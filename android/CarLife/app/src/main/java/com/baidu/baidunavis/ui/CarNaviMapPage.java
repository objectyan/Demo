package com.baidu.baidunavis.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.drivertool.BNAttachmentManager;
import com.baidu.navisdk.util.drivertool.BNTakePhotoManager;

public abstract class CarNaviMapPage extends ContentFragment {
    private static final String TAG = "Framework";

    public abstract String getPageClsName();

    public abstract int getPageType();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onAttach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseFragment.mResumeMapView = true;
        if (BaiduNaviManager.isNaviSoLoadSuccess() && BaiduNaviManager.sIsBaseEngineInitialized) {
            NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onCreate");
            if (BNRouteGuideFragment.isStopedByWatch) {
                if (SystemClock.elapsedRealtime() - BNRouteGuideFragment.sWatchEixtTime <= 1500) {
                    goBack();
                    return;
                }
                return;
            }
            return;
        }
        back();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onCreateView");
        NavFragmentManager.getInstance().setLastPageType(getPageType());
        NavMapManager.getInstance().addNaviMapListener();
        NavMapManager.getInstance().handleMapThemeAndScene(getPageType());
        NavMapManager.getInstance().set3DGestureEnable(is3DGestureEnable());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onViewCreated");
    }

    public void onStart() {
        super.onStart();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onStart");
    }

    public void onResume() {
        super.onResume();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onResume");
    }

    public void onPause() {
        super.onPause();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onPause");
    }

    public void onStop() {
        super.onStop();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onDestroyView");
        NavMapManager.getInstance().removeNaviMapListener();
        NavMapManager.getInstance().handleMapThemeAndScene(0);
        NavMapManager.getInstance().set3DGestureEnable(GlobalConfig.getInstance().isOpen3D());
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onDestroyView end");
    }

    public void onDestroy() {
        super.onDestroy();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onDetach");
    }

    public void goBack() {
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> goBack");
        NavFragmentManager.getInstance().back(null, forceResetModeWhenBack());
        back();
    }

    public boolean onBackPressed() {
        NavLogUtils.m3003e("Framework", getPageClsName() + ": --> onBackPressed");
        goBack();
        return true;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (!BaiduNaviManager.isNaviSoLoadSuccess() || !BaiduNaviManager.sIsBaseEngineInitialized) {
            super.onConfigurationChanged(newConfig);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        NavLogUtils.m3003e("Framework", getPageClsName() + ": resultCode --> " + resultCode);
        BNavigator.getInstance().onActivityResult(requestCode, resultCode, data);
        if (requestCode == 256 && resultCode == -1) {
            BNTakePhotoManager.getInstance().onPhotoTakeActionFinish((Bitmap) data.getExtras().get("data"), new Object());
        } else if (requestCode == 257 && resultCode == -1) {
            BNAttachmentManager.getInstance().onSelectPictureFinish(data);
        }
    }

    private String getClassName() {
        try {
            String name = getClass().getName();
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Throwable th) {
            return "Crash";
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        return null;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public boolean isMapPage() {
        return true;
    }

    public boolean forbidsConfigurationChange() {
        return true;
    }

    public boolean is3DGestureEnable() {
        return false;
    }

    public boolean forceResetModeWhenBack() {
        return false;
    }
}
