package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import java.util.HashMap;

public class CmdDataCheckUpload
  extends CommandBase
{
  private String upJson = null;
  
  public static void packetParams(ReqData paramReqData, String paramString)
  {
    paramReqData.mParams.put("param.datacheck.json", paramString);
  }
  
  protected CommandResult exec()
  {
    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      boolean bool = DataCheckHelper.pushNaviStatistics(this.upJson);
      LogUtil.e("CmdDataCheckUpload", "push datacheck result :" + bool);
    }
    this.mRet.setSuccess();
    return this.mRet;
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.upJson = ((String)paramReqData.mParams.get("param.datacheck.json"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdDataCheckUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */