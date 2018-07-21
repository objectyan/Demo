package com.baidu.navisdk.ui.routeguide.control;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class RGEngineControl
{
  private static final String TAG = "RouteGuide";
  private static volatile RGEngineControl me = null;
  private boolean mManualSound;
  private boolean mbForbidManualSoundWhenSilence = false;
  
  public static void destory()
  {
    if (me != null) {}
    try
    {
      if (me != null) {
        me.dispose();
      }
      me = null;
      return;
    }
    finally {}
  }
  
  private void dispose() {}
  
  public static RGEngineControl getInstance()
  {
    if (me == null) {}
    try
    {
      if (me == null) {
        me = new RGEngineControl();
      }
      return me;
    }
    finally {}
  }
  
  private boolean reCalcRoute(int paramInt)
  {
    LogUtil.e("RouteGuide", "reCalcRoute");
    BNavigator.getInstance().resetWithReCalcRoute();
    Object localObject = getCurrentGeoPoint();
    if ((localObject == null) || (!((GeoPoint)localObject).isValid())) {
      return false;
    }
    RoutePlanNode localRoutePlanNode2 = new RoutePlanNode((GeoPoint)localObject, 3, null, null);
    localRoutePlanNode2.mNodeType = 3;
    localObject = RoutePlanModel.sNavNodeList;
    RoutePlanNode localRoutePlanNode1 = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getEndNode();
    if (localRoutePlanNode1 == null) {
      return false;
    }
    localRoutePlanNode1.mNodeType = 1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localRoutePlanNode2);
    if ((localObject != null) && (((ArrayList)localObject).size() >= 3))
    {
      int i = 1;
      while (i < ((ArrayList)localObject).size() - 1)
      {
        localRoutePlanNode2 = (RoutePlanNode)((ArrayList)localObject).get(i);
        if (localRoutePlanNode2 != null) {
          localArrayList.add(localRoutePlanNode2);
        }
        i += 1;
      }
    }
    localArrayList.add(localRoutePlanNode1);
    BNRoutePlaner.getInstance().setComeFrom(2);
    BNRoutePlaner.getInstance().setEntry(2);
    BNRoutePlaner.getInstance().setGuideEndType(1);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, paramInt);
    RGNotificationController.getInstance().hideAllView(false, false);
    return true;
  }
  
  public boolean addViaPtToCalcRoute(GeoPoint paramGeoPoint, String paramString)
  {
    Object localObject = getCurrentGeoPoint();
    if ((localObject == null) || (!((GeoPoint)localObject).isValid())) {
      return false;
    }
    localObject = new RoutePlanNode((GeoPoint)localObject, 3, null, null);
    paramGeoPoint = new RoutePlanNode(paramGeoPoint, 1, null, null);
    paramGeoPoint.mName = paramString;
    paramString = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getEndNode();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(paramGeoPoint);
    localArrayList.add(paramString);
    ((RoutePlanNode)localObject).mNodeType = 3;
    paramGeoPoint.mNodeType = 1;
    if (paramString != null) {
      paramString.mNodeType = 1;
    }
    BNRoutePlaner.getInstance().setGuideEndType(1);
    BNRoutePlaner.getInstance().setComeFrom(2);
    BNRoutePlaner.getInstance().setEntry(2);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, 0);
    return true;
  }
  
  public void disableManuSound()
  {
    this.mManualSound = false;
  }
  
  public void enableManualSound()
  {
    this.mManualSound = true;
  }
  
  public GeoPoint getCarGeoPoint()
  {
    GeoPoint localGeoPoint = new GeoPoint();
    Object localObject = new int[1];
    localObject[0] = 0;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    if ((BNRouteGuider.getInstance().getCarPoint((int[])localObject, arrayOfInt)) && (localObject[0] != 0) && (arrayOfInt[0] != 0))
    {
      LogUtil.e("RouteGuide", "getCarGeoPoint. Engine(guidance_control) value is valid");
      localGeoPoint.setLongitudeE6(localObject[0]);
      localGeoPoint.setLatitudeE6(arrayOfInt[0]);
    }
    for (;;)
    {
      if (localGeoPoint != null)
      {
        localObject = localGeoPoint;
        if (localGeoPoint.isValid()) {}
      }
      else
      {
        localObject = BNLocationManagerProxy.getInstance().getLastValidLocation();
      }
      return (GeoPoint)localObject;
      LogUtil.e("RouteGuide", "getCarGeoPoint. Engine(guidance_control) value is valid, set LastValidLocation as car point.");
      localGeoPoint = BNSysLocationManager.getInstance().getLastValidLocation();
    }
  }
  
  public GeoPoint getCurrentGeoPoint()
  {
    new GeoPoint();
    Object localObject2 = BNSysLocationManager.getInstance().getLastValidLocation();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((GeoPoint)localObject2).isValid()) {}
    }
    else
    {
      localObject1 = BNLocationManagerProxy.getInstance().getLastValidLocation();
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((GeoPoint)localObject1).isValid()) {}
    }
    else
    {
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 0;
      int[] arrayOfInt2 = new int[1];
      arrayOfInt2[0] = 0;
      localObject2 = localObject1;
      if (BNRouteGuider.getInstance().getCarPoint(arrayOfInt1, arrayOfInt2))
      {
        localObject2 = localObject1;
        if (arrayOfInt1[0] != 0)
        {
          localObject2 = localObject1;
          if (arrayOfInt2[0] != 0)
          {
            LogUtil.e("RouteGuide", "getCarGeoPoint. Engine(guidance_control) value is valid");
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new GeoPoint();
            }
            ((GeoPoint)localObject2).setLongitudeE6(arrayOfInt1[0]);
            ((GeoPoint)localObject2).setLatitudeE6(arrayOfInt2[0]);
          }
        }
      }
    }
    return (GeoPoint)localObject2;
  }
  
  public int getFirstRemainDist()
  {
    return ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getFirstRemainDist();
  }
  
  public String getFirstRoadName()
  {
    String str2 = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getFirstRoadName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!StringUtils.isEmpty(str2)) {}
    }
    else
    {
      LogUtil.e("RouteGuide", "ERROR: current RoadName = null");
      str1 = JarUtils.getResources().getString(1711669364);
    }
    return str1;
  }
  
  public int getFirstTurnType()
  {
    return ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getFirstTurnType();
  }
  
  public int getNodeNum()
  {
    return ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getNodeNum();
  }
  
  public int getTotalDistance()
  {
    return ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getTotalDistanceInt();
  }
  
  public int getTotalTime()
  {
    return ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getTotalTimeInt();
  }
  
  public boolean isViaPoint(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {}
    RoutePlanNode localRoutePlanNode;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          return false;
          localObject = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getViaNodeList();
        } while ((localObject == null) || (((ArrayList)localObject).size() < 1));
        localObject = ((ArrayList)localObject).iterator();
      }
      localRoutePlanNode = (RoutePlanNode)((Iterator)localObject).next();
    } while ((localRoutePlanNode.mGeoPoint == null) || (!localRoutePlanNode.mGeoPoint.equals(paramGeoPoint)));
    return true;
  }
  
  public boolean manualPlaySound(Context paramContext)
  {
    if ((this.mManualSound) && (!this.mbForbidManualSoundWhenSilence))
    {
      LogUtil.e("RouteGuide", "manualPlaySound");
      return BNRoutePlaner.getInstance().ManualPlaySound();
    }
    return false;
  }
  
  public boolean reCalcRoute()
  {
    return reCalcRoute(0);
  }
  
  public boolean reCalcRouteWhenFail()
  {
    LogUtil.e("RouteGuide", "reCalcRouteWhenFail");
    BNavigator.getInstance().resetWithReCalcRoute();
    ArrayList localArrayList = RoutePlanModel.sNavNodeList;
    RoutePlanModel localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    RoutePlanNode localRoutePlanNode = localRoutePlanModel.getEndNode();
    Object localObject2 = null;
    GeoPoint localGeoPoint = getCurrentGeoPoint();
    Object localObject1 = localObject2;
    if (localGeoPoint != null)
    {
      localObject1 = localObject2;
      if (localGeoPoint.isValid()) {
        localObject1 = new RoutePlanNode(localGeoPoint, 3, null, null);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localRoutePlanModel.getStartNode();
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    if ((localArrayList != null) && (localArrayList.size() >= 3))
    {
      int i = 1;
      while (i < localArrayList.size() - 1)
      {
        localObject2 = (RoutePlanNode)localArrayList.get(i);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        i += 1;
      }
    }
    ((ArrayList)localObject1).add(localRoutePlanNode);
    BNRoutePlaner.getInstance().setComeFrom(2);
    BNRoutePlaner.getInstance().setEntry(2);
    BNRoutePlaner.getInstance().setGuideEndType(1);
    BNRoutePlaner.getInstance().setPointsToCalcRoute((ArrayList)localObject1, 0);
    RGNotificationController.getInstance().hideAllView(false, false);
    return true;
  }
  
  public boolean setEndPtToCalcRoute(GeoPoint paramGeoPoint)
  {
    Object localObject = getCurrentGeoPoint();
    if ((localObject == null) || (!((GeoPoint)localObject).isValid())) {
      return false;
    }
    RoutePlanNode localRoutePlanNode = new RoutePlanNode((GeoPoint)localObject, 3, null, null);
    localRoutePlanNode.mNodeType = 3;
    localObject = new RoutePlanNode(paramGeoPoint, 1, null, null);
    ArrayList localArrayList = new ArrayList();
    ((RoutePlanNode)localObject).mNodeType = 1;
    localArrayList.add(localRoutePlanNode);
    paramGeoPoint = null;
    if (RoutePlanModel.sNavNodeList.size() >= 3) {
      paramGeoPoint = (RoutePlanNode)RoutePlanModel.sNavNodeList.get(1);
    }
    if (paramGeoPoint != null) {
      localArrayList.add(paramGeoPoint);
    }
    localArrayList.add(localObject);
    BNRoutePlaner.getInstance().mEndNode = ((RoutePlanNode)localObject);
    BNSettingManager.setEndNode((RoutePlanNode)localObject);
    LogUtil.e("RouteGuide", "endNode route " + BNRoutePlaner.getInstance().mEndNode.toString());
    if (BNRoutePlaner.getInstance().getGuideSceneType() != 4)
    {
      BNRoutePlaner.getInstance().setGuideSceneType(1);
      BNRoutePlaner.getInstance().setGuideEndType(0);
    }
    for (;;)
    {
      BNRoutePlaner.getInstance().setComeFrom(2);
      BNRoutePlaner.getInstance().setEntry(2);
      BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, 0);
      return true;
      BNRoutePlaner.getInstance().setGuideSceneType(4);
      BNRoutePlaner.getInstance().setGuideEndType(2);
    }
  }
  
  public void setVoiceMode(int paramInt)
  {
    if (paramInt == 2) {}
    for (this.mbForbidManualSoundWhenSilence = true;; this.mbForbidManualSoundWhenSilence = false)
    {
      BNRouteGuider.getInstance().setVoiceMode(paramInt);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RGEngineControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */