package com.ouyben.animationdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv;
    private Button mBtnStart;


    private Context mContext;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ValueAnimatorActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        initView();
        initData();
    }

    private void initData() {
        mContext = this;
        startAnimatior();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mBtnStart = (Button) findViewById(R.id.btn_start);

        mBtnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startAnimatior();
                break;
        }
    }

    private void startAnimatior() {
        ValueAnimator animator = ValueAnimator.ofFloat(28.0f, 14.0f, 28.0f);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f = (float) valueAnimator.getAnimatedValue();
                mTv.setTextSize(f);
            }
        });
        animator.start();
    }
}
