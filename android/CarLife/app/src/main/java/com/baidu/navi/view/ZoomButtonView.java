package com.baidu.navi.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;

public class ZoomButtonView {
    private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
    private AutoHandler mAutoHandler = new AutoHandler();
    private Context mContext;
    private boolean mDayStyle;
    private OnZoomBtnClickListener mListener;
    private OnClickListener mZoomBtnClickListener = new C40241();
    private OnTouchListener mZoomBtnTouchListener = new C40252();
    private View mZoomDirver = null;
    private ImageView mZoomInBtnView = null;
    private boolean mZoomInEnabled;
    private ImageView mZoomOutBtnView = null;
    private boolean mZoomOutEnabled;
    private View mZoomPanelView = null;

    public interface OnZoomBtnClickListener {
        void onZoomInBtnClick();

        void onZoomOutBtnClick();
    }

    /* renamed from: com.baidu.navi.view.ZoomButtonView$1 */
    class C40241 implements OnClickListener {
        C40241() {
        }

        public void onClick(View v) {
            ZoomButtonView.this.mAutoHandler.removeMessages(8);
            if (v == ZoomButtonView.this.mZoomInBtnView) {
                ZoomButtonView.this.handleZoomIn();
            } else if (v == ZoomButtonView.this.mZoomOutBtnView) {
                ZoomButtonView.this.handleZoomOut();
            }
        }
    }

    /* renamed from: com.baidu.navi.view.ZoomButtonView$2 */
    class C40252 implements OnTouchListener {
        C40252() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v == ZoomButtonView.this.mZoomInBtnView || v == ZoomButtonView.this.mZoomOutBtnView) {
                ZoomButtonView.this.mAutoHandler.removeMessages(8);
            }
            return false;
        }
    }

    private static class AutoHandler extends Handler {
        private ZoomButtonView mView;

        private AutoHandler(ZoomButtonView view) {
            this.mView = view;
        }

        public void handleMessage(Message msg) {
            this.mView.handleMessage(msg);
        }
    }

    public void initView(Context context, View view) {
        this.mContext = context;
        this.mZoomDirver = view.findViewById(C0965R.id.zoom_dirver);
        this.mZoomPanelView = view.findViewById(C0965R.id.nav_zoom_panel);
        this.mZoomInBtnView = (ImageView) view.findViewById(C0965R.id.btn_zoom_in);
        this.mZoomOutBtnView = (ImageView) view.findViewById(C0965R.id.btn_zoom_out);
        this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        this.mDayStyle = true;
        this.mZoomInEnabled = true;
        this.mZoomOutEnabled = true;
    }

    public void initView(Context context, View view, boolean isForRouteDetails) {
        initView(context, view);
    }

    public void updateZoomBtn(boolean enableZoomIn, boolean enableZoomOut) {
        this.mZoomInEnabled = enableZoomIn;
        this.mZoomOutEnabled = enableZoomOut;
        updateStyle();
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
        updateStyle();
    }

    private void updateStyle() {
        if (this.mZoomInBtnView != null && this.mZoomOutBtnView != null) {
            if (this.mZoomPanelView != null || this.mZoomDirver != null) {
                this.mZoomDirver.setBackgroundColor(this.mDayStyle ? 14277081 : -13814976);
                this.mZoomPanelView.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn, this.mDayStyle));
                this.mZoomInBtnView.setBackground(StyleManager.getDrawable(C0965R.drawable.common_btn_bg_zoom_in_selector, this.mDayStyle));
                this.mZoomOutBtnView.setBackground(StyleManager.getDrawable(C0965R.drawable.common_btn_bg_zoom_out_selector, this.mDayStyle));
                if (this.mZoomInEnabled) {
                    this.mZoomInBtnView.setImageResource(C0965R.drawable.map_ic_home_enlarge);
                } else {
                    this.mZoomInBtnView.setImageResource(C0965R.drawable.map_ic_home_enlarge_disable);
                }
                if (this.mZoomOutEnabled) {
                    this.mZoomOutBtnView.setImageResource(C0965R.drawable.map_ic_home_narrow);
                } else {
                    this.mZoomOutBtnView.setImageResource(C0965R.drawable.map_ic_home_narrow_disable);
                }
                if (!this.mZoomInEnabled && this.mZoomInBtnView.isFocused()) {
                    this.mZoomOutBtnView.requestFocus();
                } else if (!this.mZoomOutEnabled && this.mZoomOutBtnView.isFocused()) {
                    this.mZoomInBtnView.requestFocus();
                }
                this.mZoomInBtnView.setEnabled(this.mZoomInEnabled);
                this.mZoomOutBtnView.setEnabled(this.mZoomOutEnabled);
            }
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
        MapViewFactory.getInstance().getMapView().setZoomLevel(BNMapController.getInstance().getZoomLevel() + 1);
        if (this.mListener != null) {
            this.mListener.onZoomInBtnClick();
        }
    }

    public void handleZoomOut() {
        MapViewFactory.getInstance().getMapView().setZoomLevel(BNMapController.getInstance().getZoomLevel() - 1);
        if (this.mListener != null) {
            this.mListener.onZoomOutBtnClick();
        }
    }

    public View getZoomInBtnView() {
        return this.mZoomInBtnView;
    }

    public View getZoomOutBtnView() {
        return this.mZoomOutBtnView;
    }
}
