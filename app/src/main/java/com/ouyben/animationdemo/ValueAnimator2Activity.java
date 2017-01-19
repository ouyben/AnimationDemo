package com.ouyben.animationdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * TODO : ValueAnimator高级用法
 * Created by owen
 * on 2017-01-19.
 */
public class ValueAnimator2Activity extends AppCompatActivity implements View.OnClickListener {

    private AnimValueView mView;
    private Button mBtnStart;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ValueAnimator2Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator2);
        initView();

    }

    private void initView() {
        mView = (AnimValueView) findViewById(R.id.view);
        mBtnStart = (Button) findViewById(R.id.btn_start);

        mBtnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                mView.startAnima();
                break;
        }
    }
}
