package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.l;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.k.r;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.u;
import java.nio.charset.Charset;
import java.security.Principal;

@NotThreadSafe
public class b
  extends m
{
  private boolean a;
  
  public b()
  {
    this(c.f);
  }
  
  @Deprecated
  public b(l paraml)
  {
    super(paraml);
  }
  
  public b(Charset paramCharset)
  {
    super(paramCharset);
    this.a = false;
  }
  
  @Deprecated
  public static cz.msebera.android.httpclient.f a(n paramn, String paramString, boolean paramBoolean)
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Credentials");
    cz.msebera.android.httpclient.o.a.a(paramString, "charset");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramn.a().getName());
    localStringBuilder.append(":");
    if (paramn.b() == null)
    {
      paramn = "null";
      localStringBuilder.append(paramn);
      paramn = cz.msebera.android.httpclient.h.a.c(cz.msebera.android.httpclient.o.f.a(localStringBuilder.toString(), paramString), 2);
      paramString = new d(32);
      if (!paramBoolean) {
        break label129;
      }
      paramString.a("Proxy-Authorization");
    }
    for (;;)
    {
      paramString.a(": Basic ");
      paramString.a(paramn, 0, paramn.length);
      return new r(paramString);
      paramn = paramn.b();
      break;
      label129:
      paramString.a("Authorization");
    }
  }
  
  @Deprecated
  public cz.msebera.android.httpclient.f a(n paramn, u paramu)
    throws j
  {
    return a(paramn, paramu, new cz.msebera.android.httpclient.n.a());
  }
  
  public cz.msebera.android.httpclient.f a(n paramn, u paramu, g paramg)
    throws j
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Credentials");
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP request");
    paramg = new StringBuilder();
    paramg.append(paramn.a().getName());
    paramg.append(":");
    if (paramn.b() == null)
    {
      paramn = "null";
      paramg.append(paramn);
      paramn = cz.msebera.android.httpclient.h.a.c(cz.msebera.android.httpclient.o.f.a(paramg.toString(), a(paramu)), 2);
      paramu = new d(32);
      if (!e()) {
        break label136;
      }
      paramu.a("Proxy-Authorization");
    }
    for (;;)
    {
      paramu.a(": Basic ");
      paramu.a(paramn, 0, paramn.length);
      return new r(paramu);
      paramn = paramn.b();
      break;
      label136:
      paramu.a("Authorization");
    }
  }
  
  public String a()
  {
    return "basic";
  }
  
  public void a(cz.msebera.android.httpclient.f paramf)
    throws p
  {
    super.a(paramf);
    this.a = true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */