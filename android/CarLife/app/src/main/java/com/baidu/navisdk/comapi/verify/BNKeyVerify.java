package com.baidu.navisdk.comapi.verify;

import android.content.Context;
import android.os.Handler;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdSDKVerify;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class BNKeyVerify
{
  private static final long EXPIRE_DURATION = 604800000L;
  private static final String PREF_LAST_TIME_VERIFIED_SUCC = BNKeyVerify.class.getSimpleName() + ".lastTimeVerifiedSucc";
  private static final String PREF_VERIFIED_UID = BNKeyVerify.class.getSimpleName() + ".VerifiedUID";
  private static final int RETRY_1ST_DELAY = 120000;
  private static final int RETRY_COUNT_MAX = 2;
  private static final String TAG = BNKeyVerify.class.getSimpleName();
  private static BNKeyVerify sInstance;
  private Context mContext;
  private boolean mHasVerified = false;
  private long mLastTimeVerifiedSucc = 0L;
  private boolean mVerifiedSucc = false;
  private long mVerifiedUID = -1L;
  
  public static BNKeyVerify getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new BNKeyVerify();
      }
      BNKeyVerify localBNKeyVerify = sInstance;
      return localBNKeyVerify;
    }
    finally {}
  }
  
  public boolean asyncVerify(String paramString, Handler paramHandler)
  {
    this.mVerifiedUID = PreferenceHelper.getInstance(this.mContext).getLong(PREF_VERIFIED_UID, -1L);
    this.mLastTimeVerifiedSucc = PreferenceHelper.getInstance(this.mContext).getLong(PREF_LAST_TIME_VERIFIED_SUCC, 0L);
    if (!isVerificationExpired()) {
      return false;
    }
    paramHandler = new ReqData("cmd.sdkop.verify", 4, paramHandler, 1302, 100000);
    paramHandler.mRetryTimes = 2;
    paramHandler.mRetryIntervals = 120000;
    CmdSDKVerify.packetParams(paramHandler, paramString);
    CommandCenter.getInstance().sendRequest(paramHandler);
    return true;
  }
  
  public long getVerifiedUID()
  {
    this.mVerifiedUID = PreferenceHelper.getInstance(this.mContext).getLong(PREF_VERIFIED_UID, -1L);
    return this.mVerifiedUID;
  }
  
  public boolean isVerificationExpired()
  {
    return System.currentTimeMillis() - this.mLastTimeVerifiedSucc > 604800000L;
  }
  
  public void setVerifiedUID(long paramLong)
  {
    PreferenceHelper.getInstance(this.mContext).putLong(PREF_VERIFIED_UID, paramLong);
    PreferenceHelper.getInstance(this.mContext).putLong(PREF_LAST_TIME_VERIFIED_SUCC, System.currentTimeMillis());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/verify/BNKeyVerify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */