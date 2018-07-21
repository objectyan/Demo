package com.baidu.navisdk.logic;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpPostBase
  extends CommandBase
{
  private static final int K_TIMEOUT_CONNECTION = 3000;
  private static final int K_TIMEOUT_SOCKET = 5000;
  private static final String TAG = "HttpCommandBase";
  protected JSONObject mJson;
  
  protected CommandResult exec()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      this.mRet.set(NaviErrCode.getSDKError(1));
      return this.mRet;
    }
    LogUtil.e("HttpCommandBase", "exec() url=" + getUrl());
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = false;
    BNHttpCenter.getInstance().post(getUrl(), BNHttpCenterHelper.formatParams(generateParams()), new BNHttpTextResponseHandler()
    {
      public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        LogUtil.e("HttpCommandBase", "exec.err statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
        HttpPostBase.this.mRet.set(NaviErrCode.getAppError(5));
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        LogUtil.e("HttpCommandBase", "exec.ok statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          HttpPostBase.this.mRet.set(NaviErrCode.getAppError(4));
          return;
        }
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          HttpPostBase.this.mJson = paramAnonymousString;
          HttpPostBase.this.mRet.setSuccess();
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          HttpPostBase.this.mRet.set(NaviErrCode.getAppError(3));
        }
      }
    }, localBNHttpParams);
    if (!this.mRet.isSuccess()) {
      return this.mRet;
    }
    parseJson();
    if (this.mRet.isSuccess()) {
      handleSuccess();
    }
    for (;;)
    {
      return this.mRet;
      handleError();
    }
  }
  
  protected abstract List<NameValuePair> generateParams();
  
  protected abstract String getUrl();
  
  protected void handleSuccess()
  {
    if ((!this.mReqData.mHasMsgSent) && (this.mReqData.mRetryTimes == 1))
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.obj = new RspData(this.mReqData, this.mJson);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void parseJson() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/HttpPostBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */