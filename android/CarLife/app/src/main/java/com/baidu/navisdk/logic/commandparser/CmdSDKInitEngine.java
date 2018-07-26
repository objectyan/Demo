package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;

public class CmdSDKInitEngine extends CommandBase {
    EngineCommonConfig mConfig;

    public static void packetParams(ReqData reqdata, EngineCommonConfig config) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SDKOP_INITENGINECONFIG, config);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mConfig = (EngineCommonConfig) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SDKOP_INITENGINECONFIG);
    }

    protected CommandResult exec() {
        if (BNaviEngineManager.getInstance().initEngineBySync(this.mConfig)) {
            this.mRet.setSuccess();
        }
        return this.mRet;
    }
}
