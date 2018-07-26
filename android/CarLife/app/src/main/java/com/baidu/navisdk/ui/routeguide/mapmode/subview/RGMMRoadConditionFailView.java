package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel.OnCountDownListener;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RGMMRoadConditionFailView extends BNBaseView {
    private static String TAG = RGMMRoadConditionFailView.class.getName();
    private View bgView;
    private View dividerView;
    private Handler mHandler = null;
    private BNWorkerNormalTask mHideTask = new BNWorkerNormalTask<String, String>("mHideTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
            RGViewController.getInstance().requestShowExpendView(3, false);
            return null;
        }
    };
    private ViewGroup mRoadConditionFailContainer = null;
    private TextView mRoadConditionFailKnown;
    private TextView mRoadConditionFailTips;
    private View mRoadConditionFailView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRoadConditionFailView$1 */
    class C44191 implements OnClickListener {
        C44191() {
        }

        public void onClick(View v) {
            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
            RGViewController.getInstance().requestShowExpendView(3, false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRoadConditionFailView$2 */
    class C44202 implements OnCountDownListener {
        C44202() {
        }

        public void onCountDown(int count) {
            if (count == 0) {
                BNWorkerCenter.getInstance().submitMainThreadTask(RGMMRoadConditionFailView.this.mHideTask, new BNWorkerConfig(2, 0));
            }
        }
    }

    public RGMMRoadConditionFailView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    public void orientationChanged(ViewGroup view, int orien) {
        super.orientationChanged(view, orien);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            LogUtil.m15791e(TAG, "initViews() in");
            this.mRoadConditionFailContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_update_road_condition_fail);
            if (this.mRoadConditionFailContainer != null) {
                LogUtil.m15791e(TAG, "initViews() create");
                this.mRoadConditionFailContainer.removeAllViews();
                this.mRoadConditionFailView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_update_road_condition_fail, null);
                if (this.mRoadConditionFailContainer != null && this.mRoadConditionFailView != null) {
                    this.mRoadConditionFailContainer.addView(this.mRoadConditionFailView, new LayoutParams(-1, -1));
                    this.bgView = this.mRootViewGroup.findViewById(C4048R.id.ll_road_condition_fail_item);
                    this.dividerView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_common_divider_road_condition_fail);
                    this.mRoadConditionFailKnown = (TextView) this.mRootViewGroup.findViewById(C4048R.id.road_condition_fail_known);
                    this.mRoadConditionFailTips = (TextView) this.mRootViewGroup.findViewById(C4048R.id.road_condition_fail_tips);
                }
            }
        }
    }

    public void updateData(Bundle b) {
    }

    private void initListener() {
        if (this.mRoadConditionFailKnown != null) {
            this.mRoadConditionFailKnown.setOnClickListener(new C44191());
        }
    }

    public void show() {
        super.show();
        LogUtil.m15791e(TAG, "onShow()");
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mRoadConditionFailContainer == null) {
            BNWorkerCenter.getInstance().cancelTask(this.mHideTask, false);
            BNWorkerCenter.getInstance().submitMainThreadTask(this.mHideTask, new BNWorkerConfig(2, 0));
        } else if (this.mRoadConditionFailContainer.getVisibility() != 0) {
            this.mRoadConditionFailContainer.setVisibility(0);
            RGUpdateRCFailModel.getInstance().startCountDown();
            RGUpdateRCFailModel.getInstance().setOnCountDownListener(new C44202());
        }
    }

    public void hide() {
        super.hide();
        LogUtil.m15791e(TAG, "onHide()");
        BNWorkerCenter.getInstance().cancelTask(this.mHideTask, false);
        if (this.mRoadConditionFailContainer != null) {
            this.mRoadConditionFailContainer.setVisibility(8);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mRoadConditionFailKnown != null) {
            this.mRoadConditionFailKnown.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_e));
            this.mRoadConditionFailKnown.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_button_selector));
        }
        if (this.mRoadConditionFailTips != null) {
            this.mRoadConditionFailTips.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
        }
        if (this.bgView != null) {
            this.bgView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.dividerView != null) {
            this.dividerView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
        }
    }
}
