package com.baidu.baidunavis.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavPerformanceModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.NavSearchCircle;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import java.util.HashMap;
import java.util.List;

public class NavSearchController
{
  public static final String TAG = "NavSearchController";
  private static NavSearchController sInstance = null;
  private Handler mHandler = new BNMainLooperHandler()
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      boolean bool3 = false;
      boolean bool2 = false;
      Object localObject1 = new StringBuilder().append("mHandler() msg.what=").append(paramAnonymousMessage.what).append(", msg.arg1=").append(paramAnonymousMessage.arg1).append(", mOutHandler=null?");
      boolean bool1;
      if (NavSearchController.this.mOutHandler == null)
      {
        bool1 = true;
        NavLogUtils.e("NavSearchController", bool1);
        if (paramAnonymousMessage.what != 1007) {
          break label93;
        }
        NavSearchController.this.handleSearchByKeyForMapRPNodePoiResultPB(paramAnonymousMessage);
      }
      label93:
      while ((paramAnonymousMessage.what != 1008) && (paramAnonymousMessage.what != 1009) && (paramAnonymousMessage.what != 1010))
      {
        return;
        bool1 = false;
        break;
      }
      label139:
      Object localObject2;
      if (paramAnonymousMessage.what == 1008)
      {
        NavPerformanceModel.getInstance().endSearchByNameForMapPoiResultPB();
        if (NavSearchController.this.mOutHandler == null) {
          break label510;
        }
        if (paramAnonymousMessage.arg1 != 0) {
          break label598;
        }
        NavSearchController.this.mSearchResultOK = true;
        localObject1 = NavSearchController.this.mOutHandler.obtainMessage(1020);
        if ((paramAnonymousMessage.obj instanceof RspData))
        {
          NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_OK 0");
          ((Message)localObject1).obj = ((RspData)paramAnonymousMessage.obj).mData;
          if ((((Message)localObject1).obj == null) || (!(((Message)localObject1).obj instanceof Bundle))) {
            break label563;
          }
          NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_OK 1");
          localObject2 = (Bundle)((Message)localObject1).obj;
          if (!((Bundle)localObject2).containsKey("has_offline_data")) {
            break label517;
          }
          NavSearchController localNavSearchController = NavSearchController.this;
          if (((Bundle)localObject2).getInt("has_offline_data") != 0) {
            break label512;
          }
          bool1 = bool2;
          label325:
          localNavSearchController.mIsContainsOfflineData = bool1;
          NavLogUtils.e("NavSearchController", "mHandler() contains mIsContainsOfflineData=" + NavSearchController.this.mIsContainsOfflineData);
          label361:
          if (!((Bundle)localObject2).containsKey("pb_data")) {
            break label528;
          }
          NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", Search_PB_Data");
          localObject2 = ((Bundle)localObject2).getByteArray("pb_data");
          if (localObject2 != null) {
            NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", Search_PB_Data ,data.len=" + localObject2.length);
          }
        }
      }
      for (;;)
      {
        ((Message)localObject1).sendToTarget();
        NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_OK 3");
        return;
        if (paramAnonymousMessage.what != 1009) {
          break label139;
        }
        NavPerformanceModel.getInstance().endSearchByCircleForMapPoiResultPB();
        break label139;
        label510:
        break;
        label512:
        bool1 = true;
        break label325;
        label517:
        NavSearchController.this.mIsContainsOfflineData = false;
        break label361;
        label528:
        NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", Search_PB_Data is null");
        continue;
        label563:
        NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_OK 2");
      }
      label598:
      NavSearchController.this.mSearchResultOK = false;
      if ((paramAnonymousMessage.obj instanceof RspData))
      {
        NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_FAILED 0");
        localObject1 = ((RspData)paramAnonymousMessage.obj).mData;
        if ((localObject1 != null) && ((localObject1 instanceof Bundle)))
        {
          NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_FAILED 1");
          localObject1 = (Bundle)localObject1;
          if (!((Bundle)localObject1).containsKey("has_offline_data")) {
            break label831;
          }
          localObject2 = NavSearchController.this;
          if (((Bundle)localObject1).getInt("has_offline_data") != 0) {
            break label826;
          }
          bool1 = bool3;
          ((NavSearchController)localObject2).mIsContainsOfflineData = bool1;
          NavLogUtils.e("NavSearchController", "mHandler() contains mIsContainsOfflineData=" + NavSearchController.this.mIsContainsOfflineData);
        }
      }
      for (;;)
      {
        NavSearchController.this.mOutHandler.obtainMessage(1021).sendToTarget();
        NavLogUtils.e("NavSearchController", "mHandler() msg.what=" + paramAnonymousMessage.what + ", RET_FAILED");
        return;
        label826:
        bool1 = true;
        break;
        label831:
        NavSearchController.this.mIsContainsOfflineData = false;
      }
    }
  };
  public boolean mIsContainsOfflineData = false;
  private boolean mIsFromMap = true;
  private Handler mOutHandler = null;
  public boolean mSearchResultOK = false;
  private int mSearchRouteNodeType = -1;
  
  public static NavSearchController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavSearchController();
    }
    return sInstance;
  }
  
  private void handleSearchByKeyForMapRPNodePoiResultPB(Message paramMessage)
  {
    if (paramMessage.what != 1007) {}
    Object localObject1;
    label960:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = new Bundle();
              if ((paramMessage.obj instanceof RspData)) {
                break;
              }
            } while (BaiduNaviManager.getInstance().getMapHandler() == null);
            NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() obj is null.");
            paramMessage = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
            paramMessage.obj = localObject1;
            paramMessage.sendToTarget();
            return;
            localObject2 = ((RspData)paramMessage.obj).mData;
            if ((localObject2 != null) && ((localObject2 instanceof HashMap))) {
              break;
            }
          } while (BaiduNaviManager.getInstance().getMapHandler() == null);
          NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() data is null.");
          paramMessage = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
          paramMessage.obj = localObject1;
          paramMessage.sendToTarget();
          return;
          localObject2 = (HashMap)localObject2;
          if (((HashMap)localObject2).containsKey("route_node_type"))
          {
            ((Bundle)localObject1).putInt("route_node_type", ((Integer)((HashMap)localObject2).get("route_node_type")).intValue());
            this.mSearchRouteNodeType = ((Integer)((HashMap)localObject2).get("route_node_type")).intValue();
          }
          int i = -1;
          if (((HashMap)localObject2).containsKey("param.search.via_route_node_index"))
          {
            ((Bundle)localObject1).putInt("route_node_type", ((Integer)((HashMap)localObject2).get("param.search.via_route_node_index")).intValue());
            i = ((Integer)((HashMap)localObject2).get("param.search.via_route_node_index")).intValue();
          }
          NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() nodeType=" + this.mSearchRouteNodeType + ", viaNodeIndex=" + i);
          if (paramMessage.arg1 != 0) {
            break label960;
          }
          NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB RET_OK");
          if (!((HashMap)localObject2).containsKey("search_jump_to_rp")) {
            break;
          }
          if (((Boolean)((HashMap)localObject2).get("search_jump_to_rp")).booleanValue())
          {
            NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS() for SearchPoi");
            if (!((HashMap)localObject2).containsKey("search_poi")) {
              break;
            }
            paramMessage = (SearchPoi)((HashMap)localObject2).get("search_poi");
            if ((this.mSearchRouteNodeType < 0) || (paramMessage == null) || (paramMessage.mGuidePoint == null)) {
              break;
            }
            if (this.mSearchRouteNodeType == 0)
            {
              localObject1 = NavRoutePlanModel.getInstance().getStartRouteNode();
              ((RouteNode)localObject1).mFromType = 1;
              ((RouteNode)localObject1).mGeoPoint = NavModelHelper.convertGeoPoint(paramMessage.mGuidePoint);
              ((RouteNode)localObject1).mName = paramMessage.mName;
              ((RouteNode)localObject1).mAddr = paramMessage.mAddress;
              ((RouteNode)localObject1).mProvinceID = paramMessage.mDistrictId;
              ((RouteNode)localObject1).mCityID = paramMessage.mDistrictId;
              ((RouteNode)localObject1).mUID = paramMessage.mOriginUID;
              NavRoutePlanModel.getInstance().setStartRouteNode((RouteNode)localObject1);
            }
            for (;;)
            {
              if (BaiduNaviManager.getInstance().getMapHandler() != null)
              {
                NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS()  dispatch msg to dimiss loadding...");
                BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1031).sendToTarget();
              }
              if (!isFromMap()) {
                break;
              }
              BaiduNaviManager.getInstance().calcRouteForPBData(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavRoutePlanModel.getInstance().getViaNodes(), NavRoutePlanModel.getInstance().getPreference(), NavRoutePlanModel.getInstance().getDriveRefTimeInterval(), NavRoutePlanModel.getInstance().getDriveRefTimeDuration(), NavRoutePlanModel.getInstance().getStrategy(), NavRoutePlanModel.getInstance().getRouteInfoStatus(), NavRoutePlanModel.getInstance().mCarPANumber, NavRoutePlanModel.getInstance().getEntry());
              return;
              if (this.mSearchRouteNodeType == 5)
              {
                localObject1 = NavRoutePlanModel.getInstance().getEndRouteNode();
                ((RouteNode)localObject1).mFromType = 1;
                ((RouteNode)localObject1).mGeoPoint = NavModelHelper.convertGeoPoint(paramMessage.mGuidePoint);
                ((RouteNode)localObject1).mName = paramMessage.mName;
                ((RouteNode)localObject1).mAddr = paramMessage.mAddress;
                ((RouteNode)localObject1).mProvinceID = paramMessage.mDistrictId;
                ((RouteNode)localObject1).mCityID = paramMessage.mDistrictId;
                ((RouteNode)localObject1).mUID = paramMessage.mOriginUID;
                NavRoutePlanModel.getInstance().setEndRouteNode((RouteNode)localObject1);
              }
              else if ((this.mSearchRouteNodeType >= 1) && (this.mSearchRouteNodeType <= 4) && (i >= 0) && (NavRoutePlanModel.getInstance().getViaNodes() != null) && (i < NavRoutePlanModel.getInstance().getViaNodes().size()))
              {
                localObject1 = (RouteNode)NavRoutePlanModel.getInstance().getViaNodes().get(i);
                ((RouteNode)localObject1).mFromType = 1;
                ((RouteNode)localObject1).mGeoPoint = NavModelHelper.convertGeoPoint(paramMessage.mGuidePoint);
                ((RouteNode)localObject1).mName = paramMessage.mName;
                ((RouteNode)localObject1).mAddr = paramMessage.mAddress;
                ((RouteNode)localObject1).mProvinceID = paramMessage.mDistrictId;
                ((RouteNode)localObject1).mCityID = paramMessage.mDistrictId;
                ((RouteNode)localObject1).mUID = paramMessage.mOriginUID;
                NavRoutePlanModel.getInstance().getViaNodes().set(i, localObject1);
              }
            }
            BaiduNaviManager.getInstance().calcRouteToNaviRoute(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavRoutePlanModel.getInstance().getViaNodes(), NavRoutePlanModel.getInstance().getPreference(), NavRoutePlanModel.getInstance().getDriveRefTimeInterval(), NavRoutePlanModel.getInstance().getDriveRefTimeDuration(), NavRoutePlanModel.getInstance().getStrategy(), NavRoutePlanModel.getInstance().getEntry());
            return;
          }
          NavLogUtils.e("NavSearchController", "search EVENT_SUCCUSS() for pb");
          if (!((HashMap)localObject2).containsKey("pb_data")) {
            break;
          }
          paramMessage = (byte[])((HashMap)localObject2).get("pb_data");
          if (paramMessage != null)
          {
            NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS() routePB.len=" + paramMessage.length);
            ((Bundle)localObject1).putByteArray("pb_data", paramMessage);
          }
        } while (BaiduNaviManager.getInstance().getMapHandler() == null);
        NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_SUCCUSS()  dispatch msg");
        paramMessage = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1020);
        paramMessage.obj = localObject1;
        paramMessage.sendToTarget();
        return;
      } while (BaiduNaviManager.getInstance().getMapHandler() == null);
      NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL()  dispatch msg");
      paramMessage = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
      paramMessage.obj = localObject1;
      paramMessage.sendToTarget();
      return;
      NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL()");
      paramMessage = null;
      if (((HashMap)localObject2).containsKey("pb_data")) {
        paramMessage = (byte[])((HashMap)localObject2).get("pb_data");
      }
      if (paramMessage != null)
      {
        NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL() routePB.len=" + paramMessage.length);
        ((Bundle)localObject1).putByteArray("pb_data", paramMessage);
      }
    } while (BaiduNaviManager.getInstance().getMapHandler() == null);
    NavLogUtils.e("NavSearchController", "handleSearchByKeyForMapRPNodePoiResultPB() EVENT_FAIL()  dispatch msg");
    paramMessage = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1021);
    paramMessage.obj = localObject1;
    paramMessage.sendToTarget();
  }
  
  public boolean cancelQuery()
  {
    BNPoiSearcher.getInstance().cancelQuery();
    return true;
  }
  
  public int getDistrictIdForKeySearch(int paramInt)
  {
    NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch() districtId=" + paramInt);
    int k = 0;
    int m = paramInt;
    if ((m == -1) || (m == 1) || (m >= 9000) || (m >= 65536)) {
      k = 1;
    }
    int i = k;
    int j = m;
    DistrictInfo localDistrictInfo;
    if (k == 0)
    {
      localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(paramInt);
      if (localDistrictInfo == null)
      {
        NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()1 district info is null. ");
        if ((localDistrictInfo == null) || (localDistrictInfo.mType != 3)) {
          break label500;
        }
        i = 1;
        j = localDistrictInfo.mId;
      }
    }
    else
    {
      label117:
      m = i;
      k = j;
      if (i == 0)
      {
        k = NavMapAdapter.getInstance().getRoamCityId();
        localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(k);
        if (localDistrictInfo != null) {
          break label576;
        }
        NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()2 district info is null. roamID=" + k);
        label176:
        m = i;
        k = j;
        if (localDistrictInfo != null)
        {
          m = i;
          k = j;
          if (localDistrictInfo.mType == 3)
          {
            m = 1;
            k = localDistrictInfo.mId;
          }
        }
      }
      j = m;
      i = k;
      if (m == 0)
      {
        i = NavMapAdapter.getInstance().getCurrentLocalCityId();
        localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(i);
        if (localDistrictInfo != null) {
          break label647;
        }
        NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()3 district info is null. curLocalCityId=" + i);
        label269:
        j = m;
        i = k;
        if (localDistrictInfo != null)
        {
          j = m;
          i = k;
          if (localDistrictInfo.mType == 3)
          {
            j = 1;
            i = localDistrictInfo.mId;
          }
        }
      }
      m = j;
      k = i;
      if (j == 0)
      {
        k = NavCommonFuncController.getInstance().getLocationCityIdByPoint();
        if (k <= 0) {
          break label788;
        }
        localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(k);
        if (localDistrictInfo != null) {
          break label717;
        }
        NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()4 district info is null. locID=" + k);
        label367:
        m = j;
        k = i;
        if (localDistrictInfo != null)
        {
          m = j;
          k = i;
          if (localDistrictInfo.mType == 3) {
            m = 1;
          }
        }
      }
    }
    for (k = localDistrictInfo.mId;; k = i)
    {
      if (m == 0) {
        k = paramInt;
      }
      NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch() newDistrictId=" + k);
      return k;
      NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()1 di.type=" + localDistrictInfo.mType + ", di.id=" + localDistrictInfo.mId + ", name=" + localDistrictInfo.mName);
      break;
      label500:
      i = k;
      j = m;
      if (localDistrictInfo == null) {
        break label117;
      }
      i = k;
      j = m;
      if (localDistrictInfo.mType != 4) {
        break label117;
      }
      localDistrictInfo = BNPoiSearcher.getInstance().getParentDistrict(localDistrictInfo.mId);
      i = k;
      j = m;
      if (localDistrictInfo == null) {
        break label117;
      }
      i = k;
      j = m;
      if (localDistrictInfo.mType != 3) {
        break label117;
      }
      i = 1;
      j = localDistrictInfo.mId;
      break label117;
      label576:
      NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()2 di.type=" + localDistrictInfo.mType + ", di.id=" + localDistrictInfo.mId + ", name=" + localDistrictInfo.mName + ", roamID=" + k);
      break label176;
      label647:
      NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()3 di.type=" + localDistrictInfo.mType + ", di.id=" + localDistrictInfo.mId + ", name=" + localDistrictInfo.mName + ", curLocalCityId=" + i);
      break label269;
      label717:
      NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()4 di.type=" + localDistrictInfo.mType + ", di.id=" + localDistrictInfo.mId + ", name=" + localDistrictInfo.mName + ", locID=" + k);
      break label367;
      label788:
      NavLogUtils.e("NavSearchController", "getDistrictIdForKeySearch()4 district info is null. locID=" + k);
      m = j;
    }
  }
  
  public Bundle getSearchStatusInfo()
  {
    Bundle localBundle = new Bundle();
    NavLogUtils.e("NavSearchController", "getSearchStatusInfo() result=" + this.mSearchResultOK + ", netmode=" + BNPoiSearcher.getInstance().getNetModeOfLastResult() + ", hasOfflineData=" + this.mIsContainsOfflineData);
    localBundle.putBoolean("result", this.mSearchResultOK);
    localBundle.putInt("netmode", BNPoiSearcher.getInstance().getNetModeOfLastResult());
    localBundle.putBoolean("has_offline_data", this.mIsContainsOfflineData);
    return localBundle;
  }
  
  public boolean isFromMap()
  {
    return this.mIsFromMap;
  }
  
  public boolean routeSearchForMapPoiResultPB(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, Handler paramHandler)
  {
    this.mOutHandler = paramHandler;
    this.mSearchResultOK = false;
    this.mIsContainsOfflineData = false;
    NavLogUtils.e("NavSearchController", "routeSearchForMapPoiResultPB() routeSearchMode=" + paramInt1 + ", searchWord=" + paramString1 + ", searchRange=" + paramInt2 + ", sortType=" + paramInt3 + ", mrsl=" + paramString2);
    return BNPoiSearcher.getInstance().asynRouteSearchForMapPoiResultPB(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramInt4, paramInt5, this.mHandler);
  }
  
  public boolean searchByCircleForMapPoiResultPB(String paramString, int paramInt1, NavSearchCircle paramNavSearchCircle, int paramInt2, int paramInt3, Handler paramHandler)
  {
    this.mOutHandler = paramHandler;
    this.mSearchResultOK = false;
    this.mIsContainsOfflineData = false;
    int i = getDistrictIdForKeySearch(paramInt1);
    NavLogUtils.e("NavSearchController", "NavSearchController.SearchByCircleForMapPoiResultPB() districtId=" + paramInt1 + ", newID=" + i);
    return BNPoiSearcher.getInstance().asynSearchByCircleForMapPoiResultPB(paramString, i, NavModelHelper.convertNavSearchCircle(paramNavSearchCircle), paramInt2, paramInt3, this.mHandler);
  }
  
  public void searchByKeyForPBData(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mSearchRouteNodeType = paramInt5;
    this.mSearchResultOK = false;
    this.mIsContainsOfflineData = false;
    int j = getDistrictIdForKeySearch(paramInt1);
    NavLogUtils.e("NavSearchController", "searchByKeyForPBData() oldID=" + paramInt1 + ", newID=" + j + " , key=" + paramString + ", searchRouteNodeType=" + paramInt5 + ", strategy=" + paramInt3);
    int i;
    switch (paramInt3)
    {
    default: 
      i = 3;
      if (i == 3) {
        paramInt3 = 1;
      }
      break;
    }
    for (;;)
    {
      i = paramInt3;
      if (paramInt3 != 0)
      {
        i = paramInt3;
        if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
          i = 0;
        }
      }
      NavLogUtils.e("NavSearchController", "searchByKeyForPBData() districtId=" + paramInt1 + ", netMode=" + i + ", routeNodeType=" + paramInt5 + ", viaIndex=" + paramInt6);
      BNPoiSearcher.getInstance().asynSearchByKeyForMapRPNodePoiResultPB(paramString, j, paramInt2, i, paramInt4, paramInt5, paramInt6, this.mHandler);
      NavLogUtils.e("NavSearchController", "searchByKeyForPBData() end");
      return;
      i = 3;
      break;
      i = BNSettingManager.getPrefSearchMode();
      break;
      paramInt3 = i;
      if (i == 2) {
        paramInt3 = 0;
      }
    }
  }
  
  public boolean searchByNameForMapPoiResultPB(String paramString, int paramInt1, NavSearchCircle paramNavSearchCircle, int paramInt2, int paramInt3, Handler paramHandler)
  {
    this.mOutHandler = paramHandler;
    this.mSearchResultOK = false;
    this.mIsContainsOfflineData = false;
    int i = getDistrictIdForKeySearch(paramInt1);
    NavLogUtils.e("NavSearchController", "NavSearchController.SearchByNameForMapPoiResultPB() districtId=" + paramInt1 + ", newID=" + i);
    return BNPoiSearcher.getInstance().asynSearchByNameForMapPoiResultPB(paramString, i, NavModelHelper.convertNavSearchCircle(paramNavSearchCircle), paramInt2, paramInt3, this.mHandler);
  }
  
  public void setIsFromMap(boolean paramBoolean)
  {
    LogUtil.e("NavSearchController", " (NavSearchController) setIsFromMap (普通导航): fromMap --> " + paramBoolean);
    this.mIsFromMap = paramBoolean;
  }
  
  public void setRpEntry(int paramInt)
  {
    int i = BNRoutePlaner.getInstance().mEntryCache;
    if (i != -1)
    {
      BNRoutePlaner.getInstance().setComeFrom(i);
      BNRoutePlaner.getInstance().mEntryCache = -1;
      return;
    }
    BNRoutePlaner.getInstance().setComeFrom(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavSearchController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */