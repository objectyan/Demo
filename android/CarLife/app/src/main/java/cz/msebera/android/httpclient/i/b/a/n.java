package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.d.c;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.j;
import cz.msebera.android.httpclient.x;
import java.util.Date;

@Immutable
class n
{
  private final l a;
  
  n()
  {
    this(new l());
  }
  
  n(l paraml)
  {
    this.a = paraml;
  }
  
  private void a(x paramx, cz.msebera.android.httpclient.n paramn)
  {
    if (a(paramx)) {}
    while (paramx.getFirstHeader("Content-Length") != null) {
      return;
    }
    paramx.setHeader(new cz.msebera.android.httpclient.k.b("Content-Length", Long.toString(paramn.getContentLength())));
  }
  
  private boolean a(x paramx)
  {
    return paramx.getFirstHeader("Transfer-Encoding") != null;
  }
  
  c a(d paramd)
  {
    Date localDate = new Date();
    j localj = new j(ac.d, paramd.d(), paramd.c());
    localj.setHeaders(paramd.g());
    if (paramd.i() != null)
    {
      g localg = new g(paramd);
      a(localj, localg);
      localj.a(localg);
    }
    long l = this.a.a(paramd, localDate);
    if (l > 0L)
    {
      if (l < 2147483647L) {
        break label116;
      }
      localj.setHeader("Age", "2147483648");
    }
    for (;;)
    {
      return aj.a(localj);
      label116:
      localj.setHeader("Age", "" + (int)l);
    }
  }
  
  c b(d paramd)
  {
    j localj = new j(ac.d, 304, "Not Modified");
    f localf = paramd.a("Date");
    Object localObject = localf;
    if (localf == null) {
      localObject = new cz.msebera.android.httpclient.k.b("Date", cz.msebera.android.httpclient.b.g.b.a(new Date()));
    }
    localj.addHeader((f)localObject);
    localObject = paramd.a("ETag");
    if (localObject != null) {
      localj.addHeader((f)localObject);
    }
    localObject = paramd.a("Content-Location");
    if (localObject != null) {
      localj.addHeader((f)localObject);
    }
    localObject = paramd.a("Expires");
    if (localObject != null) {
      localj.addHeader((f)localObject);
    }
    localObject = paramd.a("Cache-Control");
    if (localObject != null) {
      localj.addHeader((f)localObject);
    }
    paramd = paramd.a("Vary");
    if (paramd != null) {
      localj.addHeader(paramd);
    }
    return aj.a(localj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */