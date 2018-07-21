package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocData
  implements Cloneable
{
  public static final double LOCDEFAULT = -1.0D;
  public float accuracy;
  public double altitude;
  public float direction;
  public int indoorState;
  public double latitude = -1.0D;
  public int locType;
  public double longitude = -1.0D;
  public String networkLocType;
  public int satellitesNum;
  public float speed;
  public long time;
  public int type;
  
  public LocData clone()
  {
    LocData localLocData = new LocData();
    try
    {
      localLocData.accuracy = this.accuracy;
      localLocData.direction = this.direction;
      localLocData.latitude = this.latitude;
      localLocData.longitude = this.longitude;
      localLocData.satellitesNum = this.satellitesNum;
      localLocData.speed = this.speed;
      localLocData.altitude = this.altitude;
      localLocData.type = this.type;
      localLocData.time = this.time;
      localLocData.locType = this.locType;
      return localLocData;
    }
    finally {}
  }
  
  public int getStartPointUpStreamLocType()
  {
    int i = 0;
    if (this.type == 61) {
      i = 1;
    }
    while (this.type != 161) {
      return i;
    }
    if ("wf".equalsIgnoreCase(this.networkLocType)) {
      return 2;
    }
    if ("cl".equalsIgnoreCase(this.networkLocType)) {
      return 3;
    }
    return 0;
  }
  
  public boolean isValid()
  {
    return (this.longitude != -1.0D) && (this.latitude != -1.0D);
  }
  
  public GeoPoint toGeoPoint()
  {
    GeoPoint localGeoPoint = new GeoPoint();
    localGeoPoint.setLongitudeE6((int)(this.longitude * 100000.0D));
    localGeoPoint.setLatitudeE6((int)(this.latitude * 100000.0D));
    return localGeoPoint;
  }
  
  public String toLocationOverlayJsonString(boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject1.put("type", 0);
      if (0 == 0) {
        break label217;
      }
      throw new NullPointerException();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    localJSONObject2.put("radius", this.accuracy);
    localJSONObject2.put("direction", this.direction);
    localJSONObject2.put("iconarrownor", "NormalLocArrow");
    localJSONObject2.put("iconarrownorid", 28);
    localJSONObject2.put("iconarrowfoc", "FocusLocArrow");
    localJSONObject2.put("iconarrowfocid", 29);
    localJSONArray.put(localJSONObject2);
    if (paramBoolean)
    {
      if (0 == 0) {
        break label242;
      }
      throw new NullPointerException();
    }
    for (;;)
    {
      localJSONObject3.put("radius", 0);
      localJSONObject3.put("direction", 0);
      localJSONObject3.put("iconarrownor", "direction_wheel");
      localJSONObject3.put("iconarrownorid", 54);
      localJSONObject3.put("iconarrowfoc", "direction_wheel");
      localJSONObject3.put("iconarrowfocid", 54);
      localJSONArray.put(localJSONObject3);
      localJSONObject1.put("data", localJSONArray);
      return localJSONObject1.toString();
      label217:
      localJSONObject2.put("ptx", this.longitude);
      localJSONObject2.put("pty", this.latitude);
      break;
      label242:
      localJSONObject3.put("ptx", this.longitude);
      localJSONObject3.put("pty", this.latitude);
    }
  }
  
  public String toLocationOverlayJsonStringNoDir()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("type", 0);
        if (0 == 0) {
          continue;
        }
        throw new NullPointerException();
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      localJSONObject2.put("radius", this.accuracy);
      localJSONObject2.put("direction", 0);
      localJSONObject2.put("iconarrownor", "NormalLocArrow");
      localJSONObject2.put("iconarrownorid", 26);
      localJSONObject2.put("iconarrowfoc", "FocusLocArrow");
      localJSONObject2.put("iconarrowfocid", 27);
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray);
      return localJSONObject1.toString();
      localJSONObject2.put("ptx", this.longitude);
      localJSONObject2.put("pty", this.latitude);
    }
  }
  
  public String toString()
  {
    return String.format("LocData {longitude:%1$f latitude:%2$f direction:%3$.1f speed:%4$.1f sat:%5$d}", new Object[] { Double.valueOf(this.longitude), Double.valueOf(this.latitude), Float.valueOf(this.direction), Float.valueOf(this.speed), Integer.valueOf(this.satellitesNum) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/LocData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */