package com.baidu.navisdk.ui.routeguide.model;

import android.os.Handler;
import android.os.Message;

public class RGNaviQuitModel {
    private static final int MSG_TYPE_COUNT_DOWN = 100;
    private static RGNaviQuitModel sInstance = null;
    private int mCountDown = 10;
    private OnCountDownListener mCountDownListener = null;
    private Handler mHandler = null;
    private boolean mIsShowCountDown = false;

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGNaviQuitModel$1 */
    class C44481 extends Handler {
        C44481() {
        }

        public void handleMessage(Message msg) {
            if (100 == msg.what) {
                RGNaviQuitModel.this.mCountDown = RGNaviQuitModel.this.mCountDown - 1;
                if (RGNaviQuitModel.this.mCountDown > 0) {
                    RGNaviQuitModel.this.mHandler.sendEmptyMessageDelayed(100, 1000);
                } else {
                    RGNaviQuitModel.this.mCountDown = 0;
                    RGNaviQuitModel.this.mIsShowCountDown = false;
                }
                if (RGNaviQuitModel.this.mCountDownListener != null) {
                    RGNaviQuitModel.this.mCountDownListener.onCountDown(RGNaviQuitModel.this.mCountDown);
                }
            }
        }
    }

    public interface OnCountDownListener {
        void onCountDown(int i);
    }

    public static RGNaviQuitModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGNaviQuitModel();
        }
        return sInstance;
    }

    private RGNaviQuitModel() {
    }

    public boolean isShowCountDown() {
        return this.mIsShowCountDown;
    }

    public void setAndStartCountDown(boolean show) {
        setCountDown(show);
        startCountDown();
    }

    public void setCountDown(boolean show) {
        this.mIsShowCountDown = show;
        if (show) {
            this.mCountDown = 10;
        } else {
            this.mCountDownListener = null;
        }
    }

    public void startCountDown() {
        if (this.mIsShowCountDown) {
            if (this.mHandler == null) {
                this.mHandler = new C44481();
            }
            if (this.mHandler != null) {
                if (this.mHandler.hasMessages(100)) {
                    this.mHandler.removeMessages(100);
                }
                this.mHandler.sendEmptyMessageDelayed(100, 1000);
            }
        }
    }

    public void setOnCountDownListener(OnCountDownListener lis) {
        this.mCountDownListener = lis;
    }
}
