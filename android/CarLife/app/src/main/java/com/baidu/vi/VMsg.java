package com.baidu.vi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class VMsg {
    private static final boolean DEBUG = false;
    private static Handler g_viMsgHandler;
    private static HandlerThread looperThread;

    static class VIHandler extends Handler {
        public VIHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            VMsg.OnUserCommand1(message.what, message.arg1, message.arg2, message.obj == null ? 0 : ((Integer) message.obj).intValue());
        }
    }

    private static native void OnUserCommand1(int i, int i2, int i3, int i4);

    public static void init() {
        looperThread = new HandlerThread("VIMsgThread");
        looperThread.start();
        g_viMsgHandler = new VIHandler(looperThread.getLooper());
    }

    public static void destroy() {
        if (looperThread != null) {
            looperThread.quit();
        }
        looperThread = null;
        g_viMsgHandler.removeCallbacksAndMessages(null);
        g_viMsgHandler = null;
    }

    private static void postMessage(int nMsgID, int nArg1, int nArg2, int nHandle) {
        if (g_viMsgHandler != null) {
            Message.obtain(g_viMsgHandler, nMsgID, nArg1, nArg2, nHandle == 0 ? null : Integer.valueOf(nHandle)).sendToTarget();
        }
    }
}
