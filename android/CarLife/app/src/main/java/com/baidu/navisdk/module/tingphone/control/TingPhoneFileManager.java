package com.baidu.navisdk.module.tingphone.control;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.io.File;

public class TingPhoneFileManager {
    public static final String TAG = TingPhoneFileManager.class.getSimpleName();

    /* renamed from: com.baidu.navisdk.module.tingphone.control.TingPhoneFileManager$1 */
    static class C41871 extends Callback {
        C41871() {
        }

        public void execute(Message message) {
            if (message.what == 20) {
                try {
                    TingPhoneFileManager.cleanSDCard();
                    TingPhoneFileManager.cleanModulePath();
                } catch (Throwable th) {
                }
            }
        }

        public void careAbouts() {
            careAbout(20);
        }

        public String getName() {
            return "TingPhone";
        }
    }

    public static void cleanPathFileAndConfig() {
        CommonHandlerThread.getInstance().registerCallback(new C41871());
        CommonHandlerThread.getInstance().sendMessage(20, 0, 0, null, 3000);
    }

    private static boolean cleanSDCard() {
        String path = getSDCardFirstDirPath();
        LogUtil.m15791e(TAG, "sdcard path = " + path);
        if (TextUtils.isEmpty(path)) {
            LogUtil.m15791e(TAG, "sdcard path is null or empty");
            return false;
        }
        File dir = new File(path);
        if (dir != null && dir.exists()) {
            return deleteDir(dir);
        }
        LogUtil.m15791e(TAG, "sdcard tingphone floder no exist");
        return false;
    }

    private static boolean cleanModulePath() {
        String path = getModuleFilePath();
        LogUtil.m15791e(TAG, "module path = " + path);
        if (TextUtils.isEmpty(path)) {
            LogUtil.m15791e(TAG, "module path is null or empty");
            return false;
        }
        File dir = new File(path);
        if (dir != null && dir.exists()) {
            return deleteDir(dir);
        }
        LogUtil.m15791e(TAG, "module path tingphone floder no exist");
        return false;
    }

    private static boolean deleteDir(File dir) {
        if (dir == null) {
            return false;
        }
        if (dir.isDirectory()) {
            String[] child = dir.list();
            if (child == null) {
                return false;
            }
            for (String file : child) {
                if (!deleteDir(new File(dir, file))) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    private static String getSDCardFirstDirPath() {
        String sdCardDir = SysOSAPI.getInstance().GetSDCardPath();
        if (TextUtils.isEmpty(sdCardDir)) {
            return null;
        }
        return sdCardDir + File.separator + "tingphone";
    }

    private static String getModuleFilePath() {
        Context cnt = BNaviModuleManager.getContext();
        if (cnt == null) {
            return null;
        }
        File file = cnt.getExternalFilesDir(VDeviceAPI.APP_NAME_BAIDU_MAP);
        if (file == null) {
            return null;
        }
        String path = file.getAbsolutePath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + File.separator + "bnav" + File.separator + "tingphone";
    }
}
