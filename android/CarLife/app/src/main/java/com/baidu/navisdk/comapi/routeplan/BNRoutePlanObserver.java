package com.baidu.navisdk.comapi.routeplan;

import android.view.View.OnClickListener;
import com.baidu.navisdk.comapi.base.BNObserver;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;

public interface BNRoutePlanObserver extends BNObserver {
    public static final int EVENT_BEFORE = 1;
    public static final int EVENT_ENGINE_FAIL = 7;
    public static final int EVENT_GENERAL_FAIL = 6;
    public static final int EVENT_NETWORK_CONFIRM = 9;
    public static final int EVENT_NETWORK_NOTICE = 8;
    public static final int EVENT_NO_NET_NO_DATA_CONFIRM = 19;
    public static final int EVENT_NO_NET_NO_DATA_NOTICE = 18;
    public static final int EVENT_RECALC_CONFIRM = 17;
    public static final int EVENT_RECALC_NOTICE = 16;
    public static final int EVENT_RP_FAIL = 3;
    public static final int EVENT_RP_OFFLINE_TO_ONLINE = 20;
    public static final int EVENT_RP_ONLINE_TO_OFFLINE = 21;
    public static final int EVENT_RP_SUCCUSS = 2;
    public static final int EVENT_RP_YAWING_FAIL = 5;
    public static final int EVENT_RP_YAWING_SUCCUSS = 4;
    public static final int EVENT_Update_RoadCondition_Failed = 23;
    public static final int EVENT_Update_RoadCondition_Success = 22;
    public static final int TYPE_AVOID_TRAFFICJAM = 3;
    public static final int TYPE_OFFLINEDATA_LACK = 2;
    public static final int TYPE_ONLINE_NETWORK_ERROR = 4;
    public static final int TYPE_ONLINE_NO_NET_NO_DATA = 6;
    public static final int TYPE_ONLINE_OVERTIME = 5;
    public static final int TYPE_ROUTE_PLAN = 1;
    public static final int TYPE_ROUTE_PLAN_FIRST = 7;
    public static final int TYPE_SET_START_POS_OK = 17;

    public static class ConfirmArg {
        public OnClickListener mConfirmListener;
    }

    public static class ConfirmOTArg {
        public OnNaviClickListener mConfirmListener;
        public String mTipStr;
    }

    public static class FailArg {
        public String mFailText;
        public int mFailType;
    }

    public static class FailType {
        public static final int PERMISSION_DENIED = 5092;
        public static final int ROUTEPLAN_ON2OFF_NETWORK_ERROR = 5031;
        public static final int ROUTE_PLAN_DISTRICT_GET_FAILD = 5055;
        public static final int ROUTE_PLAN_LOC_SERVICE_UNSTART = 5201;
        public static final int ROUTE_PLAN_NEED_WAIT_BY_LAST_CANCEL = 5054;
        public static final int ROUTE_PLAN_PARSE_GET_ROUTEINFO_ERROR = 5060;
        public static final int ROUTE_PLAN_SEARCH_FAILED = 5100;
        public static final int ROUTE_PLAN_TOAST_ACTIVATE_NETWORK_UNCONNECTED = 5030;
        public static final int ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED = 5050;
        public static final int ROUTE_PLAN_TOAST_FAIL_TOO_CLOSE = 5002;
        public static final int ROUTE_PLAN_TOAST_LOC_INVALID = 5200;
        public static final int ROUTE_PLAN_TOAST_OFFLINE_AVOID_TAFFICJAM_ERROR = 5053;
        public static final int ROUTE_PLAN_TOAST_ROUTE_NODE_NOT_COMPLETE = 5000;
        public static final int ROUTE_PLAN_TOAST_SET_END_FAILED = 5052;
        public static final int ROUTE_PLAN_TOAST_SET_START_FAILED = 5051;
        public static final int ROUTE_PLAN_TOAST_SET_START_FAILED_FOR_APP_GUIDANCE_IS_NULL = 5090;
        public static final int ROUTE_PLAN_TOAST_SET_START_FAILED_FOR_APP_START_IS_NULL = 5091;
        public static final int ROUTE_PLAN_TOAST_SET_START_FAILED_FOR_ENGINE_HANDLE_IS_NULL = 5059;
        public static final int ROUTE_PLAN_TOAST_START_OR_DEST_INVALID = 5001;
    }

    public static class LackDataArg {
        public String mLackDataText;
    }
}
