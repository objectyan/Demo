package com.baidu.carlife.p052m;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.carlife.core.AppContext;
import com.baidu.platform.basic.BMExecutorsManager;
import java.io.File;

/* compiled from: TTSManager */
/* renamed from: com.baidu.carlife.m.b */
public class C1917b {
    /* renamed from: a */
    public static void m7339a() {
        final String sdcardAPPPath = NavMapAdapter.getInstance().getDataPath() + File.separator + "bnav";
        BMExecutorsManager.CACHED_EXECUTOR_SERVICE.execute(new Runnable() {
            public void run() {
                BaseTTSPlayer.loadTTSSO();
                BaseTTSPlayer.getInstance().initPlayer(AppContext.m3876a(), sdcardAPPPath);
            }
        });
    }
}
