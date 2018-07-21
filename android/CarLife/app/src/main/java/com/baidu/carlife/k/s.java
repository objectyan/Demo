package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import com.baidu.carlife.model.p;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends e
{
  private p a;
  private String b;
  
  public s()
  {
    this.tag = s.class.getSimpleName();
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public p b()
  {
    return this.a;
  }
  
  protected String getUrl()
  {
    return f.a(f.a.e);
  }
  
  protected d getUrlParams()
  {
    d locald = new d();
    locald.put("channel_number", this.b);
    locald.put("version", "2");
    return locald;
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if ((paramString == null) || (!paramString.has("logo_name")) || (!paramString.has("logo_imageurl"))) {
      return -1;
    }
    this.a = new p();
    this.a.a = paramString.optString("logo_imageurl");
    this.a.b = paramString.optString("logo_name");
    this.a.c = paramString.optString("create_time");
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */