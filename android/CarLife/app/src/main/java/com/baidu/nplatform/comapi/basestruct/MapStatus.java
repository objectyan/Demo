package com.baidu.nplatform.comapi.basestruct;

public class MapStatus {
    public int _CenterPtX = -1;
    public int _CenterPtY = -1;
    public int _CenterPtZ = 0;
    public GeoBound _GeoRound = new GeoBound();
    public float _Level = -1.0f;
    public int _Overlooking = -1;
    public int _Rotation = -1;
    public WinRound _WinRound = new WinRound();
    public long _Xoffset = 0;
    public long _Yoffset = 0;
    public boolean _bfpp = false;
    public String _panoId = "";

    public class GeoBound {
        public long bottom = 0;
        public Point lb = new Point(0, 0);
        public long left = 0;
        public Point lt = new Point(0, 0);
        public Point rb = new Point(0, 0);
        public long right = 0;
        public Point rt = new Point(0, 0);
        public long top = 0;

        public int hashCode() {
            return ((((((((int) (this.bottom ^ (this.bottom >>> 32))) + 31) * 31) + ((int) (this.left ^ (this.left >>> 32)))) * 31) + ((int) (this.right ^ (this.right >>> 32)))) * 31) + ((int) (this.top ^ (this.top >>> 32)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof GeoBound)) {
                return false;
            }
            GeoBound other = (GeoBound) obj;
            if (this.bottom != other.bottom) {
                return false;
            }
            if (this.left != other.left) {
                return false;
            }
            if (this.right != other.right) {
                return false;
            }
            if (this.top != other.top) {
                return false;
            }
            return true;
        }
    }

    public class WinRound {
        public int bottom = 0;
        public int left = 0;
        public int right = 0;
        public int top = 0;

        public int hashCode() {
            return ((((((this.bottom + 31) * 31) + this.left) * 31) + this.right) * 31) + this.top;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof WinRound)) {
                return false;
            }
            WinRound other = (WinRound) obj;
            if (this.bottom != other.bottom) {
                return false;
            }
            if (this.left != other.left) {
                return false;
            }
            if (this.right != other.right) {
                return false;
            }
            if (this.top != other.top) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((this._CenterPtX + 31) * 31) + this._CenterPtY) * 31) + (this._bfpp ? 1 : 0)) * 31) + (this._GeoRound == null ? 0 : this._GeoRound.hashCode())) * 31) + Float.floatToIntBits(this._Level)) * 31) + this._Overlooking) * 31) + this._Rotation) * 31;
        if (this._WinRound != null) {
            i = this._WinRound.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        MapStatus other = (MapStatus) obj;
        if (this._CenterPtX != other._CenterPtX) {
            return false;
        }
        if (this._CenterPtY != other._CenterPtY) {
            return false;
        }
        if (this._bfpp != other._bfpp) {
            return false;
        }
        if (this._GeoRound == null) {
            if (other._GeoRound != null) {
                return false;
            }
        } else if (!this._GeoRound.equals(other._GeoRound)) {
            return false;
        }
        if (Float.floatToIntBits(this._Level) != Float.floatToIntBits(other._Level)) {
            return false;
        }
        if (this._Overlooking != other._Overlooking) {
            return false;
        }
        if (this._Rotation != other._Rotation) {
            return false;
        }
        if (this._Yoffset != other._Yoffset) {
            return false;
        }
        if (this._Xoffset != other._Xoffset) {
            return false;
        }
        if (this._WinRound == null) {
            if (other._WinRound != null) {
                return false;
            }
            return true;
        } else if (this._WinRound.equals(other._WinRound)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "MapStatus{level=" + this._Level + ", rotation=" + this._Rotation + ", overlooking=" + this._Overlooking + ", centerPtX=" + this._CenterPtX + ", centerPtY=" + this._CenterPtY + ", centerPtZ=" + this._CenterPtZ + ", winRound=" + this._WinRound + ", geoRound=" + this._GeoRound + ", xOffset=" + this._Xoffset + ", yOffset=" + this._Yoffset + ", bfpp=" + this._bfpp + ", panoId='" + this._panoId + '}';
    }
}
