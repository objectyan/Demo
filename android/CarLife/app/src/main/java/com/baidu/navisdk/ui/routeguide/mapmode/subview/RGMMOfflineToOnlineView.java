package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMOfflineToOnlineView extends BNBaseView {
    private static String TAG = RGMMOfflineToOnlineView.class.getName();
    private ViewGroup mOfflineToOnlineContainer = null;
    private View mOfflineToOnlineView = null;
    private TextView mReCalBtn;
    private Handler mhander = new Handler();

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOfflineToOnlineView$1 */
    class C44051 implements OnTouchListener {
        C44051() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOfflineToOnlineView$2 */
    class C44062 implements OnClickListener {
        C44062() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_1, "1", null, null);
                if (NetworkUtils.isNetworkAvailable(RGMMOfflineToOnlineView.this.mContext)) {
                    RGViewController.getInstance().showAvoidTrafficLoading("在线重算中...");
                    BNRouteGuider.getInstance().calcOtherRoute(2, 2);
                    return;
                }
                TipTool.onCreateToastDialog(RGMMOfflineToOnlineView.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_network_connect_failture));
            }
        }
    }

    public RGMMOfflineToOnlineView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            LogUtil.m15791e(TAG, "initViews() in");
            this.mOfflineToOnlineContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_offline_to_online_container);
            if (this.mOfflineToOnlineContainer != null) {
                LogUtil.m15791e(TAG, "initViews() create");
                this.mOfflineToOnlineContainer.removeAllViews();
                this.mOfflineToOnlineView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_offline_to_online, null);
                if (this.mOfflineToOnlineContainer != null && this.mOfflineToOnlineView != null) {
                    this.mOfflineToOnlineContainer.addView(this.mOfflineToOnlineView, new LayoutParams(-1, -2));
                    this.mReCalBtn = (TextView) this.mOfflineToOnlineView.findViewById(C4048R.id.connect_notify_set);
                }
            }
        }
    }

    private void initListener() {
        if (this.mOfflineToOnlineContainer != null) {
            this.mOfflineToOnlineContainer.setOnTouchListener(new C44051());
        }
        if (this.mReCalBtn != null) {
            this.mReCalBtn.setOnClickListener(new C44062());
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "onShow()");
        if (this.mOfflineToOnlineContainer != null) {
            this.mOfflineToOnlineContainer.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "onHide()");
        if (this.mOfflineToOnlineContainer != null) {
            this.mOfflineToOnlineContainer.setVisibility(8);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mReCalBtn != null) {
            this.mReCalBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_route_switch_button));
        }
    }
}
