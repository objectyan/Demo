package com.baidu.navisdk.ui.widget;

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
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.subview.widget.FrameAnimationController;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class SwitchButton extends CheckBox {
    private static final float EXTENDED_OFFSET_Y = 15.0f;
    private static final int MAX_ALPHA = 255;
    private static final float VELOCITY = 350.0f;
    private int mAlpha;
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private float mAnimationPosition;
    private Bitmap mBottom;
    private boolean mBroadcasting;
    private Bitmap mBtnNormal;
    private float mBtnOffPos;
    private float mBtnOnPos;
    private float mBtnPos;
    private Bitmap mBtnPressed;
    private float mBtnWidth;
    private boolean mChecked;
    private int mClickTimeout;
    private Context mContext;
    private Bitmap mCurBtnPic;
    private boolean mDayStyle;
    private float mExtendOffsetY;
    private float mFirstDownX;
    private float mFirstDownY;
    private Bitmap mFrame;
    private Bitmap mMask;
    private float mMaskHeight;
    private float mMaskWidth;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;
    private Paint mPaint;
    private ViewParent mParent;
    private float mRealPos;
    private RectF mSaveLayerRectF;
    private int mTouchSlop;
    private float mVelocity;
    private PorterDuffXfermode mXfermode;

    private final class PerformClick implements Runnable {
        private PerformClick() {
        }

        public void run() {
            SwitchButton.this.performClick();
        }
    }

    private final class SwitchAnimation implements Runnable {
        private SwitchAnimation() {
        }

        public void run() {
            if (SwitchButton.this.mAnimating) {
                SwitchButton.this.doAnimation();
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
        this.mAlpha = 255;
        this.mChecked = false;
        this.mDayStyle = true;
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        Resources resources = JarUtils.getResources();
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        if (this.mDayStyle) {
            this.mBottom = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_switch_bottom);
            if (this.mChecked) {
                this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_pressed);
                this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_normal);
            } else {
                this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_pressed);
                this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_normal);
            }
            this.mFrame = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_switch_frame);
            this.mMask = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_switch_mask);
        } else {
            this.mBottom = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_switch_bottom_night);
            if (this.mChecked) {
                this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_pressed_night);
                this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_normal_night);
            } else {
                this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_pressed_night);
                this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_normal_night);
            }
            this.mFrame = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_switch_frame_night);
            this.mMask = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_switch_mask_night);
        }
        this.mCurBtnPic = this.mBtnNormal;
        this.mBtnWidth = (float) this.mBtnPressed.getWidth();
        this.mMaskWidth = (float) this.mMask.getWidth();
        this.mMaskHeight = (float) this.mMask.getHeight();
        this.mBtnOffPos = this.mBtnWidth / 2.0f;
        this.mBtnOnPos = this.mMaskWidth - (this.mBtnWidth / 2.0f);
        this.mBtnPos = this.mChecked ? this.mBtnOnPos : this.mBtnOffPos;
        this.mRealPos = getRealPos(this.mBtnPos);
        this.mVelocity = (float) ScreenUtil.getInstance().dip2px(VELOCITY);
        this.mExtendOffsetY = (float) ScreenUtil.getInstance().dip2px(EXTENDED_OFFSET_Y);
        this.mSaveLayerRectF = new RectF(0.0f, this.mExtendOffsetY, (float) this.mMask.getWidth(), ((float) this.mMask.getHeight()) + this.mExtendOffsetY);
        this.mXfermode = new PorterDuffXfermode(Mode.SRC_IN);
    }

    public void setEnabled(boolean enabled) {
        this.mAlpha = enabled ? 255 : TransportMediator.KEYCODE_MEDIA_PAUSE;
        super.setEnabled(enabled);
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void toggle() {
        setInternalChecked(!this.mChecked);
    }

    private void setCheckedDelayed(final boolean checked) {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("setCheckedDelayed-" + getClass().getSimpleName(), null) {
            protected String execute() {
                SwitchButton.this.setInternalChecked(checked);
                return null;
            }
        }, new BNWorkerConfig(100, 0), 10);
    }

    public void setChecked(boolean checked) {
        setInternalChecked(!checked);
    }

    private void setInternalChecked(boolean checked) {
        this.mChecked = checked;
        this.mBtnPos = checked ? this.mBtnOnPos : this.mBtnOffPos;
        this.mRealPos = getRealPos(this.mBtnPos);
        invalidate();
        if (!this.mBroadcasting) {
            this.mBroadcasting = true;
            Resources resources = JarUtils.getResources();
            if (this.mDayStyle) {
                if (this.mChecked) {
                    this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_pressed);
                    this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_normal);
                    this.mCurBtnPic = this.mBtnNormal;
                } else {
                    this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_pressed);
                    this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_normal);
                    this.mCurBtnPic = this.mBtnNormal;
                }
            } else if (this.mChecked) {
                this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_pressed_night);
                this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_off_normal_night);
                this.mCurBtnPic = this.mBtnNormal;
            } else {
                this.mBtnPressed = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_pressed_night);
                this.mBtnNormal = BitmapFactory.decodeResource(resources, C4048R.drawable.nsdk_drawable_rg_btn_switch_on_normal_night);
                this.mCurBtnPic = this.mBtnNormal;
            }
            invalidate();
            if (this.mOnCheckedChangeListener != null) {
                boolean z;
                OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
                if (this.mChecked) {
                    z = false;
                } else {
                    z = true;
                }
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
            if (this.mOnCheckedChangeWidgetListener != null) {
                this.mOnCheckedChangeWidgetListener.onCheckedChanged(this, this.mChecked);
            }
            this.mBroadcasting = false;
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeWidgetListener = listener;
    }

    public boolean performClick() {
        startAnimation(!this.mChecked);
        return true;
    }

    private void attemptClaimDrag() {
        this.mParent = getParent();
        if (this.mParent != null) {
            this.mParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private float getRealPos(float btnPos) {
        return btnPos - (this.mBtnWidth / 2.0f);
    }

    protected void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(this.mSaveLayerRectF, this.mAlpha, 31);
        canvas.drawBitmap(this.mMask, 0.0f, this.mExtendOffsetY, this.mPaint);
        this.mPaint.setXfermode(this.mXfermode);
        if (this.mChecked) {
            canvas.drawBitmap(this.mBottom, this.mRealPos - 4.0f, this.mExtendOffsetY, this.mPaint);
        } else {
            canvas.drawBitmap(this.mBottom, this.mRealPos + 4.0f, this.mExtendOffsetY, this.mPaint);
        }
        this.mPaint.setXfermode(null);
        canvas.drawBitmap(this.mFrame, 0.0f, this.mExtendOffsetY, this.mPaint);
        if (this.mChecked) {
            canvas.drawBitmap(this.mCurBtnPic, this.mRealPos - 4.0f, this.mExtendOffsetY, this.mPaint);
        } else {
            canvas.drawBitmap(this.mCurBtnPic, this.mRealPos + 4.0f, this.mExtendOffsetY, this.mPaint);
        }
        canvas.restore();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) this.mMaskWidth, (int) (this.mMaskHeight + (2.0f * this.mExtendOffsetY)));
    }

    private void startAnimation(boolean turnOn) {
        this.mAnimating = true;
        this.mAnimatedVelocity = turnOn ? -this.mVelocity : this.mVelocity;
        this.mAnimationPosition = this.mBtnPos;
        new SwitchAnimation().run();
    }

    private void stopAnimation() {
        this.mAnimating = false;
    }

    private void doAnimation() {
        this.mAnimationPosition += (this.mAnimatedVelocity * 16.0f) / 1000.0f;
        if (this.mAnimationPosition <= this.mBtnOnPos - 8.0f) {
            stopAnimation();
            this.mAnimationPosition = this.mBtnOnPos - 8.0f;
            setCheckedDelayed(true);
        } else if (this.mAnimationPosition >= this.mBtnOffPos + 8.0f) {
            stopAnimation();
            this.mAnimationPosition = this.mBtnOffPos + 8.0f;
            setCheckedDelayed(false);
        }
        moveView(this.mAnimationPosition);
    }

    private void moveView(float position) {
        this.mBtnPos = position;
        this.mRealPos = getRealPos(this.mBtnPos);
        invalidate();
    }

    public void setDayStyle(boolean dayStyle) {
        this.mDayStyle = dayStyle;
        try {
            initView(this.mContext);
            invalidate();
        } catch (Exception e) {
        }
    }
}
