package com.baidu.carlife.l;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.baidu.carlife.core.screen.j;
import com.baidu.carlife.core.screen.presentation.a.b;
import com.baidu.carlife.core.screen.presentation.f;
import com.baidu.carlife.core.screen.video.e;

public class d
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4353;
  private static final String e = "CarlifeCoreVideo";
  private static d g;
  private e f = null;
  
  public static d a()
  {
    if (g == null) {
      g = new d();
    }
    return g;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.f.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Activity paramActivity, Class paramClass, j paramj, Drawable paramDrawable, int paramInt)
  {
    b.b().a(paramActivity, paramClass, paramj);
    b.b().a(paramDrawable);
    b.b().a(paramInt);
    com.baidu.carlife.core.d.a().a(paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f.a(paramBoolean);
  }
  
  public int b()
  {
    e locale = this.f;
    return e.c();
  }
  
  public void b(boolean paramBoolean)
  {
    this.f.b(paramBoolean);
  }
  
  public int c()
  {
    e locale = this.f;
    return e.d();
  }
  
  public void c(boolean paramBoolean)
  {
    this.f.c(paramBoolean);
  }
  
  public Bitmap d()
  {
    return this.f.f;
  }
  
  public void d(boolean paramBoolean)
  {
    this.f.d(paramBoolean);
  }
  
  public boolean e()
  {
    return this.f.e();
  }
  
  public void f()
  {
    this.f.h();
  }
  
  public void g()
  {
    this.f.i();
  }
  
  public boolean h()
  {
    return this.f.j();
  }
  
  public boolean i()
  {
    return this.f.k();
  }
  
  public boolean j()
  {
    return this.f.l();
  }
  
  public void k()
  {
    this.f.m();
  }
  
  public void l()
  {
    this.f.p();
    b.b().c();
  }
  
  public boolean m()
  {
    return this.f.n();
  }
  
  public f n()
  {
    return b.b().h();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/l/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */