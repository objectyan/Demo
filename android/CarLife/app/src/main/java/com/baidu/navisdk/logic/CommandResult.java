package com.baidu.navisdk.logic;

import android.content.res.Resources;

public class CommandResult {
    public int mErrCode;
    public String mErrDebug;
    public String mErrForUser;
    public Object mUserObject;

    public static void mapErrInfo(Resources resource, CommandResult result) {
        if (result.mErrForUser != null && result.mErrForUser.length() <= 0) {
        }
    }

    public CommandResult() {
        reset();
    }

    public CommandResult(int errCode) {
        this();
        set(errCode);
    }

    public CommandResult(int errCode, String errDebug, String errForUser) {
        this();
        set(errCode, errDebug, errForUser);
    }

    public void reset() {
        this.mErrCode = NaviErrCode.RET_INIT;
        this.mErrDebug = "";
        this.mErrForUser = "";
        this.mUserObject = null;
    }

    public boolean isNetworkErr() {
        return false;
    }

    public static boolean isNetworkErr(int errCode) {
        if ((errCode < NaviErrCode.getAppError(0) || errCode > NaviErrCode.getAppError(2)) && (errCode < NaviErrCode.getSDKError(0) || errCode > NaviErrCode.getSDKError(2))) {
            return false;
        }
        return true;
    }

    public boolean isSuccess() {
        if (this.mErrCode == 0) {
            return true;
        }
        return false;
    }

    public void set(int errCode, String errDebug, String errForUser) {
        this.mErrCode = errCode;
        if (errDebug == null) {
            errDebug = "";
        }
        this.mErrDebug = errDebug;
        if (errForUser == null) {
            errForUser = "";
        }
        this.mErrForUser = errForUser;
    }

    public void setSuccess() {
        this.mErrCode = 0;
    }

    public void setSuccess(String errForUser) {
        setSuccess();
        this.mErrForUser = errForUser;
    }

    public void set(int errCode, String errDebug) {
        set(errCode, errDebug, null);
    }

    public void set(int errCode) {
        set(errCode, null, null);
    }

    public void setSDKError(int errCode) {
        set(errCode + 5000, null, null);
    }

    public void setAppError(int errCode) {
        set(errCode + 6000, null, null);
    }

    public void set(CommandResult src) {
        set(src.mErrCode, src.mErrDebug, src.mErrForUser);
    }
}
