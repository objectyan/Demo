package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f.c;
import com.baidu.carlife.util.k;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends com.baidu.carlife.k.a.e
{
  private com.baidu.carlife.model.e a;
  private String b;
  
  public f(String paramString, com.baidu.carlife.model.e parame)
  {
    this.tag = f.class.getSimpleName();
    this.a = parame;
    this.b = paramString;
  }
  
  public com.baidu.carlife.model.e a()
  {
    return this.a;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("token", "76646ec3a3d2c05957a44f59bf4978c76ab80b92");
    locald.put("sid", this.b);
    long l = System.currentTimeMillis() / 1000L;
    locald.put("t", String.valueOf(l));
    locald.put("sn", k.a(l + "baiduCarlife"));
    return locald;
  }
  
  protected String getUrl()
  {
    return com.baidu.carlife.k.a.f.a(f.c.b);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString).optJSONObject("result");
    if (paramString == null) {
      return -1;
    }
    this.a = com.baidu.carlife.model.e.a(this.a, paramString);
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */