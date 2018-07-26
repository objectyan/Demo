package com.baidu.navi.fragment.carmode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.adapter.CarModeOfflineDataListAdapter;
import com.baidu.navi.adapter.OfflineDataAdapterListener;
import com.baidu.navi.adapter.OfflineDataHorizontalListAdapter;
import com.baidu.navi.adapter.OfflineDataListAdapter;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navi.view.HorizontalListView;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.comapi.offlinedata.OfflineDataParams;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.common.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class CarModeOfflineDataFragment extends ContentFragment {
    protected static final int DEFAULT_TITLE_HEIGHT = 30;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 14;
    protected static final int DEFAULT_TITLE_WIDTH = 60;
    public static final String KEY_COME_FROM_CONTINUEDOWNLOAD_DIALOG = "continue_download_dialog";
    public static final String KEY_PROVINCE_ID = "province_id";
    protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
    public static final int MSG_TYPE_CAL_DISK_SPACE = 5;
    public static final int MSG_TYPE_CAL_DISK_SPACE_DONE = 6;
    public static final int MSG_TYPE_CANCEL_UPDATE_DATA = 4;
    public static final int MSG_TYPE_CANCEL_UPDATE_DONE = 1;
    public static final int MSG_TYPE_DELETE_DATA = 2;
    public static final int MSG_TYPE_DELETE_DONE = 0;
    public static final String NEED_DELETE_DATA = "needDeleteOldMapData";
    private static final String TAG = "OffineData";
    private RelativeLayout bottom_status = null;
    private ImageView mBackImg = null;
    private CalDiskkSpaceThread mCalDiskkSpaceThread = null;
    private CancelUpdateThread mCancelUpdateThread = null;
    private OfflineDataAdapterListener mDelegate = new C38828();
    private C1953c mDeleteAlertDlg = null;
    private C1953c mDeleteCommonAlertDlg = null;
    private DeleteThread mDeleteThread = null;
    private TextView mDiskSpaceTextView = null;
    private TextView mDownload = null;
    private C1443g mFocusArea;
    private C1438c mFocusList;
    private OfflineHandler mHandler = new OfflineHandler(this);
    private OfflineDataHorizontalListAdapter mHorizontalListAdapter = null;
    private HorizontalListView mHorizontalListView = null;
    private int mLastOrientation = 0;
    private BNOfflineDataObserver mOfflineDataMsgObserver = new BNOfflineDataObserver() {
        public void update(BNSubject o, int Type, int event, Object arg) {
            switch (Type) {
                case 1:
                    CarModeOfflineDataFragment.this.updateList();
                    return;
                case 2:
                    DownloadArg downloadArg = (DownloadArg) arg;
                    String notifTitle;
                    switch (event) {
                        case 257:
                            return;
                        case 258:
                            StringUtils.showToastText(C1157a.a(), StyleManager.getString(C0965R.string.download_request_fail));
                            return;
                        case 259:
                            StringUtils.showToastText(C1157a.a(), StyleManager.getString(C0965R.string.download_request_net_work));
                            return;
                        case 260:
                        case 261:
                            DownNotifManager.getInstance(C1157a.a()).updateDowningNotif(StyleManager.getString(C0965R.string.downloading_alert, downloadArg.mName), downloadArg.mProgress, downloadArg.mProgress + "%");
                            return;
                        case 262:
                            C1260i.e("Alert", "Download finish alert ");
                            SearchStrategyHelper.getInstance(C1157a.a()).setIsNeedReloadSearchEngine(true);
                            notifTitle = StyleManager.getString(C0965R.string.download_complete_alert, downloadArg.mName);
                            DownNotifManager.getInstance(C1157a.a()).showResultNotif(C1157a.a(), notifTitle);
                            StringUtils.showToastText(C1157a.a(), notifTitle);
                            StatisticManager.onEvent(StatisticConstants.HOME_MY_MAP_DOWNLOAD, downloadArg.mName);
                            return;
                        case 263:
                        case 264:
                            DownNotifManager.getInstance(C1157a.a()).updateSuspendingNotif(StyleManager.getString(C0965R.string.suspending_alert, downloadArg.mName));
                            return;
                        case 265:
                        case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                            UIModel.getInstance().setNewData(true);
                            UIModel.getInstance().setIsAutoUpdateDataStatus(true);
                            DownNotifManager.getInstance(C1157a.a()).updateDowningNotif(StyleManager.getString(C0965R.string.updating_alert, downloadArg.mName), downloadArg.mProgress, downloadArg.mProgress + "%");
                            return;
                        case BNOfflineDataObserver.EVENT_UPDATE_FINISH /*267*/:
                            SearchStrategyHelper.getInstance(C1157a.a()).setIsNeedReloadSearchEngine(true);
                            UIModel.getInstance().setNewData(false);
                            if (downloadArg.mUpdatePoiCount > 0 && downloadArg.mUpdateRouteCount > 0) {
                                notifTitle = StyleManager.getString(C0965R.string.update_complete_alert, downloadArg.mName, Integer.valueOf(downloadArg.mUpdateRouteCount), Integer.valueOf(downloadArg.mUpdatePoiCount));
                            } else if (downloadArg.mUpdatePoiCount <= 0 && downloadArg.mUpdateRouteCount > 0) {
                                notifTitle = StyleManager.getString(C0965R.string.update_complete_alert_only_rp, downloadArg.mName, Integer.valueOf(downloadArg.mUpdateRouteCount));
                            } else if (downloadArg.mUpdatePoiCount <= 0 || downloadArg.mUpdateRouteCount > 0) {
                                notifTitle = StyleManager.getString(C0965R.string.update_complete_alert0, downloadArg.mName);
                            } else {
                                notifTitle = StyleManager.getString(C0965R.string.update_complete_alert_only_poi, downloadArg.mName, Integer.valueOf(downloadArg.mUpdatePoiCount));
                            }
                            DownNotifManager.getInstance(C1157a.a()).showUpdateFinshedNotif(C1157a.a(), notifTitle);
                            StringUtils.showToastText(C1157a.a(), notifTitle);
                            StatisticManager.onEvent(StatisticConstants.HOME_MY_MAP_DOWNLOAD, "更新:" + downloadArg.mName);
                            return;
                        case BNOfflineDataObserver.EVENT_UPDATE_SUSPEND /*268*/:
                            DownNotifManager.getInstance(C1157a.a()).updateSuspendingNotif(StyleManager.getString(C0965R.string.update_suspend_alert, downloadArg.mName));
                            return;
                        case BNOfflineDataObserver.EVENT_DELETE_FINISH /*269*/:
                            DownNotifManager.getInstance(C1157a.a()).clearAllNotifs();
                            return;
                        case BNOfflineDataObserver.EVENT_UPDATE_MERGE_START /*288*/:
                            DownNotifManager.getInstance(C1157a.a()).showUpdateMergeNotif(C1157a.a(), "正在准备数据中:" + downloadArg.mName + " 数据包");
                            return;
                        case 289:
                            DownNotifManager.getInstance(C1157a.a()).showUpdateMergeNotif(C1157a.a(), "等待中:" + downloadArg.mName + " 数据包");
                            return;
                        case 290:
                            DownNotifManager.getInstance(C1157a.a()).clearAllNotifs();
                            return;
                        case 291:
                            DownNotifManager.getInstance(C1157a.a()).showUpdateMergeNotif(C1157a.a(), "数据更新失败:" + downloadArg.mName + " 数据包");
                            StringUtils.showToastText(C1157a.a(), "数据更新失败");
                            return;
                        default:
                            return;
                    }
                case 3:
                    switch (event) {
                        case 270:
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    };
    private OnItemClickListener mOnItemClickListener = null;
    private OnItemLongClickListener mOnItemLongClickListener = null;
    private TextView mUnDownload = null;
    private LinearLayout mUpdateLogLayout;
    private TextView mUpdateLogTextView = null;
    private CarModeOfflineDataListAdapter mVerticalListAdapter = null;
    private ListView mVerticalListView = null;
    private ViewGroup mViewGroup = null;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment$2 */
    class C38762 implements OnClickListener {
        C38762() {
        }

        public void onClick(View v) {
            CarModeOfflineDataFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment$3 */
    class C38773 implements OnClickListener {
        C38773() {
        }

        public void onClick(View arg0) {
            if (!FileUtils.isExistUpdateLogFile()) {
                TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.no_data_update_log);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment$4 */
    class C38784 implements OnClickListener {
        C38784() {
        }

        public void onClick(View v) {
            CarModeOfflineDataFragment.this.bottom_status.setVisibility(8);
            CarModeOfflineDataFragment.this.mUnDownload.setTextColor(StyleManager.getColor(C0965R.color.carmode_offline_title_text_pressed));
            CarModeOfflineDataFragment.this.mDownload.setTextColor(StyleManager.getColor(C0965R.color.carmode_offline_title_text_normal));
            CarModeOfflineDataFragment.this.mUnDownload.setBackgroundResource(C0965R.drawable.carmode_offline_title_press_bg_selector);
            CarModeOfflineDataFragment.this.mDownload.setBackgroundResource(C0965R.drawable.carmode_offline_title_normal_bg_selector);
            CarModeOfflineDataFragment.this.updateUserClickStatus(Boolean.valueOf(true));
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment$5 */
    class C38795 implements OnClickListener {
        C38795() {
        }

        public void onClick(View v) {
            CarModeOfflineDataFragment.this.bottom_status.setVisibility(0);
            CarModeOfflineDataFragment.this.mUnDownload.setTextColor(StyleManager.getColor(C0965R.color.carmode_offline_title_text_normal));
            CarModeOfflineDataFragment.this.mDownload.setTextColor(StyleManager.getColor(C0965R.color.carmode_offline_title_text_pressed));
            CarModeOfflineDataFragment.this.mUnDownload.setBackgroundResource(C0965R.drawable.carmode_offline_title_normal_bg_selector);
            CarModeOfflineDataFragment.this.mDownload.setBackgroundResource(C0965R.drawable.carmode_offline_title_press_bg_selector);
            CarModeOfflineDataFragment.this.updateUserClickStatus(Boolean.valueOf(false));
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment$6 */
    class C38806 implements OnClickListener {
        C38806() {
        }

        public void onClick(View v) {
            CarModeOfflineDataFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeOfflineDataFragment$8 */
    class C38828 implements OfflineDataAdapterListener {
        C38828() {
        }

        public void itemDeleteButtomClicked(OfflineDataInfo model) {
            if (CarModeOfflineDataFragment.this.mVerticalListAdapter == null || !CarModeOfflineDataFragment.this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                int state = SDCardUtils.handleSdcardError(0, true);
                if (state == 2 || state == 3) {
                    TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.sdcard_error);
                } else if (model.mIsNewVer || model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                    CarModeOfflineDataFragment.this.showDeleteAlertDialog(C0965R.string.cancel_download, model.mIsNewVer, model.mProvinceId);
                } else {
                    CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
                }
            } else if (!ForbidDaulClickUtils.isFastDoubleClick() && model != null) {
                C1260i.e("UTEST", "Item clicked model status:" + model.mTaskStatus);
                OfflineDataInfo commonModel;
                switch (model.mTaskStatus) {
                    case 1:
                        if (!model.mIsRequest) {
                            if (BNOfflineDataManager.getInstance().isCommonDataDownload() || model.mProvinceId == 0) {
                                CarModeOfflineDataFragment.this.mVerticalListAdapter.checkToStartDownloadRequest(model, false);
                                return;
                            }
                            commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                            if (commonModel == null || commonModel.mTaskStatus != 1) {
                                CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseDownloadStrategy(model, true);
                                return;
                            } else {
                                CarModeOfflineDataFragment.this.mVerticalListAdapter.checkToStartDownloadRequest(model, true);
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
                            C1260i.e("UTEST", "chooseUpdateStrategy model status:" + model.mTaskStatus);
                            CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseUpdateStrategy(model);
                            CarModeOfflineDataFragment.this.setNewDataStatus();
                            return;
                        }
                        C1260i.e("UTEST", "chooseDownloadStrategy model status:" + model.mTaskStatus);
                        if (BNOfflineDataManager.getInstance().isCommonDataDownload() || model.mProvinceId == 0) {
                            CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseDownloadStrategy(model, false);
                            return;
                        }
                        commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                        if (commonModel == null || commonModel.mTaskStatus != 1) {
                            CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseDownloadStrategy(model, true);
                            return;
                        } else {
                            CarModeOfflineDataFragment.this.mVerticalListAdapter.checkToStartDownloadRequest(model, true);
                            return;
                        }
                    case 10:
                        CarModeOfflineDataFragment.this.mVerticalListAdapter.chooseUpdateStrategy(model);
                        CarModeOfflineDataFragment.this.setNewDataStatus();
                        return;
                    case 11:
                    case 12:
                        BNOfflineDataManager.getInstance().suspendUpdateProvinceData(model.mProvinceId);
                        CarModeOfflineDataFragment.this.setNewDataStatus();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private class CalDiskkSpaceThread extends Thread {
        private Handler mUIHandler = null;

        public CalDiskkSpaceThread(Handler handler) {
            this.mUIHandler = handler;
        }

        public void run() {
            OfflineDataListAdapter adapter = null;
            if (CarModeOfflineDataFragment.this.mVerticalListAdapter != null) {
                adapter = CarModeOfflineDataFragment.this.mVerticalListAdapter;
            }
            if (CarModeOfflineDataFragment.this.mHorizontalListAdapter != null) {
                adapter = CarModeOfflineDataFragment.this.mHorizontalListAdapter;
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

    private static class OfflineHandler extends Handler {
        private final CarModeOfflineDataFragment mFragment;

        OfflineHandler(CarModeOfflineDataFragment fragment) {
            this.mFragment = fragment;
        }

        public void handleMessage(Message msg) {
            this.mFragment.handleMessage(msg);
        }
    }

    private class OnListItemClickListener implements OnItemClickListener {
        private OnListItemClickListener() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            OfflineDataListAdapter adapter = null;
            OfflineDataInfo model = null;
            if (CarModeOfflineDataFragment.this.mHorizontalListAdapter != null) {
                adapter = CarModeOfflineDataFragment.this.mHorizontalListAdapter;
                model = (OfflineDataInfo) CarModeOfflineDataFragment.this.mHorizontalListAdapter.getItem((int) id);
            } else if (CarModeOfflineDataFragment.this.mVerticalListAdapter != null) {
                adapter = CarModeOfflineDataFragment.this.mVerticalListAdapter;
                model = (OfflineDataInfo) CarModeOfflineDataFragment.this.mVerticalListAdapter.getItem((int) id);
            }
            if (!ForbidDaulClickUtils.isFastDoubleClick(200) && model != null) {
                C1260i.e("UTEST", "Item clicked model status:" + model.mTaskStatus);
                OfflineDataInfo commonModel;
                switch (model.mTaskStatus) {
                    case 1:
                        if (!model.mIsRequest) {
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
                            C1260i.e("UTEST", "chooseUpdateStrategy model status:" + model.mTaskStatus);
                            adapter.chooseUpdateStrategy(model);
                            CarModeOfflineDataFragment.this.setNewDataStatus();
                            return;
                        }
                        C1260i.e("UTEST", "chooseDownloadStrategy model status:" + model.mTaskStatus);
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
                        adapter.chooseUpdateStrategy(model);
                        CarModeOfflineDataFragment.this.setNewDataStatus();
                        return;
                    case 11:
                    case 12:
                        BNOfflineDataManager.getInstance().suspendUpdateProvinceData(model.mProvinceId);
                        CarModeOfflineDataFragment.this.setNewDataStatus();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private class OnListItemLongClickListener implements OnItemLongClickListener {
        private OnListItemLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            OfflineDataInfo model = null;
            if (CarModeOfflineDataFragment.this.mHorizontalListAdapter != null) {
                model = CarModeOfflineDataFragment.this.mHorizontalListAdapter.getDownloadedListModelByPosition((int) id);
            } else if (CarModeOfflineDataFragment.this.mVerticalListAdapter != null) {
                model = CarModeOfflineDataFragment.this.mVerticalListAdapter.getDownloadedListModelByPosition((int) id);
            }
            if (ForbidDaulClickUtils.isFastDoubleClick() || model == null) {
                return false;
            }
            if (model.mTaskStatus == 16) {
                TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.data_merge_forbit_del);
                return false;
            }
            int finalProvinceId = model.mProvinceId;
            boolean finalIsNewVer = model.mIsNewVer;
            int state = SDCardUtils.handleSdcardError(0, true);
            if (state == 2 || state == 3) {
                TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.sdcard_error);
                return false;
            }
            if (CarModeOfflineDataFragment.this.mVerticalListAdapter == null || !CarModeOfflineDataFragment.this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                if (CarModeOfflineDataFragment.this.mVerticalListAdapter == null || CarModeOfflineDataFragment.this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
                    if (model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                        CarModeOfflineDataFragment.this.showDeleteAlertDialog(C0965R.string.del_navi_data_notification, false, finalProvinceId);
                    } else {
                        CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
                    }
                } else if (model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                    boolean z = model.mTaskStatus == 11 || model.mTaskStatus == 12 || model.mTaskStatus == 13;
                    Boolean isUpdate = Boolean.valueOf(z);
                    CarModeOfflineDataFragment.this.showDeleteAlertDialog(isUpdate.booleanValue() ? C0965R.string.cancel_download : C0965R.string.del_navi_data_notification, isUpdate.booleanValue(), finalProvinceId);
                } else {
                    CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
                }
            } else if (model.mTaskStatus == 1) {
                return false;
            } else {
                if (model.mIsNewVer || model.mProvinceId != 0 || BNOfflineDataManager.getInstance().isDeleteCommonDataVailid()) {
                    CarModeOfflineDataFragment.this.showDeleteAlertDialog(C0965R.string.cancel_download, finalIsNewVer, finalProvinceId);
                } else {
                    CarModeOfflineDataFragment.this.showDeleteCommonAlertDialog();
                }
            }
            return true;
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mLastOrientation = getResources().getConfiguration().orientation;
        if (PreferenceHelper.getInstance(mActivity).getBoolean(Key.SP_KEY_FIRST_INIT_FOR_LINKID, true)) {
            PreferenceHelper.getInstance(mActivity).putBoolean(Key.SP_KEY_FIRST_INIT_FOR_LINKID, false);
            BNOfflineDataManager.getInstance().initDownloadInfoForfirst();
        }
        initView(this.mViewGroup, inflater);
        this.mHorizontalListAdapter = null;
        this.mVerticalListView.setItemsCanFocus(true);
        this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
        this.mVerticalListView.setVisibility(0);
        this.mHorizontalListView.setVisibility(8);
        updateViewWitchOrientation(this.mLastOrientation);
        setOnItemClickedListener();
        if (this.mShowBundle != null && this.mShowBundle.containsKey(OfflineDataParams.Key.DOWNLOAD_KEY_PROVINCE_ID)) {
            int provinceId = this.mShowBundle.getInt(OfflineDataParams.Key.DOWNLOAD_KEY_PROVINCE_ID);
            OfflineDataListAdapter adapter = null;
            if (this.mVerticalListAdapter != null) {
                adapter = this.mVerticalListAdapter;
            }
            if (this.mHorizontalListAdapter != null) {
                adapter = this.mHorizontalListAdapter;
            }
            OfflineDataInfo model = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(provinceId);
            OfflineDataInfo commonModel;
            switch (model.mTaskStatus) {
                case 1:
                    if (!BNOfflineDataManager.getInstance().isCommonDataDownload()) {
                        commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                        if (commonModel != null && commonModel.mTaskStatus == 1) {
                            adapter.checkToStartDownloadRequest(model, true);
                            break;
                        }
                        adapter.chooseDownloadStrategy(model, true);
                        break;
                    }
                    adapter.checkToStartDownloadRequest(model, false);
                    break;
                case 4:
                case 6:
                case 8:
                case 9:
                case 13:
                    if (!model.mIsNewVer) {
                        if (!BNOfflineDataManager.getInstance().isCommonDataDownload()) {
                            commonModel = BNOfflineDataManager.getInstance().getDataInfoByProvinceId(0);
                            if (commonModel != null && commonModel.mTaskStatus == 1) {
                                adapter.checkToStartDownloadRequest(model, true);
                                break;
                            }
                            adapter.chooseDownloadStrategy(model, true);
                            break;
                        }
                        adapter.chooseDownloadStrategy(model, false);
                        break;
                    }
                    C1260i.e("UTEST", "chooseUpdateStrategy model status:" + model.mTaskStatus);
                    adapter.chooseUpdateStrategy(model);
                    setNewDataStatus();
                    break;
                case 10:
                    adapter.chooseUpdateStrategy(model);
                    setNewDataStatus();
                    break;
            }
        }
        return this.mViewGroup;
    }

    protected void onInitView() {
        BNOfflineDataManager.getInstance().addObserver(this.mOfflineDataMsgObserver);
        handleContinueDownload();
    }

    private void handleContinueDownload() {
        if (this.mShowBundle != null && this.mShowBundle.containsKey(KEY_COME_FROM_CONTINUEDOWNLOAD_DIALOG) && this.mShowBundle.getBoolean(KEY_COME_FROM_CONTINUEDOWNLOAD_DIALOG, false)) {
            this.mShowBundle.remove(KEY_COME_FROM_CONTINUEDOWNLOAD_DIALOG);
            if (NetworkUtils.isWifiConnected()) {
                final List<Integer> ids = BNOfflineDataManager.getInstance().getSuspendDownloadDataInfo();
                if (ids.size() > 0) {
                    int id = ((Integer) ids.remove(0)).intValue();
                    ArrayList<OfflineDataInfo> models = BNOfflineDataManager.getInstance().getUndowloadList();
                    for (int i = 0; i < models.size(); i++) {
                        if (id == ((OfflineDataInfo) models.get(i)).mProvinceId) {
                            final int index = i;
                            this.mVerticalListView.post(new Runnable() {
                                public void run() {
                                    CarModeOfflineDataFragment.this.mVerticalListView.setSelection(index);
                                    new Thread("ContinueDownloadDataInfoInWifi") {
                                        public void run() {
                                            for (Integer id : ids) {
                                                BNOfflineDataManager.getInstance().downloadProvinceData(id.intValue());
                                                try {
                                                    C38741.sleep(200);
                                                } catch (InterruptedException e) {
                                                }
                                            }
                                        }
                                    }.start();
                                }
                            });
                        }
                    }
                    BNOfflineDataManager.getInstance().downloadProvinceData(id);
                    return;
                }
                return;
            }
            TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.is_not_in_wifi);
        }
    }

    protected void onUpdateOrientation(int orientation) {
        if (orientation != this.mLastOrientation) {
            this.mLastOrientation = orientation;
            updateViewWitchOrientation(this.mLastOrientation);
        }
    }

    protected void onUpdateStyle(boolean dayStyle) {
        updateViewWitchOrientation(this.mLastOrientation);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean onBackPressed() {
        pageBack(this.mModuleFrom);
        return true;
    }

    public void onDestroy() {
        BNOfflineDataManager.getInstance().deleteObserver(this.mOfflineDataMsgObserver);
        super.onDestroy();
    }

    private void initView(ViewGroup viewGroup, LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.car_mode_frag_offline_data, null);
        this.mViewGroup.findViewById(C0965R.id.carmode_frag_offline_data_layout_temp).setOnClickListener(null);
        this.mViewGroup.findViewById(C0965R.id.carmode_frag_offline_data_back).setOnClickListener(new C38762());
        this.mVerticalListView = (ListView) this.mViewGroup.findViewById(C0965R.id.vertical_list_view);
        this.mVerticalListView.setSelector(C2188r.b(C0965R.drawable.com_bg_item_selector));
        this.mHorizontalListView = (HorizontalListView) this.mViewGroup.findViewById(C0965R.id.horiontal_list_view);
        this.mDiskSpaceTextView = (TextView) this.mViewGroup.findViewById(C0965R.id.textview_disk_space);
        this.mUpdateLogLayout = (LinearLayout) this.mViewGroup.findViewById(C0965R.id.update_log_layout);
        this.mUpdateLogTextView = (TextView) this.mViewGroup.findViewById(C0965R.id.textview_update_log);
        this.mUpdateLogLayout.setOnClickListener(new C38773());
        this.bottom_status = (RelativeLayout) this.mViewGroup.findViewById(C0965R.id.bottom_status);
        this.bottom_status.setVisibility(8);
        this.mUnDownload = (TextView) this.mViewGroup.findViewById(C0965R.id.offline_data_undownload);
        this.mDownload = (TextView) this.mViewGroup.findViewById(C0965R.id.offline_data_download);
        this.mUnDownload.setOnClickListener(new C38784());
        this.mDownload.setOnClickListener(new C38795());
        this.mBackImg = (ImageView) this.mViewGroup.findViewById(C0965R.id.img_carmode_bar_back);
        this.mBackImg.setOnClickListener(getLeftOnClickListener());
    }

    private OnClickListener getLeftOnClickListener() {
        return new C38806();
    }

    private void updateViewWitchOrientation(int orientation) {
        if (mActivity != null) {
            this.mHorizontalListAdapter = null;
            this.mVerticalListView.setItemsCanFocus(true);
            this.mVerticalListAdapter = new CarModeOfflineDataListAdapter(mActivity, this.mDelegate, this);
            this.mVerticalListView.setAdapter(this.mVerticalListAdapter);
            this.mVerticalListView.setVisibility(0);
            this.mHorizontalListView.setVisibility(8);
            updateList();
        }
    }

    private void updateList() {
        if (this.mVerticalListAdapter != null) {
            this.mVerticalListAdapter.updateData();
            this.mVerticalListAdapter.notifyDataSetChanged();
        }
        if (this.mHorizontalListAdapter != null) {
            this.mHorizontalListAdapter.updateData();
            this.mHorizontalListAdapter.notifyDataSetChanged();
        }
        if (this.mVerticalListAdapter != null && !this.mVerticalListAdapter.getmIsUndownload().booleanValue()) {
            Message.obtain(this.mHandler, 5, 0, 0, null).sendToTarget();
        }
    }

    private void updateUserClickStatus(Boolean isUndownload) {
        if (this.mVerticalListAdapter != null) {
            this.mVerticalListAdapter.updateUserClickStatus(isUndownload);
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
        C1260i.e("OfflineData", "updateDiskSpaceTV totalDownloadSize:" + totalDownloadSize + "  diskSpace: " + diskSpace + "tempTotalDownloadSize:" + tempTotalDownloadSize + "  tempDiskSpace: " + StringUtils.ByteSizeToStringForLong(Long.valueOf(diskSpace)));
        this.mDiskSpaceTextView.setText(StyleManager.getString(C0965R.string.offline_data_disk_space, tempTotalDownloadSize, tempDiskSpace));
    }

    private void showDeleteCommonAlertDialog() {
        if (this.mDeleteCommonAlertDlg == null) {
            this.mDeleteCommonAlertDlg = new C1953c(C1157a.a()).b(C0965R.string.alert_notification).a(C0965R.string.del_common_data_notification).c(C0965R.string.alert_i_know);
        }
        showDialog(this.mDeleteCommonAlertDlg);
    }

    private void showDeleteAlertDialog(int msgId, final boolean isNewVer, final int provinceId) {
        this.mDeleteAlertDlg = new C1953c(C1157a.a()).b(C0965R.string.alert_notification).a(msgId).c(C0965R.string.alert_confirm).q().d(C0965R.string.alert_cancel);
        this.mDeleteAlertDlg.a(new C0672b() {
            public void onClick() {
                Message msg;
                C1307e.a().b(StyleManager.getString(C0965R.string.waiting_delete_data));
                if (isNewVer) {
                    msg = Message.obtain(CarModeOfflineDataFragment.this.mHandler, 4, provinceId, 0, null);
                } else {
                    msg = Message.obtain(CarModeOfflineDataFragment.this.mHandler, 2, provinceId, 0, null);
                }
                msg.sendToTarget();
            }
        });
        showDialog(this.mDeleteAlertDlg);
    }

    private void setOnItemClickedListener() {
        this.mOnItemClickListener = new OnListItemClickListener();
        this.mOnItemLongClickListener = new OnListItemLongClickListener();
        if (this.mVerticalListView != null) {
            this.mVerticalListView.setOnItemClickListener(this.mOnItemClickListener);
            this.mVerticalListView.setOnItemLongClickListener(this.mOnItemLongClickListener);
        }
        if (this.mHorizontalListView != null) {
            this.mHorizontalListView.setOnItemClickListener(this.mOnItemClickListener);
            this.mHorizontalListView.setOnItemLongClickListener(this.mOnItemLongClickListener);
        }
    }

    private void setNewDataStatus() {
        new Thread(getClass().getSimpleName()) {
            public void run() {
                boolean isNewData = BNOfflineDataManager.getInstance().isNewUpdateData();
                boolean isUpdating = BNOfflineDataManager.getInstance().isNewDataUpdating();
                UIModel.getInstance().setNewData(isNewData);
                UIModel.getInstance().setIsAutoUpdateDataStatus(isUpdating);
            }
        }.start();
    }

    private void handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C1307e.a().c();
                if (this.mDeleteThread != null) {
                    this.mDeleteThread = null;
                }
                updateList();
                setNewDataStatus();
                return;
            case 1:
                C1307e.a().c();
                if (this.mCancelUpdateThread != null) {
                    this.mCancelUpdateThread = null;
                }
                updateList();
                setNewDataStatus();
                return;
            case 2:
                if (this.mDeleteThread != null) {
                    this.mDeleteThread = null;
                }
                this.mDeleteThread = new DeleteThread(msg.arg1, this.mHandler);
                if (this.mDeleteThread != null && !this.mDeleteThread.isAlive()) {
                    this.mDeleteThread.start();
                    return;
                }
                return;
            case 4:
                if (this.mCancelUpdateThread != null) {
                    this.mCancelUpdateThread = null;
                }
                this.mCancelUpdateThread = new CancelUpdateThread(msg.arg1, this.mHandler);
                if (this.mCancelUpdateThread != null && !this.mCancelUpdateThread.isAlive()) {
                    this.mCancelUpdateThread.start();
                    return;
                }
                return;
            case 5:
                if (this.mCalDiskkSpaceThread != null) {
                    this.mCalDiskkSpaceThread = null;
                }
                this.mCalDiskkSpaceThread = new CalDiskkSpaceThread(this.mHandler);
                if (this.mCalDiskkSpaceThread != null && !this.mCalDiskkSpaceThread.isAlive()) {
                    this.mCalDiskkSpaceThread.start();
                    return;
                }
                return;
            case 6:
                if (this.mCalDiskkSpaceThread != null) {
                    this.mCalDiskkSpaceThread = null;
                }
                updateDiskSpaceTV(msg.getData().getLong("TotalDownloadSize"), msg.getData().getLong("DiskSpace"));
                return;
            default:
                return;
        }
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        initFocusChain(this.mViewGroup);
    }

    public void initFocusChain(View root) {
        if (this.mFocusArea == null) {
            this.mFocusArea = new C1443g(root, 2);
            this.mFocusArea.d(this.mBackImg).d(this.mUnDownload).d(this.mDownload);
            this.mFocusArea.b(this.mUnDownload);
        }
        if (this.mFocusList == null) {
            this.mFocusList = new C1438c(this.mVerticalListView, 4);
        }
        C1440d.a().b(new C1436a[]{this.mFocusArea, this.mFocusList});
        if (this.mVerticalListView == null || this.mVerticalListView.getAdapter().getCount() <= 0) {
            C1440d.a().h(this.mFocusArea);
            return;
        }
        C1440d.a().h(this.mFocusList);
        this.mFocusList.e();
    }

    public void driving() {
        C1260i.b("yftech", "CarModeOfflineDataFragment driving");
        dismissAllDialog();
        if (C1343b.a().b()) {
            back();
            back();
        } else {
            backTo(17, null);
        }
        C1342a.a().d();
    }

    public void stopDriving() {
    }

    private void dismissAllDialog() {
        if (this.mDeleteAlertDlg != null && this.mDeleteAlertDlg.isShown()) {
            this.mDeleteAlertDlg.d();
        }
        if (this.mDeleteCommonAlertDlg != null && this.mDeleteCommonAlertDlg.isShown()) {
            this.mDeleteCommonAlertDlg.d();
        }
    }
}
