package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;

public class c
  implements h
{
  private static final String b = "CarlifeCmdMessage";
  private static int c = 0;
  byte[] a = null;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  
  public c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = c + 1;
      c = i;
      this.d = i;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > Integer.MAX_VALUE))
    {
      i.e("CarlifeCmdMessage", "set index fail: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    this.d = paramInt;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 8)
    {
      i.e("CarlifeCmdMessage", "fromByteArray fail: length not equal");
      return false;
    }
    try
    {
      d(b.d(new byte[] { paramArrayOfByte[0], paramArrayOfByte[1] }));
      b(b.d(new byte[] { paramArrayOfByte[2], paramArrayOfByte[3] }));
      c(b.b(new byte[] { paramArrayOfByte[4], paramArrayOfByte[5], paramArrayOfByte[6], paramArrayOfByte[7] }));
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      i.e("CarlifeCmdMessage", "fromByteArray fail: get exception");
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte1 = new byte[8];
    try
    {
      byte[] arrayOfByte2 = b.a(this.e);
      int j = 0 + 1;
      arrayOfByte1[0] = arrayOfByte2[2];
      int i = j + 1;
      arrayOfByte1[j] = arrayOfByte2[3];
      arrayOfByte2 = b.a(this.f);
      j = i + 1;
      arrayOfByte1[i] = arrayOfByte2[2];
      i = j + 1;
      arrayOfByte1[j] = arrayOfByte2[3];
      arrayOfByte2 = b.a(this.g);
      j = i + 1;
      arrayOfByte1[i] = arrayOfByte2[0];
      i = j + 1;
      arrayOfByte1[j] = arrayOfByte2[1];
      j = i + 1;
      arrayOfByte1[i] = arrayOfByte2[2];
      arrayOfByte1[j] = arrayOfByte2[3];
      return arrayOfByte1;
    }
    catch (Exception localException)
    {
      i.e("CarlifeCmdMessage", "toByteArray fail: get exception");
      localException.printStackTrace();
    }
    return null;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > Integer.MAX_VALUE))
    {
      i.e("CarlifeCmdMessage", "set reserved fail: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    this.f = paramInt;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > Integer.MAX_VALUE))
    {
      i.e("CarlifeCmdMessage", "set service type fail: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    this.g = paramInt;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 32768))
    {
      i.e("CarlifeCmdMessage", "set data len fail: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    this.e = paramInt;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public byte[] f()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */