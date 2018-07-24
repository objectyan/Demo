package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.baidu.carlife.R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class StatusButton extends LinearLayout {
    /* renamed from: a */
    private RadioGroup f7247a;
    /* renamed from: b */
    private RadioButton f7248b;
    /* renamed from: c */
    private RadioButton f7249c;
    /* renamed from: d */
    private RadioButton f7250d;
    /* renamed from: e */
    private OnClickListener f7251e;
    /* renamed from: f */
    private OnClickListener f7252f;
    /* renamed from: g */
    private OnClickListener f7253g;
    /* renamed from: h */
    private C1550a f7254h;
    /* renamed from: i */
    private Context f7255i;
    /* renamed from: j */
    private int f7256j;
    /* renamed from: k */
    private boolean f7257k = true;

    /* renamed from: com.baidu.carlife.view.StatusButton$a */
    public interface C1550a {
        /* renamed from: a */
        void mo1592a(StatusButton statusButton, C2237b c2237b);
    }

    /* renamed from: com.baidu.carlife.view.StatusButton$1 */
    class C22361 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ StatusButton f7242a;

        C22361(StatusButton this$0) {
            this.f7242a = this$0;
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f7242a.f7248b.getId() && this.f7242a.f7256j != 1) {
                this.f7242a.f7256j = 1;
            } else if (checkedId == this.f7242a.f7249c.getId() && this.f7242a.f7256j != 2) {
                this.f7242a.f7256j = 2;
            } else if (checkedId == this.f7242a.f7250d.getId() && this.f7242a.f7256j != 3) {
                this.f7242a.f7256j = 3;
            } else {
                return;
            }
            if (this.f7242a.f7254h != null) {
                switch (this.f7242a.f7256j) {
                    case 1:
                        this.f7242a.f7254h.mo1592a(this.f7242a, C2237b.LEFT);
                        return;
                    case 2:
                        this.f7242a.f7254h.mo1592a(this.f7242a, C2237b.MID);
                        return;
                    case 3:
                        this.f7242a.f7254h.mo1592a(this.f7242a, C2237b.RIGHT);
                        return;
                    default:
                        return;
                }
            }
            switch (this.f7242a.f7256j) {
                case 1:
                    if (this.f7242a.f7251e != null) {
                        this.f7242a.f7251e.onClick(this.f7242a.f7248b);
                        return;
                    }
                    return;
                case 2:
                    if (this.f7242a.f7252f != null) {
                        this.f7242a.f7252f.onClick(this.f7242a.f7249c);
                        return;
                    }
                    return;
                case 3:
                    if (this.f7242a.f7253g != null) {
                        this.f7242a.f7253g.onClick(this.f7242a.f7250d);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.view.StatusButton$b */
    public enum C2237b {
        LEFT,
        MID,
        RIGHT
    }

    public StatusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7255i = context;
        m8485e();
    }

    public StatusButton(Context context) {
        super(context);
        this.f7255i = context;
        m8485e();
    }

    /* renamed from: a */
    public StatusButton m8495a(String content) {
        this.f7248b.setText(content);
        return this;
    }

    /* renamed from: a */
    public StatusButton m8490a(int resid) {
        this.f7248b.setText(resid);
        return this;
    }

    /* renamed from: b */
    public StatusButton m8502b(String content) {
        this.f7249c.setText(content);
        return this;
    }

    /* renamed from: b */
    public StatusButton m8500b(int resid) {
        this.f7249c.setText(resid);
        return this;
    }

    /* renamed from: c */
    public StatusButton m8506c(String content) {
        this.f7250d.setText(content);
        return this;
    }

    /* renamed from: c */
    public StatusButton m8504c(int resid) {
        this.f7250d.setText(resid);
        return this;
    }

    /* renamed from: a */
    public StatusButton m8497a(String content1, String content2, String content3) {
        this.f7248b.setText(content1);
        this.f7249c.setText(content2);
        this.f7250d.setText(content3);
        return this;
    }

    /* renamed from: a */
    public StatusButton m8492a(int resId1, int resId2, int resId3) {
        this.f7248b.setText(resId1);
        this.f7249c.setText(resId2);
        this.f7250d.setText(resId3);
        return this;
    }

    /* renamed from: a */
    public StatusButton m8496a(String contentLeft, String contentRight) {
        this.f7248b.setText(contentLeft);
        this.f7249c.setVisibility(8);
        this.f7250d.setText(contentRight);
        return this;
    }

    /* renamed from: a */
    public StatusButton m8491a(int resIdLeft, int resIdRight) {
        this.f7248b.setText(resIdLeft);
        this.f7249c.setVisibility(8);
        this.f7250d.setText(resIdRight);
        return this;
    }

    /* renamed from: a */
    public StatusButton m8489a() {
        this.f7248b.setChecked(true);
        this.f7256j = 1;
        return this;
    }

    /* renamed from: b */
    public StatusButton m8499b() {
        this.f7249c.setChecked(true);
        this.f7256j = 2;
        return this;
    }

    /* renamed from: c */
    public StatusButton m8503c() {
        this.f7250d.setChecked(true);
        this.f7256j = 3;
        return this;
    }

    /* renamed from: a */
    public StatusButton m8493a(OnClickListener leftCL) {
        this.f7251e = leftCL;
        return this;
    }

    /* renamed from: b */
    public StatusButton m8501b(OnClickListener midCL) {
        this.f7252f = midCL;
        return this;
    }

    /* renamed from: c */
    public StatusButton m8505c(OnClickListener rightCL) {
        this.f7253g = rightCL;
        return this;
    }

    /* renamed from: a */
    public StatusButton m8494a(C1550a allListener) {
        this.f7254h = allListener;
        return this;
    }

    /* renamed from: a */
    public StatusButton m8498a(boolean isGone) {
        this.f7249c.setVisibility(8);
        return this;
    }

    /* renamed from: d */
    public void m8507d() {
        if (this.f7257k) {
            this.f7248b.setTextColor(m8481b(StyleManager.getColor(R.color.nsdk_statusbutton_tc_default_night, false), StyleManager.getColor(R.color.nsdk_statusbutton_tc_pressed_night, false), StyleManager.getColor(R.color.nsdk_statusbutton_tc_pressed_night, false)));
            this.f7249c.setTextColor(m8481b(StyleManager.getColor(R.color.nsdk_statusbutton_tc_default_night, false), StyleManager.getColor(R.color.nsdk_statusbutton_tc_pressed_night, false), StyleManager.getColor(R.color.nsdk_statusbutton_tc_pressed_night, false)));
            this.f7250d.setTextColor(m8481b(StyleManager.getColor(R.color.nsdk_statusbutton_tc_default_night, false), StyleManager.getColor(R.color.nsdk_statusbutton_tc_pressed_night, false), StyleManager.getColor(R.color.nsdk_statusbutton_tc_pressed_night, false)));
            if (VERSION.SDK_INT > 15) {
                this.f7248b.setBackground(StyleManager.getDrawable(R.drawable.nsdk_drawable_statusbutton_left_button_night, false));
                this.f7249c.setBackground(StyleManager.getDrawable(R.drawable.nsdk_drawable_statusbutton_mid_button_night, false));
                this.f7250d.setBackground(StyleManager.getDrawable(R.drawable.nsdk_drawable_statusbutton_right_button_night, false));
                return;
            }
            this.f7248b.setBackgroundDrawable(StyleManager.getDrawable(R.drawable.nsdk_drawable_statusbutton_left_button_night, false));
            this.f7249c.setBackgroundDrawable(StyleManager.getDrawable(R.drawable.nsdk_drawable_statusbutton_mid_button_night, false));
            this.f7250d.setBackgroundDrawable(StyleManager.getDrawable(R.drawable.nsdk_drawable_statusbutton_right_button_night, false));
        }
    }

    /* renamed from: e */
    private void m8485e() {
        this.f7257k = BNSettingManager.isUsingMapMode();
        if (this.f7257k) {
            LayoutInflater.from(this.f7255i).inflate(R.layout.nsdk_layout_statusbutton, this);
        } else {
            LayoutInflater.from(this.f7255i).inflate(R.layout.nsdk_layout_statusbutton_carmode, this);
        }
        this.f7247a = (RadioGroup) findViewById(R.id.rbtngroup);
        this.f7248b = (RadioButton) this.f7247a.getChildAt(0);
        this.f7249c = (RadioButton) this.f7247a.getChildAt(1);
        this.f7250d = (RadioButton) this.f7247a.getChildAt(2);
        if (!BNStyleManager.getDayStyle()) {
            m8507d();
        }
        this.f7247a.setOnCheckedChangeListener(new C22361(this));
    }

    /* renamed from: b */
    private ColorStateList m8481b(int normal, int pressed, int checked) {
        int[] colors = new int[]{pressed, checked, normal};
        states = new int[3][];
        states[0] = new int[]{16842919};
        states[1] = new int[]{16842912};
        states[2] = new int[0];
        return new ColorStateList(states, colors);
    }
}
