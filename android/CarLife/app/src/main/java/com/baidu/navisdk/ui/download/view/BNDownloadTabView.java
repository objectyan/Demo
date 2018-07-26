package com.baidu.navisdk.ui.download.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.comapi.offlinedata.OfflineDataParams.Key;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.download.BNDownloadNotifyManager;
import com.baidu.navisdk.ui.download.adapter.BNOfflineDataAdapterListener;
import com.baidu.navisdk.ui.download.adapter.BNOfflineDataListAdapter;
import com.baidu.navisdk.ui.download.adapter.BNOfflineDataVerticalListAdapter;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class BNDownloadTabView {
    protected static final int DEFAULT_TITLE_HEIGHT = 30;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 14;
    protected static final int DEFAULT_TITLE_WIDTH = 60;
    private static final int INDEX_RP_NETMODE = 0;
    private static final int INDEX_WIFI_UPDATE = 1;
    public static final String KEY_PROVINCE_ID = "province_id";
    protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
    public static final int MSG_TYPE_CAL_DISK_SPACE = 5;
    public static final int MSG_TYPE_CAL_DISK_SPACE_DONE = 6;
    public static final int MSG_TYPE_CANCEL_UPDATE_DATA = 4;
    public static final int MSG_TYPE_CANCEL_UPDATE_DONE = 1;
    public static final int MSG_TYPE_DELETE_COMMON_DATA = 3;
    public static final int MSG_TYPE_DELETE_DATA = 2;
    public static final int MSG_TYPE_DELETE_DONE = 0;
    public static final int MSG_TYPE_MD5_ERROR = 7;
    public static final int MSG_TYPE_MD5_ERROR_DONE = 8;
    private static final int OPTION_SIZE = 2;
    private static final String TAG = "!#BNDownloadTabView";
    private RelativeLayout bottom_status = null;
    private Activity mActivity;
    private CalDiskkSpaceThread mCalDiskkSpaceThread = null;
    private CancelUpdateThread mCancelUpdateThread = null;
    ImageView[] mCheckboxs = new ImageView[2];
    private BNOfflineDataAdapterListener mDelegate = new C43228();
    private BNMessageDialog mDeleteAlertDlg = null;
    private BNMessageDialog mDeleteCommonAlertDlg = null;
    private DeleteThread mDeleteThread = null;
    private TextView mDiskSpaceTextView = null;
    private RadioButton mDownload = null;
    private HandleMd5ErrorThread mHandleMd5ErrorThread = null;
    private Handler mHandler = new C43239();
    private boolean mIsShowDownloadedPage = false;
    private ListItem[] mItems = new ListItem[2];
    private int mLastOrientation = 0;
    private BNMessageDialog mMd5AlertDlg = null;
    private View mNetModeView;
    private BNOfflineDataObserver mOfflineDataMsgObserver = new BNOfflineDataObserver() {

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$10$1 */
        class C43111 implements OnNaviClickListener {
            C43111() {
            }

            public void onClick() {
                try {
                    if (BNDownloadTabView.this.mWaitProgress == null && BNDownloadTabView.this.mActivity != null) {
                        BNDownloadTabView.this.mWaitProgress = new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(C4048R.string.waiting_delete_data));
                    }
                    if (!(BNDownloadTabView.this.mWaitProgress == null || BNDownloadTabView.this.mWaitProgress.isShowing())) {
                        BNDownloadTabView.this.mWaitProgress.show();
                    }
                    Message.obtain(BNDownloadTabView.this.mHandler, 7, 0, 0, null).sendToTarget();
                    if (BNDownloadTabView.this.mMd5AlertDlg != null) {
                        BNDownloadTabView.this.mMd5AlertDlg.dismiss();
                        BNDownloadTabView.this.mMd5AlertDlg = null;
                    }
                } catch (Exception e) {
                }
            }
        }

        public void update(BNSubject o, int Type, int event, Object arg) {
            switch (Type) {
                case 1:
                    BNDownloadTabView.this.updateList();
                    return;
                case 2:
                    DownloadArg downloadArg = (DownloadArg) arg;
                    String notifTitle;
                    switch (event) {
                        case 257:
                            return;
                        case 258:
                            StringUtils.showToastText(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(C4048R.string.download_request_fail));
                            return;
                        case 259:
                            StringUtils.showToastText(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(C4048R.string.download_request_net_work));
                            return;
                        case 260:
                        case 261:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.downloading_alert, new Object[]{downloadArg.mName}), downloadArg.mProgress);
                            return;
                        case 262:
                            LogUtil.m15791e("Alert", "Download finish alert ");
                            notifTitle = JarUtils.getResources().getString(C4048R.string.download_complete_alert, new Object[]{downloadArg.mName});
                            BNDownloadNotifyManager.getInstance().updateNotification(notifTitle, downloadArg.mProgress);
                            BNDownloadNotifyManager.getInstance().clearNotification();
                            StringUtils.showToastText(BNDownloadTabView.this.mActivity, notifTitle);
                            return;
                        case 263:
                        case 264:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.suspending_alert, new Object[]{downloadArg.mName}), downloadArg.mProgress);
                            return;
                        case 265:
                        case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.updating_alert, new Object[]{downloadArg.mName}), downloadArg.mProgress);
                            return;
                        case BNOfflineDataObserver.EVENT_UPDATE_FINISH /*267*/:
                            LogUtil.m15791e("", " update  downloadArg.mUpdatePoiCount " + downloadArg.mUpdatePoiCount + "   downloadArg.mUpdateRouteCount " + downloadArg.mUpdateRouteCount);
                            if (downloadArg.mUpdatePoiCount > 0 && downloadArg.mUpdateRouteCount > 0) {
                                notifTitle = JarUtils.getResources().getString(C4048R.string.update_complete_alert, new Object[]{downloadArg.mName, Integer.valueOf(downloadArg.mUpdateRouteCount), Integer.valueOf(downloadArg.mUpdatePoiCount)});
                            } else if (downloadArg.mUpdatePoiCount <= 0 && downloadArg.mUpdateRouteCount > 0) {
                                notifTitle = JarUtils.getResources().getString(C4048R.string.update_complete_alert_only_rp, new Object[]{downloadArg.mName, Integer.valueOf(downloadArg.mUpdateRouteCount)});
                            } else if (downloadArg.mUpdatePoiCount <= 0 || downloadArg.mUpdateRouteCount > 0) {
                                notifTitle = JarUtils.getResources().getString(C4048R.string.update_complete_alert0, new Object[]{downloadArg.mName});
                            } else {
                                notifTitle = JarUtils.getResources().getString(C4048R.string.update_complete_alert_only_poi, new Object[]{downloadArg.mName, Integer.valueOf(downloadArg.mUpdatePoiCount)});
                            }
                            if (BNOfflineDataManager.getInstance().mIsUpdateFinishNotProgress) {
                                BNDownloadNotifyManager.getInstance().updateNotification(notifTitle, -1);
                            } else {
                                BNDownloadNotifyManager.getInstance().updateNotification(notifTitle, downloadArg.mProgress);
                            }
                            BNOfflineDataManager.getInstance().mIsUpdateFinishNotProgress = false;
                            BNDownloadNotifyManager.getInstance().clearNotification();
                            StringUtils.showToastText(BNDownloadTabView.this.mActivity, notifTitle);
                            return;
                        case BNOfflineDataObserver.EVENT_UPDATE_SUSPEND /*268*/:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.update_suspend_alert, new Object[]{downloadArg.mName}), downloadArg.mProgress);
                            return;
                        case BNOfflineDataObserver.EVENT_DELETE_FINISH /*269*/:
                            BNDownloadNotifyManager.getInstance().clearNotification();
                            return;
                        case BNOfflineDataObserver.EVENT_UPDATE_MERGE_START /*288*/:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.merge_prepare_alert, new Object[]{downloadArg.mName}), -1);
                            return;
                        case 289:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.merge_suspend_alert, new Object[]{downloadArg.mName}), -1);
                            return;
                        case 290:
                            BNDownloadNotifyManager.getInstance().clearNotification();
                            return;
                        case 291:
                            BNDownloadNotifyManager.getInstance().updateNotification(JarUtils.getResources().getString(C4048R.string.merge_fail_alert, new Object[]{downloadArg.mName}), -1);
                            StringUtils.showToastText(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(C4048R.string.merge_fail));
                            return;
                        default:
                            return;
                    }
                case 3:
                    switch (event) {
                        case 270:
                        case BNOfflineDataObserver.EVENT_ERROR_SD_FULL /*271*/:
                            return;
                        case 278:
                            LogUtil.m15791e("Alert", "EVENT_ERROR_MD5  princeId ");
                            try {
                                if (BNDownloadTabView.this.mMd5AlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                                    BNDownloadTabView.this.mMd5AlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.del_md5_data_notification)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.del_md5_data_download)).setOnFirstBtnClickListener(new C43111());
                                }
                                if (BNDownloadTabView.this.mMd5AlertDlg != null && !BNDownloadTabView.this.mMd5AlertDlg.isShowing() && BNDownloadTabView.this.mActivity != null && !BNDownloadTabView.this.mActivity.isFinishing()) {
                                    BNDownloadTabView.this.mMd5AlertDlg.show();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    };
    private View mOfflineDataSettingView;
    private RelativeLayout mOfflinecontentview = null;
    private OnClickListener mOnBackBtnClickListener;
    private OnItemClickListener mOnItemClickListener = null;
    private OnItemLongClickListener mOnItemLongClickListener = null;
    private View mRootView;
    private BNMessageDialog mSDCardAlertDlg = null;
    protected Bundle mShowBundle;
    private BNCommonTitleBar mTitleBar = null;
    private RadioButton mUnDownload = null;
    private TextView mUpdateLogTextView = null;
    private BNOfflineDataVerticalListAdapter mVerticalListAdapter = null;
    private ListView mVerticalListView = null;
    private View mWIFIUpdateView;
    private BNCommonProgressDialog mWaitProgress = null;
    private View middleTitleView = null;

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$1 */
    class C43121 implements OnClickListener {
        C43121() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$2 */
    class C43132 implements OnClickListener {
        C43132() {
        }

        public void onClick(View v) {
            BNDownloadTabView.this.mIsShowDownloadedPage = false;
            BNDownloadTabView.this.bottom_status.setVisibility(8);
            BNDownloadTabView.this.mOfflineDataSettingView.setVisibility(8);
            BNDownloadTabView.this.mUnDownload.setChecked(true);
            BNDownloadTabView.this.mDownload.setChecked(false);
            BNDownloadTabView.this.updateUserClickStatus(Boolean.valueOf(true));
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$3 */
    class C43143 implements OnClickListener {
        C43143() {
        }

        public void onClick(View v) {
            BNDownloadTabView.this.mIsShowDownloadedPage = true;
            BNDownloadTabView.this.bottom_status.setVisibility(0);
            ArrayList<OfflineDataInfo> downloadedList = BNOfflineDataManager.getInstance().getDownloadedList();
            if (downloadedList == null || downloadedList.size() <= 0) {
                BNDownloadTabView.this.mOfflineDataSettingView.setVisibility(8);
            } else {
                BNDownloadTabView.this.mOfflineDataSettingView.setVisibility(0);
            }
            BNDownloadTabView.this.mUnDownload.setChecked(false);
            BNDownloadTabView.this.mDownload.setChecked(true);
            BNDownloadTabView.this.updateUserClickStatus(Boolean.valueOf(false));
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$4 */
    class C43154 implements OnClickListener {
        C43154() {
        }

        public void onClick(View v) {
            BNDownloadTabView.this.reverseItemCheck(0);
            BNDownloadTabView.this.onSettingsChange(0);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$5 */
    class C43165 implements OnClickListener {
        C43165() {
        }

        public void onClick(View v) {
            BNDownloadTabView.this.reverseItemCheck(1);
            BNDownloadTabView.this.onSettingsChange(1);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$6 */
    class C43176 implements OnClickListener {
        C43176() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$7 */
    class C43187 implements OnClickListener {
        C43187() {
        }

        public void onClick(View v) {
            if (BNDownloadTabView.this.mOnBackBtnClickListener != null) {
                BNDownloadTabView.this.mOnBackBtnClickListener.onClick(v);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$8 */
    class C43228 implements BNOfflineDataAdapterListener {

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$8$1 */
        class C43191 implements OnNaviClickListener {
            C43191() {
            }

            public void onClick() {
                Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
            }
        }

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$8$2 */
        class C43202 implements OnNaviClickListener {
            C43202() {
            }

            public void onClick() {
                if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.this.mDeleteAlertDlg = null;
                }
            }
        }

        C43228() {
        }

        public void itemDeleteButtomClicked(final OfflineDataInfo model) {
            if (BNDownloadTabView.this.mVerticalListAdapter == null || !BNDownloadTabView.this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                int state = SDCardUtils.handleOfflinePathError(0, true);
                if (state == 2 || state == 3) {
                    TipTool.onCreateToastDialog(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(C4048R.string.sdcard_error));
                } else if (model.mIsNewVer || model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                    try {
                        if (BNDownloadTabView.this.mDeleteAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                            BNDownloadTabView.this.mDeleteAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.cancel_download)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                                public void onClick() {
                                    Message msg;
                                    if (BNDownloadTabView.this.mWaitProgress == null) {
                                        BNDownloadTabView.this.mWaitProgress = new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(C4048R.string.waiting_delete_data));
                                    }
                                    if (!(BNDownloadTabView.this.mWaitProgress == null || BNDownloadTabView.this.mWaitProgress.isShowing())) {
                                        BNDownloadTabView.this.mWaitProgress.show();
                                    }
                                    if (model.mIsNewVer) {
                                        msg = Message.obtain(BNDownloadTabView.this.mHandler, 4, model.mProvinceId, 0, null);
                                    } else {
                                        msg = Message.obtain(BNDownloadTabView.this.mHandler, 2, model.mProvinceId, 0, null);
                                    }
                                    msg.sendToTarget();
                                    if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                                        BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                                        BNDownloadTabView.this.mDeleteAlertDlg = null;
                                    }
                                }
                            }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_cancel)).setOnFirstBtnClickListener(new C43202());
                        }
                        if (BNDownloadTabView.this.mDeleteAlertDlg != null && !BNDownloadTabView.this.mDeleteAlertDlg.isShowing() && BNDownloadTabView.this.mActivity != null && !BNDownloadTabView.this.mActivity.isFinishing()) {
                            BNDownloadTabView.this.mDeleteAlertDlg.show();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    try {
                        if (BNDownloadTabView.this.mDeleteCommonAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.del_common_data_notification)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_i_know)).setOnFirstBtnClickListener(new C43191());
                        }
                        if (BNDownloadTabView.this.mDeleteCommonAlertDlg != null && !BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing() && BNDownloadTabView.this.mActivity != null && !BNDownloadTabView.this.mActivity.isFinishing()) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
                        }
                    } catch (Exception e2) {
                    }
                }
            } else if (model != null) {
                LogUtil.m15791e("UTEST", "Item clicked model status:" + model.mTaskStatus);
                OfflineDataInfo commonModel;
                switch (model.mTaskStatus) {
                    case 1:
                        if (!model.mIsRequest) {
                            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 0);
                            if (BNOfflineDataManager.getInstance().isCommonDataDownload() || model.mProvinceId == 0) {
                                BNDownloadTabView.this.mVerticalListAdapter.checkToStartDownloadRequest(model, false);
                                return;
                            }
                            commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                            if (commonModel == null || commonModel.mTaskStatus != 1) {
                                BNDownloadTabView.this.mVerticalListAdapter.chooseDownloadStrategy(model, true);
                                return;
                            } else {
                                BNDownloadTabView.this.mVerticalListAdapter.checkToStartDownloadRequest(model, true);
                                return;
                            }
                        }
                        return;
                    case 2:
                    case 3:
                        BNOfflineDataManager.getInstance().suspendDownloadProvinceData(model.mProvinceId);
                        return;
                    case 4:
                    case 6:
                    case 8:
                    case 9:
                    case 13:
                        if (model.mIsNewVer) {
                            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 1);
                            LogUtil.m15791e("UTEST", "chooseUpdateStrategy model status:" + model.mTaskStatus);
                            BNDownloadTabView.this.mVerticalListAdapter.chooseUpdateStrategy(model);
                            return;
                        }
                        LogUtil.m15791e("UTEST", "chooseDownloadStrategy model status:" + model.mTaskStatus);
                        BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 0);
                        if (BNOfflineDataManager.getInstance().isCommonDataDownload() || model.mProvinceId == 0) {
                            BNDownloadTabView.this.mVerticalListAdapter.chooseDownloadStrategy(model, false);
                            return;
                        }
                        commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                        if (commonModel == null || commonModel.mTaskStatus != 1) {
                            BNDownloadTabView.this.mVerticalListAdapter.chooseDownloadStrategy(model, true);
                            return;
                        } else {
                            BNDownloadTabView.this.mVerticalListAdapter.checkToStartDownloadRequest(model, true);
                            return;
                        }
                    case 10:
                        BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 1);
                        BNDownloadTabView.this.mVerticalListAdapter.chooseUpdateStrategy(model);
                        return;
                    case 11:
                    case 12:
                        BNOfflineDataManager.getInstance().suspendUpdateProvinceData(model.mProvinceId);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$9 */
    class C43239 extends Handler {
        C43239() {
        }

        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case 0:
                        if (!(BNDownloadTabView.this.mWaitProgress == null || !BNDownloadTabView.this.mWaitProgress.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mWaitProgress.dismiss();
                        }
                        if (BNDownloadTabView.this.mDeleteThread != null) {
                            BNDownloadTabView.this.mDeleteThread = null;
                        }
                        BNDownloadTabView.this.updateList();
                        return;
                    case 1:
                        if (!(BNDownloadTabView.this.mWaitProgress == null || !BNDownloadTabView.this.mWaitProgress.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mWaitProgress.dismiss();
                        }
                        if (BNDownloadTabView.this.mCancelUpdateThread != null) {
                            BNDownloadTabView.this.mCancelUpdateThread = null;
                        }
                        BNDownloadTabView.this.updateList();
                        return;
                    case 2:
                        if (BNDownloadTabView.this.mDeleteThread != null) {
                            BNDownloadTabView.this.mDeleteThread = null;
                        }
                        BNDownloadTabView.this.mDeleteThread = new DeleteThread(msg.arg1, BNDownloadTabView.this.mHandler);
                        if (BNDownloadTabView.this.mDeleteThread != null && !BNDownloadTabView.this.mDeleteThread.isAlive()) {
                            BNDownloadTabView.this.mDeleteThread.start();
                            return;
                        }
                        return;
                    case 3:
                        if (BNDownloadTabView.this.mDeleteCommonAlertDlg != null && BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing() && BNDownloadTabView.this.mActivity != null && !BNDownloadTabView.this.mActivity.isFinishing()) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg.dismiss();
                            return;
                        }
                        return;
                    case 4:
                        if (BNDownloadTabView.this.mCancelUpdateThread != null) {
                            BNDownloadTabView.this.mCancelUpdateThread = null;
                        }
                        BNDownloadTabView.this.mCancelUpdateThread = new CancelUpdateThread(msg.arg1, BNDownloadTabView.this.mHandler);
                        if (BNDownloadTabView.this.mCancelUpdateThread != null && !BNDownloadTabView.this.mCancelUpdateThread.isAlive()) {
                            BNDownloadTabView.this.mCancelUpdateThread.start();
                            return;
                        }
                        return;
                    case 5:
                        if (BNDownloadTabView.this.mCalDiskkSpaceThread != null) {
                            BNDownloadTabView.this.mCalDiskkSpaceThread = null;
                        }
                        BNDownloadTabView.this.mCalDiskkSpaceThread = new CalDiskkSpaceThread(BNDownloadTabView.this.mHandler);
                        if (BNDownloadTabView.this.mCalDiskkSpaceThread != null && !BNDownloadTabView.this.mCalDiskkSpaceThread.isAlive()) {
                            BNDownloadTabView.this.mCalDiskkSpaceThread.start();
                            return;
                        }
                        return;
                    case 6:
                        if (!(BNDownloadTabView.this.mWaitProgress == null || !BNDownloadTabView.this.mWaitProgress.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mWaitProgress.dismiss();
                        }
                        if (BNDownloadTabView.this.mCalDiskkSpaceThread != null) {
                            BNDownloadTabView.this.mCalDiskkSpaceThread = null;
                        }
                        BNDownloadTabView.this.updateDiskSpaceTV(msg.getData().getLong("TotalDownloadSize"), msg.getData().getLong("DiskSpace"));
                        return;
                    case 7:
                        LogUtil.m15791e("Alert", "MSG_TYPE_MD5_ERROR  princeId ");
                        if (BNDownloadTabView.this.mHandleMd5ErrorThread != null) {
                            BNDownloadTabView.this.mHandleMd5ErrorThread = null;
                        }
                        BNDownloadTabView.this.mHandleMd5ErrorThread = new HandleMd5ErrorThread(BNDownloadTabView.this.mHandler);
                        if (BNDownloadTabView.this.mHandleMd5ErrorThread != null && !BNDownloadTabView.this.mHandleMd5ErrorThread.isAlive()) {
                            BNDownloadTabView.this.mHandleMd5ErrorThread.start();
                            return;
                        }
                        return;
                    case 8:
                        if (!(BNDownloadTabView.this.mWaitProgress == null || !BNDownloadTabView.this.mWaitProgress.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mWaitProgress.dismiss();
                        }
                        if (BNDownloadTabView.this.mHandleMd5ErrorThread != null) {
                            BNDownloadTabView.this.mHandleMd5ErrorThread = null;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }
    }

    private class CalDiskkSpaceThread extends Thread {
        private Handler mUIHandler = null;

        public CalDiskkSpaceThread(Handler handler) {
            this.mUIHandler = handler;
        }

        public void run() {
            BNOfflineDataListAdapter adapter = null;
            if (BNDownloadTabView.this.mVerticalListAdapter != null) {
                adapter = BNDownloadTabView.this.mVerticalListAdapter;
            }
            if (adapter != null) {
                adapter.updateDiskSpace();
                Bundle b = new Bundle();
                b.putLong("TotalDownloadSize", adapter.getmTotalDownloadSize());
                b.putLong("DiskSpace", adapter.getmDiskSpace());
                Message msg = Message.obtain(this.mUIHandler, 6, 0, 0, null);
                msg.setData(b);
                msg.sendToTarget();
            }
        }
    }

    private class CancelUpdateThread extends Thread {
        private int mProvinceId;
        private Handler mUIHandler = null;

        public CancelUpdateThread(int nProvinceId, Handler handler) {
            this.mProvinceId = nProvinceId;
            this.mUIHandler = handler;
        }

        public void run() {
            BNOfflineDataManager.getInstance().cancelUpdateData(this.mProvinceId);
            Message.obtain(this.mUIHandler, 1, 0, 0, null).sendToTarget();
        }
    }

    private class DeleteThread extends Thread {
        private int mProvinceId;
        private Handler mUIHandler = null;

        public DeleteThread(int nProvinceId, Handler handler) {
            this.mProvinceId = nProvinceId;
            this.mUIHandler = handler;
        }

        public void run() {
            BNOfflineDataManager.getInstance().removeProvinceData(this.mProvinceId);
            Message.obtain(this.mUIHandler, 0, 0, 0, null).sendToTarget();
        }
    }

    private class HandleMd5ErrorThread extends Thread {
        private Handler mUIHandler = null;

        public HandleMd5ErrorThread(Handler handler) {
            this.mUIHandler = handler;
        }

        public void run() {
            BNOfflineDataManager.getInstance().handleMd5ToRedownload();
            Message.obtain(this.mUIHandler, 8, 0, 0, null).sendToTarget();
        }
    }

    private class ListItem {
        boolean mHasCheckBox;
        boolean mIsCheck;

        private ListItem() {
        }
    }

    private class OnListItemClickListener implements OnItemClickListener {
        private OnListItemClickListener() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            BNOfflineDataListAdapter adapter = null;
            OfflineDataInfo model = null;
            if (BNDownloadTabView.this.mVerticalListAdapter != null) {
                adapter = BNDownloadTabView.this.mVerticalListAdapter;
                model = (OfflineDataInfo) BNDownloadTabView.this.mVerticalListAdapter.getItem((int) id);
            }
            if (model != null) {
                LogUtil.m15791e("UTEST", "Item clicked model status:" + model.mTaskStatus);
                OfflineDataInfo commonModel;
                switch (model.mTaskStatus) {
                    case 1:
                        if (!model.mIsRequest) {
                            try {
                                BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 0);
                            } catch (Throwable th) {
                            }
                            if (BNOfflineDataManager.getInstance().isCommonDataDownload() || model.mProvinceId == 0) {
                                adapter.checkToStartDownloadRequest(model, false);
                                return;
                            }
                            commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                            if (commonModel == null || commonModel.mTaskStatus != 1) {
                                adapter.chooseDownloadStrategy(model, true);
                                return;
                            } else {
                                adapter.checkToStartDownloadRequest(model, true);
                                return;
                            }
                        }
                        return;
                    case 2:
                    case 3:
                        BNOfflineDataManager.getInstance().suspendDownloadProvinceData(model.mProvinceId);
                        return;
                    case 4:
                    case 6:
                    case 8:
                    case 9:
                    case 13:
                        if (model.mIsNewVer) {
                            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 1);
                            LogUtil.m15791e("UTEST", "chooseUpdateStrategy model status:" + model.mTaskStatus);
                            adapter.chooseUpdateStrategy(model);
                            return;
                        }
                        LogUtil.m15791e("UTEST", "chooseDownloadStrategy model status:" + model.mTaskStatus);
                        BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 0);
                        if (BNOfflineDataManager.getInstance().isCommonDataDownload() || model.mProvinceId == 0) {
                            adapter.chooseDownloadStrategy(model, false);
                            return;
                        }
                        commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                        if (commonModel == null || commonModel.mTaskStatus != 1) {
                            adapter.chooseDownloadStrategy(model, true);
                            return;
                        } else {
                            adapter.checkToStartDownloadRequest(model, true);
                            return;
                        }
                    case 10:
                        try {
                            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, true, 1);
                        } catch (Throwable th2) {
                        }
                        adapter.chooseUpdateStrategy(model);
                        return;
                    case 11:
                    case 12:
                        BNOfflineDataManager.getInstance().suspendUpdateProvinceData(model.mProvinceId);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private class OnListItemLongClickListener implements OnItemLongClickListener {

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$OnListItemLongClickListener$1 */
        class C43241 implements OnNaviClickListener {
            C43241() {
            }

            public void onClick() {
                Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
            }
        }

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$OnListItemLongClickListener$2 */
        class C43252 implements OnNaviClickListener {
            C43252() {
            }

            public void onClick() {
                if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.this.mDeleteAlertDlg = null;
                }
            }
        }

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$OnListItemLongClickListener$4 */
        class C43274 implements OnNaviClickListener {
            C43274() {
            }

            public void onClick() {
                Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
            }
        }

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$OnListItemLongClickListener$5 */
        class C43285 implements OnNaviClickListener {
            C43285() {
            }

            public void onClick() {
                if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.this.mDeleteAlertDlg = null;
                }
            }
        }

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$OnListItemLongClickListener$7 */
        class C43307 implements OnNaviClickListener {
            C43307() {
            }

            public void onClick() {
                Message.obtain(BNDownloadTabView.this.mHandler, 3, 0, 0, null).sendToTarget();
            }
        }

        /* renamed from: com.baidu.navisdk.ui.download.view.BNDownloadTabView$OnListItemLongClickListener$8 */
        class C43318 implements OnNaviClickListener {
            C43318() {
            }

            public void onClick() {
                if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                    BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                    BNDownloadTabView.this.mDeleteAlertDlg = null;
                }
            }
        }

        private OnListItemLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            boolean z = false;
            OfflineDataInfo model = null;
            if (BNDownloadTabView.this.mVerticalListAdapter != null) {
                model = BNDownloadTabView.this.mVerticalListAdapter.getDownloadedListModelByPosition((int) id);
            }
            if (model == null) {
                return false;
            }
            if (model.mTaskStatus == 16) {
                TipTool.onCreateToastDialog(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(C4048R.string.data_merge_forbit_del));
                return false;
            }
            final int finalProvinceId = model.mProvinceId;
            final boolean finalIsNewVer = model.mIsNewVer;
            int state = SDCardUtils.handleOfflinePathError(0, true);
            if (state == 2 || state == 3) {
                TipTool.onCreateToastDialog(BNDownloadTabView.this.mActivity, JarUtils.getResources().getString(C4048R.string.sdcard_error));
                return false;
            }
            if (BNDownloadTabView.this.mVerticalListAdapter == null || !BNDownloadTabView.this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                if (BNDownloadTabView.this.mVerticalListAdapter == null || BNDownloadTabView.this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                    if (model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                        try {
                            if (BNDownloadTabView.this.mDeleteAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                                BNDownloadTabView.this.mDeleteAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.del_navi_data_notification)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                                    public void onClick() {
                                        if (BNDownloadTabView.this.mWaitProgress == null) {
                                            BNDownloadTabView.this.mWaitProgress = new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(C4048R.string.waiting_delete_data));
                                        }
                                        if (!BNDownloadTabView.this.mWaitProgress.isShowing()) {
                                            BNDownloadTabView.this.mWaitProgress.show();
                                        }
                                        Message.obtain(BNDownloadTabView.this.mHandler, 2, finalProvinceId, 0, null).sendToTarget();
                                        if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                                            BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                                            BNDownloadTabView.this.mDeleteAlertDlg = null;
                                        }
                                    }
                                }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_cancel)).setOnFirstBtnClickListener(new C43318());
                            }
                            if (!(BNDownloadTabView.this.mDeleteAlertDlg == null || BNDownloadTabView.this.mDeleteAlertDlg.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                                BNDownloadTabView.this.mDeleteAlertDlg.show();
                            }
                        } catch (Exception e) {
                        }
                    } else {
                        try {
                            if (BNDownloadTabView.this.mDeleteCommonAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                                BNDownloadTabView.this.mDeleteCommonAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.del_common_data_notification)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_i_know)).setOnFirstBtnClickListener(new C43307());
                            }
                            if (!(BNDownloadTabView.this.mDeleteCommonAlertDlg == null || BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                                BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
                            }
                        } catch (Exception e2) {
                        }
                    }
                } else if (model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                    if (model.mTaskStatus == 11 || model.mTaskStatus == 12 || model.mTaskStatus == 13) {
                        z = true;
                    }
                    final Boolean isUpdate = Boolean.valueOf(z);
                    try {
                        if (BNDownloadTabView.this.mDeleteAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                            BNDownloadTabView.this.mDeleteAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(isUpdate.booleanValue() ? C4048R.string.cancel_download : C4048R.string.del_navi_data_notification)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                                public void onClick() {
                                    Message msg;
                                    try {
                                        if (BNDownloadTabView.this.mWaitProgress == null) {
                                            BNDownloadTabView.this.mWaitProgress = new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(C4048R.string.waiting_delete_data));
                                        }
                                        if (!(BNDownloadTabView.this.mWaitProgress == null || BNDownloadTabView.this.mWaitProgress.isShowing())) {
                                            BNDownloadTabView.this.mWaitProgress.show();
                                        }
                                    } catch (Exception e) {
                                    }
                                    if (isUpdate.booleanValue()) {
                                        msg = Message.obtain(BNDownloadTabView.this.mHandler, 4, finalProvinceId, 0, null);
                                    } else {
                                        msg = Message.obtain(BNDownloadTabView.this.mHandler, 2, finalProvinceId, 0, null);
                                    }
                                    msg.sendToTarget();
                                    if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                                        BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                                        BNDownloadTabView.this.mDeleteAlertDlg = null;
                                    }
                                }
                            }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_cancel)).setOnFirstBtnClickListener(new C43285());
                        }
                        if (!(BNDownloadTabView.this.mDeleteAlertDlg == null || BNDownloadTabView.this.mDeleteAlertDlg.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mDeleteAlertDlg.show();
                        }
                    } catch (Exception e3) {
                    }
                } else {
                    try {
                        if (BNDownloadTabView.this.mDeleteCommonAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.del_common_data_notification)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_i_know)).setOnFirstBtnClickListener(new C43274());
                        }
                        if (!(BNDownloadTabView.this.mDeleteCommonAlertDlg == null || BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
                        }
                    } catch (Exception e4) {
                    }
                }
            } else if (model.mTaskStatus == 1) {
                return false;
            } else {
                if (model.mIsNewVer || model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                    try {
                        if (BNDownloadTabView.this.mDeleteAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                            BNDownloadTabView.this.mDeleteAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.cancel_download)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                                public void onClick() {
                                    Message msg;
                                    try {
                                        if (BNDownloadTabView.this.mWaitProgress == null) {
                                            BNDownloadTabView.this.mWaitProgress = new BNCommonProgressDialog(BNDownloadTabView.this.mActivity).setMessage(JarUtils.getResources().getString(C4048R.string.waiting_delete_data));
                                        }
                                        if (!(BNDownloadTabView.this.mWaitProgress == null || BNDownloadTabView.this.mWaitProgress.isShowing())) {
                                            BNDownloadTabView.this.mWaitProgress.show();
                                        }
                                    } catch (Exception e) {
                                    }
                                    if (finalIsNewVer) {
                                        msg = Message.obtain(BNDownloadTabView.this.mHandler, 4, finalProvinceId, 0, null);
                                    } else {
                                        msg = Message.obtain(BNDownloadTabView.this.mHandler, 2, finalProvinceId, 0, null);
                                    }
                                    msg.sendToTarget();
                                    if (BNDownloadTabView.this.mDeleteAlertDlg != null) {
                                        BNDownloadTabView.this.mDeleteAlertDlg.dismiss();
                                        BNDownloadTabView.this.mDeleteAlertDlg = null;
                                    }
                                }
                            }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_cancel)).setOnFirstBtnClickListener(new C43252());
                        }
                        if (!(BNDownloadTabView.this.mDeleteAlertDlg == null || BNDownloadTabView.this.mDeleteAlertDlg.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mDeleteAlertDlg.show();
                        }
                    } catch (Exception e5) {
                    }
                } else {
                    try {
                        if (BNDownloadTabView.this.mDeleteCommonAlertDlg == null && BNDownloadTabView.this.mActivity != null) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg = new BNMessageDialog(BNDownloadTabView.this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_notification)).setMessage(JarUtils.getResources().getString(C4048R.string.del_common_data_notification)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_i_know)).setOnFirstBtnClickListener(new C43241());
                        }
                        if (!(BNDownloadTabView.this.mDeleteCommonAlertDlg == null || BNDownloadTabView.this.mDeleteCommonAlertDlg.isShowing() || BNDownloadTabView.this.mActivity == null || BNDownloadTabView.this.mActivity.isFinishing())) {
                            BNDownloadTabView.this.mDeleteCommonAlertDlg.show();
                        }
                    } catch (Exception e6) {
                    }
                }
            }
            return true;
        }
    }

    public BNDownloadTabView(Activity activity) {
        this.mActivity = activity;
        BNOfflineDataManager.getInstance().addObserver(this.mOfflineDataMsgObserver);
        initUserConfig();
        initView(activity, null);
    }

    private void initView(Activity activity, Bundle showBundle) {
        LogUtil.m15791e(TAG, "JarUtils asJar=" + JarUtils.getAsJar());
        if (activity != null) {
            this.mLastOrientation = 1;
            initView(this.mRootView);
            if (this.mVerticalListView != null) {
                this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
                this.mVerticalListView.setVisibility(0);
                updateOrientation(this.mLastOrientation);
                updateStyle(BNStyleManager.getDayStyle());
                setOnItemClickedListener();
                if (this.mShowBundle != null && this.mShowBundle.containsKey(Key.DOWNLOAD_KEY_PROVINCE_ID)) {
                    int provinceId = this.mShowBundle.getInt(Key.DOWNLOAD_KEY_PROVINCE_ID);
                    BNOfflineDataListAdapter adapter = null;
                    if (this.mVerticalListAdapter != null) {
                        adapter = this.mVerticalListAdapter;
                    }
                    OfflineDataInfo model = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(provinceId);
                    OfflineDataInfo commonModel;
                    switch (model.mTaskStatus) {
                        case 1:
                            if (BNOfflineDataManager.getInstance().isCommonDataDownload()) {
                                adapter.checkToStartDownloadRequest(model, false);
                                return;
                            }
                            commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                            if (commonModel == null || commonModel.mTaskStatus != 1) {
                                adapter.chooseDownloadStrategy(model, true);
                                return;
                            } else {
                                adapter.checkToStartDownloadRequest(model, true);
                                return;
                            }
                        case 4:
                        case 6:
                        case 8:
                        case 9:
                        case 13:
                            if (model.mIsNewVer) {
                                LogUtil.m15791e("UTEST", "chooseUpdateStrategy model status:" + model.mTaskStatus);
                                adapter.chooseUpdateStrategy(model);
                                return;
                            } else if (BNOfflineDataManager.getInstance().isCommonDataDownload()) {
                                adapter.chooseDownloadStrategy(model, false);
                                return;
                            } else {
                                commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                                if (commonModel == null || commonModel.mTaskStatus != 1) {
                                    adapter.chooseDownloadStrategy(model, true);
                                    return;
                                } else {
                                    adapter.checkToStartDownloadRequest(model, true);
                                    return;
                                }
                            }
                        case 10:
                            adapter.chooseUpdateStrategy(model);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    private void initView(View viewGroup) {
        try {
            this.mRootView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_offline_data, null);
            if (this.mRootView != null) {
                LogUtil.m15791e("zzt", "mRootView  " + this.mRootView);
                this.mOfflinecontentview = (RelativeLayout) this.mRootView.findViewById(C4048R.id.offline_contentview);
                this.mVerticalListView = (ListView) this.mRootView.findViewById(C4048R.id.vertical_list_view);
                this.mTitleBar = (BNCommonTitleBar) this.mRootView.findViewById(C4048R.id.title_bar);
                this.mDiskSpaceTextView = (TextView) this.mRootView.findViewById(C4048R.id.textview_disk_space);
                this.mUpdateLogTextView = (TextView) this.mRootView.findViewById(C4048R.id.textview_update_log);
                this.bottom_status = (RelativeLayout) this.mRootView.findViewById(C4048R.id.bottom_status);
                this.mUpdateLogTextView.setVisibility(4);
                this.bottom_status.setVisibility(8);
                this.mUpdateLogTextView.setOnClickListener(new C43121());
                this.middleTitleView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_offline_data_middle_title, null);
                LogUtil.m15791e("zzt", "mRootView1111  " + this.mRootView);
                if (this.middleTitleView != null) {
                    this.mTitleBar.setMiddleContent(this.middleTitleView);
                }
                this.mOfflineDataSettingView = this.mRootView.findViewById(C4048R.id.nav_offline_data_setting_layout);
                this.mUnDownload = (RadioButton) this.middleTitleView.findViewById(C4048R.id.offline_data_undownload);
                this.mDownload = (RadioButton) this.middleTitleView.findViewById(C4048R.id.offline_data_download);
                this.mUnDownload.setOnClickListener(new C43132());
                this.mDownload.setOnClickListener(new C43143());
                setupTitleBar();
                this.mNetModeView = this.mRootView.findViewById(C4048R.id.nav_rp_netmode_select_layout);
                this.mCheckboxs[0] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_rp_netmode_cb);
                this.mWIFIUpdateView = this.mRootView.findViewById(C4048R.id.nav_wifi_update_select_layout);
                this.mCheckboxs[1] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_wifi_update_cb);
                this.mNetModeView.setOnClickListener(new C43154());
                this.mWIFIUpdateView.setOnClickListener(new C43165());
                for (int i = 0; i < 2; i++) {
                    updateView(i);
                }
            }
        } catch (Exception e) {
        }
    }

    private void setupTitleBar() {
        OnClickListener mTitleRightBtnListener = new C43176();
        this.mTitleBar.setRightContenVisible(false);
        this.mTitleBar.setRightOnClickedListener(mTitleRightBtnListener);
    }

    public void setBackBtnOnClickListener(OnClickListener listener) {
        this.mOnBackBtnClickListener = listener;
        if (this.mTitleBar != null && listener != null) {
            this.mTitleBar.setLeftOnClickedListener(new C43187());
        }
    }

    private void setOnItemClickedListener() {
        this.mOnItemClickListener = new OnListItemClickListener();
        this.mOnItemLongClickListener = new OnListItemLongClickListener();
        if (this.mVerticalListView != null) {
            this.mVerticalListView.setOnItemClickListener(this.mOnItemClickListener);
            this.mVerticalListView.setOnItemLongClickListener(this.mOnItemLongClickListener);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setShowBundle(Bundle showBundle) {
        this.mShowBundle = showBundle;
    }

    public void updateOrientation(int o) {
        this.mVerticalListAdapter = new BNOfflineDataVerticalListAdapter(this.mActivity, this.mDelegate);
        this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
        this.mVerticalListView.setVisibility(0);
        this.middleTitleView.setVisibility(0);
        this.mTitleBar.setMiddleTextVisible(false);
        updateList();
    }

    public void updateStyle(boolean dayStyle) {
        try {
            if (this.mOfflinecontentview != null) {
                this.mOfflinecontentview.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.bnav_rp_tc_title_scheme_name));
            }
            if (this.mVerticalListView != null) {
                this.mVerticalListView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.common_list_bg_color));
            }
            if (this.mVerticalListAdapter != null) {
                if (this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                    this.mUnDownload.setChecked(true);
                    this.mDownload.setChecked(false);
                } else {
                    this.mUnDownload.setChecked(false);
                    this.mDownload.setChecked(true);
                }
            }
            if (this.bottom_status != null) {
                this.bottom_status.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.bnav_rp_od_bg_bottom_status));
            }
            if (this.mDiskSpaceTextView != null) {
                this.mDiskSpaceTextView.setTextColor(JarUtils.getResources().getColor(C4048R.color.bnav_rp_od_bg_bottom_info));
            }
        } catch (Throwable th) {
        }
    }

    public void updateList() {
        if (this.mVerticalListAdapter != null) {
            this.mVerticalListAdapter.updateData();
            this.mVerticalListAdapter.notifyDataSetChanged();
        }
        if (this.mIsShowDownloadedPage && this.mOfflineDataSettingView != null) {
            ArrayList<OfflineDataInfo> downloadedList = BNOfflineDataManager.getInstance().getDownloadedList();
            if (downloadedList == null || downloadedList.size() <= 0) {
                this.mOfflineDataSettingView.setVisibility(8);
            } else {
                this.mOfflineDataSettingView.setVisibility(0);
            }
        }
        if (this.mVerticalListAdapter != null && !this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
            Message.obtain(this.mHandler, 5, 0, 0, null).sendToTarget();
        }
    }

    private void updateUserClickStatus(Boolean isUndownload) {
        if (this.mVerticalListAdapter != null) {
            this.mVerticalListAdapter.updateUserClickStatus(isUndownload);
        }
        if (!isUndownload.booleanValue()) {
            BNOfflineDataManager.getInstance().updateMapDataStutas();
            if (this.mVerticalListAdapter != null) {
                this.mVerticalListAdapter.updateData(true);
            }
        }
        updateList();
    }

    private void updateDiskSpaceTV(long totalDownloadSize, long diskSpace) {
        String tempTotalDownloadSize;
        if (((double) totalDownloadSize) < 1.0E-7d) {
            tempTotalDownloadSize = "0M";
        } else {
            tempTotalDownloadSize = StringUtils.ByteSizeToStringForLong(Long.valueOf(totalDownloadSize));
        }
        LogUtil.m15791e("OfflineData", "updateDiskSpaceTV totalDownloadSize:" + totalDownloadSize + "  diskSpace: " + diskSpace + "tempTotalDownloadSize:" + tempTotalDownloadSize + "  tempDiskSpace: " + StringUtils.ByteSizeToStringForLong(Long.valueOf(diskSpace)));
        this.mDiskSpaceTextView.setText(JarUtils.getResources().getString(C4048R.string.offline_data_disk_space, new Object[]{tempTotalDownloadSize, tempDiskSpace}));
    }

    private void initUserConfig() {
        ListItem item = new ListItem();
        item.mHasCheckBox = true;
        item.mIsCheck = getRPNetMode();
        this.mItems[0] = item;
        item = new ListItem();
        item.mHasCheckBox = true;
        item.mIsCheck = BNSettingManager.isAutoUpdateNewData();
        this.mItems[1] = item;
    }

    private boolean getRPNetMode() {
        if (BNSettingManager.getPrefRoutPlanMode() == 2) {
            return true;
        }
        return false;
    }

    private void setRPNetMode(boolean isOfflineRP) {
        BNSettingManager.setPrefRoutePlanMode(isOfflineRP ? 2 : 3);
    }

    private void updateView(int index) {
        switch (index) {
            case 0:
                updateCheckDrawable(index);
                return;
            case 1:
                updateCheckDrawable(index);
                return;
            default:
                return;
        }
    }

    private void updateCheckDrawable(int index) {
        if (this.mItems[index].mIsCheck) {
            this.mCheckboxs[index].setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkin_icon));
        } else {
            this.mCheckboxs[index].setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkout_icon));
        }
    }

    private void reverseItemCheck(int index) {
        if (this.mItems[index] != null) {
            this.mItems[index].mIsCheck = !this.mItems[index].mIsCheck;
        }
    }

    private void onSettingsChange(int index) {
        switch (index) {
            case 0:
                if (this.mItems[index] != null) {
                    setRPNetMode(this.mItems[index].mIsCheck);
                    break;
                }
                break;
            case 1:
                if (this.mItems[index] != null) {
                    BNSettingManager.setAutoUpdateNewData(this.mItems[index].mIsCheck);
                    break;
                }
                break;
        }
        try {
            updateView(index);
        } catch (Throwable th) {
        }
    }

    public void destroy() {
        if (this.mVerticalListAdapter != null) {
            this.mVerticalListAdapter.dimissLinkageDialog();
        }
    }
}
