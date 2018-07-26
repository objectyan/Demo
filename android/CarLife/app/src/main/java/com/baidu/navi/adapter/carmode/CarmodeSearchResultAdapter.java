package com.baidu.navi.adapter.carmode;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.adapter.SearchResultAdapter.OnClickOnlineSearch;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.NameSearchFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import java.util.List;

public class CarmodeSearchResultAdapter extends BaseAdapter {
    public static final int SEARCH_MODE_NORMAL = 1;
    public static final int SEARCH_MODE_SETTING = 2;
    private static int TYPE_BTN = 2;
    private static int TYPE_FOOT_ITEM_NOME = 1;
    private static int TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE = 3;
    private static int TYPE_FOOT_ITEM_ONLINE_SEARCH = 2;
    private static int TYPE_ITEM = 1;
    private boolean isNeedAddOnlineBtn;
    private boolean isSetMode;
    private int[] mChildCnt;
    private int[] mChildIndex;
    private OnClickListener mClickListener;
    private Context mContext;
    private int mFootItemType;
    private NaviFragmentManager mFragmentManager;
    private LayoutInflater mLayoutInflater;
    private C1277e mOnDialogListener;
    private OnClickOnlineSearch mOnlineSearchListener;
    private int[] mParentCnt;
    private List<SearchPoi> mPoiList;
    private SearchPoiPager mSearchPoiPager;
    private final int mSearchPoiTagKey;
    private Bundle mShowBundle;

    /* renamed from: com.baidu.navi.adapter.carmode.CarmodeSearchResultAdapter$1 */
    class C36691 implements OnClickListener {
        C36691() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                int id = v.getId();
                Bundle bundle;
                if (id == C0965R.id.btn_poi_gonavi) {
                    if (!CarmodeSearchResultAdapter.this.isSetMode) {
                        Integer index = (Integer) v.getTag();
                        if (index != null && index.intValue() >= 0 && index.intValue() < CarmodeSearchResultAdapter.this.mPoiList.size()) {
                            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(CarmodeSearchResultAdapter.this.mPoiList);
                            bundle = new Bundle();
                            bundle.putInt("incoming_type", 83);
                            if (CarmodeSearchResultAdapter.this.mSearchPoiPager != null) {
                                bundle.putInt("search_result_mode", CarmodeSearchResultAdapter.this.mSearchPoiPager.getNetMode());
                            }
                            bundle.putInt("fc_type", 0);
                            bundle.putInt("current_poi", index.intValue());
                            bundle.putInt("current_child_count", CarmodeSearchResultAdapter.this.mChildCnt[index.intValue()]);
                            bundle.putInt("child_start_poi", CarmodeSearchResultAdapter.this.mChildIndex[index.intValue()]);
                            bundle.putIntArray("child_count_array", CarmodeSearchResultAdapter.this.mChildCnt);
                            bundle.putIntArray("parent_position_array", CarmodeSearchResultAdapter.this.mParentCnt);
                            bundle.putIntArray("child_start_array", CarmodeSearchResultAdapter.this.mChildIndex);
                            bundle.putInt(NameSearchFragment.COME_FROM, CarmodeSearchResultAdapter.this.mShowBundle.getInt(NameSearchFragment.COME_FROM));
                            if (CarmodeSearchResultAdapter.this.mFragmentManager != null) {
                                CarmodeSearchResultAdapter.this.mFragmentManager.showFragment(33, bundle);
                            }
                            SearchStatItem.getInstance().setResultIndex(index.intValue());
                            SearchStatItem.getInstance().onEvent();
                        }
                    }
                } else if (id == C0965R.id.poi_name_addr_layout) {
                    SearchPoi searchPoi;
                    if (CarmodeSearchResultAdapter.this.isPoiComfirmPage()) {
                        searchPoi = (SearchPoi) v.getTag(C0965R.id.poi_name_addr_layout);
                        if (CarmodeSearchResultAdapter.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION) == 1) {
                            FavoriteDestinationController.getInstance().addFavoriteDestFromDB(CarmodeSearchResultAdapter.this.createRoutePlanNode(searchPoi), null);
                        } else {
                            bundle = new Bundle();
                            bundle.putInt(BundleKey.SELECT_POINT_ACTION, CarmodeSearchResultAdapter.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION));
                            UIModel.settingAddress(searchPoi, CarmodeSearchResultAdapter.this.mContext, bundle);
                        }
                        CarmodeSearchResultAdapter.this.mFragmentManager.backTo(CarmodeSearchResultAdapter.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                        return;
                    }
                    searchPoi = (SearchPoi) v.getTag();
                    if (searchPoi != null && !CarmodeSearchResultAdapter.this.isSetMode) {
                        if (CarmodeSearchResultAdapter.this.mShowBundle.getInt(NameSearchFragment.COME_FROM) == 8) {
                            StatisticManager.onEvent(StatisticConstants.DISCOVER_QJY_0002, StatisticConstants.DISCOVER_QJY_0002);
                        }
                        NavPoiController.getInstance().startCalcRoute(searchPoi);
                    }
                } else if (id == C0965R.id.search_btn) {
                    CarmodeSearchResultAdapter.this.clickSearchBtn();
                }
            }
        }
    }

    protected class ChildGrideListAdapter extends BaseAdapter {
        private OnClickListener mChildClickListener = new C36701();
        int mChildCount = 0;
        int mChildsum = 0;
        Context mContext;
        int mParentPosition = 0;

        /* renamed from: com.baidu.navi.adapter.carmode.CarmodeSearchResultAdapter$ChildGrideListAdapter$1 */
        class C36701 implements OnClickListener {
            C36701() {
            }

            public void onClick(View v) {
                if (!CarmodeSearchResultAdapter.this.isSetMode && !ForbidDaulClickUtils.isFastDoubleClick()) {
                    Integer poiIndex = (Integer) v.getTag();
                    if (CarmodeSearchResultAdapter.this.mPoiList != null) {
                        SearchPoi poi = (SearchPoi) CarmodeSearchResultAdapter.this.mPoiList.get(poiIndex.intValue());
                        if (poi != null) {
                            String str = poi.mName;
                        }
                    }
                    if (poiIndex != null && poiIndex.intValue() >= 0 && poiIndex.intValue() < CarmodeSearchResultAdapter.this.mPoiList.size()) {
                        SearchStatItem.getInstance().searchStatistics(poiIndex.intValue());
                        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(CarmodeSearchResultAdapter.this.mSearchPoiPager.getPoiList());
                        Bundle bundle = new Bundle();
                        bundle.putInt("fc_type", 1);
                        bundle.putInt("incoming_type", 83);
                        bundle.putInt("search_result_mode", CarmodeSearchResultAdapter.this.mSearchPoiPager.getNetMode());
                        bundle.putInt("current_poi", poiIndex.intValue());
                        bundle.putInt("child_start_poi", ChildGrideListAdapter.this.mChildsum);
                        bundle.putInt("current_child_count", ChildGrideListAdapter.this.mChildCount);
                        bundle.putInt("current_parent_position", ChildGrideListAdapter.this.mParentPosition);
                        bundle.putIntArray("child_count_array", CarmodeSearchResultAdapter.this.mChildCnt);
                        bundle.putIntArray("parent_position_array", CarmodeSearchResultAdapter.this.mParentCnt);
                        bundle.putIntArray("child_start_array", CarmodeSearchResultAdapter.this.mChildIndex);
                        if (CarmodeSearchResultAdapter.this.mFragmentManager != null) {
                            CarmodeSearchResultAdapter.this.mFragmentManager.showFragment(33, bundle);
                        }
                    }
                }
            }
        }

        protected class ViewHolder {
            TextView mChildName;
            ImageView mIcDot;

            protected ViewHolder() {
            }
        }

        public ChildGrideListAdapter(Context mContext) {
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
            convertView = CarmodeSearchResultAdapter.this.mLayoutInflater.inflate(C0965R.layout.carmode_search_result_list_child_item, null);
            holder.mChildName = (TextView) convertView.findViewById(C0965R.id.tv_child_name);
            holder.mIcDot = (ImageView) convertView.findViewById(C0965R.id.ic_child_dot);
            convertView.setTag(holder);
            holder.mChildName.setText(((SearchPoi) CarmodeSearchResultAdapter.this.mPoiList.get(this.mChildsum + position)).mAliasName);
            convertView.setTag(Integer.valueOf(this.mChildsum + position));
            convertView.setOnClickListener(this.mChildClickListener);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(32)));
            return convertView;
        }
    }

    static class ViewHodler {
        View mBtnNameAddr;
        View mBtnStartNavi;
        GridView mChildGrideList;
        View mHorDeverder;
        View mHorDiverderB;
        ImageView mIcResult;
        TextView mTvAddr;
        TextView mTvDistance;
        TextView mTvName;
        TextView mTvNum;
        View mVerDiverderA;

        ViewHodler() {
        }
    }

    public CarmodeSearchResultAdapter(Context context, SearchPoiPager searchPoiPager, NaviFragmentManager fragmentManager, boolean isSetMode, C1277e listener) {
        this.isNeedAddOnlineBtn = false;
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.mParentCnt = new int[200];
        this.mFootItemType = TYPE_FOOT_ITEM_NOME;
        this.mSearchPoiTagKey = C0965R.id.poi_name_addr_layout;
        this.mClickListener = new C36691();
        this.mPoiList = searchPoiPager.getPoiList();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.mSearchPoiPager = searchPoiPager;
        this.mFragmentManager = fragmentManager;
        this.isSetMode = isSetMode;
        setSearchPager(searchPoiPager);
        this.mChildIndex[0] = searchPoiPager.getCountPerPager();
        this.mOnDialogListener = listener;
    }

    public CarmodeSearchResultAdapter(Context context, List<SearchPoi> list, NaviFragmentManager fragmentManager, boolean isSetMode) {
        int i = 10;
        this.isNeedAddOnlineBtn = false;
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.mParentCnt = new int[200];
        this.mFootItemType = TYPE_FOOT_ITEM_NOME;
        this.mSearchPoiTagKey = C0965R.id.poi_name_addr_layout;
        this.mClickListener = new C36691();
        if (list != null) {
            this.mPoiList = list;
            this.mContext = context;
            this.mLayoutInflater = LayoutInflater.from(this.mContext);
            this.mFragmentManager = fragmentManager;
            this.isSetMode = isSetMode;
            this.mFootItemType = TYPE_FOOT_ITEM_NOME;
            int[] iArr = this.mChildIndex;
            if (list.size() <= 10) {
                i = list.size();
            }
            iArr[0] = i;
        }
    }

    public void setSearchPager(SearchPoiPager searchPoiPager) {
        int districtId = 0;
        this.mSearchPoiPager = searchPoiPager;
        this.mPoiList = searchPoiPager.getPoiList();
        this.mChildIndex[0] = searchPoiPager.getCountPerPager();
        int netMode = this.mSearchPoiPager.getNetMode();
        int searchType = this.mSearchPoiPager.getSearchType();
        if (searchType == 1 || searchType == 2) {
            DistrictInfo districtInfo = this.mSearchPoiPager.getDistrct();
            if (districtInfo != null) {
                districtId = districtInfo.mId;
            }
            if (districtId == 0 || !NetworkUtils.getConnectStatus()) {
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
        notifyDataSetChanged();
    }

    public int getCount() {
        if (this.mPoiList == null) {
            return 0;
        }
        int size = 10;
        if (this.mChildIndex != null && this.mChildIndex[0] > 0) {
            size = this.mPoiList.size() >= this.mChildIndex[0] ? this.mChildIndex[0] : this.mPoiList.size();
        }
        return this.mFootItemType != TYPE_FOOT_ITEM_NOME ? size + 1 : size;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        int size = 10;
        if (this.mChildIndex != null && this.mChildIndex[0] > 0) {
            size = this.mPoiList.size() >= this.mChildIndex[0] ? this.mChildIndex[0] : this.mPoiList.size();
        }
        if (position == size) {
            convertView = this.mLayoutInflater.inflate(C0965R.layout.carmode_layout_search_item, null);
            TextView onlineSearch = (TextView) convertView.findViewById(C0965R.id.search_btn);
            if (this.mFootItemType == TYPE_FOOT_ITEM_ONLINE_SEARCH) {
                onlineSearch.setText(StyleManager.getString(C0965R.string.search_online_normal));
            } else {
                onlineSearch.setText(StyleManager.getString(C0965R.string.search_online_country));
            }
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(80)));
        } else {
            convertView = this.mLayoutInflater.inflate(C0965R.layout.carmode_search_result_list_item, null);
            ViewHodler viewHodler = new ViewHodler();
            viewHodler.mVerDiverderA = convertView.findViewById(C0965R.id.line_poi_vertical_a);
            viewHodler.mBtnStartNavi = convertView.findViewById(C0965R.id.btn_poi_gonavi);
            viewHodler.mBtnNameAddr = convertView.findViewById(C0965R.id.poi_name_addr_layout);
            viewHodler.mTvName = (TextView) convertView.findViewById(C0965R.id.tv_poi_title);
            viewHodler.mTvAddr = (TextView) convertView.findViewById(C0965R.id.tv_poi_addr);
            viewHodler.mTvDistance = (TextView) convertView.findViewById(C0965R.id.tv_poi_distance_new);
            viewHodler.mTvNum = (TextView) convertView.findViewById(C0965R.id.tv_num);
            viewHodler.mHorDeverder = convertView.findViewById(C0965R.id.line_poi_horizontal);
            viewHodler.mChildGrideList = (GridView) convertView.findViewById(C0965R.id.grideview);
            viewHodler.mIcResult = (ImageView) convertView.findViewById(C0965R.id.ic_result);
            viewHodler.mHorDiverderB = convertView.findViewById(C0965R.id.line_poi_horizontal_b);
            if (isPoiComfirmPage()) {
                viewHodler.mTvDistance.setVisibility(8);
                viewHodler.mBtnStartNavi.setVisibility(8);
                viewHodler.mHorDiverderB.setVisibility(8);
            } else {
                viewHodler.mTvDistance.setVisibility(0);
                viewHodler.mBtnStartNavi.setVisibility(0);
            }
            SearchPoi searchPoi = (SearchPoi) this.mPoiList.get(position);
            if (searchPoi != null) {
                if (isPoiComfirmPage()) {
                    viewHodler.mTvName.setText(searchPoi.mName);
                } else {
                    viewHodler.mTvNum.setText((position + 1) + ". ");
                    viewHodler.mTvName.setText(searchPoi.mName);
                }
                viewHodler.mTvAddr.setText(searchPoi.mAddress);
                viewHodler.mTvDistance.setText(PoiController.getInstance().getDistance2CurrentPoint(searchPoi));
            }
            viewHodler.mBtnNameAddr.setTag(searchPoi);
            viewHodler.mBtnNameAddr.setTag(C0965R.id.poi_name_addr_layout, searchPoi);
            viewHodler.mBtnStartNavi.setTag(Integer.valueOf(position));
            viewHodler.mBtnNameAddr.setOnClickListener(this.mClickListener);
            viewHodler.mBtnStartNavi.setOnClickListener(this.mClickListener);
            this.mChildCnt[position] = searchPoi.mChildCnt;
            if (position >= 1) {
                this.mChildIndex[position] = this.mChildIndex[position - 1] + this.mChildCnt[position - 1];
            }
            this.mParentCnt[position] = position;
            if (this.mChildCnt[position] <= 0) {
                viewHodler.mIcResult.setVisibility(8);
                convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(80)));
            }
        }
        return convertView;
    }

    public int[] getChildCnt() {
        return this.mChildCnt;
    }

    public int[] getChildIndex() {
        return this.mChildIndex;
    }

    public void setOnlineSearchListener(OnClickOnlineSearch listener) {
        this.mOnlineSearchListener = listener;
    }

    private RoutePlanNode createRoutePlanNode(SearchPoi node) {
        return new RoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
    }

    public void clickSearchBtn() {
        if (this.mOnlineSearchListener == null) {
            return;
        }
        if (this.mFootItemType == TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE) {
            this.mOnlineSearchListener.onCountrywideOnlineSearch();
        } else if (this.mFootItemType == TYPE_FOOT_ITEM_ONLINE_SEARCH) {
            this.mOnlineSearchListener.onNormalOnlineSearch();
        }
    }

    public void interPoidetail() {
        if (!this.isSetMode) {
            Integer index = Integer.valueOf(0);
            if (this.mPoiList != null) {
                SearchPoi poi = (SearchPoi) this.mPoiList.get(index.intValue());
                if (poi != null) {
                    String str = poi.mName;
                }
            }
            if (index != null && index.intValue() >= 0 && index.intValue() < this.mPoiList.size()) {
                ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(this.mPoiList);
                Bundle bundle = new Bundle();
                bundle.putInt("incoming_type", 83);
                if (this.mSearchPoiPager != null) {
                    bundle.putInt("search_result_mode", this.mSearchPoiPager.getNetMode());
                }
                bundle.putInt("fc_type", 0);
                bundle.putInt("current_poi", index.intValue());
                bundle.putInt("current_child_count", this.mChildCnt[index.intValue()]);
                bundle.putInt("child_start_poi", this.mChildIndex[index.intValue()]);
                bundle.putIntArray("child_count_array", this.mChildCnt);
                bundle.putIntArray("parent_position_array", this.mParentCnt);
                bundle.putIntArray("child_start_array", this.mChildIndex);
                if (this.mFragmentManager != null) {
                    this.mFragmentManager.showFragment(33, bundle);
                }
                SearchStatItem.getInstance().setResultIndex(index.intValue());
                SearchStatItem.getInstance().onEvent();
            }
        }
    }

    public void setShowBundle(Bundle bundle) {
        this.mShowBundle = bundle;
    }

    private boolean isPoiComfirmPage() {
        int action = this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION);
        if (action == 1 || action == 5 || action == 4) {
            return true;
        }
        return false;
    }
}
