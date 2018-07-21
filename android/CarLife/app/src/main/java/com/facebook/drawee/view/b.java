package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.g.d;
import com.facebook.common.g.e;
import com.facebook.common.internal.j;
import com.facebook.common.internal.j.a;
import com.facebook.common.internal.k;
import com.facebook.drawee.b.b.a;
import com.facebook.drawee.d.t;
import com.facebook.drawee.d.u;
import javax.annotation.Nullable;

public class b<DH extends com.facebook.drawee.g.b>
  implements d, u
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private DH e;
  private com.facebook.drawee.g.a f = null;
  private final com.facebook.drawee.b.b g = com.facebook.drawee.b.b.a();
  
  public b(@Nullable DH paramDH)
  {
    if (paramDH != null) {
      a(paramDH);
    }
  }
  
  public static <DH extends com.facebook.drawee.g.b> b<DH> a(@Nullable DH paramDH, Context paramContext)
  {
    paramDH = new b(paramDH);
    paramDH.a(paramContext);
    e.a(paramDH);
    return paramDH;
  }
  
  private void a(@Nullable u paramu)
  {
    Drawable localDrawable = j();
    if ((localDrawable instanceof t)) {
      ((t)localDrawable).a(paramu);
    }
  }
  
  private void l()
  {
    if (this.a) {}
    do
    {
      return;
      this.g.a(b.a.g);
      this.a = true;
    } while ((this.f == null) || (this.f.m() == null));
    this.f.o();
  }
  
  private void m()
  {
    if (!this.a) {}
    do
    {
      return;
      this.g.a(b.a.h);
      this.a = false;
    } while (this.f == null);
    this.f.p();
  }
  
  private void n()
  {
    if ((this.b) && (this.c) && (!this.d))
    {
      l();
      return;
    }
    m();
  }
  
  public void a()
  {
    this.g.a(b.a.q);
    this.d = true;
    n();
  }
  
  public void a(Context paramContext) {}
  
  public void a(@Nullable com.facebook.drawee.g.a parama)
  {
    boolean bool = this.a;
    if (bool) {
      m();
    }
    if (this.f != null)
    {
      this.g.a(b.a.d);
      this.f.a(null);
    }
    this.f = parama;
    if (this.f != null)
    {
      this.g.a(b.a.c);
      this.f.a(this.e);
    }
    for (;;)
    {
      if (bool) {
        l();
      }
      return;
      this.g.a(b.a.e);
    }
  }
  
  public void a(DH paramDH)
  {
    this.g.a(b.a.a);
    a(null);
    this.e = ((com.facebook.drawee.g.b)k.a(paramDH));
    Drawable localDrawable = this.e.a();
    if ((localDrawable == null) || (localDrawable.isVisible())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      a(this);
      if (this.f != null) {
        this.f.a(paramDH);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c == paramBoolean) {
      return;
    }
    com.facebook.drawee.b.b localb = this.g;
    if (paramBoolean) {}
    for (b.a locala = b.a.s;; locala = b.a.t)
    {
      localb.a(locala);
      this.c = paramBoolean;
      n();
      return;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.f == null) {
      return false;
    }
    return this.f.a(paramMotionEvent);
  }
  
  public void b()
  {
    this.g.a(b.a.r);
    this.d = false;
    n();
  }
  
  public void c()
  {
    if (this.a) {
      return;
    }
    if (!this.d) {
      com.facebook.common.e.a.f(com.facebook.drawee.b.b.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f)), toString() });
    }
    this.d = false;
    this.b = true;
    this.c = true;
    n();
  }
  
  public void d()
  {
    this.g.a(b.a.o);
    this.b = true;
    n();
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public void f()
  {
    this.g.a(b.a.p);
    this.b = false;
    n();
  }
  
  @Nullable
  public com.facebook.drawee.g.a g()
  {
    return this.f;
  }
  
  public DH h()
  {
    return (com.facebook.drawee.g.b)k.a(this.e);
  }
  
  public boolean i()
  {
    return this.e != null;
  }
  
  public Drawable j()
  {
    if (this.e == null) {
      return null;
    }
    return this.e.a();
  }
  
  protected com.facebook.drawee.b.b k()
  {
    return this.g;
  }
  
  public String toString()
  {
    return j.a(this).a("controllerAttached", this.a).a("holderAttached", this.b).a("drawableVisible", this.c).a("trimmed", this.d).a("events", this.g.toString()).toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */