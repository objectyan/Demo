package com.baidu.carlife.core.connect;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;
import java.util.ArrayList;

public class f
  implements h
{
  private static final String a = "ConnectServiceProxy";
  private static final String b = "ConnectServiceProxyHandler";
  private ArrayList<Messenger> c = new ArrayList();
  private Context d;
  private Handler e;
  
  public f(Context paramContext)
  {
    this.d = paramContext;
    paramContext = new HandlerThread("ConnectServiceProxyHandler");
    paramContext.start();
    this.e = new a(paramContext.getLooper());
  }
  
  public Handler a()
  {
    return this.e;
  }
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null)
      {
        i.e("ConnectServiceProxy", "handleMessage error: msg is null");
        return;
      }
      switch (paramMessage.what)
      {
      case 903: 
      default: 
        if (paramMessage.arg1 == 1001)
        {
          i.b("ConnectServiceProxy", "Send Msg to Socket, what = 0x" + j.a(paramMessage.what, 8));
          if ((paramMessage.what == 65538) || (e.a().g())) {
            e.a().a((c)paramMessage.obj);
          }
        }
        super.handleMessage(paramMessage);
        return;
      case 901: 
        f.a(f.this).add(paramMessage.replyTo);
        return;
      }
      f.a(f.this).remove(paramMessage.replyTo);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */