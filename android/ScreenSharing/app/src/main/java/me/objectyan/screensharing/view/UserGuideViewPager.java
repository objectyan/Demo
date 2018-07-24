package com.baidu.carlife.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UserGuideViewPager extends ViewPager {
    /* renamed from: a */
    private boolean f7303a;

    public UserGuideViewPager(Context context) {
        super(context);
    }

    public UserGuideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollOperationFlag(boolean flag) {
        this.f7303a = flag;
    }

    public boolean onTouchEvent(MotionEvent arg0) {
        if (this.f7303a) {
            return super.onTouchEvent(arg0);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (this.f7303a) {
            return super.onInterceptTouchEvent(arg0);
        }
        return false;
    }
}
