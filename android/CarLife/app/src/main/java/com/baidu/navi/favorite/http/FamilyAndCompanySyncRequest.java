package com.baidu.navi.favorite.http;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.navi.favorite.model.FamilyAndCompanyRequestModel;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FamilyAndCompanySyncRequest
  extends e
{
  private FamilyAndCompanyRequestModel requestModel;
  
  public FamilyAndCompanySyncRequest()
  {
    this.tag = FamilyAndCompanySyncRequest.class.getSimpleName();
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("bduss", this.requestModel.getBduss());
    locald.put("ofmt", "json");
    locald.put("data", this.requestModel.getData());
    return locald;
  }
  
  public SearchPoi getSearchPoi(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    GeoPoint localGeoPoint = new GeoPoint(paramInt1, paramInt2);
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mGuidePoint = localGeoPoint;
    localSearchPoi.mName = paramString1;
    localSearchPoi.mAddress = paramString2;
    return localSearchPoi;
  }
  
  protected String getUrl()
  {
    return "http://automap.baidu.com/naviauto/?__c=tps&rt=usercenter&ctime=" + this.requestModel.getCtime() + "&auth_id=" + this.requestModel.getAuthId() + "&sign=" + this.requestModel.getSign() + "&fromapp=carlife";
  }
  
  protected d getUrlParams()
  {
    return null;
  }
  
  public void reponseNoJsonCallBack(String paramString)
  {
    int k = -4;
    int i = k;
    int j;
    Object localObject3;
    Object localObject1;
    int m;
    Object localObject2;
    for (;;)
    {
      try
      {
        paramString = new String(a.b("YiVz0MC3b9UqsETN", AuthTokenSyncRequest.hex2byte(paramString.trim())));
        j = k;
        i = k;
        if (!TextUtils.isEmpty(paramString))
        {
          i = k;
          paramString = new JSONObject(paramString).optJSONObject("result").optJSONArray("content");
          i = k;
          LogUtil.e("Family", "result" + paramString.toString());
          if (paramString != null)
          {
            i = k;
            if (paramString.length() != 0) {
              continue;
            }
          }
          i = k;
          AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
          i = k;
          AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
          i = k;
          paramString = new Bundle();
          i = k;
          paramString.putInt("select_point_action", 4);
          i = k;
          UIModel.getInstance();
          i = k;
          UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), paramString);
          i = k;
          paramString = new Bundle();
          i = k;
          paramString.putInt("select_point_action", 5);
          i = k;
          UIModel.getInstance();
          i = k;
          UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), paramString);
          k = 0;
          j = 0;
          i = k;
          PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean("family_has_synced", false);
          i = k;
          PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean("company_has_synced", false);
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        j = i;
        continue;
        i = k;
        AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), paramString, paramString, j, m, (String)localObject3);
        i = k;
        AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
        i = k;
        localObject1 = new Bundle();
        i = k;
        ((Bundle)localObject1).putInt("select_point_action", 4);
        i = k;
        UIModel.getInstance();
        i = k;
        UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), (Bundle)localObject1);
        i = k;
        localObject1 = new Bundle();
        i = k;
        ((Bundle)localObject1).putInt("select_point_action", 5);
        i = k;
        UIModel.getInstance();
        i = k;
        UIModel.syncAddressToCoDriver(getSearchPoi(paramString, paramString, j, m), (Bundle)localObject1);
        continue;
        j = k;
        i = k;
        if (paramString.length() != 2) {
          continue;
        }
        j = 0;
      }
      notifyResponseListener(j);
      return;
      i = k;
      if (paramString.length() != 1) {
        continue;
      }
      i = k;
      localObject3 = (JSONObject)paramString.get(0);
      i = k;
      localObject1 = ((JSONObject)localObject3).optString("key");
      i = k;
      paramString = ((JSONObject)localObject3).optString("name");
      j = 0;
      m = 0;
      i = k;
      localObject2 = CoordinateTransformUtil.MC2LL(((JSONObject)localObject3).optInt("locx"), ((JSONObject)localObject3).optInt("locy"));
      i = k;
      localObject3 = ((JSONObject)localObject3).optString("poi_id");
      if (localObject2 != null)
      {
        i = k;
        j = (int)(((Bundle)localObject2).getDouble("LLx") * 100000.0D);
        i = k;
        m = (int)(((Bundle)localObject2).getDouble("LLy") * 100000.0D);
      }
      i = k;
      if (!"home".equals(localObject1)) {
        continue;
      }
      i = k;
      AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), paramString, paramString, j, m, (String)localObject3);
      i = k;
      AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
      i = k;
      localObject1 = new Bundle();
      i = k;
      ((Bundle)localObject1).putInt("select_point_action", 4);
      i = k;
      UIModel.getInstance();
      i = k;
      UIModel.syncAddressToCoDriver(getSearchPoi(paramString, paramString, j, m), (Bundle)localObject1);
      i = k;
      paramString = new Bundle();
      i = k;
      paramString.putInt("select_point_action", 5);
      i = k;
      UIModel.getInstance();
      i = k;
      UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), paramString);
      k = 0;
      j = 0;
      i = k;
      PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean("family_has_synced", false);
      i = k;
      PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean("company_has_synced", false);
    }
    for (;;)
    {
      if (j < 2)
      {
        i = k;
        Object localObject4 = (JSONObject)paramString.get(j);
        i = k;
        localObject2 = ((JSONObject)localObject4).optString("key");
        i = k;
        localObject1 = ((JSONObject)localObject4).optString("name");
        m = 0;
        int n = 0;
        i = k;
        localObject3 = CoordinateTransformUtil.MC2LL(((JSONObject)localObject4).optInt("locx"), ((JSONObject)localObject4).optInt("locy"));
        i = k;
        localObject4 = ((JSONObject)localObject4).optString("poi_id");
        if (localObject3 != null)
        {
          i = k;
          m = (int)(((Bundle)localObject3).getDouble("LLx") * 100000.0D);
          i = k;
          n = (int)(((Bundle)localObject3).getDouble("LLy") * 100000.0D);
        }
        i = k;
        if ("home".equals(localObject2))
        {
          i = k;
          AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), (String)localObject1, (String)localObject1, m, n, (String)localObject4);
          i = k;
          localObject2 = new Bundle();
          i = k;
          ((Bundle)localObject2).putInt("select_point_action", 4);
          i = k;
          UIModel.getInstance();
          i = k;
          UIModel.syncAddressToCoDriver(getSearchPoi((String)localObject1, (String)localObject1, m, n), (Bundle)localObject2);
        }
        else
        {
          i = k;
          if ("company".equals(localObject2))
          {
            i = k;
            AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), (String)localObject1, (String)localObject1, m, n, (String)localObject4);
            i = k;
            localObject2 = new Bundle();
            i = k;
            ((Bundle)localObject2).putInt("select_point_action", 5);
            i = k;
            UIModel.getInstance();
            i = k;
            UIModel.syncAddressToCoDriver(getSearchPoi((String)localObject1, (String)localObject1, m, n), (Bundle)localObject2);
          }
        }
      }
      else
      {
        k = 0;
        j = 0;
        i = k;
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean("family_has_synced", false);
        i = k;
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean("company_has_synced", false);
        break;
      }
      j += 1;
    }
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    return -4;
  }
  
  public void setParamsModel(FamilyAndCompanyRequestModel paramFamilyAndCompanyRequestModel)
  {
    this.requestModel = paramFamilyAndCompanyRequestModel;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/http/FamilyAndCompanySyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */