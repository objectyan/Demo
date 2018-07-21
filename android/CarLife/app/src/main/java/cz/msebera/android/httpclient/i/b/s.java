package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.f.e;
import cz.msebera.android.httpclient.b.f.i;
import cz.msebera.android.httpclient.b.f.k;
import cz.msebera.android.httpclient.b.f.l;
import cz.msebera.android.httpclient.b.f.o;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.l.m;
import cz.msebera.android.httpclient.l.n;
import cz.msebera.android.httpclient.n.aa;
import cz.msebera.android.httpclient.n.b;
import cz.msebera.android.httpclient.n.w;
import cz.msebera.android.httpclient.n.y;
import cz.msebera.android.httpclient.n.z;
import java.nio.charset.Charset;

@Deprecated
@ThreadSafe
public class s
  extends c
{
  public s()
  {
    super(null, null);
  }
  
  public s(cz.msebera.android.httpclient.e.c paramc)
  {
    super(paramc, null);
  }
  
  public s(cz.msebera.android.httpclient.e.c paramc, j paramj)
  {
    super(paramc, paramj);
  }
  
  public s(j paramj)
  {
    super(null, paramj);
  }
  
  public static void b(j paramj)
  {
    m.a(paramj, ac.d);
    m.b(paramj, cz.msebera.android.httpclient.n.f.t.name());
    cz.msebera.android.httpclient.l.h.b(paramj, true);
    cz.msebera.android.httpclient.l.h.b(paramj, 8192);
    m.c(paramj, ag.a);
  }
  
  protected j c()
  {
    n localn = new n();
    b(localn);
    return localn;
  }
  
  protected b d()
  {
    b localb = new b();
    localb.b(new i());
    localb.b(new w());
    localb.b(new z());
    localb.b(new cz.msebera.android.httpclient.b.f.h());
    localb.b(new aa());
    localb.b(new y());
    localb.b(new e());
    localb.b(new o());
    localb.b(new cz.msebera.android.httpclient.b.f.f());
    localb.b(new l());
    localb.b(new k());
    return localb;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */