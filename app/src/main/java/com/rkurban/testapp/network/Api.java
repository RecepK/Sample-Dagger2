package com.rkurban.testapp.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by rkurban on 22.03.2018.
 */

public interface Api {

    @GET("/bins/1bhpgb")
    Observable<List<Item>> getItemList();

}
