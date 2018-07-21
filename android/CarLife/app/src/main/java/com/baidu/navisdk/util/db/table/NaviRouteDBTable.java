package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.NaviRouteDBObject;

public class NaviRouteDBTable
  extends BaseDBTable<NaviRouteDBObject>
{
  public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS navi_route(navi_route_id INTEGER PRIMARY KEY AUTOINCREMENT,navi_route_time INTEGER);";
  public static final String ID = "navi_route_id";
  public static final String TABLE_NAME = "navi_route";
  public static final String TIME = "navi_route_time";
  public static final Object mMutex = new Object();
  
  public NaviRouteDBObject build(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    NaviRouteDBObject localNaviRouteDBObject = new NaviRouteDBObject();
    int i = paramCursor.getInt(paramCursor.getColumnIndex("navi_route_id"));
    long l = paramCursor.getLong(paramCursor.getColumnIndex("navi_route_time"));
    localNaviRouteDBObject.setId(i);
    localNaviRouteDBObject.setTime(l);
    return localNaviRouteDBObject;
  }
  
  public ContentValues deconstruct(NaviRouteDBObject paramNaviRouteDBObject)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramNaviRouteDBObject == null) {
      return localContentValues;
    }
    localContentValues.put("navi_route_time", Long.valueOf(paramNaviRouteDBObject.getTime()));
    return localContentValues;
  }
  
  public String getIdCumName()
  {
    return "navi_route_id";
  }
  
  public String getTableName()
  {
    return "navi_route";
  }
  
  public Object getmMutex()
  {
    return mMutex;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/table/NaviRouteDBTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */