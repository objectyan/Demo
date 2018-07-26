package com.baidu.android.pushservice.p032k;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.system.Os;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.core.connect.p070a.C1204d;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.k.e */
public final class C0589e {
    /* renamed from: a */
    private static final String f1891a;
    /* renamed from: e */
    private static C0587b f1892e;
    /* renamed from: b */
    private final Context f1893b;
    /* renamed from: c */
    private int f1894c = 0;
    /* renamed from: d */
    private PublicKey f1895d;

    /* renamed from: com.baidu.android.pushservice.k.e$1 */
    class C05851 implements Comparator<C0586a> {
        /* renamed from: a */
        final /* synthetic */ C0589e f1883a;

        C05851(C0589e c0589e) {
            this.f1883a = c0589e;
        }

        /* renamed from: a */
        public int m2634a(C0586a c0586a, C0586a c0586a2) {
            int i = c0586a2.f1885b - c0586a.f1885b;
            return i == 0 ? (c0586a.f1887d && c0586a2.f1887d) ? 0 : c0586a.f1887d ? -1 : c0586a2.f1887d ? 1 : i : i;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2634a((C0586a) obj, (C0586a) obj2);
        }
    }

    /* renamed from: com.baidu.android.pushservice.k.e$a */
    private static class C0586a {
        /* renamed from: a */
        public ApplicationInfo f1884a;
        /* renamed from: b */
        public int f1885b;
        /* renamed from: c */
        public boolean f1886c;
        /* renamed from: d */
        public boolean f1887d;

        private C0586a() {
            this.f1885b = 0;
            this.f1886c = false;
            this.f1887d = false;
        }
    }

    /* renamed from: com.baidu.android.pushservice.k.e$b */
    private static class C0587b {
        /* renamed from: a */
        public String f1888a;
        /* renamed from: b */
        public String f1889b;
        /* renamed from: c */
        public int f1890c;

        private C0587b() {
            this.f1890c = 2;
        }

        /* renamed from: a */
        public static C0587b m2635a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Object string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                int i = jSONObject.getInt("ver");
                if (TextUtils.isEmpty(string) || string2 == null) {
                    return null;
                }
                C0587b c0587b = new C0587b();
                c0587b.f1888a = string;
                c0587b.f1889b = string2;
                c0587b.f1890c = i;
                return c0587b;
            } catch (Throwable e) {
                C0589e.m2654b(e);
                return null;
            }
        }

        /* renamed from: a */
        public String m2636a() {
            try {
                return new JSONObject().put("deviceid", this.f1888a).put("imei", this.f1889b).put("ver", this.f1890c).toString();
            } catch (Throwable e) {
                C0589e.m2654b(e);
                return null;
            }
        }

        /* renamed from: b */
        public String m2637b() {
            String str = this.f1889b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f1888a + "|" + new StringBuffer(str).reverse().toString();
        }
    }

    /* renamed from: com.baidu.android.pushservice.k.e$c */
    static class C0588c {
        @SuppressLint({"NewApi"})
        /* renamed from: a */
        static boolean m2638a(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (Throwable e) {
                C0589e.m2654b(e);
                return false;
            }
        }
    }

    static {
        String str = new String(C0582b.m2630a(new byte[]{(byte) 77, (byte) 122, (byte) 65, (byte) 121, (byte) 77, (byte) 84, (byte) 73, (byte) 120, (byte) 77, (byte) 68, (byte) 73, (byte) 61}));
        f1891a = str + new String(C0582b.m2630a(new byte[]{(byte) 90, (byte) 71, (byte) 108, (byte) 106, (byte) 100, (byte) 87, (byte) 82, (byte) 112, (byte) 89, (byte) 87, (byte) 73, (byte) 61}));
    }

    private C0589e(Context context) {
        this.f1893b = context.getApplicationContext();
        m2643a();
    }

    /* renamed from: a */
    public static String m2639a(Context context) {
        return C0589e.m2659d(context).m2637b();
    }

    /* renamed from: a */
    private static String m2640a(File file) {
        FileReader fileReader;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                str = charArrayWriter.toString();
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable e2) {
                        C0589e.m2654b(e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    C0589e.m2654b(e2);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e22) {
                            C0589e.m2654b(e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e222) {
                            C0589e.m2654b(e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            Object obj = str;
            C0589e.m2654b(e222);
            if (fileReader != null) {
                fileReader.close();
            }
            return str;
        } catch (Throwable e2222) {
            fileReader = str;
            th = e2222;
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
        return str;
    }

    /* renamed from: a */
    private static String m2641a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            str = toHexString.length() == 1 ? str + "0" + toHexString : str + toHexString;
        }
        return str.toLowerCase();
    }

    /* renamed from: a */
    private List<C0586a> m2642a(Intent intent, boolean z) {
        List<C0586a> arrayList = new ArrayList();
        try {
            PackageManager packageManager = this.f1893b.getPackageManager();
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (!(resolveInfo.activityInfo == null || resolveInfo.activityInfo.applicationInfo == null)) {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            Object string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a = C0582b.m2630a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a));
                                C0586a c0586a = new C0586a();
                                c0586a.f1885b = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                c0586a.f1884a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f1893b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    c0586a.f1887d = true;
                                }
                                if (z) {
                                    Object string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (m2647a(strArr, m2649a(packageInfo.signatures))) {
                                            byte[] a2 = C0589e.m2648a(C0582b.m2630a(string2.getBytes()), this.f1895d);
                                            Object obj = (a2 == null || !Arrays.equals(a2, C0592h.m2675a(a))) ? null : 1;
                                            if (obj != null) {
                                                c0586a.f1886c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(c0586a);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        Collections.sort(arrayList, new C05851(this));
        return arrayList;
    }

    /* renamed from: a */
    private void m2643a() {
        Throwable e;
        ByteArrayInputStream byteArrayInputStream = null;
        ByteArrayInputStream byteArrayInputStream2;
        try {
            byteArrayInputStream2 = new ByteArrayInputStream(C0584d.m2633a());
            try {
                this.f1895d = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getPublicKey();
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable e2) {
                        C0589e.m2654b(e2);
                    }
                }
            } catch (Exception e3) {
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable e22) {
                        C0589e.m2654b(e22);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                byteArrayInputStream = byteArrayInputStream2;
                e22 = th2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        C0589e.m2654b(th3);
                    }
                }
                throw e22;
            }
        } catch (Exception e4) {
            byteArrayInputStream2 = null;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
        } catch (Throwable th4) {
            e22 = th4;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw e22;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    private boolean m2645a(java.lang.String r7) {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r3 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r4 = 24;
        if (r0 < r4) goto L_0x003d;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        r4 = r6.f1893b;	 Catch:{ Exception -> 0x0044, all -> 0x0055 }
        r5 = "libcuid.so";
        r3 = r4.openFileOutput(r5, r0);	 Catch:{ Exception -> 0x0044, all -> 0x0055 }
        r4 = r7.getBytes();	 Catch:{ Exception -> 0x0064, all -> 0x0055 }
        r3.write(r4);	 Catch:{ Exception -> 0x0064, all -> 0x0055 }
        r3.flush();	 Catch:{ Exception -> 0x0064, all -> 0x0055 }
        if (r3 == 0) goto L_0x0022;
    L_0x001f:
        r3.close();	 Catch:{ Exception -> 0x003f }
    L_0x0022:
        if (r0 != 0) goto L_0x003c;
    L_0x0024:
        r0 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r1 = new java.io.File;
        r2 = r6.f1893b;
        r2 = r2.getFilesDir();
        r3 = "libcuid.so";
        r1.<init>(r2, r3);
        r1 = r1.getAbsolutePath();
        r2 = com.baidu.android.pushservice.p032k.C0589e.C0588c.m2638a(r1, r0);
    L_0x003c:
        return r2;
    L_0x003d:
        r0 = r2;
        goto L_0x000a;
    L_0x003f:
        r1 = move-exception;
        com.baidu.android.pushservice.p032k.C0589e.m2654b(r1);
        goto L_0x0022;
    L_0x0044:
        r0 = move-exception;
        r2 = r3;
    L_0x0046:
        com.baidu.android.pushservice.p032k.C0589e.m2654b(r0);	 Catch:{ all -> 0x0061 }
        if (r2 == 0) goto L_0x004e;
    L_0x004b:
        r2.close();	 Catch:{ Exception -> 0x0050 }
    L_0x004e:
        r2 = r1;
        goto L_0x003c;
    L_0x0050:
        r0 = move-exception;
        com.baidu.android.pushservice.p032k.C0589e.m2654b(r0);
        goto L_0x004e;
    L_0x0055:
        r0 = move-exception;
    L_0x0056:
        if (r3 == 0) goto L_0x005b;
    L_0x0058:
        r3.close();	 Catch:{ Exception -> 0x005c }
    L_0x005b:
        throw r0;
    L_0x005c:
        r1 = move-exception;
        com.baidu.android.pushservice.p032k.C0589e.m2654b(r1);
        goto L_0x005b;
    L_0x0061:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0056;
    L_0x0064:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.k.e.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    private boolean m2646a(String str, String str2) {
        try {
            return System.putString(this.f1893b.getContentResolver(), str, str2);
        } catch (Throwable e) {
            C0589e.m2654b(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2647a(String[] strArr, String[] strArr2) {
        int i = 0;
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (Object add : strArr) {
            hashSet.add(add);
        }
        HashSet hashSet2 = new HashSet();
        int length = strArr2.length;
        while (i < length) {
            hashSet2.add(strArr2[i]);
            i++;
        }
        return hashSet.equals(hashSet2);
    }

    /* renamed from: a */
    private static byte[] m2648a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    private String[] m2649a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = C0589e.m2641a(C0592h.m2675a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* renamed from: b */
    private C0587b m2650b() {
        boolean z;
        C0586a c0586a;
        boolean z2;
        String str;
        String str2;
        C0587b a;
        C0587b e;
        String str3 = null;
        int i = 0;
        List a2 = m2642a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f1893b.getPackageName()), true);
        int i2;
        if (a2 == null || a2.size() == 0) {
            for (i2 = 0; i2 < 3; i2++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            c0586a = (C0586a) a2.get(0);
            z2 = c0586a.f1886c;
            if (!c0586a.f1886c) {
                for (i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z2;
        }
        File file = new File(this.f1893b.getFilesDir(), "libcuid.so");
        C0587b a3 = file.exists() ? C0587b.m2635a(C0589e.m2663f(C0589e.m2640a(file))) : null;
        if (a3 == null) {
            this.f1894c |= 16;
            List<C0586a> a4 = m2642a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a4 != null) {
                str = "files";
                file = this.f1893b.getFilesDir();
                if (str.equals(file.getName())) {
                    str2 = str;
                } else {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + file.getAbsolutePath());
                    str2 = file.getName();
                }
                for (C0586a c0586a2 : a4) {
                    if (!c0586a2.f1887d) {
                        File file2 = new File(new File(c0586a2.f1884a.dataDir, str2), "libcuid.so");
                        if (file2.exists()) {
                            a = C0587b.m2635a(C0589e.m2663f(C0589e.m2640a(file2)));
                            if (a != null) {
                                break;
                            }
                        }
                        a = a3;
                        a3 = a;
                    }
                }
            }
        }
        a = a3;
        if (a == null) {
            a = C0587b.m2635a(C0589e.m2663f(m2652b("com.baidu.deviceid.v2")));
        }
        boolean c = m2657c("android.permission.READ_EXTERNAL_STORAGE");
        if (a == null && c) {
            this.f1894c |= 2;
            e = m2661e();
        } else {
            e = a;
        }
        if (e == null) {
            this.f1894c |= 8;
            e = m2658d();
        }
        if (e == null && c) {
            this.f1894c |= 1;
            str = m2665h("");
            e = m2660d(str);
            i = 1;
        } else {
            str = null;
        }
        if (e == null) {
            this.f1894c |= 4;
            if (i == 0) {
                str = m2665h("");
            }
            C0587b c0587b = new C0587b();
            str2 = C0589e.m2655c(this.f1893b);
            c0587b.f1888a = C0590f.m2669a((VERSION.SDK_INT < 23 ? str + str2 + UUID.randomUUID().toString() : "com.baidu" + str2).getBytes(), true);
            c0587b.f1889b = str;
            a = c0587b;
        } else {
            a = e;
        }
        file = new File(this.f1893b.getFilesDir(), "libcuid.so");
        if (!((this.f1894c & 16) == 0 && file.exists())) {
            str2 = TextUtils.isEmpty(null) ? C0589e.m2662e(a.m2636a()) : null;
            m2645a(str2);
            str3 = str2;
        }
        z2 = m2656c();
        if (z2 && ((this.f1894c & 2) != 0 || TextUtils.isEmpty(m2652b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = C0589e.m2662e(a.m2636a());
            }
            m2646a("com.baidu.deviceid.v2", str3);
        }
        if (m2657c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file3 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (!((this.f1894c & 8) == 0 && file3.exists())) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = C0589e.m2662e(a.m2636a());
                }
                C0589e.m2664g(str3);
            }
        }
        if (z2 && ((this.f1894c & 1) != 0 || TextUtils.isEmpty(m2652b("com.baidu.deviceid")))) {
            m2646a("com.baidu.deviceid", a.f1888a);
            m2646a("bd_setting_i", a.f1889b);
        }
        if (z2 && !TextUtils.isEmpty(a.f1889b)) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if (!((this.f1894c & 2) == 0 && file.exists())) {
                C0589e.m2653b(a.f1889b, a.f1888a);
            }
        }
        return a;
    }

    /* renamed from: b */
    public static String m2651b(Context context) {
        return C0589e.m2659d(context).f1888a;
    }

    /* renamed from: b */
    private String m2652b(String str) {
        try {
            return System.getString(this.f1893b.getContentResolver(), str);
        } catch (Throwable e) {
            C0589e.m2654b(e);
            return null;
        }
    }

    /* renamed from: b */
    private static void m2653b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file2 = new File(file, ".cuid");
            try {
                if (file.exists() && !file.isDirectory()) {
                    File file3;
                    Random random = new Random();
                    File parentFile = file.getParentFile();
                    String name = file.getName();
                    do {
                        file3 = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file3.exists());
                    file.renameTo(file3);
                    file3.delete();
                }
                file.mkdirs();
                FileWriter fileWriter = new FileWriter(file2, false);
                fileWriter.write(C0582b.m2629a(C0581a.m2627a(f1891a, f1891a, stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: b */
    private static void m2654b(Throwable th) {
    }

    /* renamed from: c */
    public static String m2655c(Context context) {
        String str = "";
        Object string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    /* renamed from: c */
    private boolean m2656c() {
        return m2657c("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: c */
    private boolean m2657c(String str) {
        return this.f1893b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: d */
    private C0587b m2658d() {
        Object b = m2652b("com.baidu.deviceid");
        String b2 = m2652b("bd_setting_i");
        if (TextUtils.isEmpty(b2)) {
            b2 = m2665h("");
            if (!TextUtils.isEmpty(b2)) {
                m2646a("bd_setting_i", b2);
            }
        }
        if (TextUtils.isEmpty(b)) {
            b = m2652b(C0590f.m2669a(("com.baidu" + b2 + C0589e.m2655c(this.f1893b)).getBytes(), true));
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        C0587b c0587b = new C0587b();
        c0587b.f1888a = b;
        c0587b.f1889b = b2;
        return c0587b;
    }

    /* renamed from: d */
    private static C0587b m2659d(Context context) {
        if (f1892e == null) {
            synchronized (C0587b.class) {
                if (f1892e == null) {
                    SystemClock.uptimeMillis();
                    f1892e = new C0589e(context).m2650b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f1892e;
    }

    /* renamed from: d */
    private C0587b m2660d(String str) {
        Object obj = null;
        Object obj2 = VERSION.SDK_INT < 23 ? 1 : null;
        if (obj2 != null && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        C0587b c0587b;
        Object obj3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            int i = 1;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append("\r\n");
            }
            bufferedReader.close();
            String[] split = new String(C0581a.m2628b(f1891a, f1891a, C0582b.m2630a(stringBuilder.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (obj2 != null && str.equals(split[0])) {
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        C0589e.m2653b(str2, obj3);
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c0587b = new C0587b();
                    c0587b.f1888a = obj3;
                    c0587b.f1889b = str2;
                    return c0587b;
                } else if (obj2 == null) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        try {
                            C0589e.m2653b(str2, obj3);
                        } catch (FileNotFoundException e) {
                        } catch (IOException e2) {
                        } catch (Exception e3) {
                        }
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c0587b = new C0587b();
                    c0587b.f1888a = obj3;
                    c0587b.f1889b = str2;
                    return c0587b;
                }
            }
            str2 = str;
            if (obj == null) {
                C0589e.m2653b(str2, obj3);
            }
        } catch (FileNotFoundException e4) {
            str2 = str;
        } catch (IOException e5) {
            str2 = str;
        } catch (Exception e6) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(obj3)) {
            return null;
        }
        c0587b = new C0587b();
        c0587b.f1888a = obj3;
        c0587b.f1889b = str2;
        return c0587b;
    }

    /* renamed from: e */
    private C0587b m2661e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            Object a = C0589e.m2640a(file);
            if (!TextUtils.isEmpty(a)) {
                try {
                    return C0587b.m2635a(new String(C0581a.m2628b(f1891a, f1891a, C0582b.m2630a(a.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    private static String m2662e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return C0582b.m2629a(C0581a.m2627a(f1891a, f1891a, str.getBytes()), "utf-8");
        } catch (Throwable e) {
            C0589e.m2654b(e);
            return "";
        } catch (Throwable e2) {
            C0589e.m2654b(e2);
            return "";
        }
    }

    /* renamed from: f */
    private static String m2663f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(C0581a.m2628b(f1891a, f1891a, C0582b.m2630a(str.getBytes())));
        } catch (Throwable e) {
            C0589e.m2654b(e);
            return "";
        }
    }

    /* renamed from: g */
    private static void m2664g(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file2 = new File(file, ".cuid2");
        try {
            if (file.exists() && !file.isDirectory()) {
                File file3;
                Random random = new Random();
                File parentFile = file.getParentFile();
                String name = file.getName();
                do {
                    file3 = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file3.exists());
                file.renameTo(file3);
                file3.delete();
            }
            file.mkdirs();
            FileWriter fileWriter = new FileWriter(file2, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    /* renamed from: h */
    private String m2665h(String str) {
        String deviceId;
        CharSequence i;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f1893b.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                i = C0589e.m2666i(deviceId);
                return TextUtils.isEmpty(i) ? str : i;
            }
        } catch (Throwable e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        deviceId = null;
        i = C0589e.m2666i(deviceId);
        if (TextUtils.isEmpty(i)) {
        }
    }

    /* renamed from: i */
    private static String m2666i(String str) {
        return (str == null || !str.contains(Config.TRACE_TODAY_VISIT_SPLIT)) ? str : "";
    }
}
