package com.pangu.fristapp.logic;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by oyh on 15/12/22.
 */
public class HttpUtil {

    private static final String TAG = HttpUtil.class.getSimpleName();

    public static void post(final RequestType type, Object tag, Map<String, String> params, final HttpUtilInterface httpInterface) {


        OkHttpUtils.post()
                .url("")
                .params(params)
                .addParams("key1", "value1")
                .tag(tag)
                .build()
                .connTimeOut(30000)
                .readTimeOut(30000)
                .writeTimeOut(30000)
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response) throws IOException {
                        String string = response.body().string();
                        return string;
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        if(httpInterface != null) {
                            ResultObject resultObject = new ResultObject();
                            httpInterface.httpFinish(resultObject);
                        }
                    }

                    @Override
                    public void onResponse(Object response) {
                        String responseString = (String)response;
                        if(httpInterface != null) {
                            ResultObject resultObject = null;
                            try {
                                resultObject = JsonParse.parseData(responseString, type);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            httpInterface.httpFinish(resultObject);
                        }
                    }
                });
    }

    public static void cancel(Object tag) {
        OkHttpUtils.getInstance().cancelTag(tag);
    }
}
