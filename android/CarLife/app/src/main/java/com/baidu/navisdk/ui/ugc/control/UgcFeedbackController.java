package com.baidu.navisdk.ui.ugc.control;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.UgcPointInfo;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.base.LocationUtils;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class UgcFeedbackController
{
  private static final String TAG = UgcFeedbackController.class.getName();
  private static String URL_UGC_YAW_DESTINATION = null;
  private static String URL_UGC_YAW_ROUTEADDED;
  private static String URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD = null;
  private static String URL_UGC_YAW_TRAFICFLAGERROR = null;
  private Context mContext = null;
  private UgcFeedbackController mSyncHandler;
  private UgcFeedbackCallback mUgcFeedbackCallback = null;
  
  static
  {
    URL_UGC_YAW_ROUTEADDED = null;
  }
  
  private UgcFeedbackController()
  {
    initUgcUrl();
  }
  
  public static UgcFeedbackController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private String getKeyValueString(String paramString, int paramInt)
  {
    return "&" + paramString + "=" + paramInt;
  }
  
  private String getKeyValueString(String paramString1, String paramString2)
  {
    return "&" + paramString1 + "=" + paramString2;
  }
  
  private String getKeyValueStringWithNoPrefix(String paramString, int paramInt)
  {
    return paramString + "=" + paramInt;
  }
  
  private String getKeyValueStringWithNoPrefix(String paramString1, String paramString2)
  {
    return paramString1 + "=" + paramString2;
  }
  
  private String getUGCParamFinishNavi(UgcPointInfo paramUgcPointInfo)
  {
    Object localObject1 = paramUgcPointInfo.mViewPoint;
    label102:
    RoutePlanModel localRoutePlanModel;
    label198:
    Object localObject2;
    if (localObject1 != null)
    {
      paramUgcPointInfo = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject1).getLongitudeE6(), ((GeoPoint)localObject1).getLatitudeE6());
      paramUgcPointInfo = getKeyValueStringWithNoPrefix("user_point", paramUgcPointInfo.getInt("MCx") + "," + paramUgcPointInfo.getInt("MCy"));
      localObject1 = BNPoiSearcher.getInstance().getDistrictByPoint((GeoPoint)localObject1, 0);
      if (localObject1 == null) {
        break label418;
      }
      paramUgcPointInfo = paramUgcPointInfo + getKeyValueString("city_id", ((DistrictInfo)localObject1).mId);
      localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
      if (localRoutePlanModel == null) {
        break label447;
      }
      localObject1 = localRoutePlanModel.getStartNode().getGeoPoint();
      localObject1 = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject1).getLongitudeE6(), ((GeoPoint)localObject1).getLatitudeE6());
      localObject1 = paramUgcPointInfo + getKeyValueString("from_point", new StringBuilder().append(((Bundle)localObject1).getInt("MCx")).append(",").append(((Bundle)localObject1).getInt("MCy")).toString());
      paramUgcPointInfo = null;
      if (localRoutePlanModel != null) {
        paramUgcPointInfo = localRoutePlanModel.getStartNode().getUID();
      }
      localObject2 = paramUgcPointInfo;
      if (paramUgcPointInfo == null) {
        localObject2 = "";
      }
      paramUgcPointInfo = (String)localObject1 + getKeyValueString("from_uid", (String)localObject2);
      if (localRoutePlanModel == null) {
        break label476;
      }
      localObject1 = localRoutePlanModel.getEndNode().getGeoPoint();
      localObject1 = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject1).getLongitudeE6(), ((GeoPoint)localObject1).getLatitudeE6());
    }
    label418:
    label447:
    label476:
    for (localObject1 = paramUgcPointInfo + getKeyValueString("to_point", new StringBuilder().append(((Bundle)localObject1).getInt("MCx")).append(",").append(((Bundle)localObject1).getInt("MCy")).toString());; localObject1 = paramUgcPointInfo + getKeyValueString("to_point", " , "))
    {
      paramUgcPointInfo = null;
      if (localRoutePlanModel != null) {
        paramUgcPointInfo = localRoutePlanModel.getEndNode().getUID();
      }
      localObject2 = paramUgcPointInfo;
      if (paramUgcPointInfo == null) {
        localObject2 = "";
      }
      paramUgcPointInfo = (String)localObject1 + getKeyValueString("to_uid", (String)localObject2);
      return paramUgcPointInfo + getKeyValueString("business_trigger", 4);
      paramUgcPointInfo = getKeyValueStringWithNoPrefix("user_point", " , ");
      break;
      paramUgcPointInfo = paramUgcPointInfo + getKeyValueString("city_id", "-1");
      break label102;
      localObject1 = paramUgcPointInfo + getKeyValueString("from_point", " , ");
      break label198;
    }
  }
  
  private String getUGCParamInNavi(int paramInt)
  {
    Object localObject2 = BNSysLocationManager.getInstance().getCurLocation();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (paramInt != 4)
      {
        localObject1 = localObject2;
        if (paramInt != 6) {}
      }
      else
      {
        localObject1 = BNavigator.getInstance().getLocDataCache();
      }
    }
    RoutePlanModel localRoutePlanModel;
    label216:
    String str;
    if (localObject1 != null)
    {
      localObject1 = CoordinateTransformUtil.LL2MC(((LocData)localObject1).longitude, ((LocData)localObject1).latitude);
      if (localObject1 == null) {
        break label572;
      }
      localObject1 = getKeyValueStringWithNoPrefix("user_point", ((Bundle)localObject1).getInt("MCx") + "," + ((Bundle)localObject1).getInt("MCy"));
      localObject1 = (String)localObject1 + getKeyValueString("city_id", LocationUtils.getCurrentCityId());
      localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
      if (localRoutePlanModel == null) {
        break label584;
      }
      localObject2 = localRoutePlanModel.getStartNode().getGeoPoint();
      localObject2 = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject2).getLatitudeE6());
      localObject1 = (String)localObject1 + getKeyValueString("from_point", new StringBuilder().append(((Bundle)localObject2).getInt("MCx")).append(",").append(((Bundle)localObject2).getInt("MCy")).toString());
      if (localRoutePlanModel == null) {
        break label613;
      }
      str = localRoutePlanModel.getStartNode().getUID();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      localObject1 = (String)localObject1 + getKeyValueString("from_uid", (String)localObject2);
      label267:
      localObject2 = localObject1;
      if (localRoutePlanModel != null)
      {
        str = localRoutePlanModel.getStartNode().getDescription();
        localObject2 = str;
        if (str.equals("")) {
          localObject2 = localRoutePlanModel.getStartNode().getName();
        }
        localObject2 = (String)localObject1 + getKeyValueString("from_name", (String)localObject2);
      }
      if (localRoutePlanModel == null) {
        break label642;
      }
      localObject1 = localRoutePlanModel.getEndNode().getGeoPoint();
      localObject1 = CoordinateTransformUtil.LLE62MC(((GeoPoint)localObject1).getLongitudeE6(), ((GeoPoint)localObject1).getLatitudeE6());
      localObject1 = (String)localObject2 + getKeyValueString("to_point", new StringBuilder().append(((Bundle)localObject1).getInt("MCx")).append(",").append(((Bundle)localObject1).getInt("MCy")).toString());
      label414:
      if (localRoutePlanModel == null) {
        break label671;
      }
      str = localRoutePlanModel.getEndNode().getUID();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
    }
    label572:
    label584:
    label613:
    label642:
    label671:
    for (localObject1 = (String)localObject1 + getKeyValueString("to_uid", (String)localObject2);; localObject1 = (String)localObject1 + getKeyValueString("to_uid", ""))
    {
      localObject2 = localObject1;
      if (localRoutePlanModel != null)
      {
        str = localRoutePlanModel.getEndNode().getDescription();
        localObject2 = str;
        if (str.equals("")) {
          localObject2 = localRoutePlanModel.getEndNode().getName();
        }
        localObject2 = (String)localObject1 + getKeyValueString("to_name", (String)localObject2);
      }
      return (String)localObject2 + getKeyValueString("business_trigger", paramInt);
      if (this.mContext != null) {
        TipTool.onCreateToastDialog(this.mContext, "GPS定位中，请在定位成功后报错");
      }
      return null;
      localObject1 = getKeyValueStringWithNoPrefix("user_point", " , ");
      break;
      localObject1 = (String)localObject1 + getKeyValueString("from_point", " , ");
      break label216;
      localObject1 = (String)localObject1 + getKeyValueString("from_uid", "");
      break label267;
      localObject1 = (String)localObject2 + getKeyValueString("to_point", " , ");
      break label414;
    }
  }
  
  private String getUGCParamInRouteAdded(int paramInt)
  {
    LocData localLocData = BNSysLocationManager.getInstance().getCurLocation();
    Object localObject = localLocData;
    if (localLocData == null) {
      localObject = BNavigator.getInstance().getLocDataCache();
    }
    if (localObject != null)
    {
      localObject = CoordinateTransformUtil.LL2MC(((LocData)localObject).longitude, ((LocData)localObject).latitude);
      if (localObject == null) {
        break label134;
      }
    }
    label134:
    for (localObject = getKeyValueStringWithNoPrefix("user_point", ((Bundle)localObject).getInt("MCx") + "," + ((Bundle)localObject).getInt("MCy"));; localObject = getKeyValueStringWithNoPrefix("user_point", " , "))
    {
      localObject = (String)localObject + getKeyValueString("city_id", LocationUtils.getCurrentCityId());
      return (String)localObject + getKeyValueString("business_trigger", paramInt);
      return null;
    }
  }
  
  private String getUGCURLAddr(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 8192: 
      str = URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD;
      return str + "?" + getKeyValueStringWithNoPrefix("page_type", 202) + "&";
    case 8194: 
      str = URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD;
      return str + "?" + getKeyValueStringWithNoPrefix("page_type", 203) + "&";
    case 8195: 
      return URL_UGC_YAW_ROUTEADDED + "?";
    case 8193: 
      return URL_UGC_YAW_TRAFICFLAGERROR + "?";
    case 8196: 
      str = URL_UGC_YAW_DESTINATION;
      return str + "?" + getKeyValueStringWithNoPrefix("page_type", 101) + "&";
    case 8197: 
      str = URL_UGC_YAW_DESTINATION;
      return str + "?" + getKeyValueStringWithNoPrefix("page_type", 102) + "&";
    case 8198: 
      str = URL_UGC_YAW_DESTINATION;
      return str + "?" + getKeyValueStringWithNoPrefix("page_type", 103) + "&";
    case 8199: 
      str = URL_UGC_YAW_DESTINATION;
      return str + "?" + getKeyValueStringWithNoPrefix("page_type", 104) + "&";
    }
    String str = URL_UGC_YAW_DESTINATION;
    return str + "?" + getKeyValueStringWithNoPrefix("page_type", 105) + "&";
  }
  
  private void initUgcUrl()
  {
    if (BNSettingManager.isShowJavaLog())
    {
      URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/roadobstructedorbad";
      URL_UGC_YAW_TRAFICFLAGERROR = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/trafficsignswrong";
      URL_UGC_YAW_ROUTEADDED = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/addroad";
      URL_UGC_YAW_DESTINATION = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/poicorrect/destinationerror";
      return;
    }
    URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD = UGCYAWParamConstans.URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_ONLINE;
    URL_UGC_YAW_TRAFICFLAGERROR = UGCYAWParamConstans.URL_UGC_YAW_TRAFICFLAGERROR_ONLINE;
    URL_UGC_YAW_ROUTEADDED = UGCYAWParamConstans.URL_UGC_YAW_ROUTEADDED_ONLINE;
    URL_UGC_YAW_DESTINATION = UGCYAWParamConstans.URL_UGC_YAW_DESTINATION_ONLINE;
  }
  
  public String getNaviUgcURLString(int paramInt1, int paramInt2)
  {
    String str2 = getUGCURLAddr(paramInt1, paramInt2);
    if (str2 == null) {}
    for (;;)
    {
      return null;
      if ((paramInt1 == 8195) && (paramInt2 == 4)) {}
      for (String str1 = getUGCParamInRouteAdded(paramInt2); str1 != null; str1 = getUGCParamInNavi(paramInt2))
      {
        str1 = str2 + str1;
        LogUtil.e(TAG, "UGCUrlStr:" + str1);
        return str1;
      }
    }
  }
  
  public String getURLStringFinishNavi(int paramInt, UgcPointInfo paramUgcPointInfo)
  {
    String str = getUGCURLAddr(paramInt, 4);
    if (str == null) {
      return null;
    }
    paramUgcPointInfo = str + getUGCParamFinishNavi(paramUgcPointInfo);
    LogUtil.e(TAG, "UGCUrlStr:" + paramUgcPointInfo);
    return paramUgcPointInfo;
  }
  
  public void initUgcFeedbakController(Context paramContext, UgcFeedbackCallback paramUgcFeedbackCallback)
  {
    this.mContext = paramContext;
    this.mUgcFeedbackCallback = paramUgcFeedbackCallback;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void uninitUgcFeedbakController()
  {
    this.mContext = null;
    this.mUgcFeedbackCallback = null;
  }
  
  private static class LazyHolder
  {
    private static UgcFeedbackController sInstance = new UgcFeedbackController(null);
  }
  
  public static abstract interface UGCYAWParamConstans
  {
    public static final int DESERROR_PROBLEM_CAR_BLOCK = 8198;
    public static final int DESERROR_PROBLEM_CAR_FORBIDDEN = 8199;
    public static final int DESERROR_PROBLEM_GUIDE = 8197;
    public static final int DESERROR_PROBLEM_NOT_FOUND = 8196;
    public static final int DESERROR_PROBLEM_OTHERS = 8200;
    public static final int MSG_UGC_YAW_ROUTEADDED = 8195;
    public static final int MSG_UGC_YAW_ROUTEBAD = 8194;
    public static final int MSG_UGC_YAW_ROUTEBLOCK = 8192;
    public static final int MSG_UGC_YAW_TRAFICFLAGERROR = 8193;
    public static final int NAVI_FINISH_POI_TRIGGER = 6;
    public static final int NAVI_FINISH_TRIGGER = 4;
    public static final int NAVI_IN_TRIGGER = 1;
    public static final int PAGE_TYPE_DESTINATION_CAR_BLOCK = 103;
    public static final int PAGE_TYPE_DESTINATION_CAR_FORBIDDEN = 104;
    public static final int PAGE_TYPE_DESTINATION_GUIDE = 102;
    public static final int PAGE_TYPE_DESTINATION_NOT_FOUND = 101;
    public static final int PAGE_TYPE_DESTINATION_OTHERS = 105;
    public static final int PAGE_TYPE_ROUTEBAD = 203;
    public static final int PAGE_TYPE_ROUTEBLOCK = 202;
    public static final String URL_UGC_YAW_DESTINATION_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/poicorrect/destinationerror";
    public static final String URL_UGC_YAW_DESTINATION_ONLINE = HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/poicorrect/destinationerror";
    public static final String URL_UGC_YAW_ROUTEADDED_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/addroad";
    public static final String URL_UGC_YAW_ROUTEADDED_ONLINE;
    public static final String URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/roadobstructedorbad";
    public static final String URL_UGC_YAW_ROUTEBLOCK_OR_ROUTEBAD_ONLINE = HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/road/roadobstructedorbad";
    public static final String URL_UGC_YAW_TRAFICFLAGERROR_OFFLINE = "http://cp01-rdqa-dev112.cp01.baidu.com:8086/api/page/road/trafficsignswrong";
    public static final String URL_UGC_YAW_TRAFICFLAGERROR_ONLINE = HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/road/trafficsignswrong";
    public static final String busTrigger = "business_trigger";
    public static final String cityID = "city_id";
    public static final String fromCoordinate = "from_point";
    public static final String fromName = "from_name";
    public static final String fromUid = "from_uid";
    public static final String locCoordinate = "user_point";
    public static final String pageType = "page_type";
    public static final String toCoordinate = "to_point";
    public static final String toName = "to_name";
    public static final String toUid = "to_uid";
    
    static
    {
      URL_UGC_YAW_ROUTEADDED_ONLINE = HttpURLManager.getInstance().getScheme() + "i.map.baidu.com/api/page/road/addroad";
    }
  }
  
  public static abstract interface UgcFeedbackCallback
  {
    public abstract void onDataRequireFinish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/control/UgcFeedbackController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */