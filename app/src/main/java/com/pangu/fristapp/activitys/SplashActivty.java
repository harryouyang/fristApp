package com.pangu.fristapp.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import com.pangu.fristapp.MainActivity;
import com.pangu.fristapp.R;
import com.pangu.fristapp.logic.AesEncryptionUtil;
import com.pangu.pglogic.common.util.PGLogUtil;

/**
 * Created by oyh on 15/12/24.
 */
public class SplashActivty extends BaseActivty {

    private static final String TAG = SplashActivty.class.getSimpleName();

    boolean isFirstIn = false;

    private static final int GO_MAIN = 1000;
    private static final int GO_GUIDE = 1001;
    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 3000;

    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_MAIN:
                    goMain();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activty_splash);

        String string = AesEncryptionUtil.encrypt("中  文aes演示\n\n\r\r", "625202f9149e061d", "5efd3f6060e20330");
        PGLogUtil.d(TAG, string);

        string = AesEncryptionUtil.decrypt(string, "625202f9149e061d", "5efd3f6060e20330");
        PGLogUtil.d(TAG, string);

        init();
    }

    private void init() {
        // 读取SharedPreferences中需要的数据
        // 使用SharedPreferences来记录程序的使用次数
        SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, MODE_PRIVATE);

        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        isFirstIn = preferences.getBoolean("isFirstIn", true);

        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (!isFirstIn) {
            // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
            mHandler.sendEmptyMessageDelayed(GO_MAIN, SPLASH_DELAY_MILLIS);
        } else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
        }

    }

    private void goMain() {
        Intent intent = new Intent(SplashActivty.this, MainActivity.class);
        SplashActivty.this.startActivity(intent);
        SplashActivty.this.finish();
    }

    private void goGuide() {
        Intent intent = new Intent(SplashActivty.this, GuideActivity.class);
        SplashActivty.this.startActivity(intent);
        SplashActivty.this.finish();
    }
}
