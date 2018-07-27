package com.baidu.carlife.wechat.p112f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.che.codriver.sdk.p081a.C2575a.C1979b;
import com.baidu.che.codriver.sdk.p126b.C2617a;
import com.baidu.navi.util.StatisticConstants;

/* compiled from: WechatSpeechAdapter */
/* renamed from: com.baidu.carlife.wechat.f.a */
public class C2445a {
    /* renamed from: a */
    private static final int f7998a = 4097;
    /* renamed from: b */
    private static final int f7999b = 4098;
    /* renamed from: c */
    private static final int f8000c = 4099;
    /* renamed from: d */
    private static final int f8001d = 4100;
    /* renamed from: e */
    private static final long f8002e = 12000;
    /* renamed from: f */
    private static final long f8003f = 20000;
    /* renamed from: g */
    private C2443a f8004g;
    /* renamed from: h */
    private C2444b f8005h = null;
    /* renamed from: i */
    private Handler f8006i = new Handler(this, Looper.getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ C2445a f7987a;

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4097:
                case 4098:
                case 4099:
                case 4100:
                    this.f7987a.f8005h = null;
                    this.f7987a.f8004g.mo1847c();
                    return;
                default:
                    return;
            }
        }
    };

    /* compiled from: WechatSpeechAdapter */
    /* renamed from: com.baidu.carlife.wechat.f.a$2 */
    class C24382 extends C1979b {
        /* renamed from: a */
        final /* synthetic */ C2445a f7988a;

        C24382(C2445a this$0) {
            this.f7988a = this$0;
        }

        public void onCommand(String type, String cmd) {
            this.f7988a.f8006i.removeMessages(4097);
            if (this.f7988a.m9332g() && this.f7988a.f8005h == C2444b.Play && TextUtils.equals(type, "wechat_play")) {
                this.f7988a.f8005h = null;
                if (TextUtils.equals(cmd, "播报")) {
                    this.f7988a.f8004g.mo1845a();
                } else {
                    this.f7988a.f8004g.mo1847c();
                }
            }
        }
    }

    /* compiled from: WechatSpeechAdapter */
    /* renamed from: com.baidu.carlife.wechat.f.a$3 */
    class C24393 extends C1979b {
        /* renamed from: a */
        final /* synthetic */ C2445a f7989a;

        C24393(C2445a this$0) {
            this.f7989a = this$0;
        }

        public void onCommand(String type, String cmd) {
            this.f7989a.f8006i.removeMessages(4098);
            if (this.f7989a.m9332g() && this.f7989a.f8005h == C2444b.Music && TextUtils.equals(type, "wechat_music")) {
                this.f7989a.f8005h = null;
                if (TextUtils.equals(cmd, StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PLAY) || TextUtils.equals(cmd, "播放音乐")) {
                    this.f7989a.f8004g.mo1845a();
                } else {
                    this.f7989a.f8004g.mo1847c();
                }
            }
        }
    }

    /* compiled from: WechatSpeechAdapter */
    /* renamed from: com.baidu.carlife.wechat.f.a$4 */
    class C24404 extends C1979b {
        /* renamed from: a */
        final /* synthetic */ C2445a f7990a;

        C24404(C2445a this$0) {
            this.f7990a = this$0;
        }

        public void onCommand(String type, String cmd) {
            this.f7990a.f8006i.removeMessages(4099);
            if (this.f7990a.m9332g() && this.f7990a.f8005h == C2444b.Navi && TextUtils.equals(type, "wechat_navi")) {
                this.f7990a.f8005h = null;
                if (TextUtils.equals(cmd, "开始导航")) {
                    this.f7990a.f8004g.mo1845a();
                } else {
                    this.f7990a.f8004g.mo1847c();
                }
            }
        }
    }

    /* compiled from: WechatSpeechAdapter */
    /* renamed from: com.baidu.carlife.wechat.f.a$5 */
    class C24415 extends C1979b {
        /* renamed from: a */
        final /* synthetic */ C2445a f7991a;

        C24415(C2445a this$0) {
            this.f7991a = this$0;
        }

        public void onCommand(String type, String cmd) {
            this.f7991a.f8006i.removeMessages(4100);
            if (this.f7991a.m9332g() && this.f7991a.f8005h == C2444b.Reply && TextUtils.equals(type, "wechat_reply")) {
                this.f7991a.f8005h = null;
                if (TextUtils.equals(cmd, "回复")) {
                    this.f7991a.f8004g.mo1846b();
                } else {
                    this.f7991a.f8004g.mo1847c();
                }
            }
        }
    }

    /* compiled from: WechatSpeechAdapter */
    /* renamed from: com.baidu.carlife.wechat.f.a$a */
    public interface C2443a {
        /* renamed from: a */
        void mo1845a();

        /* renamed from: b */
        void mo1846b();

        /* renamed from: c */
        void mo1847c();
    }

    /* compiled from: WechatSpeechAdapter */
    /* renamed from: com.baidu.carlife.wechat.f.a$b */
    public enum C2444b {
        Play,
        Music,
        Reply,
        Navi
    }

    /* renamed from: a */
    public void m9339a(C2443a callback) {
        this.f8004g = callback;
    }

    /* renamed from: a */
    public void m9337a() {
        m9333h();
        m9334i();
        m9335j();
        m9336k();
    }

    /* renamed from: b */
    public void m9340b() {
        m9328a(C2444b.Play);
    }

    /* renamed from: c */
    public void m9341c() {
        m9328a(C2444b.Music);
    }

    /* renamed from: d */
    public void m9342d() {
        m9328a(C2444b.Navi);
    }

    /* renamed from: e */
    public void m9343e() {
        m9328a(C2444b.Reply);
    }

    /* renamed from: a */
    public void m9338a(C2376b contact) {
        C1754b.m6365a().m6377a(new C2617a(contact.m9052a(), contact.m9054b()));
    }

    /* renamed from: f */
    public void m9344f() {
        this.f8005h = null;
        this.f8006i.removeMessages(4097);
        this.f8006i.removeMessages(4098);
        this.f8006i.removeMessages(4099);
        this.f8006i.removeMessages(4100);
    }

    /* renamed from: a */
    private void m9328a(C2444b scene) {
        this.f8005h = scene;
        switch (this.f8005h) {
            case Play:
                this.f8006i.sendEmptyMessageDelayed(4097, f8002e);
                return;
            case Music:
                this.f8006i.sendEmptyMessageDelayed(4098, f8002e);
                return;
            case Navi:
                this.f8006i.sendEmptyMessageDelayed(4099, f8002e);
                return;
            case Reply:
                this.f8006i.sendEmptyMessageDelayed(4100, f8003f);
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private boolean m9332g() {
        return !TextUtils.isEmpty(C2380c.m9070a().m9085f().m9135d());
    }

    /* renamed from: h */
    private void m9333h() {
        C1979b playCommand = new C24382(this);
        playCommand.addCommand("wechat_play", "播报", "取消");
        C1754b.m6365a().m6368a(playCommand);
    }

    /* renamed from: i */
    private void m9334i() {
        C1979b musicCommand = new C24393(this);
        musicCommand.addCommand("wechat_music", StatisticConstants.HOME_MUSIC_STATUS_CHANGE_PLAY, "播放音乐", "取消");
        C1754b.m6365a().m6368a(musicCommand);
    }

    /* renamed from: j */
    private void m9335j() {
        C1979b naviCommand = new C24404(this);
        naviCommand.addCommand("wechat_navi", "开始导航", "取消");
        C1754b.m6365a().m6368a(naviCommand);
    }

    /* renamed from: k */
    private void m9336k() {
        C1979b replyCommand = new C24415(this);
        replyCommand.addCommand("wechat_reply", "回复", "取消");
        C1754b.m6365a().m6368a(replyCommand);
    }
}
