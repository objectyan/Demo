package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.i;
import com.google.gson.Gson;

public class CLGetSongDataReq
  extends CLRequest
{
  private static final String TAG = CLGetSongDataReq.class.getSimpleName();
  public String songId;
  
  public static CLGetSongDataReq fromJson(String paramString)
  {
    try
    {
      paramString = (CLGetSongDataReq)new Gson().fromJson(paramString, CLGetSongDataReq.class);
      return paramString;
    }
    catch (Exception paramString)
    {
      i.a(TAG, paramString);
    }
    return null;
  }
  
  public int getRequestType()
  {
    return 3;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/request/CLGetSongDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */