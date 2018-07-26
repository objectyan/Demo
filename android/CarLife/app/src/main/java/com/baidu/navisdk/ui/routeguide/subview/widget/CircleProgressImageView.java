package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Timer;
import java.util.TimerTask;

public class CircleProgressImageView extends ImageView {
    private static final boolean DEFAULT_FILL_MODE = true;
    private static final int DEFAULT_INSIDE_VALUE = 0;
    private static final int DEFAULT_MAX_VALUE = 100;
    private static final int DEFAULT_PAINT_COLOR = 0;
    private static final int DEFAULT_PAINT_WIDTH = 10;
    private static final int DEFAULT_PROGRESS_PAINT_WIDTH = 10;
    private int mBackgroundColor;
    private Drawable mBackgroundPicture;
    private CartoomEngine mCartoomEngine;
    private CircleAttribute mCircleAttribute;
    private boolean mIsBackgroundFill;
    private boolean mIsMainCapRound = false;
    private int mMainCurProgress;
    private int mMaxProgress;
    private int mSubCurProgress;
    private int mSubProgressColor;
    private String mText;

    class CartoomEngine {
        private static final int TIMER_ID = 16;
        public boolean mBCartoom = false;
        public float mCurFloatProcess = 0.0f;
        public Handler mHandler;
        public int mSaveMax = 0;
        public Timer mTimer = new Timer(getClass().getSimpleName() + "_CartoomEngine");
        public int mTimerInterval = 50;
        public MyTimerTask mTimerTask;
        private long timeMil;

        class MyTimerTask extends TimerTask {
            MyTimerTask() {
            }

            public void run() {
                CartoomEngine.this.mHandler.obtainMessage(16).sendToTarget();
            }
        }

        public CartoomEngine() {
            this.mHandler = new Handler(CircleProgressImageView.this) {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 16:
                            if (CartoomEngine.this.mBCartoom) {
                                CartoomEngine cartoomEngine = CartoomEngine.this;
                                cartoomEngine.mCurFloatProcess += 1.0f;
                                CircleProgressImageView.this.setMainProgress((int) CartoomEngine.this.mCurFloatProcess);
                                CartoomEngine.this.timeMil = System.currentTimeMillis();
                                if (CartoomEngine.this.mCurFloatProcess >= ((float) CircleProgressImageView.this.mMaxProgress)) {
                                    CartoomEngine.this.stopCartoom();
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        public synchronized void startCartoom(int time) {
            if (time > 0) {
                if (!this.mBCartoom) {
                    this.timeMil = 0;
                    this.mBCartoom = true;
                    CircleProgressImageView.this.setMainProgress(0);
                    CircleProgressImageView.this.setSubProgress(0);
                    this.mSaveMax = CircleProgressImageView.this.mMaxProgress;
                    CircleProgressImageView.this.mMaxProgress = (1000 / this.mTimerInterval) * time;
                    this.mCurFloatProcess = 0.0f;
                    this.mTimerTask = new MyTimerTask();
                    this.mTimer.schedule(this.mTimerTask, (long) this.mTimerInterval, (long) this.mTimerInterval);
                }
            }
        }

        public synchronized void stopCartoom() {
            if (this.mBCartoom) {
                this.mBCartoom = false;
                CircleProgressImageView.this.mMaxProgress = this.mSaveMax;
                CircleProgressImageView.this.setMainProgress(0);
                CircleProgressImageView.this.setSubProgress(0);
                if (this.mTimerTask != null) {
                    this.mTimerTask.cancel();
                    this.mTimerTask = null;
                }
            }
        }
    }

    class CircleAttribute {
        public boolean mBRoundPaintsFill = true;
        public int mBeamHeight;
        public Paint mBottomPaint;
        public int mDrawPos = -90;
        public Paint mMainPaints = new Paint();
        public int mPaintColor = 0;
        public int mPaintWidth = 0;
        public int mProgressPaintWidth = 0;
        public RectF mRoundOval = new RectF();
        public int mSidePaintInterval = 0;
        public Paint mSubPaint;
        public Paint mTextPaint;
        public int mTextPaintColor;

        public CircleAttribute() {
            this.mMainPaints.setAntiAlias(true);
            this.mMainPaints.setStyle(Style.FILL);
            this.mMainPaints.setStrokeWidth((float) this.mPaintWidth);
            this.mMainPaints.setColor(this.mPaintColor);
            this.mSubPaint = new Paint();
            this.mSubPaint.setAntiAlias(true);
            this.mSubPaint.setStyle(Style.FILL);
            this.mSubPaint.setStrokeWidth((float) this.mPaintWidth);
            this.mSubPaint.setColor(this.mPaintColor);
            this.mBottomPaint = new Paint();
            this.mBottomPaint.setAntiAlias(true);
            this.mBottomPaint.setStyle(Style.FILL);
            this.mBottomPaint.setStrokeWidth((float) this.mPaintWidth);
            this.mBottomPaint.setColor(-7829368);
            this.mTextPaint = new Paint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Align.CENTER);
            this.mTextPaint.setStyle(Style.FILL);
            this.mTextPaint.setStrokeWidth((float) this.mPaintWidth);
            this.mTextPaint.setColor(-16777216);
            this.mTextPaint.setTextSize((float) ScreenUtil.getInstance().dip2px(25));
        }

        public void setPaintWidth(int width) {
            this.mMainPaints.setStrokeWidth((float) width);
            this.mSubPaint.setStrokeWidth((float) width);
            this.mBottomPaint.setStrokeWidth((float) width);
        }

        public void setProgressPaintWidth(int width) {
            this.mMainPaints.setStrokeWidth((float) width);
            this.mProgressPaintWidth = width;
        }

        public void setPaintColor(int color) {
            this.mMainPaints.setColor(color);
            this.mSubPaint.setColor((16777215 & color) | 1711276032);
        }

        public void setBackgroundColor(int color) {
            this.mBottomPaint.setColor(color);
        }

        public void setTextColor(int color) {
            this.mTextPaintColor = color;
            this.mTextPaint.setColor(this.mTextPaintColor);
        }

        public void setFill(boolean fill) {
            this.mBRoundPaintsFill = fill;
            if (fill) {
                this.mMainPaints.setStyle(Style.FILL);
                this.mSubPaint.setStyle(Style.FILL);
                this.mBottomPaint.setStyle(Style.FILL);
                return;
            }
            this.mMainPaints.setStyle(Style.STROKE);
            this.mSubPaint.setStyle(Style.STROKE);
            this.mBottomPaint.setStyle(Style.STROKE);
        }

        public void autoFix(int w, int h) {
            int paintWidth = Math.max(this.mPaintWidth, this.mProgressPaintWidth);
            if (this.mSidePaintInterval != 0) {
                this.mRoundOval.set((float) (((paintWidth / 2) + this.mSidePaintInterval) + ScreenUtil.getInstance().dip2px(1)), (float) ((paintWidth / 2) + this.mSidePaintInterval), (float) (((w - (paintWidth / 2)) - this.mSidePaintInterval) - ScreenUtil.getInstance().dip2px(1)), (float) (((h - (paintWidth / 2)) - this.mSidePaintInterval) - ScreenUtil.getInstance().dip2px(2)));
                LogUtil.m15791e("wangyang", "autoFix " + (((paintWidth / 2) + this.mSidePaintInterval) + ScreenUtil.getInstance().dip2px(1)) + " ; " + ((paintWidth / 2) + this.mSidePaintInterval) + "," + (((w - (paintWidth / 2)) - this.mSidePaintInterval) - ScreenUtil.getInstance().dip2px(1)) + " ; " + (((h - (paintWidth / 2)) - this.mSidePaintInterval) - ScreenUtil.getInstance().dip2px(2)));
                return;
            }
            int sl = CircleProgressImageView.this.getPaddingLeft();
            int sr = CircleProgressImageView.this.getPaddingRight();
            int st = CircleProgressImageView.this.getPaddingTop();
            int sb = CircleProgressImageView.this.getPaddingBottom();
            this.mRoundOval.set((float) ((paintWidth / 2) + sl), (float) ((paintWidth / 2) + st), (float) ((w - sr) - (paintWidth / 2)), (float) ((h - sb) - (paintWidth / 2)));
            LogUtil.m15791e("wangyang", "autoFix " + ((paintWidth / 2) + sl) + " ; " + ((paintWidth / 2) + st) + "," + ((w - sr) - (paintWidth / 2)) + " ; " + ((h - sb) - (paintWidth / 2)));
        }
    }

    public CircleProgressImageView(Context context) {
        super(context);
        defaultParam();
    }

    public CircleProgressImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        defaultParam();
        TypedArray array = context.obtainStyledAttributes(attrs, C4048R.styleable.CircleProgressImageView);
        this.mMaxProgress = array.getInteger(0, 100);
        boolean bFill = array.getBoolean(1, true);
        int paintWidth = (int) array.getDimension(2, 10.0f);
        this.mCircleAttribute.setFill(bFill);
        this.mSubProgressColor = array.getInteger(7, 0);
        this.mCircleAttribute.mSubPaint.setColor(this.mSubProgressColor);
        this.mBackgroundColor = array.getInteger(8, 0);
        if (this.mBackgroundColor != 0) {
            this.mCircleAttribute.setBackgroundColor(this.mBackgroundColor);
        }
        this.mIsBackgroundFill = array.getBoolean(9, bFill);
        if (this.mIsBackgroundFill) {
            this.mCircleAttribute.mBottomPaint.setStyle(Style.FILL);
        } else {
            this.mCircleAttribute.mBottomPaint.setStyle(Style.STROKE);
        }
        if (!bFill) {
            this.mCircleAttribute.setPaintWidth(paintWidth);
        }
        this.mCircleAttribute.setProgressPaintWidth((int) array.getDimension(6, 10.0f));
        this.mCircleAttribute.setPaintColor(array.getColor(3, 0));
        this.mCircleAttribute.mSidePaintInterval = (int) array.getDimension(4, 0.0f);
        this.mCircleAttribute.setTextColor(array.getColor(5, -16777216));
        this.mIsMainCapRound = array.getBoolean(10, false);
        if (this.mIsMainCapRound) {
            this.mCircleAttribute.mMainPaints.setStrokeCap(Cap.ROUND);
        }
        array.recycle();
    }

    private void defaultParam() {
        this.mCircleAttribute = new CircleAttribute();
        this.mMaxProgress = 100;
        this.mMainCurProgress = 0;
        this.mSubCurProgress = 0;
        this.mText = "";
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        this.mBackgroundPicture = getBackground();
        if (this.mBackgroundPicture != null) {
            width = this.mBackgroundPicture.getMinimumWidth();
            height = this.mBackgroundPicture.getMinimumHeight();
        }
        setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec));
        LogUtil.m15791e("wangyang", "CircleProgressImageView onMeasure  mode =" + MeasureSpec.getMode(heightMeasureSpec) + " widthMeasureSpec=" + widthMeasureSpec + " heightMeasureSpec=" + heightMeasureSpec + " width=" + width + " height=" + height + "resolvewidthSize= " + resolveSize(width, widthMeasureSpec) + "resolveHeightSize= " + resolveSize(height, heightMeasureSpec));
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mCircleAttribute.autoFix(w, h);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float subSweep = 360.0f * (((float) this.mSubCurProgress) / ((float) this.mMaxProgress));
        canvas.drawArc(this.mCircleAttribute.mRoundOval, (float) this.mCircleAttribute.mDrawPos, subSweep, this.mCircleAttribute.mBRoundPaintsFill, this.mCircleAttribute.mSubPaint);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.mCircleAttribute.mRoundOval, (float) this.mCircleAttribute.mDrawPos, 360.0f * (((float) this.mMainCurProgress) / ((float) this.mMaxProgress)), this.mCircleAttribute.mBRoundPaintsFill, this.mCircleAttribute.mMainPaints);
        drawText(canvas);
        LogUtil.m15791e("wangyang", "CircleProgressImageView onDraw ");
    }

    private int determineMaxTextSize(String str, float maxWidth) {
        int size = 0;
        do {
            size++;
            this.mCircleAttribute.mTextPaint.setTextSize((float) size);
        } while (this.mCircleAttribute.mTextPaint.measureText(str) < maxWidth);
        return size;
    }

    private void drawText(Canvas canvas) {
        if (!TextUtils.isEmpty(this.mText)) {
            if (this.mCircleAttribute.mBeamHeight != 0) {
                this.mCircleAttribute.mBeamHeight = getHeight() / 3;
            }
            Rect textRect = new Rect();
            this.mCircleAttribute.mTextPaint.getTextBounds(this.mText, 0, this.mText.length() - 1, textRect);
            canvas.drawText(this.mText, (float) ((int) (((double) getWidth()) * 0.5d)), (float) ((int) (((double) ((getHeight() + Math.abs(textRect.bottom - textRect.top)) + this.mCircleAttribute.mBeamHeight)) * 0.5d)), this.mCircleAttribute.mTextPaint);
        }
    }

    public void setText(String text) {
        if (text != null) {
            if (this.mText == null || !this.mText.equals(text)) {
                this.mText = text;
                invalidate();
            }
        }
    }

    public String getText() {
        return this.mText;
    }

    public void setBeamHeight(int beamHeight) {
        this.mCircleAttribute.mBeamHeight = beamHeight;
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int resId) {
        super.setImageDrawable(JarUtils.getResources().getDrawable(resId));
    }

    public synchronized void setMainProgress(int progress) {
        if (this.mMainCurProgress != progress) {
            this.mMainCurProgress = progress;
            if (this.mMainCurProgress < 0) {
                this.mMainCurProgress = 0;
            }
            if (this.mMainCurProgress > this.mMaxProgress) {
                this.mMainCurProgress = this.mMaxProgress;
            }
            invalidate();
        }
    }

    public synchronized int getMainProgress() {
        return this.mMainCurProgress;
    }

    public synchronized void setSubProgress(int progress) {
        if (this.mSubCurProgress != progress) {
            this.mSubCurProgress = progress;
            if (this.mSubCurProgress < 0) {
                this.mSubCurProgress = 0;
            }
            if (this.mSubCurProgress > this.mMaxProgress) {
                this.mSubCurProgress = this.mMaxProgress;
            }
            invalidate();
        }
    }

    public synchronized int getSubProgress() {
        return this.mSubCurProgress;
    }

    public void startCartoom(int time) {
    }

    public void stopCartoom() {
    }
}
