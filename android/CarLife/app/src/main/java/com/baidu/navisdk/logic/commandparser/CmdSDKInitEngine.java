package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import java.util.HashMap;

public class CmdSDKInitEngine
  extends CommandBase
{
  EngineCommonConfig mConfig;
  
  public static void packetParams(ReqData paramReqData, EngineCommonConfig paramEngineCommonConfig)
  {
    paramReqData.mParams.put("param.sdkop.initengineconfig", paramEngineCommonConfig);
  }
  
  protected CommandResult exec()
  {
    if (BNaviEngineManager.getInstance().initEngineBySync(this.mConfig)) {
      this.mRet.setSuccess();
    }
    return this.mRet;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mConfig = ((EngineCommonConfig)paramReqData.mParams.get("param.sdkop.initengineconfig"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdSDKInitEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */