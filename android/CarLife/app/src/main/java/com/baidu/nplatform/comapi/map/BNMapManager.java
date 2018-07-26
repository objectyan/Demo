package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.MapWrapper;

public class BNMapManager {
    private static final String TAG = BNMapManager.class.getSimpleName();

    static class Holder {
        private static BNMapManager sInstance = new BNMapManager();

        Holder() {
        }
    }

    private BNMapManager() {
    }

    public static BNMapManager getInstance() {
        return Holder.sInstance;
    }

    public void init(Context context, Bundle initParams) {
        LogUtil.m15791e(TAG, "init: -->");
        BNMapController.getInstance().initMapController(context, initParams);
    }

    public void unInit() {
        LogUtil.m15791e(TAG, "unInit: -->");
        BNMapController.destory();
        NMapControlProxy.destory();
    }

    public void addMapObserver(BNMapObserver bnMapObserver) {
        if (bnMapObserver != null) {
            BNMapController.getInstance().addObserver(bnMapObserver);
        }
    }

    public void deleteMapObserver(BNMapObserver bnMapObserver) {
        if (bnMapObserver != null) {
            BNMapController.getInstance().deleteObserver(bnMapObserver);
        }
    }

    public void onAction(int eventGesture, Object arg) {
        LogUtil.m15791e(TAG, "onAction: actionType --> " + eventGesture);
        switch (eventGesture) {
            case 513:
                LogUtil.m15791e(TAG, " --> onDoubleTap");
                BNMapController.getInstance().handleDoubleTouch(arg);
                return;
            case 514:
                LogUtil.m15791e(TAG, " --> onSingleTapConfirmed");
                BNMapController.getInstance().handleSingleTouch(arg);
                return;
            case 515:
                LogUtil.m15791e(TAG, " --> onDown");
                BNMapController.getInstance().notifyMapObservers(2, 515, null);
                return;
            case 516:
                LogUtil.m15791e(TAG, " --> onFling");
                BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_FLIP);
                BNMapController.getInstance().notifyMapObservers(2, 516, null);
                return;
            case 517:
                LogUtil.m15791e(TAG, " --> onLongPress");
                BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_LONGCLICK);
                BNMapController.getInstance().notifyMapObservers(2, 517, arg);
                return;
            case 518:
                LogUtil.m15791e(TAG, " --> onScroll");
                BNMapController.getInstance().notifyMapObservers(2, 518, null);
                return;
            case 520:
                LogUtil.m15791e(TAG, " --> onDoubleFingerZoom");
                BNMapController.getInstance().notifyMapObservers(2, 520, null);
                return;
            case 521:
                LogUtil.m15791e(TAG, " --> onDoubleFingerRotate");
                BNMapController.getInstance().notifyMapObservers(2, 520, null);
                return;
            default:
                return;
        }
    }

    public Point onTapInterception(Point point) {
        if (point != null) {
            LogUtil.m15791e(TAG, "onTap: input --> x: " + point.getmPtx() + ", y: " + point.getmPty());
            if (RouteGuideParams.getRouteGuideMode() == 2) {
                point.setmPty((point.getmPty() + ScreenUtil.getInstance().getStatusBarHeight()) - ScreenUtil.getInstance().dip2px(20));
                LogUtil.m15791e(TAG, "onTap: output --> x: " + point.getmPtx() + ", y: " + point.getmPty());
            }
        }
        return point;
    }

    public boolean onItemClick(String jsonStr, int clickedX, int clickedY) {
        LogUtil.m15791e(TAG, "onItemClick: jsonStr --> " + jsonStr);
        return BNMapController.getInstance().onMapItemClick(jsonStr, clickedX, clickedY);
    }

    public void onMapRenderModeChange(int value) {
        LogUtil.m15791e(TAG, "onMapRenderModeChange: value --> " + value);
        switch (value) {
            case 1:
                JNIBaseMap.UpdateNeedRender(true);
                return;
            default:
                return;
        }
    }

    public void onMapAnimationFinish() {
        LogUtil.m15791e(TAG, "onMapAnimationFinish:  --> ");
        BNMapController.getInstance().onMapAnimationFinish();
    }

    public void setItemizedOverlayMapWrapper(MapWrapper mMapWrapper) {
        ItemizedOverlayUtil.getInstance().setMapWrapper(mMapWrapper);
    }
}
