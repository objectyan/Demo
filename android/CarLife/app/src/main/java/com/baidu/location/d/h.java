package com.baidu.location.d;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.f.f;
import com.baidu.location.h.g;
import java.util.HashMap;
import java.util.Map;

public class h
{
  private static h a;
  private com.baidu.location.f.e b = null;
  private com.baidu.location.f.a c = null;
  private long d = 0L;
  private BDLocation e = null;
  private long f = 0L;
  private int g = 0;
  private boolean h = false;
  
  public static h a()
  {
    try
    {
      if (a == null) {
        a = new h();
      }
      h localh = a;
      return localh;
    }
    finally {}
  }
  
  private void a(BDLocation paramBDLocation)
  {
    this.e = paramBDLocation;
    Bundle localBundle = new Bundle();
    if ((paramBDLocation != null) && (paramBDLocation.getNetworkLocationType() != null) && (paramBDLocation.getNetworkLocationType().equals("wf")))
    {
      localBundle.putParcelable("navimodelocation", paramBDLocation);
      localBundle.setClassLoader(BDLocation.class.getClassLoader());
      com.baidu.location.a.a.a().a(localBundle, 404);
    }
  }
  
  private boolean a(com.baidu.location.f.a parama)
  {
    boolean bool2 = true;
    com.baidu.location.f.a locala = com.baidu.location.f.b.a().f();
    boolean bool1;
    if (locala == parama) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (locala == null);
        bool1 = bool2;
      } while (parama == null);
      bool1 = bool2;
    } while (!parama.a(locala));
    return false;
  }
  
  private boolean a(com.baidu.location.f.e parame)
  {
    boolean bool2 = true;
    com.baidu.location.f.e locale = f.a().q();
    boolean bool1;
    if (parame == locale) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (locale == null);
        bool1 = bool2;
      } while (parame == null);
      bool1 = bool2;
    } while (!parame.c(locale));
    return false;
  }
  
  private void b(int paramInt)
  {
    if ((System.currentTimeMillis() - this.d < 1000L) && (this.e != null)) {
      a(this.e);
    }
    while (this.h) {
      return;
    }
    this.d = System.currentTimeMillis();
    boolean bool1 = a(this.b);
    boolean bool2 = a(this.c);
    if ((!bool1) && (!bool2) && (this.e != null))
    {
      a(this.e);
      return;
    }
    this.c = com.baidu.location.f.b.a().f();
    this.b = f.a().q();
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if ((this.c != null) && (this.c.b())) {
      localStringBuffer.append(this.c.i());
    }
    if ((this.b != null) && (this.b.a() > 1)) {
      localStringBuffer.append(this.b.a(15));
    }
    localStringBuffer.append("&nase=" + paramInt);
    localStringBuffer.append("&coor=bd09");
    localStringBuffer.append(com.baidu.location.h.b.a().a(false));
    localStringBuffer.append(com.baidu.location.a.a.a().f());
    new a().a(localStringBuffer.toString());
    this.h = true;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    b(paramInt);
  }
  
  public void b()
  {
    if (this.g == 0) {}
    String str;
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis() - this.f;
      } while ((l <= 0L) || (l < 3000L));
      this.f = System.currentTimeMillis();
      str = f.a().h();
    } while ((str == null) || (!str.equals("&wifio=1")));
    b(this.g);
  }
  
  public void c()
  {
    this.b = null;
    this.c = null;
    this.d = 0L;
    this.e = null;
    this.f = 0L;
    this.g = 0;
    this.h = false;
  }
  
  class a
    extends com.baidu.location.h.e
  {
    private String b = null;
    
    a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.i = 1;
      this.h = g.e();
      String str = Jni.encodeTp4(this.b);
      this.b = null;
      this.k.put("bloc", str);
    }
    
    public void a(String paramString)
    {
      this.b = paramString;
      c(g.f);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      try
      {
        BDLocation localBDLocation = new BDLocation(this.j);
        h.a(h.this, localBDLocation);
        if (this.k != null) {
          this.k.clear();
        }
        h.a(h.this, false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(h.this, null);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */