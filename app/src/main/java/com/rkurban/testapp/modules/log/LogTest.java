package com.rkurban.testapp.modules.log;

import android.content.Context;
import android.util.Log;

/**
 * Created by rkurban on 22.03.2018.
 */

public class LogTest {

    private Context context;

    public LogTest(Context context) {
        this.context = context;
    }

    public void LogTest2(String s) {
        Log.d("RKRK", s);
    }

}
