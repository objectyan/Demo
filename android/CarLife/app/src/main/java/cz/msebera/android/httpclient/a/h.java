package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import cz.msebera.android.httpclient.r;
import java.util.Locale;

@Immutable
public class h
{
  public static final String a = null;
  public static final int b = -1;
  public static final String c = null;
  public static final String d = null;
  public static final h e = new h(a, -1, c, d);
  private final String f;
  private final String g;
  private final String h;
  private final int i;
  
  public h(h paramh)
  {
    a.a(paramh, "Scope");
    this.h = paramh.a();
    this.i = paramh.b();
    this.g = paramh.c();
    this.f = paramh.d();
  }
  
  public h(r paramr)
  {
    this(paramr, c, d);
  }
  
  public h(r paramr, String paramString1, String paramString2)
  {
    this(paramr.a(), paramr.b(), paramString1, paramString2);
  }
  
  public h(String paramString, int paramInt)
  {
    this(paramString, paramInt, c, d);
  }
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    this(paramString1, paramInt, paramString2, d);
  }
  
  public h(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      paramString1 = a;
      this.h = paramString1;
      int j = paramInt;
      if (paramInt < 0) {
        j = -1;
      }
      this.i = j;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = c;
      }
      this.g = paramString1;
      if (paramString3 != null) {
        break label74;
      }
    }
    label74:
    for (paramString1 = d;; paramString1 = paramString3.toUpperCase(Locale.ENGLISH))
    {
      this.f = paramString1;
      return;
      paramString1 = paramString1.toLowerCase(Locale.ENGLISH);
      break;
    }
  }
  
  public int a(h paramh)
  {
    int k = 0;
    int j;
    if (i.a(this.f, paramh.f))
    {
      j = 0 + 1;
      if (!i.a(this.g, paramh.g)) {
        break label100;
      }
      k = j + 2;
      label38:
      if (this.i != paramh.i) {
        break label126;
      }
      j = k + 4;
      label53:
      if (!i.a(this.h, paramh.h)) {
        break label148;
      }
      k = j + 8;
    }
    label100:
    label126:
    label148:
    do
    {
      do
      {
        return k;
        j = k;
        if (this.f == d) {
          break;
        }
        j = k;
        if (paramh.f == d) {
          break;
        }
        return -1;
        k = j;
        if (this.g == c) {
          break label38;
        }
        k = j;
        if (paramh.g == c) {
          break label38;
        }
        return -1;
        j = k;
        if (this.i == -1) {
          break label53;
        }
        j = k;
        if (paramh.i == -1) {
          break label53;
        }
        return -1;
        k = j;
      } while (this.h == a);
      k = j;
    } while (paramh.h == a);
    return -1;
  }
  
  public String a()
  {
    return this.h;
  }
  
  public int b()
  {
    return this.i;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      if (!(paramObject instanceof h)) {
        return super.equals(paramObject);
      }
      paramObject = (h)paramObject;
      if ((!i.a(this.h, ((h)paramObject).h)) || (this.i != ((h)paramObject).i) || (!i.a(this.g, ((h)paramObject).g))) {
        break;
      }
      bool1 = bool2;
    } while (i.a(this.f, ((h)paramObject).f));
    return false;
  }
  
  public int hashCode()
  {
    return i.a(i.a(i.a(i.a(17, this.h), this.i), this.g), this.f);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.f != null)
    {
      localStringBuilder.append(this.f.toUpperCase(Locale.ENGLISH));
      localStringBuilder.append(' ');
    }
    if (this.g != null)
    {
      localStringBuilder.append('\'');
      localStringBuilder.append(this.g);
      localStringBuilder.append('\'');
    }
    for (;;)
    {
      if (this.h != null)
      {
        localStringBuilder.append('@');
        localStringBuilder.append(this.h);
        if (this.i >= 0)
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.i);
        }
      }
      return localStringBuilder.toString();
      localStringBuilder.append("<any realm>");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */