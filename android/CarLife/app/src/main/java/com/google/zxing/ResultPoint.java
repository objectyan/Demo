package com.google.zxing;

public class ResultPoint {
    /* renamed from: x */
    private final float f22859x;
    /* renamed from: y */
    private final float f22860y;

    public ResultPoint(float x, float y) {
        this.f22859x = x;
        this.f22860y = y;
    }

    public final float getX() {
        return this.f22859x;
    }

    public final float getY() {
        return this.f22860y;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ResultPoint)) {
            return false;
        }
        ResultPoint otherPoint = (ResultPoint) other;
        if (this.f22859x == otherPoint.f22859x && this.f22860y == otherPoint.f22860y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f22859x) * 31) + Float.floatToIntBits(this.f22860y);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(25);
        result.append('(');
        result.append(this.f22859x);
        result.append(',');
        result.append(this.f22860y);
        result.append(')');
        return result.toString();
    }

    public static void orderBestPatterns(ResultPoint[] patterns) {
        ResultPoint pointB;
        ResultPoint pointA;
        ResultPoint pointC;
        float zeroOneDistance = distance(patterns[0], patterns[1]);
        float oneTwoDistance = distance(patterns[1], patterns[2]);
        float zeroTwoDistance = distance(patterns[0], patterns[2]);
        if (oneTwoDistance >= zeroOneDistance && oneTwoDistance >= zeroTwoDistance) {
            pointB = patterns[0];
            pointA = patterns[1];
            pointC = patterns[2];
        } else if (zeroTwoDistance < oneTwoDistance || zeroTwoDistance < zeroOneDistance) {
            pointB = patterns[2];
            pointA = patterns[0];
            pointC = patterns[1];
        } else {
            pointB = patterns[1];
            pointA = patterns[0];
            pointC = patterns[2];
        }
        if (crossProductZ(pointA, pointB, pointC) < 0.0f) {
            ResultPoint temp = pointA;
            pointA = pointC;
            pointC = temp;
        }
        patterns[0] = pointA;
        patterns[1] = pointB;
        patterns[2] = pointC;
    }

    public static float distance(ResultPoint pattern1, ResultPoint pattern2) {
        float xDiff = pattern1.f22859x - pattern2.f22859x;
        float yDiff = pattern1.f22860y - pattern2.f22860y;
        return (float) Math.sqrt((double) ((xDiff * xDiff) + (yDiff * yDiff)));
    }

    private static float crossProductZ(ResultPoint pointA, ResultPoint pointB, ResultPoint pointC) {
        float bX = pointB.f22859x;
        float bY = pointB.f22860y;
        return ((pointC.f22859x - bX) * (pointA.f22860y - bY)) - ((pointC.f22860y - bY) * (pointA.f22859x - bX));
    }
}
