package com.facebook.imagepipeline.i;

public class f
  implements g
{
  public static final g a = a(Integer.MAX_VALUE, true, true);
  int b;
  boolean c;
  boolean d;
  
  private f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramInt;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public static g a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new f(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
    } while ((this.b == ((f)paramObject).b) && (this.c == ((f)paramObject).c) && (this.d == ((f)paramObject).d));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.b;
    if (this.c) {}
    for (int i = 4194304;; i = 0)
    {
      if (this.d) {
        j = 8388608;
      }
      return i ^ k ^ j;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/i/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */