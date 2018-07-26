package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2746e;
import com.baidu.che.codriver.vr.C2848p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseVoiceCommand */
/* renamed from: com.baidu.che.codriver.vr.a.a */
public abstract class C2747a implements C2746e {
    /* renamed from: a */
    public static final String f9028a = "CoDriverVoice";
    /* renamed from: b */
    protected C2848p f9029b = null;
    /* renamed from: c */
    protected C2673m f9030c;
    /* renamed from: d */
    protected Context f9031d;

    /* renamed from: h */
    public abstract void mo1957h();

    /* renamed from: j */
    protected abstract void mo1958j();

    public C2747a(C2848p data, C2673m callback, Context context) {
        this.f9029b = data;
        this.f9030c = callback;
        this.f9031d = context;
        mo1958j();
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
    }

    /* renamed from: i */
    protected void mo1960i() {
        C2549b model = new C2549b();
        model.f8465g = this.f9031d.getString(C0965R.string.common_command_cancel);
        this.f9030c.mo1928a(model);
        m10413q();
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }

    /* renamed from: l */
    protected void m10408l() {
        JSONObject result = new JSONObject();
        try {
            result.put("domain", mo1953d());
            result.put("intent", mo1954e());
            JSONObject paramJson = mo1961k();
            result.putOpt("object", paramJson);
            if (paramJson != null) {
                this.f9029b.m10788c(paramJson.toString());
            }
        } catch (JSONException e) {
            C2725h.m10214e(f9028a, "---createJsonResult--ERROR---");
            e.printStackTrace();
        }
        this.f9029b.m10792e(result.toString());
        C2725h.m10207b(f9028a, "------updateJsonResult:" + result.toString());
    }

    /* renamed from: a */
    protected static int m10395a(String option, int listLen) {
        int i = -1;
        if (TextUtils.isEmpty(option)) {
            return i;
        }
        try {
            i = Integer.parseInt(option);
            if (i > 0) {
                return i - 1;
            }
            if (i != 0) {
                return i + listLen;
            }
            return i;
        } catch (NumberFormatException e) {
            return i;
        }
    }

    /* renamed from: m */
    public String m10409m() {
        if (this.f9029b != null) {
            return this.f9029b.m10796h();
        }
        return null;
    }

    /* renamed from: c */
    public String mo1952c() {
        if (this.f9029b != null) {
            return this.f9029b.m10795g();
        }
        return null;
    }

    /* renamed from: d */
    public String mo1953d() {
        if (this.f9029b == null) {
            return null;
        }
        return this.f9029b.m10785b();
    }

    /* renamed from: e */
    public String mo1954e() {
        if (this.f9029b == null) {
            return null;
        }
        return this.f9029b.m10787c();
    }

    /* renamed from: f */
    public String mo1955f() {
        if (this.f9029b == null) {
            return null;
        }
        return this.f9029b.m10791e();
    }

    /* renamed from: g */
    public String mo1956g() {
        if (this.f9029b == null) {
            return null;
        }
        return this.f9029b.m10789d();
    }

    /* renamed from: b */
    public static boolean m10396b(C2747a command) {
        if (command != null && C2848p.f9315p.equals(command.mo1953d()) && C2848p.f9278E.equals(command.mo1954e())) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public boolean m10410n() {
        if (C2848p.f9315p.equals(mo1953d()) && C2848p.f9295V.equals(mo1954e())) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public boolean m10411o() {
        if (C2848p.f9315p.equals(mo1953d()) && C2848p.f9294U.equals(mo1954e())) {
            return true;
        }
        return false;
    }

    /* renamed from: p */
    public boolean m10412p() {
        return C2761c.m10463a().m10481f();
    }

    /* renamed from: a */
    public void mo1965a(View view) {
        this.f9030c.mo1926a(view);
        C2761c.m10463a().m10479d(this);
    }

    /* renamed from: q */
    public void m10413q() {
        this.f9030c.mo1944p();
        C2761c.m10463a().m10482g();
    }
}
