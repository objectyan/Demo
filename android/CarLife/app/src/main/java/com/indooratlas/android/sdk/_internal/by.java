package com.indooratlas.android.sdk._internal;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteStatement;
import java.io.IOException;
import java.util.Arrays;

public final class by implements cb {
    /* renamed from: a */
    private cj f23273a;

    public by(cj cjVar) {
        this.f23273a = cjVar;
    }

    /* renamed from: a */
    public final void mo4646a(bz... bzVarArr) throws IOException {
        SQLiteDatabase a;
        Object obj = null;
        try {
            cj cjVar = this.f23273a;
            SQLiteDatabase a2 = cjVar.m20220a();
            if (a2 != null) {
                try {
                    a2.beginTransaction();
                    SQLiteStatement compileStatement = a2.compileStatement("insert into event (type, data, sync_status) values (?, ?, 'local')");
                    for (int i = 0; i <= 0; i++) {
                        bz bzVar = bzVarArr[0];
                        compileStatement.bindLong(1, (long) bzVar.f23274a);
                        compileStatement.bindString(2, bzVar.m20194a());
                        compileStatement.execute();
                    }
                    a2.setTransactionSuccessful();
                    new Object[1][0] = Arrays.toString(bzVarArr);
                } catch (SQLiteFullException e) {
                    ee.m20409a("IAStorage", "bulkInsert, SQLiteFullException: " + e.toString(), new Object[0]);
                    cjVar.m20222c();
                    a = cjVar.m20220a();
                    if (a != null) {
                        try {
                            if (DatabaseUtils.queryNumEntries(a, "event") > 1000) {
                                obj = 1;
                            }
                            if (obj != null) {
                                a.beginTransaction();
                                a.execSQL("delete from event where _id >= (select _id from event limit 1 offset 1000)");
                                a.setTransactionSuccessful();
                            }
                            if (obj != null) {
                                cj.m20219a(a);
                            }
                        } catch (SQLiteException e2) {
                            ee.m20409a("IAStorage", "Failed to recycle: " + e2.toString(), new Object[0]);
                            if (null != null) {
                                cj.m20219a(a);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            if (null != null) {
                                cj.m20219a(a);
                            }
                        }
                    }
                } catch (SQLiteException e22) {
                    ee.m20409a("IAStorage", "bulkInsert, SQLiteException: " + e22.toString(), new Object[0]);
                } finally {
                    cj.m20219a(a2);
                }
                a = cjVar.m20220a();
                if (a != null) {
                    if (DatabaseUtils.queryNumEntries(a, "event") > 1000) {
                        obj = 1;
                    }
                    if (obj != null) {
                        a.beginTransaction();
                        a.execSQL("delete from event where _id >= (select _id from event limit 1 offset 1000)");
                        a.setTransactionSuccessful();
                    }
                    if (obj != null) {
                        cj.m20219a(a);
                    }
                }
            }
        } catch (Throwable e3) {
            throw new IOException(e3);
        } catch (IllegalStateException e4) {
        }
    }

    public final void close() throws IOException {
    }
}
