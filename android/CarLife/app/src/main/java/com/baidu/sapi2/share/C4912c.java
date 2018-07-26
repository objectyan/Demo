package com.baidu.sapi2.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.C4891b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccount$ReloginCredentials;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: ShareUtils */
/* renamed from: com.baidu.sapi2.share.c */
final class C4912c {

    /* compiled from: ShareUtils */
    /* renamed from: com.baidu.sapi2.share.c$1 */
    static class C49101 implements Comparator<Entry<Intent, Integer>> {
        C49101() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m16357a((Entry) x0, (Entry) x1);
        }

        /* renamed from: a */
        public int m16357a(Entry<Intent, Integer> o1, Entry<Intent, Integer> o2) {
            return ((Integer) o1.getValue()).compareTo((Integer) o2.getValue());
        }
    }

    C4912c() {
    }

    /* renamed from: a */
    static List<Intent> m16359a(Context context) {
        List<Intent> serviceList = new ArrayList();
        Map<Intent, Integer> orderServices = new HashMap();
        Map<String, Integer> orderAuthorizedPackages = C4891b.m16250a(context).m16292n();
        if (context != null) {
            try {
                List<ResolveInfo> services = context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32);
                if (services != null) {
                    for (ResolveInfo resolveInfo : services) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        if (serviceInfo != null) {
                            Intent intent = new Intent("baidu.intent.action.account.SHARE_SERVICE");
                            intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                            if (VERSION.SDK_INT > 11) {
                                intent.addFlags(32);
                            }
                            if (!TextUtils.isEmpty(serviceInfo.permission)) {
                                if (context.checkCallingOrSelfPermission(serviceInfo.permission) != 0) {
                                }
                            }
                            if (C4912c.m16363a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                                int serviceWeight = Integer.MAX_VALUE;
                                for (String packageNamePattern : orderAuthorizedPackages.keySet()) {
                                    if (intent.getComponent().getPackageName().matches(packageNamePattern)) {
                                        serviceWeight = ((Integer) orderAuthorizedPackages.get(packageNamePattern)).intValue();
                                    }
                                }
                                orderServices.put(intent, Integer.valueOf(serviceWeight));
                            }
                        }
                    }
                    List<Entry<Intent, Integer>> orderServicesList = new ArrayList(orderServices.entrySet());
                    Collections.sort(orderServicesList, new C49101());
                    for (Entry<Intent, Integer> service : orderServicesList) {
                        serviceList.add(service.getKey());
                    }
                }
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
        return serviceList;
    }

    /* renamed from: b */
    static boolean m16368b(Context context) {
        if (context == null) {
            return false;
        }
        String callerPackageName = C4912c.m16369c(context);
        String callerPackageSign = C4912c.m16364b(context, callerPackageName);
        Map<String, String> authorizedPackages = C4891b.m16250a(context).m16289k();
        if (TextUtils.isEmpty(callerPackageName) || TextUtils.isEmpty(callerPackageSign)) {
            return false;
        }
        for (String packageNamePattern : authorizedPackages.keySet()) {
            if (callerPackageName.matches(packageNamePattern) && callerPackageSign.equals(authorizedPackages.get(packageNamePattern))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m16363a(Context context, String calleePackageName) {
        if (context == null || TextUtils.isEmpty(calleePackageName)) {
            return false;
        }
        Map<String, String> authorizedPackages = C4891b.m16250a(context).m16289k();
        String calleePackageSign = C4912c.m16364b(context, calleePackageName);
        if (TextUtils.isEmpty(calleePackageSign)) {
            return false;
        }
        for (String packageNamePattern : authorizedPackages.keySet()) {
            if (calleePackageName.matches(packageNamePattern) && calleePackageSign.equals(authorizedPackages.get(packageNamePattern))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    static String m16369c(Context context) {
        String callerPackageName = "";
        if (context == null) {
            return callerPackageName;
        }
        try {
            String[] packages = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packages.length > 0) {
                callerPackageName = packages[0];
            }
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return callerPackageName;
    }

    /* renamed from: b */
    static String m16364b(Context context, String packageName) {
        String packageSign = "";
        if (context == null || TextUtils.isEmpty(packageName)) {
            return packageSign;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo.signatures.length > 0) {
                packageSign = C4912c.m16358a(packageInfo.signatures[0].toByteArray());
            }
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return packageSign;
    }

    /* renamed from: a */
    static String m16358a(byte[] bytes) {
        String result = "";
        if (bytes == null) {
            return result;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(bytes);
            result = C4912c.m16365b(md5.digest());
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return result;
    }

    /* renamed from: b */
    static String m16365b(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        if (bytes == null) {
            return builder.toString();
        }
        for (int b : bytes) {
            String str = Integer.toHexString(b & 255);
            if (str.length() == 1) {
                builder.append("0");
            }
            builder.append(str);
        }
        return builder.toString();
    }

    /* renamed from: a */
    static synchronized void m16361a(Context context, LoginShareStrategy strategy, ShareModel shareModel) {
        synchronized (C4912c.class) {
            if (!(context == null || strategy == null || shareModel == null)) {
                shareModel.m16332b(context);
                final C4891b sapiContext = C4891b.m16250a(context);
                if (strategy == LoginShareStrategy.SILENT && !sapiContext.m16286h() && sapiContext.m16278d() == null && shareModel.m16324a().size() > 0 && SapiUtils.isValidAccount((SapiAccount) shareModel.m16324a().get(0))) {
                    SapiAccount shareAccount = (SapiAccount) shareModel.m16324a().get(0);
                    sapiContext.m16265a(shareAccount);
                    sapiContext.m16275c(shareAccount);
                    sapiContext.m16279d(shareAccount);
                    if (SapiAccountManager.getSilentShareListener() != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (SapiAccountManager.getSilentShareListener() != null && sapiContext.m16278d() != null) {
                                    SapiAccountManager.getSilentShareListener().onSilentShare();
                                }
                            }
                        });
                    }
                    for (SapiAccount account : shareModel.m16324a()) {
                        if (C4912c.m16362a(context, account)) {
                            sapiContext.m16272b(account);
                        }
                    }
                    Map<String, String> extras = new HashMap();
                    extras.put("app", shareAccount.app);
                    StatService.m16390a("silent_login_share", extras);
                } else {
                    for (SapiAccount account2 : shareModel.m16324a()) {
                        if (C4912c.m16362a(context, account2)) {
                            sapiContext.m16272b(account2);
                        }
                        C4912c.m16366b(context, account2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m16362a(Context context, SapiAccount account) {
        if (context == null) {
            return false;
        }
        C4891b sapiContext = C4891b.m16250a(context);
        if (!SapiUtils.isValidAccount(account)) {
            return false;
        }
        if ((sapiContext.m16278d() == null || !sapiContext.m16278d().uid.equals(account.uid)) && !sapiContext.m16284f().contains(account)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static void m16360a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.m16332b(context);
            C4891b sapiContext = C4891b.m16250a(context);
            if (shareModel.m16324a().size() > 0) {
                SapiAccount invalidateAccount = (SapiAccount) shareModel.m16324a().get(0);
                if (sapiContext.m16278d() == null || !sapiContext.m16278d().uid.equals(invalidateAccount.uid)) {
                    sapiContext.m16279d(invalidateAccount);
                }
            }
        }
    }

    /* renamed from: b */
    static void m16366b(Context context, SapiAccount account) {
        if (context != null && SapiUtils.isValidAccount(account)) {
            C4891b sapiContext = C4891b.m16250a(context);
            SapiAccount currentAccount = sapiContext.m16278d();
            if (currentAccount != null && account.uid.equals(currentAccount.uid)) {
                currentAccount.bduss = account.bduss;
                sapiContext.m16265a(currentAccount);
            }
            for (SapiAccount loginAccount : sapiContext.m16284f()) {
                if (account.uid.equals(loginAccount.uid)) {
                    loginAccount.bduss = account.bduss;
                    sapiContext.m16275c(loginAccount);
                }
            }
            for (SapiAccount shareAccount : sapiContext.m16281e()) {
                if (account.uid.equals(shareAccount.uid)) {
                    shareAccount.bduss = account.bduss;
                    sapiContext.m16272b(shareAccount);
                }
            }
        }
    }

    /* renamed from: c */
    static void m16370c(Context context, String reloginCredentials) {
        if (context != null && !TextUtils.isEmpty(reloginCredentials)) {
            try {
                JSONObject obj = new JSONObject(C4909b.m16356b(context, reloginCredentials));
                Iterator<?> iterator = obj.keys();
                while (iterator.hasNext()) {
                    String uid = (String) iterator.next();
                    C4891b.m16250a(context).m16268a(uid, SapiAccount$ReloginCredentials.fromJSONObject(obj.optJSONObject(uid)));
                }
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: b */
    static void m16367b(Context context, LoginShareStrategy strategy, ShareModel shareModel) {
        if (context != null && strategy != null && shareModel != null) {
            if (TextUtils.isEmpty(shareModel.m16333c())) {
                shareModel.m16329a(context.getPackageName());
            }
            shareModel.m16328a(strategy);
            shareModel.m16325a(context);
        }
    }
}
