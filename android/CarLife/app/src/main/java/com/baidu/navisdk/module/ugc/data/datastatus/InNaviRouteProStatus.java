package com.baidu.navisdk.module.ugc.data.datastatus;

import java.util.ArrayList;

public class InNaviRouteProStatus
{
  private ArrayList<RouteProInfo> routeProInfoList = new ArrayList();
  
  private void addNewRoutePro(RouteProInfo paramRouteProInfo)
  {
    if (this.routeProInfoList != null) {
      this.routeProInfoList.add(paramRouteProInfo);
    }
  }
  
  private void clear()
  {
    if (this.routeProInfoList != null) {
      this.routeProInfoList.clear();
    }
  }
  
  public class RouteProInfo
  {
    private int type = -1;
    
    RouteProInfo(int paramInt) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/data/datastatus/InNaviRouteProStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */