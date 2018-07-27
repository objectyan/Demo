package com.baidu.carlife.radio.player;

import android.os.Bundle;
import android.os.Message;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.music.C1790b.C1539c;
import com.baidu.carlife.logic.music.C1795c;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.logic.music.C1834p;
import com.baidu.carlife.logic.p088a.C1681a;
import com.baidu.carlife.logic.p088a.C1702j;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p083g.C1605a;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.C1526a;
import com.baidu.carlife.view.HomeCardMusicMelodyView;
import com.baidu.carlife.view.RadioPlayerCircleProgressView;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Random;

public class RadioPlayerFragment extends ContentFragment {
    /* renamed from: a */
    private static final String f6871a = "CarLifeRadio";
    /* renamed from: b */
    private ImageButton f6872b;
    /* renamed from: c */
    private CommonTipView f6873c;
    /* renamed from: d */
    private RadioPlayerCircleProgressView f6874d;
    /* renamed from: e */
    private ImageButton f6875e;
    /* renamed from: f */
    private ImageButton f6876f;
    /* renamed from: g */
    private ImageButton f6877g;
    /* renamed from: h */
    private ImageButton f6878h;
    /* renamed from: i */
    private ImageButton f6879i;
    /* renamed from: j */
    private TextView f6880j;
    /* renamed from: k */
    private TextView f6881k;
    /* renamed from: l */
    private LinearLayout f6882l;
    /* renamed from: m */
    private SimpleDraweeView f6883m;
    /* renamed from: n */
    private HomeCardMusicMelodyView f6884n;
    /* renamed from: o */
    private C1818h f6885o = null;
    /* renamed from: p */
    private MusicSongModel f6886p;
    /* renamed from: q */
    private int f6887q = 0;
    /* renamed from: r */
    private boolean f6888r = false;
    /* renamed from: s */
    private C1539c f6889s = new C21571(this);
    /* renamed from: t */
    private OnClickListener f6890t = new C21582(this);
    /* renamed from: u */
    private MsgBaseHandler f6891u = new C21593(this);
    /* renamed from: v */
    private Runnable f6892v = new C21615(this);
    /* renamed from: w */
    private C1443g f6893w;
    /* renamed from: x */
    private C1443g f6894x;

    /* renamed from: com.baidu.carlife.radio.player.RadioPlayerFragment$1 */
    class C21571 implements C1539c {
        /* renamed from: a */
        final /* synthetic */ RadioPlayerFragment f6865a;

        C21571(RadioPlayerFragment this$0) {
            this.f6865a = this$0;
        }

        /* renamed from: a */
        public void mo1585a(int status) {
            this.f6865a.m8135a(status);
        }

        /* renamed from: a */
        public void mo1584a() {
            this.f6865a.m8154i();
        }

        /* renamed from: a */
        public void mo1586a(String albumId) {
            mo1588c();
            this.f6865a.m8136a(C1702j.m6181a().m6188c().mo1696p());
            if (this.f6865a.f6888r) {
                this.f6865a.f6885o.m6806e(this.f6865a.f6886p);
            }
            this.f6865a.m8140b();
        }

        /* renamed from: b */
        public void mo1587b() {
            this.f6865a.m8134a();
        }

        /* renamed from: c */
        public void mo1588c() {
            this.f6865a.m8156j();
        }

        /* renamed from: d */
        public void mo1589d() {
        }

        /* renamed from: e */
        public void mo1590e() {
            this.f6865a.m8170q();
        }
    }

    /* renamed from: com.baidu.carlife.radio.player.RadioPlayerFragment$2 */
    class C21582 extends C1681a {
        /* renamed from: a */
        final /* synthetic */ RadioPlayerFragment f6866a;

        C21582(RadioPlayerFragment this$0) {
            this.f6866a = this$0;
        }

        /* renamed from: a */
        protected void mo1784a(View v) {
            if (C1772k.m6480a().m6489c() != 0) {
                C2201w.m8371a((int) R.string.phone_status_busy_music, 1);
                return;
            }
            switch (v.getId()) {
                case R.id.ib_left:
                    this.f6866a.m8148f();
                    return;
                case R.id.radio_favorite:
                    if (this.f6866a.f6885o.m6775I()) {
                        this.f6866a.m8150g();
                        return;
                    } else {
                        this.f6866a.f6885o.m6837y();
                        return;
                    }
                case R.id.radio_prev:
                    C1903m.m7252a().m7255b();
                    StatisticManager.onEvent(StatisticConstants.CONTENT_CONTROl_0001);
                    if (!this.f6866a.f6885o.m6829q()) {
                        this.f6866a.m8145d();
                    }
                    this.f6866a.f6885o.m6790a(false, true);
                    return;
                case R.id.radio_play:
                    C1903m.m7252a().m7255b();
                    if (this.f6866a.m8161l()) {
                        this.f6866a.f6885o.m6837y();
                        return;
                    } else {
                        this.f6866a.m8145d();
                        return;
                    }
                case R.id.radio_next:
                    C1903m.m7252a().m7255b();
                    StatisticManager.onEvent(StatisticConstants.CONTENT_CONTROl_0002);
                    if (!this.f6866a.f6885o.m6829q()) {
                        this.f6866a.m8145d();
                    }
                    this.f6866a.f6885o.m6790a(true, true);
                    return;
                case R.id.radio_delete:
                    if (this.f6866a.f6885o.m6775I()) {
                        this.f6866a.m8152h();
                        return;
                    } else {
                        this.f6866a.f6885o.m6837y();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.radio.player.RadioPlayerFragment$3 */
    class C21593 extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ RadioPlayerFragment f6867a;

        C21593(RadioPlayerFragment this$0) {
            this.f6867a = this$0;
        }

        public void careAbout() {
            addMsg(307);
            addMsg(CommonParams.dG);
            addMsg(225);
            addMsg(CommonParams.dH);
            addMsg(218);
            addMsg(CommonParams.dR);
        }

        public void handleMessage(Message msg) {
            if (C1702j.m6181a().m6188c() == null) {
                sendMessageDelayed(Message.obtain(msg), 1000);
            }
            switch (msg.what) {
                case 218:
                    if (msg.arg1 == C1702j.m6181a().m6188c().m6649s()) {
                        C1702j.m6181a().m6188c().m6602a((Pair) msg.obj);
                        return;
                    }
                    return;
                case 225:
                    if (msg.arg1 == C1702j.m6181a().m6188c().m6649s() && this.f6867a.f6877g != null) {
                        if (this.f6867a.f6886p == null || !this.f6867a.f6886p.f5919k) {
                            this.f6867a.f6877g.setImageDrawable(C2188r.m8331b(R.drawable.radio_ic_play));
                            this.f6867a.m8168p();
                            return;
                        }
                        this.f6867a.f6877g.setImageDrawable(C2188r.m8331b(R.drawable.radio_ic_pause));
                        this.f6867a.m8167o();
                        return;
                    }
                    return;
                case CommonParams.dG /*226*/:
                    if (msg.arg1 == C1702j.m6181a().m6188c().m6649s()) {
                        removeMessages(307);
                        C1702j.m6181a().m6188c().m6634i(2);
                        if (this.f6867a.f6885o.m6829q()) {
                            this.f6867a.m8136a(C1818h.m6730b().m6817i());
                        }
                        this.f6867a.m8140b();
                        return;
                    }
                    return;
                case CommonParams.dH /*227*/:
                    if (msg.arg1 == C1702j.m6181a().m6188c().m6649s()) {
                        this.f6867a.f6885o.m6787a(this.f6867a.f6886p);
                        C1702j.m6181a().m6188c().m6634i(3);
                        return;
                    }
                    return;
                case CommonParams.dR /*249*/:
                    if (msg.arg1 == C1702j.m6181a().m6188c().m6649s()) {
                        this.f6867a.m8156j();
                        if (msg.arg1 >= 3 && msg.arg2 != -1) {
                            C2201w.m8373a(this.f6867a.getString(R.string.module_music_thirdparty_null_list), 1);
                            return;
                        }
                        return;
                    }
                    return;
                case 307:
                    if (this.f6867a.m8161l()) {
                        this.f6867a.f6885o.m6837y();
                        this.f6867a.f6885o.m6811f(true);
                        MsgHandlerCenter.m4452a(307);
                        return;
                    } else if (this.f6867a.f6874d != null && msg.arg2 == C1702j.m6181a().m6188c().m6649s()) {
                        if (msg.arg1 < 3 || msg.arg1 % 3 == 0) {
                            this.f6867a.f6874d.setProgress(msg.arg1);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.radio.player.RadioPlayerFragment$4 */
    class C21604 implements C1526a {
        /* renamed from: a */
        final /* synthetic */ RadioPlayerFragment f6868a;

        C21604(RadioPlayerFragment this$0) {
            this.f6868a = this$0;
        }

        /* renamed from: a */
        public void mo1575a() {
            if (C1772k.m6480a().m6489c() != 0) {
                C2201w.m8371a((int) R.string.phone_status_busy_music, 1);
            }
        }
    }

    /* renamed from: com.baidu.carlife.radio.player.RadioPlayerFragment$5 */
    class C21615 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RadioPlayerFragment f6869a;

        C21615(RadioPlayerFragment this$0) {
            this.f6869a = this$0;
        }

        public void run() {
            this.f6869a.f6884n.setStartIndex(new Random().nextInt(20));
            this.f6869a.f6884n.invalidate();
            if (this.f6869a.f6891u != null) {
                this.f6869a.f6891u.postDelayed(this.f6869a.f6892v, 150);
            }
        }
    }

    /* renamed from: com.baidu.carlife.radio.player.RadioPlayerFragment$6 */
    class C21626 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RadioPlayerFragment f6870a;

        C21626(RadioPlayerFragment this$0) {
            this.f6870a = this$0;
        }

        public void run() {
            this.f6870a.f6877g.setImageDrawable(C2188r.m8331b(R.drawable.radio_ic_play));
            this.f6870a.f6874d.setProgress(0);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f6885o = C1818h.m6730b();
        MsgHandlerCenter.m4460a(this.f6891u);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onStart() {
        m8162m();
        super.onStart();
        LogUtil.d(f6871a, "------onStart()------");
    }

    public void onResume() {
        if (this.f6886p != null && this.f6886p.f5920l) {
            m8154i();
        }
        m8140b();
        MsgHandlerCenter.dispatchMessage((int) CommonParams.gS);
        super.onResume();
        onInitFocusAreas();
        if (this.f6886p == null || !this.f6886p.m7369j()) {
            m8168p();
        } else {
            m8167o();
        }
    }

    public void onPause() {
        super.onPause();
        m8168p();
    }

    public void onDestroyView() {
        dismissDialog();
        m8158k();
        super.onDestroyView();
    }

    public void onDetach() {
        this.f6891u.removeMessages(307);
        MsgHandlerCenter.m4464b(this.f6891u);
        this.f6891u = null;
        C1702j.m6181a().m6188c().m6604a(null);
        super.onDetach();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtil.m4434b(f6871a);
        if (hidden) {
            m8158k();
            m8168p();
        } else if (this.f6886p != null) {
            if (this.f6886p.f5920l) {
                m8154i();
            }
            if (this.f6886p.m7369j()) {
                m8167o();
            }
        }
    }

    public boolean onBackPressed() {
        m8148f();
        return true;
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_radio_player, null);
        m8165n();
        return this.mContentView;
    }

    @Deprecated
    protected void onInitView() {
    }

    @Deprecated
    protected void onUpdateOrientation(int orientation) {
    }

    @Deprecated
    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
    }

    /* renamed from: a */
    private void m8134a() {
        m8136a(C1702j.m6181a().m6188c().mo1696p());
        if (this.f6886p == null) {
            this.f6885o.m6811f(true);
            m8170q();
            C1702j.m6181a().m6188c().m6626f();
        } else if (!this.f6885o.m6814g(C1702j.m6181a().m6188c().m6649s()) || this.f6886p.f5918j <= 0) {
            this.f6885o.m6811f(true);
            this.f6885o.m6806e(this.f6886p);
        } else {
            m8140b();
            this.f6885o.m6807e(true);
            this.f6885o.m6774H();
        }
    }

    /* renamed from: a */
    private void m8135a(int status) {
        if (C1702j.m6181a().m6188c().m6649s() == 101) {
            this.f6872b.setVisibility(0);
            this.f6873c.m8398a((int) R.string.module_music_content_no_network, (int) R.string.module_music_content_reconnect);
            this.f6873c.m8401a(true);
        }
        switch (status) {
            case 2:
                this.f6882l.setVisibility(0);
                this.f6873c.setVisibility(8);
                break;
            case 3:
                this.f6882l.setVisibility(8);
                this.f6873c.setVisibility(0);
                break;
            case 6:
                String appName = this.f6885o.m6779a(C1702j.m6181a().m6188c().m6647q());
                this.f6873c.m8398a((int) R.string.module_music_thirdparty_downlist_empty2, (int) R.string.module_music_content_reconnect);
                this.f6873c.m8401a(true);
                this.f6882l.setVisibility(8);
                this.f6873c.setVisibility(0);
                break;
        }
        onInitFocusAreas();
    }

    /* renamed from: b */
    private void m8140b() {
        if (this.f6886p == null) {
            m8143c();
            return;
        }
        this.f6888r = false;
        try {
            this.f6887q = Integer.parseInt(this.f6886p.f5917i) / 1000;
        } catch (NumberFormatException e) {
            this.f6887q = 1;
        }
        this.f6874d.setMax(this.f6887q);
        this.f6874d.setProgress(this.f6886p.f5918j);
        if (this.f6886p.f5919k) {
            this.f6877g.setImageDrawable(C2188r.m8331b(R.drawable.radio_ic_pause));
        } else {
            this.f6877g.setImageDrawable(C2188r.m8331b(R.drawable.radio_ic_play));
        }
        this.f6880j.setText(this.f6886p.f5910b);
        this.f6881k.setText(this.f6886p.f5914f);
        if (this.f6886p.f5915g != null) {
            this.f6883m.setController(C1605a.m5867a(this.f6883m, this.f6886p.f5915g, 200, 200));
        }
        if (this.f6886p.f5927s == 1) {
            this.f6875e.setImageResource(R.drawable.radio_ic_like_on);
        } else {
            this.f6875e.setImageResource(R.drawable.radio_ic_like_off);
        }
    }

    /* renamed from: c */
    private void m8143c() {
        this.f6874d.setMax(1);
        this.f6874d.setProgress(0);
        this.f6881k.setText("");
        this.f6880j.setText("");
        this.f6883m.setImageURI("");
        this.f6875e.setImageResource(R.drawable.radio_ic_like_off);
    }

    /* renamed from: d */
    private void m8145d() {
        if (this.f6886p != null) {
            if (this.f6886p.f5920l) {
                C2201w.m8373a("正在缓冲", 0);
            } else {
                m8146e();
            }
        }
    }

    /* renamed from: e */
    private void m8146e() {
        if (!this.f6885o.m6829q()) {
            this.f6885o.m6832t();
            this.f6885o.m6833u();
            this.f6885o.m6806e(this.f6886p);
        } else if (this.f6886p.f5919k) {
            C1834p.m6925a().m6927c();
            this.f6885o.m6811f(true);
        } else {
            C1834p.m6925a().m6928d();
            this.f6885o.m6807e(true);
        }
    }

    /* renamed from: f */
    private void m8148f() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_from_player", true);
        FragmentManagerCallbackProxy.m4757a().back(bundle);
    }

    /* renamed from: g */
    private void m8150g() {
        if (this.f6886p != null) {
            if (this.f6886p.f5927s == 1) {
                this.f6886p.f5927s = 0;
                this.f6875e.setImageResource(R.drawable.radio_ic_like_off);
            } else {
                StatisticManager.onEvent(StatisticConstants.CONTENT_LIKE_0001);
                this.f6886p.f5927s = 1;
                this.f6875e.setImageResource(R.drawable.radio_ic_like_on);
                if (this.f6886p.f5926r == 999) {
                    return;
                }
            }
            C1795c.m6660a().m6667a(this.f6886p);
        }
    }

    /* renamed from: h */
    private void m8152h() {
        if (this.f6886p != null) {
            StatisticManager.onEvent(StatisticConstants.CONTENT_LIKE_0002);
            if (this.f6885o.m6829q() && this.f6886p.f5919k) {
                this.f6885o.m6811f(true);
            }
            this.f6886p.f5927s = 2;
            C1795c.m6660a().m6667a(this.f6886p);
            if (this.f6886p.f5926r != 999) {
                this.f6888r = true;
                C1702j.m6181a().m6190e();
            }
        }
    }

    /* renamed from: a */
    private void m8136a(MusicSongModel song) {
        this.f6886p = song;
    }

    /* renamed from: i */
    private void m8154i() {
        this.f6885o.m6768B();
    }

    /* renamed from: j */
    private void m8156j() {
        this.f6885o.m6767A();
    }

    /* renamed from: k */
    private void m8158k() {
        C2342g.m8864e().m8895f();
    }

    /* renamed from: l */
    private boolean m8161l() {
        return (this.f6885o.m6775I() || this.f6886p == null || (this.f6886p.f5922n >= this.f6886p.f5923o && this.f6886p.f5922n >= 0 && this.f6886p.f5923o > 0)) ? false : true;
    }

    /* renamed from: m */
    private void m8162m() {
        C1702j.m6181a().m6188c().m6604a(this.f6889s);
        C1702j.m6181a().m6188c().mo1689a(getArguments());
        this.f6886p = C1702j.m6181a().m6188c().mo1696p();
    }

    /* renamed from: n */
    private void m8165n() {
        this.f6872b = (ImageButton) this.mContentView.findViewById(R.id.ib_left);
        this.f6872b.setBackground(C2251b.m8528b(getContext()));
        this.f6880j = (TextView) this.mContentView.findViewById(R.id.radio_channel_name);
        this.f6881k = (TextView) this.mContentView.findViewById(R.id.radio_content_name);
        this.f6875e = (ImageButton) this.mContentView.findViewById(R.id.radio_favorite);
        this.f6876f = (ImageButton) this.mContentView.findViewById(R.id.radio_prev);
        this.f6877g = (ImageButton) this.mContentView.findViewById(R.id.radio_play);
        this.f6878h = (ImageButton) this.mContentView.findViewById(R.id.radio_next);
        this.f6879i = (ImageButton) this.mContentView.findViewById(R.id.radio_delete);
        this.f6874d = (RadioPlayerCircleProgressView) this.mContentView.findViewById(R.id.cp_progress);
        this.f6883m = (SimpleDraweeView) this.mContentView.findViewById(R.id.frag_radio_player_img);
        this.f6873c = (CommonTipView) this.mContentView.findViewById(R.id.common_tip_view);
        this.f6873c.setCommonTipCallBack(new C21604(this));
        this.f6882l = (LinearLayout) this.mContentView.findViewById(R.id.ll_radio_control);
        this.f6876f.setOnClickListener(this.f6890t);
        this.f6877g.setOnClickListener(this.f6890t);
        this.f6878h.setOnClickListener(this.f6890t);
        this.f6875e.setOnClickListener(this.f6890t);
        this.f6879i.setOnClickListener(this.f6890t);
        this.f6872b.setOnClickListener(this.f6890t);
        this.f6884n = (HomeCardMusicMelodyView) this.mContentView.findViewById(R.id.radio_player_melody_view);
        this.f6884n.setVisibility(4);
    }

    /* renamed from: o */
    private void m8167o() {
    }

    /* renamed from: p */
    private void m8168p() {
        this.f6884n.setVisibility(4);
        if (this.f6891u != null) {
            this.f6891u.removeCallbacks(this.f6892v);
        }
    }

    /* renamed from: q */
    private void m8170q() {
        if (this.f6874d != null) {
            this.f6874d.post(new C21626(this));
        }
    }

    public void onInitFocusAreas() {
        if (this.f6893w == null) {
            this.f6893w = new C1443g(this.mContentView, 2, true);
            this.f6893w.m5300d(this.f6872b);
        }
        if (this.f6894x == null) {
            this.f6894x = new C1443g(this.mContentView, 4, true);
            this.f6894x.m5300d(this.f6875e).m5300d(this.f6876f).m5300d(this.f6877g).m5300d(this.f6878h).m5300d(this.f6879i);
            this.f6894x.m5297b(this.f6877g);
        }
        C1440d.m5251a().m5256b(this.f6893w, this.f6894x);
        C1440d.m5251a().m5268h(this.f6894x);
    }
}
