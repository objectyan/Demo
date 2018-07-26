package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

public class OverlayLocationData {
    private Bitmap bitmap;
    private int imgHeight;
    private String imgName;
    private int imgWidth;
    private int rotation;

    public String getImgName() {
        return this.imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Bitmap getImage() {
        return this.bitmap;
    }

    public void setImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public int isRotation() {
        return this.rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}
