package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class m
{
  public volatile int c = -1;
  
  public static <T extends m> T a(T paramT, byte[] paramArrayOfByte, int paramInt)
    throws j
  {
    try
    {
      paramArrayOfByte = new a(paramArrayOfByte, paramInt);
      paramT.a(paramArrayOfByte);
      paramArrayOfByte.a(0);
      return paramT;
    }
    catch (j paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] a(m paramm)
  {
    byte[] arrayOfByte = new byte[paramm.c()];
    int i = arrayOfByte.length;
    try
    {
      b localb = b.a(arrayOfByte, i);
      paramm.a(localb);
      if (localb.a.remaining() != 0) {
        throw new IllegalStateException("Did not write as much data as expected.");
      }
    }
    catch (IOException paramm)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramm);
    }
    return arrayOfByte;
  }
  
  public int a()
  {
    return 0;
  }
  
  public abstract m a(a parama)
    throws IOException;
  
  public void a(b paramb)
    throws IOException
  {}
  
  public m b()
    throws CloneNotSupportedException
  {
    return (m)super.clone();
  }
  
  public final int c()
  {
    int i = a();
    this.c = i;
    return i;
  }
  
  public String toString()
  {
    return n.a(this);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */