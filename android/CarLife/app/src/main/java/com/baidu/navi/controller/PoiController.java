package com.baidu.navi.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.logic.q;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.ShareTools;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import java.util.ArrayList;

public class PoiController
{
  private static final int K_TIMEOUT = 8000;
  private static final String TAG = "PoiController";
  private Context mContext = BaiduNaviApplication.getInstance();
  private int mDistrictId;
  private int mId;
  private int mModuleFrom;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4: 
        paramAnonymousMessage = new Bundle();
        paramAnonymousMessage.putInt("module_from", PoiController.this.mModuleFrom);
        h.a().showFragment(52, paramAnonymousMessage);
        BNRoutePlaner.getInstance().removeRouteResultHandler(PoiController.this.mRPHandler);
        return;
      case 7: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(PoiController.this.mRPHandler);
        return;
      case 32: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(PoiController.this.mRPHandler);
        return;
      }
      StatisticUtils.statSetDestFromPoi();
    }
  };
  private String mSearchKey;
  private int mSearchRsultNetMode = 1;
  private ShareTools mShareTool = null;
  private SearchPoi mStreetViewPoi;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private Handler mWorkHandler;
  
  private PoiController()
  {
    FavoriteDestinationController.getInstance().queryAllFavoriteDestFromDB(null);
  }
  
  private RoutePlanNode createRoutePlanNode(SearchPoi paramSearchPoi)
  {
    return new RoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
  }
  
  public static PoiController getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  private Bundle getOpenSharePoiBundle(SearchPoi paramSearchPoi, String paramString)
  {
    if (paramString != null)
    {
      StringBuffer localStringBuffer = new StringBuffer(128);
      Bundle localBundle = new Bundle();
      localStringBuffer.append("这里是：");
      if (paramSearchPoi != null)
      {
        localStringBuffer.append(paramSearchPoi.mName);
        int i = paramSearchPoi.mType;
        localBundle.putString("poi_name", paramSearchPoi.mName);
        localBundle.putString("uid", paramSearchPoi.mOriginUID);
      }
      String str = paramSearchPoi.mAddress;
      if (!TextUtils.isEmpty(str))
      {
        if (!localStringBuffer.toString().equals("这里是：")) {
          localStringBuffer.append("，");
        }
        localStringBuffer.append(str);
      }
      localStringBuffer.append("，详情：");
      localStringBuffer.append(paramString);
      localStringBuffer.append(" -[百度导航]");
      localBundle.putString("poi_addr", str);
      localBundle.putString("subject", "百度导航");
      localBundle.putString("content", localStringBuffer.toString());
      localBundle.putString("filepath", "");
      localBundle.putString("img_url", "http://client.map.baidu.com/imap/cfg/static/share_poi_wx.png");
      localBundle.putString("share_url", paramString);
      localBundle.putString("tel", paramSearchPoi.mPhone);
      localBundle.putInt("poi_x", paramSearchPoi.mViewPoint.getLatitudeE6());
      localBundle.putInt("poi_y", paramSearchPoi.mViewPoint.getLongitudeE6());
      return localBundle;
    }
    return null;
  }
  
  public void addFavorite(SearchPoi paramSearchPoi, FavoriteResultCallBack paramFavoriteResultCallBack) {}
  
  public void animationByFrogleap(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    animationByFrogleap(paramSearchPoi.mViewPoint);
  }
  
  public void animationByFrogleap(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return;
    }
    MapStatus localMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
    paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    localMapStatus.centerPtX = paramGeoPoint.getInt("MCx");
    localMapStatus.centerPtY = paramGeoPoint.getInt("MCy");
    MapViewFactory.getInstance().getMapView().animateTo(localMapStatus, 0);
  }
  
  public void animationTo(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    animationTo(paramSearchPoi.mViewPoint);
  }
  
  public void animationTo(SearchPoi paramSearchPoi, long paramLong1, long paramLong2)
  {
    if (paramSearchPoi == null) {
      return;
    }
    animationTo(paramSearchPoi.mViewPoint, paramLong1, paramLong2, -1);
  }
  
  public void animationTo(SearchPoi paramSearchPoi, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramSearchPoi == null) {
      return;
    }
    animationTo(paramSearchPoi.mViewPoint, paramLong1, paramLong2, paramInt);
  }
  
  public void animationTo(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {}
    MapStatus localMapStatus;
    do
    {
      return;
      localMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
      paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    } while ((localMapStatus == null) || (paramGeoPoint == null));
    localMapStatus.centerPtX = paramGeoPoint.getInt("MCx");
    localMapStatus.centerPtY = paramGeoPoint.getInt("MCy");
    MapViewFactory.getInstance().getMapView().animateTo(localMapStatus, 0);
  }
  
  public void animationTo(GeoPoint paramGeoPoint, long paramLong1, long paramLong2)
  {
    animationTo(paramGeoPoint, paramLong1, paramLong2, -1);
  }
  
  public void animationTo(GeoPoint paramGeoPoint, long paramLong1, long paramLong2, int paramInt)
  {
    animationTo(paramGeoPoint, paramLong1, paramLong2, paramInt, true);
  }
  
  public void animationTo(GeoPoint paramGeoPoint, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {}
    MapStatus localMapStatus;
    do
    {
      return;
      localMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
    } while (localMapStatus == null);
    paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    localMapStatus.centerPtX = paramGeoPoint.getInt("MCx");
    localMapStatus.centerPtY = paramGeoPoint.getInt("MCy");
    localMapStatus.xOffset = ((float)paramLong1);
    localMapStatus.yOffset = ((float)paramLong2);
    if (paramInt > 0) {
      localMapStatus.level = paramInt;
    }
    MapViewFactory.getInstance().getMapView().animateTo(localMapStatus, 0);
  }
  
  public boolean antiGeo(SearchPoi paramSearchPoi, int paramInt, Handler paramHandler)
  {
    if (paramSearchPoi == null) {
      return false;
    }
    return BNPoiSearcher.getInstance().asynGetPoiByPoint(paramSearchPoi.mViewPoint, paramInt, 10000, paramHandler);
  }
  
  public void backFragment()
  {
    h.a().back();
  }
  
  public void callPhone(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    q.f().a(this.mContext, paramSearchPoi.mPhone);
  }
  
  public void checkFavorite(SearchPoi paramSearchPoi, FavoriteResultCallBack paramFavoriteResultCallBack) {}
  
  public void checkFavorite(GeoPoint paramGeoPoint, FavoriteResultCallBack paramFavoriteResultCallBack) {}
  
  public void clearPoiCache()
  {
    ItemizedOverlayUtil.getInstance().removeAllItems();
    ItemizedOverlayUtil.getInstance().hide();
    ItemizedOverlayUtil.getInstance().refresh();
  }
  
  public void focusItem(boolean paramBoolean)
  {
    BNMapController.getInstance().focusItem(3, this.mId, paramBoolean);
  }
  
  public void focusPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    focusPoi(paramSearchPoi.mViewPoint);
  }
  
  public void focusPoi(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return;
    }
    this.mId = 0;
    BNPoiSearcher.getInstance().clearPoiCache();
    BNPoiSearcher.getInstance().updatePoiCache(paramGeoPoint);
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().updateLayer(3);
    ItemizedOverlayUtil.getInstance().removeAllItems();
    Bundle localBundle = CoordinateTransformUtil.LL2MC(paramGeoPoint.getLongitudeE6() / 100000.0D, paramGeoPoint.getLatitudeE6() / 100000.0D);
    paramGeoPoint = null;
    if (localBundle != null) {
      paramGeoPoint = new GeoPoint(localBundle.getInt("MCx"), localBundle.getInt("MCy"));
    }
    paramGeoPoint = ItemizedOverlayUtil.getInstance().getOverlayItem(paramGeoPoint, StyleManager.getDrawable(2130837889));
    ItemizedOverlayUtil.getInstance().addMapItem(paramGeoPoint);
    ItemizedOverlayUtil.getInstance().show();
    ItemizedOverlayUtil.getInstance().refresh();
    ItemizedOverlayUtil.getInstance().setOnTapListener(null);
  }
  
  public void focusPoi(ArrayList<SearchPoi> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    this.mId = paramInt;
    BNPoiSearcher.getInstance().clearPoiCache();
    BNPoiSearcher.getInstance().updatePoiCacheWithList(paramArrayList);
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().updateLayer(3);
  }
  
  public int getAntiPoiNetMode(GeoPoint paramGeoPoint)
  {
    int i = -1;
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return -1;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0);
      bool1 = bool2;
      if (paramGeoPoint != null)
      {
        paramGeoPoint = BNPoiSearcher.getInstance().getParentDistrict(paramGeoPoint.mId);
        bool1 = bool2;
        if (paramGeoPoint != null) {
          bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(paramGeoPoint.mId);
        }
      }
    }
    if (bool1) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (NetworkUtils.getConnectStatus()) {
        i = 1;
      }
    }
  }
  
  public String getDistance2CurrentPoint(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return StyleManager.getString(2131298908);
    }
    return getDistance2CurrentPoint(paramSearchPoi.mViewPoint);
  }
  
  public String getDistance2CurrentPoint(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return "";
    }
    GeoPoint localGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if ((localGeoPoint == null) || (!localGeoPoint.isValid())) {
      return "";
    }
    return StringUtils.getDistance(paramGeoPoint.getLongitudeE6() - localGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6() - localGeoPoint.getLatitudeE6());
  }
  
  public int getDistrictId()
  {
    return this.mDistrictId;
  }
  
  public int getSearchNetMode()
  {
    return this.mSearchRsultNetMode;
  }
  
  public SearchPoi getStreetViewPoi()
  {
    return this.mStreetViewPoi;
  }
  
  public void handleSinaCallback(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mShareTool == null) {
      this.mShareTool = new ShareTools(paramContext, 2);
    }
    this.mShareTool.onSinaAuthorizeCallback(paramInt1, paramInt2, paramIntent);
  }
  
  public void removeFavorite(SearchPoi paramSearchPoi, FavoriteResultCallBack paramFavoriteResultCallBack) {}
  
  public void searchSpace(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("incoming_type", 1);
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setSpaceSearchPoi(paramSearchPoi);
    h.a().showFragment(38, localBundle);
  }
  
  public void setDistrictId(int paramInt)
  {
    this.mDistrictId = paramInt;
  }
  
  public void setEnd(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_poi_detail", true);
    localBundle.putInt("set_poi_type", 2);
    paramSearchPoi = createRoutePlanNode(paramSearchPoi);
    ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointPoiDetail(paramSearchPoi);
    h.a().showFragment(50, localBundle);
  }
  
  public void setMapffset(long paramLong1, long paramLong2)
  {
    MapStatus localMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
    if (localMapStatus != null)
    {
      localMapStatus.xOffset = ((float)paramLong1);
      localMapStatus.yOffset = ((float)paramLong2);
      MapViewFactory.getInstance().getMapView().animateTo(localMapStatus, 0);
    }
  }
  
  public void setSearchKey(String paramString)
  {
    this.mSearchKey = paramString;
  }
  
  public void setSearchNetMode(int paramInt)
  {
    this.mSearchRsultNetMode = paramInt;
  }
  
  public void setStart(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_poi_detail", true);
    localBundle.putInt("set_poi_type", 0);
    paramSearchPoi = createRoutePlanNode(paramSearchPoi);
    ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointPoiDetail(paramSearchPoi);
    h.a().showFragment(50, localBundle);
  }
  
  public void setVia(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_poi_detail", true);
    localBundle.putInt("set_poi_type", 1);
    paramSearchPoi = createRoutePlanNode(paramSearchPoi);
    ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointPoiDetail(paramSearchPoi);
    h.a().showFragment(50, localBundle);
  }
  
  public void sharePoi(Context paramContext, SearchPoi paramSearchPoi, String paramString, Activity paramActivity, ShareEventCallBack paramShareEventCallBack)
  {
    paramString = new Intent("android.intent.action.SEND");
    paramString.setType("text/plain");
    paramString.putExtra("android.intent.extra.SUBJECT", "分享");
    paramString.putExtra("android.intent.extra.TEXT", paramSearchPoi.mName);
    paramString.setFlags(268435456);
    paramContext.startActivity(Intent.createChooser(paramString, "分享方式"));
  }
  
  public void sharePoi(SearchPoi paramSearchPoi, String paramString, Activity paramActivity, ShareEventCallBack paramShareEventCallBack)
  {
    if ((paramSearchPoi == null) || (TextUtils.isEmpty(paramSearchPoi.mName)) || (paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    if (paramShareEventCallBack != null) {
      paramShareEventCallBack.onStart();
    }
    new StringBuilder().append(paramSearchPoi.mName).append("\r\n").toString();
    if (this.mShareTool == null) {
      this.mShareTool = new ShareTools(paramActivity, 2);
    }
    this.mShareTool.share(getOpenSharePoiBundle(paramSearchPoi, paramString));
  }
  
  public void sharePoiGetShortUrl(SearchPoi paramSearchPoi, Handler paramHandler) {}
  
  public void sharePoiParseShortUrl(String paramString, Handler paramHandler) {}
  
  public void startCalcRoute(SearchPoi paramSearchPoi, e parame)
  {
    NavPoiController.getInstance().startCalcRoute(paramSearchPoi);
  }
  
  public void startRef(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    if (!NetworkUtils.getConnectStatus())
    {
      TipTool.onCreateToastDialog(this.mContext, 2131296542);
      return;
    }
    RoutePlanNode localRoutePlanNode = BNLocationManagerProxy.getInstance().getCurLocationNode();
    if ((localRoutePlanNode == null) || (!BNLocationManagerProxy.getInstance().isLocationValid()))
    {
      TipTool.onCreateToastDialog(this.mContext, 2131297228);
      return;
    }
    paramSearchPoi = createRoutePlanNode(paramSearchPoi);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(localRoutePlanNode);
    localArrayList.add(paramSearchPoi);
  }
  
  public void updatePoiBkgLayer(ArrayList<SearchPoi> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    BNPoiSearcher.getInstance().clearBkgCache();
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    if (i < paramArrayList.size())
    {
      SearchPoi localSearchPoi = (SearchPoi)paramArrayList.get(i);
      if (localSearchPoi == null) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localSearchPoi.mViewPoint);
      }
    }
    BNPoiSearcher.getInstance().updateBkgCache(localArrayList, -1);
    BNMapController.getInstance().updateLayer(4);
    BNMapController.getInstance().updateLayer(3);
  }
  
  public void viewStreet(SearchPoi paramSearchPoi, Context paramContext, e parame) {}
  
  public static abstract interface AntiGeoCallBack
  {
    public abstract void onFail();
    
    public abstract void onRevSearchPoi(SearchPoi paramSearchPoi);
    
    public abstract void onStart();
  }
  
  class FavoriteJob
    implements Runnable
  {
    public static final int ADD_EVENT = 0;
    public static final int CANCLE_EVENT = 2;
    public static final int CHECK_EVENT = 1;
    private int mEvent = -1;
    private PoiController.FavoriteResultCallBack mFavoriteResultCallBack;
    private GeoPoint mPoint;
    private SearchPoi mSearchPoi;
    
    public FavoriteJob(SearchPoi paramSearchPoi, PoiController.FavoriteResultCallBack paramFavoriteResultCallBack)
    {
      this.mFavoriteResultCallBack = paramFavoriteResultCallBack;
      this.mSearchPoi = paramSearchPoi;
    }
    
    public FavoriteJob(GeoPoint paramGeoPoint, PoiController.FavoriteResultCallBack paramFavoriteResultCallBack)
    {
      this.mFavoriteResultCallBack = paramFavoriteResultCallBack;
      this.mPoint = paramGeoPoint;
    }
    
    public void run()
    {
      if (this.mFavoriteResultCallBack == null) {
        return;
      }
      PoiController.this.mUIHandler.post(new Runnable()
      {
        public void run()
        {
          PoiController.FavoriteJob.this.mFavoriteResultCallBack.onFavoritEventStart();
        }
      });
      switch (this.mEvent)
      {
      default: 
        return;
      case 0: 
        bool = false;
        switch (BNFavoriteManager.getInstance().addNewPoiToFavorite(this.mSearchPoi))
        {
        }
      case 1: 
        for (;;)
        {
          PoiController.this.mUIHandler.post(new Runnable()
          {
            public void run()
            {
              PoiController.FavoriteJob.this.mFavoriteResultCallBack.onAddResult(bool);
            }
          });
          return;
          if (this.mPoint == null) {}
          for (bool = BNFavoriteManager.getInstance().isPoiExistInFavByPoint(this.mSearchPoi);; bool = BNFavoriteManager.getInstance().isPoiExistInFavByPoint(this.mPoint))
          {
            PoiController.this.mUIHandler.post(new Runnable()
            {
              public void run()
              {
                PoiController.FavoriteJob.this.mFavoriteResultCallBack.onCheckResult(bool);
              }
            });
            return;
          }
          TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(2131296424));
          BNMapController.getInstance().updateLayer(16);
          bool = true;
          continue;
          TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(2131296419));
          continue;
          TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(2131296422));
          continue;
          TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(2131296423));
        }
      }
      final boolean bool = BNFavoriteManager.getInstance().removePoiFromFavorite(this.mSearchPoi);
      if (bool)
      {
        BNMapController.getInstance().updateLayer(16);
        TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(2131296420));
      }
      for (;;)
      {
        PoiController.this.mUIHandler.post(new Runnable()
        {
          public void run()
          {
            PoiController.FavoriteJob.this.mFavoriteResultCallBack.onRemoveResult(bool);
          }
        });
        return;
        TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(2131296421));
      }
    }
    
    public FavoriteJob setEvent(int paramInt)
    {
      this.mEvent = paramInt;
      return this;
    }
  }
  
  public static abstract interface FavoriteResultCallBack
  {
    public abstract void onAddResult(boolean paramBoolean);
    
    public abstract void onCheckResult(boolean paramBoolean);
    
    public abstract void onFavoritEventStart();
    
    public abstract void onRemoveResult(boolean paramBoolean);
  }
  
  static class InnerHolder
  {
    static PoiController mInstance = new PoiController(null);
  }
  
  public static abstract interface ShareEventCallBack
  {
    public abstract void onEnd();
    
    public abstract void onStart();
  }
  
  public static abstract interface StreetSearchCallBack
  {
    public abstract void onFail();
    
    public abstract void onRevStreetId(String paramString);
    
    public abstract void onStart();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/PoiController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */