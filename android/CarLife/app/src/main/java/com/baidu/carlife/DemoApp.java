package com.baidu.carlife;

import android.app.Application;
import android.content.Context;
import android.support.multidex.C0047b;
import com.baidu.carlife.core.C1157a;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comjni.engine.NAEngine;

public class DemoApp extends Application {
    /* renamed from: a */
    private static Application f2397a = null;

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        C0047b.m139a((Context) this);
        C2911f.m11011a(true);
        C2907c.m10972b(this);
        C2907c.m10970a(this);
    }

    public void onCreate() {
        super.onCreate();
        f2397a = this;
        C1157a.m3877a(this);
        C2907c.m10974c();
        StorageSettings.getInstance().initialize(this);
        C2907c.m10975d();
        NAEngine.startSocketProc();
        BNSettingManager.init(this);
        BNSettingManager.setShowJavaLog(true);
        BNSettingManager.setShowNativeLog(true);
        MapViewFactory.getInstance().preCreateMapViewInstance();
        BNSysLocationManager.getInstance().init(this);
        BNSysLocationManager.getInstance().startNaviLocate(this);
    }

    /* renamed from: a */
    public static Application m3126a() {
        return f2397a;
    }
}
