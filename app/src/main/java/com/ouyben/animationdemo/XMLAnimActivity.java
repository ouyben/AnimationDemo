package com.ouyben.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class XMLAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv;
    private Button mBtnStart;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, XMLAnimActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanim);
        initView();
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
                startAnima();
                break;
        }
    }

    private void startAnima() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_textview);
        animator.setTarget(mTv);
        animator.start();
    }
}
