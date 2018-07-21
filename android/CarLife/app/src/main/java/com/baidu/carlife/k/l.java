package com.baidu.carlife.k;

import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends e
{
  public l()
  {
    this.tag = "OpenNaviRequest导航开关";
  }
  
  protected String getUrl()
  {
    return f.a(f.a.d);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    boolean bool = true;
    if (new JSONObject(paramString).optInt("open_flag", 0) == 1) {}
    for (;;)
    {
      com.baidu.carlife.core.f.jr = bool;
      return 0;
      bool = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */