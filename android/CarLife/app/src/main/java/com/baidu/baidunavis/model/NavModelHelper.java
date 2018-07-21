package com.baidu.baidunavis.model;

import android.text.TextUtils;
import com.baidu.baidunavis.control.NavSearchController;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapStatus.GeoBound;

public class NavModelHelper
{
  private static final String TAG = NavModelHelper.class.getSimpleName();
  
  public static NavGeoPoint convertGeoPoint(GeoPoint paramGeoPoint)
  {
    NavGeoPoint localNavGeoPoint = new NavGeoPoint();
    if (paramGeoPoint == null) {
      return localNavGeoPoint;
    }
    localNavGeoPoint.setLatitudeE6(paramGeoPoint.getLatitudeE6());
    localNavGeoPoint.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    return localNavGeoPoint;
  }
  
  public static GeoPoint convertNavGeoPoint(NavGeoPoint paramNavGeoPoint)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    if (paramNavGeoPoint == null) {
      return localGeoPoint;
    }
    localGeoPoint.setLatitudeE6(paramNavGeoPoint.getLatitudeE6());
    localGeoPoint.setLongitudeE6(paramNavGeoPoint.getLongitudeE6());
    return localGeoPoint;
  }
  
  public static SearchCircle convertNavSearchCircle(NavSearchCircle paramNavSearchCircle)
  {
    if (paramNavSearchCircle == null) {
      return null;
    }
    return new SearchCircle(paramNavSearchCircle.mCenter.getLongitudeE6(), paramNavSearchCircle.mCenter.getLatitudeE6(), paramNavSearchCircle.mRadius);
  }
  
  public static RoutePlanNode convertRouteNode(RouteNode paramRouteNode)
  {
    if (paramRouteNode == null) {
      return null;
    }
    localRoutePlanNode = new RoutePlanNode();
    try
    {
      int j = paramRouteNode.mCityID;
      int i = j;
      if (j < 0) {
        i = paramRouteNode.mProvinceID;
      }
      for (;;)
      {
        localRoutePlanNode.setGeoPoint(convertNavGeoPoint(paramRouteNode.mGeoPoint));
        localRoutePlanNode.setUID(paramRouteNode.mUID);
        localRoutePlanNode.setDistrictID(j);
        if (!TextUtils.isEmpty(paramRouteNode.mName)) {
          localRoutePlanNode.setName(paramRouteNode.mName);
        }
        localRoutePlanNode.mDescription = paramRouteNode.mAddr;
        localRoutePlanNode.mFrom = paramRouteNode.mFromType;
        if (paramRouteNode.mMapGeoBound != null)
        {
          localRoutePlanNode.mLeft = paramRouteNode.mMapGeoBound.left;
          localRoutePlanNode.mRight = paramRouteNode.mMapGeoBound.right;
          localRoutePlanNode.mBottom = paramRouteNode.mMapGeoBound.bottom;
          localRoutePlanNode.mTop = paramRouteNode.mMapGeoBound.top;
        }
        if (paramRouteNode.mFromType == 4) {
          localRoutePlanNode.mFrom = 4;
        }
        for (;;)
        {
          if ((paramRouteNode.mFromType == 2) || (paramRouteNode.mFromType == 1) || (paramRouteNode.mFromType == 4) || (paramRouteNode.mFromType == 5)) {
            localRoutePlanNode.mDistrictID = NavSearchController.getInstance().getDistrictIdForKeySearch(j);
          }
          localRoutePlanNode.mLevel = paramRouteNode.mLevel;
          localRoutePlanNode.mNodeType = paramRouteNode.mNodeType;
          if (paramRouteNode.mLocType == 61)
          {
            localRoutePlanNode.mLocType = 1;
            label244:
            if (paramRouteNode.mLocType != 61) {
              break label483;
            }
            localRoutePlanNode.mGPSAngle = paramRouteNode.mGPSAngle;
            localRoutePlanNode.mGPSAccuracy = paramRouteNode.mGPSAccuracy;
            localRoutePlanNode.mGPSSpeed = (paramRouteNode.mGPSSpeed / 3.6F);
            localRoutePlanNode.mAltitude = ((float)paramRouteNode.mAltitude);
            float f = localRoutePlanNode.mAltitude;
            if (f >= 0.0F) {}
          }
          try
          {
            LocationManager.LocData localLocData = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
            localRoutePlanNode.mAltitude = ((float)localLocData.altitude);
            localRoutePlanNode.mGPSAngle = localLocData.direction;
            localRoutePlanNode.mGPSAccuracy = localLocData.accuracy;
            localRoutePlanNode.mGPSSpeed = (localLocData.speed / 3.6F);
            for (;;)
            {
              if ("我的位置".equals(paramRouteNode.mName)) {
                localRoutePlanNode.mSensorAngle = NavRoutePlanModel.getInstance().getmSensorAngle();
              }
              localRoutePlanNode.mBusinessPoi = paramRouteNode.mBusinessPoi;
              return localRoutePlanNode;
              if (paramRouteNode.mFromType != 5) {
                break;
              }
              localRoutePlanNode.mFrom = 5;
              break;
              if (paramRouteNode.mLocType == 161)
              {
                if ("wf".equalsIgnoreCase(paramRouteNode.mNetworkLocStr))
                {
                  localRoutePlanNode.mLocType = 2;
                  break label244;
                }
                if ("cl".equalsIgnoreCase(paramRouteNode.mNetworkLocStr))
                {
                  localRoutePlanNode.mLocType = 3;
                  break label244;
                }
                localRoutePlanNode.mLocType = 0;
                break label244;
              }
              localRoutePlanNode.mLocType = 0;
              break label244;
              label483:
              localRoutePlanNode.mGPSAngle = -2.0F;
              localRoutePlanNode.mGPSSpeed = -2.0F;
              if (paramRouteNode.mGPSAccuracy >= 0.0F) {
                localRoutePlanNode.mGPSAccuracy = paramRouteNode.mGPSAccuracy;
              } else {
                localRoutePlanNode.mGPSAccuracy = -2.0F;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
        j = i;
        if (i < 0) {
          j = 0;
        }
      }
      return localRoutePlanNode;
    }
    catch (Exception paramRouteNode) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/NavModelHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */