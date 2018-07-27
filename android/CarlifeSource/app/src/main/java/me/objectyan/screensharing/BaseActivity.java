package com.baidu.carlife;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import com.baidu.android.common.util.CommonParam;
import com.baidu.carlife.core.LogUtil;
import com.baidu.mobstat.StatService;
import com.baidu.navi.ActivityStack;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.PackageUtil;
import java.util.List;

public class BaseActivity extends FragmentActivity {
    /* renamed from: a */
    public static String f2326a = "BaseActivity";
    /* renamed from: b */
    public boolean f2327b = true;

    protected void onCreate(Bundle savedInstanceState) {
        ActivityStack.addActivity(this);
        super.onCreate(savedInstanceState);
        LogUtil.m4429a(f2326a, "Time test:Start in BaseActivity 0 ");
        StatService.setAppChannel(getApplicationContext(), PackageUtil.getChannel(), true);
        LogUtil.m4429a(f2326a, "Time test:Start in BaseActivity 1 ");
        String cuid = CommonParam.getCUID(getApplicationContext());
        PackageUtil.setCuid(cuid);
        LogUtil.m4429a(f2326a, "cuid = " + cuid);
        LogUtil.m4429a(f2326a, "Time test:Start in BaseActivity 2");
        Display display = getWindowManager().getDefaultDisplay();
        if (VERSION.SDK_INT >= 8) {
            MainMapModel.getInstance().mScreenRotation = display.getRotation() * 90;
            return;
        }
        MainMapModel.getInstance().mScreenRotation = display.getOrientation() * 90;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityStack.removeActivity(this);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Display display = getWindowManager().getDefaultDisplay();
        if (VERSION.SDK_INT >= 8) {
            MainMapModel.getInstance().mScreenRotation = display.getRotation() * 90;
            return;
        }
        MainMapModel.getInstance().mScreenRotation = display.getOrientation() * 90;
    }

    /* renamed from: a */
    public boolean m3013a() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        String packageName = getApplicationContext().getPackageName();
        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName) && appProcess.importance == 100) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m3014b() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        String packageName = getApplicationContext().getPackageName();
        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName) && appProcess.importance == 400) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public String m3012a(Context context) {
        List<RunningTaskInfo> runningTaskInfos = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningTasks(1);
        if (runningTaskInfos != null) {
            return ((RunningTaskInfo) runningTaskInfos.get(0)).topActivity.getClassName();
        }
        return null;
    }
}
