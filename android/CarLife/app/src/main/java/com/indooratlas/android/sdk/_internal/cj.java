package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class cj extends SQLiteOpenHelper {
    /* renamed from: a */
    private static AtomicInteger f23314a = new AtomicInteger();

    /* renamed from: com.indooratlas.android.sdk._internal.cj$a */
    interface C5837a {
        /* renamed from: a */
        public static final String[] f23313a = new String[]{"event"};
    }

    /* renamed from: a */
    public static synchronized cj m20218a(Context context) {
        cj cjVar;
        synchronized (cj.class) {
            f23314a.incrementAndGet();
            cjVar = new cj(context);
        }
        return cjVar;
    }

    private cj(Context context) {
        super(context, "com_indooratlas_sdk.db", null, 3);
        SQLiteDatabase a = m20220a();
        Object[] objArr = new Object[2];
        objArr[0] = a != null ? Integer.valueOf(a.getVersion()) : "null";
        objArr[1] = this;
    }

    public final synchronized void close() {
        Object[] objArr = new Object[]{Integer.valueOf(f23314a.decrementAndGet()), this};
        super.close();
    }

    public final void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL,data TEXT NOT NULL,sync_batch_id TEXT,sync_status TEXT)");
    }

    public final void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int i = 0;
        Object[] objArr = new Object[]{Integer.valueOf(oldVersion), Integer.valueOf(newVersion)};
        if (oldVersion != 3) {
            new Object[1][0] = Integer.valueOf(oldVersion);
            String[] strArr = C5837a.f23313a;
            int length = strArr.length;
            while (i < length) {
                db.execSQL("drop table if exists " + strArr[i]);
                i++;
            }
            onCreate(db);
        }
    }

    /* renamed from: a */
    public final SQLiteDatabase m20220a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
        } catch (SQLiteException e) {
            ee.m20409a("IAStorage", "Failed to get writable database: " + e.toString(), new Object[0]);
        }
        return sQLiteDatabase;
    }

    /* renamed from: b */
    public final SQLiteDatabase m20221b() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getReadableDatabase();
        } catch (SQLiteException e) {
            ee.m20409a("IAStorage", "Failed to get readable database: " + e.toString(), new Object[0]);
        }
        return sQLiteDatabase;
    }

    /* renamed from: a */
    public static void m20219a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (SQLiteException e) {
                new StringBuilder("endTransactionSafely, SQLiteException: ").append(e.toString());
            }
        }
    }

    /* renamed from: c */
    public final void m20222c() {
        try {
            SQLiteDatabase a = m20220a();
            if (a != null) {
                for (String delete : C5837a.f23313a) {
                    a.delete(delete, null, null);
                }
            }
            SQLiteDatabase a2 = m20220a();
            if (a2 != null) {
                onCreate(a2);
            }
        } catch (SQLiteException e) {
            ee.m20409a("IAStorage", "handleDatabaseFullException failed: " + e.toString(), new Object[0]);
        }
    }
}
