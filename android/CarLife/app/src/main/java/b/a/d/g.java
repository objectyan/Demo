package b.a.d;

import b.a;
import b.ab;
import b.ad;
import b.af;
import b.j;
import b.u;
import b.v;
import b.v.a;
import java.io.IOException;
import java.util.List;

public final class g
  implements v.a
{
  private final List<v> a;
  private final b.a.c.g b;
  private final c c;
  private final j d;
  private final int e;
  private final ab f;
  private int g;
  
  public g(List<v> paramList, b.a.c.g paramg, c paramc, j paramj, int paramInt, ab paramab)
  {
    this.a = paramList;
    this.d = paramj;
    this.b = paramg;
    this.c = paramc;
    this.e = paramInt;
    this.f = paramab;
  }
  
  private boolean a(u paramu)
  {
    return (paramu.i().equals(this.d.a().a().a().i())) && (paramu.j() == this.d.a().a().a().j());
  }
  
  public ab a()
  {
    return this.f;
  }
  
  public ad a(ab paramab)
    throws IOException
  {
    return a(paramab, this.b, this.c, this.d);
  }
  
  public ad a(ab paramab, b.a.c.g paramg, c paramc, j paramj)
    throws IOException
  {
    if (this.e >= this.a.size()) {
      throw new AssertionError();
    }
    this.g += 1;
    if ((this.c != null) && (!a(paramab.a()))) {
      throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must retain the same host and port");
    }
    if ((this.c != null) && (this.g > 1)) {
      throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must call proceed() exactly once");
    }
    paramab = new g(this.a, paramg, paramc, paramj, this.e + 1, paramab);
    paramg = (v)this.a.get(this.e);
    paramj = paramg.a(paramab);
    if ((paramc != null) && (this.e + 1 < this.a.size()) && (paramab.g != 1)) {
      throw new IllegalStateException("network interceptor " + paramg + " must call proceed() exactly once");
    }
    if (paramj == null) {
      throw new NullPointerException("interceptor " + paramg + " returned null");
    }
    return paramj;
  }
  
  public j b()
  {
    return this.d;
  }
  
  public b.a.c.g c()
  {
    return this.b;
  }
  
  public c d()
  {
    return this.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */