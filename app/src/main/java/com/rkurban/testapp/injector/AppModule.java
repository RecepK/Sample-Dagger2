package com.rkurban.testapp.injector;

import android.content.Context;

import com.rkurban.testapp.network.Api;
import com.rkurban.testapp.modules.log.LogTest;
import com.rkurban.testapp.modules.toast.ToastTest;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by rkurban on 22.03.2018.
 */


@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return this.context;
    }


    @Provides
    @Singleton
    LogTest provideLogTest(Context context) {
        return new LogTest(context);
    }

    @Provides
    @Singleton
    ToastTest provideToastTest(Context context) {
        return new ToastTest(context);
    }

    @Provides
    OkHttpClient.Builder provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);
    }

    @Provides
    Api provideApi(OkHttpClient.Builder okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.myjson.com")
                //.client(okHttpClient.addInterceptor(interceptor).build())
                .build();
        return retrofit.create(Api.class);
    }

}
