package com.rkurban.testapp.modules.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by rkurban on 22.03.2018.
 */

public class ToastTest {

    private Context context;

    public ToastTest(Context context) {
        this.context = context;
    }

    public void ToastTest2(String s) {
        Toast.makeText(context, "ToastTest: " + s, Toast.LENGTH_SHORT).show();
    }

}
