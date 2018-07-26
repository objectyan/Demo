package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class RGMainAuxiliaryModel {
    public static final int MAX_WAIT_TIME = 30;
    public static final int MSG_CANCEL_COUNT = 3;
    public static final int MSG_STOP_COUNT = 2;
    public static final int MSG_TIME_COUNT = 1;
    public static int currentMsgType = -1;
    private static RGMainAuxiliaryModel mInstance = null;
    public int currentCount = 30;
    private boolean mCanCounterRestart = false;
    private boolean mCanMainAuxiliaryShow = false;
    private String mMainAuxiliarySwitch = null;
    private String mMainAuxiliaryTips = null;

    private RGMainAuxiliaryModel() {
    }

    public static RGMainAuxiliaryModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGMainAuxiliaryModel();
        }
        return mInstance;
    }

    public String getCountStr() {
        StringBuffer buf = new StringBuffer();
        buf.append(BNStyleManager.getString(C4048R.string.nsdk_string_rg_online_cancel));
        return buf.append(this.currentCount).toString();
    }

    public String getmMainAuxiliaryTips() {
        return this.mMainAuxiliaryTips;
    }

    public void setmMainAuxiliaryTips(String mMainAuxiliaryTips) {
        this.mMainAuxiliaryTips = mMainAuxiliaryTips;
    }

    public boolean ismCanMainAuxiliaryShow() {
        return this.mCanMainAuxiliaryShow;
    }

    public void setmCanMainAuxiliaryShow(boolean mCanMainAuxiliaryShow) {
        this.mCanMainAuxiliaryShow = mCanMainAuxiliaryShow;
    }

    public boolean ismCanCounterRestart() {
        return this.mCanCounterRestart;
    }

    public void setmCanCounterRestart(boolean mCanCounterRestart) {
        this.mCanCounterRestart = mCanCounterRestart;
    }

    public String getmMainAuxiliarySwitch() {
        return this.mMainAuxiliarySwitch;
    }

    public void setmMainAuxiliarySwitch(String mMainAuxiliarySwitch) {
        this.mMainAuxiliarySwitch = mMainAuxiliarySwitch;
    }
}
