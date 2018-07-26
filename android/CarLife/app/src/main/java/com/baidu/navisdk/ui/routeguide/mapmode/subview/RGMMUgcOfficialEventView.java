package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMUgcOfficialEventView extends BNBaseView {
    private static final int MSG_HIDE_UGC_OFFICIAL_EVENT_CARD = 1;
    private static final String TAG = "RGMMUgcOfficialEventView";
    private ViewGroup mUgcOfficialEventContainer = null;
    private TextView mUgcOfficialEventTV = null;
    private View mUgcOfficialEventView = null;

    public RGMMUgcOfficialEventView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    private void initListener() {
    }

    private void initViews() {
        if (this.mRootViewGroup != null && this.mUgcOfficialEventContainer != null) {
            this.mUgcOfficialEventContainer.removeAllViews();
            this.mUgcOfficialEventView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_common_card, null);
            if (this.mUgcOfficialEventContainer != null) {
                this.mUgcOfficialEventTV = (TextView) this.mUgcOfficialEventView.findViewById(C4048R.id.common_card_text);
            }
            if (this.mUgcOfficialEventTV != null) {
                this.mUgcOfficialEventContainer.addView(this.mUgcOfficialEventView, new LayoutParams(-1, -2));
            }
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "show()");
        if (this.mUgcOfficialEventContainer != null) {
            this.mUgcOfficialEventContainer.setVisibility(0);
        }
        if (this.mUgcOfficialEventTV != null) {
            this.mUgcOfficialEventTV.setText(JNIGuidanceControl.getInstance().GetRoadEventText());
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "hide()");
        if (this.mUgcOfficialEventContainer != null) {
            this.mUgcOfficialEventContainer.setVisibility(8);
        }
    }
}
