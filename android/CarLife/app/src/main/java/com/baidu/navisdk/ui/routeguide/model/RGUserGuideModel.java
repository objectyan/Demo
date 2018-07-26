package com.baidu.navisdk.ui.routeguide.model;

public class RGUserGuideModel {
    public static final String TAG = "RGUserGuideModel";
    private static volatile RGUserGuideModel mInstance = null;
    public boolean isShowing = false;
    public long mLoadEndTime = 0;
    public long mLoadStartTime = 0;
    public boolean mReceivError = false;

    public static RGUserGuideModel getInstance() {
        if (mInstance == null) {
            synchronized (RGUserGuideModel.class) {
                if (mInstance == null) {
                    mInstance = new RGUserGuideModel();
                }
            }
        }
        return mInstance;
    }

    public boolean satisfyCondition() {
        if (!this.mReceivError && this.mLoadEndTime - this.mLoadStartTime <= 3000 && this.mLoadEndTime >= 1) {
            return true;
        }
        return false;
    }
}
