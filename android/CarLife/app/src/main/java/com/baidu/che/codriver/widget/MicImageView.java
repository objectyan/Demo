package com.baidu.che.codriver.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import com.baidu.platform.comapi.map.NodeType;
import com.baidu.platform.comapi.util.C4820d;

public class MicImageView extends ImageView {
    /* renamed from: a */
    public static final int f9451a = 0;
    /* renamed from: b */
    public static final int f9452b = 1;
    /* renamed from: c */
    public static final int f9453c = 2;
    /* renamed from: d */
    public static final int f9454d = 3;
    /* renamed from: e */
    private static final int f9455e = 144;
    /* renamed from: f */
    private LayerDrawable f9456f;
    /* renamed from: g */
    private ClipDrawable f9457g;
    /* renamed from: h */
    private ObjectAnimator f9458h;
    /* renamed from: i */
    private ValueAnimator f9459i;
    /* renamed from: j */
    private ValueAnimator f9460j;
    /* renamed from: k */
    private Paint f9461k;
    /* renamed from: l */
    private float f9462l;
    /* renamed from: m */
    private float f9463m;
    /* renamed from: n */
    private RectF f9464n;
    /* renamed from: o */
    private RectF f9465o;
    /* renamed from: p */
    private float f9466p;
    /* renamed from: q */
    private float f9467q;
    /* renamed from: r */
    private int f9468r;
    /* renamed from: s */
    private int f9469s;
    /* renamed from: t */
    private float f9470t;
    /* renamed from: u */
    private int f9471u = 0;

    /* renamed from: com.baidu.che.codriver.widget.MicImageView$1 */
    class C28771 implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ MicImageView f9449a;

        C28771(MicImageView this$0) {
            this.f9449a = this$0;
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            this.f9449a.f9470t = ((Float) animation.getAnimatedValue()).floatValue();
        }
    }

    /* renamed from: com.baidu.che.codriver.widget.MicImageView$2 */
    class C28782 implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ MicImageView f9450a;

        C28782(MicImageView this$0) {
            this.f9450a = this$0;
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            this.f9450a.f9468r = ((Integer) animation.getAnimatedValue()).intValue();
            this.f9450a.invalidate();
        }
    }

    public MicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10894d();
    }

    public MicImageView(Context context) {
        super(context);
        m10894d();
    }

    /* renamed from: d */
    private void m10894d() {
        this.f9456f = (LayerDrawable) getDrawable();
        this.f9457g = (ClipDrawable) this.f9456f.getDrawable(1);
        this.f9457g.setLevel(10000);
        this.f9461k = new Paint(1);
        this.f9461k.setColor(-16741121);
        this.f9461k.setStyle(Style.STROKE);
        this.f9461k.setStrokeWidth(m10888a(3.0f));
        this.f9462l = m10888a(55.0f);
        this.f9463m = m10888a(69.0f);
        this.f9458h = ObjectAnimator.ofInt(this.f9457g, "level", new int[]{3000, NodeType.E_PARTICLE, m_AppUI.MSG_APP_SAVESCREEN, 9000, 3000});
        this.f9458h.setDuration(1000);
        this.f9458h.setRepeatCount(-1);
        this.f9458h.setRepeatMode(1);
        this.f9458h.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f9459i = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f9459i.addUpdateListener(new C28771(this));
        this.f9459i.setDuration(1000);
        this.f9459i.setRepeatCount(-1);
        this.f9459i.setRepeatMode(1);
        this.f9459i.setInterpolator(new DecelerateInterpolator());
        this.f9460j = ValueAnimator.ofInt(new int[]{0, 360});
        this.f9460j.addUpdateListener(new C28782(this));
        this.f9460j.setDuration(1000);
        this.f9460j.setRepeatCount(-1);
        this.f9460j.setRepeatMode(-1);
        this.f9460j.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public int getCurrentState() {
        return this.f9471u;
    }

    /* renamed from: a */
    public void m10899a() {
        setState(0);
    }

    /* renamed from: b */
    public void m10901b() {
        setState(1);
    }

    /* renamed from: c */
    public void m10902c() {
        setState(2);
    }

    /* renamed from: a */
    public void m10900a(int progress) {
        if (progress < 0 || progress > 100) {
            progress = 0;
        }
        this.f9469s = progress;
        setState(3);
    }

    private void setState(int state) {
        if (this.f9471u != state) {
            this.f9471u = state;
            switch (state) {
                case 0:
                    m10896f();
                    m10898h();
                    return;
                case 1:
                case 3:
                    m10895e();
                    m10898h();
                    return;
                case 2:
                    m10897g();
                    m10896f();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: e */
    private void m10895e() {
        this.f9458h.start();
        this.f9459i.start();
    }

    /* renamed from: f */
    private void m10896f() {
        this.f9458h.cancel();
        this.f9459i.cancel();
        this.f9457g.setLevel(10000);
        this.f9461k.setAlpha(255);
        this.f9469s = 0;
        this.f9470t = 0.0f;
    }

    /* renamed from: g */
    private void m10897g() {
        this.f9460j.start();
    }

    /* renamed from: h */
    private void m10898h() {
        this.f9460j.cancel();
        this.f9468r = 0;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (this.f9471u) {
            case 1:
                m10891a(canvas);
                return;
            case 2:
                m10892b(canvas);
                return;
            case 3:
                m10893c(canvas);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m10891a(Canvas canvas) {
        float x = (float) (getWidth() / 2);
        float y = (float) (getHeight() / 2);
        float r = this.f9462l + (this.f9470t * (this.f9463m - this.f9462l));
        float angle = 20.0f + (this.f9470t * 10.0f);
        this.f9461k.setAlpha((int) ((1.0d - (0.8d * ((double) this.f9470t))) * 255.0d));
        RectF rectF = new RectF(x - r, y - r, x + r, y + r);
        canvas.drawArc(rectF, 360.0f - (angle / 2.0f), angle, false, this.f9461k);
        canvas.drawArc(rectF, 180.0f - (angle / 2.0f), angle, false, this.f9461k);
        this.f9461k.setAlpha((int) ((0.2d + (0.8d * ((double) this.f9470t))) * 255.0d));
        canvas.drawArc(this.f9464n, 350.0f, 20.0f, false, this.f9461k);
        canvas.drawArc(this.f9464n, 170.0f, 20.0f, false, this.f9461k);
    }

    /* renamed from: b */
    private void m10892b(Canvas canvas) {
        canvas.drawArc(this.f9464n, (float) (this.f9468r + 0), 60.0f, false, this.f9461k);
        canvas.drawArc(this.f9464n, (float) (this.f9468r + C4820d.f19955a), 60.0f, false, this.f9461k);
    }

    /* renamed from: c */
    private void m10893c(Canvas canvas) {
        canvas.drawArc(this.f9464n, 270.0f, (float) ((this.f9469s * 360) / 100), false, this.f9461k);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dimension = (int) m10888a(144.0f);
        setMeasuredDimension(dimension, dimension);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f9466p = (float) (w / 2);
        this.f9467q = (float) (h / 2);
        this.f9464n = new RectF(this.f9466p - this.f9462l, this.f9467q - this.f9462l, this.f9466p + this.f9462l, this.f9467q + this.f9462l);
        this.f9465o = new RectF(this.f9466p - this.f9463m, this.f9467q - this.f9463m, this.f9466p + this.f9463m, this.f9467q + this.f9463m);
    }

    /* renamed from: a */
    private float m10888a(float x) {
        return TypedValue.applyDimension(1, x, getResources().getDisplayMetrics());
    }
}
