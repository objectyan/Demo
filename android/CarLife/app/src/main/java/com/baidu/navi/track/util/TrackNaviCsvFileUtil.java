package com.baidu.navi.track.util;

import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.common.util.StorageInformation;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.util.List;

public class TrackNaviCsvFileUtil {
    private static final String APPDIR = "BaiduCarlife/bnav/trajectory";
    private static final String FILE_EXTENSION = ".bin.gz";
    private static final String TAG = TrackNaviCsvFileUtil.class.getSimpleName();

    public static void deleteGuidsFile(String guid) {
        List<StorageInformation> allStorages = StorageSettings.getInstance().getAllStorages();
        if (allStorages != null) {
            for (int i = 0; i < allStorages.size(); i++) {
                StorageInformation storageInformation = (StorageInformation) allStorages.get(i);
                if (storageInformation != null) {
                    String filePath = getFilePath(guid, storageInformation.getRootPath());
                    if (TextUtils.isEmpty(filePath)) {
                        continue;
                    } else {
                        File file = new File(filePath);
                        file.lastModified();
                        if (file.exists()) {
                            C1260i.b(TAG, "delete file " + filePath + " " + file.delete());
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void cleanTrackFile() {
        long time = System.currentTimeMillis() - -1627869184;
        File file = new File(getAppDir());
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                int i = 0;
                while (i < files.length) {
                    if (files[i].exists() && files[i].isFile() && files[i].lastModified() <= time) {
                        C1260i.b(TAG, "delete file " + files[i].getAbsolutePath() + " " + files[i].delete());
                    }
                    i++;
                }
            }
        }
    }

    public static String getAppDir() {
        return SysOSAPIv2.getInstance().getSdcardPath() + File.separator + APPDIR;
    }

    public static String getFilePath(String guid, String sdcard) {
        if (TextUtils.isEmpty(guid) || TextUtils.isEmpty(sdcard)) {
            return "";
        }
        String path = sdcard + File.separator + APPDIR + File.separator + guid + FILE_EXTENSION;
        C1260i.b(TAG, path);
        return !new File(path).exists() ? "" : path;
    }
}
