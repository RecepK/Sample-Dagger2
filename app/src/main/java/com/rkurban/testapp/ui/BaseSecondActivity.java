package com.rkurban.testapp.ui;

import com.rkurban.testapp.App;
import com.rkurban.testapp.modules.toast.ToastTest;
import com.rkurban.testapp.network.Api;
import com.rkurban.testapp.network.Item;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rkurban on 22.03.2018.
 */

public abstract class BaseSecondActivity extends BaseActivity {

    @Inject
    ToastTest toastTest;

    @Inject
    Api api;


    @Override
    public void daggerComponent() {
        ((App) getApplication()).getComponent().inject(this);
    }

    public void toastTest(String s) {
        toastTest.ToastTest2("BaseSecondActivity: " + s);
    }

    public void api(Consumer<List<Item>> consumer) {
        api.getItemList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(consumer);
    }
}
