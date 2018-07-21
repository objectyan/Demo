package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Polygon
  extends Geometry
{
  private List<GeoPoint> mPoints;
  
  public Polygon(Style paramStyle)
  {
    super(paramStyle);
    this.dataType = 1;
    this.styleType = 3;
  }
  
  private boolean genDifferPoints()
  {
    if ((this.mPoints == null) && (this.mPoints.size() < 3)) {
      return false;
    }
    int j = this.mPoints.size();
    this.mDifferArray = new double[this.mPoints.size() * 2];
    genGeoBound();
    this.mDifferArray[0] = ((GeoPoint)this.mPoints.get(0)).getLongitude();
    this.mDifferArray[1] = ((GeoPoint)this.mPoints.get(0)).getLatitude();
    int i = 1;
    while (i < j)
    {
      this.mDifferArray[(i * 2)] = (((GeoPoint)this.mPoints.get(i)).getLongitude() - ((GeoPoint)this.mPoints.get(i - 1)).getLongitude());
      this.mDifferArray[(i * 2 + 1)] = (((GeoPoint)this.mPoints.get(i)).getLatitude() - ((GeoPoint)this.mPoints.get(i - 1)).getLatitude());
      i += 1;
    }
    return true;
  }
  
  private boolean genGeoBound()
  {
    if ((this.mPoints == null) && (this.mPoints.size() < 3)) {
      return false;
    }
    this.mLL.setLatitude(((GeoPoint)this.mPoints.get(0)).getLatitude());
    this.mLL.setLongitude(((GeoPoint)this.mPoints.get(0)).getLongitude());
    this.mRU.setLatitude(((GeoPoint)this.mPoints.get(0)).getLatitude());
    this.mRU.setLongitude(((GeoPoint)this.mPoints.get(0)).getLongitude());
    Iterator localIterator = this.mPoints.iterator();
    while (localIterator.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)localIterator.next();
      if (this.mLL.getLatitude() >= localGeoPoint.getLatitude()) {
        this.mLL.setLatitude(localGeoPoint.getLatitude());
      }
      if (this.mLL.getLongitude() >= localGeoPoint.getLongitude()) {
        this.mLL.setLongitude(localGeoPoint.getLongitude());
      }
      if (this.mRU.getLatitude() <= localGeoPoint.getLatitude()) {
        this.mRU.setLatitude(localGeoPoint.getLatitude());
      }
      if (this.mRU.getLongitude() <= localGeoPoint.getLongitude()) {
        this.mRU.setLongitude(localGeoPoint.getLongitude());
      }
    }
    return true;
  }
  
  public String getData()
  {
    if (this.isNeedRefresh)
    {
      genGeoBound();
      if (genDifferPoints()) {
        break label35;
      }
    }
    label35:
    for (boolean bool = true;; bool = false)
    {
      this.isNeedRefresh = bool;
      return getData(this.dataType);
    }
  }
  
  public void setPoints(List<GeoPoint> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("points list can not be null!");
    }
    if ((paramList.size() < 3) && (this.styleType == 3)) {
      throw new IllegalArgumentException("points count can not be less than three!");
    }
    if (this.mPoints == null)
    {
      this.mPoints = new ArrayList();
      this.mPoints.addAll(paramList);
    }
    for (;;)
    {
      this.isNeedRefresh = true;
      return;
      this.mPoints.clear();
      this.mPoints.addAll(paramList);
    }
  }
  
  public void setStyleType(int paramInt)
  {
    this.styleType = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/Polygon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */