package com.baidu.navisdk.ui.routeguide;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.listener.BlueToothListener;

class BNavigator$1 extends Handler {
    final /* synthetic */ BNavigator this$0;

    BNavigator$1(BNavigator this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 1003:
                if (msg.arg1 == 0) {
                    SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                    if (poi != null && poi.mName.length() > 0) {
                        RGPickPointModel.getInstance().updateAntiSearchPoi(poi);
                        RGViewController.getInstance().mIsPickPointDripShow = true;
                        RGViewController.getInstance().updatePickPointView();
                        RGViewController.getInstance().showPickPointView();
                        RGPickPointModel.getInstance().setPickPointShow(true);
                        return;
                    }
                    return;
                } else if (BNavigator.access$000(this.this$0) != null) {
                    TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), BNStyleManager.getString(C4048R.string.nsdk_string_rg_pp_no_data_no_network));
                    return;
                } else {
                    return;
                }
            case BlueToothListener.MSG_TYPE_BT_CHANGE /*10601*/:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "BlueToothListener.MSG_TYPE_BT_CHANGE");
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "isBTConnect = " + BlueToothListener.isBTConnect + ", msg.arg1 = " + msg.arg1);
                if (BlueToothListener.isBTConnect && msg.arg1 == 1) {
                    BNavigator.access$100(this.this$0);
                    if (!BNavigator.access$200(this.this$0)) {
                        if (msg.arg2 != 2) {
                            RGNotificationController.getInstance().showBlueTooth();
                            return;
                        } else if (RGNotificationController.getInstance().getLocalRouteType() == -1) {
                            RGNotificationController.getInstance().showBlueTooth();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (msg.arg2 == 0) {
                    RGMapModeViewController.getInstance().closeSCO(12);
                    return;
                } else if (msg.arg2 == 1) {
                    RGMapModeViewController.getInstance().closeSCO(15);
                    return;
                } else {
                    return;
                }
            case 10901:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "mHandler MSG_TYPE_OPEN_BLUETOOTH_SCO");
                RGMapModeViewController.getInstance().openSCO(2);
                return;
            case BNavigator.MSG_TYPE_INIT /*10921*/:
                if (msg.arg1 == 1) {
                    RGViewController.getInstance().delayRefreshViewAfterInit();
                    return;
                }
                return;
            case 10931:
                this.this$0.mIsGPSDisable = false;
                RGViewController.getInstance().updateSatelliteNum(RGSimpleGuideModel.getInstance().getSatelliteNum());
                return;
            default:
                return;
        }
    }
}
