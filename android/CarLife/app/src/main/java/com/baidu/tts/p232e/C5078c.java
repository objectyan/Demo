package com.baidu.tts.p232e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: SynthesizeResultDb */
/* renamed from: com.baidu.tts.e.c */
public class C5078c {
    /* renamed from: a */
    private static C5078c f20991a;
    /* renamed from: b */
    private C5077a f20992b;
    /* renamed from: c */
    private ReadWriteLock f20993c = new ReentrantReadWriteLock();
    /* renamed from: d */
    private Lock f20994d = this.f20993c.writeLock();
    /* renamed from: e */
    private Lock f20995e = this.f20993c.readLock();
    /* renamed from: f */
    private Context f20996f;

    /* compiled from: SynthesizeResultDb */
    /* renamed from: com.baidu.tts.e.c$a */
    class C5077a extends SQLiteOpenHelper {
        /* renamed from: a */
        final /* synthetic */ C5078c f20990a;

        public C5077a(C5078c c5078c, Context context) {
            this.f20990a = c5078c;
            super(context, "ttsdata", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table result (_id integer primary key autoincrement, time text, code integer, cmd_type integer, cmd_id integer, result text);");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS result");
            onCreate(db);
        }
    }

    private C5078c(Context context) {
        this.f20996f = context;
        this.f20992b = new C5077a(this, this.f20996f);
    }

    /* renamed from: a */
    public static C5078c m17232a(Context context) {
        if (f20991a == null) {
            synchronized (C5078c.class) {
                if (f20991a == null) {
                    f20991a = new C5078c(context);
                }
            }
        }
        return f20991a;
    }

    /* renamed from: a */
    public void m17236a(long j, int i, int i2, int i3, String str) {
        this.f20994d.lock();
        SQLiteDatabase c = m17233c();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BaiduNaviParams.KEY_TIME, Long.valueOf(j));
            contentValues.put("code", Integer.valueOf(i));
            contentValues.put("cmd_type", Integer.valueOf(i2));
            contentValues.put("cmd_id", Integer.valueOf(i3));
            contentValues.put("result", str);
            c.insert("result", null, contentValues);
        } catch (SQLiteException e) {
            LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + e.toString());
        } catch (IllegalStateException e2) {
            LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + e2.toString());
        } catch (Exception e3) {
            LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + e3.toString());
        } finally {
            c.close();
            this.f20994d.unlock();
        }
    }

    /* renamed from: a */
    public int m17235a() {
        Cursor query;
        int count;
        SQLiteException sQLiteException;
        Throwable th;
        IllegalStateException illegalStateException;
        Exception exception;
        Cursor cursor = null;
        this.f20995e.lock();
        SQLiteDatabase d = m17234d();
        if (d != null) {
            try {
                query = d.query("result", new String[]{"_id", BaiduNaviParams.KEY_TIME, "code", "cmd_type", "cmd_id", "result"}, null, null, null, null, null);
                try {
                    count = query.getCount();
                } catch (SQLiteException e) {
                    cursor = query;
                    sQLiteException = e;
                    try {
                        LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + sQLiteException.toString());
                        cursor.close();
                        d.close();
                        this.f20995e.unlock();
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor.close();
                        d.close();
                        this.f20995e.unlock();
                        throw th;
                    }
                } catch (IllegalStateException e2) {
                    cursor = query;
                    illegalStateException = e2;
                    LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + illegalStateException.toString());
                    cursor.close();
                    d.close();
                    this.f20995e.unlock();
                    return 0;
                } catch (Exception e3) {
                    cursor = query;
                    exception = e3;
                    LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + exception.toString());
                    cursor.close();
                    d.close();
                    this.f20995e.unlock();
                    return 0;
                } catch (Throwable th3) {
                    cursor = query;
                    th = th3;
                    cursor.close();
                    d.close();
                    this.f20995e.unlock();
                    throw th;
                }
            } catch (SQLiteException e4) {
                sQLiteException = e4;
                LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + sQLiteException.toString());
                cursor.close();
                d.close();
                this.f20995e.unlock();
                return 0;
            } catch (IllegalStateException e5) {
                illegalStateException = e5;
                LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + illegalStateException.toString());
                cursor.close();
                d.close();
                this.f20995e.unlock();
                return 0;
            } catch (Exception e6) {
                exception = e6;
                LoggerProxy.m17001d("SynthesizeResultDb", "exception:" + exception.toString());
                cursor.close();
                d.close();
                this.f20995e.unlock();
                return 0;
            }
        }
        query = null;
        count = 0;
        query.close();
        d.close();
        this.f20995e.unlock();
        return count;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public java.util.Map<java.lang.String, java.util.ArrayList> m17238b() {
        /*
        r18 = this;
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = new java.util.ArrayList;
        r5.<init>();
        r0 = r18;
        r2 = r0.f20995e;
        r2.lock();
        r6 = r18.m17234d();
        r2 = "select * from result limit 0,500";
        r7 = 0;
        r7 = r6.rawQuery(r2, r7);
    L_0x0022:
        r2 = r7.moveToNext();	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        if (r2 == 0) goto L_0x0106;
    L_0x0028:
        r2 = new org.json.JSONObject;	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        r8 = "_id";
        r8 = r7.getColumnIndex(r8);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r8 = r7.getInt(r8);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r9 = "time";
        r9 = r7.getColumnIndex(r9);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r9 = r7.getString(r9);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r10 = "code";
        r10 = r7.getColumnIndex(r10);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r10 = r7.getInt(r10);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r11 = "cmd_type";
        r11 = r7.getColumnIndex(r11);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r11 = r7.getInt(r11);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r12 = "cmd_id";
        r12 = r7.getColumnIndex(r12);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r12 = r7.getInt(r12);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r13 = "result";
        r13 = r7.getColumnIndex(r13);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r13 = r7.getString(r13);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r14 = "time";
        r16 = java.lang.Long.parseLong(r9);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r0 = r16;
        r2.put(r14, r0);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r9 = "error_code";
        r2.put(r9, r10);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        if (r10 != 0) goto L_0x0095;
    L_0x0083:
        r9 = "cmd_type";
        r2.put(r9, r11);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r9 = "cmd_id";
        r2.put(r9, r12);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r9 = "voice_to_text_result";
        r2.put(r9, r13);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
    L_0x0095:
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r5.add(r8);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        r4.add(r2);	 Catch:{ JSONException -> 0x00a0, Exception -> 0x00d3, SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9 }
        goto L_0x0022;
    L_0x00a0:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        goto L_0x0022;
    L_0x00a6:
        r2 = move-exception;
        r4 = "SynthesizeResultDb";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014d }
        r5.<init>();	 Catch:{ all -> 0x014d }
        r8 = "exception:";
        r5 = r5.append(r8);	 Catch:{ all -> 0x014d }
        r2 = r2.toString();	 Catch:{ all -> 0x014d }
        r2 = r5.append(r2);	 Catch:{ all -> 0x014d }
        r2 = r2.toString();	 Catch:{ all -> 0x014d }
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r4, r2);	 Catch:{ all -> 0x014d }
        r7.close();
        r6.close();
        r0 = r18;
        r2 = r0.f20995e;
        r2.unlock();
    L_0x00d2:
        return r3;
    L_0x00d3:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        goto L_0x0022;
    L_0x00d9:
        r2 = move-exception;
        r4 = "SynthesizeResultDb";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014d }
        r5.<init>();	 Catch:{ all -> 0x014d }
        r8 = "exception:";
        r5 = r5.append(r8);	 Catch:{ all -> 0x014d }
        r2 = r2.toString();	 Catch:{ all -> 0x014d }
        r2 = r5.append(r2);	 Catch:{ all -> 0x014d }
        r2 = r2.toString();	 Catch:{ all -> 0x014d }
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r4, r2);	 Catch:{ all -> 0x014d }
        r7.close();
        r6.close();
        r0 = r18;
        r2 = r0.f20995e;
        r2.unlock();
        goto L_0x00d2;
    L_0x0106:
        r2 = "listId";
        r3.put(r2, r5);	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        r2 = "list";
        r3.put(r2, r4);	 Catch:{ SQLiteException -> 0x00a6, IllegalStateException -> 0x00d9, Exception -> 0x0120 }
        r7.close();
        r6.close();
        r0 = r18;
        r2 = r0.f20995e;
        r2.unlock();
        goto L_0x00d2;
    L_0x0120:
        r2 = move-exception;
        r4 = "SynthesizeResultDb";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014d }
        r5.<init>();	 Catch:{ all -> 0x014d }
        r8 = "exception:";
        r5 = r5.append(r8);	 Catch:{ all -> 0x014d }
        r2 = r2.toString();	 Catch:{ all -> 0x014d }
        r2 = r5.append(r2);	 Catch:{ all -> 0x014d }
        r2 = r2.toString();	 Catch:{ all -> 0x014d }
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r4, r2);	 Catch:{ all -> 0x014d }
        r7.close();
        r6.close();
        r0 = r18;
        r2 = r0.f20995e;
        r2.unlock();
        goto L_0x00d2;
    L_0x014d:
        r2 = move-exception;
        r7.close();
        r6.close();
        r0 = r18;
        r3 = r0.f20995e;
        r3.unlock();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.e.c.b():java.util.Map<java.lang.String, java.util.ArrayList>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m17237a(java.util.List<java.lang.Integer> r6) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0009;
    L_0x0003:
        r1 = r6.size();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r1 = r5.f20994d;
        r1.lock();
        r2 = r5.m17234d();
        r1 = "";
    L_0x0016:
        r3 = r6.size();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        if (r0 >= r3) goto L_0x003b;
    L_0x001c:
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r1 = r3.append(r1);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3 = r6.get(r0);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r1 = r1.append(r3);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3 = ",";
        r1 = r1.append(r3);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r1 = r1.toString();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r0 = r0 + 1;
        goto L_0x0016;
    L_0x003b:
        r0 = r1.length();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        if (r0 <= 0) goto L_0x006e;
    L_0x0041:
        r0 = 0;
        r3 = r1.length();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3 = r3 + -1;
        r0 = r1.substring(r0, r3);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r1 = "result";
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r4 = "_id in (";
        r3 = r3.append(r4);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r0 = r3.append(r0);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3 = ")";
        r0 = r0.append(r3);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r0 = r0.toString();	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
        r3 = 0;
        r2.delete(r1, r0, r3);	 Catch:{ SQLiteException -> 0x0077, IllegalStateException -> 0x00a0, Exception -> 0x00c9 }
    L_0x006e:
        r2.close();
        r0 = r5.f20994d;
        r0.unlock();
        goto L_0x0009;
    L_0x0077:
        r0 = move-exception;
        r1 = "SynthesizeResultDb";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
        r3.<init>();	 Catch:{ all -> 0x00f2 }
        r4 = "exception:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00f2 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00f2 }
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r1, r0);	 Catch:{ all -> 0x00f2 }
        r2.close();
        r0 = r5.f20994d;
        r0.unlock();
        goto L_0x0009;
    L_0x00a0:
        r0 = move-exception;
        r1 = "SynthesizeResultDb";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
        r3.<init>();	 Catch:{ all -> 0x00f2 }
        r4 = "exception:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00f2 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00f2 }
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r1, r0);	 Catch:{ all -> 0x00f2 }
        r2.close();
        r0 = r5.f20994d;
        r0.unlock();
        goto L_0x0009;
    L_0x00c9:
        r0 = move-exception;
        r1 = "SynthesizeResultDb";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
        r3.<init>();	 Catch:{ all -> 0x00f2 }
        r4 = "exception:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00f2 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00f2 }
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r1, r0);	 Catch:{ all -> 0x00f2 }
        r2.close();
        r0 = r5.f20994d;
        r0.unlock();
        goto L_0x0009;
    L_0x00f2:
        r0 = move-exception;
        r2.close();
        r1 = r5.f20994d;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.e.c.a(java.util.List):void");
    }

    /* renamed from: c */
    private SQLiteDatabase m17233c() {
        return this.f20992b.getWritableDatabase();
    }

    /* renamed from: d */
    private SQLiteDatabase m17234d() {
        return this.f20992b.getReadableDatabase();
    }
}
