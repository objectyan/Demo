package com.baidu.navisdk.util.db.object;

import android.text.format.DateFormat;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.List;

public class NaviRouteDBObject
  implements BaseDBObject
{
  private int mId;
  private ArrayList<RoutePlanNodeDBObject> mRoutePlanNodes;
  private long mTime;
  
  public NaviRouteDBObject() {}
  
  public NaviRouteDBObject(ArrayList<RoutePlanNodeDBObject> paramArrayList, long paramLong)
  {
    this.mRoutePlanNodes = paramArrayList;
    this.mTime = paramLong;
  }
  
  public boolean compareRoute(List<RoutePlanNode> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mRoutePlanNodes != null)
    {
      if (paramList != null) {
        break label22;
      }
      bool1 = bool2;
    }
    label22:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.mRoutePlanNodes.size() != paramList.size());
    bool2 = true;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= this.mRoutePlanNodes.size()) {
        break;
      }
      paramList = (RoutePlanNode)this.mRoutePlanNodes.get(i);
      RoutePlanNodeDBObject localRoutePlanNodeDBObject = (RoutePlanNodeDBObject)this.mRoutePlanNodes.get(i);
      if (paramList.getLatitudeE6() != localRoutePlanNodeDBObject.getLatitudeE6()) {
        return false;
      }
      if (paramList.getLongitudeE6() != localRoutePlanNodeDBObject.getLongitudeE6()) {
        return false;
      }
      i += 1;
    }
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public ArrayList<RoutePlanNodeDBObject> getRoutePlanDBNodes()
  {
    return this.mRoutePlanNodes;
  }
  
  public ArrayList<RoutePlanNode> getRoutePlanNodes()
  {
    return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
  }
  
  public long getTime()
  {
    return this.mTime;
  }
  
  public CharSequence getTimeAsStr()
  {
    return DateFormat.format("yyyy-MM-dd kk:mm", this.mTime);
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void setRoutePlanNodes(ArrayList<RoutePlanNodeDBObject> paramArrayList)
  {
    this.mRoutePlanNodes = paramArrayList;
  }
  
  public void setTime(long paramLong)
  {
    this.mTime = paramLong;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/object/NaviRouteDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */