package com.baidu.navi.cruise.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.map.MapController;

public class CruiseScaleLevelView {
    private static final int MSG_AUTO_HIDE = 1;
    private Activity mActivity;
    private ImageView mAppNameIV = null;
    private Handler mAutoHandler = new C37671();
    private RelativeLayout mLayout = null;
    private TextView mScaleIndicator = null;
    private TextView mScaleTitle = null;

    /* renamed from: com.baidu.navi.cruise.view.CruiseScaleLevelView$1 */
    class C37671 extends Handler {
        C37671() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    CruiseScaleLevelView.this.mLayout.setVisibility(8);
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public CruiseScaleLevelView(Activity activity, View view) {
        this.mActivity = activity;
        this.mLayout = (RelativeLayout) view.findViewById(C0965R.id.bnav_cruise_map_scale_layout);
        this.mScaleTitle = (TextView) view.findViewById(C0965R.id.bnav_cruise_scale_title);
        this.mScaleIndicator = (TextView) view.findViewById(C0965R.id.bnav_cruise_scale_indicator);
        this.mAppNameIV = (ImageView) view.findViewById(C0965R.id.app_name);
        if (this.mAppNameIV != null) {
            this.mAppNameIV.setVisibility(8);
        }
    }

    public void update() {
        String txt;
        int scrWidht = BNMapController.getInstance().getScreenWidth();
        int level = BNMapController.getInstance().getZoomLevel();
        double u = BNMapController.getInstance().getZoomUnitsInMeter();
        int dist = MapController.getScaleDis(level);
        LogUtil.m15791e("Meter", "room updateScale dis=" + dist + " level=" + level + " u=" + u);
        int pxLen = (int) Math.ceil(((double) dist) / u);
        while (pxLen > scrWidht / 2 && level >= 3 && level <= 20) {
            level++;
            dist = MapController.getScaleDis(level);
            pxLen = (int) Math.ceil(((double) dist) / u);
        }
        if (dist >= 1000) {
            txt = (dist / 1000) + StyleManager.getString(C0965R.string.nsdk_string_rg_kilometer);
        } else {
            txt = dist + StyleManager.getString(C0965R.string.nsdk_string_rg_meter);
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

    public void autoHide(long delayMillis) {
        this.mAutoHandler.removeMessages(1);
        this.mAutoHandler.sendEmptyMessageDelayed(1, delayMillis);
    }

    @SuppressLint({"NewApi"})
    public void onUpdateStyle(boolean isDay) {
        if (this.mScaleTitle != null) {
            this.mScaleTitle.setTextColor(isDay ? -13223362 : -1052432);
        }
        if (this.mScaleIndicator == null) {
            return;
        }
        if (StyleManager.getDayStyle()) {
            this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_ic_scale_indicator));
        } else {
            this.mScaleIndicator.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_ic_scale_indicator_night));
        }
    }

    public void showIcon() {
        this.mScaleTitle.setVisibility(4);
        this.mScaleIndicator.setVisibility(4);
    }

    public void showScale() {
        this.mScaleTitle.setVisibility(0);
        this.mScaleIndicator.setVisibility(0);
    }
}
