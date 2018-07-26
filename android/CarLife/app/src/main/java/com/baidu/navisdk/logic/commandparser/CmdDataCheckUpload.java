package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;

public class CmdDataCheckUpload extends CommandBase {
    private String upJson = null;

    public static void packetParams(ReqData reqdata, String json) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_DATACHECK_JSON, json);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.upJson = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_DATACHECK_JSON);
    }

    protected CommandResult exec() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            LogUtil.m15791e("CmdDataCheckUpload", "push datacheck result :" + DataCheckHelper.pushNaviStatistics(this.upJson));
        }
        this.mRet.setSuccess();
        return this.mRet;
    }
}
