package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.i;
import com.google.gson.Gson;

public class CLGetSongListReq
  extends CLRequest
{
  private static final String TAG = CLGetSongListReq.class.getSimpleName();
  public int pn;
  public int rn;
  public String songListId;
  public int version = 1;
  
  public static CLGetSongListReq fromJson(String paramString)
  {
    try
    {
      paramString = (CLGetSongListReq)new Gson().fromJson(paramString, CLGetSongListReq.class);
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
    return 2;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/request/CLGetSongListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */