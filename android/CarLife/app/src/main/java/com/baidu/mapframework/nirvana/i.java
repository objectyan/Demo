package com.baidu.mapframework.nirvana;

import java.util.concurrent.ThreadFactory;

public class i
  implements ThreadFactory
{
  private String a;
  
  public i(String paramString)
  {
    this.a = ("Nirvana-ThreadFactory-" + paramString);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new h(paramRunnable, this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */