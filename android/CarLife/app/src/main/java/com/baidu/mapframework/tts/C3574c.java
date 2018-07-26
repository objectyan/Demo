package com.baidu.mapframework.tts;

import android.content.Context;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.File;

/* compiled from: TTSManager */
/* renamed from: com.baidu.mapframework.tts.c */
public class C3574c {
    /* renamed from: a */
    public static void m15234a(final Context context) {
        final String sdcardAPPPath = StorageSettings.getInstance().getCurrentStorage().getDataPath() + File.separator + "bnav";
        ConcurrentManager.executeTask(Module.VOICE_MODULE, new ConcurrentTask() {
            public void run() {
                BaseTTSPlayer.loadTTSSO();
                BaseTTSPlayer.getInstance().initPlayer(context, sdcardAPPPath);
            }
        }, ScheduleConfig.forData());
    }
}
