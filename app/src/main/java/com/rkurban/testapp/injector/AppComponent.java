package com.rkurban.testapp.injector;

import com.rkurban.testapp.ui.BaseSecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rkurban on 22.03.2018.
 */


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BaseSecondActivity activity);

}
