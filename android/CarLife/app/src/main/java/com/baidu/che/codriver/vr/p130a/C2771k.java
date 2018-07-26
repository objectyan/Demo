package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.che.codriver.p117c.C2523a;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.sdk.p081a.C2589f;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a.C2587a;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2699f;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2848p;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MusicCommand */
/* renamed from: com.baidu.che.codriver.vr.a.k */
public class C2771k extends C2747a implements C2587a {
    /* renamed from: e */
    private static final String f9091e = "[MusicModule] MusicCommand";
    /* renamed from: f */
    private String f9092f;
    /* renamed from: g */
    private String f9093g;
    /* renamed from: h */
    private String f9094h;
    /* renamed from: i */
    private String f9095i;
    /* renamed from: j */
    private List<C2523a> f9096j;
    /* renamed from: k */
    private C1821a f9097k = C2589f.m9787a().m9789b();

    public C2771k(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: j */
    protected void mo1958j() {
        C2716c.m10143a(this.d, C2536a.f8312m);
        try {
            JSONObject result = new JSONObject(mo1956g());
            this.f9092f = result.optString("name");
            this.f9095i = result.optString("type");
            JSONArray artists = result.optJSONArray(C2125n.ah);
            if (artists != null && artists.length() > 0) {
                this.f9093g = artists.getString(0);
            }
            JSONArray tags = result.optJSONArray("tag");
            if (tags != null && tags.length() > 0) {
                this.f9094h = tags.getString(0);
            }
            String jsonPoiList = result.optString("music");
            if (!TextUtils.isEmpty(jsonPoiList)) {
                this.f9096j = Arrays.asList((C2523a[]) new Gson().fromJson(jsonPoiList, C2523a[].class));
                if (this.f9096j != null) {
                    for (C2523a item : this.f9096j) {
                        item.f8262l = 2;
                    }
                }
            }
            C2725h.m10207b(f9091e, "---语音指令：-----" + result.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        if (newCommand == null || !C2747a.m10396b(newCommand)) {
            C2725h.m10207b(f9091e, "---不是多轮命令，提示用户选择------");
            this.c.mo1928a(null);
            return;
        }
        C2549b model;
        try {
            JSONObject obj = new JSONObject(newCommand.mo1956g());
            C2725h.m10207b(f9091e, "---多轮命令---" + obj.toString());
            int selectIndex = C2747a.m10395a(obj.optString("option"), this.f9096j.size());
            C2725h.m10207b("MusicCommand", "---多轮命令---selectIndex:" + selectIndex);
            if (this.f9096j == null || selectIndex >= this.f9096j.size() || selectIndex < 0) {
                model = new C2549b();
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8468j = 1;
                model.f8465g = this.d.getString(C0965R.string.phone_command_say_right_index);
                model.f8466h = C2539c.f8338F;
                this.c.mo1928a(model);
                return;
            }
            m10507a(this.f9096j, selectIndex);
        } catch (JSONException e) {
            model = new C2549b();
            model.f8464f = C2695a.TYPE_NORMAL_REQ;
            model.f8467i = 5;
            this.c.mo1928a(model);
        }
    }

    /* renamed from: h */
    public void mo1957h() {
        C2725h.m10207b(f9091e, "------excute()------------");
        if (this.f9097k == null) {
            m10508b(this.d.getString(C0965R.string.music_command_not_support));
        }
        if (this.f9096j == null || this.f9096j.size() <= 0) {
            this.f9097k.mo1676a(this.f9093g, this.f9092f, this.f9094h, this.f9095i, this);
        } else {
            m10509b(this.f9096j);
        }
    }

    /* renamed from: b */
    private void m10509b(List<C2523a> musicModels) {
        if (m10510c(musicModels)) {
            m10507a(musicModels, 0);
            return;
        }
        C2761c.m10463a().m10475b(this);
        C2549b model = new C2699f(musicModels);
        model.g = this.d.getString(C0965R.string.music_command_header_online, new Object[]{Integer.valueOf(musicModels.size())});
        model.j = 1;
        this.c.mo1928a(model);
    }

    /* renamed from: c */
    private boolean m10510c(List<C2523a> musicModels) {
        return musicModels.size() == 1 || mo1955f().contains(this.d.getString(C0965R.string.module_music));
    }

    /* renamed from: a */
    private void m10507a(final List<C2523a> modelList, final int position) {
        C2761c.m10463a().m10478d();
        C2549b baseModel = new C2549b();
        baseModel.f8468j = 2;
        this.c.mo1929a(baseModel, new C2752a(this) {
            /* renamed from: c */
            final /* synthetic */ C2771k f9090c;

            /* renamed from: a */
            public void mo1964a() {
                this.f9090c.f9097k.mo1677a(modelList, position);
            }
        }, null);
    }

    /* renamed from: b */
    private void m10508b(String content) {
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

    /* renamed from: a */
    public void mo1970a(List<C2523a> musicList) {
        this.f9096j = musicList;
        m10509b(this.f9096j);
    }

    /* renamed from: a */
    public void mo1969a(String error) {
        m10508b(error);
    }
}
