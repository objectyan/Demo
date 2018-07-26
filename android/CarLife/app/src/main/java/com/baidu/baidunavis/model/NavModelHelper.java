package com.baidu.baidunavis.model;

import android.text.TextUtils;
import com.baidu.baidunavis.control.NavSearchController;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class NavModelHelper {
    private static final String TAG = NavModelHelper.class.getSimpleName();

    public static GeoPoint convertNavGeoPoint(NavGeoPoint ngp) {
        GeoPoint gp = new GeoPoint();
        if (ngp != null) {
            gp.setLatitudeE6(ngp.getLatitudeE6());
            gp.setLongitudeE6(ngp.getLongitudeE6());
        }
        return gp;
    }

    public static NavGeoPoint convertGeoPoint(GeoPoint ngp) {
        NavGeoPoint gp = new NavGeoPoint();
        if (ngp != null) {
            gp.setLatitudeE6(ngp.getLatitudeE6());
            gp.setLongitudeE6(ngp.getLongitudeE6());
        }
        return gp;
    }

    public static SearchCircle convertNavSearchCircle(NavSearchCircle nsc) {
        if (nsc == null) {
            return null;
        }
        return new SearchCircle(nsc.mCenter.getLongitudeE6(), nsc.mCenter.getLatitudeE6(), nsc.mRadius);
    }

    public static RoutePlanNode convertRouteNode(RouteNode rn) {
        if (rn == null) {
            return null;
        }
        RoutePlanNode rpn = new RoutePlanNode();
        try {
            int districtID = rn.mCityID;
            if (districtID < 0) {
                districtID = rn.mProvinceID;
            }
            if (districtID < 0) {
                districtID = 0;
            }
            rpn.setGeoPoint(convertNavGeoPoint(rn.mGeoPoint));
            rpn.setUID(rn.mUID);
            rpn.setDistrictID(districtID);
            if (!TextUtils.isEmpty(rn.mName)) {
                rpn.setName(rn.mName);
            }
            rpn.mDescription = rn.mAddr;
            rpn.mFrom = rn.mFromType;
            if (rn.mMapGeoBound != null) {
                rpn.mLeft = rn.mMapGeoBound.left;
                rpn.mRight = rn.mMapGeoBound.right;
                rpn.mBottom = rn.mMapGeoBound.bottom;
                rpn.mTop = rn.mMapGeoBound.top;
            }
            if (rn.mFromType == 4) {
                rpn.mFrom = 4;
            } else if (rn.mFromType == 5) {
                rpn.mFrom = 5;
            }
            if (rn.mFromType == 2 || rn.mFromType == 1 || rn.mFromType == 4 || rn.mFromType == 5) {
                rpn.mDistrictID = NavSearchController.getInstance().getDistrictIdForKeySearch(districtID);
            }
            rpn.mLevel = rn.mLevel;
            rpn.mNodeType = rn.mNodeType;
            if (rn.mLocType == 61) {
                rpn.mLocType = 1;
            } else if (rn.mLocType != 161) {
                rpn.mLocType = 0;
            } else if ("wf".equalsIgnoreCase(rn.mNetworkLocStr)) {
                rpn.mLocType = 2;
            } else if ("cl".equalsIgnoreCase(rn.mNetworkLocStr)) {
                rpn.mLocType = 3;
            } else {
                rpn.mLocType = 0;
            }
            if (rn.mLocType == 61) {
                rpn.mGPSAngle = rn.mGPSAngle;
                rpn.mGPSAccuracy = rn.mGPSAccuracy;
                rpn.mGPSSpeed = rn.mGPSSpeed / 3.6f;
                rpn.mAltitude = (float) rn.mAltitude;
                if (rpn.mAltitude < 0.0f) {
                    try {
                        LocData mCurLocData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
                        rpn.mAltitude = (float) mCurLocData.altitude;
                        rpn.mGPSAngle = mCurLocData.direction;
                        rpn.mGPSAccuracy = mCurLocData.accuracy;
                        rpn.mGPSSpeed = mCurLocData.speed / 3.6f;
                    } catch (Exception e) {
                    }
                }
            } else {
                rpn.mGPSAngle = -2.0f;
                rpn.mGPSSpeed = -2.0f;
                if (rn.mGPSAccuracy >= 0.0f) {
                    rpn.mGPSAccuracy = rn.mGPSAccuracy;
                } else {
                    rpn.mGPSAccuracy = -2.0f;
                }
            }
            if (RoutePlanParams.MY_LOCATION.equals(rn.mName)) {
                rpn.mSensorAngle = NavRoutePlanModel.getInstance().getmSensorAngle();
            }
            rpn.mBusinessPoi = rn.mBusinessPoi;
            return rpn;
        } catch (Exception e2) {
            return rpn;
        }
    }
}
