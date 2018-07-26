package com.baidu.navi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;

public class CommonTitleBar extends FrameLayout {
    protected static final int DEFAULT_TITLE_HEIGHT = 48;
    protected static final int DEFAULT_TITLE_TEXT_COLOR = 16777215;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 20;
    protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
    private boolean hasSetLeftContentFromOutSide;
    private boolean hasSetMiddleContentFromOutSide;
    private boolean hasSetRightContentFromOutSide;
    private boolean isMapMode = NaviFragmentManager.isUsingMapMode();
    protected RelativeLayout mLayout;
    protected Button mLeftButton;
    protected FrameLayout mLeftContent;
    protected ImageView mLeftImageView;
    private OnClickListener mLeftListener;
    protected FrameLayout mMiddleContent;
    private OnClickListener mMiddleListern;
    protected TextView mMiddleTextView;
    protected TextView mRightButton;
    protected FrameLayout mRightContent;
    protected ImageView mRightImageView;
    private OnClickListener mRightListner;

    public CommonTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public CommonTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttr(context, attrs);
    }

    protected void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (this.isMapMode) {
            this.mLayout = (RelativeLayout) inflater.inflate(C0965R.layout.com_title_bar, null);
        } else {
            this.mLayout = (RelativeLayout) inflater.inflate(C0965R.layout.carmode_com_title_bar, null);
        }
        addView(this.mLayout, new LayoutParams(-2, ScreenUtil.getInstance().dip2px(48)));
        this.mLeftImageView = (ImageView) this.mLayout.findViewById(C0965R.id.left_imageview);
        this.mLeftButton = (Button) this.mLayout.findViewById(C0965R.id.left_button);
        this.mRightImageView = (ImageView) this.mLayout.findViewById(C0965R.id.right_imageview);
        this.mRightButton = (TextView) this.mLayout.findViewById(C0965R.id.right_button);
        this.mMiddleContent = (FrameLayout) this.mLayout.findViewById(C0965R.id.middle_content);
        this.mRightContent = (FrameLayout) this.mLayout.findViewById(C0965R.id.right_content);
        this.mLeftContent = (FrameLayout) this.mLayout.findViewById(C0965R.id.left_content);
        this.mLeftButton.setVisibility(8);
        this.mMiddleTextView = (TextView) this.mLayout.findViewById(C0965R.id.middle_text);
        this.mMiddleTextView.setTextColor(StyleManager.getColor(this.isMapMode ? C0965R.color.bnav_titlebar_middle_text : C0965R.color.carmode_titlebar_text_bg));
    }

    protected void initAttr(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, C0965R.C0963p.CommonTitleBar);
            Drawable d = typedArray.getDrawable(0);
            if (d != null) {
                if (VERSION.SDK_INT >= 16) {
                    this.mLayout.setBackground(d);
                } else {
                    this.mLayout.setBackgroundDrawable(d);
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

    public Drawable getBackground() {
        return this.mLayout.getBackground();
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
        setLeftText(StyleManager.getString(resId));
    }

    public void setLeftTextColor(int color) {
        this.mLeftButton.setTextColor(color);
    }

    public void setLeftTextColorById(int resId) {
        this.mLeftButton.setTextColor(StyleManager.getColor(resId));
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
        setRightText(StyleManager.getString(resId));
    }

    public void setRightTextColor(int color) {
        if (this.mRightButton != null) {
            this.mRightButton.setTextColor(color);
        }
    }

    public void setRightIconBackGround(Drawable d) {
        if (this.mRightImageView != null) {
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
        this.mRightContent.removeAllViews();
        this.mRightContent.addView(view, new LayoutParams(-1, -1));
        this.mRightContent.setOnClickListener(this.mRightListner);
        this.mRightContent.setClickable(true);
        this.hasSetRightContentFromOutSide = true;
    }

    public void setLeftContent(View view) {
        this.mLeftContent.removeAllViews();
        this.mLeftContent.addView(view, new LayoutParams(-1, -1));
        this.mLeftContent.setOnClickListener(this.mLeftListener);
        this.mLeftContent.setClickable(true);
        this.hasSetRightContentFromOutSide = true;
    }

    public void setMiddleContent(View view) {
        this.mMiddleContent.setVisibility(0);
        this.mMiddleContent.removeAllViews();
        this.mMiddleContent.addView(view, new LayoutParams(-1, -1));
        this.hasSetMiddleContentFromOutSide = true;
        this.mMiddleTextView.setVisibility(4);
    }

    public void setMiddleText(int resId) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setText(resId);
            this.mMiddleTextView.setVisibility(0);
            this.mMiddleContent.setVisibility(8);
        }
    }

    public void setMiddleText(CharSequence text) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setText(text);
            this.mMiddleTextView.setVisibility(0);
            this.mMiddleContent.setVisibility(8);
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

    public void setMiddleTextVisible(boolean visible) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setVisibility(visible ? 0 : 8);
        }
    }

    public void updateStyle() {
        if (this.isMapMode) {
            if (this.mLeftImageView != null) {
                this.mLeftImageView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_titlebar_btn_transparent_bg_selector));
                this.mLeftImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_titlebar_ic_back_normal));
            }
            if (this.mLeftButton != null) {
                this.mLeftButton.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_titlebar_btn_bg_selector));
            }
            this.mLayout.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_titlebar_bg));
            if (NaviFragmentManager.isUsingMapMode() && this.mMiddleTextView != null) {
                this.mMiddleTextView.setTextColor(StyleManager.getColor(C0965R.color.bnav_titlebar_middle_text));
            }
        }
    }
}
