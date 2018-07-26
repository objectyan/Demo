package com.baidu.che.codriver.platform;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.sdk.p081a.C2580c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2746e;

public class PlatformManager {
    private static final String TAG = "PlatformManager";
    private static PlatformManager sIntance = null;
    private static final Object sLock = new Object();
    private Context mContext = null;

    private PlatformManager() {
    }

    public static PlatformManager getInstance() {
        if (sIntance == null) {
            synchronized (sLock) {
                if (sIntance == null) {
                    sIntance = new PlatformManager();
                }
            }
        }
        return sIntance;
    }

    public void init(Context context) {
        if (context != null) {
            this.mContext = context;
            initNavi();
        }
    }

    private boolean initNavi() {
        NaviParse.getInstance().initCmdHashMap();
        NaviCmdController.getInstance().readAddress();
        return true;
    }

    public boolean handleCommand(C2746e command, Boolean needLaunchApp) {
        if (command == null || TextUtils.isEmpty(command.mo1952c())) {
            C2725h.m10207b(TAG, "handleCommand: error");
            return false;
        }
        int cmdType = PlatformUtils.getCommandType(command);
        C2725h.m10207b(TAG, "handleCommand: cmdType = " + cmdType);
        if (cmdType == 8) {
            sendNaviCommand(command.mo1952c(), needLaunchApp);
        }
        return true;
    }

    public boolean handleCommand(int cmdType, String cmdResult, Boolean needLaunchApp) {
        if (TextUtils.isEmpty(cmdResult)) {
            return false;
        }
        C2725h.m10207b(TAG, "handleCommand: cmdType = " + cmdType);
        if (cmdType == 8) {
            sendNaviCommand(cmdResult, needLaunchApp);
        }
        return true;
    }

    public void sendNaviCommand(String cmd, Boolean needLaunchApp) {
        C2725h.m10207b(TAG, "sendNaviCommand: cmd = " + cmd);
        NaviCmdData naviCmdData = NaviParse.getInstance().parse(cmd);
        if (naviCmdData == null) {
            C2725h.m10214e(TAG, "cannot parse the navi cmd data");
            return;
        }
        C2725h.m10207b(TAG, "naviCmdData = " + naviCmdData.toString());
        C2580c.m9750a().m9754a(naviCmdData.getFunc(), naviCmdData.getParams());
    }
}
