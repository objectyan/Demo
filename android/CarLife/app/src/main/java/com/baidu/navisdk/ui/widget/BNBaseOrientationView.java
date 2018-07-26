package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public abstract class BNBaseOrientationView extends BNBaseView {
    private static final String TAG = "BNBaseOrientationView";
    private boolean hasInitView = false;
    protected View mRootView = null;
    protected ViewGroup mRootViewContainer = null;

    public abstract LayoutParams generalLayoutParams();

    public abstract int getContainerViewId();

    public abstract int getLandscapeLayoutId();

    public abstract int getPortraitLayoutId();

    public abstract void initListener();

    public abstract void initViewById();

    public abstract void updateDataByLast();

    public BNBaseOrientationView(Context c, ViewGroup p) {
        super(c, p);
    }

    public BNBaseOrientationView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
    }

    public void orientationChanged(ViewGroup p, int orien) {
        resetStateBeforOrientation(orien);
        super.orientationChanged(p, orien);
        initViewContainner(true);
        if (getPortraitLayoutId() != getLandscapeLayoutId()) {
            initView();
        }
        if (isVisibility()) {
            addToContainer(true);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mRootView);
        }
    }

    protected void resetStateBeforOrientation(int orien) {
    }

    protected void initViewContainner(boolean forceInit) {
        if (this.mRootViewContainer == null || forceInit) {
            this.mRootViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(getContainerViewId());
        }
    }

    public void addToContainer(boolean forceInit) {
        if (this.mRootViewContainer == null) {
            LogUtil.m15791e(TAG, "addToContainner mRootViewContainer is null");
        } else if (this.mRootViewContainer.getChildCount() == 0 || forceInit) {
            this.mRootViewContainer.removeAllViews();
            if (this.mRootView == null) {
                LogUtil.m15791e(TAG, "addToContainner mRootView is null");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mRootView);
            }
            if (isVisibility()) {
                LayoutParams lp = generalLayoutParams();
                if (lp != null) {
                    this.mRootView.setLayoutParams(lp);
                }
                this.mRootViewContainer.addView(this.mRootView);
                this.mRootViewContainer.setVisibility(0);
                return;
            }
            this.mRootViewContainer.setVisibility(8);
            LogUtil.m15791e(TAG, "addToContainer isVisibility false");
        } else {
            LogUtil.m15791e(TAG, "addToContainner has done");
        }
    }

    public final void show() {
        show(null);
    }

    public void show(Bundle bundle) {
        super.show(bundle);
        if (!this.hasInitView) {
            initView();
        }
        initViewContainner(false);
        addToContainer(false);
        if (this.mRootViewContainer != null) {
            this.mRootViewContainer.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        if (this.mRootViewContainer != null) {
            this.mRootViewContainer.setVisibility(8);
        }
    }

    public void dispose() {
        super.dispose();
        if (this.mRootView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mRootView);
                }
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "webview dispose exception");
            }
        }
        this.mRootViewContainer = null;
        this.mRootView = null;
    }

    public void preloadView() {
        initView();
    }

    private void initView() {
        this.hasInitView = true;
        if (1 == RGViewController.getInstance().getOrientation()) {
            this.mCurOrientation = 1;
            this.mRootView = JarUtils.inflate((Activity) this.mContext, getPortraitLayoutId(), null);
        } else {
            this.mCurOrientation = 2;
            this.mRootView = JarUtils.inflate((Activity) this.mContext, getLandscapeLayoutId(), null);
        }
        initViewById();
        initListener();
        updateDataByLast();
        updateStyle(BNStyleManager.getDayStyle());
    }
}
