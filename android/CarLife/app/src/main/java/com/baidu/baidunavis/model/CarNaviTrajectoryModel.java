package com.baidu.baidunavis.model;

public class CarNaviTrajectoryModel {
    public static final String TAG = CarNaviTrajectoryModel.class.getSimpleName();
    private static CarNaviTrajectoryModel mInstance = null;
    public boolean isBackground = false;
    public boolean isCarNaviPageVisible = false;
    public boolean isFromRoutePlan = false;
    public boolean isRecordStart = false;

    public static CarNaviTrajectoryModel getInstance() {
        if (mInstance == null) {
            mInstance = new CarNaviTrajectoryModel();
        }
        return mInstance;
    }
}
