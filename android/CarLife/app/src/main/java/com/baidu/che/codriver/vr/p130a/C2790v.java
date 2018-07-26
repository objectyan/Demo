package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p120e.C2529a;
import com.baidu.che.codriver.p120e.C2534b;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.sdk.p081a.C2598i;
import com.baidu.che.codriver.sdk.p081a.C2598i.C1752b;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2707i;
import com.baidu.che.codriver.ui.p124d.C2707i.C2706a;
import com.baidu.che.codriver.ui.p127a.C2657f.C2656a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2848p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PhoneCommand */
/* renamed from: com.baidu.che.codriver.vr.a.v */
public class C2790v extends C2747a {
    /* renamed from: i */
    private static int f9141i = 0;
    /* renamed from: e */
    private String f9142e;
    /* renamed from: f */
    private String f9143f;
    /* renamed from: g */
    private List<C2529a> f9144g;
    /* renamed from: h */
    private List<C2529a> f9145h;
    /* renamed from: j */
    private C1752b f9146j = C2598i.m9805b().m9812c();
    /* renamed from: k */
    private C2656a f9147k = new C27881(this);

    /* compiled from: PhoneCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.v$1 */
    class C27881 implements C2656a {
        /* renamed from: a */
        final /* synthetic */ C2790v f9139a;

        C27881(C2790v this$0) {
            this.f9139a = this$0;
        }

        /* renamed from: a */
        public void mo1963a(int position, C2529a data, C2706a uiType) {
            this.f9139a.c.mo1936d();
            if (uiType == C2706a.TYPE_CONTACT_NAME) {
                List list = C2534b.m9598a().m9610b(data.m9591a());
                if (list == null || list.isEmpty()) {
                    C2674b.m9985b().m10013a("无法根据" + data.m9591a() + "找到相应号码", 0);
                    return;
                } else if (list.size() == 1) {
                    this.f9139a.f9143f = data.m9593b();
                    this.f9139a.m10580r();
                    return;
                } else {
                    this.f9139a.f9145h = list;
                    C2549b model = new C2707i(String.format(this.f9139a.d.getString(C0965R.string.phone_command_find_multi_num), new Object[]{data.m9591a(), Integer.valueOf(list.size())}), list, C2706a.TYPE_CONTACT_NUM, 1);
                    model.m10127a(this.f9139a.f9147k);
                    C2674b.m9985b().m10019b(model);
                    return;
                }
            }
            this.f9139a.f9143f = data.m9593b();
            this.f9139a.m10580r();
        }
    }

    /* compiled from: PhoneCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.v$2 */
    class C27892 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2790v f9140a;

        C27892(C2790v this$0) {
            this.f9140a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9140a.f9146j.mo1636a(this.f9140a.f9143f);
        }
    }

    public C2790v(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        C2716c.m10143a(this.d, "10003");
    }

    /* renamed from: h */
    public void mo1957h() {
        if (this.f9146j == null) {
            C2549b model = new C2549b();
            model.f8465g = "无法连接拨号工具";
            model.f8468j = 2;
            this.c.mo1928a(model);
        } else if (!C2598i.m9805b().m9810a(0, this.c)) {
            if (!TextUtils.isEmpty(this.f9143f)) {
                m10572a();
            } else if (TextUtils.isEmpty(this.f9142e)) {
                m10576b();
            } else {
                m10574a(this.f9142e);
            }
        }
    }

    /* renamed from: a */
    private void m10572a() {
        String content = this.d.getString(C0965R.string.phone_command_dial_out_confirm_b, new Object[]{this.f9143f});
        List list = new ArrayList();
        C2529a mModel = new C2529a();
        mModel.m9594b(this.f9143f);
        list.add(mModel);
        this.c.mo1928a(new C2707i(content, list, C2706a.TYPE_NUM_CONFIRM, 1));
        C2761c.m10463a().m10479d(this);
    }

    /* renamed from: b */
    private void m10576b() {
        C2549b model = new C2549b();
        model.f8465g = "您可以说打电话给10086或者打电话给小度";
        model.f8468j = 1;
        this.c.mo1928a(model);
    }

    /* renamed from: j */
    public void mo1958j() {
        if (this.b != null) {
            try {
                JSONObject result = new JSONObject(mo1956g());
                this.f9142e = result.optString("name");
                this.f9143f = result.optString(C2848p.aL);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        if (newCommand == null || !C2848p.f9315p.equals(newCommand.mo1953d())) {
            C2725h.m10207b(C2747a.f9028a, "---不是电话需要的多轮命令，提示用户选择------");
            this.c.mo1928a(null);
        } else if (C2848p.f9291R.equals(newCommand.mo1954e())) {
            if (TextUtils.isEmpty(this.f9143f)) {
                this.c.mo1928a(null);
            } else {
                m10580r();
            }
        } else if (C2848p.f9292S.equals(newCommand.mo1954e())) {
            mo1960i();
        } else {
            try {
                JSONObject result = new JSONObject(newCommand.mo1956g());
                if (this.f9145h == null || this.f9145h.isEmpty()) {
                    m10577b(((C2529a) this.f9144g.get(C2747a.m10395a(result.optString("option"), this.f9144g.size()))).m9591a());
                    return;
                }
                this.f9143f = ((C2529a) this.f9145h.get(C2747a.m10395a(result.optString("option"), this.f9145h.size()))).m9593b();
                m10580r();
            } catch (JSONException e) {
                C2549b model = new C2549b();
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8467i = 5;
                this.c.mo1928a(model);
            } catch (IndexOutOfBoundsException e2) {
                this.c.mo1928a(new C2707i(this.d.getString(C0965R.string.phone_command_say_right_index), C2539c.f8338F, 1, C2695a.TYPE_NORMAL_REQ));
            }
        }
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        JSONObject params = new JSONObject();
        try {
            params.putOpt("name", this.f9142e);
            params.putOpt(C2848p.aL, this.f9143f);
            params.putOpt("num", this.f9143f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return params;
    }

    /* renamed from: r */
    private void m10580r() {
        m10413q();
        if (!C2598i.m9805b().m9810a(1, this.c)) {
            C2549b model = new C2549b();
            model.f8468j = 2;
            this.c.mo1929a(model, new C27892(this), null);
        }
    }

    /* renamed from: a */
    private void m10574a(String similarName) {
        List<C2529a> list = C2534b.m9598a().m9607a(similarName);
        if (list == null || list.isEmpty()) {
            int i = f9141i + 1;
            f9141i = i;
            if (i >= 2) {
                f9141i = 0;
                this.c.mo1928a(new C2707i(this.d.getString(C0965R.string.phone_command_not_find_anyone_close), C2539c.f8336D, 2, C2695a.TYPE_NORMAL_REQ));
                return;
            }
            this.c.mo1928a(new C2707i(this.d.getString(C0965R.string.phone_command_not_find_anyone_retry), C2539c.f8337E, 1, C2695a.TYPE_NORMAL_REQ));
            return;
        }
        f9141i = 0;
        this.f9144g = list;
        if (list.size() == 1) {
            m10577b(((C2529a) list.get(0)).m9591a());
            return;
        }
        C2761c.m10463a().m10475b(this);
        C2549b model = new C2707i(this.d.getString(C0965R.string.phone_command_find_multi_name), this.f9144g, C2706a.TYPE_CONTACT_NAME, 1);
        model.m10127a(this.f9147k);
        this.c.mo1928a(model);
        C2716c.m10144a(this.d, "10004", "进入多轮");
    }

    /* renamed from: b */
    private void m10577b(String accurateName) {
        this.f9142e = accurateName;
        List<C2529a> list = C2534b.m9598a().m9610b(accurateName);
        if (list == null || list.isEmpty()) {
            Toast.makeText(this.d, "无法根据" + accurateName + "找到相应号码", 0).show();
            this.c.mo1928a(null);
            return;
        }
        if (C2761c.m10463a().m10480e()) {
            C2716c.m10144a(this.d, "10004", "澄清成功");
        }
        this.f9145h = list;
        if (list.size() == 1) {
            this.f9143f = ((C2529a) list.get(0)).m9593b();
            m10572a();
        } else if (list.size() > 1) {
            C2716c.m10144a(this.d, "10004", "进入多轮");
            C2761c.m10463a().m10475b(this);
            C2549b model = new C2707i(String.format(this.d.getString(C0965R.string.phone_command_find_multi_num), new Object[]{this.f9142e, Integer.valueOf(list.size())}), this.f9145h, C2706a.TYPE_CONTACT_NUM, 1);
            model.m10127a(this.f9147k);
            this.c.mo1928a(model);
        }
    }

    /* renamed from: i */
    protected void mo1960i() {
        C2549b model = new C2549b();
        model.f8465g = this.d.getString(C0965R.string.common_command_cancel);
        model.f8468j = 1;
        this.c.mo1928a(model);
        m10413q();
    }
}
