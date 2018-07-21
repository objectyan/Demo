package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import java.util.Locale;

@Deprecated
@Immutable
public final class f
{
  private final String a;
  private final k b;
  private final int c;
  private final boolean d;
  private String e;
  
  public f(String paramString, int paramInt, k paramk)
  {
    a.a(paramString, "Scheme name");
    if ((paramInt > 0) && (paramInt <= 65535)) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "Port is invalid");
      a.a(paramk, "Socket factory");
      this.a = paramString.toLowerCase(Locale.ENGLISH);
      this.c = paramInt;
      if (!(paramk instanceof g)) {
        break;
      }
      this.d = true;
      this.b = paramk;
      return;
    }
    if ((paramk instanceof b))
    {
      this.d = true;
      this.b = new i((b)paramk);
      return;
    }
    this.d = false;
    this.b = paramk;
  }
  
  @Deprecated
  public f(String paramString, m paramm, int paramInt)
  {
    a.a(paramString, "Scheme name");
    a.a(paramm, "Socket factory");
    boolean bool;
    if ((paramInt > 0) && (paramInt <= 65535))
    {
      bool = true;
      a.a(bool, "Port is invalid");
      this.a = paramString.toLowerCase(Locale.ENGLISH);
      if (!(paramm instanceof c)) {
        break label88;
      }
      this.b = new h((c)paramm);
    }
    for (this.d = true;; this.d = false)
    {
      this.c = paramInt;
      return;
      bool = false;
      break;
      label88:
      this.b = new l(paramm);
    }
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.c;
    }
    return i;
  }
  
  @Deprecated
  public final m b()
  {
    if ((this.b instanceof l)) {
      return ((l)this.b).a();
    }
    if (this.d) {
      return new d((b)this.b);
    }
    return new n(this.b);
  }
  
  public final k c()
  {
    return this.b;
  }
  
  public final String d()
  {
    return this.a;
  }
  
  public final boolean e()
  {
    return this.d;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        break;
      }
      paramObject = (f)paramObject;
    } while ((this.a.equals(((f)paramObject).a)) && (this.c == ((f)paramObject).c) && (this.d == ((f)paramObject).d));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return cz.msebera.android.httpclient.o.i.a(cz.msebera.android.httpclient.o.i.a(cz.msebera.android.httpclient.o.i.a(17, this.c), this.a), this.d);
  }
  
  public final String toString()
  {
    if (this.e == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(':');
      localStringBuilder.append(Integer.toString(this.c));
      this.e = localStringBuilder.toString();
    }
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */