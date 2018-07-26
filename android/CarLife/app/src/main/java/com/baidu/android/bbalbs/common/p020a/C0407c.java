package com.baidu.android.bbalbs.common.p020a;

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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.android.bbalbs.common.security.C0408a;
import com.baidu.android.bbalbs.common.security.C0409b;
import com.baidu.android.bbalbs.common.security.C0410c;
import com.baidu.carlife.core.connect.p070a.C1204d;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

/* renamed from: com.baidu.android.bbalbs.common.a.c */
public final class C0407c {
    /* renamed from: d */
    private static C0406b f1285d;
    /* renamed from: a */
    private final Context f1286a;
    /* renamed from: b */
    private int f1287b = 0;
    /* renamed from: c */
    private PublicKey f1288c;

    /* renamed from: com.baidu.android.bbalbs.common.a.c$1 */
    class C04041 implements Comparator<C0405a> {
        /* renamed from: a */
        final /* synthetic */ C0407c f1277a;

        C04041(C0407c c0407c) {
            this.f1277a = c0407c;
        }

        /* renamed from: a */
        public int m1692a(C0405a c0405a, C0405a c0405a2) {
            int i = c0405a2.f1279b - c0405a.f1279b;
            return i == 0 ? (c0405a.f1281d && c0405a2.f1281d) ? 0 : c0405a.f1281d ? -1 : c0405a2.f1281d ? 1 : i : i;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1692a((C0405a) obj, (C0405a) obj2);
        }
    }

    /* renamed from: com.baidu.android.bbalbs.common.a.c$a */
    private static class C0405a {
        /* renamed from: a */
        public ApplicationInfo f1278a;
        /* renamed from: b */
        public int f1279b;
        /* renamed from: c */
        public boolean f1280c;
        /* renamed from: d */
        public boolean f1281d;

        private C0405a() {
            this.f1279b = 0;
            this.f1280c = false;
            this.f1281d = false;
        }
    }

    /* renamed from: com.baidu.android.bbalbs.common.a.c$b */
    private static class C0406b {
        /* renamed from: a */
        public String f1282a;
        /* renamed from: b */
        public String f1283b;
        /* renamed from: c */
        public int f1284c;

        private C0406b() {
            this.f1284c = 2;
        }

        /* renamed from: a */
        public static C0406b m1693a(String str) {
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
                C0406b c0406b = new C0406b();
                c0406b.f1282a = string;
                c0406b.f1283b = string2;
                c0406b.f1284c = i;
                return c0406b;
            } catch (Throwable e) {
                C0407c.m1711b(e);
                return null;
            }
        }

        /* renamed from: a */
        public String m1694a() {
            try {
                return new JSONObject().put("deviceid", this.f1282a).put("imei", this.f1283b).put("ver", this.f1284c).toString();
            } catch (Throwable e) {
                C0407c.m1711b(e);
                return null;
            }
        }

        /* renamed from: b */
        public String m1695b() {
            String str = this.f1283b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f1282a + "|" + new StringBuffer(str).reverse().toString();
        }
    }

    private C0407c(Context context) {
        this.f1286a = context.getApplicationContext();
        m1700a();
    }

    /* renamed from: a */
    public static String m1696a(Context context) {
        return C0407c.m1712c(context).m1695b();
    }

    /* renamed from: a */
    private static String m1697a(File file) {
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
                        C0407c.m1711b(e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    C0407c.m1711b(e2);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e22) {
                            C0407c.m1711b(e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e222) {
                            C0407c.m1711b(e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            Object obj = str;
            C0407c.m1711b(e222);
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
    private static String m1698a(byte[] bArr) {
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
    private List<C0405a> m1699a(Intent intent, boolean z) {
        List<C0405a> arrayList = new ArrayList();
        PackageManager packageManager = this.f1286a.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (!(resolveInfo.activityInfo == null || resolveInfo.activityInfo.applicationInfo == null)) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            Object string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] decode = Base64.decode(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(decode));
                                C0405a c0405a = new C0405a();
                                c0405a.f1279b = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                c0405a.f1278a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f1286a.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    c0405a.f1281d = true;
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
                                        if (m1704a(strArr, m1706a(packageInfo.signatures))) {
                                            byte[] a = C0407c.m1705a(Base64.decode(string2.getBytes()), this.f1288c);
                                            i = (a == null || !Arrays.equals(a, C0410c.m1727a(decode))) ? 0 : 1;
                                            if (i != 0) {
                                                c0405a.f1280c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(c0405a);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new C04041(this));
        return arrayList;
    }

    /* renamed from: a */
    private void m1700a() {
        Throwable e;
        ByteArrayInputStream byteArrayInputStream = null;
        ByteArrayInputStream byteArrayInputStream2;
        try {
            byteArrayInputStream2 = new ByteArrayInputStream(C0403b.m1691a());
            try {
                this.f1288c = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getPublicKey();
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable e2) {
                        C0407c.m1711b(e2);
                    }
                }
            } catch (Exception e3) {
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable e22) {
                        C0407c.m1711b(e22);
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
                        C0407c.m1711b(th3);
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

    /* renamed from: a */
    private boolean m1702a(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.f1286a.openFileOutput("libcuid.so", 1);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            if (fileOutputStream == null) {
                return true;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (Throwable e) {
                C0407c.m1711b(e);
                return true;
            }
        } catch (Throwable e2) {
            C0407c.m1711b(e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e22) {
                    C0407c.m1711b(e22);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    C0407c.m1711b(e3);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m1703a(String str, String str2) {
        try {
            return System.putString(this.f1286a.getContentResolver(), str, str2);
        } catch (Throwable e) {
            C0407c.m1711b(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m1704a(String[] strArr, String[] strArr2) {
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
    private static byte[] m1705a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    private String[] m1706a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = C0407c.m1698a(C0410c.m1727a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* renamed from: b */
    private C0406b m1707b() {
        boolean z;
        boolean z2;
        String str;
        String str2;
        C0406b a;
        C0406b e;
        String str3 = null;
        int i = 0;
        List a2 = m1699a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f1286a.getPackageName()), true);
        int i2;
        if (a2 == null || a2.size() == 0) {
            for (i2 = 0; i2 < 3; i2++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            C0405a c0405a;
            c0405a = (C0405a) a2.get(0);
            z2 = c0405a.f1280c;
            if (!c0405a.f1280c) {
                for (i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z2;
        }
        File file = new File(this.f1286a.getFilesDir(), "libcuid.so");
        C0406b a3 = file.exists() ? C0406b.m1693a(C0407c.m1719f(C0407c.m1697a(file))) : null;
        if (a3 == null) {
            this.f1287b |= 16;
            List<C0405a> a4 = m1699a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a4 != null) {
                str = "files";
                file = this.f1286a.getFilesDir();
                if (str.equals(file.getName())) {
                    str2 = str;
                } else {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + file.getAbsolutePath());
                    str2 = file.getName();
                }
                for (C0405a c0405a2 : a4) {
                    if (!c0405a2.f1281d) {
                        File file2 = new File(new File(c0405a2.f1278a.dataDir, str2), "libcuid.so");
                        if (file2.exists()) {
                            a = C0406b.m1693a(C0407c.m1719f(C0407c.m1697a(file2)));
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
            a = C0406b.m1693a(C0407c.m1719f(m1709b("com.baidu.deviceid.v2")));
        }
        boolean c = m1714c("android.permission.READ_EXTERNAL_STORAGE");
        if (a == null && c) {
            this.f1287b |= 2;
            e = m1717e();
        } else {
            e = a;
        }
        if (e == null) {
            this.f1287b |= 8;
            e = m1715d();
        }
        if (e == null && c) {
            this.f1287b |= 1;
            str = m1721h("");
            e = m1716d(str);
            i = 1;
        } else {
            str = null;
        }
        if (e == null) {
            this.f1287b |= 4;
            if (i == 0) {
                str = m1721h("");
            }
            C0406b c0406b = new C0406b();
            str2 = C0407c.m1708b(this.f1286a);
            c0406b.f1282a = C0409b.m1726a((VERSION.SDK_INT < 23 ? str + str2 + UUID.randomUUID().toString() : "com.baidu" + str2).getBytes(), true);
            c0406b.f1283b = str;
            a = c0406b;
        } else {
            a = e;
        }
        file = new File(this.f1286a.getFilesDir(), "libcuid.so");
        if (!((this.f1287b & 16) == 0 && file.exists())) {
            str2 = TextUtils.isEmpty(null) ? C0407c.m1718e(a.m1694a()) : null;
            m1702a(str2);
            str3 = str2;
        }
        z2 = m1713c();
        if (z2 && ((this.f1287b & 2) != 0 || TextUtils.isEmpty(m1709b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = C0407c.m1718e(a.m1694a());
            }
            m1703a("com.baidu.deviceid.v2", str3);
        }
        if (m1714c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file3 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (!((this.f1287b & 8) == 0 && file3.exists())) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = C0407c.m1718e(a.m1694a());
                }
                C0407c.m1720g(str3);
            }
        }
        if (z2 && ((this.f1287b & 1) != 0 || TextUtils.isEmpty(m1709b("com.baidu.deviceid")))) {
            m1703a("com.baidu.deviceid", a.f1282a);
            m1703a("bd_setting_i", a.f1283b);
        }
        if (z2 && !TextUtils.isEmpty(a.f1283b)) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if (!((this.f1287b & 2) == 0 && file.exists())) {
                C0407c.m1710b(a.f1283b, a.f1282a);
            }
        }
        return a;
    }

    /* renamed from: b */
    public static String m1708b(Context context) {
        String str = "";
        Object string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    /* renamed from: b */
    private String m1709b(String str) {
        try {
            return System.getString(this.f1286a.getContentResolver(), str);
        } catch (Throwable e) {
            C0407c.m1711b(e);
            return null;
        }
    }

    /* renamed from: b */
    private static void m1710b(String str, String str2) {
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
                fileWriter.write(Base64.encode(C0408a.m1723a("30212102dicudiab", "30212102dicudiab", stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: b */
    private static void m1711b(Throwable th) {
    }

    /* renamed from: c */
    private static C0406b m1712c(Context context) {
        if (f1285d == null) {
            synchronized (C0406b.class) {
                if (f1285d == null) {
                    SystemClock.uptimeMillis();
                    f1285d = new C0407c(context).m1707b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f1285d;
    }

    /* renamed from: c */
    private boolean m1713c() {
        return m1714c("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: c */
    private boolean m1714c(String str) {
        return this.f1286a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: d */
    private C0406b m1715d() {
        Object b = m1709b("com.baidu.deviceid");
        String b2 = m1709b("bd_setting_i");
        if (TextUtils.isEmpty(b2)) {
            b2 = m1721h("");
            if (!TextUtils.isEmpty(b2)) {
                m1703a("bd_setting_i", b2);
            }
        }
        if (TextUtils.isEmpty(b)) {
            b = m1709b(C0409b.m1726a(("com.baidu" + b2 + C0407c.m1708b(this.f1286a)).getBytes(), true));
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        C0406b c0406b = new C0406b();
        c0406b.f1282a = b;
        c0406b.f1283b = b2;
        return c0406b;
    }

    /* renamed from: d */
    private C0406b m1716d(String str) {
        Object obj = null;
        Object obj2 = VERSION.SDK_INT < 23 ? 1 : null;
        if (obj2 != null && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        C0406b c0406b;
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
            String[] split = new String(C0408a.m1724b("30212102dicudiab", "30212102dicudiab", Base64.decode(stringBuilder.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (obj2 != null && str.equals(split[0])) {
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        C0407c.m1710b(str2, obj3);
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c0406b = new C0406b();
                    c0406b.f1282a = obj3;
                    c0406b.f1283b = str2;
                    return c0406b;
                } else if (obj2 == null) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        try {
                            C0407c.m1710b(str2, obj3);
                        } catch (FileNotFoundException e) {
                        } catch (IOException e2) {
                        } catch (Exception e3) {
                        }
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c0406b = new C0406b();
                    c0406b.f1282a = obj3;
                    c0406b.f1283b = str2;
                    return c0406b;
                }
            }
            str2 = str;
            if (obj == null) {
                C0407c.m1710b(str2, obj3);
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
        c0406b = new C0406b();
        c0406b.f1282a = obj3;
        c0406b.f1283b = str2;
        return c0406b;
    }

    /* renamed from: e */
    private C0406b m1717e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            Object a = C0407c.m1697a(file);
            if (!TextUtils.isEmpty(a)) {
                try {
                    return C0406b.m1693a(new String(C0408a.m1724b("30212102dicudiab", "30212102dicudiab", Base64.decode(a.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    private static String m1718e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(C0408a.m1723a("30212102dicudiab", "30212102dicudiab", str.getBytes()), "utf-8");
        } catch (Throwable e) {
            C0407c.m1711b(e);
            return "";
        } catch (Throwable e2) {
            C0407c.m1711b(e2);
            return "";
        }
    }

    /* renamed from: f */
    private static String m1719f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(C0408a.m1724b("30212102dicudiab", "30212102dicudiab", Base64.decode(str.getBytes())));
        } catch (Throwable e) {
            C0407c.m1711b(e);
            return "";
        }
    }

    /* renamed from: g */
    private static void m1720g(String str) {
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
    private String m1721h(String str) {
        String deviceId;
        CharSequence i;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f1286a.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                i = C0407c.m1722i(deviceId);
                return TextUtils.isEmpty(i) ? str : i;
            }
        } catch (Throwable e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        deviceId = null;
        i = C0407c.m1722i(deviceId);
        if (TextUtils.isEmpty(i)) {
        }
    }

    /* renamed from: i */
    private static String m1722i(String str) {
        return (str == null || !str.contains(Config.TRACE_TODAY_VISIT_SPLIT)) ? str : "";
    }
}
