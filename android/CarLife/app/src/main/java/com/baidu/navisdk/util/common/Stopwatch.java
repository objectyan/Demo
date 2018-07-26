package com.baidu.navisdk.util.common;

import android.os.SystemClock;

public class Stopwatch {
    private static long end;
    private static long start;
    private long mEnd;
    private long mStart = SystemClock.elapsedRealtime();

    public static void reset() {
        start = 0;
        end = 0;
    }

    public static void setStart() {
        start = System.nanoTime();
    }

    public static void setEnd() {
        end = System.nanoTime();
    }

    public static long getDuration() {
        return (end - start) / 1000000;
    }

    public static long getNanoSecDuration() {
        return end - start;
    }

    public void start() {
        this.mStart = SystemClock.elapsedRealtime();
        LogUtil.m15791e("Stopwatch", "stat test start time = " + this.mStart);
    }

    public void stop() {
        this.mEnd = SystemClock.elapsedRealtime();
        LogUtil.m15791e("Stopwatch", "stat test stop time = " + this.mEnd);
    }

    public long ElapsedTicks() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return (SystemClock.elapsedRealtime() - this.mStart) + " ms";
    }
}
