package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.platform.PlatformUtils;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2746e;
import com.baidu.che.codriver.vr.C2820j.C2758a;
import com.baidu.che.codriver.vr.C2847o;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommandManager */
/* renamed from: com.baidu.che.codriver.vr.a.c */
public class C2761c {
    /* renamed from: a */
    private static final String f9070a = "CoDriverVoice-CommandManager";
    /* renamed from: b */
    private static final Object f9071b = new Object();
    /* renamed from: c */
    private static C2761c f9072c;
    /* renamed from: d */
    private C2747a f9073d;
    /* renamed from: e */
    private C2747a f9074e;
    /* renamed from: f */
    private boolean f9075f;

    private C2761c() {
    }

    /* renamed from: a */
    public static C2761c m10463a() {
        if (f9072c == null) {
            synchronized (f9071b) {
                if (f9072c == null) {
                    f9072c = new C2761c();
                }
            }
        }
        return f9072c;
    }

    /* renamed from: b */
    public C2747a m10474b() {
        return this.f9074e;
    }

    /* renamed from: a */
    public void m10467a(C2747a command) {
        this.f9074e = command;
    }

    /* renamed from: b */
    public void m10475b(C2747a command) {
        this.f9073d = command;
    }

    /* renamed from: c */
    public C2747a m10476c() {
        return this.f9073d;
    }

    /* renamed from: c */
    public void m10477c(C2747a command) {
        this.f9073d.mo1959a(command);
    }

    /* renamed from: d */
    public void m10478d() {
        m10475b(null);
        C2725h.m10207b(f9070a, "-----quitMultiInteraction---");
    }

    /* renamed from: e */
    public boolean m10480e() {
        return this.f9073d != null;
    }

    /* renamed from: f */
    public boolean m10481f() {
        return this.f9075f;
    }

    /* renamed from: d */
    public void m10479d(C2747a command) {
        m10475b(command);
        this.f9075f = true;
    }

    /* renamed from: g */
    public void m10482g() {
        m10478d();
        this.f9075f = false;
    }

    /* renamed from: h */
    public void m10483h() {
        m10482g();
        this.f9074e = null;
    }

    /* renamed from: a */
    public C2747a m10466a(C2848p model, C2673m callback, Context context) {
        if (model == null) {
            return new C2782q(model, callback, context);
        }
        C2725h.m10207b(f9070a, "----createCommand-domain:" + model.m10785b());
        C2725h.m10207b(f9070a, "----createCommand-intent:" + model.m10787c());
        if (model.m10781a() != 0) {
            return new C2762d(model, callback, context);
        }
        if (m10480e() && C2848p.al.equals(this.f9073d.mo1954e())) {
            return new C2767h(model, callback, context);
        }
        if (m10481f()) {
            if (C2848p.f9315p.equals(model.m10785b()) && (C2848p.f9278E.equals(model.m10787c()) || C2848p.f9295V.equals(model.m10787c()) || C2848p.f9294U.equals(model.m10787c()) || C2848p.f9292S.equals(model.m10787c()) || C2848p.f9291R.equals(model.m10787c()) || "quit".equals(model.m10787c()))) {
                return new C2767h(model, callback, context);
            }
            m10482g();
        }
        if (!((callback.mo1945s() != C2837c.STATE_SET_HOME && callback.mo1945s() != C2837c.STATE_SET_COMPANY) || "poi".equals(model.m10787c()) || C2848p.f9278E.equals(model.m10787c()) || "other".equals(model.m10787c()) || C2848p.f9295V.equals(model.m10787c()) || C2848p.f9294U.equals(model.m10787c()))) {
            C2761c.m10463a().m10478d();
            callback.mo1930a(C2837c.STATE_NORMAL);
        }
        if ("telephone".equals(model.m10785b())) {
            return new C2790v(model, callback, context);
        }
        if ("other".equals(model.m10785b())) {
            return new C2773l(model, callback, context);
        }
        if ("music".equals(model.m10785b())) {
            return new C2771k(model, callback, context);
        }
        if ("player".equals(model.m10785b())) {
            boolean flag = false;
            try {
                flag = new JSONObject(model.m10789d()).has(UpdateDeviceStatusDataStruct.KEY_DEVICE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (C2848p.af.equals(model.m10787c()) && flag) {
                return new C2782q(model, callback, context);
            }
            return new C2800w(model, callback, context);
        } else if ("map".equals(model.m10785b()) && "nearby".equals(model.m10787c())) {
            return new C2781p(model, callback, context);
        } else {
            if ("map".equals(model.m10785b()) && ("route".equals(model.m10787c()) || "poi".equals(model.m10787c()))) {
                return new C2807y(model, callback, context);
            }
            if (!"navigate_instruction".equals(model.m10785b())) {
                if (C2848p.f9315p.equals(model.m10785b())) {
                    if (C2848p.f9278E.equals(model.m10787c()) || C2848p.f9295V.equals(model.m10787c()) || C2848p.f9294U.equals(model.m10787c()) || C2848p.f9292S.equals(model.m10787c()) || C2848p.f9291R.equals(model.m10787c()) || "quit".equals(model.m10787c())) {
                        return new C2767h(model, callback, context);
                    }
                    if (C2848p.f9296W.equals(model.m10787c()) || C2848p.f9297X.equals(model.m10787c())) {
                        return new ae(model, callback, context);
                    }
                    if (C2848p.f9298Y.equals(model.m10787c())) {
                        return new C2783r(model, callback, context);
                    }
                    if ("login".equals(model.m10787c())) {
                        return new C2786t(model, callback, context);
                    }
                    if (C2848p.aj.equals(model.m10787c())) {
                        return new C2768i(model, callback, context, false);
                    }
                    if ("download".equals(model.m10787c()) || "sync".equals(model.m10787c())) {
                        return new C2786t(model, callback, context);
                    }
                    String intent = model.m10787c();
                    if (!(TextUtils.isEmpty(intent) || intent.startsWith("dr_"))) {
                        return new C2811z(model, callback, context);
                    }
                } else if ("app".equals(model.m10785b())) {
                    if (model.m10789d().contains(C2736p.f8976f)) {
                        return new C2780o(model, callback, context);
                    }
                    return new C2811z(model, callback, context);
                } else if ("app".equals(model.m10785b())) {
                    return new C2811z(model, callback, context);
                } else {
                    if (C2848p.f9309j.equals(model.m10785b())) {
                        return new C2757b(model, callback, context);
                    }
                    if (C2848p.f9319t.equals(model.m10785b())) {
                        return new C2773l(model, callback, context);
                    }
                    if ("flight".equals(model.m10785b())) {
                        return new C2773l(model, callback, context);
                    }
                    if (C2848p.f9320u.equals(model.m10785b())) {
                        return new C2773l(model, callback, context);
                    }
                    if ("wechat".equals(model.m10785b())) {
                        return new af(model, callback, context);
                    }
                    if (C2848p.f9324y.equals(model.m10785b())) {
                        return new C2803x(model, callback, context);
                    }
                    if ("radio".equals(model.m10785b())) {
                        return new C2803x(model, callback, context);
                    }
                    if (C2848p.f9316q.equals(model.m10785b())) {
                        return new C2786t(model, callback, context);
                    }
                }
                if (TextUtils.isEmpty(model.m10785b())) {
                    return new C2782q(model, callback, context);
                }
                return new C2811z(model, callback, context);
            } else if ("set_home".equals(model.m10787c()) || "set_work".equals(model.m10787c()) || "route_home".equals(model.m10787c()) || "route_work".equals(model.m10787c())) {
                return new C2776m(model, callback, context);
            } else {
                return new C2779n(model, callback, context);
            }
        }
    }

    /* renamed from: a */
    public C2747a m10465a(NLPResponseData data, C2673m callback, Context context) {
        Result result = C2704g.m10120a(data);
        if (result == null) {
            return new C2782q(null, callback, context);
        }
        C2725h.m10207b(f9070a, "----createNLPCommand-cardType:" + result.cardType);
        if (m10480e() && C2848p.al.equals(this.f9073d.mo1954e())) {
            return new C2767h(data, callback, context);
        }
        if (result.cardType.equals(C2704g.f8856o)) {
            return new ac(data, callback, context);
        }
        if (result.cardType.equals(C2704g.f8847f)) {
            return new C2765f(data, callback, context);
        }
        if (result.cardType.equals(C2704g.f8850i)) {
            return new C2773l(data, callback, context);
        }
        if (result.cardType.equals("flight")) {
            return new C2773l(data, callback, context);
        }
        if (result.cardType.equals(C2704g.f8851j)) {
            return new aa(data, callback, context);
        }
        if (result.cardType.equals(C2704g.f8849h)) {
            return new C2773l(data, callback, context);
        }
        return new C2773l(data, callback, context);
    }

    /* renamed from: a */
    public void m10468a(String query, C2673m callback, Context context) {
        m10469a(query, callback, context, null);
    }

    /* renamed from: a */
    public void m10469a(String query, final C2673m callback, final Context context, Map<String, Map> map) {
        C2847o.m10687a().m10736a((Map) map, query, new C2758a(this) {
            /* renamed from: c */
            final /* synthetic */ C2761c f9067c;

            /* renamed from: a */
            public void mo1968a(String rawText) {
                C2725h.m10207b(C2761c.f9070a, "Nlp onParseRawText: rawText=" + rawText);
            }

            /* renamed from: a */
            public void mo1967a(C2848p resultModel) {
                C2725h.m10207b(C2761c.f9070a, "Nlp onParseNormalResult: " + (resultModel != null ? resultModel.toString() : "null"));
                this.f9067c.m10466a(resultModel, callback, context).mo1957h();
            }

            /* renamed from: a */
            public void mo1966a(NLPResponseData nlpResponseData) {
                C2725h.m10207b(C2761c.f9070a, "Nlp onParseComplexResult: " + (nlpResponseData != null ? nlpResponseData.toString() : "null"));
                this.f9067c.m10465a(nlpResponseData, callback, context).mo1957h();
            }
        });
    }

    /* renamed from: b */
    private C2746e m10464b(String domain, String intent, Pair<String, String>... params) {
        final C2848p model = new C2848p();
        model.m10784a(domain);
        model.m10786b(intent);
        model.m10783a(0);
        model.m10782a(1.0f);
        JSONObject object = new JSONObject();
        if (params != null) {
            int length = params.length;
            int i = 0;
            while (i < length) {
                Pair<String, String> pair = params[i];
                try {
                    object.putOpt((String) pair.first, pair.second);
                    i++;
                } catch (JSONException e) {
                    return null;
                }
            }
        }
        model.m10788c(object.toString());
        JSONObject commandJson = new JSONObject();
        try {
            commandJson.put("domain", domain);
            commandJson.put("intent", intent);
            commandJson.putOpt("object", object);
        } catch (JSONException e2) {
            C2725h.m10207b(f9070a, "---createJsonResult--ERROR---");
            e2.printStackTrace();
        }
        model.m10792e(commandJson.toString());
        return new C2746e(this) {
            /* renamed from: b */
            final /* synthetic */ C2761c f9069b;

            /* renamed from: c */
            public String mo1952c() {
                return model.m10795g();
            }

            /* renamed from: d */
            public String mo1953d() {
                return model.m10785b();
            }

            /* renamed from: e */
            public String mo1954e() {
                return model.m10787c();
            }

            /* renamed from: f */
            public String mo1955f() {
                return model.m10791e();
            }

            /* renamed from: g */
            public String mo1956g() {
                return model.m10789d();
            }
        };
    }

    /* renamed from: a */
    public boolean m10473a(String domain, String intent, Pair<String, String>... params) {
        return m10471a(m10464b(domain, intent, params));
    }

    /* renamed from: a */
    public boolean m10471a(C2746e command) {
        if (command == null) {
            return false;
        }
        int cmdType = PlatformUtils.getCommandType(command);
        C2725h.m10207b(f9070a, "####### handlePlatformCommand cmdType: " + command.mo1952c());
        return m10472a(command, Boolean.valueOf(true));
    }

    /* renamed from: a */
    public boolean m10470a(int cmdType, String cmdResult, Boolean needLaunchApp) {
        return PlatformManager.getInstance().handleCommand(cmdType, cmdResult, needLaunchApp);
    }

    /* renamed from: a */
    public boolean m10472a(C2746e command, Boolean needLaunchApp) {
        C2725h.m10207b(f9070a, "####### handlePlatformCommand ICommand cmdResult: " + command.mo1952c());
        return PlatformManager.getInstance().handleCommand(command, needLaunchApp);
    }
}
