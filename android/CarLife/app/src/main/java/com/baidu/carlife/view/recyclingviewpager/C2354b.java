package com.baidu.carlife.view.recyclingviewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: SpeedScroller */
/* renamed from: com.baidu.carlife.view.recyclingviewpager.b */
public class C2354b extends Scroller {
    /* renamed from: a */
    private int f7787a = 1500;

    public C2354b(Context context) {
        super(context);
    }

    public C2354b(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, this.f7787a);
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, this.f7787a);
    }

    /* renamed from: a */
    public void m8952a(int time) {
        this.f7787a = time;
    }
}
