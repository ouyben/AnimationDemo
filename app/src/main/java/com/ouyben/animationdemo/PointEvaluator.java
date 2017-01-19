package com.ouyben.animationdemo;

import android.animation.TypeEvaluator;

/**
 * TODO :
 * Created by owen
 * on 2017-01-19.
 */

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float v, Object start, Object end) {
        Point startPoint = (Point) start;
        Point endPoint = (Point) end;
        float x = startPoint.getX() + v * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + v * (endPoint.getY() - startPoint.getY());
        return new Point(x, y);
    }
}
