package com.tencent.mm.sdk.b;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class d
  implements e.a
{
  private e aJ;
  private ConcurrentHashMap<Runnable, WeakReference<g>> aK = new ConcurrentHashMap();
  private int aL;
  private LinkedList<WeakReference<g>> aM = new LinkedList();
  
  public d()
  {
    this.aJ = new e(this);
    if (this.aJ.getLooper().getThread().getName().equals("initThread")) {
      b.a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { h.u() });
    }
  }
  
  public d(Looper paramLooper)
  {
    this.aJ = new e(paramLooper, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      b.a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { h.u() });
    }
  }
  
  public final void a(Runnable paramRunnable, g paramg)
  {
    this.aK.put(paramRunnable, new WeakReference(paramg));
  }
  
  public final void b(Runnable paramRunnable, g paramg)
  {
    WeakReference localWeakReference = (WeakReference)this.aK.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramg))
    {
      this.aK.remove(paramRunnable);
      if (this.aL > 0)
      {
        if (this.aM.size() == this.aL) {
          this.aM.pop();
        }
        this.aM.add(localWeakReference);
      }
    }
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    return this.aJ.post(paramRunnable);
  }
  
  public final String toString()
  {
    return "MMHandler(" + getClass().getName() + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */