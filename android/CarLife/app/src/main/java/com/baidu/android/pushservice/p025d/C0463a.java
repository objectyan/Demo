package com.baidu.android.pushservice.p025d;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.pushservice.p029h.C0533a;
import com.baidu.android.pushservice.p029h.C0536b;
import com.baidu.android.pushservice.p029h.C0539f;
import com.baidu.android.pushservice.p029h.C0543i;
import com.baidu.android.pushservice.p029h.C0544j;
import com.baidu.android.pushservice.p029h.C0545k;
import com.baidu.android.pushservice.p031j.C0578p;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.d.a */
public class C0463a {
    /* renamed from: a */
    private static C0457e f1511a = null;
    /* renamed from: b */
    private static C0456d f1512b = null;
    /* renamed from: c */
    private static final Object f1513c = new Object();
    /* renamed from: d */
    private static int f1514d = 100;

    /* renamed from: com.baidu.android.pushservice.d.a$a */
    enum C0453a {
        alarmMsgInfoId,
        msgId,
        sendtime,
        showtime,
        expiretime,
        msgEnable,
        isAlarm
    }

    /* renamed from: com.baidu.android.pushservice.d.a$b */
    enum C0454b {
        appInfoId,
        f1439b,
        appType,
        f1441d,
        appName,
        cFrom,
        versionCode,
        versionName,
        intergratedPushVersion
    }

    /* renamed from: com.baidu.android.pushservice.d.a$c */
    enum C0455c {
        actionId,
        actionName,
        timeStamp,
        networkStatus,
        msgType,
        msgId,
        msgLen,
        errorMsg,
        requestId,
        stableHeartInterval,
        errorCode,
        f1459l,
        channel,
        openByPackageName,
        f1462o
    }

    /* renamed from: com.baidu.android.pushservice.d.a$d */
    private static class C0456d implements DatabaseErrorHandler {
        private C0456d() {
        }

        @TargetApi(16)
        /* renamed from: a */
        private void m1982a(String str) {
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
                            m1982a((String) pair.second);
                        }
                    } else {
                        m1982a(sQLiteDatabase.getPath());
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
                        m1982a(sQLiteDatabase.getPath());
                    } else {
                        while (r2.hasNext()) {
                            m1982a((String) pair.second);
                        }
                    }
                    throw th2;
                }
                if (r1 != null) {
                    for (Pair pair2 : r1) {
                        m1982a((String) pair2.second);
                    }
                    return;
                }
                m1982a(sQLiteDatabase.getPath());
                return;
            }
            m1982a(sQLiteDatabase.getPath());
        }
    }

    /* renamed from: com.baidu.android.pushservice.d.a$e */
    private static class C0457e extends SQLiteOpenHelper {
        /* renamed from: a */
        private static final String f1464a = ("CREATE TABLE StatisticsInfo (" + C0462j.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0462j.f1503b.name() + " TEXT NOT NULL, " + C0462j.open_type.name() + " TEXT NOT NULL, " + C0462j.msgid.name() + " TEXT, " + C0462j.app_open_time.name() + " TEXT NOT NULL, " + C0462j.app_close_time.name() + " TEXT NOT NULL, " + C0462j.use_duration.name() + " TEXT NOT NULL, " + C0462j.extra.name() + " TEXT" + ");");
        /* renamed from: b */
        private static final String f1465b = ("CREATE TABLE PushBehavior (" + C0455c.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0455c.actionName.name() + " TEXT NOT NULL, " + C0455c.timeStamp.name() + " LONG NOT NULL, " + C0455c.networkStatus.name() + " TEXT, " + C0455c.msgType.name() + " INTEGER, " + C0455c.msgId.name() + " TEXT, " + C0455c.msgLen.name() + " INTEGER, " + C0455c.errorMsg.name() + " TEXT, " + C0455c.requestId.name() + " TEXT, " + C0455c.stableHeartInterval.name() + " INTEGER, " + C0455c.errorCode.name() + " INTEGER, " + C0455c.f1459l.name() + " TEXT, " + C0455c.channel.name() + " TEXT, " + C0455c.f1462o.name() + " TEXT, " + C0455c.openByPackageName.name() + " TEXT" + ");");
        /* renamed from: c */
        private static final String f1466c = ("CREATE TABLE MsgArriveApp (" + C0460h.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0460h.msgId.name() + " TEXT NOT NULL, " + C0460h.timeStamp.name() + " LONG NOT NULL" + ");");
        /* renamed from: d */
        private static final String f1467d = ("CREATE TABLE AlarmMsgInfo (" + C0453a.alarmMsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0453a.msgId.name() + " TEXT NOT NULL, " + C0453a.sendtime.name() + " LONG NOT NULL, " + C0453a.showtime.name() + " LONG NOT NULL, " + C0453a.expiretime.name() + " LONG NOT NULL, " + C0453a.msgEnable.name() + " INTEGER, " + C0453a.isAlarm.name() + " INTEGER" + ");");
        /* renamed from: e */
        private static final String f1468e = ("CREATE TABLE AppInfo (" + C0454b.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C0454b.f1439b.name() + " TEXT, " + C0454b.appType.name() + " INTEGER, " + C0454b.f1441d.name() + " TEXT UNIQUE, " + C0454b.appName.name() + " TEXT, " + C0454b.cFrom.name() + " TEXT, " + C0454b.versionCode.name() + " TEXT, " + C0454b.versionName.name() + " TEXT, " + C0454b.intergratedPushVersion.name() + " TEXT" + ");");
        /* renamed from: f */
        private static final String f1469f = ("CREATE TABLE FileDownloadingInfo (" + C0458f.belongTo.name() + " TEXT, " + C0458f.downloadUrl.name() + " TEXT PRIMARY KEY, " + C0458f.savePath.name() + " TEXT NOT NULL, " + C0458f.title.name() + " TEXT, " + C0458f.description.name() + " TEXT, " + C0458f.fileName.name() + " TEXT NOT NULL, " + C0458f.downloadBytes.name() + " INTEGER NOT NULL, " + C0458f.totalBytes.name() + " INTEGER NOT NULL, " + C0458f.downloadStatus.name() + " INTEGER NOT NULL," + C0458f.timeStamp.name() + " INTEGER NOT NULL" + ");");
        /* renamed from: g */
        private static final String f1470g = ("CREATE TABLE NoDisturb (" + C0461i.pkgName.name() + " TEXT NOT NULL, " + C0461i.startHour.name() + " INTEGER, " + C0461i.startMinute.name() + " INTEGER, " + C0461i.endHour.name() + " INTEGER, " + C0461i.endMinute.name() + " INTEGER" + ");");

        public C0457e(Context context, String str, int i) {
            super(context, str, null, i);
        }

        public C0457e(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        /* renamed from: a */
        private void m1983a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS StatisticsInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS FileDownloadingInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushBehavior");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AlarmMsgInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS NoDisturb");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgArriveApp");
            } catch (Exception e) {
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f1464a);
                sQLiteDatabase.execSQL(f1465b);
                sQLiteDatabase.execSQL(f1466c);
                sQLiteDatabase.execSQL(f1467d);
                sQLiteDatabase.execSQL(f1468e);
                sQLiteDatabase.execSQL(f1469f);
                sQLiteDatabase.execSQL(f1470g);
            } catch (Exception e) {
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            m1983a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* renamed from: com.baidu.android.pushservice.d.a$f */
    enum C0458f {
        belongTo,
        downloadUrl,
        title,
        description,
        savePath,
        fileName,
        downloadBytes,
        totalBytes,
        downloadStatus,
        timeStamp
    }

    /* renamed from: com.baidu.android.pushservice.d.a$g */
    public static class C0459g {
        /* renamed from: a */
        public String f1482a;
        /* renamed from: b */
        public String f1483b;
        /* renamed from: c */
        public String f1484c;
        /* renamed from: d */
        public String f1485d;
        /* renamed from: e */
        public String f1486e;
        /* renamed from: f */
        public String f1487f;
        /* renamed from: g */
        public int f1488g;
        /* renamed from: h */
        public int f1489h;
        /* renamed from: i */
        public int f1490i;
        /* renamed from: j */
        public long f1491j;
    }

    /* renamed from: com.baidu.android.pushservice.d.a$h */
    enum C0460h {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* renamed from: com.baidu.android.pushservice.d.a$i */
    enum C0461i {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* renamed from: com.baidu.android.pushservice.d.a$j */
    enum C0462j {
        info_id,
        f1503b,
        open_type,
        msgid,
        app_open_time,
        app_close_time,
        use_duration,
        extra
    }

    /* renamed from: a */
    public static int m1984a(Context context, long j, long j2) {
        Cursor cursor = null;
        int i = 0;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
            } else {
                try {
                    cursor = e.rawQuery("SELECT COUNT(*) FROM PushBehavior WHERE " + C0455c.timeStamp.name() + " < " + j + " AND " + C0455c.timeStamp.name() + " >= " + j2 + " ;", null);
                    cursor.moveToFirst();
                    i = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    e.close();
                } catch (Exception e2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    e.close();
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    e.close();
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m1985a(android.content.Context r11, java.lang.String r12, int r13) {
        /*
        r8 = 0;
        r10 = f1513c;
        monitor-enter(r10);
        r9 = 0;
        r0 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r11);	 Catch:{ all -> 0x00a3 }
        if (r0 != 0) goto L_0x000e;
    L_0x000b:
        r0 = -1;
        monitor-exit(r10);	 Catch:{ all -> 0x00a3 }
    L_0x000d:
        return r0;
    L_0x000e:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r1.<init>();	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r2 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgId;	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r2 = r2.name();	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r2 = " = ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r1 = r1.append(r12);	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r2 = ";";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r3 = r1.toString();	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        r1 = "AlarmMsgInfo";
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00a6, all -> 0x00b5 }
        if (r2 != 0) goto L_0x004f;
    L_0x0041:
        r1 = -2;
        if (r2 == 0) goto L_0x0047;
    L_0x0044:
        r2.close();	 Catch:{ all -> 0x00a3 }
    L_0x0047:
        if (r0 == 0) goto L_0x004c;
    L_0x0049:
        r0.close();	 Catch:{ all -> 0x00a3 }
    L_0x004c:
        monitor-exit(r10);	 Catch:{ all -> 0x00a3 }
        r0 = r1;
        goto L_0x000d;
    L_0x004f:
        r1 = r2.getCount();	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        if (r1 <= 0) goto L_0x0095;
    L_0x0055:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r1.<init>();	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = "UPDATE AlarmMsgInfo SET ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgEnable;	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = r3.name();	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = " = ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r1 = r1.append(r13);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = " WHERE ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgId;	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r3 = " = ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r1 = r1.append(r12);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
        r0.execSQL(r1);	 Catch:{ Exception -> 0x00c4, all -> 0x00c2 }
    L_0x0095:
        if (r2 == 0) goto L_0x009a;
    L_0x0097:
        r2.close();	 Catch:{ all -> 0x00a3 }
    L_0x009a:
        if (r0 == 0) goto L_0x00c9;
    L_0x009c:
        r0.close();	 Catch:{ all -> 0x00a3 }
        r0 = r9;
    L_0x00a0:
        monitor-exit(r10);	 Catch:{ all -> 0x00a3 }
        goto L_0x000d;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00a3 }
        throw r0;
    L_0x00a6:
        r1 = move-exception;
        r1 = r8;
    L_0x00a8:
        r2 = -3;
        if (r1 == 0) goto L_0x00ae;
    L_0x00ab:
        r1.close();	 Catch:{ all -> 0x00a3 }
    L_0x00ae:
        if (r0 == 0) goto L_0x00c7;
    L_0x00b0:
        r0.close();	 Catch:{ all -> 0x00a3 }
        r0 = r2;
        goto L_0x00a0;
    L_0x00b5:
        r1 = move-exception;
        r2 = r8;
    L_0x00b7:
        if (r2 == 0) goto L_0x00bc;
    L_0x00b9:
        r2.close();	 Catch:{ all -> 0x00a3 }
    L_0x00bc:
        if (r0 == 0) goto L_0x00c1;
    L_0x00be:
        r0.close();	 Catch:{ all -> 0x00a3 }
    L_0x00c1:
        throw r1;	 Catch:{ all -> 0x00a3 }
    L_0x00c2:
        r1 = move-exception;
        goto L_0x00b7;
    L_0x00c4:
        r1 = move-exception;
        r1 = r2;
        goto L_0x00a8;
    L_0x00c7:
        r0 = r2;
        goto L_0x00a0;
    L_0x00c9:
        r0 = r9;
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.a(android.content.Context, java.lang.String, int):int");
    }

    /* renamed from: a */
    public static int m1986a(Context context, String str, C0459g c0459g) {
        int i = 0;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
            } else {
                String[] strArr = new String[]{str};
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0458f.belongTo.name(), c0459g.f1482a);
                contentValues.put(C0458f.downloadUrl.name(), c0459g.f1483b);
                contentValues.put(C0458f.title.name(), c0459g.f1484c);
                contentValues.put(C0458f.description.name(), c0459g.f1485d);
                contentValues.put(C0458f.savePath.name(), c0459g.f1486e);
                contentValues.put(C0458f.fileName.name(), c0459g.f1487f);
                contentValues.put(C0458f.downloadBytes.name(), Integer.valueOf(c0459g.f1488g));
                contentValues.put(C0458f.totalBytes.name(), Integer.valueOf(c0459g.f1489h));
                contentValues.put(C0458f.downloadStatus.name(), Integer.valueOf(c0459g.f1490i));
                contentValues.put(C0458f.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                i = -1;
                try {
                    i = e.update("FileDownloadingInfo", contentValues, C0458f.downloadUrl.name() + "=?", strArr);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return i;
    }

    /* renamed from: a */
    private static int m1987a(SQLiteDatabase sQLiteDatabase, C0544j c0544j) {
        int i = 0;
        if (sQLiteDatabase != null) {
            String[] strArr = new String[]{c0544j.m2267b()};
            ContentValues contentValues = new ContentValues();
            contentValues.put(C0454b.f1441d.name(), c0544j.m2267b());
            if (!TextUtils.isEmpty(c0544j.m2264a())) {
                contentValues.put(C0454b.f1439b.name(), c0544j.m2264a());
            }
            contentValues.put(C0454b.appType.name(), Integer.valueOf(c0544j.m2329h()));
            contentValues.put(C0454b.appName.name(), c0544j.m2270c());
            if (!TextUtils.isEmpty(c0544j.m2272d())) {
                contentValues.put(C0454b.cFrom.name(), c0544j.m2272d());
            }
            contentValues.put(C0454b.versionCode.name(), Integer.valueOf(c0544j.m2274e()));
            contentValues.put(C0454b.versionName.name(), c0544j.m2276f());
            contentValues.put(C0454b.intergratedPushVersion.name(), Integer.valueOf(c0544j.m2277g()));
            i = -1;
            try {
                i = sQLiteDatabase.update("AppInfo", contentValues, C0454b.f1441d.name() + " =?", strArr);
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public static long m1988a(Context context, C0459g c0459g) {
        long j;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0458f.belongTo.name(), c0459g.f1482a);
                contentValues.put(C0458f.downloadUrl.name(), c0459g.f1483b);
                contentValues.put(C0458f.title.name(), c0459g.f1484c);
                contentValues.put(C0458f.description.name(), c0459g.f1485d);
                contentValues.put(C0458f.savePath.name(), c0459g.f1486e);
                contentValues.put(C0458f.fileName.name(), c0459g.f1487f);
                contentValues.put(C0458f.downloadBytes.name(), Integer.valueOf(c0459g.f1488g));
                contentValues.put(C0458f.totalBytes.name(), Integer.valueOf(c0459g.f1489h));
                contentValues.put(C0458f.downloadStatus.name(), Integer.valueOf(c0459g.f1490i));
                contentValues.put(C0458f.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                j = 0;
                try {
                    j = e.insert("FileDownloadingInfo", null, contentValues);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1989a(Context context, C0533a c0533a) {
        long j = -1;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0453a.msgId.name(), c0533a.f1731a);
                contentValues.put(C0453a.sendtime.name(), Long.valueOf(c0533a.f1732b));
                contentValues.put(C0453a.showtime.name(), Long.valueOf(c0533a.f1733c));
                contentValues.put(C0453a.expiretime.name(), Long.valueOf(c0533a.f1734d));
                contentValues.put(C0453a.isAlarm.name(), Integer.valueOf(c0533a.f1735e));
                contentValues.put(C0453a.msgEnable.name(), Integer.valueOf(c0533a.f1736f));
                try {
                    j = e.insert("AlarmMsgInfo", null, contentValues);
                    C0578p.m2546b("AlarmMsgInfoEnum:  insert into database", context);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1990a(Context context, C0536b c0536b) {
        long j;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0455c.actionName.name(), c0536b.d);
                contentValues.put(C0455c.timeStamp.name(), Long.valueOf(c0536b.e));
                contentValues.put(C0455c.networkStatus.name(), c0536b.f);
                contentValues.put(C0455c.f1459l.name(), c0536b.h);
                contentValues.put(C0455c.errorMsg.name(), c0536b.f1755a);
                contentValues.put(C0455c.requestId.name(), c0536b.f1756b);
                contentValues.put(C0455c.errorCode.name(), Integer.valueOf(c0536b.g));
                contentValues.put(C0455c.f1462o.name(), c0536b.j);
                if (c0536b.f1757c != null) {
                    contentValues.put(C0455c.channel.name(), c0536b.f1757c);
                }
                j = 0;
                try {
                    j = e.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1991a(Context context, C0539f c0539f) {
        long j;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0455c.actionName.name(), c0539f.d);
                contentValues.put(C0455c.timeStamp.name(), Long.valueOf(c0539f.e));
                contentValues.put(C0455c.networkStatus.name(), c0539f.f);
                contentValues.put(C0455c.errorMsg.name(), c0539f.f1783a);
                contentValues.put(C0455c.f1459l.name(), c0539f.h);
                j = 0;
                try {
                    j = e.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1992a(Context context, C0543i c0543i) {
        long j;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0455c.actionName.name(), c0543i.d);
                contentValues.put(C0455c.timeStamp.name(), Long.valueOf(c0543i.e));
                contentValues.put(C0455c.networkStatus.name(), c0543i.f);
                contentValues.put(C0455c.errorMsg.name(), c0543i.i);
                contentValues.put(C0455c.stableHeartInterval.name(), Integer.valueOf(c0543i.f1794a));
                contentValues.put(C0455c.errorCode.name(), Integer.valueOf(c0543i.g));
                contentValues.put(C0455c.f1459l.name(), c0543i.h);
                contentValues.put(C0455c.msgId.name(), c0543i.f1795b);
                contentValues.put(C0455c.openByPackageName.name(), c0543i.f1796c);
                j = 0;
                try {
                    j = e.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1993a(Context context, C0544j c0544j) {
        long j = 0;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = -1;
            } else if (C0463a.m2007b(e, c0544j)) {
                e.close();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0454b.f1439b.name(), c0544j.m2264a());
                contentValues.put(C0454b.appType.name(), Integer.valueOf(c0544j.m2329h()));
                contentValues.put(C0454b.f1441d.name(), c0544j.m2267b());
                contentValues.put(C0454b.appName.name(), c0544j.m2270c());
                contentValues.put(C0454b.cFrom.name(), c0544j.m2272d());
                contentValues.put(C0454b.versionCode.name(), Integer.valueOf(c0544j.m2274e()));
                contentValues.put(C0454b.versionName.name(), c0544j.m2276f());
                contentValues.put(C0454b.intergratedPushVersion.name(), Integer.valueOf(c0544j.m2277g()));
                try {
                    j = e.insert("AppInfo", null, contentValues);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1994a(Context context, C0545k c0545k) {
        long j = -1;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0455c.actionName.name(), c0545k.d);
                contentValues.put(C0455c.timeStamp.name(), Long.valueOf(c0545k.e));
                contentValues.put(C0455c.networkStatus.name(), c0545k.f);
                if (c0545k.h != null) {
                    contentValues.put(C0455c.f1459l.name(), c0545k.h);
                }
                contentValues.put(C0455c.msgType.name(), Integer.valueOf(c0545k.f1805c));
                contentValues.put(C0455c.msgId.name(), c0545k.f1803a);
                contentValues.put(C0455c.msgLen.name(), Integer.valueOf(c0545k.f1804b));
                contentValues.put(C0455c.errorCode.name(), Integer.valueOf(c0545k.g));
                if (c0545k.f1806k != null) {
                    contentValues.put(C0455c.openByPackageName.name(), c0545k.f1806k);
                }
                if (TextUtils.isEmpty(c0545k.j)) {
                    e.close();
                } else {
                    contentValues.put(C0455c.f1462o.name(), c0545k.j);
                    try {
                        j = e.insert("PushBehavior", null, contentValues);
                    } catch (Exception e2) {
                    }
                    e.close();
                }
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m1995a(Context context, String str, int i, int i2, int i3, int i4) {
        Cursor cursor;
        Throwable th;
        synchronized (f1513c) {
            long j = -1;
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                return -1;
            }
            cursor = null;
            Cursor query;
            try {
                query = e.query("NoDisturb", new String[]{C0461i.pkgName.name()}, C0461i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C0461i.pkgName.name(), str);
                    contentValues.put(C0461i.startHour.name(), Integer.valueOf(i));
                    contentValues.put(C0461i.startMinute.name(), Integer.valueOf(i2));
                    contentValues.put(C0461i.endHour.name(), Integer.valueOf(i3));
                    contentValues.put(C0461i.endMinute.name(), Integer.valueOf(i4));
                    if (query == null || !query.moveToNext()) {
                        j = e.insert("NoDisturb", null, contentValues);
                    } else if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
                        j = (long) e.delete("NoDisturb", C0461i.pkgName.name() + "= ?", new String[]{str});
                    } else {
                        j = (long) e.update("NoDisturb", contentValues, C0461i.pkgName.name() + "= ?", new String[]{str});
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (e != null) {
                        e.close();
                        r0 = j;
                    }
                } catch (Exception e2) {
                    if (query != null) {
                        query.close();
                    }
                    if (e != null) {
                        e.close();
                        r0 = -1;
                        return r0;
                    }
                    r0 = j;
                    return r0;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e != null) {
                        e.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                query = null;
                if (query != null) {
                    query.close();
                }
                if (e != null) {
                    long j2;
                    e.close();
                    j2 = -1;
                    return j2;
                }
                j2 = j;
                return j2;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                if (e != null) {
                    e.close();
                }
                throw th;
            }
            j2 = j;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static com.baidu.android.pushservice.p025d.C0463a.C0459g m1996a(android.content.Context r11, java.lang.String r12) {
        /*
        r8 = 0;
        r9 = f1513c;
        monitor-enter(r9);
        r0 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r11);	 Catch:{ all -> 0x00fd }
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        monitor-exit(r9);	 Catch:{ all -> 0x00fd }
        r0 = r8;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fd }
        r1.<init>();	 Catch:{ all -> 0x00fd }
        r2 = "(";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00fd }
        r2 = com.baidu.android.pushservice.p025d.C0463a.C0458f.downloadUrl;	 Catch:{ all -> 0x00fd }
        r2 = r2.name();	 Catch:{ all -> 0x00fd }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00fd }
        r2 = "==?";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00fd }
        r2 = ")";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00fd }
        r3 = r1.toString();	 Catch:{ all -> 0x00fd }
        r1 = 1;
        r4 = new java.lang.String[r1];	 Catch:{ all -> 0x00fd }
        r1 = 0;
        r4[r1] = r12;	 Catch:{ all -> 0x00fd }
        r1 = "FileDownloadingInfo";
        r2 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0100, all -> 0x010c }
        r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x011a, all -> 0x0116 }
        if (r2 == 0) goto L_0x0123;
    L_0x004c:
        r2 = new com.baidu.android.pushservice.d.a$g;	 Catch:{ Exception -> 0x011a, all -> 0x0116 }
        r2.<init>();	 Catch:{ Exception -> 0x011a, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.belongTo;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1482a = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.downloadUrl;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1483b = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.title;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1484c = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.description;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1485d = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.savePath;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1486e = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.fileName;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1487f = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.downloadBytes;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getInt(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1488g = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.totalBytes;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getInt(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1489h = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.downloadStatus;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getInt(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1490i = r3;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0458f.timeStamp;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r3.name();	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r4 = r1.getLong(r3);	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
        r2.f1491j = r4;	 Catch:{ Exception -> 0x011f, all -> 0x0116 }
    L_0x00f1:
        if (r1 == 0) goto L_0x00f6;
    L_0x00f3:
        r1.close();	 Catch:{ all -> 0x00fd }
    L_0x00f6:
        r0.close();	 Catch:{ all -> 0x00fd }
        r0 = r2;
    L_0x00fa:
        monitor-exit(r9);	 Catch:{ all -> 0x00fd }
        goto L_0x000c;
    L_0x00fd:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00fd }
        throw r0;
    L_0x0100:
        r1 = move-exception;
        r1 = r8;
    L_0x0102:
        if (r8 == 0) goto L_0x0107;
    L_0x0104:
        r8.close();	 Catch:{ all -> 0x00fd }
    L_0x0107:
        r0.close();	 Catch:{ all -> 0x00fd }
        r0 = r1;
        goto L_0x00fa;
    L_0x010c:
        r1 = move-exception;
    L_0x010d:
        if (r8 == 0) goto L_0x0112;
    L_0x010f:
        r8.close();	 Catch:{ all -> 0x00fd }
    L_0x0112:
        r0.close();	 Catch:{ all -> 0x00fd }
        throw r1;	 Catch:{ all -> 0x00fd }
    L_0x0116:
        r2 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x010d;
    L_0x011a:
        r2 = move-exception;
        r10 = r1;
        r1 = r8;
        r8 = r10;
        goto L_0x0102;
    L_0x011f:
        r3 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x0102;
    L_0x0123:
        r2 = r8;
        goto L_0x00f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.a(android.content.Context, java.lang.String):com.baidu.android.pushservice.d.a$g");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static java.util.List<com.baidu.android.pushservice.p029h.C0544j> m1997a(android.content.Context r7) {
        /*
        r0 = 0;
        r2 = f1513c;
        monitor-enter(r2);
        r3 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r7);	 Catch:{ all -> 0x00c7 }
        if (r3 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r2);	 Catch:{ all -> 0x00c7 }
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00c7 }
        r1.<init>();	 Catch:{ all -> 0x00c7 }
        r4 = "SELECT * FROM AppInfo;";
        r5 = 0;
        r0 = r3.rawQuery(r4, r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00ca }
    L_0x0019:
        r4 = r0.moveToNext();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        if (r4 == 0) goto L_0x00be;
    L_0x001f:
        r4 = new com.baidu.android.pushservice.h.j;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.<init>();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.f1439b;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2266a(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.appType;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2328c(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.f1441d;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2269b(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.appName;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2271c(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.cFrom;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2273d(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.versionCode;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2265a(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.versionName;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2275e(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0454b.intergratedPushVersion;	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r5.name();	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r4.m2268b(r5);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        r1.add(r4);	 Catch:{ Exception -> 0x00b1, all -> 0x00d7 }
        goto L_0x0019;
    L_0x00b1:
        r4 = move-exception;
        if (r0 == 0) goto L_0x00b7;
    L_0x00b4:
        r0.close();	 Catch:{ all -> 0x00c7 }
    L_0x00b7:
        r3.close();	 Catch:{ all -> 0x00c7 }
    L_0x00ba:
        monitor-exit(r2);	 Catch:{ all -> 0x00c7 }
        r0 = r1;
        goto L_0x000b;
    L_0x00be:
        if (r0 == 0) goto L_0x00c3;
    L_0x00c0:
        r0.close();	 Catch:{ all -> 0x00c7 }
    L_0x00c3:
        r3.close();	 Catch:{ all -> 0x00c7 }
        goto L_0x00ba;
    L_0x00c7:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00c7 }
        throw r0;
    L_0x00ca:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00ce:
        if (r1 == 0) goto L_0x00d3;
    L_0x00d0:
        r1.close();	 Catch:{ all -> 0x00c7 }
    L_0x00d3:
        r3.close();	 Catch:{ all -> 0x00c7 }
        throw r0;	 Catch:{ all -> 0x00c7 }
    L_0x00d7:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.a(android.content.Context):java.util.List<com.baidu.android.pushservice.h.j>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static java.util.List<com.baidu.android.pushservice.p029h.C0538e> m1998a(android.content.Context r9, long r10, long r12, int r14) {
        /*
        r0 = 0;
        r2 = f1513c;
        monitor-enter(r2);
        r3 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r9);	 Catch:{ all -> 0x018e }
        if (r3 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r2);	 Catch:{ all -> 0x018e }
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x018e }
        r1.<init>();	 Catch:{ all -> 0x018e }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x018e }
        r4.<init>();	 Catch:{ all -> 0x018e }
        r5 = "SELECT * FROM PushBehavior WHERE ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.timeStamp;	 Catch:{ all -> 0x018e }
        r5 = r5.name();	 Catch:{ all -> 0x018e }
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r5 = " < ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r4 = r4.append(r10);	 Catch:{ all -> 0x018e }
        r5 = " AND ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.timeStamp;	 Catch:{ all -> 0x018e }
        r5 = r5.name();	 Catch:{ all -> 0x018e }
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r5 = " >= ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r4 = r4.append(r12);	 Catch:{ all -> 0x018e }
        r5 = " LIMIT ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r4 = r4.append(r14);	 Catch:{ all -> 0x018e }
        r5 = ";";
        r4 = r4.append(r5);	 Catch:{ all -> 0x018e }
        r4 = r4.toString();	 Catch:{ all -> 0x018e }
        r5 = 0;
        r0 = r3.rawQuery(r4, r5);	 Catch:{ Exception -> 0x0178, all -> 0x0191 }
    L_0x0069:
        r4 = r0.moveToNext();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        if (r4 == 0) goto L_0x0185;
    L_0x006f:
        r4 = new com.baidu.android.pushservice.h.e;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.<init>();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.actionId;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2279a(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.actionName;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2281a(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.f1459l;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2296f(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.channel;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2299g(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.errorCode;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2292e(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.errorMsg;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2290d(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.msgId;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2287c(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.msgLen;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2286c(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.msgType;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2283b(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.networkStatus;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2284b(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.openByPackageName;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2302i(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.requestId;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2293e(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.stableHeartInterval;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2289d(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.timeStamp;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r6 = r0.getLong(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2280a(r6);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.f1462o;	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r5.name();	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getColumnIndex(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r4.m2301h(r5);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        r1.add(r4);	 Catch:{ Exception -> 0x0178, all -> 0x019e }
        goto L_0x0069;
    L_0x0178:
        r4 = move-exception;
        if (r0 == 0) goto L_0x017e;
    L_0x017b:
        r0.close();	 Catch:{ all -> 0x018e }
    L_0x017e:
        r3.close();	 Catch:{ all -> 0x018e }
    L_0x0181:
        monitor-exit(r2);	 Catch:{ all -> 0x018e }
        r0 = r1;
        goto L_0x000b;
    L_0x0185:
        if (r0 == 0) goto L_0x018a;
    L_0x0187:
        r0.close();	 Catch:{ all -> 0x018e }
    L_0x018a:
        r3.close();	 Catch:{ all -> 0x018e }
        goto L_0x0181;
    L_0x018e:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x018e }
        throw r0;
    L_0x0191:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0195:
        if (r1 == 0) goto L_0x019a;
    L_0x0197:
        r1.close();	 Catch:{ all -> 0x018e }
    L_0x019a:
        r3.close();	 Catch:{ all -> 0x018e }
        throw r0;	 Catch:{ all -> 0x018e }
    L_0x019e:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0195;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.a(android.content.Context, long, long, int):java.util.List<com.baidu.android.pushservice.h.e>");
    }

    /* renamed from: a */
    public static void m1999a() {
        synchronized (f1513c) {
            try {
                if (f1511a != null) {
                    f1511a.close();
                    f1511a = null;
                }
            } catch (Exception e) {
                f1511a = null;
            }
        }
    }

    /* renamed from: a */
    private static void m2000a(final String str, Context context) {
        File parentFile = context.getDatabasePath("pushstat_6.0.0.db").getParentFile();
        if (parentFile != null && parentFile.isDirectory()) {
            File[] listFiles = parentFile.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains("pushstat") && !name.contains(str);
                }
            });
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.isDirectory()) {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m2001a(android.database.sqlite.SQLiteDatabase r5, com.baidu.android.pushservice.p029h.C0543i r6) {
        /*
        r2 = 0;
        r1 = 0;
        r0 = 1;
        if (r5 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "SELECT * FROM PushBehavior WHERE ";
        r3 = r3.append(r4);
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0455c.actionName;
        r4 = r4.name();
        r3 = r3.append(r4);
        r4 = " = '";
        r3 = r3.append(r4);
        r4 = r6.d;
        r3 = r3.append(r4);
        r4 = "' AND ";
        r3 = r3.append(r4);
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0455c.errorCode;
        r4 = r4.name();
        r3 = r3.append(r4);
        r4 = " = ";
        r3 = r3.append(r4);
        r4 = r6.g;
        r3 = r3.append(r4);
        r4 = ";";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r2 = r5.rawQuery(r3, r4);	 Catch:{ Exception -> 0x0080, all -> 0x0088 }
        r3 = r2.moveToNext();	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        if (r3 == 0) goto L_0x0092;
    L_0x005d:
        r3 = com.baidu.android.pushservice.p025d.C0463a.C0455c.stableHeartInterval;	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        r3 = r3.name();	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        r3 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        r3 = r2.getInt(r3);	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        r6.f1794a = r3;	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        com.baidu.android.pushservice.p025d.C0463a.m2003b(r5, r6);	 Catch:{ Exception -> 0x008f, all -> 0x0088 }
        r3 = r0;
    L_0x0071:
        if (r3 == 0) goto L_0x0079;
    L_0x0073:
        if (r2 == 0) goto L_0x0005;
    L_0x0075:
        r2.close();
        goto L_0x0005;
    L_0x0079:
        if (r2 == 0) goto L_0x007e;
    L_0x007b:
        r2.close();
    L_0x007e:
        r0 = r1;
        goto L_0x0005;
    L_0x0080:
        r0 = move-exception;
        r0 = r2;
    L_0x0082:
        if (r0 == 0) goto L_0x007e;
    L_0x0084:
        r0.close();
        goto L_0x007e;
    L_0x0088:
        r0 = move-exception;
        if (r2 == 0) goto L_0x008e;
    L_0x008b:
        r2.close();
    L_0x008e:
        throw r0;
    L_0x008f:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0082;
    L_0x0092:
        r3 = r1;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.a(android.database.sqlite.SQLiteDatabase, com.baidu.android.pushservice.h.i):boolean");
    }

    /* renamed from: b */
    public static int m2002b(Context context, String str) {
        int i = 0;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
            } else {
                i = -1;
                try {
                    i = e.delete("FileDownloadingInfo", C0458f.downloadUrl.name() + "=?", new String[]{str});
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return i;
    }

    /* renamed from: b */
    private static int m2003b(SQLiteDatabase sQLiteDatabase, C0543i c0543i) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(C0455c.actionName.name(), c0543i.d);
        contentValues.put(C0455c.timeStamp.name(), Long.valueOf(c0543i.e));
        contentValues.put(C0455c.networkStatus.name(), c0543i.f);
        contentValues.put(C0455c.stableHeartInterval.name(), Integer.valueOf(c0543i.f1794a + 1));
        contentValues.put(C0455c.errorCode.name(), Integer.valueOf(c0543i.g));
        contentValues.put(C0455c.f1459l.name(), c0543i.h);
        try {
            sQLiteDatabase.update("PushBehavior", contentValues, C0455c.actionName.name() + " = " + "'" + c0543i.d + "' AND " + C0455c.errorCode.name() + " = " + c0543i.g + ";", null);
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: b */
    public static long m2004b(Context context, C0543i c0543i) {
        long j = 0;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = -1;
            } else if (C0463a.m2001a(e, c0543i)) {
                if (e != null) {
                    e.close();
                }
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0455c.actionName.name(), c0543i.d);
                contentValues.put(C0455c.timeStamp.name(), Long.valueOf(c0543i.e));
                contentValues.put(C0455c.networkStatus.name(), c0543i.f);
                contentValues.put(C0455c.stableHeartInterval.name(), Integer.valueOf(1));
                contentValues.put(C0455c.errorCode.name(), Integer.valueOf(c0543i.g));
                contentValues.put(C0455c.f1459l.name(), c0543i.h);
                try {
                    j = e.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                e.close();
            }
        }
        return j;
    }

    /* renamed from: b */
    public static List<C0459g> m2005b(Context context) {
        Throwable th;
        Cursor cursor = null;
        synchronized (f1513c) {
            List<C0459g> arrayList = new ArrayList();
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                return arrayList;
            }
            Cursor query;
            try {
                query = e.query("FileDownloadingInfo", null, null, null, null, null, C0458f.timeStamp.name() + " DESC");
                while (query.moveToNext()) {
                    try {
                        C0459g c0459g = new C0459g();
                        c0459g.f1482a = query.getString(query.getColumnIndex(C0458f.belongTo.name()));
                        c0459g.f1483b = query.getString(query.getColumnIndex(C0458f.downloadUrl.name()));
                        c0459g.f1484c = query.getString(query.getColumnIndex(C0458f.title.name()));
                        c0459g.f1485d = query.getString(query.getColumnIndex(C0458f.description.name()));
                        c0459g.f1486e = query.getString(query.getColumnIndex(C0458f.savePath.name()));
                        c0459g.f1487f = query.getString(query.getColumnIndex(C0458f.fileName.name()));
                        c0459g.f1488g = query.getInt(query.getColumnIndex(C0458f.downloadBytes.name()));
                        c0459g.f1489h = query.getInt(query.getColumnIndex(C0458f.totalBytes.name()));
                        c0459g.f1490i = query.getInt(query.getColumnIndex(C0458f.downloadStatus.name()));
                        c0459g.f1491j = query.getLong(query.getColumnIndex(C0458f.timeStamp.name()));
                        arrayList.add(c0459g);
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                    }
                }
                if (query != null) {
                    query.close();
                }
                e.close();
            } catch (Exception e3) {
                query = null;
                if (query != null) {
                    query.close();
                }
                e.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                e.close();
                throw th;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static boolean m2006b(android.content.Context r7, long r8, long r10) {
        /*
        r1 = 0;
        r0 = 0;
        r3 = f1513c;
        monitor-enter(r3);
        r4 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r7);	 Catch:{ all -> 0x00a1 }
        if (r4 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x00a1 }
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a1 }
        r2.<init>();	 Catch:{ all -> 0x00a1 }
        r5 = "SELECT ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.actionName;	 Catch:{ all -> 0x00a1 }
        r5 = r5.name();	 Catch:{ all -> 0x00a1 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = " FROM ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = "PushBehavior";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = " WHERE ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.timeStamp;	 Catch:{ all -> 0x00a1 }
        r5 = r5.name();	 Catch:{ all -> 0x00a1 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = " < ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r2 = r2.append(r8);	 Catch:{ all -> 0x00a1 }
        r5 = " AND ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = com.baidu.android.pushservice.p025d.C0463a.C0455c.timeStamp;	 Catch:{ all -> 0x00a1 }
        r5 = r5.name();	 Catch:{ all -> 0x00a1 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = " >= ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00a1 }
        r5 = " ;";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00a1 }
        r2 = r2.toString();	 Catch:{ all -> 0x00a1 }
        r5 = 0;
        r1 = r4.rawQuery(r2, r5);	 Catch:{ Exception -> 0x00a4, all -> 0x00b4 }
    L_0x0079:
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x00c3, all -> 0x00b4 }
        if (r2 == 0) goto L_0x0094;
    L_0x007f:
        r2 = 0;
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00c3, all -> 0x00b4 }
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x00c3, all -> 0x00b4 }
        if (r5 != 0) goto L_0x0079;
    L_0x008a:
        r5 = com.baidu.android.pushservice.p029h.C0535n.f1752t;	 Catch:{ Exception -> 0x00c3, all -> 0x00b4 }
        r2 = r2.startsWith(r5);	 Catch:{ Exception -> 0x00c3, all -> 0x00b4 }
        if (r2 != 0) goto L_0x0079;
    L_0x0092:
        r0 = 1;
        goto L_0x0079;
    L_0x0094:
        if (r1 == 0) goto L_0x0099;
    L_0x0096:
        r1.close();	 Catch:{ all -> 0x00a1 }
    L_0x0099:
        if (r0 == 0) goto L_0x009e;
    L_0x009b:
        r4.close();	 Catch:{ all -> 0x00a1 }
    L_0x009e:
        monitor-exit(r3);	 Catch:{ all -> 0x00a1 }
        goto L_0x000c;
    L_0x00a1:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00a1 }
        throw r0;
    L_0x00a4:
        r2 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00a8:
        if (r0 == 0) goto L_0x00ad;
    L_0x00aa:
        r0.close();	 Catch:{ all -> 0x00a1 }
    L_0x00ad:
        if (r1 == 0) goto L_0x00c8;
    L_0x00af:
        r4.close();	 Catch:{ all -> 0x00a1 }
        r0 = r1;
        goto L_0x009e;
    L_0x00b4:
        r2 = move-exception;
        r6 = r2;
        r2 = r0;
        r0 = r6;
        if (r1 == 0) goto L_0x00bd;
    L_0x00ba:
        r1.close();	 Catch:{ all -> 0x00a1 }
    L_0x00bd:
        if (r2 == 0) goto L_0x00c2;
    L_0x00bf:
        r4.close();	 Catch:{ all -> 0x00a1 }
    L_0x00c2:
        throw r0;	 Catch:{ all -> 0x00a1 }
    L_0x00c3:
        r2 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00a8;
    L_0x00c8:
        r0 = r1;
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.b(android.content.Context, long, long):boolean");
    }

    /* renamed from: b */
    private static boolean m2007b(SQLiteDatabase sQLiteDatabase, C0544j c0544j) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("AppInfo", null, C0454b.f1441d.name() + " =?", new String[]{c0544j.m2267b()}, null, null, null);
            try {
                if (query.moveToNext()) {
                    if (!(TextUtils.equals(c0544j.m2272d(), query.getString(query.getColumnIndex(C0454b.cFrom.name()))) && TextUtils.equals(c0544j.m2274e() + "", query.getInt(query.getColumnIndex(C0454b.versionCode.name())) + "") && TextUtils.equals(c0544j.m2277g() + "", query.getString(query.getColumnIndex(C0454b.intergratedPushVersion.name()))))) {
                        C0463a.m1987a(sQLiteDatabase, c0544j);
                    }
                    if (query != null) {
                        query.close();
                    }
                    return true;
                }
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Exception e) {
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th2) {
                cursor = query;
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            query = null;
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    public static C0533a m2008c(Context context, String str) {
        Throwable th;
        Cursor cursor = null;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                return null;
            }
            C0533a c0533a = new C0533a();
            try {
                Cursor query = e.query("AlarmMsgInfo", null, C0453a.msgId.name() + " = " + str + ";", null, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    e.close();
                    return null;
                }
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        c0533a.f1732b = query.getLong(query.getColumnIndex(C0453a.sendtime.name()));
                        c0533a.f1733c = query.getLong(query.getColumnIndex(C0453a.showtime.name()));
                        c0533a.f1734d = query.getLong(query.getColumnIndex(C0453a.expiretime.name()));
                        c0533a.f1735e = query.getInt(query.getColumnIndex(C0453a.isAlarm.name()));
                        c0533a.f1736f = query.getInt(query.getColumnIndex(C0453a.msgEnable.name()));
                    }
                    if (query != null) {
                        query.close();
                    }
                    e.close();
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    e.close();
                    return c0533a;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    e.close();
                    throw th;
                }
            } catch (Exception e3) {
                if (cursor != null) {
                    cursor.close();
                }
                e.close();
                return c0533a;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                e.close();
                throw th;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static void m2009c(android.content.Context r9) {
        /*
        r0 = 0;
        r2 = f1513c;
        monitor-enter(r2);
        r3 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r9);	 Catch:{ all -> 0x00a1 }
        if (r3 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r2);	 Catch:{ all -> 0x00a1 }
    L_0x000b:
        return;
    L_0x000c:
        r1 = "SELECT * FROM AlarmMsgInfo;";
        r4 = 0;
        r0 = r3.rawQuery(r1, r4);	 Catch:{ Exception -> 0x0093, all -> 0x00af }
    L_0x0014:
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        if (r1 == 0) goto L_0x00a4;
    L_0x001a:
        r1 = new com.baidu.android.pushservice.h.a;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.<init>();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgId;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r4.name();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getString(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.f1731a = r4;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.sendtime;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r4.name();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getLong(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.f1732b = r4;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.showtime;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r4.name();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getLong(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.f1733c = r4;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.expiretime;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r4.name();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getLong(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.f1734d = r4;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.isAlarm;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r4.name();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.f1735e = r4;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgEnable;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r4.name();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r1.f1736f = r4;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = r1.f1736f;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        if (r4 == 0) goto L_0x008d;
    L_0x0083:
        r4 = r1.f1734d;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0014;
    L_0x008d:
        r1 = r1.f1731a;	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        com.baidu.android.pushservice.p025d.C0463a.m2011d(r9, r1);	 Catch:{ Exception -> 0x0093, all -> 0x00be }
        goto L_0x0014;
    L_0x0093:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0099;
    L_0x0096:
        r0.close();	 Catch:{ all -> 0x00a1 }
    L_0x0099:
        if (r3 == 0) goto L_0x009e;
    L_0x009b:
        r3.close();	 Catch:{ all -> 0x00a1 }
    L_0x009e:
        monitor-exit(r2);	 Catch:{ all -> 0x00a1 }
        goto L_0x000b;
    L_0x00a1:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00a1 }
        throw r0;
    L_0x00a4:
        if (r0 == 0) goto L_0x00a9;
    L_0x00a6:
        r0.close();	 Catch:{ all -> 0x00a1 }
    L_0x00a9:
        if (r3 == 0) goto L_0x009e;
    L_0x00ab:
        r3.close();	 Catch:{ all -> 0x00a1 }
        goto L_0x009e;
    L_0x00af:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x00b3:
        if (r1 == 0) goto L_0x00b8;
    L_0x00b5:
        r1.close();	 Catch:{ all -> 0x00a1 }
    L_0x00b8:
        if (r3 == 0) goto L_0x00bd;
    L_0x00ba:
        r3.close();	 Catch:{ all -> 0x00a1 }
    L_0x00bd:
        throw r0;	 Catch:{ all -> 0x00a1 }
    L_0x00be:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.c(android.content.Context):void");
    }

    /* renamed from: d */
    public static long m2010d(Context context) {
        long j;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                j = 0;
            } else {
                try {
                    e.delete("PushBehavior", null, null);
                    e.delete("AppInfo", null, null);
                } catch (Exception e2) {
                }
                e.close();
                j = (long) -1;
            }
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static void m2011d(android.content.Context r10, java.lang.String r11) {
        /*
        r8 = 0;
        r9 = f1513c;
        monitor-enter(r9);
        r0 = com.baidu.android.pushservice.p025d.C0463a.m2012e(r10);	 Catch:{ all -> 0x004b }
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r9);	 Catch:{ all -> 0x004b }
    L_0x000b:
        return;
    L_0x000c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r1.<init>();	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r2 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgId;	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r2 = r2.name();	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r2 = " = ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r1 = r1.append(r11);	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r2 = ";";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r3 = r1.toString();	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        r1 = "AlarmMsgInfo";
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0080, all -> 0x008d }
        if (r1 != 0) goto L_0x004e;
    L_0x003f:
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        r1.close();	 Catch:{ all -> 0x004b }
    L_0x0044:
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.close();	 Catch:{ all -> 0x004b }
    L_0x0049:
        monitor-exit(r9);	 Catch:{ all -> 0x004b }
        goto L_0x000b;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x004b }
        throw r0;
    L_0x004e:
        r2 = "AlarmMsgInfo";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r3.<init>();	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r4 = com.baidu.android.pushservice.p025d.C0463a.C0453a.msgId;	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r4 = r4.name();	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r4 = "= ?";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        r0.delete(r2, r3, r4);	 Catch:{ Exception -> 0x009d, all -> 0x0099 }
        if (r1 == 0) goto L_0x0079;
    L_0x0076:
        r1.close();	 Catch:{ all -> 0x004b }
    L_0x0079:
        if (r0 == 0) goto L_0x007e;
    L_0x007b:
        r0.close();	 Catch:{ all -> 0x004b }
    L_0x007e:
        monitor-exit(r9);	 Catch:{ all -> 0x004b }
        goto L_0x000b;
    L_0x0080:
        r1 = move-exception;
        r1 = r8;
    L_0x0082:
        if (r1 == 0) goto L_0x0087;
    L_0x0084:
        r1.close();	 Catch:{ all -> 0x004b }
    L_0x0087:
        if (r0 == 0) goto L_0x007e;
    L_0x0089:
        r0.close();	 Catch:{ all -> 0x004b }
        goto L_0x007e;
    L_0x008d:
        r1 = move-exception;
    L_0x008e:
        if (r8 == 0) goto L_0x0093;
    L_0x0090:
        r8.close();	 Catch:{ all -> 0x004b }
    L_0x0093:
        if (r0 == 0) goto L_0x0098;
    L_0x0095:
        r0.close();	 Catch:{ all -> 0x004b }
    L_0x0098:
        throw r1;	 Catch:{ all -> 0x004b }
    L_0x0099:
        r2 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x008e;
    L_0x009d:
        r2 = move-exception;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.a.d(android.content.Context, java.lang.String):void");
    }

    /* renamed from: e */
    private static SQLiteDatabase m2012e(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        C0457e f = C0463a.m2014f(context);
        if (f != null) {
            try {
                sQLiteDatabase = f.getWritableDatabase();
            } catch (Throwable th) {
            }
        }
        return sQLiteDatabase;
    }

    /* renamed from: e */
    public static boolean m2013e(Context context, String str) {
        Throwable th;
        Cursor cursor = null;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                return true;
            }
            Cursor query;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.clear();
                contentValues.put(C0460h.msgId.name(), str);
                contentValues.put(C0460h.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                String str2 = C0460h.msgId.name() + " =? ";
                query = e.query("MsgArriveApp", null, str2, new String[]{str}, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            "UPDATE MsgArriveApp SET " + C0460h.timeStamp.name() + " = " + System.currentTimeMillis() + " WHERE " + C0460h.msgId + " = " + str;
                            e.update("MsgArriveApp", contentValues, str2, new String[]{str});
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            e.close();
                            return false;
                        }
                    } catch (Exception e2) {
                        query.close();
                        e.close();
                        return true;
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                        cursor.close();
                        e.close();
                        throw th;
                    }
                }
                query = e.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                query.moveToFirst();
                if (query.getInt(0) > f1514d) {
                    e.delete("MsgArriveApp", null, null);
                }
                e.insert("MsgArriveApp", null, contentValues);
                if (query != null) {
                    if (!query.isClosed()) {
                        query.close();
                    }
                }
                e.close();
                return true;
            } catch (Exception e3) {
                query = null;
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                e.close();
                return true;
            } catch (Throwable th3) {
                th = th3;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                e.close();
                throw th;
            }
        }
    }

    /* renamed from: f */
    private static C0457e m2014f(Context context) {
        synchronized (f1513c) {
            if (f1511a == null) {
                String path = context.getDatabasePath("pushstat_6.0.0.db").getPath();
                C0463a.m2000a("pushstat_6.0.0.db", context);
                if (VERSION.SDK_INT >= 11) {
                    f1512b = new C0456d();
                    f1511a = new C0457e(context, path, 2, f1512b);
                } else {
                    f1511a = new C0457e(context, path, 2);
                }
            }
        }
        return f1511a;
    }

    /* renamed from: f */
    public static int[] m2015f(Context context, String str) {
        Cursor query;
        Cursor cursor;
        Throwable th;
        synchronized (f1513c) {
            SQLiteDatabase e = C0463a.m2012e(context);
            if (e == null) {
                return null;
            }
            try {
                query = e.query("NoDisturb", null, C0461i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            int i = query.getInt(query.getColumnIndex(C0461i.startHour.name()));
                            int i2 = query.getInt(query.getColumnIndex(C0461i.startMinute.name()));
                            int i3 = query.getInt(query.getColumnIndex(C0461i.endHour.name()));
                            int i4 = query.getInt(query.getColumnIndex(C0461i.endMinute.name()));
                            int[] iArr;
                            if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
                                iArr = new int[0];
                                if (query != null) {
                                    query.close();
                                }
                                e.close();
                                return iArr;
                            }
                            iArr = new int[]{i, i2, i3, i4};
                            if (query != null) {
                                query.close();
                            }
                            e.close();
                            return iArr;
                        }
                    } catch (Exception e2) {
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        e.close();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        e.close();
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                e.close();
            } catch (Exception e3) {
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                e.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                e.close();
                throw th;
            }
        }
    }
}
