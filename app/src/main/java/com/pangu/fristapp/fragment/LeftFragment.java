package com.pangu.fristapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pangu.fristapp.MainActivity;
import com.pangu.fristapp.R;

/**
 * Created by oyh on 15/12/22.
 */
public class LeftFragment extends BaseFragment implements View.OnClickListener {

    private View menuView1;
    private View menuView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_menu, null);
        findViews(view);

        return view;
    }

    public void findViews(View view) {
        menuView1 = view.findViewById(R.id.leftMenu1);
        menuView2 = view.findViewById(R.id.leftMenu2);

        menuView1.setOnClickListener(this);
        menuView2.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Fragment newContent = null;
        String title = null;
        switch (v.getId()) {
            case R.id.leftMenu1:
            {
                newContent = new MainFragment();
                title = getString(R.string.leftMenuName1);
                break;
            }
            case R.id.leftMenu2:
            {
                newContent = new SettingFragment();
                title = getString(R.string.leftMenuName2);
                break;
            }
            default:
                break;
        }

        if (newContent != null) {
            switchFragment(newContent, title);
        }
    }

    private void switchFragment(Fragment fragment, String title) {
        if (getActivity() == null) {
            return;
        }
        if (getActivity() instanceof MainActivity) {
            MainActivity fca = (MainActivity) getActivity();
            fca.switchConent(fragment, title);
        }
    }
}
