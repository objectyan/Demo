package com.facebook.imagepipeline.e;

import com.facebook.common.internal.k;
import com.facebook.common.m.b;
import java.util.Locale;

public class d
{
  public final int a;
  public final int b;
  
  public d(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt2 <= 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      this.a = paramInt1;
      this.b = paramInt2;
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((this.a == ((d)paramObject).a) && (this.b == ((d)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    return b.a(this.a, this.b);
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%dx%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */