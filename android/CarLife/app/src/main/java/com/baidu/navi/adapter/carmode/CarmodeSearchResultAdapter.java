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
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.adapter.SearchResultAdapter.OnClickOnlineSearch;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
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

public class CarmodeSearchResultAdapter
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
      int i;
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
              if (i != 2131624190) {
                break;
              }
            } while (CarmodeSearchResultAdapter.this.isSetMode);
            paramAnonymousView = (Integer)paramAnonymousView.getTag();
          } while ((paramAnonymousView == null) || (paramAnonymousView.intValue() < 0) || (paramAnonymousView.intValue() >= CarmodeSearchResultAdapter.this.mPoiList.size()));
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList(CarmodeSearchResultAdapter.this.mPoiList);
          Bundle localBundle = new Bundle();
          localBundle.putInt("incoming_type", 83);
          if (CarmodeSearchResultAdapter.this.mSearchPoiPager != null) {
            localBundle.putInt("search_result_mode", CarmodeSearchResultAdapter.this.mSearchPoiPager.getNetMode());
          }
          localBundle.putInt("fc_type", 0);
          localBundle.putInt("current_poi", paramAnonymousView.intValue());
          localBundle.putInt("current_child_count", CarmodeSearchResultAdapter.this.mChildCnt[paramAnonymousView.intValue()]);
          localBundle.putInt("child_start_poi", CarmodeSearchResultAdapter.this.mChildIndex[paramAnonymousView.intValue()]);
          localBundle.putIntArray("child_count_array", CarmodeSearchResultAdapter.this.mChildCnt);
          localBundle.putIntArray("parent_position_array", CarmodeSearchResultAdapter.this.mParentCnt);
          localBundle.putIntArray("child_start_array", CarmodeSearchResultAdapter.this.mChildIndex);
          localBundle.putInt("come_from", CarmodeSearchResultAdapter.this.mShowBundle.getInt("come_from"));
          if (CarmodeSearchResultAdapter.this.mFragmentManager != null) {
            CarmodeSearchResultAdapter.this.mFragmentManager.showFragment(33, localBundle);
          }
          SearchStatItem.getInstance().setResultIndex(paramAnonymousView.intValue());
          SearchStatItem.getInstance().onEvent();
          return;
          if (i != 2131624193) {
            break;
          }
          if (CarmodeSearchResultAdapter.this.isPoiComfirmPage())
          {
            i = CarmodeSearchResultAdapter.this.mShowBundle.getInt("select_point_action");
            paramAnonymousView = (SearchPoi)paramAnonymousView.getTag(2131624193);
            if (i == 1) {
              FavoriteDestinationController.getInstance().addFavoriteDestFromDB(CarmodeSearchResultAdapter.this.createRoutePlanNode(paramAnonymousView), null);
            }
            for (;;)
            {
              CarmodeSearchResultAdapter.this.mFragmentManager.backTo(CarmodeSearchResultAdapter.this.mShowBundle.getInt("from_Fragment"), null);
              return;
              localBundle = new Bundle();
              localBundle.putInt("select_point_action", CarmodeSearchResultAdapter.this.mShowBundle.getInt("select_point_action"));
              UIModel.settingAddress(paramAnonymousView, CarmodeSearchResultAdapter.this.mContext, localBundle);
            }
          }
          paramAnonymousView = (SearchPoi)paramAnonymousView.getTag();
        } while ((paramAnonymousView == null) || (CarmodeSearchResultAdapter.this.isSetMode));
        if (CarmodeSearchResultAdapter.this.mShowBundle.getInt("come_from") == 8) {
          StatisticManager.onEvent("DISCOVER_QJY_0002", "DISCOVER_QJY_0002");
        }
        NavPoiController.getInstance().startCalcRoute(paramAnonymousView);
        return;
      } while (i != 2131624530);
      CarmodeSearchResultAdapter.this.clickSearchBtn();
    }
  };
  private Context mContext;
  private int mFootItemType = TYPE_FOOT_ITEM_NOME;
  private NaviFragmentManager mFragmentManager;
  private LayoutInflater mLayoutInflater;
  private e mOnDialogListener;
  private SearchResultAdapter.OnClickOnlineSearch mOnlineSearchListener;
  private int[] mParentCnt = new int['È'];
  private List<SearchPoi> mPoiList;
  private SearchPoiPager mSearchPoiPager;
  private final int mSearchPoiTagKey = 2131624193;
  private Bundle mShowBundle;
  
  static
  {
    TYPE_BTN = 2;
    TYPE_FOOT_ITEM_NOME = 1;
    TYPE_FOOT_ITEM_ONLINE_SEARCH = 2;
  }
  
  public CarmodeSearchResultAdapter(Context paramContext, SearchPoiPager paramSearchPoiPager, NaviFragmentManager paramNaviFragmentManager, boolean paramBoolean, e parame)
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
  
  public CarmodeSearchResultAdapter(Context paramContext, List<SearchPoi> paramList, NaviFragmentManager paramNaviFragmentManager, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.mPoiList = paramList;
      this.mContext = paramContext;
      this.mLayoutInflater = LayoutInflater.from(this.mContext);
      this.mFragmentManager = paramNaviFragmentManager;
      this.isSetMode = paramBoolean;
      this.mFootItemType = TYPE_FOOT_ITEM_NOME;
      paramContext = this.mChildIndex;
      if (paramList.size() <= 10) {
        break label130;
      }
    }
    for (;;)
    {
      paramContext[0] = i;
      return;
      label130:
      i = paramList.size();
    }
  }
  
  private RoutePlanNode createRoutePlanNode(SearchPoi paramSearchPoi)
  {
    return new RoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
  }
  
  private boolean isPoiComfirmPage()
  {
    int i = this.mShowBundle.getInt("select_point_action");
    return (i == 1) || (i == 5) || (i == 4);
  }
  
  public void clickSearchBtn()
  {
    if (this.mOnlineSearchListener != null)
    {
      if (this.mFootItemType != TYPE_FOOT_ITEM_ONLINE_COUNTRYWIDE) {
        break label27;
      }
      this.mOnlineSearchListener.onCountrywideOnlineSearch();
    }
    label27:
    while (this.mFootItemType != TYPE_FOOT_ITEM_ONLINE_SEARCH) {
      return;
    }
    this.mOnlineSearchListener.onNormalOnlineSearch();
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
          break label75;
        }
      }
    }
    label75:
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
          break label122;
        }
        i = this.mChildIndex[0];
      }
    }
    if (paramInt == i)
    {
      paramView = this.mLayoutInflater.inflate(2130968668, null);
      paramViewGroup = (TextView)paramView.findViewById(2131624530);
      if (this.mFootItemType == TYPE_FOOT_ITEM_ONLINE_SEARCH) {
        paramViewGroup.setText(StyleManager.getString(2131297133));
      }
      for (;;)
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(80)));
        return paramView;
        label122:
        i = this.mPoiList.size();
        break;
        paramViewGroup.setText(StyleManager.getString(2131297132));
      }
    }
    paramViewGroup = this.mLayoutInflater.inflate(2130968689, null);
    ViewHodler localViewHodler = new ViewHodler();
    localViewHodler.mVerDiverderA = paramViewGroup.findViewById(2131624189);
    localViewHodler.mBtnStartNavi = paramViewGroup.findViewById(2131624190);
    localViewHodler.mBtnNameAddr = paramViewGroup.findViewById(2131624193);
    localViewHodler.mTvName = ((TextView)paramViewGroup.findViewById(2131624196));
    localViewHodler.mTvAddr = ((TextView)paramViewGroup.findViewById(2131624197));
    localViewHodler.mTvDistance = ((TextView)paramViewGroup.findViewById(2131624606));
    localViewHodler.mTvNum = ((TextView)paramViewGroup.findViewById(2131624187));
    localViewHodler.mHorDeverder = paramViewGroup.findViewById(2131624097);
    localViewHodler.mChildGrideList = ((GridView)paramViewGroup.findViewById(2131624608));
    localViewHodler.mIcResult = ((ImageView)paramViewGroup.findViewById(2131624605));
    localViewHodler.mHorDiverderB = paramViewGroup.findViewById(2131624604);
    if (isPoiComfirmPage())
    {
      localViewHodler.mTvDistance.setVisibility(8);
      localViewHodler.mBtnStartNavi.setVisibility(8);
      localViewHodler.mHorDiverderB.setVisibility(8);
      label356:
      paramView = (SearchPoi)this.mPoiList.get(paramInt);
      if (paramView != null)
      {
        if (isPoiComfirmPage()) {
          break label615;
        }
        localViewHodler.mTvNum.setText(paramInt + 1 + ". ");
        localViewHodler.mTvName.setText(paramView.mName);
      }
    }
    for (;;)
    {
      localViewHodler.mTvAddr.setText(paramView.mAddress);
      localViewHodler.mTvDistance.setText(PoiController.getInstance().getDistance2CurrentPoint(paramView));
      localViewHodler.mBtnNameAddr.setTag(paramView);
      localViewHodler.mBtnNameAddr.setTag(2131624193, paramView);
      localViewHodler.mBtnStartNavi.setTag(Integer.valueOf(paramInt));
      localViewHodler.mBtnNameAddr.setOnClickListener(this.mClickListener);
      localViewHodler.mBtnStartNavi.setOnClickListener(this.mClickListener);
      this.mChildCnt[paramInt] = paramView.mChildCnt;
      if (paramInt >= 1) {
        this.mChildIndex[paramInt] = (this.mChildIndex[(paramInt - 1)] + this.mChildCnt[(paramInt - 1)]);
      }
      this.mParentCnt[paramInt] = paramInt;
      paramView = paramViewGroup;
      if (this.mChildCnt[paramInt] > 0) {
        break;
      }
      localViewHodler.mIcResult.setVisibility(8);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(80)));
      return paramViewGroup;
      localViewHodler.mTvDistance.setVisibility(0);
      localViewHodler.mBtnStartNavi.setVisibility(0);
      break label356;
      label615:
      localViewHodler.mTvName.setText(paramView.mName);
    }
  }
  
  public void interPoidetail()
  {
    if (this.isSetMode) {}
    Integer localInteger;
    do
    {
      return;
      localInteger = Integer.valueOf(0);
      if (this.mPoiList != null)
      {
        localObject = (SearchPoi)this.mPoiList.get(localInteger.intValue());
        if (localObject != null) {
          localObject = ((SearchPoi)localObject).mName;
        }
      }
    } while ((localInteger == null) || (localInteger.intValue() < 0) || (localInteger.intValue() >= this.mPoiList.size()));
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList(this.mPoiList);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("incoming_type", 83);
    if (this.mSearchPoiPager != null) {
      ((Bundle)localObject).putInt("search_result_mode", this.mSearchPoiPager.getNetMode());
    }
    ((Bundle)localObject).putInt("fc_type", 0);
    ((Bundle)localObject).putInt("current_poi", localInteger.intValue());
    ((Bundle)localObject).putInt("current_child_count", this.mChildCnt[localInteger.intValue()]);
    ((Bundle)localObject).putInt("child_start_poi", this.mChildIndex[localInteger.intValue()]);
    ((Bundle)localObject).putIntArray("child_count_array", this.mChildCnt);
    ((Bundle)localObject).putIntArray("parent_position_array", this.mParentCnt);
    ((Bundle)localObject).putIntArray("child_start_array", this.mChildIndex);
    if (this.mFragmentManager != null) {
      this.mFragmentManager.showFragment(33, (Bundle)localObject);
    }
    SearchStatItem.getInstance().setResultIndex(localInteger.intValue());
    SearchStatItem.getInstance().onEvent();
  }
  
  public void setOnlineSearchListener(SearchResultAdapter.OnClickOnlineSearch paramOnClickOnlineSearch)
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
        if (CarmodeSearchResultAdapter.this.isSetMode) {}
        Object localObject;
        do
        {
          do
          {
            do
            {
              return;
            } while (ForbidDaulClickUtils.isFastDoubleClick());
            paramAnonymousView = (Integer)paramAnonymousView.getTag();
            if (CarmodeSearchResultAdapter.this.mPoiList != null)
            {
              localObject = (SearchPoi)CarmodeSearchResultAdapter.this.mPoiList.get(paramAnonymousView.intValue());
              if (localObject != null) {
                localObject = ((SearchPoi)localObject).mName;
              }
            }
          } while ((paramAnonymousView == null) || (paramAnonymousView.intValue() < 0) || (paramAnonymousView.intValue() >= CarmodeSearchResultAdapter.this.mPoiList.size()));
          SearchStatItem.getInstance().searchStatistics(paramAnonymousView.intValue());
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList(CarmodeSearchResultAdapter.this.mSearchPoiPager.getPoiList());
          localObject = new Bundle();
          ((Bundle)localObject).putInt("fc_type", 1);
          ((Bundle)localObject).putInt("incoming_type", 83);
          ((Bundle)localObject).putInt("search_result_mode", CarmodeSearchResultAdapter.this.mSearchPoiPager.getNetMode());
          ((Bundle)localObject).putInt("current_poi", paramAnonymousView.intValue());
          ((Bundle)localObject).putInt("child_start_poi", CarmodeSearchResultAdapter.ChildGrideListAdapter.this.mChildsum);
          ((Bundle)localObject).putInt("current_child_count", CarmodeSearchResultAdapter.ChildGrideListAdapter.this.mChildCount);
          ((Bundle)localObject).putInt("current_parent_position", CarmodeSearchResultAdapter.ChildGrideListAdapter.this.mParentPosition);
          ((Bundle)localObject).putIntArray("child_count_array", CarmodeSearchResultAdapter.this.mChildCnt);
          ((Bundle)localObject).putIntArray("parent_position_array", CarmodeSearchResultAdapter.this.mParentCnt);
          ((Bundle)localObject).putIntArray("child_start_array", CarmodeSearchResultAdapter.this.mChildIndex);
        } while (CarmodeSearchResultAdapter.this.mFragmentManager == null);
        CarmodeSearchResultAdapter.this.mFragmentManager.showFragment(33, (Bundle)localObject);
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
      View localView = CarmodeSearchResultAdapter.this.mLayoutInflater.inflate(2130968688, null);
      paramView.mChildName = ((TextView)localView.findViewById(2131624602));
      paramView.mIcDot = ((ImageView)localView.findViewById(2131624601));
      localView.setTag(paramView);
      paramView.mChildName.setText(((SearchPoi)CarmodeSearchResultAdapter.this.mPoiList.get(this.mChildsum + paramInt)).mAliasName);
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
  
  static class ViewHodler
  {
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
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/carmode/CarmodeSearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */