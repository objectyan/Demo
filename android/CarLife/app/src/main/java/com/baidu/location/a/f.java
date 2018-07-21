package com.baidu.location.a;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.f.b;
import com.baidu.location.f.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class f
{
  public static String c = null;
  public com.baidu.location.f.e a = null;
  public com.baidu.location.f.a b = null;
  final Handler d = new a();
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private String h = null;
  private String i = null;
  
  public String a(String paramString)
  {
    if ((this.b == null) || (!this.b.a())) {
      this.b = b.a().f();
    }
    if ((this.a == null) || (!this.a.l())) {
      this.a = com.baidu.location.f.f.a().q();
    }
    if (d.a().m()) {}
    for (Location localLocation = d.a().k();; localLocation = null)
    {
      if (((this.b == null) || (this.b.d()) || (this.b.c())) && ((this.a == null) || (this.a.a() == 0)) && (localLocation == null)) {
        return null;
      }
      String str = b();
      paramString = str;
      if (e.a().d() == -2) {
        paramString = str + "&imo=1";
      }
      int j = com.baidu.location.h.g.c(com.baidu.location.f.getServiceContext());
      str = paramString;
      if (j >= 0) {
        str = paramString + "&lmd=" + j;
      }
      if ((this.a == null) || (this.a.a() == 0))
      {
        paramString = com.baidu.location.f.f.a().m();
        if (paramString == null) {}
      }
      for (paramString = paramString + str;; paramString = str)
      {
        if (this.f)
        {
          this.f = false;
          return com.baidu.location.h.g.a(this.b, this.a, localLocation, paramString, 0, true);
        }
        return com.baidu.location.h.g.a(this.b, this.a, localLocation, paramString, 0);
      }
    }
  }
  
  public abstract void a();
  
  public abstract void a(Message paramMessage);
  
  public String b()
  {
    String str1 = a.a().f();
    Object localObject1;
    String str2;
    Object localObject2;
    if (com.baidu.location.f.f.j())
    {
      localObject1 = "&cn=32";
      if (!this.e) {
        break label261;
      }
      this.e = false;
      com.baidu.location.d.g.a().b().a(true);
      str2 = com.baidu.location.f.f.a().u();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str2))
      {
        localObject2 = localObject1;
        if (!str2.equals("02:00:00:00:00:00"))
        {
          localObject2 = str2.replace(":", "");
          localObject2 = String.format(Locale.CHINA, "%s&mac=%s", new Object[] { localObject1, localObject2 });
        }
      }
      localObject2 = String.format(Locale.CHINA, "%s&btag=%s", new Object[] { localObject2, com.baidu.location.d.a.a().b() });
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT > 17)
      {
        if (!com.baidu.location.f.f.a().o()) {
          break label241;
        }
        localObject1 = String.format(Locale.CHINA, "%s&wfal=1", new Object[] { localObject2 });
      }
      label161:
      localObject2 = localObject1;
      if (!com.baidu.location.h.g.g.equals("all")) {
        localObject2 = (String)localObject1 + "&addr=allj";
      }
    }
    for (;;)
    {
      return (String)localObject2 + str1;
      localObject1 = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(b.a().e()) });
      break;
      label241:
      localObject1 = String.format(Locale.CHINA, "%s&wfal=0", new Object[] { localObject2 });
      break label161;
      label261:
      localObject2 = localObject1;
      if (!this.g)
      {
        str2 = m.h();
        localObject2 = localObject1;
        if (str2 != null) {
          localObject2 = (String)localObject1 + str2;
        }
        this.g = true;
      }
    }
  }
  
  public class a
    extends Handler
  {
    public a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (!com.baidu.location.f.isServing) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 21: 
        f.this.a(paramMessage);
        return;
      }
      f.this.a();
    }
  }
  
  class b
    extends com.baidu.location.h.e
  {
    String a = null;
    String b = null;
    
    public b()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = com.baidu.location.h.g.e();
      String str = Jni.encodeTp4(this.b);
      this.b = null;
      if (this.a == null) {
        this.a = m.b();
      }
      this.k.put("bloc", str);
      if (this.a != null) {
        this.k.put("up", this.a);
      }
      str = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.k.put("trtm", str);
    }
    
    public void a(String paramString)
    {
      this.b = paramString;
      c(com.baidu.location.h.g.f);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null))
      {
        for (;;)
        {
          try
          {
            localObject1 = this.j;
            f.c = (String)localObject1;
            com.baidu.location.d.f.a().a("receive net result = " + (String)localObject1);
          }
          catch (Exception localException2)
          {
            Object localObject1;
            localMessage = f.this.d.obtainMessage(63);
            localMessage.obj = "HttpStatus error";
            localMessage.sendToTarget();
            continue;
            Object localObject2 = f.this.d.obtainMessage(21);
            ((Message)localObject2).obj = localMessage;
            ((Message)localObject2).sendToTarget();
            continue;
          }
          try
          {
            localObject2 = new BDLocation((String)localObject1);
            if (((BDLocation)localObject2).getLocType() == 161) {
              e.a().a((String)localObject1);
            }
            ((BDLocation)localObject2).setOperators(b.a().h());
            localObject1 = localObject2;
            if (i.a().g())
            {
              ((BDLocation)localObject2).setDirection(i.a().i());
              localObject1 = localObject2;
            }
          }
          catch (Exception localException1)
          {
            localBDLocation = new BDLocation();
            localBDLocation.setLocType(0);
          }
        }
        this.a = null;
        if ((((BDLocation)localObject1).getLocType() == 0) && (((BDLocation)localObject1).getLatitude() == Double.MIN_VALUE) && (((BDLocation)localObject1).getLongitude() == Double.MIN_VALUE))
        {
          localObject1 = f.this.d.obtainMessage(63);
          ((Message)localObject1).obj = "HttpStatus error";
          ((Message)localObject1).sendToTarget();
        }
      }
      for (;;)
      {
        if (this.k != null) {
          this.k.clear();
        }
        return;
        BDLocation localBDLocation;
        Message localMessage = f.this.d.obtainMessage(63);
        localMessage.obj = "HttpStatus error";
        localMessage.sendToTarget();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */