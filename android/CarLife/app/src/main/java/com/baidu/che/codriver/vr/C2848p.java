package com.baidu.che.codriver.vr;

import com.baidu.carlife.radio.p080b.C2125n;
import org.json.JSONObject;

/* compiled from: VrResultModel */
/* renamed from: com.baidu.che.codriver.vr.p */
public class C2848p {
    /* renamed from: A */
    public static final String f9274A = "route_home";
    /* renamed from: B */
    public static final String f9275B = "route_work";
    /* renamed from: C */
    public static final String f9276C = "nearby";
    /* renamed from: D */
    public static final String f9277D = "poi";
    /* renamed from: E */
    public static final String f9278E = "select";
    /* renamed from: F */
    public static final String f9279F = "call";
    /* renamed from: G */
    public static final String f9280G = "open";
    /* renamed from: H */
    public static final String f9281H = "close";
    /* renamed from: I */
    public static final String f9282I = "save";
    /* renamed from: J */
    public static final String f9283J = "volume_up";
    /* renamed from: K */
    public static final String f9284K = "volume_down";
    /* renamed from: L */
    public static final String f9285L = "volume_up_max";
    /* renamed from: M */
    public static final String f9286M = "volume_down_min";
    /* renamed from: N */
    public static final String f9287N = "light_up";
    /* renamed from: O */
    public static final String f9288O = "light_down";
    /* renamed from: P */
    public static final String f9289P = "light_down_min";
    /* renamed from: Q */
    public static final String f9290Q = "light_up_max";
    /* renamed from: R */
    public static final String f9291R = "yes";
    /* renamed from: S */
    public static final String f9292S = "no";
    /* renamed from: T */
    public static final String f9293T = "quit";
    /* renamed from: U */
    public static final String f9294U = "next";
    /* renamed from: V */
    public static final String f9295V = "back";
    /* renamed from: W */
    public static final String f9296W = "addWakeUpWord";
    /* renamed from: X */
    public static final String f9297X = "wakeup";
    /* renamed from: Y */
    public static final String f9298Y = "customCmd";
    /* renamed from: Z */
    public static final String f9299Z = "set_home";
    /* renamed from: a */
    public static final int f9300a = 0;
    public static final String aA = "goto_music_local";
    public static final String aB = "goto_music_qq";
    public static final String aC = "goto_netease";
    public static final String aD = "goto_music_xmly";
    public static final String aE = "goto_music_kaola";
    public static final String aF = "goto_music_chyb";
    public static final String aG = "goto_music_chinese_fm";
    public static final String aH = "download_music";
    public static final String aI = "synchronize_music";
    public static final String aJ = "download";
    public static final String aK = "sync";
    public static final String aL = "number";
    public static final String aM = "name";
    public static final String aN = "words";
    public static final String aO = "name";
    public static final String aP = "wakeupWords";
    public static final String aQ = "wechat_name";
    public static final String aR = "wechat_id";
    public static final String aS = "nlp_next";
    public static final String aT = "nlp_pre";
    public static final String aU = "nlp_click";
    public static final String aV = "phone_nlp_number";
    public static final String aa = "set_work";
    public static final String ab = "navigate";
    public static final String ac = "start_navigate";
    public static final String ad = "switch";
    public static final String ae = "tune";
    public static final String af = "set";
    public static final String ag = "set_ac";
    public static final String ah = "heat";
    public static final String ai = "login";
    public static final String aj = "logout";
    public static final String ak = "send";
    public static final String al = "listen";
    public static final String am = "location";
    public static final String an = "goto_contacts";
    public static final String ao = "goto_call_record";
    public static final String ap = "goto_item_discover";
    public static final String aq = "goto_item_park";
    public static final String ar = "goto_item_discover_food";
    public static final String as = "goto_item_fuel";
    public static final String at = "goto_item_rescue";
    public static final String au = "goto_item_ind_center";
    public static final String av = "goto_navi_set";
    public static final String aw = "goto_vr_Set";
    public static final String ax = "goto_journey_Set";
    public static final String ay = "goto_help";
    public static final String az = "goto_about";
    /* renamed from: b */
    public static final int f9301b = 1;
    /* renamed from: c */
    public static final int f9302c = 2;
    /* renamed from: d */
    public static final int f9303d = 3;
    /* renamed from: e */
    public static final int f9304e = 4;
    /* renamed from: f */
    public static final String f9305f = "domain";
    /* renamed from: g */
    public static final String f9306g = "intent";
    /* renamed from: h */
    public static final String f9307h = "object";
    /* renamed from: i */
    public static final String f9308i = "data";
    /* renamed from: j */
    public static final String f9309j = "calendar";
    /* renamed from: k */
    public static final String f9310k = "map";
    /* renamed from: l */
    public static final String f9311l = "navigate_instruction";
    /* renamed from: m */
    public static final String f9312m = "telephone";
    /* renamed from: n */
    public static final String f9313n = "music";
    /* renamed from: o */
    public static final String f9314o = "player";
    /* renamed from: p */
    public static final String f9315p = "codriver";
    /* renamed from: q */
    public static final String f9316q = "carlife";
    /* renamed from: r */
    public static final String f9317r = "app";
    /* renamed from: s */
    public static final String f9318s = "flight";
    /* renamed from: t */
    public static final String f9319t = "train";
    /* renamed from: u */
    public static final String f9320u = "hotel";
    /* renamed from: v */
    public static final String f9321v = "wechat";
    /* renamed from: w */
    public static final String f9322w = "other";
    /* renamed from: x */
    public static final String f9323x = "radio";
    /* renamed from: y */
    public static final String f9324y = "sound_program";
    /* renamed from: z */
    public static final String f9325z = "route";
    private String aW;
    private String aX;
    private String aY;
    private String aZ;
    private String ba;
    private String bb;
    private float bc;
    private int bd;

    /* renamed from: a */
    public int m10781a() {
        return this.bd;
    }

    /* renamed from: a */
    public void m10783a(int mErrorCode) {
        this.bd = mErrorCode;
    }

    /* renamed from: b */
    public String m10785b() {
        return this.aW;
    }

    /* renamed from: c */
    public String m10787c() {
        return this.aX;
    }

    /* renamed from: d */
    public String m10789d() {
        return this.aY;
    }

    /* renamed from: e */
    public String m10791e() {
        return this.aZ;
    }

    /* renamed from: f */
    public float m10793f() {
        return this.bc;
    }

    /* renamed from: g */
    public String m10795g() {
        return this.ba;
    }

    /* renamed from: h */
    public String m10796h() {
        return this.bb;
    }

    /* renamed from: a */
    public void m10784a(String mDomain) {
        this.aW = mDomain;
    }

    /* renamed from: b */
    public void m10786b(String mIntent) {
        this.aX = mIntent;
    }

    /* renamed from: c */
    public void m10788c(String mParams) {
        this.aY = mParams;
    }

    /* renamed from: d */
    public void m10790d(String mRawText) {
        this.aZ = mRawText;
    }

    /* renamed from: a */
    public void m10782a(float mScore) {
        this.bc = mScore;
    }

    /* renamed from: e */
    public void m10792e(String result) {
        this.ba = result;
    }

    /* renamed from: f */
    public void m10794f(String jsonResult) {
        this.bb = jsonResult;
    }

    public String toString() {
        try {
            JSONObject result = new JSONObject();
            result.put("text", this.aZ);
            result.put(C2125n.f6745M, this.bd);
            result.put("domain", this.aW);
            result.put("intent", this.aX);
            result.put("object", this.aY);
            return result.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
