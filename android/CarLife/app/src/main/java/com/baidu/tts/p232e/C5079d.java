package com.baidu.tts.p232e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.zip.GZIPOutputStream;

/* compiled from: Utility */
/* renamed from: com.baidu.tts.e.d */
public class C5079d {
    /* renamed from: a */
    public static void m17242a(Context context, long j) {
        Editor edit = context.getSharedPreferences("tts", 0).edit();
        edit.putLong("last_upload_stat_time", j);
        edit.commit();
    }

    /* renamed from: a */
    public static long m17239a(Context context) {
        return context.getSharedPreferences("tts", 0).getLong("last_upload_stat_time", 0);
    }

    /* renamed from: a */
    public static String m17241a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return new String(Base64.encode(bArr, 0, bArr.length, 0), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m17243a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m17240a() {
        return "1.0.0-20140804";
    }

    /* renamed from: b */
    public static String m17245b(Context context) {
        return C5079d.m17255i(context);
    }

    /* renamed from: c */
    public static String m17248c(Context context) {
        return C5079d.m17244b() + "&" + Build.MODEL + "&" + VERSION.RELEASE + "&" + VERSION.SDK_INT + "&" + C5079d.m17250d(context);
    }

    /* renamed from: b */
    public static String m17244b() {
        return C1253f.jb;
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: d */
    public static int m17250d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !C1981b.f6365e.equals(activeNetworkInfo.getTypeName().toLowerCase())) {
            return 3;
        }
        return 1;
    }

    /* renamed from: e */
    public static String m17251e(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        return i + "*" + displayMetrics.heightPixels;
    }

    /* renamed from: c */
    public static String m17247c() {
        return "离线TTS SDK";
    }

    /* renamed from: f */
    public static String m17252f(Context context) {
        String str = null;
        try {
            str = C5079d.m17246b(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: b */
    private static String m17246b(byte[] bArr) {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(x509Certificate.getEncoded());
            return C5079d.m17249c(instance.digest());
        } catch (CertificateException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private static String m17249c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }

    /* renamed from: i */
    private static String m17255i(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
            }
        } catch (NameNotFoundException e2) {
            Object obj = applicationInfo;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    /* renamed from: g */
    public static NetworkInfo m17253g(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* renamed from: h */
    public static boolean m17254h(Context context) {
        NetworkInfo g = C5079d.m17253g(context);
        return g != null && g.isConnected();
    }
}
