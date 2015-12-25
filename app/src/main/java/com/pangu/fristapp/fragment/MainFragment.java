package com.pangu.fristapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pangu.fristapp.R;
import com.pangu.fristapp.logic.HttpUtil;
import com.pangu.fristapp.logic.HttpUtilInterface;
import com.pangu.fristapp.logic.RequestType;
import com.pangu.fristapp.logic.ResultObject;

/**
 * Created by oyh on 15/12/22.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.testButton);
        imageView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        HttpUtil.post(RequestType.RequestType_Login, this, null, new HttpUtilInterface() {
            @Override
            public void httpFinish(ResultObject resultObject) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        HttpUtil.cancel(this);
    }

}
