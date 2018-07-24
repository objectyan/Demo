package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.media.TransportMediator;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.baidu.carlife.R;
import com.baidu.navisdk.ui.routeguide.subview.widget.FrameAnimationController;
import com.baidu.navisdk.util.common.ScreenUtil;

public class SwitchButton extends CheckBox {
    /* renamed from: A */
    private static final float f7262A = 350.0f;
    /* renamed from: C */
    private static final float f7263C = 15.0f;
    /* renamed from: t */
    private static final int f7264t = 255;
    /* renamed from: B */
    private float f7265B;
    /* renamed from: D */
    private float f7266D;
    /* renamed from: E */
    private float f7267E;
    /* renamed from: F */
    private float f7268F;
    /* renamed from: a */
    private Paint f7269a;
    /* renamed from: b */
    private ViewParent f7270b;
    /* renamed from: c */
    private Context f7271c;
    /* renamed from: d */
    private Bitmap f7272d;
    /* renamed from: e */
    private Bitmap f7273e;
    /* renamed from: f */
    private Bitmap f7274f;
    /* renamed from: g */
    private Bitmap f7275g;
    /* renamed from: h */
    private Bitmap f7276h;
    /* renamed from: i */
    private RectF f7277i;
    /* renamed from: j */
    private PorterDuffXfermode f7278j;
    /* renamed from: k */
    private float f7279k;
    /* renamed from: l */
    private float f7280l;
    /* renamed from: m */
    private float f7281m;
    /* renamed from: n */
    private float f7282n;
    /* renamed from: o */
    private float f7283o;
    /* renamed from: p */
    private float f7284p;
    /* renamed from: q */
    private float f7285q;
    /* renamed from: r */
    private int f7286r;
    /* renamed from: s */
    private int f7287s;
    /* renamed from: u */
    private int f7288u;
    /* renamed from: v */
    private boolean f7289v;
    /* renamed from: w */
    private boolean f7290w;
    /* renamed from: x */
    private OnCheckedChangeListener f7291x;
    /* renamed from: y */
    private OnCheckedChangeListener f7292y;
    /* renamed from: z */
    private boolean f7293z;

    /* renamed from: com.baidu.carlife.view.SwitchButton$a */
    private final class C2239a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SwitchButton f7260a;

        private C2239a(SwitchButton switchButton) {
            this.f7260a = switchButton;
        }

        public void run() {
            this.f7260a.performClick();
        }
    }

    /* renamed from: com.baidu.carlife.view.SwitchButton$b */
    private final class C2240b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SwitchButton f7261a;

        private C2240b(SwitchButton switchButton) {
            this.f7261a = switchButton;
        }

        public void run() {
            if (this.f7261a.f7293z) {
                this.f7261a.m8514b();
                FrameAnimationController.requestAnimationFrame(this);
            }
        }
    }

    public SwitchButton(Context context, AttributeSet attrs) {
        this(context, attrs, 16842860);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7288u = 255;
        this.f7289v = false;
        m8510a(context);
    }

    /* renamed from: a */
    private void m8510a(Context context) {
        this.f7271c = context;
        this.f7269a = new Paint();
        this.f7269a.setColor(-1);
        Resources resources = getResources();
        this.f7286r = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.f7287s = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f7272d = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_btn);
        if (this.f7289v) {
            this.f7274f = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_off_press);
            this.f7275g = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_off);
        } else {
            this.f7274f = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_on_press);
            this.f7275g = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_on);
        }
        this.f7276h = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_frame);
        this.f7273e = this.f7275g;
        this.f7285q = (float) this.f7274f.getWidth();
        this.f7283o = (float) this.f7276h.getWidth();
        this.f7284p = (float) this.f7276h.getHeight();
        this.f7282n = this.f7285q / 2.0f;
        this.f7281m = this.f7283o - (this.f7285q / 2.0f);
        this.f7280l = this.f7289v ? this.f7281m : this.f7282n;
        this.f7279k = m8508a(this.f7280l);
        this.f7265B = (float) ScreenUtil.getInstance().dip2px((float) f7262A);
        this.f7266D = (float) ScreenUtil.getInstance().dip2px((float) f7263C);
        this.f7277i = new RectF(0.0f, this.f7266D, (float) this.f7276h.getWidth(), ((float) this.f7274f.getHeight()) + this.f7266D);
        this.f7278j = new PorterDuffXfermode(Mode.SRC_IN);
    }

    public void setEnabled(boolean enabled) {
        this.f7288u = enabled ? 255 : TransportMediator.KEYCODE_MEDIA_PAUSE;
        super.setEnabled(enabled);
    }

    public boolean isChecked() {
        return this.f7289v;
    }

    public void toggle() {
        setInternalChecked(!this.f7289v);
    }

    private void setCheckedDelayed(final boolean checked) {
        postDelayed(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ SwitchButton f7259b;

            public void run() {
                this.f7259b.setInternalChecked(checked);
            }
        }, 10);
    }

    public void setChecked(boolean checked) {
        setInternalChecked(!checked);
    }

    private void setInternalChecked(boolean checked) {
        this.f7289v = checked;
        this.f7280l = checked ? this.f7281m : this.f7282n;
        this.f7279k = m8508a(this.f7280l);
        invalidate();
        if (!this.f7290w) {
            this.f7290w = true;
            Resources resources = getResources();
            if (this.f7289v) {
                this.f7274f = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_off_press);
                this.f7275g = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_off);
                this.f7273e = this.f7275g;
            } else {
                this.f7274f = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_on_press);
                this.f7275g = BitmapFactory.decodeResource(resources, R.drawable.com_ic_switch_on);
                this.f7273e = this.f7275g;
            }
            invalidate();
            if (this.f7291x != null) {
                boolean z;
                OnCheckedChangeListener onCheckedChangeListener = this.f7291x;
                if (this.f7289v) {
                    z = false;
                } else {
                    z = true;
                }
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
            if (this.f7292y != null) {
                this.f7292y.onCheckedChanged(this, this.f7289v);
            }
            this.f7290w = false;
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.f7291x = listener;
    }

    void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        this.f7292y = listener;
    }

    public boolean performClick() {
        m8512a(!this.f7289v);
        return true;
    }

    /* renamed from: a */
    private float m8508a(float btnPos) {
        return btnPos - (this.f7285q / 2.0f);
    }

    protected void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(this.f7277i, this.f7288u, 31);
        canvas.drawBitmap(this.f7276h, 0.0f, this.f7266D, this.f7269a);
        this.f7269a.setXfermode(this.f7278j);
        if (this.f7289v) {
            canvas.drawBitmap(this.f7272d, this.f7279k, this.f7266D, this.f7269a);
        } else {
            canvas.drawBitmap(this.f7272d, this.f7279k, this.f7266D, this.f7269a);
        }
        this.f7269a.setXfermode(null);
        canvas.drawBitmap(this.f7273e, this.f7279k, this.f7266D, this.f7269a);
        canvas.restore();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) this.f7283o, (int) (this.f7284p + (2.0f * this.f7266D)));
    }

    /* renamed from: a */
    private void m8512a(boolean turnOn) {
        this.f7293z = true;
        this.f7268F = turnOn ? -this.f7265B : this.f7265B;
        this.f7267E = this.f7280l;
        new C2240b().run();
    }

    /* renamed from: a */
    private void m8509a() {
        this.f7293z = false;
    }

    /* renamed from: b */
    private void m8514b() {
        this.f7267E += (this.f7268F * 16.0f) / 1000.0f;
        if (this.f7267E <= this.f7281m) {
            m8509a();
            this.f7267E = this.f7281m;
            setCheckedDelayed(true);
        } else if (this.f7267E >= this.f7282n) {
            m8509a();
            this.f7267E = this.f7282n;
            setCheckedDelayed(false);
        }
        m8515b(this.f7267E);
    }

    /* renamed from: b */
    private void m8515b(float position) {
        this.f7280l = position;
        this.f7279k = m8508a(this.f7280l);
        invalidate();
    }
}
