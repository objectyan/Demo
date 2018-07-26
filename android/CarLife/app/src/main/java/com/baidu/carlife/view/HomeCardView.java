package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;

public class HomeCardView extends RelativeLayout implements OnTouchListener {
    /* renamed from: a */
    private static final String f7136a = HomeCardView.class.getSimpleName();
    /* renamed from: b */
    private C2218a f7137b;
    /* renamed from: c */
    private View f7138c;
    /* renamed from: d */
    private View f7139d;
    /* renamed from: e */
    private View f7140e;
    /* renamed from: f */
    private View f7141f;
    /* renamed from: g */
    private View f7142g;
    /* renamed from: h */
    private View f7143h;
    /* renamed from: i */
    private View f7144i;
    /* renamed from: j */
    private View f7145j;
    /* renamed from: k */
    private TextView f7146k;
    /* renamed from: l */
    private TextView f7147l;
    /* renamed from: m */
    private ImageView f7148m;
    /* renamed from: n */
    private ImageView f7149n;
    /* renamed from: o */
    private ImageView f7150o;
    /* renamed from: p */
    private HomeCardMusicMelodyView f7151p;
    /* renamed from: q */
    private OnClickListener f7152q;
    /* renamed from: r */
    private OnClickListener f7153r;
    /* renamed from: s */
    private OnClickListener f7154s;

    /* renamed from: com.baidu.carlife.view.HomeCardView$1 */
    class C22101 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7121a;

        C22101(HomeCardView this$0) {
            this.f7121a = this$0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$2 */
    class C22112 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7122a;

        C22112(HomeCardView this$0) {
            this.f7122a = this$0;
        }

        public void onClick(View v) {
            if (this.f7122a.f7154s != null) {
                this.f7122a.f7154s.onClick(this.f7122a);
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$3 */
    class C22123 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7123a;

        C22123(HomeCardView this$0) {
            this.f7123a = this$0;
        }

        public void onClick(View v) {
            if (this.f7123a.f7154s != null) {
                this.f7123a.f7154s.onClick(this.f7123a);
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$4 */
    class C22134 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7124a;

        C22134(HomeCardView this$0) {
            this.f7124a = this$0;
        }

        public void onClick(View v) {
            if (this.f7124a.f7152q != null) {
                this.f7124a.f7152q.onClick(v);
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$5 */
    class C22145 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7125a;

        C22145(HomeCardView this$0) {
            this.f7125a = this$0;
        }

        public void onClick(View v) {
            if (this.f7125a.f7153r != null) {
                this.f7125a.f7153r.onClick(v);
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$6 */
    class C22156 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7126a;

        C22156(HomeCardView this$0) {
            this.f7126a = this$0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (this.f7126a.f7137b == C2218a.Discover) {
                if (event.getAction() == 0) {
                    this.f7126a.f7142g.setVisibility(0);
                } else if (event.getAction() == 1) {
                    this.f7126a.f7142g.setVisibility(8);
                }
            }
            return false;
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$7 */
    class C22167 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7127a;

        C22167(HomeCardView this$0) {
            this.f7127a = this$0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (this.f7127a.f7137b == C2218a.Carlife) {
                if (event.getAction() == 0) {
                    this.f7127a.f7142g.setVisibility(0);
                } else if (event.getAction() == 1) {
                    this.f7127a.f7142g.setVisibility(8);
                }
            }
            return false;
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$8 */
    class C22178 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ HomeCardView f7128a;

        C22178(HomeCardView this$0) {
            this.f7128a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                this.f7128a.f7142g.setVisibility(8);
                this.f7128a.f7143h.setVisibility(0);
                return;
            }
            this.f7128a.f7143h.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeCardView$a */
    public enum C2218a {
        Navi("Navi"),
        Music("Music"),
        Discover("Discover"),
        Carlife("Carlife"),
        ExitCarlife("ExitCarlife");
        
        /* renamed from: f */
        private String f7135f;

        private C2218a(String type) {
            this.f7135f = type;
        }

        /* renamed from: a */
        public synchronized String m8409a() {
            return this.f7135f;
        }

        /* renamed from: a */
        public synchronized void m8410a(String type) {
            this.f7135f = type;
        }
    }

    public HomeCardView(Context context) {
        super(context);
        m8423a(context);
    }

    public HomeCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m8423a(context);
        m8424a(context, attrs);
    }

    /* renamed from: a */
    protected void m8423a(Context context) {
        this.f7138c = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0965R.layout.carlife_common_home_card, this, true);
        this.f7139d = findViewById(C0965R.id.home_card_ll);
        this.f7140e = findViewById(C0965R.id.home_card_up_ll);
        this.f7141f = findViewById(C0965R.id.home_card_content_ll);
        this.f7144i = findViewById(C0965R.id.home_card_middle_ll);
        this.f7142g = findViewById(C0965R.id.card_press_view);
        this.f7143h = findViewById(C0965R.id.card_focus_view);
        this.f7145j = findViewById(C0965R.id.red_point);
        this.f7146k = (TextView) findViewById(C0965R.id.tv_home_card_up_title);
        this.f7147l = (TextView) findViewById(C0965R.id.tv_home_card_up_info);
        this.f7148m = (ImageView) findViewById(C0965R.id.iv_home_card_middle_first);
        this.f7149n = (ImageView) findViewById(C0965R.id.iv_home_card_middle_secend);
        this.f7150o = (ImageView) findViewById(C0965R.id.iv_home_card_vehicle_logo);
        this.f7151p = (HomeCardMusicMelodyView) findViewById(C0965R.id.music_melody);
        this.f7138c.setOnTouchListener(new C22101(this));
        this.f7141f.setOnTouchListener(this);
        this.f7140e.setOnTouchListener(this);
        this.f7140e.setOnClickListener(new C22112(this));
        this.f7141f.setOnClickListener(new C22123(this));
        this.f7148m.setOnClickListener(new C22134(this));
        this.f7149n.setOnClickListener(new C22145(this));
        this.f7148m.setOnTouchListener(new C22156(this));
        this.f7150o.setOnTouchListener(new C22167(this));
        setOnFocusChangeListener(new C22178(this));
    }

    public void setFocusViewGone() {
        this.f7143h.setVisibility(8);
    }

    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
        this.f7154s = l;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            this.f7142g.setVisibility(0);
        } else if (event.getAction() == 1) {
            this.f7142g.setVisibility(8);
        }
        return false;
    }

    /* renamed from: a */
    protected void m8424a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, C0965R.C0963p.HomeCardView);
            String cardType = typedArray.getString(7);
            if (!TextUtils.isEmpty(cardType)) {
                if (C2218a.Navi.m8409a().equals(cardType)) {
                    this.f7137b = C2218a.Navi;
                } else if (C2218a.Music.m8409a().equals(cardType)) {
                    this.f7137b = C2218a.Music;
                } else if (C2218a.Discover.m8409a().equals(cardType)) {
                    this.f7137b = C2218a.Discover;
                } else if (C2218a.Carlife.m8409a().equals(cardType)) {
                    this.f7137b = C2218a.Carlife;
                } else if (C2218a.ExitCarlife.m8409a().equals(cardType)) {
                    this.f7137b = C2218a.ExitCarlife;
                }
            }
            Drawable background = typedArray.getDrawable(0);
            if (background != null) {
                this.f7139d.setBackground(background);
            }
            if (this.f7137b == C2218a.Carlife) {
                Drawable vehicleName = typedArray.getDrawable(1);
                Drawable vehicleLogo = typedArray.getDrawable(2);
                this.f7146k.setText(typedArray.getString(3));
                if (vehicleName != null) {
                    this.f7140e.setBackground(vehicleName);
                }
                if (vehicleLogo != null) {
                    this.f7150o.setImageDrawable(vehicleLogo);
                }
                this.f7150o.setVisibility(0);
                this.f7144i.setVisibility(8);
            } else {
                this.f7150o.setVisibility(8);
                this.f7144i.setVisibility(0);
                String title = typedArray.getString(3);
                String info = typedArray.getString(4);
                this.f7146k.setText(title);
                this.f7147l.setText(info);
                Drawable first = typedArray.getDrawable(5);
                Drawable secend = typedArray.getDrawable(6);
                if (first != null) {
                    this.f7148m.setImageDrawable(first);
                    this.f7148m.setVisibility(0);
                } else {
                    this.f7148m.setVisibility(8);
                }
                if (secend != null) {
                    this.f7149n.setImageDrawable(secend);
                    this.f7149n.setVisibility(0);
                } else {
                    this.f7149n.setVisibility(8);
                }
            }
            typedArray.recycle();
        }
    }

    /* renamed from: a */
    public HomeCardView m8421a(C2218a cardType) {
        this.f7137b = cardType;
        return this;
    }

    /* renamed from: a */
    public HomeCardView m8422a(String title) {
        this.f7146k.setText(title);
        return this;
    }

    /* renamed from: b */
    public HomeCardView m8429b(String info) {
        this.f7147l.setText(info);
        return this;
    }

    /* renamed from: a */
    public HomeCardView m8418a(int visibility) {
        this.f7148m.setVisibility(visibility);
        return this;
    }

    /* renamed from: a */
    public HomeCardView m8417a() {
        this.f7148m.setVisibility(0);
        return this;
    }

    /* renamed from: b */
    public HomeCardView m8425b() {
        this.f7149n.setVisibility(0);
        return this;
    }

    /* renamed from: c */
    public HomeCardView m8430c() {
        this.f7148m.setVisibility(8);
        return this;
    }

    /* renamed from: d */
    public HomeCardView m8435d() {
        this.f7149n.setVisibility(8);
        return this;
    }

    /* renamed from: a */
    public HomeCardView m8419a(Drawable drawable) {
        if (drawable != null) {
            this.f7148m.setImageDrawable(drawable);
            this.f7148m.setVisibility(0);
        } else {
            this.f7148m.setVisibility(8);
        }
        return this;
    }

    /* renamed from: b */
    public HomeCardView m8426b(int resId) {
        this.f7148m.setImageResource(resId);
        return this;
    }

    /* renamed from: b */
    public HomeCardView m8427b(Drawable drawable) {
        if (drawable != null) {
            this.f7149n.setImageDrawable(drawable);
            this.f7149n.setVisibility(0);
        } else {
            this.f7149n.setVisibility(8);
        }
        return this;
    }

    /* renamed from: c */
    public HomeCardView m8431c(int resId) {
        this.f7149n.setImageResource(resId);
        return this;
    }

    /* renamed from: d */
    public HomeCardView m8436d(int visibility) {
        this.f7145j.setVisibility(visibility);
        return this;
    }

    /* renamed from: c */
    public HomeCardView m8432c(Drawable drawable) {
        this.f7150o.setImageDrawable(drawable);
        return this;
    }

    /* renamed from: e */
    public HomeCardView m8438e(int resId) {
        this.f7150o.setImageResource(resId);
        return this;
    }

    /* renamed from: d */
    public HomeCardView m8437d(Drawable drawable) {
        this.f7140e.setBackground(drawable);
        this.f7146k.setText("");
        return this;
    }

    /* renamed from: f */
    public HomeCardView m8439f(int resId) {
        this.f7140e.setBackgroundResource(resId);
        this.f7146k.setText("");
        return this;
    }

    /* renamed from: c */
    public HomeCardView m8434c(String name) {
        this.f7146k.setText(name);
        this.f7140e.setBackground(null);
        return this;
    }

    /* renamed from: g */
    public HomeCardView m8440g(int visibility) {
        this.f7151p.setVisibility(visibility);
        return this;
    }

    public HomeCardMusicMelodyView getMusicMelody() {
        return this.f7151p;
    }

    /* renamed from: a */
    public HomeCardView m8420a(OnClickListener listener) {
        this.f7152q = listener;
        return this;
    }

    /* renamed from: b */
    public HomeCardView m8428b(OnClickListener listener) {
        this.f7153r = listener;
        return this;
    }

    /* renamed from: c */
    public HomeCardView m8433c(OnClickListener listener) {
        this.f7150o.setOnClickListener(listener);
        return this;
    }
}
