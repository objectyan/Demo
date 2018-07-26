package com.baidu.navi.view.xpulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.platform.comapi.util.C4820d;

public class XFooterView extends LinearLayout {
    public static final int STATE_LOADING = 2;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_READY = 1;
    private final int ROTATE_ANIM_DURATION = C4820d.f19955a;
    private TextView mHintView;
    private View mLayout;
    private Animation mRotateDownAnim;
    private Animation mRotateUpAnim;
    private int mState = 0;

    public XFooterView(Context context) {
        super(context);
        initView(context);
    }

    public XFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.mLayout = LayoutInflater.from(context).inflate(C0965R.layout.layout_xpulltorrefresh_footer, null);
        this.mLayout.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.mLayout);
        this.mHintView = (TextView) this.mLayout.findViewById(C0965R.id.footer_hint_text);
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
                    this.mHintView.setText(C0965R.string.footer_hint_load_normal);
                    break;
                case 1:
                    if (this.mState != 1) {
                        this.mHintView.setText(C0965R.string.footer_hint_load_ready);
                        break;
                    }
                    break;
            }
            this.mState = state;
        }
    }

    public void setBottomMargin(int margin) {
        if (margin >= 0) {
            LayoutParams lp = (LayoutParams) this.mLayout.getLayoutParams();
            lp.bottomMargin = margin;
            this.mLayout.setLayoutParams(lp);
        }
    }

    public int getBottomMargin() {
        return ((LayoutParams) this.mLayout.getLayoutParams()).bottomMargin;
    }

    public void normal() {
        this.mHintView.setVisibility(0);
    }

    public void loading() {
        this.mHintView.setVisibility(8);
    }

    public void hide() {
        LayoutParams lp = (LayoutParams) this.mLayout.getLayoutParams();
        lp.height = 0;
        this.mLayout.setLayoutParams(lp);
    }

    public void show() {
        LayoutParams lp = (LayoutParams) this.mLayout.getLayoutParams();
        lp.height = -2;
        this.mLayout.setLayoutParams(lp);
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
