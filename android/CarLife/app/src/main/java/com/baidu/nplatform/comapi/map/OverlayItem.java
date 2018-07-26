package com.baidu.nplatform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class OverlayItem {
    public static final int ALIGN_BOTTON = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALING_CENTER = 1;
    private float anchorX;
    private float anchorY;
    private Bundle animate;
    private int bound;
    private ArrayList<Bundle> clickRect;
    private String id;
    private int level;
    private CoordType mCoordType = CoordType.CoordType_BD09;
    private Drawable mMarker;
    protected GeoPoint mPoint;
    protected String mSnippet;
    protected String mTitle;
    private int mask;

    public enum CoordType {
        CoordType_BD09LL,
        CoordType_BD09
    }

    public OverlayItem(GeoPoint point, String title, String snippet) {
        this.mPoint = point;
        this.mTitle = title;
        this.mSnippet = snippet;
        this.mMarker = null;
        this.bound = 2;
        this.id = "";
        this.anchorX = 0.5f;
        this.anchorY = 1.0f;
        this.clickRect = new ArrayList();
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMask() {
        return this.mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public final Drawable getMarker() {
        return this.mMarker;
    }

    public GeoPoint getPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public void setSnippet(String snippet) {
        this.mSnippet = snippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setMarker(Drawable marker) {
        this.mMarker = marker;
    }

    void setBound(int i) {
        this.bound = i;
    }

    int getBound() {
        return this.bound;
    }

    void setId(String id) {
        this.id = id;
    }

    int getResId() {
        if (getMarker() == null) {
            return -1;
        }
        return getMarker().hashCode();
    }

    String getId() {
        return this.id;
    }

    public void setGeoPoint(GeoPoint p) {
        this.mPoint = p;
    }

    public CoordType getCoordType() {
        return this.mCoordType;
    }

    public void setCoordType(CoordType type) {
        this.mCoordType = type;
    }

    public void setAnchor(float anchorX, float anchorY) {
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }

    public void setAnchor(int ALIGN_TYPE) {
        switch (ALIGN_TYPE) {
            case 1:
                setAnchor(0.5f, 0.5f);
                return;
            case 2:
                setAnchor(0.5f, 1.0f);
                return;
            case 3:
                setAnchor(0.5f, 0.0f);
                return;
            default:
                return;
        }
    }

    public float getAnchorX() {
        return this.anchorX;
    }

    public float getAnchorY() {
        return this.anchorY;
    }

    public void setClickRect(ArrayList<Bundle> clickRect) {
        this.clickRect = clickRect;
    }

    public void addClickRect(Bundle clickRectBundle) {
        if (this.clickRect == null) {
            this.clickRect = new ArrayList();
        }
        this.clickRect.add(clickRectBundle);
    }

    public ArrayList<Bundle> getClickRect() {
        return this.clickRect;
    }

    public Bundle getAnimate() {
        return this.animate;
    }

    public void setAnimate(Bundle animate) {
        this.animate = animate;
    }
}
