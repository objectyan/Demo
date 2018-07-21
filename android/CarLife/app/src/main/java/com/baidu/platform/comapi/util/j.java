package com.baidu.platform.comapi.util;

import android.os.Process;
import com.baidu.platform.basic.b;
import java.util.concurrent.ThreadFactory;

public class j
  implements ThreadFactory
{
  private String a;
  private int b;
  
  public j(String paramString)
  {
    this(paramString, 0);
  }
  
  public j(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    new b(paramRunnable, this.a)
    {
      public void run()
      {
        Process.setThreadPriority(j.a(j.this));
        super.run();
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */