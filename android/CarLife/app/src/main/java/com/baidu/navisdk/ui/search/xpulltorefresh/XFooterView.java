package com.baidu.navisdk.ui.search.xpulltorefresh;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class XFooterView extends LinearLayout {
    private static final int ROTATE_ANIM_DURATION = 180;
    public static final int STATE_LOADING = 2;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_READY = 1;
    private TextView mHintView;
    private Animation mRotateDownAnim;
    private Animation mRotateUpAnim;
    private int mState = 0;
    private ViewGroup mViewGroup;

    public XFooterView(Context context) {
        super(context);
        initView((Activity) context);
    }

    public XFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView((Activity) context);
    }

    private void initView(Activity mActivity) {
        this.mViewGroup = (ViewGroup) JarUtils.inflate(mActivity, C4048R.layout.layout_xpulltorrefresh_footer, null);
        this.mViewGroup.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.mViewGroup);
        this.mHintView = (TextView) this.mViewGroup.findViewById(C4048R.id.footer_hint_text);
        this.mRotateUpAnim = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim.setDuration(180);
        this.mRotateUpAnim.setFillAfter(true);
        this.mRotateDownAnim = new RotateAnimation(180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim.setDuration(180);
        this.mRotateDownAnim.setFillAfter(true);
    }

    public void setState(int state) {
        if (state != this.mState) {
            if (state == 2) {
                this.mHintView.setVisibility(4);
            } else {
                this.mHintView.setVisibility(0);
            }
            switch (state) {
                case 0:
                    this.mHintView.setText(BNStyleManager.getString(C4048R.string.footer_hint_load_normal));
                    break;
                case 1:
                    if (this.mState != 1) {
                        this.mHintView.setText(BNStyleManager.getString(C4048R.string.footer_hint_load_ready));
                        break;
                    }
                    break;
            }
            this.mState = state;
        }
    }

    public void setBottomMargin(int margin) {
        if (margin >= 0) {
            LayoutParams lp = (LayoutParams) this.mViewGroup.getLayoutParams();
            lp.bottomMargin = margin;
            this.mViewGroup.setLayoutParams(lp);
        }
    }

    public int getBottomMargin() {
        return ((LayoutParams) this.mViewGroup.getLayoutParams()).bottomMargin;
    }

    public void normal() {
        this.mHintView.setVisibility(0);
    }

    public void loading() {
        this.mHintView.setVisibility(8);
    }

    public void hide() {
        LayoutParams lp = (LayoutParams) this.mViewGroup.getLayoutParams();
        lp.height = 0;
        this.mViewGroup.setLayoutParams(lp);
    }

    public void show() {
        LayoutParams lp = (LayoutParams) this.mViewGroup.getLayoutParams();
        lp.height = -2;
        this.mViewGroup.setLayoutParams(lp);
    }

    public void setTextColor(int color) {
        if (this.mHintView != null) {
            this.mHintView.setTextColor(color);
        }
    }

    public void setText(int resid) {
        if (this.mHintView != null) {
            this.mHintView.setText(resid);
        }
    }
}
