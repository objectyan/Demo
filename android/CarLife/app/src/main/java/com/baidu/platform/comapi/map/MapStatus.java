package com.baidu.platform.comapi.map;

import java.io.Serializable;

public class MapStatus implements Serializable {
    private static final long serialVersionUID = -6653836093940008535L;
    public int animationTime;
    public boolean bOverlookSpringback;
    public boolean bfpp;
    public double centerPtX;
    public double centerPtY;
    public double centerPtZ;
    public GeoBound geoRound;
    public int hasAnimation;
    public boolean isBirdEye;
    public float level;
    public int minOverlooking;
    public int overlooking;
    public String panoId;
    public float roadOffsetX;
    public float roadOffsetY;
    public int rotation;
    public int streetExt;
    public float streetIndicateAngle;
    public WinRound winRound;
    public float xOffset;
    public float yOffset;

    public static class GeoBound implements Serializable {
        private static final long serialVersionUID = -4289946562664743225L;
        public long bottom = 0;
        public long left = 0;
        public long right = 0;
        public long top = 0;

        public int hashCode() {
            return ((((((((int) (this.bottom ^ (this.bottom >>> 32))) + 31) * 31) + ((int) (this.left ^ (this.left >>> 32)))) * 31) + ((int) (this.right ^ (this.right >>> 32)))) * 31) + ((int) (this.top ^ (this.top >>> 32)));
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof GeoBound)) {
                return false;
            }
            GeoBound other = (GeoBound) obj;
            if (this.bottom != other.bottom || this.left != other.left || this.right != other.right) {
                return false;
            }
            if (this.top != other.top) {
                z = false;
            }
            return z;
        }
    }

    public static class WinRound implements Serializable {
        private static final long serialVersionUID = 8296028961543854239L;
        public int bottom = 0;
        public int left = 0;
        public int right = 0;
        public int top = 0;

        public int hashCode() {
            return ((((((this.bottom + 31) * 31) + this.left) * 31) + this.right) * 31) + this.top;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof WinRound)) {
                return false;
            }
            WinRound other = (WinRound) obj;
            if (this.bottom != other.bottom || this.left != other.left || this.right != other.right) {
                return false;
            }
            if (this.top != other.top) {
                z = false;
            }
            return z;
        }
    }

    public int hashCode() {
        int i = 0;
        double hashCode = 31.0d * ((31.0d * ((31.0d * ((31.0d * ((31.0d * ((31.0d * ((31.0d * ((31.0d * ((31.0d * 1.0d) + this.centerPtX)) + this.centerPtY)) + this.centerPtZ)) + ((double) (this.bfpp ? 1 : 0)))) + ((double) (this.geoRound == null ? 0 : this.geoRound.hashCode())))) + ((double) Float.floatToIntBits(this.level)))) + ((double) this.overlooking))) + ((double) this.rotation));
        if (this.winRound != null) {
            i = this.winRound.hashCode();
        }
        return (int) (hashCode + ((double) i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapStatus)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        MapStatus other = (MapStatus) obj;
        if (this.centerPtX != other.centerPtX || this.centerPtY != other.centerPtY || this.centerPtZ != other.centerPtZ || this.bfpp != other.bfpp) {
            return false;
        }
        if (this.geoRound == null) {
            if (other.geoRound != null) {
                return false;
            }
        } else if (!this.geoRound.equals(other.geoRound)) {
            return false;
        }
        if (Float.floatToIntBits(this.level) != Float.floatToIntBits(other.level) || this.overlooking != other.overlooking || this.rotation != other.rotation || this.yOffset != other.yOffset || this.xOffset != other.xOffset) {
            return false;
        }
        if (this.winRound == null) {
            if (other.winRound != null) {
                return false;
            }
        } else if (!this.winRound.equals(other.winRound)) {
            return false;
        }
        return true;
    }

    public MapStatus() {
        this.level = -1.0f;
        this.rotation = -1;
        this.overlooking = -1;
        this.centerPtX = -1.0d;
        this.centerPtY = -1.0d;
        this.centerPtZ = 0.0d;
        this.xOffset = 0.0f;
        this.yOffset = 0.0f;
        this.winRound = new WinRound();
        this.geoRound = new GeoBound();
        this.bfpp = false;
        this.panoId = "";
        this.streetIndicateAngle = 0.0f;
        this.isBirdEye = false;
        this.streetExt = 0;
        this.roadOffsetX = 0.0f;
        this.roadOffsetY = 0.0f;
        this.bOverlookSpringback = false;
        this.minOverlooking = -1;
    }

    public MapStatus(MapStatus other) {
        this.level = other.level;
        this.rotation = other.rotation;
        this.overlooking = other.overlooking;
        this.centerPtX = other.centerPtX;
        this.centerPtY = other.centerPtY;
        this.centerPtZ = other.centerPtZ;
        this.xOffset = other.xOffset;
        this.yOffset = other.yOffset;
        this.winRound = other.winRound;
        this.geoRound = other.geoRound;
        this.bfpp = other.bfpp;
        this.panoId = other.panoId;
        this.streetIndicateAngle = other.streetIndicateAngle;
        this.isBirdEye = other.isBirdEye;
        this.streetExt = other.streetExt;
        this.roadOffsetX = other.roadOffsetX;
        this.roadOffsetY = other.roadOffsetY;
        this.bOverlookSpringback = other.bOverlookSpringback;
        this.minOverlooking = other.minOverlooking;
    }

    public String toString() {
        return "MapStatus{level=" + this.level + ", rotation=" + this.rotation + ", overlooking=" + this.overlooking + ", centerPtX=" + this.centerPtX + ", centerPtY=" + this.centerPtY + ", centerPtZ=" + this.centerPtZ + ", winRound=" + this.winRound + ", geoRound=" + this.geoRound + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", bfpp=" + this.bfpp + ", panoId='" + this.panoId + '\'' + ", streetIndicateAngle=" + this.streetIndicateAngle + ", isBirdEye=" + this.isBirdEye + ", streetExt=" + this.streetExt + ", roadOffsetX=" + this.roadOffsetX + ", roadOffsetY=" + this.roadOffsetY + '}';
    }
}
