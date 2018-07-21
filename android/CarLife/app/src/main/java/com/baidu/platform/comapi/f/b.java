package com.baidu.platform.comapi.f;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static String a = "bsdiff";
  public String b;
  public String c;
  public int d;
  public String e;
  public int f;
  public int g;
  public String h;
  public String i;
  public int j;
  public int k;
  public boolean l = true;
  public String m;
  public String n;
  public int o;
  public String p;
  public boolean q = false;
  
  public b a(Bundle paramBundle)
  {
    boolean bool = true;
    paramBundle = paramBundle.getString("ret");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.b = paramBundle.optString("oem");
      this.e = paramBundle.optString("file");
      this.h = paramBundle.optString("md5sum");
      this.i = paramBundle.optString("desc");
      this.c = paramBundle.optString("verson");
      this.d = paramBundle.optInt("timestamp");
      this.f = paramBundle.optInt("frag_num");
      this.g = paramBundle.optInt("filesize");
      this.j = paramBundle.optInt("interval");
      this.k = paramBundle.optInt("force");
      this.p = paramBundle.optString("google_play");
      int i1;
      if (paramBundle.has("diffup"))
      {
        JSONArray localJSONArray = paramBundle.getJSONArray("diffup");
        if (localJSONArray.length() > 0)
        {
          int i2 = localJSONArray.length();
          i1 = 0;
          if (i1 < i2)
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
            if (!TextUtils.equals(localJSONObject.optString("type"), a)) {
              break label251;
            }
            this.n = localJSONObject.optString("md5sum");
            this.m = localJSONObject.optString("file");
            this.o = localJSONObject.optInt("filesize");
          }
        }
      }
      if (paramBundle.optInt("JNIDownLoad") != 1) {}
      for (;;)
      {
        this.l = bool;
        this.q = true;
        return this;
        label251:
        i1 += 1;
        break;
        bool = false;
      }
      return this;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      this.q = false;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.m)) && (!TextUtils.isEmpty(this.n)) && (this.o > 0);
  }
  
  public boolean b()
  {
    return !TextUtils.isEmpty(this.p);
  }
  
  public Intent c()
  {
    return new Intent("android.intent.action.VIEW", Uri.parse(this.p));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */