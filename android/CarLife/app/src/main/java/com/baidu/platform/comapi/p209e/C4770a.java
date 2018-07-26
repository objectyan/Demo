package com.baidu.platform.comapi.p209e;

import com.baidu.platform.comapi.p132b.C2905c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserdataCollect */
/* renamed from: com.baidu.platform.comapi.e.a */
public class C4770a {
    /* renamed from: a */
    public static C4770a f19806a = null;
    /* renamed from: b */
    private static JSONObject f19807b = null;
    /* renamed from: c */
    private C2905c f19808c = null;

    /* renamed from: a */
    public static C4770a m15846a() {
        if (f19806a == null) {
            f19806a = new C4770a();
        }
        if (f19807b == null) {
            f19807b = new JSONObject();
        }
        return f19806a;
    }

    /* renamed from: a */
    public synchronized void m15850a(String action, Map<String, String> args) {
        JSONObject jsonObject = new JSONObject();
        if (args != null) {
            for (String key : args.keySet()) {
                try {
                    jsonObject.put(key, args.get(key));
                } catch (JSONException e) {
                }
            }
        }
        m15852a(action, jsonObject);
    }

    /* renamed from: a */
    public synchronized void m15849a(String key, String value) {
        if (f19807b != null) {
            try {
                f19807b.put(key, value);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: a */
    public synchronized void m15848a(String key, int value) {
        if (f19807b != null) {
            try {
                f19807b.put(key, Integer.toString(value));
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m15851a(String strAction) {
        boolean bSucceed;
        if (this.f19808c == null) {
            this.f19808c = C2905c.a();
        }
        bSucceed = false;
        if (this.f19808c != null) {
            if (f19807b == null || f19807b.length() <= 0) {
                bSucceed = this.f19808c.a(1100, 1, strAction, null);
            } else {
                bSucceed = this.f19808c.a(1100, 1, strAction, f19807b.toString());
            }
            m15847b();
        }
        return bSucceed;
    }

    /* renamed from: a */
    public synchronized boolean m15852a(String strAction, JSONObject jsonObject) {
        boolean bSucceed;
        if (this.f19808c == null) {
            this.f19808c = C2905c.a();
        }
        bSucceed = false;
        if (this.f19808c != null) {
            if (jsonObject == null || jsonObject.length() <= 0) {
                bSucceed = this.f19808c.a(1100, 1, strAction, null);
            } else {
                bSucceed = this.f19808c.a(1100, 1, strAction, jsonObject.toString());
            }
        }
        return bSucceed;
    }

    /* renamed from: b */
    public synchronized boolean m15853b(String strAction) {
        boolean bSucceed;
        if (this.f19808c == null) {
            this.f19808c = C2905c.a();
        }
        bSucceed = false;
        if (this.f19808c != null) {
            if (f19807b == null || f19807b.length() <= 0) {
                bSucceed = this.f19808c.a(1100, 2, strAction, null);
            } else {
                bSucceed = this.f19808c.a(1100, 2, strAction, f19807b.toString());
            }
            m15847b();
        }
        return bSucceed;
    }

    /* renamed from: b */
    private void m15847b() {
        f19807b = null;
        f19807b = new JSONObject();
    }
}
