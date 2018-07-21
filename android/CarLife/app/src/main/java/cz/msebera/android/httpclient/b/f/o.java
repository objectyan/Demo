package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Immutable
public class o
  implements z
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  
  private static String a(cz.msebera.android.httpclient.f.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.a());
    localStringBuilder.append("=\"");
    String str2 = paramb.b();
    if (str2 != null)
    {
      String str1 = str2;
      if (str2.length() > 100) {
        str1 = str2.substring(0, 100) + "...";
      }
      localStringBuilder.append(str1);
    }
    localStringBuilder.append("\"");
    localStringBuilder.append(", version:");
    localStringBuilder.append(Integer.toString(paramb.k()));
    localStringBuilder.append(", domain:");
    localStringBuilder.append(paramb.g());
    localStringBuilder.append(", path:");
    localStringBuilder.append(paramb.h());
    localStringBuilder.append(", expiry:");
    localStringBuilder.append(paramb.e());
    return localStringBuilder.toString();
  }
  
  private void a(i parami, cz.msebera.android.httpclient.f.h paramh, e parame, cz.msebera.android.httpclient.b.h paramh1)
  {
    while (parami.hasNext())
    {
      f localf = parami.a();
      try
      {
        Iterator localIterator = paramh.a(localf, parame).iterator();
        while (localIterator.hasNext())
        {
          cz.msebera.android.httpclient.f.b localb = (cz.msebera.android.httpclient.f.b)localIterator.next();
          try
          {
            paramh.a(localb, parame);
            paramh1.addCookie(localb);
            if (!this.a.a()) {
              continue;
            }
            this.a.a("Cookie accepted [" + a(localb) + "]");
          }
          catch (l locall2) {}
          if (this.a.c()) {
            this.a.c("Cookie rejected [" + a(localb) + "] " + locall2.getMessage());
          }
        }
        if (!this.a.c()) {
          continue;
        }
      }
      catch (l locall1) {}
      this.a.c("Invalid cookie header: \"" + localf + "\". " + locall1.getMessage());
    }
  }
  
  public void process(x paramx, g paramg)
    throws p, IOException
  {
    a.a(paramx, "HTTP request");
    a.a(paramg, "HTTP context");
    Object localObject = c.b(paramg);
    paramg = ((c)localObject).g();
    if (paramg == null) {
      this.a.a("Cookie spec not specified in HTTP context");
    }
    cz.msebera.android.httpclient.b.h localh;
    do
    {
      return;
      localh = ((c)localObject).f();
      if (localh == null)
      {
        this.a.a("Cookie store not specified in HTTP context");
        return;
      }
      localObject = ((c)localObject).h();
      if (localObject == null)
      {
        this.a.a("Cookie origin not specified in HTTP context");
        return;
      }
      a(paramx.headerIterator("Set-Cookie"), paramg, (e)localObject, localh);
    } while (paramg.a() <= 0);
    a(paramx.headerIterator("Set-Cookie2"), paramg, (e)localObject, localh);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */