package com.pangu.pglogic;

import android.app.Application;

import com.pangu.pglogic.common.util.PGLogUtil;

/**
 * Created by oyh on 15/12/21.
 */
public final class PGX {

    private PGX() {
    }

    public static void setLogType(int type) {
        PGLogUtil.LEVEL = type;
    }

    public static Application app() {
        if(Ext.app == null) {
            throw new RuntimeException("please invoke x.Ext.init(app) on Application#onCreate()");
        }
        return Ext.app;
    }

    public static class Ext {
        private static Application app;

        private Ext() {}

        public static void init(Application app) {
            if(Ext.app == null) {
                Ext.app = app;
            }
        }
    }
}
