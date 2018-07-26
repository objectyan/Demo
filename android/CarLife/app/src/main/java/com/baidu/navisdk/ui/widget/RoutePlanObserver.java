package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.ConfirmArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.ConfirmOTArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.LackDataArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;

public class RoutePlanObserver implements BNRoutePlanObserver {
    private static BNNetworkingDialog mRoutePlanAvoidTrafficJamDialog = null;
    private static BNMessageDialog mRoutePlanFirstCalcDialog = null;
    private static BNMessageDialog mRoutePlanNetworkingDialog = null;
    private static BNMessageDialog mRoutePlanNoNetNoDataDialog = null;
    private static BNMessageDialog mRoutePlanOvertimeDialog = null;
    private static BNCommonProgressDialog mWaitProgress = null;
    private WeakReference<Activity> mActivity = null;
    private IJumpToDownloadListener mIIJumpToDownloadListener = null;
    private BNMessageDialog mNaviMessageDialog = null;

    /* renamed from: com.baidu.navisdk.ui.widget.RoutePlanObserver$1 */
    class C46051 implements OnNaviClickListener {
        C46051() {
        }

        public void onClick() {
            RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
            if (RoutePlanObserver.this.mActivity.get() != null) {
                ((Activity) RoutePlanObserver.this.mActivity.get()).startActivity(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"));
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.RoutePlanObserver$2 */
    class C46062 implements OnNaviClickListener {
        C46062() {
        }

        public void onClick() {
            RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
            if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
                RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.RoutePlanObserver$3 */
    class C46073 implements OnCancelListener {
        C46073() {
        }

        public void onCancel(DialogInterface dialog) {
            LogUtil.m15791e("RoutePlan", "WaitProgress onCancel!");
            RGViewController.getInstance().showReCalRouteQuitDialog();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.RoutePlanObserver$4 */
    class C46084 implements OnClickListener {
        C46084() {
        }

        public void onClick(View v) {
            RoutePlanObserver.this.dismissRoutePlanAvoidTrafficJamDialog();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.RoutePlanObserver$5 */
    class C46095 implements OnNaviClickListener {
        C46095() {
        }

        public void onClick() {
            RoutePlanObserver.this.dismissRoutePlanNetworkingDialog();
            if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
                RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.RoutePlanObserver$6 */
    class C46106 implements OnNaviClickListener {
        C46106() {
        }

        public void onClick() {
            RoutePlanObserver.this.dismissRoutePlanOvertimeDialog();
        }
    }

    public interface IJumpToDownloadListener {
        void onJumpToDownloadOfflineData();
    }

    public RoutePlanObserver(Activity activity, IJumpToDownloadListener l) {
        this.mActivity = new WeakReference(activity);
        this.mIIJumpToDownloadListener = l;
    }

    public void onRouterPlanTipShow(FailArg failArg) {
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing()) {
            TipTool.onCreateToastDialog((Context) this.mActivity.get(), failArg.mFailText + getDebugToastMessage(failArg));
        }
    }

    public void onRouterPlanFailReasonShow(FailArg failArg) {
        switch (failArg.mFailType) {
            case 420:
                if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing()) {
                    TipTool.onCreateToastDialog((Context) this.mActivity.get(), "数据缺失，请检查" + getDebugToastMessage(failArg));
                    return;
                }
                return;
            case 421:
                if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing()) {
                    TipTool.onCreateToastDialog((Context) this.mActivity.get(), "无网络无数据，请检查" + getDebugToastMessage(failArg));
                    return;
                }
                return;
            default:
                if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing()) {
                    TipTool.onCreateToastDialog((Context) this.mActivity.get(), failArg.mFailText + getDebugToastMessage(failArg));
                    return;
                }
                return;
        }
    }

    private String getDebugToastMessage(FailArg failArg) {
        return LogUtil.LOGGABLE ? "(" + failArg.mFailType + ")" : "";
    }

    public void showMessageDialog(Context ctx, String messageStr) {
        dismissMessageDialog();
        if (this.mNaviMessageDialog == null && ctx != null) {
            this.mNaviMessageDialog = new BNMessageDialog((Activity) ctx).setMessage(messageStr).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).setFirstBtnEnabled(true).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_alert_iknown));
        }
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && this.mNaviMessageDialog != null) {
            try {
                this.mNaviMessageDialog.show();
            } catch (Exception e) {
            }
        }
    }

    public boolean dismissMessageDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || this.mNaviMessageDialog == null || !this.mNaviMessageDialog.isShowing())) {
            try {
                this.mNaviMessageDialog.dismiss();
            } catch (Exception e) {
            }
        }
        this.mNaviMessageDialog = null;
        return true;
    }

    public void showRoutePlanNetworkingDialog(Context ctx, String contentString, String confirmString, OnNaviClickListener onlineListener, OnNaviClickListener downloadListener) {
        dismissRoutePlanNetworkingDialog();
        if (mRoutePlanNetworkingDialog == null && this.mActivity.get() != null) {
            mRoutePlanNetworkingDialog = new BNMessageDialog((Activity) this.mActivity.get()).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).setMessage(contentString).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_down_data)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_use_online)).setOnFirstBtnClickListener(downloadListener).setOnSecondBtnClickListener(onlineListener);
        }
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && mRoutePlanNetworkingDialog != null) {
            try {
                mRoutePlanNetworkingDialog.show();
            } catch (Exception e) {
            }
        }
    }

    public boolean dismissRoutePlanNetworkingDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || mRoutePlanNetworkingDialog == null || !mRoutePlanNetworkingDialog.isShowing())) {
            try {
                mRoutePlanNetworkingDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mRoutePlanNetworkingDialog = null;
        return true;
    }

    public void showRoutePlanAvoidTrafficJamDialog(Context ctx, String contentString, String confirmString, OnClickListener confirmListener, OnClickListener cancleListener) {
        dismissRoutePlanAvoidTrafficJamDialog();
        if (mRoutePlanAvoidTrafficJamDialog == null) {
            mRoutePlanAvoidTrafficJamDialog = new BNNetworkingDialog((Activity) ctx).setNetworkingContentMessage(contentString).setConfirmNetworkMessage(confirmString).setConfirmNetworkingListener(confirmListener).setCancleListener(cancleListener).setTwoButtonMode(true);
        }
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && mRoutePlanAvoidTrafficJamDialog != null) {
            try {
                mRoutePlanAvoidTrafficJamDialog.show();
            } catch (Exception e) {
            }
        }
    }

    public boolean dismissRoutePlanAvoidTrafficJamDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || mRoutePlanAvoidTrafficJamDialog == null || !mRoutePlanAvoidTrafficJamDialog.isShowing())) {
            try {
                mRoutePlanAvoidTrafficJamDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mRoutePlanAvoidTrafficJamDialog = null;
        return true;
    }

    public void showRoutePlanOvertimeDialog(Context ctx, OnNaviClickListener confirmListener, OnNaviClickListener cancleListener) {
        dismissRoutePlanOvertimeDialog();
        if (mRoutePlanOvertimeDialog == null && this.mActivity.get() != null) {
            mRoutePlanOvertimeDialog = new BNMessageDialog((Activity) this.mActivity.get()).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_recalc_tip)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_negative)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_recalc)).setOnFirstBtnClickListener(cancleListener).setOnSecondBtnClickListener(confirmListener);
        }
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && mRoutePlanOvertimeDialog != null) {
            try {
                mRoutePlanOvertimeDialog.show();
            } catch (Exception e) {
            }
        }
    }

    public boolean dismissRoutePlanOvertimeDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || mRoutePlanOvertimeDialog == null || !mRoutePlanOvertimeDialog.isShowing())) {
            try {
                mRoutePlanOvertimeDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mRoutePlanOvertimeDialog = null;
        return true;
    }

    public void showRoutePlanNoNetNoDataDialog(Context ctx, String lackCity) {
        dismissRoutePlanNoNetNoDataDialog();
        if (mRoutePlanNoNetNoDataDialog == null && this.mActivity.get() != null) {
            mRoutePlanNoNetNoDataDialog = new BNMessageDialog((Activity) this.mActivity.get()).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_no_net_no_data_tip) + "\n缺失以下数据：" + lackCity).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_down_data)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_open_net)).setOnFirstBtnClickListener(new C46062()).setOnSecondBtnClickListener(new C46051());
        }
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && mRoutePlanNoNetNoDataDialog != null) {
            try {
                mRoutePlanNoNetNoDataDialog.show();
            } catch (Exception e) {
                LogUtil.m15791e("wy", e.toString());
            }
        }
    }

    public boolean dismissRoutePlanNoNetNoDataDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || mRoutePlanNoNetNoDataDialog == null || !mRoutePlanNoNetNoDataDialog.isShowing())) {
            try {
                mRoutePlanNoNetNoDataDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mRoutePlanNoNetNoDataDialog = null;
        return true;
    }

    public void showRoutePlanFirstCalcDialog(Context ctx, OnNaviClickListener onCalcListener) {
        dismissRoutePlanFirstCalcDialog();
        if (mRoutePlanFirstCalcDialog == null && this.mActivity.get() != null) {
            mRoutePlanFirstCalcDialog = new BNMessageDialog((Activity) this.mActivity.get()).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_fist_calc_tip)).setSecondBtnEnabled(false).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_alert_iknown)).setOnFirstBtnClickListener(onCalcListener);
        }
        if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && mRoutePlanFirstCalcDialog != null) {
            try {
                mRoutePlanFirstCalcDialog.show();
            } catch (Exception e) {
                LogUtil.m15791e("wy", e.toString());
            }
        }
    }

    public boolean dismissRoutePlanFirstCalcDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || mRoutePlanFirstCalcDialog == null || !mRoutePlanFirstCalcDialog.isShowing())) {
            try {
                mRoutePlanFirstCalcDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mRoutePlanFirstCalcDialog = null;
        return true;
    }

    public void showWaitProgressDialog(Context ctx) {
        dismissWaitProgressDialog();
        try {
            if (mWaitProgress == null && ctx != null) {
                mWaitProgress = new BNCommonProgressDialog((Activity) ctx);
            }
            if (this.mActivity.get() != null && !((Activity) this.mActivity.get()).isFinishing() && mWaitProgress != null) {
                mWaitProgress.setOnCancelListener(new C46073());
                mWaitProgress.setMessage(getRoutePlanTipsMsg());
                mWaitProgress.show();
            }
        } catch (Exception e) {
        }
    }

    public String getRoutePlanTipsMsg() {
        String msg = "";
        switch (BNRoutePlaner.getInstance().getGuideSceneType()) {
            case 1:
                msg = BNStyleManager.getString(C4048R.string.nsdk_string_rg_guide_normal);
                break;
            case 2:
                msg = BNStyleManager.getString(C4048R.string.nsdk_string_rg_guide_end);
                break;
            case 4:
                msg = BNStyleManager.getString(C4048R.string.nsdk_string_rg_navi_recomment_park);
                break;
            default:
                msg = BNStyleManager.getString(C4048R.string.nsdk_string_rg_guide_normal);
                break;
        }
        BNRoutePlaner.getInstance().setGuideSceneType(1);
        return msg;
    }

    public boolean dismissWaitProgressDialog() {
        if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing() || mWaitProgress == null || !mWaitProgress.isShowing())) {
            try {
                mWaitProgress.dismiss();
            } catch (Exception e) {
            }
        }
        mWaitProgress = null;
        return true;
    }

    public void update(BNSubject o, int type, int event, Object arg) {
        switch (type) {
            case 1:
                switch (event) {
                    case 1:
                        if (BNRoutePlaner.getInstance().getEntry() != 16 && BNRoutePlaner.getInstance().getEntry() != 7 && !BNavigator.getInstance().isNaviBegin() && !RGViewController.getInstance().isWaitCalProgressShowing()) {
                            showWaitProgressDialog((Context) this.mActivity.get());
                            return;
                        }
                        return;
                    case 2:
                    case 4:
                        dismissWaitProgressDialog();
                        return;
                    case 3:
                        if (!BNavigator.getInstance().isNaviBegin()) {
                            if (!(this.mActivity.get() == null || ((Activity) this.mActivity.get()).isFinishing())) {
                                TipTool.onCreateToastDialog((Context) this.mActivity.get(), "抱歉，小度没找到");
                            }
                            dismissWaitProgressDialog();
                            return;
                        }
                        return;
                    case 5:
                        onRouterPlanTipShow((FailArg) arg);
                        BNRoutePlaner.getInstance().setGuideSceneType(1);
                        BNRoutePlaner.getInstance().setGuideEndType(0);
                        BNRouteGuider.getInstance().setGuideEndType(0);
                        return;
                    case 6:
                        onRouterPlanTipShow((FailArg) arg);
                        BNRoutePlaner.getInstance().setGuideSceneType(1);
                        BNRoutePlaner.getInstance().setGuideEndType(0);
                        BNRouteGuider.getInstance().setGuideEndType(0);
                        return;
                    case 7:
                        dismissWaitProgressDialog();
                        onRouterPlanFailReasonShow((FailArg) arg);
                        BNRoutePlaner.getInstance().setGuideSceneType(1);
                        BNRoutePlaner.getInstance().setGuideEndType(0);
                        BNRouteGuider.getInstance().setGuideEndType(0);
                        return;
                    case 21:
                        return;
                    default:
                        return;
                }
            case 2:
                if (8 == event) {
                    ConfirmOTArg confirmArg = (ConfirmOTArg) arg;
                    showRoutePlanNetworkingDialog((Context) this.mActivity.get(), "小度需要" + confirmArg.mTipStr + "数据，才可以带您去这里，请选择：", JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_confirm), confirmArg.mConfirmListener, new C46095());
                    return;
                } else if (9 == event) {
                    dismissRoutePlanNetworkingDialog();
                    return;
                } else {
                    return;
                }
            case 3:
                if (8 == event) {
                    showRoutePlanAvoidTrafficJamDialog((Context) this.mActivity.get(), JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_avoid_trafficjam), JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_avoid_trafficjam_iknow), ((ConfirmArg) arg).mConfirmListener, new C46084());
                    return;
                } else if (9 == event) {
                    dismissRoutePlanAvoidTrafficJamDialog();
                    return;
                } else {
                    return;
                }
            case 4:
                if (8 == event) {
                    LackDataArg lackDataArg = (LackDataArg) arg;
                    showMessageDialog((Context) this.mActivity.get(), JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_online_network_error, new Object[]{lackDataArg.mLackDataText}));
                    return;
                } else if (9 == event) {
                    dismissMessageDialog();
                    return;
                } else {
                    return;
                }
            case 5:
                if (!BNRoutePlaner.getInstance().isGuideEnd()) {
                    if (16 == event) {
                        showRoutePlanOvertimeDialog((Context) this.mActivity.get(), ((ConfirmOTArg) arg).mConfirmListener, new C46106());
                        return;
                    } else if (17 == event) {
                        dismissRoutePlanOvertimeDialog();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 6:
                if (18 == event) {
                    showRoutePlanNoNetNoDataDialog((Context) this.mActivity.get(), (String) arg);
                    return;
                } else if (19 == event) {
                    dismissRoutePlanNoNetNoDataDialog();
                    return;
                } else {
                    return;
                }
            case 7:
                if (8 == event) {
                    showRoutePlanFirstCalcDialog((Context) this.mActivity.get(), ((ConfirmOTArg) arg).mConfirmListener);
                    return;
                } else if (9 == event) {
                    dismissRoutePlanNoNetNoDataDialog();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
