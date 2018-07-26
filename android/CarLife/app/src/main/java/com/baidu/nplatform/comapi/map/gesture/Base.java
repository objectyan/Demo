package com.baidu.nplatform.comapi.map.gesture;

import android.view.MotionEvent;

public class Base {
    public static final Line HORIZONTAL = new Line(new Point(0.0d, 0.0d), new Point(1.0d, 0.0d));
    public static final Line VERTICAL = new Line(new Point(0.0d, 0.0d), new Point(0.0d, 1.0d));

    public static class Line {
        /* renamed from: a */
        public Point f19731a;
        /* renamed from: b */
        public Point f19732b;

        public Line(Point a, Point b) {
            this.f19731a = a;
            this.f19732b = b;
        }

        public Point center() {
            return new Point((this.f19731a.f19733x + this.f19732b.f19733x) / 2.0d, (this.f19731a.f19734y + this.f19732b.f19734y) / 2.0d);
        }

        public double length() {
            return Math.sqrt(((this.f19731a.f19733x - this.f19732b.f19733x) * (this.f19731a.f19733x - this.f19732b.f19733x)) + ((this.f19731a.f19734y - this.f19732b.f19734y) * (this.f19731a.f19734y - this.f19732b.f19734y)));
        }

        public Vector vector() {
            return new Vector(this.f19732b.f19733x - this.f19731a.f19733x, this.f19732b.f19734y - this.f19731a.f19734y);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.f19731a.toString() + " b : " + this.f19732b.toString();
        }

        public static Line make(MotionEvent event) {
            return new Line(new Point((double) event.getX(0), (double) event.getY(0)), new Point((double) event.getX(1), (double) event.getY(1)));
        }
    }

    public static class Point {
        /* renamed from: x */
        public double f19733x;
        /* renamed from: y */
        public double f19734y;

        public Point(double x, double y) {
            this.f19733x = x;
            this.f19734y = y;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f19733x + " y : " + this.f19734y;
        }
    }

    public static class Translation {
        public final Vector move;
        public final double rotate;
        public final double scale;

        public Translation(Line from, Line to) {
            this.move = new Vector(from.center(), to.center());
            double d = from.length();
            if (d > 1.0E-7d || d < -1.0E-7d) {
                this.scale = to.length() / d;
            } else {
                this.scale = 0.0d;
            }
            this.rotate = Vector.angle(from.vector(), to.vector());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.rotate + " scale : " + (this.scale * 100.0d) + " move : " + this.move.toString();
        }
    }

    public static class Vector {
        /* renamed from: x */
        public double f19735x;
        /* renamed from: y */
        public double f19736y;

        public Vector(double x, double y) {
            this.f19735x = x;
            this.f19736y = y;
        }

        public Vector(Point from, Point to) {
            this.f19735x = to.f19733x - from.f19733x;
            this.f19736y = to.f19734y - from.f19734y;
        }

        public static double angle(Vector a, Vector b) {
            return ((Math.atan2(a.f19736y, a.f19735x) - Math.atan2(b.f19736y, b.f19735x)) * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f19735x + " y : " + this.f19736y;
        }
    }
}
