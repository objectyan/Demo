package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMMessageFloatView {
    private static final String TAG = RGMMMessageFloatView.class.getSimpleName();
    private volatile boolean isShowing = false;
    private TextView mContentText;
    private ViewGroup mFloatLayout;
    private TextView mHideButton;
    private WindowManager mWindowManager;
    private LayoutParams wmParams;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMessageFloatView$1 */
    class C43951 implements OnClickListener {
        C43951() {
        }

        public void onClick(View v) {
            RGMMMessageFloatView.this.hide();
        }
    }

    public RGMMMessageFloatView() {
        initWindowsManger();
        initViews();
    }

    private void initWindowsManger() {
        this.wmParams = new LayoutParams();
        this.mWindowManager = (WindowManager) BNaviModuleManager.getActivity().getApplicationContext().getSystemService("window");
        if (VERSION.SDK_INT >= 19) {
            this.wmParams.type = 2005;
        } else {
            this.wmParams.type = 2002;
        }
        this.wmParams.format = -3;
        this.wmParams.flags = RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL;
        this.wmParams.gravity = 17;
        this.wmParams.x = 0;
        this.wmParams.y = 0;
        this.wmParams.width = -1;
        this.wmParams.height = -1;
    }

    private void initViews() {
        this.mFloatLayout = (ViewGroup) JarUtils.inflate(BNaviModuleManager.getActivity(), C4048R.layout.nsdk_layout_notice_float, null);
        this.mContentText = (TextView) this.mFloatLayout.findViewById(C4048R.id.text_content);
        this.mContentText.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        this.mHideButton = (TextView) this.mFloatLayout.findViewById(C4048R.id.text_hide);
        this.mHideButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        this.mHideButton.setText(JarUtils.getResources().getString(C4048R.string.alert_i_know));
        this.mHideButton.setOnClickListener(new C43951());
    }

    public void setText(String text) {
        if (this.mContentText != null) {
            this.mContentText.setText(text);
        }
    }

    public boolean show() {
        if (isShow()) {
            return true;
        }
        try {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_5);
            this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
            this.isShowing = true;
            return true;
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "float excetion e:" + e.getMessage());
            this.isShowing = false;
            return false;
        }
    }

    public void hide() {
        this.isShowing = false;
        if (this.mFloatLayout != null && this.mFloatLayout.getParent() != null) {
            this.mWindowManager.removeView(this.mFloatLayout);
        }
    }

    public boolean isShow() {
        return this.isShowing;
    }

    public void dispose() {
        hide();
    }
}
