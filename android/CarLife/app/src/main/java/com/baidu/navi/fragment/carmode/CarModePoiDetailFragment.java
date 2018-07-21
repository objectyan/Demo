package com.baidu.navi.fragment.carmode;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.MapContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.CarmodePoiDetailView;
import com.baidu.navi.view.CarmodePoiListView;
import com.baidu.navi.view.MapControlPanel;
import com.baidu.navisdk.comapi.base.BNSubject;
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
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.MultiTouch;
import java.util.ArrayList;
import java.util.List;

public class CarModePoiDetailFragment
  extends MapContentFragment
{
  public static final int INCOMING_BROWSE_FAVORITE = 86;
  public static final int INCOMING_BROWSE_MAP_ANTIGEO = 81;
  public static final int INCOMING_BROWSE_MAP_POIPICK = 82;
  public static final int INCOMING_FAVORITE = 85;
  public static final int INCOMING_INTENT_API = 87;
  public static final int INCOMING_SEARCH_RESULT = 83;
  public static final int INCOMING_STREETSCAPE = 84;
  public static final String INCOMING_TYPE = "incoming_type";
  public static final String ISFAVPOI = "ISFAVPOI";
  public static final String ISMYPOSITION = "ISMYPOSITION";
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
        i.e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
        paramAnonymousBNSubject = (MotionEvent)paramAnonymousObject;
        CarModePoiDetailFragment.this.handleLongPress(paramAnonymousBNSubject);
        return;
      }
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      case 257: 
        i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_FINISHED");
        PoiController.getInstance().focusItem(true);
        return;
      case 264: 
        i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_BASE_POI_LAYER");
        CarModePoiDetailFragment.this.handleClickBasePoiLayer((MapItem)paramAnonymousObject);
        return;
      case 265: 
        CarModePoiDetailFragment.this.handleClickPoiBkgLayer((MapItem)paramAnonymousObject);
        return;
      case 276: 
        CarModePoiDetailFragment.this.handleClickFavPoiLayer((MapItem)paramAnonymousObject);
        return;
      }
      i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
      CarModePoiDetailFragment.this.handleClickPoiLayer((MapItem)paramAnonymousObject);
    }
  };
  private View mBack;
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private int mFCType = -1;
  private ImageView mIvBack;
  private View mLocation;
  private g mMiddleFocusArea;
  private CarmodePoiDetailView mPoiDetailView;
  private ArrayList<SearchPoi> mPoiList;
  private CarmodePoiListView mPoiListView;
  private g mRightFocusArea;
  private int mSearchRsultNetMode = 0;
  private ViewGroup mViewGroup;
  private ImageView mZoomInBtnView;
  private ImageView mZoomOutBtnView;
  private long xOffset = ScreenUtil.getInstance().dip2px(65286) / 2;
  private long yOffset = ScreenUtil.getInstance().dip2px(0) / 2;
  
  private View.OnClickListener getBackBtnOnclickListner()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModePoiDetailFragment.this.onBackPressed();
      }
    };
  }
  
  private void getBundle()
  {
    switch (this.mShowBundle.getInt("incoming_type"))
    {
    default: 
      onBackPressed();
      return;
    case 81: 
      handleComeFromBrowsermapAntigeo();
      return;
    case 82: 
      handleComeFromBrowsermapPickpoint();
      return;
    case 84: 
      i.e("PoiSearch", "from streetscape");
      onBackPressed();
      return;
    case 83: 
      handleComeFromSearchResult();
      return;
    case 85: 
      i.e("PoiSearch", "from favorite");
      handleComeFromFavorite();
      return;
    case 86: 
      handleBrowseFavPoi();
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
  
  private void handleBrowseFavPoi()
  {
    List localList = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    if ((localList != null) && (localList.size() == 1) && (localList.get(0) != null))
    {
      this.mPoiDetailView.setMyPositionMode(false);
      PoiController.getInstance().focusPoi((SearchPoi)localList.get(0));
      PoiController.getInstance().animationTo((SearchPoi)localList.get(0), this.xOffset, this.yOffset);
      this.mPoiDetailView.setFavSearchPoi((SearchPoi)localList.get(0));
      this.mPoiDetailView.setVisibility(0);
      this.mPoiListView.setVisibility(8);
      this.mPoiDetailView.setFromBrowseMapFragment(true, getNaviFragmentManager());
      return;
    }
    back(null);
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
    localSearchPoi.mViewPoint = localGeoPoint;
    localSearchPoi.mGuidePoint = localGeoPoint;
    localSearchPoi.mOriginUID = paramMapItem.mUid;
    this.mPoiDetailView.pickPoi(localSearchPoi, this.xOffset, this.yOffset);
    this.mPoiDetailView.setMyPositionMode(false);
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
    PoiController.getInstance().animationTo(paramMapItem, this.xOffset, this.yOffset);
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
  
  private void handleComeFromBrowsermapAntigeo()
  {
    boolean bool = this.mShowBundle.getBoolean("ISMYPOSITION");
    i.e("PoiSearch", "from handleComeFromBrowsermap");
    List localList = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    if ((localList != null) && (localList.size() == 1) && (localList.get(0) != null))
    {
      this.mPoiDetailView.setMyPositionMode(bool);
      this.mPoiDetailView.antiPoi(((SearchPoi)localList.get(0)).mViewPoint, this.xOffset, this.yOffset);
      this.mPoiDetailView.setVisibility(0);
      this.mPoiListView.setVisibility(8);
      PoiController.getInstance().focusPoi((SearchPoi)localList.get(0));
      this.mPoiDetailView.setFromBrowseMapFragment(true, getNaviFragmentManager());
      return;
    }
    back(null);
  }
  
  private void handleComeFromBrowsermapPickpoint()
  {
    boolean bool = this.mShowBundle.getBoolean("ISMYPOSITION");
    i.e("PoiSearch", "from handleComeFromBrowsermap");
    List localList = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    if ((localList != null) && (localList.size() == 1) && (localList.get(0) != null))
    {
      this.mPoiDetailView.setMyPositionMode(bool);
      this.mPoiDetailView.pickPoi((SearchPoi)localList.get(0), this.xOffset, this.yOffset);
      this.mPoiDetailView.setVisibility(0);
      this.mPoiListView.setVisibility(8);
      PoiController.getInstance().focusPoi((SearchPoi)localList.get(0));
      this.mPoiDetailView.setFromBrowseMapFragment(true, getNaviFragmentManager());
      return;
    }
    back(null);
  }
  
  private void handleComeFromFavorite()
  {
    boolean bool = this.mShowBundle.getBoolean("ISMYPOSITION");
    SearchPoi localSearchPoi = FavoriteModel.getInstance().getFavoriteSearchPoi();
    if (localSearchPoi == null)
    {
      onBackPressed();
      return;
    }
    PoiController.getInstance().setSearchNetMode(0);
    this.mPoiDetailView.setSearchPoi(localSearchPoi);
    this.mPoiDetailView.setMyPositionMode(bool);
    this.mPoiDetailView.setVisibility(0);
    this.mPoiListView.setVisibility(8);
    this.mBack.setVisibility(0);
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
      this.mPoiDetailView.antiPoi((GeoPoint)localObject, 0L, this.mPoiDetailView.getHeight() / 2);
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
    i.e("PoiSearch", "from search  result");
    int k = this.mShowBundle.getInt("current_poi");
    Object localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    int j = 0;
    this.mPoiListView.setComeFrom(this.mShowBundle.getInt("come_from", 0));
    this.mPoiDetailView.setComeFrom(this.mShowBundle.getInt("come_from", 0));
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
      this.ParChildPoi.add(((List)localObject).get(i));
      this.mPoiList = new ArrayList(n);
      i = 0;
      while (i < n)
      {
        this.mPoiList.add(((List)localObject).get(i + m));
        this.ParChildPoi.add(((List)localObject).get(i + m));
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
          if (((List)localObject).size() <= this.mChildIndex[0]) {
            break label376;
          }
        }
      }
      label376:
      for (i = this.mChildIndex[0];; i = ((List)localObject).size())
      {
        this.mPoiList = new ArrayList(i);
        this.id = 0;
        j = 0;
        while (j < i)
        {
          this.mPoiList.add(((List)localObject).get(j));
          j += 1;
        }
      }
      this.ParChildPoi.add(((List)localObject).get(k));
      if ((this.mChildCnt != null) && (this.mChildIndex != null) && (this.mChildCnt[k] > 0))
      {
        i = 0;
        while (i < this.mChildCnt[k])
        {
          this.ParChildPoi.add(((List)localObject).get(this.mChildIndex[k] + i));
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
    i.e("PoiSearch", "searchRsultNetMode = " + i);
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
    if (this.mFCType == 0) {
      if (this.mPoiList.size() == 1)
      {
        this.mPoiDetailView.setSearchPoi((SearchPoi)this.mPoiList.get(0));
        this.mPoiListView.setCurrentIndex(k, this.ParChildPoi, this.id);
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        PoiController.getInstance().focusPoi(this.ParChildPoi, 0);
      }
    }
    for (;;)
    {
      this.mBack.setVisibility(0);
      return;
      this.mPoiListView.setSearchPoiList(this.mPoiList);
      this.mPoiListView.setChildIndex(this.mChildIndex);
      this.mPoiListView.setChildCnt(this.mChildCnt);
      this.mPoiListView.setCurrentIndex(k, this.ParChildPoi, this.id);
      this.mPoiDetailView.setVisibility(4);
      this.mPoiListView.setVisibility(0);
      continue;
      if (this.mPoiList.size() == 1)
      {
        this.mPoiDetailView.setSearchPoi((SearchPoi)this.mPoiList.get(0));
        this.mPoiListView.setCurrentIndex(k - m, this.ParChildPoi, this.id);
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        PoiController.getInstance().focusPoi(this.ParChildPoi, this.id);
      }
      else
      {
        this.mPoiListView.setSearchPoiList(this.mPoiList);
        this.mPoiListView.setCurrentIndex(k - m, this.ParChildPoi, this.id);
        this.mPoiDetailView.setVisibility(4);
        this.mPoiListView.setVisibility(0);
      }
    }
  }
  
  private void handleLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = BNMapController.getInstance().getGeoPosByScreenPos((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setAntiGeoPoint(paramMotionEvent);
    showPoidetailView();
    this.mPoiDetailView.setMyPositionMode(false);
    this.mPoiDetailView.antiPoi(paramMotionEvent, this.xOffset, this.yOffset);
  }
  
  private void initMapLayer()
  {
    Rect localRect = new Rect(0, ScreenUtil.getInstance().getStatusBarHeight(), ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels());
    BNMapController.getInstance().setMapDrawScreenRect(localRect);
    NavMapManager.getInstance().showCarResultLayer(false);
  }
  
  private void showPoiListlView()
  {
    this.mPoiListView.setVisibility(0);
    this.mPoiDetailView.setVisibility(8);
  }
  
  private void showPoidetailView()
  {
    this.mPoiListView.setVisibility(8);
    this.mPoiDetailView.setVisibility(0);
  }
  
  public void driving()
  {
    backTo(17, null);
    com.baidu.carlife.custom.a.a().d();
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
    } while ((paramMapItem == null) || (this.mChildIndex == null) || (this.mChildCnt == null) || (paramMapItem.size() <= j));
    if (i == 0)
    {
      int k = this.mChildCnt[j];
      localArrayList = new ArrayList(k + 1);
      localArrayList.add(paramMapItem.get(j));
      if (paramMapItem.size() == 1)
      {
        this.mPoiDetailView.setSearchPoi((SearchPoi)paramMapItem.get(0));
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
  
  public void initFocusChain(View paramView)
  {
    if ((this.mMiddleFocusArea == null) && (this.mMapControlPanel != null))
    {
      this.mZoomInBtnView = this.mMapControlPanel.getZoomInBtnView();
      this.mZoomOutBtnView = this.mMapControlPanel.getZoomOutBtnView();
      this.mLocation = this.mMapControlPanel.getLocationView();
      this.mMiddleFocusArea = new g(this.mViewGroup.findViewById(2131624141), 4, true);
      this.mMiddleFocusArea.d(this.mBack).d(this.mZoomInBtnView);
      this.mMiddleFocusArea.d(this.mZoomOutBtnView).d(this.mLocation);
    }
    if ((this.mPoiList != null) && (this.mPoiList.size() > 0))
    {
      if (this.mPoiList.size() != 1) {
        break label269;
      }
      this.mRightFocusArea = new g(this.mPoiDetailView, 5);
      this.mRightFocusArea.d(this.mPoiDetailView.findViewById(2131624537));
      this.mRightFocusArea.d(this.mPoiDetailView.findViewById(2131624541));
      this.mRightFocusArea.d(this.mPoiDetailView.findViewById(2131624543));
      this.mRightFocusArea.c(null);
      this.mRightFocusArea.b(this.mPoiDetailView.findViewById(2131624543));
    }
    for (;;)
    {
      d.a().b(new com.baidu.carlife.f.a[] { this.mMiddleFocusArea, this.mRightFocusArea });
      d.a().h(this.mMiddleFocusArea);
      return;
      label269:
      this.mRightFocusArea = new g(this.mPoiListView, 5);
      this.mRightFocusArea.d(this.mPoiListView.findViewById(2131624537));
      this.mRightFocusArea.d(this.mPoiListView.findViewById(2131624541));
      this.mRightFocusArea.d(this.mPoiListView.findViewById(2131624543));
      this.mRightFocusArea.d(this.mPoiListView.findViewById(2131624546));
      this.mRightFocusArea.d(this.mPoiListView.findViewById(2131624547));
      this.mRightFocusArea.c(null);
      this.mRightFocusArea.b(this.mPoiListView.findViewById(2131624543));
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.mPoiList != null) && (this.mPoiList.size() > 1) && (this.mPoiListView.getVisibility() != 0))
    {
      showPoiListlView();
      this.mPoiListView.setCurrentIndex(this.mPoiListView.getCurretnIndex(), this.mPoiListView.getCurrentPoiList(), this.mPoiListView.getCurretnId());
      return true;
    }
    Bundle localBundle = null;
    if (this.mPoiDetailView != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("from_Fragment", 33);
      localBundle.putInt("fav_action_key", 2);
    }
    back(localBundle);
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    boolean bool = false;
    if (NavMapManager.getInstance().getNaviMapMode() != 5)
    {
      com.baidu.baidumaps.f.a.a.a.a().d();
      com.baidu.baidumaps.f.a.a.a.a().a(false, null);
      NavMapManager.getInstance().set3DGestureEnable(false);
      BNMapController localBNMapController = BNMapController.getInstance();
      if (!BNStyleManager.getRealDayStyle()) {
        bool = true;
      }
      localBNMapController.setNightMode(bool);
    }
    loadMapCtrlPanel(true);
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968614, null));
    this.mViewGroup.findViewById(2131624138).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mBack = this.mViewGroup.findViewById(2131624136);
    this.mIvBack = ((ImageView)this.mViewGroup.findViewById(2131624137));
    this.mPoiListView = ((CarmodePoiListView)this.mViewGroup.findViewById(2131624139));
    this.mPoiDetailView = ((CarmodePoiDetailView)this.mViewGroup.findViewById(2131624140));
    this.mPoiDetailView.setOnDialogListener(this);
    this.mPoiListView.setOnDialogListener(this);
    return this.mViewGroup;
  }
  
  public void onDestroy()
  {
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList().clear();
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      initFocusChain(null);
    }
  }
  
  protected void onInitMap()
  {
    setMapLayerMode(1);
  }
  
  protected void onInitView()
  {
    i.e("PoiSearch", "@移动统计 @搜周边-POI详情页-进入次数");
    i.e("PoiSearch", "getBundle()");
    this.mPoiListView.setController(PoiController.getInstance());
    this.mPoiDetailView.setController(PoiController.getInstance());
    getBundle();
    this.mBack.setOnClickListener(getBackBtnOnclickListner());
  }
  
  protected void onLocationBtnClicked(MapViewConfig.PositionStatus paramPositionStatus)
  {
    super.onLocationBtnClicked(paramPositionStatus);
    if (paramPositionStatus == MapViewConfig.PositionStatus.NORMAL)
    {
      paramPositionStatus = BNLocationManagerProxy.getInstance().getLastValidLocation();
      i.e("PoiSearch", "onLocationBtnClicked: " + paramPositionStatus);
      if ((paramPositionStatus == null) || (!paramPositionStatus.isValid())) {}
    }
  }
  
  public void onPause()
  {
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    PoiController.getInstance().focusItem(false);
    BNPoiSearcher.getInstance().clearBkgCache();
    BNPoiSearcher.getInstance().clearPoiCache();
    BNMapController.getInstance().showLayer(4, false);
    BNMapController.getInstance().updateLayer(4);
    BNMapController.getInstance().updateLayer(3);
    PoiController.getInstance().clearPoiCache();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    initMapLayer();
    setMapFocusViewVisible(false);
    hideMapCtrlPanel();
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.hideLayerView();
    }
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    ArrayList localArrayList2 = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
    Object localObject = null;
    if (localArrayList2 != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      i = 0;
      for (;;)
      {
        localObject = localArrayList1;
        if (i >= localArrayList2.size()) {
          break;
        }
        localObject = localArrayList1;
        if (i >= 10) {
          break;
        }
        localArrayList1.add(localArrayList2.get(i));
        i += 1;
      }
    }
    PoiController.getInstance().updatePoiBkgLayer((ArrayList)localObject);
    PoiController.getInstance().focusPoi(getCurrentPoi());
    if (this.mShowBundle.getInt("incoming_type") != 85)
    {
      BNMapController.getInstance().showLayer(4, true);
      BNMapController.getInstance().updateLayer(4);
    }
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().showLayer(6, true);
    BNMapController.getInstance().showLayer(7, true);
    BNMapController.getInstance().updateLayer(3);
    int i = ScreenUtil.getInstance().dip2px(0) / 2;
    int j = ScreenUtil.getInstance().dip2px(65286) / 2;
    PoiController.getInstance().animationTo(getCurrentPoi(), j, i, 15);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    super.onUpdateStyle(paramBoolean);
    if (this.mIvBack == null) {
      return;
    }
    this.mIvBack.setBackground(StyleManager.getDrawable(2130838852));
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
  
  protected void showTrafficMap(boolean paramBoolean)
  {
    BNMapController.getInstance().switchITSMode(true);
    BNMapController.getInstance().showTrafficMap(true);
  }
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModePoiDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */