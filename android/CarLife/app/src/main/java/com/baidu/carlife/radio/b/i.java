package com.baidu.carlife.radio.b;

import com.baidu.carlife.d.a.e;
import com.baidu.carlife.radio.b.a.a;
import java.util.Map;

public class i
  extends a
{
  public String a()
  {
    return com.baidu.carlife.radio.b.a.c.j();
  }
  
  public void a(int paramInt, String paramString)
  {
    com.baidu.carlife.core.i.c("radio_request", "statusCode = " + paramInt + "; response=" + paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.baidu.carlife.core.i.e("radio_request", "error = " + paramString2);
  }
  
  protected void a(String paramString, Map<String, String> paramMap, com.baidu.carlife.d.a.c paramc)
  {
    e.b(paramString, paramMap, paramc);
  }
  
  public void a(Map<String, String> paramMap) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */