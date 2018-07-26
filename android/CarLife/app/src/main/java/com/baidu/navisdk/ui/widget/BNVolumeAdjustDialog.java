package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMBlueToothUSBGuideView;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class BNVolumeAdjustDialog extends BNVolumeKeyDownDialog {
    private static final String TAG = BNVolumeAdjustDialog.class.getSimpleName();
    private static volatile boolean runFlag = true;
    private Activity mActivity;
    private ImageView mBTUSBCarImageView = null;
    private TextView mBTUSBCarTextView = null;
    private TextView mBTUSBDescribeTextView = null;
    private ImageView mBTUSBImageView = null;
    private LinearLayout mBTUSBLayout = null;
    private View mBTUSBSplitView = null;
    private TextView mBTUSBTextView = null;
    private BNWorkerNormalTask<String, String> mDisapperVolumeTask = new BNWorkerNormalTask<String, String>("mDisapperVolumeTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            BNVolumeAdjustDialog.this.dismiss();
            if (BNVolumeAdjustDialog.this.mRGRLVolume != null) {
                BNVolumeAdjustDialog.this.mRGRLVolume.setVisibility(8);
            }
            return null;
        }
    };
    private ImageView mRGIVVolume;
    private LinearLayout mRGLLVolume;
    private ProgressBar mRGPBVolume;
    private RelativeLayout mRGRLVolume;

    /* renamed from: com.baidu.navisdk.ui.widget.BNVolumeAdjustDialog$1 */
    class C45961 implements OnClickListener {
        C45961() {
        }

        public void onClick(View view) {
            BNWorkerCenter.getInstance().cancelTask(BNVolumeAdjustDialog.this.mDisapperVolumeTask, false);
            BNVolumeAdjustDialog.this.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNVolumeAdjustDialog$2 */
    class C45972 implements OnClickListener {
        C45972() {
        }

        public void onClick(View v) {
            if (v != null) {
                BNWorkerCenter.getInstance().cancelTask(BNVolumeAdjustDialog.this.mDisapperVolumeTask, false);
                BNVolumeAdjustDialog.this.dismiss();
                BNVolumeAdjustDialog.this.gotoBTUSBGuidePage(RGMMBlueToothUSBGuideView.sPanelContentType);
            }
        }
    }

    public BNVolumeAdjustDialog(Activity activity) {
        View view;
        super(activity, 16973840);
        requestWindowFeature(1);
        Window win = getWindow();
        win.setBackgroundDrawableResource(17170445);
        win.clearFlags(2);
        try {
            view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_volume_adjust_dialog, null);
        } catch (Exception e) {
            view = null;
        }
        if (view != null) {
            setContentView(view);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            this.mRGRLVolume = (RelativeLayout) findViewById(C4048R.id.navi_rg_rl_volume);
            this.mRGPBVolume = (ProgressBar) findViewById(C4048R.id.navi_rg_pg_volume);
            this.mRGIVVolume = (ImageView) findViewById(C4048R.id.bnav_rg_volume_icon);
            this.mRGLLVolume = (LinearLayout) findViewById(C4048R.id.navi_rg_ll_volume);
            this.mBTUSBLayout = (LinearLayout) findViewById(C4048R.id.navi_rg_pg_volume_bt_usb_ll);
            this.mBTUSBSplitView = findViewById(C4048R.id.navi_rg_pg_volume_split_line);
            this.mBTUSBImageView = (ImageView) findViewById(C4048R.id.navi_rg_volume_bt_usb_iv);
            this.mBTUSBTextView = (TextView) findViewById(C4048R.id.navi_rg_volume_bt_usb_tv);
            this.mBTUSBCarImageView = (ImageView) findViewById(C4048R.id.navi_rg_volume_car_iv);
            this.mBTUSBCarTextView = (TextView) findViewById(C4048R.id.navi_rg_volume_car_tv);
            this.mBTUSBDescribeTextView = (TextView) findViewById(C4048R.id.navi_rg_volume_describe_tv);
            initListener();
            onUpdateStyle(BNStyleManager.getDayStyle());
            this.mRGRLVolume.setOnClickListener(new C45961());
        }
    }

    private void initListener() {
        if (this.mBTUSBDescribeTextView != null) {
            this.mBTUSBDescribeTextView.setOnClickListener(new C45972());
        }
    }

    public void showVolume(int curSystemVolume, int maxSystemVolume, int curTTSVolume, boolean volumeUp, int spGuideHeight, int hwHeight) {
        if (this.mRGLLVolume != null && this.mRGIVVolume != null && this.mRGPBVolume != null) {
            LayoutParams params;
            if (2 == RGCacheStatus.sOrientation) {
                params = (LayoutParams) this.mRGLLVolume.getLayoutParams();
                params.setMargins((ScreenUtil.getInstance().getHeightPixels() / 3) + ScreenUtil.getInstance().dip2px(58), ScreenUtil.getInstance().dip2px(8), ScreenUtil.getInstance().dip2px(58), 0);
                this.mRGLLVolume.setLayoutParams(params);
            } else {
                int topMargin;
                params = (LayoutParams) this.mRGLLVolume.getLayoutParams();
                if (spGuideHeight <= 0 || hwHeight <= 0) {
                    topMargin = ScreenUtil.getInstance().dip2px(160);
                } else {
                    topMargin = (ScreenUtil.getInstance().dip2px(8) + spGuideHeight) + hwHeight;
                }
                params.setMargins(ScreenUtil.getInstance().dip2px(58), topMargin, ScreenUtil.getInstance().dip2px(58), 0);
                this.mRGLLVolume.setLayoutParams(params);
            }
            BNWorkerCenter.getInstance().cancelTask(this.mDisapperVolumeTask, false);
            if (curSystemVolume == 0) {
                if (this.mRGIVVolume != null) {
                    this.mRGIVVolume.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_no_voice_icon));
                }
            } else if (this.mRGIVVolume != null) {
                this.mRGIVVolume.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_voume_icon));
            }
            LogUtil.m15791e(TAG, "curSystemVolume = " + curSystemVolume + ", maxSystemVolume = " + maxSystemVolume + ", curSystemVolume * 100 / maxSystemVolume = " + ((curSystemVolume * 100) / maxSystemVolume));
            this.mRGPBVolume.setProgress((curSystemVolume * 100) / maxSystemVolume);
            this.mRGRLVolume.setVisibility(0);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mDisapperVolumeTask, new BNWorkerConfig(100, 0), 3000);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
        }
    }

    public void onBackPressed() {
        dismiss();
        if (this.mRGRLVolume != null) {
            this.mRGRLVolume.setVisibility(8);
        }
    }

    public void onOrientationChange() {
        dismiss();
        if (this.mRGRLVolume != null) {
            this.mRGRLVolume.setVisibility(8);
        }
    }

    public void onUpdateStyle(boolean isDay) {
        if (this.mRGLLVolume != null) {
            this.mRGLLVolume.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
        }
        if (this.mBTUSBSplitView != null) {
            if (isDay) {
                this.mBTUSBSplitView.setBackgroundColor(Color.parseColor("#d6d6d6"));
            } else {
                this.mBTUSBSplitView.setBackgroundColor(Color.parseColor("#2b2d31"));
            }
        }
        if (this.mBTUSBTextView != null) {
            if (isDay) {
                this.mBTUSBTextView.setTextColor(Color.parseColor("#333333"));
            } else {
                this.mBTUSBTextView.setTextColor(Color.parseColor("#dedede"));
            }
        }
        if (this.mBTUSBCarTextView != null) {
            if (isDay) {
                this.mBTUSBCarTextView.setTextColor(Color.parseColor("#999999"));
            } else {
                this.mBTUSBCarTextView.setTextColor(Color.parseColor("#6e6e6e"));
            }
        }
        if (this.mBTUSBCarImageView != null) {
            this.mBTUSBCarImageView.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_volume_adjust_dialog_tips));
        }
    }

    public void onDestory() {
        BNWorkerCenter.getInstance().cancelTask(this.mDisapperVolumeTask, false);
    }

    public void showBTUSBPanel(boolean isShow) {
        if (this.mBTUSBLayout != null && this.mBTUSBSplitView != null) {
            if (isShow) {
                this.mBTUSBLayout.setVisibility(0);
                this.mBTUSBSplitView.setVisibility(0);
                return;
            }
            this.mBTUSBLayout.setVisibility(8);
            this.mBTUSBSplitView.setVisibility(8);
        }
    }

    public void setBTUSBContent(int type) {
        if (this.mBTUSBImageView != null && this.mBTUSBTextView != null) {
            if (type == 1) {
                this.mBTUSBImageView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_volume_adjust_dialog_bluetooth));
                this.mBTUSBTextView.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_tts_volume_dialog_bluetooth_tips));
            } else if (type == 2) {
                this.mBTUSBImageView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_volume_adjust_dialog_usb));
                this.mBTUSBTextView.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_tts_volume_dialog_usb_tips));
            }
        }
    }

    public void gotoBTUSBGuidePage(int pageType) {
        if (pageType == 1) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_r_3, "1", null, null);
            RGViewController.getInstance().showBlueToothUSBGuide();
        } else if (pageType == 2) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_r_3, "2", null, null);
            RGViewController.getInstance().showBlueToothUSBGuide();
        }
    }
}
