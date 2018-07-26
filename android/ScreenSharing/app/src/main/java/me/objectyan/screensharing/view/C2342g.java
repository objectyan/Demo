package com.baidu.carlife.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.carlife.R;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewWrapper;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.C1868q.C1060g;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.wechat.p108b.C2382d.C2381a;
import com.baidu.carlife.wechat.p112f.C2451b;
import com.baidu.carlife.wechat.p112f.C2454d;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSMListener;
import com.baidu.navisdk.ui.routeguide.subview.BNavR;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.HashMap;

/* compiled from: TipsView */
/* renamed from: com.baidu.carlife.view.g */
public class C2342g implements OnClickListener, OnRGInfoListener {
    /* renamed from: a */
    private static final String f7667a = "TipsView";
    /* renamed from: b */
    private static volatile C2342g f7668b = null;
    /* renamed from: d */
    private static final String f7669d = "米后";
    /* renamed from: e */
    private static final String f7670e = "公里后";
    /* renamed from: f */
    private static int f7671f = 0;
    /* renamed from: g */
    private static final int f7672g = 25;
    /* renamed from: h */
    private static final int f7673h = CarlifeScreenUtil.m4331a().m4351h();
    /* renamed from: A */
    private TextView f7674A;
    /* renamed from: B */
    private ImageView f7675B;
    /* renamed from: C */
    private HashMap<String, Integer> f7676C;
    /* renamed from: D */
    private HashMap<String, String> f7677D;
    /* renamed from: E */
    private C1443g f7678E;
    /* renamed from: F */
    private C1443g f7679F;
    /* renamed from: G */
    private boolean f7680G;
    /* renamed from: H */
    private View f7681H;
    /* renamed from: I */
    private View f7682I;
    /* renamed from: J */
    private C1443g f7683J;
    /* renamed from: K */
    private C1443g f7684K;
    /* renamed from: L */
    private ImageButton f7685L;
    /* renamed from: M */
    private ImageButton f7686M;
    /* renamed from: N */
    private ImageButton f7687N;
    /* renamed from: O */
    private C1868q f7688O;
    /* renamed from: P */
    private boolean f7689P;
    /* renamed from: Q */
    private boolean f7690Q;
    /* renamed from: R */
    private RouteGuideFSMListener f7691R;
    /* renamed from: S */
    private C1060g f7692S;
    /* renamed from: c */
    private C2341a f7693c;
    /* renamed from: i */
    private int f7694i;
    /* renamed from: j */
    private String f7695j;
    /* renamed from: k */
    private boolean f7696k;
    /* renamed from: l */
    private View f7697l;
    /* renamed from: m */
    private LinearLayout f7698m;
    /* renamed from: n */
    private LinearLayout f7699n;
    /* renamed from: o */
    private LinearLayout f7700o;
    /* renamed from: p */
    private View f7701p;
    /* renamed from: q */
    private ProgressBar f7702q;
    /* renamed from: r */
    private MusicSongModel f7703r;
    /* renamed from: s */
    private ImageView f7704s;
    /* renamed from: t */
    private MarqueeTextView f7705t;
    /* renamed from: u */
    private MarqueeTextView f7706u;
    /* renamed from: v */
    private MarqueeTextView f7707v;
    /* renamed from: w */
    private MarqueeTextView f7708w;
    /* renamed from: x */
    private ImageView f7709x;
    /* renamed from: y */
    private ImageView f7710y;
    /* renamed from: z */
    private TextView f7711z;

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$1 */
    class C23321 implements RouteGuideFSMListener {
        /* renamed from: a */
        final /* synthetic */ C2342g f7655a;

        C23321(C2342g this$0) {
            this.f7655a = this$0;
        }

        public void run(String event) {
            if (FsmEvent.MSG_ENLARGE_ROADMAP_SHOW.equals(event)) {
                this.f7655a.f7680G = false;
            } else if (FsmEvent.MSG_ENLARGE_ROADMAP_HIDE.equals(event)) {
                this.f7655a.f7680G = true;
            } else if (FsmEvent.MAP_MOVE.equals(event) || FsmEvent.TOUCH_MAP.equals(event)) {
                BottomTabDisplayController.getInstance().showThenDelayDismiss();
            }
        }
    }

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$4 */
    class C23354 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2342g f7660a;

        C23354(C2342g this$0) {
            this.f7660a = this$0;
        }

        public void onClick(View arg0) {
            this.f7660a.m8877l();
        }
    }

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$5 */
    class C23365 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2342g f7661a;

        C23365(C2342g this$0) {
            this.f7661a = this$0;
        }

        public void onClick(View v) {
            this.f7661a.m8879m();
        }
    }

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$7 */
    class C23387 implements C1060g {
        /* renamed from: a */
        final /* synthetic */ C2342g f7663a;

        C23387(C2342g this$0) {
            this.f7663a = this$0;
        }

        /* renamed from: a */
        public void mo1390a(boolean isBTConnected) {
            this.f7663a.m8893c();
            ((Chronometer) this.f7663a.f7697l.findViewById(R.id.tip_phone_start_timing)).stop();
            int curModuleType = FragmentManagerCallbackProxy.m4757a().m4768d();
            if (isBTConnected && 4002 != curModuleType && this.f7663a.f7689P) {
                this.f7663a.m8870i();
                this.f7663a.f7693c.sendEmptyMessageDelayed(CommonParams.gT, 10000);
            }
            this.f7663a.f7689P = false;
            this.f7663a.f7690Q = false;
        }

        /* renamed from: b */
        public void mo1391b(boolean isBTConnected) {
            int curModuleType = FragmentManagerCallbackProxy.m4757a().m4768d();
            if (!isBTConnected || 4002 == curModuleType) {
                this.f7663a.m8893c();
            } else {
                this.f7663a.m8869h();
            }
            this.f7663a.f7689P = true;
        }

        /* renamed from: c */
        public void mo1392c(boolean isBTConnected) {
            this.f7663a.m8893c();
            this.f7663a.f7689P = true;
        }

        /* renamed from: a */
        public void mo1389a() {
            Chronometer startTimeView = (Chronometer) this.f7663a.f7697l.findViewById(R.id.tip_phone_start_timing);
            startTimeView.setBase(SystemClock.elapsedRealtime());
            startTimeView.start();
            this.f7663a.f7690Q = true;
        }

        /* renamed from: d */
        public void mo1393d(boolean isMultiCall) {
        }
    }

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$8 */
    class C23398 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2342g f7664a;

        C23398(C2342g this$0) {
            this.f7664a = this$0;
        }

        public void onClick(View v) {
            C2451b.m9347d().m9357f();
            switch ((C2381a) this.f7664a.f7709x.getTag()) {
                case Play:
                case Navi:
                    C2454d.m9370a();
                    C2451b.m9347d().mo1845a();
                    return;
                case Reply:
                    C2454d.m9370a();
                    C2451b.m9347d().m9358g();
                    return;
                default:
                    this.f7664a.m8896g();
                    C2451b.m9347d().mo1847c();
                    return;
            }
        }
    }

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$9 */
    class C23409 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2342g f7665a;

        C23409(C2342g this$0) {
            this.f7665a = this$0;
        }

        public void onClick(View v) {
            C2454d.m9370a();
            C2451b.m9347d().m9357f();
            this.f7665a.m8896g();
            C2451b.m9347d().mo1847c();
        }
    }

    /* compiled from: TipsView */
    /* renamed from: com.baidu.carlife.view.g$a */
    private class C2341a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C2342g f7666a;

        private C2341a(C2342g c2342g) {
            this.f7666a = c2342g;
        }

        public void careAbout() {
            addMsg(CommonParams.dZ);
            addMsg(CommonParams.dB);
            addMsg(CommonParams.gS);
            addMsg(CommonParams.gR);
            addMsg(CommonParams.gT);
            addMsg(505);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CommonParams.dB /*219*/:
                    Bitmap bitmap = msg.obj;
                    if (bitmap == null) {
                        this.f7666a.f7704s.setImageResource(R.drawable.music_ic_albumcover);
                        return;
                    } else {
                        this.f7666a.f7704s.setImageBitmap(bitmap);
                        return;
                    }
                case CommonParams.dZ /*310*/:
                    if (msg.arg1 == CommonParams.ir) {
                        try {
                            this.f7666a.f7704s.setImageResource(R.drawable.music_ic_albumcover);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    int curFragmentType = FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType();
                    if (C1818h.m6730b().m6829q()) {
                        if (!FragmentManagerCallbackProxy.m4757a().m4763a(curFragmentType)) {
                            this.f7666a.m8859c(this.f7666a.m8882o());
                            this.f7666a.f7694i = 0;
                            return;
                        }
                        return;
                    } else if (FragmentManagerCallbackProxy.m4757a().m4765b(curFragmentType)) {
                        removeMessages(CommonParams.dZ);
                        if (this.f7666a.f7694i = this.f7666a.f7694i + 1 < 25) {
                            sendEmptyMessageDelayed(CommonParams.dZ, 500);
                            return;
                        } else {
                            this.f7666a.f7694i = 0;
                            return;
                        }
                    } else {
                        this.f7666a.m8859c(this.f7666a.m8882o());
                        this.f7666a.f7694i = 0;
                        return;
                    }
                case 505:
                    RouteGuideFSM.getInstance().setRGMListener(this.f7666a.f7691R);
                    return;
                case CommonParams.gR /*4022*/:
                    this.f7666a.m8875k();
                    return;
                case CommonParams.gS /*4023*/:
                    this.f7666a.m8879m();
                    return;
                case CommonParams.gT /*4024*/:
                    this.f7666a.m8894d();
                    return;
                case CommonParams.gU /*4026*/:
                    this.f7666a.f7696k = false;
                    return;
                default:
                    return;
            }
        }
    }

    public C2342g() {
        this.f7693c = null;
        this.f7694i = 0;
        this.f7695j = "";
        this.f7696k = false;
        this.f7697l = null;
        this.f7698m = null;
        this.f7699n = null;
        this.f7700o = null;
        this.f7701p = null;
        this.f7702q = null;
        this.f7703r = null;
        this.f7704s = null;
        this.f7705t = null;
        this.f7706u = null;
        this.f7707v = null;
        this.f7708w = null;
        this.f7675B = null;
        this.f7676C = new HashMap();
        this.f7677D = new HashMap();
        this.f7680G = true;
        this.f7691R = new C23321(this);
        this.f7692S = new C23387(this);
        this.f7693c = new C2341a();
        MsgHandlerCenter.m4460a(this.f7693c);
        m8884p();
    }

    /* renamed from: a */
    public void m8885a() {
        BNRouteGuider.getInstance().addRGInfoListeners((OnRGInfoListener) this);
        RouteGuideFSM.getInstance().setRGMListener(this.f7691R);
    }

    /* renamed from: a */
    public void m8888a(CarlifeViewWrapper viewWrapper) {
        this.f7697l = viewWrapper.m4695g();
        f7671f = AppContext.m3876a().getResources().getDimensionPixelSize(R.dimen.tips_progress_default_size);
        this.f7698m = (LinearLayout) this.f7697l.findViewById(R.id.tips_music);
        this.f7699n = (LinearLayout) this.f7697l.findViewById(R.id.tips_wechat);
        this.f7700o = (LinearLayout) this.f7697l.findViewById(R.id.tips_navi);
        this.f7699n.setOnClickListener(null);
        this.f7709x = (ImageView) this.f7699n.findViewById(R.id.tips_wechat_button);
        this.f7709x.setOnClickListener(new C23398(this));
        this.f7710y = (ImageView) this.f7699n.findViewById(R.id.tips_wechat_close);
        this.f7710y.setOnClickListener(new C23409(this));
        this.f7711z = (TextView) this.f7699n.findViewById(R.id.tips_wechat_title);
        this.f7674A = (TextView) this.f7699n.findViewById(R.id.tips_wechat_desc);
        this.f7704s = (ImageView) this.f7698m.findViewById(R.id.iv_song_image);
        this.f7705t = (MarqueeTextView) this.f7698m.findViewById(R.id.music_name);
        this.f7706u = (MarqueeTextView) this.f7698m.findViewById(R.id.music_singer);
        ImageButton ibCancleTips = (ImageButton) this.f7698m.findViewById(R.id.ib_cancle_tips);
        ibCancleTips.requestFocusFromTouch();
        ibCancleTips.setOnClickListener(this);
        this.f7707v = (MarqueeTextView) this.f7700o.findViewById(R.id.tv_front_info);
        this.f7708w = (MarqueeTextView) this.f7700o.findViewById(R.id.tv_next_road_info);
        this.f7675B = (ImageView) this.f7700o.findViewById(R.id.iv_turn_icon);
        ImageButton ibCancleTipsNavi = (ImageButton) this.f7700o.findViewById(R.id.ib_cancle_tips);
        ibCancleTipsNavi.requestFocusFromTouch();
        ibCancleTipsNavi.setOnClickListener(this);
        this.f7702q = (ProgressBar) LayoutInflater.from(AppContext.m3876a()).inflate(R.layout.carlife_progress_bar, null);
    }

    /* renamed from: b */
    public void m8892b() {
        if (this.f7697l != null) {
            this.f7681H = this.f7697l.findViewById(R.id.tips_phone_incoming);
            this.f7682I = this.f7697l.findViewById(R.id.tips_phone_end);
            this.f7685L = (ImageButton) this.f7697l.findViewById(R.id.tip_phone_btn_answer);
            this.f7685L.setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2342g f7650a;

                {
                    this.f7650a = this$0;
                }

                public void onClick(View v) {
                    this.f7650a.m8893c();
                    this.f7650a.f7688O.m7127m();
                    StatisticManager.onEvent(StatisticConstants.HOME_PHONE_COMING, StatisticConstants.HOME_PHONE_COMING_BUTTON_ANSWER);
                }
            });
            this.f7686M = (ImageButton) this.f7697l.findViewById(R.id.tip_phone_btn_break);
            this.f7686M.setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2342g f7651a;

                {
                    this.f7651a = this$0;
                }

                public void onClick(View v) {
                    this.f7651a.m8893c();
                    this.f7651a.f7688O.m7106a(AppContext.m3876a());
                    StatisticManager.onEvent(StatisticConstants.HOME_PHONE_COMING, StatisticConstants.HOME_PHONE_COMING_BUTTON_REJECT);
                }
            });
            this.f7682I.setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2342g f7652a;

                {
                    this.f7652a = this$0;
                }

                public void onClick(View v) {
                    this.f7652a.m8894d();
                }
            });
            this.f7687N = (ImageButton) this.f7697l.findViewById(R.id.tip_phone_btn_close);
            this.f7687N.setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2342g f7653a;

                {
                    this.f7653a = this$0;
                }

                public void onClick(View v) {
                    this.f7653a.m8894d();
                }
            });
            this.f7688O = C1868q.m7089f();
            this.f7688O.m7111a(this.f7692S);
        }
    }

    /* renamed from: c */
    public void m8893c() {
        if (this.f7681H != null) {
            this.f7681H.setVisibility(8);
            C1440d.m5251a().m5255b(null);
        }
    }

    /* renamed from: d */
    public void m8894d() {
        if (this.f7682I != null) {
            this.f7682I.setVisibility(8);
            this.f7697l.findViewById(R.id.tip_phone_start_timing).setVisibility(8);
            if (m8873j()) {
                C1440d.m5251a().m5255b(null);
            }
        }
    }

    /* renamed from: h */
    private void m8869h() {
        m8875k();
        this.f7681H.setVisibility(0);
        ((TextView) this.f7697l.findViewById(R.id.tip_phone_name)).setText(this.f7688O.m7102a());
        if (this.f7683J == null) {
            this.f7683J = new C1443g(this.f7681H, 0);
            this.f7683J.m5300d(this.f7685L).m5300d(this.f7686M);
        }
        C1440d.m5251a().m5255b(this.f7683J);
    }

    /* renamed from: i */
    private void m8870i() {
        m8875k();
        this.f7682I.setVisibility(0);
        this.f7697l.findViewById(R.id.tip_phone_start_timing).setVisibility(this.f7690Q ? 0 : 8);
        if (this.f7684K == null) {
            this.f7684K = new C1443g(this.f7682I, 0);
            this.f7684K.m5300d(this.f7687N);
        }
        C1440d.m5251a().m5255b(this.f7684K);
    }

    /* renamed from: j */
    private boolean m8873j() {
        if (this.f7681H == null) {
            return false;
        }
        return this.f7681H.isShown();
    }

    /* renamed from: e */
    public static C2342g m8864e() {
        if (f7668b == null) {
            f7668b = new C2342g();
        }
        return f7668b;
    }

    /* renamed from: f */
    public void m8895f() {
        this.f7693c.post(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ C2342g f7654a;

            {
                this.f7654a = this$0;
            }

            public void run() {
                if (this.f7654a.f7701p != null) {
                    this.f7654a.f7701p.setVisibility(8);
                }
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_cancle_tips:
                m8875k();
                return;
            default:
                return;
        }
    }

    /* renamed from: k */
    private void m8875k() {
        m8879m();
        m8877l();
        m8894d();
        m8896g();
    }

    /* renamed from: l */
    private void m8877l() {
        this.f7693c.removeMessages(CommonParams.gR);
        if (this.f7700o != null) {
            this.f7700o.setVisibility(8);
            this.f7696k = true;
            this.f7693c.sendEmptyMessageDelayed(CommonParams.gU, 10000);
        }
        if (m8873j()) {
            C1440d.m5251a().m5255b(null);
        }
    }

    /* renamed from: m */
    private void m8879m() {
        this.f7693c.removeMessages(CommonParams.gR);
        if (this.f7698m != null) {
            this.f7698m.setVisibility(8);
        }
        if (!m8873j()) {
            C1440d.m5251a().m5255b(null);
            ContentFragment contentFragment = FragmentManagerCallbackProxy.m4757a().getCurrentFragment();
            if (contentFragment != null && contentFragment.isDisplayed && (contentFragment instanceof BNRouteGuideFragment)) {
                contentFragment.onInitFocusAreas();
            }
        }
    }

    /* renamed from: g */
    public void m8896g() {
        this.f7693c.removeMessages(CommonParams.gR);
        if (this.f7699n != null) {
            this.f7699n.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m8886a(final int resid) {
        this.f7693c.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C2342g f7657b;

            public void run() {
                this.f7657b.m8849a(0, resid);
            }
        });
    }

    /* renamed from: a */
    public void m8890a(final String content) {
        this.f7693c.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C2342g f7659b;

            public void run() {
                this.f7659b.m8850a(0, content);
            }
        });
    }

    /* renamed from: a */
    private void m8850a(int xPos, String content) {
        if (this.f7701p != null) {
            this.f7701p.setVisibility(0);
            if (!TextUtils.isEmpty(content)) {
                ((TextView) this.f7701p.findViewById(R.id.tv_process_content)).setText(content);
            }
        }
    }

    /* renamed from: a */
    private void m8849a(int xPos, int resId) {
        if (this.f7701p != null) {
            this.f7701p.setVisibility(0);
            if (resId > 0) {
                ((TextView) this.f7701p.findViewById(R.id.tv_process_content)).setText(resId);
            }
        }
    }

    /* renamed from: b */
    private void m8856b(int xPos) {
        if (!m8873j()) {
            m8894d();
            m8879m();
            m8896g();
            if (this.f7700o.getVisibility() == 8) {
                this.f7700o.setVisibility(0);
                this.f7700o.setOnClickListener(new C23354(this));
                LayoutParams lp = new LayoutParams(-1, -2);
                lp.leftMargin = xPos;
                this.f7700o.setLayoutParams(lp);
            } else {
                this.f7693c.removeMessages(CommonParams.gR);
            }
            this.f7693c.sendEmptyMessageDelayed(CommonParams.gR, 10000);
            if (this.f7679F == null) {
                this.f7679F = new C1443g(this.f7698m, 0);
                this.f7679F.m5300d(this.f7700o.findViewById(R.id.ib_cancle_tips));
            }
            C1440d.m5251a().m5255b(this.f7679F);
        }
    }

    /* renamed from: c */
    private void m8859c(int xPos) {
        LogUtil.d("ouyang", "----------xPos:" + xPos);
        if (!m8873j() && this.f7680G) {
            if (C1818h.m6730b().m6829q()) {
                this.f7703r = C1818h.m6730b().m6817i();
            } else {
                this.f7703r = C1818h.m6730b().m6816h();
            }
            if (this.f7703r != null && !TextUtils.isEmpty(this.f7703r.f5910b)) {
                m8894d();
                m8877l();
                m8896g();
                this.f7705t.setText(this.f7703r.f5910b);
                this.f7706u.setText(this.f7703r.f5914f);
                if (this.f7698m.getVisibility() == 0) {
                    this.f7693c.removeMessages(CommonParams.gR);
                } else {
                    this.f7698m.setVisibility(0);
                    int curFragmentType = FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType();
                    if (curFragmentType == 113 || curFragmentType == 114) {
                        this.f7704s.setVisibility(8);
                    } else {
                        this.f7704s.setVisibility(0);
                    }
                    this.f7698m.setOnClickListener(new C23365(this));
                    LayoutParams lp = new LayoutParams(-1, -2);
                    lp.leftMargin = xPos;
                    this.f7698m.setLayoutParams(lp);
                }
                this.f7693c.sendEmptyMessageDelayed(CommonParams.gR, 10000);
                if (this.f7678E == null) {
                    this.f7678E = new C1443g(this.f7698m, 0);
                    this.f7678E.m5300d(this.f7698m.findViewById(R.id.ib_cancle_tips));
                }
                C1440d.m5251a().m5255b(this.f7678E);
            }
        }
    }

    /* renamed from: n */
    private int m8880n() {
        int curFragmentType = FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType();
        if (curFragmentType == 113 || curFragmentType == 114) {
            return CarlifeScreenUtil.m4331a().m4351h() / 3;
        }
        return 0;
    }

    /* renamed from: a */
    public void m8889a(C2381a showType) {
        this.f7709x.setTag(showType);
        switch (showType) {
            case Play:
                this.f7709x.setImageResource(R.mipmap.com_ic_tips_play);
                return;
            case Navi:
                this.f7709x.setImageResource(R.mipmap.com_ic_tips_navigation);
                return;
            case Reply:
                this.f7709x.setImageResource(R.mipmap.com_ic_tips_replay);
                return;
            default:
                this.f7709x.setImageResource(R.mipmap.com_ic_tips_play);
                return;
        }
    }

    /* renamed from: a */
    public void m8891a(String name, String content, C2381a showType) {
        if (!m8873j() && this.f7680G) {
            m8894d();
            m8877l();
            m8879m();
            this.f7709x.setTag(showType);
            switch (showType) {
                case Play:
                    this.f7709x.setImageResource(R.mipmap.com_ic_tips_play);
                    break;
                case Navi:
                    this.f7709x.setImageResource(R.mipmap.com_ic_tips_navigation);
                    break;
                case Reply:
                    this.f7709x.setImageResource(R.mipmap.com_ic_tips_replay);
                    break;
                default:
                    this.f7709x.setImageResource(R.mipmap.com_ic_tips_play);
                    break;
            }
            this.f7711z.setText(name);
            this.f7674A.setText(content);
            if (this.f7699n.getVisibility() == 0) {
                this.f7693c.removeMessages(CommonParams.gR);
                return;
            }
            this.f7699n.setVisibility(0);
            LayoutParams lp = new LayoutParams(-1, -2);
            lp.leftMargin = m8880n();
            this.f7699n.setLayoutParams(lp);
        }
    }

    /* renamed from: o */
    private int m8882o() {
        int curFragmentType = FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType();
        if (FragmentManagerCallbackProxy.m4757a().m4765b(curFragmentType) || FragmentManagerCallbackProxy.m4757a().isCarlifeFragment(curFragmentType) || curFragmentType == 17) {
            return 0;
        }
        if (curFragmentType == 113) {
            return CarlifeScreenUtil.m4331a().m4351h() / 3;
        }
        if (curFragmentType == 114) {
            return CarlifeScreenUtil.m4331a().m4351h() / 3;
        }
        return ScreenUtil.getInstance().dip2px(80);
    }

    public void onSimpleGuideInfoShow(Message msg) {
    }

    /* renamed from: a */
    private Bundle m8847a(Message msg) {
        if (msg == null || !(msg.obj instanceof Bundle)) {
            return null;
        }
        return (Bundle) msg.obj;
    }

    /* renamed from: p */
    private void m8884p() {
        int size = RouteGuideParams.gTurnIconName.length;
        for (int i = 0; i < size; i++) {
            this.f7676C.put(RouteGuideParams.gTurnIconName[i], Integer.valueOf(BNavR.gTurnIconID[i]));
            this.f7677D.put(RouteGuideParams.gTurnIconName[i], RouteGuideParams.gTurnTypeDesc[i]);
        }
    }

    public void onSimpleGuideInfoUpdate(Message msg) {
        Bundle simpleGuideData = m8847a(msg);
        if (simpleGuideData != null) {
            int remainDist = simpleGuideData.getInt(SimpleGuideInfo.RemainDist);
            String nextRoad = simpleGuideData.getString("road_name");
            String iconName = simpleGuideData.getString("icon_name");
            if (!(remainDist <= 0 && RoutePlanParams.TURN_TYPE_ID_END.equals(this.f7695j) && TextUtils.isEmpty(nextRoad)) && BNavigator.getInstance().isNaviBegin()) {
                this.f7695j = nextRoad;
                int resId = ((Integer) this.f7676C.get(RouteGuideParams.gTurnIconName[0])).intValue();
                if (iconName != null && this.f7676C.containsKey(iconName)) {
                    resId = ((Integer) this.f7676C.get(iconName)).intValue();
                }
                if (remainDist >= 1000) {
                    int hmInt = (remainDist % 1000) / 100;
                    this.f7707v.setText((remainDist / 1000) + "." + hmInt + f7670e);
                } else {
                    this.f7707v.setText(remainDist + f7669d);
                }
                this.f7708w.setText(nextRoad);
                this.f7675B.setImageDrawable(JarUtils.getResources().getDrawable(resId));
                if (FragmentManagerCallbackProxy.m4757a().isCarlifeFragment(FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType()) && !this.f7696k) {
                    m8856b(m8882o());
                    return;
                }
                return;
            }
            this.f7707v.setText("导航结束");
            this.f7708w.setText(RoutePlanParams.TURN_TYPE_ID_END);
            this.f7695j = "";
            m8877l();
        }
    }

    public void onSimpleGuideInfoHide(Message msg) {
    }

    public void onTotalRemainDistTimeUpdate(Message msg) {
    }

    public void onAssistInfoShow(Message msg) {
    }

    public void onAssistInfoUpdate(Message msg) {
    }

    public void onAssistInfoHide(Message msg) {
    }

    public void onRasterExpandMapShow(Message msg) {
    }

    public void onRasterExpandMapUpdate(Message msg) {
    }

    public void onRasterExpandMapHide(Message msg) {
    }

    public void onDirectBoardShow(Message msg) {
    }

    public void onDirectBoardUpdate(Message msg) {
    }

    public void onDirectBoardHide(Message msg) {
    }

    public void onVectorExpandMapShow(Message msg) {
        if (FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType() == 113) {
            m8879m();
        }
    }

    public void onVectorExpandMapUpdate(Message msg) {
        if (FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType() == 113) {
            m8879m();
        }
    }

    public void onVectorExpandMapHide(Message msg) {
    }

    public void onCurRoadNameUpdate(Message msg) {
    }

    public void onHUDUpdate(Message msg) {
    }

    public void onRGSyncOperation(Message msg) {
    }

    public void onHighwayInfoShow(Message msg) {
    }

    public void onHighwayInfoUpdate(Message msg) {
    }

    public void onHighwayInfoHide(Message msg) {
    }

    public void onOtherRGInfo(Message msg) {
    }

    public void onSimpleBoardShow(Message message) {
    }

    public void onSimpleBoardUpdate(Message message) {
    }

    public void onSimpleBoardHide(Message message) {
    }

    public void onUGCEventTipsShow() {
    }

    public void onUGCEventTipsHide() {
    }

    public void onGPSWeak(Message message) {
    }

    public void onDestStreetViewDownloadSuccess(Message arg0) {
    }

    public void onDestStreetViewHide(Message arg0) {
    }

    public void onDestStreetViewShow(Message arg0) {
    }

    public void onDestStreetViewStartDownload(Message arg0) {
    }

    public void onDestStreetViewUpdate(Message arg0) {
    }

    /* renamed from: a */
    public void m8887a(View mStupProgress) {
        this.f7701p = mStupProgress;
    }
}
