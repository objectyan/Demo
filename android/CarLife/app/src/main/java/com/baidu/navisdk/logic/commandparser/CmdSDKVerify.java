package com.baidu.navisdk.logic.commandparser;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.verify.BNKeyVerify;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.HttpPostBase;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class CmdSDKVerify extends HttpPostBase {
    private static final String K_LBS_SERVICE_NAVI_SDK = "lbs_navsdk";
    private static final String URL = (HttpURLManager.getInstance().getScheme() + "sapi.map.baidu.com/sdkcs/verify");
    String mAccessKey;
    String mCode;
    int mVerifiedUID;

    public static void packetParams(ReqData reqdata, String accessKey) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SDKOP_VERIFYACCESSKEY, accessKey);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mAccessKey = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SDKOP_VERIFYACCESSKEY);
    }

    protected String getUrl() {
        return URL;
    }

    protected List<NameValuePair> generateParams() {
        List<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair("ak", this.mAccessKey));
        params.add(new BasicNameValuePair("mcode", PackageUtil.getAuthString(BNaviModuleManager.getContext())));
        params.add(new BasicNameValuePair(PlatformConstants.CONNECT_EXTRA_KEY, K_LBS_SERVICE_NAVI_SDK));
        params.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
        return params;
    }

    protected void parseJson() {
        try {
            int state = this.mJson.optInt("status", -1);
            long uid = this.mJson.optLong("uid", -1);
            String msg = this.mJson.optString(PushConstants.EXTRA_PUSH_MESSAGE);
            if (state == 0) {
                BNKeyVerify.getInstance().setVerifiedUID(uid);
                this.mRet.setSuccess();
                return;
            }
            this.mRet.setSDKError(5);
        } catch (Exception e) {
            this.mRet.setSDKError(3);
        }
    }
}
