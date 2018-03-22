package com.rkurban.testapp.ui;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by rkurban on 22.03.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onStart() {
        super.onStart();
        initUI();
        daggerComponent();
    }

    public abstract void daggerComponent();

    public abstract void initUI();

}
