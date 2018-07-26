package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

public class MapBound implements Serializable {
    private static final long serialVersionUID = 9060448268138558778L;
    public Point leftBottomPt = new Point();
    public Point rightTopPt = new Point();

    public MapBound(int llx, int lly, int rux, int ruy) {
        setLeftBottomPt(llx, lly);
        setRightTopPt(rux, ruy);
    }

    public void setLeftBottomPt(int x, int y) {
        this.leftBottomPt.setTo((double) x, (double) y);
    }

    public void setRightTopPt(int x, int y) {
        this.rightTopPt.setTo((double) x, (double) y);
    }

    public void setLeftBottomPt(Point leftBottomPt) {
        this.leftBottomPt.setTo(leftBottomPt);
    }

    public void setRightTopPt(Point rightTopPt) {
        this.rightTopPt.setTo(rightTopPt);
    }

    public Point getCenterPt() {
        return new Point((double) ((this.leftBottomPt.getIntX() + this.rightTopPt.getIntX()) / 2), (double) ((this.leftBottomPt.getIntY() + this.rightTopPt.getIntY()) / 2));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MapBound)) {
            return false;
        }
        MapBound mapBound = (MapBound) o;
        if (this.leftBottomPt == null ? mapBound.leftBottomPt != null : !this.leftBottomPt.equals(mapBound.leftBottomPt)) {
            return false;
        }
        if (this.rightTopPt != null) {
            if (this.rightTopPt.equals(mapBound.rightTopPt)) {
                return true;
            }
        } else if (mapBound.rightTopPt == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i = 0;
        if (this.leftBottomPt != null) {
            result = this.leftBottomPt.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.rightTopPt != null) {
            i = this.rightTopPt.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "MapBound{leftBottomPt=" + this.leftBottomPt + ", rightTopPt=" + this.rightTopPt + '}';
    }

    public String toQuery() {
        return String.format("(%d,%d;%d,%d)", new Object[]{Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY())});
    }
}
