package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.che.codriver.sdk.p081a.C1695n;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2608a;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2609b;
import com.baidu.che.codriver.sdk.p081a.C2580c;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2848p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PrivateRadioCommand */
/* renamed from: com.baidu.che.codriver.vr.a.x */
public class C2803x extends C2747a implements C2608a {
    /* renamed from: e */
    private String f9163e;
    /* renamed from: f */
    private String f9164f;
    /* renamed from: g */
    private String f9165g;
    /* renamed from: h */
    private List<String> f9166h;
    /* renamed from: i */
    private C1695n f9167i = C2580c.m9750a().m9756c();

    /* compiled from: PrivateRadioCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.x$1 */
    class C28011 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2803x f9161a;

        C28011(C2803x this$0) {
            this.f9161a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
            if (this.f9161a.f9167i != null) {
                this.f9161a.f9167i.mo1618a();
            }
        }
    }

    /* compiled from: PrivateRadioCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.x$2 */
    class C28022 implements C2752a {
        /* renamed from: a */
        final /* synthetic */ C2803x f9162a;

        C28022(C2803x this$0) {
            this.f9162a = this$0;
        }

        /* renamed from: a */
        public void mo1964a() {
        }
    }

    public C2803x(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        if (this.f9167i != null) {
            C2609b model = new C2609b(this.f9163e, this.f9164f, this.f9165g, this.f9166h, this.b.m10796h());
            C1702j.m6181a().m6186a(this.b.m10785b());
            this.f9167i.mo1619a(model, this);
        }
    }

    /* renamed from: j */
    protected void mo1958j() {
        try {
            JSONObject result = new JSONObject(mo1956g());
            this.f9163e = result.optString("type");
            this.f9164f = result.optString("person");
            this.f9165g = result.optString("program_name");
            if (result.has("keywords")) {
                JSONArray array = result.optJSONArray("keywords");
                this.f9166h = new ArrayList();
                for (int i = 0; i < array.length(); i++) {
                    this.f9166h.add(array.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1973a() {
        C2549b model = new C2549b();
        if (TextUtils.isEmpty(this.f9165g)) {
            model.f8465g = this.d.getString(C0965R.string.common_command_ok);
        } else {
            model.f8465g = this.d.getString(C0965R.string.music_begin_play) + "《" + this.f9165g + "》";
        }
        model.f8468j = 2;
        this.c.mo1929a(model, new C28011(this), null);
    }

    /* renamed from: b */
    public void mo1974b() {
        C2549b model = new C2549b();
        model.f8465g = this.d.getString(C0965R.string.common_command_fail);
        model.f8468j = 1;
        this.c.mo1929a(model, new C28022(this), null);
    }
}
