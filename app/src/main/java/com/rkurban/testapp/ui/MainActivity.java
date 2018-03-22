package com.rkurban.testapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rkurban.testapp.R;
import com.rkurban.testapp.network.Item;

import java.util.List;

import io.reactivex.functions.Consumer;

public class MainActivity extends BaseSecondActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == button.getId()) {
            toastTest("asd");
            api(new Consumer<List<Item>>() {
                @Override
                public void accept(List<Item> items) throws Exception {
                    String s = "";
                    for (Item item : items) {
                        s += "\n" + item.getId() + " " + item.getName();
                    }

                    toastTest(s);
                }
            });
        }
    }


    @Override
    public void initUI() {
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void toastTest(String s) {
        super.toastTest(s);
    }


    @Override
    public void api(Consumer<List<Item>> consumer) {
        super.api(consumer);
    }
}
