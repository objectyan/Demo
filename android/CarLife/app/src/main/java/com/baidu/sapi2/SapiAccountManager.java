package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.sapi2.share.C4908a;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4920d;
import com.baidu.sapi2.utils.C4922e;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class SapiAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_PTOKEN = "ptoken";
    public static final String SESSION_STOKEN = "stoken";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 80;
    public static final String VERSION_NAME = "6.14.5";
    /* renamed from: a */
    private static SapiAccountManager f20021a;
    /* renamed from: b */
    private static SapiConfiguration f20022b;
    /* renamed from: c */
    private static SapiAccountService f20023c;
    /* renamed from: d */
    private static SilentShareListener f20024d;
    /* renamed from: e */
    private static ReceiveShareListener f20025e;
    /* renamed from: f */
    private static GlobalAuthorizationListener f20026f;
    /* renamed from: g */
    private static final List<String> f20027g = new ArrayList();

    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount session) {
        }
    }

    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        f20027g.addAll(Arrays.asList(new String[]{"uid", SESSION_DISPLAYNAME, "bduss", SESSION_PTOKEN, SESSION_STOKEN}));
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (f20021a == null) {
                f20021a = new SapiAccountManager();
            }
            sapiAccountManager = f20021a;
        }
        return sapiAccountManager;
    }

    private SapiAccountManager() {
    }

    public synchronized void init(final SapiConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        } else if (f20022b == null) {
            f20022b = configuration;
            f20023c = new SapiAccountService(configuration.context);
            if (m16062c(configuration.context)) {
                new Thread(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ SapiAccountManager f20020b;

                    public void run() {
                        int curVersionCode = SapiUtils.getVersionCode(configuration.context);
                        if (configuration.silentShareOnUpgrade && curVersionCode > C4891b.m16250a(configuration.context).m16298t()) {
                            SapiUtils.resetSilentShareStatus(configuration.context);
                        }
                        C4891b.m16250a(configuration.context).m16264a(curVersionCode);
                        configuration.clientId = SapiUtils.getClientId(configuration.context);
                        configuration.clientIp = SapiUtils.getLocalIpAddress();
                        C4908a.m16344b();
                        if (configuration.syncCacheOnInit) {
                            SapiCache.init(configuration.context);
                        }
                        if (!TextUtils.isEmpty(configuration.deviceLoginSignKey)) {
                            SapiAccountManager.f20023c.deviceLoginCheck();
                        }
                        StatService.m16389a();
                        C4922e.m16411a(configuration.context);
                    }
                }).start();
            }
        } else {
            C4913L.m16372d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
        }
    }

    public SapiConfiguration getSapiConfiguration() {
        m16063a();
        return f20022b;
    }

    public SapiAccountService getAccountService() {
        m16063a();
        return f20023c;
    }

    public boolean isLogin() {
        m16063a();
        return C4891b.m16250a(f20022b.context).m16278d() != null;
    }

    public void logout() {
        StatService.m16390a(C2848p.aj, Collections.singletonMap("di", C4920d.m16400b("sdk_api_logout")));
        removeLoginAccount(getSession());
    }

    public String getSession(String key, String defaultValue) {
        m16063a();
        SapiAccount session = getSession();
        if (!m16064a(key) || !isLogin() || session == null) {
            return defaultValue;
        }
        JSONObject sessionData = session.toJSONObject();
        if (sessionData != null) {
            return sessionData.optString(key, defaultValue);
        }
        return defaultValue;
    }

    public String getSession(String key) {
        m16063a();
        return getSession(key, null);
    }

    public SapiAccount getSession() {
        m16063a();
        return C4891b.m16250a(f20022b.context).m16278d();
    }

    public boolean validate(SapiAccount sapiAccount) {
        m16063a();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        C4908a.m16342a().m16350a(sapiAccount);
        return true;
    }

    public List<SapiAccount> getShareAccounts() {
        m16063a();
        List<SapiAccount> validAccounts = new ArrayList();
        if (f20022b.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            for (SapiAccount account : C4891b.m16250a(f20022b.context).m16281e()) {
                if (SapiUtils.isValidAccount(account)) {
                    validAccounts.add(account);
                } else {
                    C4891b.m16250a(f20022b.context).m16279d(account);
                }
            }
            Collections.reverse(validAccounts);
        }
        return validAccounts;
    }

    public void removeLoginAccount(SapiAccount account) {
        m16063a();
        C4891b.m16250a(f20022b.context).m16282e(account);
    }

    public List<SapiAccount> getLoginAccounts() {
        m16063a();
        return C4891b.m16250a(f20022b.context).m16284f();
    }

    /* renamed from: a */
    boolean m16064a(String sessionKey) {
        return !TextUtils.isEmpty(sessionKey) && f20027g.contains(sessionKey);
    }

    /* renamed from: a */
    void m16063a() {
        if (f20022b == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
        }
    }

    public static void registerSilentShareListener(SilentShareListener listener) {
        f20024d = listener;
    }

    public static void unregisterSilentShareListener() {
        f20024d = null;
    }

    public static SilentShareListener getSilentShareListener() {
        return f20024d;
    }

    public static void registerReceiveShareListener(ReceiveShareListener listener) {
        f20025e = listener;
    }

    public static void unregisterReceiveShareListener() {
        f20025e = null;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return f20025e;
    }

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener listener) {
        f20026f = listener;
    }

    public static void unregisterGlobalAuthorizationListener() {
        f20026f = null;
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return f20026f;
    }

    @TargetApi(3)
    /* renamed from: a */
    static String m16059a(Context context) {
        try {
            int pid = Process.myPid();
            for (RunningAppProcessInfo appProcess : ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses()) {
                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return "";
    }

    /* renamed from: b */
    static String m16061b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable e) {
            C4913L.m16374e(e);
            return "";
        }
    }

    /* renamed from: c */
    static boolean m16062c(Context context) {
        String curProcessName = m16059a(context);
        String appProcessName = m16061b(context);
        return TextUtils.isEmpty(curProcessName) || TextUtils.isEmpty(appProcessName) || curProcessName.equals(appProcessName);
    }
}
