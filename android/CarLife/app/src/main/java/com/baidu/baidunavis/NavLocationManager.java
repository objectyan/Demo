package com.baidu.baidunavis;

import com.baidu.baidunavis.control.NavDrivingCarController;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class NavLocationManager {
    private boolean isRouteDetailPage;
    private LocationChangeListener mLocationListener;
    private BNWorkerNormalTask mUpdateLocationOnBGTask;

    /* renamed from: com.baidu.baidunavis.NavLocationManager$1 */
    class C07461 implements LocationChangeListener {
        C07461() {
        }

        public void onLocationChange(LocData locData) {
            com.baidu.navisdk.model.datastruct.LocData navLocData = new com.baidu.navisdk.model.datastruct.LocData();
            navLocData.accuracy = locData.accuracy;
            navLocData.direction = locData.direction;
            navLocData.satellitesNum = locData.satellitesNum;
            navLocData.speed = locData.speed / 3.6f;
            navLocData.type = locData.type;
            try {
                navLocData.latitude = locData.latitude;
                navLocData.longitude = locData.longitude;
                if (PerformStatItem.sEnableTestData) {
                    GeoPoint pointTrans = CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119d, 40.040642d);
                    navLocData.longitude = ((double) pointTrans.getLongitudeE6()) / 100000.0d;
                    navLocData.latitude = ((double) pointTrans.getLatitudeE6()) / 100000.0d;
                }
                navLocData.altitude = locData.altitude;
                navLocData.indoorState = locData.indoorState;
                navLocData.networkLocType = locData.networkLocType;
                BNExtGPSLocationManager.getInstance().updateLocation(navLocData);
                BNWorkerCenter.getInstance().cancelTask(NavLocationManager.this.mUpdateLocationOnBGTask, true);
                BNWorkerCenter.getInstance().submitNormalTask(NavLocationManager.this.mUpdateLocationOnBGTask, new BNWorkerConfig(100, 0));
            } catch (Throwable th) {
            }
            RespTimeStatItem.getInstance().setAppLocatedTime();
        }

        public CoordType onGetCoordType() {
            return CoordType.CoordType_GCJ02;
        }
    }

    private static class LazyHolder {
        private static NavLocationManager sLocationManager = new NavLocationManager();

        private LazyHolder() {
        }
    }

    public void enterRouteDetailPage() {
        this.isRouteDetailPage = true;
    }

    public void exitRouteDetailPage() {
        this.isRouteDetailPage = false;
    }

    private NavLocationManager() {
        this.isRouteDetailPage = false;
        this.mLocationListener = new C07461();
        this.mUpdateLocationOnBGTask = new BNWorkerNormalTask("onLocationChange", null) {
            protected Object execute() {
                com.baidu.navisdk.model.datastruct.LocData navLocData = BNExtGPSLocationManager.getInstance().getCurLocation();
                if (navLocData != null) {
                    NavDrivingCarController.getInstance().getMapCarPoint(navLocData);
                    BNExtGPSLocationManager.getInstance().notifyLocationChangedForEngine(navLocData);
                    if (NavLocationManager.this.isRouteDetailPage) {
                        BNExtGPSLocationManager.getInstance().triggerGPSDataChangeForDriving(navLocData);
                    }
                }
                return null;
            }
        };
    }

    public static NavLocationManager getInstance() {
        return LazyHolder.sLocationManager;
    }

    public void addLocationListener() {
        NavMapAdapter.getInstance().addLocationChangeLister(this.mLocationListener);
    }

    public void removeLocationListener() {
        NavMapAdapter.getInstance().removeLocationChangeLister(this.mLocationListener);
    }

    public void notifyMapGPSEnable(boolean useGPS) {
        if (!useGPS) {
            BNSysLocationManager.getInstance().stopNaviLocateForRoutePlan();
        } else if (NavCommonFuncModel.getInstance().getActivity() != null) {
            BNSysLocationManager.getInstance().startNaviLocateForRoutePlan(NavCommonFuncModel.getInstance().getActivity().getApplicationContext());
        }
    }
}
