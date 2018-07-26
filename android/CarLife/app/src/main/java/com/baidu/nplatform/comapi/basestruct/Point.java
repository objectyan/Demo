package com.baidu.nplatform.comapi.basestruct;

import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = -5301955526770473401L;
    /* renamed from: x */
    public int f19727x;
    /* renamed from: y */
    public int f19728y;

    public Point(int x, int y) {
        this.f19727x = x;
        this.f19728y = y;
    }

    public int getmPtx() {
        return this.f19727x;
    }

    public void setmPtx(int mPtx) {
        this.f19727x = mPtx;
    }

    public int getmPty() {
        return this.f19728y;
    }

    public void setmPty(int mPty) {
        this.f19728y = mPty;
    }

    public String toString() {
        return "Point [x=" + this.f19727x + ", y=" + this.f19728y + "]";
    }

    public int hashCode() {
        return ((this.f19727x + 31) * 31) + this.f19728y;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (this.f19727x != other.f19727x) {
            return false;
        }
        if (this.f19728y != other.f19728y) {
            return false;
        }
        return true;
    }
}
