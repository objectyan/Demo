package com.baidu.navisdk.debug;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class BNEyeSpyPaperFloatButton {
    private static final String TAG = BNEyeSpyPaperFloatButton.class.getSimpleName();
    private boolean isMoved = false;
    private boolean isShowing = false;
    private float mDownX = 0.0f;
    private float mDownY = 0.0f;
    private LinearLayout mFloatLayout;
    private int mTouchSlop;
    private WindowManager mWindowManager;
    private float mXInFloatView;
    private float mXInScreen;
    private float mYInFloatView;
    private float mYInScreen;
    private LayoutParams wmParams;

    /* renamed from: com.baidu.navisdk.debug.BNEyeSpyPaperFloatButton$1 */
    class C40811 implements OnClickListener {
        C40811() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                BNEyeSpyPaperController.getInstance().showUserKeyLogDialog();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.debug.BNEyeSpyPaperFloatButton$2 */
    class C40822 implements OnTouchListener {
        C40822() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return BNEyeSpyPaperFloatButton.this.handleMotionEvent(event);
        }
    }

    public BNEyeSpyPaperFloatButton() {
        initWindowsManger();
        initViews();
        this.mTouchSlop = ViewConfiguration.get(BNaviModuleManager.getActivity()).getScaledTouchSlop();
    }

    private void initWindowsManger() {
        this.wmParams = new LayoutParams();
        this.mWindowManager = (WindowManager) BNaviModuleManager.getActivity().getSystemService("window");
        this.wmParams.type = 2;
        this.wmParams.format = 1;
        this.wmParams.flags = 8;
        this.wmParams.gravity = 51;
        this.wmParams.width = ScreenUtil.getInstance().dip2px(69);
        this.wmParams.height = ScreenUtil.getInstance().dip2px(30);
    }

    private void initViews() {
        this.mFloatLayout = new LinearLayout(BNaviModuleManager.getActivity());
        TextView textView = new TextView(BNaviModuleManager.getActivity());
        textView.setTextSize(1, 20.0f);
        textView.setText("报bug");
        this.mFloatLayout.addView(textView);
        this.mFloatLayout.setOrientation(0);
        this.mFloatLayout.setGravity(17);
        this.mFloatLayout.setBackgroundColor(-65536);
        this.mFloatLayout.setOnClickListener(new C40811());
    }

    public boolean show() {
        LogUtil.m15791e(TAG, "show :" + isShow());
        if (isShow()) {
            return true;
        }
        try {
            this.mFloatLayout.setOnTouchListener(new C40822());
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
        LogUtil.m15791e(TAG, "hide");
        try {
            if (!(this.mFloatLayout == null || this.mFloatLayout.getParent() == null)) {
                this.mWindowManager.removeView(this.mFloatLayout);
            }
            this.isShowing = false;
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "hide float excetion e:" + e.getMessage());
        }
    }

    public boolean isShow() {
        return this.isShowing;
    }

    public void dispose() {
        this.isShowing = false;
        if (this.mFloatLayout != null) {
            this.mWindowManager.removeView(this.mFloatLayout);
        }
    }

    private boolean handleMotionEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                this.mXInFloatView = event.getX();
                this.mYInFloatView = event.getY();
                this.mDownX = event.getRawX();
                this.mDownY = event.getRawY();
                this.isMoved = false;
                return false;
            case 1:
                updateViewPosition();
                return this.isMoved;
            case 2:
                this.mXInScreen = event.getRawX();
                this.mYInScreen = event.getRawY() - ((float) ScreenUtil.getInstance().getStatusBarHeight());
                if (Math.abs(this.mDownX - event.getRawX()) > ((float) this.mTouchSlop) || Math.abs(this.mDownY - event.getRawY()) > ((float) this.mTouchSlop)) {
                    this.isMoved = true;
                }
                if (!this.isMoved) {
                    return false;
                }
                updateViewPosition();
                return false;
            default:
                return false;
        }
    }

    private void updateViewPosition() {
        this.wmParams.x = (int) (this.mXInScreen - this.mXInFloatView);
        this.wmParams.y = (int) (this.mYInScreen - this.mYInFloatView);
        try {
            this.mWindowManager.updateViewLayout(this.mFloatLayout, this.wmParams);
        } catch (Exception e) {
        }
    }
}
