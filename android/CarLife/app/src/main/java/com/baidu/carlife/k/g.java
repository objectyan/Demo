package com.baidu.carlife.k;

import android.text.TextUtils;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.c;
import com.baidu.carlife.util.k;
import com.baidu.carlife.util.w;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends e
{
  public String a;
  public String b;
  
  public g(String paramString1, String paramString2)
  {
    this.tag = g.class.getSimpleName();
    this.a = paramString1;
    this.b = paramString2;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("token", "76646ec3a3d2c05957a44f59bf4978c76ab80b92");
    locald.put("orderid", this.a);
    locald.put("serialid", this.b);
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    locald.put("t", str);
    locald.put("sn", k.a(str + "baiduCarlife"));
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a(f.c.e);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString).optJSONObject("result");
    if (paramString == null) {
      return -1;
    }
    paramString = paramString.optString("msg");
    if (!TextUtils.isEmpty(paramString)) {
      w.a(paramString, 0);
    }
    com.baidu.carlife.logic.h.c = true;
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */