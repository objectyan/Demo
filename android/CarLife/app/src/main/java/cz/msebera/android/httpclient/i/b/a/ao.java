package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Immutable
class ao
{
  private static final String a = "The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.";
  private static final String b = "partial content was returned for a request that did not ask for it";
  
  private void a(u paramu, x paramx)
    throws IOException
  {
    if ((paramu.getFirstHeader("Range") != null) || (paramx.a().b() != 206)) {
      return;
    }
    a(paramx);
    throw new cz.msebera.android.httpclient.b.f("partial content was returned for a request that did not ask for it");
  }
  
  private void a(x paramx)
    throws IOException
  {
    paramx = paramx.b();
    if (paramx != null) {
      ae.a(paramx);
    }
  }
  
  private void b(cz.msebera.android.httpclient.b.d.o paramo, x paramx)
    throws IOException
  {
    if (paramx.a().b() != 100) {}
    do
    {
      return;
      paramo = paramo.a();
    } while (((paramo instanceof cz.msebera.android.httpclient.o)) && (((cz.msebera.android.httpclient.o)paramo).expectContinue()));
    a(paramx);
    throw new cz.msebera.android.httpclient.b.f("The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.");
  }
  
  private void b(u paramu, x paramx)
  {
    if (!paramu.getRequestLine().a().equalsIgnoreCase("OPTIONS")) {}
    while ((paramx.a().b() != 200) || (paramx.getFirstHeader("Content-Length") != null)) {
      return;
    }
    paramx.addHeader("Content-Length", "0");
  }
  
  private void b(x paramx)
  {
    Object localObject = cz.msebera.android.httpclient.b.g.b.a(paramx.getFirstHeader("Date").d());
    if (localObject == null) {}
    for (;;)
    {
      return;
      cz.msebera.android.httpclient.f[] arrayOff = paramx.getHeaders("Warning");
      if ((arrayOff != null) && (arrayOff.length != 0))
      {
        ArrayList localArrayList = new ArrayList();
        int k = 0;
        int m = arrayOff.length;
        int i = 0;
        while (i < m)
        {
          at[] arrayOfat = at.a(arrayOff[i]);
          int n = arrayOfat.length;
          int j = 0;
          if (j < n)
          {
            at localat = arrayOfat[j];
            Date localDate = localat.m();
            if ((localDate == null) || (localDate.equals(localObject))) {
              localArrayList.add(new cz.msebera.android.httpclient.k.b("Warning", localat.toString()));
            }
            for (;;)
            {
              j += 1;
              break;
              k = 1;
            }
          }
          i += 1;
        }
        if (k != 0)
        {
          paramx.removeHeaders("Warning");
          localObject = localArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramx.addHeader((cz.msebera.android.httpclient.f)((Iterator)localObject).next());
          }
        }
      }
    }
  }
  
  private void c(cz.msebera.android.httpclient.b.d.o paramo, x paramx)
  {
    if (paramo.a().getProtocolVersion().b(ac.d) >= 0) {
      return;
    }
    f(paramx);
  }
  
  private void c(x paramx)
  {
    Object localObject1 = paramx.getHeaders("Content-Encoding");
    if ((localObject1 == null) || (localObject1.length == 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      int n = localObject1.length;
      int i = 0;
      while (i < n)
      {
        g[] arrayOfg = localObject1[i];
        Object localObject2 = new StringBuilder();
        int m = 1;
        arrayOfg = arrayOfg.e();
        int i1 = arrayOfg.length;
        int j = 0;
        if (j < i1)
        {
          g localg = arrayOfg[j];
          if ("identity".equalsIgnoreCase(localg.a())) {
            k = 1;
          }
          for (;;)
          {
            j += 1;
            break;
            if (m == 0) {
              ((StringBuilder)localObject2).append(",");
            }
            ((StringBuilder)localObject2).append(localg.toString());
            m = 0;
          }
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (!"".equals(localObject2)) {
          localArrayList.add(new cz.msebera.android.httpclient.k.b("Content-Encoding", (String)localObject2));
        }
        i += 1;
      }
      if (k != 0)
      {
        paramx.removeHeaders("Content-Encoding");
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramx.addHeader((cz.msebera.android.httpclient.f)((Iterator)localObject1).next());
        }
      }
    }
  }
  
  private boolean c(u paramu, x paramx)
  {
    return ("HEAD".equals(paramu.getRequestLine().a())) || (paramx.a().b() == 204) || (paramx.a().b() == 205) || (paramx.a().b() == 304);
  }
  
  private void d(x paramx)
  {
    if (paramx.getFirstHeader("Date") == null) {
      paramx.addHeader("Date", cz.msebera.android.httpclient.b.g.b.a(new Date()));
    }
  }
  
  private void e(x paramx)
  {
    int i = 0;
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "Allow";
    arrayOfString[1] = "Content-Encoding";
    arrayOfString[2] = "Content-Language";
    arrayOfString[3] = "Content-Length";
    arrayOfString[4] = "Content-MD5";
    arrayOfString[5] = "Content-Range";
    arrayOfString[6] = "Content-Type";
    arrayOfString[7] = "Last-Modified";
    if (paramx.a().b() == 304)
    {
      int j = arrayOfString.length;
      while (i < j)
      {
        paramx.removeHeaders(arrayOfString[i]);
        i += 1;
      }
    }
  }
  
  private void f(x paramx)
  {
    paramx.removeHeaders("TE");
    paramx.removeHeaders("Transfer-Encoding");
  }
  
  public void a(cz.msebera.android.httpclient.b.d.o paramo, x paramx)
    throws IOException
  {
    if (c(paramo, paramx))
    {
      a(paramx);
      paramx.a(null);
    }
    b(paramo, paramx);
    c(paramo, paramx);
    a(paramo, paramx);
    b(paramo, paramx);
    d(paramx);
    e(paramx);
    c(paramx);
    b(paramx);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */