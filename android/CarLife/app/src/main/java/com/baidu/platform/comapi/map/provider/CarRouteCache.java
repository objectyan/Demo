package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.Car;
import com.baidu.entity.pb.Car.Routes;
import com.baidu.entity.pb.Car.Routes.Legs;
import com.baidu.entity.pb.Car.Traffic;
import com.baidu.entity.pb.Car.Traffic.Routes;
import com.baidu.entity.pb.Car.Traffic.Routes.Legs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CarRouteCache
{
  private List<Car.Routes> routeCache = new LinkedList();
  
  private Car.Routes.Legs getRouteLegsByIndex(Car paramCar, int paramInt1, int paramInt2)
  {
    int i;
    if ((paramCar.getRoutesCount() > paramInt1) && (paramCar.getRoutes(paramInt1).getLegsCount() > paramInt2) && (paramCar.getRoutes(paramInt1).getLegs(paramInt2).getStepsCount() > 0))
    {
      i = 1;
      if ((this.routeCache == null) || (this.routeCache.size() <= paramInt1) || (((Car.Routes)this.routeCache.get(paramInt1)).getLegsCount() <= paramInt2) || (((Car.Routes)this.routeCache.get(paramInt1)).getLegs(paramInt2).getStepsCount() <= 0)) {
        break label133;
      }
    }
    label133:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label139;
      }
      this.routeCache = paramCar.getRoutesList();
      return paramCar.getRoutes(paramInt1).getLegs(paramInt2);
      i = 0;
      break;
    }
    label139:
    if (j != 0) {
      return ((Car.Routes)this.routeCache.get(paramInt1)).getLegs(paramInt2);
    }
    return null;
  }
  
  private Car.Traffic.Routes.Legs getTrafficLegs(Car.Traffic paramTraffic, int paramInt1, int paramInt2)
  {
    if ((paramTraffic.getRoutesCount() > paramInt1) && (paramTraffic.getRoutes(paramInt1).getLegsCount() > paramInt2)) {
      return paramTraffic.getRoutes(paramInt1).getLegs(paramInt2);
    }
    return null;
  }
  
  List<RouteData> updateCacheAndGetResult(Car paramCar)
  {
    LinkedList localLinkedList = new LinkedList();
    RouteData localRouteData = new RouteData();
    localRouteData.routeLegs = new ArrayList();
    localRouteData.trafficLegs = new ArrayList();
    int j = Math.max(paramCar.getRoutes(0).getLegsCount(), paramCar.getTraffic().getRoutes(0).getLegsCount());
    int i = 0;
    while (i < j)
    {
      localRouteData.routeLegs.add(getRouteLegsByIndex(paramCar, 0, i));
      localRouteData.trafficLegs.add(getTrafficLegs(paramCar.getTraffic(), 0, i));
      i += 1;
    }
    if (localRouteData.routeLegs != null) {
      localLinkedList.add(localRouteData);
    }
    return localLinkedList;
  }
  
  class RouteData
  {
    ArrayList<Car.Routes.Legs> routeLegs;
    ArrayList<Car.Traffic.Routes.Legs> trafficLegs;
    
    RouteData() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/CarRouteCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */