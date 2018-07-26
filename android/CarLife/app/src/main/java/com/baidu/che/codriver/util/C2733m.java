package com.baidu.che.codriver.util;

import com.baidu.che.codriver.vr.C2847o;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SwitcherManager */
/* renamed from: com.baidu.che.codriver.util.m */
public class C2733m {
    /* renamed from: a */
    private static final String f8946a = "SwitcherManager";
    /* renamed from: b */
    private static final String f8947b = "nlpswitch";
    /* renamed from: c */
    private boolean f8948c = false;
    /* renamed from: d */
    private boolean f8949d = false;
    /* renamed from: e */
    private boolean f8950e = false;
    /* renamed from: f */
    private Map<String, Integer> f8951f = new HashMap();

    /* compiled from: SwitcherManager */
    /* renamed from: com.baidu.che.codriver.util.m$a */
    private static class C2732a {
        /* renamed from: a */
        private static C2733m f8945a = new C2733m();

        private C2732a() {
        }
    }

    /* renamed from: a */
    public static C2733m m10233a() {
        return C2732a.f8945a;
    }

    /* renamed from: a */
    public void m10236a(boolean useNlu) {
        C2725h.m10207b(f8946a, "setUseNlu useNlu=" + useNlu);
        if (useNlu != this.f8950e) {
            this.f8950e = useNlu;
            C2847o.m10687a().m10745b(useNlu);
        }
    }

    /* renamed from: b */
    public boolean m10237b() {
        return this.f8950e;
    }

    /* renamed from: c */
    public void m10238c() {
    }

    /* renamed from: a */
    private void m10234a(JsonObject data) {
        try {
            JsonArray jsonArray = data.getAsJsonArray("switch");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject json = jsonArray.get(i).getAsJsonObject();
                this.f8951f.put(json.get("func").getAsString(), Integer.valueOf(json.get("status").getAsInt()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m10235d() {
        if (this.f8951f.get(f8947b) == null || ((Integer) this.f8951f.get(f8947b)).intValue() != 0) {
            m10236a(true);
        } else {
            m10236a(false);
        }
    }
}
