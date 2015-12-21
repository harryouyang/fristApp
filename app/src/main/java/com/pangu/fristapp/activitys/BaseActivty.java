package com.pangu.fristapp.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pangu.pglogic.ActivityManager;

/**
 * Created by oyh on 15/12/21.
 */
public class BaseActivty extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}
