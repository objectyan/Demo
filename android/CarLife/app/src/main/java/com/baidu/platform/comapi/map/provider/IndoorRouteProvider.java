package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.IndoorNavi;
import com.baidu.entity.pb.IndoorNavi.Routes;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs.Steps;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs.Steps.Pois;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IndoorRouteProvider
  implements RenderProvider
{
  private static final String TAG = IndoorRouteProvider.class.getSimpleName();
  private JsonBuilder builder;
  private List<IndoorNavi.Routes.Legs.Steps> highLightSteps = new LinkedList();
  private final IndoorNavi.Routes.Legs indoorLeg;
  private int nodeIndex;
  
  public IndoorRouteProvider(IndoorNavi.Routes.Legs paramLegs)
  {
    this.indoorLeg = paramLegs;
  }
  
  public static IndoorNavi.Routes.Legs extractRouteLeg(IndoorNavi paramIndoorNavi)
    throws Exception
  {
    IndoorNavi.Routes.Legs localLegs = new IndoorNavi.Routes.Legs();
    Iterator localIterator = paramIndoorNavi.getRoutes(0).getLegsList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IndoorNavi.Routes.Legs)localIterator.next();
      localLegs.setDistance(localLegs.getDistance() + ((IndoorNavi.Routes.Legs)localObject).getDistance());
      localLegs.setDuration(localLegs.getDuration() + ((IndoorNavi.Routes.Legs)localObject).getDuration());
      localObject = ((IndoorNavi.Routes.Legs)localObject).getStepsList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localLegs.addSteps((IndoorNavi.Routes.Legs.Steps)((Iterator)localObject).next());
        }
      }
    }
    localIterator = paramIndoorNavi.getRoutes(0).getLegs(0).getSstartLocationList().iterator();
    while (localIterator.hasNext()) {
      localLegs.addSstartLocation(((Double)localIterator.next()).doubleValue());
    }
    paramIndoorNavi = paramIndoorNavi.getRoutes(0).getLegs(paramIndoorNavi.getRoutes(0).getLegsCount() - 1).getSendLocationList().iterator();
    while (paramIndoorNavi.hasNext()) {
      localLegs.addSendLocation(((Double)paramIndoorNavi.next()).doubleValue());
    }
    return localLegs;
  }
  
  private void renderEnd()
  {
    this.builder.object();
    this.builder.key("ty").value(2);
    this.builder.key("nst").value(18);
    this.builder.key("fst").value(18);
    this.builder.key("tx").value("终点");
    JsonBuilder localJsonBuilder = this.builder.key("in");
    int i = this.nodeIndex;
    this.nodeIndex = (i + 1);
    localJsonBuilder.value(i);
    this.builder.key("align").value(2);
    this.builder.key("path").objectValue(ProviderUtils.pathToJson(this.indoorLeg.getSendLocationList()));
    this.builder.endObject();
  }
  
  private void renderPois()
  {
    if (this.highLightSteps == null) {}
    Iterator localIterator2;
    do
    {
      return;
      Iterator localIterator1;
      while (!localIterator1.hasNext()) {
        localIterator1 = this.highLightSteps.iterator();
      }
      localIterator2 = ((IndoorNavi.Routes.Legs.Steps)localIterator1.next()).getPoisList().iterator();
    } while (!localIterator2.hasNext());
    IndoorNavi.Routes.Legs.Steps.Pois localPois = (IndoorNavi.Routes.Legs.Steps.Pois)localIterator2.next();
    this.builder.object();
    this.builder.key("ty").value(3);
    switch (localPois.getType())
    {
    }
    for (;;)
    {
      this.builder.key("tx").value(localPois.getName());
      JsonBuilder localJsonBuilder = this.builder.key("in");
      int i = this.nodeIndex;
      this.nodeIndex = (i + 1);
      localJsonBuilder.value(i);
      this.builder.key("align").value(1);
      this.builder.key("of").value(15);
      this.builder.key("path").objectValue(ProviderUtils.pathToJson(localPois.getLocationList()));
      this.builder.endObject();
      break;
      this.builder.key("nst").value(204);
      this.builder.key("fst").value(204);
      continue;
      this.builder.key("nst").value(203);
      this.builder.key("fst").value(203);
      continue;
      this.builder.key("nst").value(202);
      this.builder.key("fst").value(202);
      continue;
      this.builder.key("nst").value(201);
      this.builder.key("fst").value(201);
    }
  }
  
  private void renderStart()
  {
    this.builder.object();
    this.builder.key("ty").value(1);
    this.builder.key("nst").value(17);
    this.builder.key("fst").value(17);
    this.builder.key("tx").value("起点");
    JsonBuilder localJsonBuilder = this.builder.key("in");
    int i = this.nodeIndex;
    this.nodeIndex = (i + 1);
    localJsonBuilder.value(i);
    this.builder.key("align").value(2);
    this.builder.key("path").objectValue(ProviderUtils.pathToJson(this.indoorLeg.getSstartLocationList()));
    this.builder.endObject();
  }
  
  private void renderSteps()
  {
    Iterator localIterator = this.indoorLeg.getStepsList().iterator();
    if (localIterator.hasNext())
    {
      IndoorNavi.Routes.Legs.Steps localSteps = (IndoorNavi.Routes.Legs.Steps)localIterator.next();
      label56:
      JsonBuilder localJsonBuilder;
      int j;
      if ((this.highLightSteps != null) && (this.highLightSteps.contains(localSteps)))
      {
        i = 1;
        this.builder.object();
        this.builder.key("ty").value(2);
        localJsonBuilder = this.builder.key("in");
        j = this.nodeIndex;
        this.nodeIndex = (j + 1);
        localJsonBuilder.value(j);
        localJsonBuilder = this.builder.key("nst");
        if (i == 0) {
          break label197;
        }
        j = 154;
        label127:
        localJsonBuilder.value(j);
        localJsonBuilder = this.builder.key("fst");
        if (i == 0) {
          break label204;
        }
      }
      label197:
      label204:
      for (int i = 154;; i = 155)
      {
        localJsonBuilder.value(i);
        this.builder.key("path").objectValue(ProviderUtils.pathToJson(localSteps.getSpathList()));
        this.builder.endObject();
        break;
        i = 0;
        break label56;
        j = 155;
        break label127;
      }
    }
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
      renderPois();
      renderStart();
      renderEnd();
      this.builder.endArrayValue().endObject();
      String str = this.builder.getJson();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setHighLightSteps(List<IndoorNavi.Routes.Legs.Steps> paramList)
  {
    try
    {
      this.highLightSteps = paramList;
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/IndoorRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */