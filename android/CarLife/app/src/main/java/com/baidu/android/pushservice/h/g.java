package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends m
{
  private static g e = null;
  private String c = "LbsSender";
  private f d = null;
  
  private g(Context paramContext)
  {
    super(paramContext);
    this.b = "https://lbsonline.pushct.baidu.com/lbsupload";
  }
  
  public static g a(Context paramContext)
  {
    if (e == null) {
      e = new g(paramContext);
    }
    return e;
  }
  
  String a(boolean paramBoolean)
  {
    return com.baidu.android.pushservice.j.g.a(this.a, paramBoolean);
  }
  
  public void a(f paramf)
  {
    this.d = paramf;
  }
  
  void a(String paramString)
  {
    com.baidu.android.pushservice.j.g.a(this.a, System.currentTimeMillis());
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("lbsInfo"))
      {
        paramString = paramString.optJSONObject("lbsInfo");
        if (paramString != null)
        {
          paramString = com.baidu.android.pushservice.j.g.a(this.a, paramString);
          if ((this.d != null) && (!TextUtils.isEmpty(paramString)))
          {
            this.d.a(0, paramString);
            this.d = null;
          }
        }
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = null;
        continue;
        paramString = null;
      }
    }
  }
  
  void a(String paramString, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("method", "uploadGeo");
    paramHashMap.put("data", paramString);
  }
  
  boolean a()
  {
    return true;
  }
  
  boolean b()
  {
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */