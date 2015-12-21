package com.pangu.fristapp;

import com.pangu.pglogic.PGApplication;
import com.pangu.pglogic.PGX;
import com.pangu.pglogic.common.util.PGLogUtil;

/**
 * Created by oyh on 15/12/21.
 */
public class MyApplication extends PGApplication {

    @Override
    public void onCreate() {
        super.onCreate();

//        PGX.setLogType(PGLogUtil.NOTHING);
    }
}
