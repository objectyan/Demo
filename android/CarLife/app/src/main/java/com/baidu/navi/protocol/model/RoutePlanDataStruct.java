package com.baidu.navi.protocol.model;

import java.util.ArrayList;
import java.util.List;

public class RoutePlanDataStruct
  extends DataStruct
{
  public static final int CAL_MODE_DEFAULT = 1;
  public static final int CAL_MODE_LESS_DISTANCE = 2;
  public static final int CAL_MODE_LESS_TIME = 3;
  public static final String KEY_ADD_HISTORY = "addHistory";
  public static final String KEY_CALMODE = "calMode";
  public static final String KEY_END = "end";
  public static final String KEY_START = "start";
  public static final String KEY_VIA = "via";
  public static final String KEY_X = "X";
  public static final String KEY_Y = "Y";
  public boolean addHistory;
  public int calMode;
  public GeoPointInfo endPoint;
  public List<GeoPointInfo> mViaPoints;
  public GeoPointInfo startPoint;
  
  public RoutePlanDataStruct()
  {
    this.mCmd = "route";
  }
  
  public void addViaPoint(int paramInt1, int paramInt2, String paramString)
  {
    if (this.mViaPoints == null) {
      this.mViaPoints = new ArrayList();
    }
    this.mViaPoints.add(new GeoPointInfo(paramInt1, paramInt2, paramString));
  }
  
  public void setEndPoint(int paramInt1, int paramInt2, String paramString)
  {
    this.endPoint = new GeoPointInfo(paramInt1, paramInt2, paramString);
  }
  
  public void setStartPoint(int paramInt1, int paramInt2, String paramString)
  {
    this.startPoint = new GeoPointInfo(paramInt1, paramInt2, paramString);
  }
  
  public void setViaPoints(List<GeoPointInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.mViaPoints == null) {
        this.mViaPoints = new ArrayList();
      }
      this.mViaPoints.clear();
      this.mViaPoints.addAll(paramList);
    }
  }
  
  public String toString()
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if (this.startPoint != null) {
      str1 = this.startPoint.toString();
    }
    if (this.endPoint != null) {
      str2 = this.endPoint.toString();
    }
    if (this.mViaPoints != null) {
      str3 = GeoPointInfo.listToString(this.mViaPoints);
    }
    return "cmd=" + this.mCmd + " startPoint=" + str1 + " endPoint=" + str2 + " via=" + str3 + " calMode=" + this.calMode + " addHistory=" + this.addHistory;
  }
  
  public static abstract interface ResultKey
  {
    public static final String DISTANCE = "distance";
    public static final String TOTAL_TIME = "totalTime";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/RoutePlanDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */