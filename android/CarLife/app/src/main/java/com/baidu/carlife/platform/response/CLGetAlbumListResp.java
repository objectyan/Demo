package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.i;
import com.baidu.carlife.platform.model.CLAlbum;
import com.google.gson.Gson;
import java.util.ArrayList;

public class CLGetAlbumListResp
  extends CLResponse
{
  private static final String TAG = CLGetAlbumListResp.class.getSimpleName();
  public ArrayList<CLAlbum> albumList;
  
  public static CLGetAlbumListResp fromJson(String paramString)
  {
    try
    {
      paramString = (CLGetAlbumListResp)new Gson().fromJson(paramString, CLGetAlbumListResp.class);
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
    return 1;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/response/CLGetAlbumListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */