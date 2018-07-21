package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;

@NotThreadSafe
public class c
  implements g, Cloneable
{
  private final String a;
  private final String b;
  private final ag[] c;
  
  public c(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public c(String paramString1, String paramString2, ag[] paramArrayOfag)
  {
    this.a = ((String)a.a(paramString1, "Name"));
    this.b = paramString2;
    if (paramArrayOfag != null)
    {
      this.c = paramArrayOfag;
      return;
    }
    this.c = new ag[0];
  }
  
  public ag a(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public ag a(String paramString)
  {
    a.a(paramString, "Name");
    Object localObject2 = null;
    ag[] arrayOfag = this.c;
    int j = arrayOfag.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfag[i];
        if (!((ag)localObject1).a().equalsIgnoreCase(paramString)) {}
      }
      else
      {
        return (ag)localObject1;
      }
      i += 1;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public ag[] c()
  {
    return (ag[])this.c.clone();
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public int d()
  {
    return this.c.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof g)) {
        break;
      }
      paramObject = (c)paramObject;
    } while ((this.a.equals(((c)paramObject).a)) && (i.a(this.b, ((c)paramObject).b)) && (i.a(this.c, ((c)paramObject).c)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    int j = i.a(i.a(17, this.a), this.b);
    ag[] arrayOfag = this.c;
    int k = arrayOfag.length;
    int i = 0;
    while (i < k)
    {
      j = i.a(j, arrayOfag[i]);
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    if (this.b != null)
    {
      localStringBuilder.append("=");
      localStringBuilder.append(this.b);
    }
    ag[] arrayOfag = this.c;
    int j = arrayOfag.length;
    int i = 0;
    while (i < j)
    {
      ag localag = arrayOfag[i];
      localStringBuilder.append("; ");
      localStringBuilder.append(localag);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */