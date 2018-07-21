package com.baidu.navisdk.logic;

import com.baidu.navisdk.util.common.LogUtil;
import java.io.Serializable;

public abstract class CommandBase
  implements CommandConst
{
  protected ReqData mReqData;
  protected CommandResult mRet = new CommandResult();
  
  public RspData deserializeCache(Serializable paramSerializable)
  {
    return null;
  }
  
  protected abstract CommandResult exec();
  
  public CommandResult execute(ReqData paramReqData)
  {
    this.mReqData = paramReqData;
    unpacketParams(paramReqData);
    this.mRet = exec();
    if (this.mRet == null)
    {
      LogUtil.e("CommandBase", "warning: the command result is null.");
      this.mRet = new CommandResult(55538);
    }
    if ((this.mRet != null) && (this.mRet.isSuccess())) {
      handleSuccess();
    }
    for (;;)
    {
      return this.mRet;
      handleError();
    }
  }
  
  public String getCacheKey()
  {
    return null;
  }
  
  public RspData getFromCache(ReqData paramReqData)
  {
    return null;
  }
  
  protected void handleError()
  {
    if ((this.mReqData != null) && (this.mRet != null)) {
      LogUtil.e("", "------------------------------\nhandler:" + this.mReqData.mHandler + "    \nError=" + this.mRet.mErrCode + "    \nstrdebug:" + this.mRet.mErrDebug + "    \nstruser:" + this.mRet.mErrForUser);
    }
  }
  
  protected void handleSuccess() {}
  
  public Serializable serializeCache(RspData paramRspData)
  {
    return null;
  }
  
  protected abstract void unpacketParams(ReqData paramReqData);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/CommandBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */