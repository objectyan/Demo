package b.a.d;

import b.a.c;
import b.a.d;
import b.ab;
import b.ab.a;
import b.ac;
import b.ad;
import b.ad.a;
import b.ae;
import b.m;
import b.n;
import b.t;
import b.t.a;
import b.v;
import b.v.a;
import b.w;
import java.io.IOException;
import java.util.List;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

public final class a
  implements v
{
  private final n a;
  
  public a(n paramn)
  {
    this.a = paramn;
  }
  
  private String a(List<m> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      m localm = (m)paramList.get(i);
      localStringBuilder.append(localm.a()).append('=').append(localm.b());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public ad a(v.a parama)
    throws IOException
  {
    Object localObject1 = parama.a();
    Object localObject2 = ((ab)localObject1).f();
    Object localObject3 = ((ab)localObject1).d();
    if (localObject3 != null)
    {
      w localw = ((ac)localObject3).b();
      if (localw != null) {
        ((ab.a)localObject2).a("Content-Type", localw.toString());
      }
      long l = ((ac)localObject3).c();
      if (l == -1L) {
        break label351;
      }
      ((ab.a)localObject2).a("Content-Length", Long.toString(l));
      ((ab.a)localObject2).b("Transfer-Encoding");
    }
    for (;;)
    {
      if (((ab)localObject1).a("Host") == null) {
        ((ab.a)localObject2).a("Host", c.a(((ab)localObject1).a(), false));
      }
      if (((ab)localObject1).a("Connection") == null) {
        ((ab.a)localObject2).a("Connection", "Keep-Alive");
      }
      int i = 0;
      if (((ab)localObject1).a("Accept-Encoding") == null)
      {
        i = 1;
        ((ab.a)localObject2).a("Accept-Encoding", "gzip");
      }
      localObject3 = this.a.a(((ab)localObject1).a());
      if (!((List)localObject3).isEmpty()) {
        ((ab.a)localObject2).a("Cookie", a((List)localObject3));
      }
      if (((ab)localObject1).a("User-Agent") == null) {
        ((ab.a)localObject2).a("User-Agent", d.a());
      }
      parama = parama.a(((ab.a)localObject2).d());
      e.a(this.a, ((ab)localObject1).a(), parama.g());
      localObject1 = parama.i().a((ab)localObject1);
      if ((i != 0) && ("gzip".equalsIgnoreCase(parama.b("Content-Encoding"))) && (e.d(parama)))
      {
        localObject2 = new GzipSource(parama.h().c());
        parama = parama.g().c().c("Content-Encoding").c("Content-Length").a();
        ((ad.a)localObject1).a(parama);
        ((ad.a)localObject1).a(new h(parama, Okio.buffer((Source)localObject2)));
      }
      return ((ad.a)localObject1).a();
      label351:
      ((ab.a)localObject2).a("Transfer-Encoding", "chunked");
      ((ab.a)localObject2).b("Content-Length");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */