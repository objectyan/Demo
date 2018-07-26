package com.baidu.navi.voice;

import android.os.Bundle;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C1269a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1306d;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class MapVoiceCommandController {
    private static final String TAG = MapVoiceCommandController.class.getSimpleName();
    private static MapVoiceCommandController mInstance;
    private C1306d mCarlifePresenter;

    private MapVoiceCommandController() {
    }

    public static MapVoiceCommandController getInstance() {
        if (mInstance == null) {
            mInstance = new MapVoiceCommandController();
        }
        return mInstance;
    }

    public void setCarlifePresenter(C1306d presenter) {
        this.mCarlifePresenter = presenter;
    }

    public boolean isMapModule() {
        return this.mCarlifePresenter.i() == 4003;
    }

    public void openNavi() {
        this.mCarlifePresenter.e();
    }

    public boolean isMapContentFragment() {
        int type = this.mCarlifePresenter.h();
        if (type == 17 || type == 52 || type == 113 || type == 116 || type == 114 || type == 33) {
            return true;
        }
        return false;
    }

    public boolean isRouteDetailFragment() {
        return this.mCarlifePresenter.h() == 52;
    }

    private void handleVoiceCommandMsg(int topType, int subType, int arg, Bundle data) {
        BNVoiceCommandController.getInstance().handleVoiceCommandMsg(topType, subType, arg, data);
    }

    public void startCalcRoute(double lng, double lat) {
        GeoPoint geoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(lng, lat);
        if (geoPoint.isValid()) {
            C1269a carLifeSearchPoi = new C1269a(((double) geoPoint.getLongitudeE6()) / 100000.0d, ((double) geoPoint.getLatitudeE6()) / 100000.0d);
            if (this.mCarlifePresenter != null) {
                this.mCarlifePresenter.a(carLifeSearchPoi);
            }
        }
    }

    public void switchDayNightMode(boolean isDay) {
        C1260i.b(TAG, "switchDayNightMode isDay: " + isDay);
        if (!isMapContentFragment()) {
            return;
        }
        if (isDay) {
            if (StyleManager.getDayStyle()) {
                C1915a.a().b("当前已为该模式", 0);
            } else {
                C1915a.a().b("已为您切换", 0);
            }
            handleVoiceCommandMsg(2, 32, 0, null);
            return;
        }
        if (StyleManager.getDayStyle()) {
            C1915a.a().b("已为您切换", 0);
        } else {
            C1915a.a().b("当前已为该模式", 0);
        }
        handleVoiceCommandMsg(2, 31, 0, null);
    }

    public void mapZoomIn() {
        C1260i.b(TAG, BNaviProtocolDef.COMMAND_MAP_ZOOM_IN);
        if (isMapContentFragment()) {
            if (BNMapController.getInstance().getZoomLevel() >= 20) {
                C1915a.a().b("已为最大模式", 0);
            } else {
                C1915a.a().b("地图已放大", 0);
            }
            handleVoiceCommandMsg(2, 3, 0, null);
        }
    }

    public void mapZoomOut() {
        C1260i.b(TAG, BNaviProtocolDef.COMMAND_MAP_ZOOM_OUT);
        if (isMapContentFragment()) {
            if (BNMapController.getInstance().getZoomLevel() <= 3) {
                C1915a.a().b("已为最小模式", 0);
            } else {
                C1915a.a().b("地图已缩小", 0);
            }
            handleVoiceCommandMsg(2, 2, 0, null);
        }
    }

    public boolean mapMoveLeft() {
        return mapMove(BNMapController.getInstance().getScreenWidth() / 3, 0);
    }

    public boolean mapMoveRight() {
        return mapMove((-BNMapController.getInstance().getScreenWidth()) / 3, 0);
    }

    public boolean mapMoveUp() {
        return mapMove(0, BNMapController.getInstance().getScreenHeight() / 3);
    }

    public boolean mapMoveDown() {
        return mapMove(0, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    public boolean mapMoveLeftDown() {
        return mapMove(BNMapController.getInstance().getScreenWidth() / 3, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    public boolean mapMoveRightDown() {
        return mapMove((-BNMapController.getInstance().getScreenWidth()) / 3, (-BNMapController.getInstance().getScreenHeight()) / 3);
    }

    public boolean mapMoveLeftUp() {
        return mapMove(BNMapController.getInstance().getScreenWidth() / 3, BNMapController.getInstance().getScreenHeight() / 3);
    }

    public boolean mapMoveRightUp() {
        return mapMove((-BNMapController.getInstance().getScreenWidth()) / 3, BNMapController.getInstance().getScreenHeight() / 3);
    }

    private static boolean mapMove(int x, int y) {
        MapStatus st = BNMapController.getInstance().getMapStatus();
        if (st == null) {
            return false;
        }
        Bundle bd = CoordinateTransformUtil.MC2LLE6(st._CenterPtX, st._CenterPtY);
        Point pt = BNMapController.getInstance().getScreenPosByGeoPos(new GeoPoint(bd.getInt("LLx"), bd.getInt("LLy")));
        if (pt == null) {
            return false;
        }
        pt.f19727x += x;
        pt.f19728y += y;
        GeoPoint newGP = BNMapController.getInstance().getGeoPosByScreenPos(pt.f19727x, pt.f19728y);
        Bundle b = CoordinateTransformUtil.LL2MC(((double) newGP.getLongitudeE6()) / 100000.0d, ((double) newGP.getLatitudeE6()) / 100000.0d);
        st._CenterPtX = b.getInt("MCx");
        st._CenterPtY = b.getInt("MCy");
        NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationPos);
        return true;
    }

    public void mapNorthForward() {
        C1260i.b(TAG, "mapNorthForward");
        if (isMapContentFragment()) {
            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                if (RGControlPanelModel.getInstance().getLocateStatus() == 2) {
                    C1915a.a().b("当前已为该模式", 0);
                } else {
                    C1915a.a().b("已为您切换", 0);
                }
            } else if (BaiduNaviSDKManager.getInstance().isCruiseBegin() || BCruiser.getInstance().isCruiseBegin()) {
                if (PreferenceHelper.getInstance(C1157a.a()).getBoolean(Key.SP_Last_Cruise_Map_Status, true)) {
                    C1915a.a().b("当前已为该模式", 0);
                } else {
                    C1915a.a().b("已为您切换", 0);
                }
            } else if (1 == MainMapModel.getInstance().getCurLocMode()) {
                C1915a.a().b("当前已为该模式", 0);
            } else {
                C1915a.a().b("已为您切换", 0);
            }
            handleVoiceCommandMsg(2, 29, 0, null);
        }
    }

    public void mapCarForward() {
        C1260i.b(TAG, "mapCarForward");
        if (isMapContentFragment()) {
            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                if (RGControlPanelModel.getInstance().getLocateStatus() == 1) {
                    C1915a.a().b("当前已为该模式", 0);
                } else {
                    C1915a.a().b("已为您切换", 0);
                }
            } else if (BaiduNaviSDKManager.getInstance().isCruiseBegin() || BCruiser.getInstance().isCruiseBegin()) {
                if (PreferenceHelper.getInstance(C1157a.a()).getBoolean(Key.SP_Last_Cruise_Map_Status, true)) {
                    C1915a.a().b("已为您切换", 0);
                } else {
                    C1915a.a().b("当前已为该模式", 0);
                }
            } else if (2 == MainMapModel.getInstance().getCurLocMode()) {
                C1915a.a().b("当前已为该模式", 0);
            } else {
                C1915a.a().b("已为您切换", 0);
            }
            handleVoiceCommandMsg(2, 30, 0, null);
        }
    }

    public void naviContinue() {
        C1260i.b(TAG, "naviContinue");
        if (!BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            handleError();
        } else if (RGControlPanelModel.getInstance().getFullviewState()) {
            C1915a.a().b("已为您切换", 0);
            BNavigator.getInstance().enterNavState();
        } else {
            C1915a.a().b("当前已为该模式", 0);
        }
    }

    public void naviFullView() {
        C1260i.b(TAG, "naviFullView");
        if (!BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            handleError();
        } else if (RGControlPanelModel.getInstance().getFullviewState()) {
            C1915a.a().b("当前已为该模式", 0);
        } else {
            C1915a.a().b("已为您切换", 0);
            BNavigator.getInstance().onVoiceCommand(2, 16, 0, null, true);
        }
    }

    public void switchRoadCondition(boolean isEnable) {
        C1260i.b(TAG, "switchRoadCondition isEnable: " + isEnable);
        if (isEnable) {
            if (BNSettingManager.isRoadCondOnOrOff()) {
                C1915a.a().b("当前路况已开启", 0);
            } else {
                C1915a.a().b("路况已开启", 0);
            }
            handleVoiceCommandMsg(2, 7, 0, null);
            return;
        }
        if (BNSettingManager.isRoadCondOnOrOff()) {
            C1915a.a().b("路况已关闭", 0);
        } else {
            C1915a.a().b("当前路况已关闭", 0);
        }
        handleVoiceCommandMsg(2, 8, 0, null);
    }

    public void switchNaviVoiceMode(boolean isNewerMode) {
        C1260i.b(TAG, "switchNaviVoiceMode isNewerMode: " + isNewerMode);
        if (isNewerMode) {
            handleVoiceCommandMsg(2, 33, 0, null);
        } else {
            handleVoiceCommandMsg(2, 34, 0, null);
        }
    }

    public void exitNavi() {
        C1260i.b(TAG, "exitNavi");
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().quitNavi();
        } else {
            handleError();
        }
    }

    public void startNavi() {
        C1260i.b(TAG, BNaviProtocolDef.COMMAND_START_NAVI);
        if (isRouteDetailFragment()) {
            handleVoiceCommandMsg(2, 65, 0, null);
        } else {
            handleError();
        }
    }

    public void cancelNavi() {
        C1260i.b(TAG, "cancelNavi");
        handleVoiceCommandMsg(2, 38, 0, null);
    }

    public void exitCruise() {
        C1260i.b(TAG, "exitCruise");
        if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            BaiduNaviSDKManager.getInstance().quitCruise();
        }
    }

    public void enterCruise() {
        C1260i.b(TAG, "enterCruise");
        C1915a.a().a(C1663a.a().N());
        C1328h.a().showFragment(114, null);
    }

    public void exitCruiseFollow() {
        C1260i.b(TAG, "exitCruiseFollow");
        if (BCruiser.getInstance().isCruiseBegin()) {
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
    }

    public void selectRoute(int index) {
        C1260i.b(TAG, "selectRoute index: " + index);
        handleVoiceCommandMsg(2, 67, index, null);
    }

    public void selectRouteAndStartNavi(int index) {
        C1260i.b(TAG, "selectRouteAndStartNavi index: " + index);
        handleVoiceCommandMsg(2, 66, index, null);
    }

    public void goHome() {
        C1260i.b(TAG, "goHome");
        handleVoiceCommandMsg(5, 5, 0, null);
    }

    public void goOffice() {
        C1260i.b(TAG, "goOffice");
        handleVoiceCommandMsg(5, 6, 0, null);
    }

    public void nameSearch(String key) {
        C1260i.b(TAG, "nameSearch key: " + key);
        Bundle data = new Bundle();
        data.putString("poiname", key);
        handleVoiceCommandMsg(5, 3, 0, data);
    }

    public void spaceSearch(String key) {
        C1260i.b(TAG, "spaceSearch key: " + key);
        Bundle data = new Bundle();
        data.putString("poiname", key);
        handleVoiceCommandMsg(5, 4, 0, data);
    }

    public void setHomeAddress(RoutePlanNode node) {
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
        UIModel.settingAddress(node, C1157a.a(), bundle);
    }

    public void setCompanyAddress(RoutePlanNode node) {
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
        UIModel.settingAddress(node, C1157a.a(), bundle);
    }

    private void handleError() {
        C1915a.a().b("当前页面不支持", 0);
        C2201w.a("当前页面不支持");
    }
}
