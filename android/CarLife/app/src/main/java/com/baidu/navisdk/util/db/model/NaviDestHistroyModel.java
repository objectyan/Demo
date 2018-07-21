package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.List;

public class NaviDestHistroyModel
{
  private static final int SIZE_LIMIT = 50;
  private static final int mArg1 = 2;
  private boolean mIsQueryDatabase = false;
  private List<RoutePlanNodeDBObject> mRoutePlanNodes = null;
  private RoutePlanNodeDBTable mTable = new RoutePlanNodeDBTable();
  
  private void consumeSize()
  {
    if (this.mRoutePlanNodes.size() > 50)
    {
      RoutePlanNodeDBObject localRoutePlanNodeDBObject = (RoutePlanNodeDBObject)this.mRoutePlanNodes.get(this.mRoutePlanNodes.size() - 1);
      if (localRoutePlanNodeDBObject != null) {
        this.mTable.delete(localRoutePlanNodeDBObject.getId());
      }
      this.mRoutePlanNodes.remove(this.mRoutePlanNodes.size() - 1);
    }
  }
  
  public static NaviDestHistroyModel getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  public void addNaviDest(RoutePlanNode paramRoutePlanNode)
  {
    if ((paramRoutePlanNode == null) || (!paramRoutePlanNode.isNodeIntegrated())) {
      return;
    }
    if (!this.mIsQueryDatabase) {
      getAllHistoryDestPoints();
    }
    this.mTable.beginTransaction();
    removeNaviDest(paramRoutePlanNode);
    RoutePlanNodeDBObject localRoutePlanNodeDBObject = new RoutePlanNodeDBObject();
    localRoutePlanNodeDBObject.copy(paramRoutePlanNode);
    localRoutePlanNodeDBObject.setArg1(2);
    this.mTable.insert(localRoutePlanNodeDBObject);
    this.mTable.endTransaction();
    this.mRoutePlanNodes.add(0, localRoutePlanNodeDBObject);
    consumeSize();
  }
  
  public boolean checkIsQueryDB()
  {
    return this.mIsQueryDatabase;
  }
  
  public void clear()
  {
    if (!this.mIsQueryDatabase) {
      getAllHistoryDestPoints();
    }
    this.mTable.delete("arg1=?", new String[] { "2" });
    this.mRoutePlanNodes.clear();
  }
  
  public void getAllHistoryDestPoints()
  {
    if (this.mRoutePlanNodes == null)
    {
      this.mRoutePlanNodes = this.mTable.queryMulti("arg1=?", new String[] { "2" }, "routeplan_id", "DESC");
      if (this.mRoutePlanNodes == null) {
        this.mRoutePlanNodes = new ArrayList(0);
      }
      consumeSize();
      this.mIsQueryDatabase = true;
    }
  }
  
  public ArrayList<RoutePlanNode> getRoutePlanNode()
  {
    return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
  }
  
  public void removeNaviDest(RoutePlanNode paramRoutePlanNode)
  {
    if (paramRoutePlanNode == null) {}
    for (;;)
    {
      return;
      if (!this.mIsQueryDatabase) {
        getAllHistoryDestPoints();
      }
      int i = 0;
      while (i < this.mRoutePlanNodes.size())
      {
        RoutePlanNodeDBObject localRoutePlanNodeDBObject = (RoutePlanNodeDBObject)this.mRoutePlanNodes.get(i);
        if (RoutePlanNodeDBObject.compare(localRoutePlanNodeDBObject, paramRoutePlanNode))
        {
          this.mTable.delete(localRoutePlanNodeDBObject.getId());
          this.mRoutePlanNodes.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  static class InnerHolder
  {
    static NaviDestHistroyModel mInstance = new NaviDestHistroyModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/model/NaviDestHistroyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */