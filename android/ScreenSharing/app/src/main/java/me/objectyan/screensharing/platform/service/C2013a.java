package com.baidu.carlife.platform.service;

import android.text.TextUtils;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.platform.communication.C2002b;
import com.baidu.carlife.platform.communication.C2006c;
import com.baidu.carlife.platform.communication.C2006c.C2004b;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CLClientManager */
/* renamed from: com.baidu.carlife.platform.service.a */
public class C2013a implements C2004b {
    /* renamed from: a */
    private static C2013a f6513a = null;
    /* renamed from: b */
    private C2006c f6514b = C2006c.m7651a();
    /* renamed from: c */
    private ConcurrentHashMap<String, C2017c> f6515c = new ConcurrentHashMap();
    /* renamed from: d */
    private C2014b f6516d;

    private C2013a() {
        if (this.f6514b != null) {
            this.f6514b.m7658a((C2004b) this);
        }
    }

    /* renamed from: a */
    public static C2013a m7695a() {
        if (f6513a == null) {
            f6513a = new C2013a();
        }
        return f6513a;
    }

    /* renamed from: b */
    public C2014b m7697b() {
        if (this.f6516d == null) {
            this.f6516d = new C2014b();
        }
        return this.f6516d;
    }

    /* renamed from: b */
    public C2017c m7698b(String name) {
        C2017c client = new C2017c(name);
        this.f6515c.put(name, client);
        return client;
    }

    /* renamed from: c */
    public C2017c m7699c(String name) {
        return (C2017c) this.f6515c.get(name);
    }

    /* renamed from: c */
    public List<String> m7700c() {
        ArrayList<String> clients = new ArrayList();
        Enumeration<String> enumer = this.f6515c.keys();
        while (enumer.hasMoreElements()) {
            String client = (String) enumer.nextElement();
            if (!TextUtils.isEmpty(client)) {
                clients.add(client);
            }
        }
        return clients;
    }

    /* renamed from: d */
    public void m7702d(String name) {
        if (this.f6515c.containsKey(name)) {
            this.f6515c.remove(name);
            try {
                m7697b().mo1739b(name);
            } catch (Throwable e) {
                LogUtil.m4432a("PlatformManager", e);
            }
        }
    }

    /* renamed from: d */
    public void m7701d() {
        if (this.f6514b != null) {
            this.f6514b.m7659b();
        }
    }

    /* renamed from: a */
    public void mo1753a(String name) {
        if (this.f6514b != null) {
            C2002b socketClient = this.f6514b.m7657a(name);
            C2017c clsdkClient = (C2017c) this.f6515c.get(name);
            if (clsdkClient != null) {
                clsdkClient.m7718a(socketClient);
                try {
                    m7697b().mo1738a(name);
                } catch (Throwable e) {
                    LogUtil.m4432a("PlatformManager", e);
                }
            }
        }
    }
}
