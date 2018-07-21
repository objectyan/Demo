package com.baidu.navisdk.ui.routeguide.model;

import android.content.Context;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.MultiRoadConfig;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.util.Arrays;

public class RGMultiRouteModel
{
  public static final int DEFAULT_INSTANT_CLOUND_MULTI_ROUTE_LASTMILE = 1000;
  public static final int[] DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS = { 40, 150, 400 };
  public static final boolean DETAULT_INSTANT_CLOUD_MULTI_ROUTE_STATE = true;
  public static final String TAG = "RGMultiRouteModel";
  private static RGMultiRouteModel sInstance = null;
  public boolean hasSetByCloud = false;
  public boolean isAvoidTrafficStatus = false;
  public boolean isMultiRouteEnable = true;
  public boolean isSwitchButtonShowing = false;
  public int mCurRouteIndex = 0;
  public int[] mPstLabelDis = new int[3];
  public int mSelectedRouteIndex = -1;
  
  public static RGMultiRouteModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGMultiRouteModel();
    }
    return sInstance;
  }
  
  public int getLastMile()
  {
    CloudlConfigDataModel.MultiRoadConfig localMultiRoadConfig = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
    if (localMultiRoadConfig == null) {
      return 1000;
    }
    int i = localMultiRoadConfig.getLastMile();
    if (i > 0) {}
    for (;;)
    {
      return i;
      i = 1000;
    }
  }
  
  public int[] getPstLabelDis()
  {
    Object localObject;
    if (CloudlConfigDataModel.getInstance().isWebDataValid) {
      if (this.hasSetByCloud) {
        localObject = this.mPstLabelDis;
      }
    }
    for (;;)
    {
      return (int[])localObject;
      localObject = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
      if (localObject != null) {
        return ((CloudlConfigDataModel.MultiRoadConfig)localObject).getTagDistance();
      }
      localObject = BNaviModuleManager.getContext();
      if (localObject == null)
      {
        LogUtil.e("RGMultiRouteModel", "context is null");
        return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
      }
      localObject = PreferenceHelper.getInstance((Context)localObject).getString("sp_rg_instant_last_cloud_pstlabeldis_value", null);
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        LogUtil.e("RGMultiRouteModel", "labelDis is null");
        return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
      }
      try
      {
        String[] arrayOfString = ((String)localObject).substring(1, ((String)localObject).length() - 1).split(",");
        int j = arrayOfString.length;
        if (j != 3) {
          return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
        }
        int[] arrayOfInt = new int[3];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfInt;
          if (i >= j) {
            break;
          }
          arrayOfInt[i] = Integer.valueOf(arrayOfString[i].trim()).intValue();
          i += 1;
        }
        return DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS;
      }
      catch (Exception localException)
      {
        LogUtil.e("RGMultiRouteModel", "Exception labelDis");
      }
    }
  }
  
  public boolean isEnable()
  {
    if (CloudlConfigDataModel.getInstance().isWebDataValid)
    {
      if (this.hasSetByCloud) {
        return this.isMultiRouteEnable;
      }
      localObject = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
      if (localObject != null) {
        return ((CloudlConfigDataModel.MultiRoadConfig)localObject).isMultiRoadOpen();
      }
    }
    Object localObject = BNaviModuleManager.getContext();
    if (localObject != null)
    {
      LogUtil.e("RGMultiRouteModel", "context not null");
      return PreferenceHelper.getInstance((Context)localObject).getBoolean("sp_rg_instant_last_cloud_open_state", true);
    }
    LogUtil.e("RGMultiRouteModel", "context is null");
    return true;
  }
  
  public void updateMultiRouteParams()
  {
    Object localObject = CloudlConfigDataModel.getInstance().mMultiRoadConfig;
    if (localObject == null) {
      LogUtil.e("RGMultiRouteModel", "MultiRoadConfig is null");
    }
    do
    {
      return;
      this.isMultiRouteEnable = ((CloudlConfigDataModel.MultiRoadConfig)localObject).isMultiRoadOpen();
      this.mPstLabelDis = ((CloudlConfigDataModel.MultiRoadConfig)localObject).getTagDistance();
    } while ((this.mPstLabelDis == null) || (this.mPstLabelDis.length != 3));
    localObject = BNaviModuleManager.getContext();
    if (localObject != null)
    {
      PreferenceHelper.getInstance((Context)localObject).putBoolean("sp_rg_instant_last_cloud_open_state", this.isMultiRouteEnable);
      PreferenceHelper.getInstance((Context)localObject).putString("sp_rg_instant_last_cloud_pstlabeldis_value", Arrays.toString(this.mPstLabelDis));
    }
    this.hasSetByCloud = true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGMultiRouteModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */