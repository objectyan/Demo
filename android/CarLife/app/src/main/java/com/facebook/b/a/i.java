package com.facebook.b.a;

import android.net.Uri;
import com.facebook.common.internal.k;

public class i
  implements d
{
  final String a;
  
  public i(String paramString)
  {
    this.a = ((String)k.a(paramString));
  }
  
  public boolean a(Uri paramUri)
  {
    return this.a.contains(paramUri.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      return this.a.equals(((i)paramObject).a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */