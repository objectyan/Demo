package com.baidu.navisdk.ui.cruise.view;

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

public class CruiseZoomButtonView {
    private static final int MSG_AUTO_HIDE_ZOOMBUTTON = 8;
    private Handler mAutoHandler = new C42953();
    private Context mContext;
    private boolean mDayStyle = true;
    private OnZoomBtnClickListener mListener;
    private OnClickListener mZoomBtnClickListener = new C42931();
    private OnTouchListener mZoomBtnTouchListener = new C42942();
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

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseZoomButtonView$1 */
    class C42931 implements OnClickListener {
        C42931() {
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

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseZoomButtonView$2 */
    class C42942 implements OnTouchListener {
        C42942() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v == CruiseZoomButtonView.this.mZoomInBtnView || v == CruiseZoomButtonView.this.mZoomOutBtnView) {
                CruiseZoomButtonView.this.mAutoHandler.removeMessages(8);
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseZoomButtonView$3 */
    class C42953 extends Handler {
        C42953() {
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

    public CruiseZoomButtonView(Context context, View view) {
        this.mContext = context;
        this.mZoomDirver = view.findViewById(C4048R.id.zoom_dirver);
        this.mZoomPanelView = view.findViewById(C4048R.id.bnav_cruise_zoom_panel);
        this.mZoomInBtnView = (ImageView) view.findViewById(C4048R.id.bnav_cruise_btn_zoom_in);
        this.mZoomOutBtnView = (ImageView) view.findViewById(C4048R.id.bnav_cruise_btn_zoom_out);
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
            this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_enlarge));
        } else {
            this.mZoomInBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_enlarge_disable));
        }
    }

    private void zoomOutEnabled(boolean bEnable) {
        this.mZoomOutButtonEnable = bEnable;
        if (bEnable) {
            this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_narrow));
        } else {
            this.mZoomOutBtnView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.map_ic_home_narrow_disable));
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        this.mDayStyle = dayStyle;
        if (this.mZoomInBtnView != null && this.mZoomOutBtnView != null) {
            if (this.mZoomPanelView != null || this.mZoomDirver != null) {
                this.mZoomDirver.setBackgroundColor(this.mDayStyle ? 14277081 : -13814976);
                this.mZoomPanelView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.map_bg_btn));
                this.mZoomInBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.common_btn_bg_zoom_in_selector));
                this.mZoomOutBtnView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.common_btn_bg_zoom_out_selector));
                zoomOutEnabled(this.mZoomOutButtonEnable);
                zoomInEnabled(this.mZoomInButtonEnable);
            }
        }
    }
}
