package com.baidu.android.pushservice.p025d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0538e;
import com.baidu.android.pushservice.p029h.C0542h;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0578p;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.d.c */
public class C0472c {
    /* renamed from: a */
    private static C0468c f1564a = null;
    /* renamed from: b */
    private static C0467b f1565b = null;
    /* renamed from: c */
    private static final Object f1566c = new Object();
    /* renamed from: d */
    private static int f1567d = 100;

    /* renamed from: com.baidu.android.pushservice.d.c$a */
    public enum C0466a {
        actionId,
        actionName,
        timeStamp,
        f1527d,
        pkgName,
        versionCode,
        versionName,
        status
    }

    /* renamed from: com.baidu.android.pushservice.d.c$b */
    private static class C0467b implements DatabaseErrorHandler {
        private C0467b() {
        }

        @TargetApi(16)
        /* renamed from: a */
        private void m2017a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    if (VERSION.SDK_INT > 18) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } else {
                        new File(str).delete();
                    }
                } catch (Exception e) {
                }
            }
        }

        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            Throwable th;
            List list;
            Throwable th2;
            if (sQLiteDatabase.isOpen()) {
                List list2 = null;
                try {
                    list2 = sQLiteDatabase.getAttachedDbs();
                } catch (SQLiteException e) {
                } catch (Throwable th3) {
                    th = th3;
                    list = list2;
                    th2 = th;
                    if (r0 == null) {
                        for (Pair pair : r0) {
                            m2017a((String) pair.second);
                        }
                    } else {
                        m2017a(sQLiteDatabase.getPath());
                    }
                    throw th2;
                }
                try {
                    sQLiteDatabase.close();
                } catch (SQLiteException e2) {
                } catch (Throwable th32) {
                    th = th32;
                    list = r1;
                    th2 = th;
                    if (r0 == null) {
                        m2017a(sQLiteDatabase.getPath());
                    } else {
                        while (r2.hasNext()) {
                            m2017a((String) pair.second);
                        }
                    }
                    throw th2;
                }
                if (r1 != null) {
                    for (Pair pair2 : r1) {
                        m2017a((String) pair2.second);
                    }
                    return;
                }
                m2017a(sQLiteDatabase.getPath());
                return;
            }
            m2017a(sQLiteDatabase.getPath());
        }
    }

    /* renamed from: com.baidu.android.pushservice.d.c$c */
    private static class C0468c extends SQLiteOpenHelper {
        /* renamed from: a */
        private static final String f1533a = ("CREATE TABLE PushShareInfo (" + C0470e.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0470e.PushPriority.name() + " LONG NOT NULL DEFAULT ((0)), " + C0470e.PushVersion.name() + " INTEGER DEFAULT ((0)), " + C0470e.PushChannelID.name() + " TEXT, " + C0470e.PushCurPkgName.name() + " TEXT, " + C0470e.PushWebAppBindInfo.name() + " TEXT, " + C0470e.PushLightAppBindInfo.name() + " TEXT, " + C0470e.PushSDKClientBindInfo.name() + " TEXT, " + C0470e.PushClientsBindInfo.name() + " TEXT, " + C0470e.PushSelfBindInfo.name() + " TEXT" + ");");
        /* renamed from: b */
        private static final String f1534b = ("CREATE TABLE PushVerifInfo (" + C0471f.verifId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0471f.msgId.name() + " TEXT NOT NULL, " + C0471f.md5Infos.name() + " TEXT NOT NULL, " + C0471f.appId.name() + " TEXT, " + C0471f.time.name() + " TEXT" + ");");
        /* renamed from: c */
        private static final String f1535c = ("CREATE TABLE PushMsgInfos (" + C0469d.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0469d.appId.name() + "  TEXT, " + C0469d.msgType.name() + "  INTEGER NOT NULL, " + C0469d.msgId.name() + " LONG NOT NULL, " + C0469d.secureInfo.name() + " TEXT, " + C0469d.msgBody.name() + "  TEXT, " + C0469d.expireTime.name() + "  LONG, " + C0469d.ackRet.name() + "  INTEGER, " + C0469d.arriveTime.name() + " LONG NOT NULL" + ");");
        /* renamed from: d */
        private static final String f1536d = ("CREATE TABLE PushAppStatus (" + C0466a.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0466a.actionName.name() + " TEXT NOT NULL, " + C0466a.timeStamp.name() + " LONG NOT NULL, " + C0466a.pkgName.name() + " TEXT, " + C0466a.versionCode.name() + " INTEGER, " + C0466a.versionName.name() + " TEXT, " + C0466a.status.name() + " INTEGER" + ");");

        public C0468c(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public C0468c(Context context, String str, CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        /* renamed from: a */
        private void m2018a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
            } catch (Exception e) {
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f1533a);
                sQLiteDatabase.execSQL(f1534b);
                sQLiteDatabase.execSQL(f1535c);
                sQLiteDatabase.execSQL(f1536d);
            } catch (Exception e) {
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 1) {
                m2018a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } else if (i == 2) {
                sQLiteDatabase.execSQL(f1535c);
                sQLiteDatabase.execSQL(f1536d);
            } else if (i == 3) {
                sQLiteDatabase.execSQL(f1536d);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.d.c$d */
    public enum C0469d {
        MsgInfoId,
        appId,
        msgType,
        msgId,
        arriveTime,
        secureInfo,
        msgBody,
        expireTime,
        ackRet
    }

    /* renamed from: com.baidu.android.pushservice.d.c$e */
    public enum C0470e {
        PushInfoId,
        PushPriority,
        PushVersion,
        PushChannelID,
        PushCurPkgName,
        PushWebAppBindInfo,
        PushLightAppBindInfo,
        PushSDKClientBindInfo,
        PushClientsBindInfo,
        PushSelfBindInfo
    }

    /* renamed from: com.baidu.android.pushservice.d.c$f */
    public enum C0471f {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    /* renamed from: a */
    public static synchronized long m2019a(Context context, C0464b c0464b) {
        long j;
        Cursor query;
        Throwable th;
        long j2 = -1;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                    j = -1;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C0470e.PushPriority.name(), Long.valueOf(c0464b.f1515a));
                    contentValues.put(C0470e.PushVersion.name(), Long.valueOf(c0464b.f1516b));
                    contentValues.put(C0470e.PushChannelID.name(), c0464b.f1517c);
                    contentValues.put(C0470e.PushCurPkgName.name(), c0464b.f1518d);
                    contentValues.put(C0470e.PushLightAppBindInfo.name(), c0464b.f1520f);
                    contentValues.put(C0470e.PushWebAppBindInfo.name(), c0464b.f1519e);
                    contentValues.put(C0470e.PushSDKClientBindInfo.name(), c0464b.f1521g);
                    contentValues.put(C0470e.PushClientsBindInfo.name(), c0464b.f1522h);
                    contentValues.put(C0470e.PushSelfBindInfo.name(), c0464b.f1523i);
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    j2 = (long) a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    C0578p.m2546b("pushadvertiseinfo:  update into database", context);
                                    C0578p.m2546b("updatePushInfo pushinfo:  insert into database,  clientinfo = " + c0464b.m2016a().toString(), context);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                        j = j2;
                                    }
                                    j = j2;
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                    j = j2;
                                    return j;
                                }
                                j = j2;
                                return j;
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        j2 = a.insert("PushShareInfo", null, contentValues);
                        C0578p.m2546b("pushadvertiseinfo:  insert into database", context);
                        C0578p.m2546b("updatePushInfo pushinfo:  insert into database,  clientinfo = " + c0464b.m2016a().toString(), context);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                            j = j2;
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                            j = j2;
                            return j;
                        }
                        j = j2;
                        return j;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                    j = j2;
                }
            }
        }
        return j;
    }

    /* renamed from: a */
    public static SQLiteDatabase m2020a(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        C0468c i = C0472c.m2042i(context);
        if (i != null) {
            try {
                sQLiteDatabase = i.getWritableDatabase();
            } catch (Throwable th) {
                C0553q.m2362a(context, th);
            }
        }
        return sQLiteDatabase;
    }

    /* renamed from: a */
    public static Object m2021a() {
        return f1566c;
    }

    /* renamed from: a */
    public static String m2022a(Context context, String str, String str2) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        try {
            String string;
            if (C0578p.m2584m(context, str) >= 52) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    query = contentResolver.query(Uri.parse("content://" + str + ".bdpush" + "/" + "verif"), new String[]{C0471f.md5Infos.name()}, C0471f.msgId.name() + "=?", new String[]{str2}, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                cursor = query;
                                string = query.getString(0);
                                if (cursor != null) {
                                    return string;
                                }
                                try {
                                    cursor.close();
                                    return string;
                                } catch (Exception e) {
                                    return string;
                                }
                            }
                        } catch (Throwable th2) {
                            cursor = query;
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                }
                            }
                            throw th;
                        }
                    }
                    cursor = query;
                    Object obj = null;
                    if (cursor != null) {
                        return string;
                    }
                    cursor.close();
                    return string;
                }
            }
            string = null;
            if (cursor != null) {
                return string;
            }
            cursor.close();
            return string;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static synchronized void m2023a(Context context, long j) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                } else {
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushPriority.name(), Long.valueOf(j));
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = j;
                        c0464b.f1516b = 0;
                        c0464b.f1517c = null;
                        c0464b.f1518d = null;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = null;
                        c0464b.f1522h = null;
                        c0464b.f1523i = null;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2024a(Context context, String str) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                } else {
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushChannelID.name(), str);
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = 0;
                        c0464b.f1516b = 0;
                        c0464b.f1517c = str;
                        c0464b.f1518d = null;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = null;
                        c0464b.f1522h = null;
                        c0464b.f1523i = null;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2025a(Context context, String str, int i, long j, byte[] bArr, byte[] bArr2, long j2, int i2) {
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0469d.appId.name(), str);
                contentValues.put(C0469d.msgId.name(), Long.valueOf(j));
                contentValues.put(C0469d.msgType.name(), Integer.valueOf(i));
                if (bArr != null && bArr.length > 0) {
                    contentValues.put(C0469d.msgBody.name(), BaiduAppSSOJni.getEncrypted(context, str, bArr));
                    contentValues.put(C0469d.secureInfo.name(), bArr2);
                    contentValues.put(C0469d.expireTime.name(), Long.valueOf(j2));
                }
                contentValues.put(C0469d.arriveTime.name(), Long.valueOf(System.currentTimeMillis()));
                contentValues.put(C0469d.ackRet.name(), Integer.valueOf(i2));
                a.insert("PushMsgInfos", null, contentValues);
            } catch (Exception e) {
            } finally {
                a.close();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2026a(Context context, List<C0542h> list) {
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                } else {
                    try {
                        a.beginTransaction();
                        a.delete("PushAppStatus", null, null);
                        for (C0542h c0542h : list) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(C0466a.actionName.name(), c0542h.d);
                            contentValues.put(C0466a.pkgName.name(), c0542h.j);
                            contentValues.put(C0466a.timeStamp.name(), Long.valueOf(c0542h.e));
                            contentValues.put(C0466a.versionCode.name(), Integer.valueOf(c0542h.f1792b));
                            contentValues.put(C0466a.versionName.name(), c0542h.f1791a);
                            contentValues.put(C0466a.status.name(), Integer.valueOf(c0542h.f1793c));
                            a.insert("PushAppStatus", null, contentValues);
                        }
                        a.setTransactionSuccessful();
                        a.endTransaction();
                        a.close();
                    } catch (Exception e) {
                        a.endTransaction();
                        a.close();
                    } catch (Throwable th) {
                        a.endTransaction();
                        a.close();
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static synchronized boolean m2027a(android.content.Context r12, com.baidu.android.pushservice.p025d.C0474e r13) {
        /*
        r4 = com.baidu.android.pushservice.p025d.C0472c.class;
        monitor-enter(r4);
        r5 = f1566c;	 Catch:{ all -> 0x00a2 }
        monitor-enter(r5);	 Catch:{ all -> 0x00a2 }
        r6 = com.baidu.android.pushservice.p025d.C0472c.m2020a(r12);	 Catch:{ all -> 0x009f }
        if (r6 != 0) goto L_0x0010;
    L_0x000c:
        r0 = 0;
        monitor-exit(r5);	 Catch:{ all -> 0x009f }
    L_0x000e:
        monitor-exit(r4);
        return r0;
    L_0x0010:
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x009f }
        r1.<init>();	 Catch:{ all -> 0x009f }
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0471f.msgId;	 Catch:{ all -> 0x009f }
        r0 = r0.name();	 Catch:{ all -> 0x009f }
        r2 = r13.f1568a;	 Catch:{ all -> 0x009f }
        r1.put(r0, r2);	 Catch:{ all -> 0x009f }
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0471f.md5Infos;	 Catch:{ all -> 0x009f }
        r0 = r0.name();	 Catch:{ all -> 0x009f }
        r2 = r13.f1569b;	 Catch:{ all -> 0x009f }
        r1.put(r0, r2);	 Catch:{ all -> 0x009f }
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0471f.appId;	 Catch:{ all -> 0x009f }
        r0 = r0.name();	 Catch:{ all -> 0x009f }
        r2 = r13.f1571d;	 Catch:{ all -> 0x009f }
        r1.put(r0, r2);	 Catch:{ all -> 0x009f }
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0471f.time;	 Catch:{ all -> 0x009f }
        r0 = r0.name();	 Catch:{ all -> 0x009f }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r2.<init>();	 Catch:{ all -> 0x009f }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x009f }
        r2 = r2.append(r8);	 Catch:{ all -> 0x009f }
        r3 = "";
        r2 = r2.append(r3);	 Catch:{ all -> 0x009f }
        r2 = r2.toString();	 Catch:{ all -> 0x009f }
        r1.put(r0, r2);	 Catch:{ all -> 0x009f }
        r2 = -1;
        r0 = 0;
        r7 = "PushVerifInfo";
        r8 = 0;
        r2 = r6.insert(r7, r8, r1);	 Catch:{ Exception -> 0x00a5, all -> 0x00b5 }
        r1 = "SELECT COUNT(*) FROM PushVerifInfo;";
        r7 = 0;
        r0 = r6.rawQuery(r1, r7);	 Catch:{ Exception -> 0x00a5, all -> 0x00b5 }
        r0.moveToFirst();	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
        r1 = 0;
        r1 = r0.getInt(r1);	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
        r7 = f1567d;	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
        if (r1 <= r7) goto L_0x0087;
    L_0x0076:
        r1 = "PushVerifInfo";
        r7 = " msgId IS NOT ?";
        r8 = 1;
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
        r9 = 0;
        r10 = r13.f1568a;	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
        r8[r9] = r10;	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
        r6.delete(r1, r7, r8);	 Catch:{ Exception -> 0x00a5, all -> 0x00ca }
    L_0x0087:
        if (r0 == 0) goto L_0x0092;
    L_0x0089:
        r1 = r0.isClosed();	 Catch:{ all -> 0x009f }
        if (r1 != 0) goto L_0x0092;
    L_0x008f:
        r0.close();	 Catch:{ all -> 0x009f }
    L_0x0092:
        r6.close();	 Catch:{ all -> 0x009f }
    L_0x0095:
        r0 = -1;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00c8;
    L_0x009b:
        r0 = 1;
    L_0x009c:
        monitor-exit(r5);	 Catch:{ all -> 0x009f }
        goto L_0x000e;
    L_0x009f:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x009f }
        throw r0;	 Catch:{ all -> 0x00a2 }
    L_0x00a2:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x00a5:
        r1 = move-exception;
        if (r0 == 0) goto L_0x00b1;
    L_0x00a8:
        r1 = r0.isClosed();	 Catch:{ all -> 0x009f }
        if (r1 != 0) goto L_0x00b1;
    L_0x00ae:
        r0.close();	 Catch:{ all -> 0x009f }
    L_0x00b1:
        r6.close();	 Catch:{ all -> 0x009f }
        goto L_0x0095;
    L_0x00b5:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x00b9:
        if (r1 == 0) goto L_0x00c4;
    L_0x00bb:
        r2 = r1.isClosed();	 Catch:{ all -> 0x009f }
        if (r2 != 0) goto L_0x00c4;
    L_0x00c1:
        r1.close();	 Catch:{ all -> 0x009f }
    L_0x00c4:
        r6.close();	 Catch:{ all -> 0x009f }
        throw r0;	 Catch:{ all -> 0x009f }
    L_0x00c8:
        r0 = 0;
        goto L_0x009c;
    L_0x00ca:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.c.a(android.content.Context, com.baidu.android.pushservice.d.e):boolean");
    }

    /* renamed from: b */
    public static int m2028b(Context context) {
        Throwable th;
        int i = 0;
        Cursor cursor = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return 0;
            }
            Cursor query;
            try {
                query = a.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        i = query.getInt(query.getColumnIndex(C0470e.PushPriority.name()));
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        r0 = i;
                    }
                } catch (Exception e) {
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        r0 = 0;
                        return r0;
                    }
                    r0 = i;
                    return r0;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    cursor.close();
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                query = null;
                if (query != null) {
                    if (query.isClosed()) {
                        query.close();
                    }
                }
                if (a != null) {
                    int i2;
                    a.close();
                    i2 = 0;
                    return i2;
                }
                i2 = i;
                return i2;
            } catch (Throwable th3) {
                th = th3;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            i2 = i;
        }
    }

    /* renamed from: b */
    public static String m2029b(Context context, String str, String str2) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        try {
            String string;
            if (C0578p.m2584m(context, str) >= 52) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    query = contentResolver.query(Uri.parse("content://" + str + ".bdpush" + "/" + "verif"), new String[]{C0471f.md5Infos.name()}, C0471f.md5Infos.name() + "=?", new String[]{str2}, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                cursor = query;
                                string = query.getString(0);
                                if (cursor != null) {
                                    return string;
                                }
                                try {
                                    cursor.close();
                                    return string;
                                } catch (Exception e) {
                                    return string;
                                }
                            }
                        } catch (Throwable th2) {
                            cursor = query;
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                }
                            }
                            throw th;
                        }
                    }
                    cursor = query;
                    Object obj = null;
                    if (cursor != null) {
                        return string;
                    }
                    cursor.close();
                    return string;
                }
            }
            string = null;
            if (cursor != null) {
                return string;
            }
            cursor.close();
            return string;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static synchronized void m2030b(Context context, long j) {
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                } else {
                    Cursor query;
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushVersion.name(), Long.valueOf(j));
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = 0;
                        c0464b.f1516b = j;
                        c0464b.f1517c = null;
                        c0464b.f1518d = null;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = null;
                        c0464b.f1522h = null;
                        c0464b.f1523i = null;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m2031b(Context context, String str) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                } else {
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushCurPkgName.name(), str);
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = 0;
                        c0464b.f1516b = 0;
                        c0464b.f1517c = null;
                        c0464b.f1518d = str;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = null;
                        c0464b.f1522h = null;
                        c0464b.f1523i = null;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static int m2032c(Context context) {
        Cursor query;
        int i;
        Throwable th;
        int i2 = 0;
        Cursor cursor = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return 0;
            }
            try {
                query = a.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        i2 = query.getInt(query.getColumnIndex(C0470e.PushVersion.name()));
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        i = i2;
                    }
                } catch (Exception e) {
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        i = 0;
                        return i;
                    }
                    i = i2;
                    return i;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    cursor.close();
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                query = null;
                if (query != null) {
                    if (query.isClosed()) {
                        query.close();
                    }
                }
                if (a != null) {
                    a.close();
                    i = 0;
                    return i;
                }
                i = i2;
                return i;
            } catch (Throwable th3) {
                th = th3;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            i = i2;
        }
    }

    /* renamed from: c */
    public static synchronized void m2033c(Context context, String str) {
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null || str == null) {
                } else {
                    Cursor query;
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushSDKClientBindInfo.name(), str);
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = 0;
                        c0464b.f1516b = 0;
                        c0464b.f1517c = null;
                        c0464b.f1518d = null;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = str;
                        c0464b.f1522h = null;
                        c0464b.f1523i = null;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static boolean m2034c(Context context, long j) {
        Throwable th;
        Cursor cursor = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return false;
            }
            Cursor query;
            try {
                query = a.query("PushMsgInfos", null, C0469d.msgId.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            a.close();
                            return true;
                        }
                    } catch (Exception e) {
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        a.close();
                        return false;
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                        if (!(cursor == null || cursor.isClosed())) {
                            cursor.close();
                        }
                        a.close();
                        throw th;
                    }
                }
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                a.close();
                return false;
            } catch (Exception e2) {
                query = null;
                query.close();
                a.close();
                return false;
            } catch (Throwable th3) {
                th = th3;
                cursor.close();
                a.close();
                throw th;
            }
        }
    }

    /* renamed from: d */
    public static String m2035d(Context context) {
        String str;
        Throwable th;
        Cursor cursor = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return null;
            }
            Cursor query;
            try {
                query = a.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        cursor = query.getString(query.getColumnIndex(C0470e.PushChannelID.name()));
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    a.close();
                    str = cursor;
                } catch (Exception e) {
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    a.close();
                    str = null;
                    return str;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    a.close();
                    throw th;
                }
            } catch (Exception e2) {
                query = null;
                if (query != null) {
                    if (query.isClosed()) {
                        query.close();
                    }
                }
                a.close();
                str = null;
                return str;
            } catch (Throwable th3) {
                th = th3;
                cursor.close();
                a.close();
                throw th;
            }
        }
    }

    /* renamed from: d */
    public static synchronized void m2036d(Context context, String str) {
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null || str == null) {
                } else {
                    Cursor query;
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushClientsBindInfo.name(), str);
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = 0;
                        c0464b.f1516b = 0;
                        c0464b.f1517c = null;
                        c0464b.f1518d = null;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = null;
                        c0464b.f1522h = str;
                        c0464b.f1523i = null;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public static String m2037e(Context context) {
        Cursor query;
        String str;
        Throwable th;
        Cursor cursor = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return null;
            }
            try {
                query = a.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        cursor = query.getString(query.getColumnIndex(C0470e.PushSDKClientBindInfo.name()));
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        str = cursor;
                    } else {
                        Object obj = cursor;
                    }
                } catch (Exception e) {
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a == null) {
                        str = null;
                    } else {
                        a.close();
                        str = null;
                    }
                    return str;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    cursor.close();
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                query = null;
                if (query != null) {
                    if (query.isClosed()) {
                        query.close();
                    }
                }
                if (a == null) {
                    a.close();
                    str = null;
                } else {
                    str = null;
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: e */
    public static synchronized void m2038e(Context context, String str) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null || str == null) {
                } else {
                    try {
                        query = a.query("PushShareInfo", null, null, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.getCount() != 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(C0470e.PushSelfBindInfo.name(), str);
                                    a.update("PushShareInfo", contentValues, C0470e.PushInfoId.name() + "=1", null);
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                    if (a != null) {
                                        a.close();
                                    }
                                }
                            } catch (Exception e) {
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                if (a != null) {
                                    a.close();
                                }
                            } catch (Throwable th2) {
                                cursor = query;
                                th = th2;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (a != null) {
                                    a.close();
                                }
                                throw th;
                            }
                        }
                        C0464b c0464b = new C0464b();
                        c0464b.f1515a = 0;
                        c0464b.f1516b = 0;
                        c0464b.f1517c = null;
                        c0464b.f1518d = null;
                        c0464b.f1520f = null;
                        c0464b.f1519e = null;
                        c0464b.f1521g = null;
                        c0464b.f1522h = null;
                        c0464b.f1523i = str;
                        C0472c.m2019a(context, c0464b);
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Exception e2) {
                        query = null;
                        if (query != null) {
                            if (query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor.close();
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: f */
    public static String m2039f(Context context) {
        Cursor query;
        String str;
        Throwable e;
        String str2 = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return null;
            }
            try {
                query = a.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndex(C0470e.PushClientsBindInfo.name()));
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        str = str2;
                    } else {
                        str = str2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0578p.m2546b("PushInfoDataBase*BBind*" + C0527a.m2215a(e), context);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        if (a == null) {
                            str = null;
                        } else {
                            a.close();
                            str = null;
                        }
                        return str;
                    } catch (Throwable th) {
                        e = th;
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                C0578p.m2546b("PushInfoDataBase*BBind*" + C0527a.m2215a(e), context);
                if (query != null) {
                    if (query.isClosed()) {
                        query.close();
                    }
                }
                if (a == null) {
                    a.close();
                    str = null;
                } else {
                    str = null;
                }
                return str;
            } catch (Throwable th2) {
                e = th2;
                query = null;
                query.close();
                if (a != null) {
                    a.close();
                }
                throw e;
            }
        }
    }

    /* renamed from: g */
    public static String m2040g(Context context) {
        Cursor query;
        String str;
        Throwable th;
        Cursor cursor = null;
        synchronized (f1566c) {
            SQLiteDatabase a = C0472c.m2020a(context);
            if (a == null) {
                return null;
            }
            try {
                query = a.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        cursor = query.getString(query.getColumnIndex(C0470e.PushSelfBindInfo.name()));
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a != null) {
                        a.close();
                        str = cursor;
                    } else {
                        Object obj = cursor;
                    }
                } catch (Exception e) {
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                    if (a == null) {
                        str = null;
                    } else {
                        a.close();
                        str = null;
                    }
                    return str;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    cursor.close();
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                query = null;
                if (query != null) {
                    if (query.isClosed()) {
                        query.close();
                    }
                }
                if (a == null) {
                    a.close();
                    str = null;
                } else {
                    str = null;
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: h */
    public static synchronized List<C0538e> m2041h(Context context) {
        List<C0538e> list;
        Cursor cursor = null;
        synchronized (C0472c.class) {
            synchronized (f1566c) {
                SQLiteDatabase a = C0472c.m2020a(context);
                if (a == null) {
                    list = cursor;
                } else {
                    List<C0538e> arrayList = new ArrayList();
                    try {
                        String name = C0466a.timeStamp.name();
                        cursor = a.query("PushAppStatus", null, null, null, null, null, name + " DESC");
                        if (cursor != null && cursor.getCount() > 0) {
                            int columnIndex = cursor.getColumnIndex(C0466a.actionName.name());
                            int columnIndex2 = cursor.getColumnIndex(C0466a.pkgName.name());
                            int columnIndex3 = cursor.getColumnIndex(name);
                            int columnIndex4 = cursor.getColumnIndex(C0466a.versionCode.name());
                            int columnIndex5 = cursor.getColumnIndex(C0466a.versionName.name());
                            int columnIndex6 = cursor.getColumnIndex(C0466a.status.name());
                            while (cursor.moveToNext()) {
                                C0538e c0538e = new C0538e();
                                c0538e.m2281a(cursor.getString(columnIndex));
                                c0538e.m2301h(cursor.getString(columnIndex2));
                                c0538e.m2280a(cursor.getLong(columnIndex3));
                                c0538e.m2295f(cursor.getInt(columnIndex4));
                                c0538e.m2303j(cursor.getString(columnIndex5));
                                c0538e.m2298g(cursor.getInt(columnIndex6));
                                arrayList.add(c0538e);
                            }
                        }
                        if (!(cursor == null || cursor.isClosed())) {
                            cursor.close();
                        }
                        a.close();
                    } catch (Exception e) {
                        if (cursor != null) {
                            if (!cursor.isClosed()) {
                                cursor.close();
                            }
                        }
                        a.close();
                    } catch (Throwable th) {
                        if (cursor != null) {
                            if (!cursor.isClosed()) {
                                cursor.close();
                            }
                        }
                        a.close();
                    }
                    list = arrayList;
                }
            }
        }
        return list;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private static com.baidu.android.pushservice.p025d.C0472c.C0468c m2042i(android.content.Context r9) {
        /*
        r0 = 0;
        r2 = f1566c;
        monitor-enter(r2);
        r1 = f1564a;	 Catch:{ all -> 0x00c3 }
        if (r1 != 0) goto L_0x00b5;
    L_0x0008:
        r1 = new java.io.File;	 Catch:{ all -> 0x00c3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c3 }
        r3.<init>();	 Catch:{ all -> 0x00c3 }
        r4 = android.os.Environment.getDataDirectory();	 Catch:{ all -> 0x00c3 }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x00c3 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c3 }
        r4 = "/data";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c3 }
        r4 = java.io.File.separator;	 Catch:{ all -> 0x00c3 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c3 }
        r4 = r9.getPackageName();	 Catch:{ all -> 0x00c3 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c3 }
        r4 = "/database";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c3 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c3 }
        r1.<init>(r3);	 Catch:{ all -> 0x00c3 }
        r3 = r1.exists();	 Catch:{ all -> 0x00c3 }
        if (r3 != 0) goto L_0x0047;
    L_0x0044:
        r1.mkdirs();	 Catch:{ all -> 0x00c3 }
    L_0x0047:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c3 }
        r3.<init>();	 Catch:{ all -> 0x00c3 }
        r1 = r1.getAbsolutePath();	 Catch:{ all -> 0x00c3 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x00c3 }
        r3 = java.io.File.separator;	 Catch:{ all -> 0x00c3 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x00c3 }
        r3 = "pushinfo.db";
        r1 = r1.append(r3);	 Catch:{ all -> 0x00c3 }
        r1 = r1.toString();	 Catch:{ all -> 0x00c3 }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00c3 }
        r4 = 11;
        if (r3 < r4) goto L_0x00b9;
    L_0x006b:
        r3 = new com.baidu.android.pushservice.d.c$b;	 Catch:{ all -> 0x00c3 }
        r4 = 0;
        r3.<init>();	 Catch:{ all -> 0x00c3 }
        f1565b = r3;	 Catch:{ all -> 0x00c3 }
        r3 = new com.baidu.android.pushservice.d.c$c;	 Catch:{ all -> 0x00c3 }
        r4 = 4;
        r5 = f1565b;	 Catch:{ all -> 0x00c3 }
        r3.<init>(r9, r1, r4, r5);	 Catch:{ all -> 0x00c3 }
        f1564a = r3;	 Catch:{ all -> 0x00c3 }
    L_0x007d:
        r1 = f1564a;	 Catch:{ Exception -> 0x00c6, all -> 0x00cd }
        r0 = r1.getWritableDatabase();	 Catch:{ Exception -> 0x00c6, all -> 0x00cd }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r1.<init>();	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r3 = com.baidu.android.pushservice.p025d.C0472c.C0469d.arriveTime;	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r3 = r3.name();	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r3 = " < ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r6 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r4 = r4 - r6;
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        r3 = "PushMsgInfos";
        r4 = 0;
        r0.delete(r3, r1, r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00d7 }
        if (r0 == 0) goto L_0x00b5;
    L_0x00b2:
        r0.close();	 Catch:{ all -> 0x00c3 }
    L_0x00b5:
        monitor-exit(r2);	 Catch:{ all -> 0x00c3 }
        r0 = f1564a;
        return r0;
    L_0x00b9:
        r3 = new com.baidu.android.pushservice.d.c$c;	 Catch:{ all -> 0x00c3 }
        r4 = 0;
        r5 = 4;
        r3.<init>(r9, r1, r4, r5);	 Catch:{ all -> 0x00c3 }
        f1564a = r3;	 Catch:{ all -> 0x00c3 }
        goto L_0x007d;
    L_0x00c3:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00c3 }
        throw r0;
    L_0x00c6:
        r1 = move-exception;
        if (r0 == 0) goto L_0x00b5;
    L_0x00c9:
        r0.close();	 Catch:{ all -> 0x00c3 }
        goto L_0x00b5;
    L_0x00cd:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x00d1:
        if (r1 == 0) goto L_0x00d6;
    L_0x00d3:
        r1.close();	 Catch:{ all -> 0x00c3 }
    L_0x00d6:
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x00d7:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.c.i(android.content.Context):com.baidu.android.pushservice.d.c$c");
    }
}
