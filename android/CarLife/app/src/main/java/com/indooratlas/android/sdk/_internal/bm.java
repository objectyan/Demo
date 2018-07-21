package com.indooratlas.android.sdk._internal;

import android.util.SparseArray;

public final class bm
{
  final SparseArray<bp> a = new SparseArray();
  b b;
  a c = new a(this);
  
  private boolean a(bp parambp, long paramLong)
  {
    int i = parambp.a;
    this.c.removeMessages(i);
    for (;;)
    {
      synchronized (this.a)
      {
        bp localbp = (bp)this.a.get(i);
        if ((localbp == null) || ((localbp.b != parambp.b) && (this.b != null)))
        {
          if (paramLong >= 0L)
          {
            parambp = this.c.obtainMessage(i, new d(localbp, parambp));
            this.c.sendMessageDelayed(parambp, paramLong);
            bool = true;
            return bool;
          }
          a(i, parambp);
          bool = true;
        }
      }
      boolean bool = false;
    }
  }
  
  final void a(int paramInt, bp parambp)
  {
    synchronized (this.a)
    {
      this.a.put(paramInt, parambp);
      this.b.a(parambp);
      return;
    }
  }
  
  public final boolean a(int paramInt, long paramLong)
  {
    return a(new bp(paramInt), paramLong);
  }
  
  static final class a
    extends ek<bm>
  {
    protected a(bm parambm)
    {
      super();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(bp parambp);
  }
  
  public static class c
    implements bm.b
  {
    public void a(bp parambp) {}
  }
  
  static final class d
  {
    final bp a;
    final bp b;
    
    d(bp parambp1, bp parambp2)
    {
      this.a = parambp1;
      this.b = parambp2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */