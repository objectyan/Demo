package com.baidu.navisdk.logic.commandparser;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.NetworkUtils;

public class CmdStatisticsUpload extends CommandBase {
    protected void unpacketParams(ReqData reqdata) {
    }

    protected CommandResult exec() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            CommonHandlerThread.getInstance().sendMessage(13, -1, -1, null, 0);
        }
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            CommonHandlerThread.getInstance().sendMessage(14, -1, -1, null, 0);
        }
        this.mRet.setSuccess();
        return this.mRet;
    }
}
