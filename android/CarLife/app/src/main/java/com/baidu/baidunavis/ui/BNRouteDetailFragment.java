package com.baidu.baidunavis.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.wrapper.BNRouteDetailActivityWrapper;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.routedetails.proxy.BNRouteDetail;

public class BNRouteDetailFragment extends ContentFragment {
    public static final String BACK_FROM_ANOLOG_NAVI = "BACK_FROM_ANOLOG_NAVI";
    private BNRouteDetailActivityWrapper mBnRouteDetailActivityWrapper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseFragment.mResumeMapView = true;
        if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {
            NavMapAdapter.getInstance().navigateTo(C1157a.m3876a(), NavMapAdapter.getInstance().getMapFramePageClassName());
        } else if (this.mBnRouteDetailActivityWrapper == null) {
            this.mBnRouteDetailActivityWrapper = new BNRouteDetailActivityWrapper(this);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (NavMapManager.getInstance().getNaviMapMode() == 5) {
            NavMapManager.getInstance().showCarResultLayer(true);
        } else {
            C0705a.m2962a().m2979d();
            C0705a.m2962a().m2970a(false, null);
        }
        NavMapManager.getInstance().set3DGestureEnable(false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        if (!NavMapAdapter.getInstance().isNaviInjectSuccess() || this.mBnRouteDetailActivityWrapper == null) {
            return null;
        }
        return this.mBnRouteDetailActivityWrapper.onCreateContentView(this);
    }

    public boolean isMapPage() {
        return true;
    }

    protected void onInitView() {
    }

    public void onResume() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && this.mBnRouteDetailActivityWrapper != null) {
            this.mBnRouteDetailActivityWrapper.onResume();
        }
        if (C1663a.m5979a().m5993N()) {
            C1915a.m7321a().m7327a(true);
        } else {
            C1915a.m7321a().m7327a(false);
        }
        super.onResume();
    }

    public void onPause() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && this.mBnRouteDetailActivityWrapper != null) {
            this.mBnRouteDetailActivityWrapper.onPause();
        }
        super.onPause();
    }

    public void onDestroy() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && this.mBnRouteDetailActivityWrapper != null) {
            this.mBnRouteDetailActivityWrapper.onDestroy();
        }
        super.onDestroy();
    }

    public void driving() {
        if (!C1343b.m4932a().m4935b()) {
            backTo(17, null);
            C1342a.m4926a().m4931d();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && this.mBnRouteDetailActivityWrapper != null) {
            this.mBnRouteDetailActivityWrapper.onConfigurationChanged(newConfig);
        }
        super.onConfigurationChanged(newConfig);
    }

    public boolean onBackPressed() {
        if (!NavMapAdapter.getInstance().isNaviInjectSuccess() || this.mBnRouteDetailActivityWrapper == null) {
            super.onBackPressed();
        } else if (!this.mBnRouteDetailActivityWrapper.onBackPressed()) {
            super.onBackPressed();
        }
        return true;
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onHiddenChanged(boolean hidden) {
        BNRouteDetail.getInstance().cancleCountDownTask();
        super.onHiddenChanged(hidden);
    }

    public void onInitFocusAreas() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && this.mBnRouteDetailActivityWrapper != null) {
            this.mBnRouteDetailActivityWrapper.onInitFocus();
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (type == 2 && subType == 38) {
            back();
            return true;
        } else if (this.mBnRouteDetailActivityWrapper != null) {
            return this.mBnRouteDetailActivityWrapper.onVoiceCommand(type, subType, arg1, arg2, needResponse);
        } else {
            return false;
        }
    }
}
