package com.indooratlas.android.sdk._internal;

import java.util.Arrays;

public abstract class ji
{
  private final int a = 3;
  protected final byte b = 61;
  protected final int c = 0;
  private final int d = 4;
  private final int e;
  
  protected ji(int paramInt)
  {
    this.e = paramInt;
  }
  
  protected static byte[] a(int paramInt, a parama)
  {
    if ((parama.c == null) || (parama.c.length < parama.d + paramInt))
    {
      if (parama.c == null)
      {
        parama.c = new byte[' '];
        parama.d = 0;
        parama.e = 0;
      }
      for (;;)
      {
        return parama.c;
        byte[] arrayOfByte = new byte[parama.c.length * 2];
        System.arraycopy(parama.c, 0, arrayOfByte, 0, parama.c.length);
        parama.c = arrayOfByte;
      }
    }
    return parama.c;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, a parama);
  
  protected abstract boolean a(byte paramByte);
  
  protected final boolean b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte b1 = paramArrayOfByte[i];
        if ((61 == b1) || (a(b1))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final long c(byte[] paramArrayOfByte)
  {
    long l2 = (paramArrayOfByte.length + this.a - 1) / this.a * this.d;
    long l1 = l2;
    if (this.c > 0) {
      l1 = l2 + (this.c + l2 - 1L) / this.c * this.e;
    }
    return l1;
  }
  
  static final class a
  {
    int a;
    long b;
    byte[] c;
    int d;
    int e;
    boolean f;
    int g;
    int h;
    
    public final String toString()
    {
      return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[] { getClass().getSimpleName(), Arrays.toString(this.c), Integer.valueOf(this.g), Boolean.valueOf(this.f), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.d), Integer.valueOf(this.e) });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */