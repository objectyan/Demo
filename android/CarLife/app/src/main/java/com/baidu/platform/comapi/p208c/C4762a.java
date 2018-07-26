package com.baidu.platform.comapi.p208c;

import com.baidu.mapframework.commonlib.http.DNSProxy;
import com.baidu.platform.comjni.engine.NAEngine;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DNSProxyManager */
/* renamed from: com.baidu.platform.comapi.c.a */
public class C4762a implements DNSProxy {
    /* renamed from: a */
    private Map<String, Set<String>> f19792a;

    /* compiled from: DNSProxyManager */
    /* renamed from: com.baidu.platform.comapi.c.a$a */
    private static class C4761a {
        /* renamed from: a */
        private static final C4762a f19791a = new C4762a();

        private C4761a() {
        }
    }

    private C4762a() {
        this.f19792a = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public static C4762a m15826a() {
        return C4761a.f19791a;
    }

    /* renamed from: b */
    public void m15827b() {
        this.f19792a.clear();
    }

    public void putIP2DomainsRecord(String ip, String domain) {
        Set<String> hosts = (Set) this.f19792a.get(ip);
        if (hosts == null) {
            hosts = new HashSet();
            this.f19792a.put(ip, hosts);
        }
        hosts.add(domain);
    }

    public String getIP(String domain) {
        try {
            return NAEngine.getIP(domain);
        } catch (Exception e) {
            return null;
        }
    }

    public Set<String> getDomains(String ip) {
        return (Set) this.f19792a.get(ip);
    }
}
