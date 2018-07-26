package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.widget.ImageView;

/* compiled from: RoundAngleImageView */
public final class db extends ImageView {
    /* renamed from: a */
    private Paint f21656a;
    /* renamed from: b */
    private int f21657b = 5;
    /* renamed from: c */
    private int f21658c = 5;
    /* renamed from: d */
    private Paint f21659d;

    public db(Context context) {
        super(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f21657b = (int) (((float) this.f21657b) * f);
        this.f21658c = (int) (f * ((float) this.f21658c));
        this.f21656a = new Paint();
        this.f21656a.setColor(-1);
        this.f21656a.setAntiAlias(true);
        this.f21656a.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        this.f21659d = new Paint();
        this.f21659d.setXfermode(null);
    }

    public final void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.RGB_565);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        Path path = new Path();
        path.moveTo(0.0f, (float) this.f21658c);
        path.lineTo(0.0f, 0.0f);
        path.lineTo((float) this.f21657b, 0.0f);
        path.arcTo(new RectF(0.0f, 0.0f, (float) (this.f21657b * 2), (float) (this.f21658c * 2)), -90.0f, -90.0f);
        path.close();
        canvas2.drawPath(path, this.f21656a);
        path = new Path();
        path.moveTo((float) getWidth(), (float) this.f21658c);
        path.lineTo((float) getWidth(), 0.0f);
        path.lineTo((float) (getWidth() - this.f21657b), 0.0f);
        path.arcTo(new RectF((float) (getWidth() - (this.f21657b * 2)), 0.0f, (float) getWidth(), (float) ((this.f21658c * 2) + 0)), -90.0f, 90.0f);
        path.close();
        canvas2.drawPath(path, this.f21656a);
        path = new Path();
        path.moveTo(0.0f, (float) (getHeight() - this.f21658c));
        path.lineTo(0.0f, (float) getHeight());
        path.lineTo((float) this.f21657b, (float) getHeight());
        path.arcTo(new RectF(0.0f, (float) (getHeight() - (this.f21658c * 2)), (float) ((this.f21657b * 2) + 0), (float) getHeight()), 90.0f, 90.0f);
        path.close();
        canvas2.drawPath(path, this.f21656a);
        path = new Path();
        path.moveTo((float) (getWidth() - this.f21657b), (float) getHeight());
        path.lineTo((float) getWidth(), (float) getHeight());
        path.lineTo((float) getWidth(), (float) (getHeight() - this.f21658c));
        path.arcTo(new RectF((float) (getWidth() - (this.f21657b * 2)), (float) (getHeight() - (this.f21658c * 2)), (float) getWidth(), (float) getHeight()), 0.0f, 90.0f);
        path.close();
        canvas2.drawPath(path, this.f21656a);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f21659d);
        createBitmap.recycle();
    }
}
