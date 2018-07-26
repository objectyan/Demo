package com.baidu.platform.comapi.map.gesture;

import android.view.MotionEvent;

public class Base {
    public static final Line HORIZONTAL = new Line(new Point(0.0d, 0.0d), new Point(1.0d, 0.0d));
    public static final Line VERTICAL = new Line(new Point(0.0d, 0.0d), new Point(0.0d, 1.0d));

    public static class Line {
        /* renamed from: a */
        public Point f19856a;
        /* renamed from: b */
        public Point f19857b;

        public Line(Point a, Point b) {
            this.f19856a = a;
            this.f19857b = b;
        }

        public Point center() {
            return new Point((this.f19856a.f19858x + this.f19857b.f19858x) / 2.0d, (this.f19856a.f19859y + this.f19857b.f19859y) / 2.0d);
        }

        public double length() {
            return Math.sqrt(((this.f19856a.f19858x - this.f19857b.f19858x) * (this.f19856a.f19858x - this.f19857b.f19858x)) + ((this.f19856a.f19859y - this.f19857b.f19859y) * (this.f19856a.f19859y - this.f19857b.f19859y)));
        }

        public Vector vector() {
            return new Vector(this.f19857b.f19858x - this.f19856a.f19858x, this.f19857b.f19859y - this.f19856a.f19859y);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.f19856a.toString() + " b : " + this.f19857b.toString();
        }

        public static Line make(MotionEvent event) {
            return new Line(new Point((double) event.getX(0), (double) event.getY(0)), new Point((double) event.getX(1), (double) event.getY(1)));
        }
    }

    public static class Point {
        /* renamed from: x */
        public double f19858x;
        /* renamed from: y */
        public double f19859y;

        public Point(double x, double y) {
            this.f19858x = x;
            this.f19859y = y;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f19858x + " y : " + this.f19859y;
        }
    }

    public static class Translation {
        public final Vector move;
        public final double rotate;
        public final double scale;

        public Translation(Line from, Line to) {
            this.move = new Vector(from.center(), to.center());
            double result = 0.0d;
            if (from.length() != 0.0d) {
                result = to.length() / from.length();
            }
            this.scale = result;
            this.rotate = Vector.angle(from.vector(), to.vector());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.rotate + " scale : " + (this.scale * 100.0d) + " move : " + this.move.toString();
        }
    }

    public static class Vector {
        /* renamed from: x */
        public double f19860x;
        /* renamed from: y */
        public double f19861y;

        public Vector(double x, double y) {
            this.f19860x = x;
            this.f19861y = y;
        }

        public Vector(Point from, Point to) {
            this.f19860x = to.f19858x - from.f19858x;
            this.f19861y = to.f19859y - from.f19859y;
        }

        public static double angle(Vector a, Vector b) {
            return ((Math.atan2(a.f19861y, a.f19860x) - Math.atan2(b.f19861y, b.f19860x)) * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f19860x + " y : " + this.f19861y;
        }
    }
}
