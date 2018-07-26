package com.baidu.tts.tools;

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

public final class DeviceId {
    /* renamed from: a */
    private static final String f21310a;
    /* renamed from: b */
    private static C5163b f21311b;
    /* renamed from: c */
    private final Context f21312c;
    /* renamed from: d */
    private int f21313d = 0;
    /* renamed from: e */
    private PublicKey f21314e;

    /* renamed from: com.baidu.tts.tools.DeviceId$1 */
    class C51611 implements Comparator<C5162a> {
        /* renamed from: a */
        final /* synthetic */ DeviceId f21302a;

        C51611(DeviceId deviceId) {
            this.f21302a = deviceId;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m17515a((C5162a) x0, (C5162a) x1);
        }

        /* renamed from: a */
        public int m17515a(C5162a c5162a, C5162a c5162a2) {
            int i = c5162a2.f21304b - c5162a.f21304b;
            if (i != 0) {
                return i;
            }
            if (c5162a.f21306d && c5162a2.f21306d) {
                return 0;
            }
            if (c5162a.f21306d) {
                return -1;
            }
            if (c5162a2.f21306d) {
                return 1;
            }
            return i;
        }
    }

    /* renamed from: com.baidu.tts.tools.DeviceId$a */
    private static class C5162a {
        /* renamed from: a */
        public ApplicationInfo f21303a;
        /* renamed from: b */
        public int f21304b;
        /* renamed from: c */
        public boolean f21305c;
        /* renamed from: d */
        public boolean f21306d;

        private C5162a() {
            this.f21304b = 0;
            this.f21305c = false;
            this.f21306d = false;
        }
    }

    /* renamed from: com.baidu.tts.tools.DeviceId$b */
    private static class C5163b {
        /* renamed from: a */
        public String f21307a;
        /* renamed from: b */
        public String f21308b;
        /* renamed from: c */
        public int f21309c;

        private C5163b() {
            this.f21309c = 2;
        }

        /* renamed from: a */
        public static C5163b m17516a(String str) {
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
                C5163b c5163b = new C5163b();
                c5163b.f21307a = string;
                c5163b.f21308b = string2;
                c5163b.f21309c = i;
                return c5163b;
            } catch (Throwable e) {
                DeviceId.m17532b(e);
                return null;
            }
        }

        /* renamed from: a */
        public String m17517a() {
            try {
                return new JSONObject().put("deviceid", this.f21307a).put("imei", this.f21308b).put("ver", this.f21309c).toString();
            } catch (Throwable e) {
                DeviceId.m17532b(e);
                return null;
            }
        }

        /* renamed from: b */
        public String m17518b() {
            String str = this.f21308b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f21307a + "|" + new StringBuffer(str).reverse().toString();
        }
    }

    static {
        String str = new String(Base64.decode(new byte[]{(byte) 77, (byte) 122, (byte) 65, (byte) 121, (byte) 77, (byte) 84, (byte) 73, (byte) 120, (byte) 77, (byte) 68, (byte) 73, (byte) 61}));
        f21310a = str + new String(Base64.decode(new byte[]{(byte) 90, (byte) 71, (byte) 108, (byte) 106, (byte) 100, (byte) 87, (byte) 82, (byte) 112, (byte) 89, (byte) 87, (byte) 73, (byte) 61}));
    }

    private DeviceId(Context var1) {
        this.f21312c = var1.getApplicationContext();
        m17524a();
    }

    /* renamed from: a */
    private static String m17522a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                str = str + "0" + toHexString;
            } else {
                str = str + toHexString;
            }
        }
        return str.toLowerCase();
    }

    /* renamed from: a */
    private static byte[] m17528a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    private static void m17532b(Throwable th) {
    }

    /* renamed from: a */
    private static String m17520a(File file) {
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
                        m17532b(e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    m17532b(e2);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e22) {
                            m17532b(e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e222) {
                            m17532b(e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            Object obj = str;
            m17532b(e222);
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

    public static String getCUID(Context var0) {
        return m17519a(var0).m17518b();
    }

    /* renamed from: a */
    private static C5163b m17519a(Context context) {
        if (f21311b == null) {
            Class cls = C5163b.class;
            synchronized (C5163b.class) {
                if (f21311b == null) {
                    SystemClock.uptimeMillis();
                    f21311b = new DeviceId(context).m17530b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f21311b;
    }

    public static String getDeviceID(Context var0) {
        return m17519a(var0).f21307a;
    }

    public static String getIMEI(Context var0) {
        return m17519a(var0).f21308b;
    }

    public static String getAndroidId(Context var0) {
        String str = "";
        str = Secure.getString(var0.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    /* renamed from: a */
    private static String m17521a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(f21310a, f21310a, str.getBytes()), "utf-8");
        } catch (Throwable e) {
            m17532b(e);
            return "";
        } catch (Throwable e2) {
            m17532b(e2);
            return "";
        }
    }

    /* renamed from: b */
    private static String m17531b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(f21310a, f21310a, Base64.decode(str.getBytes())));
        } catch (Throwable e) {
            m17532b(e);
            return "";
        }
    }

    /* renamed from: c */
    private static void m17534c(String str) {
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

    /* renamed from: a */
    private static void m17525a(String str, String str2) {
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
                fileWriter.write(Base64.encode(AESUtil.encrypt(f21310a, f21310a, stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: d */
    private static String m17537d(String str) {
        return (str == null || !str.contains(Config.TRACE_TODAY_VISIT_SPLIT)) ? str : "";
    }

    /* renamed from: a */
    private String[] m17529a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = m17522a(SHA1Util.sha1(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* renamed from: a */
    private void m17524a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable e;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C5164a.m17549a());
            try {
                this.f21314e = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e2) {
                        m17532b(e2);
                    }
                }
            } catch (Exception e3) {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e22) {
                        m17532b(e22);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                byteArrayInputStream2 = byteArrayInputStream;
                e22 = th2;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th3) {
                        m17532b(th3);
                    }
                }
                throw e22;
            }
        } catch (Exception e4) {
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
        } catch (Throwable th4) {
            e22 = th4;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            throw e22;
        }
    }

    /* renamed from: a */
    private List<C5162a> m17523a(Intent intent, boolean z) {
        List<C5162a> arrayList = new ArrayList();
        PackageManager packageManager = this.f21312c.getPackageManager();
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
                                C5162a c5162a = new C5162a();
                                c5162a.f21304b = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                c5162a.f21303a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f21312c.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    c5162a.f21306d = true;
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
                                        if (m17527a(strArr, m17529a(packageInfo.signatures))) {
                                            byte[] a = m17528a(Base64.decode(string2.getBytes()), this.f21314e);
                                            i = (a == null || !Arrays.equals(a, SHA1Util.sha1(decode))) ? 0 : 1;
                                            if (i != 0) {
                                                c5162a.f21305c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(c5162a);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new C51611(this));
        return arrayList;
    }

    /* renamed from: a */
    private boolean m17527a(String[] strArr, String[] strArr2) {
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

    /* renamed from: e */
    private boolean m17539e(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.f21312c.openFileOutput("libcuid.so", 1);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            if (fileOutputStream == null) {
                return true;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (Throwable e) {
                m17532b(e);
                return true;
            }
        } catch (Throwable e2) {
            m17532b(e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e22) {
                    m17532b(e22);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    m17532b(e3);
                }
            }
        }
    }

    /* renamed from: f */
    private String m17540f(String str) {
        try {
            return System.getString(this.f21312c.getContentResolver(), str);
        } catch (Throwable e) {
            m17532b(e);
            return null;
        }
    }

    /* renamed from: b */
    private boolean m17533b(String str, String str2) {
        try {
            return System.putString(this.f21312c.getContentResolver(), str, str2);
        } catch (Throwable e) {
            m17532b(e);
            return false;
        }
    }

    /* renamed from: b */
    private C5163b m17530b() {
        boolean z;
        C5162a c5162a;
        boolean z2;
        C5163b a;
        String str;
        String str2;
        C5163b c5163b;
        C5163b e;
        String str3 = null;
        int i = 0;
        List a2 = m17523a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f21312c.getPackageName()), true);
        int i2;
        if (a2 == null || a2.size() == 0) {
            for (i2 = 0; i2 < 3; i2++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            c5162a = (C5162a) a2.get(0);
            z2 = c5162a.f21305c;
            if (!c5162a.f21305c) {
                for (i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z2;
        }
        File file = new File(this.f21312c.getFilesDir(), "libcuid.so");
        if (file.exists()) {
            a = C5163b.m17516a(m17531b(m17520a(file)));
        } else {
            a = null;
        }
        if (a == null) {
            this.f21313d |= 16;
            List<C5162a> a3 = m17523a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a3 != null) {
                str = "files";
                file = this.f21312c.getFilesDir();
                if (str.equals(file.getName())) {
                    str2 = str;
                } else {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + file.getAbsolutePath());
                    str2 = file.getName();
                }
                for (C5162a c5162a2 : a3) {
                    if (!c5162a2.f21306d) {
                        File file2 = new File(new File(c5162a2.f21303a.dataDir, str2), "libcuid.so");
                        if (file2.exists()) {
                            a = C5163b.m17516a(m17531b(m17520a(file2)));
                            if (a != null) {
                                c5163b = a;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    a = a;
                }
            }
        }
        c5163b = a;
        if (c5163b == null) {
            c5163b = C5163b.m17516a(m17531b(m17540f("com.baidu.deviceid.v2")));
        }
        boolean g = m17541g("android.permission.READ_EXTERNAL_STORAGE");
        if (c5163b == null && g) {
            this.f21313d |= 2;
            e = m17538e();
        } else {
            e = c5163b;
        }
        if (e == null) {
            this.f21313d |= 8;
            e = m17536d();
        }
        if (e == null && g) {
            this.f21313d |= 1;
            str = m17543i("");
            e = m17542h(str);
            i = 1;
        } else {
            str = null;
        }
        if (e == null) {
            this.f21313d |= 4;
            if (i == 0) {
                str = m17543i("");
            }
            C5163b c5163b2 = new C5163b();
            str2 = getAndroidId(this.f21312c);
            if (VERSION.SDK_INT < 23) {
                str2 = str + str2 + UUID.randomUUID().toString();
            } else {
                str2 = "com.baidu" + str2;
            }
            c5163b2.f21307a = MD5Util.toMd5(str2.getBytes(), true);
            c5163b2.f21308b = str;
            c5163b = c5163b2;
        } else {
            c5163b = e;
        }
        file = new File(this.f21312c.getFilesDir(), "libcuid.so");
        if (!((this.f21313d & 16) == 0 && file.exists())) {
            if (TextUtils.isEmpty(null)) {
                str2 = m17521a(c5163b.m17517a());
            } else {
                str2 = null;
            }
            m17539e(str2);
            str3 = str2;
        }
        z2 = m17535c();
        if (z2 && ((this.f21313d & 2) != 0 || TextUtils.isEmpty(m17540f("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = m17521a(c5163b.m17517a());
            }
            m17533b("com.baidu.deviceid.v2", str3);
        }
        if (m17541g("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file3 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (!((this.f21313d & 8) == 0 && file3.exists())) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = m17521a(c5163b.m17517a());
                }
                m17534c(str3);
            }
        }
        if (z2 && ((this.f21313d & 1) != 0 || TextUtils.isEmpty(m17540f("com.baidu.deviceid")))) {
            m17533b("com.baidu.deviceid", c5163b.f21307a);
            m17533b("bd_setting_i", c5163b.f21308b);
        }
        if (z2 && !TextUtils.isEmpty(c5163b.f21308b)) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if (!((this.f21313d & 2) == 0 && file.exists())) {
                m17525a(c5163b.f21308b, c5163b.f21307a);
            }
        }
        return c5163b;
    }

    /* renamed from: c */
    private boolean m17535c() {
        return m17541g("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: g */
    private boolean m17541g(String str) {
        return this.f21312c.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: d */
    private C5163b m17536d() {
        Object f = m17540f("com.baidu.deviceid");
        String f2 = m17540f("bd_setting_i");
        if (TextUtils.isEmpty(f2)) {
            f2 = m17543i("");
            if (!TextUtils.isEmpty(f2)) {
                m17533b("bd_setting_i", f2);
            }
        }
        if (TextUtils.isEmpty(f)) {
            f = m17540f(MD5Util.toMd5(("com.baidu" + f2 + getAndroidId(this.f21312c)).getBytes(), true));
        }
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        C5163b c5163b = new C5163b();
        c5163b.f21307a = f;
        c5163b.f21308b = f2;
        return c5163b;
    }

    /* renamed from: e */
    private C5163b m17538e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            Object a = m17520a(file);
            if (!TextUtils.isEmpty(a)) {
                try {
                    return C5163b.m17516a(new String(AESUtil.decrypt(f21310a, f21310a, Base64.decode(a.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: h */
    private C5163b m17542h(String str) {
        Object obj = 1;
        Object obj2 = VERSION.SDK_INT < 23 ? 1 : null;
        if (obj2 != null && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        C5163b c5163b;
        Object obj3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (file.exists()) {
            obj = null;
        } else {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
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
            String[] split = new String(AESUtil.decrypt(f21310a, f21310a, Base64.decode(stringBuilder.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (obj2 != null && str.equals(split[0])) {
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        m17525a(str2, r0);
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c5163b = new C5163b();
                    c5163b.f21307a = obj3;
                    c5163b.f21308b = str2;
                    return c5163b;
                } else if (obj2 == null) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    obj3 = split[1];
                    str2 = str;
                    if (obj == null) {
                        try {
                            m17525a(str2, r0);
                        } catch (FileNotFoundException e) {
                        } catch (IOException e2) {
                        } catch (Exception e3) {
                        }
                    }
                    if (!TextUtils.isEmpty(obj3)) {
                        return null;
                    }
                    c5163b = new C5163b();
                    c5163b.f21307a = obj3;
                    c5163b.f21308b = str2;
                    return c5163b;
                }
            }
            str2 = str;
            if (obj == null) {
                m17525a(str2, r0);
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
        c5163b = new C5163b();
        c5163b.f21307a = obj3;
        c5163b.f21308b = str2;
        return c5163b;
    }

    /* renamed from: i */
    private String m17543i(String str) {
        String deviceId;
        CharSequence d;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f21312c.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                d = m17537d(deviceId);
                if (TextUtils.isEmpty(d)) {
                    return d;
                }
                return str;
            }
        } catch (Throwable e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        deviceId = null;
        d = m17537d(deviceId);
        if (TextUtils.isEmpty(d)) {
            return d;
        }
        return str;
    }
}
