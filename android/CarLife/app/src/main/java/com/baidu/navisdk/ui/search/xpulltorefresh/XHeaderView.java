package com.baidu.navisdk.ui.search.xpulltorefresh;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class XHeaderView extends LinearLayout {
    private static final int ROTATE_ANIM_DURATION = 180;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_REFRESHING = 2;
    private ImageView mArrowImageView;
    private TextView mHintTextView;
    private boolean mIsFirst;
    private Animation mRotateDownAnim;
    private Animation mRotateUpAnim;
    private int mState = 0;
    private ViewGroup mViewGroup;

    public XHeaderView(Context context) {
        super(context);
        initView((Activity) context);
    }

    public XHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView((Activity) context);
    }

    private void initView(Activity mActivity) {
        LayoutParams lp = new LayoutParams(-1, 0);
        this.mViewGroup = (ViewGroup) JarUtils.inflate(mActivity, C4048R.layout.layout_xpulltorrefresh_header, null);
        addView(this.mViewGroup, lp);
        setGravity(80);
        this.mArrowImageView = (ImageView) findViewById(C4048R.id.header_arrow);
        this.mHintTextView = (TextView) findViewById(C4048R.id.header_hint_text);
        this.mRotateUpAnim = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim.setDuration(180);
        this.mRotateUpAnim.setFillAfter(true);
        this.mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim.setDuration(180);
        this.mRotateDownAnim.setFillAfter(true);
    }

    public void setState(int state) {
        if (state == this.mState && this.mIsFirst) {
            this.mIsFirst = true;
            return;
        }
        if (state == 2) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.setVisibility(4);
        } else {
            this.mArrowImageView.setVisibility(0);
        }
        switch (state) {
            case 0:
                if (this.mState == 1) {
                    this.mArrowImageView.startAnimation(this.mRotateDownAnim);
                }
                if (this.mState == 2) {
                    this.mArrowImageView.clearAnimation();
                }
                this.mHintTextView.setText(BNStyleManager.getString(C4048R.string.header_hint_refresh_normal));
                break;
            case 1:
                if (this.mState != 1) {
                    this.mArrowImageView.clearAnimation();
                    this.mArrowImageView.startAnimation(this.mRotateUpAnim);
                    this.mHintTextView.setText(BNStyleManager.getString(C4048R.string.header_hint_refresh_ready));
                    break;
                }
                break;
            case 2:
                this.mHintTextView.setText(BNStyleManager.getString(C4048R.string.header_hint_refresh_loading));
                break;
        }
        this.mState = state;
    }

    public void setVisibleHeight(int height) {
        if (height < 0) {
            height = 0;
        }
        LayoutParams lp = (LayoutParams) this.mViewGroup.getLayoutParams();
        lp.height = height;
        this.mViewGroup.setLayoutParams(lp);
    }

    public int getVisibleHeight() {
        return this.mViewGroup.getHeight();
    }

    public void setTextColor(int color) {
        if (this.mHintTextView != null) {
            this.mHintTextView.setTextColor(color);
        }
    }
}
