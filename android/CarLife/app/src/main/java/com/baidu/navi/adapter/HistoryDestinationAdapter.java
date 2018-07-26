package com.baidu.navi.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.controller.QuickRoutePlanController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.TravelRefListener;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager$DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviDestHistroyModel;
import java.util.ArrayList;
import java.util.List;

public class HistoryDestinationAdapter extends BaseAdapter {
    private int MAX_HISTORY_NUM = 10;
    private DBManager$DBOperateResultCallback callback = new C36354();
    private boolean hideRefLayout = false;
    ViewHolder holder;
    private View mCleanHistoryLayout;
    private Context mContext;
    private QuickRoutePlanController mFragControl;
    private List<RoutePlanNode> mHistoryList = new ArrayList();
    private LayoutInflater mInflater;
    private boolean mIsCarMode = false;
    private boolean mIsQuickNaviFragment = false;
    private boolean mIsRoutePlanNodeFragment = false;
    private ListView mListView;
    private NaviDestHistroyModel mNaviDestHistory;
    private C1277e mOnDialogListener;
    private int mOrientation;
    private String mPackageName;
    private Resources mResources;
    private RoutePlanNode mRoutePlanNode;
    private TravelRefListener mTravelRefListener;

    /* renamed from: com.baidu.navi.adapter.HistoryDestinationAdapter$3 */
    class C36323 implements C0672b {
        C36323() {
        }

        public void onClick() {
            HistoryDestinationAdapter.this.cleanAllHistoryDesPoi();
        }
    }

    /* renamed from: com.baidu.navi.adapter.HistoryDestinationAdapter$4 */
    class C36354 implements DBManager$DBOperateResultCallback {

        /* renamed from: com.baidu.navi.adapter.HistoryDestinationAdapter$4$1 */
        class C36331 implements Runnable {
            C36331() {
            }

            public void run() {
                HistoryDestinationAdapter.this.notifyHistoryDataSetChanged();
                if (HistoryDestinationAdapter.this.mTravelRefListener != null && HistoryDestinationAdapter.this.getCount() == 0) {
                    HistoryDestinationAdapter.this.mTravelRefListener.onAddOrDeleteSuccess();
                }
            }
        }

        /* renamed from: com.baidu.navi.adapter.HistoryDestinationAdapter$4$2 */
        class C36342 implements Runnable {
            C36342() {
            }

            public void run() {
                HistoryDestinationAdapter.this.notifyHistoryDataSetChanged();
            }
        }

        C36354() {
        }

        public void onAddOrDeleteSuccess() {
            new Handler(Looper.getMainLooper()).post(new C36331());
        }

        public void onQuerySuccess() {
            new Handler(Looper.getMainLooper()).post(new C36342());
        }
    }

    public static class ViewHolder {
        public LinearLayout infoLayout;
        public LinearLayout poiInfoLayout;
        public TextView pointDescription;
        public ImageView pointIcon;
        public TextView pointName;
        public ImageView travelRef;
        public LinearLayout travelRefLayout;
    }

    public HistoryDestinationAdapter(Context context, boolean bIsQuickNaviFragment) {
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mContext = context;
        this.mIsQuickNaviFragment = bIsQuickNaviFragment;
        this.mNaviDestHistory = NaviDestHistroyModel.getInstance();
    }

    public HistoryDestinationAdapter(Context context, boolean bIsQuickNaviFragment, TravelRefListener listener) {
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mContext = context;
        this.mIsQuickNaviFragment = bIsQuickNaviFragment;
        this.mNaviDestHistory = NaviDestHistroyModel.getInstance();
        if (!this.mNaviDestHistory.checkIsQueryDB()) {
            DBManager.getAllHistoryDestPoints(this.callback);
        }
        this.mTravelRefListener = listener;
    }

    public HistoryDestinationAdapter(Context context, boolean bIsQuickNaviFragment, TravelRefListener listener, QuickRoutePlanController mFragControl) {
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mContext = context;
        this.mIsQuickNaviFragment = bIsQuickNaviFragment;
        this.mNaviDestHistory = NaviDestHistroyModel.getInstance();
        if (!this.mNaviDestHistory.checkIsQueryDB()) {
            DBManager.getAllHistoryDestPoints(this.callback);
        }
        this.mTravelRefListener = listener;
        this.mFragControl = mFragControl;
    }

    public void setCarMode(boolean isCar) {
        this.mIsCarMode = isCar;
        this.mPackageName = BaiduNaviApplication.getInstance().getPackageName();
        this.mResources = BaiduNaviApplication.getInstance().getResources();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getItemView(convertView, position);
        setItemContent(position);
        return convertView;
    }

    private View getItemView(View convertView, final int position) {
        if (convertView == null) {
            this.holder = new ViewHolder();
            convertView = this.mInflater.inflate(C0965R.layout.navi_des_history_item, null);
            this.holder.infoLayout = (LinearLayout) convertView.findViewById(C0965R.id.nav_history_item_layout);
            this.holder.poiInfoLayout = (LinearLayout) convertView.findViewById(C0965R.id.poi_info_layout);
            this.holder.pointName = (TextView) convertView.findViewById(C0965R.id.poi_name);
            this.holder.pointDescription = (TextView) convertView.findViewById(C0965R.id.poi_description);
            this.holder.pointIcon = (ImageView) convertView.findViewById(C0965R.id.icon_view);
            this.holder.travelRef = (ImageView) convertView.findViewById(C0965R.id.btn_travel_ref);
            this.holder.travelRefLayout = (LinearLayout) convertView.findViewById(C0965R.id.travel_ref_layout);
            convertView.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) convertView.getTag();
        }
        updateStyle(position);
        this.holder.travelRefLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                    if (HistoryDestinationAdapter.this.mTravelRefListener != null) {
                        HistoryDestinationAdapter.this.mTravelRefListener.onEnterTravelRefFragment(position, false);
                    }
                    StatisticManager.onEvent(StatisticConstants.WILLINGGO_HISTORYREFERENCE, StatisticConstants.WILLINGGO_HISTORYREFERENCE);
                }
            }
        });
        return convertView;
    }

    private void setItemContent(int position) {
        if (this.mHistoryList != null && position < this.mHistoryList.size()) {
            this.mRoutePlanNode = (RoutePlanNode) this.mHistoryList.get(position);
            if (this.mRoutePlanNode != null) {
                String name = this.mRoutePlanNode.getName();
                String description = this.mRoutePlanNode.getDescription();
                if (StringUtils.isEmpty(name)) {
                    name = this.mContext.getString(C0965R.string.default_poi_name);
                }
                if (this.holder.pointName != null) {
                    this.holder.pointName.setText(name);
                }
                if (this.holder.pointDescription != null) {
                    if (description == null || description.length() <= 0) {
                        this.holder.pointDescription.setText(null);
                        this.holder.pointDescription.setVisibility(8);
                    } else {
                        this.holder.pointDescription.setText(description);
                        this.holder.pointDescription.setVisibility(0);
                    }
                }
            }
            if ((this.mIsQuickNaviFragment || this.mIsCarMode) && !this.hideRefLayout && NetworkUtils.isNetworkAvailable(this.mContext)) {
                this.holder.travelRefLayout.setVisibility(0);
                this.holder.travelRef.setVisibility(0);
                return;
            }
            this.holder.travelRefLayout.setVisibility(8);
            this.holder.travelRef.setVisibility(8);
        }
    }

    public void hidleRefLayout() {
        this.hideRefLayout = true;
    }

    public int getHistoryIcon(int position) {
        if (position < 0) {
            return -1;
        }
        int num = position + 1;
        return this.mResources.getIdentifier(getResourceNameById(C0965R.drawable.carmode_ic_common_serial_bg) + JNISearchConst.LAYER_ID_DIVIDER + num, "drawable", this.mPackageName);
    }

    private String getResourceNameById(int resId) {
        String name = "";
        if (this.mResources == null) {
            return name;
        }
        try {
            return this.mResources.getResourceEntryName(resId);
        } catch (NotFoundException e) {
            return "";
        }
    }

    private void updateStyle(int position) {
        if (this.mIsCarMode) {
            if (this.holder.pointName != null) {
                this.holder.pointName.setTextColor(StyleManager.getColor(C0965R.color.carmode_common_main_text));
            }
            if (this.holder.pointDescription != null) {
                this.holder.pointDescription.setTextColor(StyleManager.getColor(C0965R.color.carmode_common_second_text));
            }
            if (this.mPackageName == null || this.mResources == null) {
                this.holder.pointIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_search_ic_history));
            } else {
                int resId = getHistoryIcon(position);
                if (resId > 0) {
                    this.holder.pointIcon.setBackgroundDrawable(this.mResources.getDrawable(resId));
                } else {
                    this.holder.pointIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_search_ic_history));
                }
            }
            if (this.holder.travelRef != null) {
                this.holder.travelRef.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_car_mode_poi_detail_ic_goout));
            }
        } else {
            if (this.holder.pointIcon != null) {
                this.holder.pointIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_search_ic_history));
            }
            if (this.holder.pointName != null) {
                this.holder.pointName.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_point_text_color));
            }
            if (this.holder.pointDescription != null) {
                this.holder.pointDescription.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_point_secondText_color));
            }
            if (this.holder.travelRef != null) {
                this.holder.travelRef.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rp_travel_ref_selected));
            }
        }
        if (this.holder.infoLayout == null) {
        }
    }

    public int getCount() {
        if (this.mHistoryList == null) {
            return 0;
        }
        int count;
        int size = this.mHistoryList.size();
        if (size > this.MAX_HISTORY_NUM) {
            count = this.MAX_HISTORY_NUM;
        } else {
            count = size;
        }
        return count;
    }

    public Object getItem(int position) {
        if (position <= 0 || position >= this.mHistoryList.size()) {
            return null;
        }
        return this.mHistoryList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public void showDelHistoryItemDialog(final int position) {
        C1953c commonDialog = new C1953c(this.mContext).a(C0965R.string.alert_delete).g(17).c(C0965R.string.alert_confirm).q().d(C0965R.string.alert_cancel);
        commonDialog.a(new C0672b() {
            public void onClick() {
                HistoryDestinationAdapter.this.delRoutePlanHistoryItem(position);
            }
        });
        this.mOnDialogListener.showDialog(commonDialog);
    }

    public void showCleanAllHistoryDialog() {
        C1953c commonDialog = new C1953c(this.mContext).a(C0965R.string.alert_clear_history_des).g(17).c(C0965R.string.alert_clean).q().d(C0965R.string.alert_cancel);
        commonDialog.a(new C36323());
        this.mOnDialogListener.showDialog(commonDialog);
    }

    public void cleanAllHistoryDesPoi() {
        DBManager.clearHistoryDestFromDB(this.callback);
    }

    public void delRoutePlanHistoryItem(int position) {
        if (this.mHistoryList != null) {
            DBManager.deleteHistoryDestFromDB((RoutePlanNode) this.mHistoryList.get(position), this.callback);
        }
    }

    public void notifyHistoryDataSetChanged() {
        this.mHistoryList = this.mNaviDestHistory.getRoutePlanNode();
        refreshListViewData();
    }

    public void refreshListViewData() {
        if (this.mCleanHistoryLayout != null) {
            if (getCount() == 0) {
                this.mCleanHistoryLayout.setVisibility(8);
                if (this.mListView != null) {
                    this.mListView.setVisibility(4);
                }
            } else if (this.mListView != null) {
                this.mListView.setVisibility(0);
            }
        }
        notifyDataSetChanged();
        if (this.mListView == null) {
        }
    }

    public RoutePlanNode getDate(int position) {
        LogUtil.m15791e("navi_history", position + " position:  " + position);
        if (position < 0 || position >= this.mHistoryList.size()) {
            return null;
        }
        return (RoutePlanNode) this.mHistoryList.get(position);
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    public void setListView(ListView list) {
        this.mListView = list;
    }

    public void setCleanHistoryLayout(View layout) {
        this.mCleanHistoryLayout = layout;
    }

    public void setOnDialogListener(C1277e listener) {
        this.mOnDialogListener = listener;
    }
}
