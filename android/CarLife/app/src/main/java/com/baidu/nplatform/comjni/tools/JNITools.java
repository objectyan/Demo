package com.baidu.nplatform.comjni.tools;

import android.os.Bundle;
import java.util.ArrayList;

public class JNITools {
    public static native Bundle BD2GCJ(double d, double d2);

    public static native String CalcUrlSign(ArrayList<String> arrayList);

    public static native Bundle CoordSysChangeByType(int i, double d, double d2);

    public static native Bundle GCJ2BD(double d, double d2);

    public static native Bundle GCJ2WGS(double d, double d2);

    public static native void GetDistanceByMC(Object obj);

    public static native Bundle LL2MC(double d, double d2);

    public static native Bundle MC2LL(int i, int i2);

    public static native boolean TransGeoStr2ComplexPt(Object obj);

    public static native boolean TransGeoStr2Pt(Object obj);

    public static native void TransNodeStr2Pt(Object obj);

    public static native Bundle WGS2GCJ(double d, double d2);
}
