package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class ProgressIncreasingBar extends View {
    private static final String TAG = ProgressIncreasingBar.class.getSimpleName();
    private int animRate = 3;
    private int animTime = 1;
    private boolean animationFinish = false;
    private Canvas canvas;
    private int comHeight;
    private int comWidth;
    private Handler handler = new Handler();
    private boolean isAnim = true;
    private boolean isHasRateTopView;
    private OnAnimationStateListener listener = null;
    BNWorkerNormalTask<String, String> mRefreshViewTask = new BNWorkerNormalTask<String, String>("mRefreshViewTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            if (ProgressIncreasingBar.this.orientation == 0 && ProgressIncreasingBar.this.rateAnimValue <= ProgressIncreasingBar.this.rateWidth) {
                ProgressIncreasingBar.this.rateAnimValue = ProgressIncreasingBar.this.rateAnimValue + ProgressIncreasingBar.this.animRate;
                ProgressIncreasingBar.this.invalidate();
            } else if (ProgressIncreasingBar.this.orientation != 1 || ProgressIncreasingBar.this.rateAnimValue > ProgressIncreasingBar.this.rateHeight) {
                ProgressIncreasingBar.this.rateAnimValue = 0;
                if (ProgressIncreasingBar.this.listener != null) {
                    ProgressIncreasingBar.this.animationFinish = true;
                    ProgressIncreasingBar.this.listener.onAnimationFinish(true);
                }
            } else {
                ProgressIncreasingBar.this.rateAnimValue = ProgressIncreasingBar.this.rateAnimValue + ProgressIncreasingBar.this.animRate;
                ProgressIncreasingBar.this.invalidate();
            }
            return null;
        }
    };
    private int orientation;
    private Paint paint;
    private double progress;
    private Bitmap rataBackgroundBitmap;
    private int rateAnimValue;
    private String rateBackgroundColor;
    private int rateBackgroundId;
    private int rateHeight;
    private View rateTopView;
    private View rateView;
    private int rateWidth;

    public interface OnAnimationStateListener {
        void onAnimationFinish(boolean z);
    }

    public ProgressIncreasingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ProgressIncreasingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressIncreasingBar(Context context) {
        super(context);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.comWidth = w;
        this.comHeight = h;
        if (this.orientation == 0) {
            this.rateWidth = (int) (((double) w) * this.progress);
            this.rateHeight = h;
            return;
        }
        this.rateHeight = (int) (((double) h) * this.progress);
        this.rateWidth = w;
    }

    protected void onDraw(Canvas canvas) {
        boolean z = true;
        super.onDraw(canvas);
        this.canvas = canvas;
        if (this.paint == null) {
            this.paint = new Paint();
        }
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Style.FILL);
        Paint paint;
        if (this.rateBackgroundColor != null) {
            paint = this.paint;
            if (!this.isAnim || this.animationFinish) {
                z = false;
            }
            drawViewWithColor(paint, z);
        } else if (this.rateBackgroundId != -1) {
            paint = this.paint;
            if (!this.isAnim || this.animationFinish) {
                z = false;
            }
            drawViewWithBitmap(paint, z);
        }
    }

    private void drawViewWithColor(Paint paint, boolean isAnim) {
        paint.setColor(Color.parseColor(this.rateBackgroundColor));
        if (isAnim) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mRefreshViewTask, new BNWorkerConfig(2, 0), (long) this.animTime);
            if (this.orientation == 0) {
                this.canvas.drawRect(0.0f, 0.0f, (float) this.rateAnimValue, (float) this.comHeight, paint);
                return;
            }
            this.canvas.drawRect(0.0f, (float) (this.comHeight - this.rateAnimValue), (float) this.comWidth, (float) this.comHeight, paint);
        } else if (this.orientation == 0) {
            this.canvas.drawRect(0.0f, 0.0f, (float) this.rateWidth, (float) this.comHeight, paint);
        } else {
            this.canvas.drawRect(0.0f, (float) (this.comHeight - this.rateHeight), (float) this.comWidth, (float) this.comHeight, paint);
        }
    }

    private void drawViewWithBitmap(Paint paint, boolean isAnim) {
        if (this.rataBackgroundBitmap != null) {
            if (isAnim) {
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mRefreshViewTask, new BNWorkerConfig(2, 0), (long) this.animTime);
                if (this.orientation == 0) {
                    this.canvas.drawBitmap(this.rataBackgroundBitmap, null, new RectF(0.0f, 0.0f, (float) this.rateAnimValue, (float) this.comHeight), paint);
                    return;
                }
                this.canvas.drawBitmap(this.rataBackgroundBitmap, null, new RectF(0.0f, (float) (this.comHeight - this.rateAnimValue), (float) this.comWidth, (float) this.comHeight), paint);
            } else if (this.orientation == 0) {
                this.canvas.drawBitmap(this.rataBackgroundBitmap, null, new RectF(0.0f, 0.0f, (float) this.rateWidth, (float) this.comHeight), paint);
            } else {
                this.canvas.drawBitmap(this.rataBackgroundBitmap, null, new RectF(0.0f, (float) (this.comHeight - this.rateHeight), (float) this.comWidth, (float) this.comHeight), paint);
            }
        }
    }

    public double getProgress() {
        return this.progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public View getRateView() {
        return this.rateView;
    }

    public void setRateView(View rateView) {
        this.rateView = rateView;
    }

    public int getRateHeight() {
        return this.rateHeight;
    }

    public void setRateHeight(int rateHeight) {
        this.rateHeight = rateHeight;
    }

    public int getRateWidth() {
        return this.rateWidth;
    }

    public void setRateWidth(int rateWidth) {
        this.rateWidth = rateWidth;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public boolean isAnim() {
        return this.isAnim;
    }

    public void setAnim(boolean isAnim) {
        this.isAnim = isAnim;
    }

    public int getAnimRate() {
        return this.animRate;
    }

    public void setAnimRate(int animRate) {
        this.animRate = animRate;
    }

    public String getRateBackgroundColor() {
        return this.rateBackgroundColor;
    }

    public void setRateBackgroundColor(String rateBackgroundColor) {
        this.rateBackgroundColor = rateBackgroundColor;
        this.rateBackgroundId = -1;
        this.rataBackgroundBitmap = null;
    }

    public int getRateBackgroundId() {
        return this.rateBackgroundId;
    }

    public void setRateBackgroundId(int rateBackground) {
        this.rateBackgroundId = rateBackground;
        this.rataBackgroundBitmap = BitmapFactory.decodeResource(getResources(), this.rateBackgroundId);
        this.rateBackgroundColor = null;
    }

    public void setRateBackgroundId(int rateBackground, boolean naviSdk, int imgWidth, int imgHeight) {
        this.rateBackgroundId = rateBackground;
        if (naviSdk) {
            this.rataBackgroundBitmap = drawableToBitmap(JarUtils.getResources().getDrawable(rateBackground), imgWidth, imgHeight);
        }
        this.rateBackgroundColor = null;
    }

    private Bitmap drawableToBitmap(Drawable drawable, int imgWidth, int imgHeight) {
        if (imgWidth <= 0 || imgHeight <= 0 || drawable == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(imgWidth, imgHeight, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, imgWidth, imgHeight);
        drawable.draw(canvas);
        return bitmap;
    }

    public OnAnimationStateListener getListener() {
        return this.listener;
    }

    public void setListener(OnAnimationStateListener listener) {
        this.listener = listener;
    }
}
