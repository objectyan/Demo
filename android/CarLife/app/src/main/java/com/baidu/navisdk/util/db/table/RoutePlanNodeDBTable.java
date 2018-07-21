package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;

public class RoutePlanNodeDBTable
  extends BaseDBTable<RoutePlanNodeDBObject>
{
  public static final String ARG1 = "arg1";
  public static final int ARG1_FOR_CONTINUENAVI = 1;
  public static final int ARG1_FOR_CUR_ROUTE_POIS = 5;
  public static final int ARG1_FOR_CUSTOMROUTE = 4;
  public static final int ARG1_FOR_NAVIDEST = 2;
  public static final int ARG1_FOR_NAVIROUTE = 3;
  public static final String ARG2 = "arg2";
  public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS route_plan_node(routeplan_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,description TEXT,latitude INTEGER DEFAULT 0,longitude INTEGER DEFAULT 0,is_from INTEGER DEFAULT 0, poi_origin_uid TEXT,arg1 INTEGER DEFAULT 0,arg2 INTEGER DEFAULT 0);";
  public static final String DESCRIPTION = "description";
  public static final String FROM = "is_from";
  public static final String ID = "routeplan_id";
  public static final String LATITUDE = "latitude";
  public static final String LONGITUDE = "longitude";
  public static final Object MUTEX = new Object();
  public static final String NAME = "name";
  public static final String POI_ORIGIN_UID = "poi_origin_uid";
  public static final String TABLE_NAME = "route_plan_node";
  
  public RoutePlanNodeDBObject build(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    int i = paramCursor.getColumnIndex("name");
    int j = paramCursor.getColumnIndex("description");
    int k = paramCursor.getColumnIndex("is_from");
    int m = paramCursor.getColumnIndex("latitude");
    int n = paramCursor.getColumnIndex("longitude");
    int i1 = paramCursor.getColumnIndex("poi_origin_uid");
    int i2 = paramCursor.getColumnIndex("routeplan_id");
    int i3 = paramCursor.getColumnIndex("arg1");
    int i4 = paramCursor.getColumnIndex("arg2");
    RoutePlanNodeDBObject localRoutePlanNodeDBObject = new RoutePlanNodeDBObject(paramCursor.getInt(m), paramCursor.getInt(n), paramCursor.getInt(k), paramCursor.getString(i), paramCursor.getString(j), paramCursor.getString(i1));
    localRoutePlanNodeDBObject.setId(paramCursor.getInt(i2));
    localRoutePlanNodeDBObject.setArg1(paramCursor.getInt(i3));
    localRoutePlanNodeDBObject.setArg2(paramCursor.getInt(i4));
    return localRoutePlanNodeDBObject;
  }
  
  public ContentValues deconstruct(RoutePlanNodeDBObject paramRoutePlanNodeDBObject)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramRoutePlanNodeDBObject == null) {
      return localContentValues;
    }
    localContentValues.put("name", paramRoutePlanNodeDBObject.mName);
    localContentValues.put("description", paramRoutePlanNodeDBObject.mDescription);
    localContentValues.put("is_from", Integer.valueOf(paramRoutePlanNodeDBObject.mFrom));
    localContentValues.put("latitude", Integer.valueOf(paramRoutePlanNodeDBObject.getLatitudeE6()));
    localContentValues.put("longitude", Integer.valueOf(paramRoutePlanNodeDBObject.getLongitudeE6()));
    localContentValues.put("arg1", Integer.valueOf(paramRoutePlanNodeDBObject.getArg1()));
    localContentValues.put("arg2", Integer.valueOf(paramRoutePlanNodeDBObject.getArg2()));
    if ((paramRoutePlanNodeDBObject.mUID != null) && (paramRoutePlanNodeDBObject.mUID.trim().length() > 0))
    {
      localContentValues.put("poi_origin_uid", paramRoutePlanNodeDBObject.mUID);
      return localContentValues;
    }
    localContentValues.put("poi_origin_uid", "");
    return localContentValues;
  }
  
  public String getIdCumName()
  {
    return "routeplan_id";
  }
  
  public String getTableName()
  {
    return "route_plan_node";
  }
  
  public Object getmMutex()
  {
    return MUTEX;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/table/RoutePlanNodeDBTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */