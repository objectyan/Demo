package com.baidu.navi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.c;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.view.dialog.n;
import com.baidu.navi.adapter.SearchResultAdapter;
import com.baidu.navi.adapter.SearchResultAdapter.OnClickOnlineSearch;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navi.view.xpulltorefresh.XListView;
import com.baidu.navi.view.xpulltorefresh.XListView.IXListViewListener;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class SearchResultFragment
  extends MapContentFragment
{
  public static final String DISTRICT_ID = "district_id";
  public static final int INCOMING_CATALOG_SEARCH = 33;
  public static final int INCOMING_QUICK_ROUTE_PLAN = 34;
  public static final String INCOMING_TYPE = "incoming_type";
  public static final int INCOMING_VOICE_COMMAND = 35;
  private static int MARGINTOP_NORMAL = ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight() - ScreenUtil.getInstance().dip2px(100);
  private static int Middle_TOP_NORMAL = ScreenUtil.getInstance().dip2px(250);
  private static final float OFFSET_RADIO = 1.8F;
  private static final int PULL_LOAD_MORE_DELTA = 50;
  private static final int SCROLL_DURATION = 400;
  public static final String SEACHRESULT_SHOW_NEWER_GUIDE_KEY = "searchresult_show_newer_key";
  public static final int SEARCH_CIRCLE_1000 = 1000;
  public static final int SEARCH_CIRCLE_2000 = 2000;
  public static final int SEARCH_CIRCLE_500 = 500;
  public static final int SEARCH_CIRCLE_5000 = 5000;
  public static final int SEARCH_CIRCLE_DEAFAULT = 5000;
  public static final String SEARCH_ID = "search_id";
  public static final String SEARCH_KEY = "search_key";
  public static final String SEARCH_NET_MODE = "search_mode";
  public static final String SEARCH_TYPE = "search_type";
  public static final int SEARCH_TYPE_NAME = 17;
  public static final int SEARCH_TYPE_SPACE_CATALOG = 19;
  public static final int SEARCH_TYPE_SPACE_KEY = 18;
  private static final String TAG = "PoiSearch";
  private static int TITLEBAR_HEIGHT;
  private static BNNetworkingDialog mNetworkingDialog;
  private static float mStartY;
  private boolean isCityResultMode = false;
  private boolean isFromCatalogSearch = false;
  private boolean isFromVoiceCommand = false;
  private boolean isListSort = false;
  private boolean isSetHomeComp = false;
  private boolean isSetPointMode = false;
  private boolean isVoiceCommandResponsed = false;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (2 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      while (1 != paramAnonymousInt1)
      {
        return;
        LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
        paramAnonymousBNSubject = (MotionEvent)paramAnonymousObject;
        return;
      }
      switch (paramAnonymousInt2)
      {
      case 276: 
      default: 
        return;
      case 257: 
        LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_FINISHED");
        PoiController.getInstance().focusItem(true);
        return;
      case 264: 
        LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_BASE_POI_LAYER");
        return;
      case 265: 
        StatisticManager.onEvent("410136", "410136");
        SearchResultFragment.this.handleClickPoiBkgLayer((MapItem)paramAnonymousObject);
        return;
      }
      LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
    }
  };
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private n mCityListDialog;
  private ImageView mCloseSortingIv;
  private int mCurrentDistrictId;
  private LinearLayout mDrawingLayout;
  private n mFilterRuleDialog;
  private ViewGroup mGroupView;
  private ImageView mHandleView;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((SearchResultFragment.this.isDetached()) || (SearchResultFragment.this.isRemoving())) {}
      label481:
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              do
              {
                return;
                localObject = (RspData)paramAnonymousMessage.obj;
              } while (paramAnonymousMessage.what != 1005);
              e.a().c();
              SearchResultFragment.this.mResultListView.stopLoadMore();
              localObject = (SearchPoiPager)((RspData)localObject).mData;
              if (localObject != null) {
                break;
              }
              LogUtil.e("PoiSearch", "search with pager fail");
              TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298915);
            } while (SearchResultFragment.this.mResultAdapter != null);
            SearchResultFragment.this.onBackPressed();
            return;
            if (paramAnonymousMessage.arg1 != 0) {
              break label481;
            }
            paramAnonymousMessage = ((SearchPoiPager)localObject).getPoiList();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() != 0)) {
              break;
            }
            LogUtil.e("PoiSearch", "search with pager fail");
            TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298915);
          } while (SearchResultFragment.this.mResultAdapter != null);
          SearchResultFragment.this.onBackPressed();
          return;
          if (((SearchPoi)paramAnonymousMessage.get(0)).mType == 1)
          {
            if (((SearchPoiPager)localObject).getNetMode() == 1) {}
            for (boolean bool = true;; bool = false)
            {
              SearchResultFragment.this.showCityList(paramAnonymousMessage, bool);
              return;
            }
          }
          SearchResultFragment.access$402(SearchResultFragment.this, (SearchPoiPager)localObject);
          if (SearchResultFragment.this.mResultAdapter != null) {
            SearchResultFragment.this.mResultAdapter.setSearchPager(SearchResultFragment.this.mSearchPoiPager);
          }
          for (;;)
          {
            SearchResultFragment.this.updateListView();
            SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
            SearchResultFragment.access$102(SearchResultFragment.this, null);
            return;
            SearchResultFragment.access$002(SearchResultFragment.this, new SearchResultAdapter(BaseFragment.mActivity, SearchResultFragment.this.mSearchPoiPager, SearchResultFragment.this.getNaviFragmentManager(), SearchResultFragment.this.isSetPointMode, SearchResultFragment.this));
            SearchResultFragment.this.mResultAdapter.setOnlineSearchListener(SearchResultFragment.this.mOnlineClickListener);
            SearchResultFragment.this.mResultAdapter.setShowBundle(SearchResultFragment.this.mShowBundle);
            SearchResultFragment.this.mResultListView.setAdapter(SearchResultFragment.this.mResultAdapter);
            int j = SearchResultFragment.this.mSearchPoiPager.getCountPerPager();
            paramAnonymousMessage = new ArrayList(j);
            int i = 0;
            while (i < j)
            {
              paramAnonymousMessage.add(SearchResultFragment.this.mSearchPoiPager.getPoiList().get(i));
              i += 1;
            }
            SearchResultFragment.access$702(SearchResultFragment.this, new SearchResultFragment.SearchResultViewPagerAdapter(SearchResultFragment.this, paramAnonymousMessage));
            SearchResultFragment.this.mViewPager.setAdapter(SearchResultFragment.this.mSearchResultViewPagerAdapter);
            SearchResultFragment.this.mViewPager.setCurrentItem(0);
          }
          if (!CommandResult.isNetworkErr(paramAnonymousMessage.arg1)) {
            break;
          }
          LogUtil.e("PoiSearch", "search with pager fail");
          TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298915);
          SearchResultFragment.access$102(SearchResultFragment.this, null);
        } while (SearchResultFragment.this.mResultAdapter != null);
        SearchResultFragment.this.onBackPressed();
        return;
        LogUtil.e("PoiSearch", "search with pager fail");
        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298915);
        SearchResultFragment.access$102(SearchResultFragment.this, null);
      } while (SearchResultFragment.this.mResultAdapter != null);
      SearchResultFragment.this.onBackPressed();
    }
  };
  private XListView.IXListViewListener mIXListViewListener = new XListView.IXListViewListener()
  {
    public void onLoadMore()
    {
      SearchPoiPager localSearchPoiPager = SearchResultFragment.this.mSearchPoiPager.getNextPager();
      if ((localSearchPoiPager != null) && (localSearchPoiPager.getPoiList() != null) && (localSearchPoiPager.getPoiList().size() > 0))
      {
        SearchResultFragment.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            SearchResultFragment.this.mResultListView.stopLoadMore();
            SearchPoiPager localSearchPoiPager = SearchResultFragment.this.mSearchPoiPager.getNextPager();
            if (localSearchPoiPager != null)
            {
              SearchResultFragment.access$402(SearchResultFragment.this, localSearchPoiPager);
              SearchResultFragment.this.mResultAdapter.setSearchPager(localSearchPoiPager);
              SearchResultFragment.this.updateListView();
              SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
              SearchResultFragment.this.mSearchResultViewPagerAdapter.setPoiList(localSearchPoiPager.getPoiList());
              SearchResultFragment.this.mSearchResultViewPagerAdapter.notifyDataSetChanged();
            }
          }
        }, 1000L);
        return;
      }
      localSearchPoiPager = SearchResultFragment.this.mSearchPoiPager.createNextPager();
      if (localSearchPoiPager != null)
      {
        BNPoiSearcher.getInstance().setNetMode(localSearchPoiPager.getNetMode());
        BNPoiSearcher.getInstance().asynSearchWithPager(localSearchPoiPager, SearchResultFragment.this.mHandler);
        return;
      }
      SearchResultFragment.this.mResultListView.stopLoadMore();
    }
    
    public void onRefresh()
    {
      SearchResultFragment.this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          SearchResultFragment.this.mResultListView.stopRefresh();
          SearchPoiPager localSearchPoiPager = SearchResultFragment.this.mSearchPoiPager.getPrevPager();
          if (localSearchPoiPager != null)
          {
            SearchResultFragment.access$402(SearchResultFragment.this, localSearchPoiPager);
            SearchResultFragment.this.mResultAdapter.setSearchPager(SearchResultFragment.this.mSearchPoiPager);
            SearchResultFragment.this.updateListView();
            SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
            SearchResultFragment.this.mSearchResultViewPagerAdapter.setPoiList(localSearchPoiPager.getPoiList());
            SearchResultFragment.this.mSearchResultViewPagerAdapter.notifyDataSetChanged();
          }
        }
      }, 1000L);
    }
  };
  private int mLastOrientation = 0;
  private float mLastY = -1.0F;
  private RelativeLayout mNewerGuideLayout;
  private SearchResultAdapter.OnClickOnlineSearch mOnlineClickListener = new SearchResultAdapter.OnClickOnlineSearch()
  {
    public void onCountrywideOnlineSearch()
    {
      if (!NetworkUtils.getConnectStatus())
      {
        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298873);
        return;
      }
      SearchPoiPager localSearchPoiPager;
      for (Object localObject = SearchResultFragment.this.mSearchPoiPager;; localObject = localSearchPoiPager)
      {
        localSearchPoiPager = ((SearchPoiPager)localObject).getPrevPager();
        if (localSearchPoiPager == null)
        {
          localObject = ((SearchPoiPager)localObject).copy();
          ((SearchPoiPager)localObject).setNetMode(1);
          ((SearchPoiPager)localObject).setDistrict(BNPoiSearcher.getInstance().getDistrictById(0));
          e.a().a("", SearchResultFragment.this.mSearchDialogCancelListener);
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
          BNPoiSearcher.getInstance().setNetMode(((SearchPoiPager)localObject).getNetMode());
          BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, SearchResultFragment.this.mHandler);
          return;
        }
      }
    }
    
    public void onNormalOnlineSearch()
    {
      if (!NetworkUtils.getConnectStatus())
      {
        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298873);
        return;
      }
      SearchPoiPager localSearchPoiPager;
      for (Object localObject = SearchResultFragment.this.mSearchPoiPager;; localObject = localSearchPoiPager)
      {
        localSearchPoiPager = ((SearchPoiPager)localObject).getPrevPager();
        if (localSearchPoiPager == null)
        {
          localObject = ((SearchPoiPager)localObject).copy();
          ((SearchPoiPager)localObject).setNetMode(1);
          e.a().a("", SearchResultFragment.this.mSearchDialogCancelListener);
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
          BNPoiSearcher.getInstance().setNetMode(((SearchPoiPager)localObject).getNetMode());
          BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, SearchResultFragment.this.mHandler);
          return;
        }
      }
    }
  };
  private ArrayList<SearchPoi> mPoiList;
  private List<SearchPoi> mPreSearchCityList;
  private SearchResultAdapter mResultAdapter;
  private XListView mResultListView;
  private b mSearchDialogCancelListener = new b()
  {
    public void onClick()
    {
      if (SearchResultFragment.this.mResultAdapter == null) {
        SearchResultFragment.this.onBackPressed();
      }
      SearchResultFragment.access$102(SearchResultFragment.this, null);
      BNPoiSearcher.getInstance().cancelQuery();
    }
  };
  private String mSearchKey;
  private SearchPoiPager mSearchPoiPager;
  private SearchResultViewPagerAdapter mSearchResultViewPagerAdapter;
  private RelativeLayout mSortByDistance;
  private ImageView mSortByDistanceIv;
  private TextView mSortByDistanceTv;
  private RelativeLayout mSortByKey;
  private ImageView mSortByKeyIv;
  private TextView mSortByKeyTv;
  private RelativeLayout mSortingRl;
  private MapTitleBar mTitleBar;
  private View.OnTouchListener mTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (SearchResultFragment.this.mLastY == -1.0F) {
        SearchResultFragment.access$1402(SearchResultFragment.this, paramAnonymousMotionEvent.getRawY());
      }
      float f1;
      float f2;
      int i;
      switch (paramAnonymousMotionEvent.getAction())
      {
      case 1: 
      default: 
        LogUtil.e("wywywy", "reset");
        f1 = paramAnonymousMotionEvent.getRawY();
        f2 = SearchResultFragment.mStartY;
        i = SearchResultFragment.this.getTopMargin();
        if (Math.abs(f1 - f2) >= 50.0F) {
          break label258;
        }
        if (Math.abs(i - SearchResultFragment.Middle_TOP_NORMAL) < 3) {
          SearchResultFragment.this.setListViewMargin(SearchResultFragment.Middle_TOP_NORMAL);
        }
        break;
      }
      for (;;)
      {
        SearchResultFragment.access$1402(SearchResultFragment.this, -1.0F);
        return true;
        SearchResultFragment.access$1402(SearchResultFragment.this, paramAnonymousMotionEvent.getRawY());
        SearchResultFragment.access$1502(paramAnonymousMotionEvent.getRawY());
        return true;
        f2 = paramAnonymousMotionEvent.getRawY() - SearchResultFragment.this.mLastY;
        SearchResultFragment.access$1402(SearchResultFragment.this, paramAnonymousMotionEvent.getRawY());
        f1 = f2;
        if (SearchResultFragment.this.getTopMargin() <= SearchResultFragment.this.mTitleBar.getHeight()) {
          f1 = f2 / 1.8F;
        }
        SearchResultFragment.this.updateTopMargin(f1);
        return true;
        if (Math.abs(i - SearchResultFragment.this.mTitleBar.getHeight()) < 3) {
          SearchResultFragment.this.setListViewMargin(SearchResultFragment.this.mTitleBar.getHeight());
        }
      }
      label258:
      if (i >= SearchResultFragment.MARGINTOP_NORMAL)
      {
        SearchResultFragment.this.setListViewMargin(SearchResultFragment.MARGINTOP_NORMAL);
        SearchResultFragment.this.mViewPager.setVisibility(0);
        SearchResultFragment.this.mResultListView.setVisibility(8);
        SearchResultFragment.this.updateMapView(SearchResultFragment.MARGINTOP_NORMAL);
      }
      for (;;)
      {
        SearchResultFragment.access$1402(SearchResultFragment.this, -1.0F);
        return true;
        if (i < SearchResultFragment.this.mTitleBar.getHeight())
        {
          if (SearchResultFragment.this.mViewPager.getVisibility() == 0)
          {
            SearchResultFragment.this.mViewPager.setVisibility(8);
            SearchResultFragment.this.mResultListView.setVisibility(0);
          }
          SearchResultFragment.this.setListViewMargin(SearchResultFragment.this.mTitleBar.getHeight());
        }
        else
        {
          if (SearchResultFragment.this.mViewPager.getVisibility() == 0)
          {
            SearchResultFragment.this.mViewPager.setVisibility(8);
            SearchResultFragment.this.mResultListView.setVisibility(0);
            SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
          }
          SearchResultFragment.this.setListViewMargin(SearchResultFragment.Middle_TOP_NORMAL);
        }
      }
    }
  };
  private ViewPager mViewPager;
  private int netMode = 1;
  private int searchType = 0;
  private int voiceCommandSubType = -1;
  private int voiceCommandTopType = -1;
  
  public static boolean dismissSearchNetworkingDialog()
  {
    if ((mNetworkingDialog != null) && (mNetworkingDialog.isShowing())) {
      mNetworkingDialog.dismiss();
    }
    mNetworkingDialog = null;
    return true;
  }
  
  private void getBundle()
  {
    boolean bool = false;
    if (this.mShowBundle == null) {
      return;
    }
    this.mSearchKey = this.mShowBundle.getString("search_key");
    this.mTitleBar.setMiddleText(null);
    Object localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
    if (this.mShowBundle.containsKey("district_id")) {
      this.mCurrentDistrictId = this.mShowBundle.getInt("district_id");
    }
    if (this.mShowBundle.getInt("incoming_type") == 33)
    {
      this.isFromCatalogSearch = true;
      if (this.mShowBundle.getInt("incoming_type") != 35) {
        break label370;
      }
      this.isFromVoiceCommand = true;
      this.isVoiceCommandResponsed = false;
      this.voiceCommandTopType = this.mShowBundle.getInt("Key_Bundle_VC_Top_Type", -1);
      this.voiceCommandSubType = this.mShowBundle.getInt("Key_Bundle_VC_Sub_Type", -1);
      label143:
      this.searchType = this.mShowBundle.getInt("search_type");
      if (this.mShowBundle.getInt("search_mode") != 1) {
        break label378;
      }
      this.netMode = 1;
      label174:
      if (!this.mShowBundle.containsKey("select_point_action")) {
        break label398;
      }
      this.isSetPointMode = true;
      label192:
      i = this.mShowBundle.getInt("select_point_action");
      if ((i != 5) && (i != 4)) {
        break label406;
      }
      this.isSetHomeComp = true;
      LogUtil.e("PoiSearch", "isSetHomeComp =" + this.isSetHomeComp);
    }
    for (;;)
    {
      localObject = ((PoiSearchModel)localObject).getSearchPoiPagerList();
      if (((List)localObject).size() <= 0) {
        break label572;
      }
      this.mSearchPoiPager = ((SearchPoiPager)((List)localObject).get(0));
      updateSortView();
      localObject = this.mSearchPoiPager.getPoiList();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label566;
      }
      if (((SearchPoi)((List)localObject).get(0)).mType != 1) {
        break label414;
      }
      if (this.mSearchPoiPager.getNetMode() == 1) {
        bool = true;
      }
      showCityList((List)localObject, bool);
      this.isCityResultMode = true;
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 2);
      return;
      this.isFromCatalogSearch = false;
      break;
      label370:
      this.isFromVoiceCommand = false;
      break label143;
      label378:
      if (this.mShowBundle.getInt("search_mode") != 0) {
        break label174;
      }
      this.netMode = 0;
      break label174;
      label398:
      this.isSetPointMode = false;
      break label192;
      label406:
      this.isSetHomeComp = false;
    }
    label414:
    this.mResultAdapter = new SearchResultAdapter(mActivity, this.mSearchPoiPager, getNaviFragmentManager(), this.isSetPointMode, this);
    this.mResultAdapter.setShowBundle(this.mShowBundle);
    this.mResultAdapter.setOnlineSearchListener(this.mOnlineClickListener);
    this.mResultListView.setAdapter(this.mResultAdapter);
    updateListView();
    int j = this.mSearchPoiPager.getCountPerPager();
    localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(this.mSearchPoiPager.getPoiList().get(i));
      i += 1;
    }
    this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter((List)localObject);
    this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
    this.mViewPager.setCurrentItem(0);
    this.isCityResultMode = false;
    return;
    label566:
    back(null);
    return;
    label572:
    back(null);
  }
  
  private View.OnClickListener getOnClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramAnonymousView.getId();
        if (i == 2131624137)
        {
          StatisticManager.onEvent("410132", "410132");
          if (SearchResultFragment.this.isFromCatalogSearch) {
            SearchResultFragment.this.back(null);
          }
        }
        do
        {
          return;
          SearchResultFragment.this.back(null);
          SearchResultFragment.this.back(null);
          return;
          if (i == 2131624286)
          {
            SearchResultFragment.this.mSortingRl.setVisibility(0);
            return;
          }
          if (i == 2131624149)
          {
            SearchResultFragment.this.mSortingRl.setVisibility(8);
            return;
          }
          if (i == 2131624150)
          {
            StatisticManager.onEvent("410133", "410133");
            SearchResultFragment.this.mSearchPoiPager.setSortType(1);
            SearchResultFragment.this.mSortingRl.setVisibility(8);
            SearchResultFragment.this.sortListByRule();
            SearchResultFragment.this.mSortByKeyIv.setVisibility(0);
            SearchResultFragment.this.mSortByDistanceIv.setVisibility(8);
            SearchResultFragment.this.mSortByKeyTv.setTextColor(StyleManager.getColor(2131559194));
            SearchResultFragment.this.mSortByDistanceTv.setTextColor(StyleManager.getColor(2131559195));
            PoiController.getInstance().updatePoiBkgLayer(SearchResultFragment.this.mSearchPoiPager.getPoiList());
            return;
          }
        } while (i != 2131624151);
        StatisticManager.onEvent("410134", "410134");
        paramAnonymousView = BNGeoLocateManager.getInstance().getLastValidLocation();
        if ((paramAnonymousView != null) && (paramAnonymousView.isValid()))
        {
          SearchResultFragment.this.mSearchPoiPager.setSortType(2);
          SearchResultFragment.this.mSortingRl.setVisibility(8);
          SearchResultFragment.this.sortListByRule();
          SearchResultFragment.this.mSortByKeyIv.setVisibility(8);
          SearchResultFragment.this.mSortByDistanceIv.setVisibility(0);
          SearchResultFragment.this.mSortByKeyTv.setTextColor(StyleManager.getColor(2131559195));
          SearchResultFragment.this.mSortByDistanceTv.setTextColor(StyleManager.getColor(2131559194));
          paramAnonymousView = SearchResultFragment.this.mSearchPoiPager.getPoiList();
          PoiController.getInstance().updatePoiBkgLayer(paramAnonymousView);
          return;
        }
        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), 2131298761);
      }
    };
  }
  
  private int getTopMargin()
  {
    return ((RelativeLayout.LayoutParams)this.mDrawingLayout.getLayoutParams()).topMargin;
  }
  
  private boolean onClickPoiResult(int paramInt)
  {
    if (this.mSearchPoiPager == null) {}
    do
    {
      return false;
      localObject = this.mSearchPoiPager.getPoiList();
    } while ((localObject == null) || (paramInt < 0) || (paramInt >= ((List)localObject).size()));
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList((List)localObject);
    new Bundle();
    Object localObject = this.mShowBundle;
    ((Bundle)localObject).putInt("incoming_type", 83);
    ((Bundle)localObject).putInt("search_result_mode", this.netMode);
    ((Bundle)localObject).putInt("current_poi", paramInt);
    ((Bundle)localObject).putString("search_key", this.mSearchKey);
    ((Bundle)localObject).putInt("district_id", this.mCurrentDistrictId);
    if ((mActivity != null) && (!mActivity.isFinishing())) {
      showFragment(33, (Bundle)localObject);
    }
    return true;
  }
  
  private boolean onVoiceCommandToClickPoiResultItem(int paramInt)
  {
    if (this.isCityResultMode)
    {
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 2);
      return false;
    }
    SearchPoi localSearchPoi;
    if ((this.mPoiList != null) && (paramInt >= 0) && (paramInt < this.mPoiList.size()))
    {
      localSearchPoi = (SearchPoi)this.mPoiList.get(paramInt);
      if (localSearchPoi != null)
      {
        if (!BNVoiceCommandController.getInstance().isSettingHome()) {
          break label114;
        }
        BNVoiceCommandController.getInstance().setIsSettingHome(false);
        AddressSettingModel.setHomeAddress(mActivity, localSearchPoi.mAddress, localSearchPoi.mName, localSearchPoi.mGuidePoint.getLongitudeE6(), localSearchPoi.mGuidePoint.getLatitudeE6(), localSearchPoi.mOriginUID);
      }
    }
    for (;;)
    {
      return onClickPoiResult(paramInt);
      label114:
      if (BNVoiceCommandController.getInstance().isSettingOffice())
      {
        BNVoiceCommandController.getInstance().setIsSettingOffice(false);
        AddressSettingModel.setCompAddress(mActivity, localSearchPoi.mAddress, localSearchPoi.mName, localSearchPoi.mGuidePoint.getLongitudeE6(), localSearchPoi.mGuidePoint.getLatitudeE6(), localSearchPoi.mOriginUID);
      }
    }
  }
  
  private void responsePoiResultCountToVoiceCommand(int paramInt)
  {
    if ((this.voiceCommandTopType != -1) && (this.voiceCommandSubType != -1))
    {
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 1, "为您搜索到" + paramInt + "条结果");
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(5, 2);
  }
  
  private void setListViewMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mDrawingLayout.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.mDrawingLayout.setLayoutParams(localLayoutParams);
  }
  
  private void showCityList(final List<SearchPoi> paramList, boolean paramBoolean)
  {
    SearchPoi localSearchPoi;
    if ((this.mPreSearchCityList != null) && (this.mPreSearchCityList.size() == paramList.size()))
    {
      i = 0;
      while (i < this.mPreSearchCityList.size())
      {
        localObject = (SearchPoi)this.mPreSearchCityList.get(i);
        localSearchPoi = (SearchPoi)paramList.get(i);
        if ((localObject == null) || (localSearchPoi == null) || (((SearchPoi)localObject).mId != localSearchPoi.mId)) {
          break;
        }
        i += 1;
      }
      if (i == this.mPreSearchCityList.size())
      {
        TipTool.onCreateToastDialog(getContext().getApplicationContext(), 2131298915);
        onBackPressed();
        return;
      }
    }
    dismissDialog(this.mCityListDialog);
    this.mCityListDialog = new n(mActivity).i(StyleManager.getString(2131298922)).a(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        SearchResultFragment.this.dismissDialog(SearchResultFragment.this.mCityListDialog);
        paramAnonymousAdapterView = (SearchPoi)paramList.get(paramAnonymousInt);
        if (((paramAnonymousAdapterView.mDistrictId & 0xFFFF0000) > 0) && ((paramAnonymousAdapterView.mDistrictId & 0xFFFF) == 0)) {}
        for (paramAnonymousAdapterView = BNPoiSearcher.getInstance().getDistrictById(paramAnonymousAdapterView.mDistrictId >> 16);; paramAnonymousAdapterView = BNPoiSearcher.getInstance().getDistrictById(paramAnonymousAdapterView.mDistrictId))
        {
          paramAnonymousAdapterView = new SearchPoiPager(SearchResultFragment.this.mSearchPoiPager.getSearchKey(), paramAnonymousAdapterView, 10, SearchResultFragment.this.mSearchPoiPager.getNetMode());
          e.a().a("", SearchResultFragment.this.mSearchDialogCancelListener);
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
          BNPoiSearcher.getInstance().setNetMode(paramAnonymousAdapterView.getNetMode());
          BNPoiSearcher.getInstance().asynSearchWithPager(paramAnonymousAdapterView, SearchResultFragment.this.mHandler);
          SearchResultFragment.access$102(SearchResultFragment.this, paramList);
          return;
        }
      }
    });
    Object localObject = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      localSearchPoi = (SearchPoi)paramList.get(i);
      int j;
      if (paramBoolean) {
        if (localSearchPoi.mWeight == 0)
        {
          j = 1;
          label220:
          ((ArrayList)localObject).add(localSearchPoi.mName + "(" + j + ")");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = localSearchPoi.mWeight;
        break label220;
        ((ArrayList)localObject).add(localSearchPoi.mName);
      }
    }
    this.mCityListDialog.setListAdapter((ArrayList)localObject);
    showDialog(this.mCityListDialog);
  }
  
  public static void showSearchNetworkingDialog(Activity paramActivity, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    dismissSearchNetworkingDialog();
    if (mNetworkingDialog == null)
    {
      mNetworkingDialog = new BNNetworkingDialog(paramActivity).setTwoButtonMode(true);
      mNetworkingDialog.setNetworkingContentMessage(StyleManager.getString(2131298909));
      mNetworkingDialog.setConfirmNetworkingListener(paramOnClickListener1);
      mNetworkingDialog.setCancleListener(paramOnClickListener3);
    }
    mNetworkingDialog.show();
  }
  
  private void updateListView()
  {
    if (this.mSearchPoiPager != null)
    {
      if (this.mSearchPoiPager.getPrevPager() == null) {
        break label52;
      }
      this.mResultListView.setPullRefreshEnable(true);
      if (!this.mSearchPoiPager.isLastPager()) {
        break label63;
      }
      this.mResultListView.setPullLoadEnable(false);
    }
    for (;;)
    {
      this.mResultListView.setSelection(0);
      return;
      label52:
      this.mResultListView.setPullRefreshEnable(false);
      break;
      label63:
      this.mResultListView.setPullLoadEnable(true);
    }
  }
  
  private void updateMapView(int paramInt)
  {
    int i = 10;
    PoiController.getInstance().clearPoiCache();
    if ((this.mSearchPoiPager != null) && (this.mSearchPoiPager.getPoiList() != null))
    {
      if (this.mSearchPoiPager.getPoiList().size() >= 10) {}
      ArrayList localArrayList;
      for (;;)
      {
        localArrayList = new ArrayList(i);
        int j = 0;
        while (j < i)
        {
          localArrayList.add(this.mSearchPoiPager.getPoiList().get(j));
          j += 1;
        }
        i = this.mSearchPoiPager.getPoiList().size();
      }
      PoiController.getInstance().updatePoiBkgLayer(localArrayList);
      Rect localRect = new Rect();
      localRect.left = 0;
      localRect.top = (ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight());
      localRect.right = ScreenUtil.getInstance().getWidthPixels();
      localRect.bottom = (localRect.top - paramInt);
      BNMapController.getInstance().updateMapView(localArrayList, localRect, true);
    }
  }
  
  private void updateSortView()
  {
    switch (this.mSearchPoiPager.getSearchType())
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      this.mSortByKeyIv.setVisibility(8);
      this.mSortByDistanceIv.setVisibility(0);
      this.mSortByKeyTv.setTextColor(StyleManager.getColor(2131559195));
      this.mSortByDistanceTv.setTextColor(StyleManager.getColor(2131559194));
      this.mSearchPoiPager.setSortType(2);
      return;
    }
    this.mSortByKeyIv.setVisibility(0);
    this.mSortByDistanceIv.setVisibility(8);
    this.mSortByKeyTv.setTextColor(StyleManager.getColor(2131559194));
    this.mSortByDistanceTv.setTextColor(StyleManager.getColor(2131559195));
    this.mSearchPoiPager.setSortType(1);
  }
  
  private int updateTopMargin(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mDrawingLayout.getLayoutParams();
    localLayoutParams.topMargin = ((int)(localLayoutParams.topMargin + paramFloat));
    this.mDrawingLayout.setLayoutParams(localLayoutParams);
    return localLayoutParams.topMargin;
  }
  
  private void updateViewWithOrientation(int paramInt, boolean paramBoolean) {}
  
  protected void handleClickPoiBkgLayer(MapItem paramMapItem)
  {
    if (paramMapItem == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = BNPoiSearcher.getInstance().parseBkgLayerId(paramMapItem.mUid);
        if (this.isSetPointMode) {
          break;
        }
      } while ((i < 0) || (i >= this.mSearchPoiPager.getPoiList().size()));
      ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setPoiList(this.mSearchPoiPager.getPoiList());
      this.mChildCnt = this.mResultAdapter.getChildCnt();
      this.mChildIndex = this.mResultAdapter.getChildIndex();
      paramMapItem = new Bundle();
      paramMapItem.putInt("incoming_type", 83);
      paramMapItem.putInt("search_result_mode", this.mSearchPoiPager.getNetMode());
      paramMapItem.putInt("current_poi", i);
      paramMapItem.putIntArray("child_count_array", this.mChildCnt);
      paramMapItem.putIntArray("child_start_array", this.mChildIndex);
      showFragment(33, paramMapItem);
      return;
    } while ((i < 0) || (i >= this.mSearchPoiPager.getPoiList().size()));
    paramMapItem = (SearchPoi)this.mSearchPoiPager.getPoiList().get(i);
    if (this.mShowBundle.getInt("select_point_action") == 1)
    {
      ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointSelectNode(paramMapItem);
      backTo(this.mShowBundle.getInt("from_Fragment"), null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("select_point_action", this.mShowBundle.getInt("select_point_action"));
    UIModel.settingAddress(paramMapItem, mActivity, localBundle);
    backTo(this.mShowBundle.getInt("from_Fragment"), null);
  }
  
  public boolean onBackPressed()
  {
    if ((this.mSortingRl != null) && (this.mSortingRl.getVisibility() == 0))
    {
      this.mSortingRl.setVisibility(8);
      return true;
    }
    if (this.mNewerGuideLayout != null) {
      try
      {
        this.mGroupView.removeView(this.mNewerGuideLayout);
        this.mNewerGuideLayout = null;
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
    }
    if (this.isFromCatalogSearch)
    {
      back(null);
      return true;
    }
    back(null);
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mLastOrientation = getResources().getConfiguration().orientation;
    this.mGroupView = ((ViewGroup)paramLayoutInflater.inflate(2130968806, null));
    this.mTitleBar = ((MapTitleBar)this.mGroupView.findViewById(2131624146));
    this.mResultListView = ((XListView)this.mGroupView.findViewById(2131624147));
    this.mDrawingLayout = ((LinearLayout)this.mGroupView.findViewById(2131625168));
    this.mHandleView = ((ImageView)this.mGroupView.findViewById(2131625169));
    this.mHandleView.setOnTouchListener(this.mTouchListener);
    this.mTitleBar.setRightButtonBackground(StyleManager.getDrawable(2130839441));
    this.mTitleBar.setRightButtonVisible(true);
    this.mTitleBar.setLeftOnClickedListener(getOnClickListener());
    this.mTitleBar.setRightOnClickedListener(getOnClickListener());
    this.mResultListView.setAutoLoadEnable(false);
    this.mResultListView.setDividerHeight(0);
    this.mResultListView.setXListViewListener(this.mIXListViewListener);
    this.mResultListView.setPullRefreshEnable(false);
    this.mSortingRl = ((RelativeLayout)this.mGroupView.findViewById(2131624148));
    this.mSortingRl.setVisibility(8);
    this.mSortingRl.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mCloseSortingIv = ((ImageView)this.mGroupView.findViewById(2131624149));
    this.mSortByKey = ((RelativeLayout)this.mGroupView.findViewById(2131624150));
    this.mSortByDistance = ((RelativeLayout)this.mGroupView.findViewById(2131624151));
    this.mSortByKeyTv = ((TextView)this.mGroupView.findViewById(2131624152));
    this.mSortByDistanceTv = ((TextView)this.mGroupView.findViewById(2131624154));
    this.mSortByKeyIv = ((ImageView)this.mGroupView.findViewById(2131624153));
    this.mSortByDistanceIv = ((ImageView)this.mGroupView.findViewById(2131624155));
    this.mCloseSortingIv.setOnClickListener(getOnClickListener());
    this.mSortByKey.setOnClickListener(getOnClickListener());
    this.mSortByDistance.setOnClickListener(getOnClickListener());
    this.mViewPager = ((ViewPager)this.mGroupView.findViewById(2131625170));
    return this.mGroupView;
  }
  
  protected void onInitMap() {}
  
  protected void onInitView()
  {
    getBundle();
    this.mDrawingLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }
  
  public void onPause()
  {
    super.onPause();
    BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    PoiController.getInstance().focusItem(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.isFromVoiceCommand) && (!this.isVoiceCommandResponsed))
    {
      this.isVoiceCommandResponsed = true;
      if ((this.mSearchPoiPager != null) && (this.mSearchPoiPager.getPoiList() != null)) {
        responsePoiResultCountToVoiceCommand(this.mSearchPoiPager.getPoiList().size());
      }
    }
    setMapLayerMode(2);
    BNMapController.getInstance().showLayer(3, false);
    BNMapController.getInstance().updateLayer(3);
    int i = ScreenUtil.getInstance().getHeightPixels();
    int j = ScreenUtil.getInstance().dip2px(250);
    PoiController.getInstance().setMapffset(0L, i - j);
    updateMapView(Middle_TOP_NORMAL);
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    if (paramInt != this.mLastOrientation) {
      this.mLastOrientation = paramInt;
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    this.mTitleBar.onUpdateStyle(paramBoolean);
    this.mHandleView.setBackgroundDrawable(StyleManager.getDrawable(2130837738));
    if (this.mResultAdapter != null) {
      this.mResultAdapter.notifyDataSetChanged();
    }
    this.mResultListView.setBackgroundColor(StyleManager.getColor(2131558420));
    this.mResultListView.setTextColor(StyleManager.getColor(2131559131));
    this.mHandleView.setImageDrawable(StyleManager.getDrawable(2130837919));
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if ((3 == paramInt1) && (3 == paramInt2) && (paramInt3 >= 21) && (paramInt3 <= 30))
    {
      if (!onVoiceCommandToClickPoiResultItem(paramInt3 - 21)) {
        break label54;
      }
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 1);
    }
    for (;;)
    {
      return super.onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
      label54:
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 3);
    }
  }
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    return false;
  }
  
  protected void sortListByDistance()
  {
    boolean bool2 = c.a().f();
    GeoPoint localGeoPoint = BNGeoLocateManager.getInstance().getLastValidLocation();
    if ((localGeoPoint != null) && (localGeoPoint.getLatitudeE6() == Integer.MIN_VALUE) && (localGeoPoint.getLongitudeE6() == Integer.MIN_VALUE))
    {
      TipTool.onCreateToastDialog(getContext(), 2131298923);
      dismissDialog(this.mFilterRuleDialog);
      return;
    }
    BNPoiSearcher.getInstance().quickSortByDistance(localGeoPoint, this.mPoiList);
    if (!this.isListSort) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isListSort = bool1;
      updateViewWithOrientation(this.mLastOrientation, bool2);
      return;
    }
  }
  
  protected void sortListByRule()
  {
    this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
  }
  
  public class SearchResultViewPagerAdapter
    extends PagerAdapter
  {
    View convertView;
    List<SearchPoi> mPoiList;
    
    public SearchResultViewPagerAdapter()
    {
      List localList;
      this.mPoiList = localList;
    }
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)paramObject);
    }
    
    public void finishUpdate(View paramView) {}
    
    public int getCount()
    {
      return this.mPoiList.size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      View localView = LayoutInflater.from(SearchResultFragment.this.getContext()).inflate(2130969012, null);
      SearchResultFragment.ViewHodler localViewHodler = new SearchResultFragment.ViewHodler();
      localViewHodler.mVerDiverderA = localView.findViewById(2131624189);
      localViewHodler.mBtnStartNavi = localView.findViewById(2131624190);
      localViewHodler.mBtnNameAddr = localView.findViewById(2131624193);
      localViewHodler.mTvName = ((TextView)localView.findViewById(2131624196));
      localViewHodler.mTvAddr = ((TextView)localView.findViewById(2131624197));
      localViewHodler.mTvStartNavi = ((TextView)localView.findViewById(2131624191));
      localViewHodler.mTvDistance = ((TextView)localView.findViewById(2131624192));
      localViewHodler.mTvNum = ((TextView)localView.findViewById(2131624187));
      localViewHodler.mDivider = localView.findViewById(2131624322);
      localViewHodler.mIcResult = ((ImageView)localView.findViewById(2131624605));
      localViewHodler.mLayoutChildBottom = ((LinearLayout)localView.findViewById(2131624607));
      localViewHodler.mPoiParent = ((RelativeLayout)localView.findViewById(2131624603));
      localView.setTag(localViewHodler);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
      localViewHodler.mVerDiverderA.setBackgroundColor(StyleManager.getColor(2131559139));
      localViewHodler.mBtnStartNavi.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
      localViewHodler.mBtnNameAddr.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
      localViewHodler.mTvName.setTextColor(StyleManager.getColor(2131559141));
      localViewHodler.mTvAddr.setTextColor(StyleManager.getColor(2131559128));
      localViewHodler.mTvStartNavi.setTextColor(StyleManager.getColor(2131559135));
      localViewHodler.mTvDistance.setTextColor(StyleManager.getColor(2131559133));
      localViewHodler.mDivider.setBackgroundDrawable(StyleManager.getDrawable(2130838474));
      localViewHodler.mLayoutChildBottom.setBackgroundColor(StyleManager.getColor(2131558424));
      localViewHodler.mPoiParent.setBackgroundColor(StyleManager.getColor(2131558420));
      localViewHodler.mDivider.setBackgroundDrawable(StyleManager.getDrawable(2130838474));
      localViewHodler.mLayoutChildBottom.setBackgroundColor(StyleManager.getColor(2131558424));
      localViewHodler.mTvNum.setTextColor(StyleManager.getColor(2131559143));
      localViewHodler.mTvNum.setText(paramInt + 1 + "");
      SearchPoi localSearchPoi = (SearchPoi)this.mPoiList.get(paramInt);
      if (localSearchPoi != null)
      {
        localViewHodler.mTvName.setText(localSearchPoi.mName);
        localViewHodler.mTvAddr.setText(localSearchPoi.mAddress);
        localViewHodler.mTvDistance.setText(PoiController.getInstance().getDistance2CurrentPoint(localSearchPoi));
      }
      localViewHodler.mBtnStartNavi.setTag(localSearchPoi);
      localViewHodler.mBtnNameAddr.setTag(Integer.valueOf(paramInt));
      localViewHodler.mBtnNameAddr.setOnClickListener(SearchResultFragment.this.mResultAdapter.getNameSearchResultListener());
      localViewHodler.mBtnStartNavi.setOnClickListener(SearchResultFragment.this.mResultAdapter.getNameSearchResultListener());
      ((ViewPager)paramView).addView(localView, 0);
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
    
    public Parcelable saveState()
    {
      return null;
    }
    
    public void setPoiList(List<SearchPoi> paramList)
    {
      this.mPoiList = paramList;
    }
    
    public void startUpdate(View paramView) {}
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/SearchResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */