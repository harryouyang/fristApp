package com.pangu.fristapp.logic;

/**
 * Created by oyh on 15/12/23.
 */
public class ResultObject {
    private int errorCode;
    private Object data;
    private String errorDesc;

    ResultObject() {
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
