package com.baidu.baidunavis.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class NavDrivingCarController
{
  public static final String TAG = NavDrivingCarController.class.getSimpleName();
  private static NavDrivingCarController sInstance = null;
  public boolean hasYawRouteMsg = false;
  private boolean isDrvingCar = false;
  
  public static NavDrivingCarController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavDrivingCarController();
    }
    return sInstance;
  }
  
  public void getMapCarPoint(LocData paramLocData)
  {
    if ((NavCommonFuncModel.getInstance().mIsAppForeground) && (this.isDrvingCar))
    {
      if (paramLocData != null) {
        BNExtGPSLocationManager.getInstance().triggerGPSDataChangeForDriving(paramLocData);
      }
      paramLocData = BNRoutePlaner.getInstance().getMapVehiclePos();
      if ((paramLocData != null) && (paramLocData.getDouble("map_carpoint_x") > 0.0D) && (paramLocData.getDouble("map_carpoint_y") > 0.0D))
      {
        localObject = BaiduNaviManager.getInstance().getMapHandler();
        if (localObject != null)
        {
          localObject = ((Handler)localObject).obtainMessage(3010);
          if (localObject != null)
          {
            ((Message)localObject).obj = paramLocData;
            ((Message)localObject).sendToTarget();
          }
        }
      }
    }
    while (!NavCommonFuncModel.getInstance().mIsAppForeground)
    {
      Object localObject;
      return;
    }
  }
  
  public boolean isDrvingCar()
  {
    return this.isDrvingCar;
  }
  
  public int refreshRouteForDrivingCar()
  {
    return BNRouteGuider.getInstance().calcOtherRoute(1, 0);
  }
  
  public boolean selectRoute(String paramString, boolean paramBoolean)
  {
    NavLogUtils.e(TAG, "NavDrivingCar===selectRoute= startDriv : " + paramBoolean);
    if (this.hasYawRouteMsg)
    {
      this.hasYawRouteMsg = false;
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("Driver.selectRoute", null)new BNWorkerConfig
      {
        protected String execute()
        {
          Object localObject = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf();
          NavLogUtils.e(TAG, "NavDrivingCar===NE_RoutePlan_Driving_Car_ROUTE_REFRESH routePB.lenth=");
          Bundle localBundle = new Bundle();
          localBundle.putByteArray("pb_data", (byte[])localObject);
          localBundle.putInt("route_refresh_reason", 2);
          localObject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3020);
          ((Message)localObject).obj = localBundle;
          ((Message)localObject).sendToTarget();
          return null;
        }
      }, new BNWorkerConfig(100, 0), 1000L);
    }
    return BNRoutePlaner.getInstance().selectRouteForDriving(paramString);
  }
  
  public boolean startDrivingCar()
  {
    NavLogUtils.e(TAG, "NavDrivingCar===startDrivingCar= isDrvingCar : " + this.isDrvingCar);
    if (this.isDrvingCar) {
      return true;
    }
    BNRouteGuider.getInstance().setLocateMode(1);
    if (BNRoutePlaner.getInstance().startDrivingCar())
    {
      this.isDrvingCar = true;
      return true;
    }
    return false;
  }
  
  public boolean stopDrivingCar()
  {
    NavLogUtils.e(TAG, "NavDrivingCar===stopDrivingCar= isDrvingCar : " + this.isDrvingCar);
    if (!this.isDrvingCar) {
      return true;
    }
    if (BNRoutePlaner.getInstance().stopDrivingCar())
    {
      this.isDrvingCar = false;
      return true;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavDrivingCarController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */