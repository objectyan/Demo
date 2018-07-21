package com.baidu.location.d;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.e.d.a;
import com.baidu.location.e.d.b;
import com.baidu.location.f.f;
import com.baidu.location.h.g;
import java.util.HashMap;
import java.util.Map;

public class k
{
  private static k a;
  private com.baidu.location.f.e b = null;
  private com.baidu.location.f.a c = null;
  private long d = 0L;
  private final long e = 1000L;
  private String f = null;
  
  public static k a()
  {
    try
    {
      if (a == null) {
        a = new k();
      }
      k localk = a;
      return localk;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    this.f = paramString;
    Bundle localBundle = new Bundle();
    if ((paramString != null) && (!paramString.equals(""))) {
      localBundle.putByteArray("locationtag", paramString.getBytes());
    }
    for (;;)
    {
      com.baidu.location.a.a.a().a(localBundle, 601);
      return;
      localBundle.putByteArray("locationtag", null);
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
  
  public void b()
  {
    if ((System.currentTimeMillis() - this.d < 1000L) && (this.f != null))
    {
      a(this.f);
      return;
    }
    this.d = System.currentTimeMillis();
    boolean bool1 = a(this.b);
    boolean bool2 = a(this.c);
    if ((!bool1) && (!bool2) && (this.f != null))
    {
      a(this.f);
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
    for (;;)
    {
      String str = com.baidu.location.f.d.a().h();
      if (str != null) {
        localStringBuffer.append(str);
      }
      localStringBuffer.append("&sema=aptag");
      localStringBuffer.append(com.baidu.location.h.b.a().a(false));
      localStringBuffer.append(com.baidu.location.a.a.a().f());
      new a().a(localStringBuffer.toString());
      return;
      str = f.a().m();
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
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
      label170:
      for (;;)
      {
        try
        {
          BDLocation localBDLocation1 = new BDLocation(this.j);
          k.a(k.this, localBDLocation1.getLocationDescribe());
          if (this.k != null) {
            this.k.clear();
          }
          return;
        }
        catch (Exception localException)
        {
          k.a(k.this, null);
          continue;
        }
        paramBoolean = g.h;
        g.h = true;
        BDLocation localBDLocation2;
        if ((com.baidu.location.e.d.a().d()) && (com.baidu.location.e.d.a().f()))
        {
          localBDLocation2 = com.baidu.location.e.d.a().a(com.baidu.location.f.b.a().f(), f.a().p(), null, d.b.b, d.a.a);
          if ((localBDLocation2 == null) || (localBDLocation2.getLocType() == 67)) {
            k.a(k.this, null);
          }
        }
        for (;;)
        {
          if (paramBoolean) {
            break label170;
          }
          g.h = false;
          break;
          k.a(k.this, localBDLocation2.getLocationDescribe());
          continue;
          k.a(k.this, null);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */