package com.github.mrmitew.skeleton.welcome.view;

import android.os.Bundle;

import com.github.mrmitew.skeleton.R;
import com.github.mrmitew.skeleton.base.view.BaseActivity;
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders;
import com.github.mrmitew.skeleton.welcome.di.WelcomeActivityComponent;

public class WelcomeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void injectMembers(final HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((WelcomeActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(WelcomeActivity.class))
                .activityModule(new WelcomeActivityComponent.WelcomeActivityModule(this))
                .build()
                .injectMembers(this);
    }
}