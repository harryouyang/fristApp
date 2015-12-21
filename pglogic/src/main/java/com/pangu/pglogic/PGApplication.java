package com.pangu.pglogic;

import android.app.Application;
import android.content.Context;

/**
 * Created by oyh on 15/12/21.
 */
public class PGApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        PGX.Ext.init(this);
    }

    public static Context getContext() {
        return context;
    }
}
