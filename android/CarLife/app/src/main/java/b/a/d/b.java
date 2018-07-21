package b.a.d;

import b.ab;
import b.ac;
import b.ad;
import b.ad.a;
import b.ae;
import b.v;
import b.v.a;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSink;
import okio.Okio;

public final class b
  implements v
{
  private final boolean a;
  
  public b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public ad a(v.a parama)
    throws IOException
  {
    c localc = ((g)parama).d();
    b.a.c.g localg = ((g)parama).c();
    parama = parama.a();
    long l = System.currentTimeMillis();
    localc.a(parama);
    if ((f.c(parama.b())) && (parama.d() != null))
    {
      BufferedSink localBufferedSink = Okio.buffer(localc.a(parama, parama.d().c()));
      parama.d().a(localBufferedSink);
      localBufferedSink.close();
    }
    localc.a();
    parama = localc.b().a(parama).a(localg.b().c()).a(l).b(System.currentTimeMillis()).a();
    int i = parama.c();
    if ((this.a) && (i == 101)) {}
    for (parama = parama.i().a(b.a.c.c).a();; parama = parama.i().a(localc.a(parama)).a())
    {
      if (("close".equalsIgnoreCase(parama.a().a("Connection"))) || ("close".equalsIgnoreCase(parama.b("Connection")))) {
        localg.d();
      }
      if (((i != 204) && (i != 205)) || (parama.h().b() <= 0L)) {
        break;
      }
      throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + parama.h().b());
    }
    return parama;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */