package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDBTable<T extends BaseDBObject> {
    public static final String ORDERBY_DOWN = "DESC";
    public static final String ORDERBY_UP = "ASC";
    private String id = getIdCumName();
    private String idcause = (this.id + "=?");
    private Object mMutex = getmMutex();
    private String mTableName = getTableName();

    public abstract T build(Cursor cursor);

    public abstract ContentValues deconstruct(T t);

    public abstract String getIdCumName();

    public abstract String getTableName();

    public abstract Object getmMutex();

    public int insert(T object) {
        synchronized (this.mMutex) {
            if (object != null) {
                if (DBManager.openDB()) {
                    object.setId((int) DBManager.getDB().insert(this.mTableName, null, deconstruct(object)));
                    DBManager.closeDB();
                }
            }
        }
        return -1;
    }

    public void insert(List<T> objects) {
        synchronized (this.mMutex) {
            if (objects != null) {
                if (objects.size() > 0 && DBManager.openDB()) {
                    DBManager.getDB().beginTransaction();
                    for (int i = 0; i < objects.size(); i++) {
                        insert((BaseDBObject) objects.get(i));
                    }
                    DBManager.getDB().endTransaction();
                    DBManager.closeDB();
                }
            }
        }
    }

    public void update(T object) {
        synchronized (this.mMutex) {
            if (object != null) {
                if (DBManager.openDB()) {
                    DBManager.getDB().update(this.mTableName, deconstruct(object), this.idcause, new String[]{object.getId() + ""});
                    DBManager.closeDB();
                }
            }
        }
    }

    public void delete(int id) {
        synchronized (this.mMutex) {
            if (DBManager.openDB()) {
                DBManager.getDB().delete(this.mTableName, this.idcause, new String[]{id + ""});
                DBManager.closeDB();
            }
        }
    }

    public void delete(String whereCause, String[] whereArgs) {
        synchronized (this.mMutex) {
            try {
                if (DBManager.openDB()) {
                    DBManager.getDB().delete(this.mTableName, whereCause, whereArgs);
                    DBManager.closeDB();
                }
            } catch (Exception e) {
            }
        }
    }

    public void deleteAll() {
        synchronized (this.mMutex) {
            if (DBManager.openDB()) {
                DBManager.getDB().delete(this.mTableName, null, null);
                DBManager.closeDB();
            }
        }
    }

    public T query(int id) {
        T queryOne;
        synchronized (this.mMutex) {
            queryOne = queryOne(this.idcause, new String[]{id + ""});
        }
        return queryOne;
    }

    public ArrayList<T> queryMulti(String whereCause, String[] whereArgs, String orderByWhichColumn, String orderBy) {
        ArrayList<T> objects = null;
        synchronized (this.mMutex) {
            if (DBManager.openDB()) {
                objects = buildMulti(DBManager.getDB().query(this.mTableName, null, whereCause, whereArgs, null, null, orderByWhichColumn + " " + orderBy));
                DBManager.closeDB();
            }
        }
        return objects;
    }

    public T queryOne(String whereCause, String[] whereArgs) {
        T object = null;
        synchronized (this.mMutex) {
            if (DBManager.openDB()) {
                object = buildOne(DBManager.getDB().query(this.mTableName, null, whereCause, whereArgs, null, null, null));
                DBManager.closeDB();
            }
        }
        return object;
    }

    public ArrayList<T> queryAll(String orderByWhichColum, String orderBy) {
        ArrayList<T> queryMulti;
        synchronized (this.mMutex) {
            queryMulti = queryMulti(null, null, orderByWhichColum, orderBy);
        }
        return queryMulti;
    }

    protected ArrayList<T> buildMulti(Cursor cursor) {
        Exception e;
        ArrayList<T> objects = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    ArrayList<T> objects2 = new ArrayList(cursor.getCount());
                    while (!cursor.isAfterLast()) {
                        try {
                            objects2.add(build(cursor));
                            cursor.moveToNext();
                        } catch (Exception e2) {
                            e = e2;
                            objects = objects2;
                        }
                    }
                    objects = objects2;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (objects != null) {
                    return objects;
                }
                return new ArrayList(0);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        if (objects != null) {
            return new ArrayList(0);
        }
        return objects;
    }

    protected T buildOne(Cursor cursor) {
        T object = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                object = build(cursor);
            }
            cursor.close();
        }
        return object;
    }

    public int getHighestID(String mTableName) {
        int id;
        synchronized (this.mMutex) {
            String query = "SELECT MAX(" + this.id + ") FROM " + mTableName;
            SQLiteDatabase db = DBManager.getDB();
            id = 0;
            if (db != null) {
                Cursor cur = db.rawQuery(query, null);
                cur.moveToFirst();
                id = cur.getInt(0);
                cur.close();
            }
        }
        return id;
    }

    public void beginTransaction() {
        DBManager.openDB();
    }

    public void endTransaction() {
        DBManager.closeDB();
    }
}
