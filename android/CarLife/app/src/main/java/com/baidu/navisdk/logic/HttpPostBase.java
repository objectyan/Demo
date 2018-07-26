package com.baidu.navisdk.logic;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpPostBase extends CommandBase {
    private static final int K_TIMEOUT_CONNECTION = 3000;
    private static final int K_TIMEOUT_SOCKET = 5000;
    private static final String TAG = "HttpCommandBase";
    protected JSONObject mJson;

    /* renamed from: com.baidu.navisdk.logic.HttpPostBase$1 */
    class C41361 extends BNHttpTextResponseHandler {
        C41361() {
        }

        public void onSuccess(int statusCode, String responseString) {
            LogUtil.m15791e(HttpPostBase.TAG, "exec.ok statusCode=" + statusCode + ", s=" + responseString);
            if (TextUtils.isEmpty(responseString)) {
                HttpPostBase.this.mRet.set(NaviErrCode.getAppError(4));
                return;
            }
            try {
                HttpPostBase.this.mJson = new JSONObject(responseString);
                HttpPostBase.this.mRet.setSuccess();
            } catch (JSONException e) {
                HttpPostBase.this.mRet.set(NaviErrCode.getAppError(3));
            }
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            LogUtil.m15791e(HttpPostBase.TAG, "exec.err statusCode=" + statusCode + ", s=" + responseString);
            HttpPostBase.this.mRet.set(NaviErrCode.getAppError(5));
        }
    }

    protected abstract List<NameValuePair> generateParams();

    protected abstract String getUrl();

    protected void parseJson() {
    }

    protected CommandResult exec() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            LogUtil.m15791e(TAG, "exec() url=" + getUrl());
            BNHttpParams httpParams = new BNHttpParams();
            httpParams.isAsync = false;
            BNHttpCenter.getInstance().post(getUrl(), BNHttpCenterHelper.formatParams(generateParams()), new C41361(), httpParams);
            if (!this.mRet.isSuccess()) {
                return this.mRet;
            }
            parseJson();
            if (this.mRet.isSuccess()) {
                handleSuccess();
            } else {
                handleError();
            }
            return this.mRet;
        }
        this.mRet.set(NaviErrCode.getSDKError(1));
        return this.mRet;
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent && this.mReqData.mRetryTimes == 1) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mJson);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }
}
