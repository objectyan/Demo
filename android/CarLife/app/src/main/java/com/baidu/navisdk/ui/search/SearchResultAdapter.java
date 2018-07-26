package com.baidu.navisdk.ui.search;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter extends BaseAdapter {
    public static final int SEARCH_MODE_NORMAL = 1;
    public static final int SEARCH_MODE_SETTING = 2;
    private static int TYPE_BTN = 2;
    private static int TYPE_FOOT_ITEM_NOME = 1;
    private static int TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE = 3;
    private static int TYPE_FOOT_ITEM_ONLINE_SEARCH = 2;
    private static int TYPE_ITEM = 1;
    private boolean isNeedAddOnlineBtn = false;
    private boolean isSetMode;
    private int[] mChildCnt = new int[200];
    private int[] mChildIndex = new int[200];
    private OnClickListener mClickListener = new C44821();
    private Activity mContext;
    private int mFootItemType = TYPE_FOOT_ITEM_NOME;
    private IBNSearchResultListener mIBNSearchResultListener;
    private int mLastFocusIndex;
    private View mLastFocusView;
    private LayoutInflater mLayoutInflater;
    private int[] mParentCnt = new int[200];
    private ArrayList<SearchPoi> mPoiList;
    private SearchPoiPager mSearchPoiPager;
    private boolean mShowFocusItem = true;

    /* renamed from: com.baidu.navisdk.ui.search.SearchResultAdapter$1 */
    class C44821 implements OnClickListener {
        C44821() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                int id = v.getId();
                if (id == C4048R.id.par_infor_layout) {
                    TextView addr;
                    Integer index = (Integer) v.getTag();
                    if (SearchResultAdapter.this.mIBNSearchResultListener != null) {
                        SearchResultAdapter.this.mIBNSearchResultListener.goPoiDetailFragment(false, index.intValue(), SearchResultAdapter.this.isSetMode, SearchResultAdapter.this.mChildCnt, SearchResultAdapter.this.mChildIndex, SearchResultAdapter.this.mParentCnt);
                    }
                    if (SearchResultAdapter.this.mLastFocusView == null) {
                        SearchResultAdapter.this.mLastFocusView = v;
                    } else {
                        TextView name = (TextView) SearchResultAdapter.this.mLastFocusView.findViewById(C4048R.id.tv_poi_title);
                        addr = (TextView) SearchResultAdapter.this.mLastFocusView.findViewById(C4048R.id.tv_poi_addr);
                        ((TextView) SearchResultAdapter.this.mLastFocusView.findViewById(C4048R.id.tv_num)).setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_default_text));
                        name.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_default_text));
                        addr.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_line));
                        SearchResultAdapter.this.mLastFocusView = v;
                    }
                    SearchResultAdapter.this.mLastFocusIndex = index.intValue();
                    if (SearchResultAdapter.this.mShowFocusItem) {
                        addr = (TextView) v.findViewById(C4048R.id.tv_poi_addr);
                        TextView mTvNum = (TextView) v.findViewById(C4048R.id.tv_num);
                        ((TextView) v.findViewById(C4048R.id.tv_poi_title)).setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
                        addr.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
                        mTvNum.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
                    }
                } else if (id == C4048R.id.btn_poi_gonavi) {
                    SearchPoi searchPoi = (SearchPoi) v.getTag();
                    if (searchPoi != null) {
                        String key = searchPoi.mName;
                        LogUtil.m15791e("luoluo", "gonavi :--------->" + key);
                        int netMode = SearchResultAdapter.this.mSearchPoiPager.getNetMode();
                        if (netMode == 1 || netMode == 3) {
                            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.ROUTE_PLAN_BY_PARENT_NODE, key);
                            LogUtil.m15791e("BNStatisticsManager", "在线检索通过主点发起算路次数");
                        }
                        if (SearchResultAdapter.this.mIBNSearchResultListener != null) {
                            SearchResultAdapter.this.mIBNSearchResultListener.startGoNavi(SearchResultAdapter.this.isSetMode, searchPoi);
                        }
                    }
                }
            }
        }
    }

    protected class ChildGrideListAdapter extends BaseAdapter {
        private OnClickListener mChildClickListener = new C44831();
        private int mChildCount = 0;
        private int mChildsum = 0;
        private Activity mContext;
        private int mParentPosition = 0;

        /* renamed from: com.baidu.navisdk.ui.search.SearchResultAdapter$ChildGrideListAdapter$1 */
        class C44831 implements OnClickListener {
            C44831() {
            }

            public void onClick(View v) {
                if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                    Integer poiIndex = (Integer) v.getTag();
                    List<SearchPoi> mPoiList = SearchResultAdapter.this.mSearchPoiPager.getPoiList();
                    if (mPoiList != null) {
                        SearchPoi poi = (SearchPoi) mPoiList.get(poiIndex.intValue());
                        if (poi != null) {
                            String key = poi.mName;
                            int netMode = SearchResultAdapter.this.mSearchPoiPager.getNetMode();
                            if (netMode == 1 || netMode == 3) {
                                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.ROUTE_PLAN_BY_CHILD_NODE, key);
                                LogUtil.m15791e("BNStatisticsManager", "在线检索通过子点发起算路次数");
                            }
                            if (SearchResultAdapter.this.mIBNSearchResultListener != null) {
                                SearchResultAdapter.this.mIBNSearchResultListener.startGoNavi(SearchResultAdapter.this.isSetMode, poi);
                            }
                        }
                    }
                }
            }
        }

        protected class ViewHolder {
            TextView mChildName;

            protected ViewHolder() {
            }
        }

        public ChildGrideListAdapter(Activity mContext) {
            this.mContext = mContext;
        }

        public int getCount() {
            return this.mChildCount;
        }

        public void SetCount(int ChildCount) {
            this.mChildCount = ChildCount;
        }

        public void SetParentPosition(int ParentPosition) {
            this.mParentPosition = ParentPosition;
        }

        public void SetCountSUM(int ChildSUM) {
            this.mChildsum = ChildSUM;
        }

        public int GetCountSUM() {
            return this.mChildsum;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            return getItemView(convertView, position);
        }

        protected View getItemView(View convertView, int position) {
            ViewHolder holder = new ViewHolder();
            convertView = JarUtils.inflate(this.mContext, C4048R.layout.search_result_list_child_item, null);
            holder.mChildName = (TextView) convertView.findViewById(C4048R.id.tv_child_name);
            holder.mChildName.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_default_text));
            int index = position + this.mChildsum;
            if (index < SearchResultAdapter.this.mPoiList.size()) {
                holder.mChildName.setText(((SearchPoi) SearchResultAdapter.this.mPoiList.get(index)).mAliasName);
                convertView.setTag(Integer.valueOf(this.mChildsum + position));
                convertView.setOnClickListener(this.mChildClickListener);
            }
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(32)));
            return convertView;
        }
    }

    static class ViewHodler {
        View mBtnNameAddr;
        View mBtnStartNavi;
        GridView mChildGrideList;
        View mDivider;
        ImageView mIcResult;
        LinearLayout mLayoutChildBottom;
        View mParInforLayout;
        RelativeLayout mPoiParent;
        TextView mTvAddr;
        TextView mTvDistance;
        TextView mTvName;
        TextView mTvNum;
        TextView mTvStartNavi;
        View mVerDiverderA;

        ViewHodler() {
        }
    }

    public SearchResultAdapter(Activity context, SearchPoiPager searchPoiPager, boolean isSetMode) {
        this.mPoiList = searchPoiPager.getPoiList();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.mSearchPoiPager = searchPoiPager;
        this.isSetMode = isSetMode;
        setSearchPager(searchPoiPager);
        this.mChildIndex[0] = searchPoiPager.getCountPerPager();
        this.mLastFocusIndex = 0;
    }

    public void setSearchPager(SearchPoiPager searchPoiPager) {
        this.mSearchPoiPager = searchPoiPager;
        this.mPoiList = searchPoiPager.getPoiList();
        this.mChildIndex[0] = searchPoiPager.getCountPerPager();
        int netMode = this.mSearchPoiPager.getNetMode();
        int searchType = this.mSearchPoiPager.getSearchType();
        if (searchType == 1 || searchType == 2) {
            DistrictInfo districtInfo = this.mSearchPoiPager.getDistrct();
            if ((districtInfo == null ? 0 : districtInfo.mId) == 0 || !NetworkUtils.getConnectStatus()) {
                this.mFootItemType = TYPE_FOOT_ITEM_NOME;
            } else if (netMode == 0) {
                this.mFootItemType = TYPE_FOOT_ITEM_ONLINE_SEARCH;
            } else if (netMode == 1) {
                this.mFootItemType = TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE;
            }
        } else if (netMode == 0 && NetworkUtils.getConnectStatus()) {
            this.mFootItemType = TYPE_FOOT_ITEM_ONLINE_SEARCH;
        } else {
            this.mFootItemType = TYPE_FOOT_ITEM_NOME;
        }
        this.mLastFocusIndex = 0;
        notifyDataSetChanged();
    }

    public void setShowFocusItem(boolean showFocusItem) {
        this.mShowFocusItem = showFocusItem;
    }

    public void setFocusIndex(int index) {
        this.mLastFocusIndex = index;
    }

    public int getCount() {
        if (this.mPoiList == null) {
            return 0;
        }
        if (this.mChildIndex == null || this.mChildIndex[0] <= 0) {
            return 10;
        }
        return this.mPoiList.size() >= this.mChildIndex[0] ? this.mChildIndex[0] : this.mPoiList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if (this.mChildIndex != null && this.mChildIndex[0] > 0) {
            int size;
            if (this.mPoiList.size() >= this.mChildIndex[0]) {
                size = this.mChildIndex[0];
            } else {
                size = this.mPoiList.size();
            }
        }
        if (convertView == null) {
            convertView = JarUtils.inflate(this.mContext, C4048R.layout.search_result_list_item, null);
            viewHodler = new ViewHodler();
            viewHodler.mVerDiverderA = convertView.findViewById(C4048R.id.line_poi_vertical_a);
            viewHodler.mBtnStartNavi = convertView.findViewById(C4048R.id.btn_poi_gonavi);
            viewHodler.mBtnNameAddr = convertView.findViewById(C4048R.id.poi_name_addr_layout);
            viewHodler.mTvName = (TextView) convertView.findViewById(C4048R.id.tv_poi_title);
            viewHodler.mTvAddr = (TextView) convertView.findViewById(C4048R.id.tv_poi_addr);
            viewHodler.mTvStartNavi = (TextView) convertView.findViewById(C4048R.id.tv_poi_gonavi);
            viewHodler.mTvDistance = (TextView) convertView.findViewById(C4048R.id.tv_poi_distance);
            viewHodler.mTvNum = (TextView) convertView.findViewById(C4048R.id.tv_num);
            viewHodler.mChildGrideList = (GridView) convertView.findViewById(C4048R.id.grideview);
            viewHodler.mDivider = convertView.findViewById(C4048R.id.ls_divider);
            viewHodler.mIcResult = (ImageView) convertView.findViewById(C4048R.id.ic_result);
            viewHodler.mLayoutChildBottom = (LinearLayout) convertView.findViewById(C4048R.id.layout_child_bottom);
            viewHodler.mPoiParent = (RelativeLayout) convertView.findViewById(C4048R.id.btn_poi_parent);
            viewHodler.mParInforLayout = convertView.findViewById(C4048R.id.par_infor_layout);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        ChildGrideListAdapter mChildGrideListAdapter = new ChildGrideListAdapter(this.mContext);
        convertView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.poi_result_layout_background));
        viewHodler.mVerDiverderA.setBackgroundColor(BNStyleManager.getColor(C4048R.color.poi_line));
        viewHodler.mBtnStartNavi.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_bg_pressed_mask_selector));
        viewHodler.mBtnNameAddr.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_bg_pressed_mask_selector));
        if (this.mLastFocusIndex == position && this.mShowFocusItem) {
            this.mLastFocusView = viewHodler.mParInforLayout;
            viewHodler.mTvName.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mTvAddr.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
            viewHodler.mTvNum.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
        } else {
            viewHodler.mTvName.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_default_text));
            viewHodler.mTvAddr.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_line));
            viewHodler.mTvNum.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_default_text));
        }
        viewHodler.mTvStartNavi.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
        viewHodler.mTvDistance.setTextColor(BNStyleManager.getColor(C4048R.color.poi_search_text));
        viewHodler.mLayoutChildBottom.setBackgroundColor(BNStyleManager.getColor(C4048R.color.poi_result_layout_background));
        viewHodler.mChildGrideList.setAdapter(mChildGrideListAdapter);
        SearchPoi searchPoi = (SearchPoi) this.mPoiList.get(position);
        if (searchPoi != null) {
            viewHodler.mTvName.setText(searchPoi.mName);
            viewHodler.mTvAddr.setText(searchPoi.mAddress);
            viewHodler.mTvDistance.setText(this.mIBNSearchResultListener.getDistance(searchPoi));
        }
        viewHodler.mBtnStartNavi.setTag(searchPoi);
        viewHodler.mParInforLayout.setTag(Integer.valueOf(position));
        viewHodler.mParInforLayout.setOnClickListener(this.mClickListener);
        viewHodler.mBtnStartNavi.setOnClickListener(this.mClickListener);
        convertView.setTag(viewHodler);
        viewHodler.mTvNum.setText((position + 1) + ".");
        if (this.isSetMode) {
            viewHodler.mTvStartNavi.setText(BNStyleManager.getString(C4048R.string.detail_ok));
        }
        this.mChildCnt[position] = searchPoi.mChildCnt;
        if (position >= 1) {
            this.mChildIndex[position] = this.mChildIndex[position - 1] + this.mChildCnt[position - 1];
        }
        this.mParentCnt[position] = position;
        mChildGrideListAdapter.SetCount(this.mChildCnt[position]);
        mChildGrideListAdapter.SetCountSUM(this.mChildIndex[position]);
        mChildGrideListAdapter.SetParentPosition(this.mParentCnt[position]);
        mChildGrideListAdapter.notifyDataSetChanged();
        if (this.mChildCnt[position] <= 0) {
            viewHodler.mIcResult.setVisibility(8);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
        } else {
            viewHodler.mIcResult.setVisibility(8);
            int GridViewRows = (int) Math.ceil(((double) this.mChildCnt[position]) / 3.0d);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(((GridViewRows * 32) + 108) + ((GridViewRows - 1) * 16))));
        }
        return convertView;
    }

    public int[] getChildCnt() {
        return this.mChildCnt;
    }

    public int[] getChildIndex() {
        return this.mChildIndex;
    }

    public void setOnlineSearchListener(IBNSearchResultListener listener) {
        this.mIBNSearchResultListener = listener;
    }

    public OnClickListener getNameSearchResultListener() {
        return this.mClickListener;
    }

    public List<SearchPoi> getPoiList() {
        return this.mPoiList;
    }
}
