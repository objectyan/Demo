package com.baidu.mapframework.common.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c
  extends Handler
{
  private a a;
  
  public c(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private a b()
  {
    h localh2 = j.a;
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h().a(a.a.b);
    }
    if (this.a == null) {
      this.a = g.a(localh1);
    }
    for (;;)
    {
      return this.a;
      if (!this.a.b().equals(localh1.a()))
      {
        this.a.a();
        this.a = g.a(localh1);
      }
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof i)))
    {
      paramMessage = (i)paramMessage.obj;
      a locala = b();
      if (locala != null) {
        locala.a(paramMessage);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */