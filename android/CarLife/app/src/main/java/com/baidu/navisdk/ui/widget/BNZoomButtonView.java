package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class BNZoomButtonView {
    private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
    private AutoHandler mAutoHandler = new AutoHandler();
    private Context mContext;
    private boolean mDayStyle;
    private boolean mIsFullView = true;
    private View mLineLeftView = null;
    private View mLineRightView = null;
    private OnZoomBtnClickListener mListener;
    private boolean mShowTwoBtn;
    private OnClickListener mZoomBtnClickListener = new C46001();
    private OnTouchListener mZoomBtnTouchListener = new C46012();
    private ImageView mZoomFullViewBtnView = null;
    private ImageView mZoomInBtnView = null;
    private boolean mZoomInEnabled;
    private ImageView mZoomOutBtnView = null;
    private boolean mZoomOutEnabled;
    private View mZoomPanelView = null;
    private boolean noNightStyle = false;

    /* renamed from: com.baidu.navisdk.ui.widget.BNZoomButtonView$1 */
    class C46001 implements OnClickListener {
        C46001() {
        }

        public void onClick(View v) {
            BNZoomButtonView.this.mAutoHandler.removeMessages(8);
            if (v == BNZoomButtonView.this.mZoomInBtnView) {
                UserOPController.getInstance().add(UserOPParams.COMMON_1_9);
                BNZoomButtonView.this.handleZoomIn();
            } else if (v == BNZoomButtonView.this.mZoomOutBtnView) {
                UserOPController.getInstance().add(UserOPParams.COMMON_1_a);
                BNZoomButtonView.this.handleZoomOut();
            } else if (v == BNZoomButtonView.this.mZoomFullViewBtnView && BNZoomButtonView.this.mListener != null) {
                BNZoomButtonView.this.mListener.onZoomFullViewBtnClick();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNZoomButtonView$2 */
    class C46012 implements OnTouchListener {
        C46012() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v == BNZoomButtonView.this.mZoomInBtnView || v == BNZoomButtonView.this.mZoomOutBtnView || v == BNZoomButtonView.this.mZoomFullViewBtnView) {
                BNZoomButtonView.this.mAutoHandler.removeMessages(8);
            }
            return false;
        }
    }

    private static class AutoHandler extends Handler {
        private BNZoomButtonView mView;

        private AutoHandler(BNZoomButtonView view) {
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
        this.mZoomInBtnView = (ImageView) view.findViewById(C4048R.id.btn_zoom_in);
        this.mZoomOutBtnView = (ImageView) view.findViewById(C4048R.id.btn_zoom_out);
        this.mZoomFullViewBtnView = (ImageView) view.findViewById(C4048R.id.btn_zoom_full_view);
        this.mLineLeftView = view.findViewById(C4048R.id.line_left);
        this.mLineRightView = view.findViewById(C4048R.id.line_right);
        this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomFullViewBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        this.mZoomFullViewBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
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
        this.mZoomPanelView.setVisibility(0);
        this.mZoomInBtnView.getParent().requestTransparentRegion(this.mZoomInBtnView);
    }

    public void hide() {
        this.mZoomPanelView.setVisibility(8);
    }

    public void onUpdateStyle(boolean dayStyle) {
        this.mDayStyle = dayStyle;
        if (this.noNightStyle) {
            initStyle();
        } else {
            updateStyle();
        }
    }

    private void initStyle() {
        this.mZoomInBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_top_selector));
        this.mLineLeftView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_line_horizontal));
        this.mLineLeftView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.cl_bg_b));
        if (this.mShowTwoBtn) {
            this.mZoomOutBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_bottom_selector));
        } else {
            this.mZoomOutBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_bottom_selector));
            this.mLineRightView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_line_horizontal));
            this.mZoomFullViewBtnView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_selector));
            if (this.mIsFullView) {
                this.mZoomFullViewBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_fullview_off));
            } else {
                this.mZoomFullViewBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_fullview));
            }
        }
        if (this.mZoomInEnabled) {
            this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_zoom_in_normal));
        } else {
            this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_zoom_in_disabled));
        }
        if (this.mZoomOutEnabled) {
            this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_zoom_out_normal));
        } else {
            this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_ic_zoom_out_disabled));
        }
        this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
        this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
    }

    private void updateStyle() {
        this.mZoomInBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_top_selector));
        this.mLineLeftView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_line_horizontal));
        this.mLineLeftView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
        if (this.mShowTwoBtn) {
            this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_bottom_selector));
        } else {
            this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_bottom_selector));
            this.mLineRightView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_line_horizontal));
            this.mZoomFullViewBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_prj_card_selector));
            if (this.mIsFullView) {
                this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_fullview_off));
            } else {
                this.mZoomFullViewBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_fullview));
            }
        }
        if (this.mZoomInEnabled) {
            this.mZoomInBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_zoom_in_normal));
        } else {
            this.mZoomInBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_zoom_in_disabled));
        }
        if (this.mZoomOutEnabled) {
            this.mZoomOutBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_zoom_out_normal));
        } else {
            this.mZoomOutBtnView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_ic_zoom_out_disabled));
        }
        this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
        this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
    }

    private void updateZoomBtnVisibility() {
        if (this.mShowTwoBtn) {
            this.mZoomFullViewBtnView.setVisibility(8);
            this.mLineRightView.setVisibility(8);
            return;
        }
        this.mZoomFullViewBtnView.setVisibility(0);
        this.mLineRightView.setVisibility(0);
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
