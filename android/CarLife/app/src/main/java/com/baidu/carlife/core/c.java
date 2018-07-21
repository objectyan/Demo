package com.baidu.carlife.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class c
  implements h
{
  private static final String a;
  private static final String b = e.h();
  private static final String c = "isFristHelpInVoice";
  private static c n = new c();
  private boolean d = false;
  private boolean e = false;
  private boolean f = true;
  private int g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private SharedPreferences m = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder().append("hadGuide_v");
    e.a();
    a = e.h();
    localStringBuilder = new StringBuilder().append("hadAgreeDisclaimer");
    e.a();
  }
  
  private c()
  {
    n();
  }
  
  public static c a()
  {
    return n;
  }
  
  private void a(SharedPreferences.Editor paramEditor)
  {
    a(paramEditor, false);
  }
  
  private void a(SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramEditor.commit();
      return;
    }
    paramEditor.apply();
  }
  
  private void n() {}
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.m.edit();
    localEditor.putBoolean(a, paramBoolean);
    a(localEditor);
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.m.edit();
    localEditor.putBoolean(b, paramBoolean);
    a(localEditor);
  }
  
  public boolean b()
  {
    return this.m.getBoolean(a, true);
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    return this.m.getBoolean(b, false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public void f(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public void g(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.m.edit();
    localEditor.putBoolean("isFristHelpInVoice", paramBoolean);
    a(localEditor);
  }
  
  public void h(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public void i(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public void j(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean j()
  {
    return this.m.getBoolean("isFristHelpInVoice", true);
  }
  
  public boolean k()
  {
    return this.h;
  }
  
  public boolean l()
  {
    return this.k;
  }
  
  public boolean m()
  {
    return this.l;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */