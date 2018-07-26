package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6128j;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class ab implements Runnable {
    /* renamed from: a */
    private Context f24798a = null;
    /* renamed from: b */
    private Map<String, Integer> f24799b = null;
    /* renamed from: c */
    private C6161k f24800c = null;

    public ab(Context context, Map<String, Integer> map, C6161k c6161k) {
        this.f24798a = context;
        this.f24800c = c6161k;
        if (map != null) {
            this.f24799b = map;
        }
    }

    /* renamed from: a */
    private C6153c m21742a(String str, int i) {
        Throwable th;
        C6153c c6153c = new C6153c();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            c6153c.m21934a(str);
            c6153c.m21936b(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            c6153c.m21933a(System.currentTimeMillis() - currentTimeMillis);
            c6153c.m21937b(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                C6160j.f25104q.m21826b(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            C6160j.f25104q.m21826b(th2);
            socket.close();
        } catch (Throwable th22) {
            C6160j.f25104q.m21826b(th22);
        }
        c6153c.m21932a(i2);
        return c6153c;
    }

    /* renamed from: a */
    private Map<String, Integer> m21743a() {
        Map<String, Integer> hashMap = new HashMap();
        String b = C6156f.m21989b("__MTA_TEST_SPEED__", null);
        if (!(b == null || b.trim().length() == 0)) {
            for (String b2 : b2.split(";")) {
                String[] split = b2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            C6160j.f25104q.m21826b(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (this.f24799b == null) {
                this.f24799b = m21743a();
            }
            if (this.f24799b == null || this.f24799b.size() == 0) {
                C6160j.f25104q.m21825b((Object) "empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f24799b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    C6160j.f25104q.m21830f("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    C6160j.f25104q.m21830f("port is null for " + str);
                } else {
                    jSONArray.put(m21742a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).m21941f());
                }
            }
            if (jSONArray.length() != 0) {
                C6119e c6128j = new C6128j(this.f24798a, C6160j.m22090a(this.f24798a, false, this.f24800c), this.f24800c);
                c6128j.m21736a(jSONArray.toString());
                new ac(c6128j).m21751a();
            }
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
        }
    }
}
