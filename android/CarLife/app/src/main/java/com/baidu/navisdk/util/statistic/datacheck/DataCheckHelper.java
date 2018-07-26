package com.baidu.navisdk.util.statistic.datacheck;

import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataCheckHelper {
    private static final int K_TIMEOUT_STATISTICS = 4000;
    public static final String NAVI_URL = NAVI_URL_ONLINE;
    private static final String NAVI_URL_OFFLINE = "http://cq01-rdqa-pool211.cq01.baidu.com:8282/statistics/sendCheck";
    private static final String NAVI_URL_ONLINE = (HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/statistics/sendCheck");
    public static int eventId = -1;
    private static int pushNaviStatisticsRet = 0;
    private static List<NameValuePair> sStatParamsPrefixs = new ArrayList();
    public static JSONObject sUpJson = null;
    public static JSONArray sUpJsonArr = null;

    /* renamed from: com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper$1 */
    static class C47301 extends BNHttpTextResponseHandler {
        C47301() {
        }

        public void onSuccess(int statusCode, String responseString) {
            LogUtil.m15791e("DataCheckHelper", "onSuccess().statusCode=" + statusCode);
            DataCheckHelper.pushNaviStatisticsRet = statusCode;
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            LogUtil.m15791e("DataCheckHelper", "onFailure().statusCode=" + statusCode);
            DataCheckHelper.pushNaviStatisticsRet = statusCode;
        }
    }

    public static void initStatParamsPrefix() {
        LogUtil.m15791e("DataCheckHelper", "initStatParamsPrefix start");
        sStatParamsPrefixs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
        sStatParamsPrefixs.add(new BasicNameValuePair("os", C1253f.jb));
        sStatParamsPrefixs.add(new BasicNameValuePair("ov", PackageUtil.strOSVersion));
        sStatParamsPrefixs.add(new BasicNameValuePair("pcn", PackageUtil.getPackageName()));
        sStatParamsPrefixs.add(new BasicNameValuePair("ch", PackageUtil.getChannel()));
        sStatParamsPrefixs.add(new BasicNameValuePair("mb", PackageUtil.strPhoneType));
        sStatParamsPrefixs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
        LogUtil.m15791e("DataCheckHelper", "initStatParamsPrefix end " + sStatParamsPrefixs.size());
    }

    public static boolean pushNaviStatistics(String upJson) {
        if (upJson == null || upJson.length() == 0) {
            LogUtil.m15791e("DataCheckHelper", "upJson is null");
            return false;
        }
        pushNaviStatisticsRet = 0;
        List<NameValuePair> params = new ArrayList();
        if (sStatParamsPrefixs.isEmpty()) {
            initStatParamsPrefix();
        }
        params.addAll(sStatParamsPrefixs);
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_MAPGESTURE_LONGCLICK, upJson));
        if (LogUtil.LOGGABLE) {
            for (NameValuePair pair : params) {
                LogUtil.m15791e("DataCheckHelper", "push pair name = " + pair.getName() + " value = " + pair.getValue());
            }
        }
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = false;
        BNHttpCenter.getInstance().post(NAVI_URL, BNHttpCenterHelper.formatParams(params), new C47301(), httpParams);
        if (pushNaviStatisticsRet == 200) {
            return true;
        }
        return false;
    }

    public static void uploadDataCheck(String jsonString) {
    }

    public static void reset() {
        sUpJson = new JSONObject();
        sUpJsonArr = new JSONArray();
    }

    public static String getUpJson() {
        return sUpJson.toString();
    }
}
