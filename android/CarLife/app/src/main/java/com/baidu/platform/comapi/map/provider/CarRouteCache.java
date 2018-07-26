package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.Car;
import com.baidu.entity.pb.Car.Routes;
import com.baidu.entity.pb.Car.Routes.Legs;
import com.baidu.entity.pb.Car.Traffic;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CarRouteCache {
    private List<Routes> routeCache = new LinkedList();

    class RouteData {
        ArrayList<Legs> routeLegs;
        ArrayList<Traffic.Routes.Legs> trafficLegs;

        RouteData() {
        }
    }

    CarRouteCache() {
    }

    List<RouteData> updateCacheAndGetResult(Car aCar) {
        LinkedList<RouteData> resultRoutes = new LinkedList();
        RouteData routeData = new RouteData();
        routeData.routeLegs = new ArrayList();
        routeData.trafficLegs = new ArrayList();
        int size = Math.max(aCar.getRoutes(0).getLegsCount(), aCar.getTraffic().getRoutes(0).getLegsCount());
        for (int i = 0; i < size; i++) {
            routeData.routeLegs.add(getRouteLegsByIndex(aCar, 0, i));
            routeData.trafficLegs.add(getTrafficLegs(aCar.getTraffic(), 0, i));
        }
        if (routeData.routeLegs != null) {
            resultRoutes.add(routeData);
        }
        return resultRoutes;
    }

    private Legs getRouteLegsByIndex(Car car, int routeIndex, int legIndex) {
        boolean isCurrentDataHas;
        boolean isCacheDataHas;
        if (car.getRoutesCount() <= routeIndex || car.getRoutes(routeIndex).getLegsCount() <= legIndex || car.getRoutes(routeIndex).getLegs(legIndex).getStepsCount() <= 0) {
            isCurrentDataHas = false;
        } else {
            isCurrentDataHas = true;
        }
        if (this.routeCache == null || this.routeCache.size() <= routeIndex || ((Routes) this.routeCache.get(routeIndex)).getLegsCount() <= legIndex || ((Routes) this.routeCache.get(routeIndex)).getLegs(legIndex).getStepsCount() <= 0) {
            isCacheDataHas = false;
        } else {
            isCacheDataHas = true;
        }
        if (isCurrentDataHas) {
            this.routeCache = car.getRoutesList();
            return car.getRoutes(routeIndex).getLegs(legIndex);
        } else if (isCacheDataHas) {
            return ((Routes) this.routeCache.get(routeIndex)).getLegs(legIndex);
        } else {
            return null;
        }
    }

    private Traffic.Routes.Legs getTrafficLegs(Traffic trafficData, int routeIndex, int legIndex) {
        if (trafficData.getRoutesCount() <= routeIndex || trafficData.getRoutes(routeIndex).getLegsCount() <= legIndex) {
            return null;
        }
        return trafficData.getRoutes(routeIndex).getLegs(legIndex);
    }
}
