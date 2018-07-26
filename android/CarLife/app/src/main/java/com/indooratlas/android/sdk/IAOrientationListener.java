package com.indooratlas.android.sdk;

public interface IAOrientationListener {
    void onHeadingChanged(long j, double d);

    void onOrientationChange(long j, double[] dArr);
}
