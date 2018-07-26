package com.baidu.navisdk.ui.cruise.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.map.MapController;

public class CruiseScaleLevelView {
    private static final int MSG_AUTO_HIDE = 1;
    private ImageView mAppNameIV = null;
    private Handler mAutoHandler = new C42921();
    private Context mContext;
    private RelativeLayout mLayout = null;
    private TextView mScaleIndicator = null;
    private TextView mScaleTitle = null;

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseScaleLevelView$1 */
    class C42921 extends Handler {
        C42921() {
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

    public CruiseScaleLevelView(Context context, View view) {
        this.mContext = context;
        this.mLayout = (RelativeLayout) view.findViewById(C4048R.id.bnav_cruise_map_scale_layout);
        this.mScaleTitle = (TextView) view.findViewById(C4048R.id.bnav_cruise_scale_title);
        this.mScaleIndicator = (TextView) view.findViewById(C4048R.id.bnav_cruise_scale_indicator);
        this.mAppNameIV = (ImageView) view.findViewById(C4048R.id.app_name);
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

    public void autoHide(long delayMillis) {
        this.mAutoHandler.removeMessages(1);
        this.mAutoHandler.sendEmptyMessageDelayed(1, delayMillis);
    }

    @SuppressLint({"NewApi"})
    public void onUpdateStyle(boolean isDay) {
        if (this.mScaleTitle != null) {
            this.mScaleTitle.setTextColor(isDay ? -13223362 : -1052432);
        }
        if (this.mScaleIndicator != null) {
            this.mScaleIndicator.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_scale_indicator));
        }
    }
}
