package com.baidu.mobstat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.core.connect.p070a.C1204d;
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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.g */
public final class C3593g {
    /* renamed from: a */
    private static final String f19635a;
    /* renamed from: e */
    private static C3596j f19636e;
    /* renamed from: b */
    private final Context f19637b;
    /* renamed from: c */
    private int f19638c = 0;
    /* renamed from: d */
    private PublicKey f19639d;

    static {
        String str = new String(C3588b.m15410a(new byte[]{(byte) 77, (byte) 122, (byte) 65, (byte) 121, (byte) 77, (byte) 84, (byte) 73, (byte) 120, (byte) 77, (byte) 68, (byte) 73, (byte) 61}));
        f19635a = str + new String(C3588b.m15410a(new byte[]{(byte) 90, (byte) 71, (byte) 108, (byte) 106, (byte) 100, (byte) 87, (byte) 82, (byte) 112, (byte) 89, (byte) 87, (byte) 73, (byte) 61}));
    }

    private C3593g(Context context) {
        this.f19637b = context.getApplicationContext();
        m15723a();
    }

    /* renamed from: a */
    public static String m15719a(Context context) {
        return C3593g.m15735c(context).m15749b();
    }

    /* renamed from: a */
    private static String m15720a(File file) {
        Throwable e;
        Throwable th;
        String str = null;
        FileReader fileReader;
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
                        C3593g.m15734b(e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    C3593g.m15734b(e2);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e22) {
                            C3593g.m15734b(e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e222) {
                            C3593g.m15734b(e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            Object obj = str;
            C3593g.m15734b(e222);
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
    private static String m15721a(byte[] bArr) {
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
    private List<C3595i> m15722a(Intent intent, boolean z) {
        List<C3595i> arrayList = new ArrayList();
        PackageManager packageManager = this.f19637b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (!(resolveInfo.activityInfo == null || resolveInfo.activityInfo.applicationInfo == null)) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            Object string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a = C3588b.m15410a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a));
                                C3595i c3595i = new C3595i();
                                c3595i.f19642b = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                c3595i.f19641a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f19637b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    c3595i.f19644d = true;
                                }
                                if (z) {
                                    Object string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        int i;
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (m15727a(strArr, m15729a(packageInfo.signatures))) {
                                            byte[] a2 = C3593g.m15728a(C3588b.m15410a(string2.getBytes()), this.f19639d);
                                            i = (a2 == null || !Arrays.equals(a2, C3590d.m15652a(a))) ? 0 : 1;
                                            if (i != 0) {
                                                c3595i.f19643c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(c3595i);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new C3594h(this));
        return arrayList;
    }

    /* renamed from: a */
    private void m15723a() {
        Throwable e;
        ByteArrayInputStream byteArrayInputStream = null;
        ByteArrayInputStream byteArrayInputStream2;
        try {
            byteArrayInputStream2 = new ByteArrayInputStream(C3592f.m15718a());
            try {
                this.f19639d = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getPublicKey();
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable e2) {
                        C3593g.m15734b(e2);
                    }
                }
            } catch (Exception e3) {
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable e22) {
                        C3593g.m15734b(e22);
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
                        C3593g.m15734b(th3);
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
    private boolean m15725a(java.lang.String r7) {
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
        r4 = r6.f19637b;	 Catch:{ Exception -> 0x0044, all -> 0x0055 }
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
        r2 = r6.f19637b;
        r2 = r2.getFilesDir();
        r3 = "libcuid.so";
        r1.<init>(r2, r3);
        r1 = r1.getAbsolutePath();
        r2 = com.baidu.mobstat.C3597k.m15750a(r1, r0);
    L_0x003c:
        return r2;
    L_0x003d:
        r0 = r2;
        goto L_0x000a;
    L_0x003f:
        r1 = move-exception;
        com.baidu.mobstat.C3593g.m15734b(r1);
        goto L_0x0022;
    L_0x0044:
        r0 = move-exception;
        r2 = r3;
    L_0x0046:
        com.baidu.mobstat.C3593g.m15734b(r0);	 Catch:{ all -> 0x0061 }
        if (r2 == 0) goto L_0x004e;
    L_0x004b:
        r2.close();	 Catch:{ Exception -> 0x0050 }
    L_0x004e:
        r2 = r1;
        goto L_0x003c;
    L_0x0050:
        r0 = move-exception;
        com.baidu.mobstat.C3593g.m15734b(r0);
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
        com.baidu.mobstat.C3593g.m15734b(r1);
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.g.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    private boolean m15726a(String str, String str2) {
        try {
            return System.putString(this.f19637b.getContentResolver(), str, str2);
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m15727a(String[] strArr, String[] strArr2) {
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
    private static byte[] m15728a(byte[] bArr, PublicKey publicKey) {
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    private String[] m15729a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = C3593g.m15721a(C3590d.m15652a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* renamed from: b */
    private C3596j m15730b() {
        boolean z;
        boolean z2;
        String str;
        String str2;
        C3596j a;
        C3596j e;
        String str3 = null;
        int i = 0;
        List a2 = m15722a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f19637b.getPackageName()), true);
        int i2;
        if (a2 == null || a2.size() == 0) {
            for (i2 = 0; i2 < 3; i2++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            C3595i c3595i;
            c3595i = (C3595i) a2.get(0);
            z2 = c3595i.f19643c;
            if (!c3595i.f19643c) {
                for (i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z2;
        }
        File file = new File(this.f19637b.getFilesDir(), "libcuid.so");
        C3596j a3 = file.exists() ? C3596j.m15747a(C3593g.m15742f(C3593g.m15720a(file))) : null;
        if (a3 == null) {
            this.f19638c |= 16;
            List<C3595i> a4 = m15722a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a4 != null) {
                str = "files";
                file = this.f19637b.getFilesDir();
                if (str.equals(file.getName())) {
                    str2 = str;
                } else {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + file.getAbsolutePath());
                    str2 = file.getName();
                }
                for (C3595i c3595i2 : a4) {
                    if (!c3595i2.f19644d) {
                        File file2 = new File(new File(c3595i2.f19641a.dataDir, str2), "libcuid.so");
                        if (file2.exists()) {
                            a = C3596j.m15747a(C3593g.m15742f(C3593g.m15720a(file2)));
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
            a = C3596j.m15747a(C3593g.m15742f(m15732b("com.baidu.deviceid.v2")));
        }
        boolean c = m15737c("android.permission.READ_EXTERNAL_STORAGE");
        if (a == null && c) {
            this.f19638c |= 2;
            e = m15740e();
        } else {
            e = a;
        }
        if (e == null) {
            this.f19638c |= 8;
            e = m15738d();
        }
        if (e == null && c) {
            this.f19638c |= 1;
            str = m15744h("");
            e = m15739d(str);
            i = 1;
        } else {
            str = null;
        }
        if (e == null) {
            this.f19638c |= 4;
            if (i == 0) {
                str = m15744h("");
            }
            C3596j c3596j = new C3596j();
            str2 = C3593g.m15731b(this.f19637b);
            c3596j.f19645a = C3589c.m15546a((VERSION.SDK_INT < 23 ? str + str2 + UUID.randomUUID().toString() : "com.baidu" + str2).getBytes(), true);
            c3596j.f19646b = str;
            a = c3596j;
        } else {
            a = e;
        }
        file = new File(this.f19637b.getFilesDir(), "libcuid.so");
        if (!((this.f19638c & 16) == 0 && file.exists())) {
            str2 = TextUtils.isEmpty(null) ? C3593g.m15741e(a.m15748a()) : null;
            m15725a(str2);
            str3 = str2;
        }
        z2 = m15736c();
        if (z2 && ((this.f19638c & 2) != 0 || TextUtils.isEmpty(m15732b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = C3593g.m15741e(a.m15748a());
            }
            m15726a("com.baidu.deviceid.v2", str3);
        }
        if (m15737c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file3 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (!((this.f19638c & 8) == 0 && file3.exists())) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = C3593g.m15741e(a.m15748a());
                }
                C3593g.m15743g(str3);
            }
        }
        if (z2 && ((this.f19638c & 1) != 0 || TextUtils.isEmpty(m15732b("com.baidu.deviceid")))) {
            m15726a("com.baidu.deviceid", a.f19645a);
            m15726a("bd_setting_i", a.f19646b);
        }
        if (z2 && !TextUtils.isEmpty(a.f19646b)) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if (!((this.f19638c & 2) == 0 && file.exists())) {
                C3593g.m15733b(a.f19646b, a.f19645a);
            }
        }
        return a;
    }

    /* renamed from: b */
    public static String m15731b(Context context) {
        String str = "";
        Object string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    /* renamed from: b */
    private String m15732b(String str) {
        try {
            return System.getString(this.f19637b.getContentResolver(), str);
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return null;
        }
    }

    /* renamed from: b */
    private static void m15733b(String str, String str2) {
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
                fileWriter.write(C3588b.m15409a(C3584a.m15285a(f19635a, f19635a, stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: b */
    private static void m15734b(Throwable th) {
    }

    /* renamed from: c */
    private static C3596j m15735c(Context context) {
        if (f19636e == null) {
            synchronized (C3596j.class) {
                if (f19636e == null) {
                    SystemClock.uptimeMillis();
                    f19636e = new C3593g(context).m15730b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f19636e;
    }

    /* renamed from: c */
    private boolean m15736c() {
        return m15737c("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: c */
    private boolean m15737c(String str) {
        return this.f19637b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: d */
    private C3596j m15738d() {
        Object b = m15732b("com.baidu.deviceid");
        String b2 = m15732b("bd_setting_i");
        if (TextUtils.isEmpty(b2)) {
            b2 = m15744h("");
            if (!TextUtils.isEmpty(b2)) {
                m15726a("bd_setting_i", b2);
            }
        }
        if (TextUtils.isEmpty(b)) {
            b = m15732b(C3589c.m15546a(("com.baidu" + b2 + C3593g.m15731b(this.f19637b)).getBytes(), true));
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        C3596j c3596j = new C3596j();
        c3596j.f19645a = b;
        c3596j.f19646b = b2;
        return c3596j;
    }

    /* renamed from: d */
    private C3596j m15739d(String str) {
        Object obj = null;
        Object obj2 = VERSION.SDK_INT < 23 ? 1 : null;
        if (obj2 != null && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        C3596j c3596j;
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
            String[] split = new String(C3584a.m15286b(f19635a, f19635a, C3588b.m15410a(stringBuilder.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (obj2 != null && str.equals(split[0])) {
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        C3593g.m15733b(str2, obj3);
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c3596j = new C3596j();
                    c3596j.f19645a = obj3;
                    c3596j.f19646b = str2;
                    return c3596j;
                } else if (obj2 == null) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        try {
                            C3593g.m15733b(str2, obj3);
                        } catch (FileNotFoundException e) {
                        } catch (IOException e2) {
                        } catch (Exception e3) {
                        }
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c3596j = new C3596j();
                    c3596j.f19645a = obj3;
                    c3596j.f19646b = str2;
                    return c3596j;
                }
            }
            str2 = str;
            if (obj == null) {
                C3593g.m15733b(str2, obj3);
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
        c3596j = new C3596j();
        c3596j.f19645a = obj3;
        c3596j.f19646b = str2;
        return c3596j;
    }

    /* renamed from: e */
    private C3596j m15740e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            Object a = C3593g.m15720a(file);
            if (!TextUtils.isEmpty(a)) {
                try {
                    return C3596j.m15747a(new String(C3584a.m15286b(f19635a, f19635a, C3588b.m15410a(a.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    private static String m15741e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return C3588b.m15409a(C3584a.m15285a(f19635a, f19635a, str.getBytes()), "utf-8");
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return "";
        } catch (Throwable e2) {
            C3593g.m15734b(e2);
            return "";
        }
    }

    /* renamed from: f */
    private static String m15742f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(C3584a.m15286b(f19635a, f19635a, C3588b.m15410a(str.getBytes())));
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return "";
        }
    }

    /* renamed from: g */
    private static void m15743g(String str) {
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
    private String m15744h(String str) {
        String deviceId;
        CharSequence i;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f19637b.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                i = C3593g.m15745i(deviceId);
                return TextUtils.isEmpty(i) ? str : i;
            }
        } catch (Throwable e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        deviceId = null;
        i = C3593g.m15745i(deviceId);
        if (TextUtils.isEmpty(i)) {
        }
    }

    /* renamed from: i */
    private static String m15745i(String str) {
        return (str == null || !str.contains(Config.TRACE_TODAY_VISIT_SPLIT)) ? str : "";
    }
}
