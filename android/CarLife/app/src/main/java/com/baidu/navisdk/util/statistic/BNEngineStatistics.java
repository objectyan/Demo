package com.baidu.navisdk.util.statistic;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralFunc.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.listener.NetworkListener;

public class BNEngineStatistics {
    private static final String TAG = BNEngineStatistics.class.getSimpleName();
    private static volatile BNEngineStatistics mInstance = null;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case NetworkListener.MSG_TYPE_NET_WORK_CHANGE /*5555*/:
                    LogUtil.m15791e("Handler", " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE");
                    int wifiStatus = msg.arg1;
                    int status = 0;
                    if (msg.arg2 == 1 && wifiStatus == 1) {
                        status = 2;
                    }
                    final int toExeStatus = status;
                    ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_FUNC, 7, new Handler(), 1401, 10000);
                    CmdGeneralFunc.addFunc(reqdata, new Callback() {
                        public CommandResult exec() {
                            LogUtil.m15791e(BNEngineStatistics.TAG, "changeNaviStatisticsNetworkStatus toExeStatus=" + toExeStatus);
                            BNaviEngineManager.getInstance().changeNaviStatisticsNetworkStatus(toExeStatus);
                            return null;
                        }
                    });
                    CommandCenter.getInstance().sendRequest(reqdata);
                    return;
                default:
                    return;
            }
        }
    };

    private BNEngineStatistics() {
    }

    public static BNEngineStatistics getInstance() {
        if (mInstance == null) {
            synchronized (BNEngineStatistics.class) {
                if (mInstance == null) {
                    mInstance = new BNEngineStatistics();
                }
            }
        }
        return mInstance;
    }

    public void init() {
        NetworkListener.registerMessageHandler(this.mHandler);
        BNaviEngineManager.getInstance().initNaviStatistics();
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (BNEngineStatistics.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                    BNaviEngineManager.getInstance().uninitNaviStatistics();
                }
            }
        }
        mInstance = null;
    }

    private void dispose() {
        NetworkListener.unRegisterMessageHandler(this.mHandler);
    }
}
