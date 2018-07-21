package com.baidu.tts.b.a.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.j;
import com.baidu.tts.f.l;

public class c
{
  private com.baidu.tts.m.b a;
  private j b;
  
  private boolean a(int paramInt)
  {
    return b(paramInt) >= 2;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 1;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 2;
    }
    return 3;
  }
  
  private boolean b()
  {
    Object localObject = null;
    try
    {
      j localj = this.a.c();
      localObject = localj;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (this.b == null)
    {
      if (localObject == null)
      {
        this.b = j.a;
        return true;
      }
      this.b = ((j)localObject);
      return true;
    }
    if (localObject == null) {
      return false;
    }
    if (this.b.equals(localObject)) {
      return false;
    }
    this.b = ((j)localObject);
    return true;
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void a(com.baidu.tts.m.b paramb)
  {
    this.a = paramb;
  }
  
  public boolean a()
  {
    try
    {
      Object localObject = com.baidu.tts.h.b.b.a().h();
      int i;
      int j;
      if (localObject != null)
      {
        f.b localb;
        if (b())
        {
          localb = this.a.a();
          if ((!this.b.equals(j.c)) && (!this.b.equals(j.d))) {
            break label148;
          }
          localb.c(l.b.b());
        }
        for (;;)
        {
          localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
          if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
            break;
          }
          i = ((NetworkInfo)localObject).getType();
          j = ((NetworkInfo)localObject).getSubtype();
          switch (1.a[this.b.ordinal()])
          {
          case 1: 
            label148:
            localb.c(l.c.b());
          }
        }
      }
      boolean bool;
      return false;
    }
    catch (Exception localException)
    {
      LoggerProxy.d("MixStrategy", localException.toString());
      break label220;
      if (!c(i)) {
        if (i == 9)
        {
          break label222;
          if ((!c(i)) && (i != 9))
          {
            bool = a(j);
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    label220:
    label222:
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */