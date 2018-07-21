package com.baidu.carlife.e;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.carlife.core.d;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.k.c;
import com.baidu.carlife.util.h;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = "ConfigManager";
  private static final String b = "carlife.config";
  private static final String c = "screenadapt.config";
  private static final String d = "KEY_HOME_FOUND_ETCP_STRING";
  private static final String e = "KEY_HOME_FOUND_ETCP_OPEN_BOOL";
  private static final String f = "289,131,340,132";
  private static final String g = "KEY_HOME_FOUND_BOOK_STRING";
  private static final String h = "KEY_HOME_FOUND_BOOK_OPEN_BOOL";
  private static final String i = "340";
  private static final String j = "KEY_HOME_FOUND_JYB_OPEN_BOOL";
  private static final String k = "KEY_TRACK_UPLOAD_GPS_FILE_OPEN";
  private static final String l = "KEY_INTERNAL_SCREEN_BLACK_LIST";
  private static final String m = "{\"HUAWEI\":{\"HUAWEI P6-T00\":\"19\"},\"samsung\":{\"SM-A8000\":\"22\"}}";
  private static a q = new a();
  private boolean n = false;
  private boolean o = false;
  private JSONObject p = new JSONObject();
  
  private a()
  {
    o();
  }
  
  public static a a()
  {
    return q;
  }
  
  public static String c()
  {
    File localFile = new File(com.baidu.carlife.core.a.a().getFilesDir(), "carlife.config");
    i.b("ConfigManager", "ConfigFilePath: " + localFile.exists());
    return localFile.getPath();
  }
  
  private void o()
  {
    String str = h.b(c());
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i.b("ConfigManager", "loadData=" + str);
      this.p = new JSONObject(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void b()
  {
    j();
    l();
    com.baidu.carlife.core.b.a.a(this.n);
    new c(new a()
    {
      public void a()
      {
        i.b("ConfigManager", "onSuccess()");
        a.a(a.this);
        a.this.j();
        a.this.k();
        a.this.l();
        com.baidu.carlife.core.b.a.a(a.b(a.this));
        k.b(6001);
      }
      
      public void a(int paramAnonymousInt)
      {
        a.this.m();
      }
    }).toGetRequest();
  }
  
  public String d()
  {
    if (this.p != null) {
      return this.p.optString("KEY_HOME_FOUND_ETCP_STRING", "289,131,340,132");
    }
    return "289,131,340,132";
  }
  
  public String e()
  {
    if (this.p != null) {
      return this.p.optString("KEY_HOME_FOUND_BOOK_STRING", "340");
    }
    return "340";
  }
  
  public boolean f()
  {
    boolean bool = false;
    if (this.p != null) {
      bool = this.p.optBoolean("KEY_HOME_FOUND_ETCP_OPEN_BOOL", false);
    }
    return bool;
  }
  
  public boolean g()
  {
    boolean bool = true;
    if (this.p != null) {
      bool = this.p.optBoolean("KEY_HOME_FOUND_BOOK_OPEN_BOOL", true);
    }
    return bool;
  }
  
  public boolean h()
  {
    boolean bool = true;
    if (this.p != null) {
      bool = this.p.optBoolean("KEY_HOME_FOUND_JYB_OPEN_BOOL", true);
    }
    return bool;
  }
  
  public int i()
  {
    int i1 = 1;
    if (this.p != null) {
      i1 = this.p.optInt("KEY_TRACK_UPLOAD_GPS_FILE_OPEN", 1);
    }
    return i1;
  }
  
  public void j()
  {
    JSONObject localJSONObject2;
    Object localObject;
    if (this.p != null)
    {
      localJSONObject2 = this.p.optJSONObject("KEY_INTERNAL_SCREEN_BLACK_LIST");
      localObject = localJSONObject2;
      if (localJSONObject2 != null) {}
    }
    try
    {
      localObject = new JSONObject("{\"HUAWEI\":{\"HUAWEI P6-T00\":\"19\"},\"samsung\":{\"SM-A8000\":\"22\"}}");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONObject(Build.MANUFACTURER);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString(Build.MODEL);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains(Build.VERSION.SDK_INT + "")))
          {
            this.n = true;
            i.e("ConfigManager", "manufacturer=" + Build.MANUFACTURER + ", model=" + Build.MODEL + ", version=" + Build.VERSION.SDK_INT + " not support internal screen capture policy.");
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        JSONObject localJSONObject1 = localJSONObject2;
      }
    }
  }
  
  public void k()
  {
    if (this.p != null) {
      try
      {
        com.baidu.carlife.core.b.a.b();
        JSONArray localJSONArray = this.p.getJSONArray("CHAT_SWITCH");
        int i1 = 0;
        int i2 = localJSONArray.length();
        while (i1 < i2)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          com.baidu.carlife.core.b.a.a locala = new com.baidu.carlife.core.b.a.a();
          locala.a = localJSONObject.optString("vehiclechannel");
          locala.b = localJSONObject.optString("text");
          com.baidu.carlife.core.b.a.a(locala);
          i1 += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void l()
  {
    if (this.p != null) {
      try
      {
        JSONArray localJSONArray = this.p.getJSONArray("KEY_WIDE_SCREEN_HU");
        i.b("ConfigManager", "KEY_WIDE_SCREEN_HU: " + localJSONArray);
        int i1 = 0;
        int i2 = localJSONArray.length();
        while (i1 < i2)
        {
          d.a(localJSONArray.getString(i1));
          i1 += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void m()
  {
    Object localObject1 = new File(com.baidu.carlife.core.a.a().getFilesDir(), "screenadapt.config");
    Object localObject3 = null;
    if (((File)localObject1).exists()) {
      try
      {
        String str = h.b(((File)localObject1).getPath());
        boolean bool = TextUtils.isEmpty(str);
        localObject1 = localObject3;
        if (!bool) {}
        try
        {
          i.b("ConfigManager", "readOfflineScreenAdaptConfig=" + str);
          this.p = new JSONObject(str);
          localObject1 = this.p.getJSONArray("KEY_WIDE_SCREEN_HU");
          if (localObject1 != null)
          {
            i.b("ConfigManager", "KEY_WIDE_SCREEN_HU: " + localObject1);
            int i1 = 0;
            int i2 = ((JSONArray)localObject1).length();
            while (i1 < i2)
            {
              d.a(((JSONArray)localObject1).getString(i1));
              i1 += 1;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            Object localObject2 = localObject3;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void n()
  {
    if ((this.p != null) && (!this.p.toString().isEmpty()))
    {
      i.b("ConfigManager", "Save config: " + this.p.toString());
      h.a(c(), this.p.toString());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */