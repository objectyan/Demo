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
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
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
        do
        {
          do
          {
            return;
            i = paramAnonymousView.getId();
            if (i == 1711867336)
            {
              localObject = (Integer)paramAnonymousView.getTag();
              if (SearchResultAdapter.this.mIBNSearchResultListener != null) {
                SearchResultAdapter.this.mIBNSearchResultListener.goPoiDetailFragment(false, ((Integer)localObject).intValue(), SearchResultAdapter.this.isSetMode, SearchResultAdapter.this.mChildCnt, SearchResultAdapter.this.mChildIndex, SearchResultAdapter.this.mParentCnt);
              }
              if (SearchResultAdapter.this.mLastFocusView == null) {
                SearchResultAdapter.access$702(SearchResultAdapter.this, paramAnonymousView);
              }
              for (;;)
              {
                SearchResultAdapter.access$802(SearchResultAdapter.this, ((Integer)localObject).intValue());
                if (!SearchResultAdapter.this.mShowFocusItem) {
                  break;
                }
                localObject = (TextView)paramAnonymousView.findViewById(1711867034);
                TextView localTextView1 = (TextView)paramAnonymousView.findViewById(1711867035);
                paramAnonymousView = (TextView)paramAnonymousView.findViewById(1711867337);
                ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800377));
                localTextView1.setTextColor(BNStyleManager.getColor(1711800377));
                paramAnonymousView.setTextColor(BNStyleManager.getColor(1711800377));
                return;
                localTextView1 = (TextView)SearchResultAdapter.this.mLastFocusView.findViewById(1711867034);
                TextView localTextView2 = (TextView)SearchResultAdapter.this.mLastFocusView.findViewById(1711867035);
                ((TextView)SearchResultAdapter.this.mLastFocusView.findViewById(1711867337)).setTextColor(BNStyleManager.getColor(1711800378));
                localTextView1.setTextColor(BNStyleManager.getColor(1711800378));
                localTextView2.setTextColor(BNStyleManager.getColor(1711800379));
                SearchResultAdapter.access$702(SearchResultAdapter.this, paramAnonymousView);
              }
            }
          } while (i != 1711867029);
          paramAnonymousView = (SearchPoi)paramAnonymousView.getTag();
        } while (paramAnonymousView == null);
        Object localObject = paramAnonymousView.mName;
        LogUtil.e("luoluo", "gonavi :--------->" + (String)localObject);
        int i = SearchResultAdapter.this.mSearchPoiPager.getNetMode();
        if ((i == 1) || (i == 3))
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410385", (String)localObject);
          LogUtil.e("BNStatisticsManager", "在线检索通过主点发起算路次数");
        }
      } while (SearchResultAdapter.this.mIBNSearchResultListener == null);
      SearchResultAdapter.this.mIBNSearchResultListener.startGoNavi(SearchResultAdapter.this.isSetMode, paramAnonymousView);
    }
  };
  private Activity mContext;
  private int mFootItemType = TYPE_FOOT_ITEM_NOME;
  private IBNSearchResultListener mIBNSearchResultListener;
  private int mLastFocusIndex;
  private View mLastFocusView;
  private LayoutInflater mLayoutInflater;
  private int[] mParentCnt = new int['È'];
  private ArrayList<SearchPoi> mPoiList;
  private SearchPoiPager mSearchPoiPager;
  private boolean mShowFocusItem = true;
  
  static
  {
    TYPE_BTN = 2;
    TYPE_FOOT_ITEM_NOME = 1;
    TYPE_FOOT_ITEM_ONLINE_SEARCH = 2;
  }
  
  public SearchResultAdapter(Activity paramActivity, SearchPoiPager paramSearchPoiPager, boolean paramBoolean)
  {
    this.mPoiList = paramSearchPoiPager.getPoiList();
    this.mContext = paramActivity;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    this.mSearchPoiPager = paramSearchPoiPager;
    this.isSetMode = paramBoolean;
    setSearchPager(paramSearchPoiPager);
    this.mChildIndex[0] = paramSearchPoiPager.getCountPerPager();
    this.mLastFocusIndex = 0;
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
    int i;
    if (this.mPoiList == null) {
      i = 0;
    }
    do
    {
      int j;
      do
      {
        return i;
        j = 10;
        i = j;
      } while (this.mChildIndex == null);
      i = j;
    } while (this.mChildIndex[0] <= 0);
    if (this.mPoiList.size() >= this.mChildIndex[0]) {
      return this.mChildIndex[0];
    }
    return this.mPoiList.size();
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
    label235:
    ChildGrideListAdapter localChildGrideListAdapter;
    if ((this.mChildIndex != null) && (this.mChildIndex[0] > 0))
    {
      if (this.mPoiList.size() >= this.mChildIndex[0]) {
        int i = this.mChildIndex[0];
      }
    }
    else
    {
      if (paramView != null) {
        break label697;
      }
      paramView = JarUtils.inflate(this.mContext, 1711472790, null);
      paramViewGroup = new ViewHodler();
      paramViewGroup.mVerDiverderA = paramView.findViewById(1711867032);
      paramViewGroup.mBtnStartNavi = paramView.findViewById(1711867029);
      paramViewGroup.mBtnNameAddr = paramView.findViewById(1711867033);
      paramViewGroup.mTvName = ((TextView)paramView.findViewById(1711867034));
      paramViewGroup.mTvAddr = ((TextView)paramView.findViewById(1711867035));
      paramViewGroup.mTvStartNavi = ((TextView)paramView.findViewById(1711867030));
      paramViewGroup.mTvDistance = ((TextView)paramView.findViewById(1711867031));
      paramViewGroup.mTvNum = ((TextView)paramView.findViewById(1711867337));
      paramViewGroup.mChildGrideList = ((GridView)paramView.findViewById(1711867339));
      paramViewGroup.mDivider = paramView.findViewById(1711867340);
      paramViewGroup.mIcResult = ((ImageView)paramView.findViewById(1711867335));
      paramViewGroup.mLayoutChildBottom = ((LinearLayout)paramView.findViewById(1711867338));
      paramViewGroup.mPoiParent = ((RelativeLayout)paramView.findViewById(1711867028));
      paramViewGroup.mParInforLayout = paramView.findViewById(1711867336);
      paramView.setTag(paramViewGroup);
      localChildGrideListAdapter = new ChildGrideListAdapter(this.mContext);
      paramView.setBackgroundColor(BNStyleManager.getColor(1711800370));
      paramViewGroup.mVerDiverderA.setBackgroundColor(BNStyleManager.getColor(1711800390));
      paramViewGroup.mBtnStartNavi.setBackgroundDrawable(BNStyleManager.getDrawable(1711407111));
      paramViewGroup.mBtnNameAddr.setBackgroundDrawable(BNStyleManager.getDrawable(1711407111));
      if ((this.mLastFocusIndex != paramInt) || (!this.mShowFocusItem)) {
        break label708;
      }
      this.mLastFocusView = paramViewGroup.mParInforLayout;
      paramViewGroup.mTvName.setTextColor(BNStyleManager.getColor(1711800377));
      paramViewGroup.mTvAddr.setTextColor(BNStyleManager.getColor(1711800377));
      paramViewGroup.mTvNum.setTextColor(BNStyleManager.getColor(1711800377));
    }
    for (;;)
    {
      paramViewGroup.mTvStartNavi.setTextColor(BNStyleManager.getColor(1711800377));
      paramViewGroup.mTvDistance.setTextColor(BNStyleManager.getColor(1711800377));
      paramViewGroup.mLayoutChildBottom.setBackgroundColor(BNStyleManager.getColor(1711800370));
      paramViewGroup.mChildGrideList.setAdapter(localChildGrideListAdapter);
      SearchPoi localSearchPoi = (SearchPoi)this.mPoiList.get(paramInt);
      if (localSearchPoi != null)
      {
        paramViewGroup.mTvName.setText(localSearchPoi.mName);
        paramViewGroup.mTvAddr.setText(localSearchPoi.mAddress);
        paramViewGroup.mTvDistance.setText(this.mIBNSearchResultListener.getDistance(localSearchPoi));
      }
      paramViewGroup.mBtnStartNavi.setTag(localSearchPoi);
      paramViewGroup.mParInforLayout.setTag(Integer.valueOf(paramInt));
      paramViewGroup.mParInforLayout.setOnClickListener(this.mClickListener);
      paramViewGroup.mBtnStartNavi.setOnClickListener(this.mClickListener);
      paramView.setTag(paramViewGroup);
      paramViewGroup.mTvNum.setText(paramInt + 1 + ".");
      if (this.isSetMode) {
        paramViewGroup.mTvStartNavi.setText(BNStyleManager.getString(1711669461));
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
      if (this.mChildCnt[paramInt] > 0) {
        break label750;
      }
      paramViewGroup.mIcResult.setVisibility(8);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
      return paramView;
      this.mPoiList.size();
      break;
      label697:
      paramViewGroup = (ViewHodler)paramView.getTag();
      break label235;
      label708:
      paramViewGroup.mTvName.setTextColor(BNStyleManager.getColor(1711800378));
      paramViewGroup.mTvAddr.setTextColor(BNStyleManager.getColor(1711800379));
      paramViewGroup.mTvNum.setTextColor(BNStyleManager.getColor(1711800378));
    }
    label750:
    paramViewGroup.mIcResult.setVisibility(8);
    paramInt = (int)Math.ceil(this.mChildCnt[paramInt] / 3.0D);
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(paramInt * 32 + 108 + (paramInt - 1) * 16)));
    return paramView;
  }
  
  public void setFocusIndex(int paramInt)
  {
    this.mLastFocusIndex = paramInt;
  }
  
  public void setOnlineSearchListener(IBNSearchResultListener paramIBNSearchResultListener)
  {
    this.mIBNSearchResultListener = paramIBNSearchResultListener;
  }
  
  public void setSearchPager(SearchPoiPager paramSearchPoiPager)
  {
    this.mSearchPoiPager = paramSearchPoiPager;
    this.mPoiList = paramSearchPoiPager.getPoiList();
    this.mChildIndex[0] = paramSearchPoiPager.getCountPerPager();
    int j = this.mSearchPoiPager.getNetMode();
    int i = this.mSearchPoiPager.getSearchType();
    if ((i == 1) || (i == 2))
    {
      paramSearchPoiPager = this.mSearchPoiPager.getDistrct();
      if (paramSearchPoiPager == null)
      {
        i = 0;
        if ((i != 0) && (NetworkUtils.getConnectStatus())) {
          break label98;
        }
        this.mFootItemType = TYPE_FOOT_ITEM_NOME;
      }
    }
    for (;;)
    {
      this.mLastFocusIndex = 0;
      notifyDataSetChanged();
      return;
      i = paramSearchPoiPager.mId;
      break;
      label98:
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
  
  public void setShowFocusItem(boolean paramBoolean)
  {
    this.mShowFocusItem = paramBoolean;
  }
  
  protected class ChildGrideListAdapter
    extends BaseAdapter
  {
    private View.OnClickListener mChildClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {}
        do
        {
          do
          {
            do
            {
              return;
              paramAnonymousView = (Integer)paramAnonymousView.getTag();
              localObject = SearchResultAdapter.this.mSearchPoiPager.getPoiList();
            } while (localObject == null);
            paramAnonymousView = (SearchPoi)((List)localObject).get(paramAnonymousView.intValue());
          } while (paramAnonymousView == null);
          Object localObject = paramAnonymousView.mName;
          int i = SearchResultAdapter.this.mSearchPoiPager.getNetMode();
          if ((i == 1) || (i == 3))
          {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410386", (String)localObject);
            LogUtil.e("BNStatisticsManager", "在线检索通过子点发起算路次数");
          }
        } while (SearchResultAdapter.this.mIBNSearchResultListener == null);
        SearchResultAdapter.this.mIBNSearchResultListener.startGoNavi(SearchResultAdapter.this.isSetMode, paramAnonymousView);
      }
    };
    private int mChildCount = 0;
    private int mChildsum = 0;
    private Activity mContext;
    private int mParentPosition = 0;
    
    public ChildGrideListAdapter(Activity paramActivity)
    {
      this.mContext = paramActivity;
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
      View localView = JarUtils.inflate(this.mContext, 1711472789, null);
      paramView.mChildName = ((TextView)localView.findViewById(1711867334));
      paramView.mChildName.setTextColor(BNStyleManager.getColor(1711800378));
      int i = paramInt + this.mChildsum;
      if (i < SearchResultAdapter.this.mPoiList.size())
      {
        paramView.mChildName.setText(((SearchPoi)SearchResultAdapter.this.mPoiList.get(i)).mAliasName);
        localView.setTag(Integer.valueOf(this.mChildsum + paramInt));
        localView.setOnClickListener(this.mChildClickListener);
      }
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
      
      protected ViewHolder() {}
    }
  }
  
  static class ViewHodler
  {
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
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/search/SearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */