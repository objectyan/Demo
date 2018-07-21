package com.baidu.navi.voice;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.m.a;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.sdk.a.m;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviToolImpl
  implements m
{
  private static final String TAG = NaviToolImpl.class.getSimpleName();
  
  private void handleError()
  {
    a.a().b("当前页面不支持", 0);
    w.a("当前页面不支持");
  }
  
  private boolean naviAppControl(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return true;
      MapVoiceCommandController.getInstance().openNavi();
      paramJSONObject = paramJSONObject.optString("order");
    } while ((paramJSONObject.equals("")) || ((!paramJSONObject.equals("end_navi")) && (!paramJSONObject.equals("end_app"))));
    if (BNavigator.getInstance().isNaviBegin())
    {
      MapVoiceCommandController.getInstance().exitNavi();
      return true;
    }
    return false;
  }
  
  private boolean naviMapControl(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return true;
    }
    MapVoiceCommandController.getInstance().openNavi();
    int i = paramJSONObject.optInt("order");
    if ((!MapVoiceCommandController.getInstance().isMapContentFragment()) && (i != 216) && (i != 217)) {
      h.a().backTo(17, null);
    }
    switch (i)
    {
    case 204: 
    case 205: 
    case 206: 
    case 209: 
    case 210: 
    case 211: 
    case 212: 
    case 213: 
    case 214: 
    case 215: 
    case 218: 
    case 219: 
    case 224: 
    case 225: 
    case 226: 
    case 227: 
    case 228: 
    default: 
      return false;
    case 202: 
      MapVoiceCommandController.getInstance().mapZoomOut();
      return true;
    case 203: 
      MapVoiceCommandController.getInstance().mapZoomIn();
      return true;
    case 207: 
      MapVoiceCommandController.getInstance().switchRoadCondition(true);
      return true;
    case 208: 
      MapVoiceCommandController.getInstance().switchRoadCondition(false);
      return true;
    case 216: 
      MapVoiceCommandController.getInstance().naviFullView();
      return true;
    case 217: 
      MapVoiceCommandController.getInstance().naviContinue();
      return true;
    case 220: 
      MapVoiceCommandController.getInstance().mapMoveRight();
      return true;
    case 221: 
      MapVoiceCommandController.getInstance().mapMoveLeft();
      return true;
    case 222: 
      MapVoiceCommandController.getInstance().mapMoveUp();
      return true;
    case 223: 
      MapVoiceCommandController.getInstance().mapMoveDown();
      return true;
    case 229: 
      MapVoiceCommandController.getInstance().mapNorthForward();
      return true;
    case 230: 
      MapVoiceCommandController.getInstance().mapCarForward();
      return true;
    case 231: 
      MapVoiceCommandController.getInstance().switchDayNightMode(false);
      return true;
    case 232: 
      MapVoiceCommandController.getInstance().switchDayNightMode(true);
      return true;
    case 233: 
      MapVoiceCommandController.getInstance().switchNaviVoiceMode(true);
      return true;
    }
    MapVoiceCommandController.getInstance().switchNaviVoiceMode(false);
    return true;
  }
  
  private void naviNaviSet(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str1;
    Object localObject;
    String str2;
    String str3;
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            do
            {
              return;
              str1 = paramJSONObject.optString("order");
            } while (str1.equals(""));
            localObject = paramJSONObject.optJSONObject("data");
          } while (localObject == null);
          paramJSONObject = ((JSONObject)localObject).optString("type");
          str2 = ((JSONObject)localObject).optString("name");
          str3 = ((JSONObject)localObject).optString("address");
          i = ((JSONObject)localObject).optInt("lng");
          j = ((JSONObject)localObject).optInt("lat");
        } while ((paramJSONObject.equals("")) || (str2.equals("")) || (i <= 0) || (j <= 0));
        localObject = new GeoPoint(i, j);
      } while (!((GeoPoint)localObject).isValid());
      if (("type_company_address".equals(str1)) && (paramJSONObject.equals("office")))
      {
        paramJSONObject = new RoutePlanNode((GeoPoint)localObject, 5, str2, str3);
        MapVoiceCommandController.getInstance().setCompanyAddress(paramJSONObject);
        return;
      }
    } while ((!"type_home_address".equals(str1)) || (!paramJSONObject.equals("home")));
    paramJSONObject = new RoutePlanNode((GeoPoint)localObject, 4, str2, str3);
    MapVoiceCommandController.getInstance().setHomeAddress(paramJSONObject);
  }
  
  private boolean naviStartTask(JSONObject paramJSONObject)
  {
    i.b(TAG, "naviStartTask");
    if (paramJSONObject == null)
    {
      if (MapVoiceCommandController.getInstance().isRouteDetailFragment())
      {
        MapVoiceCommandController.getInstance().startNavi();
        return true;
      }
      return false;
    }
    paramJSONObject = paramJSONObject.optJSONObject("dest");
    if (paramJSONObject == null) {
      return false;
    }
    int j = paramJSONObject.optInt("lng");
    int k = paramJSONObject.optInt("lat");
    Object localObject = paramJSONObject.optString("dest_name");
    int i = paramJSONObject.optInt("preference");
    i.b(TAG, "destName:" + (String)localObject + ", lng:" + j + ", lat:" + k + ", preference:" + i);
    paramJSONObject = paramJSONObject.optJSONArray("pass_point");
    if (paramJSONObject != null)
    {
      localObject = new ArrayList();
      i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          GeoPoint localGeoPoint = new GeoPoint();
          localGeoPoint.setLatitudeE6(localJSONObject.optInt("lat"));
          localGeoPoint.setLongitudeE6(localJSONObject.optInt("lng"));
          ((ArrayList)localObject).add(localGeoPoint);
          i.b(TAG, "passPoint:lng:" + j + ", lat:" + k);
        }
        i += 1;
      }
    }
    MapVoiceCommandController.getInstance().startCalcRoute(j / 100000.0D, k / 100000.0D);
    return true;
  }
  
  public double calculateDistance(double paramDouble1, double paramDouble2)
  {
    return getDistance2CurrentPoint(CoordinateTransformUtil.transferBD09ToGCJ02(paramDouble2, paramDouble1));
  }
  
  public String getCity()
  {
    return GeoLocateModel.getInstance().getCurCityName();
  }
  
  public double getDistance2CurrentPoint(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {}
    GeoPoint localGeoPoint;
    do
    {
      return 0.0D;
      localGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    } while ((localGeoPoint == null) || (!localGeoPoint.isValid()));
    double d1 = paramGeoPoint.getLongitudeE6() - localGeoPoint.getLongitudeE6();
    double d2 = paramGeoPoint.getLatitudeE6() - localGeoPoint.getLatitudeE6();
    return Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public double getLatitude()
  {
    if (BNLocationManagerProxy.getInstance().getCurLocation() != null) {
      return BNLocationManagerProxy.getInstance().getCurLocation().latitude;
    }
    return 39.912733D;
  }
  
  public double getLatitudeBd09ll()
  {
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    return CoordinateTransformUtil.transferGCJ02ToBD09(localLocData.longitude, localLocData.latitude).getLatitudeE6() / 100000.0D;
  }
  
  public double getLatitudeBd09mc()
  {
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    return CoordinateTransformUtil.LL2MC(localLocData.longitude, localLocData.latitude).getInt("MCy") * 1.0D;
  }
  
  public double getLongitude()
  {
    if (BNLocationManagerProxy.getInstance().getCurLocation() != null) {
      return BNLocationManagerProxy.getInstance().getCurLocation().longitude;
    }
    return 116.403963D;
  }
  
  public double getLongitudeBd09ll()
  {
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    return CoordinateTransformUtil.transferGCJ02ToBD09(localLocData.longitude, localLocData.latitude).getLongitudeE6() / 100000.0D;
  }
  
  public double getLongitudeBd09mc()
  {
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    return CoordinateTransformUtil.LL2MC(localLocData.longitude, localLocData.latitude).getInt("MCx") * 1.0D;
  }
  
  public boolean isLocationReady()
  {
    return BNLocationManagerProxy.getInstance().isLocationValid();
  }
  
  public void onNaviCommand(String paramString1, String paramString2)
  {
    i.b(TAG, "func:" + paramString1 + " parsms:" + paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      i.b(TAG, "func is null");
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString2)) || (!"fun_navi_start_task".equals(paramString1))) {
        break;
      }
      MapVoiceCommandController.getInstance().openNavi();
    } while (naviStartTask(null));
    handleError();
    return;
    for (;;)
    {
      boolean bool;
      try
      {
        paramString2 = new JSONObject(paramString2);
        bool = false;
        if ("fun_navi_map_control".equals(paramString1))
        {
          bool = naviMapControl(paramString2);
          if (bool) {
            break;
          }
          handleError();
          return;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        i.b(TAG, "create JSONObject fail!");
        i.e(TAG, paramString1.toString());
        return;
      }
      if ("fun_navi_start_task".equals(paramString1))
      {
        naviStartTask(paramString2);
        bool = true;
      }
      else if ("fun_navi_navi_set".equals(paramString1))
      {
        naviNaviSet(paramString2);
        bool = true;
      }
      else if ("fun_navi_app_control".equals(paramString1))
      {
        bool = naviAppControl(paramString2);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/voice/NaviToolImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */