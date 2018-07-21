package com.baidu.carlife.custom.elhyf;

import com.loopj.android.http.AsyncHttpClient;

public class a
{
  public static final String a = "http://caronline.yfgps.com";
  static AsyncHttpClient b;
  
  public static AsyncHttpClient a()
  {
    if (b == null)
    {
      b = new AsyncHttpClient();
      b.setMaxRetriesAndTimeout(0, 10000);
    }
    return b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */