package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.NaviRouteDBObject;

public class NaviRouteDBTable extends BaseDBTable<NaviRouteDBObject> {
    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS navi_route(navi_route_id INTEGER PRIMARY KEY AUTOINCREMENT,navi_route_time INTEGER);";
    public static final String ID = "navi_route_id";
    public static final String TABLE_NAME = "navi_route";
    public static final String TIME = "navi_route_time";
    public static final Object mMutex = new Object();

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdCumName() {
        return ID;
    }

    public Object getmMutex() {
        return mMutex;
    }

    public NaviRouteDBObject build(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        NaviRouteDBObject obj = new NaviRouteDBObject();
        int id = cursor.getInt(cursor.getColumnIndex(ID));
        long time = cursor.getLong(cursor.getColumnIndex(TIME));
        obj.setId(id);
        obj.setTime(time);
        return obj;
    }

    public ContentValues deconstruct(NaviRouteDBObject object) {
        ContentValues values = new ContentValues();
        if (object != null) {
            values.put(TIME, Long.valueOf(object.getTime()));
        }
        return values;
    }
}
