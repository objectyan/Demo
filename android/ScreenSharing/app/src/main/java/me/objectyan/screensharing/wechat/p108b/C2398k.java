package com.baidu.carlife.wechat.p108b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.baidunavis.tts.IBNTTSPlayerWeChatListener;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.screen.CarLifeSearchPoi;
import com.baidu.carlife.core.screen.presentation.view.CarlifePresenter;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.wechat.p105a.p106a.C2358a;
import com.baidu.carlife.wechat.p105a.p106a.C2368c;
import com.baidu.carlife.wechat.p105a.p106a.C2368c.C2367c;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2382d.C2381a;
import com.baidu.carlife.wechat.p109c.C2415a;
import com.baidu.carlife.wechat.p110e.C2418a;
import com.baidu.carlife.wechat.p112f.C2451b;
import com.baidu.carlife.wechat.p112f.C2454d;
import com.baidu.carlife.wechat.p113g.C2498b;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONObject;

/* compiled from: WechatMsgCenter */
/* renamed from: com.baidu.carlife.wechat.b.k */
public class C2398k {
    /* renamed from: a */
    private List<C2382d> f7932a;
    /* renamed from: b */
    private List<C2382d> f7933b;
    /* renamed from: c */
    private Map<String, C2375a> f7934c;
    /* renamed from: d */
    private List<String> f7935d;
    /* renamed from: e */
    private Queue<C2382d> f7936e;
    /* renamed from: f */
    private Queue<C2382d> f7937f;
    /* renamed from: g */
    private MediaPlayer f7938g;
    /* renamed from: h */
    private boolean f7939h;
    /* renamed from: i */
    private boolean f7940i;
    /* renamed from: j */
    private boolean f7941j;
    /* renamed from: k */
    private CarlifePresenter f7942k;
    /* renamed from: l */
    private List<C2397b> f7943l;

    /* compiled from: WechatMsgCenter */
    /* renamed from: com.baidu.carlife.wechat.b.k$2 */
    class C23902 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2398k f7921a;

        C23902(C2398k this$0) {
            this.f7921a = this$0;
        }

        public void run() {
            C2451b.m9347d().mo1847c();
        }
    }

    /* compiled from: WechatMsgCenter */
    /* renamed from: com.baidu.carlife.wechat.b.k$3 */
    class C23913 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2398k f7922a;

        C23913(C2398k this$0) {
            this.f7922a = this$0;
        }

        public void run() {
            C2451b.m9347d().mo1847c();
        }
    }

    /* compiled from: WechatMsgCenter */
    /* renamed from: com.baidu.carlife.wechat.b.k$5 */
    class C23945 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ C2398k f7928a;

        C23945(C2398k this$0) {
            this.f7928a = this$0;
        }

        public void onPrepared(MediaPlayer mp) {
            this.f7928a.f7938g.start();
        }
    }

    /* compiled from: WechatMsgCenter */
    /* renamed from: com.baidu.carlife.wechat.b.k$a */
    private static class C2396a {
        /* renamed from: a */
        public static final C2398k f7931a = new C2398k();

        private C2396a() {
        }
    }

    /* compiled from: WechatMsgCenter */
    /* renamed from: com.baidu.carlife.wechat.b.k$b */
    public interface C2397b {
        /* renamed from: a */
        void mo1856a();
    }

    private C2398k() {
        this.f7932a = new ArrayList();
        this.f7933b = new ArrayList();
        this.f7934c = new HashMap();
        this.f7935d = new ArrayList();
        this.f7936e = new LinkedList();
        this.f7937f = new LinkedList();
        this.f7939h = false;
        this.f7940i = false;
        this.f7941j = false;
        this.f7943l = new ArrayList();
    }

    /* renamed from: a */
    public static C2398k m9160a() {
        return C2396a.f7931a;
    }

    /* renamed from: a */
    public void m9174a(CarlifePresenter presenter) {
        this.f7942k = presenter;
    }

    /* renamed from: a */
    public void m9176a(C2397b listener) {
        if (!this.f7943l.contains(listener)) {
            this.f7943l.add(listener);
        }
    }

    /* renamed from: b */
    public void m9183b(C2397b listener) {
        this.f7943l.remove(listener);
    }

    /* renamed from: a */
    public void m9177a(String userName) {
        this.f7935d.add(userName);
    }

    /* renamed from: b */
    public List<String> m9181b() {
        return this.f7935d;
    }

    /* renamed from: a */
    public void m9178a(List<C2375a> chats) {
        this.f7934c.clear();
        for (C2375a chat : chats) {
            this.f7934c.put(chat.m9045a().m9052a(), chat);
        }
    }

    /* renamed from: b */
    public void m9184b(List<C2376b> contacts) {
        for (C2376b contact : contacts) {
            if (this.f7934c.containsKey(contact.m9052a())) {
                ((C2375a) this.f7934c.get(contact.m9052a())).m9047a(contact);
            } else {
                this.f7934c.put(contact.m9052a(), new C2375a(contact, System.currentTimeMillis() / 1000));
            }
        }
    }

    /* renamed from: a */
    public void m9175a(C2382d msg) {
        String userName = msg.m9105g().m9052a();
        if (this.f7934c.containsKey(userName)) {
            ((C2375a) this.f7934c.get(userName)).m9046a(msg.m9109k());
        } else {
            this.f7934c.put(userName, new C2375a(msg.m9105g(), msg.m9109k()));
        }
        for (C2397b listener : this.f7943l) {
            listener.mo1856a();
        }
    }

    /* renamed from: b */
    public void m9182b(C2382d msg) {
        this.f7933b.add(msg);
        m9175a(msg);
    }

    /* renamed from: c */
    public synchronized void m9188c(List<C2382d> msgList) {
        if (msgList != null) {
            for (C2382d msg : msgList) {
                if (msg.m9105g() != null && msg.m9113o()) {
                    if (C2380c.m9070a().m9077a(msg.m9103e())) {
                        this.f7932a.add(msg);
                        m9175a(msg);
                        if (m9172f(msg)) {
                            if (msg.m9105g().m9052a().startsWith("@@")) {
                                this.f7937f.offer(msg);
                            } else {
                                this.f7936e.offer(msg);
                            }
                            m9173i();
                        }
                        if (msg.m9105g().m9052a().startsWith("@@")) {
                            String c;
                            C2372c.m9030c("群消息：type=" + msg.m9099b() + "," + msg.m9105g().m9054b());
                            C2385g member = msg.m9105g().m9059d(msg.m9111m());
                            StringBuilder stringBuilder = new StringBuilder();
                            if (member != null) {
                                c = member.m9125c();
                            } else {
                                c = "";
                            }
                            C2372c.m9030c(stringBuilder.append(c).append(Config.TRACE_TODAY_VISIT_SPLIT).append(msg.m9104f()).toString());
                        } else {
                            C2372c.m9030c("新消息：type=" + msg.m9099b() + "," + msg.m9105g().m9054b() + " >> " + msg.m9104f());
                        }
                    } else {
                        m9182b(msg);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public List<C2375a> m9185c() {
        return new ArrayList(this.f7934c.values());
    }

    /* renamed from: b */
    public C2376b m9180b(String userName) {
        if (this.f7934c.containsKey(userName)) {
            return ((C2375a) this.f7934c.get(userName)).m9045a();
        }
        return null;
    }

    /* renamed from: c */
    public List<C2382d> m9186c(String userName) {
        List<C2382d> msgList = new ArrayList();
        for (C2382d msg : this.f7932a) {
            if (TextUtils.equals(msg.m9102d(), userName)) {
                msg.m9095a(1);
                msgList.add(msg);
            }
        }
        msgList.addAll(m9170e(userName));
        return msgList;
    }

    /* renamed from: e */
    private List<C2382d> m9170e(String userName) {
        List<C2382d> msgList = new ArrayList();
        for (C2382d msg : this.f7933b) {
            if (TextUtils.equals(msg.m9103e(), userName)) {
                msgList.add(msg);
            }
        }
        return msgList;
    }

    /* renamed from: d */
    public int m9189d() {
        int count = 0;
        for (C2382d msg : this.f7932a) {
            if (msg.m9110l() == 0) {
                count++;
            }
        }
        return count;
    }

    /* renamed from: d */
    public int m9190d(String userName) {
        int count = 0;
        for (C2382d msg : this.f7932a) {
            if (TextUtils.equals(userName, msg.m9102d()) && msg.m9110l() == 0) {
                count++;
            }
        }
        return count;
    }

    /* renamed from: e */
    public void m9191e() {
        this.f7935d = new ArrayList();
        this.f7934c = new HashMap();
        this.f7936e = new LinkedList();
        this.f7937f = new LinkedList();
        this.f7932a = new ArrayList();
        this.f7933b = new ArrayList();
        this.f7939h = false;
        this.f7940i = false;
        if (this.f7938g != null) {
            try {
                this.f7938g.release();
                this.f7938g = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    private synchronized void m9173i() {
        C2372c.m9030c("isReplying = " + this.f7940i + " ; isPlaying = " + this.f7939h);
        if (!this.f7940i) {
            if (!this.f7939h) {
                C2372c.m9030c("play unread msgs count = " + this.f7936e.size());
                C2372c.m9030c("play unread room msgs count = " + this.f7937f.size());
                if (this.f7936e.size() > 0) {
                    this.f7939h = true;
                    m9169d((C2382d) this.f7936e.poll());
                } else if (this.f7937f.size() > 0) {
                    this.f7939h = true;
                    m9169d((C2382d) this.f7937f.poll());
                } else {
                    this.f7939h = false;
                    C2342g.m8864e().m8896g();
                }
            }
        }
    }

    /* renamed from: d */
    private void m9169d(final C2382d msg) {
        if (msg.m9107i() == null) {
            m9171e(msg);
            return;
        }
        C2368c.m8994a(C2418a.m9251a(msg.m9107i().m9120b(), msg.m9107i().m9121c()), new C2367c(this) {
            /* renamed from: b */
            final /* synthetic */ C2398k f7920b;

            /* renamed from: a */
            public void mo1827a(Exception e) {
                this.f7920b.m9171e(msg);
            }

            /* renamed from: a */
            public void mo1826a(C2358a httpResult) {
                try {
                    C2372c.m9030c("反geo：" + httpResult.m8965b());
                    JSONObject json = new JSONObject(httpResult.m8965b());
                    if (json.getInt("status") == 0) {
                        String description = json.getJSONObject("result").optString("sematic_description");
                        if (!TextUtils.isEmpty(description)) {
                            msg.m9107i().m9119a(description.replaceAll("附近([0-9]*)米", ""));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f7920b.m9171e(msg);
            }
        });
    }

    /* renamed from: e */
    private void m9171e(C2382d msg) {
        msg.m9095a(1);
        StringBuffer ttsTextBuffer = new StringBuffer();
        if (msg.m9105g().m9066k()) {
            C2385g member = msg.m9105g().m9059d(msg.m9111m());
            if (member != null) {
                ttsTextBuffer.append("群消息，收到" + member.m9125c());
            } else {
                ttsTextBuffer.append("群消息，收到一条");
            }
        } else {
            ttsTextBuffer.append("收到" + msg.m9105g().m9054b());
        }
        if (msg.m9107i() != null) {
            ttsTextBuffer.append("分享的地理位置，请说开始导航或取消");
            C2451b.m9347d().m9355c(msg, ttsTextBuffer.toString());
            msg.m9097a(C2381a.Navi);
            C2415a.m9228a().m9239a(msg);
        } else if (msg.m9106h() != null) {
            ttsTextBuffer.append("分享的音乐，请说播放音乐或取消");
            C2451b.m9347d().m9353b(msg, ttsTextBuffer.toString());
            msg.m9097a(C2381a.Play);
            C2415a.m9228a().m9239a(msg);
        } else {
            ttsTextBuffer.append("发来的");
            if (msg.m9099b() == 34) {
                ttsTextBuffer.append("语音");
            }
            ttsTextBuffer.append("消息");
            if (C2498b.m9487c()) {
                if (msg.m9099b() == 34) {
                    m9167a(ttsTextBuffer.toString(), msg);
                } else {
                    m9161a(msg, ttsTextBuffer.toString() + msg.m9104f().replace("<br/>", ""));
                }
                msg.m9097a(C2381a.Reply);
                C2415a.m9228a().m9239a(msg);
                return;
            }
            ttsTextBuffer.append("，请说播报或取消");
            C2451b.m9347d().m9351a(msg, ttsTextBuffer.toString());
            msg.m9097a(C2381a.Play);
            C2415a.m9228a().m9239a(msg);
        }
    }

    /* renamed from: f */
    public void m9192f() {
        this.f7939h = false;
        this.f7940i = false;
        this.f7941j = false;
        for (C2397b listener : this.f7943l) {
            listener.mo1856a();
        }
        m9193g();
        m9173i();
    }

    /* renamed from: c */
    public void m9187c(C2382d msg) {
        if (msg.m9107i() != null) {
            m9163a(msg.m9107i());
            new Handler(Looper.getMainLooper()).postDelayed(new C23902(this), 2000);
        } else if (msg.m9106h() != null) {
            m9162a(msg.m9106h());
            new Handler(Looper.getMainLooper()).postDelayed(new C23913(this), 2000);
        } else if (msg.m9099b() == 34) {
            m9167a(null, msg);
        } else {
            m9161a(msg, msg.m9104f().replace("<br/>", ""));
        }
    }

    /* renamed from: a */
    private void m9161a(C2382d msg, String ttsText) {
        if (ttsText.length() > 500) {
            ttsText = ttsText.substring(0, 500);
        }
        C2451b.m9347d().m9350a(msg.m9105g(), ttsText + "，请说回复或取消");
        C2342g.m8864e().m8889a(C2381a.Reply);
    }

    /* renamed from: a */
    private void m9162a(C2383e music) {
        MusicSongModel musicSongModel = new MusicSongModel();
        musicSongModel.f5921m = music.m9117c();
        musicSongModel.f5910b = music.m9115a();
        musicSongModel.f5914f = music.m9116b();
        C1818h.m6730b().m6810f(musicSongModel);
    }

    /* renamed from: a */
    private void m9167a(final String ttsText, final C2382d msg) {
        String url = msg.m9112n();
        C2372c.m9030c("url=" + url);
        this.f7941j = true;
        C2368c.m8997a(url, AppContext.m3876a().getCacheDir().getAbsolutePath(), new C2367c(this) {
            /* renamed from: c */
            final /* synthetic */ C2398k f7927c;

            /* renamed from: a */
            public void mo1827a(Exception e) {
                C2372c.m9036e("下载语音消息出错，e=" + e);
                this.f7927c.f7941j = false;
                C2451b.m9347d().mo1847c();
            }

            /* renamed from: a */
            public void mo1826a(final C2358a httpResult) {
                if (TextUtils.isEmpty(ttsText)) {
                    this.f7927c.m9166a(httpResult.m8968d(), msg.m9105g());
                    return;
                }
                C2454d.m9370a();
                C2454d.m9371a(new IBNTTSPlayerWeChatListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C23934 f7924b;

                    public void notifyTTSStart() {
                    }

                    public void notifyTTSEnd() {
                        C2454d.m9371a(null);
                        this.f7924b.f7927c.m9166a(httpResult.m8968d(), msg.m9105g());
                    }

                    public void notifyTTSInterrupt() {
                        C2454d.m9371a(null);
                        C2451b.m9347d().mo1847c();
                    }
                });
                if (C2454d.m9369a(ttsText) < 0) {
                    C2454d.m9371a(null);
                    C2451b.m9347d().mo1847c();
                }
            }
        });
    }

    /* renamed from: a */
    private void m9166a(String filePath, final C2376b contact) {
        this.f7941j = false;
        File file = new File(filePath);
        try {
            if (this.f7938g == null) {
                this.f7938g = new MediaPlayer();
            } else {
                this.f7938g.reset();
            }
            this.f7938g.setAudioStreamType(3);
            this.f7938g.setDataSource(file.getAbsolutePath());
            this.f7938g.prepareAsync();
            this.f7938g.setOnPreparedListener(new C23945(this));
            this.f7938g.setOnCompletionListener(new OnCompletionListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2398k f7930b;

                public void onCompletion(MediaPlayer mp) {
                    C2451b.m9347d().m9350a(contact, "请说回复或取消");
                    C2342g.m8864e().m8889a(C2381a.Reply);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            C2372c.m9036e("播报语音消息异常，e=" + e);
            try {
                this.f7938g.release();
                this.f7938g = null;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            C2451b.m9347d().mo1847c();
        }
    }

    /* renamed from: a */
    public void m9179a(boolean isReplying) {
        this.f7940i = isReplying;
    }

    /* renamed from: f */
    private boolean m9172f(C2382d msg) {
        if (msg.m9105g() == null) {
            C2372c.m9036e("联系人信息为空默认不播报");
            return false;
        } else if (C2498b.m9483a()) {
            C2372c.m9036e("静音设置为true，所有消息不播报");
            return false;
        } else if (C2498b.m9485b() && msg.m9105g().m9066k()) {
            C2372c.m9036e("屏蔽群消息设置为true，所有群消息不播报");
            return false;
        } else {
            String name = msg.m9105g().m9062g();
            if (TextUtils.isEmpty(name)) {
                name = msg.m9105g().m9054b();
            }
            if (C2498b.m9488d().contains(name)) {
                C2372c.m9036e("私密好友消息，不播报");
                return false;
            } else if (msg.m9105g().m9066k() && msg.m9105g().m9061f() == 0) {
                C2372c.m9036e("手机端设置免打扰的群聊，默认不播报");
                return false;
            } else if (msg.m9106h() == null && msg.m9107i() == null && msg.m9099b() != 34 && msg.m9099b() != 1) {
                C2372c.m9036e("非 音乐、位置、语音、文字消息，默认不播报");
                return false;
            } else if (C1912n.m7270a().m7313l()) {
                C2372c.m9036e("正在语音场景中，不播报微信消息");
                return false;
            } else if (C1772k.m6480a().m6489c() == 0) {
                return true;
            } else {
                C2372c.m9036e("正在电话场景中，不播报微信消息");
                return false;
            }
        }
    }

    /* renamed from: a */
    private void m9163a(C2384f poi) {
        GeoPoint geoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(Double.parseDouble(poi.m9121c()), Double.parseDouble(poi.m9120b()));
        CarLifeSearchPoi carLifeSearchPoi = new CarLifeSearchPoi(((double) geoPoint.getLongitudeE6()) / 100000.0d, ((double) geoPoint.getLatitudeE6()) / 100000.0d);
        if (this.f7942k != null) {
            this.f7942k.m4671a(carLifeSearchPoi);
        }
    }

    /* renamed from: g */
    public void m9193g() {
        if (this.f7938g != null && this.f7938g.isPlaying()) {
            try {
                this.f7938g.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public boolean m9194h() {
        return this.f7941j;
    }
}
