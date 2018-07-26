package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class de {
    /* renamed from: a */
    private static String f19630a = null;
    /* renamed from: b */
    private static String f19631b = null;
    /* renamed from: c */
    private static String f19632c = null;
    /* renamed from: d */
    private static final Pattern f19633d = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: a */
    public static String m15678a(Context context, String str) {
        String str2 = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return str2;
            }
            Object obj = null;
            if (applicationInfo.metaData != null) {
                obj = applicationInfo.metaData.get(str);
            }
            if (obj != null) {
                return obj.toString();
            }
            db.m15657a("null,can't find information for key:" + str);
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    /* renamed from: a */
    public static String m15675a(int i, Context context) {
        try {
            return ct.m15624c(i, m15676a(context).getBytes());
        } catch (Throwable e) {
            db.m15659a(e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m15676a(Context context) {
        return f19633d.matcher(dg.m15714a(context)).replaceAll("");
    }

    /* renamed from: b */
    public static int m15680b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = m15688d(context);
        } catch (Throwable e) {
            db.m15659a(e);
        }
        return displayMetrics.widthPixels;
    }

    /* renamed from: c */
    public static int m15684c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = m15688d(context);
        } catch (Throwable e) {
            db.m15659a(e);
        }
        return displayMetrics.heightPixels;
    }

    /* renamed from: d */
    public static DisplayMetrics m15688d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: e */
    public static int m15690e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            db.m15661b("Get app version code exception");
            return 1;
        }
    }

    /* renamed from: f */
    public static String m15693f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            db.m15661b("get app version name exception");
            return "";
        }
    }

    /* renamed from: g */
    public static String m15695g(Context context) {
        String str = "%s_%s_%s";
        String format = String.format("%s_%s_%s", new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        try {
            if (cu.m15638e(context, "android.permission.ACCESS_FINE_LOCATION") || cu.m15638e(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
                db.m15657a(cellLocation + "");
                if (cellLocation == null) {
                    return format;
                }
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    r3 = new Object[3];
                    r3[0] = String.format("%d", new Object[]{Integer.valueOf(gsmCellLocation.getCid())});
                    r3[1] = String.format("%d", new Object[]{Integer.valueOf(gsmCellLocation.getLac())});
                    r3[2] = Integer.valueOf(0);
                    return String.format("%s_%s_%s", r3);
                }
                String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                return String.format("%s_%s_%s", new Object[]{split[0], split[3], split[4]});
            }
        } catch (Throwable e) {
            db.m15658a("Get Location", e);
        }
        return format;
    }

    /* renamed from: h */
    public static String m15697h(Context context) {
        String str = "";
        try {
            if (cu.m15638e(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
                db.m15661b("location: " + lastKnownLocation);
                if (lastKnownLocation != null) {
                    return String.format("%s_%s_%s", new Object[]{Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude())});
                }
            }
        } catch (Throwable e) {
            db.m15662b(e);
        }
        return str;
    }

    /* renamed from: b */
    public static String m15682b(int i, Context context) {
        Object j = m15699j(context);
        return TextUtils.isEmpty(j) ? "" : ct.m15624c(i, j.getBytes());
    }

    /* renamed from: i */
    public static String m15698i(Context context) {
        String str = "";
        if (VERSION.SDK_INT < 23) {
            return m15699j(context);
        }
        return m15685c();
    }

    /* renamed from: j */
    public static String m15699j(Context context) {
        try {
            if (cu.m15638e(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(C1981b.f6365e)).getConnectionInfo();
                if (connectionInfo != null) {
                    Object macAddress = connectionInfo.getMacAddress();
                    if (!TextUtils.isEmpty(macAddress)) {
                        return macAddress;
                    }
                }
            }
            db.m15663c("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add: android.permission.ACCESS_WIFI_STATE");
        } catch (Throwable e) {
            db.m15662b(e);
        }
        return "";
    }

    @TargetApi(9)
    /* renamed from: c */
    private static String m15685c() {
        if (VERSION.SDK_INT < 9) {
            return "";
        }
        try {
            String str = "wlan0";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            db.m15662b(th);
        }
        return "";
    }

    /* renamed from: a */
    private static String m15674a(byte b) {
        String str = "00" + Integer.toHexString(b) + Config.TRACE_TODAY_VISIT_SPLIT;
        return str.substring(str.length() - 3);
    }

    /* renamed from: c */
    public static String m15686c(int i, Context context) {
        Object d = m15689d(i, context);
        String str = null;
        if (!TextUtils.isEmpty(d)) {
            str = ct.m15624c(i, d.getBytes());
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    /* renamed from: d */
    public static String m15689d(int i, Context context) {
        String a = m15673a();
        if (TextUtils.isEmpty(a)) {
            a = m15691e(i, context);
        }
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public static String m15691e(int i, Context context) {
        byte[] bArr = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!(inetAddress.isAnyLocalAddress() || !(inetAddress instanceof Inet4Address) || inetAddress.isLoopbackAddress())) {
                        byte[] hardwareAddress;
                        if (inetAddress.isSiteLocalAddress()) {
                            hardwareAddress = networkInterface.getHardwareAddress();
                        } else if (!inetAddress.isLinkLocalAddress()) {
                            bArr = networkInterface.getHardwareAddress();
                            break;
                        } else {
                            hardwareAddress = bArr;
                        }
                        bArr = hardwareAddress;
                    }
                }
            }
        } catch (Throwable e) {
            db.m15659a(e);
        }
        if (bArr != null) {
            for (byte a : bArr) {
                stringBuffer.append(m15674a(a));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
        }
        String b = m15682b(i, context);
        if (b != null) {
            return b.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
        }
        return b;
    }

    /* renamed from: a */
    public static String m15673a() {
        Reader inputStreamReader;
        Throwable e;
        Throwable th;
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    } else if (read != cArr.length || cArr[cArr.length - 1] == '\r') {
                        for (int i = 0; i < read; i++) {
                            if (cArr[i] != '\r') {
                                stringBuffer.append(cArr[i]);
                            }
                        }
                        continue;
                    } else {
                        System.out.print(cArr);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            str = stringBuffer.toString().trim().replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Throwable e3) {
                    db.m15659a(e3);
                }
            }
        } catch (Exception e4) {
            e3 = e4;
            inputStreamReader = null;
            try {
                db.m15659a(e3);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable e32) {
                        db.m15659a(e32);
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable e322) {
                        db.m15659a(e322);
                    }
                }
                throw th;
            }
        } catch (Throwable e3222) {
            inputStreamReader = null;
            th = e3222;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        return str;
    }

    /* renamed from: a */
    public static String m15677a(Context context, int i) {
        Object u = m15710u(context);
        return TextUtils.isEmpty(u) ? "" : ct.m15624c(i, u.getBytes());
    }

    /* renamed from: u */
    private static String m15710u(Context context) {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String name = defaultAdapter.getName();
                if (name != null) {
                    return name;
                }
            }
        } catch (Throwable e) {
            db.m15662b(e);
        }
        return "";
    }

    /* renamed from: f */
    public static String m15692f(int i, Context context) {
        Object k = m15700k(context);
        return TextUtils.isEmpty(k) ? "" : ct.m15624c(i, k.getBytes());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: k */
    public static String m15700k(Context context) {
        String str = Build.BRAND;
        if ("4.1.1".equals(VERSION.RELEASE) && "TCT".equals(str)) {
            return "";
        }
        try {
            if (cu.m15638e(context, "android.permission.BLUETOOTH")) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    str = defaultAdapter.getAddress();
                    if (str != null) {
                        return str;
                    }
                }
            }
        } catch (Throwable e) {
            db.m15662b(e);
        }
        return "";
    }

    /* renamed from: l */
    public static String m15701l(Context context) {
        Object m = m15702m(context);
        if (TextUtils.isEmpty(m)) {
            return "";
        }
        return cs.m15617a(m.getBytes());
    }

    /* renamed from: g */
    public static String m15694g(int i, Context context) {
        Object m = m15702m(context);
        if (TextUtils.isEmpty(m)) {
            return "";
        }
        return ct.m15625d(i, m.getBytes());
    }

    /* renamed from: m */
    public static String m15702m(Context context) {
        WifiInfo connectionInfo;
        List scanResults;
        WifiInfo wifiInfo;
        JSONArray jSONArray;
        int i = 0;
        if (context == null) {
            return "";
        }
        if (!cu.m15638e(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        boolean z;
        int i2;
        ScanResult scanResult;
        StringBuilder stringBuilder;
        String replaceAll;
        int i3;
        JSONObject jSONObject;
        StringBuilder stringBuilder2;
        try {
            boolean isProviderEnabled;
            if (cu.m15638e(context, "android.permission.ACCESS_FINE_LOCATION")) {
                isProviderEnabled = ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
            } else {
                isProviderEnabled = false;
            }
            z = isProviderEnabled;
        } catch (Throwable e) {
            Throwable e2;
            db.m15659a(e2);
            z = false;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(C1981b.f6365e);
            connectionInfo = wifiManager.getConnectionInfo();
            try {
                scanResults = wifiManager.getScanResults();
                wifiInfo = connectionInfo;
            } catch (Throwable th) {
                e2 = th;
                db.m15659a(e2);
                scanResults = null;
                wifiInfo = connectionInfo;
                Collections.sort(scanResults, new df());
                jSONArray = new JSONArray();
                i2 = 0;
                while (scanResults != null) {
                    try {
                        scanResult = (ScanResult) scanResults.get(i2);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(scanResult.BSSID);
                        stringBuilder.append("|");
                        replaceAll = scanResult.SSID.replaceAll("\\|", "");
                        if (replaceAll.length() > 30) {
                            replaceAll = replaceAll.substring(0, 30);
                        }
                        stringBuilder.append(replaceAll);
                        stringBuilder.append("|");
                        stringBuilder.append(scanResult.level);
                        stringBuilder.append("|");
                        if (wifiInfo == null) {
                        }
                        stringBuilder.append(i3);
                        jSONArray.put(stringBuilder.toString());
                    } catch (Throwable e22) {
                        db.m15659a(e22);
                    }
                    i2++;
                }
                if (jSONArray.length() != 0) {
                    return null;
                }
                jSONObject = new JSONObject();
                try {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(System.currentTimeMillis());
                    stringBuilder2.append("|");
                    if (z) {
                        i = 1;
                    }
                    stringBuilder2.append(i);
                    stringBuilder2.append("|");
                    stringBuilder2.append(m15697h(context));
                    jSONObject.put("ap-list", jSONArray);
                    jSONObject.put("meta-data", stringBuilder2.toString());
                    return jSONObject.toString();
                } catch (Throwable e222) {
                    db.m15659a(e222);
                    return "";
                }
            }
        } catch (Throwable th2) {
            e222 = th2;
            connectionInfo = null;
            db.m15659a(e222);
            scanResults = null;
            wifiInfo = connectionInfo;
            Collections.sort(scanResults, new df());
            jSONArray = new JSONArray();
            i2 = 0;
            while (scanResults != null) {
                scanResult = (ScanResult) scanResults.get(i2);
                stringBuilder = new StringBuilder();
                stringBuilder.append(scanResult.BSSID);
                stringBuilder.append("|");
                replaceAll = scanResult.SSID.replaceAll("\\|", "");
                if (replaceAll.length() > 30) {
                    replaceAll = replaceAll.substring(0, 30);
                }
                stringBuilder.append(replaceAll);
                stringBuilder.append("|");
                stringBuilder.append(scanResult.level);
                stringBuilder.append("|");
                if (wifiInfo == null) {
                }
                stringBuilder.append(i3);
                jSONArray.put(stringBuilder.toString());
                i2++;
            }
            if (jSONArray.length() != 0) {
                return null;
            }
            jSONObject = new JSONObject();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(System.currentTimeMillis());
            stringBuilder2.append("|");
            if (z) {
                i = 1;
            }
            stringBuilder2.append(i);
            stringBuilder2.append("|");
            stringBuilder2.append(m15697h(context));
            jSONObject.put("ap-list", jSONArray);
            jSONObject.put("meta-data", stringBuilder2.toString());
            return jSONObject.toString();
        }
        if (!(scanResults == null || scanResults.size() == 0)) {
            Collections.sort(scanResults, new df());
        }
        jSONArray = new JSONArray();
        i2 = 0;
        while (scanResults != null && i2 < scanResults.size() && i2 < 30) {
            scanResult = (ScanResult) scanResults.get(i2);
            stringBuilder = new StringBuilder();
            stringBuilder.append(scanResult.BSSID);
            stringBuilder.append("|");
            replaceAll = scanResult.SSID.replaceAll("\\|", "");
            if (replaceAll.length() > 30) {
                replaceAll = replaceAll.substring(0, 30);
            }
            stringBuilder.append(replaceAll);
            stringBuilder.append("|");
            stringBuilder.append(scanResult.level);
            stringBuilder.append("|");
            i3 = (wifiInfo == null && scanResult.BSSID.equals(wifiInfo.getBSSID())) ? 1 : 0;
            stringBuilder.append(i3);
            jSONArray.put(stringBuilder.toString());
            i2++;
        }
        if (jSONArray.length() != 0) {
            return null;
        }
        jSONObject = new JSONObject();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(System.currentTimeMillis());
        stringBuilder2.append("|");
        if (z) {
            i = 1;
        }
        stringBuilder2.append(i);
        stringBuilder2.append("|");
        stringBuilder2.append(m15697h(context));
        jSONObject.put("ap-list", jSONArray);
        jSONObject.put("meta-data", stringBuilder2.toString());
        return jSONObject.toString();
    }

    /* renamed from: n */
    public static boolean m15703n(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean z;
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } catch (Throwable e) {
            db.m15659a(e);
            return false;
        }
    }

    /* renamed from: o */
    public static String m15704o(Context context) {
        String typeName;
        Throwable e;
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            typeName = activeNetworkInfo.getTypeName();
            try {
                if (typeName.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) {
                    return typeName;
                }
                return activeNetworkInfo.getSubtypeName();
            } catch (Exception e2) {
                e = e2;
                db.m15659a(e);
                return typeName;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            typeName = str;
            e = th;
            db.m15659a(e);
            return typeName;
        }
    }

    /* renamed from: p */
    public static String m15705p(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    /* renamed from: h */
    public static String m15696h(int i, Context context) {
        Object p = m15705p(context);
        if (!TextUtils.isEmpty(p)) {
            try {
                return ct.m15624c(i, p.getBytes());
            } catch (Throwable e) {
                db.m15662b(e);
            }
        }
        return "";
    }

    /* renamed from: v */
    private static String m15711v(Context context) {
        String str = f19630a;
        if (str != null) {
            return str;
        }
        String str2;
        try {
            List runningAppProcesses = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
            int i = 0;
            while (runningAppProcesses != null && i < runningAppProcesses.size()) {
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i);
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                    str2 = runningAppProcessInfo.processName;
                    break;
                }
                i++;
            }
        } catch (Throwable e) {
            db.m15662b(e);
        }
        str2 = str;
        if (str2 == null) {
            str2 = "";
        }
        f19630a = str2;
        return str2;
    }

    /* renamed from: b */
    private static String m15683b(Context context, String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf <= 0 || lastIndexOf + 1 >= str.length()) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* renamed from: c */
    private static String m15687c(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            str = null;
        }
        return str;
    }

    /* renamed from: q */
    public static String m15706q(Context context) {
        String str = f19631b;
        if (str == null) {
            String v = m15711v(context);
            str = m15683b(context, v);
            if (TextUtils.isEmpty(str)) {
                str = m15687c(context, v);
            }
            if (str == null) {
                str = "";
            }
            f19631b = str;
        }
        return str;
    }

    /* renamed from: r */
    public static String m15707r(Context context) {
        String str = "";
        String v = m15711v(context);
        if (v == null) {
            return str;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (NameNotFoundException e) {
        }
        if (packageInfo == null) {
            return str;
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr == null) {
            return str;
        }
        for (ServiceInfo serviceInfo : serviceInfoArr) {
            if (v.equals(serviceInfo.processName)) {
                str = serviceInfo.name;
                break;
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* renamed from: s */
    public static boolean m15708s(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        } catch (Throwable e) {
            db.m15662b(e);
            return false;
        }
    }

    /* renamed from: t */
    public static String m15709t(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.MODEL, memoryInfo.availMem);
            jSONObject.put("l", memoryInfo.lowMemory);
            jSONObject.put("t", memoryInfo.threshold);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_mem", jSONArray);
            jSONObject2.put("meta-data", stringBuilder.toString());
            return cs.m15617a(jSONObject2.toString().getBytes());
        } catch (Throwable e) {
            db.m15659a(e);
            return "";
        }
    }

    /* renamed from: b */
    public static String m15681b() {
        if (f19632c != null) {
            return f19632c;
        }
        String str = "";
        if (!TextUtils.isEmpty(m15679a("ro.miui.ui.version.name"))) {
            str = "miui";
        } else if (!TextUtils.isEmpty(m15679a("ro.build.version.opporom"))) {
            str = "coloros";
        } else if (!TextUtils.isEmpty(m15679a("ro.build.version.emui"))) {
            str = "emui";
        } else if (!TextUtils.isEmpty(m15679a("ro.vivo.os.version"))) {
            str = "funtouch";
        } else if (!TextUtils.isEmpty(m15679a("ro.smartisan.version"))) {
            str = "smartisan";
        }
        if (TextUtils.isEmpty(str)) {
            Object a = m15679a("ro.build.display.id");
            if (!TextUtils.isEmpty(a) && a.contains("Flyme")) {
                str = "flyme";
            }
        }
        f19632c = str;
        return f19632c;
    }

    /* renamed from: a */
    private static String m15679a(String str) {
        Process exec;
        BufferedReader bufferedReader;
        Throwable th;
        Object obj;
        String str2 = null;
        try {
            exec = Runtime.getRuntime().exec("getprop " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                try {
                    str2 = bufferedReader.readLine();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (Exception e2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                obj = str2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                return str2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                obj = str2;
                th = th4;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                throw th;
            }
        } catch (Exception e6) {
            exec = str2;
            bufferedReader = str2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            return str2;
        } catch (Throwable th5) {
            bufferedReader = str2;
            String str3 = str2;
            th = th5;
            exec = str3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            throw th;
        }
        return str2;
    }
}
