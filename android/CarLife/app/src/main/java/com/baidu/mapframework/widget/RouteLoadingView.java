package com.baidu.mapframework.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;

public class RouteLoadingView extends ImageView {
    /* renamed from: a */
    private AnimationDrawable f19348a;

    public RouteLoadingView(Context context) {
        super(context, null);
        startAni();
    }

    public RouteLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs, -1);
        startAni();
    }

    public RouteLoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        startAni();
    }

    public void startAni() {
        setImageResource(C0965R.drawable.route_loading_view);
        this.f19348a = (AnimationDrawable) getDrawable();
        this.f19348a.start();
    }
}
