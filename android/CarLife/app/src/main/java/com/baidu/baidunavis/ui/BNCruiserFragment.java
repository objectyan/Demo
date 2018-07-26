package com.baidu.baidunavis.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.control.BNCruiseDialogManager;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.logic.C1757d;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.BCruiserConfig;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

public class BNCruiserFragment extends CarNaviMapPage {
    private Object mArg = null;
    private IBCruiserListener mBCruiserListener = new C08851();
    private BNCruiseDialogManager mCruiseDialogManager;
    private C1443g mFocusArea;
    private final Handler mHandler = new Handler();
    private View mItsButton;
    private View mItsVoiceButton;
    private int mJumpType = -1;
    private View mLocationView;
    private View mQuitBtn;
    private View mZoomInBtnView;
    private View mZoomOutBtnView;

    /* renamed from: com.baidu.baidunavis.ui.BNCruiserFragment$1 */
    class C08851 implements IBCruiserListener {
        C08851() {
        }

        public void onPageJump(int jumpType, Object arg1) {
            if (1 == jumpType) {
                if (BNCruiserFragment.this.mJumpType == -1) {
                    BCruiser.getInstance().quitCruise();
                    if (!C1663a.m5979a().m5993N() || C1757d.m6389a().m6393d() == null) {
                        C1772k.m6480a().m6485a(8, 0);
                        C1772k.m6480a().m6485a(2, 0);
                    } else if (C1757d.m6389a().m6393d().getMajorVersion() >= 2) {
                        C1772k.m6480a().m6485a(8, 0);
                    } else if (C1772k.m6480a().m6488b(C1253f.jx.m4403a())) {
                        C1772k.m6480a().m6485a(2, 0);
                    }
                    StatisticManager.onEventEnd(C1157a.m3876a(), StatisticConstants.HOME_MAP_EDOG_STATUS, StatisticConstants.HOME_MAP_EDOG_STATUS_TIME);
                }
                BNCruiserFragment.this.mJumpType = jumpType;
                BNCruiserFragment.this.mArg = arg1;
                if (BNCruiserFragment.this.getNaviFragmentManager().isCarlifeFragment(BNCruiserFragment.this.getNaviFragmentManager().getCurrentFragmentType())) {
                    BNCruiserFragment.this.mJumpType = jumpType;
                    BNCruiserFragment.this.mArg = arg1;
                    return;
                }
                BNCruiserFragment.this.mJumpType = -1;
                BNCruiserFragment.this.mArg = null;
                BNCruiserFragment.this.goBack();
            } else if (2 != jumpType) {
            } else {
                if (((Boolean) arg1).booleanValue()) {
                    BaiduNaviManager.getInstance().launchDownloadActivity(BaseFragment.mActivity, BNDownloadPage.KEY_FROM_CRUISER);
                } else {
                    BNCruiserFragment.this.goBack();
                }
            }
        }

        public void notifyLoacteData(LocData arg0) {
        }

        public void notifyQuitCruiser() {
        }

        public void notifyStartCruiser() {
        }
    }

    public int getPageType() {
        return 3;
    }

    public String getPageClsName() {
        return BNCruiserFragment.class.getName();
    }

    public boolean isMapPage() {
        return true;
    }

    public boolean forbidsConfigurationChange() {
        return false;
    }

    public boolean is3DGestureEnable() {
        return true;
    }

    public boolean forceResetModeWhenBack() {
        return true;
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        BaseTTSPlayer.getInstance().setEnableTimeOut(true);
        LocationManager.LocData locData = LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09);
        Bundle b = CoordinateTransformUtil.MC2LL((int) locData.longitude, (int) locData.latitude);
        LocData naviLLData = new LocData();
        naviLLData.longitude = b.getDouble("LLx");
        naviLLData.latitude = b.getDouble("LLy");
        LocationCallback.setData(naviLLData.toLocationOverlayJsonString(PreferenceHelper.getInstance(mActivity).getBoolean(Key.SP_Last_Cruise_Map_Status, true)));
        Bundle configParams = new Bundle();
        configParams.putInt(BCruiserConfig.KEY_CRUISER_VIEW_MODE, 1);
        this.mCruiseDialogManager = new BNCruiseDialogManager(mActivity, this);
        BCruiser.getInstance().setCruiseDialogManagerInterface(this.mCruiseDialogManager.getCruiseDialogManagerInterface());
        View view = BCruiser.getInstance().init(mActivity, configParams, null);
        if (view == null) {
            super.goBack();
            return null;
        }
        BCruiser.getInstance().setListener(this.mBCruiserListener);
        if (locData != null) {
            BCruiser.getInstance().updateInitLocation((int) locData.longitude, (int) locData.latitude);
        }
        BCruiser.getInstance().startCruise();
        BaiduNaviManager.getInstance().notifyNaviBeginChanged("1");
        NavTrajectoryController.getInstance().startRecord("", RoutePlanParams.MY_LOCATION, 3, true, true);
        UserOPController.getInstance().add(UserOPParams.RECORD_START_8_2_1, "3", null, null);
        SDKDebugFileUtil.end("RouteBottomEmpty");
        if (!C1663a.m5979a().m5993N() || C1757d.m6389a().m6393d() == null) {
            C1772k.m6480a().m6485a(8, 1);
            C1772k.m6480a().m6485a(2, 1);
        } else if (C1757d.m6389a().m6393d().getMajorVersion() >= 2) {
            C1772k.m6480a().m6485a(8, 1);
        } else if (C1772k.m6480a().m6488b(C1253f.jx.m4403a())) {
            C1772k.m6480a().m6485a(2, 1);
        }
        StatisticManager.onEventStart(C1157a.m3876a(), StatisticConstants.HOME_MAP_EDOG_STATUS, StatisticConstants.HOME_MAP_EDOG_STATUS_TIME);
        return view;
    }

    protected void onInitView() {
        if (this.mJumpType != -1 && this.mBCruiserListener != null) {
            this.mBCruiserListener.onPageJump(this.mJumpType, this.mArg);
        }
    }

    public void onResume() {
        super.onResume();
        BNMapController.getInstance().setNightMode(!BNStyleManager.getRealDayStyle());
        BCruiser.getInstance().onUpdateStyle(BNStyleManager.getRealDayStyle());
        BCruiser.getInstance().onResume();
        if (!(this.mJumpType == -1 || this.mBCruiserListener == null)) {
            this.mBCruiserListener.onPageJump(this.mJumpType, this.mArg);
        }
        if (C1663a.m5979a().m5993N()) {
            C1915a.m7321a().m7327a(true);
        } else {
            C1915a.m7321a().m7327a(false);
        }
    }

    public void onPause() {
        super.onPause();
        BCruiser.getInstance().onPause();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        BCruiser.getInstance().onConfigurationChanged(newConfig);
    }

    public boolean onBackPressed() {
        BCruiser.getInstance().onBackPressed();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        BaseTTSPlayer.getInstance().setEnableTimeOut(false);
        BaiduNaviManager.getInstance().notifyNaviBeginChanged("0");
        BCruiser.getInstance().quitCruise();
        BCruiser.destory();
        NavCommonFuncModel.sIsAnologNavi = false;
        BNRouteGuider.getInstance().setRotateMode(0);
        NavTrajectoryController.getInstance().endRecord(RoutePlanParams.TURN_TYPE_ID_END, false, 2);
        UserOPController.getInstance().add(UserOPParams.RECORD_END_8_2_2, "3", null, null);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        BCruiser.getInstance().onUpdateStyle(dayStyle);
    }

    public void onInitFocusAreas() {
        if (this.mContentView != null) {
            if (this.mFocusArea == null) {
                this.mQuitBtn = this.mContentView.findViewById(C4048R.id.bnav_cruise_rg_btn_quit);
                this.mItsVoiceButton = this.mContentView.findViewById(C4048R.id.bnav_cruise_btn_its_voice_witch);
                this.mItsButton = this.mContentView.findViewById(C4048R.id.bnav_cruise_btn_its_switch);
                this.mLocationView = this.mContentView.findViewById(C4048R.id.bnav_cruise_location_layout);
                this.mZoomInBtnView = this.mContentView.findViewById(C4048R.id.bnav_cruise_btn_zoom_in);
                this.mZoomOutBtnView = this.mContentView.findViewById(C4048R.id.bnav_cruise_btn_zoom_out);
                if (this.mQuitBtn != null && this.mItsVoiceButton != null && this.mItsButton != null && this.mLocationView != null && this.mZoomOutBtnView != null && this.mZoomInBtnView != null) {
                    this.mFocusArea = new C1443g(this.mContentView, 4, true);
                    this.mFocusArea.m5300d(this.mQuitBtn).m5300d(this.mLocationView).m5300d(this.mItsVoiceButton).m5300d(this.mItsButton).m5300d(this.mZoomInBtnView).m5300d(this.mZoomOutBtnView);
                } else {
                    return;
                }
            }
            C1440d.m5251a().m5256b(this.mFocusArea);
            if (!C1309g.m4699a().isDialogShown()) {
                C1440d.m5251a().m5268h(this.mFocusArea);
            }
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (type == 2) {
            switch (subType) {
                case 2:
                    BNMapController.getInstance().zoomOut();
                    replyVoiceCommand(type, 1, needResponse);
                    return true;
                case 3:
                    BNMapController.getInstance().zoomIn();
                    replyVoiceCommand(type, 1, needResponse);
                    return true;
                case 7:
                    VoiceCommandHelper.onITSChanged(true);
                    BCruiser.getInstance().updateItsBtn();
                    return true;
                case 8:
                    VoiceCommandHelper.onITSChanged(false);
                    BCruiser.getInstance().updateItsBtn();
                    return true;
                case 29:
                case 53:
                    BCruiser.getInstance().changeToNorth2DView();
                    return true;
                case 30:
                    BCruiser.getInstance().changeToCar3DView();
                    return true;
            }
        }
        return false;
    }
}
