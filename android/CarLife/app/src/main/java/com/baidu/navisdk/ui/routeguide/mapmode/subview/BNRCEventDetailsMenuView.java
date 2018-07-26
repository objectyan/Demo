package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView.UgcRCEventCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class BNRCEventDetailsMenuView extends BNBaseView {
    public static boolean isViewShow = false;
    private ViewGroup mMenuViewContainer = null;
    private View mMenuViewPanel = null;
    private View mRCEventDetailsView = null;
    private UgcRCEventCallback mUgcRCEventCallback = new C43523();

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.BNRCEventDetailsMenuView$1 */
    class C43501 implements OnTouchListener {
        C43501() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.BNRCEventDetailsMenuView$2 */
    class C43512 implements OnTouchListener {
        C43512() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.BNRCEventDetailsMenuView$3 */
    class C43523 implements UgcRCEventCallback {
        C43523() {
        }

        public void onFinish() {
            RGMapModeViewController.getInstance().onBNRCEventClear();
            BNRCEventDetailsMenuView.this.hide();
        }

        public void onShowUserINfo(String url) {
        }
    }

    public BNRCEventDetailsMenuView(Context c, ViewGroup p, OnRGSubViewListener lis, String mUid) {
        super(c, p, lis);
        initViews(c, mUid);
        updateStyle(BNStyleManager.getDayStyle());
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    private void initViews(Context mContext, String mUid) {
        if (this.mRootViewGroup != null) {
            this.mMenuViewPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_detail_menu_panel);
            this.mMenuViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_detail_menu_container);
            if (this.mMenuViewContainer != null) {
                this.mMenuViewContainer.removeAllViews();
            }
            if (this.mMenuViewPanel != null) {
                this.mMenuViewPanel.setOnTouchListener(new C43501());
            } else if (this.mMenuViewContainer != null) {
                this.mMenuViewContainer.setOnTouchListener(new C43512());
            }
            if (BNavigator.getInstance().getmNavUserBehaviourCallback() != null) {
                BNavigator.getInstance().getmNavUserBehaviourCallback().registerLoadingProxy();
            }
            this.mRCEventDetailsView = BNRCEventDetailsViewController.getInstance().getView(mContext, mUid, BNaviModuleManager.getBduss(), this.mUgcRCEventCallback, RGViewController.getInstance().getOrientation());
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2, "2", null, null);
            if (this.mMenuViewContainer != null && this.mRCEventDetailsView != null) {
                this.mMenuViewContainer.removeAllViews();
                this.mMenuViewContainer.addView(this.mRCEventDetailsView, new LayoutParams(-1, -1));
            }
        }
    }

    public boolean onBackPress() {
        return BNRCEventDetailsViewController.getInstance().onBackPressed();
    }

    public void onDestroy() {
        BNRCEventDetailsViewController.getInstance().onDestroy();
        if (BNavigator.getInstance().getmNavUserBehaviourCallback() != null) {
            BNavigator.getInstance().getmNavUserBehaviourCallback().unRegisterLoadingProxy();
        }
    }

    public void show() {
        super.show();
        isViewShow = true;
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(0);
        }
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        isViewShow = false;
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setVisibility(8);
        }
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(8);
        }
    }
}
