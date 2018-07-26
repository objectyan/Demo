package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class TimerUtil {
    private static final String TAG = "TimerUtil";
    private TimerCallBack mCallBack;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (TimerUtil.this.mTimeCount = TimerUtil.this.mTimeCount - 1 > 0 && TimerUtil.this.mCallBack != null) {
                TimerUtil.this.mCallBack.onTick(TimerUtil.this.mTimeCount);
            }
            if (TimerUtil.this.mTimeCount != 0 && !TimerUtil.this.mHandler.hasMessages(0)) {
                TimerUtil.this.mHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };
    private int mTimeCount;
    private int mTimeOut;

    public interface TimerCallBack {
        void onTick(int i);
    }

    public void addCallback(TimerCallBack callback) {
        this.mCallBack = callback;
    }

    public void removeCallback() {
        this.mCallBack = null;
    }

    public void start(int timecount) {
        cancle();
        this.mTimeOut = timecount;
        this.mTimeCount = timecount;
        if (this.mHandler == null) {
            LogUtil.m15791e(TAG, "handler is null");
        } else if (!this.mHandler.hasMessages(0)) {
            this.mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public void reset() {
        this.mTimeCount = this.mTimeOut;
    }

    public void cancle() {
        this.mHandler.removeMessages(0);
        this.mHandler.removeCallbacks(null);
    }
}
