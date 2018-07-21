package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.List;

public class ContinueNaviModel
{
  private static final int mArg1 = 1;
  private List<RoutePlanNodeDBObject> mRoutePlanNodes = this.mTable.queryMulti("arg1=?", new String[] { "1" }, "routeplan_id", "ASC");
  private RoutePlanNodeDBTable mTable = new RoutePlanNodeDBTable();
  
  public static ContinueNaviModel getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  public void addContinueNaviNodes(List<RoutePlanNode> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if ((this.mRoutePlanNodes != null) && (this.mRoutePlanNodes.size() != 0)) {
      clear();
    }
    this.mTable.beginTransaction();
    int i = 0;
    while (i < paramList.size())
    {
      RoutePlanNodeDBObject localRoutePlanNodeDBObject = new RoutePlanNodeDBObject();
      localRoutePlanNodeDBObject.setArg1(1);
      localRoutePlanNodeDBObject.copy((RoutePlanNode)paramList.get(i));
      this.mTable.insert(localRoutePlanNodeDBObject);
      this.mRoutePlanNodes.add(localRoutePlanNodeDBObject);
      i += 1;
    }
    this.mTable.endTransaction();
  }
  
  public void clear()
  {
    this.mTable.delete("arg1=?", new String[] { "1" });
    this.mRoutePlanNodes = null;
  }
  
  public List<RoutePlanNode> getContinueNaviNodes()
  {
    return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
  }
  
  public boolean hasContinueNaviNode()
  {
    return (this.mRoutePlanNodes != null) && (this.mRoutePlanNodes.size() != 0);
  }
  
  static class InnerHolder
  {
    static ContinueNaviModel mInstance = new ContinueNaviModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/model/ContinueNaviModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */