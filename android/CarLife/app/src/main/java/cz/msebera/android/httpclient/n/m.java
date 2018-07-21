package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;

@Immutable
public class m
{
  public static final int a = 3000;
  private final int b;
  
  public m()
  {
    this(3000);
  }
  
  public m(int paramInt)
  {
    this.b = a.a(paramInt, "Wait for continue time");
  }
  
  private static void a(j paramj)
  {
    try
    {
      paramj.close();
      return;
    }
    catch (IOException paramj) {}
  }
  
  public x a(u paramu, j paramj, g paramg)
    throws IOException, p
  {
    a.a(paramu, "HTTP request");
    a.a(paramj, "Client connection");
    a.a(paramg, "HTTP context");
    try
    {
      x localx2 = b(paramu, paramj, paramg);
      x localx1 = localx2;
      if (localx2 == null) {
        localx1 = c(paramu, paramj, paramg);
      }
      return localx1;
    }
    catch (IOException paramu)
    {
      a(paramj);
      throw paramu;
    }
    catch (p paramu)
    {
      a(paramj);
      throw paramu;
    }
    catch (RuntimeException paramu)
    {
      a(paramj);
      throw paramu;
    }
  }
  
  public void a(u paramu, k paramk, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    a.a(paramk, "HTTP processor");
    a.a(paramg, "HTTP context");
    paramg.a("http.request", paramu);
    paramk.process(paramu, paramg);
  }
  
  public void a(x paramx, k paramk, g paramg)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    a.a(paramk, "HTTP processor");
    a.a(paramg, "HTTP context");
    paramg.a("http.response", paramx);
    paramk.process(paramx, paramg);
  }
  
  protected boolean a(u paramu, x paramx)
  {
    if ("HEAD".equalsIgnoreCase(paramu.getRequestLine().a())) {}
    int i;
    do
    {
      return false;
      i = paramx.a().b();
    } while ((i < 200) || (i == 204) || (i == 304) || (i == 205));
    return true;
  }
  
  protected x b(u paramu, j paramj, g paramg)
    throws IOException, p
  {
    a.a(paramu, "HTTP request");
    a.a(paramj, "Client connection");
    a.a(paramg, "HTTP context");
    Object localObject2 = null;
    Object localObject3 = null;
    paramg.a("http.connection", paramj);
    paramg.a("http.request_sent", Boolean.FALSE);
    paramj.a(paramu);
    int j;
    Object localObject1;
    if ((paramu instanceof o))
    {
      j = 1;
      localObject2 = paramu.getRequestLine().b();
      localObject1 = localObject3;
      i = j;
      if (((o)paramu).expectContinue())
      {
        localObject1 = localObject3;
        i = j;
        if (!((ak)localObject2).d(ac.c))
        {
          paramj.h_();
          localObject1 = localObject3;
          i = j;
          if (paramj.a(this.b))
          {
            localObject1 = paramj.a();
            if (a(paramu, (x)localObject1)) {
              paramj.a((x)localObject1);
            }
            i = ((x)localObject1).a().b();
            if (i >= 200) {
              break label281;
            }
            if (i != 100) {
              throw new aj("Unexpected response: " + ((x)localObject1).a());
            }
            localObject1 = null;
          }
        }
      }
    }
    label281:
    for (int i = j;; i = 0)
    {
      localObject2 = localObject1;
      if (i != 0)
      {
        paramj.a((o)paramu);
        localObject2 = localObject1;
      }
      paramj.h_();
      paramg.a("http.request_sent", Boolean.TRUE);
      return (x)localObject2;
    }
  }
  
  protected x c(u paramu, j paramj, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    a.a(paramj, "Client connection");
    a.a(paramg, "HTTP context");
    paramg = null;
    for (int i = 0; (paramg == null) || (i < 200); i = paramg.a().b())
    {
      paramg = paramj.a();
      if (a(paramu, paramg)) {
        paramj.a(paramg);
      }
    }
    return paramg;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */