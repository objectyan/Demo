package com.baidu.baidunavis.control;

import android.app.Activity;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailArg;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.ui.widget.RoutePlanObserver.IJumpToDownloadListener;

public class NavRoutePlanObserver extends RoutePlanObserver {
    private static final String TAG = NavRoutePlanObserver.class.getSimpleName();
    public boolean isDirectlyEnterNavPage = false;

    public NavRoutePlanObserver(Activity activity, IJumpToDownloadListener l) {
        super(activity, l);
    }

    public void update(BNSubject o, int type, int event, Object arg) {
        if (type == 1 && event == 1 && this.isDirectlyEnterNavPage) {
            NavLogUtils.m3003e(TAG, "update()  isDirectlyEnterNavPage true");
            return;
        }
        if (!NavSearchController.getInstance().isFromMap()) {
            super.update(o, type, event, arg);
        }
        if (type == 1) {
            int subType;
            Message msg;
            switch (event) {
                case 3:
                    NavLogUtils.m3003e(TAG, "update()  EVENT_RP_FAIL");
                    NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                    NavLogUtils.m3003e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                    if (arg != null && (arg instanceof FailArg)) {
                        NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = ((FailArg) arg).mFailType;
                    }
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1031).sendToTarget();
                        return;
                    }
                    return;
                case 6:
                    NavLogUtils.m3003e(TAG, "update()  EVENT_GENERAL_FAIL");
                    NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                    NavLogUtils.m3003e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                    subType = -1;
                    if (arg != null && (arg instanceof FailArg)) {
                        subType = ((FailArg) arg).mFailType;
                        NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = subType;
                    }
                    if (subType >= 0 && BaiduNaviManager.getInstance().getMapHandler() != null) {
                        msg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1003);
                        msg.arg1 = subType;
                        msg.sendToTarget();
                        return;
                    }
                    return;
                case 7:
                    NavLogUtils.m3003e(TAG, "update()  EVENT_ENGINE_FAIL");
                    NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                    NavLogUtils.m3003e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                    subType = -1;
                    if (arg != null && (arg instanceof FailArg)) {
                        subType = ((FailArg) arg).mFailType;
                        NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = subType;
                    }
                    if (subType >= 0 && BaiduNaviManager.getInstance().getMapHandler() != null) {
                        msg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1003);
                        msg.arg1 = subType;
                        msg.sendToTarget();
                        return;
                    }
                    return;
                case 18:
                    NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                    NavLogUtils.m3003e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                    return;
                case 22:
                case 23:
                    return;
                default:
                    return;
            }
        }
    }
}
