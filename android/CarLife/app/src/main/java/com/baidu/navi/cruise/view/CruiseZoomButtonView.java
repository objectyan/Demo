package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;

public class CruiseZoomButtonView {
    private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
    private Activity mActivity;
    private Handler mAutoHandler = new C37703();
    private boolean mDayStyle = true;
    private OnZoomBtnClickListener mListener;
    private OnClickListener mZoomBtnClickListener = new C37681();
    private OnTouchListener mZoomBtnTouchListener = new C37692();
    private View mZoomDirver = null;
    private ImageView mZoomInBtnView = null;
    private boolean mZoomInButtonEnable = true;
    private ImageView mZoomOutBtnView = null;
    private boolean mZoomOutButtonEnable = true;
    private View mZoomPanelView = null;

    public interface OnZoomBtnClickListener {
        void onZoomInBtnClick();

        void onZoomOutBtnClick();
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseZoomButtonView$1 */
    class C37681 implements OnClickListener {
        C37681() {
        }

        public void onClick(View v) {
            CruiseZoomButtonView.this.mAutoHandler.removeMessages(8);
            if (v == CruiseZoomButtonView.this.mZoomInBtnView) {
                BNMapController.getInstance().zoomIn();
                if (CruiseZoomButtonView.this.mListener != null) {
                    CruiseZoomButtonView.this.mListener.onZoomInBtnClick();
                }
            } else if (v == CruiseZoomButtonView.this.mZoomOutBtnView) {
                BNMapController.getInstance().zoomOut();
                if (CruiseZoomButtonView.this.mListener != null) {
                    CruiseZoomButtonView.this.mListener.onZoomOutBtnClick();
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseZoomButtonView$2 */
    class C37692 implements OnTouchListener {
        C37692() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v == CruiseZoomButtonView.this.mZoomInBtnView || v == CruiseZoomButtonView.this.mZoomOutBtnView) {
                CruiseZoomButtonView.this.mAutoHandler.removeMessages(8);
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseZoomButtonView$3 */
    class C37703 extends Handler {
        C37703() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 8:
                    CruiseZoomButtonView.this.mZoomInBtnView.setVisibility(8);
                    CruiseZoomButtonView.this.mZoomOutBtnView.setVisibility(8);
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public CruiseZoomButtonView(Activity activity, View view) {
        this.mActivity = activity;
        this.mZoomPanelView = view.findViewById(C0965R.id.bnav_cruise_zoom_panel);
        this.mZoomInBtnView = (ImageView) view.findViewById(C0965R.id.bnav_cruise_btn_zoom_in);
        this.mZoomDirver = view.findViewById(C0965R.id.zoom_dirver);
        this.mZoomOutBtnView = (ImageView) view.findViewById(C0965R.id.bnav_cruise_btn_zoom_out);
        this.mZoomInBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomOutBtnView.setOnClickListener(this.mZoomBtnClickListener);
        this.mZoomInBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
        this.mZoomOutBtnView.setOnTouchListener(this.mZoomBtnTouchListener);
    }

    public void setZoomBtnClickListener(OnZoomBtnClickListener listener) {
        this.mListener = listener;
    }

    public void updateZoomButton() {
        int level = BNMapController.getInstance().getZoomLevel();
        LogUtil.m15791e("CruiseMapDebug", "updateZoomButton. level = " + level);
        if (level <= 3) {
            zoomInEnabled(true);
            zoomOutEnabled(false);
        } else if (level >= 20) {
            zoomInEnabled(false);
            zoomOutEnabled(true);
        } else {
            zoomInEnabled(true);
            zoomOutEnabled(true);
        }
    }

    public void show() {
        this.mZoomPanelView.setVisibility(0);
        this.mZoomInBtnView.getParent().requestTransparentRegion(this.mZoomInBtnView);
    }

    public void hide() {
        this.mZoomPanelView.setVisibility(8);
    }

    public void autoHide(long delayMillis) {
        this.mAutoHandler.removeMessages(8);
        this.mAutoHandler.sendEmptyMessageDelayed(8, delayMillis);
    }

    private void zoomInEnabled(boolean bEnable) {
        this.mZoomInButtonEnable = bEnable;
        if (bEnable) {
            this.mZoomInBtnView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_enlarge));
        } else {
            this.mZoomInBtnView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_enlarge_disable));
        }
    }

    private void zoomOutEnabled(boolean bEnable) {
        this.mZoomOutButtonEnable = bEnable;
        if (bEnable) {
            this.mZoomOutBtnView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_narrow));
        } else {
            this.mZoomOutBtnView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_narrow_disable));
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        this.mDayStyle = dayStyle;
        if (this.mZoomInBtnView != null && this.mZoomOutBtnView != null && this.mZoomDirver != null) {
            this.mZoomDirver.setBackgroundColor(this.mDayStyle ? 14277081 : -13814976);
            this.mZoomPanelView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.map_bg_btn));
            this.mZoomInBtnView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_btn_bg_zoom_in_selector));
            this.mZoomOutBtnView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_btn_bg_zoom_out_selector));
            zoomOutEnabled(this.mZoomOutButtonEnable);
            zoomInEnabled(this.mZoomInButtonEnable);
        }
    }
}
