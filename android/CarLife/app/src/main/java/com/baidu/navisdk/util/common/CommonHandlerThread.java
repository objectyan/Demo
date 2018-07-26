package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonHandlerThread {
    public static final int MAG_NAVI_STAT_INIT = 11;
    public static final int MAG_NAVI_STAT_ONEVEN = 12;
    public static final int MESSAGE_DRAW_ROUTE = 400;
    public static final int MESSAGE_DRAW_TRACK = 401;
    public static final int MESSAGE_DRAW_TRACK_AND_POS = 402;
    public static final int MSG_CLEAN_XIMALAYA_DATA = 20;
    public static final int MSG_DEBUG_FILE_ADD = 300;
    public static final int MSG_LIGHTNAV_STAT_END = 201;
    public static final int MSG_LIGHTNAV_STAT_START = 200;
    public static final int MSG_NAVING_STAT_END = 101;
    public static final int MSG_NAVING_STAT_START = 100;
    public static final int MSG_NAVI_INIT_A = 50;
    public static final int MSG_NAVI_INIT_B = 51;
    public static final int MSG_NAVI_INIT_PRELOAD_VIEW = 56;
    public static final int MSG_NAVI_INIT_UPDATE_USERINFO = 55;
    public static final int MSG_NAVI_INPAGE_INIT_BG = 501;
    public static final int MSG_NAVI_INPAGE_REALLY_START = 502;
    public static final int MSG_NAVI_SESSION_STAT_UPLOAD = 14;
    public static final int MSG_NAVI_STAT_UPLOAD = 13;
    public static final int MSG_NAVMERGE_STAT_END = 250;
    public static final int MSG_ROUTEGUIDE_CPU_END_PROFILE = 31;
    public static final int MSG_ROUTEGUIDE_CPU_START_PROFILE = 30;
    public static final int MSG_SET_KILLED_TIME = 302;
    public static final int MSG_START_RECORD_TRAJECTORY = 150;
    public static final int MSG_SYSTEM_LOG_UPLOAD = 301;
    public static final int MSG_USER_OP_CACHE_OPS = 3;
    public static final int MSG_USER_OP_CLEAR_CACHE = 2;
    public static final int MSG_USER_OP_LOAD_CACHE = 1;
    private static final String TAG = CommonHandlerThread.class.getSimpleName();
    private static CommonHandlerThread sInstance = null;
    private List<Callback> mCallbacks = new ArrayList();
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;

    public static abstract class Callback {
        private Set<Integer> mCareMsgs = new HashSet();

        public abstract void careAbouts();

        public abstract void execute(Message message);

        public final void careAbout(int msgID) {
            this.mCareMsgs.add(Integer.valueOf(msgID));
        }

        public final boolean isCareAbout(int msgID) {
            return this.mCareMsgs.contains(Integer.valueOf(msgID));
        }

        public String getName() {
            return "default";
        }
    }

    protected CommonHandlerThread() {
        init();
    }

    public static CommonHandlerThread getInstance() {
        if (sInstance == null) {
            synchronized (CommonHandlerThread.class) {
                if (sInstance == null) {
                    sInstance = new CommonHandlerThread();
                }
            }
        }
        return sInstance;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public Looper getLooper() {
        if (this.mHandlerThread == null) {
            return null;
        }
        return this.mHandlerThread.getLooper();
    }

    public void registerCallback(Callback cb) {
        if (cb != null && !this.mCallbacks.contains(cb)) {
            cb.careAbouts();
            this.mCallbacks.add(cb);
        }
    }

    public void unregisterCallback(Callback cb) {
        if (cb != null && this.mCallbacks.contains(cb)) {
            this.mCallbacks.remove(cb);
        }
    }

    public void removeMessage(int what) {
        if (this.mHandler != null && this.mHandler.hasMessages(what)) {
            this.mHandler.removeMessages(what);
        }
    }

    public boolean sendMessage(int what) {
        return sendMessage(what, 0, 0, null, 0);
    }

    public boolean sendMessage(int what, int arg1, int arg2, Object obj, long delayTime) {
        if (this.mHandler == null) {
            LogUtil.m15791e(TAG, "warning: sendMessage() handler is null.");
            return false;
        }
        Message message = this.mHandler.obtainMessage(what);
        message.arg1 = arg1;
        message.arg2 = arg2;
        if (obj != null) {
            message.obj = obj;
        }
        if (delayTime <= 0) {
            this.mHandler.sendMessage(message);
        } else {
            this.mHandler.sendMessageDelayed(message, delayTime);
        }
        return true;
    }

    private void init() {
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread("CommonHandlerThread");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
                public void handleMessage(Message msg) {
                    int i = CommonHandlerThread.this.mCallbacks.size() - 1;
                    while (i >= 0 && i < CommonHandlerThread.this.mCallbacks.size() && CommonHandlerThread.this.mCallbacks.get(i) != null) {
                        Callback callback = (Callback) CommonHandlerThread.this.mCallbacks.get(i);
                        if (callback.isCareAbout(msg.what)) {
                            callback.execute(msg);
                        }
                        i--;
                    }
                }
            };
        }
    }
}
