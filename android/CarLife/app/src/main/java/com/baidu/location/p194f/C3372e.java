package com.baidu.location.p194f;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.p188h.C3391g;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.baidu.location.f.e */
public class C3372e {
    /* renamed from: a */
    public List<ScanResult> f18275a = null;
    /* renamed from: b */
    private long f18276b = 0;
    /* renamed from: c */
    private long f18277c = 0;
    /* renamed from: d */
    private boolean f18278d = false;
    /* renamed from: e */
    private boolean f18279e;

    public C3372e(C3372e c3372e) {
        if (c3372e != null) {
            this.f18275a = c3372e.f18275a;
            this.f18276b = c3372e.f18276b;
            this.f18277c = c3372e.f18277c;
            this.f18278d = c3372e.f18278d;
        }
    }

    public C3372e(List<ScanResult> list, long j) {
        this.f18276b = j;
        this.f18275a = list;
        this.f18277c = System.currentTimeMillis();
        m14329o();
    }

    /* renamed from: a */
    public static String m14326a(int i, List<ScanResult> list) {
        if (list.size() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = list.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) list.get(i2)).level != 0) {
                if (((ScanResult) list.get(i2)).BSSID == null) {
                    size = i3;
                    i2++;
                    i3 = size;
                } else {
                    if (i3 != 0) {
                        i3 = 0;
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) list.get(i2)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
                    size = ((ScanResult) list.get(i2)).level;
                    if (size < 0) {
                        size = -size;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                }
            }
            size = i3;
            i2++;
            i3 = size;
        }
        return i3 == 0 ? stringBuffer.toString() : null;
    }

    /* renamed from: a */
    private boolean m14327a(String str) {
        return TextUtils.isEmpty(str) ? false : Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    /* renamed from: b */
    private String m14328b(String str) {
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", JNISearchConst.LAYER_ID_DIVIDER).replace(";", JNISearchConst.LAYER_ID_DIVIDER) : str : str;
    }

    /* renamed from: o */
    private void m14329o() {
        if (m14330a() >= 1) {
            Object obj = 1;
            for (int size = this.f18275a.size() - 1; size >= 1 && r2 != null; size--) {
                int i = 0;
                obj = null;
                while (i < size) {
                    Object obj2;
                    if (((ScanResult) this.f18275a.get(i)).level < ((ScanResult) this.f18275a.get(i + 1)).level) {
                        ScanResult scanResult = (ScanResult) this.f18275a.get(i + 1);
                        this.f18275a.set(i + 1, this.f18275a.get(i));
                        this.f18275a.set(i, scanResult);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    i++;
                    obj = obj2;
                }
            }
        }
    }

    /* renamed from: a */
    public int m14330a() {
        return this.f18275a == null ? 0 : this.f18275a.size();
    }

    /* renamed from: a */
    public String m14331a(int i) {
        return m14332a(i, false, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public java.lang.String m14332a(int r27, boolean r28, boolean r29) {
        /*
        r26 = this;
        r2 = r26.m14330a();
        r3 = 1;
        if (r2 >= r3) goto L_0x0009;
    L_0x0007:
        r2 = 0;
    L_0x0008:
        return r2;
    L_0x0009:
        r3 = 0;
        r19 = new java.util.Random;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r19.<init>();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r20 = new java.lang.StringBuffer;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r0 = r20;
        r0.<init>(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r21 = new java.util.ArrayList;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r21.<init>();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = com.baidu.location.p194f.C3376f.m14355a();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r6 = r2.m14376l();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r5 = 0;
        r4 = 0;
        r2 = -1;
        if (r6 == 0) goto L_0x03c7;
    L_0x002a:
        r7 = r6.getBSSID();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r7 == 0) goto L_0x03c7;
    L_0x0030:
        r2 = r6.getBSSID();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r4 = ":";
        r5 = "";
        r5 = r2.replace(r4, r5);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r6.getRssi();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r4 = com.baidu.location.p194f.C3376f.m14355a();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r4 = r4.m14378n();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r2 >= 0) goto L_0x03bf;
    L_0x004c:
        r2 = -r2;
        r16 = r2;
        r17 = r4;
        r18 = r5;
    L_0x0053:
        r4 = 0;
        r8 = 0;
        r2 = 0;
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r7 = 17;
        if (r6 < r7) goto L_0x03bc;
    L_0x005e:
        r4 = android.os.SystemClock.elapsedRealtimeNanos();	 Catch:{ Error -> 0x00af, Exception -> 0x03ae }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
    L_0x0065:
        r6 = 0;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x03bc;
    L_0x006b:
        r2 = 1;
        r14 = r4;
    L_0x006d:
        if (r2 == 0) goto L_0x03b9;
    L_0x006f:
        if (r2 == 0) goto L_0x00b3;
    L_0x0071:
        if (r28 == 0) goto L_0x00b3;
    L_0x0073:
        r2 = 1;
    L_0x0074:
        r13 = r2;
    L_0x0075:
        r7 = 0;
        r6 = 0;
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.size();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r5 = 1;
        r0 = r27;
        if (r2 <= r0) goto L_0x03b5;
    L_0x0084:
        r4 = 0;
        r2 = 0;
        r12 = r2;
    L_0x0087:
        r0 = r27;
        if (r12 >= r0) goto L_0x0274;
    L_0x008b:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.level;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r2 != 0) goto L_0x00b5;
    L_0x0099:
        r2 = r4;
        r4 = r6;
        r25 = r5;
        r5 = r7;
        r6 = r8;
        r8 = r3;
        r3 = r25;
    L_0x00a2:
        r9 = r12 + 1;
        r12 = r9;
        r25 = r3;
        r3 = r8;
        r8 = r6;
        r6 = r4;
        r7 = r5;
        r4 = r2;
        r5 = r25;
        goto L_0x0087;
    L_0x00af:
        r4 = move-exception;
        r4 = 0;
        goto L_0x0065;
    L_0x00b3:
        r2 = 0;
        goto L_0x0074;
    L_0x00b5:
        if (r13 == 0) goto L_0x00d8;
    L_0x00b7:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x01cc, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x01cc, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x01cc, Error -> 0x01f8 }
        r10 = r2.timestamp;	 Catch:{ Exception -> 0x01cc, Error -> 0x01f8 }
        r10 = r14 - r10;
        r22 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r10 = r10 / r22;
    L_0x00ca:
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r21;
        r0.add(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x00d8;
    L_0x00d7:
        r8 = r10;
    L_0x00d8:
        if (r5 == 0) goto L_0x01d1;
    L_0x00da:
        r5 = 0;
        r2 = "&wf=";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r29 == 0) goto L_0x0105;
    L_0x00e5:
        r4 = new java.lang.StringBuffer;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r4.<init>();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = "&wf_ch=";
        r4.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.frequency;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.m14335b(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r4.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x0105:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.BSSID;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r2 == 0) goto L_0x0269;
    L_0x0113:
        r10 = ":";
        r11 = "";
        r10 = r2.replace(r10, r11);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r10);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.level;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r2 >= 0) goto L_0x0131;
    L_0x0130:
        r2 = -r2;
    L_0x0131:
        r11 = java.util.Locale.CHINA;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r22 = ";%d;";
        r23 = 1;
        r0 = r23;
        r0 = new java.lang.Object[r0];	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r23 = r0;
        r24 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r23[r24] = r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r22;
        r1 = r23;
        r2 = java.lang.String.format(r11, r0, r1);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r7 = r7 + 1;
        r2 = 0;
        if (r18 == 0) goto L_0x0178;
    L_0x0158:
        r0 = r18;
        r10 = r0.equals(r10);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r10 == 0) goto L_0x0178;
    L_0x0160:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.capabilities;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.m14327a(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r0.f18279e = r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = 1;
        r6 = r7;
    L_0x0178:
        if (r2 != 0) goto L_0x0252;
    L_0x017a:
        if (r3 != 0) goto L_0x01fc;
    L_0x017c:
        r2 = 10;
        r0 = r19;
        r2 = r0.nextInt(r2);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r10 = 2;
        if (r2 != r10) goto L_0x03b2;
    L_0x0187:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.SSID;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        if (r2 == 0) goto L_0x03b2;
    L_0x0195:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.SSID;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.length();	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r10 = 30;
        if (r2 >= r10) goto L_0x03b2;
    L_0x01a9:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.SSID;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r0 = r26;
        r2 = r0.m14328b(r2);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r0 = r20;
        r0.append(r2);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = 1;
    L_0x01c1:
        r3 = r5;
        r5 = r7;
        r25 = r6;
        r6 = r8;
        r8 = r2;
        r2 = r4;
        r4 = r25;
        goto L_0x00a2;
    L_0x01cc:
        r2 = move-exception;
        r10 = 0;
        goto L_0x00ca;
    L_0x01d1:
        r2 = "|";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r29 == 0) goto L_0x0105;
    L_0x01db:
        r2 = "|";
        r4.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.frequency;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.m14335b(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r4.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        goto L_0x0105;
    L_0x01f8:
        r2 = move-exception;
        r2 = 0;
        goto L_0x0008;
    L_0x01fc:
        r2 = 1;
        if (r3 != r2) goto L_0x03b2;
    L_0x01ff:
        r2 = 20;
        r0 = r19;
        r2 = r0.nextInt(r2);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r10 = 1;
        if (r2 != r10) goto L_0x03b2;
    L_0x020a:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.SSID;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        if (r2 == 0) goto L_0x03b2;
    L_0x0218:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.SSID;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.length();	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r10 = 30;
        if (r2 >= r10) goto L_0x03b2;
    L_0x022c:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.get(r12);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = r2.SSID;	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r0 = r26;
        r2 = r0.m14328b(r2);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r0 = r20;
        r0.append(r2);	 Catch:{ Exception -> 0x0246, Error -> 0x01f8 }
        r2 = 2;
        goto L_0x01c1;
    L_0x0246:
        r2 = move-exception;
        r2 = r4;
        r4 = r6;
        r25 = r5;
        r5 = r7;
        r6 = r8;
        r8 = r3;
        r3 = r25;
        goto L_0x00a2;
    L_0x0252:
        r0 = r26;
        r2 = r0.f18275a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.get(r12);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.SSID;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.m14328b(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x0269:
        r2 = r4;
        r4 = r6;
        r25 = r5;
        r5 = r7;
        r6 = r8;
        r8 = r3;
        r3 = r25;
        goto L_0x00a2;
    L_0x0274:
        if (r5 != 0) goto L_0x03ab;
    L_0x0276:
        r2 = new java.lang.StringBuilder;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2.<init>();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3 = "&wf_n=";
        r2 = r2.append(r3);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.append(r6);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.toString();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r18 == 0) goto L_0x02b1;
    L_0x0291:
        r2 = -1;
        r0 = r16;
        if (r0 == r2) goto L_0x02b1;
    L_0x0296:
        r2 = new java.lang.StringBuilder;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2.<init>();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3 = "&wf_rs=";
        r2 = r2.append(r3);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.toString();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x02b1:
        r2 = 10;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x033b;
    L_0x02b7:
        r2 = r21.size();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r2 <= 0) goto L_0x033b;
    L_0x02bd:
        r2 = 0;
        r0 = r21;
        r2 = r0.get(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (java.lang.Long) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = r2.longValue();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r8 = 0;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x033b;
    L_0x02d0:
        r7 = new java.lang.StringBuffer;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r7.<init>(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = "&wf_ut=";
        r7.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r5 = 1;
        r2 = 0;
        r0 = r21;
        r2 = r0.get(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = (java.lang.Long) r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r8 = r21.iterator();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x02eb:
        r3 = r8.hasNext();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r3 == 0) goto L_0x0332;
    L_0x02f1:
        r3 = r8.next();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3 = (java.lang.Long) r3;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r5 == 0) goto L_0x030a;
    L_0x02f9:
        r5 = 0;
        r10 = r3.longValue();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r7.append(r10);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3 = r5;
    L_0x0302:
        r5 = "|";
        r7.append(r5);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r5 = r3;
        goto L_0x02eb;
    L_0x030a:
        r10 = r3.longValue();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r12 = r2.longValue();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r10 = r10 - r12;
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 == 0) goto L_0x0330;
    L_0x0319:
        r3 = new java.lang.StringBuilder;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3.<init>();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r9 = "";
        r3 = r3.append(r9);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3 = r3.append(r10);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r3 = r3.toString();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r7.append(r3);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x0330:
        r3 = r5;
        goto L_0x0302;
    L_0x0332:
        r2 = r7.toString();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x033b:
        r2 = "&wf_st=";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.f18276b;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = "&wf_et=";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.f18277c;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = "&wf_vt=";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = com.baidu.location.p194f.C3376f.f18284a;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r6 <= 0) goto L_0x0387;
    L_0x036e:
        r2 = 1;
        r0 = r26;
        r0.f18278d = r2;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r2 = "&wf_en=";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r26;
        r2 = r0.f18279e;	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        if (r2 == 0) goto L_0x03a9;
    L_0x0381:
        r2 = 1;
    L_0x0382:
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x0387:
        if (r17 == 0) goto L_0x0398;
    L_0x0389:
        r2 = "&wf_gw=";
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r1 = r17;
        r0.append(r1);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x0398:
        if (r4 == 0) goto L_0x03a3;
    L_0x039a:
        r2 = r4.toString();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        r0 = r20;
        r0.append(r2);	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
    L_0x03a3:
        r2 = r20.toString();	 Catch:{ Error -> 0x01f8, Exception -> 0x03ae }
        goto L_0x0008;
    L_0x03a9:
        r2 = 0;
        goto L_0x0382;
    L_0x03ab:
        r2 = 0;
        goto L_0x0008;
    L_0x03ae:
        r2 = move-exception;
        r2 = 0;
        goto L_0x0008;
    L_0x03b2:
        r2 = r3;
        goto L_0x01c1;
    L_0x03b5:
        r27 = r2;
        goto L_0x0084;
    L_0x03b9:
        r13 = r2;
        goto L_0x0075;
    L_0x03bc:
        r14 = r4;
        goto L_0x006d;
    L_0x03bf:
        r16 = r2;
        r17 = r4;
        r18 = r5;
        goto L_0x0053;
    L_0x03c7:
        r16 = r2;
        r17 = r4;
        r18 = r5;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.e.a(int, boolean, boolean):java.lang.String");
    }

    /* renamed from: a */
    public boolean m14333a(long j) {
        Object obj;
        long j2;
        int i;
        int i2;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        if (VERSION.SDK_INT >= 17) {
            try {
                j3 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                j3 = 0;
            } catch (Exception e2) {
                j3 = 0;
            }
            if (j3 > 0) {
                obj = 1;
                j2 = j3;
                if (obj != null || this.f18275a == null || this.f18275a.size() == 0) {
                    return false;
                }
                int size = this.f18275a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (!(((ScanResult) this.f18275a.get(i2)).level == 0 || obj == null)) {
                        try {
                            j3 = (j2 - ((ScanResult) this.f18275a.get(i2)).timestamp) / 1000000;
                        } catch (Exception e3) {
                            j3 = 0;
                        } catch (Error e4) {
                            j3 = 0;
                        }
                        j5 += j3;
                        if (j3 > j4) {
                            j4 = j3;
                        }
                    }
                }
                boolean z = 1000 * j4 <= j || (j5 / ((long) i)) * 1000 > j;
                return z;
            }
        }
        obj = null;
        j2 = j3;
        if (obj != null) {
            return false;
        }
        int size2 = this.f18275a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
            j3 = (j2 - ((ScanResult) this.f18275a.get(i2)).timestamp) / 1000000;
            j5 += j3;
            if (j3 > j4) {
                j4 = j3;
            }
        }
        if (1000 * j4 <= j) {
        }
        return z;
    }

    /* renamed from: a */
    public boolean m14334a(C3372e c3372e) {
        if (this.f18275a == null || c3372e == null || c3372e.f18275a == null) {
            return false;
        }
        int size = this.f18275a.size() < c3372e.f18275a.size() ? this.f18275a.size() : c3372e.f18275a.size();
        for (int i = 0; i < size; i++) {
            if (!((ScanResult) this.f18275a.get(i)).BSSID.equals(((ScanResult) c3372e.f18275a.get(i)).BSSID)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public int m14335b(int i) {
        return (i <= 2400 || i >= 2500) ? (i <= 4900 || i >= 5900) ? 0 : 5 : 2;
    }

    /* renamed from: b */
    public String m14336b() {
        try {
            return m14332a(C3391g.f18361N, true, true);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public boolean m14337b(C3372e c3372e) {
        if (this.f18275a == null || c3372e == null || c3372e.f18275a == null) {
            return false;
        }
        int size = this.f18275a.size() < c3372e.f18275a.size() ? this.f18275a.size() : c3372e.f18275a.size();
        for (int i = 0; i < size; i++) {
            String str = ((ScanResult) this.f18275a.get(i)).BSSID;
            int i2 = ((ScanResult) this.f18275a.get(i)).level;
            String str2 = ((ScanResult) c3372e.f18275a.get(i)).BSSID;
            int i3 = ((ScanResult) c3372e.f18275a.get(i)).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public String m14338c() {
        try {
            return m14332a(C3391g.f18361N, true, false);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    public String m14339c(int i) {
        if (m14330a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.f18275a.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) this.f18275a.get(i2)).level != 0) {
                if (((ScanResult) this.f18275a.get(i2)).BSSID == null) {
                    size = i3;
                    i2++;
                    i3 = size;
                } else {
                    if (i3 != 0) {
                        i3 = 0;
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.f18275a.get(i2)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
                    size = ((ScanResult) this.f18275a.get(i2)).level;
                    if (size < 0) {
                        size = -size;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                }
            }
            size = i3;
            i2++;
            i3 = size;
        }
        return i3 == 0 ? stringBuffer.toString() : null;
    }

    /* renamed from: c */
    public boolean m14340c(C3372e c3372e) {
        return C3376f.m14357a(c3372e, this);
    }

    /* renamed from: d */
    public String m14341d() {
        try {
            return m14331a(15);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public String m14342d(int i) {
        if (m14330a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.f18275a.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) this.f18275a.get(i2)).level != 0) {
                if (((ScanResult) this.f18275a.get(i2)).BSSID == null) {
                    size = i3;
                    i2++;
                    i3 = size;
                } else {
                    if (i3 != 0) {
                        i3 = 0;
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.f18275a.get(i2)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
                    size = ((ScanResult) this.f18275a.get(i2)).level;
                    if (size < 0) {
                        size = -size;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                }
            }
            size = i3;
            i2++;
            i3 = size;
        }
        if (i3 != 0) {
            return null;
        }
        stringBuffer.append("|");
        stringBuffer.append(this.f18277c / 1000);
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public boolean m14343d(C3372e c3372e) {
        return C3376f.m14358a(c3372e, this, 0.5f);
    }

    /* renamed from: e */
    public String m14344e(int i) {
        int i2 = 0;
        if (i == 0 || m14330a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.f18275a.size();
        int i3 = size > C3391g.f18361N ? C3391g.f18361N : size;
        int i4 = 1;
        int i5 = 0;
        while (i5 < i3) {
            if ((i4 & i) == 0 || ((ScanResult) this.f18275a.get(i5)).BSSID == null) {
                size = i2;
            } else {
                if (i2 == 0) {
                    stringBuffer.append("&ssid=");
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.f18275a.get(i5)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
                stringBuffer.append(";");
                stringBuffer.append(m14328b(((ScanResult) this.f18275a.get(i5)).SSID));
                size = i2 + 1;
            }
            i4 <<= 1;
            i5++;
            i2 = size;
        }
        return stringBuffer.toString();
    }

    /* renamed from: e */
    public boolean m14345e() {
        return m14333a((long) C3391g.ae);
    }

    /* renamed from: f */
    public long m14346f() {
        long elapsedRealtimeNanos;
        int i = 16;
        int i2 = 0;
        int i3;
        if (VERSION.SDK_INT >= 17) {
            try {
                elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                elapsedRealtimeNanos = 0;
            } catch (Exception e2) {
                elapsedRealtimeNanos = 0;
            }
            i3 = elapsedRealtimeNanos > 0 ? 1 : 0;
        } else {
            i3 = 0;
            elapsedRealtimeNanos = 0;
        }
        int size = this.f18275a.size();
        if (size <= 16) {
            i = size;
        }
        long j = 0;
        while (i2 < i) {
            if (!(((ScanResult) this.f18275a.get(i2)).level == 0 || r1 == 0)) {
                long j2;
                try {
                    j2 = (elapsedRealtimeNanos - ((ScanResult) this.f18275a.get(i2)).timestamp) / 1000000;
                } catch (Exception e3) {
                    j2 = 0;
                } catch (Error e4) {
                    j2 = 0;
                }
                if (j2 > j) {
                    j = j2;
                }
            }
            i2++;
        }
        return j;
    }

    /* renamed from: g */
    public ArrayList<Long> m14347g() {
        long elapsedRealtimeNanos;
        int i = 16;
        int i2 = 0;
        ArrayList<Long> arrayList = new ArrayList();
        int i3;
        if (VERSION.SDK_INT >= 17) {
            try {
                elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                elapsedRealtimeNanos = 0;
            } catch (Exception e2) {
                elapsedRealtimeNanos = 0;
            }
            i3 = elapsedRealtimeNanos > 0 ? 1 : 0;
        } else {
            i3 = 0;
            elapsedRealtimeNanos = 0;
        }
        int size = this.f18275a.size();
        if (size <= 16) {
            i = size;
        }
        while (i2 < i) {
            if (!(((ScanResult) this.f18275a.get(i2)).level == 0 || r1 == 0)) {
                long j;
                try {
                    j = (elapsedRealtimeNanos - ((ScanResult) this.f18275a.get(i2)).timestamp) / 1000000;
                } catch (Exception e3) {
                    j = 0;
                } catch (Error e4) {
                    j = 0;
                }
                arrayList.add(Long.valueOf(j));
            }
            i2++;
        }
        return arrayList;
    }

    /* renamed from: h */
    public long m14348h() {
        return this.f18277c;
    }

    /* renamed from: i */
    public LinkedHashMap<String, Integer> m14349i() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap();
        int size = this.f18275a.size();
        for (int i = 0; i < size; i++) {
            linkedHashMap.put(((ScanResult) this.f18275a.get(i)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""), Integer.valueOf(((ScanResult) this.f18275a.get(i)).level));
        }
        return linkedHashMap;
    }

    /* renamed from: j */
    public int m14350j() {
        for (int i = 0; i < m14330a(); i++) {
            int i2 = -((ScanResult) this.f18275a.get(i)).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: k */
    public boolean m14351k() {
        return this.f18278d;
    }

    /* renamed from: l */
    public boolean m14352l() {
        return System.currentTimeMillis() - this.f18277c > 0 && System.currentTimeMillis() - this.f18277c < Config.BPLUS_DELAY_TIME;
    }

    /* renamed from: m */
    public boolean m14353m() {
        return System.currentTimeMillis() - this.f18277c > 0 && System.currentTimeMillis() - this.f18277c < Config.BPLUS_DELAY_TIME;
    }

    /* renamed from: n */
    public boolean m14354n() {
        return System.currentTimeMillis() - this.f18277c > 0 && System.currentTimeMillis() - this.f18276b < Config.BPLUS_DELAY_TIME;
    }
}
