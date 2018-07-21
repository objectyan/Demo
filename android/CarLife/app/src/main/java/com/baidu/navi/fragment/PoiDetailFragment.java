package com.baidu.navi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navi.view.PoiDetailView;
import com.baidu.navi.view.PoiListView;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.MultiTouch;
import java.util.ArrayList;

public class PoiDetailFragment
  extends MapContentFragment
{
  public static final int INCOMING_BROWSE_MAP_ANTIGEO = 81;
  public static final int INCOMING_BROWSE_MAP_POIPICK = 82;
  public static final int INCOMING_FAVORITE = 85;
  public static final int INCOMING_INTENT_API = 87;
  public static final int INCOMING_SEARCH_RESULT = 83;
  public static final int INCOMING_STREETSCAPE = 84;
  public static final String INCOMING_TYPE = "incoming_type";
  public static final String KEY_CHILD_COUNT_ARRAY = "child_count_array";
  public static final String KEY_CHILD_START_ARRAY = "child_start_array";
  public static final String KEY_CHILD_START_POI = "child_start_poi";
  public static final String KEY_CURRENT_CHILD_COUNT = "current_child_count";
  public static final String KEY_CURRENT_PARENT_POSITION = "current_parent_position";
  public static final String KEY_CURRENT_POI = "current_poi";
  public static final String KEY_FC_TYPE = "fc_type";
  public static final String KEY_LATITUDE_E6 = "lat";
  public static final String KEY_LONGITUDE_E6 = "lon";
  public static final String KEY_PARENT_POSITION_ARRAY = "parent_position_array";
  public static final String KEY_SHORT_URI = "short_uri";
  public static final String SEACHR_POI_DETAIL_NEWER_GUIDE_KEY = "search_poi_detail_newer_key";
  public static final String SEARCH_RESULT_MODE = "search_result_mode";
  private static final String TAG = "PoiSearch";
  private ArrayList<SearchPoi> ParChildPoi;
  private int id = 0;
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
        PoiDetailFragment.this.handleLongPress(paramAnonymousBNSubject);
        return;
      }
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      case 257: 
        LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_FINISHED");
        PoiController.getInstance().focusItem(true);
        return;
      case 264: 
        LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_BASE_POI_LAYER");
        PoiDetailFragment.this.handleClickBasePoiLayer((MapItem)paramAnonymousObject);
        return;
      case 265: 
        PoiDetailFragment.this.handleClickPoiBkgLayer((MapItem)paramAnonymousObject);
        return;
      case 276: 
        PoiDetailFragment.this.handleClickFavPoiLayer((MapItem)paramAnonymousObject);
        return;
      }
      LogUtil.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
      PoiDetailFragment.this.handleClickPoiLayer((MapItem)paramAnonymousObject);
    }
  };
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private int mFCType = -1;
  private ViewGroup mGroupView;
  private PoiDetailView mPoiDetailView;
  private ArrayList<SearchPoi> mPoiList;
  private PoiListView mPoiListView;
  private int mSearchRsultNetMode = 0;
  private MapTitleBar mTitleBar;
  
  private View.OnClickListener getBackBtnOnclickListner()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StatisticManager.onEvent("410138", "410138");
        PoiDetailFragment.this.onBackPressed();
      }
    };
  }
  
  private void getBundle()
  {
    switch (this.mShowBundle.getInt("incoming_type"))
    {
    case 86: 
    default: 
      onBackPressed();
      return;
    case 81: 
      handleComeFromSearchResult();
      return;
    case 82: 
      onBackPressed();
      return;
    case 84: 
      LogUtil.e("PoiSearch", "from streetscape");
      onBackPressed();
      return;
    case 83: 
      handleComeFromSearchResult();
      return;
    case 85: 
      LogUtil.e("PoiSearch", "from favorite");
      handleComeFromFavorite();
      return;
    }
    handleComeFromIntentApi();
  }
  
  private SearchPoi getCurrentPoi()
  {
    if (this.mPoiDetailView.getVisibility() == 0) {
      return this.mPoiDetailView.getSearchPoi();
    }
    return this.mPoiListView.getCurrentSearchPoi();
  }
  
  private int getViewHeight()
  {
    if (this.mPoiDetailView.getVisibility() == 0) {
      return this.mPoiDetailView.getViewHeight();
    }
    return this.mPoiListView.getViewHeight();
  }
  
  private void handleClickBasePoiLayer(MapItem paramMapItem)
  {
    if ((paramMapItem == null) || (MapController.mMultiTouch.mTwoTouch)) {
      return;
    }
    GeoPoint localGeoPoint = new GeoPoint(paramMapItem.mLongitude, paramMapItem.mLatitude);
    SearchPoi localSearchPoi = new SearchPoi();
    if (paramMapItem.mTitle != null) {
      localSearchPoi.mName = paramMapItem.mTitle.replace("\\", "");
    }
    this.mPoiDetailView.setMyPositionMode(false);
    localSearchPoi.mViewPoint = localGeoPoint;
    localSearchPoi.mGuidePoint = localGeoPoint;
    this.mPoiDetailView.pickPoi(localSearchPoi, 0, this.mPoiDetailView.getHeight() / 2);
    showPoidetailView();
  }
  
  private void handleClickFavPoiLayer(MapItem paramMapItem)
  {
    if (MapController.mMultiTouch.mTwoTouch) {}
    FavoritePoiInfo localFavoritePoiInfo;
    SearchPoi localSearchPoi;
    do
    {
      return;
      paramMapItem = new GeoPoint(paramMapItem.mLongitude, paramMapItem.mLatitude);
      localFavoritePoiInfo = BNFavoriteManager.getInstance().getFavPoiInfoByGeoPoint(paramMapItem);
      localSearchPoi = new SearchPoi();
    } while (localFavoritePoiInfo == null);
    localSearchPoi.mName = localFavoritePoiInfo.mFavName;
    localSearchPoi.mAddress = localFavoritePoiInfo.mFavAddr;
    localSearchPoi.mPhone = localFavoritePoiInfo.mPhone;
    localSearchPoi.mViewPoint = paramMapItem;
    localSearchPoi.mGuidePoint = paramMapItem;
    this.mPoiDetailView.setMyPositionMode(false);
    PoiController.getInstance().focusPoi(paramMapItem);
    PoiController.getInstance().animationTo(paramMapItem, 0L, this.mPoiDetailView.getHeight() / 2);
    this.mPoiDetailView.setFavSearchPoi(localSearchPoi);
    showPoidetailView();
  }
  
  private void handleClickPoiLayer(MapItem paramMapItem)
  {
    if ((paramMapItem == null) || (MapController.mMultiTouch.mTwoTouch)) {}
    int i;
    do
    {
      return;
      if (this.id != 0)
      {
        i = paramMapItem.mItemID;
        if (this.mPoiList.size() == 1)
        {
          this.mPoiDetailView.setSearchPoi((SearchPoi)this.mPoiList.get(0));
          PoiController.getInstance().animationByFrogleap((SearchPoi)this.mPoiList.get(0));
          PoiController.getInstance().focusPoi(this.ParChildPoi, paramMapItem.mItemID);
          this.mPoiDetailView.setVisibility(0);
          this.mPoiListView.setVisibility(8);
          return;
        }
        this.mPoiDetailView.setMyPositionMode(false);
        this.mPoiListView.setCurrentIndex(i - 1, this.ParChildPoi, paramMapItem.mItemID);
        this.mPoiDetailView.setVisibility(4);
        this.mPoiListView.setVisibility(0);
        return;
      }
      i = paramMapItem.mItemID;
      this.mPoiDetailView.setMyPositionMode(false);
      paramMapItem = this.mPoiListView.getCurrentPoiList();
    } while ((paramMapItem == null) || (i >= paramMapItem.size()));
    SearchPoi localSearchPoi = (SearchPoi)paramMapItem.get(i);
    PoiController.getInstance().focusPoi(paramMapItem, i);
    PoiController.getInstance().animationByFrogleap(localSearchPoi);
    this.mPoiDetailView.setFavSearchPoi(localSearchPoi);
    showPoidetailView();
  }
  
  private void handleComeFromFavorite()
  {
    SearchPoi localSearchPoi = FavoriteModel.getInstance().getFavoriteSearchPoi();
    if (localSearchPoi == null)
    {
      onBackPressed();
      return;
    }
    PoiController.getInstance().setSearchNetMode(0);
    this.mPoiDetailView.setSearchPoi(localSearchPoi);
    this.mPoiDetailView.checkStreetId();
    this.mPoiDetailView.setVisibility(0);
    this.mPoiListView.setVisibility(8);
    PoiController.getInstance().focusPoi(localSearchPoi);
  }
  
  private void handleComeFromIntentApi()
  {
    if ((this.mShowBundle.containsKey("lat")) && (this.mShowBundle.containsKey("lon")))
    {
      i = this.mShowBundle.getInt("lat");
      j = this.mShowBundle.getInt("lon");
      localObject = new GeoPoint();
      ((GeoPoint)localObject).setLatitudeE6(i);
      ((GeoPoint)localObject).setLongitudeE6(j);
      this.mPoiDetailView.setMyPositionMode(false);
      this.mPoiDetailView.antiPoi((GeoPoint)localObject, 0, this.mPoiDetailView.getHeight() / 2);
      this.mPoiDetailView.setVisibility(0);
      this.mPoiListView.setVisibility(8);
    }
    while (!this.mShowBundle.containsKey("short_uri"))
    {
      int i;
      int j;
      return;
    }
    Object localObject = this.mShowBundle.getString("short_uri");
    this.mPoiListView.setVisibility(8);
    this.mPoiDetailView.handleShortUri((String)localObject);
  }
  
  private void handleComeFromSearchResult()
  {
    LogUtil.e("PoiSearch", "from search  result");
    int k = this.mShowBundle.getInt("current_poi");
    Object localObject = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    int j = 0;
    this.mFCType = this.mShowBundle.getInt("fc_type", 0);
    int n = this.mShowBundle.getInt("current_child_count", 0);
    int m = this.mShowBundle.getInt("child_start_poi", 0);
    int i = this.mShowBundle.getInt("current_parent_position", 0);
    this.mChildCnt = this.mShowBundle.getIntArray("child_count_array");
    this.mChildIndex = this.mShowBundle.getIntArray("child_start_array");
    this.ParChildPoi = new ArrayList(n + 1);
    if (this.mFCType == 1)
    {
      this.id = (k - m + 1);
      if (i < ((ArrayList)localObject).size()) {
        this.ParChildPoi.add(((ArrayList)localObject).get(i));
      }
      this.mPoiList = new ArrayList(n);
      i = 0;
      while (i < n)
      {
        this.mPoiList.add(((ArrayList)localObject).get(i + m));
        this.ParChildPoi.add(((ArrayList)localObject).get(i + m));
        i += 1;
      }
      if ((k - m >= this.mPoiList.size()) || (k < 0)) {
        back(null);
      }
    }
    else
    {
      i = j;
      if (this.mChildIndex != null)
      {
        i = j;
        if (this.mChildIndex[0] > 0) {
          if (((ArrayList)localObject).size() <= this.mChildIndex[0]) {
            break label343;
          }
        }
      }
      label343:
      for (i = this.mChildIndex[0];; i = ((ArrayList)localObject).size())
      {
        this.mPoiList = new ArrayList(i);
        this.id = 0;
        j = 0;
        while (j < i)
        {
          this.mPoiList.add(((ArrayList)localObject).get(j));
          j += 1;
        }
      }
      this.ParChildPoi.add(((ArrayList)localObject).get(k));
      if ((this.mChildCnt != null) && (this.mChildIndex != null) && (this.mChildCnt[k] > 0))
      {
        i = 0;
        while (i < this.mChildCnt[k])
        {
          this.ParChildPoi.add(((ArrayList)localObject).get(this.mChildIndex[k] + i));
          i += 1;
        }
      }
      if ((k >= this.mPoiList.size()) || (k < 0))
      {
        back(null);
        return;
      }
    }
    i = this.mShowBundle.getInt("search_result_mode");
    PoiController.getInstance().setSearchNetMode(i);
    LogUtil.e("PoiSearch", "searchRsultNetMode = " + i);
    if (this.mShowBundle.containsKey("district_id"))
    {
      i = this.mShowBundle.getInt("district_id");
      PoiController.getInstance().setDistrictId(i);
    }
    if (this.mShowBundle.containsKey("search_key"))
    {
      localObject = this.mShowBundle.getString("search_key");
      PoiController.getInstance().setSearchKey((String)localObject);
    }
    if (this.mFCType == 0)
    {
      if (this.mPoiList.size() == 1)
      {
        this.mPoiDetailView.setSearchPoi((SearchPoi)this.mPoiList.get(0));
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setCurrentIndex(k, this.ParChildPoi, this.id);
        this.mPoiListView.setVisibility(8);
        this.mPoiDetailView.checkStreetId();
        PoiController.getInstance().focusPoi(this.ParChildPoi, 0);
        return;
      }
      this.mPoiListView.setSearchPoiList(this.mPoiList);
      this.mPoiListView.setChildIndex(this.mChildIndex);
      this.mPoiListView.setChildCnt(this.mChildCnt);
      this.mPoiListView.setCurrentIndex(k, this.ParChildPoi, this.id);
      this.mPoiDetailView.setVisibility(4);
      this.mPoiListView.setVisibility(0);
      return;
    }
    if (this.mPoiList.size() == 1)
    {
      this.mPoiDetailView.setSearchPoi((SearchPoi)this.mPoiList.get(0));
      this.mPoiDetailView.setVisibility(0);
      this.mPoiListView.setCurrentIndex(k - m, this.ParChildPoi, this.id);
      this.mPoiListView.setVisibility(8);
      this.mPoiDetailView.checkStreetId();
      PoiController.getInstance().focusPoi(this.ParChildPoi, this.id);
      return;
    }
    this.mPoiListView.setSearchPoiList(this.mPoiList);
    this.mPoiListView.setCurrentIndex(k - m, this.ParChildPoi, this.id);
    this.mPoiDetailView.setVisibility(4);
    this.mPoiListView.setVisibility(0);
  }
  
  private void handleLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = BNMapController.getInstance().getGeoPosByScreenPos((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setAntiGeoPoint(paramMotionEvent);
    showPoidetailView();
    this.mPoiDetailView.setMyPositionMode(false);
    this.mPoiDetailView.antiPoi(paramMotionEvent, 0, this.mPoiDetailView.getHeight() / 2);
  }
  
  private boolean isDragonOut()
  {
    if (this.mPoiDetailView.getVisibility() == 0) {
      return this.mPoiDetailView.isOut();
    }
    return this.mPoiListView.isOut();
  }
  
  private void showPoiListlView()
  {
    this.mPoiListView.setVisibility(0);
    this.mPoiDetailView.setVisibility(8);
  }
  
  private void showPoidetailView()
  {
    this.mPoiListView.setVisibility(8);
    this.mPoiDetailView.updateLayoutParams();
    this.mPoiDetailView.setVisibility(0);
  }
  
  protected void handleClickPoiBkgLayer(MapItem paramMapItem)
  {
    if (paramMapItem == null) {}
    int j;
    int i;
    do
    {
      return;
      this.mPoiDetailView.setMyPositionMode(false);
      j = BNPoiSearcher.getInstance().parseBkgLayerId(paramMapItem.mUid);
      i = this.mPoiListView.getCurretnId();
      paramMapItem = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    } while ((paramMapItem == null) || (paramMapItem.size() <= j));
    if (i == 0)
    {
      int k = this.mChildCnt[j];
      localArrayList = new ArrayList(k + 1);
      localArrayList.add(paramMapItem.get(j));
      if (paramMapItem.size() == 1)
      {
        showPoidetailView();
        PoiController.getInstance().focusPoi((SearchPoi)paramMapItem.get(0));
        PoiController.getInstance().animationByFrogleap((SearchPoi)paramMapItem.get(0));
        PoiController.getInstance().focusItem(true);
        return;
      }
      if ((k > 0) && (paramMapItem.size() >= this.mChildIndex[j] + k))
      {
        i = 0;
        while (i < k)
        {
          localArrayList.add(paramMapItem.get(this.mChildIndex[j] + i));
          i += 1;
        }
      }
      if (localArrayList.size() > 1) {
        this.mPoiListView.setCurrentIndex(j, localArrayList, 0);
      }
      for (;;)
      {
        PoiController.getInstance().focusItem(true);
        showPoiListlView();
        return;
        this.mPoiListView.setCurrentIndex(j);
      }
    }
    paramMapItem = (SearchPoi)paramMapItem.get(j);
    ArrayList localArrayList = this.mPoiListView.getCurrentPoiList();
    localArrayList.set(0, paramMapItem);
    PoiController.getInstance().focusPoi(localArrayList, 0);
    PoiController.getInstance().animationByFrogleap(paramMapItem);
    this.mPoiDetailView.setFavSearchPoi(paramMapItem);
    showPoidetailView();
  }
  
  public boolean onBackPressed()
  {
    if ((this.mPoiList != null) && (this.mPoiList.size() > 1) && (this.mPoiListView.getVisibility() != 0))
    {
      showPoiListlView();
      this.mPoiListView.setCurrentIndex(this.mPoiListView.getCurretnIndex(), this.mPoiListView.getCurrentPoiList(), this.mPoiListView.getCurretnId());
      return true;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mPoiDetailView != null)
    {
      localObject1 = localObject2;
      if (this.mPoiDetailView.checkIsReGetAllFavPois())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("from_Fragment", 33);
        ((Bundle)localObject1).putInt("fav_action_key", 2);
      }
    }
    back((Bundle)localObject1);
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    loadMapCtrlPanel(true);
    this.mGroupView = ((ViewGroup)paramLayoutInflater.inflate(2130968794, null));
    this.mTitleBar = ((MapTitleBar)this.mGroupView.findViewById(2131624146));
    this.mPoiListView = ((PoiListView)this.mGroupView.findViewById(2131624139));
    this.mGroupView.findViewById(2131624138).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mPoiDetailView = ((PoiDetailView)this.mGroupView.findViewById(2131624140));
    return this.mGroupView;
  }
  
  protected void onInitMap()
  {
    setMapLayerMode(1);
  }
  
  protected void onInitView()
  {
    LogUtil.e("PoiSearch", "@移动统计 @搜周边-POI详情页-进入次数");
    LogUtil.e("PoiSearch", "getBundle()");
    this.mPoiListView.setController(PoiController.getInstance());
    this.mPoiListView.setOnDialogListener(this);
    this.mPoiDetailView.setController(PoiController.getInstance());
    this.mPoiDetailView.setSupportDragon(true);
    getBundle();
    this.mTitleBar.setLeftOnClickedListener(getBackBtnOnclickListner());
  }
  
  protected void onLocationBtnClicked(MapViewConfig.PositionStatus paramPositionStatus)
  {
    super.onLocationBtnClicked(paramPositionStatus);
    if (paramPositionStatus == MapViewConfig.PositionStatus.NORMAL)
    {
      paramPositionStatus = BNGeoLocateManager.getInstance().getLastValidLocation();
      LogUtil.e("PoiSearch", "onLocationBtnClicked: " + paramPositionStatus);
      if ((paramPositionStatus != null) && (paramPositionStatus.isValid()))
      {
        this.mPoiDetailView.setMyPositionMode(true);
        this.mPoiDetailView.antiPoi(paramPositionStatus, 0, this.mPoiDetailView.getHeight() / 2);
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        this.mPoiDetailView.checkStreetId();
        PoiController.getInstance().clearPoiCache();
      }
    }
  }
  
  public void onPause()
  {
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    PoiController.getInstance().focusItem(false);
    BNPoiSearcher.getInstance().clearBkgCache();
    BNPoiSearcher.getInstance().clearPoiCache();
    BNMapController.getInstance().showLayer(4, false);
    BNMapController.getInstance().showLayer(3, false);
    BNMapController.getInstance().updateLayer(4);
    BNMapController.getInstance().updateLayer(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    ArrayList localArrayList3 = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (this.mChildIndex != null)
    {
      localArrayList1 = localArrayList2;
      if (this.mChildIndex[0] > 0)
      {
        localArrayList1 = localArrayList2;
        if (localArrayList3 != null)
        {
          localArrayList1 = localArrayList2;
          if (localArrayList3.size() > this.mChildIndex[0])
          {
            localArrayList2 = new ArrayList(this.mChildIndex[0]);
            i = 0;
            for (;;)
            {
              localArrayList1 = localArrayList2;
              if (i >= this.mChildIndex[0]) {
                break;
              }
              localArrayList2.add(localArrayList3.get(i));
              i += 1;
            }
          }
        }
      }
    }
    PoiController.getInstance().updatePoiBkgLayer(localArrayList1);
    if ((this.ParChildPoi != null) && (this.ParChildPoi.size() > 1) && (this.id > 0)) {
      PoiController.getInstance().focusPoi(this.ParChildPoi, this.mPoiListView.getCurretnIndex() + 1);
    }
    if ((this.mShowBundle == null) || (this.mShowBundle.getInt("incoming_type") != 85))
    {
      BNMapController.getInstance().showLayer(4, true);
      BNMapController.getInstance().updateLayer(4);
    }
    BNMapController.getInstance().showLayer(6, true);
    BNMapController.getInstance().showLayer(7, true);
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().updateLayer(3);
    int i = (getViewHeight() - ScreenUtil.getInstance().getStatusBarHeight()) / 2;
    PoiController.getInstance().animationTo(getCurrentPoi(), 0L, i, 15);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    super.onUpdateStyle(paramBoolean);
    this.mTitleBar.onUpdateStyle(paramBoolean);
    if (this.mPoiDetailView != null) {
      this.mPoiDetailView.updateStyle();
    }
    if (this.mPoiListView != null) {
      this.mPoiListView.updateStyle();
    }
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if ((3 == paramInt1) && (4 == paramInt2))
    {
      PoiController.getInstance().startCalcRoute(getCurrentPoi(), this);
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 1);
    }
    return super.onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/PoiDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */