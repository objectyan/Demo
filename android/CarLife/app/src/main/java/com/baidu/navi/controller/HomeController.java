package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager$DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviCurRoutePoiModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class HomeController {
    private DBManager$DBOperateResultCallback callback = new C36984();
    private Context mContext;
    private C1953c mContinueDownloadDataInWifiDialog;
    private C1953c mContinueLastNaviDialog;
    private C1953c mDataInfoDialog;
    private C1328h mFragmentManager;
    private C1953c mGPSSettingDialog;
    private IHomeControllerListener mListener;
    private C1277e mOnDialogListener;
    private Handler mRPHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    if (HomeController.this.mFragmentManager != null) {
                        HomeController.this.mFragmentManager.showFragment(52, null);
                    }
                    BNRoutePlaner.getInstance().removeRouteResultHandler(HomeController.this.mRPHandler);
                    return;
                case 7:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(HomeController.this.mRPHandler);
                    return;
                case 32:
                    BNRoutePlaner.getInstance().removeRouteResultHandler(HomeController.this.mRPHandler);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.baidu.navi.controller.HomeController$1 */
    class C36951 implements C0672b {
        C36951() {
        }

        public void onClick() {
            PreferenceHelper.getInstance(HomeController.this.mContext).putBoolean(Key.NAVI_SHOW_ONLINE_USE, false);
            if (HomeController.this.mOnDialogListener != null) {
                HomeController.this.mOnDialogListener.dismissDialog(HomeController.this.mDataInfoDialog);
            }
            HomeController.this.mFragmentManager.showFragment(NaviFragmentManager.TYPE_OFFLINE_DATA, null);
            if (HomeController.this.mListener != null) {
                HomeController.this.mListener.onShowOfflineDataPage();
            }
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeController$2 */
    class C36962 implements C0672b {
        C36962() {
        }

        public void onClick() {
            PreferenceHelper.getInstance(HomeController.this.mContext).putBoolean(Key.NAVI_SHOW_ONLINE_USE, false);
            if (HomeController.this.mOnDialogListener != null) {
                HomeController.this.mOnDialogListener.dismissDialog(HomeController.this.mDataInfoDialog);
            }
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeController$3 */
    class C36973 implements C0672b {
        C36973() {
        }

        public void onClick() {
            try {
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                HomeController.this.mContext.startActivity(intent);
            } catch (Exception e) {
                TipTool.onCreateToastDialog(HomeController.this.mContext, HomeController.this.mContext.getString(C0965R.string.navi_status_no_gps));
            }
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeController$4 */
    class C36984 implements DBManager$DBOperateResultCallback {
        C36984() {
        }

        public void onQuerySuccess() {
            ArrayList<RoutePlanNode> nodesList = NaviCurRoutePoiModel.getInstance().getLastNaviNodesList();
            if (nodesList != null && nodesList.size() > 0) {
                RoutePlanNode curPostionNode = BNLocationManagerProxy.getInstance().getCurLocationNode();
                if (curPostionNode != null) {
                    if (HomeController.this.calcTwoPointsDistance(curPostionNode.mGeoPoint, ((RoutePlanNode) nodesList.get(nodesList.size() - 1)).mGeoPoint) > 200) {
                        nodesList.add(0, curPostionNode);
                        HomeController.this.showContinueLastNaviDialog(nodesList);
                    }
                }
                DBManager.clearLastnaviPoints();
            }
        }

        public void onAddOrDeleteSuccess() {
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeController$5 */
    class C36995 implements C0672b {
        C36995() {
        }

        public void onClick() {
            BNRoutePlaner.getInstance().addRouteResultHandler(HomeController.this.mRPHandler);
        }
    }

    public interface IHomeControllerListener {
        void onShowOfflineDataPage();
    }

    public HomeController(Context activity, C1277e listener) {
        this.mContext = activity;
        this.mOnDialogListener = listener;
        this.mFragmentManager = C1328h.a();
    }

    public void checkNewVerDataAndUpgrade() {
        new HomeCheckNewController(this.mContext, this.mOnDialogListener).startCheckNewThread();
    }

    public void checkValidOfflineData() {
        checkValidOfflineData(BNOfflineDataManager.getInstance().haveValidData());
    }

    public void checkValidOfflineData(boolean hasValidData) {
        if (PreferenceHelper.getInstance(this.mContext).getBoolean(Key.NAVI_SHOW_ONLINE_USE, true)) {
            String dialogTitle = null;
            if (!hasValidData) {
                dialogTitle = this.mContext.getString(C0965R.string.alert_no_valid_data_info);
            }
            if (BNOfflineDataManager.getInstance().isProvinceDownloadCommonNotDownload()) {
                dialogTitle = this.mContext.getString(C0965R.string.alert_common_data_not_download);
            }
            if (dialogTitle != null) {
                showNoOfflineDataDialog(dialogTitle);
            }
        }
    }

    public void showNoOfflineDataDialog(String title) {
        if (this.mDataInfoDialog == null) {
            this.mDataInfoDialog = new C1953c(this.mContext).b(title).c(C0965R.string.alert_goto_download).q().d(C0965R.string.alert_online_use);
            this.mDataInfoDialog.a(new C36951());
            this.mDataInfoDialog.b(new C36962());
        }
        if (this.mOnDialogListener != null) {
            this.mOnDialogListener.showDialog(this.mDataInfoDialog, C1265a.Center);
        }
    }

    public void showGPSSettingDialog() {
        if (!this.mOnDialogListener.isDialogShown()) {
            if (this.mGPSSettingDialog == null) {
                this.mGPSSettingDialog = new C1953c(this.mContext).b(C0965R.string.dialog_tip).a(C0965R.string.alert_gps_not_open_and_set).c(C0965R.string.alert_gps_setting).q().d(C0965R.string.alert_know);
                this.mGPSSettingDialog.a(new C36973());
            }
            this.mOnDialogListener.showDialog(this.mGPSSettingDialog, C1265a.Center);
        }
    }

    public void dismissGPSSettingDialog() {
        if (this.mOnDialogListener.isDialogShown()) {
            this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
        }
        this.mGPSSettingDialog = null;
    }

    public boolean isOnlineUseDialogShowing() {
        if (this.mDataInfoDialog == null || !this.mOnDialogListener.isDialogShown()) {
            return false;
        }
        return true;
    }

    public boolean isContinueLastNaviDialogShowing() {
        if (this.mContinueLastNaviDialog == null || !this.mOnDialogListener.isDialogShown()) {
            return false;
        }
        return true;
    }

    public int calcTwoPointsDistance(GeoPoint start, GeoPoint end) {
        if (start == null || !start.isValid() || end == null || !end.isValid()) {
            return 0;
        }
        double dx = (double) (start.getLongitudeE6() - end.getLongitudeE6());
        double dy = (double) (start.getLatitudeE6() - end.getLatitudeE6());
        return (int) Math.sqrt((dx * dx) + (dy * dy));
    }

    public void showContinueLastNaviDialog(ArrayList<RoutePlanNode> arrayList) {
        if (this.mContinueLastNaviDialog == null) {
            this.mContinueLastNaviDialog = new C1953c(this.mContext).b(C0965R.string.alert_notification).a(C0965R.string.alert_continue_last_navi_tips).c(C0965R.string.continue_last_navi_ok).q().d(C0965R.string.continue_last_navi_cancel);
            this.mContinueLastNaviDialog.a(new C36995());
        }
        if (!this.mOnDialogListener.isDialogShown()) {
            this.mOnDialogListener.showDialog(this.mContinueLastNaviDialog, C1265a.Center);
        }
    }
}
