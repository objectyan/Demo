package com.baidu.navisdk.logic.commandparser;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpPostBase;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class CmdGeneralHttpPostFunc
  extends HttpPostBase
{
  public static final int K_TIMEOUT = 10000;
  public static final String TAG = CmdGeneralHttpPostFunc.class.getSimpleName();
  private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
  private Callback mCallback = null;
  
  public static void addFunc(ReqData paramReqData, Callback paramCallback)
  {
    sCallbackMaps.put(paramReqData, paramCallback);
  }
  
  protected CommandResult exec()
  {
    if ((this.mCallback == null) || (this.mCallback.getRequestType() == 1)) {
      return super.exec();
    }
    return null;
  }
  
  protected List<NameValuePair> generateParams()
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
    this.mCallback = ((Callback)sCallbackMaps.get(paramReqData));
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdGeneralHttpPostFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */