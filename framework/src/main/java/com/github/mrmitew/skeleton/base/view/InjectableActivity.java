package com.github.mrmitew.skeleton.base.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mrmitew.skeleton.AndroidApplication;
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders;

public abstract class InjectableActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupActivityComponent();
        super.onCreate(savedInstanceState);
    }

    protected void setupActivityComponent() {
        injectMembers(AndroidApplication.get(this));
    }

    protected abstract void injectMembers(HasActivitySubcomponentBuilders
                                                  hasActivitySubcomponentBuilders);
}