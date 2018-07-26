package com.baidu.navisdk.util.common;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

public class ScreenUtil {
    public static final int DENSITY_DEFAULT = 160;
    public static final int SCREEN_SIZE_Y_LARGE = 640;
    private static ScreenUtil mInstance = null;
    private DisplayMetrics mDM;
    private int mDPI = 0;
    private float mDensity = 0.0f;
    private int mHeightPixels = 0;
    private int mStatusBarHeight = 0;
    private int mWidthPixels = 0;
    private int mWindowHeightPixels = 0;
    private int mWindowWidthPixels = 0;

    private ScreenUtil() {
    }

    public static ScreenUtil getInstance() {
        if (mInstance == null) {
            mInstance = new ScreenUtil();
        }
        return mInstance;
    }

    public void init(Activity activity) {
        if (activity != null) {
            this.mDM = activity.getResources().getDisplayMetrics();
            this.mDensity = this.mDM.density;
            this.mWidthPixels = Math.min(this.mDM.widthPixels, this.mDM.heightPixels);
            this.mHeightPixels = Math.max(this.mDM.widthPixels, this.mDM.heightPixels);
            this.mWindowWidthPixels = getWindowWidth(activity);
            this.mWindowHeightPixels = getWindowHeight(activity);
            this.mStatusBarHeight = getStatusBarHeightInner(activity);
            try {
                PackageUtil.sdkVersion = Integer.parseInt(VERSION.SDK);
            } catch (Exception e) {
            }
            if (PackageUtil.sdkVersion > 3) {
                this.mDPI = this.mDM.densityDpi;
            } else {
                this.mDPI = 160;
            }
            if (this.mDPI == 0) {
                this.mDPI = 160;
            }
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mDM;
    }

    public float getDensity() {
        return this.mDensity;
    }

    public int getDPI() {
        return this.mDPI;
    }

    public int getWidthPixels() {
        return this.mWidthPixels;
    }

    public int getHeightPixels() {
        return this.mHeightPixels;
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    @Deprecated
    public int getWindowWidthPixels() {
        return this.mWindowWidthPixels;
    }

    @Deprecated
    public int getWindowHeightPixels() {
        return this.mWindowHeightPixels;
    }

    public int dip2px(int dip) {
        return (int) (0.5f + (this.mDensity * ((float) dip)));
    }

    public int px2dip(int px) {
        return (int) (0.5f + (((float) px) / this.mDensity));
    }

    public int dip2px(float dip) {
        return (int) (0.5f + (this.mDensity * dip));
    }

    public int px2dip(float px) {
        return (int) (0.5f + (px / this.mDensity));
    }

    public int percentHeight(float percent) {
        return (int) (((float) getHeightPixels()) * percent);
    }

    public int percentWidth(float percent) {
        return (int) (((float) getWidthPixels()) * percent);
    }

    public int getGuidePanelWidth() {
        return getHeightPixels() / 4;
    }

    private int getStatusBarHeightInner(Activity activity) {
        if (activity == null) {
            return 0;
        }
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            return activity.getResources().getDimensionPixelSize(Integer.parseInt(c.getField("status_bar_height").get(c.newInstance()).toString()));
        } catch (Exception e) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        }
    }

    public int getWindowWidth(Activity activity) {
        return activity.getWindow().getDecorView().getMeasuredWidth();
    }

    public int getWindowHeight(Activity activity) {
        return activity.getWindow().getDecorView().getMeasuredHeight();
    }
}
