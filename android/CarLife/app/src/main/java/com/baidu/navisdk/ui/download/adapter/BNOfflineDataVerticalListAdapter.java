package com.baidu.navisdk.ui.download.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.download.view.BNOfflineDataMergeLoadingView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.ArrayList;

public class BNOfflineDataVerticalListAdapter extends BNOfflineDataListAdapter {
    private static final String DOWN_LOAD_LINKAGE_FLAG = "down.load.linkage.flag";
    public boolean hasClickDataDownLoad = false;
    public boolean hasClickDataUpdate = false;
    private BNDialog linkageDialog = null;
    private Activity mActivity;
    private Context mContext;
    private BNOfflineDataAdapterListener mDelegate;
    private long mDiskSpace = 0;
    private ArrayList<OfflineDataInfo> mDownloadedItems;
    private Boolean mIsUndownload = Boolean.valueOf(true);
    private long mTotalDownloadSize = 0;
    private ArrayList<OfflineDataInfo> mUnDownloadItems;

    /* renamed from: com.baidu.navisdk.ui.download.adapter.BNOfflineDataVerticalListAdapter$5 */
    class C43065 implements OnNaviClickListener {
        C43065() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.download.adapter.BNOfflineDataVerticalListAdapter$9 */
    class C43109 implements OnClickListener {
        C43109() {
        }

        public void onClick(View v) {
            OfflineDataInfo model = (OfflineDataInfo) v.getTag();
            if (model != null) {
                BNOfflineDataVerticalListAdapter.this.mDelegate.itemDeleteButtomClicked(model);
            }
        }
    }

    public static class ViewHolder {
        RelativeLayout mInfoLayout;
        TextView mInfoTV;
        View mListDivider;
        View mListMargin;
        BNOfflineDataMergeLoadingView mMergeloadView;
        TextView mNameTV;
        ProgressBar mProgressBarDownloading;
        ProgressBar mProgressBarDownloadingNight;
        ProgressBar mProgressBarSuspend;
        ProgressBar mProgressBarSuspendNight;
        ImageView mTaskStatusIV;
    }

    public Boolean getmIsUndownload() {
        return this.mIsUndownload;
    }

    public long getmTotalDownloadSize() {
        return this.mTotalDownloadSize;
    }

    public long getmDiskSpace() {
        return this.mDiskSpace;
    }

    public BNOfflineDataVerticalListAdapter(Activity activity, BNOfflineDataAdapterListener delegate) {
        this.mContext = activity.getBaseContext();
        this.mDelegate = delegate;
        this.mActivity = activity;
        updateData();
    }

    public void updateData(boolean checkMapData) {
        this.mUnDownloadItems = BNOfflineDataManager.getInstance().getUndowloadList();
        this.mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
        if (checkMapData) {
            long start = System.currentTimeMillis();
            if (this.mDownloadedItems != null && this.mDownloadedItems.size() > 0) {
                int i = 0;
                while (i < this.mDownloadedItems.size()) {
                    if (((OfflineDataInfo) this.mDownloadedItems.get(i)).mTaskStatus != 10) {
                        LogUtil.m15791e("DataOffLine:", "start check " + ((OfflineDataInfo) this.mDownloadedItems.get(i)).mProvinceId);
                        if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(((OfflineDataInfo) this.mDownloadedItems.get(i)).mProvinceId)) {
                            ((OfflineDataInfo) this.mDownloadedItems.get(i)).mTaskStatus = 10;
                            ((OfflineDataInfo) this.mDownloadedItems.get(i)).isFakeUpdate = true;
                            ((OfflineDataInfo) this.mDownloadedItems.get(i)).mStrSize = "500";
                            ((OfflineDataInfo) this.mDownloadedItems.get(i)).mIsNewVer = true;
                        }
                        i++;
                    } else if (((OfflineDataInfo) this.mDownloadedItems.get(i)).mProvinceId == 0 && ((OfflineDataInfo) this.mDownloadedItems.get(i)).isFakeUpdate && BNOfflineDataManager.getInstance().checkBaseMapDataExit(((OfflineDataInfo) this.mDownloadedItems.get(i)).mProvinceId)) {
                        ((OfflineDataInfo) this.mDownloadedItems.get(i)).mTaskStatus = 12;
                        BNOfflineDataManager.getInstance().updateUpdateFinish(0, 100);
                    }
                }
            }
            LogUtil.m15791e("testDelay:", "updateData coast:" + (System.currentTimeMillis() - start));
            LogUtil.m15791e("OfflineData", "updateData  mUnDownloadItems: " + this.mUnDownloadItems.size() + "  mDownloadedItems: " + this.mDownloadedItems.size());
        }
    }

    public void updateData() {
        updateData(false);
    }

    public void updateDiskSpace() {
        this.mTotalDownloadSize = 0;
        this.mDiskSpace = 0;
        int downloadSize = this.mDownloadedItems.size();
        int unDownloadSize = this.mUnDownloadItems.size();
        int i = 0;
        while (i < downloadSize) {
            try {
                OfflineDataInfo mode = (OfflineDataInfo) this.mDownloadedItems.get(i);
                int tempDownloadUpSize = (int) (((double) mode.mUpSize) * (((double) mode.mUpProgressBy10) / 1000.0d));
                this.mTotalDownloadSize += (long) mode.mSize;
                this.mTotalDownloadSize += (long) tempDownloadUpSize;
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < unDownloadSize; j++) {
            mode = (OfflineDataInfo) this.mUnDownloadItems.get(j);
            this.mTotalDownloadSize += (long) ((int) (((double) mode.mSize) * (((double) mode.mProgressBy10) / 1000.0d)));
        }
        this.mDiskSpace = SDCardUtils.getSdcardSpace();
        LogUtil.m15791e("OfflineData", "mDiskSpace: " + this.mDiskSpace + "  mTotalDownloadSize: " + this.mTotalDownloadSize);
    }

    public void updateUserClickStatus(Boolean isUndownload) {
        this.mIsUndownload = isUndownload;
    }

    public void checkToStartDownloadRequest(OfflineDataInfo taskModel, boolean downloadCommonFirst) {
        int state = -1;
        if (taskModel != null) {
            state = SDCardUtils.handleOfflinePathError((long) (taskModel.mSize - ((int) (((double) taskModel.mSize) * (((double) taskModel.mProgress) / 100.0d)))), true);
        }
        if (state == 1) {
            try {
                new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_od_sdcard_storage_deficiency)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm)).show();
                return;
            } catch (Exception e) {
                return;
            }
        }
        startCheckNetStatus(taskModel.mProvinceId, downloadCommonFirst);
    }

    public void startCheckNetStatus(final int provinceId, final boolean downloadCommonFirst) {
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_od_network_unconnected));
            BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 1);
            BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 0);
        } else if (!NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            try {
                new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_od_is_wifi_notification)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                        if (provinceId == 0) {
                            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus1", null) {
                                protected String execute() {
                                    BNOfflineDataManager.getInstance().startDownloadRequest(0);
                                    try {
                                        Thread.sleep(300);
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new BNWorkerConfig(101, 0));
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                            }
                        } else if (BNOfflineDataVerticalListAdapter.this.shouldShowLinkageDialog(BNOfflineDataVerticalListAdapter.this.mContext, provinceId)) {
                            BNOfflineDataVerticalListAdapter.this.showLinkageDialog(BNOfflineDataVerticalListAdapter.this.mActivity, downloadCommonFirst, provinceId, false);
                        } else {
                            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                            if (downloadCommonFirst) {
                                BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus2", null) {
                                    protected String execute() {
                                        BNOfflineDataManager.getInstance().startDownloadRequest(0);
                                        try {
                                            Thread.sleep(300);
                                        } catch (Exception e) {
                                        }
                                        BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                                        return null;
                                    }
                                }, new BNWorkerConfig(101, 0));
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                                }
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(provinceId)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(provinceId);
                                    return;
                                }
                                return;
                            }
                            BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                            }
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(provinceId)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(provinceId);
                            }
                        }
                    }
                }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_cancel)).setOnFirstBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 1);
                        BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 0);
                    }
                }).show();
            } catch (Exception e) {
                BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 1);
                BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 0);
            }
        } else if (provinceId == 0) {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus1", null) {
                protected String execute() {
                    BNOfflineDataManager.getInstance().startDownloadRequest(0);
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                    }
                    return null;
                }
            }, new BNWorkerConfig(101, 0));
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
            }
        } else if (shouldShowLinkageDialog(this.mContext, provinceId)) {
            showLinkageDialog(this.mActivity, downloadCommonFirst, provinceId, false);
        } else {
            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
            if (downloadCommonFirst) {
                BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus2", null) {
                    protected String execute() {
                        BNOfflineDataManager.getInstance().startDownloadRequest(0);
                        try {
                            Thread.sleep(300);
                        } catch (Exception e) {
                        }
                        BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                        return null;
                    }
                }, new BNWorkerConfig(101, 0));
                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                }
                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(provinceId)) {
                    BNOfflineDataManager.getInstance().startDownBaseMapData(provinceId);
                    return;
                }
                return;
            }
            BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
            }
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(provinceId)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(provinceId);
            }
        }
    }

    public void chooseDownloadStrategy(final OfflineDataInfo model, final boolean downloadCommonFirst) {
        int state = -1;
        if (model != null) {
            state = SDCardUtils.handleOfflinePathError((long) (model.mSize - ((int) (((double) model.mSize) * (((double) model.mProgress) / 100.0d)))), true);
        }
        if (state == 1) {
            try {
                new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_od_sdcard_storage_deficiency)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm)).show();
            } catch (Exception e) {
            }
        } else if (state != 0) {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_od_sdcard_error));
        } else if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_od_network_unconnected));
        } else if (!NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            try {
                new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_od_is_wifi_notification)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        if (model.mTaskStatus == 4 || !BNOfflineDataVerticalListAdapter.this.shouldShowLinkageDialog(BNOfflineDataVerticalListAdapter.this.mContext, model.mProvinceId)) {
                            if (downloadCommonFirst) {
                                BNOfflineDataManager.getInstance().downloadProvinceData(0);
                                if (!(model.mTaskStatus == 4 || BNOfflineDataManager.getInstance().checkBaseMapDataExit(0))) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                                }
                            }
                            BNOfflineDataManager.getInstance().downloadProvinceData(model.mProvinceId);
                            return;
                        }
                        BNOfflineDataVerticalListAdapter.this.showLinkageDialog(BNOfflineDataVerticalListAdapter.this.mActivity, downloadCommonFirst, model.mProvinceId, false, true);
                    }
                }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_cancel)).setOnFirstBtnClickListener(new C43065()).show();
            } catch (Exception e2) {
            }
        } else if (model.mTaskStatus == 4 || !shouldShowLinkageDialog(this.mContext, model.mProvinceId)) {
            if (downloadCommonFirst) {
                BNOfflineDataManager.getInstance().downloadProvinceData(0);
                if (!(model.mTaskStatus == 4 || BNOfflineDataManager.getInstance().checkBaseMapDataExit(0))) {
                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                }
            }
            BNOfflineDataManager.getInstance().downloadProvinceData(model.mProvinceId);
        } else {
            showLinkageDialog(this.mActivity, downloadCommonFirst, model.mProvinceId, false, true);
        }
    }

    public void chooseUpdateStrategy(final OfflineDataInfo model) {
        int state = -1;
        if (model != null) {
            state = SDCardUtils.handleOfflinePathError((long) (model.mUpSize - ((int) (((double) model.mUpSize) * (((double) model.mUpProgress) / 100.0d)))), true);
        }
        if (state == 1) {
            try {
                new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_od_sdcard_storage_deficiency)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm)).show();
            } catch (Exception e) {
            }
            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 1);
            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 0);
        } else if (state != 0) {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_od_sdcard_error));
            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 1);
            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 0);
        } else if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_od_network_unconnected));
            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 1);
            BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 0);
        } else if (!NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            try {
                new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_od_is_wifi_notification)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        if (model.mProvinceId == 0) {
                            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                            BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                            }
                        } else if (BNOfflineDataVerticalListAdapter.this.shouldShowLinkageDialog(BNOfflineDataVerticalListAdapter.this.mContext, model.mProvinceId)) {
                            BNOfflineDataVerticalListAdapter.this.showLinkageDialog(BNOfflineDataVerticalListAdapter.this.mActivity, false, model.mProvinceId, true);
                        } else {
                            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                            BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                            }
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(model.mProvinceId)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(model.mProvinceId);
                            }
                        }
                    }
                }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_cancel)).setOnFirstBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 1);
                        BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 0);
                    }
                }).show();
            } catch (Exception e2) {
                BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 1);
                BNOfflineDataManager.getInstance().memoryUserOper(model.mProvinceId, false, 0);
            }
        } else if (shouldShowLinkageDialog(this.mContext, model.mProvinceId)) {
            showLinkageDialog(this.mActivity, false, model.mProvinceId, true);
        } else {
            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
            BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
            }
            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(model.mProvinceId)) {
                BNOfflineDataManager.getInstance().startDownBaseMapData(model.mProvinceId);
            }
        }
    }

    public OfflineDataInfo getDownloadedListModelByPosition(int position) {
        if (this.mUnDownloadItems == null || this.mDownloadedItems == null) {
            return null;
        }
        if (this.mIsUndownload.booleanValue()) {
            if (position < 0 || position >= this.mUnDownloadItems.size()) {
                return null;
            }
            return (OfflineDataInfo) this.mUnDownloadItems.get(position);
        } else if (position < 0 || position >= this.mDownloadedItems.size()) {
            return null;
        } else {
            return (OfflineDataInfo) this.mDownloadedItems.get(position);
        }
    }

    public int getCount() {
        return this.mIsUndownload.booleanValue() ? this.mUnDownloadItems.size() : this.mDownloadedItems.size();
    }

    public Object getItem(int position) {
        if (this.mUnDownloadItems == null || this.mDownloadedItems == null) {
            return null;
        }
        if (this.mIsUndownload.booleanValue()) {
            if (position < 0 || position >= this.mUnDownloadItems.size()) {
                return null;
            }
            return (OfflineDataInfo) this.mUnDownloadItems.get(position);
        } else if (position < 0 || position >= this.mDownloadedItems.size()) {
            return null;
        } else {
            return (OfflineDataInfo) this.mDownloadedItems.get(position);
        }
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public boolean isEnabled(int position) {
        return true;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        OfflineDataInfo model = (OfflineDataInfo) getItem(position);
        if (convertView == null || model == null) {
            convertView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_offline_data_vertical_list_item, null);
            if (convertView == null) {
                try {
                    if (this.mActivity != null) {
                        return new View(this.mActivity);
                    }
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
            holder = new ViewHolder();
            holder.mInfoLayout = (RelativeLayout) convertView.findViewById(C4048R.id.info_relativelayout);
            holder.mNameTV = (TextView) convertView.findViewById(C4048R.id.textview_name);
            holder.mInfoTV = (TextView) convertView.findViewById(C4048R.id.textview_info);
            holder.mProgressBarDownloading = (ProgressBar) convertView.findViewById(C4048R.id.progress_bar_downloading);
            holder.mProgressBarSuspend = (ProgressBar) convertView.findViewById(C4048R.id.progress_bar_suspend);
            holder.mProgressBarDownloadingNight = (ProgressBar) convertView.findViewById(C4048R.id.progress_bar_downloading_night);
            holder.mProgressBarSuspendNight = (ProgressBar) convertView.findViewById(C4048R.id.progress_bar_suspend_night);
            holder.mTaskStatusIV = (ImageView) convertView.findViewById(C4048R.id.imageview_btn_status);
            holder.mListDivider = convertView.findViewById(C4048R.id.list_item_divider);
            holder.mListMargin = convertView.findViewById(C4048R.id.list_item_margin);
            holder.mMergeloadView = (BNOfflineDataMergeLoadingView) convertView.findViewById(C4048R.id.merge_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        boolean isShowMargin = true;
        if (model != null && holder != null) {
            model.formatStatusTips();
            LogUtil.m15791e("OfflineData", "model.mName: " + model.mName + "  model.mStatusTips: " + model.mStatusTips + "  model.mTaskStatus111: " + model.mTaskStatus + "  model.mDownloadRatio: " + model.mDownloadRatio);
            holder.mInfoLayout.setVisibility(0);
            holder.mInfoTV.setVisibility(0);
            holder.mNameTV.setText(model.mName);
            holder.mNameTV.setTextColor(-13421773);
            holder.mInfoTV.setText(model.mStatusTips);
            holder.mInfoTV.setTextColor(model.mStatusColor);
            holder.mProgressBarDownloading.setVisibility(8);
            holder.mProgressBarDownloadingNight.setVisibility(8);
            holder.mProgressBarSuspend.setVisibility(8);
            holder.mProgressBarSuspendNight.setVisibility(8);
            holder.mMergeloadView.hideLoading();
            holder.mTaskStatusIV.setTag(model);
            holder.mTaskStatusIV.setOnClickListener(new C43109());
            if (model.mTaskStatus == 5 || model.mTaskStatus == 1 || model.mTaskStatus == 10) {
                isShowMargin = false;
            }
            switch (model.mTaskStatus) {
                case 1:
                    holder.mListDivider.setVisibility(0);
                    holder.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.offline_data_status_download));
                    break;
                case 2:
                    holder.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.offline_data_status_suspend_download));
                    if (1 != null) {
                        holder.mProgressBarDownloading.setProgress(model.mProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    break;
                case 3:
                    holder.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.offline_data_status_suspend_download));
                    if (1 != null) {
                        holder.mProgressBarDownloading.setProgress(model.mProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    break;
                case 4:
                case 6:
                case 8:
                case 9:
                    if (model.mIsNewVer) {
                        if (1 != null) {
                            holder.mProgressBarSuspend.setProgress(model.mUpProgress);
                            holder.mProgressBarSuspend.setVisibility(0);
                        } else {
                            holder.mProgressBarSuspendNight.setProgress(model.mUpProgress);
                            holder.mProgressBarSuspendNight.setVisibility(0);
                        }
                    } else if (1 != null) {
                        holder.mProgressBarSuspend.setProgress(model.mProgress);
                        holder.mProgressBarSuspend.setVisibility(0);
                    } else {
                        holder.mProgressBarSuspendNight.setProgress(model.mProgress);
                        holder.mProgressBarSuspendNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    holder.mTaskStatusIV.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.offline_data_status_continue_download));
                    break;
                case 5:
                    holder.mListDivider.setVisibility(0);
                    break;
                case 10:
                    holder.mListDivider.setVisibility(0);
                    break;
                case 11:
                case 12:
                    if (1 != null) {
                        holder.mProgressBarDownloading.setProgress(model.mUpProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mUpProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    break;
                case 13:
                    if (1 != null) {
                        holder.mProgressBarSuspend.setProgress(model.mUpProgress);
                        holder.mProgressBarSuspend.setVisibility(0);
                    } else {
                        holder.mProgressBarSuspendNight.setProgress(model.mUpProgress);
                        holder.mProgressBarSuspendNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    break;
                case 16:
                    holder.mMergeloadView.showLoading();
                    break;
                case 17:
                    holder.mListDivider.setVisibility(0);
                    break;
                case 19:
                    holder.mListDivider.setVisibility(0);
                    break;
            }
        } else if (holder != null) {
            holder.mListDivider.setVisibility(8);
            holder.mInfoLayout.setVisibility(8);
            holder.mListMargin.setVisibility(8);
        }
        if (!(convertView == null || holder == null)) {
            setVerticalListBackground(position, convertView, holder, isShowMargin);
        }
        if (!(holder == null || holder.mListDivider == null)) {
            try {
                holder.mListDivider.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.divide_list));
            } catch (Exception e2) {
            }
        }
        return convertView;
    }

    private void setVerticalListBackground(int position, View convertView, ViewHolder holder, boolean isShowMargin) {
        if (convertView != null) {
            convertView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_color_od_bg_list_transparent));
            if (this.mIsUndownload.booleanValue()) {
                if (position < this.mUnDownloadItems.size()) {
                    convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.common_list_bg_selector));
                    holder.mListMargin.setVisibility(8);
                } else if (position >= this.mUnDownloadItems.size()) {
                    convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.common_list_bg_selector));
                    if (isShowMargin) {
                        holder.mListMargin.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                }
                convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.common_list_bg_selector));
                holder.mTaskStatusIV.setVisibility(0);
                holder.mListMargin.setVisibility(8);
                return;
            }
            if (position < this.mDownloadedItems.size()) {
                convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.common_list_bg_selector));
                holder.mListMargin.setVisibility(8);
            } else if (position >= this.mDownloadedItems.size()) {
                convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.common_list_bg_selector));
                if (isShowMargin) {
                    holder.mListMargin.setVisibility(0);
                }
                holder.mListDivider.setVisibility(8);
            }
            holder.mTaskStatusIV.setVisibility(8);
        }
    }

    private void showLinkageDialog(Activity mActivity, boolean downloadCommonFirst, int provinceId, boolean isUpdate) {
        showLinkageDialog(mActivity, downloadCommonFirst, provinceId, isUpdate, false);
    }

    private void showLinkageDialog(Activity mActivity, boolean downloadCommonFirst, final int provinceId, boolean isUpdate, boolean isContinue) {
        if (mActivity != null) {
            if (this.linkageDialog != null) {
                dimissLinkageDialog();
            }
            try {
                final boolean z = isContinue;
                final boolean z2 = downloadCommonFirst;
                final int i = provinceId;
                final boolean z3 = isUpdate;
                this.linkageDialog = new BNDialog(mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_offline_data_linkage_notification)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_offline_data_start_down_confirm)).setOnSecondBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        if (z) {
                            if (z2) {
                                BNOfflineDataManager.getInstance().downloadProvinceData(0);
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                                }
                            }
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(i)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(i);
                            }
                            BNOfflineDataManager.getInstance().downloadProvinceData(i);
                        } else if (z3) {
                            boolean flag = false;
                            ArrayList<OfflineDataInfo> mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
                            if (mDownloadedItems != null && mDownloadedItems.size() > 0) {
                                int i = 0;
                                while (i < mDownloadedItems.size()) {
                                    if (((OfflineDataInfo) mDownloadedItems.get(i)).mTaskStatus == 10 && ((OfflineDataInfo) mDownloadedItems.get(i)).mProvinceId == i && ((OfflineDataInfo) mDownloadedItems.get(i)).isFakeUpdate) {
                                        ((OfflineDataInfo) mDownloadedItems.get(i)).mTaskStatus = 12;
                                        BNOfflineDataManager.getInstance().sendUpdateSucessMsg(i);
                                        flag = true;
                                        break;
                                    }
                                    i++;
                                }
                            }
                            if (!flag) {
                                BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                                BNOfflineDataManager.getInstance().updateProvinceData(i);
                            }
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                            }
                            if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(i)) {
                                BNOfflineDataManager.getInstance().startDownBaseMapData(i);
                            }
                        } else {
                            BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                            if (z2) {
                                BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "_startCheckNetStatus2", null) {
                                    protected String execute() {
                                        BNOfflineDataManager.getInstance().startDownloadRequest(0);
                                        try {
                                            Thread.sleep(300);
                                        } catch (Exception e) {
                                        }
                                        BNOfflineDataManager.getInstance().startDownloadRequest(i);
                                        return null;
                                    }
                                }, new BNWorkerConfig(101, 0));
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                                }
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(i)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(i);
                                }
                            } else {
                                BNOfflineDataManager.getInstance().startDownloadRequest(i);
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(0)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(0);
                                }
                                if (!BNOfflineDataManager.getInstance().checkBaseMapDataExit(i)) {
                                    BNOfflineDataManager.getInstance().startDownBaseMapData(i);
                                }
                            }
                        }
                        BNOfflineDataVerticalListAdapter.this.dimissLinkageDialog();
                    }
                }).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_cancel)).setOnFirstBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        BNOfflineDataVerticalListAdapter.this.dimissLinkageDialog();
                        BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 1);
                        BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 0);
                    }
                });
                hasShowLinkageDialog(mActivity);
                this.linkageDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
                BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 1);
                BNOfflineDataManager.getInstance().memoryUserOper(provinceId, false, 0);
            }
        }
    }

    public void dimissLinkageDialog() {
        if (this.linkageDialog != null) {
            this.linkageDialog.dismiss();
            this.linkageDialog = null;
        }
    }

    private boolean shouldShowLinkageDialog(Context mContext, int provinceId) {
        return !BNOfflineDataManager.getInstance().checkBaseMapDataExit(provinceId);
    }

    private void hasShowLinkageDialog(Context mContext) {
        PreferenceHelper.getInstance(mContext).putBoolean(DOWN_LOAD_LINKAGE_FLAG, true);
    }
}
