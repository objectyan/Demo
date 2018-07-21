package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import org.json.JSONException;

public class r
  extends e
{
  private boolean a = false;
  private String b;
  
  public r(String paramString)
  {
    this.tag = r.class.getSimpleName();
    this.b = paramString;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  protected String getUrl()
  {
    return f.a(f.a.f);
  }
  
  protected d getUrlParams()
  {
    d locald = new d();
    locald.put("channel_number", this.b);
    return locald;
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    this.a = false;
    if ("1".equals(paramString)) {
      this.a = true;
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */