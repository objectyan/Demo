package com.baidu.navisdk.ui.routeguide.subview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGScaleLevelView {
    private Context mContext;
    private RelativeLayout mLayout = null;
    private TextView mScaleIndicator = null;
    private TextView mScaleTitle = null;

    public RGScaleLevelView(Context context, View view) {
        this.mContext = context;
        this.mLayout = (RelativeLayout) view.findViewById(C4048R.id.bnav_rg_map_scale_layout);
        this.mScaleTitle = (TextView) view.findViewById(C4048R.id.bnav_rg_scale_title);
        this.mScaleIndicator = (TextView) view.findViewById(C4048R.id.bnav_rg_scale_indicator);
    }

    public void update() {
        String txt;
        int scrWidht = NMapControlProxy.getInstance().getScreenWidth();
        int level = NMapControlProxy.getInstance().getZoomLevel();
        double u = NMapControlProxy.getInstance().getZoomUnitsInMeter();
        int dist = NMapControlProxy.getScaleDis(level);
        LogUtil.m15791e("Meter", "room updateScale dis=" + dist + " level=" + level + " u=" + u);
        int pxLen = (int) Math.ceil(((double) dist) / u);
        while (pxLen > scrWidht / 2 && level >= 3 && level <= 20) {
            level++;
            dist = NMapControlProxy.getScaleDis(level);
            pxLen = (int) Math.ceil(((double) dist) / u);
        }
        if (dist >= 1000) {
            txt = (dist / 1000) + JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_kilometer);
        } else {
            txt = dist + JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_meter);
        }
        this.mScaleTitle.setText(txt);
        this.mScaleIndicator.setWidth(pxLen);
    }

    public void show() {
        if (this.mLayout != null) {
            this.mLayout.setVisibility(0);
        }
    }

    public void hide() {
        if (this.mLayout != null) {
            this.mLayout.setVisibility(4);
        }
    }

    @SuppressLint({"NewApi"})
    public void onUpdateStyle(boolean isDay) {
        if (this.mScaleTitle != null) {
            this.mScaleTitle.setTextColor(isDay ? -13223362 : -1052432);
        }
        if (this.mScaleIndicator != null) {
            Drawable drawable;
            TextView textView = this.mScaleIndicator;
            if (isDay) {
                drawable = JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_scale_indicator);
            } else {
                drawable = JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_scale_indicator_night);
            }
            textView.setBackgroundDrawable(drawable);
        }
    }
}
