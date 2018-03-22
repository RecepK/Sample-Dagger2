package com.rkurban.testapp;

import android.app.Application;

import com.rkurban.testapp.injector.AppComponent;
import com.rkurban.testapp.injector.AppModule;
import com.rkurban.testapp.injector.DaggerAppComponent;


/**
 * Created by rkurban on 22.03.2018.
 */

public class App extends Application {

    private AppComponent mDaggerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaggerComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getComponent() {
        return mDaggerComponent;
    }
}