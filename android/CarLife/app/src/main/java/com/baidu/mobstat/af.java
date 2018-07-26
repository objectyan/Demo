package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class af extends SQLiteOpenHelper {
    /* renamed from: a */
    private String f19382a;
    /* renamed from: b */
    private SQLiteDatabase f19383b;

    public af(Context context, String str) {
        super(context, ".confd", null, 1);
        this.f19382a = str;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f19383b = sQLiteDatabase;
    }

    /* renamed from: a */
    public synchronized boolean m15304a() {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            if (this.f19383b == null) {
                z2 = true;
            } else if (this.f19383b.isOpen()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                try {
                    this.f19383b = getWritableDatabase();
                } catch (NullPointerException e) {
                    throw new NullPointerException("db path is null");
                }
            }
            if (this.f19383b == null || !this.f19383b.isOpen()) {
                z = false;
            }
        }
        return z;
    }

    public synchronized void close() {
        super.close();
        if (this.f19383b != null) {
            this.f19383b.close();
            this.f19383b = null;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: a */
    public void m15303a(String str) {
        getWritableDatabase().execSQL(str);
    }

    /* renamed from: b */
    public final int m15305b() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.f19383b.rawQuery("SELECT COUNT(*) FROM " + this.f19382a, null);
            if (cursor == null || !cursor.moveToNext()) {
                if (cursor != null) {
                    cursor.close();
                }
                return i;
            }
            i = cursor.getInt(0);
            return i;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: a */
    public Cursor m15302a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.f19383b.query(this.f19382a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    /* renamed from: a */
    public long m15301a(String str, ContentValues contentValues) {
        return this.f19383b.insert(this.f19382a, str, contentValues);
    }

    /* renamed from: a */
    public int m15300a(String str, String[] strArr) {
        return this.f19383b.delete(this.f19382a, str, strArr);
    }
}
