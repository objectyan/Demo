package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.l;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@NotThreadSafe
public abstract class m
  extends a
{
  private final Map<String, String> a = new HashMap();
  private final Charset b;
  
  public m()
  {
    this(c.f);
  }
  
  @Deprecated
  public m(l paraml)
  {
    super(paraml);
    this.b = c.f;
  }
  
  public m(Charset paramCharset)
  {
    if (paramCharset != null) {}
    for (;;)
    {
      this.b = paramCharset;
      return;
      paramCharset = c.f;
    }
  }
  
  String a(cz.msebera.android.httpclient.u paramu)
  {
    String str = (String)paramu.getParams().a("http.auth.credential-charset");
    paramu = str;
    if (str == null) {
      paramu = k().name();
    }
    return paramu;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (String)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  protected void a(d paramd, int paramInt1, int paramInt2)
    throws p
  {
    paramd = cz.msebera.android.httpclient.k.g.b.a(paramd, new x(paramInt1, paramd.e()));
    if (paramd.length == 0) {
      throw new p("Authentication challenge is empty");
    }
    this.a.clear();
    paramInt2 = paramd.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = paramd[paramInt1];
      this.a.put(((cz.msebera.android.httpclient.g)localObject).a().toLowerCase(Locale.ENGLISH), ((cz.msebera.android.httpclient.g)localObject).b());
      paramInt1 += 1;
    }
  }
  
  public String b()
  {
    return a("realm");
  }
  
  public Charset k()
  {
    return this.b;
  }
  
  protected Map<String, String> l()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */