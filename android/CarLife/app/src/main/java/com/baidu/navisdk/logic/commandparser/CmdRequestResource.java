package com.baidu.navisdk.logic.commandparser;

import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.logic.HttpGetBase;
import com.baidu.navisdk.logic.NaviErrCode;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

public class CmdRequestResource extends HttpGetBase {
    private static final String SERVER_DOWNRESOURCE_URL_OFFLINE = "http://cp01-rdqa-dev168.cp01.baidu.com:8180/navisdk/checkupdate";
    private static final String SERVER_DOWNRESOURCE_URL_ONLINE = (HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/navisdk/checkupdate");
    private static final String TAG = "CmdRequestResource";

    protected String getUrl() {
        if (LogUtil.LOGGABLE) {
            return SERVER_DOWNRESOURCE_URL_OFFLINE;
        }
        return SERVER_DOWNRESOURCE_URL_ONLINE;
    }

    protected String generateParams() {
        return formatNameValuePair(getRequestParams());
    }

    protected List<NameValuePair> getRequestParams() {
        List<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair("os", "0"));
        params.add(new BasicNameValuePair("pcn", PackageUtil.getPackageName()));
        params.add(new BasicNameValuePair("sv", PackageUtil.getBNaviSDKVersion()));
        params.add(new BasicNameValuePair("cpu", PackageUtil.getCPUType()));
        params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
        return params;
    }

    protected void unpacketParams(ReqData reqdata) {
    }

    protected void parseJson() {
        try {
            int errno = this.mJson.getInt(C2125n.f6745M);
            String errmsg = this.mJson.getString(C2125n.f6746N).toLowerCase();
            LogUtil.m15791e("CmdRequestResource_info", errno + JNISearchConst.LAYER_ID_DIVIDER + errmsg);
            if (errno == 0 && errmsg.equals("success")) {
                this.mRet.setSuccess();
                this.mJson = this.mJson.getJSONObject("data");
                return;
            }
            this.mRet.setAppError(NaviErrCode.getAppError(5));
        } catch (JSONException e) {
            this.mRet.setAppError(3);
        }
    }
}
