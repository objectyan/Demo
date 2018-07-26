package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.OfflineDataMergeLoadingView;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.util.ArrayList;

public class OfflineDataVerticalListAdapter extends OfflineDataListAdapter {
    private Activity mActivity;
    private Context mContext;
    private OfflineDataAdapterListener mDelegate;
    private long mDiskSpace = 0;
    private ArrayList<OfflineDataInfo> mDownloadedItems;
    private Boolean mIsUndownload = Boolean.valueOf(true);
    private long mTotalDownloadSize = 0;
    private ArrayList<OfflineDataInfo> mUnDownloadItems;

    /* renamed from: com.baidu.navi.adapter.OfflineDataVerticalListAdapter$2 */
    class C36572 implements OnNaviClickListener {
        C36572() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.adapter.OfflineDataVerticalListAdapter$4 */
    class C36604 implements OnNaviClickListener {
        C36604() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.adapter.OfflineDataVerticalListAdapter$6 */
    class C36626 implements OnNaviClickListener {
        C36626() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.adapter.OfflineDataVerticalListAdapter$8 */
    class C36648 implements OnClickListener {
        C36648() {
        }

        public void onClick(View v) {
            OfflineDataInfo model = (OfflineDataInfo) v.getTag();
            if (!ForbidDaulClickUtils.isFastDoubleClick() && model != null) {
                OfflineDataVerticalListAdapter.this.mDelegate.itemDeleteButtomClicked(model);
            }
        }
    }

    public static class ViewHolder {
        RelativeLayout mInfoLayout;
        TextView mInfoTV;
        View mListDivider;
        View mListMargin;
        OfflineDataMergeLoadingView mMergeloadView;
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

    public OfflineDataVerticalListAdapter(Activity activity, OfflineDataAdapterListener delegate) {
        this.mContext = activity.getBaseContext();
        this.mDelegate = delegate;
        this.mActivity = activity;
        updateData();
    }

    public void updateData() {
        this.mUnDownloadItems = BNOfflineDataManager.getInstance().getUndowloadList();
        this.mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
        LogUtil.m15791e("OfflineData", "updateData  mUnDownloadItems: " + this.mUnDownloadItems.size() + "  mDownloadedItems: " + this.mDownloadedItems.size());
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
            state = SDCardUtils.handleSdcardError((long) (taskModel.mSize - ((int) (((double) taskModel.mSize) * (((double) taskModel.mProgress) / 100.0d)))), true);
        }
        if (state == 1) {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_sdcard_storage_deficiency).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).show();
        } else {
            startCheckNetStatus(taskModel.mProvinceId, downloadCommonFirst);
        }
    }

    public void startCheckNetStatus(final int provinceId, final boolean downloadCommonFirst) {
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.nsdk_string_od_network_unconnected);
        } else if (!NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_is_wifi_notification).setSecondBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                    if (downloadCommonFirst) {
                        new Thread(getClass().getSimpleName() + "_startCheckNetStatus2") {
                            public void run() {
                                BNOfflineDataManager.getInstance().startDownloadRequest(0);
                                try {
                                    C36581.sleep(300);
                                } catch (Exception e) {
                                }
                                BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                            }
                        }.start();
                    } else {
                        BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                    }
                }
            }).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_cancel).setOnFirstBtnClickListener(new C36572()).show();
        } else if (downloadCommonFirst) {
            new Thread(getClass().getSimpleName() + "_startCheckNetStatus1") {
                public void run() {
                    BNOfflineDataManager.getInstance().startDownloadRequest(0);
                    try {
                        C36561.sleep(300);
                    } catch (Exception e) {
                    }
                    BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                }
            }.start();
        } else {
            BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
        }
    }

    public void chooseDownloadStrategy(final OfflineDataInfo model, final boolean downloadCommonFirst) {
        int state = -1;
        if (model != null) {
            state = SDCardUtils.handleSdcardError((long) (model.mSize - ((int) (((double) model.mSize) * (((double) model.mProgress) / 100.0d)))), true);
        }
        if (state == 1) {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_sdcard_storage_deficiency).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).show();
        } else if (state != 0) {
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.nsdk_string_od_sdcard_error);
        } else if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.nsdk_string_od_network_unconnected);
        } else if (NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            if (downloadCommonFirst) {
                BNOfflineDataManager.getInstance().downloadProvinceData(0);
            }
            BNOfflineDataManager.getInstance().downloadProvinceData(model.mProvinceId);
        } else {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_is_wifi_notification).setSecondBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                    if (downloadCommonFirst) {
                        BNOfflineDataManager.getInstance().downloadProvinceData(0);
                    }
                    BNOfflineDataManager.getInstance().downloadProvinceData(model.mProvinceId);
                }
            }).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_cancel).setOnFirstBtnClickListener(new C36604()).show();
        }
    }

    public void chooseUpdateStrategy(final OfflineDataInfo model) {
        int state = -1;
        if (model != null) {
            state = SDCardUtils.handleSdcardError((long) (model.mUpSize - ((int) (((double) model.mUpSize) * (((double) model.mUpProgress) / 100.0d)))), true);
        }
        if (state == 1) {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_sdcard_storage_deficiency).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).show();
        } else if (state != 0) {
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.nsdk_string_od_sdcard_error);
        } else if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.nsdk_string_od_network_unconnected);
        } else if (NetworkUtils.isTypeNetworkAvailable(this.mContext, 1)) {
            BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
        } else {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_is_wifi_notification).setSecondBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    BNOfflineDataManager.getInstance().setIsClickDownloadOnMobile(Boolean.valueOf(true));
                    BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
                }
            }).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_cancel).setOnFirstBtnClickListener(new C36626()).show();
        }
    }

    public OfflineDataInfo getDownloadedListModelByPosition(int position) {
        OfflineDataInfo currentModel = null;
        if (!(this.mUnDownloadItems == null || this.mDownloadedItems == null)) {
            if (this.mIsUndownload.booleanValue()) {
                if (this.mUnDownloadItems == null) {
                    return null;
                }
                if (position < 0 || position >= this.mUnDownloadItems.size()) {
                    return null;
                }
                currentModel = (OfflineDataInfo) this.mUnDownloadItems.get(position);
            } else if (this.mDownloadedItems == null) {
                return null;
            } else {
                if (position < 0 || position >= this.mDownloadedItems.size()) {
                    return null;
                }
                currentModel = (OfflineDataInfo) this.mDownloadedItems.get(position);
            }
        }
        return currentModel;
    }

    public int getCount() {
        return this.mIsUndownload.booleanValue() ? this.mUnDownloadItems.size() : this.mDownloadedItems.size();
    }

    public Object getItem(int position) {
        OfflineDataInfo currentModel = null;
        if (!(this.mUnDownloadItems == null || this.mDownloadedItems == null)) {
            if (this.mIsUndownload.booleanValue()) {
                if (this.mUnDownloadItems == null) {
                    return null;
                }
                if (position < 0 || position >= this.mUnDownloadItems.size()) {
                    return null;
                }
                currentModel = (OfflineDataInfo) this.mUnDownloadItems.get(position);
            } else if (this.mDownloadedItems == null) {
                return null;
            } else {
                if (position < 0 || position >= this.mDownloadedItems.size()) {
                    return null;
                }
                currentModel = (OfflineDataInfo) this.mDownloadedItems.get(position);
            }
        }
        return currentModel;
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
            convertView = LayoutInflater.from(this.mContext).inflate(C0965R.layout.nsdk_layout_od_offline_data_vertical_list_item, null);
            holder = new ViewHolder();
            holder.mInfoLayout = (RelativeLayout) convertView.findViewById(C0965R.id.info_relativelayout);
            holder.mNameTV = (TextView) convertView.findViewById(C0965R.id.textview_name);
            holder.mInfoTV = (TextView) convertView.findViewById(C0965R.id.textview_info);
            holder.mProgressBarDownloading = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_downloading);
            holder.mProgressBarSuspend = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_suspend);
            holder.mProgressBarDownloadingNight = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_downloading_night);
            holder.mProgressBarSuspendNight = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_suspend_night);
            holder.mTaskStatusIV = (ImageView) convertView.findViewById(C0965R.id.imageview_btn_status);
            holder.mListDivider = convertView.findViewById(C0965R.id.list_item_divider);
            holder.mListMargin = convertView.findViewById(C0965R.id.list_item_margin);
            holder.mMergeloadView = (OfflineDataMergeLoadingView) convertView.findViewById(C0965R.id.merge_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        boolean isShowMargin = true;
        if (model != null) {
            model.formatStatusTips();
            LogUtil.m15791e("OfflineData", "model.mName: " + model.mName + "  model.mStatusTips: " + model.mStatusTips + "  model.mTaskStatus111: " + model.mTaskStatus + "  model.mDownloadRatio: " + model.mDownloadRatio);
            holder.mInfoLayout.setVisibility(0);
            holder.mInfoTV.setVisibility(0);
            holder.mNameTV.setText(model.mName);
            holder.mNameTV.setTextColor(StyleManager.getDayStyle() ? -13421773 : -6906938);
            holder.mInfoTV.setText(model.mStatusTips);
            holder.mInfoTV.setTextColor(model.mStatusColor);
            holder.mProgressBarDownloading.setVisibility(8);
            holder.mProgressBarDownloadingNight.setVisibility(8);
            holder.mProgressBarSuspend.setVisibility(8);
            holder.mProgressBarSuspendNight.setVisibility(8);
            boolean isDayStyle = StyleManager.getDayStyle();
            holder.mMergeloadView.hideLoading();
            holder.mTaskStatusIV.setTag(model);
            holder.mTaskStatusIV.setOnClickListener(new C36648());
            if (model.mTaskStatus == 5 || model.mTaskStatus == 1 || model.mTaskStatus == 10) {
                isShowMargin = false;
            }
            switch (model.mTaskStatus) {
                case 1:
                    holder.mListDivider.setVisibility(0);
                    holder.mTaskStatusIV.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.offline_data_status_download));
                    break;
                case 2:
                    holder.mTaskStatusIV.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.offline_data_status_suspend_download));
                    if (isDayStyle) {
                        holder.mProgressBarDownloading.setProgress(model.mProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    break;
                case 3:
                    holder.mTaskStatusIV.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.offline_data_status_suspend_download));
                    if (isDayStyle) {
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
                        if (isDayStyle) {
                            holder.mProgressBarSuspend.setProgress(model.mUpProgress);
                            holder.mProgressBarSuspend.setVisibility(0);
                        } else {
                            holder.mProgressBarSuspendNight.setProgress(model.mUpProgress);
                            holder.mProgressBarSuspendNight.setVisibility(0);
                        }
                    } else if (isDayStyle) {
                        holder.mProgressBarSuspend.setProgress(model.mProgress);
                        holder.mProgressBarSuspend.setVisibility(0);
                    } else {
                        holder.mProgressBarSuspendNight.setProgress(model.mProgress);
                        holder.mProgressBarSuspendNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    holder.mTaskStatusIV.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.offline_data_status_continue_download));
                    break;
                case 5:
                    holder.mListDivider.setVisibility(0);
                    break;
                case 10:
                    holder.mListDivider.setVisibility(0);
                    break;
                case 11:
                case 12:
                    if (isDayStyle) {
                        holder.mProgressBarDownloading.setProgress(model.mUpProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mUpProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mListDivider.setVisibility(8);
                    break;
                case 13:
                    if (isDayStyle) {
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
        }
        holder.mListDivider.setVisibility(8);
        holder.mInfoLayout.setVisibility(8);
        holder.mListMargin.setVisibility(8);
        setVerticalListBackground(position, convertView, holder, isShowMargin);
        holder.mListDivider.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
        return convertView;
    }

    private void setVerticalListBackground(int position, View convertView, ViewHolder holder, boolean isShowMargin) {
        convertView.setBackgroundColor(this.mActivity.getResources().getColor(C0965R.color.nsdk_color_od_bg_list_transparent));
        if (this.mIsUndownload.booleanValue()) {
            if (position < this.mUnDownloadItems.size()) {
                convertView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
                holder.mListMargin.setVisibility(8);
            } else if (position >= this.mUnDownloadItems.size()) {
                convertView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
                if (isShowMargin) {
                    holder.mListMargin.setVisibility(0);
                }
                holder.mListDivider.setVisibility(8);
            }
            convertView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
            holder.mTaskStatusIV.setVisibility(0);
            holder.mListMargin.setVisibility(8);
            return;
        }
        if (position < this.mDownloadedItems.size()) {
            convertView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
            holder.mListMargin.setVisibility(8);
        } else if (position >= this.mDownloadedItems.size()) {
            convertView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
            if (isShowMargin) {
                holder.mListMargin.setVisibility(0);
            }
            holder.mListDivider.setVisibility(8);
        }
        holder.mTaskStatusIV.setVisibility(8);
    }
}
