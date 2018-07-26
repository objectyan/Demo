package com.baidu.platform.comapi.map;

import android.os.Message;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.UIMsg.m_AppUI;

class LocalMapHandler extends MainLooperHandler {
    private LocalMapListener listener = null;

    LocalMapHandler() {
        super(Module.MAP_ENGINE, ScheduleConfig.forData());
    }

    void registListener(LocalMapListener listener) {
        this.listener = listener;
    }

    void removeListener(LocalMapListener listener) {
    }

    public void onMessage(Message message) {
        if (message.what == m_AppUI.V_WM_VDATAENGINE) {
            switch (message.arg1) {
                case -1:
                case 0:
                case 1:
                case 2:
                case 4:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 101:
                case 102:
                case 201:
                    if (this.listener != null) {
                        this.listener.onGetLocalMapState(message.arg1, message.arg2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
