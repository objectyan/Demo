package com.baidu.navi.view.draglistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.baidu.carlife.C0965R;

public class NaviScrollView extends ScrollView {
    private ImageView mDragImage;

    public NaviScrollView(Context context) {
        super(context);
    }

    public NaviScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NaviScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int viewRawX = (int) ev.getRawX();
        this.mDragImage = (ImageView) findViewById(C0965R.id.iv_drag);
        int[] location = new int[2];
        this.mDragImage.getLocationOnScreen(location);
        if (viewRawX <= location[0] - 20 || viewRawX >= (location[0] + this.mDragImage.getWidth()) + 20) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
}
