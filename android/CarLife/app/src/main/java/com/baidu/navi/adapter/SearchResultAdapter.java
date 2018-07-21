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
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
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

public class SearchResultAdapter
  extends BaseAdapter
{
  public static final int SEARCH_MODE_NORMAL = 1;
  public static final int SEARCH_MODE_SETTING = 2;
  private static int TYPE_BTN;
  private static int TYPE_FOOT_ITEM_NOME;
  private static int TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE = 3;
  private static int TYPE_FOOT_ITEM_ONLINE_SEARCH;
  private static int TYPE_ITEM = 1;
  private boolean isNeedAddOnlineBtn = false;
  private boolean isSetMode;
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private View.OnClickListener mClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ForbidDaulClickUtils.isFastDoubleClick()) {}
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  i = paramAnonymousView.getId();
                  if (i != 2131624193) {
                    break;
                  }
                  paramAnonymousView = (Integer)paramAnonymousView.getTag();
                  if (SearchResultAdapter.this.mPoiList != null)
                  {
                    localObject = (SearchPoi)SearchResultAdapter.this.mPoiList.get(paramAnonymousView.intValue());
                    if (localObject != null) {
                      StatisticManager.onEvent("410135", ((SearchPoi)localObject).mName);
                    }
                  }
                } while ((paramAnonymousView == null) || (paramAnonymousView.intValue() < 0) || (paramAnonymousView.intValue() >= SearchResultAdapter.this.mPoiList.size()));
                SearchStatItem.getInstance().searchStatistics(paramAnonymousView.intValue());
                if (SearchResultAdapter.this.isSetMode) {
                  break;
                }
                ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList(SearchResultAdapter.this.mSearchPoiPager.getPoiList());
                localObject = new Bundle();
                ((Bundle)localObject).putInt("fc_type", 0);
                ((Bundle)localObject).putInt("incoming_type", 83);
                ((Bundle)localObject).putInt("search_result_mode", SearchResultAdapter.this.mSearchPoiPager.getNetMode());
                ((Bundle)localObject).putInt("current_poi", paramAnonymousView.intValue());
                ((Bundle)localObject).putInt("current_child_count", SearchResultAdapter.this.mChildCnt[paramAnonymousView.intValue()]);
                ((Bundle)localObject).putInt("child_start_poi", SearchResultAdapter.this.mChildIndex[paramAnonymousView.intValue()]);
                ((Bundle)localObject).putInt("current_parent_position", SearchResultAdapter.this.mParentCnt[paramAnonymousView.intValue()]);
                ((Bundle)localObject).putIntArray("child_count_array", SearchResultAdapter.this.mChildCnt);
                ((Bundle)localObject).putIntArray("parent_position_array", SearchResultAdapter.this.mParentCnt);
                ((Bundle)localObject).putIntArray("child_start_array", SearchResultAdapter.this.mChildIndex);
              } while (SearchResultAdapter.this.mFragmentManager == null);
              SearchResultAdapter.this.mFragmentManager.showFragment(33, (Bundle)localObject);
              return;
            } while ((paramAnonymousView.intValue() < 0) || (paramAnonymousView.intValue() >= SearchResultAdapter.this.mPoiList.size()));
            if (SearchResultAdapter.this.mChildCnt[paramAnonymousView.intValue()] > 0)
            {
              localObject = new ArrayList(SearchResultAdapter.this.mChildCnt[paramAnonymousView.intValue()] + 1);
              ((ArrayList)localObject).add(SearchResultAdapter.this.mPoiList.get(paramAnonymousView.intValue()));
              i = 0;
              while (i < SearchResultAdapter.this.mChildCnt[paramAnonymousView.intValue()])
              {
                ((ArrayList)localObject).add(SearchResultAdapter.this.mPoiList.get(SearchResultAdapter.this.mChildIndex[paramAnonymousView.intValue()] + i));
                i += 1;
              }
              PoiController.getInstance().focusPoi((ArrayList)localObject, 0);
              PoiController.getInstance().animationTo((SearchPoi)SearchResultAdapter.this.mPoiList.get(paramAnonymousView.intValue()));
              return;
            }
            PoiController.getInstance().focusPoi((SearchPoi)SearchResultAdapter.this.mPoiList.get(paramAnonymousView.intValue()));
            PoiController.getInstance().animationTo((SearchPoi)SearchResultAdapter.this.mPoiList.get(paramAnonymousView.intValue()));
            return;
            if (i != 2131624190) {
              break;
            }
            StatisticManager.onEvent("410137", "410137");
            paramAnonymousView = (SearchPoi)paramAnonymousView.getTag();
          } while (paramAnonymousView == null);
          if (!SearchResultAdapter.this.isSetMode)
          {
            PoiController.getInstance().startCalcRoute(paramAnonymousView, SearchResultAdapter.this.mOnDialogListener);
            return;
          }
          if (SearchResultAdapter.this.mShowBundle.getInt("select_point_action") == 1)
          {
            ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointSelectNode(paramAnonymousView);
            SearchResultAdapter.this.mFragmentManager.backTo(SearchResultAdapter.this.mShowBundle.getInt("from_Fragment"), null);
            return;
          }
          Object localObject = new Bundle();
          ((Bundle)localObject).putInt("select_point_action", SearchResultAdapter.this.mShowBundle.getInt("select_point_action"));
          UIModel.settingAddress(paramAnonymousView, SearchResultAdapter.this.mContext, (Bundle)localObject);
          SearchResultAdapter.this.mFragmentManager.backTo(SearchResultAdapter.this.mShowBundle.getInt("from_Fragment"), null);
          return;
        } while ((i != 2131624530) || (SearchResultAdapter.this.mOnlineSearchListener == null));
        if (SearchResultAdapter.this.mFootItemType == SearchResultAdapter.TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE)
        {
          SearchResultAdapter.this.mOnlineSearchListener.onCountrywideOnlineSearch();
          return;
        }
      } while (SearchResultAdapter.this.mFootItemType != SearchResultAdapter.TYPE_FOOT_ITEM_ONLINE_SEARCH);
      SearchResultAdapter.this.mOnlineSearchListener.onNormalOnlineSearch();
    }
  };
  private Context mContext;
  private int mFootItemType = TYPE_FOOT_ITEM_NOME;
  private NaviFragmentManager mFragmentManager;
  private LayoutInflater mLayoutInflater;
  private e mOnDialogListener;
  private OnClickOnlineSearch mOnlineSearchListener;
  private int[] mParentCnt = new int['È'];
  private ArrayList<SearchPoi> mPoiList;
  private SearchPoiPager mSearchPoiPager;
  private Bundle mShowBundle;
  
  static
  {
    TYPE_BTN = 2;
    TYPE_FOOT_ITEM_NOME = 1;
    TYPE_FOOT_ITEM_ONLINE_SEARCH = 2;
  }
  
  public SearchResultAdapter(Context paramContext, SearchPoiPager paramSearchPoiPager, NaviFragmentManager paramNaviFragmentManager, boolean paramBoolean, e parame)
  {
    this.mPoiList = paramSearchPoiPager.getPoiList();
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    this.mSearchPoiPager = paramSearchPoiPager;
    this.mFragmentManager = paramNaviFragmentManager;
    this.isSetMode = paramBoolean;
    setSearchPager(paramSearchPoiPager);
    this.mChildIndex[0] = paramSearchPoiPager.getCountPerPager();
    this.mOnDialogListener = parame;
  }
  
  public int[] getChildCnt()
  {
    return this.mChildCnt;
  }
  
  public int[] getChildIndex()
  {
    return this.mChildIndex;
  }
  
  public int getCount()
  {
    if (this.mPoiList == null)
    {
      j = 0;
      return j;
    }
    int j = 10;
    int i = j;
    if (this.mChildIndex != null)
    {
      i = j;
      if (this.mChildIndex[0] > 0) {
        if (this.mPoiList.size() < this.mChildIndex[0]) {
          break label73;
        }
      }
    }
    label73:
    for (i = this.mChildIndex[0];; i = this.mPoiList.size())
    {
      j = i;
      if (this.mFootItemType == TYPE_FOOT_ITEM_NOME) {
        break;
      }
      return i + 1;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View.OnClickListener getNameSearchResultListener()
  {
    return this.mClickListener;
  }
  
  public List<SearchPoi> getPoiList()
  {
    return this.mPoiList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 10;
    int i = j;
    if (this.mChildIndex != null)
    {
      i = j;
      if (this.mChildIndex[0] > 0)
      {
        if (this.mPoiList.size() < this.mChildIndex[0]) {
          break label160;
        }
        i = this.mChildIndex[0];
      }
    }
    if (paramInt == i)
    {
      paramView = this.mLayoutInflater.inflate(2130968884, null);
      paramViewGroup = (TextView)paramView.findViewById(2131624530);
      if (this.mFootItemType == TYPE_FOOT_ITEM_ONLINE_SEARCH) {
        paramViewGroup.setText(StyleManager.getString(2131297133));
      }
      for (;;)
      {
        paramViewGroup.setTextColor(StyleManager.getColor(2131559135));
        paramView.findViewById(2131624097).setBackgroundDrawable(StyleManager.getDrawable(2130838474));
        paramViewGroup.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
        paramViewGroup.setOnClickListener(this.mClickListener);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
        return paramView;
        label160:
        i = this.mPoiList.size();
        break;
        paramViewGroup.setText(StyleManager.getString(2131297132));
      }
    }
    paramView = this.mLayoutInflater.inflate(2130969012, null);
    paramViewGroup = new ViewHodler();
    paramViewGroup.mVerDiverderA = paramView.findViewById(2131624189);
    paramViewGroup.mBtnStartNavi = paramView.findViewById(2131624190);
    paramViewGroup.mBtnNameAddr = paramView.findViewById(2131624193);
    paramViewGroup.mTvName = ((TextView)paramView.findViewById(2131624196));
    paramViewGroup.mTvAddr = ((TextView)paramView.findViewById(2131624197));
    paramViewGroup.mTvStartNavi = ((TextView)paramView.findViewById(2131624191));
    paramViewGroup.mTvDistance = ((TextView)paramView.findViewById(2131624192));
    paramViewGroup.mTvNum = ((TextView)paramView.findViewById(2131624187));
    paramViewGroup.mChildGrideList = ((GridView)paramView.findViewById(2131624608));
    paramViewGroup.mDivider = paramView.findViewById(2131624322);
    paramViewGroup.mIcResult = ((ImageView)paramView.findViewById(2131624605));
    paramViewGroup.mLayoutChildBottom = ((LinearLayout)paramView.findViewById(2131624607));
    paramViewGroup.mPoiParent = ((RelativeLayout)paramView.findViewById(2131624603));
    ChildGrideListAdapter localChildGrideListAdapter = new ChildGrideListAdapter(this.mContext);
    paramView.setBackgroundColor(StyleManager.getColor(2131558420));
    paramViewGroup.mVerDiverderA.setBackgroundColor(StyleManager.getColor(2131559139));
    paramViewGroup.mBtnStartNavi.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    paramViewGroup.mBtnNameAddr.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    paramViewGroup.mTvName.setTextColor(StyleManager.getColor(2131559141));
    paramViewGroup.mTvAddr.setTextColor(StyleManager.getColor(2131559128));
    paramViewGroup.mTvStartNavi.setTextColor(StyleManager.getColor(2131559135));
    paramViewGroup.mTvDistance.setTextColor(StyleManager.getColor(2131559133));
    paramViewGroup.mTvNum.setTextColor(StyleManager.getColor(2131559143));
    paramViewGroup.mDivider.setBackgroundDrawable(StyleManager.getDrawable(2130838474));
    paramViewGroup.mLayoutChildBottom.setBackgroundColor(StyleManager.getColor(2131558424));
    paramViewGroup.mPoiParent.setBackgroundColor(StyleManager.getColor(2131558420));
    paramViewGroup.mChildGrideList.setAdapter(localChildGrideListAdapter);
    SearchPoi localSearchPoi = (SearchPoi)this.mPoiList.get(paramInt);
    if (localSearchPoi != null)
    {
      paramViewGroup.mTvName.setText(localSearchPoi.mName);
      paramViewGroup.mTvAddr.setText(localSearchPoi.mAddress);
      paramViewGroup.mTvDistance.setText(PoiController.getInstance().getDistance2CurrentPoint(localSearchPoi));
    }
    paramViewGroup.mBtnStartNavi.setTag(localSearchPoi);
    paramViewGroup.mBtnNameAddr.setTag(Integer.valueOf(paramInt));
    paramViewGroup.mBtnNameAddr.setOnClickListener(this.mClickListener);
    paramViewGroup.mBtnStartNavi.setOnClickListener(this.mClickListener);
    paramViewGroup.mTvNum.setText(paramInt + 1 + ".");
    if (this.isSetMode) {
      paramViewGroup.mTvStartNavi.setText(StyleManager.getString(2131296426));
    }
    this.mChildCnt[paramInt] = localSearchPoi.mChildCnt;
    if (paramInt >= 1) {
      this.mChildIndex[paramInt] = (this.mChildIndex[(paramInt - 1)] + this.mChildCnt[(paramInt - 1)]);
    }
    this.mParentCnt[paramInt] = paramInt;
    localChildGrideListAdapter.SetCount(this.mChildCnt[paramInt]);
    localChildGrideListAdapter.SetCountSUM(this.mChildIndex[paramInt]);
    localChildGrideListAdapter.SetParentPosition(this.mParentCnt[paramInt]);
    localChildGrideListAdapter.notifyDataSetChanged();
    if (this.mChildCnt[paramInt] <= 0)
    {
      paramViewGroup.mIcResult.setVisibility(8);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
      return paramView;
    }
    paramViewGroup.mIcResult.setVisibility(8);
    paramInt = (int)Math.ceil(this.mChildCnt[paramInt] / 3.0D);
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(paramInt * 32 + 90)));
    return paramView;
  }
  
  public void setOnlineSearchListener(OnClickOnlineSearch paramOnClickOnlineSearch)
  {
    this.mOnlineSearchListener = paramOnClickOnlineSearch;
  }
  
  public void setSearchPager(SearchPoiPager paramSearchPoiPager)
  {
    int i = 0;
    this.mSearchPoiPager = paramSearchPoiPager;
    this.mPoiList = paramSearchPoiPager.getPoiList();
    this.mChildIndex[0] = paramSearchPoiPager.getCountPerPager();
    int j = this.mSearchPoiPager.getNetMode();
    int k = this.mSearchPoiPager.getSearchType();
    if ((k == 1) || (k == 2))
    {
      paramSearchPoiPager = this.mSearchPoiPager.getDistrct();
      if (paramSearchPoiPager == null)
      {
        if ((i != 0) && (NetworkUtils.getConnectStatus())) {
          break label96;
        }
        this.mFootItemType = TYPE_FOOT_ITEM_NOME;
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      i = paramSearchPoiPager.mId;
      break;
      label96:
      if (j == 0)
      {
        this.mFootItemType = TYPE_FOOT_ITEM_ONLINE_SEARCH;
      }
      else if (j == 1)
      {
        this.mFootItemType = TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE;
        continue;
        if ((j == 0) && (NetworkUtils.getConnectStatus())) {
          this.mFootItemType = TYPE_FOOT_ITEM_ONLINE_SEARCH;
        } else {
          this.mFootItemType = TYPE_FOOT_ITEM_NOME;
        }
      }
    }
  }
  
  public void setShowBundle(Bundle paramBundle)
  {
    this.mShowBundle = paramBundle;
  }
  
  protected class ChildGrideListAdapter
    extends BaseAdapter
  {
    private View.OnClickListener mChildClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {}
        Integer localInteger;
        do
        {
          do
          {
            do
            {
              return;
              localInteger = (Integer)paramAnonymousView.getTag();
              if (SearchResultAdapter.this.mPoiList != null)
              {
                paramAnonymousView = (SearchPoi)SearchResultAdapter.this.mPoiList.get(localInteger.intValue());
                if (paramAnonymousView != null) {
                  StatisticManager.onEvent("410135", paramAnonymousView.mName);
                }
              }
            } while ((localInteger == null) || (localInteger.intValue() < 0) || (localInteger.intValue() >= SearchResultAdapter.this.mPoiList.size()));
            SearchStatItem.getInstance().searchStatistics(localInteger.intValue());
            if (SearchResultAdapter.this.isSetMode) {
              break;
            }
            ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList(SearchResultAdapter.this.mSearchPoiPager.getPoiList());
            paramAnonymousView = new Bundle();
            paramAnonymousView.putInt("fc_type", 1);
            paramAnonymousView.putInt("incoming_type", 83);
            paramAnonymousView.putInt("search_result_mode", SearchResultAdapter.this.mSearchPoiPager.getNetMode());
            paramAnonymousView.putInt("current_poi", localInteger.intValue());
            paramAnonymousView.putInt("child_start_poi", SearchResultAdapter.ChildGrideListAdapter.this.mChildsum);
            paramAnonymousView.putInt("current_child_count", SearchResultAdapter.ChildGrideListAdapter.this.mChildCount);
            paramAnonymousView.putInt("current_parent_position", SearchResultAdapter.ChildGrideListAdapter.this.mParentPosition);
            paramAnonymousView.putIntArray("child_count_array", SearchResultAdapter.this.mChildCnt);
            paramAnonymousView.putIntArray("parent_position_array", SearchResultAdapter.this.mParentCnt);
            paramAnonymousView.putIntArray("child_start_array", SearchResultAdapter.this.mChildIndex);
          } while (SearchResultAdapter.this.mFragmentManager == null);
          SearchResultAdapter.this.mFragmentManager.showFragment(33, paramAnonymousView);
          return;
        } while ((localInteger.intValue() < 0) || (localInteger.intValue() >= SearchResultAdapter.this.mPoiList.size()));
        paramAnonymousView = null;
        if (SearchResultAdapter.ChildGrideListAdapter.this.mChildCount > 0)
        {
          ArrayList localArrayList = new ArrayList(SearchResultAdapter.ChildGrideListAdapter.this.mChildCount + 1);
          localArrayList.add(SearchResultAdapter.this.mPoiList.get(SearchResultAdapter.ChildGrideListAdapter.this.mParentPosition));
          int i = 0;
          for (;;)
          {
            paramAnonymousView = localArrayList;
            if (i >= SearchResultAdapter.ChildGrideListAdapter.this.mChildCount) {
              break;
            }
            localArrayList.add(SearchResultAdapter.this.mPoiList.get(SearchResultAdapter.ChildGrideListAdapter.this.mChildsum + i));
            i += 1;
          }
        }
        PoiController.getInstance().focusPoi(paramAnonymousView, localInteger.intValue() - SearchResultAdapter.ChildGrideListAdapter.this.mChildsum + 1);
        PoiController.getInstance().animationTo((SearchPoi)SearchResultAdapter.this.mPoiList.get(localInteger.intValue()));
      }
    };
    int mChildCount = 0;
    int mChildsum = 0;
    Context mContext;
    int mParentPosition = 0;
    
    public ChildGrideListAdapter(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public int GetCountSUM()
    {
      return this.mChildsum;
    }
    
    public void SetCount(int paramInt)
    {
      this.mChildCount = paramInt;
    }
    
    public void SetCountSUM(int paramInt)
    {
      this.mChildsum = paramInt;
    }
    
    public void SetParentPosition(int paramInt)
    {
      this.mParentPosition = paramInt;
    }
    
    public int getCount()
    {
      return this.mChildCount;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    protected View getItemView(View paramView, int paramInt)
    {
      paramView = new ViewHolder();
      View localView = SearchResultAdapter.this.mLayoutInflater.inflate(2130969011, null);
      paramView.mChildName = ((TextView)localView.findViewById(2131624602));
      paramView.mIcDot = ((ImageView)localView.findViewById(2131624601));
      localView.setBackgroundColor(StyleManager.getColor(2131558424));
      paramView.mChildName.setTextColor(StyleManager.getColor(2131559141));
      paramView.mIcDot.setBackgroundDrawable(StyleManager.getDrawable(2130838713));
      paramView.mChildName.setText(((SearchPoi)SearchResultAdapter.this.mPoiList.get(this.mChildsum + paramInt)).mAliasName);
      localView.setTag(Integer.valueOf(this.mChildsum + paramInt));
      localView.setOnClickListener(this.mChildClickListener);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(32)));
      return localView;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getItemView(paramView, paramInt);
    }
    
    protected class ViewHolder
    {
      TextView mChildName;
      ImageView mIcDot;
      
      protected ViewHolder() {}
    }
  }
  
  public static abstract interface OnClickOnlineSearch
  {
    public abstract void onCountrywideOnlineSearch();
    
    public abstract void onNormalOnlineSearch();
  }
  
  static class ViewHodler
  {
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
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/SearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */