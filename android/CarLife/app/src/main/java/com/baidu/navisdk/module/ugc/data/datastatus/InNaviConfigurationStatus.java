package com.baidu.navisdk.module.ugc.data.datastatus;

import android.graphics.Bitmap;

public class InNaviConfigurationStatus {
    private String contentDescri = null;
    private int detailInfoIndex = -1;
    private boolean hasRecorde = false;
    private Bitmap photoBitmap = null;
    private int positionInfoIndex = -1;
    private int positionLineIndex = -1;

    public int getPositionInfoIndex() {
        return this.positionInfoIndex;
    }

    public void setPositionInfoIndex(int positionInfoIndex) {
        this.positionInfoIndex = positionInfoIndex;
    }

    public int getPositionLineIndex() {
        return this.positionLineIndex;
    }

    public void setPositionLineIndex(int positionLineIndex) {
        this.positionLineIndex = positionLineIndex;
    }

    public int getDetailInfoIndex() {
        return this.detailInfoIndex;
    }

    public void setDetailInfoIndex(int detailInfoIndex) {
        this.detailInfoIndex = detailInfoIndex;
    }

    public String getContentDescri() {
        return this.contentDescri;
    }

    public void setContentDescri(String contentDescri) {
        this.contentDescri = contentDescri;
    }

    public boolean isHasRecorde() {
        return this.hasRecorde;
    }

    public void setHasRecorde(boolean hasRecorde) {
        this.hasRecorde = hasRecorde;
    }

    public Bitmap getPhotoBitmap() {
        return this.photoBitmap;
    }

    public void setPhotoBitmap(Bitmap photoBitmap) {
        this.photoBitmap = photoBitmap;
    }
}
