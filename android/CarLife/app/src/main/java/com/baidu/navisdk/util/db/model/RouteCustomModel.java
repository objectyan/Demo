package com.baidu.navisdk.util.db.model;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.RouteCustomDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.Iterator;

public class RouteCustomModel
{
  public static final int ERROR_CUSTOM_NEW_ROUTE_MAX_SUM = -2;
  public static final int ERROR_PARAM = -1;
  public static final int ROUTE_CUSTOM_ACTION_EDIT = 2;
  public static final int ROUTE_CUSTOM_ACTION__CREATE = 1;
  public static final int ROUTE_CUSTOM_AWAKE_CLOSE = 0;
  public static final int ROUTE_CUSTOM_AWAKE_OPEN = 1;
  public static final int ROUTE_CUSTOM_MAX_SUM = 10;
  public static final int ROUTE_CUSTOM_NOT_REPEAT = 0;
  public static final int ROUTE_CUSTOM_REPEAT = 1;
  public static final int ROUTE_DEST_TYPE_COMPANY = 2;
  public static final int ROUTE_DEST_TYPE_HOME = 1;
  public static final int ROUTE_DEST_TYPE_OTHER = 3;
  private static final int mArg1 = 4;
  private Context mContext = BNaviModuleManager.getContext();
  private RouteCustomDBTable mRouteCustomDBTable = new RouteCustomDBTable();
  private ArrayList<RouteCustomDBObject> mRouteCustomObjList;
  private RoutePlanNodeDBTable mRoutePlanNodeDBTable = new RoutePlanNodeDBTable();
  
  private RouteCustomModel()
  {
    this.mRouteCustomDBTable.beginTransaction();
    this.mRouteCustomObjList = this.mRouteCustomDBTable.queryMulti(null, null, "route_custom_id", "DESC");
    if (this.mRouteCustomObjList == null) {
      this.mRouteCustomObjList = new ArrayList(0);
    }
    int i = 0;
    while (i < this.mRouteCustomObjList.size())
    {
      RouteCustomDBObject localRouteCustomDBObject = (RouteCustomDBObject)this.mRouteCustomObjList.get(i);
      String str = localRouteCustomDBObject.getId() + "";
      localRouteCustomDBObject.setRoutePlanNodes(this.mRoutePlanNodeDBTable.queryMulti("arg1=?and arg2=?", new String[] { "4", str }, "routeplan_id", "ASC"));
      checkRouteCustomDestType(localRouteCustomDBObject);
      i += 1;
    }
    this.mRouteCustomDBTable.endTransaction();
  }
  
  private void checkRouteCustomDestType(RouteCustomDBObject paramRouteCustomDBObject)
  {
    RoutePlanNode localRoutePlanNode = null;
    ArrayList localArrayList2 = paramRouteCustomDBObject.getRoutePlanDBNodes();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList(0);
      paramRouteCustomDBObject.setRoutePlanNodes(localArrayList1);
    }
    if (paramRouteCustomDBObject.getDestType() == 1) {
      localRoutePlanNode = AddressSettingModel.getHomeAddrNode(this.mContext);
    }
    for (;;)
    {
      if (localRoutePlanNode != null)
      {
        paramRouteCustomDBObject = new RoutePlanNodeDBObject();
        paramRouteCustomDBObject.copy(localRoutePlanNode);
        localArrayList1.add(paramRouteCustomDBObject);
      }
      return;
      if (paramRouteCustomDBObject.getDestType() == 2) {
        localRoutePlanNode = AddressSettingModel.getCompAddrNode(this.mContext);
      }
    }
  }
  
  private int getExistRouteIndexByRouteList(ArrayList<RoutePlanNode> paramArrayList)
  {
    int m = 0;
    int i = 0;
    ArrayList localArrayList;
    for (;;)
    {
      j = m;
      if (i >= this.mRouteCustomObjList.size()) {
        break label104;
      }
      localArrayList = ((RouteCustomDBObject)this.mRouteCustomObjList.get(i)).getRoutePlanDBNodes();
      if (paramArrayList.size() == localArrayList.size()) {
        break;
      }
      i += 1;
    }
    int n = 0;
    int j = 0;
    for (;;)
    {
      int k = n;
      if (j < paramArrayList.size())
      {
        if (!RoutePlanNodeDBObject.compare((RoutePlanNode)paramArrayList.get(j), (RoutePlanNodeDBObject)localArrayList.get(j))) {
          k = 1;
        }
      }
      else
      {
        if (k != 0) {
          break;
        }
        j = 1;
        label104:
        if (j == 0) {
          break label117;
        }
        return i;
      }
      j += 1;
    }
    label117:
    return -1;
  }
  
  public static RouteCustomModel getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  public int addNewCustomRoute(int paramInt1, ArrayList<RoutePlanNode> paramArrayList, int paramInt2)
  {
    if ((paramArrayList == null) && (paramInt2 == 3)) {
      return -1;
    }
    if (this.mRouteCustomObjList.size() == 10) {
      return -2;
    }
    RouteCustomDBObject localRouteCustomDBObject = new RouteCustomDBObject();
    this.mRoutePlanNodeDBTable.beginTransaction();
    long l = System.currentTimeMillis();
    localRouteCustomDBObject.setCustomTime(l);
    localRouteCustomDBObject.setModifiedTime(l);
    localRouteCustomDBObject.setHisRouteId(paramInt1);
    localRouteCustomDBObject.setName("");
    localRouteCustomDBObject.setIsRepeat(0);
    localRouteCustomDBObject.setRepeatDate("");
    localRouteCustomDBObject.setOpen(1);
    localRouteCustomDBObject.setPushTimeHour(-1);
    localRouteCustomDBObject.setPushTimeMinute(-1);
    localRouteCustomDBObject.setPushTimeMills(-1L);
    localRouteCustomDBObject.setDestType(paramInt2);
    this.mRouteCustomDBTable.insert(localRouteCustomDBObject);
    if (paramInt2 == 3)
    {
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      localRouteCustomDBObject.setRoutePlanNodes(localArrayList);
      paramInt2 = localRouteCustomDBObject.getId();
      paramInt1 = 0;
      while (paramInt1 < paramArrayList.size())
      {
        RoutePlanNodeDBObject localRoutePlanNodeDBObject = new RoutePlanNodeDBObject();
        localRoutePlanNodeDBObject.copy((RoutePlanNode)paramArrayList.get(paramInt1));
        localRoutePlanNodeDBObject.setArg2(paramInt2);
        localRoutePlanNodeDBObject.setArg1(4);
        this.mRoutePlanNodeDBTable.insert(localRoutePlanNodeDBObject);
        localArrayList.add(localRoutePlanNodeDBObject);
        paramInt1 += 1;
      }
    }
    this.mRoutePlanNodeDBTable.endTransaction();
    checkRouteCustomDestType(localRouteCustomDBObject);
    this.mRouteCustomObjList.add(0, localRouteCustomDBObject);
    return 0;
  }
  
  public void clear()
  {
    this.mRouteCustomDBTable.beginTransaction();
    this.mRouteCustomDBTable.deleteAll();
    this.mRoutePlanNodeDBTable.delete("arg1=?", new String[] { "4" });
    this.mRouteCustomDBTable.endTransaction();
    this.mRouteCustomObjList.clear();
  }
  
  public void deleteCustomRoute(int paramInt)
  {
    this.mRouteCustomDBTable.delete(paramInt);
    String str = paramInt + "";
    this.mRoutePlanNodeDBTable.delete("arg1=? and arg2=?", new String[] { "4", str });
  }
  
  public int getCurRouteIndex(int paramInt1, int paramInt2, ArrayList<RoutePlanNode> paramArrayList)
  {
    if (paramInt1 != 3)
    {
      paramInt2 = 0;
      while (paramInt2 < this.mRouteCustomObjList.size())
      {
        if (paramInt1 == ((RouteCustomDBObject)this.mRouteCustomObjList.get(paramInt2)).getDestType()) {
          return paramInt2;
        }
        paramInt2 += 1;
      }
      return -1;
    }
    paramInt1 = getExistRouteIndexByHisRouteDBId(paramInt2);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    paramInt1 = getExistRouteIndexByRouteList(paramArrayList);
    if (paramInt1 >= 0)
    {
      paramArrayList = (RouteCustomDBObject)this.mRouteCustomObjList.get(paramInt1);
      if (paramArrayList != null)
      {
        paramArrayList.setHisRouteId(paramInt2);
        updateRouteCustomInfo(paramInt1);
      }
    }
    return paramInt1;
  }
  
  public int getExistRouteIndexByHisRouteDBId(int paramInt)
  {
    int j;
    if ((this.mRouteCustomObjList == null) || (this.mRouteCustomObjList.size() == 0))
    {
      j = -1;
      return j;
    }
    int k = this.mRouteCustomObjList.size();
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label65;
      }
      j = i;
      if (((RouteCustomDBObject)this.mRouteCustomObjList.get(i)).getHisRouteId() == paramInt) {
        break;
      }
      i += 1;
    }
    label65:
    return -1;
  }
  
  public Bundle getNodesListBundle(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = getRouteCustomInfoByPos(paramInt);
    if (localRouteCustomDBObject == null) {
      return null;
    }
    ArrayList localArrayList1 = localRouteCustomDBObject.getRoutePlanNodes();
    Bundle localBundle = new Bundle();
    if ((localArrayList1 != null) && ((localRouteCustomDBObject.getDestType() != 3) || (localArrayList1.size() == 1))) {
      localArrayList1.add(0, BNGeoLocateManager.getInstance().getCurLocationNode());
    }
    if (localArrayList1.size() != 2) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localArrayList1);
    localBundle.putParcelableArrayList("nodesList", localArrayList2);
    localBundle.putInt("type", localRouteCustomDBObject.getId());
    return localBundle;
  }
  
  public RouteCustomDBObject getRouteCustomInfoById(int paramInt)
  {
    if (this.mRouteCustomObjList == null) {
      return null;
    }
    Iterator localIterator = this.mRouteCustomObjList.iterator();
    while (localIterator.hasNext())
    {
      RouteCustomDBObject localRouteCustomDBObject = (RouteCustomDBObject)localIterator.next();
      if (localRouteCustomDBObject.getId() == paramInt) {
        return localRouteCustomDBObject;
      }
    }
    return null;
  }
  
  public RouteCustomDBObject getRouteCustomInfoByPos(int paramInt)
  {
    if (this.mRouteCustomObjList == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.mRouteCustomObjList.size())) {
      return null;
    }
    return (RouteCustomDBObject)this.mRouteCustomObjList.get(paramInt);
  }
  
  public ArrayList<RouteCustomDBObject> getRouteCustomList()
  {
    return this.mRouteCustomObjList;
  }
  
  public int getRouteCustomSize()
  {
    return this.mRouteCustomObjList.size();
  }
  
  public ArrayList<RoutePlanNode> getRouteNodesListById(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = getRouteCustomInfoById(paramInt);
    Object localObject;
    if (localRouteCustomDBObject == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return (ArrayList<RoutePlanNode>)localObject;
        localArrayList = localRouteCustomDBObject.getRoutePlanNodes();
        localObject = localArrayList;
      } while (localArrayList == null);
      if (localRouteCustomDBObject.getDestType() != 3) {
        break;
      }
      localObject = localArrayList;
    } while (localArrayList.size() != 1);
    localArrayList.add(0, BNGeoLocateManager.getInstance().getCurLocationNode());
    return localArrayList;
  }
  
  public ArrayList<RoutePlanNode> getRouteNodesListByPos(int paramInt)
  {
    RouteCustomDBObject localRouteCustomDBObject = getRouteCustomInfoByPos(paramInt);
    Object localObject;
    if (localRouteCustomDBObject == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return (ArrayList<RoutePlanNode>)localObject;
        localArrayList = localRouteCustomDBObject.getRoutePlanNodes();
        localObject = localArrayList;
      } while (localArrayList == null);
      if (localRouteCustomDBObject.getDestType() != 3) {
        break;
      }
      localObject = localArrayList;
    } while (localArrayList.size() != 1);
    localArrayList.add(0, BNGeoLocateManager.getInstance().getCurLocationNode());
    return localArrayList;
  }
  
  public void removeRouteCustomByPos(int paramInt)
  {
    if (this.mRouteCustomObjList == null) {}
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.mRouteCustomObjList.size()) {
          localObject1 = (RouteCustomDBObject)this.mRouteCustomObjList.get(paramInt);
        }
      }
    } while (localObject1 == null);
    deleteCustomRoute(((RouteCustomDBObject)localObject1).getId());
    this.mRouteCustomObjList.remove(paramInt);
  }
  
  public void updateRouteCustomInfo(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.mRouteCustomObjList.size()) {
        localObject1 = (RouteCustomDBObject)this.mRouteCustomObjList.get(paramInt);
      }
    }
    if (localObject1 != null)
    {
      ((RouteCustomDBObject)localObject1).setModifiedTime(System.currentTimeMillis());
      this.mRouteCustomDBTable.beginTransaction();
      this.mRouteCustomDBTable.update((BaseDBObject)localObject1);
      this.mRouteCustomDBTable.endTransaction();
    }
  }
  
  public void updateRouteCustomInfo(RouteCustomDBObject paramRouteCustomDBObject)
  {
    if (paramRouteCustomDBObject != null)
    {
      paramRouteCustomDBObject.setModifiedTime(System.currentTimeMillis());
      this.mRouteCustomDBTable.beginTransaction();
      this.mRouteCustomDBTable.update(paramRouteCustomDBObject);
      this.mRouteCustomDBTable.endTransaction();
    }
  }
  
  static class InnerHolder
  {
    static RouteCustomModel mInstance = new RouteCustomModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/model/RouteCustomModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */