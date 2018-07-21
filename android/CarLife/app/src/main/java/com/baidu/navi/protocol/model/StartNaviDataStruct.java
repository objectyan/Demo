package com.baidu.navi.protocol.model;

public class StartNaviDataStruct
  extends DataStruct
{
  public static final String KEY_USE_CAR_GPS = "useCarGPS";
  public boolean useCarGPS = false;
  
  public StartNaviDataStruct()
  {
    this.mCmd = "startNavi";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/StartNaviDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */