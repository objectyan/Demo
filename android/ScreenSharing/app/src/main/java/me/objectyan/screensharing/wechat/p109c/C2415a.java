package com.baidu.carlife.wechat.p109c;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.platform.C1984a;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.wechat.p105a.p106a.C2359b;
import com.baidu.carlife.wechat.p105a.p107b.C2369a;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2375a;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2380c.C2379b;
import com.baidu.carlife.wechat.p108b.C2382d;
import com.baidu.carlife.wechat.p108b.C2382d.C2381a;
import com.baidu.carlife.wechat.p108b.C2385g;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p110e.C2434b;
import com.baidu.carlife.wechat.p110e.C2434b.C2400g;
import com.baidu.carlife.wechat.p110e.C2434b.C2402j;
import com.baidu.carlife.wechat.p110e.C2434b.C2404b;
import com.baidu.carlife.wechat.p110e.C2434b.C2406a;
import com.baidu.carlife.wechat.p110e.C2434b.C2411f;
import com.baidu.carlife.wechat.p112f.C2451b;
import com.baidu.carlife.wechat.p112f.C2454d;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WechatLogic */
/* renamed from: com.baidu.carlife.wechat.c.a */
public class C2415a {
    /* renamed from: a */
    private int f7957a;
    /* renamed from: b */
    private boolean f7958b;
    /* renamed from: c */
    private C2413a f7959c;
    /* renamed from: d */
    private C2382d f7960d;

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$1 */
    class C23991 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2415a f7944a;

        C23991(C2415a this$0) {
            this.f7944a = this$0;
        }

        public void run() {
            this.f7944a.m9242b();
        }
    }

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$2 */
    class C24012 implements C2400g {
        /* renamed from: a */
        final /* synthetic */ C2415a f7945a;

        C24012(C2415a this$0) {
            this.f7945a = this$0;
        }

        /* renamed from: a */
        public void mo1831a() {
            this.f7945a.m9235h();
        }

        /* renamed from: b */
        public void mo1832b() {
            this.f7945a.m9242b();
        }

        /* renamed from: c */
        public void mo1833c() {
            this.f7945a.m9242b();
        }

        /* renamed from: d */
        public void mo1834d() {
            C2372c.m9036e("sync check canceled，心跳请求停止。。。。。。。。。。。。");
        }

        /* renamed from: e */
        public void mo1835e() {
            if (C2380c.m9070a().m9083d() == C2379b.LOGIN) {
                FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_WECHAT_LOGIN, null);
                FragmentManagerCallbackProxy.m4757a().removeWeChatFragmentFromStack();
            }
        }
    }

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$3 */
    class C24033 implements C2402j {
        /* renamed from: a */
        final /* synthetic */ C2415a f7946a;

        C24033(C2415a this$0) {
            this.f7946a = this$0;
        }

        /* renamed from: a */
        public void mo1837a(int msgCount) {
            this.f7946a.m9242b();
        }

        /* renamed from: a */
        public void mo1836a() {
            this.f7946a.m9242b();
        }
    }

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$5 */
    class C24075 implements C2406a {
        /* renamed from: a */
        final /* synthetic */ C2415a f7949a;

        C24075(C2415a this$0) {
            this.f7949a = this$0;
        }

        /* renamed from: a */
        public void mo1841a(int next, List<C2376b> contacts) {
            if (contacts != null) {
                List<C2376b> roomContacts = C2380c.m9070a().m9088i();
                int len = contacts.size();
                for (int i = 0; i < len; i++) {
                    int size = roomContacts.size();
                    for (int j = 0; j < size; j++) {
                        if (TextUtils.equals(((C2376b) roomContacts.get(j)).m9052a(), ((C2376b) contacts.get(i)).m9052a())) {
                            roomContacts.set(j, contacts.get(i));
                        }
                    }
                }
            }
            this.f7949a.m9232b(next);
        }

        /* renamed from: a */
        public void mo1840a(int next) {
            this.f7949a.m9232b(next);
        }
    }

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$6 */
    class C24086 implements C2406a {
        /* renamed from: a */
        final /* synthetic */ C2415a f7950a;

        C24086(C2415a this$0) {
            this.f7950a = this$0;
        }

        /* renamed from: a */
        public void mo1841a(int next, List<C2376b> contacts) {
            if (contacts != null && contacts.size() > 0) {
                List chats = new ArrayList();
                int size = contacts.size();
                for (int i = 0; i < size; i++) {
                    C2376b contact = (C2376b) contacts.get(i);
                    if (!contact.m9065j() && (!contact.m9066k() || contact.m9068m())) {
                        chats.add(new C2375a(contact, (long) (0 - i)));
                    }
                }
                C2398k.m9160a().m9178a(chats);
            }
            this.f7950a.m9237a(next);
        }

        /* renamed from: a */
        public void mo1840a(int next) {
            this.f7950a.m9237a(next);
        }
    }

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$a */
    public interface C2413a {
        /* renamed from: a */
        void mo1857a();
    }

    /* compiled from: WechatLogic */
    /* renamed from: com.baidu.carlife.wechat.c.a$b */
    private static class C2414b {
        /* renamed from: a */
        private static final C2415a f7956a = new C2415a();

        private C2414b() {
        }
    }

    private C2415a() {
        this.f7957a = 0;
        this.f7958b = false;
        this.f7960d = null;
    }

    /* renamed from: a */
    public static C2415a m9228a() {
        return C2414b.f7956a;
    }

    /* renamed from: b */
    public void m9242b() {
        C2372c.m9030c("");
        if (C2398k.m9160a().m9194h()) {
            C2372c.m9036e("正在下载语音消息，不能取消全部网络任务");
        } else {
            C2434b.m9300a(false);
        }
        m9234g();
    }

    /* renamed from: g */
    private void m9234g() {
        C2372c.m9030c("");
        if (C2380c.m9070a().m9083d() != C2379b.LOGIN) {
            C2372c.m9036e("账号未登录，心跳请求停止。。。。。。。。。。。。");
        } else if (C2359b.m8969a(AppContext.m3876a())) {
            C2434b.m9291a(new C24012(this));
        } else {
            Toast.makeText(AppContext.m3876a(), "网络连接异常，请检查您的网络连接", 0).show();
            C2372c.m9036e("网络连接异常，10s后重试!!!!!!!!!!!!!");
            new Handler(Looper.getMainLooper()).postDelayed(new C23991(this), BNOffScreenParams.MIN_ENTER_INTERVAL);
        }
    }

    /* renamed from: h */
    private void m9235h() {
        C2434b.m9294a(new C24033(this));
    }

    /* renamed from: a */
    public void m9240a(C2413a contactCallback) {
        this.f7959c = contactCallback;
    }

    /* renamed from: c */
    public void m9243c() {
        this.f7957a = 0;
        this.f7958b = false;
    }

    /* renamed from: d */
    public boolean m9244d() {
        return this.f7958b;
    }

    /* renamed from: a */
    public void m9241a(final String seq) {
        if (this.f7958b) {
            C2372c.m9030c("contacts is loading...");
            return;
        }
        this.f7957a++;
        C2372c.m9030c("load contacts...   load times =" + this.f7957a);
        if (this.f7957a > 3) {
            C2372c.m9030c("load contacts failed , load times = " + this.f7957a);
            m9243c();
            if (this.f7959c != null) {
                this.f7959c.mo1857a();
            }
        } else if (!TextUtils.equals("0", seq) || C2380c.m9070a().m9087h().size() <= 0) {
            this.f7958b = true;
            C2434b.m9295a(seq, new C2404b(this) {
                /* renamed from: b */
                final /* synthetic */ C2415a f7948b;

                /* renamed from: a */
                public void mo1839a(String seqStr) {
                    if (TextUtils.equals(seqStr, "0")) {
                        this.f7948b.f7957a = 0;
                        this.f7948b.m9232b(0);
                        return;
                    }
                    this.f7948b.m9243c();
                    this.f7948b.m9241a(seqStr);
                }

                /* renamed from: a */
                public void mo1838a() {
                    this.f7948b.f7958b = false;
                    this.f7948b.m9241a(seq);
                }
            });
        } else {
            C2372c.m9030c("contacts is already loaded.");
            m9243c();
            if (this.f7959c != null) {
                this.f7959c.mo1857a();
            }
        }
    }

    /* renamed from: b */
    private void m9232b(int start) {
        List<C2376b> contactList = C2380c.m9070a().m9088i();
        int size = contactList.size();
        if (start < 0 || start >= size) {
            m9243c();
            if (this.f7959c != null) {
                this.f7959c.mo1857a();
                return;
            }
            return;
        }
        C2434b.m9299a(contactList.subList(start, Math.min(size, start + 50)), start, new C24075(this));
    }

    /* renamed from: a */
    public void m9237a(int start) {
        C2372c.m9030c("start = " + start);
        List<String> chatSet = C2398k.m9160a().m9181b();
        int size = chatSet.size();
        if (start < 0 || start >= size) {
            C2372c.m9030c("session is already loaded.");
            return;
        }
        C2406a cb = new C24086(this);
        List contacts = new ArrayList();
        int end = Math.min(size, start + 50);
        for (int i = start; i < end; i++) {
            C2376b contact = new C2376b();
            contact.m9053a((String) chatSet.get(i));
            contacts.add(contact);
        }
        if (contacts.size() != 0) {
            C2434b.m9299a(contacts, start, cb);
        }
    }

    /* renamed from: i */
    private void m9236i() {
        C2342g.m8864e().m8890a("微信消息发送中...");
    }

    /* renamed from: e */
    public void m9245e() {
        C2342g.m8864e().m8895f();
    }

    /* renamed from: a */
    public void m9238a(final C2376b contact, final String content) {
        C2372c.m9030c("send msg >>>  " + contact.m9054b() + " : " + content);
        C2398k.m9160a().m9179a(true);
        m9236i();
        C2434b.m9298a(contact.m9052a(), content + "【以上文字由语音转换】", new C2411f(this) {
            /* renamed from: c */
            final /* synthetic */ C2415a f7955c;

            /* compiled from: WechatLogic */
            /* renamed from: com.baidu.carlife.wechat.c.a$7$1 */
            class C24091 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C24127 f7951a;

                C24091(C24127 this$1) {
                    this.f7951a = this$1;
                }

                public void run() {
                    C2398k.m9160a().m9192f();
                }
            }

            /* compiled from: WechatLogic */
            /* renamed from: com.baidu.carlife.wechat.c.a$7$2 */
            class C24102 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C24127 f7952a;

                C24102(C24127 this$1) {
                    this.f7952a = this$1;
                }

                public void run() {
                    C2398k.m9160a().m9192f();
                }
            }

            /* renamed from: a */
            public void mo1842a() {
                C2398k.m9160a().m9179a(false);
                C2398k.m9160a().m9182b(new C2382d(contact, content));
                C2454d.m9369a("发送成功");
                this.f7955c.m9245e();
                C2451b.m9347d().m9357f();
                new Handler().postDelayed(new C24091(this), 1000);
            }

            /* renamed from: a */
            public void mo1843a(String reason) {
                C2372c.m9036e("消息发送失败，reason=" + reason);
                C2398k.m9160a().m9179a(false);
                C2454d.m9369a("发送失败");
                C2451b.m9347d().m9357f();
                this.f7955c.m9245e();
                new Handler().postDelayed(new C24102(this), 1000);
            }

            /* renamed from: b */
            public void mo1844b() {
                C2398k.m9160a().m9179a(false);
                this.f7955c.m9245e();
                C2454d.m9369a("登录态失效");
                Toast.makeText(AppContext.m3876a(), "登录态失效，请重新登录", 0).show();
                FragmentManagerCallbackProxy.m4757a().showFragment(NaviFragmentManager.TYPE_WECHAT_LOGIN, null);
                FragmentManagerCallbackProxy.m4757a().removeWeChatFragmentFromStack();
            }
        });
        StatisticManager.onEvent(StatisticConstants.HOME_WECHAT_003);
    }

    /* renamed from: f */
    public void m9246f() {
        m9239a(this.f7960d);
    }

    /* renamed from: a */
    public void m9239a(C2382d msg) {
        if (msg == null) {
            C2451b.m9347d().mo1847c();
        } else if (CarlifeConfig.m4065a() || C2369a.m9013b(AppContext.m3876a())) {
            this.f7960d = null;
            C2376b contact = msg.m9105g();
            String showName = "";
            String title = "";
            String content = "";
            String roomMemberName = "";
            showName = contact.m9054b();
            if (contact.m9066k()) {
                C2385g member = contact.m9059d(msg.m9111m());
                if (member != null) {
                    roomMemberName = member.m9125c();
                }
            }
            if (msg.m9107i() != null) {
                title = msg.m9107i().m9118a();
                if (contact.m9066k()) {
                    content = "【群消息】" + roomMemberName + " 分享的地址";
                } else {
                    content = showName + "分享的地址";
                }
            } else if (msg.m9106h() != null) {
                title = Html.fromHtml(msg.m9106h().m9115a()) + "—" + Html.fromHtml(msg.m9106h().m9116b());
                if (contact.m9066k()) {
                    content = "【群消息】" + roomMemberName + " 分享的音乐";
                } else {
                    content = showName + "分享的音乐";
                }
            } else {
                if (contact.m9066k()) {
                    title = "群消息：" + showName;
                } else {
                    title = showName + "的微信消息";
                }
                content = "收到1条消息";
            }
            m9230a(title, content, msg.m9114p());
        } else {
            this.f7960d = msg;
            AppContext.m3876a().sendBroadcast(new Intent(C1984a.f6384c));
        }
    }

    /* renamed from: a */
    private void m9230a(String title, String content, C2381a showType) {
        C2342g.m8864e().m8891a(title, content, showType);
    }
}
