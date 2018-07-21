package com.baidu.navi.protocol.model;

public class GetFavoriteAsFileDataStruct
  extends DataStruct
{
  public static String KEY_FAVFILEPATH = "favFilePath";
  public static String KEY_FAVNUM = "favNum";
  public String mFavFile;
  public int mFavNum;
  
  public GetFavoriteAsFileDataStruct()
  {
    this.mCmd = "getFavoriteAsFile";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/GetFavoriteAsFileDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */