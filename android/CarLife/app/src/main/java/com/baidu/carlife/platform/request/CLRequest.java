package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.i;
import com.google.gson.Gson;

public abstract class CLRequest
{
  public static final int REQUEST_GET_ALBUM_LIST = 1;
  public static final int REQUEST_GET_SONG_DATA = 3;
  public static final int REQUEST_GET_SONG_LIST = 2;
  private static final String TAG = CLRequest.class.getSimpleName();
  public long requestId = System.currentTimeMillis();
  
  public static CLRequest fromJson(String paramString)
  {
    try
    {
      paramString = (CLRequest)new Gson().fromJson(paramString, CLRequest.class);
      return paramString;
    }
    catch (Exception paramString)
    {
      i.a(TAG, paramString);
    }
    return null;
  }
  
  public abstract int getRequestType();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/request/CLRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */