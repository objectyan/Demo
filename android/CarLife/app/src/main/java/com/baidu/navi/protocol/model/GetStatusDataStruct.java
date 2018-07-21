package com.baidu.navi.protocol.model;

public class GetStatusDataStruct
  extends DataStruct
{
  public static final String KEY_END_ADDR = "end";
  public static final String KEY_IS_NAVI_BEGIN = "isNaviBegin";
  public static final String KEY_START_ADDR = "start";
  
  public GetStatusDataStruct()
  {
    this.mCmd = "getStatus";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/GetStatusDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */