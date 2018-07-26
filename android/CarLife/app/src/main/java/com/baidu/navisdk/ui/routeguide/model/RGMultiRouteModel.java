package com.baidu.navisdk.ui.routeguide.model;

import android.content.Context;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.MultiRoadConfig;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import java.util.Arrays;

public class RGMultiRouteModel {
    public static final int DEFAULT_INSTANT_CLOUND_MULTI_ROUTE_LASTMILE = 1000;
    public static final int[] DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS = new int[]{40, CommonHandlerThread.MSG_START_RECORD_TRAJECTORY, 400};
    public static final boolean DETAULT_INSTANT_CLOUD_MULTI_ROUTE_STATE = true;
    public static final String TAG = "RGMultiRouteModel";
    private static RGMultiRouteModel sInstance = null;
    public boolean hasSetByCloud = false;
    public boolean isAvoidTrafficStatus = false;
    public boolean isMultiRouteEnable = true;
    public boolean isSwitchButtonShowing = false;
    public int mCurRouteIndex = 0;
    public int[] mPstLabelDis = new int[3];
    public int mSelectedRouteIndex = -1;

    private RGMultiRouteModel() {
    }

    public static RGMultiRouteModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGMultiRouteModel();
        }
        return sInstance;
    }

    public void updateMultiRouteParams() {
        MultiRoadConfig config = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
        if (config == null) {
            LogUtil.m15791e(TAG, "MultiRoadConfig is null");
            return;
        }
        this.isMultiRouteEnable = config.isMultiRoadOpen();
        this.mPstLabelDis = config.getTagDistance();
        if (this.mPstLabelDis != null && this.mPstLabelDis.length == 3) {
            Context context = BNaviModuleManager.getContext();
            if (context != null) {
                PreferenceHelper.getInstance(context).putBoolean(PreferenceHelperConst.SP_RG_INSTANT_LAST_CLOUD_OPEN_STATE, this.isMultiRouteEnable);
                PreferenceHelper.getInstance(context).putString(PreferenceHelperConst.SP_RG_INSTANT_LAST_CLOUD_PSTLABELDIS_VALUE, Arrays.toString(this.mPstLabelDis));
            }
            this.hasSetByCloud = true;
        }
    }

    public boolean isEnable() {
        if (CloudlConfigDataModel.getInstance().isWebDataValid) {
            if (this.hasSetByCloud) {
                return this.isMultiRouteEnable;
            }
            MultiRoadConfig config = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
            if (config != null) {
                return config.isMultiRoadOpen();
            }
        }
        Context context = BNaviModuleManager.getContext();
        if (context != null) {
            LogUtil.m15791e(TAG, "context not null");
            return PreferenceHelper.getInstance(context).getBoolean(PreferenceHelperConst.SP_RG_INSTANT_LAST_CLOUD_OPEN_STATE, true);
        }
        LogUtil.m15791e(TAG, "context is null");
        return true;
    }

    public int[] getPstLabelDis() {
        if (CloudlConfigDataModel.getInstance().isWebDataValid) {
            if (this.hasSetByCloud) {
                return this.mPstLabelDis;
            }
            MultiRoadConfig config = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
            if (config != null) {
                return config.getTagDistance();
            }
        }
        Context context = BNaviModuleManager.getContext();
        if (context == null) {
            LogUtil.m15791e(TAG, "context is null");
            return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
        }
        String labelDis = PreferenceHelper.getInstance(context).getString(PreferenceHelperConst.SP_RG_INSTANT_LAST_CLOUD_PSTLABELDIS_VALUE, null);
        if (labelDis == null || labelDis.length() == 0) {
            LogUtil.m15791e(TAG, "labelDis is null");
            return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
        }
        try {
            String[] disArray = labelDis.substring(1, labelDis.length() - 1).split(",");
            int len = disArray.length;
            if (len != 3) {
                return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
            }
            int[] disIntArray = new int[3];
            for (int index = 0; index < len; index++) {
                disIntArray[index] = Integer.valueOf(disArray[index].trim()).intValue();
            }
            return disIntArray;
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "Exception labelDis");
            return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
        }
    }

    public int getLastMile() {
        MultiRoadConfig config = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
        if (config == null) {
            return 1000;
        }
        int lastmile = config.getLastMile();
        if (lastmile <= 0) {
            lastmile = 1000;
        }
        return lastmile;
    }
}
