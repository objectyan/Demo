package com.baidu.baidunavis.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.BaiduNaviParams.MapCarPointKey;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanKey;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class NavDrivingCarController {
    public static final String TAG = NavDrivingCarController.class.getSimpleName();
    private static NavDrivingCarController sInstance = null;
    public boolean hasYawRouteMsg = false;
    private boolean isDrvingCar = false;

    public boolean isDrvingCar() {
        return this.isDrvingCar;
    }

    private NavDrivingCarController() {
    }

    public static NavDrivingCarController getInstance() {
        if (sInstance == null) {
            sInstance = new NavDrivingCarController();
        }
        return sInstance;
    }

    public boolean startDrivingCar() {
        NavLogUtils.m3003e(TAG, "NavDrivingCar===startDrivingCar= isDrvingCar : " + this.isDrvingCar);
        if (this.isDrvingCar) {
            return true;
        }
        BNRouteGuider.getInstance().setLocateMode(1);
        if (!BNRoutePlaner.getInstance().startDrivingCar()) {
            return false;
        }
        this.isDrvingCar = true;
        return true;
    }

    public boolean stopDrivingCar() {
        NavLogUtils.m3003e(TAG, "NavDrivingCar===stopDrivingCar= isDrvingCar : " + this.isDrvingCar);
        if (!this.isDrvingCar) {
            return true;
        }
        if (!BNRoutePlaner.getInstance().stopDrivingCar()) {
            return false;
        }
        this.isDrvingCar = false;
        return true;
    }

    public boolean selectRoute(String routeMrsl, boolean startDriv) {
        NavLogUtils.m3003e(TAG, "NavDrivingCar===selectRoute= startDriv : " + startDriv);
        if (this.hasYawRouteMsg) {
            this.hasYawRouteMsg = false;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("Driver.selectRoute", null) {
                protected String execute() {
                    byte[] pbData = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf();
                    NavLogUtils.m3003e(TAG, "NavDrivingCar===NE_RoutePlan_Driving_Car_ROUTE_REFRESH routePB.lenth=");
                    Bundle data = new Bundle();
                    data.putByteArray("pb_data", pbData);
                    data.putInt(RoutePlanKey.Route_Refresh_Reason, 2);
                    Message sucMsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_DRIVING_CAR_ROUTE_REFRESH);
                    sucMsg.obj = data;
                    sucMsg.sendToTarget();
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 1000);
        }
        return BNRoutePlaner.getInstance().selectRouteForDriving(routeMrsl);
    }

    public void getMapCarPoint(LocData locData) {
        if (NavCommonFuncModel.getInstance().mIsAppForeground && this.isDrvingCar) {
            if (locData != null) {
                BNExtGPSLocationManager.getInstance().triggerGPSDataChangeForDriving(locData);
            }
            Bundle carPoint = BNRoutePlaner.getInstance().getMapVehiclePos();
            if (carPoint != null && carPoint.getDouble(MapCarPointKey.Map_CarPoint_X) > 0.0d && carPoint.getDouble(MapCarPointKey.Map_CarPoint_Y) > 0.0d) {
                Handler mMapHandler = BaiduNaviManager.getInstance().getMapHandler();
                if (mMapHandler != null) {
                    Message outmsg = mMapHandler.obtainMessage(3010);
                    if (outmsg != null) {
                        outmsg.obj = carPoint;
                        outmsg.sendToTarget();
                    }
                }
            }
        } else if (!NavCommonFuncModel.getInstance().mIsAppForeground) {
        }
    }

    public int refreshRouteForDrivingCar() {
        return BNRouteGuider.getInstance().calcOtherRoute(1, 0);
    }
}
