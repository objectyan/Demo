package com.baidu.navisdk.ui.routeguide.control;

import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.statistic.CpuStat;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.NaviMergeStatItem;
import com.baidu.navisdk.util.statistic.NaviStatItem;

public class RouteGuideAsyncEventManager extends Callback {
    private static RouteGuideAsyncEventManager sInstance = null;

    private RouteGuideAsyncEventManager() {
    }

    public static void init() {
        if (sInstance == null) {
            synchronized (RouteGuideAsyncEventManager.class) {
                if (sInstance == null) {
                    sInstance = new RouteGuideAsyncEventManager();
                }
                CommonHandlerThread.getInstance().registerCallback(sInstance);
            }
        }
    }

    public static void uninit() {
        if (sInstance != null) {
            CommonHandlerThread.getInstance().unregisterCallback(sInstance);
        }
        sInstance = null;
    }

    public void careAbouts() {
        careAbout(100);
        careAbout(101);
        careAbout(200);
        careAbout(201);
        careAbout(30);
        careAbout(31);
        careAbout(250);
        careAbout(302);
    }

    public void execute(Message message) {
        switch (message.what) {
            case 30:
                CpuStat.getInstance().startProfile();
                return;
            case 31:
                CpuStat.getInstance().endProfile();
                return;
            case 100:
                NaviStatItem.getInstance().startStat();
                return;
            case 101:
                NaviStatItem.getInstance().onEvent();
                return;
            case 200:
                NaviIPOStatItem.getInstance().startStat();
                return;
            case 201:
                NaviIPOStatItem.getInstance().onEvent();
                return;
            case 250:
                NaviMergeStatItem.getInstance().onEvent();
                return;
            case 302:
                BNRecoverNaviHelper.getInstance().setKilledTime(BNaviModuleManager.getContext().getApplicationContext(), System.currentTimeMillis() / 1000);
                CommonHandlerThread.getInstance().sendMessage(302, 0, 0, null, 60000);
                return;
            default:
                return;
        }
    }

    public String getName() {
        return "RouteGuideAsyncEventManager";
    }
}
