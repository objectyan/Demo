package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.e.b.f;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import java.io.IOException;

@Deprecated
public abstract class c
  extends a
{
  protected volatile b a;
  
  protected c(cz.msebera.android.httpclient.e.c paramc, b paramb)
  {
    super(paramc, paramb.b);
    this.a = paramb;
  }
  
  @Deprecated
  protected final void A()
  {
    if (this.a == null) {
      throw new i();
    }
  }
  
  public void a(cz.msebera.android.httpclient.e.b.b paramb, g paramg, j paramj)
    throws IOException
  {
    b localb = z();
    a(localb);
    localb.a(paramb, paramg, paramj);
  }
  
  protected void a(b paramb)
  {
    if ((y()) || (paramb == null)) {
      throw new i();
    }
  }
  
  public void a(g paramg, j paramj)
    throws IOException
  {
    b localb = z();
    a(localb);
    localb.a(paramg, paramj);
  }
  
  public void a(r paramr, boolean paramBoolean, j paramj)
    throws IOException
  {
    b localb = z();
    a(localb);
    localb.a(paramr, paramBoolean, paramj);
  }
  
  public void a(Object paramObject)
  {
    b localb = z();
    a(localb);
    localb.a(paramObject);
  }
  
  public void a(boolean paramBoolean, j paramj)
    throws IOException
  {
    b localb = z();
    a(localb);
    localb.a(paramBoolean, paramj);
  }
  
  public void close()
    throws IOException
  {
    Object localObject = z();
    if (localObject != null) {
      ((b)localObject).b();
    }
    localObject = v();
    if (localObject != null) {
      ((w)localObject).close();
    }
  }
  
  public void f()
    throws IOException
  {
    Object localObject = z();
    if (localObject != null) {
      ((b)localObject).b();
    }
    localObject = v();
    if (localObject != null) {
      ((w)localObject).f();
    }
  }
  
  public cz.msebera.android.httpclient.e.b.b m()
  {
    b localb = z();
    a(localb);
    if (localb.e == null) {
      return null;
    }
    return localb.e.l();
  }
  
  public Object r()
  {
    b localb = z();
    a(localb);
    return localb.a();
  }
  
  public String s()
  {
    return null;
  }
  
  protected void u()
  {
    try
    {
      this.a = null;
      super.u();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Deprecated
  protected b z()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */