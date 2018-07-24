package com.baidu.carlife.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.p075d.C1431b.C1423e;
import com.baidu.carlife.p075d.C1431b.C1424f;
import com.baidu.carlife.p075d.C1431b.C1425g;

public class BatteryView extends RelativeLayout {
    /* renamed from: a */
    private Context f7057a;
    /* renamed from: b */
    private BatteryReceiver f7058b;
    /* renamed from: c */
    private View f7059c;
    /* renamed from: d */
    private ImageView f7060d;
    /* renamed from: e */
    private View f7061e;
    /* renamed from: f */
    private int f7062f;
    /* renamed from: g */
    private int f7063g;
    /* renamed from: h */
    private boolean f7064h;
    /* renamed from: i */
    private Bitmap f7065i;
    /* renamed from: j */
    private Bitmap f7066j;
    /* renamed from: k */
    private Bitmap f7067k;
    /* renamed from: l */
    private Paint f7068l;
    /* renamed from: m */
    private int f7069m;
    /* renamed from: n */
    private int f7070n;
    /* renamed from: o */
    private int f7071o;
    /* renamed from: p */
    private int f7072p;

    private class BatteryReceiver extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ BatteryView f7056a;

        private BatteryReceiver(BatteryView batteryView) {
            this.f7056a = batteryView;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int level = intent.getIntExtra("level", 0);
                switch (intent.getIntExtra("status", 1)) {
                    case 2:
                        this.f7056a.m8389b(level);
                        return;
                    case 3:
                        this.f7056a.m8385a(level);
                        return;
                    case 4:
                        this.f7056a.m8385a(level);
                        return;
                    case 5:
                        this.f7056a.m8389b(100);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public BatteryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BatteryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7062f = 0;
        this.f7063g = -1;
        this.f7064h = false;
        this.f7069m = 0;
        this.f7070n = 0;
        this.f7071o = 0;
        this.f7072p = 0;
        this.f7057a = context;
        m8386a(context);
    }

    /* renamed from: a */
    private void m8386a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1425g.widget_battery_view, this, true);
        this.f7059c = findViewById(C1424f.rl_battery);
        this.f7060d = (ImageView) findViewById(C1424f.iv_battery_state);
        if (this.f7060d != null) {
            this.f7060d.setVisibility(8);
        }
        this.f7061e = findViewById(C1424f.iv_charge);
        if (this.f7061e != null) {
            this.f7061e.setVisibility(8);
            this.f7069m = this.f7061e.getPaddingLeft();
            this.f7070n = this.f7061e.getPaddingRight();
            this.f7071o = this.f7061e.getPaddingBottom();
            this.f7072p = this.f7061e.getPaddingTop();
        }
        Resources res = getResources();
        this.f7066j = BitmapFactory.decodeResource(res, C1423e.statusbaric_ic_battery_electricity);
        this.f7065i = BitmapFactory.decodeResource(res, C1423e.statusbaric_ic_battery_electricity_black);
        this.f7068l = new Paint();
        this.f7067k = Bitmap.createBitmap(this.f7066j.getWidth(), this.f7066j.getHeight(), Config.ARGB_8888);
        this.f7067k.eraseColor(-65536);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.f7058b = new BatteryReceiver();
        this.f7057a.registerReceiver(this.f7058b, intentFilter);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f7057a != null && this.f7058b != null) {
            this.f7057a.unregisterReceiver(this.f7058b);
        }
    }

    public void setType(int type) {
        this.f7062f = type;
        if (!this.f7064h) {
            if (this.f7062f == 1) {
                setBackgroundResource(C1423e.statusbaric_ic_battery_bg_black);
                if (this.f7060d != null) {
                    this.f7060d.setBackgroundResource(C1423e.statusbaric_ic_battery_bg_black);
                }
                if (this.f7061e != null) {
                    this.f7061e.setBackgroundResource(C1423e.statusbaric_ic_battery_charge_black);
                }
            } else {
                setBackgroundResource(C1423e.statusbaric_ic_battery_bg);
                if (this.f7060d != null) {
                    this.f7060d.setBackgroundResource(C1423e.statusbaric_ic_battery_bg);
                }
                if (this.f7061e != null) {
                    this.f7061e.setBackgroundResource(C1423e.statusbaric_ic_battery_charge);
                }
            }
            invalidate();
        } else if (this.f7062f == 1) {
            setBackgroundResource(C1423e.statusbaric_ic_battery_charge_black);
        } else {
            setBackgroundResource(C1423e.statusbaric_ic_battery_charge);
        }
    }

    /* renamed from: a */
    private void m8385a(int level) {
        this.f7063g = level;
        this.f7064h = false;
        if (this.f7061e != null) {
            this.f7061e.setVisibility(8);
        }
        if (this.f7060d != null) {
            setType(this.f7062f);
            invalidate();
        } else {
            setType(this.f7062f);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m8389b(int level) {
        this.f7064h = true;
        this.f7063g = level;
        setType(this.f7062f);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7064h) {
            int dstHeight = (getHeight() - this.f7072p) - this.f7071o;
            Rect rectDest = new Rect(this.f7069m, (dstHeight - this.f7071o) - ((this.f7063g * dstHeight) / 100), getWidth() - this.f7070n, getHeight() - this.f7071o);
            Rect rectBmp = new Rect(0, this.f7065i.getHeight() - ((this.f7065i.getHeight() * this.f7063g) / 100), this.f7065i.getWidth(), this.f7065i.getHeight());
            if (this.f7063g <= 20) {
                canvas.drawBitmap(this.f7067k, rectBmp, rectDest, this.f7068l);
            } else if (this.f7062f == 1) {
                canvas.drawBitmap(this.f7065i, rectBmp, rectDest, this.f7068l);
            } else {
                canvas.drawBitmap(this.f7066j, rectBmp, rectDest, this.f7068l);
            }
        }
    }

    /* renamed from: a */
    public static int m8384a(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static int m8388b(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
