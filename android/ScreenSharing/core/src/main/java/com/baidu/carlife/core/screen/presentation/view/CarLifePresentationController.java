package com.baidu.carlife.core.screen.presentation.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnStatusChangeListener;
import com.baidu.carlife.core.screen.OnSurfaceListener;
import com.baidu.carlife.core.screen.OnServiceDiedListener;
import com.baidu.carlife.core.screen.operation.CarlifeTouchManager;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService;
import com.baidu.carlife.core.screen.presentation.CarlifeServiceConnection;
import com.baidu.carlife.core.screen.presentation.DisplaySpec;
import com.baidu.carlife.core.screen.video.Recorder;

/* compiled from: CarLifePresentationController */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.b */
public class CarLifePresentationController implements OnStatusChangeListener, OnSurfaceListener, OnServiceDiedListener {
    /* renamed from: a */
    public static final String Tag = CarLifePresentationController.class.getSimpleName();
    /* renamed from: b */
    private static CarLifePresentationController sCarLifePresentationController;
    /* renamed from: c */
    private CarlifeMaskView mCarlifeMaskView;
    /* renamed from: d */
    private View mView;
    /* renamed from: e */
    private Drawable mMaskDrawable;
    /* renamed from: f */
    private int mLaunchIconId;
    /* renamed from: g */
    private Activity mActivity;
    /* renamed from: h */
    private CarlifeServiceConnection mCarlifeServiceConnection;
    /* renamed from: i */
    private Class mAbsCarlifeActivityServiceClass = AbsCarlifeActivityService.class;
    /* renamed from: j */
    private OnStatusChangeListener mOnStatusChangeListener;

    private CarLifePresentationController() {
    }

    /* renamed from: b */
    public static CarLifePresentationController newInstance() {
        if (sCarLifePresentationController == null) {
            sCarLifePresentationController = new CarLifePresentationController();
        }
        return sCarLifePresentationController;
    }

    /* renamed from: a */
    public void m4630a(Activity activity, Class serviceClass, OnStatusChangeListener listener) {
        this.mActivity = activity;
        this.mOnStatusChangeListener = listener;
        if (serviceClass != null) {
            this.mAbsCarlifeActivityServiceClass = serviceClass;
        } else {
            this.mAbsCarlifeActivityServiceClass = AbsCarlifeActivityService.class;
        }
        Recorder.newInstance().m4857a((OnStatusChangeListener) this);
    }

    /* renamed from: c */
    public void clearAll() {
        this.mCarlifeMaskView = null;
        this.mView = null;
        this.mActivity = null;
        this.mCarlifeServiceConnection = null;
        this.mOnStatusChangeListener = null;
        this.mMaskDrawable = null;
    }

    /* renamed from: d */
    public CarlifeMaskView getCarlifeMaskView() {
        return this.mCarlifeMaskView;
    }

    /* renamed from: e */
    public View getView() {
        return this.mView;
    }

    /* renamed from: f */
    public Drawable getMaskDrawable() {
        return this.mMaskDrawable;
    }

    /* renamed from: a */
    public void setMaskDrawable(Drawable maskDrawable) {
        this.mMaskDrawable = maskDrawable;
    }

    /* renamed from: a */
    public void setLaunchIconId(int launchIconId) {
        this.mLaunchIconId = launchIconId;
    }

    /* renamed from: g */
    public int getLaunchIconId() {
        return this.mLaunchIconId;
    }

    /* renamed from: h */
    public CarlifeServiceConnection getServiceConn() {
        return this.mCarlifeServiceConnection;
    }

    /* renamed from: a */
    public void switchCarLifeViewAndMaskView(Activity activity, boolean isConnect) {
        LogUtil.d(Tag, "switchCarLifeViewAndMaskView isConnect=" + isConnect);
        if (activity != null) {
            if (!isConnect && this.mView != null) {
                if (this.mView.getParent() != null) {
                    ((ViewGroup) this.mView.getParent()).removeView(this.mView);
                    ((ViewGroup) activity.getWindow().getDecorView()).removeAllViews();
                }
                ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mView);
                if (this.mCarlifeMaskView != null && this.mCarlifeMaskView.getFrameLayout() != null && this.mCarlifeMaskView.getFrameLayout().getParent() != null) {
                    ((ViewGroup) this.mCarlifeMaskView.getFrameLayout().getParent()).removeView(this.mCarlifeMaskView.getFrameLayout());
                }
            } else if (isConnect) {
                this.mView = ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0);
                if (this.mView == null) {
                    LogUtil.e(Tag, "getDecorView.getChildAt(0) is null");
                    return;
                }
                if (this.mCarlifeMaskView == null) {
                    this.mCarlifeMaskView = new CarlifeMaskView(this);
                } else {
                    this.mCarlifeMaskView.bindServiceForDisplaySpec();
                }
                ViewParent parent = this.mView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.mView);
                    ((ViewGroup) parent).removeAllViews();
                    ((ViewGroup) parent).invalidate();
                }
                ViewParent maskViewParent = this.mCarlifeMaskView.getFrameLayout().getParent();
                if (maskViewParent != null && (maskViewParent instanceof ViewGroup)) {
                    ((ViewGroup) maskViewParent).removeView(this.mCarlifeMaskView.getFrameLayout());
                }
                FrameLayout frameLayout = new FrameLayout(activity);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                frameLayout.addView(this.mView, layoutParams);
                frameLayout.addView(this.mCarlifeMaskView.getFrameLayout(), layoutParams);
                ((ViewGroup) parent).addView(frameLayout);
                ((ViewGroup) parent).invalidate();
                frameLayout.invalidate();
            }
        }
    }

    /* renamed from: a */
    private void bindService(Context activityContext, DisplaySpec spec) {
        Intent intent = new Intent(activityContext, this.mAbsCarlifeActivityServiceClass);
        activityContext.startService(intent);
        this.mCarlifeServiceConnection = new CarlifeServiceConnection(this.mActivity, this, spec, this.mAbsCarlifeActivityServiceClass);
        activityContext.bindService(intent, this.mCarlifeServiceConnection, Context.BIND_IMPORTANT);
    }

    /* renamed from: a */
    public void bindServiceForDisplaySpec(DisplaySpec spec) {
        if (this.mActivity != null) {
            bindService(this.mActivity, spec);
        }
    }

    /* renamed from: o */
    public void onVehicleConnected() {
        LogUtil.d(Tag, "onVehicleConnected");
        switchCarLifeViewAndMaskView(this.mActivity, true);
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.onVehicleConnected();
        }
    }

    /* renamed from: p */
    public void onVehicleDisconnect() {
        LogUtil.d(Tag, "onVehicleDisconnect");
        if (this.mCarlifeServiceConnection != null) {
            this.mCarlifeServiceConnection.m4755b();
            this.mCarlifeServiceConnection.unBindService();
        }
        switchCarLifeViewAndMaskView(this.mActivity, false);
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.onVehicleDisconnect();
        }
    }

    /* renamed from: a */
    public void startActivity(Intent intent, int requestCode) {
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.startActivity(intent, requestCode);
        } else if (this.mActivity != null) {
            this.mActivity.startActivityForResult(intent, requestCode);
        }
    }

    /* renamed from: q */
    public boolean mo1356q() {
        if (this.mOnStatusChangeListener != null) {
            return this.mOnStatusChangeListener.mo1356q();
        }
        return false;
    }

    /* renamed from: a */
    public void mo1346a(int width, int height) {
        CarlifeTouchManager.newInstance().m4534a(width);
        CarlifeTouchManager.newInstance().m4542b(height);
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.mo1346a(width, height);
        }
    }

    /* renamed from: a */
    public void mo1463a() {
        if (this.mCarlifeMaskView != null) {
            this.mCarlifeMaskView.bindServiceForDisplaySpec();
        }
    }
}
