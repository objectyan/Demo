package me.objectyan.screensharing.core.screen.presentation;

import android.view.Surface;


public class DisplaySpec {

    private int mWidth;

    private int mHeight;

    private int mDensityDpi;

    private Surface mSurface;

    private int mFlag;


    public int getWidth() {
        return this.mWidth;
    }


    public void setWidth(int width) {
        this.mWidth = width;
    }


    public int getHeight() {
        return this.mHeight;
    }


    public void setHeight(int height) {
        this.mHeight = height;
    }


    public int getDensityDpi() {
        return this.mDensityDpi;
    }


    public void setDensityDpi(int densityDpi) {
        this.mDensityDpi = densityDpi;
    }


    public Surface getSurface() {
        return this.mSurface;
    }


    public void setSurface(Surface surface) {
        this.mSurface = surface;
    }


    public int getFlag() {
        return this.mFlag;
    }


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
