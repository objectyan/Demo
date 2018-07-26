package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.sapi2.share.C4908a;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiContext */
/* renamed from: com.baidu.sapi2.b */
public final class C4891b {
    /* renamed from: a */
    private static final String f20405a = "app_version_code";
    /* renamed from: b */
    private static final String f20406b = "current_account";
    /* renamed from: c */
    private static final String f20407c = "share_accounts";
    /* renamed from: d */
    private static final String f20408d = "login_accounts";
    /* renamed from: e */
    private static final String f20409e = "first_install";
    /* renamed from: f */
    private static final String f20410f = "login_status_changed";
    /* renamed from: g */
    private static final String f20411g = "sapi_options";
    /* renamed from: h */
    private static final String f20412h = "relogin_credentials";
    /* renamed from: i */
    private static final String f20413i = "cuidtoken";
    /* renamed from: j */
    private static final String f20414j = "device_token";
    /* renamed from: k */
    private static final String f20415k = "device_login_available";
    /* renamed from: l */
    private static final String f20416l = "hosts_hijacked";
    /* renamed from: m */
    private static final String f20417m = "stat_items";
    /* renamed from: n */
    private static final String f20418n = "time_offset_seconds";
    /* renamed from: o */
    private static final String f20419o = "device_info_read_times";
    /* renamed from: p */
    private static final String f20420p = "root_status";
    /* renamed from: s */
    private static C4891b f20421s;
    /* renamed from: q */
    private SharedPreferences f20422q;
    /* renamed from: r */
    private Context f20423r;

    /* renamed from: a */
    public static C4891b m16250a(Context context) {
        synchronized (C4891b.class) {
            if (f20421s == null) {
                f20421s = new C4891b(context.getApplicationContext());
            }
        }
        return f20421s;
    }

    private C4891b(Context context) {
        this.f20423r = context;
        this.f20422q = context.getSharedPreferences("sapi_system", 0);
    }

    /* renamed from: a */
    private void m16253a(String key, String value) {
        if (VERSION.SDK_INT > 8) {
            this.f20422q.edit().putString(key, value).apply();
        } else {
            this.f20422q.edit().putString(key, value).commit();
        }
    }

    /* renamed from: a */
    private void m16251a(String key, int value) {
        if (VERSION.SDK_INT > 8) {
            this.f20422q.edit().putInt(key, value).apply();
        } else {
            this.f20422q.edit().putInt(key, value).commit();
        }
    }

    /* renamed from: a */
    private void m16252a(String key, long value) {
        if (VERSION.SDK_INT > 8) {
            this.f20422q.edit().putLong(key, value).apply();
        } else {
            this.f20422q.edit().putLong(key, value).commit();
        }
    }

    /* renamed from: a */
    private void m16254a(String key, boolean value) {
        if (VERSION.SDK_INT > 8) {
            this.f20422q.edit().putBoolean(key, value).apply();
        } else {
            this.f20422q.edit().putBoolean(key, value).commit();
        }
    }

    /* renamed from: f */
    private String m16260f(String key) {
        return this.f20422q.getString(key, "");
    }

    /* renamed from: b */
    private boolean m16259b(String key, boolean defValue) {
        return this.f20422q.getBoolean(key, defValue);
    }

    /* renamed from: b */
    private int m16256b(String key, int defValue) {
        return this.f20422q.getInt(key, defValue);
    }

    /* renamed from: b */
    private long m16257b(String key, long defValue) {
        return this.f20422q.getLong(key, defValue);
    }

    /* renamed from: a */
    public String m16262a() {
        return m16260f(f20414j);
    }

    /* renamed from: a */
    public void m16267a(String token) {
        m16253a(f20414j, token);
    }

    /* renamed from: b */
    public boolean m16274b() {
        return m16259b(f20415k, false);
    }

    /* renamed from: a */
    public void m16270a(boolean supportDeviceLogin) {
        m16254a(f20415k, supportDeviceLogin);
    }

    /* renamed from: c */
    public boolean m16277c() {
        return m16259b(f20416l, false);
    }

    /* renamed from: b */
    public void m16273b(boolean hostsHijacked) {
        m16254a(f20416l, hostsHijacked);
    }

    /* renamed from: a */
    public void m16265a(SapiAccount account) {
        if (account == null) {
            m16253a(f20406b, "");
            SapiUtils.webLogout(this.f20423r);
            return;
        }
        JSONObject jsonObject = account.toJSONObject();
        if (jsonObject != null) {
            m16253a(f20406b, jsonObject.toString());
            SapiUtils.webLogin(this.f20423r, account.bduss);
            if (!m16286h()) {
                m16261w();
            }
        }
    }

    /* renamed from: d */
    public SapiAccount m16278d() {
        SapiAccount sapiAccount = null;
        if (!TextUtils.isEmpty(m16260f(f20406b))) {
            try {
                sapiAccount = SapiAccount.fromJSONObject(new JSONObject(m16260f(f20406b)));
            } catch (JSONException e) {
            }
        }
        return sapiAccount;
    }

    /* renamed from: b */
    public void m16272b(SapiAccount account) {
        if (account != null) {
            List accounts = m16281e();
            if (accounts.contains(account)) {
                accounts.remove(accounts.indexOf(account));
                accounts.add(account);
            } else {
                accounts.add(account);
            }
            m16255a(m16263a(accounts, 5));
        }
    }

    /* renamed from: c */
    public void m16275c(SapiAccount account) {
        if (account != null) {
            List accounts = m16284f();
            if (accounts.contains(account)) {
                accounts.set(accounts.indexOf(account), account);
            } else {
                accounts.add(account);
            }
            m16258b(accounts);
        }
    }

    /* renamed from: d */
    public void m16279d(SapiAccount account) {
        if (account != null) {
            List accounts = m16281e();
            if (accounts.contains(account)) {
                accounts.remove(account);
                m16255a(accounts);
            }
        }
    }

    /* renamed from: e */
    public void m16282e(SapiAccount account) {
        if (account != null) {
            SapiAccount session = m16278d();
            if (!(session == null || TextUtils.isEmpty(account.uid) || !account.uid.equals(session.uid))) {
                m16265a(null);
                C4908a.m16342a().m16351b(account);
                if (SapiAccountManager.getGlobalAuthorizationListener() != null) {
                    try {
                        SapiAccountManager.getGlobalAuthorizationListener().onLogoutSuccess(account);
                    } catch (Throwable e) {
                        C4913L.m16374e(e);
                    }
                }
            }
            List accounts = m16284f();
            if (accounts.contains(account)) {
                accounts.remove(account);
                m16258b(accounts);
            }
        }
    }

    /* renamed from: e */
    public List<SapiAccount> m16281e() {
        if (TextUtils.isEmpty(m16260f(f20407c))) {
            return new ArrayList();
        }
        try {
            return m16263a(SapiAccount.fromJSONArray(new JSONArray(m16260f(f20407c))), 5);
        } catch (Throwable th) {
            return new ArrayList();
        }
    }

    /* renamed from: f */
    public List<SapiAccount> m16284f() {
        if (TextUtils.isEmpty(m16260f(f20408d))) {
            return new ArrayList();
        }
        try {
            return SapiAccount.fromJSONArray(new JSONArray(m16260f(f20408d)));
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    /* renamed from: g */
    public boolean m16285g() {
        if (!m16259b(f20409e, true)) {
            return false;
        }
        m16254a(f20409e, false);
        return true;
    }

    /* renamed from: h */
    public boolean m16286h() {
        return m16259b(f20410f, false);
    }

    /* renamed from: w */
    private void m16261w() {
        m16254a(f20410f, true);
    }

    /* renamed from: i */
    public void m16287i() {
        m16254a(f20410f, false);
    }

    /* renamed from: a */
    private void m16255a(List<SapiAccount> accounts) {
        JSONArray jsonArray = SapiAccount.toJSONArray(accounts);
        if (jsonArray != null) {
            m16253a(f20407c, jsonArray.toString());
        }
    }

    /* renamed from: b */
    private void m16258b(List<SapiAccount> accounts) {
        JSONArray jsonArray = SapiAccount.toJSONArray(accounts);
        if (jsonArray != null) {
            m16253a(f20408d, jsonArray.toString());
        }
    }

    /* renamed from: j */
    public C4894c m16288j() {
        String options = m16260f(f20411g);
        if (!TextUtils.isEmpty(options)) {
            try {
                return C4894c.m16310a(new JSONObject(options));
            } catch (JSONException e) {
            }
        }
        return new C4894c();
    }

    /* renamed from: a */
    public void m16266a(C4894c options) {
        if (options != null) {
            m16253a(f20411g, options.m16320g());
        }
    }

    /* renamed from: k */
    public Map<String, String> m16289k() {
        return m16288j().m16317d();
    }

    /* renamed from: l */
    public List<String> m16290l() {
        return m16288j().m16318e();
    }

    /* renamed from: m */
    public String m16291m() {
        return m16288j().m16314a();
    }

    /* renamed from: n */
    public Map<String, Integer> m16292n() {
        m16288j();
        return C4894c.m16312i();
    }

    /* renamed from: a */
    public void m16268a(String uid, SapiAccount$ReloginCredentials credentials) {
        if (!TextUtils.isEmpty(uid) && credentials != null && !TextUtils.isEmpty(credentials.account) && !TextUtils.isEmpty(credentials.password) && !TextUtils.isEmpty(credentials.ubi) && !TextUtils.isEmpty(credentials.accountType)) {
            m16276c(credentials.ubi);
            JSONObject obj = m16293o();
            if (obj == null) {
                obj = new JSONObject();
            }
            try {
                obj.put(uid, credentials.toJSONObject());
                m16253a(f20412h, obj.toString());
            } catch (JSONException e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: b */
    public SapiAccount$ReloginCredentials m16271b(String uid) {
        JSONObject credentialsJSON = m16293o();
        if (credentialsJSON != null) {
            JSONObject obj = credentialsJSON.optJSONObject(uid);
            if (obj != null) {
                SapiAccount$ReloginCredentials credentials = SapiAccount$ReloginCredentials.fromJSONObject(obj);
                credentials.ubi = m16294p();
                return credentials;
            }
        }
        return new SapiAccount$ReloginCredentials();
    }

    /* renamed from: o */
    public JSONObject m16293o() {
        String credentials = m16260f(f20412h);
        if (!TextUtils.isEmpty(credentials)) {
            try {
                return new JSONObject(credentials);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    /* renamed from: c */
    void m16276c(String ubi) {
        m16253a(f20413i, ubi);
    }

    /* renamed from: p */
    String m16294p() {
        return m16260f(f20413i);
    }

    /* renamed from: a */
    public void m16269a(String name, Map<String, String> extras) {
        if (!TextUtils.isEmpty(name)) {
            if (extras == null) {
                extras = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> items = m16295q();
                items.put(name, extras);
                JSONObject obj = new JSONObject();
                for (Entry<String, Map<String, String>> item : items.entrySet()) {
                    obj.put((String) item.getKey(), new JSONObject((Map) item.getValue()));
                }
                m16253a(f20417m, obj.toString());
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: d */
    public void m16280d(String name) {
        if (!TextUtils.isEmpty(name)) {
            try {
                Map<String, Map<String, String>> items = m16295q();
                if (items.containsKey(name)) {
                    items.remove(name);
                }
                m16253a(f20417m, new JSONObject(items).toString());
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: q */
    public Map<String, Map<String, String>> m16295q() {
        Map<String, Map<String, String>> items = new HashMap();
        String itemsJSON = m16260f(f20417m);
        if (!TextUtils.isEmpty(itemsJSON)) {
            try {
                JSONObject itemsObj = new JSONObject(itemsJSON);
                Iterator itemsIterator = itemsObj.keys();
                while (itemsIterator.hasNext()) {
                    String itemName = (String) itemsIterator.next();
                    Map<String, String> extras = new HashMap();
                    JSONObject extrasObj = itemsObj.optJSONObject(itemName);
                    if (extrasObj != null) {
                        Iterator extrasIterator = extrasObj.keys();
                        while (extrasIterator.hasNext()) {
                            String extraName = (String) extrasIterator.next();
                            String extraValue = extrasObj.optString(extraName);
                            if (!(TextUtils.isEmpty(extraName) || TextUtils.isEmpty(extraValue))) {
                                extras.put(extraName, extraValue);
                            }
                        }
                    }
                    items.put(itemName, extras);
                }
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
        return items;
    }

    /* renamed from: r */
    public int m16296r() {
        return m16256b(f20418n, 0);
    }

    /* renamed from: s */
    public long m16297s() {
        return (System.currentTimeMillis() / 1000) + ((long) m16296r());
    }

    /* renamed from: t */
    public int m16298t() {
        return m16256b("app_version_code", 0);
    }

    /* renamed from: a */
    public void m16264a(int versionCode) {
        m16251a("app_version_code", versionCode);
    }

    /* renamed from: u */
    public long m16299u() {
        long usedTimes = m16257b(f20419o, 0) + 1;
        m16252a(f20419o, usedTimes);
        return usedTimes;
    }

    /* renamed from: e */
    public void m16283e(String isRoot) {
        m16253a(f20420p, isRoot);
    }

    /* renamed from: v */
    public String m16300v() {
        return m16260f(f20420p);
    }

    /* renamed from: a */
    <T> List<T> m16263a(List<T> elements, int size) {
        return (elements == null || size < 0 || size >= elements.size()) ? elements : elements.subList(elements.size() - size, elements.size());
    }
}
