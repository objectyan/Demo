package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.o.k;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;

@Immutable
public final class g
  implements Serializable
{
  public static final g a = a("application/atom+xml", c.g);
  public static final g b = a("application/x-www-form-urlencoded", c.g);
  public static final g c = a("application/json", c.e);
  public static final g d = a("application/octet-stream", (Charset)null);
  public static final g e = a("application/svg+xml", c.g);
  public static final g f = a("application/xhtml+xml", c.g);
  public static final g g = a("application/xml", c.g);
  public static final g h = a("multipart/form-data", c.g);
  public static final g i = a("text/html", c.g);
  public static final g j = a("text/plain", c.g);
  public static final g k = a("text/xml", c.g);
  public static final g l = a("*/*", (Charset)null);
  public static final g m = j;
  public static final g n = d;
  private static final long o = -7768694718232371896L;
  private final String p;
  private final Charset q;
  private final ag[] r;
  
  g(String paramString, Charset paramCharset)
  {
    this.p = paramString;
    this.q = paramCharset;
    this.r = null;
  }
  
  g(String paramString, ag[] paramArrayOfag)
    throws UnsupportedCharsetException
  {
    this.p = paramString;
    this.r = paramArrayOfag;
    paramString = a("charset");
    if (!k.b(paramString)) {}
    for (paramString = Charset.forName(paramString);; paramString = null)
    {
      this.q = paramString;
      return;
    }
  }
  
  private static g a(cz.msebera.android.httpclient.g paramg)
  {
    String str = paramg.a();
    paramg = paramg.c();
    if ((paramg != null) && (paramg.length > 0)) {}
    for (;;)
    {
      return new g(str, paramg);
      paramg = null;
    }
  }
  
  public static g a(n paramn)
    throws ai, UnsupportedCharsetException
  {
    if (paramn == null) {}
    do
    {
      do
      {
        return null;
        paramn = paramn.getContentType();
      } while (paramn == null);
      paramn = paramn.e();
    } while (paramn.length <= 0);
    return a(paramn[0]);
  }
  
  public static g a(String paramString1, String paramString2)
    throws UnsupportedCharsetException
  {
    if (!k.b(paramString2)) {}
    for (paramString2 = Charset.forName(paramString2);; paramString2 = null) {
      return a(paramString1, paramString2);
    }
  }
  
  public static g a(String paramString, Charset paramCharset)
  {
    paramString = ((String)a.b(paramString, "MIME type")).toLowerCase(Locale.ENGLISH);
    a.a(e(paramString), "MIME type may not contain reserved characters");
    return new g(paramString, paramCharset);
  }
  
  public static g b(n paramn)
    throws ai, UnsupportedCharsetException
  {
    paramn = a(paramn);
    if (paramn != null) {
      return paramn;
    }
    return m;
  }
  
  public static g b(String paramString)
  {
    return new g(paramString, (Charset)null);
  }
  
  public static g c(String paramString)
    throws ai, UnsupportedCharsetException
  {
    a.a(paramString, "Content type");
    Object localObject = new d(paramString.length());
    ((d)localObject).a(paramString);
    x localx = new x(0, paramString.length());
    localObject = cz.msebera.android.httpclient.k.g.b.a((d)localObject, localx);
    if (localObject.length > 0) {
      return a(localObject[0]);
    }
    throw new ai("Invalid content type: " + paramString);
  }
  
  private static boolean e(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if ((i2 == 34) || (i2 == 44) || (i2 == 59)) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public g a(Charset paramCharset)
  {
    return a(a(), paramCharset);
  }
  
  public String a()
  {
    return this.p;
  }
  
  public String a(String paramString)
  {
    a.a(paramString, "Parameter name");
    if (this.r == null) {}
    for (;;)
    {
      return null;
      ag[] arrayOfag = this.r;
      int i2 = arrayOfag.length;
      int i1 = 0;
      while (i1 < i2)
      {
        ag localag = arrayOfag[i1];
        if (localag.a().equalsIgnoreCase(paramString)) {
          return localag.b();
        }
        i1 += 1;
      }
    }
  }
  
  public Charset b()
  {
    return this.q;
  }
  
  public g d(String paramString)
  {
    return a(a(), paramString);
  }
  
  public String toString()
  {
    d locald = new d(64);
    locald.a(this.p);
    if (this.r != null)
    {
      locald.a("; ");
      cz.msebera.android.httpclient.k.f.b.a(locald, this.r, false);
    }
    for (;;)
    {
      return locald.toString();
      if (this.q != null)
      {
        locald.a("; charset=");
        locald.a(this.q.name());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */