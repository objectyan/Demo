package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;

public class InterceptTouchRelativeLayout extends RelativeLayout {
    public InterceptTouchRelativeLayout(Context context) {
        super(context);
    }

    public InterceptTouchRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptTouchRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public InterceptTouchRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((C1342a.m4926a().m4929b() || C1343b.m4932a().m4935b()) && motionEvent.getAction() == 2 && C1328h.m4757a().getNaviFragmentManager().isDriving()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
