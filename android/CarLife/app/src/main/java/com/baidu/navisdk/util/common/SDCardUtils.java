package com.baidu.navisdk.util.common;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.IOException;

public class SDCardUtils {
    public static final int MIN_CACHE_FREE_SIZE = 20971520;
    public static final int MIN_FREE_SIZE = 15728640;
    private static final double MIN_FREE_SPACE = 10.0d;
    public static final int SDCARD_ERROR = 2;
    public static final int SDCARD_FULL = 1;
    public static final int SDCARD_NORMAL = 0;
    public static final int SDCARD_NOTFOUND = 3;
    public static final String TAG = "StorageCheck";

    public static File getExternalStorageFile() {
        return new File(SysOSAPI.getInstance().getSDcardRootPath());
    }

    public static String getExternalStoragePath() {
        return SysOSAPI.getInstance().getSDcardRootPath();
    }

    public static boolean writeTestFileToSdcard(String path) {
        boolean flag = false;
        try {
            File testFile = new File(path + "/test.0");
            if (testFile.exists()) {
                testFile.delete();
            }
            flag = testFile.createNewFile();
            if (testFile.exists()) {
                testFile.delete();
            }
        } catch (IOException e) {
            LogUtil.m15791e("", e.toString());
        }
        return flag;
    }

    public static int handleSdcardError(long sizeInByte, boolean bBuffer) {
        int state = 0;
        try {
            state = getSdcardState();
            if (state == 0) {
                StatFs sfs = getSdcardSize();
                if (((long) sfs.getBlockSize()) * ((long) sfs.getFreeBlocks()) < ((long) (bBuffer ? 15728640 : 0)) + sizeInByte) {
                    return 1;
                }
            }
        } catch (Exception e) {
        }
        return state;
    }

    public static int getSdcardState() {
        String status = Environment.getExternalStorageState();
        if (status == null || "bad_removal".equals(status)) {
            return 2;
        }
        if ("checking".equals(status) || "mounted".equals(status)) {
            return 0;
        }
        if ("mounted_ro".equals(status)) {
            return 2;
        }
        if ("nofs".equals(status)) {
            return 2;
        }
        if ("removed".equals(status)) {
            return 3;
        }
        if ("shared".equals(status)) {
            return 3;
        }
        if ("unmountable".equals(status)) {
            return 2;
        }
        if ("unmounted".equals(status)) {
            return 3;
        }
        return 0;
    }

    private static StatFs getSdcardSize() {
        if (StringUtils.isEmpty(SysOSAPI.getInstance().getSDcardRootPath())) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        }
        try {
            return new StatFs(SysOSAPI.getInstance().getSDcardRootPath());
        } catch (Exception e) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        }
    }

    private static StatFs getOfflinePathSize() {
        return new StatFs(SysOSAPI.getInstance().getOfflineDataPath());
    }

    public static long getSdcardSpace() {
        Long diskSpace = Long.valueOf(0);
        try {
            if (getSdcardState() == 0) {
                StatFs sfs = getSdcardSize();
                diskSpace = Long.valueOf(((long) sfs.getBlockSize()) * ((long) sfs.getFreeBlocks()));
            }
        } catch (Exception e) {
        }
        return diskSpace.longValue();
    }

    private static int checkOfflinePathAvailable() {
        File file = new File(SysOSAPI.getInstance().getOfflineDataPath());
        if (file.exists() && file.canRead() && file.canWrite()) {
            return 0;
        }
        return 3;
    }

    public static int handleOfflinePathError(long sizeInByte, boolean bBuffer) {
        int state = checkOfflinePathAvailable();
        if (state != 0) {
            return state;
        }
        StatFs sfs = getOfflinePathSize();
        if (((long) sfs.getBlockSize()) * ((long) sfs.getFreeBlocks()) < ((long) (bBuffer ? 15728640 : 0)) + sizeInByte) {
            return 1;
        }
        return state;
    }
}
