package com.baidu.nplatform.comjni.tools;

import android.os.Bundle;
import java.util.ArrayList;

public class JNITools
{
  public static native Bundle BD2GCJ(double paramDouble1, double paramDouble2);
  
  public static native String CalcUrlSign(ArrayList<String> paramArrayList);
  
  public static native Bundle CoordSysChangeByType(int paramInt, double paramDouble1, double paramDouble2);
  
  public static native Bundle GCJ2BD(double paramDouble1, double paramDouble2);
  
  public static native Bundle GCJ2WGS(double paramDouble1, double paramDouble2);
  
  public static native void GetDistanceByMC(Object paramObject);
  
  public static native Bundle LL2MC(double paramDouble1, double paramDouble2);
  
  public static native Bundle MC2LL(int paramInt1, int paramInt2);
  
  public static native boolean TransGeoStr2ComplexPt(Object paramObject);
  
  public static native boolean TransGeoStr2Pt(Object paramObject);
  
  public static native void TransNodeStr2Pt(Object paramObject);
  
  public static native Bundle WGS2GCJ(double paramDouble1, double paramDouble2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comjni/tools/JNITools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */