package com.baidu.carlife.logic.voice;

import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.j;

public abstract class l
  extends j
{
  public l(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  void a() {}
  
  void b() {}
  
  void c() {}
  
  public void careAbout()
  {
    addMsg(4101);
    addMsg(4100);
    addMsg(4159);
    addMsg(4103);
    addMsg(2004);
    addMsg(2009);
    addMsg(2002);
  }
  
  void d() {}
  
  void e() {}
  
  void f() {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4101: 
      d();
      return;
    case 4100: 
      f();
      return;
    case 4159: 
      e();
      return;
    case 4103: 
      c();
      return;
    case 2004: 
      a();
      return;
    case 2009: 
      b();
      return;
    }
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */