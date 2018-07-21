package com.facebook.common.h;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class b<T>
{
  SoftReference<T> a = null;
  SoftReference<T> b = null;
  SoftReference<T> c = null;
  
  @Nullable
  public T a()
  {
    if (this.a == null) {
      return null;
    }
    return (T)this.a.get();
  }
  
  public void a(@Nonnull T paramT)
  {
    this.a = new SoftReference(paramT);
    this.b = new SoftReference(paramT);
    this.c = new SoftReference(paramT);
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/common/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */