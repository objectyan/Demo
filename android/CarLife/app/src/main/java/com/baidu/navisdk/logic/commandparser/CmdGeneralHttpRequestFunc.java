package com.baidu.navisdk.logic.commandparser;

import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpGetBase;
import com.baidu.navisdk.logic.NaviErrCode;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class CmdGeneralHttpRequestFunc extends HttpGetBase {
    public static final int K_TIMEOUT = 10000;
    public static final String TAG = CmdGeneralHttpRequestFunc.class.getSimpleName();
    private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
    byte[] images = null;
    private Callback mCallback = null;

    public interface Callback {
        public static final int REQUEST_TYPE_BYTE = 2;
        public static final int REQUEST_TYPE_JSON = 1;

        List<NameValuePair> getRequestParams();

        int getRequestType();

        String getUrl();

        boolean parseResponseJSON(JSONObject jSONObject);

        void responseImage(byte[] bArr);
    }

    /* renamed from: com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc$1 */
    class C41381 extends BNHttpBinaryResponseHandler {
        C41381() {
        }

        public void onSuccess(int statusCode, byte[] binaryData) {
            LogUtil.m15791e(CmdGeneralHttpRequestFunc.TAG, "exec.ok statusCode=" + statusCode);
            if (binaryData == null) {
                CmdGeneralHttpRequestFunc.this.mRet.set(NaviErrCode.getAppError(4));
                return;
            }
            CmdGeneralHttpRequestFunc.this.images = binaryData;
            CmdGeneralHttpRequestFunc.this.mRet.setSuccess();
        }

        public void onFailure(int statusCode, byte[] binaryData, Throwable throwable) {
            LogUtil.m15791e(CmdGeneralHttpRequestFunc.TAG, "exec.err statusCode=" + statusCode);
            CmdGeneralHttpRequestFunc.this.mRet.set(NaviErrCode.getAppError(5));
        }
    }

    public static void addFunc(ReqData reqdata, Callback cb) {
        sCallbackMaps.put(reqdata, cb);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mCallback = (Callback) sCallbackMaps.remove(reqdata);
    }

    protected void parseJson() {
        if (this.mCallback != null) {
            this.mCallback.parseResponseJSON(this.mJson);
        }
    }

    protected CommandResult exec() {
        if (this.mCallback == null || this.mCallback.getRequestType() == 1) {
            return super.exec();
        }
        if (2 == this.mCallback.getRequestType()) {
            return requestImage();
        }
        return null;
    }

    private CommandResult requestImage() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            LogUtil.m15791e(TAG, "exec() url=" + getUrl());
            BNHttpParams httpParams = new BNHttpParams();
            httpParams.isAsync = false;
            BNHttpCenter.getInstance().get(getUrl(), BNHttpCenterHelper.formatParams(getRequestParams()), new C41381(), httpParams);
            if (!this.mRet.isSuccess()) {
                return this.mRet;
            }
            if (!(this.images == null || this.mCallback == null)) {
                this.mCallback.responseImage(this.images);
            }
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
        if (!this.mReqData.mHasMsgSent) {
            LogUtil.m15791e(TAG, "exec() handleSuccess");
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mJson);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void handleError() {
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = this.mRet.mErrCode;
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected String getUrl() {
        if (this.mCallback != null) {
            return this.mCallback.getUrl();
        }
        return null;
    }

    protected String generateParams() {
        if (this.mCallback != null) {
            return formatNameValuePair(this.mCallback.getRequestParams());
        }
        return null;
    }

    protected List<NameValuePair> getRequestParams() {
        if (this.mCallback != null) {
            return this.mCallback.getRequestParams();
        }
        return null;
    }
}
