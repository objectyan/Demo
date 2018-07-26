package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.view.dialog.C2286m;
import com.baidu.carlife.view.dialog.C2286m.C2302a;
import com.baidu.carlife.view.dialog.C2304o;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.utils.Tools;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.model.datastruct.ApkInfo;
import com.baidu.navisdk.model.datastruct.CheckNewInfo;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeCheckNewController {
    public static final int MSG_CHECK_DATA_INCONSIST = -6;
    public static final int MSG_CHECK_NAVI_DATA = -4;
    public static final int MSG_CHECK_NEW_APK_VER = -5;
    public static final int MSG_CHECK_NEW_DATA_VER = -7;
    private ApkInfo mApkInfoModel;
    private String mApkSizeString;
    private boolean mAutoUpdate;
    private CheckNewAppThread mCheckNewAppThread = null;
    private boolean mCheckNewData;
    private Handler mCheckNewHandler = null;
    private CheckNewListener mCheckNewListener = null;
    private Context mContext = null;
    private boolean mDoUpdating = false;
    private C2286m mDownloadDialog;
    private TextView mDownloadText;
    private boolean mIsNewApkVer = false;
    private boolean mIsNewData = false;
    private ArrayList<OfflineDataInfo> mNeedUpdateList = new ArrayList();
    private BNOfflineDataObserver mOfflineDataObserver = new C36902();
    private C1277e mOnDialogListener;
    private TextView mPersentText;
    private ProgressBar mProgressBar;
    protected HashMap<String, String> mResponseMap = new HashMap();
    private int mUpdateCount;
    private int[] mUpdateDistrictID = new int[36];

    /* renamed from: com.baidu.navi.controller.HomeCheckNewController$2 */
    class C36902 implements BNOfflineDataObserver {
        C36902() {
        }

        public void update(BNSubject o, int Type, int event, Object arg) {
            switch (Type) {
                case 2:
                    DownloadArg downloadArg = (DownloadArg) arg;
                    int nProgress = downloadArg == null ? 0 : downloadArg.mProgress;
                    switch (event) {
                        case BNOfflineDataObserver.EVENT_UPDATE_FINISH /*267*/:
                            DownloadArg updateArg = (DownloadArg) arg;
                            String name = updateArg.mName;
                            int upPoiCount = updateArg.mUpdatePoiCount;
                            int upRpCount = updateArg.mUpdateRouteCount;
                            String updateFinishString = "";
                            if (upPoiCount > 0 && upRpCount > 0) {
                                updateFinishString = HomeCheckNewController.this.mContext.getString(C0965R.string.update_complete_alert, new Object[]{name, Integer.valueOf(upRpCount), Integer.valueOf(upPoiCount)});
                            } else if (upPoiCount <= 0 && upRpCount > 0) {
                                updateFinishString = HomeCheckNewController.this.mContext.getString(C0965R.string.update_complete_alert_only_rp, new Object[]{name, Integer.valueOf(upRpCount)});
                            } else if (upPoiCount <= 0 || upRpCount > 0) {
                                updateFinishString = HomeCheckNewController.this.mContext.getString(C0965R.string.update_complete_alert0, new Object[]{name});
                            } else {
                                updateFinishString = HomeCheckNewController.this.mContext.getString(C0965R.string.update_complete_alert_only_poi, new Object[]{name, Integer.valueOf(upPoiCount)});
                            }
                            DownNotifManager.getInstance(HomeCheckNewController.this.mContext).clearAllNotifs();
                            DownNotifManager.getInstance(HomeCheckNewController.this.mContext).showUpdateFinshedNotif(HomeCheckNewController.this.mContext, updateFinishString);
                            LogUtil.m15791e("Update", "update finished name:" + name + "!!!!!!!!!!!");
                            if (HomeCheckNewController.this.mNeedUpdateList != null) {
                                for (int index = 0; index < HomeCheckNewController.this.mNeedUpdateList.size(); index++) {
                                    if (((OfflineDataInfo) HomeCheckNewController.this.mNeedUpdateList.get(index)).mName.endsWith(name)) {
                                        HomeCheckNewController.this.mNeedUpdateList.remove(index);
                                    }
                                }
                                if (HomeCheckNewController.this.mNeedUpdateList.size() == 0) {
                                    LogUtil.m15791e("Update", "update finished in check new home!!!!!!!!!!!");
                                    HomeCheckNewController.this.mDoUpdating = false;
                                    HomeCheckNewController.this.mIsNewData = false;
                                    UIModel.getInstance().setIsAutoUpdateDataStatus(false);
                                    UIModel.getInstance().setNewData(false);
                                    if (HomeCheckNewController.this.mCheckNewListener != null) {
                                        LogUtil.m15791e("Update", "update finished listner called!!!!!!!!!!!");
                                        HomeCheckNewController.this.mCheckNewListener.finishUpdateNewData();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 272:
                        case 273:
                            if (HomeCheckNewController.this.mProgressBar != null) {
                                HomeCheckNewController.this.mProgressBar.setProgress(nProgress);
                            }
                            if (HomeCheckNewController.this.mPersentText != null) {
                                HomeCheckNewController.this.mPersentText.setText("" + nProgress + "%");
                            }
                            if (HomeCheckNewController.this.mDownloadText != null && HomeCheckNewController.this.mApkInfoModel != null) {
                                if (nProgress > 100) {
                                    nProgress = 100;
                                }
                                HomeCheckNewController.this.mDownloadText.setText(StringUtils.ByteSizeToString((HomeCheckNewController.this.mApkInfoModel.mApkSize * nProgress) / 100) + "/" + HomeCheckNewController.this.mApkSizeString);
                                return;
                            }
                            return;
                        case 274:
                            try {
                                if (HomeCheckNewController.this.mOnDialogListener != null) {
                                    HomeCheckNewController.this.mOnDialogListener.dismissDialog();
                                }
                            } catch (Exception e) {
                            }
                            HomeCheckNewController.this.installApk();
                            return;
                        default:
                            return;
                    }
                case 3:
                    switch (event) {
                        case 275:
                        case 276:
                            if (HomeCheckNewController.this.mPersentText != null) {
                                HomeCheckNewController.this.mPersentText.setText("");
                            }
                            if (HomeCheckNewController.this.mDownloadText != null) {
                                HomeCheckNewController.this.mDownloadText.setText(HomeCheckNewController.this.mContext.getString(C0965R.string.download_apk_error));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeCheckNewController$3 */
    class C36913 implements OnCheckedChangeListener {
        C36913() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).putBoolean("NAVI_UPDATE_APK_NOT_ALERT", true);
                PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).putString("NAVI_UPDATE_APK_VERSION", HomeCheckNewController.this.mApkInfoModel.mApkVer);
                return;
            }
            PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).putBoolean("NAVI_UPDATE_APK_NOT_ALERT", false);
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeCheckNewController$4 */
    class C36924 implements C2302a {
        C36924() {
        }

        public void onClick() {
            if (!NetworkUtils.isNetworkAvailable(HomeCheckNewController.this.mContext)) {
                TipTool.onCreateToastDialog(HomeCheckNewController.this.mContext, (int) C0965R.string.alert_update_apk_no_network);
            } else if (PackageUtil.isChannelGooglePlay()) {
                Tools.goMarket();
            } else {
                HomeCheckNewController.this.showDownloadAppDialog();
            }
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeCheckNewController$5 */
    class C36935 implements C2302a {
        C36935() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.controller.HomeCheckNewController$6 */
    class C36946 implements C2302a {
        C36946() {
        }

        public void onClick() {
            BNOfflineDataManager.getInstance().pauseAppDataDownLoad();
            BNOfflineDataManager.getInstance().removeAppData();
        }
    }

    class CheckNewAppThread extends Thread {
        Handler mThreadHandler;

        CheckNewAppThread(Handler handler) {
            this.mThreadHandler = handler;
        }

        public void run() {
            boolean access$400;
            HomeCheckNewController.this.mCheckNewData = PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).getBoolean(Key.NAVI_AUTO_CHECK_NEW_DATA, true);
            HomeCheckNewController.this.mAutoUpdate = PreferenceHelper.getInstance(HomeCheckNewController.this.mContext).getBoolean(Key.NAVI_AUTO_UPDATE_NEW_DATA, false);
            HomeCheckNewController.this.mIsNewApkVer = false;
            HomeCheckNewController.this.mIsNewData = false;
            HomeCheckNewController.this.mApkInfoModel = new ApkInfo();
            CheckNewInfo checkModel = new CheckNewInfo();
            if (NetworkUtils.isNetworkAvailable(HomeCheckNewController.this.mContext)) {
                try {
                    ArrayList<OfflineDataInfo> mNeedUpdateList;
                    BNOfflineDataManager.getInstance().checkNewVer(checkModel, HomeCheckNewController.this.mApkInfoModel, HomeCheckNewController.this.mUpdateDistrictID, HomeCheckNewController.this.mCheckNewData);
                    HomeCheckNewController.this.mIsNewApkVer = checkModel.mNewApp;
                    HomeCheckNewController.this.mIsNewData = checkModel.mNewData;
                    HomeCheckNewController.this.mUpdateCount = checkModel.mCount;
                    if (HomeCheckNewController.this.mIsNewApkVer || HomeCheckNewController.this.mIsNewData) {
                        BNOfflineDataManager.getInstance().addObserver(HomeCheckNewController.this.mOfflineDataObserver);
                    }
                    if (HomeCheckNewController.this.mIsNewApkVer) {
                        Message.obtain(this.mThreadHandler, -5, 0, 0, null).sendToTarget();
                    }
                    mNeedUpdateList = new ArrayList();
                    BNOfflineDataManager.getInstance().getNeedUpdateInfo(mNeedUpdateList);
                    if (mNeedUpdateList.size() > 0) {
                        HomeCheckNewController.this.mIsNewData = true;
                    }
                } catch (Exception e) {
                    return;
                }
            }
            mNeedUpdateList = new ArrayList();
            BNOfflineDataManager.getInstance().getItemTable(3, mNeedUpdateList);
            if (mNeedUpdateList.size() > 0) {
                HomeCheckNewController.this.mIsNewData = true;
            }
            if (HomeCheckNewController.this.mIsNewApkVer || HomeCheckNewController.this.mIsNewData) {
                BNOfflineDataManager.getInstance().addObserver(HomeCheckNewController.this.mOfflineDataObserver);
            }
            HomeCheckNewController homeCheckNewController = HomeCheckNewController.this;
            if (HomeCheckNewController.this.mCheckNewData) {
                access$400 = HomeCheckNewController.this.mIsNewData;
            } else {
                access$400 = false;
            }
            homeCheckNewController.mIsNewData = access$400;
            if (HomeCheckNewController.this.mIsNewData) {
                UIModel.getInstance().setNewData(true);
                if (HomeCheckNewController.this.mCheckNewListener != null) {
                    HomeCheckNewController.this.mCheckNewListener.newData();
                }
                Message.obtain(this.mThreadHandler, -7, 0, 0, null).sendToTarget();
            }
        }
    }

    public interface CheckNewListener {
        void beginUpdateNewData();

        void finishUpdateNewData();

        void newData();
    }

    public HomeCheckNewController(Context context, C1277e listener) {
        this.mContext = context;
        this.mOnDialogListener = listener;
    }

    public void setCheckNewListener(CheckNewListener listener) {
        this.mCheckNewListener = listener;
    }

    public void startCheckNewThread() {
        if (this.mCheckNewAppThread == null) {
            this.mCheckNewHandler = getMainUiHandler();
            this.mCheckNewAppThread = new CheckNewAppThread(this.mCheckNewHandler);
        }
        if (this.mCheckNewAppThread != null && !this.mCheckNewAppThread.isAlive()) {
            this.mCheckNewAppThread.start();
        }
    }

    private Handler getMainUiHandler() {
        return new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case -7:
                        HomeCheckNewController.this.mAutoUpdate = false;
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void showApkUpdateInfoDialog() {
        boolean notShowUpdate = PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_UPDATE_APK_NOT_ALERT", false);
        String lastApkVerion = PreferenceHelper.getInstance(this.mContext).getString("NAVI_UPDATE_APK_VERSION", "0.0.0");
        if (this.mApkInfoModel == null) {
            return;
        }
        if (!notShowUpdate || !this.mApkInfoModel.mApkVer.equals(lastApkVerion)) {
            View layout;
            this.mApkSizeString = StringUtils.ByteSizeToString(this.mApkInfoModel.mApkSize);
            String appInformation = this.mContext.getString(C0965R.string.software_size) + this.mApkSizeString + ".\r\n" + this.mContext.getString(C0965R.string.software_version) + this.mApkInfoModel.mApkVer + ".\r\n" + this.mApkInfoModel.mInfo;
            if (NaviFragmentManager.isUsingMapMode()) {
                layout = View.inflate(this.mContext, C0965R.layout.nav_disclaimer, null);
            } else {
                layout = View.inflate(this.mContext, C0965R.layout.carmode_nav_disclaimer, null);
            }
            CheckBox checkbox = (CheckBox) layout.findViewById(C0965R.id.nav_disclaimer_checkbox);
            TextView textView = (TextView) layout.findViewById(C0965R.id.TextView02);
            checkbox.setChecked(notShowUpdate);
            textView.setText(appInformation);
            textView.setTextSize(18.0f);
            textView.setMovementMethod(new ScrollingMovementMethod());
            checkbox.setOnCheckedChangeListener(new C36913());
            this.mOnDialogListener.showDialog(new C2304o(this.mContext).i(C0965R.string.alert_update_apk_title).c(layout).j(C0965R.string.alert_cancel).k(C0965R.string.alert_update_apk_now).m().c(new C36935()).d(new C36924()), C1265a.Center);
        }
    }

    private void showDownloadAppDialog() {
        if (this.mDownloadDialog == null) {
            View view = LayoutInflater.from(this.mContext).inflate(C0965R.layout.software_update_layout, null);
            this.mProgressBar = (ProgressBar) view.findViewById(C0965R.id.progress_bar);
            this.mDownloadText = (TextView) view.findViewById(C0965R.id.text_download);
            this.mPersentText = (TextView) view.findViewById(C0965R.id.text_persent);
            view.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_upgrade_dialog_bg));
            this.mDownloadText.setTextColor(StyleManager.getColor(C0965R.color.bnav_upgrade_dialog_text_normal));
            this.mPersentText.setTextColor(StyleManager.getColor(C0965R.color.bnav_upgrade_dialog_text_normal));
            this.mDownloadDialog = new C2286m(this.mContext).a(C0965R.string.alert_download_apk_title).a(view).b(C0965R.string.alert_cancel).a(new C36946());
        }
        this.mOnDialogListener.showDialog(this.mDownloadDialog, C1265a.Center);
        BNOfflineDataManager.getInstance().pauseAppDataDownLoad();
        BNOfflineDataManager.getInstance().removeAppData();
        BNOfflineDataManager.getInstance().downLoadAppData();
    }

    private void installApk() {
        String saveFileName = SysOSAPI.getInstance().GetSDCardPath() + "/BaiduNavi.apk";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("file://" + saveFileName), "application/vnd.android.package-archive");
        this.mContext.startActivity(intent);
    }
}
