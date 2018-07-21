package com.baidu.platform.comapi;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;
import com.baidu.vi.VMsg;

class b
{
  static boolean a = false;
  private NAEngine b;
  
  public boolean a()
  {
    if (a) {
      return true;
    }
    a = true;
    return true;
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2 = false;
    a = false;
    VMsg.init();
    this.b = new NAEngine();
    boolean bool1 = bool2;
    if (NAEngine.initEngine(paramContext, null))
    {
      bool1 = bool2;
      if (NAEngine.initLongLinkClient()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    a = false;
    return true;
  }
  
  public Bundle c()
  {
    Bundle localBundle = new Bundle();
    NAEngine.getFlaxLength(localBundle);
    return localBundle;
  }
  
  public void d()
  {
    if (a) {
      b();
    }
    VMsg.destroy();
    MessageProxy.destroy();
    NAEngine.unInitEngine();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */