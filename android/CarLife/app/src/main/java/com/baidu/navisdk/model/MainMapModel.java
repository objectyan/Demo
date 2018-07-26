package com.baidu.navisdk.model;

public class MainMapModel {
    private static volatile MainMapModel mInstance;
    public boolean bFirstLoc = true;
    public boolean bFirstShowLoc;
    public boolean haveSensor = false;
    public float mAngleX = 0.0f;
    public float mAngleY = 0.0f;
    public float mAngleZ = 0.0f;
    public int mCurLatitude;
    public int mCurLocMode = 0;
    public int mCurLongitude;
    public int mFirstAutoLocMode = 1;
    public int mLastAngle = -1024;
    public double mLastLatitude = 0.0d;
    public int mLastLocMode = 0;
    public double mLastLongitude = 0.0d;
    public int mScreenRotation = 0;
    public boolean mbFirstMapviewContent = true;

    public static MainMapModel getInstance() {
        if (mInstance == null) {
            synchronized (MainMapModel.class) {
                if (mInstance == null) {
                    mInstance = new MainMapModel();
                }
            }
        }
        return mInstance;
    }

    public int getNextLocMode() {
        switch (getCurLocMode()) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    public int getCurLocMode() {
        return this.mCurLocMode;
    }

    public int setLocMode(int locMode) {
        if (locMode == -1) {
            changeToNextLocMode();
        } else {
            this.mCurLocMode = locMode;
        }
        return getCurLocMode();
    }

    private int changeToNextLocMode() {
        this.mCurLocMode = getNextLocMode();
        return getCurLocMode();
    }
}
