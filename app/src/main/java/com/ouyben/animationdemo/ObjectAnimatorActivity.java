package com.ouyben.animationdemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private Button mButton;


    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ObjectAnimatorActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        initView();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startAnimator();
                break;
        }
    }

    private void startAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "TextSize", 28.0f, 14.0f, 28.0f);
        animator.setDuration(5000);
        animator.start();

    }
}
