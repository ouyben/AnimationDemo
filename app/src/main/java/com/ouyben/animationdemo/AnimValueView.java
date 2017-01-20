package com.ouyben.animationdemo;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * TODO :
 * Created by owen
 * on 2017-01-19.
 */

public class AnimValueView extends View {

    private float radius = 30.0f;
    private Point mCurrentPoint;
    private Paint mPaint;
    private float height, width;

    public AnimValueView(Context context) {
        this(context, null);
    }

    public AnimValueView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimValueView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (height == 0.0f) {
            height = getHeight();
            width = getWidth();
        }
        if (mCurrentPoint == null) {
            mCurrentPoint = new Point(radius, radius);
            canvas.drawCircle(mCurrentPoint.getX(), mCurrentPoint.getY(), radius, mPaint);
        } else {
            canvas.drawCircle(mCurrentPoint.getX(), mCurrentPoint.getY(), radius, mPaint);
        }

    }

    public void startAnima() {
        Point start = mCurrentPoint;
        float x, y;
        if (isLeft()) {
            x = width - radius;
        } else {
            x = radius;
        }
        y = (float) (radius + Math.random() * (height - radius * 2 + 1));
        Log.d("Anima", "x: " + x + ",y: " + y);
        Point end = new Point(x, y);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurrentPoint = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startAnima();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.setDuration(500);
        animator.start();

    }

    private boolean isLeft() {
        return mCurrentPoint.getX() == radius;
    }
}
