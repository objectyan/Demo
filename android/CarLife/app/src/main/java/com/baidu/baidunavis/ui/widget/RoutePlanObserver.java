package com.baidu.baidunavis.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.routedetails.proxy.RGRouteDetailsViewController;
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
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RoutePlanObserver implements BNRoutePlanObserver {
    private static BNNetworkingDialog mRoutePlanAvoidTrafficJamDialog = null;
    private static C1953c mRoutePlanFirstCalcDialog = null;
    private static C1953c mRoutePlanNetworkingDialog = null;
    private static C1953c mRoutePlanNoNetNoDataDialog = null;
    private static C1953c mRoutePlanOvertimeDialog = null;
    private IJumpToDownloadListener mIIJumpToDownloadListener;
    private C1953c mNaviMessageDialog;
    private C1277e mOnDialogListener;

    public interface IJumpToDownloadListener {
        void onJumpToDownloadOfflineData();
    }

    /* renamed from: com.baidu.baidunavis.ui.widget.RoutePlanObserver$6 */
    class C09086 implements C0672b {
        C09086() {
        }

        public void onClick() {
            RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
            if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
                RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.widget.RoutePlanObserver$8 */
    class C09108 implements C0672b {
        C09108() {
        }

        public void onClick() {
            RoutePlanObserver.this.cancleCalcRoute();
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.widget.RoutePlanObserver$9 */
    class C09119 implements C0690d {
        C09119() {
        }

        public void onCancel() {
            RoutePlanObserver.this.cancleCalcRoute();
        }
    }

    public RoutePlanObserver(IJumpToDownloadListener l) {
        this(l, C1309g.m4699a().m4701b());
    }

    public RoutePlanObserver(IJumpToDownloadListener l, C1277e listener) {
        this.mNaviMessageDialog = null;
        this.mIIJumpToDownloadListener = null;
        this.mIIJumpToDownloadListener = l;
        this.mOnDialogListener = listener;
    }

    public void onRouterPlanTipShow(FailArg failArg) {
        TipTool.onCreateToastDialog(C1157a.m3876a(), failArg.mFailText + getDebugToastMessage(failArg));
    }

    public void onRouterPlanFailReasonShow(FailArg failArg) {
        switch (failArg.mFailType) {
            case 420:
                TipTool.onCreateToastDialog(C1157a.m3876a(), C1157a.m3876a().getString(C0965R.string.nodata_check) + getDebugToastMessage(failArg));
                return;
            case 421:
                TipTool.onCreateToastDialog(C1157a.m3876a(), C1157a.m3876a().getString(C0965R.string.net_error_nodata) + getDebugToastMessage(failArg));
                return;
            default:
                TipTool.onCreateToastDialog(C1157a.m3876a(), failArg.mFailText + getDebugToastMessage(failArg));
                return;
        }
    }

    private String getDebugToastMessage(FailArg failArg) {
        return LogUtil.LOGGABLE ? "(" + failArg.mFailType + ")" : "";
    }

    public void showMessageDialog(Context ctx, String messageStr) {
        dismissMessageDialog();
        if (this.mNaviMessageDialog == null && ctx != null) {
            this.mNaviMessageDialog = new C1953c(ctx).m7444b(messageStr).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).m7440a(true).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_alert_iknown));
        }
        this.mOnDialogListener.showDialog(this.mNaviMessageDialog);
    }

    public boolean dismissMessageDialog() {
        this.mOnDialogListener.dismissDialog(this.mNaviMessageDialog);
        return true;
    }

    public void showRoutePlanNetworkingDialog(Context ctx, String contentString, String confirmString, final OnNaviClickListener onlineListener, final OnNaviClickListener downloadListener) {
        dismissRoutePlanNetworkingDialog();
        if (mRoutePlanNetworkingDialog == null) {
            mRoutePlanNetworkingDialog = new C1953c(ctx).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).m7444b(contentString).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_down_data)).m7454e(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_use_online)).m7438a(new C0672b() {
                public void onClick() {
                    if (downloadListener != null) {
                        downloadListener.onClick();
                    }
                }
            }).m7443b(new C0672b() {
                public void onClick() {
                    if (onlineListener != null) {
                        onlineListener.onClick();
                    }
                }
            });
        }
        this.mOnDialogListener.showDialog(mRoutePlanNetworkingDialog);
    }

    public boolean dismissRoutePlanNetworkingDialog() {
        this.mOnDialogListener.showDialog(mRoutePlanNetworkingDialog);
        return true;
    }

    public void showRoutePlanAvoidTrafficJamDialog(Context ctx, String contentString, String confirmString, OnClickListener confirmListener, OnClickListener cancleListener) {
        dismissRoutePlanAvoidTrafficJamDialog();
        if (mRoutePlanAvoidTrafficJamDialog == null) {
            mRoutePlanAvoidTrafficJamDialog = new BNNetworkingDialog((Activity) ctx).setNetworkingContentMessage(contentString).setConfirmNetworkMessage(confirmString).setConfirmNetworkingListener(confirmListener).setCancleListener(cancleListener).setTwoButtonMode(true);
        }
        if (mRoutePlanAvoidTrafficJamDialog != null) {
            try {
                mRoutePlanAvoidTrafficJamDialog.show();
            } catch (Exception e) {
            }
        }
    }

    public boolean dismissRoutePlanAvoidTrafficJamDialog() {
        if (mRoutePlanAvoidTrafficJamDialog != null && mRoutePlanAvoidTrafficJamDialog.isShowing()) {
            try {
                mRoutePlanAvoidTrafficJamDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mRoutePlanAvoidTrafficJamDialog = null;
        return true;
    }

    public void showRoutePlanOvertimeDialog(Context ctx, final OnNaviClickListener confirmListener, final OnNaviClickListener cancleListener) {
        dismissRoutePlanOvertimeDialog();
        if (mRoutePlanOvertimeDialog == null) {
            mRoutePlanOvertimeDialog = new C1953c(ctx).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).m7444b(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_recalc_tip)).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_negative)).m7454e(JarUtils.getResources().getString(C4048R.string.nsdk_string_recalc)).m7438a(new C0672b() {
                public void onClick() {
                    if (cancleListener != null) {
                        cancleListener.onClick();
                    }
                }
            }).m7443b(new C0672b() {
                public void onClick() {
                    if (confirmListener != null) {
                        confirmListener.onClick();
                    }
                }
            });
        }
        this.mOnDialogListener.showDialog(mRoutePlanOvertimeDialog);
    }

    public boolean dismissRoutePlanOvertimeDialog() {
        this.mOnDialogListener.dismissDialog(mRoutePlanOvertimeDialog);
        return true;
    }

    public void showRoutePlanNoNetNoDataDialog(final Context ctx, String lackCity) {
        dismissRoutePlanNoNetNoDataDialog();
        if (mRoutePlanNoNetNoDataDialog == null) {
            mRoutePlanNoNetNoDataDialog = new C1953c(ctx).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).m7444b(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_no_net_no_data_tip) + "\n缺失以下数据：" + lackCity).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_down_data)).m7454e(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_open_net)).m7438a(new C09086()).m7443b(new C0672b() {
                public void onClick() {
                    RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
                    Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                    intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    ctx.startActivity(intent);
                }
            });
        }
        this.mOnDialogListener.showDialog(mRoutePlanNoNetNoDataDialog);
    }

    public boolean dismissRoutePlanNoNetNoDataDialog() {
        this.mOnDialogListener.dismissDialog(mRoutePlanNoNetNoDataDialog);
        return true;
    }

    public void showRoutePlanFirstCalcDialog(Context ctx, final OnNaviClickListener onCalcListener) {
        dismissRoutePlanFirstCalcDialog();
        if (mRoutePlanFirstCalcDialog == null) {
            mRoutePlanFirstCalcDialog = new C1953c(C1157a.m3876a()).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification)).m7444b(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_fist_calc_tip)).m7445b(false).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_alert_iknown)).m7438a(new C0672b() {
                public void onClick() {
                    if (onCalcListener != null) {
                        onCalcListener.onClick();
                    }
                }
            });
        }
        this.mOnDialogListener.showDialog(mRoutePlanFirstCalcDialog);
    }

    public boolean dismissRoutePlanFirstCalcDialog() {
        this.mOnDialogListener.showDialog(mRoutePlanFirstCalcDialog);
        return true;
    }

    public void showWaitProgressDialog(Context ctx) {
        dismissWaitProgressDialog();
        try {
            NavMapAdapter.getInstance().showProgressDialog(getRoutePlanTipsMsg(), new C09108(), new C09119());
        } catch (Exception e) {
        }
    }

    private void cancleCalcRoute() {
        LogUtil.e("RoutePlan", "WaitProgress onCancel!");
        if (BNavigator.getInstance().isNaviBegin()) {
            RGViewController.getInstance().showReCalRouteQuitDialog();
            return;
        }
        BNRoutePlaner.getInstance().cancleCalcRouteRequest();
        BNRoutePlaner.getInstance().clearRouteInfoHandler();
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
        NavMapAdapter.getInstance().dismissWaitProgressDialog();
        return true;
    }

    public void update(BNSubject o, int type, int event, Object arg) {
        switch (type) {
            case 1:
                switch (event) {
                    case 1:
                        if (RGRouteDetailsViewController.getInstance().isRouteDetail() || BNavigator.getInstance().isNaviBegin()) {
                            showWaitProgressDialog(C1157a.m3876a());
                            return;
                        }
                        return;
                    case 2:
                    case 4:
                        if (RGRouteDetailsViewController.getInstance().isRouteDetail() || BNavigator.getInstance().isNaviBegin()) {
                            dismissWaitProgressDialog();
                            return;
                        }
                        return;
                    case 3:
                        TipTool.onCreateToastDialog(C1157a.m3876a(), C0965R.string.route_tips);
                        dismissWaitProgressDialog();
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
                    showRoutePlanNetworkingDialog(C1157a.m3876a(), "小度需要" + confirmArg.mTipStr + "数据，才可以带您去这里，请选择：", JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_confirm), confirmArg.mConfirmListener, new OnNaviClickListener() {
                        public void onClick() {
                            RoutePlanObserver.this.dismissRoutePlanNetworkingDialog();
                            if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
                                RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
                            }
                        }
                    });
                    return;
                } else if (9 == event) {
                    dismissRoutePlanNetworkingDialog();
                    return;
                } else {
                    return;
                }
            case 3:
                if (8 == event) {
                    showRoutePlanAvoidTrafficJamDialog(C1157a.m3876a(), JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_avoid_trafficjam), JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_avoid_trafficjam_iknow), ((ConfirmArg) arg).mConfirmListener, new OnClickListener() {
                        public void onClick(View v) {
                            RoutePlanObserver.this.dismissRoutePlanAvoidTrafficJamDialog();
                        }
                    });
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
                    showMessageDialog(C1157a.m3876a(), JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_online_network_error, new Object[]{lackDataArg.mLackDataText}));
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
                        showRoutePlanOvertimeDialog(C1157a.m3876a(), ((ConfirmOTArg) arg).mConfirmListener, new OnNaviClickListener() {
                            public void onClick() {
                                RoutePlanObserver.this.dismissRoutePlanOvertimeDialog();
                            }
                        });
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
                    showRoutePlanNoNetNoDataDialog(C1157a.m3876a(), (String) arg);
                    return;
                } else if (19 == event) {
                    dismissRoutePlanNoNetNoDataDialog();
                    return;
                } else {
                    return;
                }
            case 7:
                if (8 == event) {
                    showRoutePlanFirstCalcDialog(C1157a.m3876a(), ((ConfirmOTArg) arg).mConfirmListener);
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
