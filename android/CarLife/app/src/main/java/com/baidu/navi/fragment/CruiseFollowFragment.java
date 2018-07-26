package com.baidu.navi.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.ui.BNDownloadPage;
import com.baidu.baidunavis.ui.CarNaviMapPage;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.logic.C1757d;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.BNCruiseDialogManager;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.BCruiserConfig;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;

public class CruiseFollowFragment extends CarNaviMapPage {
    private Object mArg = null;
    private IBCruiserListener mBCruiserListener = new C37891();
    private BNCruiseDialogManager mCruiseDialogManager;
    private C1443g mFocusArea;
    private View mItsButton;
    private View mItsVoiceButton;
    private int mJumpType = -1;
    private View mLocationView;
    private long mNaviStartTime;
    private View mQuitBtn;
    private View mZoomInBtnView;
    private View mZoomOutBtnView;
    private View view;

    /* renamed from: com.baidu.navi.fragment.CruiseFollowFragment$1 */
    class C37891 implements IBCruiserListener {
        C37891() {
        }

        public void onPageJump(int jumpType, Object arg1) {
            if (1 == jumpType) {
                if (CruiseFollowFragment.this.mJumpType == -1) {
                    BCruiser.getInstance().quitCruise();
                    if (!C1663a.a().N() || C1757d.a().d() == null) {
                        C1772k.a().a(9, 0);
                        C1772k.a().a(2, 0);
                    } else if (C1757d.a().d().getMajorVersion() >= 2) {
                        C1772k.a().a(9, 0);
                    } else if (C1772k.a().b(C1253f.jx.a())) {
                        C1772k.a().a(2, 0);
                    }
                    long cruiseFollowTime = System.currentTimeMillis() - CruiseFollowFragment.this.mNaviStartTime;
                    StatisticManager.onEventDuration(C1157a.a(), StatisticConstants.NAVI_0011, StatisticConstants.HOME_MAP_CRUISE_STATUS_TIME, (int) cruiseFollowTime);
                    if (cruiseFollowTime >= 18000000) {
                        StatisticManager.onEvent(StatisticConstants.NAVI_0012, StatisticConstants.NAVI_0012);
                    }
                }
                CruiseFollowFragment.this.mJumpType = jumpType;
                CruiseFollowFragment.this.mArg = arg1;
                if (CruiseFollowFragment.this.isCarlifeFragment(CruiseFollowFragment.this.getCurrentFragmentType())) {
                    CruiseFollowFragment.this.mJumpType = jumpType;
                    CruiseFollowFragment.this.mArg = arg1;
                    return;
                }
                CruiseFollowFragment.this.mJumpType = -1;
                CruiseFollowFragment.this.mArg = null;
                CruiseFollowFragment.this.goBack();
            } else if (2 != jumpType) {
            } else {
                if (((Boolean) arg1).booleanValue()) {
                    BaiduNaviManager.getInstance().launchDownloadActivity(BaseFragment.mActivity, BNDownloadPage.KEY_FROM_CRUISER);
                } else {
                    CruiseFollowFragment.this.goBack();
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

    /* renamed from: com.baidu.navi.fragment.CruiseFollowFragment$2 */
    class C37902 implements OnFocusChangeListener {
        C37902() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                CruiseFollowFragment.this.showQuitBtn();
            }
        }
    }

    public int getPageType() {
        return 3;
    }

    public String getPageClsName() {
        return CruiseFollowFragment.class.getName();
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
        this.view = BCruiser.getInstance().init(mActivity, configParams, null);
        if (this.view == null) {
            super.goBack();
            return null;
        }
        BCruiser.getInstance().setListener(this.mBCruiserListener);
        EnterQuitLogicManager.getmInstance().setListener(this.mBCruiserListener);
        if (locData != null) {
            BCruiser.getInstance().updateInitLocation((int) locData.longitude, (int) locData.latitude);
        }
        BCruiser.getInstance().startCruise();
        BaiduNaviManager.getInstance().notifyNaviBeginChanged("1");
        NavTrajectoryController.getInstance().startRecord("", RoutePlanParams.MY_LOCATION, 3, true, true);
        if (!C1663a.a().N() || C1757d.a().d() == null) {
            C1772k.a().a(9, 1);
            C1772k.a().a(2, 1);
        } else if (C1757d.a().d().getMajorVersion() >= 2) {
            C1772k.a().a(9, 1);
        } else if (C1772k.a().b(C1253f.jx.a())) {
            C1772k.a().a(2, 1);
        }
        this.mNaviStartTime = System.currentTimeMillis();
        return this.view;
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
        if (C1663a.a().N()) {
            C1915a.a().a(true);
        } else {
            C1915a.a().a(false);
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

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        BaseTTSPlayer.getInstance().setEnableTimeOut(false);
        BaiduNaviManager.getInstance().notifyNaviBeginChanged("0");
        BCruiser.getInstance().quitCruise();
        BCruiser.destory();
        NavCommonFuncModel.sIsAnologNavi = false;
        BNRouteGuider.getInstance().setRotateMode(0);
        NavTrajectoryController.getInstance().endRecord(RoutePlanParams.TURN_TYPE_ID_END, false, 3);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        BCruiser.getInstance().onUpdateStyle(dayStyle);
    }

    public void onInitFocus() {
        if (this.view != null) {
            if (this.mFocusArea == null) {
                this.mItsVoiceButton = this.view.findViewById(C0965R.id.bnav_cruise_btn_its_voice_witch);
                setFocusListener(this.mItsVoiceButton);
                this.mLocationView = this.view.findViewById(C0965R.id.bnav_cruise_location_layout);
                setFocusListener(this.mLocationView);
                this.mQuitBtn = this.view.findViewById(C0965R.id.bnav_cruise_rg_btn_quit);
                this.mZoomOutBtnView = this.view.findViewById(C0965R.id.bnav_cruise_btn_zoom_out);
                setFocusListener(this.mZoomOutBtnView);
                this.mZoomInBtnView = this.view.findViewById(C0965R.id.bnav_cruise_btn_zoom_in);
                setFocusListener(this.mZoomInBtnView);
                this.mItsButton = this.view.findViewById(C0965R.id.bnav_cruise_btn_its_switch);
                setFocusListener(this.mItsButton);
                if (this.mQuitBtn != null && this.mItsVoiceButton != null && this.mItsButton != null && this.mLocationView != null && this.mZoomOutBtnView != null && this.mZoomInBtnView != null) {
                    this.mFocusArea = new C1443g(this.view, 4, true);
                    this.mFocusArea.d(this.mItsVoiceButton).d(this.mItsButton).d(this.mZoomInBtnView).d(this.mZoomOutBtnView).d(this.mQuitBtn).d(this.mLocationView);
                } else {
                    return;
                }
            }
            C1440d.a().b(new C1436a[]{this.mFocusArea});
            C1440d.a().h(this.mFocusArea);
        }
    }

    private void showQuitBtn() {
        if (this.mQuitBtn != null) {
            this.mQuitBtn.setVisibility(0);
        }
    }

    private void setFocusListener(View view) {
        view.setOnFocusChangeListener(new C37902());
    }

    public void onInitFocusAreas() {
        onInitFocus();
    }

    private void turnOnUnexpectPrompt() {
        Bundle setting = new Bundle();
        setting.putInt(Key.SP_Close_Speed_Camera, 0);
        setting.putInt(Key.SP_Close_Traffic_Camera, 0);
        setting.putInt(Key.SP_Close_Break_Rules, 0);
        setting.putInt("CloseTrafficSign", 1);
        BNRouteGuider.getInstance().SetCruiseSetting(setting);
    }

    private void turnOffUnexpectPrompt() {
        Bundle setting = new Bundle();
        setting.putInt(Key.SP_Close_Speed_Camera, 1);
        setting.putInt(Key.SP_Close_Traffic_Camera, 1);
        setting.putInt(Key.SP_Close_Break_Rules, 1);
        setting.putInt("CloseTrafficSign", 1);
        BNRouteGuider.getInstance().SetCruiseSetting(setting);
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
