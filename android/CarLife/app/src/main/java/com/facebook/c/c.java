package com.facebook.c;

public abstract class c<T>
  implements f<T>
{
  protected abstract void a(d<T> paramd);
  
  public void a_(d<T> paramd)
  {
    boolean bool = paramd.b();
    try
    {
      e(paramd);
      return;
    }
    finally
    {
      if (bool) {
        paramd.h();
      }
    }
  }
  
  public void b(d<T> paramd)
  {
    try
    {
      a(paramd);
      return;
    }
    finally
    {
      paramd.h();
    }
  }
  
  public void c(d<T> paramd) {}
  
  public void d(d<T> paramd) {}
  
  protected abstract void e(d<T> paramd);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */