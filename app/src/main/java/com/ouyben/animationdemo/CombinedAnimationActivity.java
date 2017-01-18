package com.ouyben.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * TODO : 组合动画改变 textview属性
 * Created by owen
 * on 2017-01-18.
 */
public class CombinedAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv;
    private Button mBtnStart;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, CombinedAnimationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined_animation);
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
                startAnimator();
                break;
        }
    }

    private void startAnimator() {
        // 修改字体大小
        ObjectAnimator animatorForTextsize = ObjectAnimator.ofFloat(mTv, "TextSize", 18.0f, 8.0f, 18.0f);
        // 修改字体暗度
        ObjectAnimator animatorForAlpha = ObjectAnimator.ofFloat(mTv, "alpha", 1.0f, 0.5f, 1.0f);
        // 修改垂直位移
        float y = mTv.getTranslationY();
        Log.d("Animator", "startAnimator: " + y);
        ObjectAnimator animatorForTranslationY = ObjectAnimator.ofFloat(mTv, "translationY", y, 600.0f, y);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.play(animatorForTextsize).with(animatorForAlpha).with(animatorForTranslationY);
        animatorSet.start();

    }
}
