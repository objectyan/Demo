package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

public class RGLaneLineController {
    public static RGLaneLineController mInstance = null;
    public boolean isNormalEnlargeShow = false;
    public ArrayList<Integer> mLastImalgeIdList = new ArrayList();

    public static RGLaneLineController getInstance() {
        if (mInstance == null) {
            mInstance = new RGLaneLineController();
        }
        return mInstance;
    }

    public void uninit() {
        this.mLastImalgeIdList.clear();
        if (RGLaneInfoModel.mInstance != null) {
            RGLaneInfoModel.mInstance.isLaneShow = false;
            RGLaneInfoModel.mInstance.isShow = false;
        }
    }

    public void handleSimulateHide() {
        LogUtil.m15791e(RGLaneInfoModel.TAG, "handleSimulateHide");
        RGLaneInfoModel currentModel = RGLaneInfoModel.getModel(false);
        if (currentModel != null) {
            currentModel.isShow = false;
        }
        getInstance().mLastImalgeIdList.clear();
        RGMapModeViewController.getInstance().requestShowExpendView(7, false, 2);
    }
}
