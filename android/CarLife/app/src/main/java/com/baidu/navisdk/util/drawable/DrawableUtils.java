package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;

public class DrawableUtils {
    public static Drawable getDrawableFromView(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        Drawable drawable = new BitmapDrawable(null, Bitmap.createBitmap(view.getDrawingCache(true)));
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        return drawable;
    }
}
