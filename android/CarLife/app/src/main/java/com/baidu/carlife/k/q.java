package com.baidu.carlife.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import com.baidu.carlife.model.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends com.baidu.carlife.k.a.e
{
  private List<j> a;
  private String b;
  
  public q(Context paramContext)
  {
    this.tag = q.class.getSimpleName();
  }
  
  public List<j> a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  protected String getUrl()
  {
    return f.a(f.a.a);
  }
  
  protected d getUrlParams()
  {
    d locald = new d();
    locald.put("cl_platform", "android");
    locald.put("cl_app_version", com.baidu.carlife.core.e.g());
    locald.put("cl_sdk_version", "1.0");
    locald.put("cl_device_id", com.baidu.carlife.core.e.b());
    locald.put("cl_width", String.valueOf(com.baidu.carlife.core.e.d()));
    locald.put("cl_height", String.valueOf(com.baidu.carlife.core.e.e()));
    locald.put("cl_system_version", com.baidu.carlife.core.e.i());
    locald.put("cl_device_type", com.baidu.carlife.core.e.j());
    return locald;
  }
  
  protected void responseErrorCallBack(int paramInt)
  {
    super.responseErrorCallBack(paramInt);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {}
    JSONArray localJSONArray;
    int j;
    do
    {
      do
      {
        return -3;
        localJSONArray = new JSONArray(paramString);
      } while (localJSONArray == null);
      j = localJSONArray.length();
    } while (j < 1);
    this.b = paramString;
    this.a = new ArrayList();
    int i = 0;
    if (i < j)
    {
      paramString = localJSONArray.optJSONObject(i);
      if (paramString == null) {}
      for (;;)
      {
        i += 1;
        break;
        j localj = new j();
        localj.i = paramString.optString("sdk_address");
        localj.h = paramString.optString("appid");
        localj.g = paramString.optInt("app_type");
        localj.k = paramString.optString("app_description");
        localj.m = paramString.optString("sdk_name");
        localj.n = paramString.optString("akey");
        localj.l = paramString.optString("app_name");
        localj.j = paramString.optString("app_icon_address");
        localj.c = (i + 3);
        this.a.add(localj);
      }
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */