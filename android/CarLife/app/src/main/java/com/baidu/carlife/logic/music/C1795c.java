package com.baidu.carlife.logic.music;

import android.os.Bundle;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.C2117g;
import com.baidu.carlife.radio.p080b.C2118h;
import com.baidu.carlife.radio.p080b.C2119i;
import org.json.JSONObject;

/* compiled from: Feeder */
/* renamed from: com.baidu.carlife.logic.music.c */
public class C1795c {
    /* renamed from: a */
    public static final int f5510a = 1;
    /* renamed from: b */
    public static final int f5511b = 2;
    /* renamed from: c */
    public static final int f5512c = 3;
    /* renamed from: d */
    public static final int f5513d = 4;
    /* renamed from: e */
    private int f5514e;
    /* renamed from: f */
    private C2118h f5515f;
    /* renamed from: g */
    private C2119i f5516g;
    /* renamed from: h */
    private C2117g f5517h;
    /* renamed from: i */
    private Bundle f5518i;
    /* renamed from: j */
    private Bundle f5519j;
    /* renamed from: k */
    private String f5520k;

    /* compiled from: Feeder */
    /* renamed from: com.baidu.carlife.logic.music.c$a */
    private static class C1792a {
        /* renamed from: a */
        private static final C1795c f5506a = new C1795c();

        private C1792a() {
        }
    }

    private C1795c() {
        this.f5514e = 1;
        this.f5515f = new C2118h();
        this.f5516g = new C2119i();
        this.f5517h = new C2117g();
        this.f5518i = new Bundle();
        this.f5519j = new Bundle();
        this.f5520k = null;
    }

    /* renamed from: a */
    public static C1795c m6660a() {
        return C1792a.f5506a;
    }

    /* renamed from: b */
    public int m6668b() {
        return this.f5514e;
    }

    /* renamed from: a */
    public void m6666a(int action, C1790b dataManager) {
        this.f5514e = action;
        this.f5518i.clear();
        MusicSongModel song = C1818h.m6730b().m6817i();
        String channelId = C2142b.m8067a().m8077c(C1702j.m6181a().m6188c().m6644n()).m7893a();
        if (song != null) {
            if (song.m7375p() != 999) {
                this.f5518i.putString("type", String.valueOf(song.f5925q));
                this.f5518i.putString("item_id", song.f5909a);
                if (!(song.f5917i == null || C1702j.m6181a().m6192g())) {
                    this.f5518i.putString("duration", song.f5917i);
                }
                if (!(song.f5912d == null || song.f5912d.isEmpty())) {
                    this.f5518i.putString("album_id", song.f5912d);
                }
            } else {
                return;
            }
        }
        this.f5518i.putString("channel_id", channelId);
        m6661a(action, song);
        if (this.f5520k == null) {
            this.f5520k = String.valueOf(4);
        }
        if (this.f5520k.equals(channelId)) {
            m6665d().m7923a(m6662b(song));
        } else {
            m6664c().m7923a(this.f5518i);
        }
    }

    /* renamed from: b */
    private Bundle m6662b(MusicSongModel song) {
        try {
            JSONObject dataParams = new JSONObject();
            dataParams.put("action_type", this.f5518i.getString("action_type"));
            dataParams.put("play_time", this.f5518i.getString("play_time"));
            dataParams.put("id", song.m7342a());
            dataParams.put("url", song.m7371l());
            dataParams.put("title", song.m7347b());
            dataParams.put("favorite", song.m7376q() + "");
            dataParams.put("duration", song.f5917i);
            this.f5518i.putString("data_type", "news_feedback");
            this.f5518i.putString("data", dataParams.toString());
        } catch (Exception e) {
            C1260i.m4435b("feeder", e.getMessage());
        }
        return this.f5518i;
    }

    /* renamed from: a */
    public void m6667a(MusicSongModel song) {
        this.f5518i.clear();
        this.f5519j.putString("type", String.valueOf(song.f5925q));
        String channelId = C1702j.m6181a().m6188c().m6644n();
        this.f5519j.putString("channel_id", channelId);
        this.f5519j.putString("item_id", song.f5909a);
        this.f5519j.putString("favorite", String.valueOf(song.f5927s));
        if (!(song.f5912d == null || song.f5912d.isEmpty())) {
            this.f5519j.putString("album_id", song.f5912d);
        }
        if (song.f5917i != null) {
            this.f5519j.putString("duration", song.f5917i);
        }
        this.f5519j.putString("play_time", String.valueOf(C1834p.m6925a().m6930f()));
        if (this.f5520k == null) {
            this.f5520k = String.valueOf(4);
        }
        if (this.f5520k.equals(channelId)) {
            m6665d().m7923a(m6663c(song));
        } else {
            this.f5517h.m7923a(this.f5519j);
        }
    }

    /* renamed from: c */
    private Bundle m6663c(MusicSongModel song) {
        try {
            JSONObject dataParams = new JSONObject();
            dataParams.put("favorite", String.valueOf(song.m7376q()));
            dataParams.put("play_time", this.f5519j.getString("play_time"));
            dataParams.put("id", song.f5909a);
            dataParams.put("url", song.m7371l());
            dataParams.put("title", song.f5910b);
            dataParams.put("duration", song.f5917i);
            this.f5519j.putString("data_type", "news_favorite");
            this.f5519j.putString("data", dataParams.toString());
        } catch (Exception e) {
            C1260i.m4435b("feeder", e.getMessage());
        }
        return this.f5519j;
    }

    /* renamed from: c */
    private C2118h m6664c() {
        return this.f5515f;
    }

    /* renamed from: d */
    private C2119i m6665d() {
        return this.f5516g;
    }

    /* renamed from: a */
    private void m6661a(int action, MusicSongModel song) {
        switch (action) {
            case 1:
                this.f5518i.putString("action_type", String.valueOf(action));
                C1834p.m6925a().m6926b();
                return;
            case 2:
            case 3:
            case 4:
                this.f5518i.putString("action_type", String.valueOf(action));
                this.f5518i.putString("play_time", String.valueOf(C1834p.m6925a().m6929e()));
                return;
            default:
                return;
        }
    }
}
