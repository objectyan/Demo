package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class s
{
  public static final int[] a = new int[0];
  public static final long[] b = new long[0];
  public static final float[] c = new float[0];
  public static final double[] d = new double[0];
  public static final boolean[] e = new boolean[0];
  public static final String[] f = new String[0];
  public static final byte[][] g = new byte[0][];
  public static final byte[] h = new byte[0];
  
  static int a(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static final int a(a parama, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = parama.k();
    parama.b(paramInt);
    while (parama.a() == paramInt)
    {
      parama.b(paramInt);
      i += 1;
    }
    parama.e(j);
    return i;
  }
  
  public static int b(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */