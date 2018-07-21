package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.i;
import com.baidu.carlife.platform.model.CLSong;
import com.google.gson.Gson;
import java.util.ArrayList;

public class CLGetSongListResp
  extends CLResponse
{
  private static final String TAG = CLGetSongListResp.class.getSimpleName();
  public String playSongId;
  public int pn;
  public int rn;
  public ArrayList<CLSong> songList;
  public String songListId;
  public int total;
  public int version = 1;
  
  public static CLGetSongListResp fromJson(String paramString)
  {
    try
    {
      paramString = (CLGetSongListResp)new Gson().fromJson(paramString, CLGetSongListResp.class);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/response/CLGetSongListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */