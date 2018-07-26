package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;

public class CircularImageView extends ImageView {
    /* renamed from: a */
    private int f7084a = 0;
    /* renamed from: b */
    private Context f7085b;
    /* renamed from: c */
    private int f7086c = 17170445;

    /* renamed from: com.baidu.carlife.view.CircularImageView$1 */
    static /* synthetic */ class C22071 {
        /* renamed from: a */
        static final /* synthetic */ int[] f7083a = new int[ScaleType.values().length];

        static {
            try {
                f7083a[ScaleType.CENTER_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7083a[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7083a[ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7083a[ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7083a[ScaleType.CENTER_CROP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f7083a[ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f7083a[ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f7083a[ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public CircularImageView(Context context) {
        super(context);
        this.f7085b = context;
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7085b = context;
        setCustomAttributes(attrs);
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7085b = context;
        setCustomAttributes(attrs);
    }

    private void setCustomAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = this.f7085b.obtainStyledAttributes(attrs, C0965R.C0963p.circularimageview);
            this.f7084a = a.getDimensionPixelSize(0, 0);
            this.f7086c = a.getColor(1, this.f7086c);
            a.recycle();
        }
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            measure(0, 0);
            if (drawable.getClass() != NinePatchDrawable.class) {
                int i;
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                int w = getWidth();
                int h = getHeight();
                if (w < h) {
                    i = w;
                } else {
                    i = h;
                }
                int radius = (i / 2) - this.f7084a;
                Bitmap roundBitmap = m8391a(bitmap, radius);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                paint.setDither(true);
                paint.setColor(this.f7086c);
                canvas.drawCircle((float) (w / 2), (float) (h / 2), (float) (this.f7084a + radius), paint);
                canvas.drawBitmap(roundBitmap, (float) ((w / 2) - radius), (float) ((h / 2) - radius), null);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m8391a(Bitmap bitmap, int roundPixels) {
        int bw = bitmap.getWidth();
        int bh = bitmap.getHeight();
        int vw = getWidth();
        int vh = getHeight();
        if (vw <= 0) {
            vw = bw;
        }
        if (vh <= 0) {
            vh = bh;
        }
        ScaleType scaleType = getScaleType();
        if (scaleType == null) {
            return bitmap;
        }
        Rect srcRect;
        Rect destRect;
        int width;
        int height;
        Bitmap roundBitmap;
        int x;
        int y;
        switch (C22071.f7083a[scaleType.ordinal()]) {
            case 1:
                int destHeight;
                int destWidth;
                if (((float) vw) / ((float) vh) > ((float) bw) / ((float) bh)) {
                    destHeight = Math.min(vh, bh);
                    destWidth = (int) (((float) bw) / (((float) bh) / ((float) destHeight)));
                } else {
                    destWidth = Math.min(vw, bw);
                    destHeight = (int) (((float) bh) / (((float) bw) / ((float) destWidth)));
                }
                x = (vw - destWidth) / 2;
                y = (vh - destHeight) / 2;
                srcRect = new Rect(0, 0, bw, bh);
                destRect = new Rect(x, y, x + destWidth, y + destHeight);
                width = vw;
                height = vh;
                break;
            case 5:
                int srcWidth;
                int srcHeight;
                if (((float) vw) / ((float) vh) > ((float) bw) / ((float) bh)) {
                    srcWidth = bw;
                    srcHeight = (int) (((float) vh) * (((float) bw) / ((float) vw)));
                    x = 0;
                    y = (bh - srcHeight) / 2;
                } else {
                    srcWidth = (int) (((float) vw) * (((float) bh) / ((float) vh)));
                    srcHeight = bh;
                    x = (bw - srcWidth) / 2;
                    y = 0;
                }
                width = vw;
                height = vh;
                srcRect = new Rect(x, y, x + srcWidth, y + srcHeight);
                destRect = new Rect(0, 0, width, height);
                break;
            case 6:
                width = vw;
                height = vh;
                srcRect = new Rect(0, 0, bw, bh);
                destRect = new Rect(0, 0, width, height);
                break;
            case 7:
            case 8:
                width = Math.min(vw, bw);
                height = Math.min(vh, bh);
                x = (bw - width) / 2;
                y = (bh - height) / 2;
                srcRect = new Rect(x, y, x + width, y + height);
                destRect = new Rect(0, 0, width, height);
                break;
            default:
                if (((float) vw) / ((float) vh) > ((float) bw) / ((float) bh)) {
                    width = (int) (((float) bw) / (((float) bh) / ((float) vh)));
                    height = vh;
                } else {
                    width = vw;
                    height = (int) (((float) bh) / (((float) bw) / ((float) vw)));
                }
                srcRect = new Rect(0, 0, bw, bh);
                destRect = new Rect(0, 0, width, height);
                break;
        }
        try {
            roundBitmap = m8392a(bitmap, roundPixels, srcRect, destRect, width, height);
        } catch (OutOfMemoryError e) {
            C1260i.m4445e("CircularImageView", e.toString());
            roundBitmap = bitmap;
        } catch (Exception e2) {
            C1260i.m4445e("CircularImageView", e2.toString());
            roundBitmap = bitmap;
        }
        return roundBitmap;
    }

    /* renamed from: a */
    private Bitmap m8392a(Bitmap bitmap, int roundPixels, Rect srcRect, Rect destRect, int width, int height) {
        Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        RectF destRectF = new RectF(destRect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        canvas.drawRoundRect(destRectF, (float) roundPixels, (float) roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, srcRect, destRectF, paint);
        return output;
    }
}
