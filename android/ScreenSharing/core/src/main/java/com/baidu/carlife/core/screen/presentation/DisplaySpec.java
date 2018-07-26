package com.baidu.carlife.core.screen.presentation;

import android.view.Surface;

/* compiled from: DisplaySpec */
/* renamed from: com.baidu.carlife.core.screen.presentation.i */
public class DisplaySpec {
    /* renamed from: a */
    private int mWidth;
    /* renamed from: b */
    private int mHeight;
    /* renamed from: c */
    private int mDensityDpi;
    /* renamed from: d */
    private Surface mSurface;
    /* renamed from: e */
    private int mFlag;

    /* renamed from: a */
    public int getWidth() {
        return this.mWidth;
    }

    /* renamed from: a */
    public void setWidth(int width) {
        this.mWidth = width;
    }

    /* renamed from: b */
    public int getHeight() {
        return this.mHeight;
    }

    /* renamed from: b */
    public void setHeight(int height) {
        this.mHeight = height;
    }

    /* renamed from: c */
    public int getDensityDpi() {
        return this.mDensityDpi;
    }

    /* renamed from: c */
    public void setDensityDpi(int densityDpi) {
        this.mDensityDpi = densityDpi;
    }

    /* renamed from: d */
    public Surface getSurface() {
        return this.mSurface;
    }

    /* renamed from: a */
    public void setSurface(Surface surface) {
        this.mSurface = surface;
    }

    /* renamed from: e */
    public int getFlag() {
        return this.mFlag;
    }

    /* renamed from: d */
    public void setFlag(int flag) {
        this.mFlag = flag;
    }

    public DisplaySpec(int width, int height, int densityDpi, Surface surface, int flag) {
        this.mWidth = width;
        this.mHeight = height;
        this.mDensityDpi = densityDpi;
        this.mSurface = surface;
        this.mFlag = flag;
    }

    public String toString() {
        return "DisplaySpec{width=" + this.mWidth + ", height=" + this.mHeight + ", densityDpi=" + this.mDensityDpi + ", surface=" + this.mSurface + ", flag=" + this.mFlag + '}';
    }
}
