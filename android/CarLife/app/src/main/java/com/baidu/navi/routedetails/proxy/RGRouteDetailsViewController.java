package com.baidu.navi.routedetails.proxy;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.routedetails.proxy.BNRouteDetail.BNRouteDetailNavListener;

public class RGRouteDetailsViewController {
    private static RGRouteDetailsViewController sInstance;
    private Activity mActivity;
    private Context mContext;
    private boolean mIsRouteDetail;
    private ViewGroup mParentView;
    private RouteDetailMapView mRouteDetailMapView;

    private RGRouteDetailsViewController() {
    }

    public boolean isRouteDetail() {
        return this.mIsRouteDetail;
    }

    public void setIsRouteDetail(boolean mIsRouteDetail) {
        this.mIsRouteDetail = mIsRouteDetail;
    }

    public static RGRouteDetailsViewController getInstance() {
        if (sInstance == null) {
            synchronized (RGRouteDetailsViewController.class) {
                if (sInstance == null) {
                    sInstance = new RGRouteDetailsViewController();
                }
            }
        }
        return sInstance;
    }

    public void initView(Activity activity, ViewGroup viewGroup, C1277e listener) {
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        this.mParentView = viewGroup;
        setIsRouteDetail(true);
        this.mRouteDetailMapView = new RouteDetailMapView(this.mActivity, this.mParentView, listener);
    }

    public void onResume() {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.onResume();
        }
    }

    public void onPause() {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.onPause();
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.onUpdateStyle(dayStyle);
        }
    }

    public void onUpdateOrientation(int orientation) {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.onUpdateOrientation(orientation);
        }
    }

    public void onDestory() {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.onDestory();
        }
        setIsRouteDetail(false);
        this.mActivity = null;
    }

    public boolean onBackPressed() {
        if (this.mRouteDetailMapView != null) {
            return this.mRouteDetailMapView.onBackPressed();
        }
        return false;
    }

    public void setNaviListener(BNRouteDetailNavListener listener) {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.setNaviListener(listener);
        }
    }

    public void cancleCountDownTask() {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.cancleCountDownTask();
        }
    }

    public void initFocus(C1443g leftArea, C1443g rightArea, boolean isReSet) {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.initFocus(leftArea, rightArea, isReSet);
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (this.mRouteDetailMapView != null) {
            this.mRouteDetailMapView.onVoiceCommand(type, subType, arg1, arg2, needResponse);
        }
        return false;
    }
}
