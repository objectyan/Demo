package com.baidu.android.pushservice.i;

import android.text.TextUtils;

public abstract class c
  implements Runnable
{
  private String a;
  private short b = 99;
  
  public c() {}
  
  public c(String paramString, short paramShort)
  {
    this.a = paramString;
    this.b = paramShort;
  }
  
  public abstract void a();
  
  public void a(short paramShort)
  {
    this.b = paramShort;
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public short d()
  {
    return this.b;
  }
  
  public final void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      Thread.currentThread().setName(this.a);
    }
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */