package com.baidu.navi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class HeightWrapableViewPager extends ViewPager {
    private View mCurrentView;

    public HeightWrapableViewPager(Context context) {
        super(context);
    }

    public HeightWrapableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View view = findViewWithTag(Integer.valueOf(getCurrentItem()));
        this.mCurrentView = view;
        if (view != null) {
            view.measure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(getMeasuredWidth(), measureHeight(heightMeasureSpec, view));
        }
    }

    private int measureHeight(int measureSpec, View view) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            return specSize;
        }
        if (view != null) {
            result = view.getMeasuredHeight();
        }
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }

    public View getCurrentView(int position) {
        return this.mCurrentView;
    }
}
