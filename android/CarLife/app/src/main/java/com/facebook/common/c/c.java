package com.facebook.common.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class c
  extends b
  implements g
{
  public c(Executor paramExecutor)
  {
    super("SerialExecutor", 1, paramExecutor, new LinkedBlockingQueue());
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      super.execute(paramRunnable);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */