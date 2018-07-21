package com.baidu.navisdk.hudsdk.socket;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.geolocate.ILocationChangeListener;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider.OnRGSubStatusListener;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.BCruiser.OnCruiseBeginListener;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator.OnHUDSDKNavStatusCallback;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRGEventHUDCollection
{
  private static final int ROUTE_ID_DEFAULT_VALUE = 100;
  private static BNRGEventHUDCollection mInstance;
  private boolean isInit = false;
  private SendAllClientCallback mBroadcast;
  private ILocationChangeListener mLocationChangeListener = new ILocationChangeListener()
  {
    public void onGpsStatusChange(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      BNRGEventHUDCollection.this.handleGpsStatusChange(paramAnonymousBoolean1, paramAnonymousBoolean2);
    }
    
    public void onLocationChange(LocData paramAnonymousLocData)
    {
      try
      {
        Bundle localBundle = new Bundle();
        Object localObject = RGEngineControl.getInstance().getCarGeoPoint();
        double d2;
        if (localObject != null) {
          d2 = ((GeoPoint)localObject).getLongitudeE6() / 100000.0D;
        }
        for (double d1 = ((GeoPoint)localObject).getLatitudeE6() / 100000.0D;; d1 = paramAnonymousLocData.latitude)
        {
          localObject = CoordinateTransformUtil.transferGCJ02ToWGS84(d2, d1);
          localBundle.putDouble("direction", paramAnonymousLocData.direction);
          localBundle.putDouble("longitude", ((Bundle)localObject).getDouble("LLx"));
          localBundle.putDouble("latitude", ((Bundle)localObject).getDouble("LLy"));
          paramAnonymousLocData = PacketJSONData.packetJSONData(116, localBundle);
          if (BNRGEventHUDCollection.this.mBroadcast == null) {
            break;
          }
          BNRGEventHUDCollection.this.mBroadcast.onBroadcast(paramAnonymousLocData);
          return;
          d2 = paramAnonymousLocData.longitude;
        }
        return;
      }
      catch (JSONException paramAnonymousLocData)
      {
        paramAnonymousLocData.printStackTrace();
      }
    }
    
    public void onWGS84LocationChange(LocData paramAnonymousLocData1, LocData paramAnonymousLocData2) {}
  };
  private BCruiser.OnCruiseBeginListener mOnCruiseBeginListener = new BCruiser.OnCruiseBeginListener()
  {
    public void onCruiseBegin(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = PacketJSONData.packetJSONData(110, null);
          if (BNRGEventHUDCollection.this.mBroadcast != null) {
            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(localJSONObject1);
          }
          return;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          return;
        }
        try
        {
          JSONObject localJSONObject2 = PacketJSONData.packetJSONData(111, null);
          if (BNRGEventHUDCollection.this.mBroadcast != null)
          {
            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(localJSONObject2);
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  };
  private BNavigator.OnHUDSDKNavStatusCallback mOnHUDSDKNavStatusCallback = new BNavigator.OnHUDSDKNavStatusCallback()
  {
    public void onNaviStatus(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = PacketJSONData.packetJSONData(108, null);
          if (BNRGEventHUDCollection.this.mBroadcast != null) {
            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(localJSONObject1);
          }
          BNRGEventHUDCollection.this.updateDestInfo();
          BNRGEventHUDCollection.this.updateSimpleGuideData();
          BNRGEventHUDCollection.this.updateTotalDistAndTime();
          return;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          continue;
        }
        try
        {
          JSONObject localJSONObject2 = PacketJSONData.packetJSONData(109, null);
          if (BNRGEventHUDCollection.this.mBroadcast != null)
          {
            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(localJSONObject2);
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  };
  private OnRGInfoListener mOnRGInfoListener = new OnRGInfoListener()
  {
    public void onAssistInfoHide(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateAssistInfo();
    }
    
    public void onAssistInfoShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateAssistInfo();
    }
    
    public void onAssistInfoUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateAssistInfo();
    }
    
    public void onCurRoadNameUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateCurRoadName();
    }
    
    public void onDestStreetViewDownloadSuccess(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewHide(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(3, 2);
    }
    
    public void onDestStreetViewShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(3, 0);
    }
    
    public void onDestStreetViewStartDownload(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(3, 1);
    }
    
    public void onDirectBoardHide(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(2, 2);
    }
    
    public void onDirectBoardShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(2, 0);
    }
    
    public void onDirectBoardUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(2, 1);
    }
    
    public void onGPSWeak(Message paramAnonymousMessage) {}
    
    public void onHUDUpdate(Message paramAnonymousMessage) {}
    
    public void onHighwayInfoHide(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateServiceAreaInfo();
    }
    
    public void onHighwayInfoShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateServiceAreaInfo();
    }
    
    public void onHighwayInfoUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateServiceAreaInfo();
    }
    
    public void onOtherRGInfo(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 4397: 
      case 4399: 
        for (;;)
        {
          return;
          int i = paramAnonymousMessage.arg1;
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putInt("isTunnel", i);
          try
          {
            paramAnonymousMessage = PacketJSONData.packetJSONData(118, paramAnonymousMessage);
            if (BNRGEventHUDCollection.this.mBroadcast == null) {
              continue;
            }
            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(paramAnonymousMessage);
            return;
          }
          catch (JSONException paramAnonymousMessage)
          {
            paramAnonymousMessage.printStackTrace();
            return;
          }
          i = paramAnonymousMessage.arg1;
          int j = paramAnonymousMessage.arg2;
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putInt("curLocIndex", i);
          paramAnonymousMessage.putInt("fromStartDist", j);
          try
          {
            paramAnonymousMessage = PacketJSONData.packetJSONData(119, paramAnonymousMessage);
            if (BNRGEventHUDCollection.this.mBroadcast != null)
            {
              BNRGEventHUDCollection.this.mBroadcast.onBroadcast(paramAnonymousMessage);
              return;
            }
          }
          catch (JSONException paramAnonymousMessage)
          {
            paramAnonymousMessage.printStackTrace();
            return;
          }
        }
      case 4396: 
        BNRGEventHUDCollection.this.updateRouteInfo();
        return;
      }
      BNRGEventHUDCollection.this.updateNearbyCameraInfo();
    }
    
    public void onRGSyncOperation(Message paramAnonymousMessage) {}
    
    public void onRasterExpandMapHide(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(0, 2);
    }
    
    public void onRasterExpandMapShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(0, 0);
    }
    
    public void onRasterExpandMapUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(0, 1);
    }
    
    public void onSimpleBoardHide(Message paramAnonymousMessage) {}
    
    public void onSimpleBoardShow(Message paramAnonymousMessage) {}
    
    public void onSimpleBoardUpdate(Message paramAnonymousMessage) {}
    
    public void onSimpleGuideInfoHide(Message paramAnonymousMessage) {}
    
    public void onSimpleGuideInfoShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateSimpleGuideData();
    }
    
    public void onSimpleGuideInfoUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateSimpleGuideData();
    }
    
    public void onTotalRemainDistTimeUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.updateTotalDistAndTime();
    }
    
    public void onUGCEventTipsHide() {}
    
    public void onUGCEventTipsShow() {}
    
    public void onVectorExpandMapHide(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(1, 2);
    }
    
    public void onVectorExpandMapShow(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(1, 0);
    }
    
    public void onVectorExpandMapUpdate(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.sendExpandMapData(1, 1);
    }
  };
  private BNRouteGuider.OnRGSubStatusListener mOnRGSubStatusListener = new BNRouteGuider.OnRGSubStatusListener()
  {
    public void onArriveDest(Message paramAnonymousMessage) {}
    
    public void onArriveDestNear(Message paramAnonymousMessage) {}
    
    public void onReRouteCarFree(Message paramAnonymousMessage)
    {
      BNRGEventHUDCollection.this.notifyCarFree();
    }
    
    public void onReRouteComplete(Message paramAnonymousMessage)
    {
      try
      {
        paramAnonymousMessage = PacketJSONData.packetJSONData(113, null);
        if (BNRGEventHUDCollection.this.mBroadcast != null) {
          BNRGEventHUDCollection.this.mBroadcast.onBroadcast(paramAnonymousMessage);
        }
        BNRGEventHUDCollection.this.notifyCarFree();
        BNRGEventHUDCollection.this.updateDestInfo();
        BNRGEventHUDCollection.this.updateSimpleGuideData();
        BNRGEventHUDCollection.this.updateTotalDistAndTime();
        return;
      }
      catch (JSONException paramAnonymousMessage)
      {
        for (;;)
        {
          paramAnonymousMessage.printStackTrace();
        }
      }
    }
    
    public void onRoutePlanYawing(Message paramAnonymousMessage)
    {
      try
      {
        paramAnonymousMessage = PacketJSONData.packetJSONData(112, null);
        if (BNRGEventHUDCollection.this.mBroadcast != null) {
          BNRGEventHUDCollection.this.mBroadcast.onBroadcast(paramAnonymousMessage);
        }
        return;
      }
      catch (JSONException paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
      }
    }
  };
  private int mRouteID = 100;
  
  public static BNRGEventHUDCollection getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNRGEventHUDCollection();
    }
    return mInstance;
  }
  
  private void handleGpsStatusChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = PacketJSONData.packetJSONData(107, null);
        if (this.mBroadcast != null) {
          this.mBroadcast.onBroadcast(localJSONObject1);
        }
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      try
      {
        JSONObject localJSONObject2 = PacketJSONData.packetJSONData(106, null);
        if (this.mBroadcast != null)
        {
          this.mBroadcast.onBroadcast(localJSONObject2);
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
  
  private void notifyCarFree()
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetJSONData(117, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void sendExpandMapData(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetEnlargeRoad(paramInt1, paramInt2);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void updateAssistInfo()
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetJSONData(102, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void updateCurRoadName()
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetJSONData(104, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void updateDestInfo()
  {
    Object localObject2 = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    if (localObject2 == null) {}
    for (;;)
    {
      return;
      Object localObject1 = ((RoutePlanModel)localObject2).getEndNode();
      int i = ((RoutePlanModel)localObject2).getTotalDistanceInt();
      localObject2 = new Bundle();
      localObject1 = CoordinateTransformUtil.transferGCJ02ToWGS84(((RoutePlanNode)localObject1).getLongitudeE6() / 100000.0D, ((RoutePlanNode)localObject1).getLatitudeE6() / 100000.0D);
      ((Bundle)localObject2).putInt("totalDist", i);
      ((Bundle)localObject2).putDouble("longitude", ((Bundle)localObject1).getDouble("LLx"));
      ((Bundle)localObject2).putDouble("latitude", ((Bundle)localObject1).getDouble("LLy"));
      try
      {
        localObject1 = PacketJSONData.packetJSONData(115, (Bundle)localObject2);
        if (this.mBroadcast != null)
        {
          this.mBroadcast.onBroadcast((JSONObject)localObject1);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void updateNearbyCameraInfo()
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetJSONData(121, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void updateRouteInfo()
  {
    updateRouteID();
    try
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("routeId", this.mRouteID);
      localObject = PacketJSONData.packetJSONData(120, (Bundle)localObject);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast((JSONObject)localObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void updateServiceAreaInfo()
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetJSONData(101, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void updateSimpleGuideData()
  {
    try
    {
      localJSONObject = PacketJSONData.packetJSONData(100, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = PacketJSONData.packetJSONData(104, null);
          if (this.mBroadcast != null) {
            this.mBroadcast.onBroadcast(localJSONObject);
          }
          return;
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        localJSONException1 = localJSONException1;
        localJSONException1.printStackTrace();
      }
    }
  }
  
  private void updateTotalDistAndTime()
  {
    try
    {
      JSONObject localJSONObject = PacketJSONData.packetJSONData(103, null);
      if (this.mBroadcast != null) {
        this.mBroadcast.onBroadcast(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void init(Context paramContext, SendAllClientCallback paramSendAllClientCallback)
  {
    if (this.isInit) {
      return;
    }
    this.isInit = true;
    this.mBroadcast = paramSendAllClientCallback;
    BNRouteGuider.getInstance().addRGInfoListeners(this.mOnRGInfoListener);
    BNRouteGuider.getInstance().addRGSubStatusListener(this.mOnRGSubStatusListener);
    BCruiser.getInstance().addRGInfoListeners(this.mOnRGInfoListener);
    BNSysLocationManager.getInstance().startNaviLocate(paramContext);
    BNSysLocationManager.getInstance().addLocationListener(this.mLocationChangeListener);
    BNavigator.getInstance().setOnHUDSDKnavStatusCallback(this.mOnHUDSDKNavStatusCallback);
    BCruiser.getInstance().addOnCruiseBeginListener(this.mOnCruiseBeginListener);
    JNIGuidanceControl.getInstance().SetHUDRouteGuideType(8191);
  }
  
  public void unInit()
  {
    if (!this.isInit) {
      return;
    }
    BNRouteGuider.getInstance().removeRGSubStatusListener(this.mOnRGSubStatusListener);
    BNRouteGuider.getInstance().removeRGInfoListeners(this.mOnRGInfoListener);
    BNSysLocationManager.getInstance().removeLocationListener(this.mLocationChangeListener);
    BCruiser.getInstance().removeRGInfoListeners(this.mOnRGInfoListener);
    BNavigator.getInstance().setOnHUDSDKnavStatusCallback(null);
    BCruiser.getInstance().removeOnCruiseBeginListener(this.mOnCruiseBeginListener);
    this.isInit = false;
    JNIGuidanceControl.getInstance().SetHUDRouteGuideType(0);
  }
  
  public int updateRouteID()
  {
    this.mRouteID += 1;
    if (this.mRouteID <= 0) {
      this.mRouteID = 100;
    }
    return this.mRouteID;
  }
  
  public static abstract interface SendAllClientCallback
  {
    public abstract void onBroadcast(JSONObject paramJSONObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/socket/BNRGEventHUDCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */