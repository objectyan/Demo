package com.baidu.platform.comapi.map.provider;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.entity.pb.Bus;
import com.baidu.entity.pb.Bus.Option;
import com.baidu.entity.pb.Bus.Routes;
import com.baidu.entity.pb.Bus.Routes.Legs;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LinkColor;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LowerSteps;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LowerSteps.LowerStep;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LowerSteps.LowerStep.Vehicle;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.Vehicle;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BusRouteProvider
  implements RenderProvider
{
  public static final int BIKE_LINE_FOCUS_STYLE = 175;
  public static final int BIKE_LINE_NORMAL_STYLE = 171;
  public static final int END_NODE_STYLE = 355;
  public static final int NO_SHOW_ARROR_LINE_MAX_LEVEL = 12;
  public static final int NO_SHOW_ARROR_LINE_MIN_LEVEL = 3;
  public static final int QIUYIN_DEFAULT_COLOR = -13400577;
  public static final int QIUYIN_DEFAULT_WIDTH = 10;
  public static final int SHOW_ARROR_LINE_MIN_LEVEL = 13;
  public static final int SHOW_ARROW_LINE_MAX_LEVEL = 22;
  public static final int START_NODE_STYLE = 354;
  public static final int STEP_NODE_AIR_STYLE = 119;
  public static final int STEP_NODE_COACH_STYLE = 345;
  public static final int STEP_NODE_STYLE_FOOT = 113;
  public static final int STEP_NODE_STYLE_PRE = 15;
  public static final int STEP_NODE_TRAIN_STYLE = 120;
  private static final String TAG = BusRouteProvider.class.getSimpleName();
  private Bus.Routes.Legs.Steps.Step endStep;
  private Bus mBusRoute;
  private JsonBuilder mJsonBuilder;
  private int mNodeCount;
  private int mRouteIndex;
  
  public BusRouteProvider(Bus paramBus)
  {
    this.mBusRoute = paramBus;
    this.mRouteIndex = 0;
  }
  
  public BusRouteProvider(Bus paramBus, int paramInt)
  {
    this(paramBus);
    this.mRouteIndex = paramInt;
  }
  
  private void addITSPath(String paramString, List<Integer> paramList, List<Bus.Routes.Legs.Steps.Step.LinkColor> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList1.size())
      {
        localArrayList1.add(Integer.valueOf(((Bus.Routes.Legs.Steps.Step.LinkColor)paramList1.get(i)).getStatus()));
        localArrayList2.add(Integer.valueOf(((Bus.Routes.Legs.Steps.Step.LinkColor)paramList1.get(i)).getGeoCnt()));
        i += 1;
      }
      paramList = ProviderUtils.splitPath(paramList, localArrayList2);
      if (paramList.size() == localArrayList1.size())
      {
        i = 0;
        while (i < paramList.size())
        {
          addITSStyle(paramString, (List)paramList.get(i), ((Integer)localArrayList1.get(i)).intValue());
          i += 1;
        }
      }
    }
  }
  
  private void addITSStyle(String paramString, List<Integer> paramList, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      addOnePathImg(paramString, paramList, 123, 124, 156, 157);
      return;
    case 1: 
      addOnePathImg(paramString, paramList, 73, 77, 160, 161);
      return;
    case 2: 
      addOnePathImg(paramString, paramList, 74, 78, 164, 165);
      return;
    case 3: 
      addOnePathImg(paramString, paramList, 75, 79, 162, 163);
      return;
    }
    addOnePathImg(paramString, paramList, 136, 137, 158, 159);
  }
  
  private void addLineArrowStyle(int paramInt1, int paramInt2)
  {
    try
    {
      JsonBuilder localJsonBuilder = new JsonBuilder();
      localJsonBuilder.arrayValue();
      localJsonBuilder.objectValue(getStyleJson(paramInt1, paramInt2, 1, 13, 22).toString());
      localJsonBuilder.objectValue(getStyleJson(paramInt1, paramInt2, 0, 3, 12).toString());
      localJsonBuilder.endArrayValue();
      this.mJsonBuilder.key("difflevel").objectValue(localJsonBuilder.getJson());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void addLineArrowStyleImg(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private void addLowStepPath(Bus.Routes.Legs.Steps.Step.LowerSteps paramLowerSteps, int paramInt)
  {
    paramLowerSteps = paramLowerSteps.getLowerStep(0);
    if (paramLowerSteps.getSpathCount() < 2) {
      return;
    }
    if (isFootLine(paramInt, paramLowerSteps.getType()))
    {
      addOnePath(paramLowerSteps.getInstructions(), paramLowerSteps.getSpathList(), 10, -13400577, 1);
      return;
    }
    addOnePathImg(paramLowerSteps.getInstructions(), paramLowerSteps.getSpathList(), 123, 124, 156, 157);
  }
  
  private void addLowSteps(Bus.Routes.Legs.Steps.Step paramStep)
  {
    int i = 0;
    if (i < paramStep.getLowerStepsCount())
    {
      Bus.Routes.Legs.Steps.Step.LowerSteps.LowerStep localLowerStep = paramStep.getLowerSteps(i).getLowerStep(0);
      switch (paramStep.getType())
      {
      }
      for (;;)
      {
        this.mNodeCount += 1;
        i += 1;
        break;
        addOneLowStep(localLowerStep, localLowerStep.getSstartLocationList());
        addOneLowStep(localLowerStep, localLowerStep.getSendLocationList());
      }
    }
  }
  
  private void addOneLowStep(Bus.Routes.Legs.Steps.Step.LowerSteps.LowerStep paramLowerStep, List<Integer> paramList)
  {
    if (paramLowerStep.getType() == 3) {
      if (paramLowerStep.getVehicle().getType() != 1) {
        break label167;
      }
    }
    label167:
    for (int i = 16;; i = 15)
    {
      this.mJsonBuilder.object();
      this.mJsonBuilder.key("ty").value(3);
      this.mJsonBuilder.key("ud").value("");
      this.mJsonBuilder.key("nst").value(i);
      this.mJsonBuilder.key("fst").value(i);
      this.mJsonBuilder.key("in").value(this.mNodeCount);
      this.mJsonBuilder.key("of").value(11);
      this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(paramLowerStep.getInstructions()));
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
      this.mJsonBuilder.endObject();
      return;
    }
  }
  
  private void addOnePath(String paramString, List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(paramString));
    if (paramInt3 == 0)
    {
      this.mJsonBuilder.key("dash").value(paramInt3);
      this.mJsonBuilder.key("style").objectValue(getStyleJson(paramInt1, paramInt2, 1, 0, 100).toString());
      addLineArrowStyle(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.mJsonBuilder.endObject();
      return;
      this.mJsonBuilder.key("dash").value(paramInt3);
      this.mJsonBuilder.key("style").objectValue(getFootStyleJson().toString());
    }
  }
  
  private void addOnePathImg(String paramString, List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(paramString));
    addLineArrowStyleImg(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mJsonBuilder.endObject();
  }
  
  private void addOneVehiclePath(Bus.Routes.Legs.Steps.Step paramStep)
  {
    if (paramStep.getSpathCount() < 2) {
      return;
    }
    if (paramStep.getType() == 5)
    {
      addOnePath(paramStep.getInstructions(), paramStep.getSpathList(), 10, -13400577, 1);
      return;
    }
    if (paramStep.getType() == 7)
    {
      addOnePathImg(paramStep.getInstructions(), paramStep.getSpathList(), 171, 175, 171, 175);
      return;
    }
    if ((paramStep.getType() == 3) && (paramStep.hasVehicle()) && (paramStep.getVehicle().getType() == 1))
    {
      addOnePath(paramStep.getInstructions(), paramStep.getSpathList(), 7, getRealColor(paramStep.getVehicle().getLineColor()), 0);
      return;
    }
    if (paramStep.getType() == 1)
    {
      addOnePathImg(paramStep.getInstructions(), paramStep.getSpathList(), 207, 207, 207, 207);
      return;
    }
    if (paramStep.getType() == 2)
    {
      addOnePathImg(paramStep.getInstructions(), paramStep.getSpathList(), 205, 205, 205, 205);
      return;
    }
    if (paramStep.getType() == 6)
    {
      addOnePathImg(paramStep.getInstructions(), paramStep.getSpathList(), 206, 206, 206, 206);
      return;
    }
    if (hasITS(paramStep))
    {
      addITSPath(paramStep.getInstructions(), paramStep.getSpathList(), paramStep.getLinkColorList());
      return;
    }
    addOnePathImg(paramStep.getInstructions(), paramStep.getSpathList(), 123, 124, 123, 124);
  }
  
  private void addOneVehicleStep(Bus.Routes.Legs.Steps.Step paramStep, List<Integer> paramList, int paramInt)
  {
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(3);
    this.mJsonBuilder.key("ud").value("");
    this.mJsonBuilder.key("nst").value(paramInt);
    this.mJsonBuilder.key("fst").value(paramInt);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("of").value(11);
    this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(paramStep.getInstructions()));
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramList));
    this.mJsonBuilder.endObject();
  }
  
  private void addOneVehicleSteps(Bus.Routes.Legs.Steps.Step paramStep, List<Integer> paramList)
  {
    int j = 1;
    int k = 15;
    boolean bool = this.mBusRoute.getOption().hasCty();
    int i = k;
    switch (paramStep.getType())
    {
    default: 
      i = k;
    }
    for (;;)
    {
      addOneVehicleStep(paramStep, paramList, i);
      do
      {
        do
        {
          return;
        } while (!bool);
        if (paramStep.getVehicle().getType() == 1) {}
        for (i = j;; i = 0)
        {
          i += 15;
          break;
        }
      } while (!bool);
      i = 113;
      continue;
      i = 119;
      continue;
      i = 120;
      continue;
      i = 345;
    }
  }
  
  private void addRouteEndNode()
  {
    if (this.endStep != null)
    {
      this.mJsonBuilder.object();
      this.mJsonBuilder.key("ud").value("");
      this.mJsonBuilder.key("ty").value(2);
      this.mJsonBuilder.key("nst").value(355);
      this.mJsonBuilder.key("fst").value(355);
      this.mJsonBuilder.key("tx").value("终点");
      this.mJsonBuilder.key("in").value(this.mNodeCount);
      this.mJsonBuilder.key("align").value(2);
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(this.endStep.getSendLocationList()));
      this.mJsonBuilder.endObject();
    }
  }
  
  private void addRoutePaths(Bus.Routes.Legs paramLegs)
  {
    paramLegs = paramLegs.getStepsList().iterator();
    while (paramLegs.hasNext())
    {
      Bus.Routes.Legs.Steps.Step localStep = ((Bus.Routes.Legs.Steps)paramLegs.next()).getStep(0);
      if (localStep.getLowerStepsCount() > 0)
      {
        Iterator localIterator = localStep.getLowerStepsList().iterator();
        while (localIterator.hasNext())
        {
          addLowStepPath((Bus.Routes.Legs.Steps.Step.LowerSteps)localIterator.next(), localStep.getType());
          this.mNodeCount += 1;
        }
      }
      else
      {
        addOneVehiclePath(localStep);
        this.mNodeCount += 1;
      }
    }
  }
  
  private void addRouteStartNode(Bus.Routes.Legs paramLegs)
  {
    if ((paramLegs != null) && (paramLegs.getStepsCount() > 0))
    {
      paramLegs = paramLegs.getStepsList();
      if (((Bus.Routes.Legs.Steps)paramLegs.get(0)).getStepCount() > 0)
      {
        paramLegs = ((Bus.Routes.Legs.Steps)paramLegs.get(0)).getStep(0);
        if (paramLegs != null)
        {
          this.mJsonBuilder.object();
          this.mJsonBuilder.key("ud").value("");
          this.mJsonBuilder.key("ty").value(1);
          this.mJsonBuilder.key("nst").value(354);
          this.mJsonBuilder.key("fst").value(354);
          this.mJsonBuilder.key("tx").value("起点");
          this.mJsonBuilder.key("in").value(0);
          this.mJsonBuilder.key("align").value(2);
          this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(paramLegs.getSstartLocationList()));
          this.mJsonBuilder.endObject();
        }
      }
    }
  }
  
  private void addRouteSteps(Bus.Routes.Legs paramLegs)
  {
    paramLegs = paramLegs.getStepsList().iterator();
    if (paramLegs.hasNext())
    {
      Bus.Routes.Legs.Steps.Step localStep = ((Bus.Routes.Legs.Steps)paramLegs.next()).getStep(0);
      this.endStep = localStep;
      if (localStep.getLowerStepsCount() > 0) {
        addLowSteps(localStep);
      }
      for (;;)
      {
        this.mNodeCount += 1;
        break;
        addOneVehicleSteps(localStep, localStep.getSstartLocationList());
        addOneVehicleSteps(localStep, localStep.getSendLocationList());
      }
    }
  }
  
  private int getRealColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -13400577;
    }
    if (paramString.startsWith("0x")) {
      return Color.parseColor(paramString.replace("0x", "#"));
    }
    return rgbToAbgr(Color.parseColor(paramString));
  }
  
  private boolean hasITS(Bus.Routes.Legs.Steps.Step paramStep)
  {
    return (paramStep != null) && (paramStep.getLinkColorCount() > 0);
  }
  
  private boolean isFootLine(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 5) || ((paramInt1 == 3) && (paramInt2 == 5));
  }
  
  private Bus.Routes.Legs mergeLegs()
  {
    Bus.Routes.Legs localLegs = new Bus.Routes.Legs();
    if ((this.mRouteIndex > -1) && (this.mBusRoute != null) && (this.mBusRoute.getRoutesCount() > this.mRouteIndex) && (this.mBusRoute.getRoutes(this.mRouteIndex) != null))
    {
      Iterator localIterator = this.mBusRoute.getRoutes(this.mRouteIndex).getLegsList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((Bus.Routes.Legs)localIterator.next()).getStepsList();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localLegs.addSteps((Bus.Routes.Legs.Steps)((Iterator)localObject).next());
          }
        }
      }
    }
    return localLegs;
  }
  
  private void resetTemporaryField()
  {
    this.mJsonBuilder = new JsonBuilder();
    this.mNodeCount = 0;
  }
  
  private int rgbToAbgr(int paramInt)
  {
    return 0xFF000000 | (paramInt & 0xFF) << 16 | 0xFF00 & paramInt | (0xFF0000 & paramInt) >> 16;
  }
  
  public JSONObject getFootStyleJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dashsty", 1);
      localJSONObject.put("width", 10);
      localJSONObject.put("smooth", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String getRenderData()
  {
    resetTemporaryField();
    Bus.Routes.Legs localLegs = mergeLegs();
    if (localLegs != null) {}
    try
    {
      this.mJsonBuilder.object().key("dataset").arrayValue();
      addRoutePaths(localLegs);
      addRouteStartNode(localLegs);
      addRouteSteps(localLegs);
      addRouteEndNode();
      this.mJsonBuilder.endArrayValue().endObject();
      return this.mJsonBuilder.getJson();
    }
    catch (Exception localException)
    {
      f.a(TAG, "getRenderData error", localException);
    }
    return "";
  }
  
  public int getRouteIndex()
  {
    return this.mRouteIndex;
  }
  
  public JSONObject getStyleJson(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("color", paramInt2);
      localJSONObject.put("arrow", paramInt3);
      localJSONObject.put("smooth", 1);
      localJSONObject.put("minl", paramInt4);
      localJSONObject.put("maxl", paramInt5);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void setRouteIndex(int paramInt)
  {
    this.mRouteIndex = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/BusRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */