package com.github.mrmitew.skeleton.base.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.mrmitew.skeleton.di.fragment.HasFragmentSubcomponentBuilders;

public abstract class InjectableFragment extends Fragment {
    private static final String TAG = "InjectableFragment";

    public InjectableFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent();
    }

    protected void setupFragmentComponent() {
        injectMembers((HasFragmentSubcomponentBuilders) getActivity());
    }

    protected abstract void injectMembers(HasFragmentSubcomponentBuilders
                                                  hasFragmentSubcomponentBuilders);
}