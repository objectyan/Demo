package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class HomeDiscoverCardView extends RelativeLayout implements OnTouchListener {
    /* renamed from: a */
    private View f7158a;
    /* renamed from: b */
    private View f7159b;
    /* renamed from: c */
    private View f7160c;
    /* renamed from: d */
    private View f7161d;
    /* renamed from: e */
    private View f7162e;
    /* renamed from: f */
    private TextView f7163f;
    /* renamed from: g */
    private ImageView f7164g;
    /* renamed from: h */
    private OnClickListener f7165h;
    /* renamed from: i */
    private int f7166i = -1;

    /* renamed from: com.baidu.carlife.view.HomeDiscoverCardView$1 */
    class C22191 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverCardView f7155a;

        C22191(HomeDiscoverCardView this$0) {
            this.f7155a = this$0;
        }

        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeDiscoverCardView$2 */
    class C22202 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverCardView f7156a;

        C22202(HomeDiscoverCardView this$0) {
            this.f7156a = this$0;
        }

        public void onClick(View v) {
            if (this.f7156a.f7165h != null && this.f7156a.isEnabled()) {
                this.f7156a.f7165h.onClick(this.f7156a);
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.HomeDiscoverCardView$3 */
    class C22213 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ HomeDiscoverCardView f7157a;

        C22213(HomeDiscoverCardView this$0) {
            this.f7157a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                this.f7157a.f7160c.setVisibility(8);
                this.f7157a.f7161d.setVisibility(0);
                return;
            }
            this.f7157a.f7161d.setVisibility(8);
        }
    }

    public HomeDiscoverCardView(Context context) {
        super(context);
        m8447a(context);
    }

    public HomeDiscoverCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m8447a(context);
    }

    /* renamed from: a */
    protected void m8447a(Context context) {
        this.f7158a = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0965R.layout.carlife_common_home_discover_card, this, true);
        this.f7159b = findViewById(C0965R.id.home_card_ll);
        this.f7160c = findViewById(C0965R.id.card_press_view);
        this.f7161d = findViewById(C0965R.id.card_focus_view);
        this.f7162e = findViewById(C0965R.id.red_point);
        this.f7164g = (ImageView) findViewById(C0965R.id.card_iv_icon);
        this.f7163f = (TextView) findViewById(C0965R.id.card_tv_name);
        this.f7158a.setOnTouchListener(new C22191(this));
        this.f7159b.setOnTouchListener(this);
        this.f7159b.setOnClickListener(new C22202(this));
        setOnFocusChangeListener(new C22213(this));
    }

    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
        this.f7165h = l;
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.5f);
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0 && isEnabled()) {
            this.f7160c.setVisibility(0);
        } else if (event.getAction() == 1) {
            this.f7160c.setVisibility(8);
        }
        return false;
    }

    /* renamed from: a */
    public HomeDiscoverCardView m8446a(String title) {
        this.f7163f.setText(title);
        return this;
    }

    public String getCardName() {
        return this.f7163f.getText().toString();
    }

    /* renamed from: a */
    public HomeDiscoverCardView m8445a(Drawable drawable) {
        this.f7164g.setImageDrawable(drawable);
        return this;
    }

    /* renamed from: a */
    public HomeDiscoverCardView m8444a(int resId) {
        this.f7164g.setImageResource(resId);
        return this;
    }

    /* renamed from: b */
    public HomeDiscoverCardView m8448b(int visibility) {
        this.f7162e.setVisibility(visibility);
        return this;
    }

    public int getTagInt() {
        return this.f7166i;
    }

    public void setTagInt(int tagInt) {
        this.f7166i = tagInt;
    }
}
