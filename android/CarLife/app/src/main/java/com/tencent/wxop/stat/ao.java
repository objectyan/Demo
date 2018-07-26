package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.tencent.wxop.stat.p291b.C6150s;
import java.util.ArrayList;
import java.util.List;

class ao extends SQLiteOpenHelper {
    /* renamed from: a */
    private String f24846a = "";
    /* renamed from: b */
    private Context f24847b = null;

    public ao(Context context, String str) {
        super(context, str, null, 3);
        this.f24846a = str;
        this.f24847b = context.getApplicationContext();
        if (C6156f.m21997b()) {
            ag.f24810h.m21825b("SQLiteOpenHelper " + this.f24846a);
        }
    }

    /* renamed from: a */
    private void m21798a(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        String str = null;
        try {
            query = sQLiteDatabase.query(BNRCEventDetailsModel.BN_RC_KEY_USER, null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", C6150s.m21923b(str));
                }
                if (str != null) {
                    sQLiteDatabase.update(BNRCEventDetailsModel.BN_RC_KEY_USER, contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    ag.f24810h.m21826b(th);
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private void m21799b(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        Cursor cursor;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            try {
                List<ap> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new ap(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
                }
                ContentValues contentValues = new ContentValues();
                for (ap apVar : arrayList) {
                    contentValues.put("content", C6150s.m21923b(apVar.f24849b));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(apVar.f24848a)});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ag.f24810h.m21833i("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m21798a(sQLiteDatabase);
            m21799b(sQLiteDatabase);
        }
        if (i == 2) {
            m21798a(sQLiteDatabase);
            m21799b(sQLiteDatabase);
        }
    }
}
