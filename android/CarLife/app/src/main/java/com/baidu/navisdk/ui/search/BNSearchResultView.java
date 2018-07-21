package com.baidu.navisdk.ui.search;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.search.xpulltorefresh.XListView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNListDialog;
import com.baidu.navisdk.ui.widget.BNMapControlPanel;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.ui.widget.BNMapTitleBar;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import com.google.android.support.v4.view.PagerAdapter;
import com.google.android.support.v4.view.ViewPager;
import com.google.android.support.v4.view.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BNSearchResultView
  extends RelativeLayout
{
  public static final String DISTRICT_ID = "district_id";
  private static int FOCUS_HEIGHT_MIDDLE = ScreenUtil.getInstance().getWindowHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight() - ScreenUtil.getInstance().dip2px(250);
  public static final int INCOMING_CATALOG_SEARCH = 33;
  public static final int INCOMING_QUICK_ROUTE_PLAN = 34;
  public static final String INCOMING_TYPE = "incoming_type";
  public static final int INCOMING_VOICE_COMMAND = 35;
  private static int MARGINTOP_NORMAL = ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight() - ScreenUtil.getInstance().dip2px(100);
  private static int Middle_TOP_NORMAL = ScreenUtil.getInstance().dip2px(250);
  private static final float OFFSET_RADIO = 1.8F;
  private static final int PULL_LOAD_MORE_DELTA = 50;
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
  public static final String SORT_BY_DISTANCE = "sort_by_distance";
  public static final String SORT_BY_KEY = "sort_by_key";
  private static int VIEW_PAGE_FOCUS_HEIGHT = ScreenUtil.getInstance().dip2px(100);
  private static BNNetworkingDialog mNetworkingDialog;
  private static float mStartY;
  private int focusHeight = FOCUS_HEIGHT_MIDDLE;
  private boolean isSetPointMode = false;
  private Activity mActivity;
  private boolean mAddMapCtrlPanel = true;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt1) {}
      switch (paramAnonymousInt2)
      {
      default: 
        if (2 == paramAnonymousInt1) {
          switch (paramAnonymousInt2)
          {
          }
        }
        break;
      }
      do
      {
        return;
        if (BNSearchResultView.this.mMapControlPanel == null) {
          break;
        }
        BNSearchResultView.this.mMapControlPanel.updateView();
        break;
        if (BNSearchResultView.this.mMapControlPanel == null) {
          break;
        }
        BNSearchResultView.this.mMapControlPanel.updateView();
        break;
        BNSearchResultView.this.handleCompassClicked();
        break;
      } while (BNSearchResultView.this.mMapControlPanel == null);
      BNSearchResultView.this.mMapControlPanel.handleScrollGesture();
      return;
      if (BNSearchResultView.this.mMapControlPanel != null) {
        BNSearchResultView.this.mMapControlPanel.handleSingleTouchGesture();
      }
      if ((BNSearchResultView.this.mViewPager != null) && (!BNSearchResultView.this.mViewPager.isShown()) && (!BNSearchResultView.this.isGeoLayoutVisible()) && (BNSearchResultView.this.mLastTopMargin == BNSearchResultView.Middle_TOP_NORMAL))
      {
        BNSearchResultView.this.setListViewMargin(BNSearchResultView.MARGINTOP_NORMAL);
        BNSearchResultView.this.mViewPager.setVisibility(0);
        BNSearchResultView.this.mResultListView.setVisibility(8);
        BNSearchResultView.this.mViewMapLayput.setVisibility(0);
        BNSearchResultView.this.loadMapCtrlPanel(BNSearchResultView.this.view, true, true);
        BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.VIEW_PAGE_FOCUS_HEIGHT);
        BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.MARGINTOP_NORMAL, BNSearchResultView.this.focusHeight);
      }
      BNSearchResultView.this.switchMapcontrolVisible();
    }
  };
  private IBNSearchResultListener mBNSearchResutlListerner = null;
  private RelativeLayout mBgView;
  private View mBtnNameAddr;
  private View mBtnStartNavi;
  private BNListDialog mCityListDialog;
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
          return;
          i = paramAnonymousView.getId();
          if (i != 1711867029) {
            break;
          }
        } while ((BNSearchResultView.this.searchGeoPoi == null) || (BNSearchResultView.this.mBNSearchResutlListerner == null));
        BNSearchResultView.this.mBNSearchResutlListerner.startGoNavi(false, BNSearchResultView.this.searchGeoPoi);
        return;
      } while ((i != 1711867033) || (BNSearchResultView.this.searchGeoPoi == null));
      BNSearchResultView.this.mBNSearchResutlListerner.setFocusMadianIndex(BNSearchResultView.this.searchGeoPoi, false, -1);
    }
  };
  private ImageView mCloseSortingIv;
  private Context mContext;
  private int mCurrentIndex = -1;
  private DistrictInfo mDistrict;
  View mDivider;
  private LinearLayout mDrawingLayout;
  private boolean mFirstItsOn = false;
  private FrameLayout mGeoLayout;
  private ImageView mHandleView;
  ImageView mIcResult;
  public BNMapControlPanel.IItsClickListener mItsClickListener = new BNMapControlPanel.IItsClickListener()
  {
    public void onClickIts()
    {
      BNSearchResultView.access$002(BNSearchResultView.this, BNSettingManager.isFirstItsOn());
      GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
      if ((localGeoPoint != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))) {
        BNSearchResultView.access$102(BNSearchResultView.this, BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0));
      }
      if (!BNSettingManager.isRoadCondOnOrOff())
      {
        if (PreferenceHelper.getInstance(BNSearchResultView.this.mContext).getBoolean("NAVI_REAL_HISTORY_ITS", true))
        {
          if (BNSearchResultView.this.mFirstItsOn) {
            BNSettingManager.setFirstItsOn(false);
          }
          if (!NetworkUtils.isNetworkAvailable(BNSearchResultView.this.mContext)) {
            break label201;
          }
          BNMapController.getInstance().switchITSMode(true);
          BNMapController.getInstance().showTrafficMap(true);
          BNSettingManager.setRoadCondOnOff(true);
          if ((BNSearchResultView.this.mDistrict != null) && (!BNMapController.getInstance().checkRoadConditionSupport(BNSearchResultView.this.mDistrict.mId))) {
            TipTool.onCreateToastDialog(BNSearchResultView.this.mContext, JarUtils.getResources().getString(1711669394));
          }
        }
        else
        {
          return;
        }
        TipTool.onCreateToastDialog(BNSearchResultView.this.mContext, JarUtils.getResources().getString(1711670038));
        return;
        label201:
        BNSearchResultView.this.showItsSettingDialog();
        return;
      }
      BNMapController.getInstance().showTrafficMap(false);
      BNSettingManager.setRoadCondOnOff(false);
    }
  };
  private BNMessageDialog mItsSettingAlertDialog;
  private int mLastTopMargin = Middle_TOP_NORMAL;
  private float mLastY = -1.0F;
  private BNMapControlPanel.ILocationBtnClickListener mLocationBtnClickListener = new BNMapControlPanel.ILocationBtnClickListener()
  {
    public void onClick(int paramAnonymousInt) {}
  };
  private BNMapControlPanel mMapControlPanel;
  private MapGLSurfaceView mNMapView;
  private RelativeLayout mNewerGuideLayout;
  private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(int paramAnonymousInt) {}
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
    
    public void onPageSelected(int paramAnonymousInt)
    {
      BNSearchResultView.access$1102(BNSearchResultView.this, paramAnonymousInt);
      BNSearchResultView.this.mResultAdapter.setFocusIndex(paramAnonymousInt);
      Object localObject = BNSearchResultView.this.mSearchPoiPager.getPoiList();
      if ((localObject != null) && (((ArrayList)localObject).size() > BNSearchResultView.this.mCurrentIndex))
      {
        localObject = (SearchPoi)((ArrayList)localObject).get(BNSearchResultView.this.mCurrentIndex);
        BNSearchResultView.this.mBNSearchResutlListerner.setFocusMadianIndex((SearchPoi)localObject, true, BNSearchResultView.this.mCurrentIndex);
      }
    }
  };
  private List<SearchPoi> mPreSearchCityList;
  public SearchResultAdapter mResultAdapter;
  private XListView mResultListView;
  private DialogInterface.OnCancelListener mSearchDialogCancelListener = new DialogInterface.OnCancelListener()
  {
    public void onCancel(DialogInterface paramAnonymousDialogInterface)
    {
      if (BNSearchResultView.this.mResultAdapter == null) {
        BNSearchResultView.this.mBNSearchResutlListerner.pressleftTitleBack();
      }
      BNSearchResultView.access$1002(BNSearchResultView.this, null);
      BNPoiSearcher.getInstance().cancelQuery();
    }
  };
  private SearchPoiPager mSearchPoiPager;
  public SearchResultViewPagerAdapter mSearchResultViewPagerAdapter;
  private boolean mShowTwoBtn = true;
  private RelativeLayout mSortByDistance;
  private ImageView mSortByDistanceIv;
  private TextView mSortByDistanceTv;
  private RelativeLayout mSortByKey;
  private ImageView mSortByKeyIv;
  private TextView mSortByKeyTv;
  private RelativeLayout mSortingRl;
  private BNMapTitleBar mTitleBar;
  public View.OnTouchListener mTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (BNSearchResultView.this.mLastY == -1.0F) {
        BNSearchResultView.access$2302(BNSearchResultView.this, paramAnonymousMotionEvent.getRawY());
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
        f2 = BNSearchResultView.mStartY;
        i = BNSearchResultView.this.getTopMargin();
        if (Math.abs(f1 - f2) >= 50.0F) {
          break label258;
        }
        if (Math.abs(i - BNSearchResultView.Middle_TOP_NORMAL) < 3) {
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.Middle_TOP_NORMAL);
        }
        break;
      }
      for (;;)
      {
        BNSearchResultView.access$2302(BNSearchResultView.this, -1.0F);
        return true;
        BNSearchResultView.access$2302(BNSearchResultView.this, paramAnonymousMotionEvent.getRawY());
        BNSearchResultView.access$2402(paramAnonymousMotionEvent.getRawY());
        return true;
        f2 = paramAnonymousMotionEvent.getRawY() - BNSearchResultView.this.mLastY;
        BNSearchResultView.access$2302(BNSearchResultView.this, paramAnonymousMotionEvent.getRawY());
        f1 = f2;
        if (BNSearchResultView.this.getTopMargin() <= BNSearchResultView.this.mTitleBar.getHeight()) {
          f1 = f2 / 1.8F;
        }
        BNSearchResultView.this.updateTopMargin(f1);
        return true;
        if (Math.abs(i - BNSearchResultView.this.mTitleBar.getHeight()) < 3) {
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.this.mTitleBar.getHeight());
        }
      }
      label258:
      if ((i < BNSearchResultView.Middle_TOP_NORMAL) && (BNSearchResultView.this.mLastTopMargin == BNSearchResultView.Middle_TOP_NORMAL))
      {
        if (BNSearchResultView.this.mViewPager.getVisibility() == 0)
        {
          BNSearchResultView.this.mViewPager.setVisibility(8);
          BNSearchResultView.this.mResultListView.setVisibility(0);
          BNSearchResultView.this.mViewMapLayput.setVisibility(8);
          BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
          BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.FOCUS_HEIGHT_MIDDLE);
        }
        BNSearchResultView.this.setListViewMargin(BNSearchResultView.this.mTitleBar.getHeight());
      }
      for (;;)
      {
        BNSearchResultView.access$2302(BNSearchResultView.this, -1.0F);
        BNSearchResultView.access$1402(BNSearchResultView.this, BNSearchResultView.this.getTopMargin());
        return true;
        if ((i < BNSearchResultView.Middle_TOP_NORMAL) && (BNSearchResultView.this.mLastTopMargin < BNSearchResultView.Middle_TOP_NORMAL))
        {
          if (BNSearchResultView.this.mViewPager.getVisibility() == 0)
          {
            BNSearchResultView.this.mViewPager.setVisibility(8);
            BNSearchResultView.this.mResultListView.setVisibility(0);
            BNSearchResultView.this.mViewMapLayput.setVisibility(8);
            BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
            BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.FOCUS_HEIGHT_MIDDLE);
            BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
            if (BNSearchResultView.this.mMapControlPanel != null) {
              BNSearchResultView.this.mMapControlPanel.setVisible(false);
            }
          }
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.Middle_TOP_NORMAL);
        }
        else if (((i > BNSearchResultView.MARGINTOP_NORMAL) && (BNSearchResultView.this.mLastTopMargin > BNSearchResultView.Middle_TOP_NORMAL)) || (BNSearchResultView.this.mLastTopMargin < BNSearchResultView.Middle_TOP_NORMAL))
        {
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.MARGINTOP_NORMAL);
          BNSearchResultView.this.mViewPager.setVisibility(0);
          BNSearchResultView.this.mResultListView.setVisibility(8);
          BNSearchResultView.this.mViewMapLayput.setVisibility(0);
          BNSearchResultView.this.loadMapCtrlPanel(BNSearchResultView.this.view, true, true);
          BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.VIEW_PAGE_FOCUS_HEIGHT);
          BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.MARGINTOP_NORMAL, BNSearchResultView.this.focusHeight);
        }
        else if ((i > BNSearchResultView.Middle_TOP_NORMAL) && (BNSearchResultView.this.mLastTopMargin == BNSearchResultView.Middle_TOP_NORMAL))
        {
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.MARGINTOP_NORMAL);
          BNSearchResultView.this.mViewPager.setVisibility(0);
          BNSearchResultView.this.mResultListView.setVisibility(8);
          BNSearchResultView.this.mViewMapLayput.setVisibility(0);
          BNSearchResultView.this.loadMapCtrlPanel(BNSearchResultView.this.view, true, true);
          BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.VIEW_PAGE_FOCUS_HEIGHT);
          BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.MARGINTOP_NORMAL, BNSearchResultView.this.focusHeight);
        }
        else if ((i < BNSearchResultView.Middle_TOP_NORMAL) && (BNSearchResultView.this.mLastTopMargin > BNSearchResultView.Middle_TOP_NORMAL))
        {
          if (BNSearchResultView.this.mViewPager.getVisibility() == 0)
          {
            BNSearchResultView.this.mViewPager.setVisibility(8);
            BNSearchResultView.this.mResultListView.setVisibility(0);
            BNSearchResultView.this.mViewMapLayput.setVisibility(8);
            BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
            BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.FOCUS_HEIGHT_MIDDLE);
          }
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.this.mTitleBar.getHeight());
        }
        else
        {
          if (BNSearchResultView.this.mViewPager.getVisibility() == 0)
          {
            BNSearchResultView.this.mViewPager.setVisibility(8);
            BNSearchResultView.this.mResultListView.setVisibility(0);
            BNSearchResultView.this.mViewMapLayput.setVisibility(8);
            BNSearchResultView.this.scrollResultListView(BNSearchResultView.this.mCurrentIndex);
            BNSearchResultView.access$2002(BNSearchResultView.this, BNSearchResultView.FOCUS_HEIGHT_MIDDLE);
            BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
            if (BNSearchResultView.this.mMapControlPanel != null) {
              BNSearchResultView.this.mMapControlPanel.setVisible(false);
            }
          }
          BNSearchResultView.this.setListViewMargin(BNSearchResultView.Middle_TOP_NORMAL);
        }
      }
    }
  };
  private TextView mTvAddr;
  private TextView mTvDistance;
  private TextView mTvName;
  private TextView mTvStartNavi;
  private View mViewMapLayput;
  private ViewPager mViewPager;
  private SearchPoi searchGeoPoi;
  private View view = null;
  
  public BNSearchResultView(Context paramContext, MapGLSurfaceView paramMapGLSurfaceView)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mNMapView = paramMapGLSurfaceView;
    setupView((Activity)paramContext);
  }
  
  public static boolean dismissSearchNetworkingDialog()
  {
    if ((mNetworkingDialog != null) && (mNetworkingDialog.isShowing())) {
      mNetworkingDialog.dismiss();
    }
    mNetworkingDialog = null;
    return true;
  }
  
  private View.OnClickListener getOnClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("2.8");
        int i = paramAnonymousView.getId();
        if (i == 1711865878)
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410132", "410132");
          BNSearchResultView.this.mBNSearchResutlListerner.pressleftTitleBack();
        }
        do
        {
          return;
          if (i == 1711865879)
          {
            BNSearchResultView.this.mSortingRl.setVisibility(0);
            return;
          }
          if (i == 1711867040)
          {
            BNSearchResultView.this.mSortingRl.setVisibility(8);
            return;
          }
          if (i == 1711867042)
          {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410133", "410133");
            BNSearchResultView.this.mSearchPoiPager.setSortType(1);
            BNSearchResultView.this.mSortingRl.setVisibility(8);
            BNSearchResultView.this.sortListByRule();
            BNSearchResultView.this.mSortByKeyIv.setVisibility(0);
            BNSearchResultView.this.mSortByDistanceIv.setVisibility(8);
            BNSearchResultView.this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(1711800373));
            BNSearchResultView.this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(1711800374));
            paramAnonymousView = BNSearchResultView.this.mSearchPoiPager.getPoiList();
            BNSearchResultView.this.mBNSearchResutlListerner.updateResultPoiBkgLayer(paramAnonymousView);
            BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
            return;
          }
        } while (i != 1711867046);
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410134", "410134");
        paramAnonymousView = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getMyPositionGeo();
        if ((paramAnonymousView != null) && (paramAnonymousView.isValid()))
        {
          BNSearchResultView.this.mSearchPoiPager.setSortType(2);
          BNSearchResultView.this.mSortingRl.setVisibility(8);
          BNSearchResultView.this.sortListByRule();
          BNSearchResultView.this.mSortByKeyIv.setVisibility(8);
          BNSearchResultView.this.mSortByDistanceIv.setVisibility(0);
          BNSearchResultView.this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(1711800374));
          BNSearchResultView.this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(1711800373));
          paramAnonymousView = BNSearchResultView.this.mSearchPoiPager.getPoiList();
          BNSearchResultView.this.mBNSearchResutlListerner.updateResultPoiBkgLayer(paramAnonymousView);
          BNSearchResultView.this.mBNSearchResutlListerner.updateAppMapView(BNSearchResultView.Middle_TOP_NORMAL, BNSearchResultView.this.focusHeight);
          return;
        }
        TipTool.onCreateToastDialog(BNSearchResultView.this.mActivity, 1711669479);
      }
    };
  }
  
  private void setupView(Activity paramActivity)
  {
    try
    {
      this.mActivity = paramActivity;
      this.view = JarUtils.inflate(this.mActivity, 1711472749, this);
      if (this.view == null) {
        return;
      }
      this.mResultListView = ((XListView)this.view.findViewById(1711867025));
      this.mTitleBar = ((BNMapTitleBar)this.view.findViewById(1711865893));
      this.mDrawingLayout = ((LinearLayout)this.view.findViewById(1711867023));
      this.mHandleView = ((ImageView)this.view.findViewById(1711867024));
      this.mViewPager = ((ViewPager)this.view.findViewById(1711867026));
      this.mHandleView.setOnTouchListener(this.mTouchListener);
      this.mTitleBar.setRightButtonBackground(BNStyleManager.getDrawable(1711408095));
      this.mTitleBar.setRightButtonVisible(true);
      this.mTitleBar.setLeftOnClickedListener(getOnClickListener());
      this.mTitleBar.setRightOnClickedListener(getOnClickListener());
      this.mResultListView.setAutoLoadEnable(false);
      this.mResultListView.setDividerHeight(0);
      this.mResultListView.setPullRefreshEnable(false);
      this.mSortingRl = ((RelativeLayout)this.view.findViewById(1711867038));
      this.mSortingRl.setVisibility(8);
      this.mSortingRl.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.mCloseSortingIv = ((ImageView)this.view.findViewById(1711867040));
      this.mSortByKey = ((RelativeLayout)this.view.findViewById(1711867042));
      this.mSortByDistance = ((RelativeLayout)this.view.findViewById(1711867046));
      this.mSortByKeyTv = ((TextView)this.view.findViewById(1711867043));
      this.mSortByDistanceTv = ((TextView)this.view.findViewById(1711867047));
      this.mSortByKeyIv = ((ImageView)this.view.findViewById(1711867044));
      this.mSortByDistanceIv = ((ImageView)this.view.findViewById(1711867048));
      this.mCloseSortingIv.setOnClickListener(getOnClickListener());
      this.mSortByKey.setOnClickListener(getOnClickListener());
      this.mSortByDistance.setOnClickListener(getOnClickListener());
      this.mBgView = ((RelativeLayout)this.view.findViewById(1711866244));
      if (this.mBgView != null) {
        this.mBgView.removeAllViews();
      }
      if (BSearchConfig.pRGViewMode == 0)
      {
        paramActivity = this.mNMapView;
        if (paramActivity == null) {}
      }
      try
      {
        paramActivity = this.mNMapView.getParent();
        if ((paramActivity != null) && ((paramActivity instanceof ViewGroup))) {
          ((ViewGroup)paramActivity).removeView(this.mNMapView);
        }
      }
      catch (Exception paramActivity)
      {
        for (;;) {}
      }
      paramActivity = new RelativeLayout.LayoutParams(-1, -1);
      if (this.mBgView != null) {
        this.mBgView.addView(this.mNMapView, paramActivity);
      }
      this.view.requestLayout();
      for (;;)
      {
        this.mGeoLayout = ((FrameLayout)this.view.findViewById(1711867027));
        this.mBtnStartNavi = this.view.findViewById(1711867029);
        this.mBtnNameAddr = this.view.findViewById(1711867033);
        this.mTvName = ((TextView)this.view.findViewById(1711867034));
        this.mTvAddr = ((TextView)this.view.findViewById(1711867035));
        this.mTvStartNavi = ((TextView)this.view.findViewById(1711867030));
        this.mTvDistance = ((TextView)this.view.findViewById(1711867031));
        this.mGeoLayout.setVisibility(8);
        this.mBtnStartNavi.setOnClickListener(this.mClickListener);
        this.mBtnNameAddr.setOnClickListener(this.mClickListener);
        this.mViewMapLayput = this.view.findViewById(1711867036);
        loadMapCtrlPanel(this.view, true, true);
        return;
        BSearchConfig.pRGViewMode = 1;
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  private void showItsSettingDialog()
  {
    if (this.mItsSettingAlertDialog == null)
    {
      this.mItsSettingAlertDialog = new BNMessageDialog(this.mActivity);
      this.mItsSettingAlertDialog.setTitleText(BNStyleManager.getString(1711669681));
      this.mItsSettingAlertDialog.setMessage(BNStyleManager.getString(1711670189));
      this.mItsSettingAlertDialog.setFirstBtnText(BNStyleManager.getString(1711669686));
      this.mItsSettingAlertDialog.setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          if (BNSearchResultView.this.mActivity == null) {}
          while (BNSearchResultView.this.mItsSettingAlertDialog == null) {
            return;
          }
          BNSearchResultView.this.mItsSettingAlertDialog.dismiss();
          BNSearchResultView.access$502(BNSearchResultView.this, null);
        }
      });
    }
    this.mItsSettingAlertDialog.show();
  }
  
  public static void showSearchNetworkingDialog(Activity paramActivity, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    dismissSearchNetworkingDialog();
    if (mNetworkingDialog == null)
    {
      mNetworkingDialog = new BNNetworkingDialog(paramActivity).setTwoButtonMode(true);
      mNetworkingDialog.setNetworkingContentMessage(BNStyleManager.getString(1711669476));
      mNetworkingDialog.setConfirmNetworkingListener(paramOnClickListener1);
      mNetworkingDialog.setCancleListener(paramOnClickListener3);
    }
    mNetworkingDialog.show();
  }
  
  private void switchMapcontrolVisible()
  {
    if (this.mMapControlPanel != null)
    {
      if (this.mMapControlPanel.isVisible()) {
        this.mMapControlPanel.setVisible(false);
      }
    }
    else {
      return;
    }
    this.mMapControlPanel.setVisible(true);
  }
  
  public int getTopMargin()
  {
    return ((RelativeLayout.LayoutParams)this.mDrawingLayout.getLayoutParams()).topMargin;
  }
  
  public void handleCompassClicked()
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    localMapStatus._Rotation = 0;
    localMapStatus._Overlooking = 0;
    localMapStatus._Level = -1.0F;
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
  }
  
  public void initView()
  {
    if ((this.mBNSearchResutlListerner != null) && (this.mResultListView != null)) {
      this.mResultListView.setXListViewListener(this.mBNSearchResutlListerner);
    }
    if (this.mDrawingLayout != null) {
      this.mDrawingLayout.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
  }
  
  public boolean isGeoLayoutVisible()
  {
    return (this.mGeoLayout != null) && (this.mGeoLayout.isShown());
  }
  
  public void loadMapCtrlPanel(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mShowTwoBtn = paramBoolean1;
    this.mAddMapCtrlPanel = paramBoolean2;
    reloadMapControlPanel(paramView);
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setVisible(true);
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.mSortingRl != null) && (this.mSortingRl.getVisibility() == 0))
    {
      this.mSortingRl.setVisibility(8);
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    BNPoiSearcher.getInstance().clearBkgCache();
    BNMapController.getInstance().clearLayer(4);
    BNMapController.getInstance().onPause();
  }
  
  public void onResume()
  {
    BNMapController.getInstance().onResume();
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mTitleBar != null) {
      this.mTitleBar.onUpdateStyle(paramBoolean);
    }
    if (this.mHandleView != null)
    {
      this.mHandleView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407112));
      this.mHandleView.setImageDrawable(BNStyleManager.getDrawable(1711407164));
    }
    if (this.mResultAdapter != null) {
      this.mResultAdapter.notifyDataSetChanged();
    }
    if (this.mResultListView != null)
    {
      this.mResultListView.setBackgroundColor(BNStyleManager.getColor(1711800370));
      this.mResultListView.setTextColor(BNStyleManager.getColor(1711800391));
    }
  }
  
  public void reloadMapControlPanel(View paramView)
  {
    if ((paramView == null) || (this.mContext == null)) {}
    while (!this.mAddMapCtrlPanel) {
      return;
    }
    this.mMapControlPanel = new BNMapControlPanel(this.mContext, paramView, this.mShowTwoBtn);
    BNMapController.getInstance().setObserver(this.mBNMapObserver);
    this.mMapControlPanel.setNoNightStyle(true);
    this.mMapControlPanel.updateView();
    this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
    this.mMapControlPanel.setLocationBtnClickListener(this.mLocationBtnClickListener);
  }
  
  public void removeBNRouteDetailsListener()
  {
    this.mBNSearchResutlListerner = null;
  }
  
  public void scrollResultListView(int paramInt)
  {
    this.mCurrentIndex = paramInt;
    this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
    this.mResultListView.smoothScrollToPositionFromTop(paramInt, 0);
    this.mResultAdapter.setFocusIndex(paramInt);
  }
  
  public void setBNRouteDetailsListener(IBNSearchResultListener paramIBNSearchResultListener)
  {
    this.mBNSearchResutlListerner = paramIBNSearchResultListener;
  }
  
  public void setGeoLayoutGone()
  {
    this.mGeoLayout.setVisibility(8);
    this.mDrawingLayout.setVisibility(0);
    this.mTitleBar.setRightButtonVisible(true);
  }
  
  public void setGeoLayoutVisible(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.mDrawingLayout.setVisibility(4);
    this.mGeoLayout.setVisibility(0);
    this.mTitleBar.setRightButtonVisible(false);
    this.mTvName.setText(paramSearchPoi.mName);
    this.mTvAddr.setText(paramSearchPoi.mAddress);
    this.mTvDistance.setText(this.mBNSearchResutlListerner.getDistance(paramSearchPoi));
    this.searchGeoPoi = paramSearchPoi;
  }
  
  public void setListViewMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mDrawingLayout.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.mDrawingLayout.setLayoutParams(localLayoutParams);
  }
  
  public void setSearchResultViewPagerAdapter(SearchPoiPager paramSearchPoiPager)
  {
    if (this.mResultListView == null) {
      return;
    }
    this.mSearchPoiPager = paramSearchPoiPager;
    this.mResultAdapter = new SearchResultAdapter(this.mActivity, this.mSearchPoiPager, this.isSetPointMode);
    this.mResultAdapter.setOnlineSearchListener(this.mBNSearchResutlListerner);
    this.mResultListView.setAdapter(this.mResultAdapter);
    updateListView();
    int j = this.mSearchPoiPager.getCountPerPager();
    paramSearchPoiPager = new ArrayList(j);
    int i = 0;
    while ((i < j) && (i < this.mSearchPoiPager.getPoiList().size()))
    {
      paramSearchPoiPager.add(this.mSearchPoiPager.getPoiList().get(i));
      i += 1;
    }
    this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(paramSearchPoiPager);
    this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
    this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    this.mViewPager.setCurrentItem(0);
  }
  
  public void setViewPagerCurrentIndex(int paramInt)
  {
    this.mCurrentIndex = paramInt;
    if (this.mViewPager != null) {
      this.mViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void showCityDialog(final List<SearchPoi> paramList, boolean paramBoolean)
  {
    if ((this.mCityListDialog != null) && (this.mCityListDialog.isShowing())) {
      this.mCityListDialog.dismiss();
    }
    this.mCityListDialog = new BNListDialog(this.mActivity).setListTitleText(BNStyleManager.getString(1711669480)).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        BNSearchResultView.this.mCityListDialog.dismiss();
        paramAnonymousView = (SearchPoi)paramList.get(paramAnonymousInt);
        if (((paramAnonymousView.mDistrictId & 0xFFFF0000) > 0) && ((paramAnonymousView.mDistrictId & 0xFFFF) == 0)) {}
        for (paramAnonymousAdapterView = BNPoiSearcher.getInstance().getDistrictById(paramAnonymousView.mDistrictId >> 16);; paramAnonymousAdapterView = BNPoiSearcher.getInstance().getDistrictById(paramAnonymousView.mDistrictId))
        {
          paramAnonymousAdapterView = new SearchPoiPager(BNSearchResultView.this.mSearchPoiPager.getSearchKey(), paramAnonymousAdapterView, 10, BNSearchResultView.this.mSearchPoiPager.getNetMode());
          BNSearchResultView.this.mBNSearchResutlListerner.asynSearchCityList(paramAnonymousAdapterView, paramAnonymousView);
          BNSearchResultView.access$1002(BNSearchResultView.this, paramList);
          return;
        }
      }
    });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      SearchPoi localSearchPoi = (SearchPoi)paramList.get(i);
      int j;
      if (paramBoolean) {
        if (localSearchPoi.mWeight == 0)
        {
          j = 1;
          label108:
          localArrayList.add(localSearchPoi.mName + "(" + j + ")");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = localSearchPoi.mWeight;
        break label108;
        localArrayList.add(localSearchPoi.mName);
      }
    }
    this.mCityListDialog.setListAdapter(localArrayList);
    this.mCityListDialog.setCanceledOnTouchOutside(false);
    this.mCityListDialog.setOnCancelListener(this.mSearchDialogCancelListener);
    this.mCityListDialog.show();
  }
  
  protected void sortListByRule()
  {
    if (this.mResultAdapter == null) {
      return;
    }
    this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
    this.mResultListView.smoothScrollToPositionFromTop(this.mCurrentIndex, 0);
    this.mResultAdapter.setFocusIndex(this.mCurrentIndex);
    int j = this.mSearchPoiPager.getCountPerPager();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while ((i < j) && (i < this.mSearchPoiPager.getPoiList().size()))
    {
      localArrayList.add(this.mSearchPoiPager.getPoiList().get(i));
      i += 1;
    }
    this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(localArrayList);
    this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
    this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    this.mViewPager.setCurrentItem(0);
  }
  
  public void stopLoadMore()
  {
    this.mResultListView.stopLoadMore();
  }
  
  public void stopRefresh()
  {
    this.mResultListView.stopRefresh();
  }
  
  public void updateAdaperView(SearchPoiPager paramSearchPoiPager)
  {
    this.mSearchPoiPager = paramSearchPoiPager;
    if (this.mResultAdapter != null) {
      this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
    }
    for (;;)
    {
      updateListView();
      return;
      this.mResultAdapter = new SearchResultAdapter(this.mActivity, this.mSearchPoiPager, this.isSetPointMode);
      this.mResultAdapter.setOnlineSearchListener(this.mBNSearchResutlListerner);
      this.mResultListView.setAdapter(this.mResultAdapter);
      int j = this.mSearchPoiPager.getCountPerPager();
      paramSearchPoiPager = new ArrayList(j);
      int i = 0;
      while ((i < j) && (i < this.mSearchPoiPager.getPoiList().size()))
      {
        paramSearchPoiPager.add(this.mSearchPoiPager.getPoiList().get(i));
        i += 1;
      }
      this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(paramSearchPoiPager);
      this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
      this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
      this.mViewPager.setCurrentItem(0);
    }
  }
  
  public void updateAdapter(SearchPoiPager paramSearchPoiPager)
  {
    this.mSearchPoiPager = paramSearchPoiPager;
    this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
    updateListView();
    this.mSearchResultViewPagerAdapter.setPoiList(paramSearchPoiPager.getPoiList());
    this.mSearchResultViewPagerAdapter.notifyDataSetChanged();
  }
  
  public void updateListView()
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
  
  public void updateMapView(MapGLSurfaceView paramMapGLSurfaceView)
  {
    if (this.mBgView != null) {
      this.mBgView.removeAllViews();
    }
    if ((BSearchConfig.pRGViewMode == 0) && (paramMapGLSurfaceView != null)) {}
    try
    {
      localObject = paramMapGLSurfaceView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(paramMapGLSurfaceView);
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    if (this.mBgView != null) {
      this.mBgView.addView(paramMapGLSurfaceView, (ViewGroup.LayoutParams)localObject);
    }
    this.view.requestLayout();
    if (paramMapGLSurfaceView != null) {
      BNMapController.getInstance().setObserver(this.mBNMapObserver);
    }
  }
  
  public void updateSortView(SearchPoiPager paramSearchPoiPager)
  {
    if (paramSearchPoiPager == null) {
      return;
    }
    this.mSearchPoiPager = paramSearchPoiPager;
    switch (this.mSearchPoiPager.getSearchType())
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      if (this.mSortByKeyIv != null) {
        this.mSortByKeyIv.setVisibility(0);
      }
      if (this.mSortByDistanceIv != null) {
        this.mSortByDistanceIv.setVisibility(8);
      }
      if (this.mSortByKeyTv != null) {
        this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(1711800373));
      }
      if (this.mSortByDistanceTv != null) {
        this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(1711800374));
      }
      this.mSearchPoiPager.setSortType(1);
      return;
    }
    if (this.mSortByKeyIv != null) {
      this.mSortByKeyIv.setVisibility(8);
    }
    if (this.mSortByDistanceIv != null) {
      this.mSortByDistanceIv.setVisibility(0);
    }
    if (this.mSortByKeyTv != null) {
      this.mSortByKeyTv.setTextColor(BNStyleManager.getColor(1711800374));
    }
    if (this.mSortByDistanceTv != null) {
      this.mSortByDistanceTv.setTextColor(BNStyleManager.getColor(1711800373));
    }
    this.mSearchPoiPager.setSortType(2);
  }
  
  public int updateTopMargin(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mDrawingLayout.getLayoutParams();
    localLayoutParams.topMargin = ((int)(localLayoutParams.topMargin + paramFloat));
    this.mDrawingLayout.setLayoutParams(localLayoutParams);
    return localLayoutParams.topMargin;
  }
  
  public void updateViewWithOrientation(int paramInt, boolean paramBoolean) {}
  
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
      ViewGroup localViewGroup = (ViewGroup)JarUtils.inflate(BNSearchResultView.this.mActivity, 1711472790, null);
      BNSearchResultView.ViewHodler localViewHodler = new BNSearchResultView.ViewHodler();
      localViewHodler.mVerDiverderA = localViewGroup.findViewById(1711867032);
      localViewHodler.mBtnStartNavi = localViewGroup.findViewById(1711867029);
      localViewHodler.mBtnNameAddr = localViewGroup.findViewById(1711867033);
      localViewHodler.mTvName = ((TextView)localViewGroup.findViewById(1711867034));
      localViewHodler.mTvAddr = ((TextView)localViewGroup.findViewById(1711867035));
      localViewHodler.mTvStartNavi = ((TextView)localViewGroup.findViewById(1711867030));
      localViewHodler.mTvDistance = ((TextView)localViewGroup.findViewById(1711867031));
      localViewHodler.mTvNum = ((TextView)localViewGroup.findViewById(1711867337));
      localViewHodler.mDivider = localViewGroup.findViewById(1711867340);
      localViewHodler.mIcResult = ((ImageView)localViewGroup.findViewById(1711867335));
      localViewHodler.mLayoutChildBottom = ((LinearLayout)localViewGroup.findViewById(1711867338));
      localViewHodler.mPoiParent = ((RelativeLayout)localViewGroup.findViewById(1711867028));
      localViewHodler.mParInforLayout = localViewGroup.findViewById(1711867336);
      localViewGroup.setTag(localViewHodler);
      localViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
      localViewHodler.mVerDiverderA.setBackgroundColor(BNStyleManager.getColor(1711800390));
      localViewHodler.mBtnStartNavi.setBackgroundDrawable(BNStyleManager.getDrawable(1711407111));
      localViewHodler.mBtnNameAddr.setBackgroundDrawable(BNStyleManager.getDrawable(1711407111));
      localViewHodler.mTvName.setTextColor(BNStyleManager.getColor(1711800377));
      localViewHodler.mTvAddr.setTextColor(BNStyleManager.getColor(1711800377));
      localViewHodler.mTvNum.setTextColor(BNStyleManager.getColor(1711800377));
      localViewHodler.mTvStartNavi.setTextColor(BNStyleManager.getColor(1711800377));
      localViewHodler.mTvDistance.setTextColor(BNStyleManager.getColor(1711800377));
      localViewHodler.mLayoutChildBottom.setBackgroundColor(BNStyleManager.getColor(1711800370));
      localViewHodler.mTvNum.setText(paramInt + 1 + ".");
      SearchPoi localSearchPoi = (SearchPoi)this.mPoiList.get(paramInt);
      if (localSearchPoi != null)
      {
        localViewHodler.mTvName.setText(localSearchPoi.mName);
        localViewHodler.mTvAddr.setText(localSearchPoi.mAddress);
        localViewHodler.mTvDistance.setText(BNSearchResultView.this.mBNSearchResutlListerner.getDistance(localSearchPoi));
      }
      localViewHodler.mBtnStartNavi.setTag(localSearchPoi);
      localViewHodler.mParInforLayout.setTag(Integer.valueOf(paramInt));
      localViewHodler.mBtnStartNavi.setOnClickListener(BNSearchResultView.this.mResultAdapter.getNameSearchResultListener());
      localViewHodler.mParInforLayout.setOnClickListener(BNSearchResultView.this.mResultAdapter.getNameSearchResultListener());
      if (paramView != null) {
        ((ViewPager)paramView).addView(localViewGroup, 0);
      }
      return localViewGroup;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/search/BNSearchResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */