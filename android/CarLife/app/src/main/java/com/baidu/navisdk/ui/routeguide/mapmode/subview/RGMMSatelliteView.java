package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMSatelliteView extends BNBaseView {
    private static String TAG = RGMMSatelliteView.class.getName();
    private final String TIPS_TEXT = "GPS信号弱，请谨慎驾驶";
    private ViewGroup mSatelliteContainer = null;
    private TextView mSatelliteTV = null;
    private View mSatelliteView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMSatelliteView$1 */
    class C44301 implements OnTouchListener {
        C44301() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public RGMMSatelliteView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    private void initViews() {
        if (this.mRootViewGroup != null && this.mSatelliteContainer != null) {
            this.mSatelliteContainer.removeAllViews();
            this.mSatelliteView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_common_card, null);
            this.mSatelliteTV = (TextView) this.mSatelliteView.findViewById(C4048R.id.common_card_text);
            if (this.mSatelliteContainer != null && this.mSatelliteView != null) {
                this.mSatelliteContainer.addView(this.mSatelliteView, new LayoutParams(-1, -2));
            }
        }
    }

    private void initListener() {
        if (this.mSatelliteContainer != null) {
            this.mSatelliteContainer.setOnTouchListener(new C44301());
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "show()");
        if (this.mSatelliteContainer != null) {
            this.mSatelliteContainer.setVisibility(0);
        }
        if (this.mSatelliteTV != null) {
            this.mSatelliteTV.setText("GPS信号弱，请谨慎驾驶");
            this.mSatelliteTV.setTextColor(-1);
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "hide()");
        if (this.mSatelliteContainer != null) {
            this.mSatelliteContainer.setVisibility(8);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }
}
