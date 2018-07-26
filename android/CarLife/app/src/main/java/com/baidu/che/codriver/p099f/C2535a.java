package com.baidu.che.codriver.p099f;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.p118d.p119a.C2525a;
import com.baidu.che.codriver.p118d.p119a.C2528c;
import com.baidu.che.codriver.p123i.C2544a;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.stat.StatManager;
import com.baidu.che.codriver.util.C2715b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.C2840n;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RobokitRequest */
/* renamed from: com.baidu.che.codriver.f.a */
public class C2535a extends C2525a {
    /* renamed from: d */
    private static final HashMap<String, String> f8291d = new HashMap();
    /* renamed from: b */
    private C1840a f8292b;
    /* renamed from: c */
    private String f8293c;
    /* renamed from: e */
    private Map<String, Map> f8294e;

    /* compiled from: RobokitRequest */
    /* renamed from: com.baidu.che.codriver.f.a$a */
    public interface C1840a {
        /* renamed from: a */
        void mo1691a(String str);

        /* renamed from: b */
        void mo1692b(String str);
    }

    public C2535a(C1840a callback) {
        this.f8292b = callback;
    }

    @Deprecated
    /* renamed from: a */
    public void mo1876a() {
        m9619a(null);
    }

    /* renamed from: a */
    public void m9619a(String query) {
        if (query == null) {
            throw new IllegalArgumentException("query is null");
        }
        this.f8293c = query;
        super.mo1876a();
    }

    /* renamed from: b */
    public C2535a m9622b(Map<String, Map> map) {
        this.f8294e = map;
        return this;
    }

    /* renamed from: c */
    public String mo1879c() {
        return C2840n.m10678d();
    }

    /* renamed from: d */
    public Map<String, String> mo1880d() {
        Map<String, String> params = new HashMap();
        params.put("coordtype", "2");
        params.put("word", this.f8293c);
        params.put("crd", LocationUtil.getInstance().getLongitude() + JNISearchConst.LAYER_ID_DIVIDER + LocationUtil.getInstance().getLatitude());
        params.put("av", C2716c.m10165k());
        params.put("ak", C2544a.m9644b());
        params.put(NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, C2544a.m9642a());
        if (C2715b.m10137a().m10138b()) {
            params.put("BDUSS", C2715b.m10137a().m10139c().bduss);
        }
        String cuid = C2716c.m10168n();
        if (TextUtils.isEmpty(cuid)) {
            StatManager.getInstance().checkActivation(C2716c.m10141a());
            if (C2840n.m10672a()) {
                Toast.makeText(C2716c.m10141a(), "uuid is empty", 0).show();
            }
        } else {
            params.put("uuid", cuid);
        }
        params.put("pn", C2716c.m10157e());
        if (!TextUtils.isEmpty(C2716c.m10167m())) {
            params.put("ext", C2716c.m10167m());
        }
        if (!f8291d.isEmpty()) {
            params.putAll(f8291d);
        }
        params.put("sign", C2528c.m9587a(params, C2840n.m10679e(), C2840n.m10680f()));
        C2725h.m10207b(C1981b.f6367g, "params = " + params.toString());
        return params;
    }

    /* renamed from: a */
    public void mo1772a(String url, String errMsg) {
        this.f8292b.mo1691a(errMsg);
    }

    /* renamed from: a */
    public void mo1878a(String url, int statusCode, String response) {
        C2725h.m10207b(C1981b.f6367g, "response=" + response);
        if (statusCode == 200) {
            this.f8292b.mo1692b(response);
        } else {
            this.f8292b.mo1691a("statusCode=" + statusCode);
        }
    }

    /* renamed from: b */
    public static void m9617b(String key, String value) {
        C2725h.m10207b(C1981b.f6367g, "add OtherParams key = " + key + "; value = " + value);
        f8291d.put(key, value);
    }

    /* renamed from: b */
    public static void m9616b(String key) {
        C2725h.m10207b(C1981b.f6367g, "remove OtherParams key = " + key);
        f8291d.remove(key);
    }
}
