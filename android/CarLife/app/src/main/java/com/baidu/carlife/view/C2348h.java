package com.baidu.carlife.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.adpter.C1027s;
import com.baidu.carlife.adpter.C1027s.C1025a;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.p056a.C1268a;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.voice.C1886j;
import com.baidu.carlife.logic.voice.C1887a;
import com.baidu.carlife.logic.voice.C1890d;
import com.baidu.carlife.logic.voice.C1893g;
import com.baidu.carlife.logic.voice.C1895i;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.logic.voice.ReceiveDataThread;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.service.C2169a;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.dialog.C0770k;
import com.baidu.carlife.view.dialog.C2331v;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VoiceRecognitionWindow */
/* renamed from: com.baidu.carlife.view.h */
public class C2348h implements OnClickListener, OnItemClickListener {
    /* renamed from: a */
    private static final String f7719a = "CarLifeVoice";
    /* renamed from: c */
    private static final String f7720c = "…";
    /* renamed from: b */
    private boolean f7721b = false;
    /* renamed from: d */
    private int f7722d = 1;
    /* renamed from: e */
    private String f7723e;
    /* renamed from: f */
    private Context f7724f;
    /* renamed from: g */
    private C2331v f7725g;
    /* renamed from: h */
    private View f7726h;
    /* renamed from: i */
    private TextView f7727i;
    /* renamed from: j */
    private TextView f7728j;
    /* renamed from: k */
    private ImageView f7729k;
    /* renamed from: l */
    private ImageView f7730l;
    /* renamed from: m */
    private ImageView f7731m;
    /* renamed from: n */
    private ImageView f7732n;
    /* renamed from: o */
    private ImageView f7733o;
    /* renamed from: p */
    private ImageView f7734p;
    /* renamed from: q */
    private ImageView f7735q;
    /* renamed from: r */
    private WaveformView f7736r;
    /* renamed from: s */
    private ScrollView f7737s;
    /* renamed from: t */
    private ListView f7738t;
    /* renamed from: u */
    private C1027s f7739u;
    /* renamed from: v */
    private RotateAnimation f7740v;
    /* renamed from: w */
    private boolean f7741w;
    /* renamed from: x */
    private List<C1886j> f7742x = new ArrayList();
    /* renamed from: y */
    private int f7743y;
    /* renamed from: z */
    private boolean f7744z = false;

    /* compiled from: VoiceRecognitionWindow */
    /* renamed from: com.baidu.carlife.view.h$1 */
    class C23431 implements C0690d {
        /* renamed from: a */
        final /* synthetic */ C2348h f7712a;

        C23431(C2348h this$0) {
            this.f7712a = this$0;
        }

        public void onCancel() {
            C1912n.m7270a().m7310i();
        }
    }

    /* compiled from: VoiceRecognitionWindow */
    /* renamed from: com.baidu.carlife.view.h$2 */
    class C23442 implements C0770k {
        /* renamed from: a */
        final /* synthetic */ C2348h f7713a;

        C23442(C2348h this$0) {
            this.f7713a = this$0;
        }

        public void onDismiss() {
            C1912n.m7270a().m7310i();
        }

        public void onShow() {
        }
    }

    /* compiled from: VoiceRecognitionWindow */
    /* renamed from: com.baidu.carlife.view.h$3 */
    class C23453 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2348h f7714a;

        C23453(C2348h this$0) {
            this.f7714a = this$0;
        }

        public void onClick(View v) {
            if (C1268a.m4481b().m4499g()) {
                C1268a.m4481b().m4502j();
            }
        }
    }

    /* compiled from: VoiceRecognitionWindow */
    /* renamed from: com.baidu.carlife.view.h$4 */
    class C23464 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2348h f7715a;

        C23464(C2348h this$0) {
            this.f7715a = this$0;
        }

        public void run() {
            C2256c.m8570a().m8571a((int) C0965R.drawable.com_ic_help, (int) C0965R.drawable.ic_voice_hint_b);
        }
    }

    /* renamed from: a */
    public void m8918a(CarlifeActivity activity) {
        this.f7724f = activity.getApplicationContext();
        this.f7726h = LayoutInflater.from(this.f7724f).inflate(C0965R.layout.tips_voice_full, null);
        this.f7725g = new C2331v(activity, this.f7726h, C0965R.style.CommonRightListDialog, this.f7724f.getResources().getDimensionPixelSize(C0965R.dimen.voice_dialog_width), 5);
        this.f7725g.setOnDialogCancelListener(new C23431(this));
        this.f7725g.setDialogShowHideListener(new C23442(this));
        this.f7726h.setOnClickListener(new C23453(this));
        this.f7728j = (TextView) this.f7726h.findViewById(C0965R.id.tv_voice_hint);
        this.f7727i = (TextView) this.f7726h.findViewById(C0965R.id.tv_voice_recog_status);
        this.f7729k = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_close);
        this.f7729k.setOnClickListener(this);
        this.f7730l = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_help);
        this.f7730l.setOnClickListener(this);
        this.f7731m = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_debug);
        this.f7731m.setOnClickListener(this);
        this.f7732n = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_save);
        this.f7732n.setOnClickListener(this);
        this.f7736r = (WaveformView) this.f7726h.findViewById(C0965R.id.wv_speaking);
        this.f7736r.setOnClickListener(this);
        this.f7733o = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_status_loading);
        this.f7734p = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_status_loading_1);
        this.f7735q = (ImageView) this.f7726h.findViewById(C0965R.id.iv_voice_btn);
        this.f7735q.setOnClickListener(this);
        this.f7737s = (ScrollView) this.f7726h.findViewById(C0965R.id.sv_layout_common);
        this.f7738t = (ListView) this.f7726h.findViewById(C0965R.id.lv_multi_result);
        this.f7739u = new C1027s(this.f7724f);
        this.f7738t.setAdapter(this.f7739u);
        this.f7738t.setOnItemClickListener(this);
        this.f7740v = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f7740v.setDuration(1000);
        this.f7740v.setInterpolator(new LinearInterpolator());
        this.f7740v.setRepeatCount(-1);
        TextView temp = (TextView) this.f7737s.findViewById(C0965R.id.temp);
        if (C1253f.jr) {
            temp.setText(C0965R.string.voice_domain_common_detail);
            this.f7737s.findViewById(C0965R.id.temp1).setVisibility(0);
            this.f7737s.findViewById(C0965R.id.temp2).setVisibility(0);
            return;
        }
        temp.setText(C0965R.string.voice_domain_common_detail_closenavi);
        this.f7737s.findViewById(C0965R.id.temp1).setVisibility(8);
        this.f7737s.findViewById(C0965R.id.temp2).setVisibility(8);
    }

    /* renamed from: a */
    public void m8919a(String name) {
        this.f7723e = name;
    }

    /* renamed from: a */
    public void m8914a() {
        C1309g.m4699a().showDialog(this.f7725g, C1265a.Right);
        this.f7744z = true;
        if (this.f7721b) {
            C2201w.m8372a("VoiceRecognitionWindow: show");
        }
        BottomTabDisplayController.getInstance().panelShow();
    }

    /* renamed from: g */
    private void m8907g() {
        this.f7738t.setVisibility(8);
        this.f7735q.setVisibility(4);
        this.f7726h.findViewById(C0965R.id.rl_bottom).setVisibility(0);
        this.f7736r.setVisibility(0);
        this.f7733o.clearAnimation();
        this.f7733o.setVisibility(4);
        this.f7734p.setVisibility(4);
        this.f7737s.setVisibility(4);
        this.f7727i.setVisibility(0);
        this.f7727i.setText("");
        this.f7728j.setText(C0965R.string.voice_hint_a);
        this.f7730l.setVisibility(0);
        this.f7729k.setVisibility(8);
    }

    /* renamed from: h */
    private void m8908h() {
        if (m8922b()) {
            this.f7744z = false;
            m8907g();
            C1309g.m4699a().dismissDialog(this.f7725g);
            m8911k();
            if (this.f7721b) {
                C2201w.m8372a("VoiceRecognitionWindow: closeVoiceFull");
            }
            BottomTabDisplayController.getInstance().panelHide();
        }
    }

    public void onClick(View v) {
        boolean z = true;
        switch (v.getId()) {
            case C0965R.id.iv_voice_close:
                if (C1268a.m4481b().m4499g()) {
                    C1268a.m4481b().m4502j();
                }
                if (m8909i()) {
                    m8910j();
                    return;
                } else {
                    C1912n.m7270a().m7310i();
                    return;
                }
            case C0965R.id.iv_voice_help:
                if (C1268a.m4481b().m4499g()) {
                    C1268a.m4481b().m4502j();
                }
                m8923c();
                return;
            case C0965R.id.iv_voice_debug:
                if (ReceiveDataThread.isPlayMicAudio) {
                    C2201w.m8372a("外放关闭");
                    this.f7731m.setAlpha(0.5f);
                } else {
                    C2201w.m8372a("外放打开");
                    this.f7731m.setAlpha(1.0f);
                }
                if (ReceiveDataThread.isPlayMicAudio) {
                    z = false;
                }
                ReceiveDataThread.isPlayMicAudio = z;
                return;
            case C0965R.id.iv_voice_save:
                if (C2169a.f6915a) {
                    C2201w.m8372a("保存功能关闭");
                    this.f7732n.setAlpha(0.5f);
                } else {
                    C2201w.m8372a("保存功能打开");
                    this.f7732n.setAlpha(1.0f);
                }
                if (C2169a.f6915a) {
                    z = false;
                }
                C2169a.f6915a = z;
                return;
            case C0965R.id.wv_speaking:
            case C0965R.id.iv_voice_btn:
                switch (this.f7722d) {
                    case 1:
                    case 5:
                    case 6:
                        C1912n.m7270a().m7307f();
                        return;
                    case 2:
                    case 3:
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m8915a(int status) {
        m8917a(status, -1, null);
    }

    /* renamed from: a */
    public void m8916a(int status, int errorCode) {
        m8917a(status, errorCode, null);
    }

    /* renamed from: b */
    private void m8900b(int err_code) {
    }

    /* renamed from: a */
    public void m8917a(int status, int errorCode, String cmd) {
        switch (status) {
            case 2:
                this.f7722d = 2;
                this.f7738t.setVisibility(8);
                this.f7735q.setVisibility(4);
                this.f7726h.findViewById(C0965R.id.rl_bottom).setVisibility(0);
                this.f7736r.setVisibility(0);
                this.f7733o.clearAnimation();
                this.f7733o.setVisibility(4);
                this.f7734p.setVisibility(4);
                this.f7737s.setVisibility(4);
                this.f7727i.setVisibility(0);
                this.f7727i.setText("");
                this.f7728j.setText(C0965R.string.voice_hint_a);
                this.f7730l.setVisibility(0);
                this.f7729k.setVisibility(8);
                this.f7725g.mo1630i();
                return;
            case 3:
                this.f7722d = 3;
                this.f7727i.setText("");
                this.f7728j.setText(C0965R.string.speaking);
                return;
            case 4:
                this.f7722d = 4;
                this.f7736r.setVisibility(4);
                this.f7734p.setVisibility(0);
                this.f7733o.setVisibility(0);
                this.f7733o.startAnimation(this.f7740v);
                this.f7735q.setVisibility(4);
                this.f7727i.setText("");
                this.f7728j.setText(C0965R.string.in_recog);
                return;
            case 5:
                this.f7722d = 1;
                this.f7736r.setVisibility(4);
                this.f7733o.clearAnimation();
                this.f7733o.setVisibility(4);
                this.f7734p.setVisibility(4);
                this.f7735q.setVisibility(0);
                this.f7728j.setText("");
                if (1 == errorCode) {
                    this.f7728j.setText(C0965R.string.in_search);
                    return;
                }
                return;
            case 6:
                this.f7722d = 6;
                this.f7728j.setText("");
                m8900b(errorCode);
                String voiceHint;
                switch (errorCode) {
                    case 2:
                        m8898a(4, String.format(this.f7724f.getString(C0965R.string.error_recog_no_found), new Object[]{cmd}));
                        return;
                    case 3:
                        m8901b(3, C0965R.string.error_recog_no_network);
                        return;
                    case 4:
                        m8901b(3, C0965R.string.error_recog_fail_start);
                        StatisticManager.onEvent(StatisticConstants.VOICE_CONTROL_RECOGNITION_FAIL_ERROR_CLIENT, "小度无法启动");
                        return;
                    case 5:
                        if (TextUtils.isEmpty(cmd)) {
                            voiceHint = this.f7724f.getString(C0965R.string.error_recog_no_music);
                        } else {
                            voiceHint = String.format(this.f7724f.getString(C0965R.string.error_recog_no_found), new Object[]{cmd});
                        }
                        m8898a(4, voiceHint);
                        return;
                    case 6:
                        if (TextUtils.isEmpty(this.f7723e)) {
                            voiceHint = this.f7724f.getString(C0965R.string.error_recog_no_poi);
                        } else {
                            voiceHint = String.format(this.f7724f.getString(C0965R.string.error_recog_no_found), new Object[]{this.f7723e});
                            m8919a(null);
                        }
                        m8898a(4, voiceHint);
                        return;
                    case 7:
                        this.f7730l.setVisibility(8);
                        this.f7737s.setVisibility(8);
                        m8901b(3, C0965R.string.error_recog_no_mic);
                        return;
                    case 8:
                        m8901b(3, C0965R.string.error_recog_music_is_playing);
                        return;
                    case 9:
                        m8898a(3, this.f7724f.getString(C0965R.string.error_recog_cancle_search_poi));
                        return;
                    default:
                        if (C1251e.m4358a().m4401r()) {
                            m8901b(1, C0965R.string.error_recog_default);
                        } else {
                            m8901b(3, C0965R.string.error_recog_no_network_when_offline);
                        }
                        if (!TextUtils.isEmpty(cmd)) {
                            this.f7727i.setText(cmd);
                            return;
                        }
                        return;
                }
            case 7:
                this.f7737s.setVisibility(0);
                this.f7728j.setText(C0965R.string.voice_hint_b);
                this.f7727i.setVisibility(4);
                this.f7730l.setVisibility(4);
                this.f7731m.setVisibility(4);
                this.f7732n.setVisibility(4);
                this.f7726h.findViewById(C0965R.id.rl_bottom).setVisibility(4);
                this.f7738t.setVisibility(8);
                this.f7729k.setImageResource(C0965R.drawable.com_ic_back);
                this.f7729k.setVisibility(0);
                m8912l();
                this.f7725g.mo1630i();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public boolean m8922b() {
        return this.f7744z;
    }

    /* renamed from: c */
    public void m8923c() {
        this.f7741w = true;
        m8915a(7);
        StatisticManager.onEvent(StatisticConstants.VOICE_HELP, StatisticConstants.VOICE_HELP);
    }

    /* renamed from: d */
    public TextView m8924d() {
        return this.f7727i;
    }

    /* renamed from: i */
    private boolean m8909i() {
        return this.f7741w;
    }

    /* renamed from: j */
    private void m8910j() {
        this.f7741w = false;
        this.f7729k.setVisibility(8);
    }

    /* renamed from: k */
    private void m8911k() {
        for (C1886j temp : this.f7742x) {
            temp.m7224b();
        }
    }

    /* renamed from: c */
    private C1886j m8903c(int eventType) {
        switch (eventType) {
            case 1:
                return new C1895i(this);
            case 2:
                return new C1893g(this);
            case 3:
                return new C1887a(this);
            case 4:
                return new C1890d(this);
            default:
                return new C1895i(this);
        }
    }

    /* renamed from: d */
    private C1886j m8905d(int eventType) {
        for (C1886j temp : this.f7742x) {
            if (eventType == temp.m7221a()) {
                return temp;
            }
        }
        this.f7742x.add(m8903c(eventType));
        return m8905d(eventType);
    }

    /* renamed from: a */
    private void m8898a(int event, String voiceHint) {
        C1260i.m4435b("Voice", "--postProcess--event:" + event + "----lastEvent:" + this.f7743y);
        if (event != this.f7743y) {
            m8911k();
        }
        this.f7743y = event;
        m8905d(event).m7225b(voiceHint);
    }

    /* renamed from: b */
    private void m8901b(int event, int stringId) {
        m8898a(event, this.f7724f.getString(stringId));
    }

    /* renamed from: b */
    public void m8921b(String text) {
        if (text.length() > 30) {
            text = f7720c + text.substring(text.length() - 30, text.length());
        }
        this.f7727i.setText(text);
    }

    /* renamed from: e */
    public void m8925e() {
        if (this.f7730l != null) {
            this.f7730l.postDelayed(new C23464(this), 50);
        }
    }

    /* renamed from: f */
    public void m8926f() {
        if (m8909i()) {
            m8910j();
        }
        m8908h();
    }

    /* renamed from: a */
    public void m8920a(final List list, final C1025a type) {
        this.f7738t.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2348h f7718c;

            public void run() {
                String tts;
                this.f7718c.f7739u.m3267a(list, type);
                this.f7718c.f7738t.setVisibility(0);
                this.f7718c.f7738t.smoothScrollToPosition(0);
                this.f7718c.f7727i.setText("");
                if (type == C1025a.ITEM_TYPE_MUSIC_LOCAL) {
                    tts = this.f7718c.f7724f.getString(C0965R.string.voice_domain_music_search_local);
                } else if (type == C1025a.ITEM_TYPE_MUSIC_ONLINE) {
                    tts = this.f7718c.f7724f.getString(C0965R.string.voice_domain_music_search_online);
                } else {
                    tts = this.f7718c.f7724f.getString(C0965R.string.voice_domain_phone_search_contact);
                }
                this.f7718c.f7728j.setText(tts);
                C1915a.m7321a().m7325a(null);
                C1915a.m7321a().m7328b(tts, 1);
            }
        });
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int itemType = parent.getAdapter().getItemViewType(position);
        if (itemType != C1025a.ITEM_TYPE_MUSIC_LOCAL.ordinal() && itemType != C1025a.ITEM_TYPE_MUSIC_ONLINE.ordinal()) {
            C1868q.m7089f().m7107a(this.f7724f, ((C1936n) parent.getItemAtPosition(position)).f6105b);
        }
    }

    /* renamed from: l */
    private void m8912l() {
        LayoutParams params = (LayoutParams) this.f7729k.getLayoutParams();
        params.height = (int) this.f7724f.getResources().getDimension(C0965R.dimen.common_icon_small);
        params.width = (int) this.f7724f.getResources().getDimension(C0965R.dimen.common_item_width);
        this.f7729k.setLayoutParams(params);
        this.f7729k.setBackground(C2251b.m8527a(this.f7724f));
    }

    /* renamed from: m */
    private void m8913m() {
        this.f7729k.setImageResource(C0965R.drawable.com_ic_close_selector);
        LayoutParams params = (LayoutParams) this.f7729k.getLayoutParams();
        params.height = (int) this.f7724f.getResources().getDimension(C0965R.dimen.common_icon_exit_height);
        params.width = (int) this.f7724f.getResources().getDimension(C0965R.dimen.common_icon_small);
        this.f7729k.setLayoutParams(params);
        this.f7729k.setBackgroundResource(C0965R.drawable.common_btn_bg_focus);
    }
}
