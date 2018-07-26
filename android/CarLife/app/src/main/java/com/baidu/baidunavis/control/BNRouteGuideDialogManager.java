package com.baidu.baidunavis.control;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C0772c;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.dialog.C0770k;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController$RouteGuideDialogManagerInterface;
import com.baidu.navisdk.ui.routeguide.model.RGNaviQuitModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNRouteGuideDialogManager {
    private static final String TAG = "RouteGuide";
    private Context mActivity;
    private C1953c mExitDialog;
    private C1953c mGPSSettingDialog;
    private boolean mIsDebugLogOn = false;
    private C1953c mNaviQuitDialog;
    private C1277e mOnDialogListener;
    private C1953c mReCalcExitDialog;
    private RGMapModeViewController$RouteGuideDialogManagerInterface mRouteGuideDialogManagerInterface = new C07681();
    private C1953c mViaComfirmDialog;

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$1 */
    class C07681 implements RGMapModeViewController$RouteGuideDialogManagerInterface {
        C07681() {
        }

        public void showYawingQuitDialog() {
            BNRouteGuideDialogManager.this.showYawingQuitDialogCarlife();
        }

        public void showYawingLoading(String arg0) {
            BNRouteGuideDialogManager.this.showYawingLoadingCarlife(arg0);
        }

        public void showQuitDialog(boolean arg0) {
            BNRouteGuideDialogManager.this.showQuitDialogCarlife(arg0);
        }

        public void showGPSSettingDialog() {
            BNRouteGuideDialogManager.this.showGPSSettingDialogCarlife();
        }

        public void releaseAllDialogs() {
            BNRouteGuideDialogManager.this.releaseAllDialogsCarlife();
        }

        public void hideAllDialogs() {
            BNRouteGuideDialogManager.this.hideAllDialogsCarlife();
        }

        public void showViaComfirmDialog() {
            BNRouteGuideDialogManager.this.showViaComfirmDialogCarlife();
        }

        public void hideViaComfirmDialog() {
            BNRouteGuideDialogManager.this.hideViaComfirmDialogCarlife();
        }

        public void showLoading(String strTip, OnCancelListener listener) {
            BNRouteGuideDialogManager.this.showLoadingCarLife(strTip, listener);
        }

        public void dismissLoading() {
            BNRouteGuideDialogManager.this.dismissLoadingCarLife();
        }

        public void showReCalRouteQuitDialog() {
            BNRouteGuideDialogManager.this.showReCalRouteQuitDialogCarLife();
        }

        public void dismissYawingLoading() {
            BNRouteGuideDialogManager.this.dismissYawingLoadingCarlife();
        }

        public void dismissQuitDialog() {
            BNRouteGuideDialogManager.this.dismissQuitDialogCarlife();
        }

        public void dismissGPSSettingDialog() {
            BNRouteGuideDialogManager.this.dismissGPSSettingDialogCarlife();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$2 */
    class C07692 implements C0672b {
        C07692() {
        }

        public void onClick() {
            UgcNaviDynamicMarkRespository.getInstance().clear();
            RGNaviQuitModel.getInstance().setCountDown(false);
            RGViewController.getInstance().quitNavWhenConfirm();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$3 */
    class C07713 implements C0770k {
        C07713() {
        }

        public void onDismiss() {
            if (BNRouteGuideDialogManager.this.mIsDebugLogOn) {
                C2201w.m8373a("dialog dismiss", 0);
            }
            BottomTabDisplayController.getInstance().panelHide();
        }

        public void onShow() {
            if (BNRouteGuideDialogManager.this.mIsDebugLogOn) {
                C2201w.m8373a("dialog show", 0);
            }
            BottomTabDisplayController.getInstance().panelShow();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$4 */
    class C07734 implements C0772c {
        C07734() {
        }

        public void onCountDown(int count) {
            if (count <= 0) {
                RGViewController.getInstance().quitNavWhenConfirm();
                BNRouteGuideDialogManager.this.mOnDialogListener.dismissDialog(BNRouteGuideDialogManager.this.mNaviQuitDialog);
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$5 */
    class C07745 implements C0672b {
        C07745() {
        }

        public void onClick() {
            RGViewController.getInstance().dismissHUDDialog();
            RGViewController.getInstance().quitNavWhenConfirm();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$6 */
    class C07756 implements C0672b {
        C07756() {
        }

        public void onClick() {
            BNRouteGuideDialogManager.this.showYawingLoadingCarlife(BNStyleManager.getString(C4048R.string.nsdk_string_rg_yawing));
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$7 */
    class C07767 implements C0672b {
        C07767() {
        }

        public void onClick() {
            BNRouteGuideDialogManager.this.showYawingQuitDialogCarlife();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$8 */
    class C07778 implements C0690d {
        C07778() {
        }

        public void onCancel() {
            BNRouteGuideDialogManager.this.showYawingQuitDialogCarlife();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNRouteGuideDialogManager$9 */
    class C07789 implements C0672b {
        C07789() {
        }

        public void onClick() {
            TipTool.onCreateToastDialog(BNRouteGuideDialogManager.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_open_gps));
        }
    }

    public RGMapModeViewController$RouteGuideDialogManagerInterface getRouteGuideDialogManagerInterface() {
        return this.mRouteGuideDialogManagerInterface;
    }

    public BNRouteGuideDialogManager(Context activity, C1277e listener) {
        this.mActivity = activity;
        this.mOnDialogListener = listener;
    }

    public void releaseAllDialogsCarlife() {
        this.mNaviQuitDialog = null;
        this.mGPSSettingDialog = null;
        hideAllDialogsCarlife();
    }

    public void hideAllDialogsCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mExitDialog);
        } catch (Exception e) {
            this.mExitDialog = null;
        }
    }

    public void showQuitDialogCarlife(boolean showCountDown) {
        dismissQuitDialogCarlife();
        try {
            this.mNaviQuitDialog = new C1953c(this.mActivity).m7435a((int) C0965R.string.nsdk_string_rg_navi_quit_arrived).m7447c((int) C0965R.string.nsdk_string_rg_navi_quit_word).m7438a(new C07692());
            this.mNaviQuitDialog.setDialogShowHideListener(new C07713());
            if (!BNNaviResultModel.getInstance().isDestArrived()) {
                this.mNaviQuitDialog.m7435a((int) C0965R.string.nsdk_string_rg_navi_quit_not_arrived);
                this.mNaviQuitDialog.m7450d((int) C0965R.string.nsdk_string_rg_navi_quit_back);
            }
            if (showCountDown) {
                this.mNaviQuitDialog.m7436a(1, 10);
                this.mNaviQuitDialog.m7439a(new C07734());
            }
            if (showCountDown) {
                this.mOnDialogListener.dismissDialog(this.mNaviQuitDialog);
            }
            this.mOnDialogListener.showDialog(this.mNaviQuitDialog);
        } catch (Exception e) {
        }
    }

    public void dismissQuitDialogCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mNaviQuitDialog);
        } catch (Exception e) {
            this.mNaviQuitDialog = null;
        }
    }

    public void showYawingQuitDialogCarlife() {
        if (this.mActivity != null) {
            dismissQuitDialogCarlife();
            try {
                this.mExitDialog = new C1953c(this.mActivity).m7448c(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).m7444b(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_yaw_exit)).m7454e(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).m7459r().m7443b(new C07756()).m7451d(BNStyleManager.getString(C4048R.string.nsdk_string_rg_exit_check)).m7458q().m7438a(new C07745());
                this.mOnDialogListener.showDialog(this.mExitDialog);
            } catch (Exception e) {
            }
        }
    }

    public void showYawingLoadingCarlife(String strTip) {
        try {
            NavMapAdapter.getInstance().closeCarLifeVR();
            C1307e.m4686a().mo1466a(strTip, new C07767(), new C07778());
        } catch (Exception e) {
        }
    }

    public void dismissYawingLoadingCarlife() {
        C1307e.m4686a().mo1468c();
    }

    public void showGPSSettingDialogCarlife() {
        try {
            if (this.mGPSSettingDialog == null) {
                this.mGPSSettingDialog = new C1953c(this.mActivity).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_title_tip)).m7444b(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_gps_not_open_and_set)).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_alert_setting)).m7458q().m7438a(new C0672b() {
                    public void onClick() {
                        try {
                            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                            intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                            BNRouteGuideDialogManager.this.mActivity.startActivity(intent);
                        } catch (Exception e) {
                            LogUtil.e("", e.toString());
                            TipTool.onCreateToastDialog(BNRouteGuideDialogManager.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_no_gps));
                        }
                    }
                }).m7454e(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).m7443b(new C07789());
            }
            this.mOnDialogListener.showDialog(this.mGPSSettingDialog);
        } catch (Exception e) {
            this.mGPSSettingDialog = null;
        }
    }

    public void dismissGPSSettingDialogCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
        } catch (Exception e) {
            this.mGPSSettingDialog = null;
        }
    }

    public void showViaComfirmDialogCarlife() {
        if (this.mActivity != null) {
            hideViaComfirmDialogCarlife();
            try {
                this.mViaComfirmDialog = new C1953c(this.mActivity).m7448c(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).m7444b(BNStyleManager.getString(C4048R.string.nsdk_string_rg_pp_set_via_tips)).m7457g(17).m7454e(BNStyleManager.getString(C4048R.string.nsdk_string_rg_exit_check)).m7459r().m7443b(new C0672b() {
                    public void onClick() {
                        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                            RGRouteSearchModel.getInstance().setRouteSearchMode(false);
                            BNPoiSearcher.getInstance().clearBkgCache();
                            BNMapController.getInstance().updateLayer(4);
                            BNMapController.getInstance().showLayer(4, false);
                        }
                        RGEngineControl.getInstance().addViaPtToCalcRoute(RGPickPointModel.getInstance().getPickPoint(), RGPickPointModel.getInstance().getAntiSearchPoi() != null ? RGPickPointModel.getInstance().getAntiSearchPoi().mName : "");
                    }
                }).m7451d(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel));
                this.mOnDialogListener.showDialog(this.mViaComfirmDialog);
            } catch (Exception e) {
            }
        }
    }

    public void hideViaComfirmDialogCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mViaComfirmDialog);
        } catch (Exception e) {
            this.mViaComfirmDialog = null;
        }
    }

    public void showReCalRouteQuitDialogCarLife() {
        if (this.mActivity == null) {
            LogUtil.e("RouteGuide", "showReCalRouteQuitDialog mActivity == null");
            BNRoutePlaner.getInstance().cancleCalcRouteRequest();
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
            return;
        }
        dismissQuitDialogCarlife();
        try {
            String string;
            C1953c c = new C1953c(this.mActivity).m7448c(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_title_tip));
            if (BNavConfig.pRGLocateMode == 2) {
                string = BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_gps_demo_exit);
            } else {
                string = BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_yaw_exit);
            }
            this.mReCalcExitDialog = c.m7444b(string).m7454e(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).m7459r().m7443b(new C0672b() {
                public void onClick() {
                    BNRoutePlaner.getInstance().showReCalRouteProgressDialog();
                }
            }).m7451d(BNStyleManager.getString(C4048R.string.nsdk_string_rg_exit_check)).m7458q().m7438a(new C0672b() {
                public void onClick() {
                    BNRoutePlaner.getInstance().cancleCalcRouteRequest();
                    BNRoutePlaner.getInstance().clearRouteInfoHandler();
                }
            });
            this.mOnDialogListener.showDialog(this.mReCalcExitDialog);
        } catch (Exception e) {
        }
    }

    public void showLoadingCarLife(String strTip, final OnCancelListener listener) {
        try {
            C1307e.m4686a().mo1465a(strTip, new C0672b() {
                public void onClick() {
                    if (listener != null) {
                        listener.onCancel(null);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    public void dismissLoadingCarLife() {
        C1307e.m4686a().mo1468c();
    }
}
