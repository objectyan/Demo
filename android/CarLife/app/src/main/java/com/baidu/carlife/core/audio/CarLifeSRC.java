package com.baidu.carlife.core.audio;

import android.util.Log;

public class CarLifeSRC
{
  private static final String a = CarLifeSRC.class.getSimpleName();
  private static final int b = 5120;
  private short[] c = new short['᐀'];
  private int d = 10240;
  private short[] e = new short[this.d];
  
  static
  {
    try
    {
      System.loadLibrary("CarLifeSRC");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      Log.d(a, "could not load library!");
    }
  }
  
  private native String hello();
  
  private native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native int resample(short[] paramArrayOfShort1, int paramInt, short[] paramArrayOfShort2);
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return init(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    a.a().a(paramArrayOfByte1, paramInt1, paramInt2, this.c);
    paramInt1 = resample(this.c, paramInt1 / 2, this.e);
    a.a().a(this.e, paramInt1, paramArrayOfByte2);
    return paramInt1 * 2;
  }
  
  public int a(short[] paramArrayOfShort1, int paramInt, short[] paramArrayOfShort2)
  {
    return resample(paramArrayOfShort1, paramInt, paramArrayOfShort2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/CarLifeSRC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */