package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;

public class FavoriteRoutePlanNodeDBTable extends BaseDBTable<RoutePlanNodeDBObject> {
    public static final String ARG1 = "arg1";
    public static final int ARG1_FOR_CONTINUENAVI = 1;
    public static final int ARG1_FOR_CUR_ROUTE_POIS = 5;
    public static final int ARG1_FOR_CUSTOMROUTE = 4;
    public static final int ARG1_FOR_NAVIDEST = 2;
    public static final int ARG1_FOR_NAVIROUTE = 3;
    public static final String ARG2 = "arg2";
    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS favorite_route_plan_node(routeplan_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,description TEXT,latitude INTEGER DEFAULT 0,longitude INTEGER DEFAULT 0,is_from INTEGER DEFAULT 0, poi_origin_uid TEXT,arg1 INTEGER DEFAULT 0,arg2 INTEGER DEFAULT 0);";
    public static final String DESCRIPTION = "description";
    public static final String FROM = "is_from";
    public static final String ID = "routeplan_id";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final Object MUTEX = new Object();
    public static final String NAME = "name";
    public static final String POI_ORIGIN_UID = "poi_origin_uid";
    public static final String TABLE_NAME = "favorite_route_plan_node";

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdCumName() {
        return "routeplan_id";
    }

    public Object getmMutex() {
        return MUTEX;
    }

    public RoutePlanNodeDBObject build(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        int name = cursor.getColumnIndex("name");
        int description = cursor.getColumnIndex("description");
        int from = cursor.getColumnIndex("is_from");
        int latitude = cursor.getColumnIndex("latitude");
        int longitude = cursor.getColumnIndex("longitude");
        int uid = cursor.getColumnIndex("poi_origin_uid");
        int id = cursor.getColumnIndex("routeplan_id");
        int arg1 = cursor.getColumnIndex("arg1");
        int arg2 = cursor.getColumnIndex("arg2");
        RoutePlanNodeDBObject object = new RoutePlanNodeDBObject(cursor.getInt(latitude), cursor.getInt(longitude), cursor.getInt(from), cursor.getString(name), cursor.getString(description), cursor.getString(uid));
        object.setId(cursor.getInt(id));
        object.setArg1(cursor.getInt(arg1));
        object.setArg2(cursor.getInt(arg2));
        return object;
    }

    public ContentValues deconstruct(RoutePlanNodeDBObject object) {
        ContentValues contentValues = new ContentValues();
        if (object != null) {
            contentValues.put("name", object.mName);
            contentValues.put("description", object.mDescription);
            contentValues.put("is_from", Integer.valueOf(object.mFrom));
            contentValues.put("latitude", Integer.valueOf(object.getLatitudeE6()));
            contentValues.put("longitude", Integer.valueOf(object.getLongitudeE6()));
            contentValues.put("arg1", Integer.valueOf(object.getArg1()));
            contentValues.put("arg2", Integer.valueOf(object.getArg2()));
            if (object.mUID == null || object.mUID.trim().length() <= 0) {
                contentValues.put("poi_origin_uid", "");
            } else {
                contentValues.put("poi_origin_uid", object.mUID);
            }
        }
        return contentValues;
    }
}
