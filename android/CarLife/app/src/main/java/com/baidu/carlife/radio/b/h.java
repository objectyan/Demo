package com.baidu.carlife.radio.b;

import com.baidu.carlife.core.i;
import com.baidu.carlife.radio.b.a.a;
import com.baidu.carlife.radio.b.a.c;
import java.util.Map;

public class h
  extends a
{
  public String a()
  {
    return c.i();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.c("radio_request", "statusCode = " + paramInt + "; response=" + paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    i.e("radio_request", "error = " + paramString2);
  }
  
  public void a(Map<String, String> paramMap) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */