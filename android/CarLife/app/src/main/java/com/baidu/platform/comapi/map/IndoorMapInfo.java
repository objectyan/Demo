package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class IndoorMapInfo
  implements Serializable
{
  private static final long serialVersionUID = 3931577061227487973L;
  private String buildingId;
  private int[] floorAttribute;
  private String floorId;
  private String[] floorList;
  private String idrSearch;
  private int idrType;
  private int idrguide;
  
  public IndoorMapInfo(String paramString1, String paramString2)
  {
    this.buildingId = paramString1;
    this.floorId = paramString2;
  }
  
  public IndoorMapInfo(String paramString1, String paramString2, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    this(paramString1, paramString2, paramArrayOfString, paramArrayOfInt, paramInt, 0, "");
  }
  
  public IndoorMapInfo(String paramString1, String paramString2, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramArrayOfString, paramArrayOfInt, paramInt1, paramInt2, "");
  }
  
  public IndoorMapInfo(String paramString1, String paramString2, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString3)
  {
    this.buildingId = paramString1;
    this.floorId = paramString2;
    this.idrType = paramInt1;
    this.idrguide = paramInt2;
    if (paramArrayOfString != null)
    {
      this.floorList = ((String[])Array.newInstance(String.class, paramArrayOfString.length));
      System.arraycopy(paramArrayOfString, 0, this.floorList, 0, paramArrayOfString.length);
    }
    if (paramArrayOfInt != null)
    {
      this.floorAttribute = new int[paramArrayOfInt.length];
      System.arraycopy(paramArrayOfInt, 0, this.floorAttribute, 0, paramArrayOfInt.length);
    }
    this.idrSearch = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof IndoorMapInfo)) {
      return false;
    }
    if (!TextUtils.equals(this.buildingId, ((IndoorMapInfo)paramObject).buildingId)) {
      return false;
    }
    if (!TextUtils.equals(this.floorId, ((IndoorMapInfo)paramObject).floorId)) {
      return false;
    }
    if (!Arrays.equals(this.floorList, ((IndoorMapInfo)paramObject).floorList)) {
      return false;
    }
    return Arrays.equals(this.floorAttribute, ((IndoorMapInfo)paramObject).floorAttribute);
  }
  
  public String getBuildingId()
  {
    return this.buildingId;
  }
  
  public final int[] getFloorAttribute()
  {
    return this.floorAttribute;
  }
  
  public String getFloorId()
  {
    return this.floorId;
  }
  
  public final String[] getFloorList()
  {
    return this.floorList;
  }
  
  public String getIdrSearch()
  {
    return this.idrSearch;
  }
  
  public int getIdrguide()
  {
    return this.idrguide;
  }
  
  public int getIndoorType()
  {
    return this.idrType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndoorMapInfo:building_id:").append(this.buildingId);
    localStringBuilder.append(";floor_id:").append(this.floorId);
    localStringBuilder.append(";indoor_type:").append(this.idrType);
    localStringBuilder.append(";floor_list:").append(Arrays.toString(this.floorList));
    localStringBuilder.append(";floor_attribute:").append(Arrays.toString(this.floorAttribute));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/IndoorMapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */