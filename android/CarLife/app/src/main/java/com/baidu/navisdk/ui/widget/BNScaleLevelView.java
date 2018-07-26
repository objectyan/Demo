package com.baidu.navisdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class BNScaleLevelView {
    private View mAppNameIV = null;
    private Context mContext;
    private TextView mScaleIndicator = null;
    private TextView mScaleTitle = null;
    private boolean visibility;

    public void initView(Context context, View view) {
        if (view != null && context != null) {
            this.mContext = context;
            this.mScaleTitle = (TextView) view.findViewById(C4048R.id.scale_title);
            this.mScaleIndicator = (TextView) view.findViewById(C4048R.id.scale_indicator);
            this.mAppNameIV = view.findViewById(C4048R.id.app_name);
            if (this.mAppNameIV != null) {
                this.mAppNameIV.setVisibility(8);
            }
        }
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
        if (this.mScaleTitle != null) {
            this.mScaleTitle.setTextColor(isDay ? -13223362 : -1052432);
        }
        if (this.mScaleIndicator != null) {
            this.mScaleIndicator.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_scale_indicator));
        }
    }
}
