package com.baidu.navisdk.logic.commandparser;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import java.util.HashMap;

public class CmdGeneralFunc
  extends CommandBase
{
  public static final int K_TIMEOUT = 10000;
  private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
  private Callback mCallback = null;
  
  public static void addFunc(ReqData paramReqData, Callback paramCallback)
  {
    sCallbackMaps.put(paramReqData, paramCallback);
  }
  
  protected CommandResult exec()
  {
    if (this.mCallback == null) {
      return null;
    }
    return this.mCallback.exec();
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
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mCallback = ((Callback)sCallbackMaps.get(paramReqData));
  }
  
  public static abstract interface Callback
  {
    public abstract CommandResult exec();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdGeneralFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */