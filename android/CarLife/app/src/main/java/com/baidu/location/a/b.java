package com.baidu.location.a;

import android.os.Bundle;

public class b
{
  private static Object a = new Object();
  private static b b = null;
  private int c = -1;
  
  public static b a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new b();
      }
      b localb = b;
      return localb;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 != this.c)
    {
      this.c = paramInt2;
      Bundle localBundle = new Bundle();
      localBundle.putInt("loctype", paramInt1);
      localBundle.putInt("diagtype", paramInt2);
      localBundle.putByteArray("diagmessage", paramString.getBytes());
      a.a().a(localBundle, 303);
    }
  }
  
  public void b()
  {
    this.c = -1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */