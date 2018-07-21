package com.baidu.carlife.l;

import android.content.Context;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.audio.g;

public class e
{
  private static final String a = "Audio-" + e.class.getSimpleName();
  private static e b;
  private g c = new g();
  private Context d = a.a().getApplicationContext();
  
  public static e a()
  {
    if (b == null) {
      b = new e();
    }
    return b;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a(paramArrayOfByte);
  }
  
  public boolean a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public byte[] b()
  {
    return this.c.a();
  }
  
  public void c()
  {
    this.c.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/l/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */