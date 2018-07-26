package com.baidu.navisdk.ui.download;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.ApkInfo;
import com.baidu.navisdk.model.datastruct.CheckNewInfo;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.download.view.BNDownloadTabView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.ArrayList;

public class BNDownloadUIManager extends BNSubject {
    private static final String PREF_SHOW_NEWER_GUIDE = "download.showNewerGuide";
    private static final String TAG = "!#BNDownloadUIManager";
    public static final int TYPE_GET_CURR_PROVINCE_SUCC = 1;
    private static ArrayList<OfflineDataInfo> mNeedUpdateList = new ArrayList();
    private static CheckNewInfo sCheckNewInfo = new CheckNewInfo();
    private static BNDownloadUIManager sInstance;
    private static boolean sIsCheckedNewVersion = false;
    private static int[] sNewVerDistrictIds = new int[35];
    private Activity mActivity;
    private boolean mIsRecverRegistered = false;
    private AlertDialog mNewerGuideDialog;
    private View mNewerGuideDlgImage;
    private BNDownloadTabView mTabView;

    /* renamed from: com.baidu.navisdk.ui.download.BNDownloadUIManager$2 */
    class C42982 implements OnClickListener {
        C42982() {
        }

        public void onClick(View v) {
            if (BNDownloadUIManager.this.mNewerGuideDialog != null) {
                BNDownloadUIManager.this.mNewerGuideDialog.dismiss();
                BNDownloadUIManager.this.mNewerGuideDialog = null;
                BNDownloadUIManager.this.mNewerGuideDlgImage = null;
            }
        }
    }

    public interface OnNewVersionListener {
        void onNewVersion(int[] iArr);
    }

    public static synchronized BNDownloadUIManager getInstance(Activity activity) {
        BNDownloadUIManager bNDownloadUIManager;
        synchronized (BNDownloadUIManager.class) {
            if (sInstance == null && activity != null) {
                sInstance = new BNDownloadUIManager(activity);
            }
            bNDownloadUIManager = sInstance;
        }
        return bNDownloadUIManager;
    }

    private BNDownloadUIManager(Activity activity) {
        this.mActivity = activity;
        boolean showNewGuider = PreferenceHelper.getInstance(this.mActivity).getBoolean(PREF_SHOW_NEWER_GUIDE, true);
        LogUtil.m15791e(TAG, "PREF_SHOW_NEWER_GUIDE = " + showNewGuider);
        if (showNewGuider) {
            PreferenceHelper.getInstance(this.mActivity).putBoolean(PREF_SHOW_NEWER_GUIDE, false);
            showNewerGuideDialog(null);
        }
        boolean isFirstShow = PreferenceHelper.getInstance(this.mActivity).getBoolean(Key.SP_KEY_SHOW_TOAST_FOR_LINKID, false);
        LogUtil.m15791e(TAG, "BNDownloadUIManager: isFirstShow " + isFirstShow);
        if (isFirstShow) {
            PreferenceHelper.getInstance(this.mActivity).putBoolean(Key.SP_KEY_SHOW_TOAST_FOR_LINKID, false);
            TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.data_ver_not_match_tips));
        }
    }

    public View createView(Activity activity) {
        if (activity == null) {
            return null;
        }
        this.mActivity = activity;
        if (this.mTabView == null) {
            this.mTabView = new BNDownloadTabView(this.mActivity);
            registerOfflineDataManagerReceiver();
        }
        return this.mTabView.getRootView();
    }

    private void registerOfflineDataManagerReceiver() {
        LogUtil.m15791e(TAG, "registerOfflineDataManagerReceiver: " + this.mIsRecverRegistered);
        if (!this.mIsRecverRegistered) {
            this.mIsRecverRegistered = true;
            BNOfflineDataManager.getInstance().initSDCardListener(this.mActivity);
        }
    }

    private void unregisterOfflineDataManagerReceiver() {
        LogUtil.m15791e(TAG, "unregisterOfflineDataManagerReceiver: " + this.mIsRecverRegistered);
        if (this.mIsRecverRegistered) {
            this.mIsRecverRegistered = false;
            BNOfflineDataManager.getInstance().UnInitSDCardListener(this.mActivity);
        }
    }

    public static synchronized void onActivityDestroy() {
        synchronized (BNDownloadUIManager.class) {
            LogUtil.m15791e(TAG, "~~~~~~~~~~ onActivityDestroy ~~~~~~~~~");
            if (sInstance != null) {
                sInstance = null;
            }
        }
    }

    public boolean isViewCreated() {
        return this.mTabView != null;
    }

    public void setBackBtnOnClickListener(OnClickListener listener) {
        if (this.mTabView != null) {
            this.mTabView.setBackBtnOnClickListener(listener);
        }
    }

    public View getView() {
        if (this.mTabView != null) {
            return this.mTabView.getRootView();
        }
        return null;
    }

    public void destroyView() {
        if (this.mTabView != null) {
            this.mTabView.destroy();
            View view = this.mTabView.getRootView();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(view);
                }
            }
            unregisterOfflineDataManagerReceiver();
            this.mTabView = null;
        }
        this.mActivity = null;
    }

    public void remmoveParentView() {
        if (this.mTabView != null) {
            View view = this.mTabView.getRootView();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(view);
                }
            }
        }
    }

    public void updateStyle(boolean dayStyle) {
        if (this.mTabView != null) {
            this.mTabView.updateStyle(dayStyle);
        }
    }

    public static synchronized void pauseAllDownload() {
        synchronized (BNDownloadUIManager.class) {
            if (sInstance != null) {
                BNOfflineDataManager.getInstance().suspendBatchDownload();
            }
        }
    }

    public static void checkNewVersion(Activity activity, boolean showDefaultDlg, final OnNewVersionListener listener) {
        if (activity == null) {
            LogUtil.m15791e(TAG, "checkNewVersion: null activity!");
        } else if (NetworkUtils.isTypeNetworkAvailable(activity, 1)) {
            int storageState = SDCardUtils.getSdcardState();
            if (storageState != 0) {
                LogUtil.m15791e(TAG, "checkNewVersion: storage is unavailable, " + storageState);
            } else {
                BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-checkNewVersion", null) {
                    protected String execute() {
                        synchronized (BNDownloadUIManager.class) {
                            if (BNDownloadUIManager.sIsCheckedNewVersion) {
                                LogUtil.m15791e(TAG, "new version data has been checked!!");
                            } else {
                                BNDownloadUIManager.sIsCheckedNewVersion = true;
                                BNOfflineDataManager.getInstance().checkNewVer(BNDownloadUIManager.sCheckNewInfo, new ApkInfo(), BNDownloadUIManager.sNewVerDistrictIds, true);
                                LogUtil.m15791e(TAG, "checkNewVerison: newData " + BNDownloadUIManager.sCheckNewInfo.mNewData + ", newApp " + BNDownloadUIManager.sCheckNewInfo.mNewApp + ", count " + BNDownloadUIManager.sCheckNewInfo.mCount);
                                if (BNDownloadUIManager.sCheckNewInfo.mNewData && BNOfflineDataManager.getInstance().isProvinceDataDownload(0) && BNSettingManager.isAutoUpdateNewData()) {
                                    ArrayList<OfflineDataInfo> updatList1 = new ArrayList();
                                    ArrayList<OfflineDataInfo> updatList2 = new ArrayList();
                                    BNOfflineDataManager.getInstance().getItemTable(3, updatList1);
                                    BNOfflineDataManager.getInstance().getItemTable(4, updatList2);
                                    BNDownloadUIManager.mNeedUpdateList.addAll(updatList1);
                                    BNDownloadUIManager.mNeedUpdateList.addAll(updatList2);
                                    for (int index = 0; index < BNDownloadUIManager.mNeedUpdateList.size(); index++) {
                                        OfflineDataInfo model = (OfflineDataInfo) BNDownloadUIManager.mNeedUpdateList.get(index);
                                        BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
                                        LogUtil.m15791e("Update", "update auto province " + model.mProvinceId + "!!!!!!!!!!!");
                                        try {
                                            Thread.sleep(100);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (listener != null) {
                                        listener.onNewVersion(BNDownloadUIManager.sNewVerDistrictIds);
                                    }
                                }
                            }
                        }
                        return null;
                    }
                }, new BNWorkerConfig(101, 0));
            }
        } else {
            LogUtil.m15791e(TAG, "checkNewVersion: wifi is unavailable");
        }
    }

    private void buildNewerGuideDialog() {
        if (this.mNewerGuideDialog == null) {
            View view;
            Builder builder = new Builder(this.mActivity);
            try {
                view = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_download_newerguide, null);
            } catch (Exception e) {
                view = null;
            }
            if (view != null) {
                this.mNewerGuideDlgImage = view.findViewById(C4048R.id.image_view);
                View button = view.findViewById(C4048R.id.confirm_btn);
                if (button != null) {
                    button.setOnClickListener(new C42982());
                }
                this.mNewerGuideDialog = builder.create();
                if (this.mNewerGuideDialog != null) {
                    this.mNewerGuideDialog.setView(view, 0, 0, 0, 0);
                    this.mNewerGuideDialog.setCancelable(false);
                }
            }
        }
    }

    private void showNewerGuideDialog(Configuration newConfig) {
        int orientation;
        buildNewerGuideDialog();
        if (newConfig != null) {
            orientation = newConfig.orientation;
        } else {
            orientation = this.mActivity.getResources().getConfiguration().orientation;
        }
        if (this.mNewerGuideDlgImage != null) {
            if (orientation == 1) {
                this.mNewerGuideDlgImage.setVisibility(0);
            } else {
                this.mNewerGuideDlgImage.setVisibility(8);
            }
        }
        if (newConfig == null && this.mNewerGuideDialog != null && !this.mActivity.isFinishing()) {
            try {
                this.mNewerGuideDialog.show();
            } catch (Throwable th) {
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        LogUtil.m15791e(TAG, "onConfigurationChanged: orientation" + newConfig.orientation);
        if (this.mNewerGuideDialog != null && this.mNewerGuideDialog.isShowing()) {
            showNewerGuideDialog(newConfig);
        }
    }
}
