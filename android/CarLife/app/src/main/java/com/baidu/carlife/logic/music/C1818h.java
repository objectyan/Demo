package com.baidu.carlife.logic.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C0995k;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.fragment.MusicPlayerFragment;
import com.baidu.carlife.logic.C1746b;
import com.baidu.carlife.logic.C1746b.C1712b;
import com.baidu.carlife.logic.C1759e;
import com.baidu.carlife.logic.C1769i;
import com.baidu.carlife.logic.C1771j;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.music.C1785a.C1782b;
import com.baidu.carlife.logic.p088a.C1688d;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p083g.C1605a;
import com.baidu.carlife.platform.C1995c;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.carlife.service.MusicPlayService;
import com.baidu.carlife.service.MusicPlayService.C2164a;
import com.baidu.carlife.util.C2181l;
import com.baidu.carlife.util.C2186p;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a.C2587a;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.netease.cloudmusic.utils.NeteaseMusicUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MusicPlayController */
/* renamed from: com.baidu.carlife.logic.music.h */
public class C1818h {
    /* renamed from: H */
    private static C1818h f5588H = null;
    /* renamed from: I */
    private static final Object f5589I = new Object();
    /* renamed from: a */
    public static final String f5590a = "CarLifeMusic";
    /* renamed from: b */
    public static final int f5591b = 0;
    /* renamed from: c */
    public static final int f5592c = 1;
    /* renamed from: d */
    public static final int f5593d = 2;
    /* renamed from: e */
    public static final int f5594e = 3;
    /* renamed from: f */
    public static final int f5595f = -1;
    /* renamed from: g */
    public static final String f5596g = "localPlayStrategy";
    /* renamed from: h */
    public static String f5597h = "单曲模式";
    /* renamed from: i */
    public static String f5598i = "随机模式";
    /* renamed from: j */
    public static String f5599j = "循环模式";
    /* renamed from: k */
    public static final String f5600k = "LastestPlaySource";
    /* renamed from: l */
    public static final int f5601l = 2;
    /* renamed from: o */
    private static final int f5602o = 1;
    /* renamed from: A */
    private MusicSongModel f5603A = null;
    /* renamed from: B */
    private MusicSongModel f5604B = null;
    /* renamed from: C */
    private boolean f5605C = false;
    /* renamed from: D */
    private boolean f5606D = true;
    /* renamed from: E */
    private List<MusicSongModel> f5607E;
    /* renamed from: F */
    private ArrayList<String> f5608F;
    /* renamed from: G */
    private List<MusicSongModel> f5609G;
    /* renamed from: J */
    private int f5610J;
    /* renamed from: K */
    private int f5611K;
    /* renamed from: L */
    private ArrayList<MusicSongModel> f5612L = new ArrayList();
    /* renamed from: M */
    private C2587a f5613M;
    /* renamed from: N */
    private HandlerThread f5614N;
    /* renamed from: O */
    private HandlerThread f5615O;
    /* renamed from: P */
    private C0936j f5616P;
    /* renamed from: Q */
    private Handler f5617Q;
    /* renamed from: R */
    private Handler f5618R;
    /* renamed from: S */
    private Context f5619S;
    /* renamed from: T */
    private C2164a f5620T;
    /* renamed from: U */
    private C1785a f5621U;
    /* renamed from: V */
    private C1800g f5622V;
    /* renamed from: W */
    private C1702j f5623W;
    /* renamed from: X */
    private Bundle f5624X;
    /* renamed from: Y */
    private ServiceConnection f5625Y = new C18042(this);
    /* renamed from: m */
    private int f5626m;
    /* renamed from: n */
    private int f5627n = -1;
    /* renamed from: p */
    private boolean f5628p = false;
    /* renamed from: q */
    private long f5629q = -1;
    /* renamed from: r */
    private long f5630r = -1;
    /* renamed from: s */
    private boolean f5631s = false;
    /* renamed from: t */
    private boolean f5632t = true;
    /* renamed from: u */
    private int f5633u = 1;
    /* renamed from: v */
    private int f5634v = 0;
    /* renamed from: w */
    private boolean f5635w = true;
    /* renamed from: x */
    private boolean f5636x = false;
    /* renamed from: y */
    private boolean f5637y = false;
    /* renamed from: z */
    private int f5638z = 5;

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$1 */
    class C18011 implements C1712b {
        /* renamed from: a */
        final /* synthetic */ C1818h f5567a;

        C18011(C1818h this$0) {
            this.f5567a = this$0;
        }

        /* renamed from: a */
        public void mo1662a() {
            this.f5567a.ae();
        }

        /* renamed from: b */
        public void mo1664b() {
            this.f5567a.ad();
        }

        /* renamed from: c */
        public void mo1666c() {
            this.f5567a.ac();
        }

        /* renamed from: a */
        public void mo1663a(boolean flag) {
            if (this.f5567a.m6829q()) {
                this.f5567a.m6807e(flag);
            } else {
                this.f5567a.m6803d(flag);
            }
        }

        /* renamed from: b */
        public void mo1665b(boolean flag) {
            this.f5567a.m6811f(flag);
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$2 */
    class C18042 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ C1818h f5570a;

        /* compiled from: MusicPlayController */
        /* renamed from: com.baidu.carlife.logic.music.h$2$1 */
        class C18031 implements C1802m {
            /* renamed from: a */
            final /* synthetic */ C18042 f5569a;

            C18031(C18042 this$1) {
                this.f5569a = this$1;
            }

            /* renamed from: a */
            public void mo1667a() {
                if (this.f5569a.f5570a.m6829q()) {
                    this.f5569a.f5570a.m6709L();
                } else {
                    this.f5569a.f5570a.m6708K();
                }
            }

            /* renamed from: b */
            public void mo1670b() {
                this.f5569a.f5570a.m6811f(false);
            }

            /* renamed from: a */
            public void mo1669a(boolean isManual) {
                if (this.f5569a.f5570a.m6829q()) {
                    this.f5569a.f5570a.m6807e(isManual);
                } else {
                    this.f5569a.f5570a.m6803d(isManual);
                }
            }

            /* renamed from: a */
            public void mo1668a(int errorType, int errorCode1, int errorCode2, Object errorObj) {
                this.f5569a.f5570a.m6784a(errorType, errorCode1, errorCode2, errorObj);
            }
        }

        C18042(C1818h this$0) {
            this.f5570a = this$0;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            C1260i.m4435b(C1818h.f5590a, "---onServiceConnected----");
            this.f5570a.f5620T = (C2164a) service;
            this.f5570a.f5620T.m8188a(new C18031(this));
        }

        public void onServiceDisconnected(ComponentName name) {
            C1260i.m4435b(C1818h.f5590a, "---onServiceDisconnected----");
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$3 */
    class C18053 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1818h f5571a;

        C18053(C1818h this$0) {
            this.f5571a = this$0;
        }

        public void run() {
            if (this.f5571a.f5604B != null) {
                long totalSize = this.f5571a.f5604B.f5923o;
                long downloadSize = this.f5571a.f5604B.f5922n;
                String id = this.f5571a.f5604B.f5909a;
                if (downloadSize >= totalSize && totalSize != 0) {
                    String path = this.f5571a.f5604B.f5921m;
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    int musicDuration = 0;
                    try {
                        mediaPlayer.setDataSource(path);
                        mediaPlayer.setAudioStreamType(3);
                        mediaPlayer.prepare();
                        musicDuration = mediaPlayer.getDuration();
                        mediaPlayer.release();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    } catch (IllegalStateException e3) {
                        e3.printStackTrace();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    if ((id != null && id.equals(this.f5571a.f5604B.f5909a)) || (path != null && path.equals(this.f5571a.f5604B.f5921m))) {
                        this.f5571a.f5604B.f5917i = String.valueOf(musicDuration);
                        try {
                            this.f5571a.f5633u = Integer.parseInt(this.f5571a.f5604B.f5917i) / 1000;
                        } catch (NumberFormatException e5) {
                            this.f5571a.f5633u = 1;
                        }
                        C1261k.m4452a((int) C1253f.dG);
                        C1261k.m4462b(C1253f.dG, 101);
                    }
                }
            }
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$4 */
    class C18064 implements C1782b {
        /* renamed from: a */
        final /* synthetic */ C1818h f5572a;

        C18064(C1818h this$0) {
            this.f5572a = this$0;
        }

        /* renamed from: a */
        public void mo1672a(int type) {
            this.f5572a.m6809f(type);
        }

        /* renamed from: a */
        public void mo1673a(boolean flag) {
            this.f5572a.m6811f(flag);
        }

        /* renamed from: a */
        public int mo1671a() {
            return this.f5572a.m6826n();
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$5 */
    class C18075 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1818h f5573a;

        C18075(C1818h this$0) {
            this.f5573a = this$0;
        }

        public void run() {
            this.f5573a.m6830r().m6650t();
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$6 */
    class C18086 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1818h f5574a;

        C18086(C1818h this$0) {
            this.f5574a = this$0;
        }

        public void run() {
            this.f5574a.m6830r().m6650t();
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$7 */
    class C18097 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1818h f5575a;

        C18097(C1818h this$0) {
            this.f5575a = this$0;
        }

        public void run() {
            this.f5575a.m6830r().m6650t();
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$8 */
    class C18108 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1818h f5576a;

        C18108(C1818h this$0) {
            this.f5576a = this$0;
        }

        public void run() {
            this.f5576a.aa();
        }
    }

    /* compiled from: MusicPlayController */
    /* renamed from: com.baidu.carlife.logic.music.h$a */
    private class C1817a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1818h f5587a;

        /* compiled from: MusicPlayController */
        /* renamed from: com.baidu.carlife.logic.music.h$a$2 */
        class C18132 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C1817a f5582a;

            C18132(C1817a this$1) {
                this.f5582a = this$1;
            }

            public void run() {
                this.f5582a.f5587a.aa();
            }
        }

        /* compiled from: MusicPlayController */
        /* renamed from: com.baidu.carlife.logic.music.h$a$3 */
        class C18143 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C1817a f5583a;

            C18143(C1817a this$1) {
                this.f5583a = this$1;
            }

            public void run() {
                this.f5583a.f5587a.aa();
            }
        }

        /* compiled from: MusicPlayController */
        /* renamed from: com.baidu.carlife.logic.music.h$a$5 */
        class C18165 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C1817a f5586a;

            C18165(C1817a this$1) {
                this.f5586a = this$1;
            }

            public void run() {
                this.f5586a.f5587a.f5613M.mo1969a("未能找到符合要求的歌曲");
            }
        }

        public C1817a(C1818h c1818h, Looper looper) {
            this.f5587a = c1818h;
            super(looper);
        }

        public void handleMessage(Message msg) {
            MusicSongModel song;
            final List<MusicSongModel> list;
            switch (msg.what) {
                case 1:
                    if (this.f5587a.m6828p()) {
                        this.f5587a.ao();
                        return;
                    }
                    return;
                case 217:
                    song = (MusicSongModel) msg.obj;
                    if (this.f5587a.m6829q()) {
                        this.f5587a.an();
                        return;
                    } else if ((this.f5587a.f5603A.f5909a == null || !this.f5587a.f5603A.f5909a.equals(song.m7342a())) && (this.f5587a.f5603A.f5921m == null || !this.f5587a.f5603A.f5921m.equals(song.m7371l()))) {
                        C1260i.m4435b(C1818h.f5590a, "----MSG_MUSIC_DOWNLOAD_COMPLETE--NEXTSONG-");
                        C1819i.m6843a(-1);
                        return;
                    } else {
                        this.f5587a.af();
                        return;
                    }
                case 221:
                    if (this.f5587a.m6829q()) {
                        this.f5587a.ag();
                        return;
                    } else {
                        this.f5587a.ai();
                        return;
                    }
                case 229:
                    final C1790b dataManager = this.f5587a.m6815h(this.f5587a.f5627n);
                    if (dataManager != null) {
                        list = this.f5587a.m6800d();
                        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(this.f5587a.f5603A.f5915g)) {
                            new Thread(new Runnable(this) {
                                /* renamed from: c */
                                final /* synthetic */ C1817a f5581c;

                                public void run() {
                                    this.f5581c.f5587a.f5603A.f5916h = dataManager.mo1656d(this.f5581c.f5587a.f5603A.f5915g);
                                    C1261k.m4458a((int) C1253f.dB, this.f5581c.f5587a.f5627n, this.f5581c.f5587a.f5603A.f5916h);
                                    this.f5581c.f5587a.f5622V.m6688a(this.f5581c.f5587a.f5603A, C1251e.m4358a().m4393a(this.f5581c.f5587a.f5603A.f5916h), list.size(), this.f5581c.f5587a.f5626m);
                                }
                            }).start();
                            return;
                        }
                        return;
                    }
                    return;
                case C1253f.dr /*253*/:
                    song = msg.obj;
                    if (song != null) {
                        if (msg.arg1 == 2) {
                            song.f5921m = NeteaseMusicUtils.getSimpleSongUrl(song.f5909a);
                            if (TextUtils.isEmpty(song.f5921m)) {
                                return;
                            }
                        }
                        if (song.m7342a() == null || song.m7371l() != null) {
                            song.f5922n = 0;
                            this.f5587a.m6742h(song);
                            this.f5587a.m6749k(song);
                            removeMessages(221);
                            sendEmptyMessageDelayed(221, 500);
                            return;
                        }
                        this.f5587a.f5623W.m6188c().m7000c(this.f5587a.f5623W.m6188c().m6644n(), song.m7342a());
                        return;
                    }
                    return;
                case 260:
                    this.f5587a.m6717T();
                    return;
                case 307:
                    if (this.f5587a.m6829q()) {
                        if (this.f5587a.f5604B != null) {
                            C1261k.m4455a(307, this.f5587a.f5604B.f5918j, 101, 1000);
                            if (this.f5587a.f5604B.f5919k) {
                                this.f5587a.ab();
                            }
                            this.f5587a.am();
                            return;
                        }
                        return;
                    } else if (this.f5587a.f5603A != null) {
                        C1261k.m4455a(msg.what, this.f5587a.f5603A.f5918j, this.f5587a.f5627n, 1000);
                        if (this.f5587a.f5603A.f5919k) {
                            this.f5587a.f5622V.m6687a(this.f5587a.f5603A.f5918j);
                            MusicSongModel l = this.f5587a.f5603A;
                            int i = l.f5918j;
                            l.f5918j = i + 1;
                            if (i > this.f5587a.f5633u) {
                                this.f5587a.m6790a(true, false);
                            }
                        }
                        if (!this.f5587a.m6814g(0) && !this.f5587a.m6814g(1)) {
                            this.f5587a.al();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 404:
                    C1260i.m4445e(C1818h.f5590a, "----MSG_MUSIC_AUDIO_DECODER_ERROR--");
                    if (!this.f5587a.m6829q() || this.f5587a.f5604B.f5922n > this.f5587a.f5604B.f5923o / 2) {
                        C2201w.m8373a(this.f5587a.f5619S.getString(C0965R.string.module_music_invalid_song_hint), 0);
                        this.f5587a.f5618R.post(new C18132(this));
                        return;
                    }
                    removeMsg(221);
                    sendEmptyMessageDelayed(221, 1000);
                    return;
                case 407:
                    if (this.f5587a.m6829q()) {
                        list = this.f5587a.f5623W.m6188c().mo1659g();
                        if (list != null && !list.isEmpty() && this.f5587a.f5604B != null && !TextUtils.isEmpty(this.f5587a.f5604B.f5910b)) {
                            this.f5587a.f5622V.m6688a(this.f5587a.f5604B, C1251e.m4358a().m4393a(this.f5587a.f5604B.f5916h), list.size(), 2);
                            return;
                        }
                        return;
                    }
                    list = this.f5587a.m6800d();
                    if (list != null && !list.isEmpty()) {
                        this.f5587a.f5622V.m6688a(this.f5587a.f5603A, C1251e.m4358a().m4393a(this.f5587a.f5603A.f5916h), list.size(), this.f5587a.f5626m);
                        return;
                    }
                    return;
                case 416:
                    C1260i.m4445e(C1818h.f5590a, "----MSG_MUSIC_AUDIO_DECODER_ERROR_NO_INPUT_DATA--");
                    if (this.f5587a.m6814g(0) && this.f5587a.m6816h().f5918j < this.f5587a.f5633u - 20) {
                        this.f5587a.f5618R.post(new C18143(this));
                        return;
                    }
                    return;
                case 423:
                    if (msg.obj != null && (msg.obj instanceof ArrayList)) {
                        this.f5587a.f5612L = (ArrayList) msg.obj;
                        msg.obj = null;
                        if (this.f5587a.f5612L.size() > 0) {
                            final ArrayList searchResultList = new ArrayList();
                            C1823k.m6859a(this.f5587a.f5612L, searchResultList);
                            this.f5587a.f5618R.post(new Runnable(this) {
                                /* renamed from: b */
                                final /* synthetic */ C1817a f5585b;

                                public void run() {
                                    this.f5585b.f5587a.f5613M.mo1970a(searchResultList);
                                }
                            });
                            return;
                        }
                        this.f5587a.f5618R.post(new C18165(this));
                        return;
                    }
                    return;
                case 424:
                    this.f5587a.m6790a(true, true);
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(217);
            addMsg(307);
            addMsg(407);
            addMsg(404);
            addMsg(416);
            addMsg(423);
            addMsg(424);
        }
    }

    /* renamed from: a */
    public void m6782a() {
        this.f5619S = BaiduNaviApplication.getInstance().getApplicationContext();
        this.f5614N = new HandlerThread("MusicPlayController");
        this.f5614N.start();
        this.f5615O = new HandlerThread("CostTimeThread");
        this.f5615O.start();
        this.f5616P = new C1817a(this, this.f5614N.getLooper());
        C1261k.m4460a(this.f5616P);
        this.f5617Q = new Handler(this.f5615O.getLooper());
        this.f5618R = new Handler(this.f5619S.getMainLooper());
        this.f5607E = new CopyOnWriteArrayList();
        this.f5609G = new CopyOnWriteArrayList();
        this.f5608F = new ArrayList();
        this.f5626m = C2186p.m8304a().m8307a(f5596g, 2);
        f5597h = this.f5619S.getResources().getString(C0965R.string.music_mode_single);
        f5598i = this.f5619S.getResources().getString(C0965R.string.music_mode_random);
        f5599j = this.f5619S.getResources().getString(C0965R.string.music_mode_circle);
        this.f5619S.bindService(new Intent(this.f5619S, MusicPlayService.class), this.f5625Y, 1);
        C1746b.m6334a().m6336a(this.f5619S, new C18011(this));
        this.f5621U = new C1785a();
        this.f5621U.m6565a(this.f5619S, new C18064(this));
        this.f5622V = new C1800g(this.f5619S);
        m6719V();
        m6720W();
        this.f5623W = C1702j.m6181a();
        this.f5624X = new Bundle();
    }

    /* renamed from: b */
    public static synchronized C1818h m6730b() {
        C1818h c1818h;
        synchronized (C1818h.class) {
            if (f5588H == null) {
                f5588H = new C1818h();
            }
            c1818h = f5588H;
        }
        return c1818h;
    }

    /* renamed from: c */
    public void m6795c() {
        m6811f(true);
        ((C1798e) m6815h(0)).mo1661z();
        m6827o();
        m6832t();
        if (this.f5619S != null) {
            try {
                this.f5619S.unbindService(this.f5625Y);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /* renamed from: d */
    public List<MusicSongModel> m6800d() {
        return m6780a(this.f5627n);
    }

    /* renamed from: a */
    public List<MusicSongModel> m6781a(int type, String listId) {
        C1790b dataManager = m6815h(type);
        if (dataManager == null) {
            return null;
        }
        return dataManager.m6625f(listId);
    }

    /* renamed from: a */
    public List<MusicSongModel> m6780a(int type) {
        C1790b dataManager = m6815h(type);
        if (dataManager == null) {
            return null;
        }
        return dataManager.mo1659g();
    }

    /* renamed from: e */
    public int m6804e() {
        return m6791b(this.f5627n);
    }

    /* renamed from: b */
    public int m6791b(int type) {
        C1790b dataManager = m6815h(type);
        if (dataManager == null) {
            return 0;
        }
        return dataManager.m6643m();
    }

    /* renamed from: c */
    public void m6796c(int index) {
        m6783a(this.f5627n, index);
    }

    /* renamed from: a */
    public void m6783a(int type, int index) {
        C1790b dataManager = m6815h(type);
        if (dataManager != null) {
            dataManager.m6627f(index);
        }
    }

    /* renamed from: f */
    public int m6808f() {
        C1790b dataManager = m6815h(m6826n());
        return dataManager != null ? dataManager.m6649s() : 0;
    }

    /* renamed from: d */
    public void m6801d(int index) {
        this.f5621U.m6571c(index);
    }

    /* renamed from: g */
    public int m6812g() {
        return this.f5621U.m6576f();
    }

    /* renamed from: a */
    public String m6779a(String packageName) {
        return this.f5621U.m6570c(packageName);
    }

    /* renamed from: h */
    public MusicSongModel m6816h() {
        return this.f5603A;
    }

    /* renamed from: i */
    public MusicSongModel m6817i() {
        return this.f5604B;
    }

    /* renamed from: g */
    private void m6739g(MusicSongModel song) {
        this.f5603A = song;
        this.f5628p = true;
    }

    /* renamed from: j */
    public String m6818j() {
        return m6830r().m6644n();
    }

    /* renamed from: a */
    public void m6787a(MusicSongModel song) {
        if (song != null) {
            song.f5918j = 0;
            song.f5919k = false;
            song.f5920l = false;
            song.f5916h = null;
        }
    }

    /* renamed from: k */
    public int m6820k() {
        return this.f5626m;
    }

    /* renamed from: l */
    public boolean m6823l() {
        return this.f5635w;
    }

    /* renamed from: m */
    public void m6825m() {
        int i = this.f5626m + 1;
        this.f5626m = i;
        this.f5626m = i % 3;
        this.f5616P.sendEmptyMessage(407);
        m6723Z();
    }

    /* renamed from: e */
    public void m6805e(int strategy) {
        this.f5626m = strategy;
        C1261k.m4461b(407);
        m6723Z();
    }

    /* renamed from: n */
    public int m6826n() {
        return this.f5627n;
    }

    /* renamed from: f */
    public void m6809f(int type) {
        if (type >= 0 && type < 100) {
            this.f5627n = type;
            C2186p.m8304a().m8319b(f5600k, m6755o(type));
        }
    }

    /* renamed from: g */
    public boolean m6814g(int type) {
        return m6826n() == type;
    }

    /* renamed from: a */
    public int m6777a(int listLength, int index, boolean isNext) {
        return C1819i.m6839a(m6820k(), listLength, index, isNext, true);
    }

    /* renamed from: o */
    public void m6827o() {
        C2186p.m8304a().m8317b(f5596g, this.f5626m);
    }

    /* renamed from: p */
    public boolean m6828p() {
        return this.f5603A != null && this.f5603A.f5919k;
    }

    /* renamed from: q */
    public boolean m6829q() {
        return this.f5605C;
    }

    /* renamed from: b */
    public C1790b m6792b(String packageName) {
        return this.f5621U.m6567b(packageName);
    }

    /* renamed from: h */
    public C1790b m6815h(int type) {
        return this.f5621U.m6563a(type);
    }

    /* renamed from: r */
    public C1790b m6830r() {
        return this.f5621U.m6566b();
    }

    /* renamed from: s */
    public C1845r m6831s() {
        return this.f5623W.m6188c();
    }

    /* renamed from: K */
    private void m6708K() {
        this.f5632t = true;
        this.f5636x = true;
        this.f5635w = false;
        this.f5634v = 0;
        this.f5603A.f5919k = true;
        this.f5603A.f5918j = 0;
        try {
            this.f5633u = Integer.parseInt(this.f5603A.f5917i) / 1000;
        } catch (NumberFormatException e) {
            this.f5633u = 1;
        }
        if (this.f5629q == -1) {
            this.f5629q = System.currentTimeMillis();
            this.f5616P.removeMessages(1);
            this.f5616P.sendEmptyMessageDelayed(1, 3000);
        }
        this.f5622V.m6690b();
        if (this.f5627n == 1 || this.f5627n == 0) {
            C1261k.m4452a((int) C1253f.dG);
            C1261k.m4462b(C1253f.dG, this.f5627n);
        }
        this.f5616P.sendEmptyMessage(229);
        m6722Y();
        C1261k.m4454a(225, this.f5627n, 100);
        C1261k.m4462b(C1253f.dZ, C1253f.ir);
        C1772k.m6480a().m6485a(3, 1);
        m6767A();
        this.f5618R.post(new C18075(this));
        if (this.f5637y) {
            m6811f(this.f5635w);
            this.f5637y = false;
        }
        if (C1912n.m7270a().m7313l() || C1772k.m6480a().m6489c() != 0) {
            m6811f(this.f5635w);
        }
    }

    /* renamed from: L */
    private void m6709L() {
        this.f5632t = true;
        this.f5636x = true;
        this.f5635w = false;
        this.f5634v = 0;
        this.f5604B.f5919k = true;
        this.f5604B.f5918j = 0;
        try {
            this.f5633u = Integer.parseInt(this.f5604B.f5917i) / 1000;
        } catch (NumberFormatException e) {
            this.f5633u = 1;
        }
        if (this.f5629q == -1) {
            this.f5629q = System.currentTimeMillis();
            this.f5616P.removeMessages(1);
            this.f5616P.sendEmptyMessageDelayed(1, 3000);
        }
        this.f5622V.m6690b();
        C1261k.m4452a((int) C1253f.dG);
        C1261k.m4462b(C1253f.dG, 101);
        C1261k.m4462b(C1253f.dZ, C1253f.ir);
        C1605a.m5870a(this.f5604B, 200, 200);
        m6722Y();
        C1261k.m4454a(225, 101, 100);
        C1772k.m6480a().m6485a(3, 1);
        m6767A();
        if (this.f5637y) {
            m6811f(this.f5635w);
            this.f5637y = false;
        }
        if (C1912n.m7270a().m7313l() || C1772k.m6480a().m6489c() != 0) {
            m6811f(this.f5635w);
        }
    }

    /* renamed from: t */
    public void m6832t() {
        this.f5623W.m6189d().m6407a();
        if (!m6829q() && m6826n() >= 3) {
            C1995c.m7602a().m7621b(m6755o(m6826n()));
        }
    }

    /* renamed from: b */
    private void m6731b(int type, MusicSongModel song) {
        this.f5616P.removeMessages(C1253f.dr);
        this.f5616P.sendMessageDelayed(Message.obtain(this.f5616P, C1253f.dr, type, -1, song), 0);
    }

    /* renamed from: b */
    public boolean m6794b(MusicSongModel mSong) {
        for (MusicSongModel song : m6776J()) {
            if ((song.f5909a != null && song.f5909a.equals(mSong.f5909a)) || (song.f5921m != null && song.f5921m.equals(mSong.f5921m))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private synchronized void m6742h(MusicSongModel song) {
        m6776J().add(song);
        if (m6776J().size() > 3) {
            m6802d((MusicSongModel) m6776J().get(0));
        }
        if (C1251e.m4382t()) {
            for (MusicSongModel tmp : m6776J()) {
                C1260i.m4435b(f5590a, "----addBufferMusic--song:" + tmp.f5910b);
            }
        }
    }

    /* renamed from: c */
    public void m6797c(MusicSongModel song) {
        m6776J().remove(song);
        m6776J().add(song);
    }

    /* renamed from: d */
    public void m6802d(MusicSongModel removeSong) {
        int index = 0;
        removeSong.f5922n = 0;
        String songId = removeSong.f5909a;
        for (MusicSongModel song : m6776J()) {
            if ((song.f5909a == null || !song.f5909a.equals(songId)) && (song.f5921m == null || !song.f5921m.equals(removeSong.f5921m))) {
                index++;
            } else {
                MusicSongModel tmp = (MusicSongModel) m6776J().remove(index);
                if (m6776J().indexOf(tmp) < 0) {
                    File f = new File(C1253f.jm + "/" + tmp.f5909a + ".mp3");
                    if (f.exists()) {
                        f.delete();
                    }
                }
                C1260i.m4435b(f5590a, "----removeBufferMusic--song:" + tmp.f5910b);
                return;
            }
        }
    }

    /* renamed from: u */
    public void m6833u() {
        if (m6776J() != null) {
            m6776J().clear();
        }
        C1251e.m4362b(C1253f.jm, ".mp3");
    }

    /* renamed from: a */
    public void m6790a(boolean isNext, boolean isManual) {
        if (!m6829q()) {
            List<MusicSongModel> list = m6800d();
            if (list != null && !list.isEmpty()) {
                int len = list.size();
                int songIndex = C1819i.m6839a(m6820k(), len, m6804e(), isNext, isManual);
                if (songIndex < 0) {
                    C2201w.m8373a(this.f5619S.getString(C0965R.string.module_music_first_hint), 1);
                } else if (songIndex >= len) {
                    C2201w.m8373a(this.f5619S.getString(C0965R.string.module_music_last_hint), 1);
                } else {
                    m6721X();
                    m6796c(songIndex);
                    m6785a(m6826n(), (MusicSongModel) list.get(songIndex));
                }
            }
        } else if (m6775I()) {
            if (C1795c.m6660a().m6668b() != 2) {
                C1795c.m6660a().m6666a(isNext ? 4 : 3, this.f5623W.m6188c());
            }
            MusicSongModel song = m6740h(isNext);
            m6721X();
            m6811f(true);
            if (song != null) {
                m6806e(song);
            }
        } else {
            m6811f(true);
            m6837y();
        }
    }

    /* renamed from: a */
    public void m6786a(int type, boolean isNext) {
        if (!C1818h.m6745i(type)) {
            type = 0;
        }
        m6809f(type);
        m6790a(isNext, true);
    }

    /* renamed from: a */
    public void m6789a(boolean isNext) {
        m6786a(m6826n(), isNext);
    }

    /* renamed from: b */
    public void m6793b(boolean isNext) {
        if (m6829q()) {
            if (isNext) {
                StatisticManager.onEvent(StatisticConstants.CONTENT_CONTROl_0002);
                StatisticManager.onEvent(StatisticConstants.VOICE_CONTROl_0002);
            } else {
                StatisticManager.onEvent(StatisticConstants.CONTENT_CONTROl_0001);
                StatisticManager.onEvent(StatisticConstants.VOICE_CONTROl_0001);
            }
        }
        m6786a(m6826n(), isNext);
    }

    /* renamed from: c */
    public void m6799c(boolean isNext) {
        C1790b dataManager = m6830r();
        if (dataManager != null) {
            m6786a(dataManager.m6649s(), isNext);
        }
    }

    /* renamed from: a */
    public void m6784a(int errorType, int errorCode1, int errorCode2, Object errorObj) {
        switch (errorType) {
            case 1:
                if (this.f5627n != 1) {
                    return;
                }
                if (errorCode1 == 1) {
                    m6790a(true, false);
                    return;
                }
                StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0015, "音乐数据不完整" + errorCode2);
                C2372c.m9037e("thinkreed", "qq music error to switch song");
                m6789a(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    public void m6803d(boolean isManualPlayed) {
        if (this.f5603A != null && this.f5620T != null && !m6829q()) {
            if (isManualPlayed) {
                this.f5635w = false;
            }
            if (!this.f5635w && !this.f5603A.f5919k) {
                this.f5603A.f5919k = true;
                this.f5620T.m8185a(this.f5627n);
                if (this.f5629q == -1) {
                    this.f5629q = System.currentTimeMillis();
                    this.f5616P.removeMessages(1);
                    this.f5616P.sendEmptyMessageDelayed(1, 3000);
                }
                C1261k.m4462b(225, this.f5627n);
                this.f5616P.sendEmptyMessage(407);
                C1772k.m6480a().m6485a(3, 1);
                this.f5618R.post(new C18086(this));
            }
        }
    }

    /* renamed from: e */
    public void m6807e(boolean isManualPlayed) {
        if (this.f5604B != null && this.f5620T != null && m6829q()) {
            if (isManualPlayed) {
                this.f5635w = false;
            }
            if (!this.f5635w && !this.f5604B.f5919k && this.f5623W.m6188c().mo1696p() == this.f5604B) {
                this.f5604B.f5919k = true;
                this.f5620T.m8185a(101);
                if (this.f5629q == -1) {
                    this.f5629q = System.currentTimeMillis();
                    this.f5616P.removeMessages(1);
                    this.f5616P.sendEmptyMessageDelayed(1, 3000);
                }
                C1261k.m4462b(225, 101);
                this.f5616P.sendEmptyMessage(407);
                C1772k.m6480a().m6485a(3, 1);
            }
        }
    }

    /* renamed from: f */
    public void m6811f(boolean isManualPaused) {
        if (this.f5620T != null) {
            if (!this.f5635w) {
                this.f5635w = isManualPaused;
            }
            if (isManualPaused) {
                this.f5630r = System.currentTimeMillis();
            }
            if (this.f5603A != null && this.f5603A.f5919k) {
                this.f5616P.removeMessages(1);
                this.f5603A.f5919k = false;
                this.f5620T.m8184a();
                C1261k.m4462b(225, this.f5627n);
                C1772k.m6480a().m6485a(3, 0);
                this.f5618R.post(new C18097(this));
                ap();
            } else if (this.f5604B != null && this.f5604B.f5919k) {
                this.f5616P.removeMessages(1);
                this.f5604B.f5919k = false;
                C1834p.m6925a().m6927c();
                this.f5620T.m8184a();
                C1261k.m4462b(225, 101);
                C1772k.m6480a().m6485a(3, 0);
                ap();
            }
        }
    }

    /* renamed from: a */
    public void m6785a(final int type, MusicSongModel song) {
        m6832t();
        if (this.f5620T != null && song != null && C1818h.m6745i(type)) {
            m6813g(false);
            m6811f(true);
            m6729a(this.f5604B, 101);
            m6809f(type);
            m6774H();
            m6787a(this.f5603A);
            m6739g(song);
            this.f5634v = 0;
            this.f5636x = false;
            m6715R();
            if (type == 0) {
                m6768B();
                if (song.f5917i == null) {
                    this.f5638z = 5;
                    m6780a(0).add(0, song);
                    m6731b(this.f5627n, this.f5603A);
                    m6815h(type).m6613b(m6818j());
                    return;
                }
                C1261k.m4452a((int) C1253f.dG);
                C1261k.m4462b(C1253f.dG, type);
                this.f5616P.sendEmptyMessageDelayed(260, 500);
            } else if (type != 1 || song.f5921m == null) {
                if (m6775I()) {
                    if (!this.f5631s) {
                        m6768B();
                    }
                    C1261k.m4452a((int) C1253f.dG);
                    C1261k.m4462b(C1253f.dG, type);
                    if (type == 2) {
                        this.f5638z = 5;
                        m6718U();
                        return;
                    } else if (type == 1) {
                        this.f5620T.m8186a(type, song);
                        return;
                    } else if (type >= 3) {
                        this.f5638z = 15;
                        m6718U();
                        return;
                    } else {
                        return;
                    }
                }
                this.f5618R.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C1818h f5578b;

                    public void run() {
                        C2201w.m8373a("网络异常", 0);
                        C1790b dataManager = this.f5578b.m6815h(type);
                        if (dataManager != null) {
                            dataManager.m6634i(3);
                        }
                    }
                });
            } else if (new File(song.f5921m).exists()) {
                this.f5620T.m8186a(type, song);
            } else {
                this.f5618R.post(new C18108(this));
            }
        }
    }

    /* renamed from: v */
    public boolean m6834v() {
        if (m6829q() && this.f5604B != null && this.f5604B.f5919k) {
            return true;
        }
        return false;
    }

    /* renamed from: w */
    public boolean m6835w() {
        if (!m6829q() || this.f5604B == null || this.f5604B.f5919k) {
            return false;
        }
        return true;
    }

    /* renamed from: x */
    public void m6836x() {
        if (m6829q()) {
            m6807e(true);
        } else if (this.f5623W.m6188c().m6644n() != null) {
            m6806e(this.f5623W.m6188c().mo1696p());
        } else {
            C2105a defaultRadioChannel = C2142b.m8067a().m8078d();
            if (defaultRadioChannel != null) {
                this.f5623W.m6188c().m6623e(defaultRadioChannel.m7893a());
                m6806e(this.f5623W.m6188c().mo1696p());
            }
        }
    }

    /* renamed from: c */
    public void m6798c(String listId) {
        if (this.f5620T != null && listId != null) {
            int channelId = 0;
            try {
                channelId = Integer.valueOf(listId).intValue();
            } catch (NumberFormatException e) {
            }
            this.f5623W.m6184a(channelId);
            if (!listId.equals(this.f5623W.m6188c().m6644n())) {
                if (m6834v()) {
                    C1795c.m6660a().m6666a(4, this.f5623W.m6188c());
                }
                m6811f(true);
                this.f5623W.m6188c().m6623e(listId);
                m6806e(this.f5623W.m6188c().mo1696p());
            } else if (m6829q()) {
                m6807e(true);
            } else {
                m6806e(this.f5623W.m6188c().mo1696p());
            }
        }
    }

    /* renamed from: e */
    public void m6806e(MusicSongModel song) {
        m6832t();
        ((C1759e) C1688d.m6148b().m6137a(MusicPlayerFragment.class.getName())).m6407a();
        if (this.f5620T != null && song != null) {
            m6715R();
            m6813g(true);
            m6811f(true);
            m6729a(this.f5603A, m6826n());
            if (m6775I()) {
                m6744i(song);
                m6747j(song);
                m6714Q();
                m6713P();
                if (!this.f5631s) {
                    m6768B();
                }
                C1261k.m4452a((int) C1253f.dG);
                C1261k.m4462b(C1253f.dG, 101);
                this.f5638z = 15;
                if (this.f5623W.m6192g()) {
                    m6712O();
                    return;
                } else if (m6711N()) {
                    m6710M();
                    m6832t();
                    return;
                } else if (m6794b(this.f5604B)) {
                    if (this.f5604B.f5922n < 0) {
                        this.f5604B.f5922n = 0;
                    }
                    m6797c(song);
                    m6749k(song);
                    m6710M();
                    return;
                } else {
                    m6731b(101, this.f5604B);
                    return;
                }
            }
            m6837y();
        }
    }

    /* renamed from: i */
    private void m6744i(MusicSongModel song) {
        if (song.f5922n > 0 && song.f5922n < song.f5923o) {
            song.f5922n = 0;
            song.f5923o = 0;
        }
    }

    /* renamed from: M */
    private void m6710M() {
        this.f5616P.removeMessages(221);
        this.f5616P.sendEmptyMessageDelayed(221, 0);
    }

    /* renamed from: N */
    private boolean m6711N() {
        return this.f5604B.f5922n > 0 && this.f5604B.f5922n >= this.f5604B.f5923o;
    }

    /* renamed from: O */
    private void m6712O() {
        this.f5623W.m6189d().m6407a();
        this.f5608F.clear();
        this.f5623W.m6189d().mo1644b(this.f5604B.f5921m);
        this.f5616P.removeMessages(221);
        this.f5616P.sendEmptyMessageDelayed(221, 500);
    }

    /* renamed from: P */
    private void m6713P() {
        if (C1702j.m6181a().m6187b() != 3) {
            int songIndex = this.f5623W.m6188c().m6643m();
            List<MusicSongModel> list = this.f5623W.m6188c().mo1659g();
            if (list != null && songIndex >= list.size() - 1) {
                this.f5623W.m6188c().mo1654a(0, this.f5623W.m6188c().m6644n());
            }
        }
    }

    /* renamed from: Q */
    private void m6714Q() {
        StatisticManager.onEvent("CONTENT_REC_0001_VOICE");
        StatisticManager.onEvent(C2142b.m8067a().m8077c(this.f5623W.m6188c().m6644n()).m7899d() + "_VOICE");
    }

    /* renamed from: y */
    public void m6837y() {
        this.f5618R.post(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ C1818h f5565a;

            {
                this.f5565a = this$0;
            }

            public void run() {
                C2201w.m8373a("网络异常", 0);
                if (this.f5565a.f5623W.m6188c() != null) {
                    this.f5565a.f5623W.m6188c().m6634i(3);
                }
            }
        });
    }

    /* renamed from: j */
    private void m6747j(MusicSongModel song) {
        m6787a(this.f5604B);
        this.f5604B = song;
        this.f5634v = 0;
        this.f5636x = false;
    }

    /* renamed from: a */
    private void m6729a(MusicSongModel currentPlayingSong, int songType) {
        if (currentPlayingSong != null) {
            m6787a(currentPlayingSong);
        }
        C1261k.m4452a((int) C1253f.dG);
        C1261k.m4462b(C1253f.dG, songType);
    }

    /* renamed from: R */
    private void m6715R() {
        this.f5616P.removeMessages(260);
        this.f5616P.removeMessages(221);
    }

    /* renamed from: z */
    public boolean m6838z() {
        List<MusicSongModel> list;
        if (C1818h.m6745i(this.f5627n)) {
            list = m6780a(this.f5627n);
            if (list == null || list.isEmpty()) {
                return true;
            }
        }
        aj();
        list = m6780a(0);
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m6745i(int type) {
        if (type == 101 || type == 0 || type == 2 || type == 1 || type >= 3) {
            return true;
        }
        return false;
    }

    /* renamed from: A */
    public void m6767A() {
        if (this.f5604B != null) {
            this.f5604B.f5920l = false;
        }
        if (this.f5603A != null) {
            this.f5603A.f5920l = false;
        }
        C2342g.m8864e().m8895f();
    }

    /* renamed from: B */
    public void m6768B() {
        if (m6829q()) {
            if (this.f5604B != null) {
                this.f5604B.f5920l = true;
            }
            if (this.f5603A != null) {
                this.f5603A.f5920l = false;
            }
        } else {
            if (this.f5604B != null) {
                this.f5604B.f5920l = false;
            }
            if (this.f5603A != null) {
                this.f5603A.f5920l = true;
            }
        }
        NaviFragmentManager fragManager = C1328h.m4757a().getNaviFragmentManager();
        if (fragManager.isCarlifeMusicFragment(fragManager.getCurrentFragmentType())) {
            C2342g.m8864e().m8886a((int) C0965R.string.progress_loading);
        } else if (m6829q() && m6753n(fragManager.getCurrentFragmentType())) {
            C2342g.m8864e().m8886a((int) C0965R.string.progress_loading);
        }
    }

    /* renamed from: n */
    private boolean m6753n(int type) {
        if (type == NaviFragmentManager.TYPE_HOME || type == NaviFragmentManager.TYPE_RADIO_PLAYER || type == NaviFragmentManager.TYPE_RADIO_CHANNEL) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public void m6819j(int type) {
        this.f5634v = 0;
        this.f5637y = false;
        C1261k.m4462b(C1253f.dH, type);
        m6767A();
    }

    /* renamed from: a */
    public int m6778a(String singer, String songName) {
        if (TextUtils.isEmpty(songName) && TextUtils.isEmpty(singer)) {
            return m6716S();
        }
        return 0;
    }

    /* renamed from: k */
    public void m6821k(int pos) {
        if (this.f5612L == null || pos < 0 || pos >= this.f5612L.size()) {
            C1260i.m4445e(f5590a, "param error");
            return;
        }
        MusicSongModel song = (MusicSongModel) this.f5612L.get(pos);
        if (this.f5610J == 0) {
            this.f5611K = 0;
            m6783a(0, m6815h(0).mo1659g().indexOf(song));
            aj();
        } else if (2 == this.f5610J) {
            this.f5611K = 2;
            C1790b bmd = m6815h(this.f5611K);
            bmd.m6623e(C1799f.f5533C);
            bmd.m6606a(C1799f.f5534D);
            bmd.m6627f(pos);
            List lastSearchResult = bmd.m6625f(C1799f.f5533C);
            if (lastSearchResult != null) {
                lastSearchResult.clear();
            } else {
                bmd.m6608a(C1799f.f5533C, new ArrayList());
            }
            bmd.m6608a(C1799f.f5533C, this.f5612L);
            bmd.m6642l();
            ak();
        }
        m6785a(this.f5611K, song);
    }

    /* renamed from: f */
    public void m6810f(MusicSongModel songWeChat) {
        String songName = songWeChat.f5910b;
        String singer = songWeChat.f5914f;
        songWeChat.f5909a = songWeChat.f5921m;
        List<MusicSongModel> list = m6780a(0);
        List<MusicSongModel> searchSongList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            int count;
            if (TextUtils.isEmpty(songName) && !TextUtils.isEmpty(singer)) {
                count = C1819i.m6841a(list, searchSongList, singer);
            } else if (TextUtils.isEmpty(songName) || !TextUtils.isEmpty(singer)) {
                count = C1819i.m6842a(list, searchSongList, songName, singer);
            } else {
                count = C1819i.m6844b(list, searchSongList, songName);
            }
            if (count >= 1) {
                MusicSongModel song = (MusicSongModel) searchSongList.get(0);
                if (song.f5917i != null) {
                    m6783a(0, list.indexOf(song));
                    m6785a(0, song);
                    return;
                }
                return;
            }
        }
        m6785a(0, songWeChat);
    }

    /* renamed from: C */
    public void m6769C() {
        if (System.currentTimeMillis() - this.f5630r >= 500) {
            if (m6829q()) {
                m6836x();
            } else {
                m6716S();
            }
        }
    }

    /* renamed from: D */
    public void m6770D() {
        if (!this.f5636x) {
            this.f5637y = true;
        }
        m6811f(true);
    }

    /* renamed from: l */
    public void m6822l(int pos) {
        this.f5621U.m6568b(pos);
    }

    /* renamed from: E */
    public C0995k m6771E() {
        return this.f5621U.m6569c();
    }

    /* renamed from: F */
    public OnItemClickListener m6772F() {
        return this.f5621U.m6572d();
    }

    /* renamed from: G */
    public void m6773G() {
        this.f5621U.m6575e();
    }

    /* renamed from: m */
    public C1931j m6824m(int pos) {
        return this.f5621U.m6573d(pos);
    }

    /* renamed from: H */
    public void m6774H() {
        this.f5621U.m6564a();
    }

    /* renamed from: S */
    private int m6716S() {
        if (!C1818h.m6745i(this.f5627n)) {
            aj();
            int songIndex = m6791b(0);
            List<MusicSongModel> list = m6780a(0);
            if (list == null || list.size() <= 0) {
                return 0;
            }
            m6811f(true);
            m6785a(0, (MusicSongModel) list.get(songIndex));
            return 4;
        } else if (this.f5603A == null || this.f5603A.f5919k) {
            return -1;
        } else {
            if (!this.f5635w) {
                return 3;
            }
            m6803d(true);
            return 4;
        }
    }

    /* renamed from: a */
    public void m6788a(String singer, String songName, C2587a listener) {
        StatisticManager.onEvent(StatisticConstants.VOICE_0008);
        List<MusicSongModel> list = m6780a(0);
        if (!(list == null || list.isEmpty())) {
            int count;
            if (TextUtils.isEmpty(songName) && !TextUtils.isEmpty(singer)) {
                count = C1819i.m6841a(list, this.f5612L, singer);
            } else if (!TextUtils.isEmpty(songName) && TextUtils.isEmpty(singer)) {
                count = C1819i.m6844b(list, this.f5612L, songName);
            } else if (TextUtils.isEmpty(songName) && TextUtils.isEmpty(singer)) {
                count = C1819i.m6840a(list, this.f5612L);
            } else {
                count = C1819i.m6842a(list, this.f5612L, songName, singer);
            }
            if (count > 0) {
                this.f5610J = 0;
                List searchResultList = new ArrayList();
                C1823k.m6859a(this.f5612L, (ArrayList) searchResultList);
                listener.mo1970a(searchResultList);
                return;
            }
        }
        this.f5610J = 2;
        this.f5613M = listener;
        m6815h(2).mo1685a(singer, songName, true);
    }

    /* renamed from: T */
    private void m6717T() {
        if (m6814g(0) && !TextUtils.isEmpty(this.f5603A.f5921m)) {
            this.f5620T.m8184a();
            if (new File(this.f5603A.f5921m).exists()) {
                this.f5620T.m8186a(m6826n(), this.f5603A);
            } else {
                this.f5618R.post(new Runnable(this) {
                    /* renamed from: a */
                    final /* synthetic */ C1818h f5566a;

                    {
                        this.f5566a = this$0;
                    }

                    public void run() {
                        this.f5566a.aa();
                    }
                });
            }
        }
    }

    /* renamed from: U */
    private void m6718U() {
        if (!m6794b(this.f5603A)) {
            m6731b(this.f5627n, this.f5603A);
        } else if (this.f5603A.f5922n <= 0 || this.f5603A.f5922n < this.f5603A.f5923o) {
            m6802d(this.f5603A);
            m6731b(this.f5627n, this.f5603A);
        } else {
            m6710M();
            m6797c(this.f5603A);
            af();
        }
    }

    /* renamed from: I */
    public boolean m6775I() {
        this.f5631s = false;
        int networkStatus = C1251e.m4381s();
        if (networkStatus == 1) {
            if (!this.f5606D) {
                return true;
            }
            this.f5606D = false;
            this.f5631s = true;
            m6767A();
            return true;
        } else if (networkStatus == 2) {
            this.f5606D = true;
            return true;
        } else {
            this.f5606D = true;
            return false;
        }
    }

    /* renamed from: h */
    private MusicSongModel m6740h(boolean isNext) {
        return this.f5623W.m6183a(isNext);
    }

    /* renamed from: V */
    private void m6719V() {
        C1688d.m6148b().m6139a(MusicPlayerFragment.class.getName(), new C1771j(this.f5609G));
        C1688d.m6148b().m6139a(C1771j.class.getName(), new C1771j(this.f5607E));
        C1688d.m6148b().m6139a(C1769i.class.getName(), new C1769i(this.f5608F));
    }

    /* renamed from: W */
    private void m6720W() {
        C1702j.m6181a().m6185a(new C1845r(this.f5619S, 101, "CarLifeRadio"));
    }

    /* renamed from: X */
    private void m6721X() {
        this.f5616P.removeMessages(307);
    }

    /* renamed from: Y */
    private void m6722Y() {
        this.f5616P.removeMessages(307);
        this.f5616P.sendEmptyMessageDelayed(307, 1000);
    }

    /* renamed from: Z */
    private void m6723Z() {
        String content;
        switch (this.f5626m) {
            case 0:
                content = f5597h;
                break;
            case 1:
                content = f5598i;
                break;
            case 2:
                content = f5599j;
                break;
            default:
                return;
        }
        C2201w.m8373a(content, 0);
    }

    private void aa() {
        if (!m6829q()) {
            C1790b dataManager = m6815h(m6826n());
            dataManager.m6605a(this.f5603A);
            if (m6800d() == null || m6800d().isEmpty()) {
                m6767A();
                dataManager.m6610b();
                m6809f(-1);
                return;
            }
            m6789a(true);
            C2201w.m8373a(this.f5619S.getString(C0965R.string.module_music_not_found_hint), 1);
        } else if (this.f5604B != null) {
            List<MusicSongModel> playList = this.f5623W.m6188c().mo1659g();
            if (playList != null) {
                playList.remove(this.f5604B);
            }
            this.f5604B = this.f5623W.m6188c().mo1696p();
            m6806e(this.f5604B);
        }
    }

    private void ab() {
        if (this.f5623W.m6192g()) {
            if (this.f5604B.f5918j > this.f5633u) {
                this.f5604B.f5918j = 1;
            }
            C1800g c1800g = this.f5622V;
            MusicSongModel musicSongModel = this.f5604B;
            int i = musicSongModel.f5918j;
            musicSongModel.f5918j = i + 1;
            c1800g.m6687a(i);
            return;
        }
        this.f5622V.m6687a(this.f5604B.f5918j);
        MusicSongModel musicSongModel2 = this.f5604B;
        int i2 = musicSongModel2.f5918j;
        musicSongModel2.f5918j = i2 + 1;
        if (i2 > this.f5633u) {
            C1795c.m6660a().m6666a(2, this.f5623W.m6188c());
            m6790a(true, false);
        }
    }

    /* renamed from: g */
    public void m6813g(boolean radioPlayMode) {
        this.f5605C = radioPlayMode;
    }

    /* renamed from: J */
    public List<MusicSongModel> m6776J() {
        return m6829q() ? this.f5607E : this.f5609G;
    }

    /* renamed from: o */
    private String m6755o(int type) {
        return this.f5621U.m6574e(type);
    }

    private void ac() {
        if (this.f5620T != null) {
            this.f5620T.m8191d();
        }
    }

    private void ad() {
        if (this.f5620T != null) {
            this.f5620T.m8189b();
        }
    }

    private void ae() {
        if (this.f5620T != null) {
            this.f5620T.m8190c();
        }
    }

    /* renamed from: k */
    private void m6749k(MusicSongModel song) {
        m6832t();
        C1260i.m4435b(f5590a, "----startDownloadSong---0----");
        if (C2181l.m8283a(C1253f.jm) <= 10000000) {
            m6833u();
            if (C2181l.m8283a(C1253f.jm) <= 10000000) {
                C2201w.m8373a(this.f5619S.getString(C0965R.string.module_music_insufficient_storage_hint), 1);
                return;
            }
        }
        if (m6829q()) {
            this.f5623W.m6189d().m6412b();
        } else if (this.f5627n >= 3) {
            C1260i.m4435b(f5590a, "----startDownloadSong---MUSIC_TYPE_THIRDPARTY----");
            C1995c.m7602a().m7617a(m6755o(this.f5627n), song);
        } else if (this.f5627n == 2 || this.f5627n == 0) {
            C1260i.m4435b(f5590a, "----startDownloadSong---NETEASE or WECHAT----");
            C1759e musicThread = (C1759e) C1688d.m6148b().m6137a(MusicPlayerFragment.class.getName());
            if (musicThread != null) {
                if (!musicThread.isAlive()) {
                    musicThread.start();
                }
                musicThread.m6412b();
            }
        }
    }

    private void af() {
        List<MusicSongModel> list = m6800d();
        if (list != null) {
            int nextIndex = m6777a(list.size(), m6804e(), true);
            if (this.f5626m == 1) {
                C1819i.m6843a(nextIndex);
            }
            try {
                MusicSongModel nextSong = (MusicSongModel) list.get(nextIndex);
                if (!m6794b(nextSong)) {
                    m6742h(nextSong);
                } else if (nextSong.f5922n <= 0 || nextSong.f5922n < nextSong.f5923o) {
                    m6802d(nextSong);
                    m6742h(nextSong);
                } else {
                    return;
                }
                if (this.f5627n == 2) {
                    nextSong.f5921m = NeteaseMusicUtils.getSimpleSongUrl(nextSong.f5909a);
                }
                m6749k(nextSong);
            } catch (IndexOutOfBoundsException e) {
                C1260i.m4445e(f5590a, "MusicListError: list size = " + list.size() + ", nextIndex = " + nextIndex);
                e.printStackTrace();
            }
        }
    }

    private void ag() {
        if (this.f5604B == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f5604B.f5909a) || !TextUtils.isEmpty(this.f5604B.f5921m)) {
            C1260i.m4435b(f5590a, "---------bufferSize11:" + this.f5604B.f5922n);
            if (this.f5604B.f5922n == -1000) {
                m6819j(m6826n());
            } else if (this.f5623W.m6192g()) {
                if (this.f5608F.size() > 2) {
                    this.f5620T.m8187a(101, this.f5604B, this.f5608F);
                    return;
                }
                r0 = this.f5634v;
                this.f5634v = r0 + 1;
                if (r0 < this.f5638z * 2) {
                    this.f5616P.removeMessages(221);
                    this.f5616P.sendEmptyMessageDelayed(221, 500);
                }
            } else if (!ah()) {
                r0 = this.f5634v;
                this.f5634v = r0 + 1;
                if (r0 < this.f5638z * 2) {
                    this.f5616P.removeMessages(221);
                    this.f5616P.sendEmptyMessageDelayed(221, 500);
                    return;
                }
                C1260i.m4445e(f5590a, "播放出错");
                m6819j(101);
            } else if (this.f5620T != null) {
                this.f5620T.m8186a(101, this.f5604B);
            }
        }
    }

    private boolean ah() {
        return this.f5604B.f5923o != 0 && (this.f5604B.f5922n >= this.f5604B.f5923o || (this.f5604B.f5922n > 30720 && this.f5604B.f5922n > this.f5604B.f5923o / 100));
    }

    private void ai() {
        if (this.f5603A == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f5603A.f5909a) || !TextUtils.isEmpty(this.f5603A.f5921m)) {
            C1260i.m4435b(f5590a, "---------bufferSize11:" + this.f5603A.f5922n);
            if (this.f5603A.f5922n == -1000) {
                m6819j(m6826n());
                return;
            }
            int duration;
            if (this.f5603A.f5917i == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                int i = 0;
                try {
                    mediaPlayer.setDataSource(this.f5603A.f5921m);
                    mediaPlayer.setAudioStreamType(3);
                    mediaPlayer.prepare();
                    i = mediaPlayer.getDuration();
                    mediaPlayer.release();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (SecurityException e2) {
                    e2.printStackTrace();
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                this.f5603A.f5917i = String.valueOf(i);
            }
            try {
                duration = Integer.parseInt(this.f5603A.f5917i);
            } catch (NumberFormatException e5) {
                duration = 1;
            }
            float time = (((float) this.f5603A.f5922n) / ((float) this.f5603A.f5923o)) * ((float) (duration / 1000));
            C1260i.m4435b(f5590a, "-----time:" + time);
            if (time <= 2.0f) {
                C1260i.m4435b(f5590a, "---------bufferTime:" + this.f5634v);
                int i2 = this.f5634v;
                this.f5634v = i2 + 1;
                if (i2 < this.f5638z) {
                    this.f5616P.removeMessages(221);
                    this.f5616P.sendEmptyMessageDelayed(221, 1000);
                    return;
                }
                m6819j(m6826n());
                if (m6826n() >= 3) {
                    C1995c.m7602a().m7621b(m6755o(m6826n()));
                }
            } else if (this.f5620T != null) {
                this.f5620T.m8186a(this.f5627n, this.f5603A);
            }
        }
    }

    private void aj() {
        this.f5621U.m6577g();
    }

    private void ak() {
        this.f5621U.m6579i();
    }

    private void al() {
        long totalSize = this.f5603A.f5923o;
        long downloadSize = this.f5603A.f5922n;
        try {
            long curPlaySize = (((long) (this.f5603A.f5918j + 2)) * totalSize) / ((long) this.f5633u);
            if (downloadSize < totalSize && downloadSize <= curPlaySize && this.f5632t) {
                m6811f(false);
                this.f5632t = false;
                m6768B();
                C1260i.m4435b(f5590a, "-service--is not Enough----");
            } else if ((downloadSize >= totalSize || downloadSize > curPlaySize) && !this.f5632t) {
                m6803d(false);
                this.f5632t = true;
                m6767A();
                C1260i.m4435b(f5590a, "-service-- Enough startplay----");
            }
            if (this.f5603A.f5920l) {
                C1260i.m4435b(f5590a, "---MSG_MUSIC_PLAY_UI_UPDATE------bufferTime:" + this.f5634v);
                int i = this.f5634v + 1;
                this.f5634v = i;
                if (i > 8) {
                    m6811f(true);
                    m6819j(m6826n());
                    StatisticManager.onEvent(StatisticConstants.MUSIC_NETEASE_0005, "获取歌曲数据超时");
                    return;
                }
                return;
            }
            this.f5634v = 0;
        } catch (ArithmeticException e) {
        }
    }

    private void am() {
        long totalSize = this.f5604B.f5923o;
        long downloadSize = this.f5604B.f5922n;
        try {
            long curPlaySize = (((long) (this.f5604B.f5918j + 2)) * totalSize) / ((long) this.f5633u);
            if (downloadSize < totalSize && downloadSize <= curPlaySize && this.f5632t) {
                m6811f(false);
                this.f5632t = false;
                m6768B();
                C1260i.m4435b(f5590a, "-service--is not Enough----");
            } else if ((downloadSize >= totalSize || downloadSize > curPlaySize) && !this.f5632t) {
                m6807e(false);
                this.f5632t = true;
                m6767A();
                C1260i.m4435b(f5590a, "-service-- Enough startplay----");
            }
            if (this.f5632t) {
                this.f5604B.f5920l = false;
            }
            if (this.f5604B.f5920l) {
                C1260i.m4435b(f5590a, "---MSG_MUSIC_PLAY_UI_UPDATE------bufferTime:" + this.f5634v);
                int i = this.f5634v + 1;
                this.f5634v = i;
                if (i > 8) {
                    m6811f(true);
                    m6819j(101);
                    return;
                }
                return;
            }
            this.f5634v = 0;
        } catch (ArithmeticException e) {
        }
    }

    private void an() {
        this.f5617Q.post(new C18053(this));
    }

    private void ao() {
        if (this.f5628p) {
            StatisticManager.onEvent(StatisticConstants.MUSIC_0002);
            switch (this.f5627n) {
                case 0:
                    StatisticManager.onEvent(StatisticConstants.MUSIC_BDYY_0002);
                    break;
                case 1:
                    StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0004);
                    String listName = m6815h(1).m6645o();
                    if (!listName.isEmpty()) {
                        if (!listName.equals(this.f5619S.getString(C0965R.string.module_musicqq_localmusic))) {
                            if (!listName.equals("最近播放")) {
                                if (!listName.equals(this.f5619S.getString(C0965R.string.module_musicqq_myfavourite))) {
                                    if (!listName.equals(this.f5619S.getString(C0965R.string.module_musicqq_poprank))) {
                                        if (listName.equals(this.f5619S.getString(C0965R.string.module_musicqq_hotrank))) {
                                            StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0013);
                                            break;
                                        }
                                    }
                                    StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0012);
                                    break;
                                }
                                StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0010);
                                break;
                            }
                            StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0011);
                            break;
                        }
                        StatisticManager.onEvent(StatisticConstants.MUSIC_QQ_0009);
                        break;
                    }
                    break;
                case 2:
                    StatisticManager.onEvent(StatisticConstants.MUSIC_NETEASE_0003);
                    break;
                case 3:
                    StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0004);
                    StatisticManager.onEvent(StatisticConstants.MUSIC_XMLY_0009, m6815h(3).m6645o());
                    break;
                case 4:
                    StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0004);
                    StatisticManager.onEvent(StatisticConstants.MUSIC_KAOLA_0009, m6815h(4).m6645o());
                    break;
                case 5:
                    StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0004);
                    StatisticManager.onEvent(StatisticConstants.MUSIC_CYB_0009, m6815h(5).m6645o());
                    break;
            }
            this.f5628p = false;
        }
    }

    private void ap() {
        if (this.f5629q != -1) {
            int totalPlayTime = (int) (System.currentTimeMillis() - this.f5629q);
            if (totalPlayTime > 3000) {
                if (m6829q()) {
                    StatisticManager.onEventDuration(this.f5619S, "CONTENT_REC_0001_TIME", "随心听播放时长", totalPlayTime);
                    C2105a channelModel = C2142b.m8067a().m8077c(this.f5623W.m6188c().m6644n());
                    if (channelModel != null) {
                        StatisticManager.onEventDuration(this.f5619S, channelModel.m7899d() + "_TIME", channelModel.m7895b() + "频道播放时长", totalPlayTime);
                    }
                } else {
                    switch (this.f5627n) {
                        case 0:
                            StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_BDYY_0003, "本地音乐时长", totalPlayTime);
                            break;
                        case 1:
                            StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_QQ_0005, "QQ音乐时长", totalPlayTime);
                            break;
                        case 2:
                            StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_NETEASE_0004, "网易云音乐时长", totalPlayTime);
                            break;
                        case 3:
                            StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_XMLY_0005, "喜马拉雅音乐时长", totalPlayTime);
                            break;
                        case 4:
                            StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_KAOLA_0005, "考拉音乐时长", totalPlayTime);
                            break;
                        case 5:
                            StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_CYB_0005, "车悦宝音乐时长", totalPlayTime);
                            break;
                    }
                    StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_0003, "音乐播放时长", totalPlayTime);
                    if (!NavTrajectoryController.hasConnected) {
                        StatisticManager.onEventDuration(this.f5619S, StatisticConstants.MUSIC_0006, "单机音乐播放时长", totalPlayTime);
                    }
                }
            }
            this.f5629q = -1;
        }
    }
}
