package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.d.a;
import cz.msebera.android.httpclient.l;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.Socket;

@Immutable
public class f
  implements l<e>
{
  public static final f a = new f();
  private final a b;
  private final cz.msebera.android.httpclient.g.e c;
  private final cz.msebera.android.httpclient.g.e d;
  private final cz.msebera.android.httpclient.j.f<u> e;
  private final cz.msebera.android.httpclient.j.d<x> f;
  
  public f()
  {
    this(null, null, null, null, null);
  }
  
  public f(a parama)
  {
    this(parama, null, null, null, null);
  }
  
  public f(a parama, cz.msebera.android.httpclient.g.e parame1, cz.msebera.android.httpclient.g.e parame2, cz.msebera.android.httpclient.j.f<u> paramf, cz.msebera.android.httpclient.j.d<x> paramd)
  {
    if (parama != null) {}
    for (;;)
    {
      this.b = parama;
      this.c = parame1;
      this.d = parame2;
      this.e = paramf;
      this.f = paramd;
      return;
      parama = a.a;
    }
  }
  
  public f(a parama, cz.msebera.android.httpclient.j.f<u> paramf, cz.msebera.android.httpclient.j.d<x> paramd)
  {
    this(parama, null, null, paramf, paramd);
  }
  
  public e b(Socket paramSocket)
    throws IOException
  {
    e locale = new e(this.b.a(), this.b.b(), d.a(this.b), d.b(this.b), this.b.f(), this.c, this.d, this.e, this.f);
    locale.a(paramSocket);
    return locale;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */