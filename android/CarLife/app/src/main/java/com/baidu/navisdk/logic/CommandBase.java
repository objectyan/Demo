package com.baidu.navisdk.logic;

import com.baidu.navisdk.util.common.LogUtil;
import java.io.Serializable;

public abstract class CommandBase implements CommandConst {
    protected ReqData mReqData;
    protected CommandResult mRet = new CommandResult();

    protected abstract CommandResult exec();

    protected abstract void unpacketParams(ReqData reqData);

    public CommandResult execute(ReqData reqdata) {
        this.mReqData = reqdata;
        unpacketParams(reqdata);
        this.mRet = exec();
        if (this.mRet == null) {
            LogUtil.m15791e("CommandBase", "warning: the command result is null.");
            this.mRet = new CommandResult(NaviErrCode.RET_RESULT_IS_NULL);
        }
        if (this.mRet == null || !this.mRet.isSuccess()) {
            handleError();
        } else {
            handleSuccess();
        }
        return this.mRet;
    }

    protected void handleSuccess() {
    }

    protected void handleError() {
        if (this.mReqData != null && this.mRet != null) {
            LogUtil.m15791e("", "------------------------------\nhandler:" + this.mReqData.mHandler + "    \nError=" + this.mRet.mErrCode + "    \nstrdebug:" + this.mRet.mErrDebug + "    \nstruser:" + this.mRet.mErrForUser);
        }
    }

    public RspData getFromCache(ReqData reqdata) {
        return null;
    }

    public String getCacheKey() {
        return null;
    }

    public Serializable serializeCache(RspData msg) {
        return null;
    }

    public RspData deserializeCache(Serializable data) {
        return null;
    }
}
