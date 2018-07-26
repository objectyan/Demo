package com.baidu.navisdk.ui.cruise.model;

import android.os.Bundle;

public class CruiseCameraType {
    public static final int UPDATE_TYPE_HIDE = 3;
    public static final int UPDATE_TYPE_SHOW = 1;
    public static final int UPDATE_TYPE_UPDATE = 2;
    private int mCameraType;
    private int mSpeed;
    private int mUpdateType;

    public CruiseCameraType(int updateType, int cameraType, int speed) {
        this.mUpdateType = updateType;
        this.mCameraType = cameraType;
        this.mSpeed = speed;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putInt("updatetype", this.mUpdateType);
        b.putInt("assisttype", this.mCameraType);
        b.putInt("speed", this.mSpeed);
        return b;
    }
}
