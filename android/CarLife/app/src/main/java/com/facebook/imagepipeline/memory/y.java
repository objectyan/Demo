package com.facebook.imagepipeline.memory;

import java.io.Closeable;

public abstract interface y
  extends Closeable
{
  public abstract byte a(int paramInt);
  
  public abstract int a();
  
  public abstract void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract long b();
  
  public abstract boolean c();
  
  public abstract void close();
  
  public static class a
    extends RuntimeException
  {
    public a()
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */