package com.baidu.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;

public class ScaleLevelView {
    private Context mContext;
    private boolean mIsForRouteDetails = false;
    private TextView mScaleIndicator = null;
    private TextView mScaleTitle = null;
    private boolean visibility;

    public void initView(Context context, View view) {
        if (view != null && context != null) {
            this.mContext = context;
            this.mScaleTitle = (TextView) view.findViewById(this.mIsForRouteDetails ? C4048R.id.scale_title : C0965R.id.scale_title);
            this.mScaleIndicator = (TextView) view.findViewById(this.mIsForRouteDetails ? C4048R.id.scale_indicator : C0965R.id.scale_indicator);
        }
    }

    public void initView(Context context, View view, boolean isForRouteDetails) {
        this.mIsForRouteDetails = isForRouteDetails;
        initView(context, view);
    }

    public void updateScaleView(String txt, int pxLen) {
        this.mScaleTitle.setText(txt);
        this.mScaleIndicator.setWidth(pxLen);
    }

    public void show() {
        if (this.mScaleTitle != null) {
            this.mScaleTitle.setVisibility(0);
        }
        if (this.mScaleIndicator != null) {
            this.mScaleIndicator.setVisibility(0);
        }
        this.visibility = true;
    }

    public void hide() {
        if (this.mScaleTitle.isShown()) {
            this.mScaleTitle.setVisibility(4);
        }
        if (this.mScaleIndicator.isShown()) {
            this.mScaleIndicator.setVisibility(4);
        }
        this.visibility = false;
    }

    @SuppressLint({"NewApi"})
    public void onUpdateStyle(boolean isDay) {
        int i = -13223362;
        LogUtil.m15791e("ScaleView", "update style:" + isDay);
        if (this.mIsForRouteDetails) {
            if (this.mScaleTitle != null) {
                TextView textView = this.mScaleTitle;
                if (!isDay) {
                    i = -1052432;
                }
                textView.setTextColor(i);
            }
            if (this.mScaleIndicator != null) {
                this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_ic_scale_indicator, isDay));
                return;
            }
            return;
        }
        if (this.mScaleTitle != null) {
            textView = this.mScaleTitle;
            if (!isDay) {
                i = -1052432;
            }
            textView.setTextColor(i);
        }
        if (this.mScaleIndicator != null) {
            this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_ic_scale_indicator, isDay));
        }
    }
}
