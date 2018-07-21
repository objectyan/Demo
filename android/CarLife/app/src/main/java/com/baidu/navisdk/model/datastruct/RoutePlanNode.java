package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class RoutePlanNode
  implements Serializable
{
  public static final int FROM_COMPANY = 5;
  public static final int FROM_FAVORITE = 6;
  public static final int FROM_HOME = 4;
  public static final int FROM_MAP_KEYWORD = 2;
  public static final int FROM_MAP_POINT = 1;
  public static final int FROM_MY_POSITION = 3;
  public static final int FROM_NAVI_NEARBY_SEARCH = 7;
  public static final int FROM_POI = 8;
  public static final int FROM_UNKNOWN = 0;
  public static final int SUB_TYPE_KEYWORD = 2;
  public static final int SUB_TYPE_MYLOC = 3;
  public static final int SUB_TYPE_POS = 1;
  public static final int SUB_TYPE_SUG = 4;
  public static final int SUB_TYPE_UID = 0;
  private static final long serialVersionUID = -1928773235463634709L;
  public float mAltitude = -1.0F;
  public long mBottom = -1L;
  public int mBusinessPoi = -1;
  public String mDescription;
  public int mDistrictID = 0;
  public int mFrom;
  public float mGPSAccuracy = -2.0F;
  public float mGPSAngle = -2.0F;
  public float mGPSSpeed = -2.0F;
  public transient GeoPoint mGeoPoint;
  public long mLeft = -1L;
  public float mLevel = -1.0F;
  public int mLocType = -1;
  public String mName;
  public int mNodeType = -1;
  public long mRight = -1L;
  public float mSensorAngle = -1.0F;
  protected ArrayList<GeoPoint> mSubPosList;
  public long mTop = -1L;
  public String mUID = null;
  public transient GeoPoint mViewPoint;
  
  public RoutePlanNode()
  {
    this.mName = "";
    this.mDescription = "";
    this.mGeoPoint = new GeoPoint();
    this.mFrom = 0;
  }
  
  public RoutePlanNode(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this(paramInt1, paramInt2, paramInt3, paramString1, paramString2, null);
  }
  
  public RoutePlanNode(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0))
    {
      this.mGeoPoint = new GeoPoint();
      if ((paramInt3 == 3) || (paramInt3 == 4) || (paramInt3 == 5) || (paramInt3 == 1) || (paramInt3 == 8) || (paramInt3 == 6) || (paramInt3 == 7)) {
        break label200;
      }
      this.mFrom = 0;
      label155:
      if (paramString1 != null) {
        break label208;
      }
      this.mName = "";
      label166:
      if (paramString2 != null) {
        break label224;
      }
    }
    label200:
    label208:
    label224:
    for (this.mDescription = "";; this.mDescription = new String(paramString2))
    {
      this.mUID = paramString3;
      return;
      this.mGeoPoint = new GeoPoint(paramInt2, paramInt1);
      break;
      this.mFrom = paramInt3;
      break label155;
      this.mName = new String(paramString1);
      break label166;
    }
  }
  
  public RoutePlanNode(RoutePlanNode paramRoutePlanNode)
  {
    this();
    copy(paramRoutePlanNode);
  }
  
  public RoutePlanNode(GeoPoint paramGeoPoint, int paramInt, String paramString1, String paramString2)
  {
    this(paramGeoPoint, paramInt, paramString1, paramString2, null);
  }
  
  public RoutePlanNode(GeoPoint paramGeoPoint, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramGeoPoint == null)
    {
      this.mGeoPoint = new GeoPoint();
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 1) || (paramInt == 8) || (paramInt == 6) || (paramInt == 7)) {
        break label201;
      }
      this.mFrom = 0;
      label151:
      if (paramString1 != null) {
        break label209;
      }
      this.mName = "";
      label161:
      if (paramString2 != null) {
        break label224;
      }
    }
    label201:
    label209:
    label224:
    for (this.mDescription = "";; this.mDescription = new String(paramString2))
    {
      this.mUID = paramString3;
      return;
      this.mGeoPoint = new GeoPoint(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
      break;
      this.mFrom = paramInt;
      break label151;
      this.mName = new String(paramString1);
      break label161;
    }
  }
  
  public RoutePlanNode(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt, String paramString1, String paramString2)
  {
    this(paramGeoPoint1, paramGeoPoint2, paramInt, paramString1, paramString2, null);
  }
  
  public RoutePlanNode(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramGeoPoint1 == null)
    {
      this.mGeoPoint = new GeoPoint();
      if (paramGeoPoint2 != null) {
        this.mViewPoint = new GeoPoint(paramGeoPoint2);
      }
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 1) || (paramInt == 8) || (paramInt == 6) || (paramInt == 7)) {
        break label218;
      }
      this.mFrom = 0;
      label167:
      if (paramString1 != null) {
        break label226;
      }
      this.mName = "";
      label178:
      if (paramString2 != null) {
        break label242;
      }
    }
    label218:
    label226:
    label242:
    for (this.mDescription = "";; this.mDescription = new String(paramString2))
    {
      this.mUID = paramString3;
      return;
      this.mGeoPoint = new GeoPoint(paramGeoPoint1.getLongitudeE6(), paramGeoPoint1.getLatitudeE6());
      break;
      this.mFrom = paramInt;
      break label167;
      this.mName = new String(paramString1);
      break label178;
    }
  }
  
  public void clearSubPoiList()
  {
    if (this.mSubPosList != null) {
      this.mSubPosList.clear();
    }
    this.mSubPosList = null;
  }
  
  public void copy(RoutePlanNode paramRoutePlanNode)
  {
    if (paramRoutePlanNode == null) {
      return;
    }
    if (paramRoutePlanNode.mName != null)
    {
      this.mName = new String(paramRoutePlanNode.mName);
      if (paramRoutePlanNode.mUID == null) {
        break label133;
      }
      this.mUID = new String(paramRoutePlanNode.mUID);
      label49:
      if (paramRoutePlanNode.mDescription == null) {
        break label141;
      }
    }
    label133:
    label141:
    for (this.mDescription = new String(paramRoutePlanNode.mDescription);; this.mDescription = "")
    {
      this.mGeoPoint.setLongitudeE6(paramRoutePlanNode.mGeoPoint.getLongitudeE6());
      this.mGeoPoint.setLatitudeE6(paramRoutePlanNode.mGeoPoint.getLatitudeE6());
      this.mViewPoint = paramRoutePlanNode.mViewPoint;
      this.mFrom = paramRoutePlanNode.mFrom;
      setSubPosList(paramRoutePlanNode.mSubPosList);
      return;
      this.mName = "";
      break;
      this.mUID = null;
      break label49;
    }
  }
  
  public float getAltitude()
  {
    return this.mAltitude;
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public int getDistrictID()
  {
    return this.mDistrictID;
  }
  
  public int getFrom()
  {
    return this.mFrom;
  }
  
  public GeoPoint getGeoPoint()
  {
    return new GeoPoint(this.mGeoPoint);
  }
  
  public int getLatitudeE6()
  {
    return this.mGeoPoint.getLatitudeE6();
  }
  
  public int getLongitudeE6()
  {
    return this.mGeoPoint.getLongitudeE6();
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getNodeType()
  {
    return this.mNodeType;
  }
  
  public ArrayList<GeoPoint> getSubPosList()
  {
    if (this.mSubPosList != null) {
      return (ArrayList)this.mSubPosList.clone();
    }
    return null;
  }
  
  public String getUID()
  {
    return this.mUID;
  }
  
  public GeoPoint getViewPoint()
  {
    if (this.mViewPoint != null) {
      return new GeoPoint(this.mViewPoint);
    }
    return new GeoPoint(this.mGeoPoint);
  }
  
  public int getViewtLatitudeE6()
  {
    if (this.mViewPoint != null) {}
    for (GeoPoint localGeoPoint = this.mViewPoint;; localGeoPoint = this.mGeoPoint) {
      return localGeoPoint.getLatitudeE6();
    }
  }
  
  public int getViewtLongitudeE6()
  {
    if (this.mViewPoint != null) {}
    for (GeoPoint localGeoPoint = this.mViewPoint;; localGeoPoint = this.mGeoPoint) {
      return localGeoPoint.getLongitudeE6();
    }
  }
  
  public boolean isNodeIntegrated()
  {
    return (this.mGeoPoint.getLatitudeE6() != Integer.MIN_VALUE) && (this.mGeoPoint.getLongitudeE6() != Integer.MIN_VALUE) && ((!"".equals(this.mName)) || (!"".equals(this.mDescription)));
  }
  
  public boolean isNodeSettedData()
  {
    return (this.mGeoPoint.getLatitudeE6() != Integer.MIN_VALUE) && (this.mGeoPoint.getLongitudeE6() != Integer.MIN_VALUE);
  }
  
  public void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }
  
  public void setDistrictID(int paramInt)
  {
    this.mDistrictID = paramInt;
  }
  
  public void setFrom(int paramInt)
  {
    this.mFrom = paramInt;
  }
  
  public void setGeoPoint(GeoPoint paramGeoPoint)
  {
    this.mGeoPoint = new GeoPoint(paramGeoPoint);
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setNodeType(int paramInt)
  {
    this.mNodeType = paramInt;
  }
  
  public void setSubPosList(ArrayList<GeoPoint> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (this.mSubPosList == null) {
        this.mSubPosList = new ArrayList();
      }
      if (this.mSubPosList != null)
      {
        this.mSubPosList.clear();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          GeoPoint localGeoPoint = (GeoPoint)paramArrayList.next();
          this.mSubPosList.add(localGeoPoint);
        }
      }
    }
    else
    {
      clearSubPoiList();
    }
  }
  
  public void setUID(String paramString)
  {
    this.mUID = paramString;
  }
  
  public void setViewPoint(GeoPoint paramGeoPoint)
  {
    this.mViewPoint = new GeoPoint(paramGeoPoint);
  }
  
  public String toString()
  {
    new String();
    if (this.mViewPoint != null) {}
    for (String str = "{Name:" + this.mName + " From:" + this.mFrom + " Loc:" + this.mGeoPoint.toString() + " ViewPos:" + this.mViewPoint.toString();; str = "{Name:" + this.mName + " From:" + this.mFrom + " Loc:" + this.mGeoPoint.toString())
    {
      localObject = str;
      if (this.mSubPosList == null) {
        break label229;
      }
      localObject = str;
      if (this.mSubPosList.size() <= 0) {
        break label229;
      }
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(" SubPosList:");
      Iterator localIterator = this.mSubPosList.iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append(((GeoPoint)localIterator.next()).toString());
      }
    }
    Object localObject = str + ((StringBuffer)localObject).toString();
    label229:
    return (String)localObject + "}";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/RoutePlanNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */