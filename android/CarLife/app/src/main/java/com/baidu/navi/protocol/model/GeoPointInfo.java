package com.baidu.navi.protocol.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoPointInfo
{
  public static final String KEY_ADDR = "addr";
  public static final String KEY_DISTANCE = "distance";
  public static final String KEY_INDEX = "index";
  public static final String KEY_NAME = "name";
  public static final String KEY_X = "x";
  public static final String KEY_Y = "y";
  public String addr;
  public String distance = "";
  public int index;
  public String name;
  public int x;
  public int y;
  
  public GeoPointInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.name = paramString;
  }
  
  public GeoPointInfo(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.name = paramString;
    this.index = paramInt3;
  }
  
  public GeoPointInfo(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.name = paramString1;
    this.index = paramInt3;
    this.addr = paramString2;
  }
  
  public GeoPointInfo(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.name = paramString1;
    this.addr = paramString2;
    this.distance = paramString3;
  }
  
  public GeoPointInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.name = paramString1;
    this.addr = paramString2;
  }
  
  public GeoPointInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.name = paramString1;
    this.addr = paramString2;
    this.distance = paramString3;
  }
  
  public static GeoPointInfo jsonToGeo(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("x", 0);
      int j = paramJSONObject.optInt("y", 0);
      localObject = paramJSONObject.optString("name", "");
      String str = paramJSONObject.optString("addr", "");
      localObject = new GeoPointInfo(i, j, (String)localObject, paramJSONObject.optInt("index", 0), str, paramJSONObject.optString("distance", ""));
    }
    return (GeoPointInfo)localObject;
  }
  
  public static List<GeoPointInfo> jsonToList(JSONArray paramJSONArray)
  {
    GeoPointInfo localGeoPointInfo = null;
    Object localObject = localGeoPointInfo;
    int j;
    int i;
    if (paramJSONArray != null)
    {
      localObject = localGeoPointInfo;
      if (paramJSONArray.length() > 0)
      {
        j = paramJSONArray.length();
        localObject = new ArrayList(j);
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        return (List<GeoPointInfo>)localObject;
      }
      try
      {
        localGeoPointInfo = jsonToGeo(paramJSONArray.getJSONObject(i));
        if (localGeoPointInfo != null)
        {
          ((List)localObject).add(localGeoPointInfo);
          ((List)localObject).set(localGeoPointInfo.index - 1, localGeoPointInfo);
        }
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
    return (List<GeoPointInfo>)localObject;
  }
  
  public static String listToString(List<GeoPointInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    int i;
    if (paramList != null)
    {
      j = paramList.size();
      localStringBuilder.append("[");
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      localStringBuilder.append(((GeoPointInfo)paramList.get(i)).toString());
      i += 1;
    }
  }
  
  public static JSONArray toJSONArray(List<GeoPointInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    int j;
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      j = paramList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return localJSONArray;
      }
      GeoPointInfo localGeoPointInfo = (GeoPointInfo)paramList.get(i);
      if (localGeoPointInfo != null)
      {
        localGeoPointInfo.index = (i + 1);
        localJSONArray.put(toJSONObject(localGeoPointInfo, true, false));
      }
      i += 1;
    }
  }
  
  public static JSONArray toJSONArray(List<GeoPointInfo> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONArray localJSONArray = new JSONArray();
    int j;
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      j = paramList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return localJSONArray;
      }
      GeoPointInfo localGeoPointInfo = (GeoPointInfo)paramList.get(i);
      if (localGeoPointInfo != null)
      {
        localGeoPointInfo.index = (i + 1);
        localJSONArray.put(toJSONObject(localGeoPointInfo, paramBoolean1, paramBoolean2));
      }
      i += 1;
    }
  }
  
  public static JSONObject toJSONObject(GeoPointInfo paramGeoPointInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramGeoPointInfo != null) {}
    try
    {
      localJSONObject.put("x", paramGeoPointInfo.x);
      localJSONObject.put("y", paramGeoPointInfo.y);
      localJSONObject.put("name", paramGeoPointInfo.name);
      localJSONObject.put("distance", paramGeoPointInfo.distance);
      if (paramBoolean1) {
        localJSONObject.put("index", paramGeoPointInfo.index);
      }
      if (paramBoolean2) {
        localJSONObject.put("addr", paramGeoPointInfo.addr);
      }
      return localJSONObject;
    }
    catch (JSONException paramGeoPointInfo)
    {
      paramGeoPointInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean isValid()
  {
    boolean bool = true;
    if ((this.x <= 0) || (this.y <= 0)) {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    return "(x=" + this.x + " y=" + this.y + " name=" + this.name + " index=" + this.index + " addr=" + this.addr + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/GeoPointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */