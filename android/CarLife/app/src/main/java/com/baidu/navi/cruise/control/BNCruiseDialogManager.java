package com.baidu.navi.cruise.control;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.cruise.control.CruiseDialogManager.CruiseDialogManagerInterface;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.LinkedList;
import java.util.List;

public class BNCruiseDialogManager {
    private static final String TAG = "Cruise";
    private Context mActivity;
    private CruiseDialogManagerInterface mCruiseDialogManagerInterface = new C37351();
    private List<Dialog> mDialogList = new LinkedList();
    private C1953c mExitDialog;
    private C1953c mGPSSettingDialog;
    private C1953c mNotLocatedDialog;
    private C1277e mOnDialogListener;
    private C1953c mUnavailableDialog;

    /* renamed from: com.baidu.navi.cruise.control.BNCruiseDialogManager$1 */
    class C37351 implements CruiseDialogManagerInterface {
        C37351() {
        }

        public void showGPSSettingDialog() {
            BNCruiseDialogManager.this.showGPSSettingDialogAtCarlife();
        }

        public void dismissGPSSettingDialog() {
            BNCruiseDialogManager.this.dismissGPSSettingDialogAtCarlife();
        }

        public void showQuitDialog(OnNaviClickListener onNaviClickListener) {
            BNCruiseDialogManager.this.showQuitDialogAtCarlife(onNaviClickListener);
        }

        public void dismissQuitDialog() {
            BNCruiseDialogManager.this.dismissQuitDialogAtCarlife();
        }

        public void showCruiseNotLocDialog(OnNaviClickListener onNaviClickListener) {
            BNCruiseDialogManager.this.showCruiseNotLocDialogAtCarlife(onNaviClickListener);
        }

        public void showCruiseUnavailableDialog(OnNaviClickListener onNaviClickListener) {
            BNCruiseDialogManager.this.showCruiseUnavailableDialogAtCarlife(onNaviClickListener);
        }

        public void hideCruiseUnavailableDialog() {
            BNCruiseDialogManager.this.hideCruiseUnavailableDialogAtCarlife();
        }

        public void popDialogAndShow() {
            BNCruiseDialogManager.this.popDialogAndShowAtCarlife();
        }

        public void putDialogInQueue(Dialog dialog) {
            BNCruiseDialogManager.this.putDialogInQueueAtCarlife(dialog);
        }
    }

    /* renamed from: com.baidu.navi.cruise.control.BNCruiseDialogManager$2 */
    class C37362 implements C0672b {
        C37362() {
        }

        public void onClick() {
            TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, BNCruiseDialogManager.this.mActivity.getResources().getString(C0965R.string.nsdk_string_rg_open_gps));
        }
    }

    /* renamed from: com.baidu.navi.cruise.control.BNCruiseDialogManager$3 */
    class C37373 implements C0672b {
        C37373() {
        }

        public void onClick() {
            try {
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                BNCruiseDialogManager.this.mActivity.startActivity(intent);
            } catch (Exception e) {
                LogUtil.m15791e("", e.toString());
                TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, BNCruiseDialogManager.this.mActivity.getResources().getString(C0965R.string.nsdk_string_rg_no_gps));
            }
        }
    }

    /* renamed from: com.baidu.navi.cruise.control.BNCruiseDialogManager$7 */
    class C37417 implements C0672b {
        C37417() {
        }

        public void onClick() {
            BNCruiseDialogManager.this.openSysNetworkSetting(true);
            BNCruiseDialogManager.this.mOnDialogListener.dismissDialog(BNCruiseDialogManager.this.mUnavailableDialog);
        }
    }

    public BNCruiseDialogManager(Context activity, C1277e listener) {
        this.mActivity = activity;
        this.mOnDialogListener = listener;
    }

    public CruiseDialogManagerInterface getCruiseDialogManagerInterface() {
        return this.mCruiseDialogManagerInterface;
    }

    public void showGPSSettingDialogAtCarlife() {
        if (this.mUnavailableDialog != null && this.mOnDialogListener.isDialogShown()) {
            return;
        }
        if (this.mExitDialog == null || !this.mOnDialogListener.isDialogShown()) {
            try {
                if (this.mGPSSettingDialog == null) {
                    Resources res = this.mActivity.getResources();
                    this.mGPSSettingDialog = new C1953c(this.mActivity).c(res.getString(C0965R.string.nsdk_string_rg_nav_title_tip)).b(res.getString(C0965R.string.nsdk_string_cruise_gps_not_open_and_set)).g(17).d(res.getString(C0965R.string.nsdk_string_cruise_gps_setting)).q().a(new C37373()).e(res.getString(C0965R.string.nsdk_string_rg_nav_dialog_cancel)).b(new C37362());
                }
                this.mOnDialogListener.showDialog(this.mGPSSettingDialog);
            } catch (Exception e) {
                LogUtil.m15791e("Cruise", "dialog show failed because activity is NOT running!");
            }
        }
    }

    public void dismissGPSSettingDialogAtCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
        } catch (Exception e) {
        }
    }

    public void showQuitDialogAtCarlife(final OnNaviClickListener onQuitListener) {
        if (this.mActivity != null) {
            dismissQuitDialogAtCarlife();
            try {
                this.mExitDialog = new C1953c(this.mActivity).c(this.mActivity.getResources().getString(C0965R.string.nsdk_string_rg_nav_title_tip)).b(this.mActivity.getResources().getString(C0965R.string.nsdk_string_cruise_exit_msg)).g(17).d(this.mActivity.getResources().getString(C0965R.string.nsdk_string_confirm)).q().a(new C0672b() {
                    public void onClick() {
                        if (onQuitListener != null) {
                            onQuitListener.onClick();
                        }
                    }
                }).e(this.mActivity.getResources().getString(C0965R.string.nsdk_string_negative));
                this.mOnDialogListener.showDialog(this.mExitDialog);
            } catch (Exception e) {
            }
        }
    }

    public void dismissQuitDialogAtCarlife() {
        this.mOnDialogListener.dismissDialog(this.mExitDialog);
    }

    public void showCruiseNotLocDialogAtCarlife(final OnNaviClickListener onCancelListener) {
        try {
            if (this.mNotLocatedDialog == null) {
                Resources res = this.mActivity.getResources();
                this.mNotLocatedDialog = new C1953c(this.mActivity).c(res.getString(C0965R.string.nsdk_string_rg_nav_title_tip)).b(res.getString(C0965R.string.nsdk_string_cruise_not_loc)).g(17).d(res.getString(C0965R.string.nsdk_string_rg_nav_dialog_cancel)).a(new C0672b() {
                    public void onClick() {
                        if (onCancelListener != null) {
                            onCancelListener.onClick();
                        }
                    }
                });
            }
            this.mOnDialogListener.showDialog(this.mNotLocatedDialog);
        } catch (Exception e) {
        }
    }

    public void showCruiseUnavailableDialogAtCarlife(final OnNaviClickListener onDownloadListener) {
        hideCruiseUnavailableDialogAtCarlife();
        if (this.mGPSSettingDialog != null && this.mOnDialogListener.isDialogShown()) {
            return;
        }
        if (this.mExitDialog == null || !this.mOnDialogListener.isDialogShown()) {
            try {
                if (this.mUnavailableDialog == null && this.mActivity != null) {
                    Resources res = this.mActivity.getResources();
                    this.mUnavailableDialog = new C1953c(this.mActivity).c(res.getString(C0965R.string.nsdk_string_rg_nav_title_tip)).b(res.getString(C0965R.string.nsdk_string_cruise_unavailable)).g(17).d(res.getString(C0965R.string.nsdk_string_cruise_open_net)).a(new C37417()).e(res.getString(C0965R.string.nsdk_string_common_alert_download)).b(new C0672b() {
                        public void onClick() {
                            if (onDownloadListener != null) {
                                onDownloadListener.onClick();
                            }
                        }
                    });
                }
                this.mOnDialogListener.showDialog(this.mUnavailableDialog);
            } catch (Exception e) {
                this.mUnavailableDialog = null;
            }
        }
    }

    public void hideCruiseUnavailableDialogAtCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mUnavailableDialog);
        } catch (Exception e) {
            this.mUnavailableDialog = null;
        }
    }

    private void openSysNetworkSetting(boolean isWifi) {
        Intent intent;
        if (isWifi) {
            intent = new Intent("android.settings.WIFI_SETTINGS");
        } else {
            intent = new Intent("android.settings.WIRELESS_SETTINGS");
        }
        try {
            if (this.mActivity != null) {
                this.mActivity.startActivity(intent);
            }
        } catch (Exception e) {
            LogUtil.m15791e("Cruise", e.toString());
        }
    }

    public void putDialogInQueueAtCarlife(Dialog dialog) {
        if (this.mDialogList != null && dialog != null) {
            for (Dialog dlg : this.mDialogList) {
                if (dialog == dlg) {
                    return;
                }
            }
            this.mDialogList.add(dialog);
        }
    }

    public void popDialogAndShowAtCarlife() {
        if (this.mDialogList != null && !this.mDialogList.isEmpty()) {
            Dialog dialog = (Dialog) this.mDialogList.remove(0);
            if (dialog != null && !dialog.isShowing()) {
                try {
                    dialog.show();
                } catch (Exception e) {
                }
            }
        }
    }
}
