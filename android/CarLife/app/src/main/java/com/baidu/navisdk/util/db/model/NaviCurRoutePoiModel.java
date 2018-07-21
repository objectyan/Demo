package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.List;

public class NaviCurRoutePoiModel
{
  private static final int ARG = 5;
  private List<RoutePlanNodeDBObject> mRoutePlanDBNodes;
  private RoutePlanNodeDBTable mRoutePlanNodeDBTable = new RoutePlanNodeDBTable();
  
  public static NaviCurRoutePoiModel getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  public void addCurNaviNodes(ArrayList<RoutePlanNode> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    getLastNaviPointsFromDB();
    clear();
    this.mRoutePlanNodeDBTable.beginTransaction();
    int i = 1;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label118;
      }
      RoutePlanNode localRoutePlanNode = (RoutePlanNode)paramArrayList.get(i);
      if ((localRoutePlanNode == null) || (localRoutePlanNode.getLatitudeE6() == Integer.MIN_VALUE) || (localRoutePlanNode.getLongitudeE6() == Integer.MIN_VALUE)) {
        break;
      }
      RoutePlanNodeDBObject localRoutePlanNodeDBObject = new RoutePlanNodeDBObject();
      localRoutePlanNodeDBObject.copy(localRoutePlanNode);
      localRoutePlanNodeDBObject.setArg1(5);
      this.mRoutePlanNodeDBTable.insert(localRoutePlanNodeDBObject);
      this.mRoutePlanDBNodes.add(localRoutePlanNodeDBObject);
      i += 1;
    }
    label118:
    this.mRoutePlanNodeDBTable.endTransaction();
  }
  
  public void clear()
  {
    getLastNaviPointsFromDB();
    this.mRoutePlanNodeDBTable.delete("arg1=?", new String[] { "5" });
    this.mRoutePlanDBNodes.clear();
  }
  
  public ArrayList<RoutePlanNode> getLastNaviNodesList()
  {
    return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanDBNodes);
  }
  
  public void getLastNaviPointsFromDB()
  {
    if (this.mRoutePlanDBNodes == null)
    {
      this.mRoutePlanDBNodes = this.mRoutePlanNodeDBTable.queryMulti("arg1=?", new String[] { "5" }, "routeplan_id", "ASC");
      if (this.mRoutePlanDBNodes == null) {
        this.mRoutePlanDBNodes = new ArrayList(0);
      }
    }
  }
  
  public void removeCurNaviViaNode(RoutePlanNode paramRoutePlanNode)
  {
    if (paramRoutePlanNode == null) {}
    for (;;)
    {
      return;
      getLastNaviPointsFromDB();
      int i = 0;
      while (i < this.mRoutePlanDBNodes.size())
      {
        RoutePlanNodeDBObject localRoutePlanNodeDBObject = (RoutePlanNodeDBObject)this.mRoutePlanDBNodes.get(i);
        if (RoutePlanNodeDBObject.compare(localRoutePlanNodeDBObject, paramRoutePlanNode))
        {
          this.mRoutePlanNodeDBTable.delete(localRoutePlanNodeDBObject.getId());
          this.mRoutePlanDBNodes.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  static class InnerHolder
  {
    static NaviCurRoutePoiModel mInstance = new NaviCurRoutePoiModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/model/NaviCurRoutePoiModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */