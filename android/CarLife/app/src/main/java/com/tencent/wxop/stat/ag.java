package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p291b.C6133b;
import com.tencent.wxop.stat.p291b.C6134c;
import com.tencent.wxop.stat.p291b.C6138g;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6150s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ag {
    /* renamed from: h */
    private static C6133b f24810h = C6144m.m21872b();
    /* renamed from: i */
    private static Context f24811i = null;
    /* renamed from: j */
    private static ag f24812j = null;
    /* renamed from: a */
    volatile int f24813a = 0;
    /* renamed from: b */
    C6134c f24814b = null;
    /* renamed from: c */
    private ao f24815c = null;
    /* renamed from: d */
    private ao f24816d = null;
    /* renamed from: e */
    private C6138g f24817e = null;
    /* renamed from: f */
    private String f24818f = "";
    /* renamed from: g */
    private String f24819g = "";
    /* renamed from: k */
    private int f24820k = 0;
    /* renamed from: l */
    private ConcurrentHashMap<C6119e, String> f24821l = null;
    /* renamed from: m */
    private boolean f24822m = false;
    /* renamed from: n */
    private HashMap<String, String> f24823n = new HashMap();

    private ag(Context context) {
        try {
            this.f24817e = new C6138g();
            f24811i = context.getApplicationContext();
            this.f24821l = new ConcurrentHashMap();
            this.f24818f = C6144m.m21896r(context);
            this.f24819g = "pri_" + C6144m.m21896r(context);
            this.f24815c = new ao(f24811i, this.f24818f);
            this.f24816d = new ao(f24811i, this.f24819g);
            m21772a(true);
            m21772a(false);
            m21782f();
            m21793b(f24811i);
            m21795d();
            m21786j();
        } catch (Throwable th) {
            f24810h.m21826b(th);
        }
    }

    /* renamed from: a */
    public static ag m21760a(Context context) {
        if (f24812j == null) {
            synchronized (ag.class) {
                if (f24812j == null) {
                    f24812j = new ag(context);
                }
            }
        }
        return f24812j;
    }

    /* renamed from: a */
    private String m21761a(List<ap> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (ap apVar : list) {
            stringBuilder.append(apVar.f24848a);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private synchronized void m21762a(int i, boolean z) {
        try {
            if (this.f24813a > 0 && i > 0 && !C6160j.m22109a()) {
                if (C6156f.m21997b()) {
                    f24810h.m21825b("Load " + this.f24813a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                m21778b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (C6156f.m21997b()) {
                        f24810h.m21825b("Peek " + arrayList.size() + " unsent events.");
                    }
                    m21770a(arrayList, 2, z);
                    aw.m21813b(f24811i).m21816b(arrayList, new am(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            f24810h.m21826b(th);
        }
    }

    /* renamed from: a */
    private void m21763a(C6119e c6119e, av avVar, boolean z) {
        long insert;
        long j;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = m21779c(z);
            sQLiteDatabase.beginTransaction();
            if (!z && this.f24813a > C6156f.m22028j()) {
                f24810h.m21829e("Too many events stored in db.");
                this.f24813a -= this.f24815c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String g = c6119e.m21717g();
            if (C6156f.m21997b()) {
                f24810h.m21825b("insert 1 event, content:" + g);
            }
            contentValues.put("content", C6150s.m21923b(g));
            contentValues.put("send_count", "0");
            contentValues.put("status", Integer.toString(1));
            contentValues.put(C2125n.f6748P, Long.valueOf(c6119e.m21713c()));
            insert = sQLiteDatabase.insert("events", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                    j = insert;
                } catch (Throwable th) {
                    f24810h.m21826b(th);
                    j = insert;
                }
                if (j <= 0) {
                    this.f24813a++;
                    if (C6156f.m21997b()) {
                        f24810h.m21834j("directStoreEvent insert event to db, event:" + c6119e.m21717g());
                    }
                    if (avVar != null) {
                        avVar.mo5017a();
                    }
                }
                f24810h.m21831g("Failed to store event:" + c6119e.m21717g());
                return;
            }
        } catch (Throwable th2) {
            f24810h.m21826b(th2);
            j = -1;
        }
        j = insert;
        if (j <= 0) {
            f24810h.m21831g("Failed to store event:" + c6119e.m21717g());
            return;
        }
        this.f24813a++;
        if (C6156f.m21997b()) {
            f24810h.m21834j("directStoreEvent insert event to db, event:" + c6119e.m21717g());
        }
        if (avVar != null) {
            avVar.mo5017a();
        }
    }

    /* renamed from: a */
    private synchronized void m21770a(List<ap> list, int i, boolean z) {
        SQLiteDatabase c;
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int b = m21773b(z);
                try {
                    String str2;
                    c = m21779c(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + m21761a((List) list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                f24810h.m21826b(th);
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th3) {
                                        f24810h.m21826b(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th5) {
                                        f24810h.m21826b(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    str2 = "update events set status=" + i + " where " + m21761a((List) list);
                    if (this.f24820k % 3 == 0) {
                        str = "delete from events where send_count>" + b;
                    }
                    this.f24820k++;
                    if (C6156f.m21997b()) {
                        f24810h.m21825b("update sql:" + str2);
                    }
                    c.beginTransaction();
                    c.execSQL(str2);
                    if (str != null) {
                        f24810h.m21825b("update for delete sql:" + str);
                        c.execSQL(str);
                        m21782f();
                    }
                    c.setTransactionSuccessful();
                    if (c != null) {
                        try {
                            c.endTransaction();
                        } catch (Throwable th32) {
                            f24810h.m21826b(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    c = null;
                    if (c != null) {
                        c.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    /* renamed from: a */
    private synchronized void m21771a(java.util.List<com.tencent.wxop.stat.ap> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.ag.a(java.util.List, boolean):void. bs: [B:26:0x00ca, B:49:0x00f2]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00d7 }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.C6156f.m21997b();	 Catch:{ all -> 0x00d7 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ all -> 0x00d7 }
    L_0x0010:
        r0 = f24810h;	 Catch:{ all -> 0x00d7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r3 = "Delete ";	 Catch:{ all -> 0x00d7 }
        r2.<init>(r3);	 Catch:{ all -> 0x00d7 }
        r3 = r9.size();	 Catch:{ all -> 0x00d7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00d7 }
        r3 = " events, important:";	 Catch:{ all -> 0x00d7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00d7 }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00d7 }
        r2 = r2.toString();	 Catch:{ all -> 0x00d7 }
        r0.m21825b(r2);	 Catch:{ all -> 0x00d7 }
    L_0x0034:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r0 = r9.size();	 Catch:{ all -> 0x00d7 }
        r0 = r0 * 3;	 Catch:{ all -> 0x00d7 }
        r3.<init>(r0);	 Catch:{ all -> 0x00d7 }
        r0 = "event_id in (";	 Catch:{ all -> 0x00d7 }
        r3.append(r0);	 Catch:{ all -> 0x00d7 }
        r0 = 0;	 Catch:{ all -> 0x00d7 }
        r4 = r9.size();	 Catch:{ all -> 0x00d7 }
        r5 = r9.iterator();	 Catch:{ all -> 0x00d7 }
        r2 = r0;	 Catch:{ all -> 0x00d7 }
    L_0x004f:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00d7 }
        if (r0 == 0) goto L_0x006e;	 Catch:{ all -> 0x00d7 }
    L_0x0055:
        r0 = r5.next();	 Catch:{ all -> 0x00d7 }
        r0 = (com.tencent.wxop.stat.ap) r0;	 Catch:{ all -> 0x00d7 }
        r6 = r0.f24848a;	 Catch:{ all -> 0x00d7 }
        r3.append(r6);	 Catch:{ all -> 0x00d7 }
        r0 = r4 + -1;	 Catch:{ all -> 0x00d7 }
        if (r2 == r0) goto L_0x006a;	 Catch:{ all -> 0x00d7 }
    L_0x0064:
        r0 = ",";	 Catch:{ all -> 0x00d7 }
        r3.append(r0);	 Catch:{ all -> 0x00d7 }
    L_0x006a:
        r0 = r2 + 1;	 Catch:{ all -> 0x00d7 }
        r2 = r0;	 Catch:{ all -> 0x00d7 }
        goto L_0x004f;	 Catch:{ all -> 0x00d7 }
    L_0x006e:
        r0 = ")";	 Catch:{ all -> 0x00d7 }
        r3.append(r0);	 Catch:{ all -> 0x00d7 }
        r1 = r8.m21779c(r10);	 Catch:{ Throwable -> 0x00da }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00da }
        r0 = "events";	 Catch:{ Throwable -> 0x00da }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00da }
        r5 = 0;	 Catch:{ Throwable -> 0x00da }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00da }
        r2 = com.tencent.wxop.stat.C6156f.m21997b();	 Catch:{ Throwable -> 0x00da }
        if (r2 == 0) goto L_0x00bc;	 Catch:{ Throwable -> 0x00da }
    L_0x008d:
        r2 = f24810h;	 Catch:{ Throwable -> 0x00da }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00da }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00da }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00da }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00da }
        r5 = " event ";	 Catch:{ Throwable -> 0x00da }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00da }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00da }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00da }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00da }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00da }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00da }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00da }
        r2.m21825b(r3);	 Catch:{ Throwable -> 0x00da }
    L_0x00bc:
        r2 = r8.f24813a;	 Catch:{ Throwable -> 0x00da }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00da }
        r8.f24813a = r0;	 Catch:{ Throwable -> 0x00da }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00da }
        r8.m21782f();	 Catch:{ Throwable -> 0x00da }
        if (r1 == 0) goto L_0x0008;
    L_0x00ca:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00cf }
        goto L_0x0008;
    L_0x00cf:
        r0 = move-exception;
        r1 = f24810h;	 Catch:{ all -> 0x00d7 }
        r1.m21826b(r0);	 Catch:{ all -> 0x00d7 }
        goto L_0x0008;
    L_0x00d7:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00da:
        r0 = move-exception;
        r2 = f24810h;	 Catch:{ all -> 0x00ef }
        r2.m21826b(r0);	 Catch:{ all -> 0x00ef }
        if (r1 == 0) goto L_0x0008;
    L_0x00e2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00e7 }
        goto L_0x0008;
    L_0x00e7:
        r0 = move-exception;
        r1 = f24810h;	 Catch:{ all -> 0x00d7 }
        r1.m21826b(r0);	 Catch:{ all -> 0x00d7 }
        goto L_0x0008;
    L_0x00ef:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00f5;
    L_0x00f2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00f6 }
    L_0x00f5:
        throw r0;	 Catch:{ all -> 0x00d7 }
    L_0x00f6:
        r1 = move-exception;	 Catch:{ all -> 0x00d7 }
        r2 = f24810h;	 Catch:{ all -> 0x00d7 }
        r2.m21826b(r1);	 Catch:{ all -> 0x00d7 }
        goto L_0x00f5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.ag.a(java.util.List, boolean):void");
    }

    /* renamed from: a */
    private void m21772a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = m21779c(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (C6156f.m21997b()) {
                f24810h.m21825b("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    f24810h.m21826b(th);
                }
            }
        } catch (Throwable th2) {
            f24810h.m21826b(th2);
        }
    }

    /* renamed from: b */
    private int m21773b(boolean z) {
        return !z ? C6156f.m22020g() : C6156f.m22010e();
    }

    /* renamed from: b */
    public static ag m21774b() {
        return f24812j;
    }

    /* renamed from: b */
    private void m21775b(int i, boolean z) {
        int g = i == -1 ? !z ? m21783g() : m21784h() : i;
        if (g > 0) {
            int m = (C6156f.m22034m() * 60) * C6156f.m22024h();
            if (g > m && m > 0) {
                g = m;
            }
            int i2 = C6156f.m22026i();
            int i3 = g / i2;
            int i4 = g % i2;
            if (C6156f.m21997b()) {
                f24810h.m21825b("sentStoreEventsByDb sendNumbers=" + g + ",important=" + z + ",maxSendNumPerFor1Period=" + m + ",maxCount=" + i3 + ",restNumbers=" + i4);
            }
            for (g = 0; g < i3; g++) {
                m21762a(i2, z);
            }
            if (i4 > 0) {
                m21762a(i4, z);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m21776b(C6119e c6119e, av avVar, boolean z, boolean z2) {
        if (C6156f.m22028j() > 0) {
            if (C6156f.f25063n <= 0 || z || z2) {
                m21763a(c6119e, avVar, z);
            } else if (C6156f.f25063n > 0) {
                if (C6156f.m21997b()) {
                    f24810h.m21825b("cacheEventsInMemory.size():" + this.f24821l.size() + ",numEventsCachedInMemory:" + C6156f.f25063n + ",numStoredEvents:" + this.f24813a);
                    f24810h.m21825b("cache event:" + c6119e.m21717g());
                }
                this.f24821l.put(c6119e, "");
                if (this.f24821l.size() >= C6156f.f25063n) {
                    m21785i();
                }
                if (avVar != null) {
                    if (this.f24821l.size() > 0) {
                        m21785i();
                    }
                    avVar.mo5017a();
                }
            }
        }
    }

    /* renamed from: b */
    private synchronized void m21777b(at atVar) {
        Throwable th;
        Cursor query;
        try {
            Object obj;
            long update;
            String a = atVar.m21804a();
            String a2 = C6144m.m21866a(a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", atVar.f24858b.toString());
            contentValues.put("md5sum", a2);
            atVar.f24859c = a2;
            contentValues.put("version", Integer.valueOf(atVar.f24860d));
            query = this.f24815c.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != atVar.f24857a);
            obj = 1;
            this.f24815c.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.f24815c.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(atVar.f24857a)});
            } else {
                contentValues.put("type", Integer.valueOf(atVar.f24857a));
                update = this.f24815c.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                f24810h.m21832h("Failed to store cfg:" + a);
            } else {
                f24810h.m21834j("Sucessed to store cfg:" + a);
            }
            this.f24815c.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.f24815c.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.f24815c.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    /* renamed from: b */
    private void m21778b(List<ap> list, int i, boolean z) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            query = m21780d(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(0);
                    String string = query.getString(1);
                    if (!C6156f.f25056g) {
                        string = C6150s.m21918a(string);
                    }
                    int i2 = query.getInt(2);
                    int i3 = query.getInt(3);
                    ap apVar = new ap(j, string, i2, i3);
                    if (C6156f.m21997b()) {
                        f24810h.m21825b("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + query.getLong(4));
                    }
                    list.add(apVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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

    /* renamed from: c */
    private SQLiteDatabase m21779c(boolean z) {
        return !z ? this.f24815c.getWritableDatabase() : this.f24816d.getWritableDatabase();
    }

    /* renamed from: d */
    private SQLiteDatabase m21780d(boolean z) {
        return !z ? this.f24815c.getReadableDatabase() : this.f24816d.getReadableDatabase();
    }

    /* renamed from: f */
    private void m21782f() {
        this.f24813a = m21783g() + m21784h();
    }

    /* renamed from: g */
    private int m21783g() {
        return (int) DatabaseUtils.queryNumEntries(this.f24815c.getReadableDatabase(), "events");
    }

    /* renamed from: h */
    private int m21784h() {
        return (int) DatabaseUtils.queryNumEntries(this.f24816d.getReadableDatabase(), "events");
    }

    /* renamed from: i */
    private void m21785i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.ag.i():void. bs: [B:42:0x0128, B:53:0x0140]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.f24822m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.f24821l;
        monitor-enter(r2);
        r0 = r9.f24821l;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.f24822m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.C6156f.m21997b();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0054;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = f24810h;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f24821l;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.C6156f.f25063n;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f24813a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.m21825b(r3);	 Catch:{ all -> 0x0013 }
    L_0x0054:
        r0 = r9.f24815c;	 Catch:{ Throwable -> 0x00d4 }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00d4 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d4 }
        r0 = r9.f24821l;	 Catch:{ Throwable -> 0x00d4 }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00d4 }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00d4 }
    L_0x0067:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00d4 }
        if (r0 == 0) goto L_0x0123;	 Catch:{ Throwable -> 0x00d4 }
    L_0x006d:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00d4 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00d4 }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00d4 }
        r0 = (com.tencent.wxop.stat.p290a.C6119e) r0;	 Catch:{ Throwable -> 0x00d4 }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00d4 }
        r4.<init>();	 Catch:{ Throwable -> 0x00d4 }
        r5 = r0.m21717g();	 Catch:{ Throwable -> 0x00d4 }
        r6 = com.tencent.wxop.stat.C6156f.m21997b();	 Catch:{ Throwable -> 0x00d4 }
        if (r6 == 0) goto L_0x009d;	 Catch:{ Throwable -> 0x00d4 }
    L_0x0088:
        r6 = f24810h;	 Catch:{ Throwable -> 0x00d4 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d4 }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00d4 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00d4 }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00d4 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00d4 }
        r6.m21825b(r7);	 Catch:{ Throwable -> 0x00d4 }
    L_0x009d:
        r5 = com.tencent.wxop.stat.p291b.C6150s.m21923b(r5);	 Catch:{ Throwable -> 0x00d4 }
        r6 = "content";	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00d4 }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00d4 }
        r6 = "0";	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00d4 }
        r5 = "status";	 Catch:{ Throwable -> 0x00d4 }
        r6 = 1;	 Catch:{ Throwable -> 0x00d4 }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00d4 }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00d4 }
        r6 = r0.m21713c();	 Catch:{ Throwable -> 0x00d4 }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00d4 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d4 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d4 }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00d4 }
        r3.remove();	 Catch:{ Throwable -> 0x00d4 }
        goto L_0x0067;
    L_0x00d4:
        r0 = move-exception;
        r3 = f24810h;	 Catch:{ all -> 0x013d }
        r3.m21826b(r0);	 Catch:{ all -> 0x013d }
        if (r1 == 0) goto L_0x00e2;
    L_0x00dc:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0136 }
        r9.m21782f();	 Catch:{ Throwable -> 0x0136 }
    L_0x00e2:
        r0 = 0;
        r9.f24822m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.C6156f.m21997b();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0120;	 Catch:{ all -> 0x0013 }
    L_0x00eb:
        r0 = f24810h;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f24821l;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.C6156f.f25063n;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f24813a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.m21825b(r1);	 Catch:{ all -> 0x0013 }
    L_0x0120:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0123:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d4 }
        if (r1 == 0) goto L_0x00e2;
    L_0x0128:
        r1.endTransaction();	 Catch:{ Throwable -> 0x012f }
        r9.m21782f();	 Catch:{ Throwable -> 0x012f }
        goto L_0x00e2;
    L_0x012f:
        r0 = move-exception;
        r1 = f24810h;	 Catch:{ all -> 0x0013 }
        r1.m21826b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00e2;	 Catch:{ all -> 0x0013 }
    L_0x0136:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = f24810h;	 Catch:{ all -> 0x0013 }
        r1.m21826b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00e2;
    L_0x013d:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0146;
    L_0x0140:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0147 }
        r9.m21782f();	 Catch:{ Throwable -> 0x0147 }
    L_0x0146:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x0147:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = f24810h;	 Catch:{ all -> 0x0013 }
        r3.m21826b(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0146;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.ag.i():void");
    }

    /* renamed from: j */
    private void m21786j() {
        Cursor query;
        Throwable th;
        try {
            query = this.f24815c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.f24823n.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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

    /* renamed from: a */
    public int m21787a() {
        return this.f24813a;
    }

    /* renamed from: a */
    void m21788a(int i) {
        this.f24817e.m21844a(new an(this, i));
    }

    /* renamed from: a */
    void m21789a(C6119e c6119e, av avVar, boolean z, boolean z2) {
        if (this.f24817e != null) {
            this.f24817e.m21844a(new ak(this, c6119e, avVar, z, z2));
        }
    }

    /* renamed from: a */
    void m21790a(at atVar) {
        if (atVar != null) {
            this.f24817e.m21844a(new al(this, atVar));
        }
    }

    /* renamed from: a */
    void m21791a(List<ap> list, int i, boolean z, boolean z2) {
        if (this.f24817e != null) {
            this.f24817e.m21844a(new ah(this, list, i, z, z2));
        }
    }

    /* renamed from: a */
    void m21792a(List<ap> list, boolean z, boolean z2) {
        if (this.f24817e != null) {
            this.f24817e.m21844a(new ai(this, list, z, z2));
        }
    }

    /* renamed from: b */
    public synchronized C6134c m21793b(Context context) {
        C6134c c6134c;
        Throwable th;
        Cursor cursor;
        if (this.f24814b != null) {
            c6134c = this.f24814b;
        } else {
            Cursor query;
            try {
                this.f24815c.getWritableDatabase().beginTransaction();
                if (C6156f.m21997b()) {
                    f24810h.m21825b((Object) "try to load user info from db.");
                }
                query = this.f24815c.getReadableDatabase().query(BNRCEventDetailsModel.BN_RC_KEY_USER, null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String b;
                    if (query.moveToNext()) {
                        String a = C6150s.m21918a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || C6144m.m21864a(query.getLong(3) * 1000).equals(C6144m.m21864a(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(C6144m.m21892n(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            b = C6144m.m21873b(context);
                            obj = 1;
                            a = b;
                        } else {
                            b = split[0];
                            if (b == null || b.length() < 11) {
                                string = C6150s.m21917a(context);
                                if (string == null || string.length() <= 10) {
                                    string = b;
                                } else {
                                    obj = 1;
                                }
                                b = a;
                                a = string;
                            } else {
                                String str = b;
                                b = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = C6144m.m21875c(context);
                            if (string != null && string.length() > 0) {
                                b = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            b = a + "," + string;
                        }
                        this.f24814b = new C6134c(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", C6150s.m21923b(b));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", C6144m.m21892n(context));
                        contentValues.put(MapObjKey.OBJ_SL_TIME, Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.f24815c.getWritableDatabase().update(BNRCEventDetailsModel.BN_RC_KEY_USER, contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.f24815c.getWritableDatabase().replace(BNRCEventDetailsModel.BN_RC_KEY_USER, null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = C6144m.m21873b(context);
                        b = C6144m.m21875c(context);
                        String str2 = (b == null || b.length() <= 0) ? string : string + "," + b;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String n = C6144m.m21892n(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", C6150s.m21923b(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", n);
                        contentValues2.put(MapObjKey.OBJ_SL_TIME, Long.valueOf(currentTimeMillis2));
                        this.f24815c.getWritableDatabase().insert(BNRCEventDetailsModel.BN_RC_KEY_USER, null, contentValues2);
                        this.f24814b = new C6134c(string, b, 0);
                    }
                    this.f24815c.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            f24810h.m21826b(th2);
                        }
                    }
                    this.f24815c.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.f24815c.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.f24815c.getWritableDatabase().endTransaction();
                throw th2;
            }
            c6134c = this.f24814b;
        }
        return c6134c;
    }

    /* renamed from: c */
    void m21794c() {
        if (C6156f.m22003c()) {
            try {
                this.f24817e.m21844a(new aj(this));
            } catch (Throwable th) {
                f24810h.m21826b(th);
            }
        }
    }

    /* renamed from: d */
    void m21795d() {
        Cursor query;
        Throwable th;
        try {
            query = this.f24815c.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    at atVar = new at(i);
                    atVar.f24857a = i;
                    atVar.f24858b = new JSONObject(string);
                    atVar.f24859c = string2;
                    atVar.f24860d = i2;
                    C6156f.m21978a(f24811i, atVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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
}
