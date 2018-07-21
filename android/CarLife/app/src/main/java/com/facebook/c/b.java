package com.facebook.c;

public abstract class b
  implements f<Boolean>
{
  protected abstract void a(boolean paramBoolean);
  
  public void a_(d<Boolean> paramd)
  {
    try
    {
      a(((Boolean)paramd.d()).booleanValue());
      return;
    }
    finally
    {
      paramd.h();
    }
  }
  
  public void b(d<Boolean> paramd)
  {
    try
    {
      e(paramd);
      return;
    }
    finally
    {
      paramd.h();
    }
  }
  
  public void c(d<Boolean> paramd) {}
  
  public void d(d<Boolean> paramd) {}
  
  protected abstract void e(d<Boolean> paramd);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */