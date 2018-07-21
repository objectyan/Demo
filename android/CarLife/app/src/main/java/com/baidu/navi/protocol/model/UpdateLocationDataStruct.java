package com.baidu.navi.protocol.model;

public class UpdateLocationDataStruct
  extends DataStruct
{
  public static final String KEY_ACCURACY = "accuracy";
  public static final String KEY_ALTITUDE = "altitude";
  public static final String KEY_BEARING = "bearing";
  public static final String KEY_LATITUDE = "latitude";
  public static final String KEY_LONGITUDE = "longitude";
  public static final String KEY_SATELLITES = "satellites";
  public static final String KEY_SPEED = "speed";
  public float accuracy;
  public double altitude;
  public float bearing;
  public double latitude;
  public double longitude;
  public int satellites;
  public float speed;
  
  public UpdateLocationDataStruct()
  {
    this.mCmd = "updateLocation";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/UpdateLocationDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */