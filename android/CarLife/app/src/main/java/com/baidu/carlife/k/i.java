package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f.c;
import com.baidu.carlife.logic.h;
import com.baidu.carlife.util.k;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends e
{
  private String a;
  private String b;
  private int c;
  private int d;
  private int e;
  private com.baidu.carlife.model.f f;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.tag = i.class.getSimpleName();
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt1;
  }
  
  public com.baidu.carlife.model.f a()
  {
    return this.f;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("token", "76646ec3a3d2c05957a44f59bf4978c76ab80b92");
    locald.put("sid", this.b);
    locald.put("m", this.a);
    locald.put("p", String.valueOf(this.c));
    locald.put("type", String.valueOf(this.d));
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    locald.put("orderid", str);
    locald.put("t", str);
    locald.put("sn", k.a(str + "baiduCarlife"));
    return locald;
  }
  
  protected String getUrl()
  {
    return com.baidu.carlife.k.a.f.a(f.c.c);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    if (new JSONObject(paramString).optJSONObject("result") == null) {
      return -1;
    }
    h.c = true;
    h.a.put(this.b, Integer.valueOf(this.e));
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */