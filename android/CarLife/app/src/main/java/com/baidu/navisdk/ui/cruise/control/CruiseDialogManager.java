package com.baidu.navisdk.ui.cruise.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.LinkedList;
import java.util.List;

public class CruiseDialogManager {
    private static final String TAG = "Cruise";
    private Activity mActivity;
    private CruiseDialogManagerInterface mCruiseDialogManagerInterface;
    private List<Dialog> mDialogList = new LinkedList();
    private BNDialog mExitDialog;
    private BNDialog mGPSSettingDialog;
    private AlertDialog mNewerGuideDialog;
    private BNDialog mNotLocatedDialog;
    private BNDialog mUnavailableDialog;

    /* renamed from: com.baidu.navisdk.ui.cruise.control.CruiseDialogManager$1 */
    class C42671 implements OnNaviClickListener {
        C42671() {
        }

        public void onClick() {
            if (CruiseDialogManager.this.mActivity != null && CruiseDialogManager.this.mActivity != null && !CruiseDialogManager.this.mActivity.isFinishing()) {
                TipTool.onCreateToastDialog(CruiseDialogManager.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_open_gps));
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.control.CruiseDialogManager$2 */
    class C42682 implements OnNaviClickListener {
        C42682() {
        }

        public void onClick() {
            try {
                CruiseDialogManager.this.mActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception e) {
                LogUtil.m15791e("", e.toString());
                TipTool.onCreateToastDialog(CruiseDialogManager.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_no_gps));
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.control.CruiseDialogManager$3 */
    class C42693 implements OnNaviClickListener {
        C42693() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.control.CruiseDialogManager$4 */
    class C42704 implements OnNaviClickListener {
        C42704() {
        }

        public void onClick() {
            CruiseDialogManager.this.openSysNetworkSetting(true);
            CruiseDialogManager.this.mUnavailableDialog.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.control.CruiseDialogManager$5 */
    class C42715 implements OnClickListener {
        C42715() {
        }

        public void onClick(View v) {
            if (CruiseDialogManager.this.mNewerGuideDialog != null) {
                CruiseDialogManager.this.mNewerGuideDialog.dismiss();
                CruiseDialogManager.this.mNewerGuideDialog = null;
            }
            CruiseDialogManager.this.popDialogAndShow();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.control.CruiseDialogManager$6 */
    class C42726 implements OnClickListener {
        C42726() {
        }

        public void onClick(View v) {
            if (CruiseDialogManager.this.mNewerGuideDialog != null) {
                CruiseDialogManager.this.mNewerGuideDialog.dismiss();
                CruiseDialogManager.this.mNewerGuideDialog = null;
            }
            CruiseDialogManager.this.popDialogAndShow();
        }
    }

    public interface CruiseDialogManagerInterface {
        void dismissGPSSettingDialog();

        void dismissQuitDialog();

        void hideCruiseUnavailableDialog();

        void popDialogAndShow();

        void putDialogInQueue(Dialog dialog);

        void showCruiseNotLocDialog(OnNaviClickListener onNaviClickListener);

        void showCruiseUnavailableDialog(OnNaviClickListener onNaviClickListener);

        void showGPSSettingDialog();

        void showQuitDialog(OnNaviClickListener onNaviClickListener);
    }

    public CruiseDialogManager(Activity activity) {
        this.mActivity = activity;
    }

    public void setCruiseDialogManagerInterface(CruiseDialogManagerInterface cruiseDialogManagerInterface) {
        this.mCruiseDialogManagerInterface = cruiseDialogManagerInterface;
    }

    public void showGPSSettingDialog() {
        try {
            if (this.mCruiseDialogManagerInterface != null) {
                this.mCruiseDialogManagerInterface.showGPSSettingDialog();
                return;
            }
            if (!(this.mGPSSettingDialog != null || this.mActivity == null || this.mActivity.isFinishing())) {
                Resources res = JarUtils.getResources();
                this.mGPSSettingDialog = new BNDialog(this.mActivity).setTitleText(res.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(res.getString(C4048R.string.nsdk_string_cruise_gps_not_open_and_set)).setFirstBtnText(res.getString(C4048R.string.nsdk_string_cruise_gps_setting)).setFirstBtnTextColorHighLight().setOnFirstBtnClickListener(new C42682()).setSecondBtnText(res.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).setOnSecondBtnClickListener(new C42671());
            }
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mGPSSettingDialog != null && !this.mGPSSettingDialog.isShowing()) {
                this.mGPSSettingDialog.show();
            }
        } catch (Exception e) {
            LogUtil.m15791e("Cruise", "dialog show failed because activity is NOT running!");
        }
    }

    public void dismissGPSSettingDialog() {
        try {
            if (this.mCruiseDialogManagerInterface != null) {
                this.mCruiseDialogManagerInterface.dismissGPSSettingDialog();
            } else if (this.mGPSSettingDialog != null && this.mActivity != null && !this.mActivity.isFinishing()) {
                if (this.mGPSSettingDialog.isShowing()) {
                    this.mGPSSettingDialog.dismiss();
                }
                this.mGPSSettingDialog = null;
            }
        } catch (Exception e) {
        }
    }

    public void showQuitDialog(OnNaviClickListener onQuitListener) {
        if (this.mCruiseDialogManagerInterface != null) {
            this.mCruiseDialogManagerInterface.showQuitDialog(onQuitListener);
        } else if (this.mActivity != null) {
            dismissQuitDialog();
            try {
                this.mExitDialog = new BNDialog(this.mActivity).enableBackKey(true).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_cruise_exit_msg)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_confirm)).setSecondBtnTextColorHighLight().setOnSecondBtnClickListener(onQuitListener).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_negative)).setOnFirstBtnClickListener(new C42693());
                if (!this.mExitDialog.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                    this.mExitDialog.show();
                }
            } catch (Exception e) {
            }
        }
    }

    public void dismissQuitDialog() {
        if (this.mCruiseDialogManagerInterface != null) {
            this.mCruiseDialogManagerInterface.dismissQuitDialog();
        } else if (this.mExitDialog != null && this.mActivity != null && !this.mActivity.isFinishing()) {
            if (this.mExitDialog.isShowing()) {
                this.mExitDialog.dismiss();
            }
            this.mExitDialog = null;
        }
    }

    public void showCruiseNotLocDialog(OnNaviClickListener onCancelListener) {
        if (this.mCruiseDialogManagerInterface != null) {
            this.mCruiseDialogManagerInterface.showCruiseNotLocDialog(onCancelListener);
            return;
        }
        try {
            if (this.mNotLocatedDialog == null) {
                this.mNotLocatedDialog = new BNDialog(this.mActivity).setTitleText((int) C4048R.string.nsdk_string_rg_nav_title_tip).setContentMessage((int) C4048R.string.nsdk_string_cruise_not_loc).setFirstBtnText((int) C4048R.string.nsdk_string_rg_nav_dialog_cancel).setOnFirstBtnClickListener(onCancelListener);
                this.mNotLocatedDialog.setCancelable(false);
            }
            if (this.mNotLocatedDialog != null) {
                this.mNotLocatedDialog.show();
            }
        } catch (Exception e) {
        }
    }

    public void showCruiseUnavailableDialog(OnNaviClickListener onDownloadListener) {
        if (this.mCruiseDialogManagerInterface != null) {
            this.mCruiseDialogManagerInterface.showCruiseUnavailableDialog(onDownloadListener);
            return;
        }
        hideCruiseUnavailableDialog();
        try {
            if (this.mUnavailableDialog == null && this.mActivity != null) {
                this.mUnavailableDialog = new BNDialog(this.mActivity).setTitleText((int) C4048R.string.nsdk_string_rg_nav_title_tip).setContentMessage((int) C4048R.string.nsdk_string_cruise_unavailable).setFirstBtnText((int) C4048R.string.nsdk_string_cruise_open_net).setOnFirstBtnClickListener(new C42704()).setSecondBtnText((int) C4048R.string.nsdk_string_common_alert_download).setOnSecondBtnClickListener(onDownloadListener);
            }
            if (this.mUnavailableDialog != null && !this.mActivity.isFinishing()) {
                this.mUnavailableDialog.show();
            }
        } catch (Exception e) {
            this.mUnavailableDialog = null;
        }
    }

    public void hideCruiseUnavailableDialog() {
        try {
            if (this.mCruiseDialogManagerInterface != null) {
                this.mCruiseDialogManagerInterface.hideCruiseUnavailableDialog();
            } else if (this.mUnavailableDialog != null && this.mUnavailableDialog.isShowing()) {
                this.mUnavailableDialog.dismiss();
            }
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

    private void buildNewerGuideDialogPortrait() {
        if (this.mNewerGuideDialog == null) {
            Builder builder = new Builder(this.mActivity);
            int layoutId = C4048R.layout.nsdk_layout_cruise_newerguide;
            if (ScreenUtil.getInstance().getHeightPixels() < 640) {
                layoutId = C4048R.layout.nsdk_layout_cruise_newerguide_land;
            }
            View view = JarUtils.inflate(this.mActivity, layoutId, null);
            view.findViewById(C4048R.id.cruise_newerguid_btn).setOnClickListener(new C42715());
            this.mNewerGuideDialog = builder.create();
            if (this.mNewerGuideDialog != null) {
                this.mNewerGuideDialog.setView(view, 0, 0, 0, 0);
                this.mNewerGuideDialog.setCancelable(false);
            }
        }
    }

    private void buildNewerGuideDialogLand() {
        if (this.mNewerGuideDialog == null) {
            Builder builder = new Builder(this.mActivity);
            View view = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_cruise_newerguide_land, null);
            view.findViewById(C4048R.id.cruise_newerguid_btn).setOnClickListener(new C42726());
            this.mNewerGuideDialog = builder.create();
            if (this.mNewerGuideDialog != null) {
                this.mNewerGuideDialog.setView(view, 0, 0, 0, 0);
                this.mNewerGuideDialog.setCancelable(false);
            }
        }
    }

    public void showNewerGuideDialog(boolean inQueue) {
        if (this.mNewerGuideDialog != null && this.mNewerGuideDialog.isShowing()) {
            this.mNewerGuideDialog.dismiss();
            this.mNewerGuideDialog = null;
        }
        if (inQueue) {
            putDialogInQueue(this.mNewerGuideDialog);
        } else if (this.mNewerGuideDialog != null && !this.mActivity.isFinishing()) {
            this.mNewerGuideDialog.show();
        }
    }

    public boolean isNewerGuideDialogShowing() {
        if (this.mNewerGuideDialog == null || !this.mNewerGuideDialog.isShowing()) {
            return false;
        }
        return true;
    }

    public void putDialogInQueue(Dialog dialog) {
        if (this.mCruiseDialogManagerInterface != null) {
            this.mCruiseDialogManagerInterface.putDialogInQueue(dialog);
        } else if (this.mDialogList != null && dialog != null) {
            for (Dialog dlg : this.mDialogList) {
                if (dialog == dlg) {
                    return;
                }
            }
            this.mDialogList.add(dialog);
        }
    }

    public void popDialogAndShow() {
        if (this.mCruiseDialogManagerInterface != null) {
            this.mCruiseDialogManagerInterface.popDialogAndShow();
        } else if (this.mDialogList != null && !this.mDialogList.isEmpty()) {
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
