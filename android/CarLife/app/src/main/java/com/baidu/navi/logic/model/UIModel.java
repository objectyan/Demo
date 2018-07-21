package com.baidu.navi.logic.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.carlife.core.a;
import com.baidu.carlife.logic.codriver.adapter.b;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.BaseModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class UIModel
  extends BaseModel
{
  private static UIModel mInstance;
  private boolean mIsAutoUpdateData = false;
  private boolean mIsNewData = false;
  private int mSearchDistrictID = 131;
  private String mSearchDistrictName = "北京市";
  
  public static UIModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new UIModel();
    }
    return mInstance;
  }
  
  private static boolean isSettingCompAddr(Bundle paramBundle)
  {
    return paramBundle.getInt("select_point_action") == 5;
  }
  
  private static boolean isSettingHomeAddr(Bundle paramBundle)
  {
    return paramBundle.getInt("select_point_action", -1) == 4;
  }
  
  private static boolean setCompAddr(RoutePlanNode paramRoutePlanNode, Context paramContext)
  {
    if (AddressSettingModel.setCompAddress(paramContext, paramRoutePlanNode))
    {
      TipTool.onCreateToastDialog(paramContext, paramContext.getString(2131297139));
      return true;
    }
    TipTool.onCreateToastDialog(paramContext, paramContext.getString(2131297138));
    return false;
  }
  
  private static boolean setHomeAddress(RoutePlanNode paramRoutePlanNode, Context paramContext)
  {
    if (AddressSettingModel.setHomeAddress(paramContext, paramRoutePlanNode))
    {
      TipTool.onCreateToastDialog(paramContext, paramContext.getString(2131297141));
      return true;
    }
    TipTool.onCreateToastDialog(paramContext, paramContext.getString(2131297138));
    return false;
  }
  
  public static void settingAddress(SearchPoi paramSearchPoi, Context paramContext, Bundle paramBundle)
  {
    if (settingAddress(RoutePlanModel.changeToRoutePlanNode(paramSearchPoi), paramContext, paramBundle)) {
      syncAddressToCoDriver(paramSearchPoi, paramBundle);
    }
  }
  
  public static boolean settingAddress(RoutePlanNode paramRoutePlanNode, Context paramContext, Bundle paramBundle)
  {
    if ((paramRoutePlanNode.getLatitudeE6() < 0) || (paramRoutePlanNode.getLongitudeE6() < 0)) {
      TipTool.onCreateToastDialog(paramContext, paramContext.getString(2131297138));
    }
    do
    {
      return false;
      if (isSettingHomeAddr(paramBundle)) {
        return setHomeAddress(paramRoutePlanNode, paramContext);
      }
    } while (!isSettingCompAddr(paramBundle));
    return setCompAddr(paramRoutePlanNode, paramContext);
  }
  
  public static void syncAddressToCoDriver(SearchPoi paramSearchPoi, Bundle paramBundle)
  {
    if ((paramSearchPoi == null) || (paramSearchPoi.mGuidePoint == null)) {}
    JSONObject localJSONObject;
    do
    {
      return;
      if (isSettingHomeAddr(paramBundle))
      {
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("domain", "navigate_instruction");
          paramBundle.put("intent", "set_home");
          localJSONObject = new JSONObject();
          localJSONObject.put("name", paramSearchPoi.mName);
          localJSONObject.put("address", paramSearchPoi.mAddress);
          paramSearchPoi = new GeoPoint(paramSearchPoi.mGuidePoint.getLongitudeE6(), paramSearchPoi.mGuidePoint.getLatitudeE6());
          localJSONObject.put("lat", paramSearchPoi.getLatitudeE6());
          localJSONObject.put("lng", paramSearchPoi.getLongitudeE6());
          localJSONObject.put("type", "home");
          paramBundle.put("data", localJSONObject);
          b.a().a(paramBundle.toString());
          return;
        }
        catch (JSONException paramSearchPoi)
        {
          return;
        }
      }
    } while (!isSettingCompAddr(paramBundle));
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("domain", "navigate_instruction");
      paramBundle.put("intent", "set_work");
      localJSONObject = new JSONObject();
      localJSONObject.put("name", paramSearchPoi.mName);
      localJSONObject.put("address", paramSearchPoi.mAddress);
      paramSearchPoi = new GeoPoint(paramSearchPoi.mGuidePoint.getLongitudeE6(), paramSearchPoi.mGuidePoint.getLatitudeE6());
      localJSONObject.put("lat", paramSearchPoi.getLatitudeE6());
      localJSONObject.put("lng", paramSearchPoi.getLongitudeE6());
      localJSONObject.put("type", "office");
      paramBundle.put("data", localJSONObject);
      b.a().a(paramBundle.toString());
      return;
    }
    catch (JSONException paramSearchPoi) {}
  }
  
  public static void syncAddressToCoDriverForAppStart()
  {
    Object localObject;
    SearchPoi localSearchPoi;
    if (AddressSettingModel.hasSetCompAddr(a.a()))
    {
      localObject = AddressSettingModel.getCompAddrNode(a.a());
      localSearchPoi = new SearchPoi();
      localSearchPoi.mName = ((RoutePlanNode)localObject).mName;
      localSearchPoi.mAddress = ((RoutePlanNode)localObject).mDescription;
      localSearchPoi.mGuidePoint = ((RoutePlanNode)localObject).mGeoPoint;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("select_point_action", 5);
      syncAddressToCoDriver(localSearchPoi, (Bundle)localObject);
    }
    if (AddressSettingModel.hasSetHomeAddr(a.a()))
    {
      localObject = AddressSettingModel.getHomeAddrNode(a.a());
      localSearchPoi = new SearchPoi();
      localSearchPoi.mName = ((RoutePlanNode)localObject).mName;
      localSearchPoi.mAddress = ((RoutePlanNode)localObject).mDescription;
      localSearchPoi.mGuidePoint = ((RoutePlanNode)localObject).mGeoPoint;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("select_point_action", 4);
      syncAddressToCoDriver(localSearchPoi, (Bundle)localObject);
    }
  }
  
  public void goSettingFragment(int paramInt, NaviFragmentManager paramNaviFragmentManager)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_Fragment", 304);
    localBundle.putInt("select_point_action", paramInt);
    paramNaviFragmentManager.showFragment(49, localBundle);
  }
  
  public void setIsAutoUpdateDataStatus(boolean paramBoolean)
  {
    this.mIsAutoUpdateData = paramBoolean;
  }
  
  public void setNewData(boolean paramBoolean)
  {
    this.mIsNewData = paramBoolean;
  }
  
  public void showToast(Activity paramActivity, int paramInt)
  {
    TipTool.onCreateToastDialog(paramActivity, paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/logic/model/UIModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */