package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.util.w;
import com.baidu.navi.adapter.SearchResultAdapter.OnClickOnlineSearch;
import com.baidu.navi.adapter.carmode.CarmodeSearchResultAdapter;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.NameSearchHelper;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.xpulltorefresh.XListView;
import com.baidu.navi.view.xpulltorefresh.XListView.IXListViewListener;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class CarModeSearchResultFragment
  extends ContentFragment
{
  public static final String DISTRICT_ID = "district_id";
  public static final int INCOMING_CATALOG_SEARCH = 33;
  public static final int INCOMING_QUICK_ROUTE_PLAN = 34;
  public static final String INCOMING_TYPE = "incoming_type";
  public static final int INCOMING_VOICE_COMMAND = 35;
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
  private static BNNetworkingDialog mNetworkingDialog;
  private int comeFrom;
  private boolean isCityResultMode = false;
  private boolean isFromCatalogSearch = false;
  private boolean isFromOnekeyToOil = false;
  private boolean isFromVoiceCommand = false;
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
        com.baidu.carlife.core.i.e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
        paramAnonymousBNSubject = (MotionEvent)paramAnonymousObject;
        return;
      }
      switch (paramAnonymousInt2)
      {
      case 276: 
      default: 
        return;
      case 257: 
        com.baidu.carlife.core.i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_FINISHED");
        PoiController.getInstance().focusItem(true);
        return;
      case 264: 
        com.baidu.carlife.core.i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_BASE_POI_LAYER");
        return;
      case 265: 
        CarModeSearchResultFragment.this.handleClickPoiBkgLayer((MapItem)paramAnonymousObject);
        return;
      }
      com.baidu.carlife.core.i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
    }
  };
  private ImageView mBackImg;
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private ListView mCityListview;
  private View mCityResultView;
  private ImageView mCloseSortingIv;
  private int mCurrentDistrictId;
  private GeoPoint mCurrentGeoPoint;
  private DistrictInfo mDistrictInfo;
  private com.baidu.carlife.f.g mFocusAreaUp;
  private com.baidu.carlife.f.g mFocusAreaUpCityResult;
  private c mFocusList;
  private c mFocusListCityResult;
  private ViewGroup mGroupView;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = true;
      if ((CarModeSearchResultFragment.this.isDetached()) || (CarModeSearchResultFragment.this.isRemoving())) {}
      label402:
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
              CarModeSearchResultFragment.this.mResultListView.stopLoadMore();
              localObject = (SearchPoiPager)((RspData)localObject).mData;
              if (localObject != null) {
                break;
              }
              com.baidu.carlife.core.i.e("PoiSearch", "search with pager fail");
              TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298915);
            } while (CarModeSearchResultFragment.this.mResultAdapter != null);
            CarModeSearchResultFragment.this.back(null);
            return;
            if (paramAnonymousMessage.arg1 != 0) {
              break label402;
            }
            paramAnonymousMessage = ((SearchPoiPager)localObject).getPoiList();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() != 0)) {
              break;
            }
            com.baidu.carlife.core.i.e("PoiSearch", "search with pager fail");
            TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298915);
          } while (CarModeSearchResultFragment.this.mResultAdapter != null);
          CarModeSearchResultFragment.this.back(null);
          return;
          if (((SearchPoi)paramAnonymousMessage.get(0)).mType == 1)
          {
            if (((SearchPoiPager)localObject).getNetMode() == 1) {}
            for (;;)
            {
              CarModeSearchResultFragment.this.showCityList(paramAnonymousMessage, bool);
              return;
              bool = false;
            }
          }
          CarModeSearchResultFragment.access$902(CarModeSearchResultFragment.this, (SearchPoiPager)localObject);
          CarModeSearchResultFragment.this.updateSortView();
          if (CarModeSearchResultFragment.this.mResultAdapter != null) {
            CarModeSearchResultFragment.this.mResultAdapter.setSearchPager(CarModeSearchResultFragment.this.mSearchPoiPager);
          }
          for (;;)
          {
            CarModeSearchResultFragment.this.updateListView();
            CarModeSearchResultFragment.this.updateMapView();
            CarModeSearchResultFragment.access$702(CarModeSearchResultFragment.this, null);
            return;
            CarModeSearchResultFragment.access$102(CarModeSearchResultFragment.this, new CarmodeSearchResultAdapter(BaseFragment.mActivity, CarModeSearchResultFragment.this.mSearchPoiPager, CarModeSearchResultFragment.this.getNaviFragmentManager(), CarModeSearchResultFragment.this.isSetPointMode, CarModeSearchResultFragment.this));
            CarModeSearchResultFragment.this.mResultAdapter.setOnlineSearchListener(CarModeSearchResultFragment.this.mOnlineClickListener);
            CarModeSearchResultFragment.this.mResultAdapter.setShowBundle(CarModeSearchResultFragment.this.mShowBundle);
            CarModeSearchResultFragment.this.mResultListView.setItemsCanFocus(true);
            CarModeSearchResultFragment.this.mResultListView.setAdapter(CarModeSearchResultFragment.this.mResultAdapter);
            CarModeSearchResultFragment.this.mResultListView.setOnItemClickListener(CarModeSearchResultFragment.this.getOnItemClickListener());
          }
          if (!CommandResult.isNetworkErr(paramAnonymousMessage.arg1)) {
            break;
          }
          com.baidu.carlife.core.i.e("PoiSearch", "search with pager fail");
          TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298915);
          CarModeSearchResultFragment.access$702(CarModeSearchResultFragment.this, null);
        } while (CarModeSearchResultFragment.this.mResultAdapter != null);
        CarModeSearchResultFragment.this.back(null);
        return;
        com.baidu.carlife.core.i.e("PoiSearch", "search with pager fail");
        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298915);
        CarModeSearchResultFragment.access$702(CarModeSearchResultFragment.this, null);
      } while (CarModeSearchResultFragment.this.mResultAdapter != null);
      CarModeSearchResultFragment.this.back(null);
    }
  };
  private XListView.IXListViewListener mIXListViewListener = new XListView.IXListViewListener()
  {
    public void onLoadMore()
    {
      SearchPoiPager localSearchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.getNextPager();
      if ((localSearchPoiPager != null) && (localSearchPoiPager.getPoiList() != null) && (localSearchPoiPager.getPoiList().size() > 0))
      {
        CarModeSearchResultFragment.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            CarModeSearchResultFragment.this.mResultListView.stopLoadMore();
            SearchPoiPager localSearchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.getNextPager();
            if (localSearchPoiPager != null)
            {
              CarModeSearchResultFragment.access$902(CarModeSearchResultFragment.this, localSearchPoiPager);
              CarModeSearchResultFragment.this.mResultAdapter.setSearchPager(localSearchPoiPager);
              CarModeSearchResultFragment.this.updateListView();
              CarModeSearchResultFragment.this.updateMapView();
            }
          }
        }, 1000L);
        return;
      }
      localSearchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.createNextPager();
      if ((localSearchPoiPager != null) && (CarModeSearchResultFragment.this.checkCanSearchByNetMode(localSearchPoiPager.getNetMode())))
      {
        BNPoiSearcher.getInstance().setNetMode(localSearchPoiPager.getNetMode());
        BNPoiSearcher.getInstance().asynSearchWithPager(localSearchPoiPager, CarModeSearchResultFragment.this.mHandler);
        return;
      }
      CarModeSearchResultFragment.this.mResultListView.stopLoadMore();
    }
    
    public void onRefresh()
    {
      CarModeSearchResultFragment.this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          CarModeSearchResultFragment.this.mResultListView.stopRefresh();
          SearchPoiPager localSearchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.getPrevPager();
          if (localSearchPoiPager != null)
          {
            CarModeSearchResultFragment.access$902(CarModeSearchResultFragment.this, localSearchPoiPager);
            CarModeSearchResultFragment.this.mResultAdapter.setSearchPager(CarModeSearchResultFragment.this.mSearchPoiPager);
            CarModeSearchResultFragment.this.updateListView();
            CarModeSearchResultFragment.this.updateMapView();
          }
        }
      }, 1000L);
    }
  };
  private TextView mJybBtn;
  private int mLastOrientation = 0;
  private View mListviewLayout;
  private View mMapbtn;
  private View.OnKeyListener mOnKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0)) {
        switch (paramAnonymousInt)
        {
        }
      }
      do
      {
        do
        {
          return false;
        } while ((CarModeSearchResultFragment.this.mResultListView == null) || (CarModeSearchResultFragment.this.mResultListView.getSelectedItemPosition() != 1));
        return true;
      } while ((CarModeSearchResultFragment.this.mSearchPoiPager == null) || (!CarModeSearchResultFragment.this.mSearchPoiPager.isLastPager()) || (CarModeSearchResultFragment.this.mResultListView == null) || (CarModeSearchResultFragment.this.mResultListView.getSelectedItemPosition() <= CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList().size()));
      return true;
    }
  };
  private SearchResultAdapter.OnClickOnlineSearch mOnlineClickListener = new SearchResultAdapter.OnClickOnlineSearch()
  {
    public void onCountrywideOnlineSearch()
    {
      if (!NetworkUtils.getConnectStatus())
      {
        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298873);
        return;
      }
      SearchPoiPager localSearchPoiPager;
      for (Object localObject = CarModeSearchResultFragment.this.mSearchPoiPager;; localObject = localSearchPoiPager)
      {
        localSearchPoiPager = ((SearchPoiPager)localObject).getPrevPager();
        if (localSearchPoiPager == null)
        {
          localObject = ((SearchPoiPager)localObject).copy();
          ((SearchPoiPager)localObject).setNetMode(1);
          ((SearchPoiPager)localObject).setDistrict(BNPoiSearcher.getInstance().getDistrictById(0));
          e.a().a(CarModeSearchResultFragment.this.getResources().getString(2131296861), CarModeSearchResultFragment.this.mSearchDialogCancelListener);
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
          BNPoiSearcher.getInstance().setNetMode(((SearchPoiPager)localObject).getNetMode());
          BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, CarModeSearchResultFragment.this.mHandler);
          return;
        }
      }
    }
    
    public void onNormalOnlineSearch()
    {
      if (!NetworkUtils.getConnectStatus())
      {
        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298873);
        return;
      }
      SearchPoiPager localSearchPoiPager;
      for (Object localObject = CarModeSearchResultFragment.this.mSearchPoiPager;; localObject = localSearchPoiPager)
      {
        localSearchPoiPager = ((SearchPoiPager)localObject).getPrevPager();
        if (localSearchPoiPager == null)
        {
          localObject = ((SearchPoiPager)localObject).copy();
          ((SearchPoiPager)localObject).setNetMode(1);
          e.a().a(CarModeSearchResultFragment.this.getResources().getString(2131296861), CarModeSearchResultFragment.this.mSearchDialogCancelListener);
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
          BNPoiSearcher.getInstance().setNetMode(((SearchPoiPager)localObject).getNetMode());
          BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, CarModeSearchResultFragment.this.mHandler);
          return;
        }
      }
    }
  };
  private View mPoiConfirmText;
  private ArrayList<SearchPoi> mPoiList;
  private List<SearchPoi> mPreSearchCityList;
  private CarmodeSearchResultAdapter mResultAdapter;
  private XListView mResultListView;
  private com.baidu.carlife.core.screen.b mSearchDialogCancelListener = new com.baidu.carlife.core.screen.b()
  {
    public void onClick()
    {
      if (CarModeSearchResultFragment.this.mResultAdapter == null) {
        CarModeSearchResultFragment.this.onBackPressed();
      }
      BNPoiSearcher.getInstance().cancelQuery();
    }
  };
  private String mSearchKey;
  private SearchPoiPager mSearchPoiPager;
  private RelativeLayout mSortByDistance;
  private ImageView mSortByDistanceIv;
  private RelativeLayout mSortByKey;
  private ImageView mSortByKeyIv;
  private RelativeLayout mSortingRl;
  private View mViewMapLayput;
  protected j myHandler = new j()
  {
    public void careAbout()
    {
      addMsg(1002);
      addMsg(1004);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 1003: 
      default: 
        return;
      case 1004: 
        CarModeSearchResultFragment.this.updateJybButtonState();
        return;
      }
      CarModeSearchResultFragment.this.updateJybButtonState();
    }
  };
  private int netMode = 1;
  private int voiceCommandSubType = -1;
  private int voiceCommandTopType = -1;
  
  private void addTitleBarContent(LayoutInflater paramLayoutInflater)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramLayoutInflater.inflate(2130968640, null);
    this.mMapbtn = localLinearLayout.findViewById(2131624295);
    this.mMapbtn.setOnClickListener(getOnClickListener());
    localLinearLayout.findViewById(2131624294).setOnClickListener(getOnClickListener());
    setTitleBarLeftBack(paramLayoutInflater);
  }
  
  private void backFromMap()
  {
    if (isPoiComfirmPage()) {
      this.mPoiConfirmText.setVisibility(0);
    }
    for (;;)
    {
      this.mListviewLayout.setVisibility(0);
      this.mViewMapLayput.setVisibility(8);
      this.mViewMapLayput.requestFocus();
      return;
      this.mPoiConfirmText.setVisibility(8);
    }
  }
  
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
    this.comeFrom = this.mShowBundle.getInt("come_from");
    this.mSearchKey = this.mShowBundle.getString("search_key");
    setCommonTitleBar(this.mGroupView, null);
    if (this.mListviewLayout != null) {
      this.mListviewLayout.findViewById(2131624258).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CarModeSearchResultFragment.this.onBackPressed();
        }
      });
    }
    Object localObject = new TextView(mActivity);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setSingleLine(true);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setTextColor(StyleManager.getColor(2131558554));
    ((TextView)localObject).setTextSize(2, 20.0F);
    ((TextView)localObject).setText(this.mSearchKey);
    localObject = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
    if (this.mShowBundle.containsKey("district_id")) {
      this.mCurrentDistrictId = this.mShowBundle.getInt("district_id");
    }
    if (this.mShowBundle.getInt("incoming_type") == 33)
    {
      this.isFromCatalogSearch = true;
      if (this.mShowBundle.getInt("incoming_type") != 5) {
        break label459;
      }
      this.isFromOnekeyToOil = true;
      label204:
      if (this.mShowBundle.getInt("incoming_type") != 35) {
        break label467;
      }
      this.isFromVoiceCommand = true;
      this.isVoiceCommandResponsed = false;
      this.voiceCommandTopType = this.mShowBundle.getInt("Key_Bundle_VC_Top_Type", -1);
      this.voiceCommandSubType = this.mShowBundle.getInt("Key_Bundle_VC_Sub_Type", -1);
      label258:
      if (this.mShowBundle.getInt("search_mode") != 1) {
        break label475;
      }
      this.netMode = 1;
      label276:
      if (!this.mShowBundle.containsKey("select_point_action")) {
        break label495;
      }
      this.isSetPointMode = true;
      label294:
      int i = this.mShowBundle.getInt("select_point_action");
      if ((i != 5) && (i != 4)) {
        break label503;
      }
      this.isSetHomeComp = true;
      com.baidu.carlife.core.i.e("PoiSearch", "isSetHomeComp =" + this.isSetHomeComp);
    }
    for (;;)
    {
      if (!this.mShowBundle.containsKey("poi_data")) {
        break label511;
      }
      localObject = (ArrayList)this.mShowBundle.getSerializable("poi_data");
      this.mResultAdapter = new CarmodeSearchResultAdapter(getContext(), (List)localObject, getNaviFragmentManager(), false);
      this.mResultListView.setItemsCanFocus(true);
      this.mResultListView.setPullLoadEnable(false, false);
      this.mResultListView.setAdapter(this.mResultAdapter);
      this.mResultListView.setOnItemClickListener(getOnItemClickListener());
      this.isCityResultMode = false;
      this.mShowBundle.remove("poi_data");
      return;
      this.isFromCatalogSearch = false;
      break;
      label459:
      this.isFromOnekeyToOil = false;
      break label204;
      label467:
      this.isFromVoiceCommand = false;
      break label258;
      label475:
      if (this.mShowBundle.getInt("search_mode") != 0) {
        break label276;
      }
      this.netMode = 0;
      break label276;
      label495:
      this.isSetPointMode = false;
      break label294;
      label503:
      this.isSetHomeComp = false;
    }
    label511:
    localObject = ((PoiSearchModel)localObject).getSearchPoiPagerList();
    if (((List)localObject).size() > 0)
    {
      this.mSearchPoiPager = ((SearchPoiPager)((List)localObject).get(0));
      updateSortView();
      localObject = this.mSearchPoiPager.getPoiList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((SearchPoi)((List)localObject).get(0)).mType == 1)
        {
          if (this.mSearchPoiPager.getNetMode() == 1) {
            bool = true;
          }
          showCityList((List)localObject, bool);
          this.isCityResultMode = true;
          BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 2);
          return;
        }
        this.mResultAdapter = new CarmodeSearchResultAdapter(getContext(), this.mSearchPoiPager, getNaviFragmentManager(), this.isSetPointMode, this);
        this.mResultAdapter.setShowBundle(this.mShowBundle);
        this.mResultAdapter.setOnlineSearchListener(this.mOnlineClickListener);
        this.mResultListView.setItemsCanFocus(true);
        this.mResultListView.setAdapter(this.mResultAdapter);
        this.mResultListView.setOnItemClickListener(getOnItemClickListener());
        updateListView();
        this.isCityResultMode = false;
        return;
      }
      back(null);
      return;
    }
    back(null);
  }
  
  private View.OnClickListener getOnClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramAnonymousView.getId();
        if (i == 2131624137) {
          if (CarModeSearchResultFragment.this.isFromCatalogSearch) {
            CarModeSearchResultFragment.this.back(null);
          }
        }
        do
        {
          do
          {
            do
            {
              return;
              CarModeSearchResultFragment.this.back(null);
              CarModeSearchResultFragment.this.back(null);
              return;
              if (i == 2131624286)
              {
                CarModeSearchResultFragment.this.mSortingRl.setVisibility(0);
                com.baidu.carlife.util.i.a(CarModeSearchResultFragment.this.mCloseSortingIv).a();
                return;
              }
              if (i == 2131624149)
              {
                CarModeSearchResultFragment.this.mSortingRl.setVisibility(8);
                return;
              }
              if (i == 2131624150)
              {
                CarModeSearchResultFragment.this.mSearchPoiPager.setSortType(1);
                CarModeSearchResultFragment.this.mSortingRl.setVisibility(8);
                CarModeSearchResultFragment.this.sortListByRule();
                CarModeSearchResultFragment.this.mSortByKeyIv.setVisibility(0);
                CarModeSearchResultFragment.this.mSortByDistanceIv.setVisibility(8);
                PoiController.getInstance().updatePoiBkgLayer(CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList());
                return;
              }
              if (i == 2131624151)
              {
                paramAnonymousView = BNLocationManagerProxy.getInstance().getLastValidLocation();
                if ((paramAnonymousView != null) && (paramAnonymousView.isValid()))
                {
                  CarModeSearchResultFragment.this.mSearchPoiPager.setSortType(2);
                  CarModeSearchResultFragment.this.mSortingRl.setVisibility(8);
                  CarModeSearchResultFragment.this.sortListByRule();
                  CarModeSearchResultFragment.this.mSortByKeyIv.setVisibility(8);
                  CarModeSearchResultFragment.this.mSortByDistanceIv.setVisibility(0);
                  paramAnonymousView = CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList();
                  PoiController.getInstance().updatePoiBkgLayer(paramAnonymousView);
                  return;
                }
                TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), 2131298761);
                return;
              }
            } while (i == 2131624188);
            if (i != 2131624295) {
              break;
            }
            if (CarModeSearchResultFragment.this.isSetHomeComp)
            {
              CarModeSearchResultFragment.this.viewMap();
              return;
            }
          } while (CarModeSearchResultFragment.this.mResultAdapter == null);
          CarModeSearchResultFragment.this.mResultAdapter.interPoidetail();
          return;
          if (i == 2131624294)
          {
            CarModeSearchResultFragment.this.mSortingRl.setVisibility(0);
            return;
          }
          if (i == 2131624118)
          {
            CarModeSearchResultFragment.this.pageBack(CarModeSearchResultFragment.this.mModuleFrom);
            return;
          }
        } while (i != 2131624258);
        CarModeSearchResultFragment.this.onBackPressed();
      }
    };
  }
  
  private AdapterView.OnItemClickListener getOnItemClickListener()
  {
    new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int j = 0;
        int i = j;
        if (CarModeSearchResultFragment.this.mSearchPoiPager != null)
        {
          i = j;
          if (CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList() != null) {
            i = CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList().size();
          }
        }
        if (paramAnonymousInt > i) {
          if ((paramAnonymousView.findViewById(2131624530) != null) && (CarModeSearchResultFragment.this.mResultAdapter != null)) {
            CarModeSearchResultFragment.this.mResultAdapter.clickSearchBtn();
          }
        }
        do
        {
          do
          {
            do
            {
              return;
            } while (CarModeSearchResultFragment.this.mIXListViewListener == null);
            CarModeSearchResultFragment.this.mIXListViewListener.onLoadMore();
            return;
          } while (paramAnonymousInt == 0);
          paramAnonymousAdapterView = (SearchPoi)CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList().get(paramAnonymousInt - 1);
        } while (paramAnonymousAdapterView == null);
        if (!CarModeSearchResultFragment.this.isSetPointMode)
        {
          if (CarModeSearchResultFragment.this.comeFrom == 8) {
            StatisticManager.onEvent("DISCOVER_QJY_0002", "DISCOVER_QJY_0002");
          }
          PoiController.getInstance().startCalcRoute(paramAnonymousAdapterView, CarModeSearchResultFragment.this);
          return;
        }
        if (CarModeSearchResultFragment.this.mShowBundle.getInt("select_point_action") == 1)
        {
          FavoriteDestinationController.getInstance().addFavoriteDestFromDB(FavoriteDestinationController.getInstance().createRoutePlanNode(paramAnonymousAdapterView), null);
          CarModeSearchResultFragment.this.backTo(CarModeSearchResultFragment.this.mShowBundle.getInt("from_Fragment"), null);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("select_point_action", CarModeSearchResultFragment.this.mShowBundle.getInt("select_point_action"));
        UIModel.settingAddress(paramAnonymousAdapterView, CarModeSearchResultFragment.this.getContext(), paramAnonymousView);
        paramAnonymousInt = CarModeSearchResultFragment.this.mShowBundle.getInt("module_from");
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 4) || (paramAnonymousInt == 2))
        {
          BaseFragment.getNaviActivity().onBackPressed();
          return;
        }
        CarModeSearchResultFragment.this.backTo(CarModeSearchResultFragment.this.mShowBundle.getInt("from_Fragment"), null);
      }
    };
  }
  
  private boolean isJybEnable()
  {
    return (this.comeFrom == 8) && (com.baidu.carlife.e.a.a().h()) && (!com.baidu.carlife.logic.g.a().c());
  }
  
  private boolean isPoiComfirmPage()
  {
    int i = this.mShowBundle.getInt("select_point_action");
    return (i == 1) || (i == 5) || (i == 4);
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
  
  private void responsePoiResultCountToVoiceCommand(int paramInt) {}
  
  private void searchSpace(int paramInt)
  {
    Object localObject = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (SearchStrategyHelper.getInstance(mActivity).checkCanSearchByNetMode(this.netMode))
    {
      localObject = new SearchPoiPager(paramInt, this.mDistrictInfo, (SearchCircle)localObject, 10, this.netMode);
      e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, this.mHandler);
    }
  }
  
  private void searchSpace(String paramString)
  {
    SearchCircle localSearchCircle = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (SearchStrategyHelper.getInstance(mActivity).checkCanSearchByNetMode(this.netMode))
    {
      paramString = new SearchPoiPager(paramString, this.mDistrictInfo, localSearchCircle, 10, this.netMode);
      e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
      BNPoiSearcher.getInstance().setNetMode(paramString.getNetMode());
      BNPoiSearcher.getInstance().asynSearchWithPager(paramString, this.mHandler);
    }
  }
  
  private void setTitleBarLeftBack(LayoutInflater paramLayoutInflater)
  {
    this.mBackImg = ((ImageView)((LinearLayout)paramLayoutInflater.inflate(2130968637, null)).findViewById(2131624118));
    this.mBackImg.setOnClickListener(getOnClickListener());
  }
  
  private void showCityList(final List<SearchPoi> paramList, boolean paramBoolean)
  {
    if ((this.mPreSearchCityList != null) && (this.mPreSearchCityList.size() == paramList.size()))
    {
      i = 0;
      while (i < this.mPreSearchCityList.size())
      {
        localObject1 = (SearchPoi)this.mPreSearchCityList.get(i);
        localObject2 = (SearchPoi)paramList.get(i);
        if ((localObject1 == null) || (localObject2 == null) || (((SearchPoi)localObject1).mId != ((SearchPoi)localObject2).mId)) {
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
    this.mResultListView.setVisibility(8);
    this.mCityResultView.setVisibility(0);
    this.mPoiConfirmText.setVisibility(8);
    initFocusChain(this.mGroupView);
    Object localObject1 = (ListView)this.mCityResultView.findViewById(2131624161);
    Object localObject2 = new ArrayAdapter(mActivity, 2130968607, 2131624096);
    int i = 0;
    if (i < paramList.size())
    {
      SearchPoi localSearchPoi = (SearchPoi)paramList.get(i);
      int j;
      if (paramBoolean) {
        if (localSearchPoi.mWeight == 0)
        {
          j = 1;
          label235:
          ((ArrayAdapter)localObject2).add(localSearchPoi.mName + "(" + j + ")");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = localSearchPoi.mWeight;
        break label235;
        ((ArrayAdapter)localObject2).add(localSearchPoi.mName);
      }
    }
    ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
    ((ListView)localObject1).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        CarModeSearchResultFragment.this.mCityResultView.setVisibility(8);
        CarModeSearchResultFragment.this.mResultListView.setVisibility(0);
        if (CarModeSearchResultFragment.this.isPoiComfirmPage())
        {
          CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(0);
          CarModeSearchResultFragment.this.initFocusChain(CarModeSearchResultFragment.this.mGroupView);
          paramAnonymousAdapterView = (SearchPoi)paramList.get(paramAnonymousInt);
          if (((paramAnonymousAdapterView.mDistrictId & 0xFFFF0000) <= 0) || ((paramAnonymousAdapterView.mDistrictId & 0xFFFF) != 0)) {
            break label235;
          }
        }
        label235:
        for (paramAnonymousAdapterView = BNPoiSearcher.getInstance().getDistrictById(paramAnonymousAdapterView.mDistrictId >> 16);; paramAnonymousAdapterView = BNPoiSearcher.getInstance().getDistrictById(paramAnonymousAdapterView.mDistrictId))
        {
          paramAnonymousAdapterView = new SearchPoiPager(CarModeSearchResultFragment.this.mSearchPoiPager.getSearchKey(), paramAnonymousAdapterView, 10, CarModeSearchResultFragment.this.mSearchPoiPager.getNetMode());
          e.a().a(CarModeSearchResultFragment.this.getResources().getString(2131296861), CarModeSearchResultFragment.this.mSearchDialogCancelListener);
          ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
          BNPoiSearcher.getInstance().setNetMode(paramAnonymousAdapterView.getNetMode());
          BNPoiSearcher.getInstance().asynSearchWithPager(paramAnonymousAdapterView, CarModeSearchResultFragment.this.mHandler);
          CarModeSearchResultFragment.access$702(CarModeSearchResultFragment.this, paramList);
          return;
          CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(8);
          break;
        }
      }
    });
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
  
  private void trySearchSpaceId(int paramInt)
  {
    this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
    if (this.mDistrictInfo == null) {
      this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    }
    this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if (!BNLocationManagerProxy.getInstance().isLocationValid())
    {
      TipTool.onCreateToastDialog(mActivity, 2131298923);
      return;
    }
    this.netMode = SearchStrategyHelper.getInstance(mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
    this.netMode = NameSearchHelper.getInstance().getFinalNetMode(this.netMode);
    searchSpace(paramInt);
  }
  
  private void trySearchSpaceKey(String paramString)
  {
    this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
    if (this.mDistrictInfo == null) {
      this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    }
    this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if (!BNLocationManagerProxy.getInstance().isLocationValid())
    {
      TipTool.onCreateToastDialog(mActivity, 2131298923);
      return;
    }
    this.netMode = SearchStrategyHelper.getInstance(mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
    this.netMode = NameSearchHelper.getInstance().getFinalNetMode(this.netMode);
    searchSpace(paramString);
  }
  
  private void updateJybButtonState()
  {
    if (this.mJybBtn == null) {}
    do
    {
      return;
      if (!isJybEnable()) {
        break;
      }
      this.mJybBtn.setVisibility(0);
    } while (!com.baidu.carlife.l.a.a().N());
    this.mJybBtn.setVisibility(8);
    return;
    this.mJybBtn.setVisibility(8);
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
      this.mResultListView.setSelection(1);
      return;
      label52:
      this.mResultListView.setPullRefreshEnable(false);
      break;
      label63:
      this.mResultListView.setPullLoadEnable(true);
    }
  }
  
  private void updateMapView() {}
  
  private void viewMap()
  {
    this.mListviewLayout.setVisibility(8);
    this.mViewMapLayput.setVisibility(0);
    this.mViewMapLayput.requestFocus();
  }
  
  public boolean checkCanSearchByNetMode(int paramInt)
  {
    if (paramInt == 0) {}
    while (NetworkUtils.isNetworkAvailable(getContext())) {
      return true;
    }
    TipTool.onCreateToastDialog(getContext(), 2131298924);
    return false;
  }
  
  public void driving()
  {
    com.baidu.carlife.core.i.b("yftech", "CarModeSearchResultFragment driving = " + this.mModuleFrom);
    dismissSearchNetworkingDialog();
    if (com.baidu.carlife.custom.b.a().b()) {
      if (this.comeFrom == 8) {
        pageBack(this.mModuleFrom);
      }
    }
    for (;;)
    {
      com.baidu.carlife.custom.a.a().d();
      return;
      backTo(17, null);
      continue;
      backTo(17, null);
    }
  }
  
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
  
  public void initFocusChain(View paramView)
  {
    if (getCurrentFragmentType() != 35) {
      return;
    }
    if (this.mFocusAreaUp == null)
    {
      this.mFocusAreaUp = new com.baidu.carlife.f.g(paramView.findViewById(2131624143), 2);
      this.mFocusAreaUp.d(paramView.findViewById(2131624143).findViewById(2131624258));
    }
    if (this.mFocusAreaUpCityResult == null)
    {
      this.mFocusAreaUpCityResult = new com.baidu.carlife.f.g(paramView.findViewById(2131624158), 2);
      this.mFocusAreaUpCityResult.d(paramView.findViewById(2131624158).findViewById(2131624258));
    }
    if (this.mFocusList == null)
    {
      this.mFocusList = new c(this.mResultListView, 6);
      this.mFocusList.a(this.mOnKeyListener);
    }
    if ((this.mResultListView != null) && (this.mResultListView.getSelectedItemPosition() == 0)) {
      this.mResultListView.setSelection(1);
    }
    if (this.mFocusListCityResult == null) {
      this.mFocusListCityResult = new c(this.mCityListview, 6);
    }
    if (this.mCityResultView.getVisibility() != 0)
    {
      d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaUp, this.mFocusList });
      d.a().h(this.mFocusList);
      return;
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaUpCityResult, this.mFocusListCityResult });
    d.a().h(this.mFocusListCityResult);
  }
  
  public boolean onBackPressed()
  {
    if ((this.mSortingRl != null) && (this.mSortingRl.getVisibility() == 0))
    {
      this.mSortingRl.setVisibility(8);
      return true;
    }
    if ((this.mCityResultView != null) && (this.mCityResultView.getVisibility() == 0) && (this.mResultAdapter != null))
    {
      this.mCityResultView.setVisibility(8);
      this.mResultListView.setVisibility(0);
      if (isPoiComfirmPage()) {
        this.mPoiConfirmText.setVisibility(0);
      }
      for (;;)
      {
        this.mPreSearchCityList = null;
        onInitFocusAreas();
        return true;
        this.mPoiConfirmText.setVisibility(8);
      }
    }
    pageBack(this.mModuleFrom);
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mLastOrientation = getResources().getConfiguration().orientation;
    this.mGroupView = ((ViewGroup)paramLayoutInflater.inflate(2130968615, null));
    this.mPoiConfirmText = this.mGroupView.findViewById(2131624145);
    if (isPoiComfirmPage()) {
      this.mPoiConfirmText.setVisibility(0);
    }
    for (;;)
    {
      setCommonTitleBar(this.mGroupView.findViewById(2131624142), null);
      this.mResultListView = ((XListView)this.mGroupView.findViewById(2131624147));
      this.mViewMapLayput = this.mGroupView.findViewById(2131624162);
      this.mListviewLayout = this.mGroupView.findViewById(2131624142);
      this.mListviewLayout.findViewById(2131624258).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CarModeSearchResultFragment.this.onBackPressed();
        }
      });
      this.mGroupView.findViewById(2131624163).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CarModeSearchResultFragment.this.backFromMap();
        }
      });
      this.mCityResultView = this.mGroupView.findViewById(2131624156);
      this.mCityResultView.findViewById(2131624258).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CarModeSearchResultFragment.this.onBackPressed();
        }
      });
      this.mCityResultView.findViewById(2131624258).setBackground(com.baidu.carlife.view.a.b.a(mActivity));
      this.mCityResultView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.mGroupView.findViewById(2131624157).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (CarModeSearchResultFragment.this.mResultAdapter == null)
          {
            CarModeSearchResultFragment.this.onBackPressed();
            return;
          }
          CarModeSearchResultFragment.this.mCityResultView.setVisibility(8);
          CarModeSearchResultFragment.this.mResultListView.setVisibility(0);
          if (CarModeSearchResultFragment.this.isPoiComfirmPage()) {
            CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(0);
          }
          for (;;)
          {
            CarModeSearchResultFragment.this.initFocusChain(CarModeSearchResultFragment.this.mGroupView);
            CarModeSearchResultFragment.access$702(CarModeSearchResultFragment.this, null);
            return;
            CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(8);
          }
        }
      });
      addTitleBarContent(paramLayoutInflater);
      this.mResultListView.setAutoLoadEnable(false);
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
      this.mSortByKeyIv = ((ImageView)this.mGroupView.findViewById(2131624153));
      this.mSortByDistanceIv = ((ImageView)this.mGroupView.findViewById(2131624155));
      this.mCloseSortingIv.setOnClickListener(getOnClickListener());
      this.mSortByKey.setOnClickListener(getOnClickListener());
      this.mSortByDistance.setOnClickListener(getOnClickListener());
      this.mCityListview = ((ListView)this.mCityResultView.findViewById(2131624161));
      this.mJybBtn = ((TextView)this.mGroupView.findViewById(2131624144));
      this.mJybBtn.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
      this.mJybBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (CarModeSearchResultFragment.this.isJybEnable())
          {
            StatisticManager.onEvent("DISCOVER_JYB_0001");
            CarModeSearchResultFragment.this.openWebView(2, 561, CarModeSearchResultFragment.this.getStringUtil(2131297512), "https://jyb.jyblife.com/buy/clBuyPage");
            return;
          }
          w.a("暂不支持该服务", 0);
        }
      });
      k.a(this.myHandler);
      return this.mGroupView;
      this.mPoiConfirmText.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    k.b(this.myHandler);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("back_bundle"))) {
      this.mBackBundle = localBundle.getBundle("back_bundle");
    }
    if ((this.mBackBundle != null) && (this.mBackBundle.getInt("bundle_type", 0) == 2))
    {
      trySearchSpaceKey(getStringUtil(2131297515));
      this.mBackBundle = null;
    }
  }
  
  public void onInitFocusAreas()
  {
    initFocusChain(this.mGroupView);
  }
  
  protected void onInitView()
  {
    getBundle();
    this.mResultListView.setTextColor(StyleManager.getColor(2131558556));
    updateJybButtonState();
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
    boolean bool = true;
    super.onResume();
    if ((this.isFromVoiceCommand) && (!this.isVoiceCommandResponsed))
    {
      this.isVoiceCommandResponsed = true;
      if ((this.mSearchPoiPager != null) && (this.mSearchPoiPager.getPoiList() != null)) {
        responsePoiResultCountToVoiceCommand(this.mSearchPoiPager.getPoiList().size());
      }
    }
    BNMapController.getInstance().updateLayer(3);
    if (!this.isCityResultMode) {
      updateMapView();
    }
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    BNMapController localBNMapController;
    if (NavMapManager.getInstance().getNaviMapMode() != 5)
    {
      com.baidu.baidumaps.f.a.a.a.a().d();
      com.baidu.baidumaps.f.a.a.a.a().a(false, null);
      NavMapManager.getInstance().set3DGestureEnable(false);
      localBNMapController = BNMapController.getInstance();
      if (BNStyleManager.getRealDayStyle()) {
        break label133;
      }
    }
    for (;;)
    {
      localBNMapController.setNightMode(bool);
      return;
      label133:
      bool = false;
    }
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    if (paramInt != this.mLastOrientation) {
      this.mLastOrientation = paramInt;
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(int paramInt)
  {
    com.baidu.carlife.core.i.b("PoiSearch", "CarModeSearchResult onVoiceCommand: " + paramInt);
    if (paramInt < 0) {}
    AdapterView.OnItemClickListener localOnItemClickListener;
    do
    {
      do
      {
        return false;
      } while (this.mResultListView == null);
      localOnItemClickListener = this.mResultListView.getOnItemClickListener();
    } while (localOnItemClickListener == null);
    localOnItemClickListener.onItemClick(this.mResultListView, this.mGroupView, paramInt + 1, 0L);
    return true;
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
    com.baidu.carlife.core.i.b("PoiSearch", "CarModeSearchResult onVoiceCommand: " + paramString1);
    return false;
  }
  
  protected void sortListByRule()
  {
    this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
  }
  
  public void stopDriving() {}
  
  public void updateSortView()
  {
    this.mSortByKeyIv.setVisibility(0);
    this.mSortByDistanceIv.setVisibility(8);
    switch (this.mSearchPoiPager.getSearchType())
    {
    default: 
      return;
    case 6: 
      this.mSortByKeyIv.setVisibility(8);
      this.mSortByDistanceIv.setVisibility(0);
      this.mSearchPoiPager.setSortType(2);
      return;
    }
    this.mSortByKeyIv.setVisibility(0);
    this.mSortByDistanceIv.setVisibility(8);
    this.mSearchPoiPager.setSortType(1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeSearchResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */