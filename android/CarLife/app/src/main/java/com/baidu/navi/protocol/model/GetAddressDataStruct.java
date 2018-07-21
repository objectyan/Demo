package com.baidu.navi.protocol.model;

public class GetAddressDataStruct
  extends DataStruct
{
  public static final String KEY_COMPANY = "company";
  public static final String KEY_HOME = "home";
  
  public GetAddressDataStruct()
  {
    this.mCmd = "getHomeAndCompany";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/GetAddressDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */