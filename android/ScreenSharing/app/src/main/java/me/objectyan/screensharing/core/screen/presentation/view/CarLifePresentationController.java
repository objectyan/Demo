package me.objectyan.screensharing.core.screen.presentation.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import me.objectyan.screensharing.core.screen.OnServiceDiedListener;
import me.objectyan.screensharing.core.screen.OnStatusChangeListener;
import me.objectyan.screensharing.core.screen.OnSurfaceListener;
import me.objectyan.screensharing.core.screen.operation.CarlifeTouchManager;
import me.objectyan.screensharing.core.screen.presentation.AbsCarlifeActivityService;
import me.objectyan.screensharing.core.screen.presentation.CarlifeServiceConnection;
import me.objectyan.screensharing.core.screen.presentation.DisplaySpec;
import me.objectyan.screensharing.core.screen.video.Recorder;


public class CarLifePresentationController implements OnStatusChangeListener, OnSurfaceListener, OnServiceDiedListener {

    public static final String Tag = CarLifePresentationController.class.getSimpleName();

    private static CarLifePresentationController sCarLifePresentationController;

    private CarlifeMaskView mCarlifeMaskView;

    private View mView;

    private Drawable mMaskDrawable;

    private int mLaunchIconId;

    private Activity mActivity;

    private CarlifeServiceConnection mCarlifeServiceConnection;

    private Class mAbsCarlifeActivityServiceClass = AbsCarlifeActivityService.class;

    private OnStatusChangeListener mOnStatusChangeListener;

    private CarLifePresentationController() {
    }


    public static CarLifePresentationController newInstance() {
        if (sCarLifePresentationController == null) {
            sCarLifePresentationController = new CarLifePresentationController();
        }
        return sCarLifePresentationController;
    }


    public void init(Activity activity, Class serviceClass, OnStatusChangeListener listener) {
        this.mActivity = activity;
        this.mOnStatusChangeListener = listener;
        if (serviceClass != null) {
            this.mAbsCarlifeActivityServiceClass = serviceClass;
        } else {
            this.mAbsCarlifeActivityServiceClass = AbsCarlifeActivityService.class;
        }
        Recorder.newInstance().setStatusListener((OnStatusChangeListener) this);
    }


    public void clearAll() {
        this.mCarlifeMaskView = null;
        this.mView = null;
        this.mActivity = null;
        this.mCarlifeServiceConnection = null;
        this.mOnStatusChangeListener = null;
        this.mMaskDrawable = null;
    }


    public CarlifeMaskView getCarlifeMaskView() {
        return this.mCarlifeMaskView;
    }


    public View getView() {
        return this.mView;
    }


    public Drawable getMaskDrawable() {
        return this.mMaskDrawable;
    }


    public void setMaskDrawable(Drawable maskDrawable) {
        this.mMaskDrawable = maskDrawable;
    }


    public void setLaunchIconId(int launchIconId) {
        this.mLaunchIconId = launchIconId;
    }


    public int getLaunchIconId() {
        return this.mLaunchIconId;
    }


    public CarlifeServiceConnection getServiceConn() {
        return this.mCarlifeServiceConnection;
    }


    public void switchCarLifeViewAndMaskView(Activity activity, boolean isConnect) {
        Log.d(Tag, "switchCarLifeViewAndMaskView isConnect=" + isConnect);
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
                    Log.e(Tag, "getDecorView.getChildAt(0) is null");
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


    private void bindService(Context activityContext, DisplaySpec spec) {
        Intent intent = new Intent(activityContext, this.mAbsCarlifeActivityServiceClass);
        activityContext.startService(intent);
        this.mCarlifeServiceConnection = new CarlifeServiceConnection(this.mActivity, this, spec, this.mAbsCarlifeActivityServiceClass);
        activityContext.bindService(intent, this.mCarlifeServiceConnection, Context.BIND_IMPORTANT);
    }


    public void bindServiceForDisplaySpec(DisplaySpec spec) {
        if (this.mActivity != null) {
            bindService(this.mActivity, spec);
        }
    }


    public void onVehicleConnected() {
        Log.d(Tag, "onVehicleConnected");
        switchCarLifeViewAndMaskView(this.mActivity, true);
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.onVehicleConnected();
        }
    }


    public void onVehicleDisconnect() {
        Log.d(Tag, "onVehicleDisconnect");
        if (this.mCarlifeServiceConnection != null) {
            this.mCarlifeServiceConnection.m4755b();
            this.mCarlifeServiceConnection.unBindService();
        }
        switchCarLifeViewAndMaskView(this.mActivity, false);
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.onVehicleDisconnect();
        }
    }


    public void startActivity(Intent intent, int requestCode) {
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.startActivity(intent, requestCode);
        } else if (this.mActivity != null) {
            this.mActivity.startActivityForResult(intent, requestCode);
        }
    }


    public boolean mo1356q() {
        if (this.mOnStatusChangeListener != null) {
            return this.mOnStatusChangeListener.mo1356q();
        }
        return false;
    }


    public void mo1346a(int width, int height) {
        CarlifeTouchManager.newInstance().getWidth(width);
        CarlifeTouchManager.newInstance().setHeight(height);
        if (this.mOnStatusChangeListener != null) {
            this.mOnStatusChangeListener.mo1346a(width, height);
        }
    }


    public void mo1463a() {
        if (this.mCarlifeMaskView != null) {
            this.mCarlifeMaskView.bindServiceForDisplaySpec();
        }
    }
}
