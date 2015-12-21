package com.pangu.fristapp;

import android.os.Bundle;

import com.pangu.fristapp.activitys.BaseActivty;
import com.pangu.pglogic.common.util.PGLogUtil;
import com.pangu.pglogic.common.util.PGNetWorkUtil;

public class MainActivity extends BaseActivty {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mac = PGNetWorkUtil.getMacAddress(this);
        PGLogUtil.d("MAC",mac);
    }
}
