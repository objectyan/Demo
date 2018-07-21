package com.baidu.carlife.core.screen.presentation.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.carlife.core.screen.k;
import com.baidu.carlife.core.screen.n;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService;
import com.baidu.carlife.core.screen.video.e;

public class b
  implements com.baidu.carlife.core.screen.j, k, n
{
  public static final String a = b.class.getSimpleName();
  private static b b;
  private j c;
  private View d;
  private Drawable e;
  private int f;
  private Activity g;
  private com.baidu.carlife.core.screen.presentation.f h;
  private Class i = AbsCarlifeActivityService.class;
  private com.baidu.carlife.core.screen.j j;
  
  private void a(Context paramContext, com.baidu.carlife.core.screen.presentation.i parami)
  {
    Intent localIntent = new Intent(paramContext, this.i);
    paramContext.startService(localIntent);
    this.h = new com.baidu.carlife.core.screen.presentation.f(this.g, this, parami, this.i);
    paramContext.bindService(localIntent, this.h, 64);
  }
  
  public static b b()
  {
    if (b == null) {
      b = new b();
    }
    return b;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    com.baidu.carlife.core.screen.b.f.a().a(paramInt1);
    com.baidu.carlife.core.screen.b.f.a().b(paramInt2);
    if (this.j != null) {
      this.j.a(paramInt1, paramInt2);
    }
  }
  
  public void a(Activity paramActivity, Class paramClass, com.baidu.carlife.core.screen.j paramj)
  {
    this.g = paramActivity;
    this.j = paramj;
    if (paramClass != null) {}
    for (this.i = paramClass;; this.i = AbsCarlifeActivityService.class)
    {
      e.b().a(this);
      return;
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    com.baidu.carlife.core.i.b(a, "switchCarLifeViewAndMaskView isConnect=" + paramBoolean);
    if (paramActivity == null) {}
    do
    {
      do
      {
        return;
        if ((paramBoolean) || (this.d == null)) {
          break;
        }
        if (this.d.getParent() != null)
        {
          ((ViewGroup)this.d.getParent()).removeView(this.d);
          ((ViewGroup)paramActivity.getWindow().getDecorView()).removeAllViews();
        }
        ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.d);
      } while ((this.c == null) || (this.c.b() == null) || (this.c.b().getParent() == null));
      ((ViewGroup)this.c.b().getParent()).removeView(this.c.b());
      return;
    } while (!paramBoolean);
    this.d = ((ViewGroup)paramActivity.getWindow().getDecorView()).getChildAt(0);
    if (this.d == null)
    {
      com.baidu.carlife.core.i.e(a, "getDecorView.getChildAt(0) is null");
      return;
    }
    if (this.c == null) {
      this.c = new j(this);
    }
    for (;;)
    {
      ViewParent localViewParent = this.d.getParent();
      if (localViewParent != null)
      {
        ((ViewGroup)localViewParent).removeView(this.d);
        ((ViewGroup)localViewParent).removeAllViews();
        ((ViewGroup)localViewParent).invalidate();
      }
      Object localObject = this.c.b().getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(this.c.b());
      }
      paramActivity = new FrameLayout(paramActivity);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      paramActivity.addView(this.d, (ViewGroup.LayoutParams)localObject);
      paramActivity.addView(this.c.b(), (ViewGroup.LayoutParams)localObject);
      ((ViewGroup)localViewParent).addView(paramActivity);
      ((ViewGroup)localViewParent).invalidate();
      paramActivity.invalidate();
      return;
      this.c.a();
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    if (this.j != null) {
      this.j.a(paramIntent, paramInt);
    }
    while (this.g == null) {
      return;
    }
    this.g.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.e = paramDrawable;
  }
  
  public void a(com.baidu.carlife.core.screen.presentation.i parami)
  {
    if (this.g != null) {
      a(this.g, parami);
    }
  }
  
  public void c()
  {
    this.c = null;
    this.d = null;
    this.g = null;
    this.h = null;
    this.j = null;
    this.e = null;
  }
  
  public j d()
  {
    return this.c;
  }
  
  public View e()
  {
    return this.d;
  }
  
  public Drawable f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public com.baidu.carlife.core.screen.presentation.f h()
  {
    return this.h;
  }
  
  public void o()
  {
    com.baidu.carlife.core.i.b(a, "onVehicleConnected");
    a(this.g, true);
    if (this.j != null) {
      this.j.o();
    }
  }
  
  public void p()
  {
    com.baidu.carlife.core.i.b(a, "onVehicleDisconnect");
    if (this.h != null)
    {
      this.h.b();
      this.h.a();
    }
    a(this.g, false);
    if (this.j != null) {
      this.j.p();
    }
  }
  
  public boolean q()
  {
    if (this.j != null) {
      return this.j.q();
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */