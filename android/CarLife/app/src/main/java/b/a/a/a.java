package b.a.a;

import b.a.d.e;
import b.a.d.h;
import b.ab;
import b.ad;
import b.ad.a;
import b.ae;
import b.t;
import b.t.a;
import b.v;
import b.v.a;
import b.z;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class a
  implements v
{
  final f a;
  
  public a(f paramf)
  {
    this.a = paramf;
  }
  
  private b a(ad paramad, ab paramab, f paramf)
    throws IOException
  {
    if (paramf == null) {}
    do
    {
      return null;
      if (c.a(paramad, paramab)) {
        break;
      }
    } while (!b.a.d.f.a(paramab.b()));
    try
    {
      paramf.b(paramab);
      return null;
    }
    catch (IOException paramad)
    {
      return null;
    }
    return paramf.a(paramad);
  }
  
  private ad a(final b paramb, ad paramad)
    throws IOException
  {
    if (paramb == null) {}
    Sink localSink;
    do
    {
      return paramad;
      localSink = paramb.b();
    } while (localSink == null);
    paramb = new Source()
    {
      boolean a;
      
      public void close()
        throws IOException
      {
        if ((!this.a) && (!b.a.c.a(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.a = true;
          paramb.a();
        }
        this.b.close();
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        try
        {
          paramAnonymousLong = this.b.read(paramAnonymousBuffer, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.a)
            {
              this.a = true;
              this.d.close();
            }
            return -1L;
          }
        }
        catch (IOException paramAnonymousBuffer)
        {
          if (!this.a)
          {
            this.a = true;
            paramb.a();
          }
          throw paramAnonymousBuffer;
        }
        paramAnonymousBuffer.copyTo(this.d.buffer(), paramAnonymousBuffer.size() - paramAnonymousLong, paramAnonymousLong);
        this.d.emitCompleteSegments();
        return paramAnonymousLong;
      }
      
      public Timeout timeout()
      {
        return this.b.timeout();
      }
    };
    return paramad.i().a(new h(paramad.g(), Okio.buffer(paramb))).a();
  }
  
  private static ad a(ad paramad)
  {
    ad localad = paramad;
    if (paramad != null)
    {
      localad = paramad;
      if (paramad.h() != null) {
        localad = paramad.i().a(null).a();
      }
    }
    return localad;
  }
  
  private static t a(t paramt1, t paramt2)
  {
    t.a locala = new t.a();
    int i = 0;
    int j = paramt1.a();
    if (i < j)
    {
      String str1 = paramt1.a(i);
      String str2 = paramt1.b(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!a(str1)) || (paramt2.a(str1) == null)) {
          b.a.a.a.a(locala, str1, str2);
        }
      }
    }
    i = 0;
    j = paramt2.a();
    if (i < j)
    {
      paramt1 = paramt2.a(i);
      if ("Content-Length".equalsIgnoreCase(paramt1)) {}
      for (;;)
      {
        i += 1;
        break;
        if (a(paramt1)) {
          b.a.a.a.a(locala, paramt1, paramt2.b(i));
        }
      }
    }
    return locala.a();
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  public ad a(v.a parama)
    throws IOException
  {
    ad localad1;
    Object localObject;
    ab localab;
    ad localad2;
    if (this.a != null)
    {
      localad1 = this.a.a(parama.a());
      localObject = new c.a(System.currentTimeMillis(), parama.a(), localad1).a();
      localab = ((c)localObject).a;
      localad2 = ((c)localObject).b;
      if (this.a != null) {
        this.a.a((c)localObject);
      }
      if ((localad1 != null) && (localad2 == null)) {
        b.a.c.a(localad1.h());
      }
      if ((localab != null) || (localad2 != null)) {
        break label162;
      }
      parama = new ad.a().a(parama.a()).a(z.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(b.a.c.c).a(-1L).b(System.currentTimeMillis()).a();
    }
    label162:
    label332:
    do
    {
      return parama;
      localad1 = null;
      break;
      if (localab == null) {
        return localad2.i().b(a(localad2)).a();
      }
      try
      {
        localObject = parama.a(localab);
        if ((localObject == null) && (localad1 != null)) {
          b.a.c.a(localad1.h());
        }
        if (localad2 == null) {
          break label332;
        }
        if (((ad)localObject).c() == 304)
        {
          parama = localad2.i().a(a(localad2.g(), ((ad)localObject).g())).a(((ad)localObject).p()).b(((ad)localObject).q()).b(a(localad2)).a(a((ad)localObject)).a();
          ((ad)localObject).h().close();
          this.a.a();
          this.a.a(localad2, parama);
          return parama;
        }
      }
      finally
      {
        if ((0 == 0) && (localad1 != null)) {
          b.a.c.a(localad1.h());
        }
      }
      b.a.c.a(localad2.h());
      localad1 = ((ad)localObject).i().b(a(localad2)).a(a((ad)localObject)).a();
      parama = localad1;
    } while (!e.d(localad1));
    return a(a(localad1, ((ad)localObject).a(), this.a), localad1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */