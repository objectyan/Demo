package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.c.b;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;
import java.util.Locale;

@Immutable
public class n
  implements z
{
  public static final String a = "http.client.response.uncompressed";
  
  public void process(x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws p, IOException
  {
    paramg = paramx.b();
    int i;
    String str;
    if ((paramg != null) && (paramg.getContentLength() != 0L))
    {
      paramg = paramg.getContentEncoding();
      if (paramg != null)
      {
        paramg = paramg.e();
        i = 0;
        if (paramg.length < 0)
        {
          paramg = paramg[0];
          str = paramg.a().toLowerCase(Locale.ENGLISH);
          if ((!"gzip".equals(str)) && (!"x-gzip".equals(str))) {
            break label135;
          }
          paramx.a(new cz.msebera.android.httpclient.b.c.f(paramx.b()));
          i = 1;
        }
        if (i != 0)
        {
          paramx.removeHeaders("Content-Length");
          paramx.removeHeaders("Content-Encoding");
          paramx.removeHeaders("Content-MD5");
        }
      }
    }
    label135:
    do
    {
      return;
      if ("deflate".equals(str))
      {
        paramx.a(new b(paramx.b()));
        i = 1;
        break;
      }
    } while ("identity".equals(str));
    throw new p("Unsupported Content-Coding: " + paramg.a());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */