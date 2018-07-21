package com.baidu.carlife.k.a;

import android.content.Context;
import android.os.Environment;
import com.baidu.carlife.BaiduNaviApplication;
import java.io.File;

public class h
{
  public static final String a = h.class.getSimpleName();
  private c b;
  private g c = new g();
  private i d;
  private String e;
  private Context f;
  
  public h(Context paramContext, String paramString1, String paramString2, String paramString3, c paramc, boolean paramBoolean, int paramInt)
  {
    this.c.g = paramBoolean;
    this.c.c = paramString1;
    this.c.d = paramString2;
    this.c.b = paramInt;
    this.e = paramString3;
    this.b = paramc;
    this.f = paramContext;
    if (this.f == null) {
      this.f = BaiduNaviApplication.getInstance();
    }
  }
  
  public h(String paramString1, String paramString2, c paramc)
  {
    this(null, paramString1, paramString2, null, paramc, true, 0);
  }
  
  public static String c()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return Environment.getExternalStorageDirectory().toString() + File.separator + "BaiduCarlife" + File.separator + "NetWorkDownload" + File.separator;
    }
    return null;
  }
  
  public void a()
  {
    this.b = null;
    if (this.d != null) {
      this.d.a();
    }
  }
  
  public void a(long paramLong)
  {
    if (this.c != null) {
      this.c.f = paramLong;
    }
  }
  
  public void a(c paramc)
  {
    this.b = paramc;
    if (this.d != null) {
      this.d.a(paramc);
    }
  }
  
  public File b()
  {
    if (this.d != null) {
      return this.d.b();
    }
    return null;
  }
  
  public void d()
  {
    if (this.d != null) {
      this.d.e();
    }
  }
  
  public void e()
  {
    this.d = new i(this.f, this.c, this.b, this.e);
    j.a().a(this.d);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(long paramLong, int paramInt);
    
    public abstract void a(h.b paramb, h.a parama);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */