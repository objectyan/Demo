package com.indooratlas.android.sdk._internal;

import java.nio.charset.Charset;

public final class jh
  extends ji
{
  static final byte[] a = { 13, 10 };
  private static final byte[] d = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] e = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] f = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private final byte[] g;
  private final byte[] h;
  private final byte[] i;
  private final int j;
  private final int k;
  
  public jh()
  {
    this((byte)0);
  }
  
  private jh(byte paramByte)
  {
    this(a);
  }
  
  private jh(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, (byte)0);
  }
  
  private jh(byte[] paramArrayOfByte, byte paramByte) {}
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 0) {
        break label18;
      }
      arrayOfByte = paramArrayOfByte;
    }
    label18:
    ji.a locala;
    int n;
    do
    {
      jh localjh;
      do
      {
        do
        {
          return arrayOfByte;
          localjh = new jh(a, (byte)0);
          long l = localjh.c(paramArrayOfByte);
          if (l > 2147483647L) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of 2147483647");
          }
          arrayOfByte = paramArrayOfByte;
        } while (paramArrayOfByte == null);
        arrayOfByte = paramArrayOfByte;
      } while (paramArrayOfByte.length == 0);
      locala = new ji.a();
      localjh.a(paramArrayOfByte, 0, paramArrayOfByte.length, locala);
      localjh.a(paramArrayOfByte, 0, -1, locala);
      paramArrayOfByte = new byte[locala.d - locala.e];
      n = paramArrayOfByte.length;
      arrayOfByte = paramArrayOfByte;
    } while (locala.c == null);
    if (locala.c != null) {}
    for (int m = locala.d - locala.e;; m = 0)
    {
      m = Math.min(m, n);
      System.arraycopy(locala.c, locala.e, paramArrayOfByte, 0, m);
      locala.e = (m + locala.e);
      arrayOfByte = paramArrayOfByte;
      if (locala.e < locala.d) {
        break;
      }
      locala.c = null;
      return paramArrayOfByte;
    }
  }
  
  final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ji.a parama)
  {
    if (parama.f) {}
    for (;;)
    {
      return;
      if (paramInt2 < 0)
      {
        parama.f = true;
        if ((parama.h != 0) || (this.c != 0))
        {
          paramArrayOfByte = a(this.k, parama);
          paramInt1 = parama.d;
          switch (parama.h)
          {
          default: 
            throw new IllegalStateException("Impossible modulus " + parama.h);
          case 1: 
            paramInt2 = parama.d;
            parama.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(parama.a >> 2 & 0x3F)];
            paramInt2 = parama.d;
            parama.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(parama.a << 4 & 0x3F)];
            if (this.g == d)
            {
              paramInt2 = parama.d;
              parama.d = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = 61;
              paramInt2 = parama.d;
              parama.d = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = 61;
            }
            break;
          }
          for (;;)
          {
            paramInt2 = parama.g;
            parama.g = (parama.d - paramInt1 + paramInt2);
            if ((this.c <= 0) || (parama.g <= 0)) {
              break;
            }
            System.arraycopy(this.i, 0, paramArrayOfByte, parama.d, this.i.length);
            parama.d += this.i.length;
            return;
            paramInt2 = parama.d;
            parama.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(parama.a >> 10 & 0x3F)];
            paramInt2 = parama.d;
            parama.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(parama.a >> 4 & 0x3F)];
            paramInt2 = parama.d;
            parama.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(parama.a << 2 & 0x3F)];
            if (this.g == d)
            {
              paramInt2 = parama.d;
              parama.d = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = 61;
            }
          }
        }
      }
      else
      {
        int m = 0;
        while (m < paramInt2)
        {
          byte[] arrayOfByte = a(this.k, parama);
          parama.h = ((parama.h + 1) % 3);
          int i1 = paramArrayOfByte[paramInt1];
          int n = i1;
          if (i1 < 0) {
            n = i1 + 256;
          }
          parama.a = (n + (parama.a << 8));
          if (parama.h == 0)
          {
            n = parama.d;
            parama.d = (n + 1);
            arrayOfByte[n] = this.g[(parama.a >> 18 & 0x3F)];
            n = parama.d;
            parama.d = (n + 1);
            arrayOfByte[n] = this.g[(parama.a >> 12 & 0x3F)];
            n = parama.d;
            parama.d = (n + 1);
            arrayOfByte[n] = this.g[(parama.a >> 6 & 0x3F)];
            n = parama.d;
            parama.d = (n + 1);
            arrayOfByte[n] = this.g[(parama.a & 0x3F)];
            parama.g += 4;
            if ((this.c > 0) && (this.c <= parama.g))
            {
              System.arraycopy(this.i, 0, arrayOfByte, parama.d, this.i.length);
              parama.d += this.i.length;
              parama.g = 0;
            }
          }
          m += 1;
          paramInt1 += 1;
        }
      }
    }
  }
  
  protected final boolean a(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte < this.h.length) && (this.h[paramByte] != -1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */