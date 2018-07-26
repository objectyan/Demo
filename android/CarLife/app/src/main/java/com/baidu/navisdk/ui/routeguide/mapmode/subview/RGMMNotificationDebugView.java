package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.widget.BNBaseView;

public class RGMMNotificationDebugView extends BNBaseView {
    private Button mCommonHideBtn = null;
    private Button mCommonShowBtn = null;
    private View mDebugView = null;
    private Button mOperableHideBtn = null;
    private Button mOperableShowBtn = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationDebugView$1 */
    class C43981 implements OnClickListener {
        C43981() {
        }

        public void onClick(View v) {
            RGNotificationController.getInstance().debugCommonNotification(true);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationDebugView$2 */
    class C43992 implements OnClickListener {
        C43992() {
        }

        public void onClick(View v) {
            RGNotificationController.getInstance().debugCommonNotification(false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationDebugView$3 */
    class C44003 implements OnClickListener {
        C44003() {
        }

        public void onClick(View v) {
            RGNotificationController.getInstance().debugOperableNotification(true);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationDebugView$4 */
    class C44014 implements OnClickListener {
        C44014() {
        }

        public void onClick(View v) {
            RGNotificationController.getInstance().debugOperableNotification(false);
        }
    }

    public RGMMNotificationDebugView(Context c, ViewGroup p) {
        super(c, p);
        initViews();
        initListener();
    }

    private void initViews() {
        if (this.mRootViewGroup != null && this.mContext != null) {
            if (this.mDebugView == null) {
                this.mDebugView = ((ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_notification_debug_layout_stub)).inflate();
            }
            if (this.mDebugView != null) {
                this.mCommonShowBtn = (Button) this.mDebugView.findViewById(C4048R.id.bnav_rg_common_notification_debug_show);
                this.mCommonHideBtn = (Button) this.mDebugView.findViewById(C4048R.id.bnav_rg_common_notification_debug_hide);
                this.mOperableShowBtn = (Button) this.mDebugView.findViewById(C4048R.id.bnav_rg_operable_notification_debug_show);
                this.mOperableHideBtn = (Button) this.mDebugView.findViewById(C4048R.id.bnav_rg_operable_notification_debug_hide);
            }
        }
    }

    private void initListener() {
        if (this.mCommonShowBtn != null) {
            this.mCommonShowBtn.setOnClickListener(new C43981());
        }
        if (this.mCommonHideBtn != null) {
            this.mCommonHideBtn.setOnClickListener(new C43992());
        }
        if (this.mOperableShowBtn != null) {
            this.mOperableShowBtn.setOnClickListener(new C44003());
        }
        if (this.mOperableHideBtn != null) {
            this.mOperableHideBtn.setOnClickListener(new C44014());
        }
    }

    public void show() {
        super.show();
        if (this.mDebugView != null) {
            this.mDebugView.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        if (this.mDebugView != null) {
            this.mDebugView.setVisibility(8);
        }
    }
}
