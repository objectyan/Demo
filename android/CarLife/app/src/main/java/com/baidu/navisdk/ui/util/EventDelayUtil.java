package com.baidu.navisdk.ui.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.LogUtil;

public class EventDelayUtil {
    private static final String TAG = "EventDelayUtil";
    private SparseArray<Object[]> mEventMap = new SparseArray();
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            int key = msg.what;
            Object[] params = (Object[]) EventDelayUtil.this.mEventMap.get(key);
            if (EventDelayUtil.this.mListener != null) {
                EventDelayUtil.this.mListener.onStart(key, params);
            }
            EventDelayUtil.this.mEventMap.remove(key);
        }
    };
    private EventDelayListener mListener;

    public interface EventDelayListener {
        void onStart(int i, Object... objArr);
    }

    public void registListner(EventDelayListener listener) {
        this.mListener = listener;
    }

    public void unRegistListner() {
        this.mListener = null;
    }

    public void exec(int key, int delay, Object... params) {
        if (this.mHandler == null) {
            LogUtil.m15791e(TAG, "handler is null");
            return;
        }
        Object[] objArray = params;
        this.mEventMap.put(key, objArray);
        if (!this.mHandler.hasMessages(key)) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(key, objArray), (long) delay);
        }
    }

    public void cancle(int key) {
        this.mEventMap.remove(key);
    }

    public void clean() {
        this.mHandler.removeCallbacks(null);
        this.mHandler = null;
        this.mEventMap.clear();
    }
}
