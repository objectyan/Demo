package com.baidu.navi.protocol.model;

public class GetMapScaleDataStruct
  extends DataStruct
{
  public static final String KEY_MAP_SCALE_DIS = "scaleDis";
  public static final String KEY_MAP_SCALE_LEVEL = "scaleLevel";
  
  public GetMapScaleDataStruct()
  {
    this.mCmd = "getMapScale";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/GetMapScaleDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */