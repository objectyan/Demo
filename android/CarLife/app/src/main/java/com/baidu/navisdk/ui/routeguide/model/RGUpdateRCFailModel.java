package com.baidu.navisdk.ui.routeguide.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class RGUpdateRCFailModel {
    public static final int MAX_WAIT_TIME = 30;
    public static final int MSG_CANCEL_COUNT = 3;
    public static final int MSG_STOP_COUNT = 2;
    public static final int MSG_TIME_COUNT = 1;
    public static int currentMsgType = -1;
    private static RGUpdateRCFailModel mInstance = null;
    public int currentCount = 30;
    private boolean mCanCounterRestart = false;
    private OnCountDownListener mCountDownListener;
    private Handler mHandler;
    private boolean mRCUpdateFialCanShow = false;

    public interface OnCountDownListener {
        void onCountDown(int i);
    }

    private RGUpdateRCFailModel() {
    }

    public static RGUpdateRCFailModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGUpdateRCFailModel();
        }
        return mInstance;
    }

    public String getCountStr() {
        StringBuffer buf = new StringBuffer();
        buf.append(BNStyleManager.getString(C4048R.string.nsdk_string_rg_online_cancel));
        return buf.append(this.currentCount).toString();
    }

    public boolean isRCUpdateFialCanShow() {
        return this.mRCUpdateFialCanShow;
    }

    public void setmCanRCUpdateFialShow(boolean canShow) {
        if (canShow) {
            this.currentCount = 30;
        } else {
            cancelCountDown();
        }
        this.mRCUpdateFialCanShow = canShow;
    }

    public boolean ismCanCounterRestart() {
        return this.mCanCounterRestart;
    }

    public void setmCanCounterRestart(boolean mCanCounterRestart) {
        this.mCanCounterRestart = mCanCounterRestart;
    }

    public void startCountDown() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    if (1 == msg.what) {
                        RGUpdateRCFailModel rGUpdateRCFailModel = RGUpdateRCFailModel.this;
                        rGUpdateRCFailModel.currentCount--;
                        if (RGUpdateRCFailModel.this.currentCount > 0) {
                            RGUpdateRCFailModel.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                        } else {
                            RGUpdateRCFailModel.this.currentCount = 0;
                        }
                        if (RGUpdateRCFailModel.this.mCountDownListener != null) {
                            RGUpdateRCFailModel.this.mCountDownListener.onCountDown(RGUpdateRCFailModel.this.currentCount);
                        }
                    }
                }
            };
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 1000);
    }

    private void cancelCountDown() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
        this.currentCount = 0;
    }

    public void setOnCountDownListener(OnCountDownListener lis) {
        this.mCountDownListener = lis;
    }
}
