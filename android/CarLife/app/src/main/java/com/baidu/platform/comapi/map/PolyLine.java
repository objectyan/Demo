package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PolyLine
  extends Geometry
{
  public static final int TYPE = 2;
  private List<GeoPoint> mPoints = new ArrayList();
  
  public PolyLine(Style paramStyle)
  {
    super(paramStyle);
    this.dataType = 0;
    this.styleType = 2;
  }
  
  private boolean genDifferPoints()
  {
    synchronized (this.mPoints)
    {
      if (this.mPoints.size() < 2) {
        return false;
      }
      int j = this.mPoints.size();
      this.mDifferArray = new double[this.mPoints.size() * 2 + 5];
      if (genGeoBound())
      {
        this.mDifferArray[0] = this.mLL.getLongitude();
        this.mDifferArray[1] = this.mLL.getLatitude();
        this.mDifferArray[2] = this.mRU.getLongitude();
        this.mDifferArray[3] = this.mRU.getLatitude();
      }
      this.mDifferArray[4] = 2.0D;
      this.mDifferArray[5] = ((GeoPoint)this.mPoints.get(0)).getLongitude();
      this.mDifferArray[6] = ((GeoPoint)this.mPoints.get(0)).getLatitude();
      int i = 1;
      while (i < j)
      {
        this.mDifferArray[(i * 2 + 5)] = (((GeoPoint)this.mPoints.get(i)).getLongitude() - ((GeoPoint)this.mPoints.get(i - 1)).getLongitude());
        this.mDifferArray[(i * 2 + 5 + 1)] = (((GeoPoint)this.mPoints.get(i)).getLatitude() - ((GeoPoint)this.mPoints.get(i - 1)).getLatitude());
        i += 1;
      }
      return true;
    }
  }
  
  private boolean genGeoBound()
  {
    synchronized (this.mPoints)
    {
      if (this.mPoints.size() < 2) {
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
    }
    return true;
  }
  
  public void addPoint(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      throw new IllegalArgumentException("point can not be null!");
    }
    synchronized (this.mPoints)
    {
      this.mPoints.add(paramGeoPoint);
      this.isNeedRefresh = true;
      return;
    }
  }
  
  public String getData()
  {
    for (;;)
    {
      synchronized (this.mPoints)
      {
        if (this.isNeedRefresh)
        {
          if (!genDifferPoints())
          {
            bool = true;
            this.isNeedRefresh = bool;
          }
        }
        else
        {
          String str = getData(this.dataType);
          return str;
        }
      }
      boolean bool = false;
    }
  }
  
  public void removeAllPoints()
  {
    synchronized (this.mPoints)
    {
      this.mPoints.clear();
      return;
    }
  }
  
  public void setPoints(List<GeoPoint> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("points list can not be null!");
    }
    if (paramList.size() < 2) {
      throw new IllegalArgumentException("points count can not be less than two!");
    }
    synchronized (this.mPoints)
    {
      this.mPoints.clear();
      this.mPoints.addAll(paramList);
      this.isNeedRefresh = true;
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/PolyLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */