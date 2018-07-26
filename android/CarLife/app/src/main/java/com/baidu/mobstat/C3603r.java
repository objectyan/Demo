package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.r */
class C3603r {
    /* renamed from: a */
    static final C3603r f19655a = new C3603r();

    C3603r() {
    }

    /* renamed from: a */
    public synchronized void m15767a(Context context, boolean z) {
        m15766b(context, z);
    }

    /* renamed from: b */
    private void m15766b(Context context, boolean z) {
        int i = 1;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            List arrayList = new ArrayList(1);
            try {
                arrayList = packageManager.getInstalledPackages(0);
            } catch (Throwable e) {
                bd.m15432b(e);
            }
            JSONArray jSONArray = new JSONArray();
            for (PackageInfo packageInfo : r0) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    boolean z2 = (applicationInfo.flags & 1) != 0;
                    String charSequence = applicationInfo.loadLabel(packageManager).toString();
                    String str = applicationInfo.sourceDir;
                    if (z == z2) {
                        m15765a(z, charSequence, str, packageInfo, jSONArray);
                    }
                }
            }
            if (jSONArray.length() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(System.currentTimeMillis() + "|");
                if (!z) {
                    i = 0;
                }
                stringBuilder.append(i);
                String str2 = "";
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_list", jSONArray);
                    jSONObject.put("meta-data", stringBuilder.toString());
                    str2 = cs.m15617a(jSONObject.toString().getBytes());
                } catch (Exception e2) {
                }
                if (!TextUtils.isEmpty(str2)) {
                    C3585y.APP_LIST.m15290a(System.currentTimeMillis(), str2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15765a(boolean z, String str, String str2, PackageInfo packageInfo, JSONArray jSONArray) {
        long j = 0;
        if (!z || !packageInfo.packageName.startsWith("com.android.")) {
            long j2;
            try {
                j2 = packageInfo.firstInstallTime;
            } catch (Throwable th) {
                bd.m15432b(th);
                j2 = j;
            }
            try {
                j = packageInfo.lastUpdateTime;
            } catch (Throwable th2) {
                bd.m15432b(th2);
            }
            long a = m15764a(str2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put(Config.APP_VERSION_CODE, str);
                jSONObject.put("v", String.valueOf(packageInfo.versionName));
                jSONObject.put(Regular.CATEGORY_FIX_VALUE, j2);
                jSONObject.put("l", j);
                jSONObject.put(Config.MODEL, a);
                jSONArray.put(jSONObject);
            } catch (Throwable th3) {
                bd.m15432b(th3);
            }
        }
    }

    /* renamed from: a */
    private long m15764a(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file == null || !file.exists()) {
            return 0;
        }
        return file.lastModified();
    }
}
