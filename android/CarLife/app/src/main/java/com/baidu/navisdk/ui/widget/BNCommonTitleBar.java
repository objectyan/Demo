package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNCommonTitleBar extends FrameLayout {
    protected static final int DEFAULT_TITLE_HEIGHT = 60;
    protected static final int DEFAULT_TITLE_TEXT_COLOR = 16777215;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 20;
    protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
    private boolean hasSetLeftContentFromOutSide;
    private boolean hasSetMiddleContentFromOutSide;
    private boolean hasSetRightContentFromOutSide;
    private boolean isMapMode = true;
    protected FrameLayout mLayout;
    protected Button mLeftButton;
    protected FrameLayout mLeftContent;
    protected ImageView mLeftImageView;
    private OnClickListener mLeftListener;
    protected FrameLayout mMiddleContent;
    private OnClickListener mMiddleListern;
    protected TextView mMiddleTextView;
    protected RelativeLayout mReLayout;
    protected Button mRightButton;
    protected FrameLayout mRightContent;
    protected ImageView mRightImageView;
    private OnClickListener mRightListner;
    protected View mTitleBarDivideLine;

    public BNCommonTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public BNCommonTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttr(context, attrs);
    }

    protected void initView(Context context) {
        if (this.isMapMode) {
            this.mLayout = (FrameLayout) JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_com_title_bar, this);
        } else {
            this.mLayout = (FrameLayout) JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_carmode_com_title_bar, this);
        }
        this.mReLayout = (RelativeLayout) this.mLayout.findViewById(C4048R.id.top_layout);
        this.mLeftImageView = (ImageView) this.mLayout.findViewById(C4048R.id.left_imageview);
        this.mLeftButton = (Button) this.mLayout.findViewById(C4048R.id.left_button);
        this.mRightImageView = (ImageView) this.mLayout.findViewById(C4048R.id.right_imageview);
        this.mRightButton = (Button) this.mLayout.findViewById(C4048R.id.right_button);
        this.mMiddleContent = (FrameLayout) this.mLayout.findViewById(C4048R.id.middle_content);
        this.mRightContent = (FrameLayout) this.mLayout.findViewById(C4048R.id.right_content);
        this.mLeftContent = (FrameLayout) this.mLayout.findViewById(C4048R.id.left_content);
        this.mTitleBarDivideLine = this.mLayout.findViewById(C4048R.id.title_bar_divide_line);
        this.mLeftButton.setVisibility(8);
        this.mMiddleTextView = (TextView) this.mLayout.findViewById(C4048R.id.middle_text);
        this.mMiddleTextView.setTextColor(JarUtils.getResources().getColor(this.isMapMode ? C4048R.color.bnav_titlebar_middle_text : C4048R.color.nsdk_carmode_titlebar_text_bg));
    }

    protected void initAttr(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, C4048R.styleable.CommonTitleBar);
            Drawable d = typedArray.getDrawable(0);
            if (d != null) {
                if (VERSION.SDK_INT >= 16) {
                    this.mReLayout.setBackground(d);
                } else {
                    this.mReLayout.setBackgroundDrawable(d);
                }
            }
            boolean rightContentVisible = true;
            if (typedArray.peekValue(6) != null) {
                rightContentVisible = typedArray.getBoolean(6, true);
            }
            if (rightContentVisible) {
                this.mRightContent.setVisibility(0);
            } else {
                this.mRightContent.setVisibility(4);
            }
            this.mMiddleTextView.setText(typedArray.getString(5));
            d = typedArray.getDrawable(1);
            if (d != null) {
                this.mRightImageView.setImageDrawable(d);
                this.mRightImageView.setVisibility(0);
            } else {
                this.mRightImageView.setVisibility(8);
            }
            String rightText = typedArray.getString(2);
            if (!TextUtils.isEmpty(rightText)) {
                this.mRightButton.setText(rightText);
                this.mRightButton.setVisibility(0);
            } else if (this.mRightImageView.getVisibility() == 0) {
                this.mRightButton.setVisibility(8);
            } else {
                this.mRightButton.setVisibility(4);
            }
            d = typedArray.getDrawable(4);
            if (d != null) {
                this.mLeftImageView.setImageDrawable(d);
                this.mLeftImageView.setVisibility(0);
            }
            String leftText = typedArray.getString(3);
            if (TextUtils.isEmpty(leftText)) {
                this.mLeftButton.setVisibility(8);
            } else {
                this.mLeftButton.setText(leftText);
                this.mLeftButton.setVisibility(0);
                this.mLeftImageView.setVisibility(8);
            }
            typedArray.recycle();
        }
    }

    public void setTitleBarBackgroundColor(int color) {
        this.mReLayout.setBackgroundColor(color);
    }

    public void setTitleBarBackground(Drawable drawable) {
        this.mReLayout.setBackgroundDrawable(drawable);
    }

    public void setLeftOnClickedListener(OnClickListener listener) {
        this.mLeftListener = listener;
        if (this.hasSetLeftContentFromOutSide) {
            this.mLeftContent.setClickable(true);
            this.mLeftContent.setOnClickListener(listener);
            return;
        }
        this.mLeftContent.setClickable(false);
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setOnClickListener(listener);
        }
        if (this.mLeftButton != null) {
            this.mLeftButton.setOnClickListener(listener);
        }
    }

    public void setRightOnClickedListener(OnClickListener listener) {
        this.mRightListner = listener;
        if (this.hasSetRightContentFromOutSide) {
            this.mRightContent.setClickable(true);
            this.mRightContent.setOnClickListener(listener);
            return;
        }
        this.mRightContent.setClickable(false);
        if (this.mRightImageView != null) {
            this.mRightImageView.setOnClickListener(listener);
        }
        if (this.mRightButton != null) {
            this.mRightButton.setOnClickListener(listener);
        }
    }

    public void setMiddleOnClickedListener(OnClickListener listener) {
        this.mMiddleContent.setOnClickListener(listener);
        this.mMiddleContent.setClickable(true);
    }

    public void setLeftTextBackground(Drawable d) {
        if (this.mLeftButton != null) {
            this.mLeftButton.setBackgroundDrawable(d);
            this.mLeftButton.setVisibility(0);
        }
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setVisibility(8);
        }
    }

    public void setLeftTextColor(int color) {
        if (this.mLeftButton != null) {
            this.mLeftButton.setTextColor(color);
            this.mLeftButton.setVisibility(0);
        }
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setVisibility(4);
        }
    }

    public void setLeftText(String text) {
        int padding = ScreenUtil.getInstance().dip2px(8);
        if (this.mLeftButton != null) {
            this.mLeftButton.setText(text);
            this.mLeftButton.setPadding(padding, 0, padding, 0);
            this.mLeftButton.setVisibility(0);
            this.mLeftContent.setVisibility(0);
        }
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setVisibility(8);
        }
    }

    public void setLeftText(int resId) {
        setLeftText(BNStyleManager.getString(resId));
    }

    public void setLeftIconBackGround(Drawable d) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setBackgroundDrawable(d);
            this.mLeftImageView.setVisibility(0);
        }
        if (this.mLeftButton != null) {
            this.mLeftButton.setVisibility(8);
        }
    }

    public void setLeftIconAlpha(float f) {
        if (this.mLeftImageView != null) {
            try {
                this.mLeftImageView.setAlpha(f);
            } catch (Exception e) {
            }
        }
    }

    public void setLeftTextVisible(boolean visible) {
        if (this.mLeftButton != null) {
            this.mLeftButton.setVisibility(visible ? 0 : 4);
        }
    }

    public void setLeftIconVisible(boolean visible) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setVisibility(visible ? 0 : 4);
        }
    }

    public void setRightTextVisible(boolean visible) {
        if (this.mRightButton != null) {
            this.mRightButton.setVisibility(visible ? 0 : 4);
        }
    }

    public void setRightIconVisible(boolean visible) {
        if (this.mRightImageView != null) {
            this.mRightImageView.setVisibility(visible ? 0 : 4);
        }
    }

    public void setLeftIcon(Drawable d) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setImageDrawable(d);
            this.mLeftImageView.setVisibility(0);
        }
        if (this.mLeftButton != null) {
            this.mLeftButton.setVisibility(4);
        }
    }

    public void setRightTextBackground(Drawable d) {
        if (this.mRightButton != null) {
            this.mRightButton.setBackgroundDrawable(d);
            this.mRightButton.setVisibility(0);
        }
        if (this.mRightImageView != null) {
            this.mRightImageView.setVisibility(4);
        }
    }

    public void setRightTextColor(int color) {
        if (this.mRightButton != null) {
            this.mRightButton.setTextColor(color);
            this.mRightButton.setVisibility(0);
        }
        if (this.mRightImageView != null) {
            this.mRightImageView.setVisibility(4);
        }
    }

    public void setRightText(String text) {
        if (this.mRightButton != null) {
            this.mRightButton.setText(text);
            this.mRightButton.setVisibility(0);
        }
        if (this.mRightImageView != null) {
            this.mRightImageView.setVisibility(4);
        }
    }

    public void setRightText(int resId) {
        setRightText(BNStyleManager.getString(resId));
    }

    public void setRightIconBackGround(Drawable d) {
        if (this.mRightImageView != null) {
            this.mRightImageView.setBackgroundDrawable(d);
            this.mRightImageView.setVisibility(0);
        }
        if (this.mRightButton != null) {
            this.mRightButton.setVisibility(4);
        }
    }

    public void setRightIcon(Drawable d) {
        if (this.mRightImageView != null) {
            this.mRightImageView.setImageDrawable(d);
            this.mRightImageView.setVisibility(0);
        }
        if (this.mRightButton != null) {
            this.mRightButton.setVisibility(4);
        }
    }

    public void setRightEnabled(boolean enabled) {
        if (this.mRightButton != null) {
            this.mRightButton.setEnabled(enabled);
        }
        if (this.mRightImageView != null) {
            this.mRightImageView.setEnabled(enabled);
        }
    }

    public void setLeftEnabled(boolean enabled) {
        if (this.mLeftButton != null) {
            this.mLeftButton.setEnabled(enabled);
        }
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setEnabled(enabled);
        }
    }

    public void setRightContent(View view) {
        if (this.mRightContent != null) {
            this.mRightContent.removeAllViews();
            this.mRightContent.addView(view, new LayoutParams(-1, -1));
            this.mRightContent.setOnClickListener(this.mRightListner);
            this.mRightContent.setClickable(true);
        }
        this.hasSetRightContentFromOutSide = true;
    }

    public void setLeftContent(View view) {
        if (this.mLeftContent != null) {
            this.mLeftContent.removeAllViews();
            this.mLeftContent.addView(view, new LayoutParams(-1, -1));
            this.mLeftContent.setOnClickListener(this.mLeftListener);
            this.mLeftContent.setClickable(true);
        }
        this.hasSetRightContentFromOutSide = true;
    }

    public void setMiddleContent(View view) {
        if (this.mMiddleContent != null) {
            this.mMiddleContent.removeAllViews();
            this.mMiddleContent.addView(view, new LayoutParams(-1, -1));
        }
        this.hasSetMiddleContentFromOutSide = true;
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setVisibility(4);
        }
    }

    public void setMiddleText(int resId) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setText(resId);
        }
    }

    public void setMiddleText(CharSequence text) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setText(text);
        }
    }

    public void setMiddleContenVisible(boolean isVisible) {
        this.mMiddleContent.setVisibility(isVisible ? 0 : 4);
    }

    public void setRightContenVisible(boolean isVisible) {
        this.mRightContent.setVisibility(isVisible ? 0 : 4);
    }

    public void setLeftContenVisible(boolean isVisible) {
        this.mLeftContent.setVisibility(isVisible ? 0 : 4);
    }

    public View getLeftContent() {
        return this.mLeftImageView;
    }

    public View getMiddleContent() {
        return this.mMiddleContent;
    }

    public View getRightContent() {
        return this.mRightContent;
    }

    public void setLeftContentBackgroud(Drawable d) {
        this.mLeftContent.setBackgroundDrawable(d);
    }

    public void setRightContentBackgroud(Drawable d) {
        this.mRightContent.setBackgroundDrawable(d);
    }

    public void setMiddleContentBackgroud(Drawable d) {
        this.mMiddleContent.setBackgroundDrawable(d);
    }

    public void setTitleBarDivideLineBackgroudColor(int color) {
        this.mTitleBarDivideLine.setBackgroundColor(color);
    }

    public void setLeftContentClickable(boolean clickable) {
        this.mLeftContent.setClickable(clickable);
    }

    public void setRightContentClickable(boolean clickable) {
        this.mRightContent.setClickable(clickable);
    }

    public void setMiddleContentClickable(boolean clickable) {
        this.mMiddleContent.setClickable(clickable);
    }

    public void setMiddleTextColor(int color) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setTextColor(color);
        }
    }

    public void setMiddleTextSize(float size) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setTextSize(size);
        }
    }

    public void setMiddleTextVisible(boolean visible) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setVisibility(visible ? 0 : 8);
        }
    }

    public void setLeftImageViewSrc(Drawable src) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setImageDrawable(src);
        }
    }

    public void updateStyle() {
        if (this.isMapMode) {
            if (this.mLeftImageView != null) {
                this.mLeftImageView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_btn_transparent_bg_selector));
                this.mLeftImageView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_ic_back_normal));
            }
            if (this.mLeftButton != null) {
                this.mLeftButton.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_btn_bg_selector));
            }
            this.mReLayout.setBackgroundColor(BNStyleManager.getColor(C4048R.color.bnav_titlebar_bg));
            if (this.mRightImageView != null) {
                this.mRightImageView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_btn_transparent_bg_selector));
            }
            if (this.mRightButton != null) {
                this.mRightButton.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_btn_bg_selector));
            }
            if (this.mMiddleTextView != null) {
                this.mMiddleTextView.setTextColor(BNStyleManager.getColor(C4048R.color.bnav_titlebar_middle_text));
            }
        }
    }
}
