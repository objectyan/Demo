package com.baidu.baidunavis.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.cruise.control.CruiseDialogManager.CruiseDialogManagerInterface;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.LinkedList;
import java.util.List;

public class BNCruiseDialogManager {
    private static final String TAG = "Cruise";
    private Activity mActivity;
    private CruiseDialogManagerInterface mCruiseDialogManagerInterface = new C07591();
    private List<Dialog> mDialogList = new LinkedList();
    private C1953c mExitDialog;
    private C1953c mGPSSettingDialog;
    private C1953c mNotLocatedDialog;
    private C1277e mOnDialogListener;
    private C1953c mUnavailableDialog;

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$1 */
    class C07591 implements CruiseDialogManagerInterface {
        C07591() {
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

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$2 */
    class C07602 implements C0672b {
        C07602() {
        }

        public void onClick() {
            if (BNCruiseDialogManager.this.mActivity != null && BNCruiseDialogManager.this.mActivity != null && !BNCruiseDialogManager.this.mActivity.isFinishing()) {
                TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_open_gps));
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$3 */
    class C07613 implements C0672b {
        C07613() {
        }

        public void onClick() {
            try {
                BNCruiseDialogManager.this.mActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception e) {
                LogUtil.e("", e.toString());
                TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_no_gps));
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$4 */
    class C07624 implements C0690d {
        C07624() {
        }

        public void onCancel() {
            BNCruiseDialogManager.this.mGPSSettingDialog = null;
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$6 */
    class C07646 implements C0690d {
        C07646() {
        }

        public void onCancel() {
            BNCruiseDialogManager.this.mExitDialog = null;
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$8 */
    class C07668 implements C0672b {
        C07668() {
        }

        public void onClick() {
            BNCruiseDialogManager.this.openSysNetworkSetting(true);
            BNCruiseDialogManager.this.mOnDialogListener.dismissDialog(BNCruiseDialogManager.this.mUnavailableDialog);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.BNCruiseDialogManager$9 */
    class C07679 implements C0690d {
        C07679() {
        }

        public void onCancel() {
            BNCruiseDialogManager.this.mUnavailableDialog = null;
        }
    }

    public BNCruiseDialogManager(Activity activity, C1277e listener) {
        this.mActivity = activity;
        this.mOnDialogListener = listener;
    }

    public CruiseDialogManagerInterface getCruiseDialogManagerInterface() {
        return this.mCruiseDialogManagerInterface;
    }

    public void showGPSSettingDialogAtCarlife() {
        if (this.mGPSSettingDialog == null && this.mExitDialog == null && this.mUnavailableDialog == null && !this.mOnDialogListener.isDialogShown()) {
            try {
                if (this.mActivity != null) {
                    Resources res = JarUtils.getResources();
                    this.mGPSSettingDialog = new C1953c(this.mActivity).m7448c(res.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).m7444b(res.getString(C4048R.string.nsdk_string_cruise_gps_not_open_and_set)).m7457g(17).m7451d(res.getString(C4048R.string.nsdk_string_cruise_gps_setting)).m7458q().m7438a(new C07613()).m7454e(res.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).m7443b(new C07602());
                    this.mGPSSettingDialog.setOnDialogCancelListener(new C07624());
                }
                this.mOnDialogListener.showDialog(this.mGPSSettingDialog);
            } catch (Exception e) {
                LogUtil.e("Cruise", "dialog show failed because activity is NOT running!");
                this.mGPSSettingDialog = null;
            }
        }
    }

    public void dismissGPSSettingDialogAtCarlife() {
        try {
            this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
            this.mGPSSettingDialog = null;
        } catch (Exception e) {
            this.mGPSSettingDialog = null;
        }
    }

    public void showQuitDialogAtCarlife(final OnNaviClickListener onQuitListener) {
        if (this.mActivity != null) {
            dismissQuitDialogAtCarlife();
            try {
                this.mExitDialog = new C1953c(this.mActivity).m7448c(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_title_tip)).m7444b(JarUtils.getResources().getString(C4048R.string.nsdk_string_cruise_exit_msg)).m7457g(17).m7451d(JarUtils.getResources().getString(C4048R.string.nsdk_string_confirm)).m7458q().m7438a(new C0672b() {
                    public void onClick() {
                        if (onQuitListener != null) {
                            onQuitListener.onClick();
                        }
                    }
                }).m7454e(JarUtils.getResources().getString(C4048R.string.nsdk_string_negative));
                this.mExitDialog.setOnDialogCancelListener(new C07646());
                this.mOnDialogListener.showDialog(this.mExitDialog);
            } catch (Exception e) {
                this.mExitDialog = null;
            }
        }
    }

    public void dismissQuitDialogAtCarlife() {
        this.mOnDialogListener.dismissDialog(this.mExitDialog);
        this.mExitDialog = null;
    }

    public void showCruiseNotLocDialogAtCarlife(OnNaviClickListener onCancelListener) {
    }

    public void showCruiseUnavailableDialogAtCarlife(final OnNaviClickListener onDownloadListener) {
        if (this.mUnavailableDialog == null && this.mExitDialog == null && this.mGPSSettingDialog == null && !this.mOnDialogListener.isDialogShown()) {
            hideCruiseUnavailableDialogAtCarlife();
            try {
                if (this.mActivity != null) {
                    Resources res = JarUtils.getResources();
                    this.mUnavailableDialog = new C1953c(this.mActivity).m7448c(res.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).m7444b(res.getString(C4048R.string.nsdk_string_cruise_unavailable)).m7457g(17).m7451d(res.getString(C4048R.string.nsdk_string_cruise_open_net)).m7438a(new C07668()).m7454e(res.getString(C4048R.string.nsdk_string_common_alert_download)).m7443b(new C0672b() {
                        public void onClick() {
                            if (onDownloadListener != null) {
                                onDownloadListener.onClick();
                            }
                        }
                    });
                    this.mUnavailableDialog.setOnDialogCancelListener(new C07679());
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
            this.mUnavailableDialog = null;
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
            LogUtil.e("Cruise", e.toString());
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
            if (dialog != null && !dialog.isShowing() && !this.mActivity.isFinishing()) {
                try {
                    dialog.show();
                } catch (Exception e) {
                }
            }
        }
    }
}
