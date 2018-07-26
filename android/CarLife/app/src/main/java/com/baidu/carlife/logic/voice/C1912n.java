package com.baidu.carlife.logic.voice;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C1020q.C1011b;
import com.baidu.carlife.adpter.C1027s.C1025a;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.codriver.adapter.C1751a;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.carlife.logic.codriver.adapter.C1756c;
import com.baidu.carlife.model.C1942q;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.p101o.C1983b;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2252a;
import com.baidu.carlife.view.C2348h;
import com.baidu.carlife.wechat.p112f.C2451b;
import com.baidu.che.codriver.p122h.C2543d;
import com.baidu.che.codriver.sdk.p081a.C2575a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2731l;
import com.baidu.che.codriver.vr.C2847o;
import com.baidu.che.codriver.vr.C2847o.C1905a;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.C2855a;
import com.baidu.navi.cruise.control.ICruiseEnterQuiteLogic;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.List;

/* compiled from: VrManager */
/* renamed from: com.baidu.carlife.logic.voice.n */
public class C1912n {
    /* renamed from: a */
    private static final int f5884a = 0;
    /* renamed from: b */
    private static final int f5885b = 1;
    /* renamed from: c */
    private static final int f5886c = 2;
    /* renamed from: d */
    private static final int f5887d = 4;
    /* renamed from: e */
    private static final int f5888e = 4097;
    /* renamed from: g */
    private static final String f5889g = "CarLifeVoice-VrManager";
    /* renamed from: h */
    private static final Object f5890h = new Object();
    /* renamed from: i */
    private static C1912n f5891i;
    /* renamed from: f */
    private int f5892f = 4;
    /* renamed from: j */
    private Context f5893j;
    /* renamed from: k */
    private C2348h f5894k = new C2348h();
    /* renamed from: l */
    private C1011b f5895l;
    /* renamed from: m */
    private List<MusicSongModel> f5896m;
    /* renamed from: n */
    private C1942q f5897n;
    /* renamed from: o */
    private boolean f5898o;
    /* renamed from: p */
    private boolean f5899p = false;
    /* renamed from: q */
    private boolean f5900q = false;
    /* renamed from: r */
    private ICruiseEnterQuiteLogic f5901r;
    /* renamed from: s */
    private C2847o f5902s = C2847o.m10687a();
    /* renamed from: t */
    private boolean f5903t = false;
    /* renamed from: u */
    private C1911a f5904u;
    /* renamed from: v */
    private C0936j f5905v = new C19041(this);
    /* renamed from: w */
    private C1889c f5906w = new C19084(this);

    /* compiled from: VrManager */
    /* renamed from: com.baidu.carlife.logic.voice.n$1 */
    class C19041 extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1912n f5873a;

        C19041(C1912n this$0) {
            this.f5873a = this$0;
        }

        public void careAbout() {
            addMsg(4160);
            addMsg(2004);
            addMsg(2002);
            addMsg(1002);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    this.f5873a.m7289w();
                    return;
                case 1004:
                    this.f5873a.m7290x();
                    return;
                case 2002:
                case 2004:
                case 4160:
                    this.f5873a.m7310i();
                    return;
                case 4097:
                    C1260i.m4435b(C1912n.f5889g, "############## delay enter scene and wakeup");
                    this.f5873a.m7308g();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.carlife.logic.voice.n$2 */
    class C19062 implements C1905a {
        /* renamed from: a */
        final /* synthetic */ C1912n f5874a;

        C19062(C1912n this$0) {
            this.f5874a = this$0;
        }

        /* renamed from: a */
        public void mo1712a() {
            C2543d.m9631a().m9635a(this.f5874a.f5893j);
            if (this.f5874a.m7288v()) {
                this.f5874a.f5902s.m10775o();
            }
            C2674b.m9985b().m10004a(this.f5874a.f5906w);
            C1754b.m6365a().m6367a(this.f5874a.f5893j);
            C1260i.m4435b("codrivervoice", "----onInitSuccess-----");
            this.f5874a.f5900q = true;
        }
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.carlife.logic.voice.n$4 */
    class C19084 implements C1889c {
        /* renamed from: a */
        final /* synthetic */ C1912n f5877a;

        C19084(C1912n this$0) {
            this.f5877a = this$0;
        }

        /* renamed from: a */
        public void mo1713a() {
            this.f5877a.m7285s();
            this.f5877a.f5892f = 4;
            this.f5877a.m7293a(4100);
            this.f5877a.f5899p = false;
        }

        /* renamed from: b */
        public boolean mo1716b() {
            if (C1328h.m4757a().getCurrentFragmentType() == 17 && this.f5877a.f5901r != null) {
                this.f5877a.f5901r.quitCruise();
            }
            if (C1772k.m6480a().m6489c() != 0) {
                C2201w.m8371a((int) C0965R.string.phone_status_busy_voice, 1);
                return false;
            }
            C2252a.m8531a().m8567d();
            if (C1772k.m6480a().m6490d() == 2) {
                C2201w.m8373a("当前车机不支持语音功能！", 0);
                return false;
            }
            if (!this.f5877a.f5899p) {
                C1261k.m4461b((int) C1253f.hb);
            }
            C1772k.m6480a().m6485a(4, 1);
            C1772k.m6480a().m6484a(1);
            C1915a.m7321a().m7335e();
            C1915a.m7321a().m7330b(true);
            return true;
        }

        /* renamed from: c */
        public void mo1717c() {
            this.f5877a.m7308g();
        }

        /* renamed from: a */
        public void mo1715a(String wakeupWord) {
            this.f5877a.f5899p = true;
            C1260i.m4435b(C1912n.f5889g, "--onWakeUp---word:" + wakeupWord);
            if (this.f5877a.m7314m()) {
                C2674b.m9985b().m10036m();
            }
            this.f5877a.m7293a(4103);
            this.f5877a.f5892f = 0;
            C1983b.m7576a();
            C1983b.m7577a(1);
            StatisticManager.onEvent(StatisticConstants.VOICE_0020);
        }

        /* renamed from: a */
        public void mo1714a(int errorCode) {
            C1260i.m4435b(C1912n.f5889g, "---errorCode:" + errorCode);
            switch (errorCode) {
                case 0:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0003);
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0002);
                        return;
                    }
                    return;
                case 1:
                case 2:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "网络错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "网络错误");
                        return;
                    }
                    return;
                case 3:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "麦克风错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "麦克风错误");
                        return;
                    }
                    return;
                case 4:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "服务端错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "服务端错误");
                        return;
                    }
                    return;
                case 5:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "客户端错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "客户端错误");
                        return;
                    }
                    return;
                case 6:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "超时错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "超时错误");
                        return;
                    }
                    return;
                case 7:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "无匹配错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "无匹配错误");
                        return;
                    }
                    return;
                case 8:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "引擎忙错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "引擎忙错误");
                        return;
                    }
                    return;
                case 9:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "无权限错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "无权限错误");
                        return;
                    }
                    return;
                case 21:
                    StatisticManager.onEvent(StatisticConstants.VOICE_0004, "定位错误");
                    if (!C1663a.m5979a().m5993N()) {
                        StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0003, "定位错误");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        /* renamed from: d */
        public void mo1718d() {
            C2451b.m9347d().mo1847c();
        }

        /* renamed from: e */
        public void mo1719e() {
            StatisticManager.onEvent(StatisticConstants.VOICE_0002);
            if (!C1663a.m5979a().m5993N()) {
                StatisticManager.onEvent(StatisticConstants.VOICE_PHONE_0001);
            }
        }

        /* renamed from: f */
        public void mo1720f() {
            if (this.f5877a.f5892f == 1 && this.f5877a.f5899p) {
                C1260i.m4435b(C1912n.f5889g, "Vr State is already LISTENING");
                return;
            }
            this.f5877a.m7292z();
            this.f5877a.m7293a(4101);
            if (this.f5877a.f5899p) {
                this.f5877a.f5892f = 1;
            }
        }

        /* renamed from: g */
        public void mo1721g() {
            this.f5877a.m7293a(4159);
            if (this.f5877a.f5899p) {
                this.f5877a.f5892f = 2;
            }
        }

        /* renamed from: h */
        public void mo1722h() {
            this.f5877a.m7293a(4100);
            this.f5877a.f5892f = 4;
        }
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.carlife.logic.voice.n$5 */
    class C19095 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1912n f5878a;

        C19095(C1912n this$0) {
            this.f5878a = this$0;
        }

        public void run() {
            this.f5878a.m7290x();
        }
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.carlife.logic.voice.n$a */
    private enum C1911a {
        STATE_FOREGROUND,
        STATE_BACKGROUND_SUPPORT_INTENAL_SCREEN,
        STATE_BACKGROUND_NOT_SUPPORT_INTENAL_SCREEN
    }

    private C1912n() {
    }

    /* renamed from: a */
    private String m7271a(String singer, String songName) {
        if (!TextUtils.isEmpty(singer) && !TextUtils.isEmpty(songName)) {
            return singer + "的" + songName;
        }
        if (TextUtils.isEmpty(singer)) {
            return TextUtils.isEmpty(songName) ? null : songName;
        } else {
            return singer + "的歌";
        }
    }

    /* renamed from: a */
    public static C1912n m7270a() {
        if (f5891i == null) {
            synchronized (f5890h) {
                if (f5891i == null) {
                    f5891i = new C1912n();
                }
            }
        }
        return f5891i;
    }

    /* renamed from: a */
    public void m7294a(Activity activity) {
        this.f5893j = activity.getApplicationContext();
        C1261k.m4460a(this.f5905v);
        C2716c.m10145a(this.f5893j, "3", "cl", C1253f.jx.m4403a(), CommonParam.getCUID(this.f5893j));
        C2731l.m10231b(this.f5893j, "wake_up", m7288v());
        C2575a.m9709a().m9727a(this.f5893j, new C19062(this));
    }

    /* renamed from: a */
    public void m7299a(final boolean flag) {
        this.f5902s.m10752d(flag);
        this.f5905v.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1912n f5876b;

            public void run() {
                C2731l.m10231b(this.f5876b.f5893j, "wake_up", flag);
            }
        });
    }

    /* renamed from: s */
    private void m7285s() {
        if (this.f5899p || m7313l()) {
            C1260i.m4435b("#######", "####### prepareCloseVr !");
            if (!m7288v()) {
                m7268A();
            }
            C1915a.m7321a().m7330b(false);
            C1772k.m6480a().m6485a(4, 0);
            C1772k.m6480a().m6484a(0);
            if (C1328h.m4757a().getCurrentFragmentType() == 17 && this.f5901r != null) {
                this.f5901r.enterCruise();
            }
        }
    }

    /* renamed from: b */
    public boolean m7301b() {
        return this.f5892f == 2;
    }

    /* renamed from: c */
    public boolean m7303c() {
        return this.f5892f == 1;
    }

    /* renamed from: d */
    public boolean m7305d() {
        return this.f5892f == 4;
    }

    /* renamed from: e */
    public void m7306e() {
        C1260i.m4435b(f5889g, "Vr State is: " + this.f5892f);
    }

    /* renamed from: a */
    public void m7293a(int what) {
        C1261k.m4452a(what);
        C1261k.m4461b(what);
    }

    /* renamed from: f */
    public void m7307f() {
        C2674b.m9985b().m10043t();
    }

    /* renamed from: b */
    public void m7300b(boolean hasTryAgain) {
        C2674b.m9985b().m10014a(hasTryAgain);
    }

    /* renamed from: g */
    public void m7308g() {
        if (m7315n() || !m7288v() || this.f5904u == C1911a.STATE_BACKGROUND_NOT_SUPPORT_INTENAL_SCREEN) {
            C1260i.m4445e(f5889g, "-can not-startWakeUp--");
        } else if (C1772k.m6480a().m6490d() == 2) {
            C2201w.m8371a((int) C0965R.string.voice_tips, 0);
            m7309h();
        } else {
            m7291y();
            this.f5902s.m10775o();
        }
    }

    /* renamed from: h */
    public void m7309h() {
        m7268A();
        this.f5902s.m10769k();
    }

    /* renamed from: i */
    public void m7310i() {
        m7286t();
    }

    /* renamed from: j */
    public void m7311j() {
        m7286t();
        C2674b.m9985b().m10036m();
    }

    /* renamed from: t */
    private void m7286t() {
        C2674b.m9985b().mo1925a();
    }

    /* renamed from: k */
    public void m7312k() {
        C2674b.m9985b().m10023c();
    }

    /* renamed from: l */
    public boolean m7313l() {
        return C2674b.m9985b().m10040q();
    }

    /* renamed from: m */
    public boolean m7314m() {
        return C2674b.m9985b().m10041r();
    }

    /* renamed from: a */
    public void m7295a(C1011b listener) {
        if (this.f5894k != null) {
            this.f5895l = listener;
        }
    }

    /* renamed from: a */
    public void m7298a(List list, C1025a type) {
        if (list != null && !list.isEmpty()) {
            this.f5894k.m8920a(list, type);
        } else if (type == C1025a.ITEM_TYPE_PHONE) {
            this.f5905v.sendMessage(Message.obtain(this.f5905v, 4151, this.f5897n.m7402c()));
        } else {
            this.f5905v.sendMessage(Message.obtain(this.f5905v, 4161, m7271a(this.f5897n.m7401b(), this.f5897n.m7400a())));
        }
    }

    /* renamed from: u */
    private void m7287u() {
        this.f5898o = true;
        if (m7288v()) {
            C2201w.m8373a("唤醒关闭了！", 0);
            m7299a(false);
            C1251e.m4358a().m4390a(false);
            m7309h();
            m7316o();
        }
    }

    /* renamed from: v */
    private boolean m7288v() {
        return C1251e.m4358a().m4398o();
    }

    /* renamed from: n */
    public boolean m7315n() {
        return this.f5898o;
    }

    /* renamed from: o */
    public void m7316o() {
        if (this.f5895l != null) {
            this.f5895l.mo1377a();
        }
    }

    /* renamed from: p */
    public void m7317p() {
        if (C1190a.m4065a() && C1663a.m5979a().m5993N()) {
            C1260i.m4435b(f5889g, " onActivityPause internal screen capture ");
            this.f5904u = C1911a.STATE_BACKGROUND_SUPPORT_INTENAL_SCREEN;
            return;
        }
        this.f5904u = C1911a.STATE_BACKGROUND_NOT_SUPPORT_INTENAL_SCREEN;
        if (m7313l()) {
            C1260i.m4435b(f5889g, " onActivityPause fullscreen capture, Invoke's vr.closeVr");
            m7286t();
        }
        if (m7288v()) {
            C1260i.m4435b(f5889g, " onActivityPause fullscreen capture, Invoke's vr.closeWakeup() ");
            m7309h();
        }
    }

    /* renamed from: q */
    public void m7318q() {
        this.f5904u = C1911a.STATE_FOREGROUND;
        if (this.f5900q) {
            C1260i.m4435b(f5889g, " onActivityResume fullscreen capture, Invoke's vr.startWakeUp() ");
            m7308g();
        }
    }

    /* renamed from: w */
    private void m7289w() {
        this.f5905v.removeMessages(4097);
        this.f5902s.m10727a(C2855a.INSIDE_RAW, null);
        this.f5898o = false;
        this.f5903t = false;
        switch (this.f5904u) {
            case STATE_FOREGROUND:
                C1260i.m4435b(f5889g, "onUsbDisConnected  STATE_FOREGROUND");
                if (m7313l()) {
                    m7310i();
                    C2674b.m9985b().m10036m();
                    return;
                }
                m7308g();
                return;
            case STATE_BACKGROUND_NOT_SUPPORT_INTENAL_SCREEN:
            case STATE_BACKGROUND_SUPPORT_INTENAL_SCREEN:
                C1260i.m4435b(f5889g, "onUsbDisConnected  STATE_BACKGROUND");
                if (m7313l()) {
                    this.f5904u = C1911a.STATE_BACKGROUND_NOT_SUPPORT_INTENAL_SCREEN;
                    m7310i();
                    return;
                }
                m7309h();
                return;
            default:
                return;
        }
    }

    /* renamed from: r */
    public void m7319r() {
        this.f5905v.removeMessages(1004);
        this.f5905v.sendEmptyMessageDelayed(1004, 1000);
    }

    /* renamed from: x */
    private void m7290x() {
        if (this.f5900q) {
            this.f5903t = false;
            if (!m7305d()) {
                m7286t();
            }
            int micStatus = C1772k.m6480a().m6490d();
            C1260i.m4435b(f5889g, "-----onUsbConnectedImpl----micStatus:" + micStatus);
            if (micStatus == 2) {
                C2201w.m8373a("当前车机不支持语音功能！", 0);
                if (m7313l()) {
                    m7286t();
                    return;
                } else {
                    m7309h();
                    return;
                }
            }
            if (!C1663a.m5979a().m5993N() || micStatus == 1) {
                this.f5902s.m10727a(C2855a.INSIDE_RAW, null);
            } else if (micStatus == 0) {
                this.f5902s.m10727a(C2855a.OUTSIDE_RAW, new C1756c());
                C1260i.m4435b(f5889g, "AecVehicle OUTSIDE_RAW_PCM");
            } else if (micStatus == 3) {
                this.f5902s.m10727a(C2855a.OUTSIDE_AEC_MIC_LEFT, new C1751a(true));
                C1260i.m4435b(f5889g, "AecVehicle OUTSIDE_AEC_MIC_LEFT_PCM");
            } else if (micStatus == 4) {
                this.f5902s.m10727a(C2855a.OUTSIDE_AEC_MIC_RIGHT, new C1751a(false));
                C1260i.m4435b(f5889g, "AecVehicle OUTSIDE_AEC_MIC_RIGHT_PCM");
            }
            if (m7313l()) {
                m7286t();
                return;
            } else if (m7288v()) {
                m7308g();
                return;
            } else {
                return;
            }
        }
        this.f5905v.postDelayed(new C19095(this), 1000);
    }

    /* renamed from: c */
    public void m7302c(boolean enable) {
        if (!enable) {
            m7287u();
        }
    }

    /* renamed from: a */
    public void m7297a(List list, int musicType) {
        this.f5896m = list;
        m7298a(list, musicType == 0 ? C1025a.ITEM_TYPE_MUSIC_LOCAL : C1025a.ITEM_TYPE_MUSIC_ONLINE);
    }

    /* renamed from: d */
    public void m7304d(boolean bOpen) {
        C2674b.m9985b().m10022b(bOpen);
    }

    /* renamed from: a */
    public void m7296a(ICruiseEnterQuiteLogic handle) {
        this.f5901r = handle;
    }

    /* renamed from: y */
    private void m7291y() {
        C1260i.m4435b(f5889g, "----MSG_CMD_MIC_RECORD_WAKEUP_START----");
        C1663a.m5979a().m6026c((int) C1253f.av);
    }

    /* renamed from: z */
    private void m7292z() {
        C1260i.m4435b(f5889g, "----MSG_CMD_MIC_RECORD_RECOG_START----");
        C1663a.m5979a().m6026c((int) C1253f.ax);
        this.f5903t = true;
    }

    /* renamed from: A */
    private void m7268A() {
        C1260i.m4435b(f5889g, "----MSG_CMD_MIC_RECORD_END----");
        C1663a.m5979a().m6026c((int) C1253f.aw);
        this.f5903t = false;
    }
}
