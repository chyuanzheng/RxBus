package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myapplication.bus.RxBus;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private Subscription rxSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btntest();
            }
        });
        rxSubscription = RxBus.getDefault().toObservable(RxbusActivity.UserEvent.class)
                .subscribe(new Action1<RxbusActivity.UserEvent>() {
                               @Override
                               public void call(RxbusActivity.UserEvent userEvent) {
                                   long id = userEvent.getId();
                                   String name = userEvent.getName();
                                   LogUl.d(LogUl.RELEASE_TAG,name);
                               }
                           });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }

    private void btntest() {
        startActivity(new Intent(this,RxbusActivity.class));
    }


}
