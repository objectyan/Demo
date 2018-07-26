package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNMapTitleBar extends FrameLayout {
    protected static final int MAP_TITLE_TEXT_COLOR = -16777216;
    protected View mLayout;
    protected ImageView mLeftImageView;
    protected TextView mMiddleTextView;
    protected ImageView mRightImageView;

    public BNMapTitleBar(Context context) {
        super(context);
    }

    public BNMapTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mLayout = (RelativeLayout) JarUtils.inflate((Activity) context, C4048R.layout.nsdk_com_map_title_bar, null);
        addView(this.mLayout);
        initView(context);
    }

    private void initView(Context context) {
        this.mRightImageView = (ImageView) this.mLayout.findViewById(C4048R.id.right_imageview);
        this.mLeftImageView = (ImageView) this.mLayout.findViewById(C4048R.id.left_imageview);
        this.mMiddleTextView = (TextView) this.mLayout.findViewById(C4048R.id.middle_text);
    }

    public void setLeftButtonBackground(Drawable d) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setBackgroundDrawable(d);
        }
    }

    public void setLeftButtonVisible(boolean visible) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setVisibility(visible ? 0 : 8);
        }
    }

    public void setRightButtonBackground(Drawable d) {
        if (this.mRightImageView != null) {
            this.mRightImageView.setBackgroundDrawable(d);
            this.mRightImageView.setVisibility(0);
        }
    }

    public void setRightButtonVisible(boolean visible) {
        if (this.mRightImageView != null) {
            this.mRightImageView.setVisibility(visible ? 0 : 8);
        }
    }

    public void setMiddleText(String text) {
        if (this.mMiddleTextView != null) {
            this.mMiddleTextView.setText(text);
        }
    }

    public void setMiddleText(int resId) {
        setMiddleText(BNStyleManager.getString(resId));
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

    public void onUpdateStyle(boolean dayStyle) {
    }

    public void setLeftOnClickedListener(OnClickListener listener) {
        if (this.mLeftImageView != null) {
            this.mLeftImageView.setOnClickListener(listener);
        }
    }

    public void setRightOnClickedListener(OnClickListener listener) {
        if (this.mRightImageView != null) {
            this.mRightImageView.setOnClickListener(listener);
            this.mRightImageView.setVisibility(0);
        }
    }
}
