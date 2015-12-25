package com.pangu.fristapp.logic;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by oyh on 15/12/23.
 */
public class JsonParse {

    public static ResultObject parseCommonData(String responseString) throws JSONException {
        JSONObject jsonObject = new JSONObject(responseString);
        int code = jsonObject.getInt("errorCode");
        String desc = jsonObject.getString("errorDesc");

        ResultObject resultObject = new ResultObject();
        resultObject.setErrorCode(code);
        resultObject.setErrorDesc(desc);
        return resultObject;
    }

    public static ResultObject parseData(String responseString, final RequestType type) throws JSONException {

        ResultObject resultObject = JsonParse.parseCommonData(responseString);

        Object object = null;
        if(resultObject.getErrorCode() == 0)
        {
            JSONObject jsonObject = new JSONObject(responseString);

            switch (type)
            {
                case RequestType_Login:
                {
                    object = JsonParse.parseLoginData(jsonObject.getJSONObject("data"));
                    break;
                }
                case RequestType_Regist:
                {
                    break;
                }
            }
        }

        resultObject.setData(object);
        return resultObject;
    }

    public static Object parseLoginData(JSONObject jsonObject) {

        return null;
    }

}
