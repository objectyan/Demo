package com.baidu.carlife.k;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.e.a;
import com.baidu.carlife.e.a.a;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import com.baidu.carlife.util.h;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.baidu.carlife.k.a.e
{
  private a.a a;
  
  public c(a.a parama)
  {
    this.tag = "ConfigRequest";
    this.a = parama;
  }
  
  protected String getUrl()
  {
    return f.a(f.a.g);
  }
  
  protected d getUrlParams()
  {
    d locald = new d();
    locald.put("appversioncode", String.valueOf(com.baidu.carlife.core.e.h()));
    locald.put("appversionname", com.baidu.carlife.core.e.g());
    return locald;
  }
  
  protected void responseErrorCallBack(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    i.b(this.tag, "ConfigRequest responseSuccessCallBack :" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject(paramString).optJSONObject("results");
      if (paramString != null)
      {
        h.a(a.c(), paramString.toString());
        if (this.a != null) {
          this.a.a();
        }
      }
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */