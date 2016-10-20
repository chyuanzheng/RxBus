package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.bus.RxBus;

public class RxbusActivity extends Activity {
    private ImageView qrIv;
    private TextView curVesion, downloadUrlTv, changeLogTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.app_version);
    }

    public void rxTest(View view) {
       // startActivity(new Intent(this,RxbusActivity.class));
        RxBus.getDefault().post(new UserEvent (1, "yoyo"));
    }



    public static class UserEvent {
        long id;
        String name;
        public UserEvent(long id,String name) {
            this.id= id;
            this.name= name;
        }
        public long getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }

}
