package com.baidu.platform.comapi.util;

import android.os.Process;
import com.baidu.platform.basic.b;
import java.util.concurrent.ThreadFactory;

public class h
  implements ThreadFactory
{
  private final boolean a;
  private String b;
  
  public h(String paramString)
  {
    this(paramString, false);
  }
  
  public h(String paramString, boolean paramBoolean)
  {
    this.b = paramString;
    this.a = paramBoolean;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    new b(paramRunnable, this.b)
    {
      public void run()
      {
        if (h.a(h.this)) {
          Process.setThreadPriority(19);
        }
        super.run();
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */