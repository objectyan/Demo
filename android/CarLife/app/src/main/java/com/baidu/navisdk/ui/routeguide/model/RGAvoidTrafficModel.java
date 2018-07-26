package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;

public class RGAvoidTrafficModel {
    private static final int MSG_TYPE_COUNT_DOWN = 100;
    private static RGAvoidTrafficModel sInstance = null;
    private boolean mCanAvoidTrafficShow = false;
    private int mCountDown = 30;
    private OnCountDownListener mCountDownListener = null;
    private int mCurRouteId = -1;
    private Handler mHandler = null;
    private boolean mIsClickToSwitch = false;
    private boolean mIsShowCountDown = false;
    private String mRouteTips = null;
    private OptimalRouteType mRouteType = OptimalRouteType.AVOID_TRAFFIC;
    private String mRouteVoiceTips = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGAvoidTrafficModel$1 */
    class C44441 extends Handler {
        C44441() {
        }

        public void handleMessage(Message msg) {
            if (100 == msg.what) {
                LogUtil.m15791e("", "AssistantIconUpdate showAvoidTrafficView:onCountDown  mCountDown " + RGAvoidTrafficModel.this.mCountDown + "   mCountDownListener " + RGAvoidTrafficModel.this.mCountDownListener);
                RGAvoidTrafficModel.this.mCountDown = RGAvoidTrafficModel.this.mCountDown - 1;
                if (RGAvoidTrafficModel.this.mCountDown > 0) {
                    RGAvoidTrafficModel.this.mHandler.sendEmptyMessageDelayed(100, 1000);
                } else {
                    RGAvoidTrafficModel.this.mCountDown = 0;
                    RGAvoidTrafficModel.this.mIsShowCountDown = false;
                }
                if (RGAvoidTrafficModel.this.mCountDownListener != null) {
                    RGAvoidTrafficModel.this.mCountDownListener.onCountDown(RGAvoidTrafficModel.this.mCountDown);
                }
            }
        }
    }

    public interface OnCountDownListener {
        void onCountDown(int i);
    }

    public enum OptimalRouteType {
        AVOID_TRAFFIC,
        CLOUD_RECOMMEND
    }

    public void setmCountDown(int mCountDown) {
        this.mCountDown = mCountDown;
    }

    public int getmCountDown() {
        return this.mCountDown;
    }

    public boolean getmIsClickToSwitch() {
        return this.mIsClickToSwitch;
    }

    public void setmIsClickToSwitch(boolean mIsClickToSwitch) {
        this.mIsClickToSwitch = mIsClickToSwitch;
    }

    public static RGAvoidTrafficModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGAvoidTrafficModel();
        }
        return sInstance;
    }

    public int getmCurRouteId() {
        return this.mCurRouteId;
    }

    public void setmCurRouteId(int mCurRouteId) {
        this.mCurRouteId = mCurRouteId;
    }

    private RGAvoidTrafficModel() {
    }

    public boolean getmCanAvoidTrafficShow() {
        return this.mCanAvoidTrafficShow;
    }

    public void setmCanAvoidTrafficShow(boolean mCanAvoidTrafficShow) {
        this.mCanAvoidTrafficShow = mCanAvoidTrafficShow;
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
        if (!show) {
            this.mCountDownListener = null;
        }
    }

    public void setOptimalRouteInfo(Bundle bundle) {
        if (bundle != null) {
            this.mRouteTips = bundle.getString("OptimalRouteTips");
            this.mRouteVoiceTips = bundle.getString("OptimalVoiceTips");
            LogUtil.m15791e("dingbinAvoic", this.mRouteVoiceTips);
            int routeType = bundle.getInt("OptimalRouteType", 0);
            LogUtil.m15791e("OptimalRoute", "OptimalRoute type " + routeType + ", " + this.mRouteTips);
            if (1 == routeType) {
                this.mRouteType = OptimalRouteType.AVOID_TRAFFIC;
            } else if (2 == routeType) {
                this.mRouteType = OptimalRouteType.CLOUD_RECOMMEND;
            }
        }
    }

    public boolean isCLoudRecommend() {
        if (this.mRouteType == OptimalRouteType.CLOUD_RECOMMEND) {
            return true;
        }
        return false;
    }

    public String getVoiceTips() {
        return this.mRouteVoiceTips;
    }

    public String getRouteTips() {
        return this.mRouteTips;
    }

    public OptimalRouteType getRouteType() {
        return this.mRouteType;
    }

    public void startCountDown() {
        if (this.mIsShowCountDown) {
            if (this.mHandler == null) {
                this.mHandler = new C44441();
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
