package com.baidu.navisdk.vi;

import android.os.Message;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class VMsg {
    public static final int VM_USER_ID = 4096;
    private static final List<MsgHandler> outboxHandlers = new ArrayList();

    public static void registerMessageHandler(MsgHandler handler) {
        if (handler != null && !outboxHandlers.contains(handler)) {
            outboxHandlers.add(handler);
        }
    }

    public static void unRegisterMessageHandler(MsgHandler handler) {
        if (handler != null && outboxHandlers.contains(handler)) {
            outboxHandlers.remove(handler);
        }
    }

    public static void dispatchMessage(int what, int arg1, int arg2) {
        if (what > 4096 && outboxHandlers != null && !outboxHandlers.isEmpty()) {
            List<MsgHandler> handlers = new ArrayList();
            handlers.addAll(outboxHandlers);
            for (int i = 0; i < handlers.size(); i++) {
                MsgHandler h = (MsgHandler) handlers.get(i);
                if (h != null && h.isObserved(what)) {
                    Message.obtain(h, what, arg1, arg2, null).sendToTarget();
                }
            }
        }
    }

    private static void postMessage(int nMsgID, int nArg1, int nArg2) {
        VMsgDispatcher.dispatchMessage(nMsgID, nArg1, nArg2);
    }

    public static void dumpList() {
        List<MsgHandler> handlers = new ArrayList();
        handlers.addAll(outboxHandlers);
        LogUtil.m15791e("VMsg", "dumpList()  handlers count=" + handlers.size());
        for (int i = 0; i < handlers.size(); i++) {
            LogUtil.m15791e("VMsg", i + "handler.class=" + ((MsgHandler) handlers.get(i)).getClass() + ", name=" + ((MsgHandler) handlers.get(i)).getClass().getSimpleName());
        }
    }
}
