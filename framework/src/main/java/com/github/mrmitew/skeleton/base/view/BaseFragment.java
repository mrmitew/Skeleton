package com.github.mrmitew.skeleton.base.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import butterknife.Unbinder;
import icepick.Icepick;

public abstract class BaseFragment extends InjectableFragment {
    private static final String TAG = "BaseFragment";
    protected Unbinder mUnbinder;

    public BaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Log.d(TAG, msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}