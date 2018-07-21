package com.facebook.imagepipeline.h;

import com.facebook.common.internal.k;
import com.facebook.imagepipeline.i.f;
import com.facebook.imagepipeline.i.g;
import java.util.Collections;
import java.util.List;

public class e
  implements c
{
  private final b a;
  
  public e()
  {
    this(new a(null));
  }
  
  public e(b paramb)
  {
    this.a = ((b)k.a(paramb));
  }
  
  public int a(int paramInt)
  {
    List localList = this.a.a();
    if ((localList == null) || (localList.isEmpty())) {
      return paramInt + 1;
    }
    int i = 0;
    while (i < localList.size())
    {
      if (((Integer)localList.get(i)).intValue() > paramInt) {
        return ((Integer)localList.get(i)).intValue();
      }
      i += 1;
    }
    return Integer.MAX_VALUE;
  }
  
  public g b(int paramInt)
  {
    if (paramInt >= this.a.b()) {}
    for (boolean bool = true;; bool = false) {
      return f.a(paramInt, bool, false);
    }
  }
  
  private static class a
    implements e.b
  {
    public List<Integer> a()
    {
      return Collections.EMPTY_LIST;
    }
    
    public int b()
    {
      return 0;
    }
  }
  
  public static abstract interface b
  {
    public abstract List<Integer> a();
    
    public abstract int b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/h/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */