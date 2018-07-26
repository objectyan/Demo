package com.baidu.navisdk.ui.routeguide.fsm;

import android.graphics.Rect;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.RoutePlanResultItem;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;

public class RGStateFullview extends RGState {
    protected void onActionUI() {
        RGControlPanelModel.getInstance().updateLocateStatus(3);
        RGViewController.getInstance().setToolBoxStatus(0);
        RGViewController.getInstance().updateAssistFullViewModeBtn();
        RGViewController.getInstance().showCurRoadNameView();
        RGViewController.getInstance().setRoadConditionBarVisible(8);
    }

    protected void onActionNaviEngine() {
        RGEngineControl.getInstance().enableManualSound();
    }

    protected void onActionLayers() {
        BNRouteGuider.getInstance().setBrowseStatus(true);
    }

    protected void onActionMapStatus() {
        boolean isVertical = false;
        if (!RGControlPanelModel.getInstance().ismIsConfigChange()) {
            BNRouteGuider.getInstance().SetFullViewState(true);
        }
        if (RGControlPanelModel.getInstance().getFullviewState()) {
            int left;
            int top;
            int right;
            int bottom;
            NMapControlProxy.getInstance().enableTouchEventLookover(false);
            ArrayList<RoutePlanResultItem> routeitems = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getRouteNodeData();
            if (1 == RGCacheStatus.sOrientation) {
                left = 10;
                top = ScreenUtil.getInstance().dip2px(124);
                right = ScreenUtil.getInstance().getWidthPixels() - 10;
                bottom = ScreenUtil.getInstance().getHeightPixels();
                if (RGRouteRecommendModel.getInstance().isViewCanShow) {
                    bottom -= ScreenUtil.getInstance().dip2px(138);
                } else {
                    bottom -= ScreenUtil.getInstance().dip2px(60);
                }
            } else {
                left = (ScreenUtil.getInstance().getHeightPixels() / 4) + 10;
                top = 20;
                right = ScreenUtil.getInstance().getHeightPixels() - 10;
                bottom = ScreenUtil.getInstance().getWidthPixels();
                if (RGRouteRecommendModel.getInstance().isViewCanShow) {
                    bottom -= ScreenUtil.getInstance().dip2px(138);
                } else {
                    bottom -= ScreenUtil.getInstance().dip2px(60);
                }
            }
            Rect rect = new Rect(left, top, right, bottom);
            if (1 == RGCacheStatus.sOrientation) {
                isVertical = true;
            }
            BNMapController.getInstance().zoomToFullView(rect, isVertical, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), RGControlPanelModel.getInstance().mNeedAnimForFullview);
        }
        RGControlPanelModel.getInstance().mNeedAnimForFullview = true;
    }

    public void excute() {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "excute by reflection");
        RGControlPanelModel.getInstance().updateFullviewState(true);
        super.excute();
    }

    public void enter() {
        super.enter();
    }

    public void exit() {
        super.exit();
    }
}
