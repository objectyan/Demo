package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.b.a.g;
import cz.msebera.android.httpclient.b.a.h;
import cz.msebera.android.httpclient.b.a.m;
import cz.msebera.android.httpclient.i.b.ag;
import java.io.Closeable;
import java.io.File;

public class q
  extends ag
{
  private m b;
  private h c;
  private File d;
  private f e;
  private aq f;
  private g g;
  
  private b b(f paramf)
  {
    if (paramf.l() > 0)
    {
      paramf = new b(c(paramf));
      a(paramf);
      return paramf;
    }
    return null;
  }
  
  private aq c(f paramf)
  {
    if (this.f != null) {
      return this.f;
    }
    return new af(paramf);
  }
  
  public static q j()
  {
    return new q();
  }
  
  public final q a(g paramg)
  {
    this.g = paramg;
    return this;
  }
  
  public final q a(h paramh)
  {
    this.c = paramh;
    return this;
  }
  
  public final q a(m paramm)
  {
    this.b = paramm;
    return this;
  }
  
  public final q a(aq paramaq)
  {
    this.f = paramaq;
    return this;
  }
  
  public final q a(f paramf)
  {
    this.e = paramf;
    return this;
  }
  
  public final q a(File paramFile)
  {
    this.d = paramFile;
    return this;
  }
  
  protected cz.msebera.android.httpclient.i.f.b a(cz.msebera.android.httpclient.i.f.b paramb)
  {
    f localf;
    Object localObject2;
    Object localObject1;
    label39:
    Object localObject3;
    if (this.e != null)
    {
      localf = this.e;
      localObject2 = this.b;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (this.d != null) {
          break label150;
        }
        localObject1 = new ac();
      }
      localObject3 = this.c;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        if (this.d != null) {
          break label165;
        }
        localObject2 = new d(localf);
      }
    }
    for (;;)
    {
      b localb = b(localf);
      j localj = new j();
      g localg = this.g;
      localObject3 = localg;
      if (localg == null) {
        localObject3 = new i(localj, (h)localObject2);
      }
      return new p(paramb, new c((m)localObject1, (h)localObject2, localf, localj, (g)localObject3), localf, localb);
      localf = f.m;
      break;
      label150:
      localObject1 = new aa(this.d);
      break label39;
      label165:
      localObject2 = new ah(localf);
      a((Closeable)localObject2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */