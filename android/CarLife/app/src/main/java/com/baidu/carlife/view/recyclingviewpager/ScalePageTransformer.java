package com.baidu.carlife.view.recyclingviewpager;

import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.baidu.carlife.C0965R;

public class ScalePageTransformer implements PageTransformer {
    /* renamed from: a */
    public static final float f7777a = 1.6f;
    /* renamed from: b */
    public static final float f7778b = 1.0f;
    /* renamed from: c */
    private static final float f7779c = 0.0f;
    /* renamed from: d */
    private static final float f7780d = 0.4f;
    /* renamed from: e */
    private static final float f7781e = 0.7f;

    public void transformPage(View page, float position) {
        View view = page.findViewById(C0965R.id.radio_channel_item_cover);
        if (position < -3.0f) {
            position = -3.0f;
        } else if (position > 3.0f) {
            position = 3.0f;
        }
        float scaleValue = 1.0f + ((3.0f - Math.abs(position)) * 0.2f);
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
        if (position < -1.0f || position > 1.0f) {
            view.setAlpha(f7781e + ((3.0f - Math.abs(position)) * -0.29999998f));
        } else {
            view.setAlpha(f7780d + ((1.0f - Math.abs(position)) * -0.4f));
        }
        if (VERSION.SDK_INT < 19) {
            page.getParent().requestLayout();
        }
    }

    /* renamed from: a */
    public void m8944a(View page, float position) {
        View view = page.findViewById(C0965R.id.radio_channel_item_cover);
        if (position < -2.0f) {
            position = -2.0f;
        } else if (position > 2.0f) {
            position = 2.0f;
        }
        float scaleValue = 1.0f + ((2.0f - Math.abs(position)) * 0.3f);
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
        if (position < -1.0f || position > 1.0f) {
            view.setAlpha(f7781e + ((2.0f - Math.abs(position)) * -0.29999998f));
        } else {
            view.setAlpha(f7780d + ((1.0f - Math.abs(position)) * -0.4f));
        }
        if (VERSION.SDK_INT < 19) {
            page.getParent().requestLayout();
        }
    }
}
