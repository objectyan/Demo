package com.baidu.navisdk.comapi.routeplan;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailType;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.NE_RoutePlan_Result;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNRoutePlanHelper {
    public static String transferGeneralFailTypeToString(int failType) {
        int tipID = -1;
        switch (failType) {
            case 5000:
                tipID = C4048R.string.nsdk_string_rp_toast_route_node_not_complete;
                break;
            case 5001:
                tipID = C4048R.string.nsdk_string_rp_start_or_dest_invalid;
                break;
            case 5002:
                tipID = C4048R.string.nsdk_string_rp_toast_fail_too_close;
                break;
            case FailType.ROUTE_PLAN_TOAST_ACTIVATE_NETWORK_UNCONNECTED /*5030*/:
                tipID = C4048R.string.nsdk_string_rp_toast_network_unconnected;
                break;
            case FailType.ROUTEPLAN_ON2OFF_NETWORK_ERROR /*5031*/:
                tipID = C4048R.string.nsdk_string_rp_on2off_network_error;
                break;
            case FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED /*5050*/:
                tipID = C4048R.string.nsdk_string_rp_toast_calc_route_failed;
                break;
            case FailType.ROUTE_PLAN_TOAST_SET_START_FAILED /*5051*/:
                tipID = C4048R.string.nsdk_string_rp_toast_set_start_failed;
                break;
            case FailType.ROUTE_PLAN_TOAST_SET_END_FAILED /*5052*/:
                tipID = C4048R.string.nsdk_string_rp_toast_set_end_failed;
                break;
            case FailType.ROUTE_PLAN_TOAST_OFFLINE_AVOID_TAFFICJAM_ERROR /*5053*/:
                tipID = C4048R.string.nsdk_string_rp_toast_offline_avoid_tafficjam_error;
                break;
            case FailType.ROUTE_PLAN_TOAST_LOC_INVALID /*5200*/:
                tipID = C4048R.string.nsdk_string_rp_toast_loc_invalid;
                break;
        }
        if (tipID == -1) {
            return JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_toast_calc_route_failed);
        }
        try {
            return JarUtils.getResources().getString(tipID);
        } catch (Exception e) {
            return "";
        }
    }

    public static String transferEngineFailTypeToString(int reasonType) {
        int id = -1;
        switch (reasonType) {
            case 400:
                id = C4048R.string.nsdk_string_rp_toast_fail_low_version;
                break;
            case 401:
                id = C4048R.string.nsdk_string_rp_toast_fail_wrong_version;
                break;
            case 402:
                id = C4048R.string.nsdk_string_rp_toast_fail_no_start;
                break;
            case 403:
                id = C4048R.string.nsdk_string_rp_toast_fail_no_stop;
                break;
            case 404:
                id = C4048R.string.nsdk_string_rp_toast_fail_wrong_coord;
                break;
            case 406:
                id = C4048R.string.nsdk_string_rp_toast_fail_calc_cancel;
                break;
            case 413:
                id = C4048R.string.nsdk_string_rp_toast_fail_start_deviate;
                break;
            case 414:
                id = C4048R.string.nsdk_string_rp_toast_fail_dest1_deviate;
                break;
            case 415:
                id = C4048R.string.nsdk_string_rp_toast_fail_dest2_deviate;
                break;
            case 416:
                id = C4048R.string.nsdk_string_rp_toast_fail_dest3_deviate;
                break;
            case 417:
                id = C4048R.string.nsdk_string_rp_toast_fail_dest4_deviate;
                break;
            case NE_RoutePlan_Result.ROUTEPLAN_RESULT_FAIL_DEST5_DEVIATE /*418*/:
                id = C4048R.string.nsdk_string_rp_toast_fail_dest5_deviate;
                break;
            case 419:
                id = C4048R.string.nsdk_string_rp_toast_fail_too_close;
                break;
            case 420:
                boolean[] data = new boolean[35];
                if (BNRoutePlaner.getInstance().getLackOfData(data)) {
                    if (data[0]) {
                        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_start_or_dest_invalid);
                    }
                    return getLackOfDataTips(data);
                }
                break;
            case 423:
                id = C4048R.string.nsdk_string_rp_toast_fail_calc_fail;
                break;
            case NE_RoutePlan_Result.ROUTEPLAN_RESULT_FAIL_NETWORK_ERROR /*450*/:
                id = C4048R.string.nsdk_string_rp_toast_network_unconnected;
                break;
            case 9000:
                id = C4048R.string.nsdk_string_rp_toast_fail_district_error;
                break;
        }
        if (id == -1) {
            return JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_toast_calc_route_failed);
        }
        try {
            return JarUtils.getResources().getString(id);
        } catch (Exception e) {
            return "晕，小度不知怎么走了，请重试一次吧~";
        }
    }

    private static String getLackOfDataTips(boolean[] data) {
        String tip = JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_lack_data_tips);
        String city = null;
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                if (StringUtils.isEmpty(city)) {
                    city = JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);
                } else {
                    city = city + "、" + JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);
                }
            }
        }
        if (StringUtils.isNotEmpty(city)) {
            return tip + city;
        }
        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_lack_of_some_data);
    }

    public static String getLackOfDataCities(boolean[] data) {
        String city = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                if (StringUtils.isEmpty(city)) {
                    try {
                        city = JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);
                    } catch (Throwable th) {
                    }
                } else {
                    try {
                        String temp = JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);
                        if (!(StringUtils.isEmpty(temp) || temp.equals("null"))) {
                            city = city + "、" + temp;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return city;
    }
}
