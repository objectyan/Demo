package com.baidu.navi.fragment;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.dialog.C2286m.C2302a;
import com.baidu.carlife.view.dialog.C2304o;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.adapter.DragSortListAdapter;
import com.baidu.navi.adapter.HistoryRouteAdapter;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.ListViewUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navi.view.DragSortListener;
import com.baidu.navi.view.draglistview.DragListView;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider$OnRGSubStatusListener;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.PointSelectNode;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.RoutePlanTimeUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class RoutePlanFragment extends BrowseMapFragment implements OnClickListener {
    public static final String KEY_FROM_POI_DETAIL = "from_poi_detail";
    public static final String KEY_FROM_ROUTE_GUIDE = "from_route_guide";
    public static final String KEY_SET_POI = "set_poi";
    public static final String KEY_SET_POI_TYPE = "set_poi_type";
    private static final String TAG = "RoutePlan";
    private boolean isNeedInitial = false;
    private View mAboveLayout;
    private Thread mAntiGeoThread;
    private ImageView mBtnBack;
    private ImageView mBtnOpenPreference;
    private View mCleanHistoryLayout;
    private TextView mCleanHistoryRouteBtn = null;
    private Button mClearRouteButton = null;
    private ImageView mDivider1;
    private ImageView mDivider2;
    private int mDividerHeight = 0;
    private long mDoubleClickTime = 0;
    private DragListView mDragSortListView;
    private ViewGroup mGroupView;
    private HistoryRouteAdapter mHistoryDataAdapter;
    private TextView mHistoryRouteText;
    private LinearLayout mHistoryRouteTextLayout;
    private DragSortListener mHorizontalDragSortListener = new C38264();
    private int mHour;
    private boolean mIsBackHome = false;
    private boolean mIsFromPoiDetail = false;
    private boolean mIsFromRouteGuide = false;
    private OnItemClickListener mItemHorizontalClickListener = new C38253();
    private OnItemClickListener mItemVerticalClickListener = new C38231();
    private int mMinute;
    private BNRouteGuider$OnRGSubStatusListener mOnRGSubStatusListener = new C38308();
    private OnTimeSetListener mOnTimeSetListener = new C38275();
    private RelativeLayout mPreferenceLayout;
    private Handler mRPHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanSuccess");
                    if (!(BaseFragment.mActivity == null || BaseFragment.mActivity.isFinishing())) {
                        RoutePlanFragment.this.removeAllFragmentByType(52);
                        RoutePlanFragment.this.showFragment(52, null);
                    }
                    BNRoutePlaner.getInstance().removeRouteResultHandler(RoutePlanFragment.this.mRPHandler);
                    return;
                case 6:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanYawingFail mIsFromRouteGuide=" + RoutePlanFragment.this.mIsFromRouteGuide);
                    if (RoutePlanFragment.this.mIsFromRouteGuide) {
                        RoutePlanFragment.this.mIsBackHome = true;
                        return;
                    }
                    return;
                case 7:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanFail mIsFromRouteGuide=" + RoutePlanFragment.this.mIsFromRouteGuide);
                    RoutePlanFragment.this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
                    if (RoutePlanFragment.this.mIsFromRouteGuide) {
                        RoutePlanFragment.this.mIsBackHome = true;
                    }
                    BNRoutePlaner.getInstance().removeRouteResultHandler(RoutePlanFragment.this.mRPHandler);
                    return;
                case 32:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanCanceled");
                    RoutePlanFragment.this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
                    if (RoutePlanFragment.this.mIsFromRouteGuide) {
                        RoutePlanFragment.this.mIsBackHome = true;
                    }
                    BNRoutePlaner.getInstance().removeRouteResultHandler(RoutePlanFragment.this.mRPHandler);
                    return;
                case 36:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanFail mIsFromRouteGuide=" + RoutePlanFragment.this.mIsFromRouteGuide);
                    RoutePlanFragment.this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
                    if (RoutePlanFragment.this.mIsFromRouteGuide) {
                        RoutePlanFragment.this.mIsBackHome = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private RoutePlanModel mRoutePlanModel = null;
    private Button mRouteplanButton = null;
    private ScrollView mScrollView;
    private Vector<RoutePlanNode> mSrcData = new Vector();
    private Handler mUIHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    if (msg.arg1 == 0) {
                        SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                        RoutePlanFragment.this.fillAntiGeo(poi.mViewPoint, poi);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private DragSortListAdapter mVerticalAdapter = null;
    private ImageView mVerticalAddNodeImageView = null;
    private DragSortListener mVerticalDragSortListener = new C38242();
    private ListView mVerticalHistoryRouteList = null;

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$1 */
    class C38231 implements OnItemClickListener {
        C38231() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (BaseFragment.mActivity != null) {
                LogUtil.m15791e("RoutePlan", "onItemClick position=" + position);
                RoutePlanFragment.this.goToRoutePlanNodePage(position);
                if (position == 0) {
                    StatisticManager.onEvent(StatisticConstants.ROUTE_SETSTART, StatisticConstants.ROUTE_SETSTART);
                } else if (position == RoutePlanFragment.this.mSrcData.size() - 1) {
                    StatisticManager.onEvent(StatisticConstants.ROUTE_SETDESTINATION, StatisticConstants.ROUTE_SETDESTINATION);
                } else {
                    StatisticManager.onEvent(StatisticConstants.ROUTE_SETWAYPOINT, StatisticConstants.ROUTE_SETWAYPOINT);
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$2 */
    class C38242 implements DragSortListener {
        C38242() {
        }

        public void onDeleteNode(int position) {
            int pos = position;
            if (pos < RoutePlanFragment.this.mSrcData.size()) {
                if (RoutePlanFragment.this.mSrcData.size() > 2) {
                    RoutePlanFragment.this.mSrcData.remove(pos);
                } else if (RoutePlanFragment.this.mSrcData.size() == 2) {
                    RoutePlanFragment.this.mSrcData.remove(pos);
                    RoutePlanFragment.this.mSrcData.insertElementAt(new RoutePlanNode(), pos);
                }
                RoutePlanFragment.this.refreshDragListView();
            }
            if (RoutePlanFragment.this.mVerticalAddNodeImageView.getVisibility() == 8) {
                RoutePlanFragment.this.mVerticalAddNodeImageView.setVisibility(0);
            }
        }

        public void onDrop(int from, int to) {
            LogUtil.m15791e("RoutePlan", "onDrop from=" + from + ",to=" + to);
            if (from != to && from >= 0 && from < RoutePlanFragment.this.mSrcData.size() && to >= 0 && to < RoutePlanFragment.this.mSrcData.size()) {
                RoutePlanFragment.this.mSrcData.insertElementAt(RoutePlanFragment.this.mSrcData.remove(from), to);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$3 */
    class C38253 implements OnItemClickListener {
        C38253() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (BaseFragment.mActivity != null) {
                LogUtil.m15791e("RoutePlan", "onItemClick position=" + position);
                RoutePlanFragment.this.goToRoutePlanNodePage(position);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$4 */
    class C38264 implements DragSortListener {
        C38264() {
        }

        public void onDeleteNode(int position) {
            int pos = position;
            if (pos < RoutePlanFragment.this.mSrcData.size()) {
                if (RoutePlanFragment.this.mSrcData.size() > 2) {
                    RoutePlanFragment.this.mSrcData.remove(pos);
                } else if (RoutePlanFragment.this.mSrcData.size() == 2) {
                    RoutePlanFragment.this.mSrcData.remove(pos);
                    RoutePlanFragment.this.mSrcData.insertElementAt(new RoutePlanNode(), pos);
                }
                RoutePlanFragment.this.refreshDragListView();
            }
        }

        public void onDrop(int from, int to) {
            LogUtil.m15791e("RoutePlan", "onDrop from=" + from + ",to=" + to);
            if (to == 0) {
                to = 1;
            }
            if (from >= 0 && from < RoutePlanFragment.this.mSrcData.size() && to >= 0 && to < RoutePlanFragment.this.mSrcData.size()) {
                RoutePlanFragment.this.mSrcData.insertElementAt(RoutePlanFragment.this.mSrcData.remove(from), to);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$5 */
    class C38275 implements OnTimeSetListener {
        C38275() {
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            RoutePlanFragment.this.mHour = hourOfDay;
            RoutePlanFragment.this.mMinute = minute;
        }
    }

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$8 */
    class C38308 implements BNRouteGuider$OnRGSubStatusListener {
        C38308() {
        }

        public void onRoutePlanYawing(Message msg) {
            if (RoutePlanFragment.this.mIsFromRouteGuide && BaseFragment.mActivity != null && !BaseFragment.mActivity.isFinishing()) {
                RoutePlanFragment.this.back(null);
            }
        }

        public void onReRouteComplete(Message msg) {
        }

        public void onReRouteCarFree(Message message) {
        }

        public void onArriveDestNear(Message msg) {
        }

        public void onArriveDest(Message msg) {
        }
    }

    /* renamed from: com.baidu.navi.fragment.RoutePlanFragment$9 */
    class C38319 implements C2302a {
        C38319() {
        }

        public void onClick() {
            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                RoutePlanFragment.this.endRecord();
                BaiduNaviSDKManager.getInstance().quitNavi();
            }
            RoutePlanFragment.this.removeAllFragmentByType(113);
            RoutePlanFragment.this.mIsFromRouteGuide = false;
            RoutePlanFragment.this.mShowBundle.putBoolean(RoutePlanFragment.KEY_FROM_ROUTE_GUIDE, false);
            RoutePlanFragment.this.routePlan();
        }
    }

    public void onInitMap() {
        super.onInitMap();
    }

    public void onAttach(Activity activity) {
        this.mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        this.mVerticalAdapter = new DragSortListAdapter(getContext(), this.mVerticalDragSortListener, this.mSrcData);
        this.mHistoryDataAdapter = new HistoryRouteAdapter(mActivity, this);
        super.onAttach(activity);
    }

    public void onDetach() {
        super.onDetach();
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mGroupView = (ViewGroup) inflater.inflate(C0965R.layout.frag_route_plan, null);
        this.mCleanHistoryLayout = inflater.inflate(C0965R.layout.common_listview_footer, null);
        this.mOrientation = mActivity.getResources().getConfiguration().orientation;
        this.mDragSortListView = (DragListView) this.mGroupView.findViewById(C0965R.id.drag_sort_list_1);
        this.mDividerHeight = ScreenUtil.getInstance().dip2px(1);
        setupView();
        return this.mGroupView;
    }

    protected void onInitView() {
        LogUtil.m15791e("RoutePlan", "onInitView start");
        initRoutePlanData(false);
        LogUtil.m15791e("RoutePlan", "onInitView end");
    }

    public boolean onBackPressed() {
        if (this.mPreferenceLayout != null && this.mPreferenceLayout.getVisibility() == 0) {
            closePreferenceDialog();
            return true;
        } else if (!this.mIsBackHome || mActivity == null || mActivity.isFinishing()) {
            return super.onBackPressed();
        } else {
            backTo(17, null);
            return true;
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == C0965R.id.ll_route_plan) {
            if (!ForbidDaulClickUtils.isFastDoubleClick() && !this.mDragSortListView.checkDragListIsOccpuy()) {
                if (this.mIsFromRouteGuide) {
                    showDialog(new C2304o(mActivity).f(C0965R.string.alert_exit_cur_navi).j(C0965R.string.alert_cancel).k(C0965R.string.alert_confirm).m().d(new C38319()));
                } else {
                    routePlan();
                }
                StatisticManager.onEvent(StatisticConstants.ROUTE_START, StatisticConstants.ROUTE_START);
            }
        } else if (id == C0965R.id.btn_clear_route) {
            initRoutePlanData(true);
            this.mDragSortListView.stopDrag();
            refreshDragListView();
            this.mVerticalAddNodeImageView.setVisibility(0);
            StatisticManager.onEvent(StatisticConstants.ROUTE_RESET, StatisticConstants.ROUTE_RESET);
        } else if (id == C0965R.id.iv_route_plan_add_btn) {
            addRoutePlanNode();
        }
    }

    public void onResume() {
        super.onResume();
        BNMapController.getInstance().onResume();
        BNRouteGuider.getInstance().addRGSubStatusListener(this.mOnRGSubStatusListener);
        handleArguments();
        requestAntiGeo();
        refreshDragListView();
        this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
    }

    public void onPause() {
        if (this.mAntiGeoThread != null && this.mAntiGeoThread.isAlive()) {
            this.mAntiGeoThread.interrupt();
        }
        this.mAntiGeoThread = null;
        BNPoiSearcher.getInstance().cancelQuery();
        BNRouteGuider.getInstance().removeRGSubStatusListener(this.mOnRGSubStatusListener);
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroyView() {
        this.isNeedInitial = true;
        if (this.mDragSortListView != null) {
            this.mDragSortListView.stopDrag();
        }
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
        super.onDestroyView();
    }

    private void refreshDragListView() {
        this.mVerticalAdapter.notifyDataSetChanged();
        ListViewUtils.setListViewHeightBasedOnChildren(this.mDragSortListView);
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {
            int totalHeight = 0;
            int listSize = listAdapter.getCount();
            for (int i = 0; i < listSize; i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            LayoutParams params = listView.getLayoutParams();
            params.height = (listView.getDividerHeight() * (listAdapter.getCount() - 1)) + totalHeight;
            listView.setLayoutParams(params);
        }
    }

    public void jumpRouteCustomDetail(int position) {
        RouteCustomController.getInstance().calcExtendRouteResult(this.mHistoryDataAdapter.getRoutePoiInfo(position), getNaviFragmentManager());
    }

    private void initRoutePlanData(boolean isClear) {
        this.mSrcData.clear();
        if (!isClear) {
            this.mSrcData.add(new RoutePlanNode(BNLocationManagerProxy.getInstance().getLastValidLocation(), 3, null, null));
        }
        LogUtil.m15791e("RoutePlan", "initRoutePlanData............enter, mSrcData.size() = " + this.mSrcData.size());
        while (this.mSrcData.size() < 2) {
            this.mSrcData.add(new RoutePlanNode());
        }
        if (this.mSrcData.size() < 2) {
            int lackCount = 2 - this.mSrcData.size();
            for (int j = 0; j < lackCount; j++) {
                this.mSrcData.add(new RoutePlanNode());
            }
        }
    }

    private void addRoutePlanNode() {
        if (mActivity != null) {
            int cnt = this.mSrcData.size();
            if (cnt < 5) {
                this.mSrcData.add(cnt - 1, new RoutePlanNode());
                refreshDragListView();
            } else {
                this.mVerticalAddNodeImageView.setVisibility(8);
            }
            if (this.mSrcData.size() == 5) {
                this.mVerticalAddNodeImageView.setVisibility(8);
            }
        }
    }

    private void renameRoutePlanNode(RoutePlanNode node, boolean renameMyPos) {
        if (node != null && mActivity != null) {
            switch (node.mFrom) {
                case 3:
                    if (renameMyPos) {
                        node.mName = StyleManager.getString(C0965R.string.nav_node_my_position, node.mName);
                        return;
                    }
                    return;
                case 4:
                    node.mName = StyleManager.getString(C0965R.string.nav_node_home);
                    return;
                case 5:
                    node.mName = StyleManager.getString(C0965R.string.nav_node_company);
                    return;
                default:
                    return;
            }
        }
    }

    private void pickRoutePlanTime() {
        int hour;
        int minute;
        LogUtil.m15791e("RoutePlan", "pickRoutePlanTime");
        RoutePlanTimeUtil routeTimeUtil = RoutePlanTimeUtil.getInstance();
        if (this.mHour < 0 || this.mMinute < 0) {
            hour = routeTimeUtil.getCurrerntHour();
            minute = routeTimeUtil.getCurrerntMinite();
        } else {
            hour = this.mHour;
            minute = this.mMinute;
        }
        TimePickerDialog timePickerDialognew = new TimePickerDialog(mActivity, this.mOnTimeSetListener, hour, minute, true);
        timePickerDialognew.setTitle(C0965R.string.route_plan_start_time_dialog_title);
        timePickerDialognew.show();
    }

    private void routePlan() {
        if (this.mSrcData.size() < 1) {
            TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.route_plan_toast_route_node_not_complete);
            return;
        }
        RoutePlanNode startNode = (RoutePlanNode) this.mSrcData.get(0);
        if (startNode == null || (startNode.getLatitudeE6() <= 0 && startNode.getLongitudeE6() <= 0)) {
            TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.route_plan_toast_route_node_not_complete);
            return;
        }
        if (3 == startNode.mFrom && !startNode.isNodeSettedData()) {
            BNLocationManagerProxy locManager = BNLocationManagerProxy.getInstance();
            if (locManager.isLocationValid()) {
                ((RoutePlanNode) this.mSrcData.get(0)).copy(locManager.getCurLocationNode());
            } else {
                TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.route_plan_toast_loc_invalid);
                return;
            }
        }
        if (3 == startNode.mFrom) {
            LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
            if (!(locData == null || startNode == null || locData.type != 61)) {
                startNode.mGPSAccuracy = locData.accuracy;
                startNode.mGPSSpeed = locData.speed;
            }
        }
        startNode = (RoutePlanNode) this.mSrcData.get(0);
        if (startNode == null || !startNode.isNodeSettedData()) {
            TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.route_plan_toast_route_node_not_complete);
            return;
        }
        ArrayList<RoutePlanNode> navNodeList = new ArrayList();
        int srcSize = this.mSrcData.size();
        int i = 0;
        while (i < srcSize) {
            RoutePlanNode node = (RoutePlanNode) this.mSrcData.get(i);
            if (this.mSrcData.size() > 2 && i >= 1 && i < this.mSrcData.size() - 1) {
                node.clearSubPoiList();
            }
            if (node.isNodeSettedData()) {
                navNodeList.add(node);
            }
            i++;
        }
        if (navNodeList.size() >= 2) {
            BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
            BNRoutePlaner.getInstance().setPointsToCalcRoute(navNodeList);
            StatisticUtils.statSetDestFromRoutePlan();
            return;
        }
        TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.route_plan_toast_route_node_not_complete);
    }

    protected void onUpdateOrientation(int orientation) {
        LogUtil.m15791e("RoutePlan", "onUpdateOrientation orientation=" + orientation);
        if (this.mGroupView != null && mActivity != null) {
            this.mOrientation = mActivity.getResources().getConfiguration().orientation;
            this.mVerticalAdapter.notifyDataSetChanged();
            setListViewHeightBasedOnChildren(this.mDragSortListView);
            this.mHistoryDataAdapter.setOrientation(orientation);
            this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
        }
    }

    protected void onUpdateStyle(boolean dayStyle) {
        this.mScrollView.setBackgroundColor(StyleManager.getColor(C0965R.color.quick_route_background));
        this.mVerticalAddNodeImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_rp_btn_add));
        this.mVerticalHistoryRouteList.setDivider(StyleManager.getDrawable(C0965R.drawable.divide_list));
        this.mDragSortListView.setDivider(StyleManager.getDrawable(C0965R.drawable.divide_list));
        this.mVerticalHistoryRouteList.setDividerHeight(this.mDividerHeight);
        this.mDragSortListView.setDividerHeight(this.mDividerHeight);
        this.mDivider1.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
        this.mDivider2.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
        int color = StyleManager.getColor(C0965R.color.history_dest_text_view_text_color);
        this.mHistoryRouteText.setTextColor(color);
        this.mCleanHistoryRouteBtn.setTextColor(color);
        this.mCleanHistoryLayout.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.history_list_item_bg_selector));
        this.mHistoryRouteTextLayout.setBackgroundColor(StyleManager.getColor(C0965R.color.history_dest_text_view_background));
        refreshDragListView();
        this.mHistoryDataAdapter.notifyHistoryDataSetChanged();
    }

    private void setupView() {
        LogUtil.m15791e("RoutePlan", "setupView mOrientation=" + this.mOrientation);
        if (mActivity != null) {
            findViews();
            if (this.mCleanHistoryRouteBtn != null) {
                this.mCleanHistoryRouteBtn.setVisibility(0);
            }
            this.mCleanHistoryLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    RoutePlanFragment.this.mHistoryDataAdapter.showCleanAllHistoryDialog();
                    StatisticManager.onEvent(StatisticConstants.ROUTE_CLEARHISTORY, StatisticConstants.ROUTE_CLEARHISTORY);
                }
            });
            this.mBtnBack.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (RoutePlanFragment.this.mIsBackHome) {
                        if (!(BaseFragment.mActivity == null || BaseFragment.mActivity.isFinishing())) {
                            RoutePlanFragment.this.backTo(NaviFragmentManager.TYPE_HOME, null);
                        }
                    } else if (!(BaseFragment.mActivity == null || BaseFragment.mActivity.isFinishing())) {
                        RoutePlanFragment.this.back(null);
                    }
                    StatisticManager.onEvent(StatisticConstants.ROUTE_RETURN, StatisticConstants.ROUTE_RETURN);
                }
            });
            this.mBtnOpenPreference.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                        RoutePlanFragment.this.mPreferenceLayout.setVisibility(0);
                        RoutePlanFragment.this.setupPreferenceList();
                    }
                }
            });
            this.mPreferenceLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                }
            });
            if (this.mClearRouteButton != null) {
                this.mClearRouteButton.setVisibility(0);
                this.mClearRouteButton.setOnClickListener(this);
            }
            if (this.mRouteplanButton != null) {
                this.mRouteplanButton.setVisibility(0);
                this.mRouteplanButton.setOnClickListener(this);
            }
            if (this.mVerticalAddNodeImageView != null) {
                this.mVerticalAddNodeImageView.setVisibility(0);
                this.mVerticalAddNodeImageView.setOnClickListener(this);
            }
            if (this.mVerticalHistoryRouteList != null) {
                this.mVerticalHistoryRouteList.setVisibility(0);
                setupHistoryListView();
            }
            setupDragListView();
            refreshDragListView();
            LogUtil.m15791e("RoutePlan", "setupView()................leave");
        }
    }

    private void setupHistoryListView() {
        this.mHistoryDataAdapter.setListView(this.mVerticalHistoryRouteList);
        this.mHistoryDataAdapter.setCleanHistoryLayout(this.mCleanHistoryLayout);
        this.mVerticalHistoryRouteList.addFooterView(this.mCleanHistoryLayout);
        this.mVerticalHistoryRouteList.setAdapter(this.mHistoryDataAdapter);
        this.mVerticalHistoryRouteList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                    final int pos = position;
                    if (RoutePlanFragment.this.mIsFromRouteGuide) {
                        RoutePlanFragment.this.showDialog(new C2304o(BaseFragment.mActivity).f(C0965R.string.alert_exit_cur_navi).j(C0965R.string.alert_cancel).k(C0965R.string.alert_confirm).m().d(new C2302a() {
                            public void onClick() {
                                if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                                    RoutePlanFragment.this.endRecord();
                                    BaiduNaviSDKManager.getInstance().quitNavi();
                                }
                                RoutePlanFragment.this.removeAllFragmentByType(113);
                                RoutePlanFragment.this.mIsFromRouteGuide = false;
                                RoutePlanFragment.this.mShowBundle.putBoolean(RoutePlanFragment.KEY_FROM_ROUTE_GUIDE, false);
                                ArrayList<RoutePlanNode> poiList = RoutePlanFragment.this.mHistoryDataAdapter.getRoutePoiInfo(pos);
                                BNRoutePlaner.getInstance().addRouteResultHandler(RoutePlanFragment.this.mRPHandler);
                                BNRoutePlaner.getInstance().setPointsToCalcRoute(poiList, 1);
                            }
                        }));
                    } else {
                        ArrayList<RoutePlanNode> poiList = RoutePlanFragment.this.mHistoryDataAdapter.getRoutePoiInfo(position);
                        BNRoutePlaner.getInstance().addRouteResultHandler(RoutePlanFragment.this.mRPHandler);
                        BNRoutePlaner.getInstance().setPointsToCalcRoute(poiList);
                    }
                    StatisticUtils.statSetDestFromHistoryRoute();
                    StatisticManager.onEvent(StatisticConstants.ROUTE_HISTORY, StatisticConstants.ROUTE_HISTORY);
                }
            }
        });
        this.mVerticalHistoryRouteList.setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                    RoutePlanFragment.this.mHistoryDataAdapter.showDelHistoryItemDialog(arg2);
                }
                return false;
            }
        });
    }

    private void setupDragListView() {
        if (this.mDragSortListView != null) {
            this.mDragSortListView.setVisibility(0);
            this.mDragSortListView.setOnItemClickListener(this.mItemVerticalClickListener);
            this.mDragSortListView.setAdapter(this.mVerticalAdapter);
        }
    }

    private void findViews() {
        this.mAboveLayout = this.mGroupView.findViewById(C0965R.id.rl_route_plan_start_node);
        this.mRouteplanButton = (Button) this.mGroupView.findViewById(C0965R.id.ll_route_plan);
        this.mClearRouteButton = (Button) this.mGroupView.findViewById(C0965R.id.btn_clear_route);
        this.mDragSortListView = (DragListView) this.mGroupView.findViewById(C0965R.id.drag_sort_list_1);
        this.mVerticalAddNodeImageView = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_route_plan_add_btn);
        this.mDivider1 = (ImageView) this.mGroupView.findViewById(C0965R.id.route_and_clear_layout_top_divider);
        this.mHistoryRouteTextLayout = (LinearLayout) this.mGroupView.findViewById(C0965R.id.history_text_layout);
        this.mHistoryRouteText = (TextView) this.mGroupView.findViewById(C0965R.id.histroy_text_view);
        this.mVerticalHistoryRouteList = (ListView) this.mGroupView.findViewById(C0965R.id.history_route_list);
        this.mCleanHistoryRouteBtn = (TextView) this.mCleanHistoryLayout.findViewById(C0965R.id.btn_clear_history_desc);
        this.mDivider2 = (ImageView) this.mCleanHistoryLayout.findViewById(C0965R.id.clear_history_desc_divider);
        this.mPreferenceLayout = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.preference_list_layout);
        this.mBtnBack = (ImageView) this.mGroupView.findViewById(C0965R.id.ic_back);
        this.mBtnOpenPreference = (ImageView) this.mGroupView.findViewById(C0965R.id.ic_open_preference);
        this.mScrollView = (ScrollView) this.mGroupView.findViewById(C0965R.id.scroll_view_layout);
    }

    private void handleArguments() {
        if (this.mRoutePlanModel.isSelectNode()) {
            LogUtil.m15791e("RoutePlan", "isSelectNode Back");
            PointSelectNode selectNode = this.mRoutePlanModel.getPointSelectNode();
            if (selectNode.getRoutePlanNode().isNodeSettedData()) {
                int index = selectNode.getPointIndex();
                if (index == this.mSrcData.size()) {
                    this.mSrcData.add(index - 1, selectNode.getRoutePlanNode());
                    refreshDragListView();
                    LogUtil.m15791e("RoutePlan", "~~~ add Via Node " + ((RoutePlanNode) this.mSrcData.get(index - 1)).toString());
                } else if (index >= 0 && index < this.mSrcData.size()) {
                    ((RoutePlanNode) this.mSrcData.get(index)).copy(selectNode.getRoutePlanNode());
                }
            }
            this.mRoutePlanModel.clearSelectNode();
            return;
        }
        if (this.mShowBundle != null) {
            this.mIsFromRouteGuide = this.mShowBundle.getBoolean(KEY_FROM_ROUTE_GUIDE, false);
            this.mIsFromPoiDetail = this.mShowBundle.getBoolean(KEY_FROM_POI_DETAIL, false);
        }
        RoutePlanNode node;
        if (this.mIsFromRouteGuide) {
            ArrayList<RoutePlanNode> navNodeList = this.mRoutePlanModel.getRouteInput();
            int pointCount = navNodeList.size();
            if (pointCount >= 2) {
                this.mSrcData.clear();
                int pastViaNum = pointCount - 1;
                int remainedDestsNum = BNRoutePlaner.getInstance().getRemainedDests();
                LogUtil.m15791e("RoutePlan", "pointCount: " + pointCount + ", remainedDestsNum: " + remainedDestsNum);
                if (remainedDestsNum >= 0) {
                    pastViaNum -= remainedDestsNum;
                } else {
                    pastViaNum = 0;
                }
                for (int i = 0; i < pointCount; i++) {
                    if (i <= 0 || pastViaNum <= 0) {
                        node = new RoutePlanNode((RoutePlanNode) navNodeList.get(i));
                        LogUtil.m15791e("RoutePlan", "Node[" + i + "]:" + node.toString());
                        if (3 == node.mFrom) {
                            RoutePlanNode myPos = BNSysLocationManager.getInstance().getCurLocationNode();
                            if (myPos != null && myPos.isNodeSettedData()) {
                                node.copy(myPos);
                                LogUtil.m15791e("RoutePlan", "SysLocation Node[" + i + "]:" + node.toString());
                            }
                        }
                        renameRoutePlanNode(node, false);
                        LogUtil.m15791e("RoutePlan", "Last Node[" + i + "]:" + node.toString());
                        this.mSrcData.add(new RoutePlanNode(node));
                    } else {
                        pastViaNum--;
                    }
                }
            }
        } else if (this.mIsFromPoiDetail) {
            int poiType = this.mShowBundle.getInt(KEY_SET_POI_TYPE, -1);
            if (poiType != -1) {
                node = this.mRoutePlanModel.getPointPoiDetail();
                int size = this.mSrcData.size();
                if (node.isNodeSettedData()) {
                    if (poiType == 0) {
                        ((RoutePlanNode) this.mSrcData.get(0)).copy(node);
                    } else if (poiType == 2) {
                        ((RoutePlanNode) this.mSrcData.get(size - 1)).copy(node);
                    } else if (poiType == 1) {
                        RoutePlanNode newNode = new RoutePlanNode();
                        newNode.copy(node);
                        this.mSrcData.add(size - 1, newNode);
                    }
                }
                this.mRoutePlanModel.clearPointPoiDetail();
            }
        }
    }

    private void fillAntiGeo(GeoPoint geoPoint, SearchPoi poi) {
        if (geoPoint != null && poi != null) {
            int size = this.mSrcData.size();
            for (int i = 0; i < size; i++) {
                RoutePlanNode node = (RoutePlanNode) this.mSrcData.get(i);
                if (node.mGeoPoint.equals(geoPoint)) {
                    node.mName = poi.mName;
                    node.mDescription = poi.mAddress;
                }
            }
            refreshDragListView();
        }
    }

    private void requestAntiGeo() {
        final Vector<RoutePlanNode> routePlanData = new Vector();
        Iterator it = this.mSrcData.iterator();
        while (it.hasNext()) {
            routePlanData.add(new RoutePlanNode((RoutePlanNode) it.next()));
        }
        this.mAntiGeoThread = new Thread(getClass().getSimpleName()) {
            public void run() {
                int size = routePlanData.size();
                for (int i = 0; i < size; i++) {
                    RoutePlanNode node = (RoutePlanNode) routePlanData.get(i);
                    if (1 == node.mFrom) {
                        if (node.isNodeSettedData() && (TextUtils.isEmpty(node.mName) || StyleManager.getString(C0965R.string.bnav_string_route_plan_map_point).equals(node.mName))) {
                            RoutePlanFragment.this.asynGetPoiByPoint(node.mGeoPoint);
                        }
                    } else if (3 == node.mFrom && BaseFragment.mActivity != null && (TextUtils.isEmpty(node.mName) || StyleManager.getString(C0965R.string.route_plan_start_my_pos).equals(node.mName))) {
                        RoutePlanFragment.this.asynGetPoiByPoint(node.mGeoPoint);
                    }
                }
            }
        };
        this.mAntiGeoThread.start();
    }

    private void asynGetPoiByPoint(GeoPoint geoPoint) {
        boolean flag = false;
        while (!flag) {
            flag = BNPoiSearcher.getInstance().asynGetPoiByPoint(geoPoint, 10000, this.mUIHandler);
        }
    }

    private String getRoutePlanNodeName(RoutePlanNode node) {
        String reStr = "";
        if (node == null || !node.isNodeSettedData()) {
            return reStr;
        }
        switch (node.mFrom) {
            case 1:
                if (StringUtils.isEmpty(node.mName)) {
                    reStr = StyleManager.getString(C0965R.string.bnav_string_route_plan_map_point);
                } else {
                    reStr = node.mName;
                }
                break;
            case 3:
                String myPosition = StyleManager.getString(C0965R.string.bnav_string_route_plan_node_my_pos);
                reStr = StringUtils.isEmpty(node.mName) ? myPosition : myPosition + "(" + node.mName + ")";
                break;
            case 4:
                String home = StyleManager.getString(C0965R.string.bnav_string_nav_node_home);
                reStr = StringUtils.isEmpty(node.mName) ? home : home + "(" + node.mName + ")";
                break;
            case 5:
                String company = StyleManager.getString(C0965R.string.bnav_string_nav_node_company);
                reStr = StringUtils.isEmpty(node.mName) ? company : company + "(" + node.mName + ")";
                break;
        }
        reStr = StringUtils.isEmpty(node.mName) ? StyleManager.getString(C0965R.string.bnav_string_rg_unknown_road) : node.mName;
        return reStr;
    }

    private void goToRoutePlanNodePage(int position) {
        if (!ForbidDaulClickUtils.isFastDoubleClick() && mActivity != null) {
            int poiType;
            String description = "";
            if (position == 0) {
                description = StyleManager.getString(C0965R.string.route_plan_start_node);
                poiType = 0;
            } else if (position == this.mSrcData.size() - 1) {
                description = StyleManager.getString(C0965R.string.route_plan_end_node);
                poiType = 2;
            } else {
                description = StyleManager.getString(C0965R.string.route_plan_end_node) + position;
                poiType = 1;
            }
            this.mRoutePlanModel.setPointSelectNodeInfo(position, description);
            Bundle b = new Bundle();
            b.putInt(BundleKey.FROM_FRAGMENT, 50);
            b.putInt(BundleKey.SELECT_POINT_ACTION, 1);
            b.putInt(KEY_SET_POI_TYPE, poiType);
            showFragment(51, b);
        }
    }

    private void setupPreferenceList() {
    }

    private void closePreferenceDialog() {
        if (this.mPreferenceLayout != null) {
            this.mPreferenceLayout.removeAllViews();
            this.mPreferenceLayout.setVisibility(8);
        }
    }

    private void endRecord() {
        LogUtil.m15791e("RoutePlan", "endRecord()");
        if (BNSettingManager.isRecordTrackEnable()) {
            new Thread(getClass().getSimpleName() + "_QuitRouteGuide") {
                public void run() {
                    RoutePlanNode node = BNLocationManagerProxy.getInstance().getCurLocationNode();
                    String tName = "未知路";
                    if (!(node == null || node.mName == null || node.mName.length() <= 0)) {
                        tName = node.mName;
                    }
                    String trackId = JNITrajectoryControl.sInstance.getCurrentUUID();
                    if (node != null && node.mGeoPoint != null && trackId == null) {
                    }
                }
            }.start();
        }
    }
}
