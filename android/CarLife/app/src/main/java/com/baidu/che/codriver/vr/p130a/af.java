package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p120e.C2529a;
import com.baidu.che.codriver.sdk.p081a.C2452p;
import com.baidu.che.codriver.sdk.p081a.C2580c;
import com.baidu.che.codriver.sdk.p126b.C2617a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2707i;
import com.baidu.che.codriver.ui.p124d.C2707i.C2706a;
import com.baidu.che.codriver.ui.p127a.C2657f.C2656a;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2848p;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WechatCommand */
/* renamed from: com.baidu.che.codriver.vr.a.af */
public class af extends C2747a {
    /* renamed from: f */
    private static int f9058f = 0;
    /* renamed from: e */
    private List<C2529a> f9059e;
    /* renamed from: g */
    private C2452p f9060g = C2580c.m9750a().m9755b();
    /* renamed from: h */
    private String f9061h;
    /* renamed from: i */
    private C2617a f9062i;
    /* renamed from: j */
    private C2756a f9063j = C2756a.STATE_DISABLE;
    /* renamed from: k */
    private C2656a f9064k = new C27511(this);

    /* compiled from: WechatCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.af$1 */
    class C27511 implements C2656a {
        /* renamed from: a */
        final /* synthetic */ af f9047a;

        C27511(af this$0) {
            this.f9047a = this$0;
        }

        /* renamed from: a */
        public void mo1963a(int position, C2529a data, C2706a uiType) {
            this.f9047a.c.mo1936d();
            this.f9047a.m10437a((C2617a) data);
        }
    }

    /* compiled from: WechatCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.af$2 */
    class C27532 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ af f9048a;

        C27532(af this$0) {
            this.f9048a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9048a.f9060g.mo1852c();
        }
    }

    /* compiled from: WechatCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.af$3 */
    class C27543 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ af f9049a;

        C27543(af this$0) {
            this.f9049a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9049a.m10413q();
            this.f9049a.f9060g.mo1849a(this.f9049a.f9062i, this.f9049a.f9061h);
        }
    }

    /* compiled from: WechatCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.af$a */
    public enum C2756a {
        STATE_DISABLE,
        STATE_ENABLE_NOT_LOGIN,
        STATE_ENABLE_LOGIN_NORMAL,
        STATE_ENABLE_LOGIN_NOT_EXIST_CONTACT,
        STATE_ENABLE_LOGIN_NORMAL_LISTENING,
        STATE_ENABLE_LOGIN_NORMAL_CONFIRMING
    }

    public af(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        if (this.f9060g == null || !this.f9060g.mo1851b()) {
            this.f9063j = C2756a.STATE_DISABLE;
        } else if (!this.f9060g.mo1850a()) {
            this.f9063j = C2756a.STATE_ENABLE_NOT_LOGIN;
        } else if (this.f9062i == null) {
            this.f9063j = C2756a.STATE_ENABLE_LOGIN_NOT_EXIST_CONTACT;
        } else if (C2848p.al.equals(mo1954e())) {
            this.f9063j = C2756a.STATE_ENABLE_LOGIN_NORMAL_LISTENING;
        } else {
            this.f9063j = C2756a.STATE_ENABLE_LOGIN_NORMAL;
        }
    }

    /* renamed from: j */
    protected void mo1958j() {
        try {
            JSONObject result = new JSONObject(mo1956g());
            if (result.isNull(C2848p.aQ)) {
                this.f9062i = null;
            } else {
                this.f9062i = new C2617a(result.optString(C2848p.aR, ""), result.optString(C2848p.aQ, ""));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    public void mo1957h() {
        switch (this.f9063j) {
            case STATE_DISABLE:
                m10436a();
                return;
            case STATE_ENABLE_NOT_LOGIN:
                m10441b();
                return;
            case STATE_ENABLE_LOGIN_NORMAL:
                m10439a(this.f9062i.m9591a());
                return;
            case STATE_ENABLE_LOGIN_NOT_EXIST_CONTACT:
                m10443r();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo1965a(View view) {
        this.f9063j = C2756a.STATE_ENABLE_LOGIN_NORMAL_CONFIRMING;
        super.mo1965a(view);
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        C2549b model;
        if (this.f9063j == C2756a.STATE_ENABLE_LOGIN_NORMAL_LISTENING) {
            this.f9061h = newCommand.mo1955f();
            mo1965a(null);
            model = new C2549b();
            model.f8465g = this.d.getString(C0965R.string.wechat_command_send_confirm, new Object[]{this.f9062i.m9591a()});
            model.f8468j = 1;
            this.c.mo1928a(model);
        } else if (this.f9063j == C2756a.STATE_ENABLE_LOGIN_NORMAL_CONFIRMING) {
            if (C2848p.f9291R.equals(newCommand.mo1954e())) {
                m10444s();
            } else if (C2848p.f9292S.equals(newCommand.mo1954e())) {
                mo1960i();
            }
        } else if (C2848p.f9278E.equals(newCommand.mo1954e())) {
            try {
                m10437a((C2617a) this.f9059e.get(C2747a.m10395a(new JSONObject(newCommand.mo1956g()).optString("option"), this.f9059e.size())));
            } catch (JSONException e) {
                model = new C2549b();
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8467i = 5;
                this.c.mo1928a(model);
            } catch (IndexOutOfBoundsException e2) {
                this.c.mo1928a(new C2707i(this.d.getString(C0965R.string.phone_command_say_right_index), 1));
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    private void m10436a() {
        C2848p fakeWechatResult = this.b;
        fakeWechatResult.m10784a("other");
        C2761c.m10463a().m10466a(fakeWechatResult, this.c, this.d).mo1957h();
    }

    /* renamed from: b */
    private void m10441b() {
        C2549b model = new C2549b();
        model.f8465g = this.d.getString(C0965R.string.wechat_command_hint_need_login);
        model.f8468j = 2;
        this.c.mo1929a(model, new C27532(this), null);
    }

    /* renamed from: a */
    private void m10437a(C2617a finalContact) {
        this.f9063j = C2756a.STATE_ENABLE_LOGIN_NORMAL_LISTENING;
        this.c.mo1930a(C2837c.STATE_WECHAT_RECEIVE_CONTENT);
        this.b.m10786b(C2848p.al);
        this.f9062i = finalContact;
        C2761c.m10463a().m10475b(this);
        C2549b model = new C2549b();
        model.f8465g = this.d.getString(C0965R.string.wechat_command_please_say_content);
        model.f8468j = 1;
        this.c.mo1928a(model);
    }

    /* renamed from: a */
    private void m10439a(String similarName) {
        List<C2529a> list = this.f9060g.mo1848a(similarName);
        if (list == null || list.isEmpty()) {
            int i = f9058f + 1;
            f9058f = i;
            if (i >= 2) {
                f9058f = 0;
                this.c.mo1928a(new C2707i(this.d.getString(C0965R.string.phone_command_not_find_anyone_close), 2));
                return;
            }
            this.c.mo1928a(new C2707i(this.d.getString(C0965R.string.phone_command_not_find_anyone_retry), 1));
            return;
        }
        f9058f = 0;
        this.f9059e = list;
        if (list.size() == 1) {
            m10437a((C2617a) this.f9059e.get(0));
            return;
        }
        C2761c.m10463a().m10475b(this);
        C2549b model = new C2707i(this.d.getString(C0965R.string.phone_command_find_multi_name), this.f9059e, C2706a.TYPE_CONTACT_NAME, 1);
        model.m10127a(this.f9064k);
        this.c.mo1928a(model);
    }

    /* renamed from: r */
    private void m10443r() {
        C2549b model = new C2549b();
        model.f8465g = this.d.getString(C0965R.string.wechat_command_hint_xiaodu);
        model.f8468j = 1;
        this.c.mo1928a(model);
    }

    /* renamed from: s */
    private void m10444s() {
        C2549b model = new C2549b();
        model.f8465g = this.d.getString(C0965R.string.common_command_ok);
        model.f8468j = 2;
        this.c.mo1929a(model, new C27543(this), null);
        this.c.mo1930a(C2837c.STATE_NORMAL);
    }

    /* renamed from: i */
    protected void mo1960i() {
        this.c.mo1944p();
        m10437a(this.f9062i);
    }
}
