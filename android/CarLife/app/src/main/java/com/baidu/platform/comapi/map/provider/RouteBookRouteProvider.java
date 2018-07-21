package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Option;
import com.baidu.entity.pb.WalkPlan.Routes;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.Steps;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RouteBookRouteProvider
  implements RenderProvider
{
  public static final int ARR_MAXL = 22;
  public static final int ARR_MINL = 13;
  public static final int BD09MC = 1;
  public static final int END_NODE_STYLE = 18;
  public static final int FOOT_LINE_ARR_FOCUS_STYLE = 157;
  public static final int FOOT_LINE_ARR_NORMAL_STYLE = 156;
  public static final int FOOT_LINE_FOCUS_STYLE = 124;
  public static final int FOOT_LINE_NORMAL_STYLE = 123;
  public static final int GCJ02 = 0;
  public static final int MAXL = 12;
  public static final int MINL = 3;
  public static final int START_NODE_STYLE = 17;
  public static final int STEP_OFFSET = 8;
  public static final int STEP_STYLE = 37;
  private static final String TAG = RouteBookRouteProvider.class.getSimpleName();
  private static ArrayList<WalkPlan> mWalkPlanList;
  private static WalkPlan.Routes.Legs routeBookLegs;
  List<Integer> curMc = null;
  private JsonBuilder mJsonBuilder;
  private int mNodeCount;
  private int mSpathType = 0;
  List<Integer> preMc = null;
  
  public RouteBookRouteProvider(ArrayList<WalkPlan> paramArrayList)
  {
    Object localObject = null;
    mWalkPlanList = paramArrayList;
    paramArrayList = (ArrayList<WalkPlan>)localObject;
    if (mWalkPlanList != null)
    {
      paramArrayList = (ArrayList<WalkPlan>)localObject;
      if (mWalkPlanList.size() != 0) {
        paramArrayList = (WalkPlan)mWalkPlanList.get(0);
      }
    }
    if ((paramArrayList != null) && (paramArrayList.hasOption()) && (paramArrayList.getOption().hasSpathType()))
    {
      this.mSpathType = paramArrayList.getOption().getSpathType();
      return;
    }
    this.mSpathType = 0;
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
  
  private void addRoutePaths(WalkPlan.Routes.Legs paramLegs)
  {
    int i = 0;
    if (i < paramLegs.getStepsCount())
    {
      List localList = ((WalkPlan.Routes.Legs.Steps)paramLegs.getStepsList().get(i)).getSpathList();
      ComplexPt localComplexPt;
      if (localList != null)
      {
        localComplexPt = null;
        if (this.mSpathType != 0) {
          break label162;
        }
        localComplexPt = ComplexPt.createComplexPt(localList).toComplexPtGCJ2MC();
      }
      for (;;)
      {
        this.curMc = localComplexPt.toIntArray();
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(getCurrentIndex());
        addLineArrowStyle(123, 124, 156, 157);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
        this.mJsonBuilder.endObject();
        this.preMc = this.curMc;
        i += 1;
        break;
        label162:
        if (this.mSpathType == 1) {
          localComplexPt = ComplexPt.createComplexPt(localList);
        }
      }
    }
  }
  
  private int getCurrentIndex()
  {
    int i = this.mNodeCount;
    this.mNodeCount = (i + 1);
    return i;
  }
  
  private WalkPlan.Routes.Legs mergeRouteBookLegs()
  {
    routeBookLegs = new WalkPlan.Routes.Legs();
    int i = 0;
    while (i < mWalkPlanList.size())
    {
      if (((WalkPlan)mWalkPlanList.get(i)).getRoutesCount() > 0)
      {
        Iterator localIterator = ((WalkPlan)mWalkPlanList.get(i)).getRoutes(0).getLegsList().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = ((WalkPlan.Routes.Legs)localIterator.next()).getStepsList();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              WalkPlan.Routes.Legs.Steps localSteps = (WalkPlan.Routes.Legs.Steps)((Iterator)localObject).next();
              routeBookLegs.addSteps(localSteps);
            }
          }
        }
      }
      i += 1;
    }
    f.e(TAG, "mergeLegs:" + routeBookLegs.getStepsCount());
    return routeBookLegs;
  }
  
  private void resetTemporaryField()
  {
    this.mJsonBuilder = new JsonBuilder();
    this.mNodeCount = 0;
  }
  
  public String getRenderData()
  {
    resetTemporaryField();
    try
    {
      WalkPlan.Routes.Legs localLegs = mergeRouteBookLegs();
      this.mJsonBuilder.object().key("dataset").arrayValue();
      addRoutePaths(localLegs);
      this.mJsonBuilder.endArrayValue().endObject();
      f.e(TAG, "walk render json:" + this.mJsonBuilder.getJson());
      return this.mJsonBuilder.getJson();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/RouteBookRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */