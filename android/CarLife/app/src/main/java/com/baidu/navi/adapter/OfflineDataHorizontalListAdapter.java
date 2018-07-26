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
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.util.ArrayList;

public class OfflineDataHorizontalListAdapter extends OfflineDataListAdapter {
    private Activity mActivity;
    private Context mContext;
    private OfflineDataAdapterListener mDelegate;
    private long mDiskSpace = 0;
    private ArrayList<OfflineDataInfo> mDownloadedItems;
    private long mTotalDownloadSize = 0;
    private ArrayList<OfflineDataInfo> mUnDownloadItems;

    /* renamed from: com.baidu.navi.adapter.OfflineDataHorizontalListAdapter$2 */
    class C36482 implements OnNaviClickListener {
        C36482() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.adapter.OfflineDataHorizontalListAdapter$4 */
    class C36514 implements OnNaviClickListener {
        C36514() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.adapter.OfflineDataHorizontalListAdapter$6 */
    class C36536 implements OnNaviClickListener {
        C36536() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.adapter.OfflineDataHorizontalListAdapter$8 */
    class C36558 implements OnClickListener {
        C36558() {
        }

        public void onClick(View v) {
            OfflineDataInfo model = (OfflineDataInfo) v.getTag();
            if (!ForbidDaulClickUtils.isFastDoubleClick() && model != null) {
                OfflineDataHorizontalListAdapter.this.mDelegate.itemDeleteButtomClicked(model);
            }
        }
    }

    public static class ViewHolder {
        ImageView mBtnDeleteIV;
        TextView mCardStatusTV;
        ImageView mDownloadIV;
        RelativeLayout mInfoLayout;
        TextView mInfoTV;
        TextView mNameTV;
        ProgressBar mProgressBarDownloading;
        ProgressBar mProgressBarDownloadingNight;
        ProgressBar mProgressBarSuspend;
        ProgressBar mProgressBarSuspendNight;
    }

    public long getmTotalDownloadSize() {
        return this.mTotalDownloadSize;
    }

    public long getmDiskSpace() {
        return this.mDiskSpace;
    }

    public OfflineDataHorizontalListAdapter(Activity activity, OfflineDataAdapterListener delegate) {
        this.mContext = activity.getBaseContext();
        this.mDelegate = delegate;
        this.mActivity = activity;
        updateData();
    }

    public void updateData() {
        this.mUnDownloadItems = BNOfflineDataManager.getInstance().getUndowloadList();
        this.mDownloadedItems = BNOfflineDataManager.getInstance().getDownloadedList();
    }

    public void updateDiskSpace() {
        this.mTotalDownloadSize = 0;
        this.mDiskSpace = 0;
        int downloadSize = this.mDownloadedItems.size();
        int unDownloadSize = this.mUnDownloadItems.size();
        for (int i = 0; i < downloadSize; i++) {
            OfflineDataInfo mode = (OfflineDataInfo) this.mDownloadedItems.get(i);
            int tempDownloadUpSize = (int) (((double) mode.mUpSize) * (((double) mode.mUpProgressBy10) / 1000.0d));
            this.mTotalDownloadSize += (long) mode.mSize;
            this.mTotalDownloadSize += (long) tempDownloadUpSize;
        }
        for (int j = 0; j < unDownloadSize; j++) {
            mode = (OfflineDataInfo) this.mUnDownloadItems.get(j);
            this.mTotalDownloadSize += (long) ((int) (((double) mode.mSize) * (((double) mode.mProgressBy10) / 1000.0d)));
        }
        this.mDiskSpace = SDCardUtils.getSdcardSpace();
        LogUtil.m15791e("OfflineData", "mDiskSpace: " + this.mDiskSpace + "  mTotalDownloadSize: " + this.mTotalDownloadSize);
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
        if (NetworkUtils.mConnectState == 0) {
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.nsdk_string_od_network_unconnected);
        } else if (NetworkUtils.mWifiState != 1) {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_is_wifi_notification).setSecondBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    if (downloadCommonFirst) {
                        new Thread(getClass().getSimpleName() + "_checkNetStatus2") {
                            public void run() {
                                BNOfflineDataManager.getInstance().startDownloadRequest(0);
                                try {
                                    C36491.sleep(300);
                                } catch (Exception e) {
                                }
                                BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                            }
                        }.start();
                    } else {
                        BNOfflineDataManager.getInstance().startDownloadRequest(provinceId);
                    }
                }
            }).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_cancel).setOnFirstBtnClickListener(new C36482()).show();
        } else if (downloadCommonFirst) {
            new Thread(getClass().getSimpleName() + "_startCheckNetStatus1") {
                public void run() {
                    BNOfflineDataManager.getInstance().startDownloadRequest(0);
                    try {
                        C36471.sleep(300);
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
            TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_sdcard_error));
        } else if (NetworkUtils.mConnectState == 0) {
            TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_network_unconnected));
        } else if (NetworkUtils.mWifiState == 1) {
            if (downloadCommonFirst) {
                BNOfflineDataManager.getInstance().downloadProvinceData(0);
            }
            BNOfflineDataManager.getInstance().downloadProvinceData(model.mProvinceId);
        } else {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_is_wifi_notification).setSecondBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    if (downloadCommonFirst) {
                        BNOfflineDataManager.getInstance().downloadProvinceData(0);
                    }
                    BNOfflineDataManager.getInstance().downloadProvinceData(model.mProvinceId);
                }
            }).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_cancel).setOnFirstBtnClickListener(new C36514()).show();
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
            TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_sdcard_error));
        } else if (NetworkUtils.mConnectState == 0) {
            TipTool.onCreateToastDialog(this.mContext, this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_network_unconnected));
        } else if (NetworkUtils.mWifiState == 1) {
            BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
        } else {
            new BNDialog(this.mActivity).setTitleTextFromActivity(C0965R.string.nsdk_string_common_alert_notification).setContentMessageFromActivity(C0965R.string.nsdk_string_od_is_wifi_notification).setSecondBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_confirm).setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    BNOfflineDataManager.getInstance().updateProvinceData(model.mProvinceId);
                }
            }).setFirstBtnTextFromActivity(C0965R.string.nsdk_string_common_alert_cancel).setOnFirstBtnClickListener(new C36536()).show();
        }
    }

    public OfflineDataInfo getDownloadedListModelByPosition(int position) {
        if (this.mDownloadedItems.size() <= 0 || position >= this.mDownloadedItems.size() || position < 0) {
            return null;
        }
        return (OfflineDataInfo) this.mDownloadedItems.get(position);
    }

    public int getCount() {
        return this.mUnDownloadItems.size() + this.mDownloadedItems.size();
    }

    public Object getItem(int position) {
        if (position < this.mDownloadedItems.size()) {
            return (OfflineDataInfo) this.mDownloadedItems.get(position);
        }
        return (OfflineDataInfo) this.mUnDownloadItems.get(position - this.mDownloadedItems.size());
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
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(C0965R.layout.nsdk_layout_od_offline_data_horizontal_list_item, null);
            holder = new ViewHolder();
            holder.mInfoLayout = (RelativeLayout) convertView.findViewById(C0965R.id.info_relativelayout);
            holder.mNameTV = (TextView) convertView.findViewById(C0965R.id.textview_name);
            holder.mInfoTV = (TextView) convertView.findViewById(C0965R.id.textview_info);
            holder.mProgressBarDownloading = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_downloading);
            holder.mProgressBarSuspend = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_suspend);
            holder.mProgressBarDownloadingNight = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_downloading_night);
            holder.mProgressBarSuspendNight = (ProgressBar) convertView.findViewById(C0965R.id.progress_bar_suspend_night);
            holder.mBtnDeleteIV = (ImageView) convertView.findViewById(C0965R.id.imageview_btn_delete);
            holder.mDownloadIV = (ImageView) convertView.findViewById(C0965R.id.download_image_view);
            holder.mCardStatusTV = (TextView) convertView.findViewById(C0965R.id.status_textview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (model != null) {
            model.formatStatusTips();
            holder.mInfoLayout.setVisibility(0);
            holder.mInfoTV.setVisibility(0);
            holder.mNameTV.setText(model.mName);
            holder.mNameTV.setTextColor(StyleManager.getDayStyle() ? -13421773 : -4538943);
            holder.mInfoTV.setText(model.mStatusTips);
            holder.mInfoTV.setTextColor(model.mStatusColor);
            holder.mInfoLayout.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_card_selector));
            holder.mBtnDeleteIV.setTag(model);
            holder.mBtnDeleteIV.setOnClickListener(new C36558());
            holder.mProgressBarDownloading.setVisibility(8);
            holder.mProgressBarDownloadingNight.setVisibility(8);
            holder.mProgressBarSuspend.setVisibility(8);
            holder.mProgressBarSuspendNight.setVisibility(8);
            boolean isDayStyle = BNStyleManager.getDayStyle();
            switch (model.mTaskStatus) {
                case 1:
                    if (isDayStyle) {
                        holder.mProgressBarDownloading.setProgress(model.mProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mDownloadIV.setVisibility(8);
                    holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_undownload));
                    holder.mBtnDeleteIV.setVisibility(8);
                    break;
                case 2:
                case 3:
                    if (isDayStyle) {
                        holder.mProgressBarDownloading.setProgress(model.mProgress);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(model.mProgress);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mDownloadIV.setVisibility(8);
                    holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_undownload));
                    holder.mBtnDeleteIV.setVisibility(0);
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
                        holder.mDownloadIV.setVisibility(0);
                        holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_downloaded));
                    } else {
                        if (isDayStyle) {
                            holder.mProgressBarSuspend.setProgress(model.mProgress);
                            holder.mProgressBarSuspend.setVisibility(0);
                        } else {
                            holder.mProgressBarSuspendNight.setProgress(model.mProgress);
                            holder.mProgressBarSuspendNight.setVisibility(0);
                        }
                        holder.mDownloadIV.setVisibility(8);
                        holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_undownload));
                    }
                    holder.mBtnDeleteIV.setVisibility(0);
                    break;
                case 5:
                    if (isDayStyle) {
                        holder.mProgressBarDownloading.setProgress(100);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(100);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mDownloadIV.setVisibility(0);
                    holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_downloaded));
                    holder.mBtnDeleteIV.setVisibility(8);
                    break;
                case 10:
                    if (isDayStyle) {
                        holder.mProgressBarDownloading.setProgress(100);
                        holder.mProgressBarDownloading.setVisibility(0);
                    } else {
                        holder.mProgressBarDownloadingNight.setProgress(100);
                        holder.mProgressBarDownloadingNight.setVisibility(0);
                    }
                    holder.mDownloadIV.setVisibility(0);
                    holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_downloaded));
                    holder.mBtnDeleteIV.setVisibility(8);
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
                    holder.mDownloadIV.setVisibility(0);
                    holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_downloaded));
                    holder.mBtnDeleteIV.setVisibility(0);
                    break;
                case 13:
                    if (isDayStyle) {
                        holder.mProgressBarSuspend.setProgress(model.mUpProgress);
                        holder.mProgressBarSuspend.setVisibility(0);
                    } else {
                        holder.mProgressBarSuspendNight.setProgress(model.mUpProgress);
                        holder.mProgressBarSuspendNight.setVisibility(0);
                    }
                    holder.mDownloadIV.setVisibility(0);
                    holder.mCardStatusTV.setText(this.mActivity.getResources().getString(C0965R.string.nsdk_string_od_offline_data_downloaded));
                    holder.mBtnDeleteIV.setVisibility(0);
                    break;
            }
        }
        return convertView;
    }
}
