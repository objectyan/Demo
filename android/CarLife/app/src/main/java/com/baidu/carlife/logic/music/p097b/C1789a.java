package com.baidu.carlife.logic.music.p097b;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.logic.music.C1790b;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1838q;
import com.baidu.carlife.logic.music.p096a.C1784a;
import com.baidu.carlife.logic.music.p096a.C1784a.C1783a;
import com.baidu.carlife.logic.music.p098c.C1794a;
import com.baidu.carlife.p059c.C1141f;
import com.baidu.carlife.p059c.p060a.C1092a;
import com.baidu.carlife.p059c.p066e.C1133a;
import com.baidu.carlife.p059c.p067g.C1145a;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.DiscoverCardView;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.fragment.BaseFragment;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: QQMusicLego */
/* renamed from: com.baidu.carlife.logic.music.b.a */
public class C1789a extends C1133a<C1784a> {
    /* renamed from: a */
    private static final int f5449a = 0;
    /* renamed from: b */
    private static final int f5450b = 2;
    /* renamed from: c */
    private static final int f5451c = 1;
    /* renamed from: d */
    private static final int f5452d = 3;
    /* renamed from: e */
    private static final String f5453e = "#408FA5E3";
    /* renamed from: f */
    private C1794a f5454f;
    /* renamed from: g */
    private C1790b f5455g;
    /* renamed from: h */
    private boolean f5456h = false;
    /* renamed from: i */
    private C1953c f5457i = null;

    /* compiled from: QQMusicLego */
    /* renamed from: com.baidu.carlife.logic.music.b.a$2 */
    class C17872 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1789a f5447a;

        C17872(C1789a this$0) {
            this.f5447a = this$0;
        }

        public void onClick() {
            this.f5447a.f5457i = null;
        }
    }

    /* compiled from: QQMusicLego */
    /* renamed from: com.baidu.carlife.logic.music.b.a$3 */
    class C17883 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ C1789a f5448a;

        C17883(C1789a this$0) {
            this.f5448a = this$0;
        }

        public void onClick() {
            this.f5448a.m6591f();
            this.f5448a.f5457i = null;
        }
    }

    /* renamed from: b */
    protected /* synthetic */ void mo1623b(Object obj) {
        m6587a((C1784a) obj);
    }

    public C1789a(C1790b dataManager) {
        this.f5455g = dataManager;
        this.f5454f = new C1794a(dataManager);
    }

    /* renamed from: a */
    public void mo1424a() {
        if (!this.f5456h) {
            m6587a(null);
            m6584g();
        }
    }

    /* renamed from: g */
    private void m6584g() {
        HashMap map = ((C1838q) this.f5455g).f5706Z;
        if (map.containsKey(C1838q.f5701U)) {
            m6589a(C1838q.f5701U, ((Integer) map.get(C1838q.f5701U)).intValue());
        }
        if (map.containsKey(C1838q.f5702V)) {
            m6589a(C1838q.f5702V, ((Integer) map.get(C1838q.f5702V)).intValue());
        }
        if (map.containsKey(C1838q.f5703W)) {
            m6589a(C1838q.f5703W, ((Integer) map.get(C1838q.f5703W)).intValue());
        }
    }

    /* renamed from: a */
    public void m6589a(String albumListId, int size) {
        if (size >= 1) {
            this.f5456h = true;
            DiscoverCardView discoverCardView;
            Resources resources;
            if (C1838q.f5701U.equals(albumListId)) {
                discoverCardView = (DiscoverCardView) mo1429b().m3703a((int) C0965R.id.card_1);
                resources = discoverCardView.getContext().getResources();
                discoverCardView.m8408b(resources.getString(C0965R.string.qqmusice_album_size) + size + resources.getString(C0965R.string.qqmusice_album_size_unit));
            } else if (C1838q.f5702V.equals(albumListId)) {
                discoverCardView = (DiscoverCardView) mo1429b().m3703a((int) C0965R.id.card_3);
                resources = discoverCardView.getContext().getResources();
                discoverCardView.m8408b(resources.getString(C0965R.string.qqmusice_album_size) + size + resources.getString(C0965R.string.qqmusice_album_size_unit));
            } else if (C1838q.f5703W.equals(albumListId)) {
                discoverCardView = (DiscoverCardView) mo1429b().m3703a((int) C0965R.id.card_2);
                resources = discoverCardView.getContext().getResources();
                discoverCardView.m8408b(resources.getString(C0965R.string.qqmusice_album_size) + size + resources.getString(C0965R.string.qqmusice_album_size_unit));
            }
        }
    }

    /* renamed from: a */
    protected void m6587a(C1784a data) {
        m6581a((int) C0965R.id.card_1, C1783a.m6530a().m6533b(C1145a.m3844a((int) C0965R.string.module_musicqq_localmusic)).m6534c(C1145a.m3844a((int) C0965R.string.qqmusice_album_empty)).m6536d(C1145a.m3845a(Integer.valueOf(C0965R.drawable.music_ic_qq_downloadsong))).m6537e(C1145a.m3845a(Integer.valueOf(0))).m6535c());
        m6581a((int) C0965R.id.card_2, C1783a.m6530a().m6533b(C1145a.m3844a((int) C0965R.string.module_musicqq_myfavourite)).m6534c(C1145a.m3844a((int) C0965R.string.qqmusice_album_unlogin)).m6536d(C1145a.m3845a(Integer.valueOf(C0965R.drawable.music_ic_qq_favoriter))).m6537e(C1145a.m3845a(Integer.valueOf(2))).m6535c());
        m6581a((int) C0965R.id.card_3, C1783a.m6530a().m6533b(C1145a.m3844a((int) C0965R.string.module_musicqq_recent)).m6534c(C1145a.m3844a((int) C0965R.string.qqmusice_album_empty)).m6536d(C1145a.m3845a(Integer.valueOf(C0965R.drawable.music_ic_qq_recent))).m6537e(C1145a.m3845a(Integer.valueOf(1))).m6535c());
        m6581a((int) C0965R.id.card_4, C1783a.m6530a().m6533b(C1145a.m3844a((int) C0965R.string.module_musicqq_poprank)).m6534c(C1145a.m3844a((int) C0965R.string.qqmusice_album_recommend)).m6536d(C1145a.m3845a(Integer.valueOf(C0965R.drawable.music_ic_qq_popular))).m6537e(C1145a.m3845a(Integer.valueOf(3))).m6535c());
    }

    /* renamed from: a */
    private void m6581a(int viewId, final C1784a cardModel) {
        DiscoverCardView discoverCardView = (DiscoverCardView) mo1429b().m3703a(viewId);
        discoverCardView.setBackgroundColor(Color.parseColor(f5453e));
        discoverCardView.m8408b((String) cardModel.m6542c().m3762b());
        discoverCardView.setCardDescriptionVisibility(true);
        discoverCardView.m8407a((String) cardModel.m6540b().m3762b());
        discoverCardView.m8406a(((Integer) cardModel.m6544d().m3762b()).intValue());
        boolean isQQMusicPlaying = false;
        if (C1818h.m6730b().m6826n() == 1) {
            isQQMusicPlaying = true;
        }
        if (isQQMusicPlaying && ((String) cardModel.m6540b().m3762b()).equals(this.f5455g.m6645o())) {
            discoverCardView.setCardTitleColor(C2188r.m8328a((int) C0965R.color.cl_other_c_highlight));
        } else {
            discoverCardView.setCardTitleColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_title));
        }
        discoverCardView.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C1789a f5446b;

            public void onClick(View v) {
                if (v.getId() != C0965R.id.card_2) {
                    C1141f.m3839a().m3841a(this.f5446b.f5454f, cardModel.m6546e().m3762b(), C1092a.m3696c());
                } else if (C1838q.f5704Y) {
                    C1141f.m3839a().m3841a(this.f5446b.f5454f, cardModel.m6546e().m3762b(), C1092a.m3696c());
                } else {
                    this.f5446b.m6585h();
                }
            }
        });
    }

    /* renamed from: h */
    private void m6585h() {
        if (this.f5457i == null) {
            this.f5457i = new C1953c(C1157a.m3876a().getApplicationContext());
            this.f5457i.m7442b((int) C0965R.string.qqmusic_jump_title);
            this.f5457i.m7435a((int) C0965R.string.qqmusic_jump_msg);
            this.f5457i.m7440a(true);
            this.f5457i.m7447c((int) C0965R.string.alert_cancel);
            this.f5457i.m7438a(new C17872(this));
            this.f5457i.m7445b(true);
            this.f5457i.m7450d((int) C0965R.string.alert_confirm);
            this.f5457i.m7459r();
            this.f5457i.m7443b(new C17883(this));
            C1309g.m4699a().showDialog(this.f5457i);
        }
    }

    /* renamed from: f */
    protected void m6591f() {
        try {
            String url = "qqmusic://qq.com/other/qplayauto?p=" + URLEncoder.encode("{\"cmd\":\"login\",\"callbackurl\":\"carlife://login\",\"devicebrand\":\"Baidu\",\"deviceid\":\"xxx\"}", "utf-8");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            BaseFragment.getNaviActivity().startActivity(intent);
        } catch (Exception e) {
            C1260i.m4435b("qqmusic", "openQQMusicForLogin error:" + e.getMessage());
        }
    }

    /* renamed from: a */
    public void m6588a(Runnable runnable, long delay) {
        mo1429b().m3702a().removeCallbacks(runnable);
        mo1429b().m3702a().postDelayed(runnable, delay);
    }
}
