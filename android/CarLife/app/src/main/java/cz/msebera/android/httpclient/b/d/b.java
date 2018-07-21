package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.e.f;
import cz.msebera.android.httpclient.k.s;
import cz.msebera.android.httpclient.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b
  extends cz.msebera.android.httpclient.k.a
  implements a, g, u, Cloneable
{
  private final AtomicBoolean aborted = new AtomicBoolean(false);
  private final AtomicReference<cz.msebera.android.httpclient.c.b> cancellableRef = new AtomicReference(null);
  
  public void abort()
  {
    if (this.aborted.compareAndSet(false, true))
    {
      cz.msebera.android.httpclient.c.b localb = (cz.msebera.android.httpclient.c.b)this.cancellableRef.getAndSet(null);
      if (localb != null) {
        localb.a();
      }
    }
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    b localb = (b)super.clone();
    localb.headergroup = ((s)cz.msebera.android.httpclient.b.g.a.a(this.headergroup));
    localb.params = ((cz.msebera.android.httpclient.l.j)cz.msebera.android.httpclient.b.g.a.a(this.params));
    return localb;
  }
  
  public void completed()
  {
    this.cancellableRef.set(null);
  }
  
  public boolean isAborted()
  {
    return this.aborted.get();
  }
  
  public void reset()
  {
    cz.msebera.android.httpclient.c.b localb = (cz.msebera.android.httpclient.c.b)this.cancellableRef.getAndSet(null);
    if (localb != null) {
      localb.a();
    }
    this.aborted.set(false);
  }
  
  public void setCancellable(cz.msebera.android.httpclient.c.b paramb)
  {
    if (!this.aborted.get()) {
      this.cancellableRef.set(paramb);
    }
  }
  
  @Deprecated
  public void setConnectionRequest(f paramf)
  {
    setCancellable(new b.1(this, paramf));
  }
  
  @Deprecated
  public void setReleaseTrigger(cz.msebera.android.httpclient.e.j paramj)
  {
    setCancellable(new b.2(this, paramj));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */