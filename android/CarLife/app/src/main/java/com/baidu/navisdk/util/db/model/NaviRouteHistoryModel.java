package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.NaviRouteDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.NaviRouteDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.List;

public class NaviRouteHistoryModel
{
  private static final int SIZE_LIMIT = 50;
  private static final int mArg1 = 3;
  private NaviRouteDBTable mNaviRouteDBTable = new NaviRouteDBTable();
  private ArrayList<NaviRouteDBObject> mNaviRouteHistory;
  private RoutePlanNodeDBTable mRoutePlanNodeDBTable = new RoutePlanNodeDBTable();
  
  private boolean compareRoute(List<RoutePlanNode> paramList, List<RoutePlanNodeDBObject> paramList1)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      if (paramList1 != null) {
        break label22;
      }
      bool1 = bool2;
    }
    label22:
    label99:
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramList.size() == paramList1.size())
      {
        bool1 = true;
        int i = 0;
        for (;;)
        {
          if (i >= paramList.size()) {
            break label99;
          }
          bool2 = RoutePlanNodeDBObject.compare((RoutePlanNode)paramList.get(i), (RoutePlanNodeDBObject)paramList1.get(i));
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
  }
  
  private void consumeSize()
  {
    if (this.mNaviRouteHistory.size() > 50)
    {
      NaviRouteDBObject localNaviRouteDBObject = (NaviRouteDBObject)this.mNaviRouteHistory.get(this.mNaviRouteHistory.size() - 1);
      if (localNaviRouteDBObject != null) {
        delelteNaviRoute(localNaviRouteDBObject.getId());
      }
      this.mNaviRouteHistory.remove(this.mNaviRouteHistory.size() - 1);
    }
  }
  
  private void delelteNaviRoute(int paramInt)
  {
    try
    {
      this.mNaviRouteDBTable.delete(paramInt);
      String str = paramInt + "";
      this.mRoutePlanNodeDBTable.delete("arg1=? and arg2=?", new String[] { "3", str });
      return;
    }
    catch (Exception localException) {}
  }
  
  private NaviRouteDBObject getExistObject(List<RoutePlanNode> paramList)
  {
    int i = 0;
    while (i < this.mNaviRouteHistory.size())
    {
      NaviRouteDBObject localNaviRouteDBObject = (NaviRouteDBObject)this.mNaviRouteHistory.get(i);
      if ((localNaviRouteDBObject != null) && (compareRoute(paramList, localNaviRouteDBObject.getRoutePlanDBNodes()))) {
        return (NaviRouteDBObject)this.mNaviRouteHistory.remove(i);
      }
      i += 1;
    }
    return null;
  }
  
  public static NaviRouteHistoryModel getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  private int handleRepeatNaviRoute(List<RoutePlanNode> paramList)
  {
    int k = -1;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.mNaviRouteHistory.size())
      {
        NaviRouteDBObject localNaviRouteDBObject = (NaviRouteDBObject)this.mNaviRouteHistory.get(i);
        if ((localNaviRouteDBObject != null) && (compareRoute(paramList, localNaviRouteDBObject.getRoutePlanDBNodes())))
        {
          this.mNaviRouteHistory.remove(i);
          delelteNaviRoute(localNaviRouteDBObject.getId());
          j = i;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public void addNaviRoute(List<RoutePlanNode> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    getAllHistoryRoutes();
    this.mRoutePlanNodeDBTable.beginTransaction();
    NaviRouteDBObject localNaviRouteDBObject = getExistObject(paramList);
    if (localNaviRouteDBObject == null)
    {
      localNaviRouteDBObject = new NaviRouteDBObject();
      localNaviRouteDBObject.setTime(System.currentTimeMillis());
      this.mNaviRouteDBTable.insert(localNaviRouteDBObject);
      ArrayList localArrayList = new ArrayList(paramList.size());
      localNaviRouteDBObject.setRoutePlanNodes(localArrayList);
      int j = localNaviRouteDBObject.getId();
      int i = 0;
      while (i < paramList.size())
      {
        RoutePlanNodeDBObject localRoutePlanNodeDBObject = new RoutePlanNodeDBObject();
        localRoutePlanNodeDBObject.copy((RoutePlanNode)paramList.get(i));
        localRoutePlanNodeDBObject.setArg1(3);
        localRoutePlanNodeDBObject.setArg2(j);
        this.mRoutePlanNodeDBTable.insert(localRoutePlanNodeDBObject);
        localArrayList.add(localRoutePlanNodeDBObject);
        i += 1;
      }
      this.mNaviRouteHistory.add(0, localNaviRouteDBObject);
      consumeSize();
    }
    for (;;)
    {
      this.mRoutePlanNodeDBTable.endTransaction();
      return;
      localNaviRouteDBObject.setTime(System.currentTimeMillis());
      this.mNaviRouteDBTable.update(localNaviRouteDBObject);
      this.mNaviRouteHistory.add(0, localNaviRouteDBObject);
    }
  }
  
  public void clear()
  {
    getAllHistoryRoutes();
    this.mNaviRouteDBTable.beginTransaction();
    this.mNaviRouteDBTable.deleteAll();
    this.mRoutePlanNodeDBTable.delete("arg1=?", new String[] { "3" });
    this.mNaviRouteDBTable.endTransaction();
    this.mNaviRouteHistory.clear();
  }
  
  public void getAllHistoryRoutes()
  {
    if (this.mNaviRouteHistory == null) {
      try
      {
        this.mNaviRouteDBTable.beginTransaction();
        this.mNaviRouteHistory = this.mNaviRouteDBTable.queryAll("navi_route_time", "DESC");
        if (this.mNaviRouteHistory == null) {
          this.mNaviRouteHistory = new ArrayList(0);
        }
        consumeSize();
        int i = 0;
        for (;;)
        {
          if (i < this.mNaviRouteHistory.size())
          {
            NaviRouteDBObject localNaviRouteDBObject = (NaviRouteDBObject)this.mNaviRouteHistory.get(i);
            if (localNaviRouteDBObject != null)
            {
              String str = localNaviRouteDBObject.getId() + "";
              localNaviRouteDBObject.setRoutePlanNodes(this.mRoutePlanNodeDBTable.queryMulti("arg1=? and arg2=?", new String[] { "3", str }, "routeplan_id", "ASC"));
            }
          }
          else
          {
            this.mNaviRouteDBTable.endTransaction();
            return;
          }
          i += 1;
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public ArrayList<NaviRouteDBObject> getNaviRouteList()
  {
    return this.mNaviRouteHistory;
  }
  
  public int getSize()
  {
    return this.mNaviRouteHistory.size();
  }
  
  public void removeNaviRoute(List<RoutePlanNode> paramList)
  {
    if (paramList == null) {
      return;
    }
    getAllHistoryRoutes();
    handleRepeatNaviRoute(paramList);
  }
  
  public void removeNaviRouteHistoryByPosition(int paramInt)
  {
    if (this.mNaviRouteHistory == null) {}
    for (;;)
    {
      return;
      getAllHistoryRoutes();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt >= 0) {
        localObject1 = localObject2;
      }
      try
      {
        if (paramInt < this.mNaviRouteHistory.size()) {
          localObject1 = (NaviRouteDBObject)this.mNaviRouteHistory.get(paramInt);
        }
        if (localObject1 != null)
        {
          delelteNaviRoute(((NaviRouteDBObject)localObject1).getId());
          this.mNaviRouteHistory.remove(paramInt);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  static class InnerHolder
  {
    static NaviRouteHistoryModel mInstance = new NaviRouteHistoryModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/model/NaviRouteHistoryModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */