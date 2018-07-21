package com.baidu.navi.fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.MultiTouch;

public class BrowseMapFragment
  extends MapContentFragment
  implements View.OnClickListener
{
  private static final String TAG = "Map";
  private boolean isShowUgc = false;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      BrowseMapFragment.this.bnMapObserverUpdate(paramAnonymousBNSubject, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
      if (2 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      while (1 != paramAnonymousInt1)
      {
        return;
        paramAnonymousBNSubject = (MotionEvent)paramAnonymousObject;
        BrowseMapFragment.this.handleLongPress(paramAnonymousBNSubject);
        return;
        paramAnonymousBNSubject = (MotionEvent)paramAnonymousObject;
        BrowseMapFragment.this.handleSingleTap(paramAnonymousBNSubject);
        return;
      }
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      }
      for (;;)
      {
        PoiController.getInstance().focusItem(true);
        return;
        BrowseMapFragment.this.handleClickBasePoiLayer((MapItem)paramAnonymousObject);
        return;
        BrowseMapFragment.this.handleClickFavPoiLayer((MapItem)paramAnonymousObject);
      }
    }
  };
  private MapTitleBar mTitleBar;
  private ViewGroup mViewGroup;
  
  private boolean disableAnitiGeo()
  {
    return false;
  }
  
  private void handleClickBasePoiLayer(MapItem paramMapItem)
  {
    if (MapController.mMultiTouch.mTwoTouch) {
      return;
    }
    initFocusChain(this.mViewGroup);
    GeoPoint localGeoPoint = new GeoPoint(paramMapItem.mLongitude, paramMapItem.mLatitude);
    SearchPoi localSearchPoi = new SearchPoi();
    if (paramMapItem.mTitle != null) {
      localSearchPoi.mName = paramMapItem.mTitle.replace("\\", "");
    }
    localSearchPoi.mViewPoint = localGeoPoint;
    localSearchPoi.mGuidePoint = localGeoPoint;
    localSearchPoi.mOriginUID = paramMapItem.mUid;
    onShowMapPoi(localSearchPoi);
  }
  
  private void handleClickFavPoiLayer(MapItem paramMapItem)
  {
    if (MapController.mMultiTouch.mTwoTouch) {
      return;
    }
    initFocusChain(this.mViewGroup);
    paramMapItem = new GeoPoint(paramMapItem.mLongitude, paramMapItem.mLatitude);
    FavoritePoiInfo localFavoritePoiInfo = BNFavoriteManager.getInstance().getFavPoiInfoByGeoPoint(paramMapItem);
    SearchPoi localSearchPoi = new SearchPoi();
    if (localFavoritePoiInfo != null)
    {
      localSearchPoi.mName = localFavoritePoiInfo.mFavName;
      localSearchPoi.mAddress = localFavoritePoiInfo.mFavAddr;
    }
    localSearchPoi.mViewPoint = paramMapItem;
    localSearchPoi.mGuidePoint = paramMapItem;
    onShowFavPoi(localSearchPoi);
  }
  
  public void bnMapObserverUpdate(BNSubject paramBNSubject, int paramInt1, int paramInt2, Object paramObject) {}
  
  protected void handleLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = BNMapController.getInstance().getGeoPosByScreenPos((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    onShowMapGeoPoint(paramMotionEvent);
  }
  
  protected void handleSingleTap(MotionEvent paramMotionEvent) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131624137) {
      back(null);
    }
    while (i != 2131624188) {
      return;
    }
    showFragment(49, null);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)LayoutInflater.from(mActivity).inflate(2130968738, null));
    loadMapCtrlPanel(true);
    this.mbMoveToLocationPoint = true;
    this.mTitleBar = ((MapTitleBar)this.mViewGroup.findViewById(2131624146));
    if (this.mTitleBar != null)
    {
      this.mTitleBar.setRightButtonBackground(StyleManager.getDrawable(2130837804));
      this.mTitleBar.setMiddleTextVisible(false);
      this.mTitleBar.setLeftOnClickedListener(this);
      this.mTitleBar.setRightOnClickedListener(this);
    }
    return this.mViewGroup;
  }
  
  protected void onInitMap()
  {
    LogUtil.e("", "  onInitMap =======MAP_LAYER_MODE_BROWSE_MAP");
    if (BaseFragment.mResumeMapView) {
      setMapLayerMode(0);
    }
    NMapControlProxy.getInstance().updateLayer(14);
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    PoiController.getInstance().focusItem(false);
    super.onPause();
  }
  
  public void onResume()
  {
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    super.onResume();
  }
  
  protected void onShowFavPoi(SearchPoi paramSearchPoi) {}
  
  protected void onShowMapGeoPoint(GeoPoint paramGeoPoint) {}
  
  protected void onShowMapPoi(SearchPoi paramSearchPoi) {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    super.onUpdateStyle(paramBoolean);
    if (this.mTitleBar != null) {
      this.mTitleBar.onUpdateStyle(paramBoolean);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/BrowseMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */