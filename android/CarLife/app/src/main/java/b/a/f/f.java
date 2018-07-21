package b.a.f;

import b.a.a;
import b.a.d.h;
import b.a.d.k;
import b.ab;
import b.ad;
import b.ad.a;
import b.ae;
import b.t;
import b.t.a;
import b.u;
import b.y;
import b.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class f
  implements b.a.d.c
{
  private static final ByteString c = ByteString.encodeUtf8("connection");
  private static final ByteString d = ByteString.encodeUtf8("host");
  private static final ByteString e = ByteString.encodeUtf8("keep-alive");
  private static final ByteString f = ByteString.encodeUtf8("proxy-connection");
  private static final ByteString g = ByteString.encodeUtf8("transfer-encoding");
  private static final ByteString h = ByteString.encodeUtf8("te");
  private static final ByteString i = ByteString.encodeUtf8("encoding");
  private static final ByteString j = ByteString.encodeUtf8("upgrade");
  private static final List<ByteString> k = b.a.c.a(new ByteString[] { c, d, e, f, h, g, i, j, c.c, c.d, c.e, c.f });
  private static final List<ByteString> l = b.a.c.a(new ByteString[] { c, d, e, f, h, g, i, j });
  final b.a.c.g b;
  private final y m;
  private final g n;
  private i o;
  
  public f(y paramy, b.a.c.g paramg, g paramg1)
  {
    this.m = paramy;
    this.b = paramg;
    this.n = paramg1;
  }
  
  public static ad.a a(List<c> paramList)
    throws IOException
  {
    Object localObject1 = null;
    t.a locala = new t.a();
    int i1 = 0;
    int i2 = paramList.size();
    if (i1 < i2)
    {
      ByteString localByteString = ((c)paramList.get(i1)).g;
      String str = ((c)paramList.get(i1)).h.utf8();
      Object localObject2;
      if (localByteString.equals(c.b)) {
        localObject2 = str;
      }
      for (;;)
      {
        i1 += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (!l.contains(localByteString))
        {
          a.a.a(locala, localByteString.utf8(), str);
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = k.a("HTTP/1.1 " + (String)localObject1);
    return new ad.a().a(z.d).a(paramList.e).a(paramList.f).a(locala.a());
  }
  
  public static List<c> b(ab paramab)
  {
    t localt = paramab.c();
    ArrayList localArrayList = new ArrayList(localt.a() + 4);
    localArrayList.add(new c(c.c, paramab.b()));
    localArrayList.add(new c(c.d, b.a.d.i.a(paramab.a())));
    localArrayList.add(new c(c.f, b.a.c.a(paramab.a(), false)));
    localArrayList.add(new c(c.e, paramab.a().c()));
    int i1 = 0;
    int i2 = localt.a();
    while (i1 < i2)
    {
      paramab = ByteString.encodeUtf8(localt.a(i1).toLowerCase(Locale.US));
      if (!k.contains(paramab)) {
        localArrayList.add(new c(paramab, localt.b(i1)));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public ae a(ad paramad)
    throws IOException
  {
    a locala = new a(this.o.j());
    return new h(paramad.g(), Okio.buffer(locala));
  }
  
  public Sink a(ab paramab, long paramLong)
  {
    return this.o.k();
  }
  
  public void a()
    throws IOException
  {
    this.o.k().close();
  }
  
  public void a(ab paramab)
    throws IOException
  {
    if (this.o != null) {
      return;
    }
    if (paramab.d() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramab = b(paramab);
      this.o = this.n.a(paramab, bool);
      this.o.h().timeout(this.m.b(), TimeUnit.MILLISECONDS);
      this.o.i().timeout(this.m.c(), TimeUnit.MILLISECONDS);
      return;
    }
  }
  
  public ad.a b()
    throws IOException
  {
    return a(this.o.f());
  }
  
  public void c()
  {
    if (this.o != null) {
      this.o.b(b.f);
    }
  }
  
  class a
    extends ForwardingSource
  {
    public a(Source paramSource)
    {
      super();
    }
    
    public void close()
      throws IOException
    {
      f.this.b.a(false, f.this);
      super.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */