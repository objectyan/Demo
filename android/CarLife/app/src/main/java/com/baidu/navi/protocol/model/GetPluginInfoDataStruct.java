package com.baidu.navi.protocol.model;

public class GetPluginInfoDataStruct
  extends DataStruct
{
  public static final String KEY_DETAIL = "detail";
  public static final String KEY_IS_RUNNING = "isRunning";
  public static final String KEY_NAME = "name";
  public static final String KEY_PLUGIN_ID = "pluginId";
  public static final String KEY_SUMMARY = "summary";
  public static final String KEY_VERSION = "version";
  public int pluginId;
  
  public GetPluginInfoDataStruct()
  {
    this.mCmd = "getPluginInfo";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/GetPluginInfoDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */