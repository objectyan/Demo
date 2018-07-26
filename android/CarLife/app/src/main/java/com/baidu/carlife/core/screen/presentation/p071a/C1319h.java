package com.baidu.carlife.core.screen.presentation.p071a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C1269a;
import com.baidu.carlife.core.screen.C1280h;
import com.baidu.carlife.core.screen.p053b.C1272d;
import com.baidu.carlife.core.screen.p056a.C1268a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.C1872t;
import com.baidu.carlife.logic.C1872t.C1318b;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.logic.voice.LightVoiceMicView;
import com.baidu.carlife.p054k.C1651l;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2199v;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2278e;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.ui.util.TipTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: CarlifeViewWrapper */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.h */
public class C1319h extends C1308f implements OnClickListener, C1318b {
    /* renamed from: c */
    public static String f3779c = "CarlifeActivity#CarlifeViewWrapper";
    /* renamed from: d */
    private C1306d f3780d = new C1306d(this);
    /* renamed from: e */
    private FrameLayout f3781e = null;
    /* renamed from: f */
    private LinearLayout f3782f = null;
    /* renamed from: g */
    private ImageButton f3783g = null;
    /* renamed from: h */
    private ImageButton f3784h = null;
    /* renamed from: i */
    private ImageButton f3785i = null;
    /* renamed from: j */
    private ImageButton f3786j = null;
    /* renamed from: k */
    private LightVoiceMicView f3787k = null;
    /* renamed from: l */
    private View f3788l = null;
    /* renamed from: m */
    private View f3789m = null;
    /* renamed from: n */
    private View f3790n;
    /* renamed from: o */
    private RelativeLayout f3791o;
    /* renamed from: p */
    private TextView f3792p;
    /* renamed from: q */
    private RelativeLayout f3793q;
    /* renamed from: r */
    private RelativeLayout f3794r;
    /* renamed from: s */
    private TextView f3795s;
    /* renamed from: t */
    private View f3796t;
    /* renamed from: u */
    private C1443g f3797u;
    /* renamed from: v */
    private C2278e f3798v;
    /* renamed from: w */
    private List<BaseDialog> f3799w = new ArrayList();

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$1 */
    class C13101 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3771a;

        C13101(C1319h this$0) {
            this.f3771a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$2 */
    class C13112 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3772a;

        C13112(C1319h this$0) {
            this.f3772a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$3 */
    class C13123 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3773a;

        C13123(C1319h this$0) {
            this.f3773a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$4 */
    class C13134 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3774a;

        C13134(C1319h this$0) {
            this.f3774a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$5 */
    class C13145 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3775a;

        C13145(C1319h this$0) {
            this.f3775a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                BottomTabDisplayController.getInstance().delayHide();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$6 */
    class C13156 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3776a;

        C13156(C1319h this$0) {
            this.f3776a = this$0;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$7 */
    class C13167 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1319h f3777a;

        C13167(C1319h this$0) {
            this.f3777a = this$0;
        }

        public void onClick(View v) {
            BaseDialog dialog = this.f3777a.m4709r();
            if (dialog == null || dialog.m4475e()) {
                this.f3777a.cancelDialog();
            }
        }
    }

    /* compiled from: CarlifeViewWrapper */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.h$8 */
    class C13178 implements C0924a {
        /* renamed from: a */
        final /* synthetic */ C1319h f3778a;

        C13178(C1319h this$0) {
            this.f3778a = this$0;
        }

        public void onNetWorkResponse(int responseCode) {
            if (C1253f.jr) {
                this.f3778a.f3786j.setVisibility(0);
            } else {
                this.f3778a.f3786j.setVisibility(8);
            }
        }
    }

    public C1319h(Context context) {
        super(context, C0965R.layout.activity_main);
        C1309g.m4699a().m4700a(this);
        C1307e.m4686a().m4687a(this);
        m4707p();
        m4710s();
    }

    /* renamed from: p */
    private void m4707p() {
        this.f3783g = (ImageButton) this.a.findViewById(C0965R.id.iv_home);
        this.f3783g.setOnFocusChangeListener(new C13101(this));
        this.f3784h = (ImageButton) this.a.findViewById(C0965R.id.iv_music);
        this.f3784h.setOnFocusChangeListener(new C13112(this));
        this.f3785i = (ImageButton) this.a.findViewById(C0965R.id.iv_phone_book);
        this.f3785i.setOnFocusChangeListener(new C13123(this));
        this.f3786j = (ImageButton) this.a.findViewById(C0965R.id.iv_navi);
        this.f3786j.setOnFocusChangeListener(new C13134(this));
        this.f3789m = this.a.findViewById(C0965R.id.iv_voice_focus_bg);
        this.f3788l = this.a.findViewById(C0965R.id.iv_voice_bg);
        this.f3787k = (LightVoiceMicView) this.a.findViewById(C0965R.id.iv_voice);
        this.f3789m.setOnFocusChangeListener(new C13145(this));
        this.f3782f = (LinearLayout) this.a.findViewById(C0965R.id.ll_bottom_control);
        this.f3790n = this.a.findViewById(C0965R.id.main_anim_view);
        this.f3792p = (TextView) this.a.findViewById(C0965R.id.activity_main_toast_text);
        this.f3792p.setVisibility(0);
        this.f3792p.setAlpha(0.0f);
        C2201w.m8369a().m8377a(this.f3792p);
        this.f3796t = ((ViewStub) this.a.findViewById(C0965R.id.stub_progress)).inflate();
        this.f3796t.setBackgroundResource(C0965R.drawable.shape_for_toast_text);
        this.f3796t.setVisibility(8);
        this.f3783g.setOnClickListener(this);
        this.f3784h.setOnClickListener(this);
        this.f3785i.setOnClickListener(this);
        this.f3786j.setOnClickListener(this);
        this.f3787k.setOnClickListener(this);
        this.f3789m.setOnClickListener(this);
        this.f3781e = (FrameLayout) this.a.findViewById(C0965R.id.content_frame);
        if (this.f3781e != null) {
            this.f3781e.setOnTouchListener(new C13156(this));
        }
        this.f3791o = (RelativeLayout) this.a.findViewById(C0965R.id.dialog_holder);
        this.f3791o.setOnClickListener(new C13167(this));
        this.f3793q = (RelativeLayout) this.a.findViewById(C0965R.id.wmv_holder);
        this.f3795s = (TextView) this.a.findViewById(C0965R.id.guide_hint_txt);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0965R.id.iv_home:
                performOpenHome();
                return;
            case C0965R.id.iv_phone_book:
                this.f3780d.m4674b();
                StatisticManager.onEvent(StatisticConstants.HOME_MENU_0001);
                return;
            case C0965R.id.iv_voice_focus_bg:
            case C0965R.id.iv_voice:
                C1260i.m4435b(f3779c, "click voic recognition btn");
                m4735k();
                return;
            case C0965R.id.iv_navi:
                this.f3780d.m4679d();
                StatisticManager.onEvent(StatisticConstants.HOME_MENU_0002);
                return;
            case C0965R.id.iv_music:
                this.f3780d.m4678c();
                StatisticManager.onEvent(StatisticConstants.HOME_MENU_0003);
                return;
            default:
                return;
        }
    }

    /* renamed from: k */
    public void m4735k() {
        if (m4708q()) {
            C1260i.m4435b(f3779c, "onVoiceClick: Idle");
            C1912n.m7270a().m7307f();
            C1912n.m7270a().m7300b(false);
            return;
        }
        C1912n.m7270a().m7306e();
        if (C1912n.m7270a().m7303c()) {
            C1260i.m4435b(f3779c, "onVoiceClick: Listening");
            C1912n.m7270a().m7312k();
        } else if (C1912n.m7270a().m7301b()) {
            C1260i.m4435b(f3779c, "onVoiceClick: Processing");
            C1903m.m7252a().m7255b();
        } else if (C1912n.m7270a().m7314m()) {
            C1260i.m4435b(f3779c, "onVoiceClick: Speeching");
            C1903m.m7252a().m7255b();
        } else {
            C1260i.m4435b(f3779c, "onVoiceClick: stopVoice");
            C1903m.m7252a().m7255b();
        }
    }

    /* renamed from: q */
    private boolean m4708q() {
        return !C1912n.m7270a().m7314m() && C1912n.m7270a().m7305d();
    }

    /* renamed from: a */
    public void m4716a(int resId) {
        if (this.a != null) {
            this.a.setBackgroundResource(resId);
        }
    }

    /* renamed from: a */
    public void m4718a(Drawable drawable) {
        if (this.a != null) {
            this.a.setBackground(drawable);
        }
    }

    public void setBottomBarBackgroud(Drawable drawable) {
        if (this.f3782f != null) {
            this.f3782f.setBackground(drawable);
        }
    }

    /* renamed from: l */
    public void m4736l() {
        updateMainDisplayStatus(this.f3780d.m4684i());
    }

    public void updateGaussianBlurBackground() {
        if (!C1328h.m4757a().m4764b()) {
            m4716a((int) C0965R.drawable.com_bg);
        }
    }

    public void updateMainDisplayStatus(int bottomStatus) {
        switch (bottomStatus) {
            case 4001:
            case 4003:
                m4706b(bottomStatus);
                return;
            case 4002:
                m4706b(bottomStatus);
                return;
            case 4004:
                m4706b(bottomStatus);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m4706b(int bottomStatus) {
        this.f3783g.setNextFocusUpId(-1);
        switch (bottomStatus) {
            case 4001:
                this.f3783g.setSelected(true);
                this.f3785i.setSelected(false);
                this.f3786j.setSelected(false);
                this.f3784h.setSelected(false);
                return;
            case 4002:
                this.f3783g.setSelected(false);
                this.f3785i.setSelected(true);
                this.f3786j.setSelected(false);
                this.f3784h.setSelected(false);
                return;
            case 4003:
                this.f3783g.setSelected(false);
                this.f3785i.setSelected(false);
                this.f3786j.setSelected(true);
                this.f3784h.setSelected(false);
                return;
            case 4004:
                this.f3783g.setSelected(false);
                this.f3785i.setSelected(false);
                this.f3786j.setSelected(false);
                this.f3784h.setSelected(true);
                return;
            default:
                return;
        }
    }

    public void setBottomBarStatus(boolean show) {
        if (show) {
            if (this.f3782f != null && this.f3782f.getVisibility() == 8) {
                this.f3782f.setVisibility(0);
            }
            if (this.f3788l != null) {
                this.f3788l.setVisibility(0);
            }
            if (this.f3787k != null) {
                this.f3787k.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f3782f != null && this.f3782f.getVisibility() == 0) {
            this.f3782f.setVisibility(8);
        }
        if (this.f3788l != null) {
            this.f3788l.setVisibility(8);
        }
        if (this.f3787k != null) {
            this.f3787k.setVisibility(8);
        }
    }

    /* renamed from: e */
    public Context mo1482e() {
        return this.b;
    }

    /* renamed from: a */
    public void m4717a(int type, Bundle bundle) {
        this.f3780d.m4669a(type, bundle);
    }

    public void showDialog(BaseDialog chldView) {
        showDialog(chldView, C1265a.Center);
    }

    public void showDialog(BaseDialog childView, C1265a gravity) {
        if (childView != null) {
            C1260i.m4435b("CarlifeViewWrapper", "showDialog=" + isDialogShown());
            if (this.f3799w.contains(childView)) {
                C1260i.m4443d(f3779c, "showDialog childView is already exists.");
                return;
            }
            this.f3799w.add(childView);
            C1260i.m4435b("Dialog", "Carlife's showDialog childView=" + childView + ", size=" + this.f3799w.size());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            if (gravity == C1265a.Center) {
                layoutParams.addRule(13);
            } else if (gravity == C1265a.Bottom) {
                layoutParams.addRule(12);
                layoutParams.addRule(15);
            } else if (gravity == C1265a.left) {
                layoutParams.addRule(9);
                layoutParams.addRule(15);
            } else {
                layoutParams.addRule(11);
                layoutParams.addRule(15);
            }
            this.f3791o.addView(childView, layoutParams);
            this.f3791o.setVisibility(0);
            childView.mo1525a(this);
        }
    }

    public void dismissDialog() {
        BaseDialog dialog = m4709r();
        if (dialog != null) {
            dismissDialog(dialog);
        }
    }

    public void dismissDialog(BaseDialog childView) {
        m4704a(childView, true);
    }

    public void cancelDialog() {
        BaseDialog dialog = m4709r();
        if (dialog != null) {
            cancelDialog(dialog);
        }
    }

    public void cancelDialog(BaseDialog childView) {
        m4704a(childView, false);
    }

    /* renamed from: a */
    private void m4704a(BaseDialog childView, boolean dismissOrCancel) {
        if (childView != null && isDialogShown()) {
            C1260i.m4435b("Dialog", "dismissDialog childView=" + childView);
            boolean result = this.f3799w.remove(childView);
            this.f3791o.removeView(childView);
            if (this.f3799w.isEmpty()) {
                this.f3791o.setVisibility(8);
            }
            C1260i.m4435b("Dialog", "CarlifeView's dismissDialog mHistories.isEmpty=" + this.f3799w.isEmpty() + ",remove Result=" + result);
            if (result && !childView.m4478h()) {
                C1260i.m4435b(f3779c, "onCancel child");
                if (dismissOrCancel) {
                    childView.mo1526d();
                } else {
                    childView.mo1629c();
                }
            }
        }
    }

    public boolean isDialogShown() {
        return this.f3791o.isShown() || !this.f3799w.isEmpty();
    }

    /* renamed from: r */
    private BaseDialog m4709r() {
        int count = this.f3799w.size();
        if (count > 0) {
            return (BaseDialog) this.f3799w.get(count - 1);
        }
        return null;
    }

    public boolean showConnectForbidDialog() {
        if (!C1663a.m5979a().m5993N()) {
            return false;
        }
        C1953c connectForbidDialog = new C1953c(this.b).m7455f(1);
        connectForbidDialog.m7458q();
        connectForbidDialog.m7435a((int) C0965R.string.home_my_dialog_alert);
        connectForbidDialog.m7447c((int) C0965R.string.alert_confirm);
        showDialog(connectForbidDialog, C1265a.Center);
        return true;
    }

    /* renamed from: s */
    private void m4710s() {
        m4711t();
        m4712u();
        C2342g.m8864e().m8888a(this);
        C2342g.m8864e().m8887a(this.f3796t);
        TipTool.setToastinInterface(new C2199v());
        C1872t.m7136a().m7151a((C1318b) this);
        C1268a.m4481b().m4488a((C1280h) this);
    }

    /* renamed from: t */
    private void m4711t() {
        C1651l openNaviRequest = new C1651l();
        openNaviRequest.toGetRequest();
        openNaviRequest.registerResponseListener(new C13178(this));
    }

    /* renamed from: u */
    private void m4712u() {
        this.f3783g.setOnKeyListener(new C1272d(this.f3785i, null));
        this.f3785i.setOnKeyListener(new C1272d(this.f3789m, this.f3783g));
        this.f3789m.setOnKeyListener(new C1272d(this.f3786j, this.f3785i));
        this.f3786j.setOnKeyListener(new C1272d(this.f3784h, this.f3789m));
        this.f3784h.setOnKeyListener(new C1272d(null, this.f3786j));
    }

    /* renamed from: a */
    public void m4719a(Window window) {
        C1440d focusManager = C1440d.m5251a();
        focusManager.m5254a(this.a);
        if (this.f3797u == null) {
            this.f3797u = new C1443g(this.a, 1);
            this.f3797u.m5300d(this.f3783g).m5300d(this.f3785i).m5300d(this.f3789m).m5300d(this.f3786j).m5300d(this.f3784h);
        }
        focusManager.m5252a(this.f3797u);
    }

    /* renamed from: b */
    public void mo1481b(boolean isSuccess) {
        if (!isSuccess) {
        }
    }

    /* renamed from: j */
    public boolean mo1489j() {
        if (this.f3783g == null || this.f3785i == null || this.f3786j == null || this.f3784h == null || this.f3789m == null) {
            return false;
        }
        if (this.f3783g.hasFocus() || this.f3785i.hasFocus() || this.f3786j.hasFocus() || this.f3784h.hasFocus() || this.f3789m.hasFocus()) {
            return true;
        }
        return false;
    }

    public void innerNameSearch(String key) {
        this.f3780d.m4672a(key);
    }

    public void openNaviFromOutSide(int type, Bundle bundle) {
        this.f3780d.m4675b(type, bundle);
    }

    public void openNavi() {
        this.f3780d.m4680e();
    }

    public void openNavi(Bundle bundle) {
        this.f3780d.m4670a(bundle);
    }

    public void startCalcRoute(C1269a poi) {
        this.f3780d.m4676b(poi);
    }

    /* renamed from: f */
    public void mo1483f() {
        if (this.f3790n != null) {
            AnimationDrawable drawable = (AnimationDrawable) this.b.getResources().getDrawable(C0965R.drawable.anim_view_drawable_list);
            this.f3790n.setBackground(drawable);
            drawable.start();
        }
    }

    /* renamed from: h */
    public void mo1484h() {
        this.f3780d.m4685j();
    }

    public void showWindowView(View view, LayoutParams layoutParams) {
        C1260i.m4435b("CarlifeActivity", "showWindowView");
        this.f3793q.removeAllViews();
        this.f3793q.addView(view, layoutParams);
        this.f3793q.setVisibility(0);
    }

    public void hideWindowView() {
        this.f3793q.setVisibility(8);
        this.f3793q.removeAllViews();
    }

    public boolean isWindowViewShown() {
        return this.f3793q.isShown();
    }

    /* renamed from: b */
    public void mo1480b() {
        if (!C1192c.m4069a().m4088h()) {
            return;
        }
        if (this.f3794r != null) {
            this.f3794r.setVisibility(0);
            return;
        }
        this.f3794r = new RelativeLayout(this.b);
        this.f3794r.setBackgroundColor(-16777216);
        ImageView imageView = new ImageView(this.b);
        imageView.setImageResource(C0965R.drawable.com_ic_carlife_black);
        LayoutParams rParams = new LayoutParams(-2, -2);
        rParams.addRule(13);
        this.f3794r.addView(imageView, rParams);
        ImageView tipIV = new ImageView(this.b);
        tipIV.setImageResource(C0965R.drawable.com_ic_gesture_slide_guide);
        LayoutParams params = new LayoutParams(-2, -2);
        params.setMargins(0, 0, 0, C1249d.m4331a().m4343c(20));
        params.addRule(12);
        params.addRule(14);
        this.f3794r.addView(tipIV, params);
        if (this.f3794r != null && this.f3794r.getParent() == null) {
            m4713v();
        }
    }

    /* renamed from: a */
    public void mo1479a(boolean isDestroy) {
        if (!C1190a.m4065a() && this.f3794r != null && this.f3794r.getParent() != null) {
            ((WindowManager) this.b.getSystemService("window")).removeView(this.f3794r);
            this.f3794r = null;
        }
    }

    /* renamed from: v */
    private void m4713v() {
        if (!C1190a.m4065a()) {
            WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
            WindowManager.LayoutParams wParams = new WindowManager.LayoutParams();
            if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) {
                wParams.type = 2005;
            } else {
                wParams.type = 2006;
            }
            wParams.format = -2;
            wParams.gravity = 112;
            wParams.systemUiVisibility = 5;
            wParams.verticalMargin = 0.0f;
            wParams.width = -1;
            wParams.height = -1;
            wParams.flags = 24;
            windowManager.addView(this.f3794r, wParams);
        }
    }

    /* renamed from: m */
    public boolean m4737m() {
        if (this.f3794r == null || this.f3794r.getParent() == null || this.f3794r.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public void m4738n() {
        if (C1268a.m4481b().m4499g()) {
            C1268a.m4481b().m4502j();
            if (C1192c.m4069a().m4090i()) {
                mo1480b();
                return;
            } else if (C1192c.m4069a().m4088h()) {
                C1268a.m4481b().m4504l();
                return;
            } else {
                return;
            }
        }
        C1268a.m4481b().m4485a(C1268a.m4481b().m4500h());
    }

    /* renamed from: o */
    public void m4739o() {
        if (this.f3794r != null) {
            if (this.f3794r.getVisibility() == 0) {
                C1192c.m4069a().m4083f(true);
            } else {
                C1192c.m4069a().m4083f(false);
            }
            this.f3794r.setVisibility(8);
            C1268a.m4481b().m4503k();
        }
    }

    /* renamed from: a */
    public void m4724a(boolean noFocus, boolean resume) {
        if (noFocus) {
            mo1479a(false);
            if (resume) {
                C1268a.m4481b().m4504l();
            }
        }
    }

    /* renamed from: c */
    public void mo1468c() {
        dismissDialog(this.f3798v);
    }

    /* renamed from: b */
    public void mo1467b(String msg) {
        mo1465a(msg, null);
    }

    /* renamed from: a */
    public void mo1465a(String msg, C0672b cancelListener) {
        mo1466a(msg, cancelListener, null);
    }

    /* renamed from: a */
    public void mo1466a(String msg, C0672b cancelListener, C0690d listener) {
        if (this.f3798v != null && isDialogShown()) {
            dismissDialog(this.f3798v);
            this.f3798v = null;
        }
        this.f3798v = m4714w();
        this.f3798v.setOnDialogCancelListener(null);
        this.f3798v.setOnCancelListener(null);
        if (!TextUtils.isEmpty(msg)) {
            this.f3798v.m8622b(msg);
        }
        if (cancelListener != null) {
            this.f3798v.setOnCancelListener(cancelListener);
        }
        if (listener != null) {
            this.f3798v.setOnDialogCancelListener(listener);
        }
        showDialog(this.f3798v);
    }

    /* renamed from: d */
    public boolean mo1469d() {
        if (this.f3798v == null || !isDialogShown()) {
            return false;
        }
        return true;
    }

    /* renamed from: w */
    private C2278e m4714w() {
        if (this.f3798v == null) {
            this.f3798v = new C2278e(C1157a.m3876a());
        }
        return this.f3798v;
    }

    /* renamed from: c */
    public void m4729c(boolean dayStyle) {
        this.f3780d.m4677b(dayStyle);
    }

    public void performOpenHome() {
        this.f3780d.m4668a();
    }

    /* renamed from: a */
    public void mo1478a(String hintStr) {
        this.f3795s.setText(hintStr);
        this.f3795s.setVisibility(0);
    }

    /* renamed from: a */
    public void mo1477a() {
        if (this.f3795s != null) {
            this.f3795s.setVisibility(8);
        }
    }

    public void hideMapFragment() {
        this.f3780d.m4681f();
    }

    public void showMapFragment() {
        this.f3780d.m4682g();
    }
}
