package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;

public class RouteCustomDBTable extends BaseDBTable<RouteCustomDBObject> {
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

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdCumName() {
        return ID;
    }

    public Object getmMutex() {
        return mMutex;
    }

    public RouteCustomDBObject build(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        RouteCustomDBObject obj = new RouteCustomDBObject();
        int id = cursor.getInt(cursor.getColumnIndex(ID));
        int hisRouteId = cursor.getInt(cursor.getColumnIndex(HIS_ROUTE_ID));
        String name = cursor.getString(cursor.getColumnIndex(NAME));
        int isOpen = cursor.getInt(cursor.getColumnIndex(IS_OPEN));
        int pushTimeHour = cursor.getInt(cursor.getColumnIndex(PUSH_TIME_HOUR));
        int pushTimeMinute = cursor.getInt(cursor.getColumnIndex(PUSH_TIME_MINUTE));
        long pushTimeMills = cursor.getLong(cursor.getColumnIndex(PUSH_TIME_MILLS));
        long customTime = cursor.getLong(cursor.getColumnIndex(ROUTE_CUSTOM_TIME));
        long modifiedTime = cursor.getLong(cursor.getColumnIndex(ROUTE_MODIFIED_TIME));
        int type = cursor.getInt(cursor.getColumnIndex(DEST_TYPE));
        int isRepeat = cursor.getInt(cursor.getColumnIndex(IS_REPEAT));
        String dates = cursor.getString(cursor.getColumnIndex(REPEAT_DATE));
        obj.setId(id);
        obj.setHisRouteId(hisRouteId);
        obj.setName(name);
        obj.setOpen(isOpen);
        obj.setPushTimeHour(pushTimeHour);
        obj.setPushTimeMinute(pushTimeMinute);
        obj.setPushTimeMills(pushTimeMills);
        obj.setCustomTime(customTime);
        obj.setModifiedTime(modifiedTime);
        obj.setDestType(type);
        obj.setIsRepeat(isRepeat);
        obj.setRepeatDate(dates);
        return obj;
    }

    public ContentValues deconstruct(RouteCustomDBObject object) {
        ContentValues values = new ContentValues();
        if (object != null) {
            values.put(HIS_ROUTE_ID, Integer.valueOf(object.getHisRouteId()));
            values.put(NAME, object.getName());
            values.put(IS_OPEN, Integer.valueOf(object.getOpen()));
            values.put(PUSH_TIME_HOUR, Integer.valueOf(object.getPushTimeHour()));
            values.put(PUSH_TIME_MINUTE, Integer.valueOf(object.getPushTimeMinute()));
            values.put(PUSH_TIME_MILLS, Long.valueOf(object.getPushTimeMills()));
            values.put(ROUTE_CUSTOM_TIME, Long.valueOf(object.getCustomTime()));
            values.put(ROUTE_MODIFIED_TIME, Long.valueOf(object.getModifiedTime()));
            values.put(DEST_TYPE, Integer.valueOf(object.getDestType()));
            values.put(IS_REPEAT, Integer.valueOf(object.getIsRepeat()));
            values.put(REPEAT_DATE, object.getRepeatDate());
        }
        return values;
    }
}
