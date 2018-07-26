package com.baidu.carlife.logic.p088a;

import com.baidu.carlife.logic.C1759e;
import com.baidu.carlife.logic.C1769i;
import com.baidu.carlife.logic.C1771j;
import com.baidu.carlife.logic.music.C1845r;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: RadioStrategy */
/* renamed from: com.baidu.carlife.logic.a.j */
public class C1702j {
    /* renamed from: a */
    private C1689k f5198a;
    /* renamed from: b */
    private C1845r f5199b;
    /* renamed from: c */
    private int f5200c;
    /* renamed from: d */
    private C1759e f5201d;

    /* compiled from: RadioStrategy */
    /* renamed from: com.baidu.carlife.logic.a.j$a */
    private static class C1701a {
        /* renamed from: a */
        private static final C1702j f5197a = new C1702j();

        private C1701a() {
        }
    }

    private C1702j() {
        this.f5200c = 1;
        this.f5198a = C1689k.m6149d();
        this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1771j.class.getName());
        m6182a(this.f5201d);
    }

    /* renamed from: a */
    public static C1702j m6181a() {
        return C1701a.f5197a;
    }

    /* renamed from: b */
    public int m6187b() {
        return this.f5200c;
    }

    /* renamed from: a */
    public void m6185a(C1845r radioDataManager) {
        this.f5199b = radioDataManager;
    }

    /* renamed from: c */
    public C1845r m6188c() {
        return this.f5199b;
    }

    /* renamed from: d */
    public C1759e m6189d() {
        return this.f5201d;
    }

    /* renamed from: a */
    public void m6184a(int channelId) {
        if (this.f5200c != channelId) {
            this.f5200c = channelId;
            switch (channelId) {
                case 3:
                    this.f5198a = C1689k.m6150e();
                    this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1771j.class.getName());
                    break;
                case 4:
                    this.f5198a = C1689k.m6152g();
                    this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1771j.class.getName());
                    break;
                case 9:
                    this.f5198a = C1689k.m6151f();
                    this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1769i.class.getName());
                    break;
                default:
                    this.f5198a = C1689k.m6149d();
                    this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1771j.class.getName());
                    break;
            }
            m6182a(this.f5201d);
        }
    }

    /* renamed from: a */
    public MusicSongModel m6183a(boolean isNext) {
        return m6191f().mo1613a(isNext, m6188c());
    }

    /* renamed from: e */
    public void m6190e() {
        m6191f().mo1616a(m6188c());
    }

    /* renamed from: f */
    public C1689k m6191f() {
        return this.f5198a;
    }

    /* renamed from: g */
    public boolean m6192g() {
        if (this.f5198a == null) {
            return false;
        }
        return this.f5198a instanceof C1690e;
    }

    /* renamed from: a */
    public void m6186a(String domain) {
        Object obj = -1;
        switch (domain.hashCode()) {
            case -472838316:
                if (domain.equals(C2848p.f9324y)) {
                    obj = 1;
                    break;
                }
                break;
            case 108270587:
                if (domain.equals("radio")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.f5198a = C1689k.m6151f();
                this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1769i.class.getName());
                break;
            case 1:
                this.f5198a = C1689k.m6149d();
                this.f5201d = (C1759e) C1688d.m6148b().m6137a(C1771j.class.getName());
                break;
        }
        this.f5200c = 10;
        m6182a(this.f5201d);
    }

    /* renamed from: a */
    private void m6182a(C1759e downLoadThread) {
        if (downLoadThread != null && !downLoadThread.isAlive()) {
            downLoadThread.start();
        }
    }
}
