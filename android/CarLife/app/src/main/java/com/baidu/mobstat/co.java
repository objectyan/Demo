package com.baidu.mobstat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import java.lang.ref.WeakReference;

class co
  implements Runnable
{
  private long b;
  private WeakReference<Context> c;
  private WeakReference<android.support.v4.app.Fragment> d;
  private WeakReference<Object> e;
  private long f;
  private WeakReference<Context> g;
  private WeakReference<android.support.v4.app.Fragment> h;
  private WeakReference<Object> i;
  private int j;
  private String k;
  private String l;
  private boolean m;
  private ExtraInfo n;
  private cm o;
  
  public co(ch paramch, long paramLong1, Context paramContext1, android.support.v4.app.Fragment paramFragment1, long paramLong2, Context paramContext2, android.support.v4.app.Fragment paramFragment2, int paramInt, String paramString1, Object paramObject1, Object paramObject2, String paramString2, boolean paramBoolean, ExtraInfo paramExtraInfo, cm paramcm)
  {
    this.b = paramLong1;
    this.f = paramLong2;
    this.c = new WeakReference(paramContext1);
    this.g = new WeakReference(paramContext2);
    this.d = new WeakReference(paramFragment1);
    this.h = new WeakReference(paramFragment2);
    this.i = new WeakReference(paramObject1);
    this.e = new WeakReference(paramObject2);
    this.j = paramInt;
    this.k = paramString1;
    this.l = paramString2;
    this.m = paramBoolean;
    this.n = paramExtraInfo;
    this.o = paramcm;
  }
  
  public void run()
  {
    if (this.j == 1)
    {
      localObject3 = (Context)this.c.get();
      localObject1 = (Context)this.g.get();
      if ((localObject3 == null) || (localObject1 == null)) {
        db.c("onPause, WeakReference is already been released");
      }
    }
    do
    {
      do
      {
        return;
        if (localObject3 != localObject1)
        {
          if (this.k != null)
          {
            db.b("onPageStart() or onPageEnd() install error.");
            return;
          }
          db.b("onPause() or onResume() install error.");
          return;
        }
        localObject2 = "";
        long l2 = this.b - this.f;
        localObject4 = new StringBuilder();
        if (this.k != null)
        {
          ((StringBuilder)localObject4).append(this.k);
          l1 = l2;
          if (this.o != null)
          {
            l2 = this.o.d - this.o.c;
            db.c("page time = " + this.o.a + "; time = " + l2);
            l1 = l2;
            if (l2 < 20L) {
              db.c("page time little than 20 mills.");
            }
          }
        }
        else
        {
          if (!(localObject3 instanceof Activity))
          {
            db.c("onPause, pause is not a Activity");
            return;
          }
          ((StringBuilder)localObject4).append(((Activity)localObject3).getComponentName().getShortClassName());
          l1 = l2;
          if (((StringBuilder)localObject4).charAt(0) == '.')
          {
            ((StringBuilder)localObject4).deleteCharAt(0);
            l1 = l2;
          }
        }
        localObject1 = localObject2;
        if ((localObject3 instanceof Activity))
        {
          CharSequence localCharSequence = ((Activity)localObject3).getTitle();
          localObject1 = localObject2;
          if (localCharSequence != null) {
            localObject1 = localCharSequence.toString();
          }
        }
        db.a("new page view, page name = " + ((StringBuilder)localObject4).toString() + ", stay time = " + l1 + "(ms)");
        localObject2 = ((StringBuilder)localObject4).toString();
        if (this.k == null) {
          this.l = ((String)localObject2);
        }
        localObject1 = new cg((String)localObject2, (String)localObject1, this.l, l1, this.f, this.m, this.n);
        ch.a(this.a).a((cg)localObject1);
        if (this.k == null) {
          break;
        }
      } while (this.o == null);
      ch.a(this.a).d(this.o.d);
      ch.a(this.a, (Context)localObject3);
      return;
      ch.a(this.a).d(this.b);
      ch.a(this.a, (Context)localObject3);
      return;
      if (this.j == 2)
      {
        localObject2 = (android.support.v4.app.Fragment)this.d.get();
        localObject1 = (android.support.v4.app.Fragment)this.h.get();
        if ((localObject2 == null) || (localObject1 == null))
        {
          db.c("onPause, WeakReference is already been released");
          return;
        }
        if (localObject2 != localObject1)
        {
          db.c("onPause() or onResume() install error.");
          return;
        }
        localObject1 = "";
        localObject3 = ((android.support.v4.app.Fragment)localObject2).getActivity();
        if (localObject3 != null) {
          localObject1 = ((Activity)localObject3).getTitle().toString();
        }
        l1 = this.b - this.f;
        localObject3 = localObject2.getClass().getName();
        localObject4 = ((String)localObject3).substring(((String)localObject3).lastIndexOf(".") + 1);
        db.a("Fragment new page view, page name = " + ((String)localObject3).toString() + ", stay time = " + l1 + "(ms)");
        localObject1 = new cg((String)localObject4, (String)localObject1, (String)localObject4, l1, this.f, this.m, this.n);
        ch.a(this.a).a((cg)localObject1);
        ch.a(this.a).d(this.b);
        ch.a(this.a, ((android.support.v4.app.Fragment)localObject2).getActivity());
        return;
      }
    } while (this.j != 3);
    Object localObject2 = (android.app.Fragment)this.e.get();
    Object localObject1 = (android.app.Fragment)this.i.get();
    if ((localObject2 == null) || (localObject1 == null))
    {
      db.c("onPause, WeakReference is already been released");
      return;
    }
    if (localObject2 != localObject1)
    {
      db.c("onPause() or onResume() install error.");
      return;
    }
    localObject1 = "";
    Object localObject3 = ((android.app.Fragment)localObject2).getActivity();
    if (localObject3 != null) {
      localObject1 = ((Activity)localObject3).getTitle().toString();
    }
    long l1 = this.b - this.f;
    localObject3 = ch.a(localObject2);
    if (localObject3 == null)
    {
      db.c("getContxtFromReverse faild.");
      return;
    }
    localObject2 = localObject2.getClass().getName();
    Object localObject4 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1);
    db.a("android.app.Fragment new page view, page name = " + ((String)localObject2).toString() + "; stay time = " + l1 + "(ms)");
    localObject1 = new cg((String)localObject4, (String)localObject1, (String)localObject4, l1, this.f, this.m, this.n);
    ch.a(this.a).a((cg)localObject1);
    ch.a(this.a).d(this.b);
    ch.a(this.a, (Context)localObject3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */