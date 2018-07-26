package com.baidu.navisdk.hudsdk;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PackageUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class HudSwitchReq {
    public static void asyncHudAuth(int type, final Bundle bundle, Handler handler) {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, handler, type, 10000);
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
            public void responseImage(byte[] img) {
            }

            public boolean parseResponseJSON(JSONObject jsonObj) {
                return false;
            }

            public String getUrl() {
                return BNRemoteConstants.HUDSDK_SWITCH_URL_ONLINE;
            }

            public int getRequestType() {
                return 1;
            }

            public List<NameValuePair> getRequestParams() {
                List<NameValuePair> valuePairs = new ArrayList();
                StringBuffer sb = new StringBuffer();
                try {
                    int cityId = HudSwitchReq.getCityID();
                    valuePairs.add(new BasicNameValuePair("city_id", String.valueOf(cityId)));
                    sb.append("city_id=");
                    sb.append(URLEncoder.encode(String.valueOf(cityId), "utf-8"));
                    valuePairs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                    sb.append("&cuid=");
                    sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
                    valuePairs.add(new BasicNameValuePair("os", String.valueOf(0)));
                    sb.append("&os=");
                    sb.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
                    if (bundle != null) {
                        String hudAppPkg = bundle.getString("hudAppPkg");
                        String hudAppVer = bundle.getString("hudVer");
                        valuePairs.add(new BasicNameValuePair("pcn", hudAppPkg));
                        sb.append("&pcn=");
                        sb.append(URLEncoder.encode(hudAppPkg, "utf-8"));
                        valuePairs.add(new BasicNameValuePair("sdk_sv", hudAppVer));
                        sb.append("&sdk_sv=");
                        sb.append(URLEncoder.encode(hudAppVer, "utf-8"));
                    }
                    valuePairs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
                    sb.append("&sv=");
                    sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
                    valuePairs.add(new BasicNameValuePair("sign", MD5.toMD5(NaviStatConstants.K_NSC_KEY_HUDSDK + sb.toString() + "1d51214e51fe24490ae78dc8ed8b5114").toLowerCase()));
                    LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "asynPullRoadList getRequestParams= " + valuePairs.toString());
                    return valuePairs;
                } catch (UnsupportedEncodingException e) {
                    return null;
                }
            }
        });
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    private static int getCityID() {
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            return district.mId;
        }
        return NaviFragmentManager.TYPE_CAR_DRV_LIST;
    }
}
