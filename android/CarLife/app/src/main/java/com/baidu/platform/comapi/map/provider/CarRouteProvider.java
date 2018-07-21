package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.Car;
import com.baidu.entity.pb.Car.Routes.Legs;
import com.baidu.entity.pb.Car.Routes.Legs.Steps;
import com.baidu.entity.pb.Car.Traffic.Routes.Legs;
import com.baidu.entity.pb.Car.Traffic.Routes.Legs.Steps;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CarRouteProvider
  implements RenderProvider
{
  public static final int END_NODE_STYLE = 18;
  public static final int NO_SHOW_ARROR_LINE_MAX_LEVEL = 12;
  public static final int NO_SHOW_ARROR_LINE_MIN_LEVEL = 3;
  public static final int SHOW_ARROR_LINE_MIN_LEVEL = 13;
  public static final int SHOW_ARROW_LINE_MAX_LEVEL = 22;
  public static final int START_NODE_STYLE = 17;
  public static final int STEP_NODE_OFFSET = 8;
  public static final int STEP_NODE_STYLE = 37;
  private static final String TAG = CarRouteProvider.class.getSimpleName();
  public static final int THROUGH_NODE_STYLE = 244;
  public static final int WALK_START_STYLE = 332;
  private Car.Routes.Legs.Steps endSteps;
  private boolean isFocus;
  private boolean isMultipleRoutes;
  private boolean isNodeShow = true;
  private boolean isShowITS;
  private Car mCarRoute;
  private int mId;
  private JsonBuilder mJsonBuilder;
  private int mNodeCount;
  private List<List<Integer>> mRoadTypeList;
  private CarRouteCache mRouteCache;
  private ProviderUtils.RouteState mState;
  private List<Integer> mWalkSpathList;
  
  public CarRouteProvider(Car paramCar)
  {
    this.mCarRoute = paramCar;
    this.mRouteCache = new CarRouteCache();
    this.mState = ProviderUtils.RouteState.ENTIRE;
    this.isFocus = true;
    this.isShowITS = false;
    this.isMultipleRoutes = false;
    this.mWalkSpathList = new ArrayList();
    this.mRoadTypeList = new ArrayList();
  }
  
  public CarRouteProvider(Car paramCar, int paramInt)
  {
    this(paramCar);
    this.mId = paramInt;
    this.isMultipleRoutes = true;
  }
  
  private void addFocusPath(CarRouteCache.RouteData paramRouteData, int paramInt1, int paramInt2)
  {
    if (hasITS(paramRouteData, paramInt1))
    {
      addITSPath(paramRouteData, paramInt1, paramInt2);
      return;
    }
    if ((((Integer)((List)this.mRoadTypeList.get(paramInt1)).get(paramInt2)).intValue() & 0x1) == 0)
    {
      addNoITSPath(paramRouteData, paramInt1, paramInt2);
      return;
    }
    addInternalRoadPath(((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList(), true);
  }
  
  private void addHeadStepNode(List<Car.Routes.Legs.Steps> paramList)
  {
    if (!paramList.isEmpty())
    {
      paramList = (Car.Routes.Legs.Steps)paramList.get(0);
      addOneRouteStop(paramList.getSstartLocationList(), paramList.getStartInstructions(), paramList.getDirection());
    }
  }
  
  private void addITSPath(CarRouteCache.RouteData paramRouteData, int paramInt1, int paramInt2)
  {
    List localList2 = ((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList();
    List localList3 = ((Car.Traffic.Routes.Legs)paramRouteData.trafficLegs.get(paramInt1)).getSteps(paramInt2).getEndList();
    List localList1 = ((Car.Traffic.Routes.Legs)paramRouteData.trafficLegs.get(paramInt1)).getSteps(paramInt2).getStatusList();
    localList2 = ProviderUtils.splitPath(localList2, localList3);
    if ((((Integer)((List)this.mRoadTypeList.get(paramInt1)).get(paramInt2)).intValue() & 0x1) == 0)
    {
      if (localList2.size() == localList1.size())
      {
        paramInt1 = 0;
        while (paramInt1 < localList2.size())
        {
          addITSStyle((List)localList2.get(paramInt1), ((Integer)localList1.get(paramInt1)).intValue());
          paramInt1 += 1;
        }
      }
    }
    else {
      addInternalRoadPath(((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList(), true);
    }
  }
  
  private void addITSStyle(List<Integer> paramList, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      addOnePath(paramList, 123, 124, 156, 157);
      return;
    case 1: 
      addOnePath(paramList, 73, 77, 160, 161);
      return;
    case 2: 
      addOnePath(paramList, 74, 78, 164, 165);
      return;
    case 3: 
      addOnePath(paramList, 75, 79, 162, 163);
      return;
    }
    addOnePath(paramList, 136, 137, 158, 159);
  }
  
  private void addInternalRoadPath(List<Integer> paramList, boolean paramBoolean)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("dash").value(1);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    if (paramBoolean) {
      addLineArrowStyle(194, 194, 195, 195);
    }
    for (;;)
    {
      this.mJsonBuilder.endObject();
      return;
      addLineArrowStyle(197, 197, 197, 197);
    }
  }
  
  private void addLineArrowStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JsonBuilder localJsonBuilder = new JsonBuilder();
      localJsonBuilder.arrayValue();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("maxl", 22);
      localJSONObject.put("minl", 13);
      localJSONObject.put("fst", paramInt4);
      localJSONObject.put("nst", paramInt3);
      localJsonBuilder.objectValue(localJSONObject.toString());
      localJSONObject = new JSONObject();
      localJSONObject.put("maxl", 12);
      localJSONObject.put("minl", 3);
      localJSONObject.put("fst", paramInt2);
      localJSONObject.put("nst", paramInt1);
      localJsonBuilder.objectValue(localJSONObject.toString());
      localJsonBuilder.endArrayValue();
      this.mJsonBuilder.key("difflevel").objectValue(localJsonBuilder.getJson());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void addMultiRouteInfo()
  {
    if (this.isMultipleRoutes)
    {
      this.mJsonBuilder.key("mcar").object();
      this.mJsonBuilder.key("id").value(this.mId);
      this.mJsonBuilder.key("status").value(this.mState.getNativeValue());
      this.mJsonBuilder.endObject();
    }
  }
  
  private void addNoITSPath(CarRouteCache.RouteData paramRouteData, int paramInt1, int paramInt2)
  {
    addOnePath(((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList(), 123, 124, 156, 157);
  }
  
  private void addNodes(CarRouteCache.RouteData paramRouteData)
  {
    if (this.isFocus)
    {
      this.mNodeCount = 1;
      addRouteStepNodes(paramRouteData);
      addRouteStartNode(paramRouteData);
      addRouteEndNode();
      addWalkStartNode();
    }
  }
  
  private void addOnePath(List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    addLineArrowStyle(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mJsonBuilder.endObject();
  }
  
  private void addOneRouteStop(List<Integer> paramList, String paramString, int paramInt)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(8);
    this.mJsonBuilder.key("nst").value(37);
    this.mJsonBuilder.key("fst").value(37);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("of").value(8);
    if (paramInt != 0) {
      this.mJsonBuilder.key("dir").value(paramInt * 30);
    }
    this.mJsonBuilder.key("tx").value(paramString);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    this.mJsonBuilder.endObject();
    this.mNodeCount += 1;
  }
  
  private void addRenderNodes()
  {
    this.mJsonBuilder.key("dataset").arrayValue();
    Iterator localIterator = this.mRouteCache.updateCacheAndGetResult(this.mCarRoute).iterator();
    while (localIterator.hasNext())
    {
      CarRouteCache.RouteData localRouteData = (CarRouteCache.RouteData)localIterator.next();
      addRoutePaths(localRouteData);
      if (this.isNodeShow) {
        addNodes(localRouteData);
      }
    }
    this.mJsonBuilder.endArrayValue();
  }
  
  private void addRouteEndNode()
  {
    if (this.endSteps != null)
    {
      this.mJsonBuilder.object();
      this.mJsonBuilder.key("ud").value("");
      this.mJsonBuilder.key("ty").value(2);
      this.mJsonBuilder.key("nst").value(18);
      this.mJsonBuilder.key("fst").value(18);
      this.mJsonBuilder.key("tx").value("终点");
      this.mJsonBuilder.key("in").value(this.mNodeCount + this.mWalkSpathList.size());
      this.mJsonBuilder.key("align").value(2);
      if (this.mWalkSpathList.size() <= 7) {
        break label321;
      }
      ArrayList localArrayList = new ArrayList();
      int k = ((Integer)this.mWalkSpathList.get(5)).intValue();
      int j = ((Integer)this.mWalkSpathList.get(6)).intValue();
      int i = 7;
      while (i < this.mWalkSpathList.size() - 1)
      {
        k += ((Integer)this.mWalkSpathList.get(i)).intValue();
        j += ((Integer)this.mWalkSpathList.get(i + 1)).intValue();
        i += 2;
      }
      localArrayList.add(Integer.valueOf(k));
      localArrayList.add(Integer.valueOf(j));
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localArrayList));
    }
    for (;;)
    {
      this.mJsonBuilder.endObject();
      this.mNodeCount += 1;
      return;
      label321:
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(this.endSteps.getSendLocationList()));
    }
  }
  
  private void addRouteLegData()
  {
    if (!this.isFocus) {
      return;
    }
    this.mJsonBuilder.key("labelset").arrayValue();
    Iterator localIterator = this.mRouteCache.updateCacheAndGetResult(this.mCarRoute).iterator();
    while (localIterator.hasNext())
    {
      CarRouteCache.RouteData localRouteData = (CarRouteCache.RouteData)localIterator.next();
      int i = 0;
      while (i < localRouteData.routeLegs.size())
      {
        int j = 0;
        while (j < ((Car.Routes.Legs)localRouteData.routeLegs.get(i)).getStepsCount())
        {
          this.mJsonBuilder.object();
          List localList = ((Car.Routes.Legs)localRouteData.routeLegs.get(i)).getSteps(j).getSpathList();
          this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localList));
          this.mJsonBuilder.key("tx").value(((Car.Routes.Legs)localRouteData.routeLegs.get(i)).getSteps(j).getUsroadname());
          this.mJsonBuilder.key("level").value(((Car.Routes.Legs)localRouteData.routeLegs.get(i)).getSteps(j).getLevel());
          this.mJsonBuilder.endObject();
          j += 1;
        }
        i += 1;
      }
    }
    this.mJsonBuilder.endArrayValue();
  }
  
  private void addRoutePaths(CarRouteCache.RouteData paramRouteData)
  {
    int i = 0;
    while (i < paramRouteData.routeLegs.size())
    {
      int j = 0;
      if (j < ((Car.Routes.Legs)paramRouteData.routeLegs.get(i)).getStepsCount())
      {
        if (this.isFocus) {
          addFocusPath(paramRouteData, i, j);
        }
        for (;;)
        {
          this.endSteps = ((Car.Routes.Legs)paramRouteData.routeLegs.get(i)).getSteps(j);
          this.mNodeCount += 1;
          j += 1;
          break;
          if (hasITS(paramRouteData, i)) {
            addUnFocusITSPath(paramRouteData, i, j);
          } else {
            addUnFocusPath(paramRouteData, i, j);
          }
        }
      }
      i += 1;
    }
    if (this.mWalkSpathList.size() > 0) {
      addWalkSPath(this.mWalkSpathList);
    }
  }
  
  private void addRouteStartNode(CarRouteCache.RouteData paramRouteData)
  {
    if ((paramRouteData != null) && (paramRouteData.routeLegs != null) && (((Car.Routes.Legs)paramRouteData.routeLegs.get(0)).getStepsCount() > 0))
    {
      paramRouteData = ((Car.Routes.Legs)paramRouteData.routeLegs.get(0)).getSteps(0);
      if (paramRouteData != null)
      {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ud").value("");
        this.mJsonBuilder.key("ty").value(1);
        this.mJsonBuilder.key("nst").value(17);
        this.mJsonBuilder.key("fst").value(17);
        this.mJsonBuilder.key("tx").value("起点");
        this.mJsonBuilder.key("in").value(0);
        this.mJsonBuilder.key("align").value(2);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramRouteData.getSstartLocationList()));
        this.mJsonBuilder.endObject();
      }
    }
  }
  
  private void addRouteStepNodes(CarRouteCache.RouteData paramRouteData)
  {
    int i = 0;
    while (i < paramRouteData.routeLegs.size())
    {
      List localList = ((Car.Routes.Legs)paramRouteData.routeLegs.get(i)).getStepsList();
      addHeadStepNode(localList);
      int j = 0;
      while (j < localList.size())
      {
        Car.Routes.Legs.Steps localSteps = (Car.Routes.Legs.Steps)localList.get(j);
        addOneRouteStop(localSteps.getSendLocationList(), localSteps.getEndInstructions(), getStepDirection(localList, j));
        j += 1;
      }
      i += 1;
    }
  }
  
  private void addUnFocusITSPath(CarRouteCache.RouteData paramRouteData, int paramInt1, int paramInt2)
  {
    List localList2 = ((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList();
    List localList3 = ((Car.Traffic.Routes.Legs)paramRouteData.trafficLegs.get(paramInt1)).getSteps(paramInt2).getEndList();
    List localList1 = ((Car.Traffic.Routes.Legs)paramRouteData.trafficLegs.get(paramInt1)).getSteps(paramInt2).getStatusList();
    if ((((Integer)((List)this.mRoadTypeList.get(paramInt1)).get(paramInt2)).intValue() & 0x1) == 0)
    {
      paramRouteData = ProviderUtils.splitPath(localList2, localList3);
      if (paramRouteData.size() == localList1.size())
      {
        paramInt1 = 0;
        while (paramInt1 < paramRouteData.size())
        {
          addUnFocusITSStyle((List)paramRouteData.get(paramInt1), ((Integer)localList1.get(paramInt1)).intValue());
          paramInt1 += 1;
        }
      }
    }
    else
    {
      addInternalRoadPath(((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList(), false);
    }
  }
  
  private void addUnFocusITSStyle(List<Integer> paramList, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      addOnePath(paramList, 189, 189, 189, 189);
      return;
    case 1: 
      addOnePath(paramList, 191, 191, 191, 191);
      return;
    case 2: 
      addOnePath(paramList, 193, 193, 193, 193);
      return;
    case 3: 
      addOnePath(paramList, 192, 192, 192, 192);
      return;
    }
    addOnePath(paramList, 190, 190, 190, 190);
  }
  
  private void addUnFocusPath(CarRouteCache.RouteData paramRouteData, int paramInt1, int paramInt2)
  {
    if ((((Integer)((List)this.mRoadTypeList.get(paramInt1)).get(paramInt2)).intValue() & 0x1) == 0)
    {
      addOnePath(((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList(), 127, 127, 127, 127);
      return;
    }
    addInternalRoadPath(((Car.Routes.Legs)paramRouteData.routeLegs.get(paramInt1)).getSteps(paramInt2).getSpathList(), false);
  }
  
  private void addWalkSPath(List<Integer> paramList)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("dash").value(1);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    addLineArrowStyle(196, 196, 196, 196);
    this.mJsonBuilder.endObject();
  }
  
  private void addWalkStartNode()
  {
    if (this.mWalkSpathList.size() > 7)
    {
      this.mJsonBuilder.object();
      this.mJsonBuilder.key("ud").value("");
      this.mJsonBuilder.key("ty").value(8);
      this.mJsonBuilder.key("nst").value(332);
      this.mJsonBuilder.key("fst").value(332);
      this.mJsonBuilder.key("tx").value("步行起点");
      this.mJsonBuilder.key("in").value(this.mNodeCount);
      this.mJsonBuilder.key("align").value(2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.mWalkSpathList.get(5));
      localArrayList.add(this.mWalkSpathList.get(6));
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localArrayList));
      this.mJsonBuilder.endObject();
    }
  }
  
  private int getStepDirection(List<Car.Routes.Legs.Steps> paramList, int paramInt)
  {
    if (paramInt < paramList.size() - 1) {
      return ((Car.Routes.Legs.Steps)paramList.get(paramInt + 1)).getDirection();
    }
    return 0;
  }
  
  private boolean hasITS(CarRouteCache.RouteData paramRouteData, int paramInt)
  {
    paramRouteData = (Car.Traffic.Routes.Legs)paramRouteData.trafficLegs.get(paramInt);
    return (this.isShowITS) && (paramRouteData != null) && (paramRouteData.getStepsCount() > 0);
  }
  
  private void resetTemporaryField()
  {
    this.mJsonBuilder = new JsonBuilder();
    this.mNodeCount = 0;
  }
  
  public void cleanFocus()
  {
    this.isFocus = false;
  }
  
  public void clearWalkPath()
  {
    this.mWalkSpathList.clear();
  }
  
  public void closeITS()
  {
    this.isShowITS = false;
  }
  
  public String getProjectionPaths()
  {
    JsonBuilder localJsonBuilder = new JsonBuilder();
    Iterator localIterator = this.mRouteCache.updateCacheAndGetResult(this.mCarRoute).iterator();
    while (localIterator.hasNext())
    {
      CarRouteCache.RouteData localRouteData = (CarRouteCache.RouteData)localIterator.next();
      int i = 0;
      while (i < localRouteData.routeLegs.size())
      {
        int j = 0;
        while (j < ((Car.Routes.Legs)localRouteData.routeLegs.get(i)).getStepsCount())
        {
          localJsonBuilder.object();
          List localList = ((Car.Routes.Legs)localRouteData.routeLegs.get(i)).getSteps(j).getSpathList();
          localJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localList));
          localJsonBuilder.endObject();
          j += 1;
        }
        i += 1;
      }
    }
    return localJsonBuilder.getJson();
  }
  
  public String getRenderData()
  {
    f.b("BUILD_JSON" + System.currentTimeMillis());
    resetTemporaryField();
    try
    {
      this.mJsonBuilder.object();
      addRenderNodes();
      addRouteLegData();
      addMultiRouteInfo();
      this.mJsonBuilder.endObject();
      f.b("BUILD_JSON" + System.currentTimeMillis());
      return this.mJsonBuilder.getJson();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public void openITS()
  {
    this.isShowITS = true;
  }
  
  public void setFocus()
  {
    this.isFocus = true;
  }
  
  public void setRoadTypeList(List<List<Integer>> paramList)
  {
    this.mRoadTypeList.clear();
    this.mRoadTypeList.addAll(paramList);
  }
  
  public void setRouteState(ProviderUtils.RouteState paramRouteState)
  {
    this.mState = paramRouteState;
  }
  
  public void setWalkPath(List<Integer> paramList)
  {
    clearWalkPath();
    this.mWalkSpathList.addAll(paramList);
  }
  
  public void showNode(boolean paramBoolean)
  {
    this.isNodeShow = paramBoolean;
  }
  
  public void updateRoute(Car paramCar)
  {
    this.mCarRoute = paramCar;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/CarRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */