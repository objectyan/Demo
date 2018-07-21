package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

class InternalProjection
  implements Projection
{
  private MapController mMapController = null;
  
  public InternalProjection(MapController paramMapController)
  {
    this.mMapController = paramMapController;
  }
  
  public GeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mMapController.getBaseMap();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((AppBaseMap)localObject1).ScrPtToGeoPoint(paramInt1, paramInt2);
    localObject1 = new GeoPoint(0, 0);
    if (localObject2 != null) {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        ((GeoPoint)localObject1).setLongitude(((JSONObject)localObject2).getDouble("geox"));
        ((GeoPoint)localObject1).setLatitude(((JSONObject)localObject2).getDouble("geoy"));
        return (GeoPoint)localObject1;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return (float)(paramFloat / this.mMapController.getZoomUnitsInMeter());
  }
  
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    Point localPoint = paramPoint;
    if (paramPoint == null) {
      localPoint = new Point(0.0D, 0.0D);
    }
    paramPoint = this.mMapController.getBaseMap();
    if (paramPoint == null) {}
    do
    {
      return localPoint;
      paramGeoPoint = paramPoint.GeoPtToScrPoint((int)paramGeoPoint.getLongitude(), (int)paramGeoPoint.getLatitude());
    } while (paramGeoPoint == null);
    try
    {
      paramGeoPoint = new JSONObject(paramGeoPoint);
      localPoint.setIntX(paramGeoPoint.getInt("scrx"));
      localPoint.setIntY(paramGeoPoint.getInt("scry"));
      return localPoint;
    }
    catch (JSONException paramGeoPoint) {}
    return localPoint;
  }
  
  public Point world2Screen(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Point localPoint = new Point(0.0D, 0.0D);
    Object localObject = this.mMapController.getBaseMap();
    if (localObject == null) {
      return localPoint;
    }
    localObject = ((AppBaseMap)localObject).worldPointToScreenPoint(paramFloat1, paramFloat2, paramFloat3);
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        localPoint.setDoubleX(((JSONObject)localObject).optDouble("scrx"));
        localPoint.setDoubleY(((JSONObject)localObject).optDouble("scry"));
        return localPoint;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/InternalProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */