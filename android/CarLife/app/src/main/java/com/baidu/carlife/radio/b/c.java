package com.baidu.carlife.radio.b;

import com.baidu.carlife.core.i;
import com.baidu.carlife.radio.b.a.a;
import com.baidu.carlife.radio.c.b;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends a
{
  public String a()
  {
    return com.baidu.carlife.radio.b.a.c.c();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.c("radio_request", "statusCode=" + paramInt);
    try
    {
      if (new JSONObject(paramString).getInt("errno") == 0) {
        b.a().d(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    i.e("radio_request", "error=" + paramString2);
  }
  
  public void a(Map<String, String> paramMap) {}
  
  public Map<String, String> b()
  {
    return null;
  }
  
  public void c()
  {
    boolean bool = b.a().f();
    i.c("radio_request", "isCacheValid = " + bool);
    if (!bool) {
      super.c();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */