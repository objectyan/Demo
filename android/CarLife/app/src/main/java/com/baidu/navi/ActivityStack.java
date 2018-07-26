package com.baidu.navi;

import android.app.Activity;
import android.os.Message;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1308f;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.view.C2252a;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.view.DownNotifManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ActivityStack {
    private static List<WeakReference<Activity>> listActivities = new ArrayList();

    public static final void addActivity(Activity activity) {
        listActivities.add(new WeakReference(activity));
    }

    public static final void removeActivity(Activity activity) {
        for (WeakReference<Activity> weakReference : listActivities) {
            if (weakReference.get() == activity) {
                listActivities.remove(weakReference);
                return;
            }
        }
    }

    public static final List<WeakReference<Activity>> getActivityStack() {
        return listActivities;
    }

    public static void finish() {
        for (WeakReference<Activity> weakReference : listActivities) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static void exitApp(boolean afterEgineInit) {
        if (C1663a.m5979a().m5993N()) {
            C1212c command = new C1212c(true);
            command.m4201c(C1253f.bf);
            C1663a.m5979a().m6017a(Message.obtain(null, command.m4202d(), 1001, 0, command));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (afterEgineInit) {
            BNVoiceCommandController.getInstance().setAPPVoiceFuncCallback(null);
            BNMapController.getInstance().SaveCache();
            DownNotifManager.getInstance(C1157a.m3876a()).clearAllNotifs();
            finish();
        } else {
            finish();
        }
        C1663a.m5979a().m5997R();
    }

    public static void handleAppBackPressed() {
        C1308f carlifeView = C1309g.m4699a().m4701b();
        if (carlifeView.isWindowViewShown()) {
            carlifeView.hideWindowView();
        } else if (carlifeView.isDialogShown()) {
            carlifeView.cancelDialog();
        } else if (C2252a.m8531a().m8564b()) {
            C2252a.m8531a().m8567d();
        } else {
            C1328h fragmentManagerCallbackProxy = C1328h.m4757a();
            ContentFragment fragment = fragmentManagerCallbackProxy.getCurrentFragment();
            if ((fragment == null || !fragment.onBackPressed()) && fragmentManagerCallbackProxy.m4776h() > 0) {
                fragmentManagerCallbackProxy.back(null);
            }
        }
    }
}
