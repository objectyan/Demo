package com.baidu.location.d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
{
  private static Object a = new Object();
  private static f b = null;
  private SharedPreferences c = null;
  private String d = null;
  private String e = null;
  private b f = null;
  private String g = "0";
  private int h = 1;
  
  public f()
  {
    if (this.c == null)
    {
      this.c = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePreSlam", 0);
      if (this.c != null)
      {
        this.d = this.c.getString("lastDay", "null");
        this.e = this.c.getString("slamconfig", "null");
        if ((this.e == null) || (this.e.equals("null"))) {}
      }
    }
    try
    {
      this.f = new b(new String(Base64.decode(this.e.getBytes())));
      if ((this.f != null) && (this.f.b > 0)) {
        this.g = ("" + this.f.b);
      }
      return;
    }
    catch (Exception localException)
    {
      this.f = null;
    }
  }
  
  public static f a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      return localf;
    }
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {
      this.c = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePreSlam", 0);
    }
    if (this.c != null)
    {
      localObject = this.c.getString("collectDay", "null");
      if (((String)localObject).equals("null"))
      {
        localObject = this.c.edit();
        ((SharedPreferences.Editor)localObject).putString("collectDay", paramString);
        ((SharedPreferences.Editor)localObject).putInt("collectTime", 1);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      return;
    }
    if (((String)localObject).equals(paramString))
    {
      int i = this.c.getInt("collectTime", 1);
      paramString = this.c.edit();
      paramString.putInt("collectTime", i + 1);
      paramString.commit();
      return;
    }
    Object localObject = this.c.edit();
    ((SharedPreferences.Editor)localObject).putString("collectDay", paramString);
    ((SharedPreferences.Editor)localObject).putInt("collectTime", 1);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public int b(String paramString)
  {
    if (this.c == null) {
      this.c = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePreSlam", 0);
    }
    String str;
    if (this.c != null)
    {
      str = this.c.getString("collectDay", "null");
      if (!str.equals("null")) {
        break label52;
      }
    }
    label52:
    while (!str.equals(paramString)) {
      return 0;
    }
    return this.c.getInt("collectTime", 1);
  }
  
  public b b()
  {
    if ((this.f != null) && (this.f.b > 0)) {
      return this.f;
    }
    return null;
  }
  
  public void c(String paramString)
  {
    if (!g.c().equals(this.d))
    {
      this.d = g.c();
      if (this.c != null)
      {
        SharedPreferences.Editor localEditor = this.c.edit();
        localEditor.putString("lastDay", this.d);
        localEditor.commit();
      }
      new d(null).a(paramString);
    }
  }
  
  public class a
  {
    public int a = 0;
    public List<f.c> b = new ArrayList();
    public int c = 1;
    public int d = 1;
    public int e = 15;
    public int f = 10;
    public double g = 0.699999988079071D;
    public double h = 0.05000000074505806D;
    
    a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.b.isEmpty()))
      {
        this.b.add(new f.c(f.this, 11, 13));
        this.b.add(new f.c(f.this, 17, 19));
      }
    }
    
    public void a() {}
    
    public boolean a(JSONObject paramJSONObject)
    {
      try
      {
        if (paramJSONObject.has("level")) {
          this.a = paramJSONObject.getInt("level");
        }
        if (paramJSONObject.has("electricity_uplimit")) {
          this.g = paramJSONObject.getDouble("electricity_uplimit");
        }
        if (paramJSONObject.has("electricity_downlimit")) {
          this.h = paramJSONObject.getDouble("electricity_downlimit");
        }
        if (paramJSONObject.has("collect_times_limit"))
        {
          this.c = paramJSONObject.getInt("collect_times_limit");
          if (this.c > f.c(f.this)) {
            f.a(f.this, this.c);
          }
        }
        if (paramJSONObject.has("trace_duration")) {
          this.d = paramJSONObject.getInt("trace_duration");
        }
        if (paramJSONObject.has("stop_check_window")) {
          this.e = paramJSONObject.getInt("stop_check_window");
        }
        if (paramJSONObject.has("area_check_interval")) {
          this.f = paramJSONObject.getInt("area_check_interval");
        }
        boolean bool = paramJSONObject.has("alowed_time_slots");
        if (bool) {}
        int k;
        int j;
        String[] arrayOfString;
        return false;
      }
      catch (Exception paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("alowed_time_slots");
          k = paramJSONObject.length();
          j = 0;
          while (j < k)
          {
            arrayOfString = paramJSONObject.getString(j).split("-");
            if (arrayOfString.length == 2) {
              this.b.add(new f.c(f.this, Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1])));
            }
            j += 1;
          }
          a();
          return true;
        }
        catch (Exception paramJSONObject) {}
        paramJSONObject = paramJSONObject;
        return false;
      }
    }
  }
  
  public class b
  {
    public Map<String, f.a> a = null;
    public int b = 0;
    public Map<String, String> c = new HashMap();
    
    b(String paramString)
    {
      for (;;)
      {
        int i;
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString.has("result"))
          {
            paramString = paramString.getJSONObject("result");
            if (paramString.has("version")) {
              this.b = paramString.getInt("version");
            }
            Object localObject;
            int j;
            if (paramString.has("collect_conf"))
            {
              localObject = paramString.getJSONArray("collect_conf");
              j = ((JSONArray)localObject).length();
              i = 0;
              if (i < j)
              {
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
                f.a locala = new f.a(f.this, false);
                if (!locala.a(localJSONObject)) {
                  break label323;
                }
                if (this.a == null) {
                  this.a = new HashMap();
                }
                this.a.put("" + locala.a, locala);
                break label323;
              }
            }
            if (paramString.has("celllist_to_conf"))
            {
              this$1 = paramString.getJSONArray("celllist_to_conf");
              int k = f.this.length();
              i = 0;
              if (i < k)
              {
                localObject = f.this.getJSONObject(i);
                if ((((JSONObject)localObject).has("level")) && (((JSONObject)localObject).has("cell_list")))
                {
                  paramString = ((JSONObject)localObject).getString("level");
                  localObject = ((JSONObject)localObject).getJSONArray("cell_list");
                  int m = ((JSONArray)localObject).length();
                  j = 0;
                  if (j < m)
                  {
                    this.c.put(((JSONArray)localObject).getString(j), paramString);
                    j += 1;
                    continue;
                  }
                }
                i += 1;
                continue;
              }
            }
          }
          return;
        }
        catch (Exception this$1)
        {
          this.b = 0;
        }
        label323:
        i += 1;
      }
    }
  }
  
  public class c
  {
    public final int a;
    public final int b;
    
    c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      a();
    }
    
    private void a() {}
  }
  
  private class d
    extends e
  {
    String a = null;
    
    private d() {}
    
    public void a()
    {
      this.h = "http://loc.map.baidu.com/slamconfig.php?";
      this.h = String.format(Locale.CHINESE, "%scuid=%s&mb=%s&msdk=12&version=%s&cityid=%s", new Object[] { this.h, b.a().b(), "" + Build.MODEL.replace(" ", "_"), f.a(f.this), this.a });
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
      h();
    }
    
    public void a(boolean paramBoolean)
    {
      if ((this.j == null) || ((paramBoolean) && (this.j != null) && (this.j.length() > 30) && (f.b(f.this) != null)))
      {
        SharedPreferences.Editor localEditor = f.b(f.this).edit();
        localEditor.putString("slamconfig", this.j);
        localEditor.commit();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */