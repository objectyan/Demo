package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.NetworkUtils;

public class CmdStatisticsUpload
  extends CommandBase
{
  protected CommandResult exec()
  {
    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
      CommonHandlerThread.getInstance().sendMessage(13, -1, -1, null, 0L);
    }
    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
      CommonHandlerThread.getInstance().sendMessage(14, -1, -1, null, 0L);
    }
    this.mRet.setSuccess();
    return this.mRet;
  }
  
  protected void unpacketParams(ReqData paramReqData) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdStatisticsUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */