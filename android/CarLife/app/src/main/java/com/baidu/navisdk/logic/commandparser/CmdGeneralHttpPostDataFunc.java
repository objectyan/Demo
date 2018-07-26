package com.baidu.navisdk.logic.commandparser;

import android.os.Message;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpPostDataBase;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import org.apache.http.entity.mime.MultipartEntity;
import org.json.JSONObject;

public class CmdGeneralHttpPostDataFunc extends HttpPostDataBase {
    public static final int K_TIMEOUT = 10000;
    public static final String TAG = CmdGeneralHttpPostDataFunc.class.getSimpleName();
    private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
    private Callback mCallback = null;

    public interface Callback {
        public static final int REQUEST_TYPE_BYTE = 2;
        public static final int REQUEST_TYPE_JSON = 1;

        MultipartEntity getMultipartEntity();

        int getRequestType();

        String getUrl();

        boolean parseResponseJSON(JSONObject jSONObject);
    }

    public static void addFunc(ReqData reqdata, Callback cb) {
        sCallbackMaps.put(reqdata, cb);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mCallback = (Callback) sCallbackMaps.get(reqdata);
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
        return null;
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

    protected MultipartEntity getMultipartEntity() {
        if (this.mCallback != null) {
            return this.mCallback.getMultipartEntity();
        }
        return null;
    }
}
