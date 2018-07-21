package com.baidu.carlife.n;

public class a
{
  private static final int a = 8;
  private byte[] b = new byte[8];
  
  public int a()
  {
    return 8;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public int c()
  {
    return (this.b[0] & 0xFF) << 8 & 0xFF00 | this.b[1] & 0xFF & 0xFF;
  }
  
  public a d()
  {
    switch ((this.b[4] & 0xFF) << 24 & 0xFF000000 | (this.b[5] & 0xFF) << 16 & 0xFF0000 | (this.b[6] & 0xFF) << 8 & 0xFF00 | this.b[7] & 0xFF & 0xFF)
    {
    default: 
      throw new IllegalStateException("unsupport message type");
    case 458759: 
      return a.a;
    case 458760: 
      return a.b;
    }
    return a.c;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */