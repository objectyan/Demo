package com.baidu.carlife.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;

public class DiscoverCardView extends ConstraintLayout {
    /* renamed from: a */
    private View f7102a;
    /* renamed from: b */
    private TextView f7103b;
    /* renamed from: c */
    private TextView f7104c;
    /* renamed from: d */
    private ImageView f7105d;
    /* renamed from: e */
    private View f7106e;
    /* renamed from: f */
    private View f7107f;
    /* renamed from: g */
    private int f7108g = -1;

    /* renamed from: com.baidu.carlife.view.DiscoverCardView$1 */
    class C22091 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ DiscoverCardView f7101a;

        C22091(DiscoverCardView this$0) {
            this.f7101a = this$0;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                this.f7101a.f7106e.setVisibility(0);
            } else {
                this.f7101a.f7106e.setVisibility(8);
            }
        }
    }

    public DiscoverCardView(Context context) {
        super(context);
        m8405a(context);
    }

    public DiscoverCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        m8405a(context);
    }

    public DiscoverCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m8405a(context);
    }

    /* renamed from: a */
    private void m8405a(Context context) {
        this.f7102a = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0965R.layout.item_discover_card, this, true);
        this.f7105d = (ImageView) this.f7102a.findViewById(C0965R.id.icon);
        this.f7103b = (TextView) this.f7102a.findViewById(C0965R.id.title);
        this.f7107f = this.f7102a.findViewById(C0965R.id.red_point);
        this.f7104c = (TextView) this.f7102a.findViewById(C0965R.id.description);
        this.f7106e = this.f7102a.findViewById(C0965R.id.card_focus_view);
        setOnFocusChangeListener(new C22091(this));
    }

    /* renamed from: a */
    public DiscoverCardView m8406a(int resId) {
        this.f7105d.setImageResource(resId);
        return this;
    }

    /* renamed from: a */
    public DiscoverCardView m8407a(String title) {
        this.f7103b.setText(title);
        return this;
    }

    public String getCardName() {
        return this.f7103b.getText().toString();
    }

    /* renamed from: b */
    public DiscoverCardView m8408b(String description) {
        this.f7104c.setText(description);
        return this;
    }

    public int getTagInt() {
        return this.f7108g;
    }

    public void setTagInt(int tagInt) {
        this.f7108g = tagInt;
    }

    public void setCardDescriptionVisibility(boolean visible) {
        if (visible) {
            this.f7104c.setVisibility(0);
            return;
        }
        this.f7104c.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.f7103b.getLayoutParams();
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        this.f7103b.setLayoutParams(layoutParams);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.5f);
        }
    }

    public void setCardTitleColor(int color) {
        if (this.f7103b != null) {
            this.f7103b.setTextColor(color);
        }
    }

    public void setRedPointVisibility(int visiable) {
        this.f7107f.setVisibility(visiable);
    }
}
