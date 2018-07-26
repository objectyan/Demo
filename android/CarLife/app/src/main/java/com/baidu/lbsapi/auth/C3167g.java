package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.p020a.C0402a;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.lbsapi.auth.C3158d.C3157a;
import com.baidu.lbsapi.auth.C3161e.C3160a;
import com.baidu.navi.adapter.DistrictAdapter;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.speech.asr.SpeechConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.lbsapi.auth.g */
public class C3167g {
    /* renamed from: a */
    private static Context f17230a;
    /* renamed from: d */
    private static C3168h f17231d = null;
    /* renamed from: e */
    private static int f17232e = 0;
    /* renamed from: f */
    private static Hashtable<String, LBSAuthManagerListener> f17233f = new Hashtable();
    /* renamed from: g */
    private static C3167g f17234g;
    /* renamed from: b */
    private C3158d f17235b = null;
    /* renamed from: c */
    private C3161e f17236c = null;
    /* renamed from: h */
    private final Handler f17237h = new Handler(this, Looper.getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ C3167g f17219a;

        public void handleMessage(Message message) {
            if (C3152a.f17205a) {
                C3152a.m13186a("handleMessage !!");
            }
            LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) C3167g.f17233f.get(message.getData().getString("listenerKey"));
            if (C3152a.f17205a) {
                C3152a.m13186a("handleMessage listener = " + lBSAuthManagerListener);
            }
            if (lBSAuthManagerListener != null) {
                lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
            }
        }
    };

    private C3167g(Context context) {
        f17230a = context;
        if (!(f17231d == null || f17231d.isAlive())) {
            f17231d = null;
        }
        C3152a.m13187b("BaiduApiAuth SDK Version:1.0.20");
        m13244d();
    }

    /* renamed from: a */
    private int m13227a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            int i = jSONObject.getInt("status");
            if (jSONObject.has(DistrictAdapter.CURRENT_LOCATION) && i == 0) {
                long j = jSONObject.getLong(DistrictAdapter.CURRENT_LOCATION);
                long currentTimeMillis = System.currentTimeMillis();
                if (((double) (currentTimeMillis - j)) / 3600000.0d >= 24.0d) {
                    i = UIMsg.MSG_MAP_PANO_ROUTE_DATA;
                } else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j)))) {
                        i = UIMsg.MSG_MAP_PANO_ROUTE_DATA;
                    }
                }
            }
            if (jSONObject.has(DistrictAdapter.CURRENT_LOCATION) && i == 602) {
                if (((double) ((System.currentTimeMillis() - jSONObject.getLong(DistrictAdapter.CURRENT_LOCATION)) / 1000)) > 180.0d) {
                    return UIMsg.MSG_MAP_PANO_ROUTE_DATA;
                }
            }
            return i;
        } catch (JSONException e) {
            JSONException jSONException = e;
            int i2 = -1;
            jSONException.printStackTrace();
            return i2;
        }
    }

    /* renamed from: a */
    public static C3167g m13228a(Context context) {
        if (f17234g == null) {
            synchronized (C3167g.class) {
                if (f17234g == null) {
                    f17234g = new C3167g(context);
                }
            }
        } else if (context != null) {
            f17230a = context;
        } else if (C3152a.f17205a) {
            C3152a.m13188c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return f17234g;
    }

    /* renamed from: a */
    private String m13229a(int i) throws IOException {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Object obj;
        Object obj2;
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        String str = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/" + i + "/cmdline"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (FileNotFoundException e) {
                obj = str;
                obj2 = str;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (IOException e2) {
                obj = str;
                obj2 = str;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (Throwable th3) {
                obj2 = str;
                String str2 = str;
                th = th3;
                obj = str2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (FileNotFoundException e3) {
                obj = str;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (IOException e4) {
                obj = str;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (Throwable th32) {
                th2 = th32;
                obj = str;
                th = th2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            try {
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (FileNotFoundException e5) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (IOException e6) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            bufferedReader = str;
            inputStreamReader = str;
            fileInputStream = str;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (IOException e8) {
            bufferedReader = str;
            inputStreamReader = str;
            fileInputStream = str;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (Throwable th322) {
            inputStreamReader = str;
            fileInputStream = str;
            th2 = th322;
            bufferedReader = str;
            th = th2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str;
    }

    /* renamed from: a */
    private String m13230a(Context context, String str) {
        String str2 = "";
        LBSAuthManagerListener lBSAuthManagerListener;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                lBSAuthManagerListener = (LBSAuthManagerListener) f17233f.get(str);
                if (lBSAuthManagerListener != null) {
                    lBSAuthManagerListener.onAuthResult(101, C3155c.m13200a(101, "AndroidManifest.xml的application中没有meta-data标签"));
                }
                return str2;
            }
            str2 = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            if (str2 == null || str2.equals("")) {
                lBSAuthManagerListener = (LBSAuthManagerListener) f17233f.get(str);
                if (lBSAuthManagerListener != null) {
                    lBSAuthManagerListener.onAuthResult(101, C3155c.m13200a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                }
            }
            return str2;
        } catch (NameNotFoundException e) {
            lBSAuthManagerListener = (LBSAuthManagerListener) f17233f.get(str);
            if (lBSAuthManagerListener != null) {
                lBSAuthManagerListener.onAuthResult(101, C3155c.m13200a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
            }
        }
    }

    /* renamed from: a */
    private synchronized void m13235a(String str, String str2) {
        if (str == null) {
            str = m13245e();
        }
        Message obtainMessage = this.f17237h.obtainMessage();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            if (!jSONObject.has(DistrictAdapter.CURRENT_LOCATION)) {
                jSONObject.put(DistrictAdapter.CURRENT_LOCATION, System.currentTimeMillis());
            }
            m13243c(jSONObject.toString());
            if (jSONObject.has(DistrictAdapter.CURRENT_LOCATION)) {
                jSONObject.remove(DistrictAdapter.CURRENT_LOCATION);
            }
            obtainMessage.what = jSONObject.getInt("status");
            obtainMessage.obj = jSONObject.toString();
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.f17237h.sendMessage(obtainMessage);
        } catch (JSONException e) {
            e.printStackTrace();
            obtainMessage.what = -1;
            obtainMessage.obj = new JSONObject();
            bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.f17237h.sendMessage(obtainMessage);
        }
        f17231d.m13249c();
        f17232e--;
        if (C3152a.f17205a) {
            C3152a.m13186a("httpRequest called mAuthCounter-- = " + f17232e);
        }
        if (f17232e == 0) {
            f17231d.m13247a();
            if (f17231d != null) {
                f17231d = null;
            }
        }
    }

    /* renamed from: a */
    private void m13236a(boolean z, String str, Hashtable<String, String> hashtable, final String str2) {
        String a = m13230a(f17230a, str2);
        if (a != null && !a.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
            C3152a.m13186a("url:https://api.map.baidu.com/sdkcs/verify");
            hashMap.put("output", "json");
            hashMap.put("ak", a);
            C3152a.m13186a("ak:" + a);
            hashMap.put("mcode", C3154b.m13191a(f17230a));
            hashMap.put(PlatformConstants.CONNECT_EXTRA_KEY, "lbs_yunsdk");
            if (hashtable != null && hashtable.size() > 0) {
                for (Entry entry : hashtable.entrySet()) {
                    String str3 = (String) entry.getKey();
                    a = (String) entry.getValue();
                    if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(a))) {
                        hashMap.put(str3, a);
                    }
                }
            }
            CharSequence charSequence = "";
            try {
                charSequence = C0402a.a(f17230a);
            } catch (Exception e) {
            }
            C3152a.m13186a("cuid:" + charSequence);
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("cuid", "");
            } else {
                hashMap.put("cuid", charSequence);
            }
            hashMap.put("pcn", f17230a.getPackageName());
            hashMap.put("version", "1.0.20");
            charSequence = "";
            try {
                charSequence = C3154b.m13197c(f17230a);
            } catch (Exception e2) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("macaddr", "");
            } else {
                hashMap.put("macaddr", charSequence);
            }
            charSequence = "";
            try {
                charSequence = C3154b.m13190a();
            } catch (Exception e3) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put(SpeechConstant.LANGUAGE, "");
            } else {
                hashMap.put(SpeechConstant.LANGUAGE, charSequence);
            }
            if (z) {
                hashMap.put("force", z ? "1" : "0");
            }
            if (str == null) {
                hashMap.put("from_service", "");
            } else {
                hashMap.put("from_service", str);
            }
            this.f17235b = new C3158d(f17230a);
            this.f17235b.m13208a(hashMap, new C3157a<String>(this) {
                /* renamed from: b */
                final /* synthetic */ C3167g f17227b;

                /* renamed from: a */
                public void m13224a(String str) {
                    this.f17227b.m13235a(str, str2);
                }
            });
        }
    }

    /* renamed from: a */
    private void m13237a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, final String str2) {
        String a = m13230a(f17230a, str2);
        if (a != null && !a.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
            hashMap.put("output", "json");
            hashMap.put("ak", a);
            hashMap.put(PlatformConstants.CONNECT_EXTRA_KEY, "lbs_yunsdk");
            if (hashtable != null && hashtable.size() > 0) {
                for (Entry entry : hashtable.entrySet()) {
                    String str3 = (String) entry.getKey();
                    a = (String) entry.getValue();
                    if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(a))) {
                        hashMap.put(str3, a);
                    }
                }
            }
            CharSequence charSequence = "";
            try {
                charSequence = C0402a.a(f17230a);
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("cuid", "");
            } else {
                hashMap.put("cuid", charSequence);
            }
            hashMap.put("pcn", f17230a.getPackageName());
            hashMap.put("version", "1.0.20");
            charSequence = "";
            try {
                charSequence = C3154b.m13197c(f17230a);
            } catch (Exception e2) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("macaddr", "");
            } else {
                hashMap.put("macaddr", charSequence);
            }
            charSequence = "";
            try {
                charSequence = C3154b.m13190a();
            } catch (Exception e3) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put(SpeechConstant.LANGUAGE, "");
            } else {
                hashMap.put(SpeechConstant.LANGUAGE, charSequence);
            }
            if (z) {
                hashMap.put("force", z ? "1" : "0");
            }
            if (str == null) {
                hashMap.put("from_service", "");
            } else {
                hashMap.put("from_service", str);
            }
            this.f17236c = new C3161e(f17230a);
            this.f17236c.m13215a(hashMap, strArr, new C3160a<String>(this) {
                /* renamed from: b */
                final /* synthetic */ C3167g f17229b;

                /* renamed from: a */
                public void m13226a(String str) {
                    this.f17229b.m13235a(str, str2);
                }
            });
        }
    }

    /* renamed from: b */
    private String m13240b(Context context) {
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        String str = null;
        try {
            str = m13229a(myPid);
        } catch (IOException e) {
        }
        return str == null ? f17230a.getPackageName() : str;
    }

    /* renamed from: b */
    private boolean m13241b(String str) {
        String a = m13230a(f17230a, str);
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(m13245e());
            if (!jSONObject.has("ak")) {
                return true;
            }
            Object string = jSONObject.getString("ak");
            return (a == null || string == null || a.equals(string)) ? false : true;
        } catch (JSONException e) {
            e.printStackTrace();
            String str3 = str2;
        }
    }

    /* renamed from: c */
    private void m13243c(String str) {
        f17230a.getSharedPreferences("authStatus_" + m13240b(f17230a), 0).edit().putString("status", str).commit();
    }

    /* renamed from: d */
    private void m13244d() {
        synchronized (C3167g.class) {
            if (f17231d == null) {
                f17231d = new C3168h(C2546c.as);
                f17231d.start();
                while (f17231d.f17238a == null) {
                    try {
                        if (C3152a.f17205a) {
                            C3152a.m13186a("wait for create auth thread.");
                        }
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private String m13245e() {
        return f17230a.getSharedPreferences("authStatus_" + m13240b(f17230a), 0).getString("status", "{\"status\":601}");
    }

    /* renamed from: a */
    public int m13246a(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        int i;
        synchronized (C3167g.class) {
            final String str2 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f17233f.put(str2, lBSAuthManagerListener);
            }
            String a = m13230a(f17230a, str2);
            if (a == null || a.equals("")) {
                i = 101;
            } else {
                f17232e++;
                if (C3152a.f17205a) {
                    C3152a.m13186a(" mAuthCounter  ++ = " + f17232e);
                }
                a = m13245e();
                if (C3152a.f17205a) {
                    C3152a.m13186a("getAuthMessage from cache:" + a);
                }
                i = m13227a(a);
                if (i == UIMsg.MSG_MAP_PANO_ROUTE_DATA) {
                    try {
                        m13243c(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                m13244d();
                if (C3152a.f17205a) {
                    C3152a.m13186a("mThreadLooper.mHandler = " + f17231d.f17238a);
                }
                if (f17231d == null || f17231d.f17238a == null) {
                    i = -1;
                } else {
                    final boolean z2 = z;
                    final String str3 = str;
                    final Hashtable<String, String> hashtable2 = hashtable;
                    f17231d.f17238a.post(new Runnable(this) {
                        /* renamed from: f */
                        final /* synthetic */ C3167g f17225f;

                        public void run() {
                            if (C3152a.f17205a) {
                                C3152a.m13186a("status = " + i + "; forced = " + z2 + "checkAK = " + this.f17225f.m13241b(str2));
                            }
                            if (i == UIMsg.MSG_MAP_PANO_ROUTE_DATA || z2 || i == -1 || this.f17225f.m13241b(str2)) {
                                if (C3152a.f17205a) {
                                    C3152a.m13186a("authenticate sendAuthRequest");
                                }
                                String[] b = C3154b.m13195b(C3167g.f17230a);
                                if (C3152a.f17205a) {
                                    C3152a.m13186a("authStrings.length:" + b.length);
                                }
                                if (b == null || b.length <= 1) {
                                    this.f17225f.m13236a(z2, str3, hashtable2, str2);
                                    return;
                                }
                                if (C3152a.f17205a) {
                                    C3152a.m13186a("more sha1 auth");
                                }
                                this.f17225f.m13237a(z2, str3, hashtable2, b, str2);
                            } else if (602 == i) {
                                if (C3152a.f17205a) {
                                    C3152a.m13186a("authenticate wait  ");
                                }
                                C3167g.f17231d.m13248b();
                                this.f17225f.m13235a(null, str2);
                            } else {
                                if (C3152a.f17205a) {
                                    C3152a.m13186a("authenticate else  ");
                                }
                                this.f17225f.m13235a(null, str2);
                            }
                        }
                    });
                }
            }
        }
        return i;
    }
}
