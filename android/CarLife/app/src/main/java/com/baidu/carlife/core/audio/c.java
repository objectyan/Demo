package com.baidu.carlife.core.audio;

public class c
{
  private static final int a = 20480;
  private byte[] b = new byte['倀'];
  
  public void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, p paramp)
  {
    if (this.b.length < paramInt1 + paramInt2) {
      this.b = new byte[paramInt1 + paramInt2];
    }
    System.arraycopy(paramArrayOfByte1, 0, this.b, 0, paramInt1);
    System.arraycopy(paramArrayOfByte2, 0, this.b, paramInt1, paramInt2);
    paramp.a(this.b);
    paramp.a(paramInt1 + paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */