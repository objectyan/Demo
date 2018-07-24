package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.model.MusicSongModel;

/* compiled from: DataChecker */
/* renamed from: com.baidu.carlife.logic.a.c */
public class C1685c {
    /* renamed from: a */
    private static final String f5180a = "600000";
    /* renamed from: b */
    private static final int f5181b = 2;

    /* compiled from: DataChecker */
    /* renamed from: com.baidu.carlife.logic.a.c$a */
    private static class C1684a {
        /* renamed from: a */
        private static final C1685c f5179a = new C1685c();

        private C1684a() {
        }
    }

    private C1685c() {
    }

    /* renamed from: a */
    public static C1685c m6142a() {
        return C1684a.f5179a;
    }

    /* renamed from: a */
    public MusicSongModel m6144a(MusicSongModel model) {
        if (m6143c(model)) {
            return null;
        }
        if (model.m7377r() < 0) {
            model.m7348b(2);
        }
        if (!m6145a(model.m7364h())) {
            return model;
        }
        model.m7365h(f5180a);
        return model;
    }

    /* renamed from: b */
    public MusicSongModel m6146b(MusicSongModel model) {
        if (model == null) {
            return null;
        }
        if (m6145a(model.m7342a()) || m6145a(model.m7347b())) {
            return null;
        }
        return model;
    }

    /* renamed from: a */
    public boolean m6145a(String input) {
        return input == null || input.isEmpty();
    }

    /* renamed from: c */
    private boolean m6143c(MusicSongModel model) {
        return model == null || m6145a(model.m7342a()) || m6145a(model.m7371l()) || model.m7375p() < 0;
    }
}
