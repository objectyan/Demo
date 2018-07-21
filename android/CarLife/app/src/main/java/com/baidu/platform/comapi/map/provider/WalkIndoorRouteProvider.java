package com.baidu.platform.comapi.map.provider;

import android.text.TextUtils;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs.Steps;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Option;
import com.baidu.entity.pb.WalkPlan.Option.End;
import com.baidu.entity.pb.WalkPlan.Option.Start;
import com.baidu.entity.pb.WalkPlan.Routes;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.ConnectedPois;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.search.convert.PBConvertUtil;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalkIndoorRouteProvider
  implements RenderProvider
{
  public static final int ARR_MAXL = 22;
  public static final int ARR_MINL = 13;
  public static final int MAXL = 12;
  public static final int MINL = 3;
  private static final String TAG = WalkIndoorRouteProvider.class.getSimpleName();
  private JsonBuilder builder;
  private String mBuildingId = "";
  boolean mDashMode = false;
  private WalkPlan mWalkRoute;
  private int nodeIndex;
  private List<IndoorNavi.Routes.Legs.Steps> stepsList = new LinkedList();
  
  public WalkIndoorRouteProvider(IndoorNavi.Routes.Legs.Steps paramSteps)
  {
    this.stepsList.add(paramSteps);
    this.mDashMode = false;
  }
  
  public WalkIndoorRouteProvider(WalkPlan paramWalkPlan, String paramString)
  {
    this.mWalkRoute = paramWalkPlan;
    this.mDashMode = true;
    this.mBuildingId = paramString;
  }
  
  private void addDashRoutes()
  {
    List localList = getDoorLoc();
    if ((localList != null) && (localList.size() != 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        int j = ((DoorInfo)localList.get(i)).x;
        int k = ((DoorInfo)localList.get(i)).y;
        int m = ((DoorInfo)localList.get(i)).type;
        if (m == 2) {
          drawDashLine(new Point(j, k), getDestLoc());
        }
        for (;;)
        {
          i += 1;
          break;
          if (m == 1) {
            drawDashLine(getStartLoc(), new Point(j, k));
          }
        }
      }
    }
  }
  
  private void drawDashLine(Point paramPoint1, Point paramPoint2)
  {
    f.e("tag", "drawDashLine:start:" + paramPoint1.toString() + "end:" + paramPoint2.toString());
    ArrayList localArrayList = new ArrayList();
    int i = paramPoint1.getIntX();
    int j = paramPoint1.getIntY();
    int k = paramPoint2.getIntX();
    int m = paramPoint2.getIntY();
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(k - i));
    localArrayList.add(Integer.valueOf(m - j));
    this.builder.object();
    this.builder.key("ty").value(2);
    this.builder.key("in").value(0);
    this.builder.key("nst").value(208);
    this.builder.key("fst").value(208);
    this.builder.key("path").objectValue(ProviderUtils.pathToJson(localArrayList));
    this.builder.endObject();
  }
  
  public static List<WalkPlan.Routes.Legs.ConnectedPois> getConnectedPoisList(WalkPlan paramWalkPlan)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramWalkPlan != null) && (paramWalkPlan.getRoutesCount() > 0))
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
  
  private void renderSteps()
  {
    if (this.mDashMode) {
      addDashRoutes();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.stepsList.iterator();
      while (localIterator.hasNext())
      {
        IndoorNavi.Routes.Legs.Steps localSteps = (IndoorNavi.Routes.Legs.Steps)localIterator.next();
        this.builder.object();
        this.builder.key("ty").value(2);
        JsonBuilder localJsonBuilder = this.builder.key("in");
        int i = this.nodeIndex;
        this.nodeIndex = (i + 1);
        localJsonBuilder.value(i);
        this.builder.key("nst").value(198);
        this.builder.key("fst").value(198);
        this.builder.key("path").objectValue(ProviderUtils.pathToJson(localSteps.getSpathList()));
        this.builder.endObject();
      }
    }
  }
  
  public Point getDestLoc()
  {
    Point localPoint2 = new Point(0.0D, 0.0D);
    Point localPoint1 = localPoint2;
    if (this.mWalkRoute != null)
    {
      localPoint1 = localPoint2;
      if (this.mWalkRoute.hasOption())
      {
        localPoint1 = localPoint2;
        if (this.mWalkRoute.getOption().getEndCount() > 0)
        {
          localPoint1 = localPoint2;
          if (this.mWalkRoute.getOption().getEnd(this.mWalkRoute.getOption().getEndCount() - 1) != null) {
            localPoint1 = PBConvertUtil.decryptPointFromArray(this.mWalkRoute.getOption().getEnd(this.mWalkRoute.getOption().getEndCount() - 1).getSptList());
          }
        }
      }
    }
    return localPoint1;
  }
  
  public List<DoorInfo> getDoorLoc()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = getConnectedPoisList(this.mWalkRoute);
    if ((localList != null) && (localList.size() != 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        if ((((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getType() == 1) && (TextUtils.equals(this.mBuildingId, ((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getBuilding())))
        {
          DoorInfo localDoorInfo = new DoorInfo();
          localDoorInfo.x = ((Integer)((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getLocationList().get(0)).intValue();
          localDoorInfo.y = ((Integer)((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getLocationList().get(1)).intValue();
          localDoorInfo.type = ((WalkPlan.Routes.Legs.ConnectedPois)localList.get(i)).getTypeDir();
          localArrayList.add(localDoorInfo);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public String getRenderData()
  {
    try
    {
      this.nodeIndex = 0;
      this.builder = new JsonBuilder();
      this.builder.object().key("dataset").arrayValue();
      this.builder.object();
      this.builder.key("indoor").value(true);
      this.builder.endObject();
      renderSteps();
      this.builder.endArrayValue().endObject();
      f.e(TAG, "indoor render json:" + this.builder.getJson());
      String str = this.builder.getJson();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Point getStartLoc()
  {
    Point localPoint2 = new Point(0.0D, 0.0D);
    Point localPoint1 = localPoint2;
    if (this.mWalkRoute != null)
    {
      localPoint1 = localPoint2;
      if (this.mWalkRoute.hasOption())
      {
        localPoint1 = localPoint2;
        if (this.mWalkRoute.getOption().hasStart()) {
          localPoint1 = PBConvertUtil.decryptPointFromArray(this.mWalkRoute.getOption().getStart().getSptList());
        }
      }
    }
    return localPoint1;
  }
  
  class DoorInfo
  {
    public int type;
    public int x;
    public int y;
    
    DoorInfo() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/WalkIndoorRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */