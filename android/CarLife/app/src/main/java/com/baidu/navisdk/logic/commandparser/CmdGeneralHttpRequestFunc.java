package com.baidu.navisdk.logic.commandparser;

import android.os.Handler;
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
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class CmdGeneralHttpRequestFunc
  extends HttpGetBase
{
  public static final int K_TIMEOUT = 10000;
  public static final String TAG = CmdGeneralHttpRequestFunc.class.getSimpleName();
  private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
  byte[] images = null;
  private Callback mCallback = null;
  
  public static void addFunc(ReqData paramReqData, Callback paramCallback)
  {
    sCallbackMaps.put(paramReqData, paramCallback);
  }
  
  private CommandResult requestImage()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      this.mRet.set(NaviErrCode.getSDKError(1));
      return this.mRet;
    }
    LogUtil.e(TAG, "exec() url=" + getUrl());
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = false;
    BNHttpCenter.getInstance().get(getUrl(), BNHttpCenterHelper.formatParams(getRequestParams()), new BNHttpBinaryResponseHandler()
    {
      public void onFailure(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        LogUtil.e(CmdGeneralHttpRequestFunc.TAG, "exec.err statusCode=" + paramAnonymousInt);
        CmdGeneralHttpRequestFunc.this.mRet.set(NaviErrCode.getAppError(5));
      }
      
      public void onSuccess(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        LogUtil.e(CmdGeneralHttpRequestFunc.TAG, "exec.ok statusCode=" + paramAnonymousInt);
        if (paramAnonymousArrayOfByte == null)
        {
          CmdGeneralHttpRequestFunc.this.mRet.set(NaviErrCode.getAppError(4));
          return;
        }
        CmdGeneralHttpRequestFunc.this.images = paramAnonymousArrayOfByte;
        CmdGeneralHttpRequestFunc.this.mRet.setSuccess();
      }
    }, localBNHttpParams);
    if (!this.mRet.isSuccess()) {
      return this.mRet;
    }
    if ((this.images != null) && (this.mCallback != null)) {
      this.mCallback.responseImage(this.images);
    }
    if (this.mRet.isSuccess()) {
      handleSuccess();
    }
    for (;;)
    {
      return this.mRet;
      handleError();
    }
  }
  
  protected CommandResult exec()
  {
    if ((this.mCallback == null) || (this.mCallback.getRequestType() == 1)) {
      return super.exec();
    }
    if (2 == this.mCallback.getRequestType()) {
      return requestImage();
    }
    return null;
  }
  
  protected String generateParams()
  {
    if (this.mCallback != null) {
      return formatNameValuePair(this.mCallback.getRequestParams());
    }
    return null;
  }
  
  protected List<NameValuePair> getRequestParams()
  {
    if (this.mCallback != null) {
      return this.mCallback.getRequestParams();
    }
    return null;
  }
  
  protected String getUrl()
  {
    if (this.mCallback != null) {
      return this.mCallback.getUrl();
    }
    return null;
  }
  
  protected void handleError()
  {
    if (!this.mReqData.mHasMsgSent)
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = this.mRet.mErrCode;
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void handleSuccess()
  {
    if (!this.mReqData.mHasMsgSent)
    {
      LogUtil.e(TAG, "exec() handleSuccess");
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.obj = new RspData(this.mReqData, this.mJson);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void parseJson()
  {
    if (this.mCallback != null) {
      this.mCallback.parseResponseJSON(this.mJson);
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mCallback = ((Callback)sCallbackMaps.remove(paramReqData));
  }
  
  public static abstract interface Callback
  {
    public static final int REQUEST_TYPE_BYTE = 2;
    public static final int REQUEST_TYPE_JSON = 1;
    
    public abstract List<NameValuePair> getRequestParams();
    
    public abstract int getRequestType();
    
    public abstract String getUrl();
    
    public abstract boolean parseResponseJSON(JSONObject paramJSONObject);
    
    public abstract void responseImage(byte[] paramArrayOfByte);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */