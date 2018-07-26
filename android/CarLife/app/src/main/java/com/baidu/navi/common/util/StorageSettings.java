package com.baidu.navi.common.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.common.StorageOptions;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.config.Preferences;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class StorageSettings {
    public static final String CACHE_FOLDER_NAME = "cache";
    public static final String DATA_FOLDER_NAME = "BaiduCarlife";
    private static volatile StorageSettings instance = null;
    private final List<StorageInformation> allStorages;
    private StorageInformation currentStorage;
    private String deprecatedDataPath;
    private boolean hasExternalStoragePermission;
    private boolean initialized;
    private boolean isExternalStorageEnabled;

    public static StorageSettings getInstance() {
        return StorageSettings$Holder.access$000();
    }

    private StorageSettings() {
        this.initialized = false;
        this.hasExternalStoragePermission = true;
        this.isExternalStorageEnabled = true;
        this.allStorages = new ArrayList();
        this.currentStorage = new StorageInformation();
    }

    public synchronized void initialize(Context context) {
        if (!this.initialized) {
            this.initialized = true;
            try {
                if (VERSION.SDK_INT >= 14) {
                    getAllStoragesV14(context);
                } else {
                    getAllStoragesV7(context);
                }
            } catch (Exception ex) {
                C2911f.m11009a(StorageSettings.class.getSimpleName(), "exception", ex);
            }
            try {
                if (this.allStorages.size() > 0) {
                    StorageInformation dataStorage = null;
                    int dataCount = 0;
                    for (StorageInformation storage : this.allStorages) {
                        if (new File(storage.getDataPath()).exists()) {
                            dataCount++;
                            dataStorage = storage;
                        }
                    }
                    boolean setDefaultStorage = false;
                    this.currentStorage = getPreferredStorage(context);
                    if (this.currentStorage == null) {
                        setDefaultStorage = true;
                    }
                    if (dataCount == 0) {
                        if (this.currentStorage == null || !this.currentStorage.isEnable()) {
                            for (StorageInformation storage2 : this.allStorages) {
                                if (isWritable(storage2.getRootPath())) {
                                    this.currentStorage = storage2;
                                    break;
                                }
                            }
                        }
                    } else if (dataCount == 1) {
                        if (this.currentStorage == null || !this.currentStorage.isEnable()) {
                            this.currentStorage = dataStorage;
                        }
                    }
                    if (this.currentStorage == null || !this.currentStorage.isEnable()) {
                        this.currentStorage = (StorageInformation) this.allStorages.get(0);
                    }
                    if (setDefaultStorage && this.currentStorage != null && dataCount < 2) {
                        setPreferredStorage(C2907c.m10977f(), this.currentStorage);
                    }
                }
            } catch (Exception ex2) {
                C2911f.m11009a(StorageSettings.class.getSimpleName(), "exception", ex2);
            }
            try {
                if (this.currentStorage != null && this.currentStorage.isEnable() && isWritable(this.currentStorage.getRootPath())) {
                    File dataFolder = new File(this.currentStorage.getDataPath());
                    if (!dataFolder.exists()) {
                        dataFolder.mkdirs();
                    }
                    File primaryCacheFolder = new File(this.currentStorage.getPrimaryCachePath());
                    if (!primaryCacheFolder.exists()) {
                        primaryCacheFolder.mkdirs();
                    }
                    File primaryCacheNoMediaFile = new File(primaryCacheFolder, ".nomedia");
                    if (!primaryCacheNoMediaFile.exists()) {
                        primaryCacheNoMediaFile.createNewFile();
                    }
                    SysOSAPIv2.getInstance().setSdcardPath(this.currentStorage.getRootPath());
                    SysOSAPIv2.getInstance().setSdcardDataPath(this.currentStorage.getDataPath());
                    SysOSAPIv2.getInstance().setOutputCache(this.currentStorage.getPrimaryCachePath());
                    SysOSAPIv2.getInstance().setOutputSecondCache(this.currentStorage.getSecondaryCachePath());
                } else {
                    this.isExternalStorageEnabled = false;
                    this.currentStorage = new StorageInformation();
                    this.allStorages.clear();
                    this.allStorages.add(this.currentStorage);
                    SysOSAPIv2.getInstance().setSdcardPath(this.currentStorage.getRootPath());
                    SysOSAPIv2.getInstance().setSdcardDataPath(this.currentStorage.getDataPath());
                    SysOSAPIv2.getInstance().setOutputCache(this.currentStorage.getPrimaryCachePath());
                    SysOSAPIv2.getInstance().setOutputSecondCache(this.currentStorage.getSecondaryCachePath());
                }
            } catch (Exception ex22) {
                C2911f.m11009a(StorageSettings.class.getSimpleName(), "exception", ex22);
            }
        }
    }

    public synchronized void reInitialize(Context context) {
        this.initialized = false;
        this.currentStorage = new StorageInformation();
        this.allStorages.clear();
        initialize(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(14)
    private void getAllStoragesV14(Context context) {
        try {
            StorageManager manager = (StorageManager) context.getSystemService("storage");
            Method getVolumeList = manager.getClass().getMethod("getVolumeList", new Class[0]);
            Method getVolumeState = manager.getClass().getMethod("getVolumeState", new Class[]{String.class});
            Class<?> storageVolume = Class.forName("android.os.storage.StorageVolume");
            Method isRemovable = storageVolume.getMethod("isRemovable", new Class[0]);
            Method getPath = storageVolume.getMethod("getPath", new Class[0]);
            Object[] volumes = (Object[]) getVolumeList.invoke(manager, new Object[0]);
            if (volumes != null) {
                String path;
                for (Object volume : volumes) {
                    path = (String) getPath.invoke(volume, new Object[0]);
                    if (path != null && path.length() > 0) {
                        if ("mounted".equals(getVolumeState.invoke(manager, new Object[]{path}))) {
                            boolean isPrimary = !((Boolean) isRemovable.invoke(volume, new Object[0])).booleanValue();
                            if ((VERSION.SDK_INT <= 19 || isPrimary) && isWritable(path)) {
                                boolean z;
                                String str;
                                List list = this.allStorages;
                                if (isPrimary) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (isPrimary) {
                                    str = StorageOptions.INTERNAL_STORAGE;
                                } else {
                                    str = StorageOptions.EXTERNAL_SD_CARD;
                                }
                                list.add(new StorageInformation(path, z, str));
                            } else if (VERSION.SDK_INT >= 19) {
                                String tmpPath = path + "/Android/data/com.baidu.carlife/files";
                                if (new File(path + File.separator + "BaiduCarlife").exists() && path.equals(context.getSharedPreferences(Preferences.SP_NAME, 0).getString("PREFFERED_SD_CARD", ""))) {
                                    this.deprecatedDataPath = path + File.separator + "BaiduCarlife";
                                } else if (isWritable(tmpPath)) {
                                    this.allStorages.add(new StorageInformation(tmpPath, !isPrimary, isPrimary ? StorageOptions.INTERNAL_STORAGE : StorageOptions.EXTERNAL_SD_CARD));
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (VERSION.SDK_INT >= 19) {
                    File[] externalStorageFiles = context.getExternalFilesDirs(null);
                    List<StorageInformation> tmp = new ArrayList();
                    tmp.addAll(this.allStorages);
                    int i = 0;
                    while (i < externalStorageFiles.length && externalStorageFiles[i] != null) {
                        path = externalStorageFiles[i].getAbsolutePath();
                        boolean exists = false;
                        for (StorageInformation storage : this.allStorages) {
                            if (path.startsWith(storage.getRootPath())) {
                                exists = true;
                                break;
                            }
                        }
                        if (!(exists || path.indexOf("com.baidu.carlife") == -1)) {
                            tmp.add(new StorageInformation(path, true, StorageOptions.EXTERNAL_SD_CARD));
                        }
                        i++;
                    }
                    this.allStorages.clear();
                    this.allStorages.addAll(tmp);
                }
            }
        } catch (Exception ex) {
            C2911f.m11009a(StorageSettings.class.getSimpleName(), "exception", ex);
        }
    }

    private void getAllStoragesV7(Context context) {
        Exception ex;
        Scanner scanner = null;
        List<String> mounts = new ArrayList();
        List<String> volds = new ArrayList();
        try {
            Scanner scanner2;
            String line;
            String[] lineElements;
            File mountsFile = new File("/proc/mounts");
            if (mountsFile.exists()) {
                scanner2 = new Scanner(mountsFile);
                while (scanner2.hasNext()) {
                    try {
                        line = scanner2.nextLine();
                        if (line.startsWith("/dev/block/vold/")) {
                            lineElements = line.replace('\t', ' ').split(" ");
                            if (lineElements != null && lineElements.length > 0) {
                                mounts.add(lineElements[1]);
                            }
                        }
                    } catch (Exception e) {
                        ex = e;
                        scanner = scanner2;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        scanner = scanner2;
                    }
                }
                scanner2.close();
                scanner2 = null;
            } else {
                scanner2 = null;
            }
            File voldFile = new File("/system/etc/vold.fstab");
            if (voldFile.exists()) {
                scanner = new Scanner(voldFile);
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (line.startsWith("dev_mount")) {
                        lineElements = line.replace('\t', ' ').split(" ");
                        if (lineElements != null && lineElements.length > 0) {
                            String element = lineElements[2];
                            if (element.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
                                element = element.substring(0, element.indexOf(Config.TRACE_TODAY_VISIT_SPLIT));
                            }
                            volds.add(element);
                        }
                    }
                }
                scanner.close();
                scanner = null;
            } else {
                scanner = scanner2;
            }
            String primaryStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            this.allStorages.add(new StorageInformation(primaryStoragePath, false, "Auto"));
            for (String path : mounts) {
                if (volds.contains(path) && !path.equals(primaryStoragePath)) {
                    File file = new File(path);
                    if (file.exists() && file.isDirectory() && file.canWrite()) {
                        this.allStorages.add(new StorageInformation(path, false, "Auto"));
                    }
                }
            }
            if (scanner != null) {
                scanner.close();
                return;
            }
            return;
        } catch (Exception e2) {
            ex = e2;
        }
        try {
            C2911f.m11009a(StorageSettings.class.getSimpleName(), "exception", ex);
            if (scanner != null) {
                scanner.close();
            }
        } catch (Throwable th3) {
            th2 = th3;
            if (scanner != null) {
                scanner.close();
            }
            throw th2;
        }
    }

    public boolean isExternalStorageEnabled() {
        return this.isExternalStorageEnabled;
    }

    public boolean isHasExternalStoragePermission() {
        return this.hasExternalStoragePermission;
    }

    public void setHasExternalStoragePermission(boolean hasExternalStoragePermission) {
        this.hasExternalStoragePermission = hasExternalStoragePermission;
    }

    public StorageInformation getCurrentStorage() {
        return this.currentStorage;
    }

    public List<StorageInformation> getAllStorages() {
        return this.allStorages;
    }

    public String getDeprecatedDataPath() {
        return this.deprecatedDataPath;
    }

    public StorageInformation getPreferredStorage(Context context) {
        String path = context.getSharedPreferences(Preferences.SP_NAME, 0).getString("PREFFERED_SD_CARD", "");
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        for (StorageInformation storage : this.allStorages) {
            if (storage.getRootPath().equals(path)) {
                return storage;
            }
            if (path.indexOf("com.baidu.carlife") != -1 && storage.getRootPath().equals(path.replace("/files", ""))) {
                return new StorageInformation(true, path);
            }
        }
        return new StorageInformation(false, path);
    }

    public boolean setPreferredStorage(Context context, StorageInformation preferredStorage) {
        String path = preferredStorage.getRootPath();
        if (!isWritable(path)) {
            return false;
        }
        Editor editor = context.getSharedPreferences(Preferences.SP_NAME, 0).edit();
        editor.putString("PREFFERED_SD_CARD", path);
        return editor.commit();
    }

    public int getMapTmpStgMax() {
        return 20971520;
    }

    public int getDomTmpStgMax() {
        return 52428800;
    }

    public int getItsTmpStgMax() {
        return MapGLSurfaceView.FLAG_OVERLAY_TA_DYNAMCI_MAP;
    }

    public int getSsgTmpStgMax() {
        return 52428800;
    }

    private boolean isWritable(String path) {
        boolean isCanWrite = false;
        try {
            File testFolder = new File(path);
            if (!testFolder.exists()) {
                testFolder.mkdirs();
            }
            File testFile = new File(path + "/test.0");
            if (testFile.exists()) {
                testFile.delete();
            }
            isCanWrite = testFile.createNewFile();
            if (testFile.exists()) {
                testFile.delete();
            }
        } catch (Exception ex) {
            C2911f.m11009a(StorageSettings.class.getSimpleName(), "exception", ex);
        }
        return isCanWrite;
    }
}
