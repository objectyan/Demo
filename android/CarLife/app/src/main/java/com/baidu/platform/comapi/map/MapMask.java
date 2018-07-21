package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapMask
  extends Polygon
{
  private int screenHeight;
  private int screenWidth;
  
  public MapMask(Style paramStyle)
  {
    super(paramStyle);
    this.styleType = 4;
  }
  
  public void setMaskScreenPoints(List<Point> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("points list can not be null!");
    }
    if (paramList.size() < 3) {
      throw new IllegalArgumentException("points count can not be less than three!");
    }
    this.screenHeight = paramInt2;
    this.screenWidth = paramInt1;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Point localPoint = (Point)paramList.next();
      localArrayList.add(new GeoPoint(-localPoint.getIntY() + paramInt2 / 2.0D, localPoint.getIntX() - paramInt1 / 2.0D));
    }
    super.setPoints(localArrayList);
  }
  
  public void setPoints(List<GeoPoint> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)paramList.next();
      localArrayList.add(new GeoPoint(-localGeoPoint.getLatitude() + this.screenHeight / 2.0D, localGeoPoint.getLongitude() - this.screenWidth / 2.0D));
    }
    super.setPoints(localArrayList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */