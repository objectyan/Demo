package com.facebook.b.a;

import android.net.Uri;
import com.facebook.common.internal.k;
import java.util.List;

public class f
  implements d
{
  final List<d> a;
  
  public f(List<d> paramList)
  {
    this.a = ((List)k.a(paramList));
  }
  
  public List<d> a()
  {
    return this.a;
  }
  
  public boolean a(Uri paramUri)
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (((d)this.a.get(i)).a(paramUri)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      return this.a.equals(((f)paramObject).a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return "MultiCacheKey:" + this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */