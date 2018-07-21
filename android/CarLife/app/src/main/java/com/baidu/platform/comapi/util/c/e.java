package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.platform.comapi.c;

public class e
  implements g
{
  public static final int a = 160;
  private int b = -1;
  private int c = -1;
  private float d = -1.0F;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private double h = -1.0D;
  
  public int a()
  {
    if (this.b == -1) {
      a(c.f());
    }
    return this.b;
  }
  
  public void a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.b = paramContext.widthPixels;
    this.c = paramContext.heightPixels;
    this.d = paramContext.density;
    this.e = ((int)paramContext.xdpi);
    this.f = ((int)paramContext.ydpi);
    if (Build.VERSION.SDK_INT > 3)
    {
      double d1 = Math.sqrt(paramContext.heightPixels * paramContext.heightPixels + paramContext.widthPixels * paramContext.widthPixels);
      double d2 = paramContext.widthPixels / paramContext.xdpi;
      double d3 = paramContext.heightPixels / paramContext.ydpi;
      this.g = ((int)Math.ceil(d1 / Math.sqrt(d2 * d2 + d3 * d3)));
      if (this.g >= 240) {}
    }
    for (this.g = paramContext.densityDpi;; this.g = 160)
    {
      if (this.g == 0) {
        this.g = 160;
      }
      this.h = (this.g / 240.0D);
      return;
    }
  }
  
  public int b()
  {
    if (this.c == -1) {
      a(c.f());
    }
    return this.c;
  }
  
  public float c()
  {
    if (this.d == -1.0F) {
      a(c.f());
    }
    return this.d;
  }
  
  public int d()
  {
    if (this.e == -1) {
      a(c.f());
    }
    return this.e;
  }
  
  public int e()
  {
    if (this.f == -1) {
      a(c.f());
    }
    return this.f;
  }
  
  public int f()
  {
    if (this.g == -1) {
      a(c.f());
    }
    return this.g;
  }
  
  public double g()
  {
    if (this.h == -1.0D) {
      a(c.f());
    }
    return this.h;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */