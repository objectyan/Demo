package com.baidu.carlife.core;

import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MsgHandlerCenter */
/* renamed from: com.baidu.carlife.core.k */
public class MsgHandlerCenter implements KeepClass {

    private static List<MsgBaseHandler> sMsgBaseHandlers = new ArrayList();

    public static void registerMessageHandler(MsgBaseHandler handler) {
        if (handler != null && !sMsgBaseHandlers.contains(handler)) {
            sMsgBaseHandlers.add(handler);
        }
    }

    public static void unRegisterMessageHandler(MsgBaseHandler handler) {
        if (handler != null && sMsgBaseHandlers.contains(handler)) {
            sMsgBaseHandlers.remove(handler);
        }
    }

    /* renamed from: a */
    public static void unRegisterAllMessageHandler() {
        if (sMsgBaseHandlers != null) {
            sMsgBaseHandlers.clear();
        }
    }

    /* renamed from: a */
    public static void removeMessages(int what) {
        if (sMsgBaseHandlers != null && !sMsgBaseHandlers.isEmpty()) {
            for (int i = 0; i < sMsgBaseHandlers.size(); i++) {
                MsgBaseHandler h = (MsgBaseHandler) sMsgBaseHandlers.get(i);
                if (h != null && h.isAdded(what)) {
                    h.removeMessages(what);
                }
            }
        }
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, int arg1, int arg2, Object b, int delay) {
        if (sMsgBaseHandlers != null && !sMsgBaseHandlers.isEmpty()) {
            for (int i = 0; i < sMsgBaseHandlers.size(); i++) {
                MsgBaseHandler h = (MsgBaseHandler) sMsgBaseHandlers.get(i);
                if (h != null && h.isAdded(what)) {
                    h.sendMessageDelayed(Message.obtain(h, what, arg1, arg2, b), (long) delay);
                }
            }
        }
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, int delay) {
        MsgHandlerCenter.dispatchMessageDelay(what, CommonParams.MSG_ARG_INVALID, CommonParams.MSG_ARG_INVALID, null, delay);
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, int arg1, int delay) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, CommonParams.MSG_ARG_INVALID, null, delay);
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, int arg1, int arg2, int delay) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, arg2, null, delay);
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, int arg1, int arg2, Object b) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, arg2, b, 0);
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, int arg1, Object b) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, CommonParams.MSG_ARG_INVALID, b);
    }

    /* renamed from: a */
    public static void dispatchMessageDelay(int what, Object b) {
        MsgHandlerCenter.dispatchMessageDelay(what, CommonParams.MSG_ARG_INVALID, CommonParams.MSG_ARG_INVALID, b);
    }

    /* renamed from: b */
    public static void dispatchMessage(int what) {
        MsgHandlerCenter.dispatchMessageDelay(what, CommonParams.MSG_ARG_INVALID, CommonParams.MSG_ARG_INVALID, null);
    }

    /* renamed from: b */
    public static void dispatchMessage(int what, int arg1) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, CommonParams.MSG_ARG_INVALID, null);
    }


    /* renamed from: b */
    public static void dispatchMessage(int what, int arg1, int arg2) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, arg2, null);
    }
}
