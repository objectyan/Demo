package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;

public class RouteCustomDBTable
  extends BaseDBTable<RouteCustomDBObject>
{
  public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS route_custom(route_custom_id INTEGER PRIMARY KEY AUTOINCREMENT,his_route_id INTEGER, route_name TEXT, is_open INTEGER, push_time_hour INTEGER, push_time_minute INTEGER, push_time_mills INTEGER, route_custom_time INTEGER, route_modified_time INTEGER, dest_type INTEGER, is_repeat INTEGER, repeat_date TEXT );";
  public static final String DEST_TYPE = "dest_type";
  public static final String HIS_ROUTE_ID = "his_route_id";
  public static final String ID = "route_custom_id";
  public static final String IS_OPEN = "is_open";
  public static final String IS_REPEAT = "is_repeat";
  public static final String NAME = "route_name";
  public static final String PUSH_TIME_HOUR = "push_time_hour";
  public static final String PUSH_TIME_MILLS = "push_time_mills";
  public static final String PUSH_TIME_MINUTE = "push_time_minute";
  public static final String REPEAT_DATE = "repeat_date";
  public static final String ROUTE_CUSTOM_TIME = "route_custom_time";
  public static final String ROUTE_MODIFIED_TIME = "route_modified_time";
  public static final String TABLE_NAME = "route_custom";
  public static final Object mMutex = new Object();
  
  public RouteCustomDBObject build(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    RouteCustomDBObject localRouteCustomDBObject = new RouteCustomDBObject();
    int i = paramCursor.getInt(paramCursor.getColumnIndex("route_custom_id"));
    int j = paramCursor.getInt(paramCursor.getColumnIndex("his_route_id"));
    String str = paramCursor.getString(paramCursor.getColumnIndex("route_name"));
    int k = paramCursor.getInt(paramCursor.getColumnIndex("is_open"));
    int m = paramCursor.getInt(paramCursor.getColumnIndex("push_time_hour"));
    int n = paramCursor.getInt(paramCursor.getColumnIndex("push_time_minute"));
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("push_time_mills"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("route_custom_time"));
    long l3 = paramCursor.getLong(paramCursor.getColumnIndex("route_modified_time"));
    int i1 = paramCursor.getInt(paramCursor.getColumnIndex("dest_type"));
    int i2 = paramCursor.getInt(paramCursor.getColumnIndex("is_repeat"));
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("repeat_date"));
    localRouteCustomDBObject.setId(i);
    localRouteCustomDBObject.setHisRouteId(j);
    localRouteCustomDBObject.setName(str);
    localRouteCustomDBObject.setOpen(k);
    localRouteCustomDBObject.setPushTimeHour(m);
    localRouteCustomDBObject.setPushTimeMinute(n);
    localRouteCustomDBObject.setPushTimeMills(l1);
    localRouteCustomDBObject.setCustomTime(l2);
    localRouteCustomDBObject.setModifiedTime(l3);
    localRouteCustomDBObject.setDestType(i1);
    localRouteCustomDBObject.setIsRepeat(i2);
    localRouteCustomDBObject.setRepeatDate(paramCursor);
    return localRouteCustomDBObject;
  }
  
  public ContentValues deconstruct(RouteCustomDBObject paramRouteCustomDBObject)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramRouteCustomDBObject == null) {
      return localContentValues;
    }
    localContentValues.put("his_route_id", Integer.valueOf(paramRouteCustomDBObject.getHisRouteId()));
    localContentValues.put("route_name", paramRouteCustomDBObject.getName());
    localContentValues.put("is_open", Integer.valueOf(paramRouteCustomDBObject.getOpen()));
    localContentValues.put("push_time_hour", Integer.valueOf(paramRouteCustomDBObject.getPushTimeHour()));
    localContentValues.put("push_time_minute", Integer.valueOf(paramRouteCustomDBObject.getPushTimeMinute()));
    localContentValues.put("push_time_mills", Long.valueOf(paramRouteCustomDBObject.getPushTimeMills()));
    localContentValues.put("route_custom_time", Long.valueOf(paramRouteCustomDBObject.getCustomTime()));
    localContentValues.put("route_modified_time", Long.valueOf(paramRouteCustomDBObject.getModifiedTime()));
    localContentValues.put("dest_type", Integer.valueOf(paramRouteCustomDBObject.getDestType()));
    localContentValues.put("is_repeat", Integer.valueOf(paramRouteCustomDBObject.getIsRepeat()));
    localContentValues.put("repeat_date", paramRouteCustomDBObject.getRepeatDate());
    return localContentValues;
  }
  
  public String getIdCumName()
  {
    return "route_custom_id";
  }
  
  public String getTableName()
  {
    return "route_custom";
  }
  
  public Object getmMutex()
  {
    return mMutex;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/table/RouteCustomDBTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */