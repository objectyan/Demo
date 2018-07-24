package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.view.C2254b;
import com.baidu.carlife.view.KeyboardResultView;
import com.baidu.carlife.view.KeyboardResultView.C2226b;
import com.baidu.carlife.view.KeyboardResultView.C2227c;

/* compiled from: KeyBoardDialog */
/* renamed from: com.baidu.carlife.view.dialog.l */
public class C2298l extends BaseDialog implements OnClickListener {
    /* renamed from: e */
    private static final int f7521e = 26;
    /* renamed from: A */
    private TextView f7522A;
    /* renamed from: B */
    private C2227c f7523B;
    /* renamed from: C */
    private OnClickListener f7524C;
    /* renamed from: D */
    private boolean f7525D = false;
    /* renamed from: E */
    private boolean f7526E = false;
    /* renamed from: F */
    private C1443g f7527F = null;
    /* renamed from: G */
    private C1443g f7528G = null;
    /* renamed from: H */
    private C1443g f7529H = null;
    /* renamed from: I */
    private C1443g f7530I = null;
    /* renamed from: J */
    private C1443g f7531J = null;
    /* renamed from: f */
    private View f7532f;
    /* renamed from: g */
    private View f7533g;
    /* renamed from: h */
    private View f7534h;
    /* renamed from: i */
    private EditText f7535i;
    /* renamed from: j */
    private KeyboardResultView f7536j;
    /* renamed from: k */
    private C2254b f7537k;
    /* renamed from: l */
    private View f7538l;
    /* renamed from: m */
    private View f7539m;
    /* renamed from: n */
    private ImageView f7540n;
    /* renamed from: o */
    private View f7541o;
    /* renamed from: p */
    private TextView f7542p;
    /* renamed from: q */
    private View f7543q;
    /* renamed from: r */
    private TextView f7544r;
    /* renamed from: s */
    private TextView f7545s;
    /* renamed from: t */
    private View f7546t;
    /* renamed from: u */
    private View f7547u;
    /* renamed from: v */
    private TextView f7548v;
    /* renamed from: w */
    private View f7549w;
    /* renamed from: x */
    private TextView[] f7550x;
    /* renamed from: y */
    private char[] f7551y;
    /* renamed from: z */
    private TextView[] f7552z;

    /* compiled from: KeyBoardDialog */
    /* renamed from: com.baidu.carlife.view.dialog.l$1 */
    class C22921 implements C2226b {
        /* renamed from: a */
        final /* synthetic */ C2298l f7515a;

        C22921(C2298l this$0) {
            this.f7515a = this$0;
        }

        /* renamed from: a */
        public void mo1819a(boolean hasPrePage, boolean hasNextPage, int visibleCount) {
            float f = 0.3f;
            if (this.f7515a.f7537k.getCount() == 0 && TextUtils.isEmpty(this.f7515a.f7535i.getText())) {
                this.f7515a.f7532f.setVisibility(0);
                this.f7515a.findViewById(R.id.keyboard_result_hide_divider).setVisibility(0);
                this.f7515a.f7533g.setVisibility(8);
                this.f7515a.f7534h.setVisibility(8);
                this.f7515a.findViewById(R.id.keyboard_result_left_divider).setVisibility(8);
                this.f7515a.findViewById(R.id.keyboard_result_right_divider).setVisibility(8);
            } else {
                this.f7515a.f7532f.setVisibility(8);
                this.f7515a.findViewById(R.id.keyboard_result_hide_divider).setVisibility(8);
                if (hasPrePage || hasNextPage) {
                    float f2;
                    this.f7515a.f7533g.setVisibility(0);
                    this.f7515a.f7534h.setVisibility(0);
                    this.f7515a.findViewById(R.id.keyboard_result_left_divider).setVisibility(0);
                    this.f7515a.findViewById(R.id.keyboard_result_right_divider).setVisibility(0);
                    this.f7515a.f7533g.setEnabled(hasPrePage);
                    View d = this.f7515a.f7533g;
                    if (hasPrePage) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.3f;
                    }
                    d.setAlpha(f2);
                    this.f7515a.f7534h.setEnabled(hasNextPage);
                    View e = this.f7515a.f7534h;
                    if (hasNextPage) {
                        f = 1.0f;
                    }
                    e.setAlpha(f);
                } else {
                    this.f7515a.f7533g.setVisibility(8);
                    this.f7515a.f7534h.setVisibility(8);
                    this.f7515a.findViewById(R.id.keyboard_result_left_divider).setVisibility(8);
                    this.f7515a.findViewById(R.id.keyboard_result_right_divider).setVisibility(8);
                }
            }
            if (this.f7515a.f7527F == null) {
                return;
            }
            if (visibleCount > 0) {
                this.f7515a.f7527F.m5306i();
                if (hasPrePage) {
                    this.f7515a.f7527F.m5300d(this.f7515a.f7533g);
                }
                int i = 0;
                while (i < visibleCount && i <= this.f7515a.f7536j.getChildCount()) {
                    this.f7515a.f7527F.m5300d(this.f7515a.f7536j.getChildAt(i));
                    i++;
                }
                if (hasNextPage) {
                    this.f7515a.f7527F.m5300d(this.f7515a.f7534h);
                }
                this.f7515a.f7527F.m5299c(this.f7515a.f7536j.getChildAt(0));
                if (this.f7515a.f7525D) {
                    this.f7515a.f7527F.mo1554a();
                    this.f7515a.f7525D = false;
                    return;
                }
                return;
            }
            this.f7515a.f7527F.m5306i();
            this.f7515a.f7527F.m5300d(this.f7515a.f7532f);
            this.f7515a.f7527F.m5299c(this.f7515a.f7532f);
            if (this.f7515a.f7525D) {
                this.f7515a.f7527F.mo1554a();
                this.f7515a.f7525D = false;
            }
        }
    }

    /* compiled from: KeyBoardDialog */
    /* renamed from: com.baidu.carlife.view.dialog.l$2 */
    class C22932 implements C2227c {
        /* renamed from: a */
        final /* synthetic */ C2298l f7516a;

        C22932(C2298l this$0) {
            this.f7516a = this$0;
        }

        /* renamed from: a */
        public void mo1800a(int position, View itemView) {
            if (this.f7516a.f7523B != null) {
                this.f7516a.f7523B.mo1800a(position, itemView);
            }
        }
    }

    /* compiled from: KeyBoardDialog */
    /* renamed from: com.baidu.carlife.view.dialog.l$3 */
    class C22943 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2298l f7517a;

        C22943(C2298l this$0) {
            this.f7517a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0) {
                return false;
            }
            if (this.f7517a.f7522A != null && this.f7517a.f7522A.getVisibility() == 0) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 23:
                    case 300:
                    case 301:
                        return true;
                    default:
                        return false;
                }
            } else if (keyCode != 19) {
                return false;
            } else {
                this.f7517a.mo1526d();
                return true;
            }
        }
    }

    /* compiled from: KeyBoardDialog */
    /* renamed from: com.baidu.carlife.view.dialog.l$4 */
    class C22954 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2298l f7518a;

        C22954(C2298l this$0) {
            this.f7518a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0) {
                return false;
            }
            if (this.f7518a.f7522A != null && this.f7518a.f7522A.getVisibility() == 0) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 23:
                    case 300:
                    case 301:
                        return true;
                    default:
                        return false;
                }
            } else if (keyCode != 20) {
                return false;
            } else {
                this.f7518a.mo1526d();
                return true;
            }
        }
    }

    /* compiled from: KeyBoardDialog */
    /* renamed from: com.baidu.carlife.view.dialog.l$5 */
    class C22965 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2298l f7519a;

        C22965(C2298l this$0) {
            this.f7519a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0) {
                return false;
            }
            if (this.f7519a.f7522A != null && this.f7519a.f7522A.getVisibility() == 0) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 23:
                    case 300:
                    case 301:
                        return true;
                    default:
                        return false;
                }
            } else if (keyCode != 19 || this.f7519a.f7532f.getVisibility() != 8 || this.f7519a.f7537k.getCount() != 0) {
                return false;
            } else {
                this.f7519a.mo1526d();
                return true;
            }
        }
    }

    /* compiled from: KeyBoardDialog */
    /* renamed from: com.baidu.carlife.view.dialog.l$6 */
    class C22976 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2298l f7520a;

        C22976(C2298l this$0) {
            this.f7520a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0 || this.f7520a.f7522A == null || this.f7520a.f7522A.getVisibility() != 0) {
                return false;
            }
            switch (keyCode) {
                case 19:
                case 20:
                case 23:
                case 300:
                case 301:
                    return true;
                default:
                    return false;
            }
        }
    }

    public C2298l(Context context) {
        super(context);
    }

    public void setResultItemClickListener(C2227c listener) {
        this.f7523B = listener;
    }

    public void setOnClickListener(OnClickListener listener) {
        this.f7524C = listener;
    }

    public C2254b getResultAdapter() {
        return this.f7537k;
    }

    public EditText getResultEditText() {
        return this.f7535i;
    }

    public TextView getLetterSpaceKey() {
        return this.f7545s;
    }

    public TextView getLetterLanguageKey() {
        return this.f7542p;
    }

    public TextView[] getLetterKeys() {
        return this.f7550x;
    }

    public ImageView getLetterShiftKey() {
        return this.f7540n;
    }

    public int getLetterSize() {
        return 26;
    }

    public char[] getLetters() {
        return this.f7551y;
    }

    public TextView getLetterFinishKey() {
        return this.f7544r;
    }

    public TextView getNumFinishKey() {
        return this.f7548v;
    }

    public View getLetterKeyboard() {
        return this.f7538l;
    }

    public View getNumKeyboard() {
        return this.f7539m;
    }

    public KeyboardResultView getResultKeyboard() {
        return this.f7536j;
    }

    /* renamed from: a */
    protected View mo1528a() {
        View contentView = LayoutInflater.from(this.c).inflate(R.layout.keyboard, null);
        setCanceledOnTouchOutside(true);
        return contentView;
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7535i = (EditText) findViewById(R.id.keyboard_result_tv);
        this.f7536j = (KeyboardResultView) findViewById(R.id.keyboard_result);
        this.f7537k = new C2254b(this.c);
        this.f7536j.setAdapter(this.f7537k);
        this.f7536j.setPageCallback(new C22921(this));
        this.f7536j.setItemClickListener(new C22932(this));
        this.f7538l = findViewById(R.id.keyboard_letter);
        this.f7539m = findViewById(R.id.keyboard_num);
        this.f7532f = findViewById(R.id.keyboard_result_hide);
        this.f7532f.setOnClickListener(this);
        this.f7533g = findViewById(R.id.keyboard_result_left);
        this.f7533g.setOnClickListener(this);
        this.f7534h = findViewById(R.id.keyboard_result_right);
        this.f7534h.setOnClickListener(this);
        this.f7540n = (ImageView) findViewById(R.id.keyboard_letter_shift);
        this.f7540n.setOnClickListener(this);
        this.f7541o = findViewById(R.id.keyboard_letter_switch);
        this.f7541o.setOnClickListener(this);
        this.f7542p = (TextView) findViewById(R.id.keyboard_letter_language);
        this.f7542p.setOnClickListener(this);
        this.f7543q = findViewById(R.id.keyboard_letter_delete);
        this.f7543q.setOnClickListener(this);
        this.f7544r = (TextView) findViewById(R.id.keyboard_letter_finish);
        this.f7544r.setOnClickListener(this);
        this.f7545s = (TextView) findViewById(R.id.keyboard_letter_space);
        this.f7545s.setOnClickListener(this);
        this.f7546t = findViewById(R.id.keyboard_num_switch);
        this.f7546t.setOnClickListener(this);
        this.f7547u = findViewById(R.id.keyboard_num_delete);
        this.f7547u.setOnClickListener(this);
        this.f7548v = (TextView) findViewById(R.id.keyboard_num_finish);
        this.f7548v.setOnClickListener(this);
        this.f7549w = findViewById(R.id.keyboard_num_space);
        this.f7549w.setOnClickListener(this);
        this.f7551y = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        this.f7550x = new TextView[26];
        this.f7550x[0] = (TextView) findViewById(R.id.keyboard_q);
        this.f7550x[1] = (TextView) findViewById(R.id.keyboard_w);
        this.f7550x[2] = (TextView) findViewById(R.id.keyboard_e);
        this.f7550x[3] = (TextView) findViewById(R.id.keyboard_r);
        this.f7550x[4] = (TextView) findViewById(R.id.keyboard_t);
        this.f7550x[5] = (TextView) findViewById(R.id.keyboard_y);
        this.f7550x[6] = (TextView) findViewById(R.id.keyboard_u);
        this.f7550x[7] = (TextView) findViewById(R.id.keyboard_i);
        this.f7550x[8] = (TextView) findViewById(R.id.keyboard_o);
        this.f7550x[9] = (TextView) findViewById(R.id.keyboard_p);
        this.f7550x[10] = (TextView) findViewById(R.id.keyboard_a);
        this.f7550x[11] = (TextView) findViewById(R.id.keyboard_s);
        this.f7550x[12] = (TextView) findViewById(R.id.keyboard_d);
        this.f7550x[13] = (TextView) findViewById(R.id.keyboard_f);
        this.f7550x[14] = (TextView) findViewById(R.id.keyboard_g);
        this.f7550x[15] = (TextView) findViewById(R.id.keyboard_h);
        this.f7550x[16] = (TextView) findViewById(R.id.keyboard_j);
        this.f7550x[17] = (TextView) findViewById(R.id.keyboard_k);
        this.f7550x[18] = (TextView) findViewById(R.id.keyboard_l);
        this.f7550x[19] = (TextView) findViewById(R.id.keyboard_z);
        this.f7550x[20] = (TextView) findViewById(R.id.keyboard_x);
        this.f7550x[21] = (TextView) findViewById(R.id.keyboard_c);
        this.f7550x[22] = (TextView) findViewById(R.id.keyboard_v);
        this.f7550x[23] = (TextView) findViewById(R.id.keyboard_b);
        this.f7550x[24] = (TextView) findViewById(R.id.keyboard_n);
        this.f7550x[25] = (TextView) findViewById(R.id.keyboard_m);
        for (TextView temp : this.f7550x) {
            temp.setOnClickListener(this);
        }
        this.f7552z = new TextView[16];
        this.f7552z[0] = (TextView) findViewById(R.id.keyboard_0);
        this.f7552z[1] = (TextView) findViewById(R.id.keyboard_1);
        this.f7552z[2] = (TextView) findViewById(R.id.keyboard_2);
        this.f7552z[3] = (TextView) findViewById(R.id.keyboard_3);
        this.f7552z[4] = (TextView) findViewById(R.id.keyboard_4);
        this.f7552z[5] = (TextView) findViewById(R.id.keyboard_5);
        this.f7552z[6] = (TextView) findViewById(R.id.keyboard_6);
        this.f7552z[7] = (TextView) findViewById(R.id.keyboard_7);
        this.f7552z[8] = (TextView) findViewById(R.id.keyboard_8);
        this.f7552z[9] = (TextView) findViewById(R.id.keyboard_9);
        this.f7552z[10] = (TextView) findViewById(R.id.keyboard_char1);
        this.f7552z[11] = (TextView) findViewById(R.id.keyboard_char2);
        this.f7552z[12] = (TextView) findViewById(R.id.keyboard_char3);
        this.f7552z[13] = (TextView) findViewById(R.id.keyboard_char4);
        this.f7552z[14] = (TextView) findViewById(R.id.keyboard_char5);
        this.f7552z[15] = (TextView) findViewById(R.id.keyboard_char6);
        for (TextView temp2 : this.f7552z) {
            temp2.setOnClickListener(this);
        }
        this.f7522A = (TextView) findViewById(R.id.cover_view);
        this.f7522A.setOnClickListener(this);
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7527F == null) {
            this.f7527F = new C1443g(findViewById(R.id.keyboard_result_layout), 7, false);
            this.f7528G = new C1443g(findViewById(R.id.keyboard_keymid1), 13, false);
            this.f7529H = new C1443g(findViewById(R.id.keyboard_keymid2), 14, false);
            this.f7530I = new C1443g(findViewById(R.id.keyboard_keymid3), 15, false);
            this.f7531J = new C1443g(findViewById(R.id.keyboard_keydown), 11, false);
            OnKeyListener focusViewGroupUpKeyListener1 = new C22943(this);
            OnKeyListener focusViewGroupDownKeyListener = new C22954(this);
            OnKeyListener focusViewGroupUpKeyListener2 = new C22965(this);
            OnKeyListener focusViewGroupUpKeyListener3 = new C22976(this);
            this.f7527F.m5295a(focusViewGroupUpKeyListener1);
            this.f7531J.m5295a(focusViewGroupDownKeyListener);
            this.f7528G.m5295a(focusViewGroupUpKeyListener2);
            this.f7529H.m5295a(focusViewGroupUpKeyListener3);
            this.f7530I.m5295a(focusViewGroupUpKeyListener3);
        } else {
            this.f7527F.m5306i();
            this.f7528G.m5306i();
            this.f7529H.m5306i();
            this.f7530I.m5306i();
            this.f7531J.m5306i();
        }
        int i;
        if (this.f7526E) {
            this.f7527F.m5300d(this.f7532f);
            this.f7528G.m5300d(this.f7552z[10]);
            for (i = 1; i < 4; i++) {
                this.f7528G.m5300d(this.f7552z[i]);
            }
            this.f7528G.m5300d(this.f7547u);
            this.f7529H.m5300d(this.f7552z[11]);
            for (i = 4; i < 7; i++) {
                this.f7529H.m5300d(this.f7552z[i]);
            }
            this.f7529H.m5300d(this.f7552z[12]);
            this.f7530I.m5300d(this.f7552z[13]);
            for (i = 7; i < 10; i++) {
                this.f7530I.m5300d(this.f7552z[i]);
            }
            this.f7530I.m5300d(this.f7552z[14]);
            this.f7531J.m5300d(this.f7546t).m5300d(this.f7549w).m5300d(this.f7552z[0]).m5300d(this.f7552z[15]).m5300d(this.f7548v);
            this.f7527F.m5297b(this.f7532f).m5244a(true);
            this.f7528G.m5297b(this.f7552z[2]).m5298b(true).m5244a(true);
            this.f7529H.m5297b(this.f7552z[5]).m5298b(true).m5244a(true);
            this.f7530I.m5297b(this.f7552z[8]).m5298b(true).m5244a(true);
            this.f7531J.m5297b(this.f7552z[0]).m5298b(true).m5244a(true);
        } else {
            this.f7527F.m5300d(this.f7532f);
            for (i = 0; i < 10; i++) {
                this.f7528G.m5300d(this.f7550x[i]);
            }
            for (i = 10; i < 19; i++) {
                this.f7529H.m5300d(this.f7550x[i]);
            }
            this.f7530I.m5300d(this.f7540n);
            for (i = 19; i < 26; i++) {
                this.f7530I.m5300d(this.f7550x[i]);
            }
            this.f7530I.m5300d(this.f7543q);
            this.f7531J.m5300d(this.f7541o).m5300d(this.f7542p).m5300d(this.f7545s).m5300d(this.f7544r);
            this.f7527F.m5297b(this.f7532f).m5244a(true);
            this.f7528G.m5297b(this.f7550x[4]).m5298b(true).m5244a(true);
            this.f7529H.m5297b(this.f7550x[14]).m5298b(true).m5244a(true);
            this.f7530I.m5297b(this.f7550x[22]).m5298b(true).m5244a(true);
            this.f7531J.m5297b(this.f7545s).m5298b(true).m5244a(true);
        }
        C1440d.m5251a().m5253a(this.f7527F, this.f7529H, this.f7530I, this.f7531J, this.f7528G);
        C1440d.m5251a().m5268h(this.f7528G);
    }

    /* renamed from: g */
    public void mo1527g() {
        super.mo1527g();
        this.f7527F = null;
        this.f7528G = null;
        this.f7529H = null;
        this.f7530I = null;
        this.f7531J = null;
    }

    public void onClick(View v) {
        if (this.f7524C != null) {
            this.f7524C.onClick(v);
        }
        if (v.getId() == this.f7533g.getId() || v.getId() == this.f7534h.getId()) {
            this.f7525D = true;
        } else {
            this.f7525D = false;
        }
    }

    public void setNeedGrantResultFocus(boolean need) {
        this.f7525D = need;
    }

    public void setNumType(boolean isNum) {
        this.f7526E = isNum;
        mo1530f();
    }

    /* renamed from: i */
    public void mo1630i() {
        if (this.f7522A != null) {
            this.f7522A.setVisibility(0);
            this.f7522A.bringToFront();
        }
    }

    /* renamed from: j */
    public void m8737j() {
        if (this.f7522A != null) {
            this.f7522A.setVisibility(8);
        }
    }
}
