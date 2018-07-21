package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class PointSelectNode
  extends RoutePlanNode
{
  private static final long serialVersionUID = 5728445424643930964L;
  public String mPointDescription;
  int mPointIndex = -1;
  
  public PointSelectNode() {}
  
  public PointSelectNode(int paramInt, RoutePlanNode paramRoutePlanNode)
  {
    this.mPointIndex = paramInt;
    setRoutePlanNode(paramRoutePlanNode);
  }
  
  public PointSelectNode(RoutePlanNode paramRoutePlanNode)
  {
    setRoutePlanNode(paramRoutePlanNode);
  }
  
  public void clearSelectNode()
  {
    this.mPointIndex = -1;
    this.mName = "";
    this.mDescription = "";
    this.mGeoPoint = new GeoPoint();
    this.mFrom = 0;
    this.mViewPoint = null;
    clearSubPoiList();
  }
  
  public String getPointDescription()
  {
    return this.mPointDescription;
  }
  
  public int getPointIndex()
  {
    return this.mPointIndex;
  }
  
  public RoutePlanNode getRoutePlanNode()
  {
    RoutePlanNode localRoutePlanNode = new RoutePlanNode(this.mGeoPoint, this.mViewPoint, this.mFrom, this.mName, this.mDescription, this.mUID);
    localRoutePlanNode.setSubPosList(getSubPosList());
    return localRoutePlanNode;
  }
  
  public void setPointDescription(String paramString)
  {
    this.mPointDescription = paramString;
  }
  
  public void setPointIndex(int paramInt)
  {
    this.mPointIndex = paramInt;
  }
  
  public void setRoutePlanNode(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    setRoutePlanNode(new GeoPoint(paramInt2, paramInt1), paramInt3, paramString1, paramString2);
  }
  
  public void setRoutePlanNode(int paramInt, SearchPoi paramSearchPoi)
  {
    setRoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
    setPointIndex(paramInt);
  }
  
  public void setRoutePlanNode(int paramInt, SearchPoi paramSearchPoi, ArrayList<SearchPoi> paramArrayList)
  {
    setRoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
    paramSearchPoi = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramSearchPoi.add(((SearchPoi)paramArrayList.get(i)).mGuidePoint);
        i += 1;
      }
      setSubPosList(paramSearchPoi);
    }
    setPointIndex(paramInt);
  }
  
  public void setRoutePlanNode(RoutePlanNode paramRoutePlanNode)
  {
    copy(paramRoutePlanNode);
  }
  
  public void setRoutePlanNode(SearchPoi paramSearchPoi)
  {
    setRoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
  }
  
  public void setRoutePlanNode(SearchPoi paramSearchPoi, ArrayList<SearchPoi> paramArrayList)
  {
    setRoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
    paramSearchPoi = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramSearchPoi.add(((SearchPoi)paramArrayList.get(i)).mGuidePoint);
        i += 1;
      }
      setSubPosList(paramSearchPoi);
    }
  }
  
  public void setRoutePlanNode(GeoPoint paramGeoPoint)
  {
    setGeoPoint(paramGeoPoint);
  }
  
  public void setRoutePlanNode(GeoPoint paramGeoPoint, int paramInt, String paramString1, String paramString2)
  {
    setGeoPoint(paramGeoPoint);
    setFrom(paramInt);
    setName(paramString1);
    setDescription(paramString2);
  }
  
  public void setRoutePlanNode(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt, String paramString1, String paramString2)
  {
    setGeoPoint(paramGeoPoint1);
    setFrom(paramInt);
    setName(paramString1);
    setDescription(paramString2);
    setViewPoint(paramGeoPoint2);
  }
  
  public void setRoutePlanNode(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    setGeoPoint(paramGeoPoint1);
    setFrom(paramInt);
    setName(paramString1);
    setDescription(paramString2);
    setViewPoint(paramGeoPoint2);
    setUID(paramString3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/PointSelectNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */