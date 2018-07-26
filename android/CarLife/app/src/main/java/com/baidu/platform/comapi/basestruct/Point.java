package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = -5301955526770473401L;
    /* renamed from: x */
    private double f19789x;
    /* renamed from: y */
    private double f19790y;

    public Point(double x, double y) {
        this.f19789x = x;
        this.f19790y = y;
    }

    public Point(Point other) {
        if (other != null) {
            this.f19789x = other.getDoubleX();
            this.f19790y = other.getDoubleY();
        }
    }

    public int getIntX() {
        return (int) this.f19789x;
    }

    public void setIntX(int x) {
        this.f19789x = (double) x;
    }

    public int getIntY() {
        return (int) this.f19790y;
    }

    public void setIntY(int y) {
        this.f19790y = (double) y;
    }

    public double getDoubleX() {
        return this.f19789x;
    }

    public void setDoubleX(double x) {
        this.f19789x = x;
    }

    public double getDoubleY() {
        return this.f19790y;
    }

    public void setDoubleY(double y) {
        this.f19790y = y;
    }

    public void setTo(double x, double y) {
        setDoubleX(x);
        setDoubleY(y);
    }

    public void setTo(Point point) {
        if (point != null) {
            setDoubleX(point.getDoubleX());
            setDoubleY(point.getDoubleY());
        }
    }

    public String toString() {
        return "Point [x=" + getDoubleX() + ", y=" + getDoubleY() + "]";
    }

    public int hashCode() {
        return ((getIntX() + 31) * 31) + getIntY();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (getDoubleX() != other.getDoubleX()) {
            return false;
        }
        if (getDoubleY() != other.getDoubleY()) {
            z = false;
        }
        return z;
    }

    public String toQuery() {
        return String.format("(%d,%d)", new Object[]{Integer.valueOf(getIntX()), Integer.valueOf(getIntY())});
    }
}
