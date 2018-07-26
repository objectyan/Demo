package com.baidu.navisdk.comapi.verify;

import android.content.Context;
import android.os.Handler;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdSDKVerify;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class BNKeyVerify {
    private static final long EXPIRE_DURATION = 604800000;
    private static final String PREF_LAST_TIME_VERIFIED_SUCC = (BNKeyVerify.class.getSimpleName() + ".lastTimeVerifiedSucc");
    private static final String PREF_VERIFIED_UID = (BNKeyVerify.class.getSimpleName() + ".VerifiedUID");
    private static final int RETRY_1ST_DELAY = 120000;
    private static final int RETRY_COUNT_MAX = 2;
    private static final String TAG = BNKeyVerify.class.getSimpleName();
    private static BNKeyVerify sInstance;
    private Context mContext;
    private boolean mHasVerified;
    private long mLastTimeVerifiedSucc;
    private boolean mVerifiedSucc;
    private long mVerifiedUID;

    private BNKeyVerify() {
        this.mHasVerified = false;
        this.mVerifiedSucc = false;
        this.mLastTimeVerifiedSucc = 0;
        this.mVerifiedUID = -1;
        this.mVerifiedUID = PreferenceHelper.getInstance(this.mContext).getLong(PREF_VERIFIED_UID, -1);
        this.mLastTimeVerifiedSucc = PreferenceHelper.getInstance(this.mContext).getLong(PREF_LAST_TIME_VERIFIED_SUCC, 0);
    }

    public static synchronized BNKeyVerify getInstance() {
        BNKeyVerify bNKeyVerify;
        synchronized (BNKeyVerify.class) {
            if (sInstance == null) {
                sInstance = new BNKeyVerify();
            }
            bNKeyVerify = sInstance;
        }
        return bNKeyVerify;
    }

    public boolean isVerificationExpired() {
        if (System.currentTimeMillis() - this.mLastTimeVerifiedSucc > 604800000) {
            return true;
        }
        return false;
    }

    public boolean asyncVerify(String accessKey, Handler handler) {
        this.mVerifiedUID = PreferenceHelper.getInstance(this.mContext).getLong(PREF_VERIFIED_UID, -1);
        this.mLastTimeVerifiedSucc = PreferenceHelper.getInstance(this.mContext).getLong(PREF_LAST_TIME_VERIFIED_SUCC, 0);
        if (!isVerificationExpired()) {
            return false;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_SDKOP_VERIFY, 4, handler, CommandConst.K_MSG_SDKOP_VERIFY, 100000);
        reqdata.mRetryTimes = 2;
        reqdata.mRetryIntervals = RETRY_1ST_DELAY;
        CmdSDKVerify.packetParams(reqdata, accessKey);
        CommandCenter.getInstance().sendRequest(reqdata);
        return true;
    }

    public long getVerifiedUID() {
        this.mVerifiedUID = PreferenceHelper.getInstance(this.mContext).getLong(PREF_VERIFIED_UID, -1);
        return this.mVerifiedUID;
    }

    public void setVerifiedUID(long uid) {
        PreferenceHelper.getInstance(this.mContext).putLong(PREF_VERIFIED_UID, uid);
        PreferenceHelper.getInstance(this.mContext).putLong(PREF_LAST_TIME_VERIFIED_SUCC, System.currentTimeMillis());
    }
}
