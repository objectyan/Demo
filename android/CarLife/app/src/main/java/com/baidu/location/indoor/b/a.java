package com.baidu.location.indoor.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.baidu.location.f;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class a
  extends e
{
  private static a p = null;
  private String a = null;
  private String b;
  private String c;
  private String d;
  private SharedPreferences e;
  private Handler f = null;
  
  private a()
  {
    this.k = new HashMap();
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString2 = new File(paramString2);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    try
    {
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte['က'];
      paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString1.getInputStream());
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString1.disconnect();
      paramString2.close();
      localBufferedInputStream.close();
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  static a b()
  {
    if (p == null) {
      p = new a();
    }
    return p;
  }
  
  private Handler d()
  {
    return this.f;
  }
  
  private boolean e()
  {
    if ((this.c == null) || (this.a == null)) {}
    Object localObject;
    do
    {
      return false;
      localObject = g.l() + File.separator + "download" + File.separator + this.a;
      localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    } while (!a(this.c, (String)localObject + File.separator + "data.zip"));
    File localFile = new File(g.l() + File.separator + "indoorinfo" + File.separator + this.a + "/");
    if (localFile.exists())
    {
      localFile.delete();
      localFile.mkdirs();
    }
    for (;;)
    {
      try
      {
        String str = g.l() + File.separator + "indoorinfo" + File.separator + this.a + "/";
        new d().a((String)localObject + File.separator + "data.zip", str);
        localObject = this.e.edit();
        ((SharedPreferences.Editor)localObject).putString("indoor_roadnet_" + this.a, this.d);
        ((SharedPreferences.Editor)localObject).commit();
        b.a().b();
        return true;
      }
      catch (Exception localException)
      {
        localFile.delete();
      }
      localFile.mkdirs();
    }
    return false;
  }
  
  public void a()
  {
    this.k.clear();
    this.k.put("bldg", this.a);
    this.k.put("vernum", this.b);
    this.k.put("mb", Build.MODEL);
    this.k.put("cuid", com.baidu.location.h.b.a().b);
    this.h = "http://loc.map.baidu.com/apigetindoordata.php";
  }
  
  void a(String paramString)
  {
    this.e = PreferenceManager.getDefaultSharedPreferences(f.getServiceContext());
    this.a = paramString;
    this.b = this.e.getString("indoor_roadnet_" + paramString, "null");
    d().postDelayed(new Runnable()
    {
      public void run()
      {
        a.this.i();
      }
    }, 1000L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.j);
      int i = localJSONObject.getInt("error");
      if (i == 0)
      {
        this.c = localJSONObject.getString("downloadlink");
        if (localJSONObject.has("vernum")) {
          this.d = localJSONObject.getString("vernum");
        }
        d().post(new Runnable()
        {
          public void run()
          {
            a.a(a.this);
          }
        });
      }
      if (i == 1) {
        b.a().b();
      }
      if (i == -1) {}
      while (i != -2) {
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void c()
  {
    SharedPreferences.Editor localEditor = this.e.edit();
    localEditor.putString("indoor_roadnet_" + this.a, "0");
    localEditor.commit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */