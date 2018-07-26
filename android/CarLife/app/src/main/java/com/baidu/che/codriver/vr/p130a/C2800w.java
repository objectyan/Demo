package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.model.C1942q;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.sdk.p081a.C2600j;
import com.baidu.che.codriver.sdk.p081a.C2600j.C1822a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2749b;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlayerCommand */
/* renamed from: com.baidu.che.codriver.vr.a.w */
public class C2800w extends C2747a {
    /* renamed from: e */
    private static final String f9157e = "[MusicModule] PlayerCommand";
    /* renamed from: f */
    private String f9158f;
    /* renamed from: g */
    private String f9159g;
    /* renamed from: h */
    private C1822a f9160h = C2600j.m9814a().m9816b();

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$1 */
    class C27911 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2800w f9148a;

        C27911(C2800w this$0) {
            this.f9148a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9148a.f9160h.mo1684g();
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$2 */
    class C27922 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2800w f9149a;

        C27922(C2800w this$0) {
            this.f9149a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9149a.f9160h.mo1679b();
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$3 */
    class C27933 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2800w f9150a;

        C27933(C2800w this$0) {
            this.f9150a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9150a.f9160h.mo1680c();
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$4 */
    class C27944 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2800w f9151a;

        C27944(C2800w this$0) {
            this.f9151a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9151a.f9160h.mo1681d();
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$5 */
    class C27955 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2800w f9152a;

        C27955(C2800w this$0) {
            this.f9152a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9152a.f9160h.mo1682e();
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$6 */
    class C27966 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2800w f9153a;

        C27966(C2800w this$0) {
            this.f9153a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            this.f9153a.f9160h.mo1683f();
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$7 */
    class C27977 implements C2749b {
        /* renamed from: a */
        final /* synthetic */ C2800w f9154a;

        C27977(C2800w this$0) {
            this.f9154a = this$0;
        }

        /* renamed from: a */
        public void mo1962a() {
            this.f9154a.f9160h.mo1674a(0);
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$8 */
    class C27988 implements C2749b {
        /* renamed from: a */
        final /* synthetic */ C2800w f9155a;

        C27988(C2800w this$0) {
            this.f9155a = this$0;
        }

        /* renamed from: a */
        public void mo1962a() {
            this.f9155a.f9160h.mo1674a(1);
        }
    }

    /* compiled from: PlayerCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.w$9 */
    class C27999 implements C2749b {
        /* renamed from: a */
        final /* synthetic */ C2800w f9156a;

        C27999(C2800w this$0) {
            this.f9156a = this$0;
        }

        /* renamed from: a */
        public void mo1962a() {
            this.f9156a.f9160h.mo1674a(2);
        }
    }

    public C2800w(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: j */
    protected void mo1958j() {
        C2716c.m10143a(this.d, C2536a.f8313n);
        try {
            JSONObject result = new JSONObject(mo1956g());
            this.f9158f = result.optString("action_type");
            this.f9159g = result.optString(NaviStatConstants.K_NSC_KEY_MODE_TYPE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
    }

    /* renamed from: h */
    public void mo1957h() {
        C2725h.m10207b(f9157e, "------excute()------------");
        if (this.f9160h == null) {
            m10596a(this.d.getString(C0965R.string.music_command_not_support));
            return;
        }
        C2549b model = new C2549b();
        model.f8468j = 2;
        if ("change".equals(mo1954e())) {
            this.c.mo1929a(model, new C27911(this), null);
        } else if (!TextUtils.isEmpty(this.f9158f)) {
            C2725h.m10207b(f9157e, "handlePlayerDomain mActionType=" + this.f9158f);
            if (this.f9158f.equals("play")) {
                this.c.mo1929a(model, new C27922(this), null);
            } else if (this.f9158f.equals(C1942q.f6139g)) {
                this.c.mo1929a(model, new C27933(this), null);
            } else if (this.f9158f.equals("exitplayer")) {
                this.c.mo1929a(model, new C27944(this), null);
            } else if (this.f9158f.equals("previous")) {
                this.c.mo1929a(model, new C27955(this), null);
            } else if (this.f9158f.equals(C2848p.f9294U)) {
                this.c.mo1929a(model, new C27966(this), null);
            } else {
                m10596a(this.d.getString(C0965R.string.music_command_not_support));
            }
        } else if (TextUtils.isEmpty(this.f9159g)) {
            m10596a(this.d.getString(C0965R.string.music_command_not_support));
        } else {
            C2725h.m10207b(f9157e, "handlePlayerDomain mMode=" + this.f9159g);
            if (this.f9159g.equals("single_loop")) {
                this.c.mo1929a(model, null, new C27977(this));
            } else if (this.f9159g.equals("random")) {
                this.c.mo1929a(model, null, new C27988(this));
            } else if (this.f9159g.equals("full_loop")) {
                this.c.mo1929a(model, null, new C27999(this));
            } else {
                m10596a(this.d.getString(C0965R.string.music_command_not_support));
            }
        }
    }

    /* renamed from: a */
    private void m10596a(String content) {
        C2725h.m10207b(C2747a.f9028a, "setErrorFinish() " + content);
        C2549b conversationModel = new C2549b();
        conversationModel.f8468j = 1;
        conversationModel.f8465g = content;
        conversationModel.f8464f = C2695a.TYPE_NORMAL_REQ;
        this.c.mo1928a(conversationModel);
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
