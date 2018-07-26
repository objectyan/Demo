package com.baidu.che.codriver.sdk.handler;

import android.text.TextUtils;
import com.baidu.che.codriver.p117c.C2523a;
import com.baidu.che.codriver.sdk.p081a.C2589f;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a.C2587a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.INoProguard;
import com.baidu.che.codriver.vr.C2848p;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.List;

public class MusicCommandHandler implements C2603a {
    /* renamed from: a */
    private C2587a f8667a;

    static class PlayList implements INoProguard {
        List<C2523a> list;
        int position;

        public PlayList(List<C2523a> list, int position) {
            this.list = list;
            this.position = position;
        }
    }

    /* renamed from: com.baidu.che.codriver.sdk.handler.MusicCommandHandler$a */
    private class C2619a implements C1821a {
        /* renamed from: a */
        final /* synthetic */ MusicCommandHandler f8665a;
        /* renamed from: b */
        private String f8666b;

        public C2619a(MusicCommandHandler musicCommandHandler, String pkgName) {
            this.f8665a = musicCommandHandler;
            this.f8666b = pkgName;
        }

        /* renamed from: a */
        public String m9848a() {
            return this.f8666b;
        }

        /* renamed from: a */
        public void mo1675a(C2523a song, int pos) {
            C2606l.m9828a().m9829a(C2606l.f8615a, "play.music", new Gson().toJson(song));
        }

        /* renamed from: a */
        public void mo1677a(List<C2523a> musicList, int position) {
            C2606l.m9828a().m9829a(C2606l.f8615a, "play.list", new Gson().toJson(new PlayList(musicList, position)));
        }

        /* renamed from: a */
        public void mo1676a(String singer, String song, String tag, String type, C2587a listener) {
            C2523a model = new C2523a();
            model.f8259i = singer;
            model.f8255e = song;
            this.f8665a.f8667a = listener;
            C2606l.m9828a().m9829a(C2606l.f8615a, "search", new Gson().toJson(model));
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        if (C2848p.af.equals(param)) {
            C2589f.m9787a().m9790b(new C2619a(this, pkg));
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("reset".equals(param)) {
            C2589f.m9787a().m9790b(null);
        } else if (!(!"search".equals(param) || this.f8667a == null || TextUtils.isEmpty(data))) {
            try {
                this.f8667a.mo1970a(((PlayList) new Gson().fromJson(data, PlayList.class)).list);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
