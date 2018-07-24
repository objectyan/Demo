package com.baidu.carlife;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.support.multidex.C0047b;

import com.baidu.baidunavis.NavMapAdapter;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.util.C2191s;

import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.commonlib.utils.ProcessUtil;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.AssetsDexInjectHelper;
import com.baidu.navi.ForegroundService;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comjni.engine.NAEngine;

import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;

public class BaiduNaviApplication extends Application implements UncaughtExceptionHandler {
    private static final String TAG = "BaiduNaviApplication";
    private static BaiduNaviApplication mInstance = null;

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        C0047b.m139a((Context) this);
        C2907c.m10972b(this);
        C2907c.m10970a(this);
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG, "onCreate");
        mInstance = this;
        AppContext.m3877a(this);
        C2907c.m10974c();
        StorageSettings.getInstance().initialize(this);
        C2907c.m10975d();
        NAEngine.startSocketProc();
        BNSettingManager.init(this);
        if (ProcessUtil.isMainProcess(this)) {
            MapViewFactory.getInstance().preCreateMapViewInstance();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        C2191s.f7018l = System.currentTimeMillis();
        GlobalConfig.getInstance().setmOpen3D(Boolean.valueOf(false));
        GlobalConfig.getInstance().setOpenOverlook(Boolean.valueOf(false));
    }

    public static BaiduNaviApplication getInstance() {
        return mInstance;
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    public void onTerminate() {
        super.onTerminate();
    }

    public void uncaughtException(Thread arg0, Throwable arg1) {
        LogUtil.m4439b(arg1);
        for (WeakReference<Activity> weakReference : ActivityStack.getActivityStack()) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                activity.moveTaskToBack(true);
            }
        }
        ForegroundService.stop(getApplicationContext());
        exitApp(true);
    }

    public void exitApp(boolean needRelease) {
        if (needRelease) {
            relaseBeforeExit();
            killProccess();
        } else {
            killProccess();
        }
        mInstance = null;
        DBManager.destroy();
        FavoritePois.destroyPoiFav();
    }

    public void relaseBeforeExit() {
        LogUtil.d("jason", "releaseBeforeExit after engine init success");
        if (AssetsDexInjectHelper.getInstance().isNaviInjectSuccess()) {
            NavMapAdapter.destroy();
        }
        C2907c.m10976e();
        AudioUtils.unInit();
    }

    public void killProccess() {
        LogUtil.d("jason", "killProcess");
        VDeviceAPI.setScreenAlwaysOn(false);
        Process.killProcess(Process.myPid());
    }
}
