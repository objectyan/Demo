package com.baidu.baidunavis.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.carlife.core.screen.presentation.C1328h;
import java.util.HashMap;

public class NavFragmentManager {
    private static final String TAG = "Framework";
    public static final int TYPE_CRUISE = 3;
    public static final int TYPE_LIGHT_NAVI = 2;
    public static final int TYPE_NAVI_RESULT = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_ROUTE_GUIDE = 1;
    public static final int TYPE_ROUTE_REPORT = 6;
    public static final int TYPE_SELECT_POINT = 5;
    private int mLastPageType;
    private HashMap<String, Integer> mPageNameTypeMap;

    private static class LazyLoader {
        private static final NavFragmentManager sInstance = new NavFragmentManager();

        private LazyLoader() {
        }
    }

    private NavFragmentManager() {
        this.mLastPageType = 0;
        this.mPageNameTypeMap = null;
    }

    public static NavFragmentManager getInstance() {
        return LazyLoader.sInstance;
    }

    public int getCarNaviPageType(String pageName) {
        if (pageName == null) {
            return 0;
        }
        if (this.mPageNameTypeMap == null) {
            this.mPageNameTypeMap = new HashMap();
            this.mPageNameTypeMap.put(BNRouteGuideFragment.class.getName(), Integer.valueOf(1));
            this.mPageNameTypeMap.put(BNCruiserFragment.class.getName(), Integer.valueOf(3));
        }
        Integer ret = (Integer) this.mPageNameTypeMap.get(pageName);
        if (ret != null) {
            return ret.intValue();
        }
        return 0;
    }

    private CarNaviMapPage getPageInstance(int pageType) {
        switch (pageType) {
            case 1:
                return new BNRouteGuideFragment();
            case 3:
                return new BNCruiserFragment();
            default:
                return null;
        }
    }

    private boolean isPageUsesNaviMapMode(String pageClsName) {
        return true;
    }

    private boolean justRemovePageWhenBack(String pageClsName) {
        if (getPageInstance(getCarNaviPageType(pageClsName)) == null) {
            return false;
        }
        return true;
    }

    public void removeNaviPage(String pageName) {
        if (!TextUtils.isEmpty(pageName)) {
            NavLogUtils.m3003e("Framework", "removeNaviPage: --> " + pageName);
        }
    }

    public void back(Bundle backBundle, boolean forceResetMode) {
        NavLogUtils.m3003e("Framework", "back: forceResetMode --> " + forceResetMode);
        if (forceResetMode || !lastPageUsesNaviMapMode()) {
            NavMapManager.getInstance().removeNaviMapListener();
            NavMapManager.getInstance().handleMapThemeAndScene(0);
        }
    }

    public void backToPage(String pageName, Bundle backBundle) {
        if (pageName != null) {
            NavLogUtils.m3003e("Framework", "backToPage: --> " + pageName);
        }
    }

    public void finishCarNaviPages(Bundle backBundle) {
        NavLogUtils.m3003e("Framework", "finishCarNaviPages: --> ");
        C1328h.m4757a().backTo(17, null);
    }

    public void showNavMapMapPage(String mapPageClsName, Bundle data) {
        NavLogUtils.m3003e("Framework", "showNavMapMapPage: mapPageClsName --> " + mapPageClsName);
        Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (mapPageClsName != null && activity != null) {
            NavMapAdapter.getInstance().navigateTo(activity, mapPageClsName, data);
        }
    }

    public boolean lastPageUsesNaviMapMode() {
        NavLogUtils.m3003e("Framework", "lastPageUsesNaviMapMode: --> " + false);
        return false;
    }

    private void logHistoryRecord() {
    }

    public void destroy() {
        NavLogUtils.m3003e("Framework", "destroy: --> ");
        NavMapManager.getInstance().unInit();
    }

    public int getLastPageType() {
        return this.mLastPageType;
    }

    public void setLastPageType(int pageType) {
        this.mLastPageType = pageType;
    }
}
