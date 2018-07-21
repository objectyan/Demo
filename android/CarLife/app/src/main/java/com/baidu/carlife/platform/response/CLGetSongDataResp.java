package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.i;
import com.baidu.carlife.platform.model.CLSongData;
import com.google.gson.Gson;

public class CLGetSongDataResp
  extends CLResponse
{
  private static final String TAG = CLGetSongDataResp.class.getSimpleName();
  public CLSongData songData;
  
  public static CLGetSongDataResp fromJson(String paramString)
  {
    try
    {
      paramString = (CLGetSongDataResp)new Gson().fromJson(paramString, CLGetSongDataResp.class);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/response/CLGetSongDataResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */