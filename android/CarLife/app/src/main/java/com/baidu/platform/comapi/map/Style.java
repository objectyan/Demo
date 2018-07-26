package com.baidu.platform.comapi.map;

public class Style {
    public static final int TYPE_LINE = 2;
    public static final int TYPE_MASK = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_POINT = 1;
    public static final int TYPE_POLYGON = 3;
    private int color;
    private int fillColor;
    private int textureId;
    private int width;

    public Style setColor(int colorVal) {
        this.color = colorVal;
        return this;
    }

    public Style setWidth(int width) {
        this.width = width;
        return this;
    }

    public Style setFillColor(int fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public Style setTextureId(int textureId) {
        this.textureId = textureId;
        return this;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public int getColor() {
        return this.color;
    }

    public int getWidth() {
        return this.width;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public String toString() {
        return "Style: color:" + Integer.toHexString(this.color) + " width:" + this.width + " fillcolor:" + Integer.toHexString(this.fillColor);
    }

    static int transColorVal(int color) {
        return (((-16777216 & color) | ((color & 255) << 16)) | (65280 & color)) | ((16711680 & color) >> 16);
    }
}
