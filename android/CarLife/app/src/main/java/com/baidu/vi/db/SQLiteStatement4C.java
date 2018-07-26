package com.baidu.vi.db;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class SQLiteStatement4C {
    private SQLiteDatabase database;
    private HashMap<Integer, Object> parameterMap = new HashMap();
    private String strSQL;

    public SQLiteStatement4C(SQLiteDatabase db, String sql) {
        this.database = db;
        this.strSQL = sql;
    }

    public void bindNull(int index) {
        this.parameterMap.put(Integer.valueOf(index), null);
    }

    public void bind(int index, String value) {
        if (value == null || value.length() == 0) {
            bindNull(index);
        } else {
            this.parameterMap.put(Integer.valueOf(index), value);
        }
    }

    public void bind(int index, int value) {
        this.parameterMap.put(Integer.valueOf(index), Integer.valueOf(value));
    }

    public void bind(int index, double value) {
        this.parameterMap.put(Integer.valueOf(index), Double.valueOf(value));
    }

    public void bind(int index, byte[] value) {
        if (value.length == 0) {
            bindNull(index);
        } else {
            this.parameterMap.put(Integer.valueOf(index), value);
        }
    }

    public boolean execUpdate() {
        try {
            Object[] bindArgs = extractParameters();
            if (bindArgs == null || bindArgs.length == 0) {
                this.database.execSQL(this.strSQL);
            } else {
                this.database.execSQL(this.strSQL, bindArgs);
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private Object[] extractParameters() {
        ArrayList<Object> valuelist = new ArrayList();
        ArrayList<Integer> keyList = new ArrayList(this.parameterMap.keySet());
        Collections.sort(keyList);
        Iterator it = keyList.iterator();
        while (it.hasNext()) {
            valuelist.add(this.parameterMap.get((Integer) it.next()));
        }
        return valuelist.toArray();
    }

    private String[] extractStringParameters() {
        Object[] objArr = extractParameters();
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            try {
                strArr[i] = objArr[i].toString();
            } catch (Exception e) {
            }
        }
        return strArr;
    }

    public void clearBinds() {
        this.parameterMap.clear();
    }

    public void Close() {
    }
}
