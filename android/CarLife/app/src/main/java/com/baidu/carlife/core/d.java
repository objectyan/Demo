package com.baidu.carlife.core;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.carlife.core.b.a;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;
import com.google.protobuf.InvalidProtocolBufferException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;

public class d
  implements h
{
  public static final int a = 160;
  public static final int b = 640;
  private static final double c = 2.6666666666666665D;
  private static final String d = "CarlifeScreenUtil";
  private static d e = null;
  private static HashSet<String> f = new HashSet();
  private DisplayMetrics g;
  private float h = 0.0F;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private a o = a.a;
  private int p = 0;
  private int q = 0;
  
  public static d a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new d();
      }
      return e;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    i.b("CarlifeScreenUtil", "####### addScreenAdaptChannel: " + paramString);
    f.add(paramString);
  }
  
  private int b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 0;
    }
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i1 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i1 = paramActivity.getResources().getDimensionPixelSize(i1);
      return i1;
    }
    catch (Exception localException)
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return localRect.top;
    }
  }
  
  public static boolean m()
  {
    if (a().b() == a.a) {}
    while (!a.a()) {
      return false;
    }
    String str1 = f.jx.a();
    i.b("CarlifeScreenUtil", "####### isVehicleSupportScreenAdapt: " + str1);
    if (str1 != null)
    {
      if ((f.jx == f.a.ab) || (f.jx == f.a.aa) || (str1.equals("20882101")) || (str1.equals("20882100")))
      {
        i.b("CarlifeScreenUtil", "####### isVehicleSupportScreenAdapt: true");
        return true;
      }
      Iterator localIterator = f.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str2.equals(str1))
        {
          i.b("CarlifeScreenUtil", "Server channel support ScreenAdapt: " + str2);
          return true;
        }
      }
    }
    i.b("CarlifeScreenUtil", "####### isVehicleSupportScreenAdapt: not sport");
    return false;
  }
  
  public int a(float paramFloat)
  {
    return (int)(0.5F + this.h * paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    this.g = paramActivity.getResources().getDisplayMetrics();
    this.h = this.g.density;
    this.i = Math.max(this.g.widthPixels, this.g.heightPixels);
    this.j = Math.min(this.g.widthPixels, this.g.heightPixels);
    if (Build.VERSION.SDK_INT >= 17)
    {
      Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint = new Point();
      localDisplay.getRealSize(localPoint);
      this.k = Math.max(localPoint.x, localPoint.y);
      this.l = Math.min(localPoint.x, localPoint.y);
    }
    for (;;)
    {
      this.m = b(paramActivity);
      try
      {
        if (Integer.parseInt(Build.VERSION.SDK) > 3) {}
        for (this.n = this.g.densityDpi;; this.n = 160)
        {
          if (this.n == 0) {
            this.n = 160;
          }
          this.p = this.i;
          this.q = this.j;
          i.a("CarlifeScreenUtil", "mDensity = " + this.h);
          i.a("CarlifeScreenUtil", "mWidthPixels = " + this.i + ", mHeightPixels = " + this.j);
          i.a("CarlifeScreenUtil", "mWindowWidthPixels = " + this.k + ", mWindowHeightPixels = " + this.l);
          i.a("CarlifeScreenUtil", "mStatusBarHeight = " + this.m);
          i.a("CarlifeScreenUtil", "mDensityDpi = " + this.n);
          return;
          this.k = this.i;
          this.l = this.j;
          break;
        }
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          paramActivity.printStackTrace();
        }
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    paramMessage = (c)paramMessage.obj;
    try
    {
      paramMessage = CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.parseFrom(paramMessage.f());
      int i1 = paramMessage.getWidth();
      int i2 = paramMessage.getHeight();
      i.b("CarlifeScreenUtil", "####### MSG_CMD_VIDEO_ENCODER_INIT:[ " + i1 + " : " + i2 + "]");
      if (i1 / i2 >= 2.3D)
      {
        this.o = a.b;
        i.b("CarlifeScreenUtil", "####### W_8_H_3 : " + this.o);
        return;
      }
    }
    catch (InvalidProtocolBufferException paramMessage)
    {
      i.e("CarlifeScreenUtil", "Get VIDEO_ENCODER_INIT_INFO Error");
      paramMessage.printStackTrace();
      return;
    }
    this.o = a.a;
    i.b("CarlifeScreenUtil", "####### W_16_H_9 : " + this.o);
  }
  
  public int b(float paramFloat)
  {
    return (int)(0.5F + paramFloat / this.h);
  }
  
  public a b()
  {
    return this.o;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int c(float paramFloat)
  {
    return (int)(i() * paramFloat);
  }
  
  public int c(int paramInt)
  {
    return (int)(0.5F + this.h * paramInt);
  }
  
  public DisplayMetrics c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.p;
  }
  
  public int d(float paramFloat)
  {
    return (int)(h() * paramFloat);
  }
  
  public int d(int paramInt)
  {
    return (int)(0.5F + paramInt / this.h);
  }
  
  public int e()
  {
    return this.q;
  }
  
  public void f()
  {
    this.o = a.a;
  }
  
  public int g()
  {
    return this.n;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public int k()
  {
    return this.k;
  }
  
  public int l()
  {
    return this.l;
  }
  
  public static enum a
  {
    double c;
    
    private a(double paramDouble)
    {
      this.c = paramDouble;
    }
    
    public double a()
    {
      return this.c;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */