package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.view.dialog.C2286m.C2302a;
import com.baidu.carlife.view.dialog.C2304o;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navi.fragment.RoutePlanFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.ListViewUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager$DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviRouteHistoryModel;
import com.baidu.navisdk.util.db.model.RouteCustomModel;
import com.baidu.navisdk.util.db.object.NaviRouteDBObject;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryRouteAdapter extends BaseAdapter {
    private static final String TAG = "HistoryRouteAdapter";
    private DBManager$DBOperateResultCallback callback = new C36403();
    ViewHolder holder;
    private View mCleanHistoryLayout;
    private Context mContext;
    RoutePlanFragment mFragment;
    private ArrayList<NaviRouteDBObject> mHistoryList;
    private LayoutInflater mInflater;
    private ListView mListView;
    private NaviRouteHistoryModel mNaviRouteHistory;
    private int mOrientation;
    private NaviRouteDBObject mRoutePlanNode;

    /* renamed from: com.baidu.navi.adapter.HistoryRouteAdapter$1 */
    class C36361 implements OnClickListener {
        C36361() {
        }

        public void onClick(View arg0) {
            int pos = ((Integer) arg0.getTag()).intValue();
            if (HistoryRouteAdapter.this.mHistoryList != null && HistoryRouteAdapter.this.mHistoryList.size() != 0 && pos < HistoryRouteAdapter.this.mHistoryList.size() && pos >= 0) {
                RouteCustomController.getInstance().setCurRouteInfoByRouteSubcribeResult(((NaviRouteDBObject) HistoryRouteAdapter.this.mHistoryList.get(pos)).getRoutePlanNodes(), 3, ((NaviRouteDBObject) HistoryRouteAdapter.this.mHistoryList.get(pos)).getId());
                HistoryRouteAdapter.this.mFragment.jumpRouteCustomDetail(pos);
            }
        }
    }

    /* renamed from: com.baidu.navi.adapter.HistoryRouteAdapter$3 */
    class C36403 implements DBManager$DBOperateResultCallback {

        /* renamed from: com.baidu.navi.adapter.HistoryRouteAdapter$3$1 */
        class C36381 implements Runnable {
            C36381() {
            }

            public void run() {
                HistoryRouteAdapter.this.notifyHistoryDataSetChanged();
            }
        }

        /* renamed from: com.baidu.navi.adapter.HistoryRouteAdapter$3$2 */
        class C36392 implements Runnable {
            C36392() {
            }

            public void run() {
                HistoryRouteAdapter.this.notifyHistoryDataSetChanged();
            }
        }

        C36403() {
        }

        public void onAddOrDeleteSuccess() {
            new Handler(Looper.getMainLooper()).post(new C36381());
        }

        public void onQuerySuccess() {
            new Handler(Looper.getMainLooper()).post(new C36392());
        }
    }

    /* renamed from: com.baidu.navi.adapter.HistoryRouteAdapter$4 */
    class C36414 implements C2302a {
        C36414() {
        }

        public void onClick() {
            HistoryRouteAdapter.this.clearHistoryRouteAndNotifyChanged();
        }
    }

    public static class ViewHolder {
        public LinearLayout infoLayout;
        public ImageView routeCustomEnterIcon;
        public LinearLayout routeCustomEnterLayout;
        public TextView routeInfo;
        public ImageView routeTimeIcon;
        public TextView routeTimeInfo;
    }

    public HistoryRouteAdapter(CarlifeActivity activity, RoutePlanFragment fragment) {
        this.mContext = activity;
        this.mFragment = fragment;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.mNaviRouteHistory = NaviRouteHistoryModel.getInstance();
        this.mHistoryList = new ArrayList();
        if (this.mNaviRouteHistory.getNaviRouteList() == null) {
            DBManager.getAllHistoryRoutes(this.callback);
        }
    }

    public int getCount() {
        if (this.mHistoryList == null) {
            return 0;
        }
        return this.mHistoryList.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getItemView(convertView, position);
        setItemContent(position);
        return convertView;
    }

    private void setItemContent(int position) {
        if (this.mHistoryList == null || position >= this.mHistoryList.size()) {
            LogUtil.m15791e(TAG, "setItemContent()..................mHistoryList is null");
            return;
        }
        this.mRoutePlanNode = (NaviRouteDBObject) this.mHistoryList.get(position);
        if (this.mRoutePlanNode != null) {
            List<RoutePlanNode> poiInfoList = this.mRoutePlanNode.getRoutePlanNodes();
            long time = this.mRoutePlanNode.getTime();
            String name = getHistoryRouteDetailInfo(poiInfoList);
            String timeText = getHistoryRouteTimeStr(time);
            if (StringUtils.isEmpty(name)) {
                name = this.mContext.getString(C0965R.string.default_poi_name);
            }
            if (this.holder.routeInfo != null) {
                this.holder.routeInfo.setText(name);
            }
            if (this.holder.routeTimeInfo != null) {
                if (timeText == null || timeText.length() <= 0) {
                    this.holder.routeTimeInfo.setText(null);
                    this.holder.routeTimeInfo.setVisibility(8);
                } else {
                    this.holder.routeTimeInfo.setText(timeText);
                    this.holder.routeTimeInfo.setVisibility(0);
                }
            }
            int index = RouteCustomModel.getInstance().getExistRouteIndexByHisRouteDBId(this.mRoutePlanNode.getId());
            if (index >= 0) {
                int isOpen = 0;
                RouteCustomDBObject rcDBObj = RouteCustomModel.getInstance().getRouteCustomInfoByPos(index);
                if (rcDBObj != null) {
                    isOpen = rcDBObj.getOpen();
                }
                if (isOpen == 1) {
                    this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_ic_travelref_alarm_active));
                    return;
                } else {
                    this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rc_travelref_alarm_selector));
                    return;
                }
            }
            this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rc_travelref_alarm_selector));
        }
    }

    private View getItemView(View convertView, int position) {
        if (convertView == null) {
            this.holder = new ViewHolder();
            convertView = this.mInflater.inflate(C0965R.layout.navi_history_item, null);
            this.holder.infoLayout = (LinearLayout) convertView.findViewById(C0965R.id.nav_route_history_item_layout);
            this.holder.routeInfo = (TextView) convertView.findViewById(C0965R.id.route_info_text);
            this.holder.routeTimeInfo = (TextView) convertView.findViewById(C0965R.id.route_time_text);
            this.holder.routeTimeIcon = (ImageView) convertView.findViewById(C0965R.id.time_icon_view);
            this.holder.routeCustomEnterLayout = (LinearLayout) convertView.findViewById(C0965R.id.route_custom_enter_layout);
            this.holder.routeCustomEnterIcon = (ImageView) convertView.findViewById(C0965R.id.route_custom_enter_icon);
            convertView.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) convertView.getTag();
        }
        this.holder.routeCustomEnterLayout.setTag(Integer.valueOf(position));
        this.holder.routeCustomEnterLayout.setOnClickListener(new C36361());
        updateStyle();
        return convertView;
    }

    private void updateStyle() {
        if (this.holder.infoLayout != null) {
            this.holder.infoLayout.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.history_list_item_bg_selector));
        }
        if (this.holder.routeInfo != null) {
            this.holder.routeInfo.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_point_text_color));
        }
        if (this.holder.routeTimeInfo != null) {
            this.holder.routeTimeInfo.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_point_secondText_color));
        }
        if (this.holder.routeTimeIcon != null) {
            this.holder.routeTimeIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.history_common_sug_icon));
        }
        if (this.holder.routeCustomEnterIcon != null) {
            this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rc_travelref_alarm_selector));
        }
    }

    public NaviRouteDBObject getDate(int position) {
        LogUtil.m15791e("navi_history", position + " position:  " + position);
        if (position < 0 || position >= this.mHistoryList.size()) {
            return null;
        }
        return (NaviRouteDBObject) this.mHistoryList.get(position);
    }

    public ArrayList<RoutePlanNode> getRoutePoiInfo(int position) {
        NaviRouteDBObject dbObject = getDate(position);
        if (dbObject == null) {
            return null;
        }
        return dbObject.getRoutePlanNodes();
    }

    public void showDelHistoryItemDialog(final int position) {
        this.mFragment.showDialog(new C2304o((Activity) this.mContext).f(C0965R.string.alert_delete).j(C0965R.string.alert_cancel).k(C0965R.string.alert_confirm).d(new C2302a() {
            public void onClick() {
                HistoryRouteAdapter.this.removeRoutePoiInfoPosition(position);
            }
        }));
    }

    public void removeRoutePoiInfoPosition(int position) {
        DBManager.deleteHistoryRouteFromDB(position, this.callback);
    }

    public void showCleanAllHistoryDialog() {
        this.mFragment.showDialog(new C2304o((Activity) this.mContext).f(C0965R.string.alert_delete).j(C0965R.string.alert_cancel).k(C0965R.string.alert_confirm).d(new C36414()));
    }

    public void clearHistoryRouteAndNotifyChanged() {
        DBManager.clearAllHistoryRoutesFromDB(this.callback);
    }

    public void notifyHistoryDataSetChanged() {
        this.mHistoryList = this.mNaviRouteHistory.getNaviRouteList();
        refreshListViewData();
    }

    public void refreshListViewData() {
        if (this.mCleanHistoryLayout != null) {
            int count = getCount();
            LogUtil.m15791e(TAG, "refreshListViewData()..........count = " + count);
            if (count == 0) {
                this.mCleanHistoryLayout.setVisibility(8);
            } else {
                this.mCleanHistoryLayout.setVisibility(0);
            }
        }
        notifyDataSetChanged();
        if (this.mListView != null) {
            ListViewUtils.setListViewHeightBasedOnChildren(this.mListView);
        }
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    public String getHistoryRouteDetailInfo(List<RoutePlanNode> list) {
        String routeDetailInfo = "";
        if (list == null || list.size() == 0) {
            return routeDetailInfo;
        }
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            routeDetailInfo = routeDetailInfo + getRoutePlanNodeName((RoutePlanNode) list.get(i)) + " - ";
        }
        return routeDetailInfo + getRoutePlanNodeName((RoutePlanNode) list.get(size - 1));
    }

    private String getRoutePlanNodeName(RoutePlanNode node) {
        String reStr = "";
        if (node == null) {
            reStr = StyleManager.getString(C0965R.string.navi_unknown_road);
        }
        if (node.isNodeSettedData()) {
            return StringUtils.isEmpty(node.mName) ? StyleManager.getString(C0965R.string.navi_unknown_road) : node.mName;
        } else {
            return reStr;
        }
    }

    public String getHistoryRouteTimeStr(long time) {
        String routeTimeStr = "";
        long curTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (format.format(new Date(curTime)).equalsIgnoreCase(format.format(new Date(time)))) {
            format = new SimpleDateFormat("HH:mm");
        } else {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
        return format.format(new Date(time));
    }

    public void setListView(ListView list) {
        this.mListView = list;
    }

    public void setCleanHistoryLayout(View layout) {
        this.mCleanHistoryLayout = layout;
    }
}
