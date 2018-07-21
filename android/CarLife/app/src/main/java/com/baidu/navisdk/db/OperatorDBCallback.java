package com.baidu.navisdk.db;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;

public abstract interface OperatorDBCallback
{
  public static abstract interface CalcRouteHistoryCallback
  {
    public abstract void onAddDest(RoutePlanNode paramRoutePlanNode);
    
    public abstract void onAddRoute(ArrayList<RoutePlanNode> paramArrayList);
    
    public abstract void onAddViaRoute(ArrayList<RoutePlanNode> paramArrayList);
  }
  
  public static abstract interface CurRoutePoiDBCallback
  {
    public abstract void onClear();
    
    public abstract void onRemoveVia(RoutePlanNode paramRoutePlanNode);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/db/OperatorDBCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */