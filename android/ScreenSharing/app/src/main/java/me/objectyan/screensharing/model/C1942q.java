package com.baidu.carlife.model;

/* compiled from: VoiceRecogResultModel */
/* renamed from: com.baidu.carlife.model.q */
public class C1942q {
    /* renamed from: A */
    public static final String f6128A = "nearby";
    /* renamed from: B */
    public static final String f6129B = "arrival";
    /* renamed from: C */
    public static final String f6130C = "poi_type";
    /* renamed from: D */
    public static final String f6131D = "player";
    /* renamed from: E */
    public static final String f6132E = "other";
    /* renamed from: a */
    public static final String f6133a = "music";
    /* renamed from: b */
    public static final String f6134b = "play";
    /* renamed from: c */
    public static final String f6135c = "music_setting";
    /* renamed from: d */
    public static final String f6136d = "search";
    /* renamed from: e */
    public static final String f6137e = "next_song";
    /* renamed from: f */
    public static final String f6138f = "pre_song";
    /* renamed from: g */
    public static final String f6139g = "pause";
    /* renamed from: h */
    public static final String f6140h = "play";
    /* renamed from: i */
    public static final String f6141i = "song";
    /* renamed from: j */
    public static final String f6142j = "singer";
    /* renamed from: k */
    public static final String f6143k = "contact";
    /* renamed from: l */
    public static final String f6144l = "call";
    /* renamed from: m */
    public static final String f6145m = "setting";
    /* renamed from: n */
    public static final String f6146n = "goto";
    /* renamed from: o */
    public static final String f6147o = "open_voice_wake";
    /* renamed from: p */
    public static final String f6148p = "close_voice_wake";
    /* renamed from: q */
    public static final String f6149q = "check_update";
    /* renamed from: r */
    public static final String f6150r = "open_help";
    /* renamed from: s */
    public static final String f6151s = "route_home";
    /* renamed from: t */
    public static final String f6152t = "route_work";
    /* renamed from: u */
    public static final String f6153u = "音乐";
    /* renamed from: v */
    public static final String f6154v = "首页";
    /* renamed from: w */
    public static final String f6155w = "地图";
    /* renamed from: x */
    public static final String f6156x = "电话";
    /* renamed from: y */
    public static final String f6157y = "map";
    /* renamed from: z */
    public static final String f6158z = "route";
    /* renamed from: F */
    public String f6159F;
    /* renamed from: G */
    public String f6160G;
    /* renamed from: H */
    public String f6161H;
    /* renamed from: I */
    public C1939b f6162I;
    /* renamed from: J */
    public C1938a f6163J;
    /* renamed from: K */
    public C1941d f6164K;
    /* renamed from: L */
    public C1940c f6165L;

    /* compiled from: VoiceRecogResultModel */
    /* renamed from: com.baidu.carlife.model.q$a */
    public class C1938a {
        /* renamed from: a */
        public String f6114a = "";
        /* renamed from: b */
        public String f6115b = "";
        /* renamed from: c */
        public String f6116c = "";
        /* renamed from: d */
        final /* synthetic */ C1942q f6117d;

        public C1938a(C1942q this$0) {
            this.f6117d = this$0;
        }
    }

    /* compiled from: VoiceRecogResultModel */
    /* renamed from: com.baidu.carlife.model.q$b */
    public class C1939b {
        /* renamed from: a */
        public String f6118a = "";
        /* renamed from: b */
        public String f6119b = "";
        /* renamed from: c */
        public String f6120c = "";
        /* renamed from: d */
        public String f6121d = "";
        /* renamed from: e */
        final /* synthetic */ C1942q f6122e;

        public C1939b(C1942q this$0) {
            this.f6122e = this$0;
        }
    }

    /* compiled from: VoiceRecogResultModel */
    /* renamed from: com.baidu.carlife.model.q$c */
    public class C1940c {
        /* renamed from: a */
        public String f6123a = "";
        /* renamed from: b */
        final /* synthetic */ C1942q f6124b;

        public C1940c(C1942q this$0) {
            this.f6124b = this$0;
        }
    }

    /* compiled from: VoiceRecogResultModel */
    /* renamed from: com.baidu.carlife.model.q$d */
    public class C1941d {
        /* renamed from: a */
        public String f6125a = "";
        /* renamed from: b */
        public String f6126b = "";
        /* renamed from: c */
        final /* synthetic */ C1942q f6127c;

        public C1941d(C1942q this$0) {
            this.f6127c = this$0;
        }
    }

    public C1942q(String domain) {
        this.f6159F = domain;
        if (domain.equals("music")) {
            this.f6162I = new C1939b(this);
        } else if (domain.equals("player")) {
            this.f6162I = new C1939b(this);
        } else if (domain.equals("contact")) {
            this.f6164K = new C1941d(this);
        } else if (domain.equals(f6145m)) {
            this.f6165L = new C1940c(this);
        } else if (domain.equals("map")) {
            this.f6163J = new C1938a(this);
        }
    }

    /* renamed from: a */
    public String m7400a() {
        return this.f6162I.f6118a;
    }

    /* renamed from: b */
    public String m7401b() {
        return this.f6162I.f6119b;
    }

    /* renamed from: c */
    public String m7402c() {
        return this.f6164K.f6126b;
    }
}
