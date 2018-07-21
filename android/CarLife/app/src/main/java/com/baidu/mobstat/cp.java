package com.baidu.mobstat;

import android.content.Context;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;

class cp
  implements Runnable
{
  private long b;
  private long c;
  private WeakReference<Context> d;
  private WeakReference<Fragment> e;
  private WeakReference<Object> f;
  private long g;
  private int h;
  private int i = 1;
  
  public cp(ch paramch, long paramLong1, long paramLong2, long paramLong3, Context paramContext, Fragment paramFragment, Object paramObject, int paramInt1, int paramInt2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = new WeakReference(paramContext);
    this.e = new WeakReference(paramFragment);
    this.f = new WeakReference(paramObject);
    this.g = paramLong3;
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void run()
  {
    Object localObject1 = (Context)this.d.get();
    Fragment localFragment = (Fragment)this.e.get();
    Object localObject2 = this.f.get();
    if ((localObject1 == null) && (localFragment == null) && (localObject2 == null)) {}
    label53:
    label80:
    label197:
    label199:
    label204:
    label225:
    label228:
    for (;;)
    {
      return;
      if (this.i == 1) {}
      for (;;)
      {
        if (localObject1 == null) {
          break label228;
        }
        if (this.c - this.b >= this.a.c())
        {
          j = 1;
          if (j == 0) {
            break label197;
          }
          if (this.b <= 0L) {
            break label204;
          }
          if ((this.i != 3) && (this.i != 2)) {
            break label199;
          }
        }
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            ch.a(this.a).d(this.b);
          }
          ch.a(this.a, (Context)localObject1, true);
          this.a.a(this.g);
          this.a.b(this.h);
          return;
          if (this.i == 2)
          {
            localObject1 = localFragment.getActivity();
            break label53;
          }
          if (this.i != 3) {
            break label225;
          }
          localObject1 = ch.a(localObject2);
          break label53;
          j = 0;
          break label80;
          break;
        }
        if (this.b != 0L) {
          break;
        }
        this.a.b(this.h);
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */