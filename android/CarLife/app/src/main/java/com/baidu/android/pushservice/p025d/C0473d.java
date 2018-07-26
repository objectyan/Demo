package com.baidu.android.pushservice.p025d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p025d.C0472c.C0469d;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.d.d */
public class C0473d {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static java.lang.String m2043a(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2584m(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = 52;
        if (r0 < r1) goto L_0x00a2;
    L_0x0009:
        r0 = r7.getContentResolver();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r0 == 0) goto L_0x00a2;
    L_0x000f:
        r1 = com.baidu.android.pushservice.p031j.C0578p.m2611z(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x007d;
    L_0x0015:
        r1 = "pushinfo_v3";
    L_0x0018:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2.<init>();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "content://";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = ".bdpush";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "/";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x00a0;
    L_0x004c:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0052:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushChannelID;	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2.<init>();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r3 = "pushchannelid  is ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.append(r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r2, r7);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
    L_0x0077:
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();	 Catch:{ Exception -> 0x0092 }
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = "pushinfo";
        goto L_0x0018;
    L_0x0081:
        r0 = move-exception;
        r0 = r6;
    L_0x0083:
        if (r6 == 0) goto L_0x007c;
    L_0x0085:
        r6.close();	 Catch:{ Exception -> 0x0089 }
        goto L_0x007c;
    L_0x0089:
        r1 = move-exception;
        goto L_0x007c;
    L_0x008b:
        r0 = move-exception;
    L_0x008c:
        if (r6 == 0) goto L_0x0091;
    L_0x008e:
        r6.close();	 Catch:{ Exception -> 0x0094 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0094:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0096:
        r0 = move-exception;
        r6 = r1;
        goto L_0x008c;
    L_0x0099:
        r0 = move-exception;
        r0 = r6;
        r6 = r1;
        goto L_0x0083;
    L_0x009d:
        r2 = move-exception;
        r6 = r1;
        goto L_0x0083;
    L_0x00a0:
        r0 = r6;
        goto L_0x0077;
    L_0x00a2:
        r0 = r6;
        r1 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m2044a(Context context) {
        Throwable th;
        Cursor cursor = null;
        String b = PushSettings.m1821b(context);
        if (!TextUtils.isEmpty(b)) {
            Cursor query;
            try {
                String u = C0578p.m2600u(context);
                if (C0578p.m2584m(context, u) >= C0430a.m1854a()) {
                    ContentResolver contentResolver = context.getContentResolver();
                    if (contentResolver != null) {
                        String[] strArr = new String[]{b, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - 86400000)};
                        query = contentResolver.query(Uri.parse("content://" + u + ".bdpush" + "/" + "msgInfo"), null, C0469d.appId.name() + " =? AND " + C0469d.expireTime.name() + " <? AND " + C0469d.arriveTime.name() + " >? ", strArr, C0469d.expireTime.name() + " DESC LIMIT " + 7);
                        if (query != null) {
                            int i = 0;
                            while (query.moveToNext()) {
                                try {
                                    long j = query.getLong(query.getColumnIndex(C0469d.msgId.name()));
                                    if (!C0578p.m2597s(context, String.valueOf(j))) {
                                        byte[] blob = query.getBlob(query.getColumnIndex(C0469d.msgBody.name()));
                                        if (!(blob == null || blob.length == 0)) {
                                            blob = BaiduAppSSOJni.getDecrypted(context, b, blob);
                                            query.getLong(query.getColumnIndex(C0469d.expireTime.name()));
                                            int i2 = query.getInt(query.getColumnIndex(C0469d.msgType.name()));
                                            byte[] blob2 = query.getBlob(query.getColumnIndex(C0469d.secureInfo.name()));
                                            Intent intent = new Intent();
                                            intent.putExtra("app_id", b);
                                            intent.putExtra("message_id", String.valueOf(j));
                                            intent.putExtra("baidu_message_type", i2);
                                            intent.putExtra("baidu_message_body", blob);
                                            intent.putExtra("baidu_message_secur_info", blob2);
                                            intent.putExtra("bdpush_deliver_NO_CALLBACK", true);
                                            C0578p.m2514a(context, intent, PushConstants.ACTION_MESSAGE, context.getPackageName());
                                            i++;
                                            if (i > 2) {
                                                if (query != null) {
                                                    try {
                                                        query.close();
                                                        return;
                                                    } catch (Exception e) {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    cursor = query;
                                    th = th2;
                                }
                            }
                        }
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e2) {
                                return;
                            }
                        }
                    }
                }
                query = null;
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static java.lang.String m2045b(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2584m(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = 52;
        if (r0 < r1) goto L_0x00a2;
    L_0x0009:
        r0 = r7.getContentResolver();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r0 == 0) goto L_0x00a2;
    L_0x000f:
        r1 = com.baidu.android.pushservice.p031j.C0578p.m2611z(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x007d;
    L_0x0015:
        r1 = "pushinfo_v3";
    L_0x0018:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2.<init>();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "content://";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = ".bdpush";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "/";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x00a0;
    L_0x004c:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0052:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushCurPkgName;	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2.<init>();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r3 = "curPkgname  is ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.append(r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r2, r7);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
    L_0x0077:
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();	 Catch:{ Exception -> 0x0092 }
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = "pushinfo";
        goto L_0x0018;
    L_0x0081:
        r0 = move-exception;
        r0 = r6;
    L_0x0083:
        if (r6 == 0) goto L_0x007c;
    L_0x0085:
        r6.close();	 Catch:{ Exception -> 0x0089 }
        goto L_0x007c;
    L_0x0089:
        r1 = move-exception;
        goto L_0x007c;
    L_0x008b:
        r0 = move-exception;
    L_0x008c:
        if (r6 == 0) goto L_0x0091;
    L_0x008e:
        r6.close();	 Catch:{ Exception -> 0x0094 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0094:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0096:
        r0 = move-exception;
        r6 = r1;
        goto L_0x008c;
    L_0x0099:
        r0 = move-exception;
        r0 = r6;
        r6 = r1;
        goto L_0x0083;
    L_0x009d:
        r2 = move-exception;
        r6 = r1;
        goto L_0x0083;
    L_0x00a0:
        r0 = r6;
        goto L_0x0077;
    L_0x00a2:
        r0 = r6;
        r1 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static int m2046c(android.content.Context r8, java.lang.String r9) {
        /*
        r7 = 0;
        r6 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2584m(r8, r9);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r1 = 52;
        if (r0 < r1) goto L_0x00a2;
    L_0x000a:
        r0 = r8.getContentResolver();	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        if (r0 == 0) goto L_0x00a2;
    L_0x0010:
        r1 = com.baidu.android.pushservice.p031j.C0578p.m2611z(r8, r9);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        if (r1 == 0) goto L_0x007e;
    L_0x0016:
        r1 = "pushinfo_v3";
    L_0x0019:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r2.<init>();	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r3 = "content://";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r2 = r2.append(r9);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r3 = ".bdpush";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r3 = "/";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0082, all -> 0x008d }
        if (r1 == 0) goto L_0x00a0;
    L_0x004d:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x009b, all -> 0x0098 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0053:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushPriority;	 Catch:{ Throwable -> 0x009b, all -> 0x0098 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x009b, all -> 0x0098 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x009b, all -> 0x0098 }
        r0 = r1.getInt(r0);	 Catch:{ Throwable -> 0x009b, all -> 0x0098 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e, all -> 0x0098 }
        r2.<init>();	 Catch:{ Throwable -> 0x009e, all -> 0x0098 }
        r3 = "pushpriority  is ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x009e, all -> 0x0098 }
        r2 = r2.append(r0);	 Catch:{ Throwable -> 0x009e, all -> 0x0098 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009e, all -> 0x0098 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r2, r8);	 Catch:{ Throwable -> 0x009e, all -> 0x0098 }
    L_0x0078:
        if (r1 == 0) goto L_0x007d;
    L_0x007a:
        r1.close();	 Catch:{ Exception -> 0x0094 }
    L_0x007d:
        return r0;
    L_0x007e:
        r1 = "pushinfo";
        goto L_0x0019;
    L_0x0082:
        r0 = move-exception;
        r0 = r6;
        r1 = r7;
    L_0x0085:
        if (r1 == 0) goto L_0x007d;
    L_0x0087:
        r1.close();	 Catch:{ Exception -> 0x008b }
        goto L_0x007d;
    L_0x008b:
        r1 = move-exception;
        goto L_0x007d;
    L_0x008d:
        r0 = move-exception;
    L_0x008e:
        if (r7 == 0) goto L_0x0093;
    L_0x0090:
        r7.close();	 Catch:{ Exception -> 0x0096 }
    L_0x0093:
        throw r0;
    L_0x0094:
        r1 = move-exception;
        goto L_0x007d;
    L_0x0096:
        r1 = move-exception;
        goto L_0x0093;
    L_0x0098:
        r0 = move-exception;
        r7 = r1;
        goto L_0x008e;
    L_0x009b:
        r0 = move-exception;
        r0 = r6;
        goto L_0x0085;
    L_0x009e:
        r2 = move-exception;
        goto L_0x0085;
    L_0x00a0:
        r0 = r6;
        goto L_0x0078;
    L_0x00a2:
        r0 = r6;
        r1 = r7;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.c(android.content.Context, java.lang.String):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static int m2047d(android.content.Context r8, java.lang.String r9) {
        /*
        r7 = 0;
        r0 = 0;
        r6 = 0;
        r6 = com.baidu.android.pushservice.p031j.C0578p.m2496C(r8, r9);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        if (r6 <= 0) goto L_0x0010;
    L_0x0009:
        if (r7 == 0) goto L_0x000e;
    L_0x000b:
        r0.close();	 Catch:{ Exception -> 0x00cc }
    L_0x000e:
        r0 = r6;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = r8.getContentResolver();	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        if (r0 == 0) goto L_0x00e0;
    L_0x0016:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r1.<init>();	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r2 = "content://";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r1 = r1.append(r9);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r2 = ".bdpush";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r2 = "/";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r2 = "pushinfo_v3";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00b8, all -> 0x00c5 }
        if (r7 == 0) goto L_0x006a;
    L_0x004d:
        r0 = r7.moveToFirst();	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        if (r0 == 0) goto L_0x00e0;
    L_0x0053:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushVersion;	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r0 = r7.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r6 = r7.getInt(r0);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r0 = r6;
    L_0x0062:
        if (r7 == 0) goto L_0x000f;
    L_0x0064:
        r7.close();	 Catch:{ Exception -> 0x0068 }
        goto L_0x000f;
    L_0x0068:
        r1 = move-exception;
        goto L_0x000f;
    L_0x006a:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r1.<init>();	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r2 = "content://";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r1 = r1.append(r9);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r2 = ".bdpush";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r2 = "/";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r2 = "pushinfo";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00d5, all -> 0x00c5 }
        if (r0 == 0) goto L_0x00dd;
    L_0x00a1:
        r1 = r0.moveToFirst();	 Catch:{ Throwable -> 0x00d9, all -> 0x00d1 }
        if (r1 == 0) goto L_0x00dd;
    L_0x00a7:
        r1 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushVersion;	 Catch:{ Throwable -> 0x00d9, all -> 0x00d1 }
        r1 = r1.name();	 Catch:{ Throwable -> 0x00d9, all -> 0x00d1 }
        r1 = r0.getColumnIndex(r1);	 Catch:{ Throwable -> 0x00d9, all -> 0x00d1 }
        r6 = r0.getInt(r1);	 Catch:{ Throwable -> 0x00d9, all -> 0x00d1 }
        r7 = r0;
        r0 = r6;
        goto L_0x0062;
    L_0x00b8:
        r0 = move-exception;
        r0 = r6;
        r1 = r7;
    L_0x00bb:
        if (r1 == 0) goto L_0x000f;
    L_0x00bd:
        r1.close();	 Catch:{ Exception -> 0x00c2 }
        goto L_0x000f;
    L_0x00c2:
        r1 = move-exception;
        goto L_0x000f;
    L_0x00c5:
        r0 = move-exception;
    L_0x00c6:
        if (r7 == 0) goto L_0x00cb;
    L_0x00c8:
        r7.close();	 Catch:{ Exception -> 0x00cf }
    L_0x00cb:
        throw r0;
    L_0x00cc:
        r0 = move-exception;
        goto L_0x000e;
    L_0x00cf:
        r1 = move-exception;
        goto L_0x00cb;
    L_0x00d1:
        r1 = move-exception;
        r7 = r0;
        r0 = r1;
        goto L_0x00c6;
    L_0x00d5:
        r0 = move-exception;
        r0 = r6;
        r1 = r7;
        goto L_0x00bb;
    L_0x00d9:
        r1 = move-exception;
        r1 = r0;
        r0 = r6;
        goto L_0x00bb;
    L_0x00dd:
        r7 = r0;
        r0 = r6;
        goto L_0x0062;
    L_0x00e0:
        r0 = r6;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.d(android.content.Context, java.lang.String):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static java.lang.String m2048e(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2584m(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = 52;
        if (r0 < r1) goto L_0x00a2;
    L_0x0009:
        r0 = r7.getContentResolver();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r0 == 0) goto L_0x00a2;
    L_0x000f:
        r1 = com.baidu.android.pushservice.p031j.C0578p.m2611z(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x007d;
    L_0x0015:
        r1 = "pushinfo_v3";
    L_0x0018:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2.<init>();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "content://";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = ".bdpush";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "/";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x00a0;
    L_0x004c:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0052:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushSDKClientBindInfo;	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2.<init>();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r3 = "sdkclientbindinfo  is ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.append(r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r2, r7);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
    L_0x0077:
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();	 Catch:{ Exception -> 0x0092 }
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = "pushinfo";
        goto L_0x0018;
    L_0x0081:
        r0 = move-exception;
        r0 = r6;
    L_0x0083:
        if (r6 == 0) goto L_0x007c;
    L_0x0085:
        r6.close();	 Catch:{ Exception -> 0x0089 }
        goto L_0x007c;
    L_0x0089:
        r1 = move-exception;
        goto L_0x007c;
    L_0x008b:
        r0 = move-exception;
    L_0x008c:
        if (r6 == 0) goto L_0x0091;
    L_0x008e:
        r6.close();	 Catch:{ Exception -> 0x0094 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0094:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0096:
        r0 = move-exception;
        r6 = r1;
        goto L_0x008c;
    L_0x0099:
        r0 = move-exception;
        r0 = r6;
        r6 = r1;
        goto L_0x0083;
    L_0x009d:
        r2 = move-exception;
        r6 = r1;
        goto L_0x0083;
    L_0x00a0:
        r0 = r6;
        goto L_0x0077;
    L_0x00a2:
        r0 = r6;
        r1 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.e(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public static java.lang.String m2049f(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2584m(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = 52;
        if (r0 < r1) goto L_0x00a2;
    L_0x0009:
        r0 = r7.getContentResolver();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r0 == 0) goto L_0x00a2;
    L_0x000f:
        r1 = com.baidu.android.pushservice.p031j.C0578p.m2611z(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x007d;
    L_0x0015:
        r1 = "pushinfo_v3";
    L_0x0018:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2.<init>();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "content://";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = ".bdpush";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "/";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x00a0;
    L_0x004c:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0052:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushClientsBindInfo;	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2.<init>();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r3 = "pushclientsbindinfo  is ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.append(r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r2, r7);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
    L_0x0077:
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();	 Catch:{ Exception -> 0x0092 }
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = "pushinfo";
        goto L_0x0018;
    L_0x0081:
        r0 = move-exception;
        r0 = r6;
    L_0x0083:
        if (r6 == 0) goto L_0x007c;
    L_0x0085:
        r6.close();	 Catch:{ Exception -> 0x0089 }
        goto L_0x007c;
    L_0x0089:
        r1 = move-exception;
        goto L_0x007c;
    L_0x008b:
        r0 = move-exception;
    L_0x008c:
        if (r6 == 0) goto L_0x0091;
    L_0x008e:
        r6.close();	 Catch:{ Exception -> 0x0094 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0094:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0096:
        r0 = move-exception;
        r6 = r1;
        goto L_0x008c;
    L_0x0099:
        r0 = move-exception;
        r0 = r6;
        r6 = r1;
        goto L_0x0083;
    L_0x009d:
        r2 = move-exception;
        r6 = r1;
        goto L_0x0083;
    L_0x00a0:
        r0 = r6;
        goto L_0x0077;
    L_0x00a2:
        r0 = r6;
        r1 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.f(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public static java.lang.String m2050g(android.content.Context r7, java.lang.String r8) {
        /*
        r6 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2584m(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = 52;
        if (r0 < r1) goto L_0x00a2;
    L_0x0009:
        r0 = r7.getContentResolver();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r0 == 0) goto L_0x00a2;
    L_0x000f:
        r1 = com.baidu.android.pushservice.p031j.C0578p.m2611z(r7, r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x007d;
    L_0x0015:
        r1 = "pushinfo_v3";
    L_0x0018:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2.<init>();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "content://";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = ".bdpush";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r3 = "/";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0081, all -> 0x008b }
        if (r1 == 0) goto L_0x00a0;
    L_0x004c:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0052:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushSelfBindInfo;	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r0.name();	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0096 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2.<init>();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r3 = "pushselfbindinfo  is ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.append(r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
        com.baidu.android.pushservice.p031j.C0578p.m2546b(r2, r7);	 Catch:{ Throwable -> 0x009d, all -> 0x0096 }
    L_0x0077:
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();	 Catch:{ Exception -> 0x0092 }
    L_0x007c:
        return r0;
    L_0x007d:
        r1 = "pushinfo";
        goto L_0x0018;
    L_0x0081:
        r0 = move-exception;
        r0 = r6;
    L_0x0083:
        if (r6 == 0) goto L_0x007c;
    L_0x0085:
        r6.close();	 Catch:{ Exception -> 0x0089 }
        goto L_0x007c;
    L_0x0089:
        r1 = move-exception;
        goto L_0x007c;
    L_0x008b:
        r0 = move-exception;
    L_0x008c:
        if (r6 == 0) goto L_0x0091;
    L_0x008e:
        r6.close();	 Catch:{ Exception -> 0x0094 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0094:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0096:
        r0 = move-exception;
        r6 = r1;
        goto L_0x008c;
    L_0x0099:
        r0 = move-exception;
        r0 = r6;
        r6 = r1;
        goto L_0x0083;
    L_0x009d:
        r2 = move-exception;
        r6 = r1;
        goto L_0x0083;
    L_0x00a0:
        r0 = r6;
        goto L_0x0077;
    L_0x00a2:
        r0 = r6;
        r1 = r6;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.d.g(android.content.Context, java.lang.String):java.lang.String");
    }
}
