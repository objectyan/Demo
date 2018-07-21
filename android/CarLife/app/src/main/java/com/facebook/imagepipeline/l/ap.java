package com.facebook.imagepipeline.l;

import com.facebook.common.c.h;
import java.util.Map;

public abstract class ap<T>
  extends h<T>
{
  private final j<T> g;
  private final al h;
  private final String i;
  private final String j;
  
  public ap(j<T> paramj, al paramal, String paramString1, String paramString2)
  {
    this.g = paramj;
    this.h = paramal;
    this.i = paramString1;
    this.j = paramString2;
    this.h.a(this.j, this.i);
  }
  
  protected void a(Exception paramException)
  {
    al localal = this.h;
    String str1 = this.j;
    String str2 = this.i;
    if (this.h.b(this.j)) {}
    for (Map localMap = b(paramException);; localMap = null)
    {
      localal.a(str1, str2, paramException, localMap);
      this.g.b(paramException);
      return;
    }
  }
  
  protected void a(T paramT)
  {
    al localal = this.h;
    String str1 = this.j;
    String str2 = this.i;
    if (this.h.b(this.j)) {}
    for (Map localMap = c(paramT);; localMap = null)
    {
      localal.a(str1, str2, localMap);
      this.g.b(paramT, true);
      return;
    }
  }
  
  protected Map<String, String> b(Exception paramException)
  {
    return null;
  }
  
  protected void b()
  {
    al localal = this.h;
    String str1 = this.j;
    String str2 = this.i;
    if (this.h.b(this.j)) {}
    for (Map localMap = e();; localMap = null)
    {
      localal.b(str1, str2, localMap);
      this.g.b();
      return;
    }
  }
  
  protected abstract void b(T paramT);
  
  protected Map<String, String> c(T paramT)
  {
    return null;
  }
  
  protected Map<String, String> e()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */