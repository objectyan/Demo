package me.objectyan.screensharing.core;

import android.os.Message;

import java.util.ArrayList;
import java.util.List;


public class MsgHandlerCenter  {

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


    public static void unRegisterAllMessageHandler() {
        if (sMsgBaseHandlers != null) {
            sMsgBaseHandlers.clear();
        }
    }


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


    public static void dispatchMessageDelay(int what, int delay) {
        MsgHandlerCenter.dispatchMessageDelay(what, CommonParams.MSG_ARG_INVALID, CommonParams.MSG_ARG_INVALID, null, delay);
    }


    public static void dispatchMessageDelay(int what, int arg1, int delay) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, CommonParams.MSG_ARG_INVALID, null, delay);
    }


    public static void dispatchMessageDelay(int what, int arg1, int arg2, int delay) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, arg2, null, delay);
    }


    public static void dispatchMessageDelay(int what, int arg1, int arg2, Object b) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, arg2, b, 0);
    }


    public static void dispatchMessageDelay(int what, int arg1, Object b) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, CommonParams.MSG_ARG_INVALID, b);
    }


    public static void dispatchMessageDelay(int what, Object b) {
        MsgHandlerCenter.dispatchMessageDelay(what, CommonParams.MSG_ARG_INVALID, CommonParams.MSG_ARG_INVALID, b);
    }


    public static void dispatchMessage(int what) {
        MsgHandlerCenter.dispatchMessageDelay(what, CommonParams.MSG_ARG_INVALID, CommonParams.MSG_ARG_INVALID, null);
    }


    public static void dispatchMessage(int what, int arg1) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, CommonParams.MSG_ARG_INVALID, null);
    }



    public static void dispatchMessage(int what, int arg1, int arg2) {
        MsgHandlerCenter.dispatchMessageDelay(what, arg1, arg2, null);
    }
}
