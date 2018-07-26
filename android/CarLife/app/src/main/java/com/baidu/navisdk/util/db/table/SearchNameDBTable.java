package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.SearchNameDBObject;

public class SearchNameDBTable extends BaseDBTable<SearchNameDBObject> {
    public static final String COUNT = "search_count";
    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS search_name(search_name_id INTEGER PRIMARY KEY AUTOINCREMENT,search_name_name text,search_count INTEGER);";
    public static final String ID = "search_name_id";
    public static final String NAME = "search_name_name";
    public static final String TABLE_NAME = "search_name";
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

    public SearchNameDBObject build(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        SearchNameDBObject object = new SearchNameDBObject();
        object.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        object.setName(cursor.getString(cursor.getColumnIndex(NAME)));
        object.setCount(cursor.getInt(cursor.getColumnIndex(COUNT)));
        return object;
    }

    public ContentValues deconstruct(SearchNameDBObject object) {
        ContentValues values = new ContentValues();
        if (object != null) {
            values.put(NAME, object.getName());
            values.put(COUNT, Integer.valueOf(object.getCount()));
        }
        return values;
    }
}
