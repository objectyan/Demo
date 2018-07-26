package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0578p;

public class PushInfoProvider extends ContentProvider {
    /* renamed from: c */
    private static final UriMatcher f1291c = new UriMatcher(-1);
    /* renamed from: a */
    SQLiteDatabase f1292a;
    /* renamed from: b */
    private Context f1293b;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.f1293b = getContext();
        f1291c.addURI(this.f1293b.getPackageName() + ".bdpush", C0578p.m2502F(this.f1293b) ? "pushinfo_v3" : "pushinfo", 1);
        f1291c.addURI(this.f1293b.getPackageName() + ".bdpush", "verif", 2);
        f1291c.addURI(this.f1293b.getPackageName() + ".bdpush", "msgInfo", 3);
        f1291c.addURI(this.f1293b.getPackageName() + ".bdpush", "appstatus", 4);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (C0472c.m2021a()) {
            try {
                switch (f1291c.match(uri)) {
                    case 1:
                        this.f1292a = C0472c.m2020a(this.f1293b);
                        query = this.f1292a != null ? this.f1292a.query("PushShareInfo", null, null, null, null, null, null) : null;
                        if (query != null) {
                            break;
                        }
                        break;
                    case 2:
                        this.f1292a = C0472c.m2020a(this.f1293b);
                        query = this.f1292a != null ? this.f1292a.query("PushVerifInfo", strArr, str, strArr2, null, null, str2) : null;
                        if (query != null) {
                            break;
                        }
                        break;
                    case 3:
                        this.f1292a = C0472c.m2020a(this.f1293b);
                        query = this.f1292a != null ? this.f1292a.query("PushMsgInfos", strArr, str, strArr2, null, null, str2) : null;
                        if (query != null) {
                            break;
                        }
                        break;
                    case 4:
                        this.f1292a = C0472c.m2020a(this.f1293b);
                        query = this.f1292a != null ? this.f1292a.query("PushAppStatus", strArr, str, strArr2, null, null, str2) : null;
                        if (query != null) {
                            break;
                        }
                        break;
                }
            } catch (Throwable e) {
                C0553q.m2362a(this.f1293b, e);
            }
            query = null;
        }
        return query;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r16, android.content.ContentValues r17, java.lang.String r18, java.lang.String[] r19) {
        /*
        r15 = this;
        r12 = -1;
        r3 = 0;
        r11 = com.baidu.android.pushservice.p025d.C0472c.m2021a();
        monitor-enter(r11);
        r10 = 0;
        r2 = f1291c;	 Catch:{ Exception -> 0x005e, all -> 0x0072 }
        r0 = r16;
        r2 = r2.match(r0);	 Catch:{ Exception -> 0x005e, all -> 0x0072 }
        switch(r2) {
            case 1: goto L_0x0024;
            default: goto L_0x0014;
        };
    L_0x0014:
        r4 = r10;
        r5 = r3;
        r2 = r12;
    L_0x0017:
        if (r4 == 0) goto L_0x001c;
    L_0x0019:
        r4.close();	 Catch:{ all -> 0x007e }
    L_0x001c:
        if (r5 == 0) goto L_0x0021;
    L_0x001e:
        r5.close();	 Catch:{ all -> 0x007e }
    L_0x0021:
        monitor-exit(r11);	 Catch:{ all -> 0x007e }
        r2 = (int) r2;
        return r2;
    L_0x0024:
        r2 = r15.f1293b;	 Catch:{ Exception -> 0x005e, all -> 0x0072 }
        r2 = com.baidu.android.pushservice.p025d.C0472c.m2020a(r2);	 Catch:{ Exception -> 0x005e, all -> 0x0072 }
        if (r2 == 0) goto L_0x009d;
    L_0x002c:
        r3 = "PushShareInfo";
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0090, all -> 0x0081 }
        if (r4 == 0) goto L_0x0051;
    L_0x003b:
        r3 = r4.getCount();	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        if (r3 == 0) goto L_0x0051;
    L_0x0041:
        r3 = "PushShareInfo";
        r5 = 0;
        r0 = r17;
        r1 = r18;
        r3 = r2.update(r3, r0, r1, r5);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r12 = (long) r3;	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r5 = r2;
        r2 = r12;
        goto L_0x0017;
    L_0x0051:
        r3 = "PushShareInfo";
        r5 = 0;
        r0 = r17;
        r12 = r2.insert(r3, r5, r0);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r5 = r2;
        r2 = r12;
        goto L_0x0017;
    L_0x005e:
        r2 = move-exception;
        r4 = r3;
        r3 = r10;
    L_0x0061:
        r5 = r15.f1293b;	 Catch:{ all -> 0x008c }
        com.baidu.android.pushservice.p029h.C0553q.m2362a(r5, r2);	 Catch:{ all -> 0x008c }
        if (r3 == 0) goto L_0x006b;
    L_0x0068:
        r3.close();	 Catch:{ all -> 0x007e }
    L_0x006b:
        if (r4 == 0) goto L_0x009b;
    L_0x006d:
        r4.close();	 Catch:{ all -> 0x007e }
        r2 = r12;
        goto L_0x0021;
    L_0x0072:
        r2 = move-exception;
    L_0x0073:
        if (r10 == 0) goto L_0x0078;
    L_0x0075:
        r10.close();	 Catch:{ all -> 0x007e }
    L_0x0078:
        if (r3 == 0) goto L_0x007d;
    L_0x007a:
        r3.close();	 Catch:{ all -> 0x007e }
    L_0x007d:
        throw r2;	 Catch:{ all -> 0x007e }
    L_0x007e:
        r2 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x007e }
        throw r2;
    L_0x0081:
        r3 = move-exception;
        r14 = r3;
        r3 = r2;
        r2 = r14;
        goto L_0x0073;
    L_0x0086:
        r3 = move-exception;
        r10 = r4;
        r14 = r3;
        r3 = r2;
        r2 = r14;
        goto L_0x0073;
    L_0x008c:
        r2 = move-exception;
        r10 = r3;
        r3 = r4;
        goto L_0x0073;
    L_0x0090:
        r3 = move-exception;
        r4 = r2;
        r2 = r3;
        r3 = r10;
        goto L_0x0061;
    L_0x0095:
        r3 = move-exception;
        r14 = r3;
        r3 = r4;
        r4 = r2;
        r2 = r14;
        goto L_0x0061;
    L_0x009b:
        r2 = r12;
        goto L_0x0021;
    L_0x009d:
        r4 = r10;
        r5 = r2;
        r2 = r12;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.PushInfoProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
