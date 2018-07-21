package com.facebook.imagepipeline.f;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a
  implements e
{
  private static final int a = 2;
  private static final int b = 1;
  private final Executor c;
  private final Executor d;
  private final Executor e;
  private final Executor f;
  
  public a(int paramInt)
  {
    k localk = new k(10);
    this.c = Executors.newFixedThreadPool(2);
    this.d = Executors.newFixedThreadPool(paramInt, localk);
    this.e = Executors.newFixedThreadPool(paramInt, localk);
    this.f = Executors.newFixedThreadPool(1, localk);
  }
  
  public Executor a()
  {
    return this.c;
  }
  
  public Executor b()
  {
    return this.c;
  }
  
  public Executor c()
  {
    return this.d;
  }
  
  public Executor d()
  {
    return this.e;
  }
  
  public Executor e()
  {
    return this.f;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */