package com.baidu.navisdk.comapi.voicecommand;

import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class VoiceCommandHelper {
    public static boolean MapMoveLeft() {
        return MapMove((-BNMapController.getInstance().getScreenWidth()) / 3, 0);
    }

    public static boolean MapMoveRight() {
        return MapMove(BNMapController.getInstance().getScreenWidth() / 3, 0);
    }

    public static boolean MapMoveUp() {
        return MapMove(0, BNMapController.getInstance().getScreenHeight() / 3);
    }

    public static boolean MapMoveDown() {
        return MapMove(0, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    private static boolean MapMove(int x, int y) {
        MapStatus st = BNMapController.getInstance().getMapStatus();
        if (st == null) {
            return false;
        }
        Bundle bd = CoordinateTransformUtil.MC2LLE6(st._CenterPtX, st._CenterPtY);
        Point pt = BNMapController.getInstance().getScreenPosByGeoPos(new GeoPoint(bd.getInt("LLx"), bd.getInt("LLy")));
        pt.f19727x += x;
        pt.f19728y += y;
        GeoPoint newGP = BNMapController.getInstance().getGeoPosByScreenPos(pt.f19727x, pt.f19728y);
        Bundle b = CoordinateTransformUtil.LL2MC(((double) newGP.getLongitudeE6()) / 100000.0d, ((double) newGP.getLatitudeE6()) / 100000.0d);
        st._CenterPtX = b.getInt("MCx");
        st._CenterPtY = b.getInt("MCy");
        NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationPos);
        return true;
    }

    public static boolean onITSChanged(boolean openITS) {
        if (!openITS || BNSettingManager.isRoadCondOnOrOff()) {
            if (!openITS && PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false)) {
                BNMapController.getInstance().showTrafficMap(false);
                BNSettingManager.setRoadCondOnOff(false);
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_is_off));
            }
        } else if (BNSettingManager.isNaviRealHistoryITS()) {
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                BNMapController.getInstance().showTrafficMap(true);
                BNSettingManager.setRoadCondOnOff(true);
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_is_on));
            } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_offline));
            }
        }
        return true;
    }

    public static boolean switchNaviMode() {
        if (RouteGuideFSM.getInstance().isBaseState()) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_LOC_CAR);
        } else {
            for (int i = 0; i < 5 && !RouteGuideFSM.getInstance().isBaseState(); i++) {
                RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            }
        }
        return true;
    }

    public static boolean switchAR() {
        String curState = RouteGuideFSM.getInstance().getCurrentState();
        for (int i = 0; i < 5 && !"HUD".equals(curState) && !RouteGuideFSM.getInstance().isBaseState(); i++) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            curState = RouteGuideFSM.getInstance().getCurrentState();
        }
        if ("HUD".equals(curState)) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_AR);
        } else if (RouteGuideFSM.getInstance().isBaseState()) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_AR);
        }
        return true;
    }

    public static boolean switchHUDMirror() {
        String curState = RouteGuideFSM.getInstance().getCurrentState();
        for (int i = 0; i < 5 && !FsmState.HUDMirror.equals(curState) && !"HUD".equals(curState) && !RouteGuideFSM.getInstance().isBaseState(); i++) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            curState = RouteGuideFSM.getInstance().getCurrentState();
        }
        if ("HUD".equals(curState)) {
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_HUD_GOTO_MIRROR);
        } else if (RouteGuideFSM.getInstance().isBaseState()) {
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_HUD_GOTO_MIRROR);
        }
        return true;
    }

    public static boolean switchHUD() {
        String curState = RouteGuideFSM.getInstance().getCurrentState();
        for (int i = 0; i < 5 && !"HUD".equals(curState) && !RouteGuideFSM.getInstance().isBaseState(); i++) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            curState = RouteGuideFSM.getInstance().getCurrentState();
        }
        if (RouteGuideFSM.getInstance().isBaseState()) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_HUD_ENTER);
        }
        return true;
    }

    public static boolean help() {
        return true;
    }

    public static boolean lockPhone() {
        return true;
    }
}
