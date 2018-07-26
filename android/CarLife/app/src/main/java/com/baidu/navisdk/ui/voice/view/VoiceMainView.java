package com.baidu.navisdk.ui.voice.view;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceUserAction;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadController;
import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceDataStatus;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.drawable.UrlDrawable;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class VoiceMainView extends VoiceBaseView {
    private boolean isExternalCall = false;
    private boolean isFromNavingPage;
    private BNCommonTitleBar mBNCommonTitleBar = null;
    private BNDialog mDeleteDialog = null;
    private View mEnterSquareBtn = null;
    private String mHeadUrl = null;
    boolean mMapMode = true;
    private MyVoiceAdapter mMyVoiceAdapter = null;
    private ArrayList<VoiceItemInfo> mMyVoiceInfos = new ArrayList();
    private ListView mMyVoiceListview = null;
    private BNDialog mNetStatusDialog = null;
    private ArrayList<VoiceItemInfo> mSharedInfos = new ArrayList();
    private VoiceItemInfo mSharedVoiceInfo = null;
    private String mUsedTaskId = null;
    private ViewGroup mVoiceMainView = null;
    private int mVoiceMode = 0;
    private BNCommonProgressDialog mWaitingLoading = null;
    private ArrayList<VoiceItemInfo> mhasDownInfos = new ArrayList();

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceMainView$1 */
    class C45431 implements OnClickListener {
        C45431() {
        }

        public void onClick(View v) {
            if (VoiceMainView.this.mJumpListener != null) {
                VoiceMainView.this.mJumpListener.onBack(null);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceMainView$2 */
    class C45442 implements OnItemClickListener {
        C45442() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "zyq onItemClick pos = " + position);
            if (!VoiceMainView.this.isFromNavingPage && VoiceMainView.this.mMyVoiceAdapter != null) {
                VoiceItemInfo itemInfo = (VoiceItemInfo) VoiceMainView.this.mMyVoiceAdapter.getItem(position);
                if (itemInfo == null) {
                    return;
                }
                if (itemInfo.mType != 1 && itemInfo.mType != 2 && itemInfo.mType != 3) {
                    return;
                }
                if ((itemInfo.mInfo.status == 2 || itemInfo.mInfo.status == 3) && !NetworkUtils.isNetworkAvailable(VoiceMainView.this.mActivity)) {
                    TipTool.onCreateToastDialog(VoiceMainView.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
                } else if (VoiceMainView.this.mJumpListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBundle(BNVoiceParams.BUNDLE_VOICEINFO, itemInfo.mInfo.toBundle());
                    VoiceMainView.this.mJumpListener.onPageJump(1, 4, bundle);
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceMainView$3 */
    class C45453 implements OnItemLongClickListener {
        C45453() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "zyq onItemLongClick pos = " + position);
            if (VoiceMainView.this.mMyVoiceAdapter != null) {
                VoiceItemInfo voiceItem = (VoiceItemInfo) VoiceMainView.this.mMyVoiceAdapter.getItem(position);
                if (!(voiceItem.mInfo == null || voiceItem.mInfo.taskId == null)) {
                    if (voiceItem.mType == 1) {
                        if (!voiceItem.mInfo.taskId.equals(VoiceHelper.getInstance().getCurrentUsedTTSId())) {
                            VoiceMainView.this.showDeleteDialog(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_delete_title), voiceItem.mInfo);
                        }
                    } else if (voiceItem.mType == 2 || voiceItem.mType == 3) {
                        DownStats status = DownStats.getTaskDownStatus(voiceItem.mInfo.taskId);
                        if (status.stats == 1 || status.stats == 2 || status.stats == 0) {
                            VoiceMainView.this.showDeleteDialog(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_cancel_title), voiceItem.mInfo);
                        }
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceMainView$4 */
    class C45464 implements OnClickListener {
        C45464() {
        }

        public void onClick(View v) {
            if (VoiceMainView.this.mJumpListener != null) {
                if (VoiceMainView.this.isFromNavingPage) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Key.BUNDLE_ROOT_PAGE_TYPE, 2);
                    BNVoice.getInstance().setInternalCall(bundle);
                }
                VoiceMainView.this.mJumpListener.onPageJump(1, 5, null);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceMainView$6 */
    class C45486 implements OnNaviClickListener {
        C45486() {
        }

        public void onClick() {
            VoiceMainView.this.dismissDeleteDialog();
        }
    }

    static class DownStats {
        public static final int VOICE_DOWNLOAD_STATUS_DOWNING = 1;
        public static final int VOICE_DOWNLOAD_STATUS_END = 3;
        public static final int VOICE_DOWNLOAD_STATUS_PAUSE = 2;
        public static final int VOICE_DOWNLOAD_STATUS_UNSTART = 0;
        public int progress = 0;
        public int stats = 0;

        public static DownStats getTaskDownStatus(String taskId) {
            DownStats downstats = new DownStats();
            int status = VoiceDownloadStatus.getInstance().getDownTaskStatus(taskId);
            VoiceDataStatus dataStatus = VoiceDownloadController.getInstance().getTaskDownStausFromEngine(taskId);
            int progress = 0;
            if (dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_DOWNING || dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_UNSTART) {
                int totalSize = (int) dataStatus.unTotalSize;
                int downSize = (int) dataStatus.unDwonloadSize;
                if (totalSize != 0) {
                    progress = (int) ((((double) downSize) / ((double) totalSize)) * 100.0d);
                }
            } else if (dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_END) {
                progress = 100;
            }
            if (dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_END) {
                downstats.stats = 3;
                downstats.progress = 100;
            } else if (dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_DOWNING || dataStatus.status == VoiceDataStatus.VOICE_DATA_DOWN_UNSTART) {
                if (progress == 100) {
                    downstats.stats = 3;
                    downstats.progress = 100;
                } else if (status == 1) {
                    downstats.stats = 1;
                    downstats.progress = progress;
                } else if (status == 2) {
                    downstats.stats = 2;
                    downstats.progress = progress;
                } else if (progress != 0) {
                    downstats.stats = 2;
                    downstats.progress = progress;
                }
            }
            return downstats;
        }
    }

    private class MyClickListener implements OnClickListener {
        private int mPosition;

        public MyClickListener(int pos) {
            this.mPosition = pos;
        }

        public void onClick(View v) {
            VoiceMainView.this.onItemBtnClick(this.mPosition);
        }
    }

    class MyVoiceAdapter extends BaseAdapter {
        public static final int ITEM_CATEGORY = 0;
        public static final int ITEM_DETAIL = 1;
        public static final int ITEM_MAX_COUNT = 3;
        public static final int ITEM_SQUARE = 2;
        private int mUsedPositon = 0;

        /* renamed from: com.baidu.navisdk.ui.voice.view.VoiceMainView$MyVoiceAdapter$1 */
        class C45511 implements OnClickListener {
            C45511() {
            }

            public void onClick(View v) {
                VoiceMainView.this.onSquareClick();
            }
        }

        public MyVoiceAdapter() {
            updateVoiceData();
        }

        public void updateVoiceData() {
            VoiceMainView.this.mVoiceMode = BNSettingManager.getVoicePersonality();
            VoiceMainView.this.mUsedTaskId = VoiceHelper.getInstance().getCurrentUsedTTSId();
            if (VoiceMainView.this.mMyVoiceInfos != null) {
                VoiceMainView.this.mMyVoiceInfos.clear();
                VoiceMainView.this.mMyVoiceInfos.addAll(VoiceMainView.this.getMyVoiceInfo());
            } else {
                VoiceMainView.this.mMyVoiceInfos = VoiceMainView.this.getMyVoiceInfo();
            }
            this.mUsedPositon = VoiceMainView.this.getUsedVoicePosition();
            if (BNVoiceParams.GLOBAL.equals(VoiceMainView.this.mUsedTaskId)) {
                this.mUsedPositon = 0;
            }
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "getUsedVoice mVoiceMode = " + VoiceMainView.this.mVoiceMode + " mUsedTaskId = " + VoiceMainView.this.mUsedTaskId + " mUsedPositon = " + this.mUsedPositon);
        }

        public int getCount() {
            if (VoiceMainView.this.mMyVoiceInfos != null) {
                return VoiceMainView.this.mMyVoiceInfos.size();
            }
            return 0;
        }

        public Object getItem(int position) {
            if (VoiceMainView.this.mMyVoiceInfos == null || VoiceMainView.this.mMyVoiceInfos.size() <= position) {
                return null;
            }
            return VoiceMainView.this.mMyVoiceInfos.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getItemViewType(int position) {
            VoiceItemInfo item = (VoiceItemInfo) getItem(position);
            if (item == null || item.mType == 4) {
                return 0;
            }
            if (item.mType == 5) {
                return 2;
            }
            return 1;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            VoiceItemInfo voiceItem = (VoiceItemInfo) getItem(position);
            if (voiceItem == null) {
                return convertView;
            }
            int itemType = getItemViewType(position);
            MyVoiceViewHolder viewHolder = null;
            MyVoiceCategoryHolder categoryHolder = null;
            MyVoiceSquareHolder squareHolder = null;
            MyClickListener mClickListener;
            if (convertView == null) {
                if (itemType == 0) {
                    convertView = JarUtils.inflate(VoiceMainView.this.mActivity, C4048R.layout.nsdk_layout_voice_category_item, null);
                    categoryHolder = new MyVoiceCategoryHolder();
                    if (convertView != null) {
                        categoryHolder.mTitle = (TextView) convertView.findViewById(C4048R.id.voice_category_title);
                        convertView.setTag(categoryHolder);
                    }
                } else if (itemType == 2) {
                    convertView = JarUtils.inflate(VoiceMainView.this.mActivity, C4048R.layout.nsdk_layout_voice_square_item, null);
                    if (convertView != null) {
                        squareHolder = new MyVoiceSquareHolder();
                        squareHolder.mTitle = (TextView) convertView.findViewById(C4048R.id.voice_square);
                        squareHolder.mDivider1 = convertView.findViewById(C4048R.id.voice_main_category_1);
                        squareHolder.mDivider2 = convertView.findViewById(C4048R.id.voice_main_category_2);
                        squareHolder.mTitle.setOnClickListener(new C45511());
                        convertView.setTag(squareHolder);
                    }
                } else {
                    convertView = JarUtils.inflate(VoiceMainView.this.mActivity, C4048R.layout.nsdk_layout_voice_my_voice_item, null);
                    viewHolder = new MyVoiceViewHolder();
                    if (convertView != null) {
                        viewHolder.mHeadView = (ImageView) convertView.findViewById(C4048R.id.voice_head_view);
                        viewHolder.mTitle = (TextView) convertView.findViewById(C4048R.id.voice_title);
                        viewHolder.mSize = (TextView) convertView.findViewById(C4048R.id.voice_size);
                        viewHolder.mDownCnt = (TextView) convertView.findViewById(C4048R.id.voice_downcnt);
                        viewHolder.mProgressBar = (ProgressBar) convertView.findViewById(C4048R.id.voice_progress);
                        viewHolder.mUsedText = (TextView) convertView.findViewById(C4048R.id.voice_used_text);
                        viewHolder.mUseBtn = (Button) convertView.findViewById(C4048R.id.voice_use_button);
                        viewHolder.mDownBtn = (ImageView) convertView.findViewById(C4048R.id.voice_down_button);
                        viewHolder.mPercent = (TextView) convertView.findViewById(C4048R.id.voice_percent);
                        mClickListener = new MyClickListener(position);
                        viewHolder.mUseBtn.setOnClickListener(mClickListener);
                        viewHolder.mDownBtn.setOnClickListener(mClickListener);
                        convertView.setTag(viewHolder);
                    }
                }
            } else if (itemType == 0) {
                categoryHolder = (MyVoiceCategoryHolder) convertView.getTag();
            } else if (itemType == 2) {
                squareHolder = (MyVoiceSquareHolder) convertView.getTag();
            } else {
                viewHolder = (MyVoiceViewHolder) convertView.getTag();
                mClickListener = new MyClickListener(position);
                viewHolder.mUseBtn.setOnClickListener(mClickListener);
                viewHolder.mDownBtn.setOnClickListener(mClickListener);
            }
            if (itemType == 0) {
                categoryHolder.mTitle.setText(voiceItem.mInfo.name);
                if (VoiceMainView.this.mMapMode) {
                    categoryHolder.mTitle.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_category_text_color));
                    categoryHolder.mTitle.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_category_bg_color));
                } else {
                    categoryHolder.mTitle.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_category_text_color));
                    categoryHolder.mTitle.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_category_bg_color));
                }
            } else if (itemType == 2) {
                squareHolder.mTitle.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_name_color));
                squareHolder.mTitle.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_voice_main_list_bg_selector));
                squareHolder.mDivider1.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_category_bg_color));
                squareHolder.mDivider2.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_category_bg_color));
            } else {
                if (voiceItem.mType == 0) {
                    viewHolder.mHeadView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_normal_head_view));
                    viewHolder.mTitle.setText(voiceItem.mInfo.name);
                    viewHolder.mSize.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_default));
                    viewHolder.mDownCnt.setVisibility(8);
                    viewHolder.mProgressBar.setVisibility(4);
                    viewHolder.mDownBtn.setVisibility(8);
                    viewHolder.mPercent.setVisibility(8);
                    if (VoiceMainView.this.mVoiceMode == 0 || BNVoiceParams.GLOBAL.equals(VoiceMainView.this.mUsedTaskId)) {
                        viewHolder.mUseBtn.setVisibility(8);
                        viewHolder.mUsedText.setVisibility(0);
                    } else {
                        viewHolder.mUseBtn.setVisibility(0);
                        viewHolder.mUsedText.setVisibility(8);
                    }
                } else {
                    if (!TextUtils.isEmpty(voiceItem.mInfo.imageUrl) && !voiceItem.mInfo.imageUrl.trim().equals("url")) {
                        viewHolder.mHeadView.setImageDrawable(UrlDrawable.getDrawable(voiceItem.mInfo.imageUrl.trim()));
                    } else if (VoiceMainView.this.mHeadUrl != null) {
                        viewHolder.mHeadView.setImageDrawable(UrlDrawable.getDrawable(VoiceMainView.this.mHeadUrl.trim()));
                    } else {
                        viewHolder.mHeadView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_common_head_view));
                    }
                    viewHolder.mTitle.setText(voiceItem.mInfo.name);
                    viewHolder.mSize.setText(VoiceHelper.getInstance().getVoiceShowSize(voiceItem.mInfo.size));
                    if (voiceItem.mType == 1) {
                        viewHolder.mDownCnt.setVisibility(8);
                        viewHolder.mPercent.setVisibility(8);
                        viewHolder.mDownBtn.setVisibility(8);
                        viewHolder.mProgressBar.setVisibility(4);
                        if (VoiceMainView.this.mVoiceMode == 0 || position != this.mUsedPositon) {
                            viewHolder.mUseBtn.setVisibility(0);
                            viewHolder.mUsedText.setVisibility(8);
                        } else {
                            viewHolder.mUseBtn.setVisibility(8);
                            viewHolder.mUsedText.setVisibility(0);
                        }
                    } else if (voiceItem.mType == 2 || voiceItem.mType == 3) {
                        viewHolder.mDownCnt.setVisibility(0);
                        viewHolder.mDownBtn.setVisibility(0);
                        viewHolder.mUseBtn.setVisibility(8);
                        viewHolder.mUsedText.setVisibility(8);
                        viewHolder.mDownCnt.setText(VoiceHelper.getInstance().getVoiceShowDownCnt(voiceItem.mInfo.downloadCnt));
                        if (voiceItem.mInfo.taskId != null) {
                            if (voiceItem.mStatus == 1 || voiceItem.mStatus == 3) {
                                viewHolder.mProgressBar.setVisibility(0);
                                viewHolder.mProgressBar.setProgress(voiceItem.mProgress);
                                viewHolder.mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_download_pause));
                                viewHolder.mPercent.setVisibility(0);
                                viewHolder.mPercent.setText("" + voiceItem.mProgress + "%");
                            } else if (voiceItem.mStatus == 2) {
                                viewHolder.mProgressBar.setVisibility(0);
                                viewHolder.mProgressBar.setProgress(voiceItem.mProgress);
                                viewHolder.mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_download_resume));
                                viewHolder.mPercent.setVisibility(0);
                                viewHolder.mPercent.setText("" + voiceItem.mProgress + "%");
                            } else {
                                viewHolder.mProgressBar.setVisibility(4);
                                viewHolder.mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_download_start));
                                viewHolder.mPercent.setVisibility(8);
                            }
                        }
                    }
                }
                if (VoiceMainView.this.mMapMode) {
                    viewHolder.mTitle.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_name_color));
                    viewHolder.mSize.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_main_text_size_color));
                    viewHolder.mDownCnt.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_category_text_color));
                    viewHolder.mProgressBar.setProgressDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_voice_download_progressbar));
                    convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_voice_main_list_bg_selector));
                } else {
                    viewHolder.mTitle.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_main_text_name_color));
                    viewHolder.mSize.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_main_text_size_color));
                    viewHolder.mDownCnt.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_main_text_size_color));
                    viewHolder.mUsedText.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_main_text_used_color));
                    viewHolder.mProgressBar.setProgressDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_voice_download_progressbar));
                    convertView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_carmode_voice_main_list_bg_selector));
                }
            }
            return convertView;
        }
    }

    class MyVoiceCategoryHolder {
        TextView mTitle;

        MyVoiceCategoryHolder() {
        }
    }

    class MyVoiceSquareHolder {
        View mDivider1;
        View mDivider2;
        TextView mTitle;

        MyVoiceSquareHolder() {
        }
    }

    class MyVoiceViewHolder {
        ImageView mDownBtn;
        TextView mDownCnt;
        ImageView mHeadView;
        TextView mPercent;
        ProgressBar mProgressBar;
        TextView mSize;
        TextView mTitle;
        Button mUseBtn;
        TextView mUsedText;

        MyVoiceViewHolder() {
        }
    }

    private class VoiceItemInfo {
        public static final int VOICE_ITEM_TYPE_CATEGORY = 4;
        public static final int VOICE_ITEM_TYPE_DOWNLOAD = 1;
        public static final int VOICE_ITEM_TYPE_INVALID = -1;
        public static final int VOICE_ITEM_TYPE_NORMAL = 0;
        public static final int VOICE_ITEM_TYPE_RECOMMEND = 2;
        public static final int VOICE_ITEM_TYPE_SHARED = 3;
        public static final int VOICE_ITEM_TYPE_SQUARE = 5;
        VoiceInfo mInfo;
        int mProgress;
        int mStatus;
        int mType;

        VoiceItemInfo() {
            this.mInfo = new VoiceInfo();
            this.mType = -1;
            this.mProgress = 0;
            this.mStatus = 0;
        }

        VoiceItemInfo(VoiceInfo info) {
            this.mInfo = info;
            this.mType = -1;
            this.mProgress = 0;
            this.mStatus = 0;
        }

        VoiceItemInfo(VoiceInfo info, int type) {
            this.mInfo = info;
            this.mType = type;
            this.mProgress = 0;
            this.mStatus = 0;
        }

        VoiceItemInfo(VoiceInfo info, int type, int status, int progress) {
            this.mInfo = info;
            this.mType = type;
            this.mStatus = status;
            this.mProgress = progress;
        }

        public boolean equals(Object o) {
            if (o != null && (o instanceof VoiceInfo)) {
                return this.mInfo.equals((VoiceInfo) o);
            }
            if (o != null && (o instanceof VoiceItemInfo)) {
                return this.mInfo.equals(((VoiceItemInfo) o).mInfo);
            }
            if (o == null || !(o instanceof String)) {
                return super.equals(o);
            }
            return this.mInfo.equals((String) o);
        }
    }

    protected View onInitView(Bundle configBundle) {
        this.mVoiceMainView = (ViewGroup) JarUtils.oldInflate(this.mActivity, C4048R.layout.nsdk_layout_voice_main_layout, null);
        if (this.mVoiceMainView == null) {
            return null;
        }
        findViews();
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_PAGE_ACCESS, NaviStatConstants.NAVI_VOICE_PAGE_ACCESS);
        return this.mVoiceMainView;
    }

    public void onResume() {
        BNVoice.getInstance().setExternalCall(false, null);
        this.mHeadUrl = BNVoice.getInstance().getUserHeadUrl();
        refreshData();
    }

    public void updateUserHeadUrl(String url) {
        this.mHeadUrl = url;
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "voiceMainView updateUserHeadUrl " + url);
        refreshData();
    }

    public void onPause() {
    }

    public void onUpdateStyle(boolean day) {
        if (this.mVoiceMainView != null) {
            if (this.mMapMode) {
                this.mVoiceMainView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_common_background));
            } else {
                this.mVoiceMainView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_voice_common_background));
            }
        }
        if (!(this.mBNCommonTitleBar == null || this.mMapMode)) {
            this.mBNCommonTitleBar.setLeftContenVisible(false);
        }
        if (this.mMyVoiceListview != null) {
            if (this.mMapMode) {
                this.mMyVoiceListview.setDivider(JarUtils.getResources().getDrawable(C4048R.drawable.divide_list));
                this.mMyVoiceListview.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_voice_common_background));
            } else {
                this.mMyVoiceListview.setDivider(new ColorDrawable(JarUtils.getResources().getColor(C4048R.color.nsdk_carmode_common_divide_line)));
                this.mMyVoiceListview.setDividerHeight(2);
            }
        }
        if (this.mMyVoiceAdapter != null) {
            this.mMyVoiceAdapter.notifyDataSetChanged();
        }
    }

    public void initValues(Bundle configBundle) {
        String downTaskId = null;
        if (configBundle != null) {
            if (configBundle.containsKey(BNVoiceParams.BUNDLE_VOICEINFO_TASKID)) {
                downTaskId = configBundle.getString(BNVoiceParams.BUNDLE_VOICEINFO_TASKID);
            }
            if (2 == configBundle.getInt(Key.BUNDLE_ROOT_PAGE_TYPE)) {
                this.isFromNavingPage = true;
            } else {
                this.isFromNavingPage = false;
            }
        }
        if (this.mEnterSquareBtn != null) {
            if (this.isFromNavingPage) {
                this.mEnterSquareBtn.setVisibility(0);
            } else {
                this.mEnterSquareBtn.setVisibility(8);
            }
        }
        if (BNVoice.getInstance().isExternalCall()) {
            this.isExternalCall = true;
            Bundle bundle = BNVoice.getInstance().getExternalCallBundle();
            if (bundle != null && bundle.containsKey("ypid")) {
                downTaskId = bundle.getString("ypid");
            }
        } else {
            this.isExternalCall = false;
        }
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "VoiceMainView downTaskId = " + downTaskId);
        if (downTaskId != null) {
            this.mSharedVoiceInfo = new VoiceItemInfo();
            this.mSharedVoiceInfo.mInfo.taskId = downTaskId;
            if (this.mhasDownInfos != null && this.mhasDownInfos.contains(this.mSharedVoiceInfo)) {
                TipTool.onCreateToastDialog(this.mActivity, "已经下载了");
                this.mSharedVoiceInfo = null;
            } else if (VoiceDownloadStatus.getInstance().hasInTaskQueue(downTaskId)) {
                TipTool.onCreateToastDialog(this.mActivity, "正在下载中");
                this.mSharedVoiceInfo = null;
            } else if (VoiceDownloadController.getInstance().hasInSharedVoice(downTaskId)) {
                downloadStatics(downTaskId);
                startDownloadCheckNet(downTaskId);
                this.mSharedVoiceInfo = null;
            } else {
                VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(downTaskId);
                if (realData == null) {
                    showWaitingLoading(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_main_waiting));
                    return;
                }
                VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                downloadStatics(downTaskId);
                startDownloadCheckNet(downTaskId);
                this.mSharedVoiceInfo = null;
            }
        }
    }

    public void updateSharedVoiceInfo(boolean success) {
        if (this.mSharedVoiceInfo != null) {
            if (success) {
                VoiceInfo realData = VoiceHelper.getInstance().getVoiceInfo(this.mSharedVoiceInfo.mInfo.taskId);
                if (realData != null) {
                    VoiceDownloadController.getInstance().addSharedVoiceInfo(realData);
                    downloadStatics(realData.taskId);
                    startDownloadCheckNet(realData.taskId);
                }
            } else {
                TipTool.onCreateToastDialog(this.mActivity, "获取失败");
            }
        }
        this.mSharedVoiceInfo = null;
        dismissWaitingLoading();
        refreshData();
    }

    private void findViews() {
        if (this.mVoiceMainView != null) {
            this.mBNCommonTitleBar = (BNCommonTitleBar) this.mVoiceMainView.findViewById(C4048R.id.voice_main_title_bar);
            this.mMyVoiceListview = (ListView) this.mVoiceMainView.findViewById(C4048R.id.voice_main_my_voice_list);
            this.mEnterSquareBtn = this.mVoiceMainView.findViewById(C4048R.id.voice_main_enter_square_btn);
            if (this.mBNCommonTitleBar == null || this.mMyVoiceListview == null || this.mEnterSquareBtn == null) {
                this.mVoiceMainView = null;
                return;
            }
            this.mBNCommonTitleBar.setMiddleTextSize(18.0f);
            this.mBNCommonTitleBar.setLeftOnClickedListener(new C45431());
            this.mMyVoiceAdapter = new MyVoiceAdapter();
            this.mMyVoiceListview.setAdapter(this.mMyVoiceAdapter);
            this.mMyVoiceListview.setOnItemClickListener(new C45442());
            this.mMyVoiceListview.setOnItemLongClickListener(new C45453());
            this.mEnterSquareBtn.setOnClickListener(new C45464());
        }
    }

    private VoiceItemInfo getNormalVoiceInfo() {
        VoiceInfo info = new VoiceInfo();
        info.name = JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_normal);
        info.taskId = BNVoiceParams.VOICE_NORMAL;
        info.tag = BNVoiceParams.VOICE_NORMAL;
        info.size = 22020096;
        VoiceItemInfo item = new VoiceItemInfo(info);
        item.mType = 0;
        return item;
    }

    private VoiceItemInfo getSquareVoiceInfo() {
        VoiceInfo info = new VoiceInfo();
        info.name = JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_main_voice_square);
        VoiceItemInfo item = new VoiceItemInfo(info);
        item.mType = 5;
        return item;
    }

    private synchronized ArrayList<VoiceItemInfo> getMyVoiceInfo() {
        ArrayList<VoiceItemInfo> infos;
        VoiceInfo info;
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "getMyVoiceInfo");
        if (this.mhasDownInfos != null) {
            this.mhasDownInfos.clear();
        }
        if (this.mSharedInfos != null) {
            this.mSharedInfos.clear();
        }
        ArrayList<VoiceInfo> downsInfos = VoiceDownloadController.getInstance().getDownloadVoiceTask();
        if (downsInfos != null && downsInfos.size() > 0) {
            Iterator it = downsInfos.iterator();
            while (it.hasNext()) {
                info = (VoiceInfo) it.next();
                if (!BNVoiceParams.GLOBAL.equals(info.taskId)) {
                    this.mhasDownInfos.add(new VoiceItemInfo(info, 1));
                }
            }
        }
        ArrayList<VoiceInfo> sharedInfos = VoiceDownloadController.getInstance().getSharedVoiceInfos();
        if (!(sharedInfos == null || sharedInfos.isEmpty())) {
            Iterator it2 = sharedInfos.iterator();
            while (it2.hasNext()) {
                info = (VoiceInfo) it2.next();
                DownStats downstats = DownStats.getTaskDownStatus(info.taskId);
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "getMySharedVoice info : " + info.toString() + " status :" + downstats.stats + " progress :" + downstats.progress);
                if (!(downsInfos.contains(info) || info.taskId.startsWith(BNVoiceParams.TTS_TEXT_ID) || info.taskId.startsWith("20-") || BNVoiceParams.GLOBAL.equals(info.taskId))) {
                    if (downstats.stats == 1 || downstats.stats == 2 || downstats.stats == 3) {
                        info.status = 3;
                        this.mSharedInfos.add(new VoiceItemInfo(info, 3, downstats.stats, downstats.progress));
                    } else if (downstats.stats == 0) {
                        info.status = 3;
                        this.mSharedInfos.add(new VoiceItemInfo(info, 3, 2, downstats.progress));
                    }
                }
            }
        }
        infos = new ArrayList();
        infos.add(getNormalVoiceInfo());
        infos.addAll(this.mhasDownInfos);
        infos.addAll(this.mSharedInfos);
        infos.add(getSquareVoiceInfo());
        return infos;
    }

    public void refreshData() {
        if (this.mMyVoiceListview != null && this.mMyVoiceAdapter != null) {
            this.mMyVoiceAdapter.updateVoiceData();
            this.mMyVoiceAdapter.notifyDataSetChanged();
        }
    }

    public void switchVoiceData(String taskId) {
        if (this.mJumpListener != null) {
            this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_usage);
        }
        if (BNVoice.getInstance().switchVoice(taskId)) {
            showWaitingLoading("切换中...");
        }
    }

    public void handleSwitchVoiceData(boolean success, String taskId) {
        if (success) {
            refreshData();
        }
        dismissWaitingLoading();
    }

    public void updateItemView(String taskId, int status, int value) {
        if (status == 3) {
            TipTool.onCreateToastDialog(this.mActivity, "下载错误");
        }
        int positoin = -1;
        if (!(this.mMyVoiceInfos == null || taskId == null)) {
            for (int i = 0; i < this.mMyVoiceInfos.size(); i++) {
                if (((VoiceItemInfo) this.mMyVoiceInfos.get(i)).equals(taskId)) {
                    positoin = i;
                }
            }
        }
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "updateItemView taskId = " + taskId + " status = " + status + " value = " + value);
        if (positoin != -1 && this.mMyVoiceListview != null && this.mMyVoiceAdapter != null) {
            int fristVisbilePos = this.mMyVoiceListview.getFirstVisiblePosition();
            int lastVisiblePos = this.mMyVoiceListview.getLastVisiblePosition();
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "updateItemView111 pos = " + positoin + " fristVisbilePos = " + fristVisbilePos + " lastVisiblePos = " + lastVisiblePos);
            if (positoin >= fristVisbilePos && positoin <= lastVisiblePos) {
                int index = positoin - fristVisbilePos;
                View view = this.mMyVoiceListview.getChildAt(index);
                VoiceItemInfo item = (VoiceItemInfo) this.mMyVoiceAdapter.getItem(positoin);
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "updateItemView111 index = " + index + " taskId = " + item.mInfo.taskId + " taskName = " + item.mInfo.name);
                if (item.mType == 2 || item.mType == 3) {
                    MyVoiceViewHolder obj = view.getTag();
                    if (obj != null && (obj instanceof MyVoiceViewHolder)) {
                        MyVoiceViewHolder viewHolder = obj;
                        if (status == 2) {
                            viewHolder.mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_download_resume));
                            TipTool.onCreateToastDialog(this.mActivity, C1253f.gr);
                        } else if (status == 1 || status == 8) {
                            viewHolder.mProgressBar.setVisibility(0);
                            viewHolder.mProgressBar.setProgress(value);
                            viewHolder.mPercent.setVisibility(0);
                            viewHolder.mPercent.setText("" + value + "%");
                            viewHolder.mDownBtn.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.voice_download_pause));
                        } else if (status == 4) {
                            viewHolder.mDownCnt.setVisibility(8);
                            viewHolder.mPercent.setVisibility(8);
                            viewHolder.mDownBtn.setVisibility(8);
                            viewHolder.mProgressBar.setVisibility(4);
                            if (this.mVoiceMode == 0 || taskId != this.mUsedTaskId) {
                                viewHolder.mUseBtn.setVisibility(0);
                                viewHolder.mUsedText.setVisibility(8);
                                return;
                            }
                            viewHolder.mUseBtn.setVisibility(8);
                            viewHolder.mUsedText.setVisibility(0);
                        }
                    }
                }
            }
        }
    }

    public boolean onBackPressed() {
        if (this.isExternalCall && this.mJumpListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("entry", "openapi");
            BNVoice.getInstance().setInternalCall(bundle);
            this.mJumpListener.onPageJump(1, 5, null);
            if (this.mActivity != null) {
                this.mActivity.finish();
                return false;
            }
        }
        return super.onBackPressed();
    }

    private void onSquareClick() {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onSquareClick");
        if (!NetworkUtils.isNetworkAvailable(this.mActivity)) {
            TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
        } else if (this.mJumpListener != null) {
            StringBuilder sbDownIds = new StringBuilder();
            if (!(this.mhasDownInfos == null || this.mhasDownInfos.isEmpty())) {
                int size = this.mhasDownInfos.size();
                for (int i = 0; i < size; i++) {
                    if (((VoiceItemInfo) this.mhasDownInfos.get(i)).mInfo.taskId != null) {
                        sbDownIds.append(((VoiceItemInfo) this.mhasDownInfos.get(i)).mInfo.taskId);
                        if (i + 1 != size) {
                            sbDownIds.append("|");
                        }
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("downIds", sbDownIds.toString());
            BNVoice.getInstance().setInternalCall(bundle);
            this.mJumpListener.onPageJump(1, 5, null);
        }
    }

    private void onItemBtnClick(int position) {
        LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onItemBtnClick pos = " + position);
        if (this.mMyVoiceAdapter != null) {
            VoiceItemInfo voiceItem = (VoiceItemInfo) this.mMyVoiceAdapter.getItem(position);
            if (voiceItem == null) {
                return;
            }
            if (voiceItem.mType == 0) {
                if (VoiceHelper.getInstance().getCurrentUsedTTSId() != null) {
                    switchVoiceData(null);
                }
            } else if (voiceItem.mType == 1) {
                String usedTTSId = VoiceHelper.getInstance().getCurrentUsedTTSId();
                if (voiceItem.mInfo.taskId != null && !voiceItem.mInfo.taskId.equals(usedTTSId)) {
                    switchVoiceData(voiceItem.mInfo.taskId);
                }
            } else if ((voiceItem.mType == 2 || voiceItem.mType == 3) && voiceItem.mInfo.taskId != null) {
                DownStats downstatus = DownStats.getTaskDownStatus(voiceItem.mInfo.taskId);
                LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "onItemBtnClick download taskId = " + voiceItem.mInfo.taskId + " status = " + downstatus.stats);
                if (downstatus.stats == 0 || downstatus.stats == 2) {
                    if (this.mJumpListener != null) {
                        this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_download);
                    }
                    if ("9999".equals(voiceItem.mInfo.taskId)) {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_MCDULL_DOWNLOAD, NaviStatConstants.NAVI_VOICE_MCDULL_DOWNLOAD);
                    } else {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_RECOMMRND_DOWNLOAD, NaviStatConstants.NAVI_VOICE_RECOMMRND_DOWNLOAD);
                    }
                    if (NetworkUtils.isNetworkAvailable(this.mActivity)) {
                        startDownloadCheckNet(voiceItem.mInfo.taskId);
                    } else {
                        TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_voice_net_work_unaiable));
                    }
                } else if (downstatus.stats == 1) {
                    VoiceDownloadController.getInstance().pauseDownload(voiceItem.mInfo.taskId);
                }
            }
        }
    }

    private int getUsedVoicePosition() {
        if (!(this.mVoiceMode == 0 || this.mUsedTaskId == null || this.mMyVoiceInfos == null)) {
            int count = this.mMyVoiceInfos.size();
            for (int i = 0; i < count; i++) {
                if (((VoiceItemInfo) this.mMyVoiceInfos.get(i)).equals(this.mUsedTaskId)) {
                    return i;
                }
            }
        }
        return 1;
    }

    private void downloadStatics(String taskId) {
        if (this.mJumpListener != null) {
            this.mJumpListener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_download);
        }
        if ("9999".equals(taskId)) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_MCDULL_DOWNLOAD, NaviStatConstants.NAVI_VOICE_MCDULL_DOWNLOAD);
        } else {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_VOICE_RECORDED_DOWNLOAD, NaviStatConstants.NAVI_VOICE_RECORDED_DOWNLOAD);
        }
    }

    public void dismissDeleteDialog() {
        try {
            if (this.mDeleteDialog != null && this.mActivity != null && !this.mActivity.isFinishing()) {
                if (this.mDeleteDialog.isShowing()) {
                    this.mDeleteDialog.dismiss();
                }
                this.mDeleteDialog = null;
            }
        } catch (Exception e) {
            this.mDeleteDialog = null;
        }
    }

    private void showDeleteDialog(String content, final VoiceInfo info) {
        dismissDeleteDialog();
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            if (this.mDeleteDialog == null) {
                this.mDeleteDialog = new BNDialog(this.mActivity);
            }
            this.mDeleteDialog.enableBackKey(true);
            this.mDeleteDialog.setContentMessage(content);
            this.mDeleteDialog.setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_confirm));
            this.mDeleteDialog.setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    if (info.taskId != null && info.taskId.equals(BNVoiceParams.JIN_SHA)) {
                        BNSettingManager.setAutoDownloadJinShaTTS(false);
                    }
                    String curTTSId = VoiceHelper.getInstance().getCurrentUsedTTSId();
                    if (curTTSId == null || !curTTSId.equals(info.taskId)) {
                        VoiceDownloadController.getInstance().removeDownload(info.taskId);
                        VoiceDownloadController.getInstance().removeSharedVoieInfo(info.taskId);
                        VoiceMainView.this.refreshData();
                        return;
                    }
                    TipTool.onCreateToastDialog(VoiceMainView.this.mActivity, "不能删除正在使用中的语音");
                }
            });
            this.mDeleteDialog.setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_negative));
            this.mDeleteDialog.setOnFirstBtnClickListener(new C45486());
            if (!this.mDeleteDialog.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mDeleteDialog.show();
            }
        }
    }

    private void showWaitingLoading(String strTip) {
        if (this.mActivity != null) {
            dismissWaitingLoading();
            try {
                if (this.mWaitingLoading == null && this.mActivity != null) {
                    this.mWaitingLoading = new BNCommonProgressDialog(this.mActivity);
                }
                if (this.mWaitingLoading != null) {
                    this.mWaitingLoading.setMessage(strTip);
                }
                if (!this.mWaitingLoading.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                    this.mWaitingLoading.show();
                }
            } catch (Exception e) {
            }
        }
    }

    private void dismissWaitingLoading() {
        try {
            if (this.mWaitingLoading != null && this.mActivity != null && !this.mActivity.isFinishing() && this.mWaitingLoading.isShowing()) {
                this.mWaitingLoading.dismiss();
            }
        } catch (Exception e) {
            this.mWaitingLoading = null;
        }
    }

    private void startDownloadCheckNet(String mTaskId) {
        final String taskId = mTaskId;
        if (!"9999".equals(taskId) && !"2-".equals(taskId.substring(0, 2))) {
            VoiceDownloadController.getInstance().startDownload(taskId);
        } else if (NetworkUtils.isTypeNetworkAvailable(this.mActivity, 1)) {
            VoiceDownloadController.getInstance().startDownload(taskId);
        } else if (this.mActivity == null) {
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "startDownloadCheckNet mActivity is null");
        } else {
            if (this.mNetStatusDialog == null) {
                this.mNetStatusDialog = new BNDialog(this.mActivity);
            } else if (this.mNetStatusDialog.isShowing()) {
                return;
            }
            this.mNetStatusDialog.setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_notification));
            this.mNetStatusDialog.setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_not_wifi_notification));
            this.mNetStatusDialog.setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_confirm));
            this.mNetStatusDialog.setOnSecondBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    if (!VoiceDownloadController.getInstance().startDownload(taskId)) {
                        TipTool.onCreateToastDialog(VoiceMainView.this.mActivity, "已下载或正在下载");
                    }
                }
            });
            this.mNetStatusDialog.setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_common_alert_cancel));
            this.mNetStatusDialog.setOnFirstBtnClickListener(new OnNaviClickListener() {
                public void onClick() {
                    DownStats downstatus = DownStats.getTaskDownStatus(taskId);
                    if (downstatus.stats == 0 || (downstatus.stats == 2 && downstatus.progress == 0)) {
                        VoiceDownloadController.getInstance().removeDownload(taskId);
                        VoiceDownloadController.getInstance().removeSharedVoieInfo(taskId);
                        VoiceMainView.this.refreshData();
                    }
                }
            });
            if (!this.mNetStatusDialog.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mNetStatusDialog.show();
            }
        }
    }

    public void onSwitchVoiceNeedRestart(String taskId) {
        if (this.isFromNavingPage) {
            BNVoice.getInstance().showVoiceNextRestartWork();
        } else {
            BNVoice.getInstance().showVoiceReStartDialog();
        }
    }
}
