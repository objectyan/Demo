package com.baidu.navi.protocol.model;

public class UpdateDeviceStatusDataStruct
  extends DataStruct
{
  public static final String DEVICE_GPS = "GPS";
  public static final String KEY_DEVICE = "device";
  public static final String KEY_ENABLED = "enabled";
  public String device;
  public boolean enabled = false;
  
  public UpdateDeviceStatusDataStruct()
  {
    this.mCmd = "updateDeviceStatus";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/UpdateDeviceStatusDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */