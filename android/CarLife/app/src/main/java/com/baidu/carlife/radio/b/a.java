package com.baidu.carlife.radio.b;

import com.baidu.carlife.core.e;
import com.baidu.carlife.radio.c.b;
import com.baidu.navi.util.StatisticManager;

public abstract class a
  extends com.baidu.carlife.radio.b.a.a
{
  public abstract void a(l paraml);
  
  void a(String paramString)
  {
    if (e.s() != 0)
    {
      StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
      if (paramString == null) {
        break label77;
      }
      paramString = b.a().c(paramString);
      if (paramString != null) {
        StatisticManager.onEvent(paramString.d() + "_REQ", paramString.b() + "请求次数");
      }
    }
    return;
    label77:
    StatisticManager.onEvent("CONTENT_REC_0011_REQ", "语音点播请求次数");
  }
  
  void f_()
  {
    a(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */