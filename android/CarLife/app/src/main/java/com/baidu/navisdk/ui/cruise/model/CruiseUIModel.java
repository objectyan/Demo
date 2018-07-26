package com.baidu.navisdk.ui.cruise.model;

import com.baidu.navisdk.model.datastruct.LocData;

public class CruiseUIModel {
    private static CruiseUIModel mInstance = null;
    private int mAssistType;
    private int mCameraDistance;
    private int mCameraIconResID;
    private String mCameraName;
    private int mCameraProgress;
    private int mCameraSpeed;
    private CruiseState mCruiseState = CruiseState.NORMAL;
    private String mCurrentRoadName;
    private int mCurrentSpeed;
    private boolean mIsConneted = false;
    private boolean mIsDayStyle = true;
    private boolean mIsProvinceDataDownloaded = false;
    private boolean mIsShowingMenu = false;
    private LocData mLastLocData;
    private int mSatelliteNum;

    public static synchronized CruiseUIModel getInstance() {
        CruiseUIModel cruiseUIModel;
        synchronized (CruiseUIModel.class) {
            if (mInstance == null) {
                mInstance = new CruiseUIModel();
            }
            cruiseUIModel = mInstance;
        }
        return cruiseUIModel;
    }

    public void reset() {
        this.mAssistType = 0;
        this.mCameraIconResID = 0;
        this.mCameraSpeed = 0;
        this.mCameraName = null;
        this.mCameraDistance = 0;
        this.mCameraProgress = 0;
        this.mCurrentSpeed = 0;
        this.mCruiseState = CruiseState.NORMAL;
        this.mSatelliteNum = 0;
        this.mCurrentRoadName = null;
        this.mIsDayStyle = true;
        this.mIsShowingMenu = false;
    }

    public int getAssistType() {
        return this.mAssistType;
    }

    public void setAssistType(int assistType) {
        this.mAssistType = assistType;
    }

    public int getCameraIconResID() {
        return this.mCameraIconResID;
    }

    public void setCameraIconResID(int cameraIconResID) {
        this.mCameraIconResID = cameraIconResID;
    }

    public int getCameraSpeed() {
        return this.mCameraSpeed;
    }

    public void setCameraSpeed(int cameraSpeed) {
        this.mCameraSpeed = cameraSpeed;
    }

    public String getCameraName() {
        return this.mCameraName;
    }

    public void setCameraName(String cameraName) {
        this.mCameraName = cameraName;
    }

    public int getCameraDistance() {
        return this.mCameraDistance;
    }

    public void setCameraDistance(int cameraDistance) {
        this.mCameraDistance = cameraDistance;
    }

    public int getCameraProgress() {
        return this.mCameraProgress;
    }

    public void setCameraProgress(int progress) {
        this.mCameraProgress = progress;
    }

    public int getCurrentSpeed() {
        return this.mCurrentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.mCurrentSpeed = currentSpeed;
    }

    public CruiseState getCruiseState() {
        return this.mCruiseState;
    }

    public void setCruiseState(CruiseState cruiseState) {
        this.mCruiseState = cruiseState;
    }

    public int getSatelliteNum() {
        return this.mSatelliteNum;
    }

    public void setSatelliteNum(int satelliteNum) {
        this.mSatelliteNum = satelliteNum;
    }

    public String getCurrentRoadName() {
        return this.mCurrentRoadName;
    }

    public void setCurrentRoadName(String currentRoadName) {
        this.mCurrentRoadName = currentRoadName;
    }

    public boolean isIsDayStyle() {
        return this.mIsDayStyle;
    }

    public void setIsDayStyle(boolean isDayStyle) {
        this.mIsDayStyle = isDayStyle;
    }

    public boolean isShowingMenu() {
        return this.mIsShowingMenu;
    }

    public void setIsShowingMenu(boolean isShowingMenu) {
        this.mIsShowingMenu = isShowingMenu;
    }

    public boolean isProvinceDataDownloaded() {
        return this.mIsProvinceDataDownloaded;
    }

    public void setProvinceDataDownloaded(boolean downloaded) {
        this.mIsProvinceDataDownloaded = downloaded;
    }

    public LocData getLastLocationData() {
        return this.mLastLocData;
    }

    public void setLastLocationData(LocData locData) {
        this.mLastLocData = locData;
    }

    public boolean isConnected() {
        return this.mIsConneted;
    }

    public void setConnected(boolean connected) {
        this.mIsConneted = connected;
    }
}
