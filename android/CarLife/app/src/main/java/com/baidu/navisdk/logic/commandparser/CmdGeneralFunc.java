package com.baidu.navisdk.logic.commandparser;

import android.os.Message;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import java.util.HashMap;

public class CmdGeneralFunc extends CommandBase {
    public static final int K_TIMEOUT = 10000;
    private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
    private Callback mCallback = null;

    public interface Callback {
        CommandResult exec();
    }

    public static void addFunc(ReqData reqdata, Callback cb) {
        sCallbackMaps.put(reqdata, cb);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mCallback = (Callback) sCallbackMaps.get(reqdata);
    }

    protected CommandResult exec() {
        if (this.mCallback == null) {
            return null;
        }
        return this.mCallback.exec();
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
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
}
