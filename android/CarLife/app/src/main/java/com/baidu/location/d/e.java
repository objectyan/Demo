package com.baidu.location.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.baidu.location.Jni;
import com.baidu.location.f.b;
import com.baidu.location.h.g;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class e
{
  private static e b = null;
  SharedPreferences a = null;
  private boolean c = true;
  private int d = 14400000;
  private int e = 10;
  private Map<String, Long> f = null;
  private int g = 0;
  private String h = g.c();
  
  private e()
  {
    if (this.a == null)
    {
      this.a = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0);
      if (this.a != null)
      {
        this.c = this.a.getBoolean("ipLocInfoUpload", true);
        this.d = this.a.getInt("ipValidTime", 14400000);
        this.e = this.a.getInt("ipLocInfoUploadTimesPerDay", 10);
        this.g = this.a.getInt("ipLocInfoUploadTimesPerDayNum", 0);
        this.h = this.a.getString("lastDay", g.c());
      }
    }
  }
  
  public static e a()
  {
    try
    {
      if (b == null) {
        b = new e();
      }
      e locale = b;
      return locale;
    }
    finally {}
  }
  
  private String a(com.baidu.location.f.a parama, com.baidu.location.f.e parame, Location paramLocation, String paramString)
  {
    return Jni.encodeTp4(g.a(parama, parame, paramLocation, paramString));
  }
  
  private void c(String paramString)
  {
    new a(paramString).b();
  }
  
  public void a(String paramString)
  {
    if (!this.c) {}
    while ((paramString == null) || (paramString.length() != 12)) {
      return;
    }
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.f.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public void b(String paramString)
  {
    if (!this.c) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramString == null) || (paramString.length() != 12) || (!com.baidu.location.f.f.j()));
      if (!g.c().equals(this.h))
      {
        this.g = 0;
        this.h = g.c();
        if (this.a != null)
        {
          localObject = this.a.edit();
          ((SharedPreferences.Editor)localObject).putInt("ipLocInfoUploadTimesPerDayNum", this.g);
          ((SharedPreferences.Editor)localObject).putString("lastDay", this.h);
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
    } while (this.g >= this.e);
    int i;
    if (this.f == null)
    {
      this.f = new HashMap();
      this.f.put(paramString, Long.valueOf(System.currentTimeMillis()));
      i = 1;
      label150:
      if (i == 0) {
        break label384;
      }
      this.g += 1;
      if (this.a != null)
      {
        paramString = this.a.edit();
        paramString.putInt("ipLocInfoUploadTimesPerDayNum", this.g);
        paramString.putString("lastDay", this.h);
        paramString.commit();
      }
      paramString = com.baidu.location.a.a.a().f();
      localObject = paramString + "&ipload=1";
      if (!com.baidu.location.f.f.j()) {
        break label386;
      }
    }
    label384:
    label386:
    for (paramString = "&cn=32";; paramString = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(b.a().e()) }))
    {
      paramString = paramString + (String)localObject;
      c(a(b.a().f(), com.baidu.location.f.f.a().p(), null, paramString));
      return;
      if (this.f.containsKey(paramString))
      {
        if (Math.abs(((Long)this.f.get(paramString)).longValue() - System.currentTimeMillis()) <= this.d)
        {
          i = 0;
          break label150;
        }
        this.f.put(paramString, Long.valueOf(System.currentTimeMillis()));
        i = 1;
        break label150;
      }
      this.f.put(paramString, Long.valueOf(System.currentTimeMillis()));
      i = 1;
      break label150;
      break;
    }
  }
  
  private class a
    extends com.baidu.location.h.e
  {
    private String b;
    
    public a(String paramString)
    {
      this.b = paramString;
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = g.e();
      this.k.put("up", this.b);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      this.k.clear();
    }
    
    public void b()
    {
      c(g.f);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */