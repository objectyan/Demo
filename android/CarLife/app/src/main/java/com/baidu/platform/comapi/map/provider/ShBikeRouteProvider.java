package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Option;
import com.baidu.entity.pb.WalkPlan.Option.End;
import com.baidu.entity.pb.WalkPlan.Option.Start;
import com.baidu.entity.pb.WalkPlan.Routes;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.ConnectedPois;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.Steps;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.search.convert.PBConvertUtil;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.tools.AppTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ShBikeRouteProvider
  implements RenderProvider
{
  public static final int ARR_MAXL = 22;
  public static final int ARR_MINL = 13;
  public static final int BD09MC = 1;
  public static final int END_NODE_STYLE = 18;
  public static final int FOOT_LINE_ARR_FOCUS_STYLE = 175;
  public static final int FOOT_LINE_ARR_NORMAL_STYLE = 171;
  public static final int FOOT_LINE_FOCUS_STYLE = 175;
  public static final int FOOT_LINE_NORMAL_STYLE = 171;
  public static final int GCJ02 = 0;
  public static final int MAXL = 12;
  public static final int MINL = 3;
  public static final int START_NODE_STYLE = 17;
  public static final int STEP_OFFSET = 8;
  public static final int STEP_STYLE = 37;
  private static final String TAG = ShBikeRouteProvider.class.getSimpleName();
  public static final int TEN_THOUSAND = 100000;
  List<Integer> curMc = null;
  public boolean mHasIndoor = false;
  private JsonBuilder mJsonBuilder;
  private int mNodeCount;
  private int mSpathType = 0;
  private WalkPlan mWalkRoute;
  List<Integer> preMc = null;
  
  public ShBikeRouteProvider(WalkPlan paramWalkPlan)
  {
    this.mWalkRoute = paramWalkPlan;
    if ((paramWalkPlan != null) && (paramWalkPlan.hasOption()) && (paramWalkPlan.getOption().hasSpathType()))
    {
      this.mSpathType = paramWalkPlan.getOption().getSpathType();
      return;
    }
    this.mSpathType = 0;
  }
  
  private void addEndDashRoutes()
  {
    f.e("tag", "addEndDashRoutes");
    Object localObject = getWalkPlanEndPoint(this.mWalkRoute);
    int i;
    int j;
    if (localObject != null)
    {
      i = ((Point)localObject).getIntX();
      j = ((Point)localObject).getIntY();
      if ((i != 0) && (j != 0)) {
        break label39;
      }
    }
    label39:
    do
    {
      do
      {
        return;
        localObject = ComplexPt.createComplexPt(this.preMc);
      } while ((localObject == null) || (((ComplexPt)localObject).isEmpty()));
      localObject = (ArrayList)((ComplexPt)localObject).mGeoPt.get(((ComplexPt)localObject).mGeoPt.size() - 1);
    } while (AppTools.getDistanceByMc((Point)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1), new Point(i, j)) < 2.0D);
    localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    ((List)localObject).add(Integer.valueOf(2));
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    this.curMc = ((List)localObject);
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("nst").value(208);
    this.mJsonBuilder.key("fst").value(208);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
    this.mJsonBuilder.endObject();
  }
  
  private boolean addEndDashRoutes4Indoor()
  {
    f.e("tag", "addEndDashRoutes4Indoor");
    Object localObject = getDoorLoc(2);
    int i;
    int j;
    if (localObject != null)
    {
      i = ((Integer)((List)localObject).get(0)).intValue();
      j = ((Integer)((List)localObject).get(1)).intValue();
      if ((i == 0) || (j == 0)) {
        return false;
      }
    }
    else
    {
      return false;
    }
    localObject = ComplexPt.createComplexPt(this.preMc);
    if ((localObject != null) && (!((ComplexPt)localObject).isEmpty()))
    {
      localObject = (ArrayList)((ComplexPt)localObject).mGeoPt.get(((ComplexPt)localObject).mGeoPt.size() - 1);
      if (AppTools.getDistanceByMc((Point)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1), new Point(i, j)) < 2.0D) {
        return false;
      }
    }
    else
    {
      return false;
    }
    localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    ((List)localObject).add(Integer.valueOf(2));
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    this.curMc = ((List)localObject);
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("nst").value(208);
    this.mJsonBuilder.key("fst").value(208);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
    this.mJsonBuilder.endObject();
    return true;
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
    if (!addStartDashRoutes4Indoor()) {
      addStartDashRoutes();
    }
    int i = 0;
    if (i < paramLegs.getStepsCount())
    {
      List localList = ((WalkPlan.Routes.Legs.Steps)paramLegs.getStepsList().get(i)).getSpathList();
      ComplexPt localComplexPt;
      if (localList != null)
      {
        localComplexPt = null;
        if (this.mSpathType != 0) {
          break label175;
        }
        localComplexPt = ComplexPt.createComplexPt(localList).toComplexPtGCJ2MC();
      }
      for (;;)
      {
        this.curMc = localComplexPt.toIntArray();
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(getCurrentIndex());
        addLineArrowStyle(171, 175, 171, 175);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
        this.mJsonBuilder.endObject();
        this.preMc = this.curMc;
        i += 1;
        break;
        label175:
        if (this.mSpathType == 1) {
          localComplexPt = ComplexPt.createComplexPt(localList);
        }
      }
    }
    if (!addEndDashRoutes4Indoor()) {
      addEndDashRoutes();
    }
  }
  
  private void addRouteStartNode()
  {
    WalkPlan.Option.Start localStart = this.mWalkRoute.getOption().getStart();
    if (localStart == null) {
      return;
    }
    this.mJsonBuilder.object();
    JsonBuilder localJsonBuilder = this.mJsonBuilder.key("ud");
    if (localStart.hasUid())
    {
      str = localStart.getUid();
      localJsonBuilder.value(str);
      this.mJsonBuilder.key("ty").value(1);
      this.mJsonBuilder.key("nst").value(17);
      this.mJsonBuilder.key("fst").value(17);
      localJsonBuilder = this.mJsonBuilder.key("tx");
      if (!localStart.hasWd()) {
        break label194;
      }
    }
    label194:
    for (String str = localStart.getWd();; str = "起点")
    {
      localJsonBuilder.value(str);
      this.mJsonBuilder.key("in").value(getCurrentIndex());
      this.mJsonBuilder.key("align").value(2);
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localStart.getSptList()));
      this.mJsonBuilder.endObject();
      return;
      str = "";
      break;
    }
  }
  
  private void addStartDashRoutes()
  {
    Point localPoint = getWalkPlanStartPoint(this.mWalkRoute);
    int i;
    int j;
    if (localPoint != null)
    {
      i = localPoint.getIntX();
      j = localPoint.getIntY();
      if ((i != 0) && (j != 0)) {
        break label36;
      }
    }
    label36:
    do
    {
      return;
      localPoint = getFirstRouteLoc();
    } while ((localPoint == null) || (AppTools.getDistanceByMc(new Point(i, j), localPoint) < 2.0D));
    ArrayList localArrayList = new ArrayList();
    int k = localPoint.getIntX();
    int m = localPoint.getIntY();
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(k - i));
    localArrayList.add(Integer.valueOf(m - j));
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("nst").value(208);
    this.mJsonBuilder.key("fst").value(208);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localArrayList));
    this.mJsonBuilder.endObject();
  }
  
  private boolean addStartDashRoutes4Indoor()
  {
    Object localObject = getDoorLoc(1);
    int i;
    int j;
    if (localObject != null)
    {
      i = ((Integer)((List)localObject).get(0)).intValue();
      j = ((Integer)((List)localObject).get(1)).intValue();
      if ((i == 0) || (j == 0)) {
        return false;
      }
    }
    else
    {
      return false;
    }
    localObject = getFirstRouteLoc();
    if (localObject != null)
    {
      if (AppTools.getDistanceByMc(new Point(i, j), (Point)localObject) < 2.0D) {
        return false;
      }
    }
    else {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int k = ((Point)localObject).getIntX();
    int m = ((Point)localObject).getIntY();
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(k - i));
    localArrayList.add(Integer.valueOf(m - j));
    this.curMc = localArrayList;
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("nst").value(208);
    this.mJsonBuilder.key("fst").value(208);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(this.curMc));
    this.mJsonBuilder.endObject();
    return true;
  }
  
  public static List<WalkPlan.Routes.Legs.ConnectedPois> getConnectedPoisList(WalkPlan paramWalkPlan)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramWalkPlan.getRoutesCount() > 0)
    {
      paramWalkPlan = paramWalkPlan.getRoutes(0).getLegsList().iterator();
      while (paramWalkPlan.hasNext())
      {
        Object localObject = ((WalkPlan.Routes.Legs)paramWalkPlan.next()).getConnectedPoisList();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add((WalkPlan.Routes.Legs.ConnectedPois)((Iterator)localObject).next());
          }
        }
      }
    }
    return localArrayList;
  }
  
  private int getCurrentIndex()
  {
    int i = this.mNodeCount;
    this.mNodeCount = (i + 1);
    return i;
  }
  
  private Point getFirstRouteLoc()
  {
    if ((this.mWalkRoute != null) && (this.mWalkRoute.getRoutesCount() > 0) && (this.mWalkRoute.getRoutes(0).getLegsCount() > 0) && (this.mWalkRoute.getRoutes(0).getLegs(0).getStepsCount() > 0))
    {
      WalkPlan.Routes.Legs.Steps localSteps = this.mWalkRoute.getRoutes(0).getLegs(0).getSteps(0);
      return new Point(((Integer)localSteps.getSpathList().get(5)).intValue(), ((Integer)localSteps.getSpathList().get(6)).intValue());
    }
    return null;
  }
  
  private WalkPlan.Routes.Legs mergeLegs()
  {
    WalkPlan.Routes.Legs localLegs = new WalkPlan.Routes.Legs();
    if (this.mWalkRoute.getRoutesCount() > 0)
    {
      Iterator localIterator = this.mWalkRoute.getRoutes(0).getLegsList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((WalkPlan.Routes.Legs)localIterator.next()).getStepsList();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localLegs.addSteps((WalkPlan.Routes.Legs.Steps)((Iterator)localObject).next());
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
  
  public List<Integer> getDoorLoc(int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    List localList = getConnectedPoisList(this.mWalkRoute);
    Object localObject2 = localObject3;
    if (localList != null)
    {
      localObject2 = localObject3;
      if (localList.size() != 0)
      {
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= localList.size()) {
            break;
          }
          localObject2 = localObject1;
          if (((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getType() == 1)
          {
            localObject2 = localObject1;
            if (((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getTypeDir() == paramInt) {
              localObject2 = ((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getLocationList();
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
    }
    return (List<Integer>)localObject2;
  }
  
  public String getRenderData()
  {
    resetTemporaryField();
    try
    {
      WalkPlan.Routes.Legs localLegs = mergeLegs();
      this.mJsonBuilder.object().key("dataset").arrayValue();
      addRoutePaths(localLegs);
      if (!this.mHasIndoor) {
        addRouteStartNode();
      }
      this.mJsonBuilder.endArrayValue().endObject();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    f.e(TAG, "walk render json:" + this.mJsonBuilder.getJson());
    return this.mJsonBuilder.getJson();
  }
  
  public Point getWalkPlanEndPoint(WalkPlan paramWalkPlan)
  {
    Point localPoint2 = new Point(0.0D, 0.0D);
    Point localPoint1 = localPoint2;
    if (paramWalkPlan != null)
    {
      localPoint1 = localPoint2;
      if (paramWalkPlan.hasOption())
      {
        localPoint1 = localPoint2;
        if (paramWalkPlan.getOption().getEndCount() > 0)
        {
          localPoint1 = localPoint2;
          if (paramWalkPlan.getOption().getEnd(paramWalkPlan.getOption().getEndCount() - 1) != null) {
            localPoint1 = PBConvertUtil.decryptPointFromArray(paramWalkPlan.getOption().getEnd(paramWalkPlan.getOption().getEndCount() - 1).getSptList());
          }
        }
      }
    }
    return localPoint1;
  }
  
  public Point getWalkPlanStartPoint(WalkPlan paramWalkPlan)
  {
    Point localPoint2 = new Point(0.0D, 0.0D);
    Point localPoint1 = localPoint2;
    if (paramWalkPlan != null)
    {
      localPoint1 = localPoint2;
      if (paramWalkPlan.hasOption())
      {
        localPoint1 = localPoint2;
        if (paramWalkPlan.getOption().hasStart()) {
          localPoint1 = PBConvertUtil.decryptPointFromArray(paramWalkPlan.getOption().getStart().getSptList());
        }
      }
    }
    return localPoint1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/ShBikeRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */