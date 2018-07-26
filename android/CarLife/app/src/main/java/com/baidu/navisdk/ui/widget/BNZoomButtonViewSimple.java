package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class BNZoomButtonViewSimple {
    private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
    private AutoHandler mAutoHandler = new AutoHandler();
    private Context mContext;
    private boolean mDayStyle;
    private boolean mIsFullView = true;
    private View mLineLeftView = null;
    private OnZoomBtnClickListener mListener;
    private boolean mShowTwoBtn;
    private OnClickListener mZoomBtnClickListener = new C46021();
    private OnTouchListener mZoomBtnTouchListener = new C46032();
    private View mZoomDivider = null;
    private ImageView mZoomFullViewBtnView = null;
    private RelativeLayout mZoomInBtnView = null;
    private boolean mZoomInEnabled;
    private ImageView mZoomInImageView = null;
    private RelativeLayout mZoomOutBtnView = null;
    private boolean mZoomOutEnabled;
    private ImageView mZoomOutImageView = null;
    private View mZoomPanelView = null;
    private boolean noNightStyle = false;

    /* renamed from: com.baidu.navisdk.ui.widget.BNZoomButtonViewSimple$1 */
    class C46021 implements OnClickListener {
        C46021() {
        }

        public void onClick(View v) {
            BNZoomButtonViewSimple.this.mAutoHandler.removeMessages(8);
            if (v == BNZoomButtonViewSimple.this.mZoomInBtnView) {
                UserOPController.getInstance().add(UserOPParams.COMMON_1_9);
                BNMapController.getInstance().setDragMapStatus(true);
                BNZoomButtonViewSimple.this.handleZoomIn();
            } else if (v == BNZoomButtonViewSimple.this.mZoomOutBtnView) {
                BNMapController.getInstance().setDragMapStatus(true);
                UserOPController.getInstance().add(UserOPParams.COMMON_1_a);
                BNZoomButtonViewSimple.this.handleZoomOut();
            } else if (v == BNZoomButtonViewSimple.this.mZoomFullViewBtnView && BNZoomButtonViewSimple.this.mListener != null) {
                BNZoomButtonViewSimple.this.mListener.onZoomFullViewBtnClick();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNZoomButtonViewSimple$2 */
    class C46032 implements OnTouchListener {
        C46032() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v == BNZoomButtonViewSimple.this.mZoomInBtnView || v == BNZoomButtonViewSimple.this.mZoomOutBtnView || v == BNZoomButtonViewSimple.this.mZoomFullViewBtnView) {
                BNZoomButtonViewSimple.this.mAutoHandler.removeMessages(8);
            }
            return false;
        }
    }

    private static class AutoHandler extends Handler {
        private BNZoomButtonViewSimple mView;

        private AutoHandler(BNZoomButtonViewSimple view) {
            this.mView = view;
        }

        public void handleMessage(Message msg) {
            this.mView.handleMessage(msg);
        }
    }

    public interface OnZoomBtnClickListener {
        void onZoomFullViewBtnClick();

        void onZoomInBtnClick();

        void onZoomOutBtnClick();
    }

    public void initView(Context context, View view, boolean showTwoBtn) {
        this.mContext = context;
        this.mZoomPanelView = view.findViewById(C4048R.id.nav_zoom_panel);
        this.mZoomInBtnView = (RelativeLayout) view.findViewById(C4048R.id.btn_zoom_in);
        this.mZoomInImageView = (ImageView) view.findViewById(C4048R.id.iv_zoom_in);
        this.mZoomOutBtnView = (RelativeLayout) view.findViewById(C4048R.id.btn_zoom_out);
        this.mZoomOutImageView = (ImageView) view.findViewById(C4048R.id.iv_zoom_out);
        this.mZoomFullViewBtnView = (ImageView) view.findViewById(C4048R.id.btn_zoom_full_view);
        this.mZoomDivider = view.findViewById(C4048R.id.bnav_rg_cp_zoom_divider);
        if (this.mZoomInBtnView != null) {
            this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
            this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        }
        if (this.mZoomOutBtnView != null) {
            this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
            this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        }
        if (this.mZoomFullViewBtnView != null) {
            this.mZoomFullViewBtnView.setOnClickListener(this.mZoomBtnClickListener);
            this.mZoomFullViewBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        }
        this.mDayStyle = true;
        this.mZoomInEnabled = true;
        this.mZoomOutEnabled = true;
        setTwoBtnMode(showTwoBtn);
    }

    public void setTwoBtnMode(boolean showTwoBtn) {
        this.mShowTwoBtn = showTwoBtn;
        updateZoomBtnVisibility();
        if (this.noNightStyle) {
            initStyle();
        } else {
            updateStyle();
        }
    }

    public void updateZoomBtn(boolean enableZoomIn, boolean enableZoomOut) {
        this.mZoomInEnabled = enableZoomIn;
        this.mZoomOutEnabled = enableZoomOut;
        if (this.noNightStyle) {
            initStyle();
        } else {
            updateStyle();
        }
    }

    public void updateFullViewState(boolean isFullView) {
        LogUtil.m15791e("jzc", "onZoomFullViewBtnClick FullView=" + isFullView);
        this.mIsFullView = isFullView;
        if (isFullView) {
            this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_fullview_off));
        } else {
            this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_fullview));
        }
    }

    public boolean isFullView() {
        return this.mIsFullView;
    }

    public void setZoomBtnClickListener(OnZoomBtnClickListener listener) {
        this.mListener = listener;
    }

    public void show() {
        if (this.mZoomPanelView != null) {
            this.mZoomPanelView.setVisibility(0);
        }
        if (this.mZoomInBtnView != null) {
            this.mZoomInBtnView.getParent().requestTransparentRegion(this.mZoomInBtnView);
        }
    }

    public void hide() {
        if (this.mZoomPanelView != null) {
            this.mZoomPanelView.setVisibility(8);
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        this.mDayStyle = dayStyle;
        updateStyle();
    }

    private void initStyle() {
        float f = 1.0f;
        if (!(this.mZoomInBtnView == null || this.mZoomOutBtnView == null)) {
            if (RouteGuideParams.getRouteGuideMode() != 2) {
                this.mZoomInBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_common_cp_zoomin_button_selector));
                this.mZoomOutBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_common_cp_zoomout_button_selector));
            }
            if (VERSION.SDK_INT >= 11) {
                this.mZoomInBtnView.setAlpha(this.mZoomInEnabled ? 1.0f : 0.2f);
                RelativeLayout relativeLayout = this.mZoomOutBtnView;
                if (!this.mZoomOutEnabled) {
                    f = 0.2f;
                }
                relativeLayout.setAlpha(f);
            }
            this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
            this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
        }
        if (this.mZoomDivider != null) {
            this.mZoomDivider.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.cl_bg_a));
        }
    }

    private void updateStyle() {
        float f = 1.0f;
        if (!(this.mZoomInBtnView == null || this.mZoomOutBtnView == null || this.mZoomInImageView == null || this.mZoomOutImageView == null)) {
            if (RouteGuideParams.getRouteGuideMode() != 2) {
                this.mZoomInBtnView.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.bnav_common_cp_zoomin_button_selector));
                this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.bnav_common_cp_zoomout_button_selector));
            }
            if (VERSION.SDK_INT >= 11) {
                this.mZoomInImageView.setAlpha(this.mZoomInEnabled ? 1.0f : 0.2f);
                ImageView imageView = this.mZoomOutImageView;
                if (!this.mZoomOutEnabled) {
                    f = 0.2f;
                }
                imageView.setAlpha(f);
            }
            this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
            this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
        }
        if (this.mZoomDivider != null) {
            this.mZoomDivider.setBackgroundColor(BNStyleManager.getColor(BNStyleManager.getDayStyle() ? C4048R.color.cl_bg_a : C4048R.color.cl_bg_b_night));
        }
    }

    private void updateZoomBtnVisibility() {
        if (this.mZoomFullViewBtnView == null) {
            return;
        }
        if (this.mShowTwoBtn) {
            this.mZoomFullViewBtnView.setVisibility(8);
        } else {
            this.mZoomFullViewBtnView.setVisibility(0);
        }
    }

    private void handleMessage(Message msg) {
        switch (msg.what) {
            case 8:
                hide();
                return;
            default:
                return;
        }
    }

    public void handleZoomIn() {
        BNMapController.getInstance().zoomIn();
        if (this.mListener != null) {
            this.mListener.onZoomInBtnClick();
        }
        updateFullViewState(false);
    }

    public void handleZoomOut() {
        BNMapController.getInstance().zoomOut();
        if (this.mListener != null) {
            this.mListener.onZoomOutBtnClick();
        }
        updateFullViewState(false);
    }

    public boolean isNoNightStyle() {
        return this.noNightStyle;
    }

    public void setNoNightStyle(boolean noNightStyle) {
        this.noNightStyle = noNightStyle;
    }
}
