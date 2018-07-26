package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.s */
class C3604s {
    /* renamed from: a */
    static C3604s f19656a = new C3604s();
    /* renamed from: b */
    private String f19657b = "";

    C3604s() {
    }

    /* renamed from: a */
    public synchronized void m15777a(Context context, boolean z) {
        int i = 1;
        if (!z) {
            i = 20;
        }
        m15771a(context, z, i);
    }

    /* renamed from: a */
    private void m15771a(Context context, boolean z, int i) {
        ArrayList a = m15769a(context, i);
        if (a != null && a.size() != 0) {
            if (z) {
                String b = ((C3605t) a.get(0)).m15779b();
                if (m15773a(b, this.f19657b)) {
                    this.f19657b = b;
                }
            }
            m15770a(context, a, z);
        }
    }

    /* renamed from: a */
    private ArrayList<C3605t> m15769a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return m15776c(context, i);
        }
        return m15774b(context, i);
    }

    /* renamed from: b */
    private ArrayList<C3605t> m15774b(Context context, int i) {
        List runningTasks;
        try {
            runningTasks = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningTasks(50);
        } catch (Throwable e) {
            bd.m15432b(e);
            runningTasks = null;
        }
        if (r0 == null) {
            return new ArrayList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (RunningTaskInfo runningTaskInfo : r0) {
            if (linkedHashMap.size() > i) {
                break;
            }
            ComponentName componentName = runningTaskInfo.topActivity;
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                if (!(TextUtils.isEmpty(packageName) || m15775b(context, packageName) || linkedHashMap.containsKey(packageName))) {
                    linkedHashMap.put(packageName, new C3605t(packageName, m15768a(context, packageName), ""));
                }
            }
        }
        return new ArrayList(linkedHashMap.values());
    }

    /* renamed from: c */
    private ArrayList<C3605t> m15776c(Context context, int i) {
        List runningAppProcesses = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return new ArrayList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < runningAppProcesses.size() && linkedHashMap.size() <= i; i2++) {
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i2);
            if (m15772a(runningAppProcessInfo.importance)) {
                String[] strArr = runningAppProcessInfo.pkgList;
                if (!(strArr == null || strArr.length == 0)) {
                    String str = runningAppProcessInfo.pkgList[0];
                    if (!(TextUtils.isEmpty(str) || m15775b(context, str) || linkedHashMap.containsKey(str))) {
                        linkedHashMap.put(str, new C3605t(str, m15768a(context, str), String.valueOf(runningAppProcessInfo.importance)));
                    }
                }
            }
        }
        return new ArrayList(linkedHashMap.values());
    }

    /* renamed from: a */
    private boolean m15772a(int i) {
        if (i == 100 || i == 200 || i == 130) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m15773a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(this.f19657b)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m15768a(Context context, String str) {
        String str2 = "";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str2;
        }
        try {
            str2 = packageManager.getPackageInfo(str, 0).versionName;
        } catch (Throwable e) {
            bd.m15432b(e);
        }
        return str2 == null ? "" : str2;
    }

    /* renamed from: b */
    private boolean m15775b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            bd.m15432b(e);
            return false;
        }
    }

    /* renamed from: a */
    private void m15770a(Context context, ArrayList<C3605t> arrayList, boolean z) {
        String a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis() + "|");
        stringBuilder.append(z ? 1 : 0);
        String str = "";
        try {
            JSONObject a2;
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a2 = ((C3605t) it.next()).m15778a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            a2 = new JSONObject();
            a2.put("app_trace", jSONArray);
            a2.put("meta-data", stringBuilder.toString());
            a = cs.m15617a(a2.toString().getBytes());
        } catch (Throwable e) {
            bd.m15432b(e);
            a = str;
        }
        if (!TextUtils.isEmpty(a)) {
            C3585y.APP_TRACE.m15290a(System.currentTimeMillis(), a);
        }
    }
}
