package com.baidu.vi.db;

import android.database.Cursor;

public class SQLiteResultSet4C {
    private Cursor cursor;

    public SQLiteResultSet4C(Cursor cur) {
        this.cursor = cur;
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    public int getIntValue(int columnIndex) {
        return this.cursor.getInt(columnIndex);
    }

    public double getDoubleValue(int columnIndex) {
        return this.cursor.getDouble(columnIndex);
    }

    public String getStringValue(int columnIndex) {
        return this.cursor.getString(columnIndex);
    }

    public byte[] getBlobValue(int columnIndex) {
        return this.cursor.getBlob(columnIndex);
    }

    public boolean next() {
        return this.cursor.moveToNext();
    }

    public void close() {
        this.cursor.close();
    }
}
