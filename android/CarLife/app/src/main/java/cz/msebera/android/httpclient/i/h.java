package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.d.a;
import cz.msebera.android.httpclient.g.e;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.l;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.Socket;

@Immutable
public class h
  implements l<g>
{
  public static final h a = new h();
  private final a b;
  private final e c;
  private final e d;
  private final cz.msebera.android.httpclient.j.d<u> e;
  private final f<x> f;
  
  public h()
  {
    this(null, null, null, null, null);
  }
  
  public h(a parama)
  {
    this(parama, null, null, null, null);
  }
  
  public h(a parama, e parame1, e parame2, cz.msebera.android.httpclient.j.d<u> paramd, f<x> paramf)
  {
    if (parama != null) {}
    for (;;)
    {
      this.b = parama;
      this.c = parame1;
      this.d = parame2;
      this.e = paramd;
      this.f = paramf;
      return;
      parama = a.a;
    }
  }
  
  public h(a parama, cz.msebera.android.httpclient.j.d<u> paramd, f<x> paramf)
  {
    this(parama, null, null, paramd, paramf);
  }
  
  public g b(Socket paramSocket)
    throws IOException
  {
    g localg = new g(this.b.a(), this.b.b(), d.a(this.b), d.b(this.b), this.b.f(), this.c, this.d, this.e, this.f);
    localg.a(paramSocket);
    return localg;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */