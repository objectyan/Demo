package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.o */
public class C3600o {
    /* renamed from: a */
    static C3600o f19649a = new C3600o();

    /* renamed from: a */
    public synchronized void m15761a(Context context) {
        m15758b(context);
    }

    /* renamed from: b */
    private void m15758b(Context context) {
        m15757a(context, m15759c(context));
    }

    /* renamed from: c */
    private ArrayList<C3601p> m15759c(Context context) {
        ArrayList<C3601p> arrayList = new ArrayList();
        Iterator it = m15760d(context).iterator();
        while (it.hasNext()) {
            PackageInfo packageInfo = (PackageInfo) it.next();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                String str;
                String str2 = packageInfo.packageName;
                String str3 = packageInfo.versionName;
                String str4 = "";
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length == 0) {
                    str = str4;
                } else {
                    str = signatureArr[0].toChars().toString();
                }
                str4 = cz.m15651a(str.getBytes());
                str = "";
                Object obj = applicationInfo.sourceDir;
                if (!TextUtils.isEmpty(obj)) {
                    str = cz.m15650a(new File(obj));
                }
                arrayList.add(new C3601p(str2, str3, str4, str));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private ArrayList<PackageInfo> m15760d(Context context) {
        ArrayList<PackageInfo> arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        List arrayList2 = new ArrayList(1);
        try {
            arrayList2 = packageManager.getInstalledPackages(64);
        } catch (Throwable e) {
            bd.m15432b(e);
        }
        for (PackageInfo packageInfo : r0) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null && (applicationInfo.flags & 1) == 0) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m15757a(Context context, ArrayList<C3601p> arrayList) {
        String a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        String str = "";
        try {
            JSONObject a2;
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a2 = ((C3601p) it.next()).m15762a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            a2 = new JSONObject();
            a2.put("app_apk", jSONArray);
            a2.put("meta-data", stringBuilder.toString());
            a = cs.m15617a(a2.toString().getBytes());
        } catch (Throwable e) {
            bd.m15432b(e);
            a = str;
        }
        if (!TextUtils.isEmpty(a)) {
            C3585y.APP_APK.m15290a(System.currentTimeMillis(), a);
        }
    }
}
