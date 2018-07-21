package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.i;
import com.google.gson.Gson;

public class CLUnsupportAPIResp
  extends CLResponse
{
  private static final String TAG = CLUnsupportAPIResp.class.getSimpleName();
  
  public CLUnsupportAPIResp() {}
  
  public CLUnsupportAPIResp(long paramLong)
  {
    this.errorNo = 1;
    this.errorMsg = "unsupport api";
    this.requestId = paramLong;
  }
  
  public static CLUnsupportAPIResp fromJson(String paramString)
  {
    try
    {
      paramString = (CLUnsupportAPIResp)new Gson().fromJson(paramString, CLUnsupportAPIResp.class);
      return paramString;
    }
    catch (Exception paramString)
    {
      i.a(TAG, paramString);
    }
    return null;
  }
  
  public int getResponseType()
  {
    return 0;
  }
  
  public String toJson()
  {
    try
    {
      String str = new Gson().toJson(this);
      return str;
    }
    catch (Exception localException)
    {
      i.a(TAG, localException);
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/response/CLUnsupportAPIResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */