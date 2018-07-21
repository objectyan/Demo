package com.baidu.android.pushservice.message;

import android.content.Context;
import java.io.IOException;
import java.util.LinkedList;

public abstract class d
{
  protected Context a;
  private LinkedList<e> b = new LinkedList();
  
  public d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public abstract e a(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public LinkedList<e> a()
  {
    return this.b;
  }
  
  public abstract void a(int paramInt);
  
  public void a(e parame)
  {
    try
    {
      synchronized (this.b)
      {
        this.b.add(parame);
        this.b.notify();
        return;
      }
    }
    catch (Exception parame)
    {
      for (;;) {}
    }
  }
  
  public abstract void b();
  
  public abstract void b(e parame)
    throws Exception;
  
  public abstract void c();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */