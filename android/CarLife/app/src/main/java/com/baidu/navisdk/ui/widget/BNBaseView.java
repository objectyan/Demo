package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public abstract class BNBaseView {
    private BNWorkerNormalTask<String, String> mAutoHideRunnable = new BNWorkerNormalTask<String, String>("BNBaseView-autoHideTask", null) {
        protected String execute() {
            BNBaseView.this.hiedByTimeOut();
            return null;
        }
    };
    protected Context mContext;
    protected int mCurOrientation = 2;
    protected boolean mIsCurDay = true;
    protected ViewGroup mRootViewGroup;
    protected OnRGSubViewListener mSubViewListener;
    private boolean mVisibility = false;

    public BNBaseView(Context c, ViewGroup p) {
        this.mContext = c;
        this.mRootViewGroup = p;
        this.mSubViewListener = null;
    }

    public BNBaseView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        this.mContext = c;
        this.mRootViewGroup = p;
        this.mSubViewListener = lis;
    }

    public void show() {
        show(null);
    }

    public void show(Bundle bundle) {
        this.mVisibility = true;
    }

    public void hide() {
        this.mVisibility = false;
    }

    public void updateSubListener(OnRGSubViewListener lis) {
        this.mSubViewListener = lis;
    }

    public void updateStyle(boolean day) {
        this.mIsCurDay = day;
    }

    public void orientationChanged(ViewGroup p, int orien) {
        this.mRootViewGroup = p;
        this.mCurOrientation = orien;
    }

    public void updateData(Bundle b) {
    }

    public boolean isVisibility() {
        return this.mVisibility;
    }

    public void dispose() {
        this.mSubViewListener = null;
        this.mContext = null;
    }

    protected Drawable getDrawable(int resId) {
        return BNStyleManager.getDrawable(resId, this.mIsCurDay);
    }

    protected int getColor(int resId) {
        return BNStyleManager.getColor(resId, this.mIsCurDay);
    }

    protected void startAutoHide(int delayTimes) {
        BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mAutoHideRunnable, new BNWorkerConfig(2, 0), (long) delayTimes);
    }

    protected void cancelAutoHide() {
        BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
    }

    protected void hiedByTimeOut() {
    }
}
