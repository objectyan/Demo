package com.baidu.navi.adapter;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
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
    private OnClickListener mClickListener = new C36651();
    private Context mContext;
    private int mFootItemType = TYPE_FOOT_ITEM_NOME;
    private NaviFragmentManager mFragmentManager;
    private LayoutInflater mLayoutInflater;
    private C1277e mOnDialogListener;
    private OnClickOnlineSearch mOnlineSearchListener;
    private int[] mParentCnt = new int[200];
    private ArrayList<SearchPoi> mPoiList;
    private SearchPoiPager mSearchPoiPager;
    private Bundle mShowBundle;

    /* renamed from: com.baidu.navi.adapter.SearchResultAdapter$1 */
    class C36651 implements OnClickListener {
        C36651() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                int id = v.getId();
                Bundle bundle;
                if (id == C0965R.id.poi_name_addr_layout) {
                    Integer index = (Integer) v.getTag();
                    if (SearchResultAdapter.this.mPoiList != null) {
                        SearchPoi poi = (SearchPoi) SearchResultAdapter.this.mPoiList.get(index.intValue());
                        if (poi != null) {
                            StatisticManager.onEvent("410135", poi.mName);
                        }
                    }
                    if (index != null && index.intValue() >= 0 && index.intValue() < SearchResultAdapter.this.mPoiList.size()) {
                        SearchStatItem.getInstance().searchStatistics(index.intValue());
                        if (!SearchResultAdapter.this.isSetMode) {
                            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(SearchResultAdapter.this.mSearchPoiPager.getPoiList());
                            bundle = new Bundle();
                            bundle.putInt("fc_type", 0);
                            bundle.putInt("incoming_type", 83);
                            bundle.putInt("search_result_mode", SearchResultAdapter.this.mSearchPoiPager.getNetMode());
                            bundle.putInt("current_poi", index.intValue());
                            bundle.putInt("current_child_count", SearchResultAdapter.this.mChildCnt[index.intValue()]);
                            bundle.putInt("child_start_poi", SearchResultAdapter.this.mChildIndex[index.intValue()]);
                            bundle.putInt("current_parent_position", SearchResultAdapter.this.mParentCnt[index.intValue()]);
                            bundle.putIntArray("child_count_array", SearchResultAdapter.this.mChildCnt);
                            bundle.putIntArray("parent_position_array", SearchResultAdapter.this.mParentCnt);
                            bundle.putIntArray("child_start_array", SearchResultAdapter.this.mChildIndex);
                            if (SearchResultAdapter.this.mFragmentManager != null) {
                                SearchResultAdapter.this.mFragmentManager.showFragment(33, bundle);
                            }
                        } else if (index.intValue() >= 0 && index.intValue() < SearchResultAdapter.this.mPoiList.size()) {
                            if (SearchResultAdapter.this.mChildCnt[index.intValue()] > 0) {
                                ArrayList<SearchPoi> mParChildPoiList = new ArrayList(SearchResultAdapter.this.mChildCnt[index.intValue()] + 1);
                                mParChildPoiList.add(SearchResultAdapter.this.mPoiList.get(index.intValue()));
                                for (int i = 0; i < SearchResultAdapter.this.mChildCnt[index.intValue()]; i++) {
                                    mParChildPoiList.add(SearchResultAdapter.this.mPoiList.get(SearchResultAdapter.this.mChildIndex[index.intValue()] + i));
                                }
                                PoiController.getInstance().focusPoi(mParChildPoiList, 0);
                                PoiController.getInstance().animationTo((SearchPoi) SearchResultAdapter.this.mPoiList.get(index.intValue()));
                                return;
                            }
                            PoiController.getInstance().focusPoi((SearchPoi) SearchResultAdapter.this.mPoiList.get(index.intValue()));
                            PoiController.getInstance().animationTo((SearchPoi) SearchResultAdapter.this.mPoiList.get(index.intValue()));
                        }
                    }
                } else if (id == C0965R.id.btn_poi_gonavi) {
                    StatisticManager.onEvent("410137", "410137");
                    SearchPoi searchPoi = (SearchPoi) v.getTag();
                    if (searchPoi == null) {
                        return;
                    }
                    if (!SearchResultAdapter.this.isSetMode) {
                        PoiController.getInstance().startCalcRoute(searchPoi, SearchResultAdapter.this.mOnDialogListener);
                    } else if (SearchResultAdapter.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION) == 1) {
                        ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointSelectNode(searchPoi);
                        SearchResultAdapter.this.mFragmentManager.backTo(SearchResultAdapter.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                    } else {
                        bundle = new Bundle();
                        bundle.putInt(BundleKey.SELECT_POINT_ACTION, SearchResultAdapter.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION));
                        UIModel.settingAddress(searchPoi, SearchResultAdapter.this.mContext, bundle);
                        SearchResultAdapter.this.mFragmentManager.backTo(SearchResultAdapter.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                    }
                } else if (id == C0965R.id.search_btn && SearchResultAdapter.this.mOnlineSearchListener != null) {
                    if (SearchResultAdapter.this.mFootItemType == SearchResultAdapter.TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE) {
                        SearchResultAdapter.this.mOnlineSearchListener.onCountrywideOnlineSearch();
                    } else if (SearchResultAdapter.this.mFootItemType == SearchResultAdapter.TYPE_FOOT_ITEM_ONLINE_SEARCH) {
                        SearchResultAdapter.this.mOnlineSearchListener.onNormalOnlineSearch();
                    }
                }
            }
        }
    }

    protected class ChildGrideListAdapter extends BaseAdapter {
        private OnClickListener mChildClickListener = new C36661();
        int mChildCount = 0;
        int mChildsum = 0;
        Context mContext;
        int mParentPosition = 0;

        /* renamed from: com.baidu.navi.adapter.SearchResultAdapter$ChildGrideListAdapter$1 */
        class C36661 implements OnClickListener {
            C36661() {
            }

            public void onClick(View v) {
                if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                    Integer poiIndex = (Integer) v.getTag();
                    if (SearchResultAdapter.this.mPoiList != null) {
                        SearchPoi poi = (SearchPoi) SearchResultAdapter.this.mPoiList.get(poiIndex.intValue());
                        if (poi != null) {
                            StatisticManager.onEvent("410135", poi.mName);
                        }
                    }
                    if (poiIndex != null && poiIndex.intValue() >= 0 && poiIndex.intValue() < SearchResultAdapter.this.mPoiList.size()) {
                        SearchStatItem.getInstance().searchStatistics(poiIndex.intValue());
                        if (!SearchResultAdapter.this.isSetMode) {
                            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(SearchResultAdapter.this.mSearchPoiPager.getPoiList());
                            Bundle bundle = new Bundle();
                            bundle.putInt("fc_type", 1);
                            bundle.putInt("incoming_type", 83);
                            bundle.putInt("search_result_mode", SearchResultAdapter.this.mSearchPoiPager.getNetMode());
                            bundle.putInt("current_poi", poiIndex.intValue());
                            bundle.putInt("child_start_poi", ChildGrideListAdapter.this.mChildsum);
                            bundle.putInt("current_child_count", ChildGrideListAdapter.this.mChildCount);
                            bundle.putInt("current_parent_position", ChildGrideListAdapter.this.mParentPosition);
                            bundle.putIntArray("child_count_array", SearchResultAdapter.this.mChildCnt);
                            bundle.putIntArray("parent_position_array", SearchResultAdapter.this.mParentCnt);
                            bundle.putIntArray("child_start_array", SearchResultAdapter.this.mChildIndex);
                            if (SearchResultAdapter.this.mFragmentManager != null) {
                                SearchResultAdapter.this.mFragmentManager.showFragment(33, bundle);
                            }
                        } else if (poiIndex.intValue() >= 0 && poiIndex.intValue() < SearchResultAdapter.this.mPoiList.size()) {
                            ArrayList<SearchPoi> mParChildPoiList = null;
                            if (ChildGrideListAdapter.this.mChildCount > 0) {
                                mParChildPoiList = new ArrayList(ChildGrideListAdapter.this.mChildCount + 1);
                                mParChildPoiList.add(SearchResultAdapter.this.mPoiList.get(ChildGrideListAdapter.this.mParentPosition));
                                for (int i = 0; i < ChildGrideListAdapter.this.mChildCount; i++) {
                                    mParChildPoiList.add(SearchResultAdapter.this.mPoiList.get(ChildGrideListAdapter.this.mChildsum + i));
                                }
                            }
                            PoiController.getInstance().focusPoi(mParChildPoiList, (poiIndex.intValue() - ChildGrideListAdapter.this.mChildsum) + 1);
                            PoiController.getInstance().animationTo((SearchPoi) SearchResultAdapter.this.mPoiList.get(poiIndex.intValue()));
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
            convertView = SearchResultAdapter.this.mLayoutInflater.inflate(C0965R.layout.search_result_list_child_item, null);
            holder.mChildName = (TextView) convertView.findViewById(C0965R.id.tv_child_name);
            holder.mIcDot = (ImageView) convertView.findViewById(C0965R.id.ic_child_dot);
            convertView.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_child_bg));
            holder.mChildName.setTextColor(StyleManager.getColor(C0965R.color.poi_name));
            holder.mIcDot.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.ic_search_dot));
            holder.mChildName.setText(((SearchPoi) SearchResultAdapter.this.mPoiList.get(this.mChildsum + position)).mAliasName);
            convertView.setTag(Integer.valueOf(this.mChildsum + position));
            convertView.setOnClickListener(this.mChildClickListener);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(32)));
            return convertView;
        }
    }

    public interface OnClickOnlineSearch {
        void onCountrywideOnlineSearch();

        void onNormalOnlineSearch();
    }

    static class ViewHodler {
        View mBtnNameAddr;
        View mBtnStartNavi;
        GridView mChildGrideList;
        View mDivider;
        ImageView mIcResult;
        LinearLayout mLayoutChildBottom;
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

    public SearchResultAdapter(Context context, SearchPoiPager searchPoiPager, NaviFragmentManager fragmentManager, boolean isSetMode, C1277e listener) {
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
            convertView = this.mLayoutInflater.inflate(C0965R.layout.layout_search_item, null);
            TextView onlineSearch = (TextView) convertView.findViewById(C0965R.id.search_btn);
            if (this.mFootItemType == TYPE_FOOT_ITEM_ONLINE_SEARCH) {
                onlineSearch.setText(StyleManager.getString(C0965R.string.search_online_normal));
            } else {
                onlineSearch.setText(StyleManager.getString(C0965R.string.search_online_country));
            }
            onlineSearch.setTextColor(StyleManager.getColor(C0965R.color.poi_gonavi));
            convertView.findViewById(C0965R.id.line_poi_horizontal).setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
            onlineSearch.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
            onlineSearch.setOnClickListener(this.mClickListener);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
        } else {
            convertView = this.mLayoutInflater.inflate(C0965R.layout.search_result_list_item, null);
            ViewHodler viewHodler = new ViewHodler();
            viewHodler.mVerDiverderA = convertView.findViewById(C0965R.id.line_poi_vertical_a);
            viewHodler.mBtnStartNavi = convertView.findViewById(C0965R.id.btn_poi_gonavi);
            viewHodler.mBtnNameAddr = convertView.findViewById(C0965R.id.poi_name_addr_layout);
            viewHodler.mTvName = (TextView) convertView.findViewById(C0965R.id.tv_poi_title);
            viewHodler.mTvAddr = (TextView) convertView.findViewById(C0965R.id.tv_poi_addr);
            viewHodler.mTvStartNavi = (TextView) convertView.findViewById(C0965R.id.tv_poi_gonavi);
            viewHodler.mTvDistance = (TextView) convertView.findViewById(C0965R.id.tv_poi_distance);
            viewHodler.mTvNum = (TextView) convertView.findViewById(C0965R.id.tv_num);
            viewHodler.mChildGrideList = (GridView) convertView.findViewById(C0965R.id.grideview);
            viewHodler.mDivider = convertView.findViewById(C0965R.id.ls_divider);
            viewHodler.mIcResult = (ImageView) convertView.findViewById(C0965R.id.ic_result);
            viewHodler.mLayoutChildBottom = (LinearLayout) convertView.findViewById(C0965R.id.layout_child_bottom);
            viewHodler.mPoiParent = (RelativeLayout) convertView.findViewById(C0965R.id.btn_poi_parent);
            ChildGrideListAdapter mChildGrideListAdapter = new ChildGrideListAdapter(this.mContext);
            convertView.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
            viewHodler.mVerDiverderA.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
            viewHodler.mBtnStartNavi.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
            viewHodler.mBtnNameAddr.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
            viewHodler.mTvName.setTextColor(StyleManager.getColor(C0965R.color.poi_name));
            viewHodler.mTvAddr.setTextColor(StyleManager.getColor(C0965R.color.poi_addr));
            viewHodler.mTvStartNavi.setTextColor(StyleManager.getColor(C0965R.color.poi_gonavi));
            viewHodler.mTvDistance.setTextColor(StyleManager.getColor(C0965R.color.poi_distance));
            viewHodler.mTvNum.setTextColor(StyleManager.getColor(C0965R.color.poi_num));
            viewHodler.mDivider.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
            viewHodler.mLayoutChildBottom.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_child_bg));
            viewHodler.mPoiParent.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
            viewHodler.mChildGrideList.setAdapter(mChildGrideListAdapter);
            SearchPoi searchPoi = (SearchPoi) this.mPoiList.get(position);
            if (searchPoi != null) {
                viewHodler.mTvName.setText(searchPoi.mName);
                viewHodler.mTvAddr.setText(searchPoi.mAddress);
                viewHodler.mTvDistance.setText(PoiController.getInstance().getDistance2CurrentPoint(searchPoi));
            }
            viewHodler.mBtnStartNavi.setTag(searchPoi);
            viewHodler.mBtnNameAddr.setTag(Integer.valueOf(position));
            viewHodler.mBtnNameAddr.setOnClickListener(this.mClickListener);
            viewHodler.mBtnStartNavi.setOnClickListener(this.mClickListener);
            viewHodler.mTvNum.setText((position + 1) + ".");
            if (this.isSetMode) {
                viewHodler.mTvStartNavi.setText(StyleManager.getString(C0965R.string.detail_ok));
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
                convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px((((int) Math.ceil(((double) this.mChildCnt[position]) / 3.0d)) * 32) + 90)));
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

    public OnClickListener getNameSearchResultListener() {
        return this.mClickListener;
    }

    public List<SearchPoi> getPoiList() {
        return this.mPoiList;
    }

    public void setShowBundle(Bundle bundle) {
        this.mShowBundle = bundle;
    }
}
