package com.baidu.location.indoor.mapversion;

import java.io.PrintStream;

public class IndoorJni
{
  public static boolean a = false;
  
  static
  {
    try
    {
      System.loadLibrary("indoor");
      initPf();
      a = true;
      return;
    }
    catch (Exception localException)
    {
      System.err.println("Cannot load indoor lib");
      localException.printStackTrace();
    }
  }
  
  public static native double[] getPfFr(double paramDouble1, double paramDouble2);
  
  public static native void initPf();
  
  public static native void resetPf();
  
  public static native double[] setPfWf(double paramDouble1, double paramDouble2);
  
  public static native void setRdnt(String paramString, short[][] paramArrayOfShort, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/mapversion/IndoorJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */