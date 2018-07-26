package com.baidu.mapframework.common.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.util.C2911f;
import java.io.File;

public final class StorageInformation {
    private final String dataPath;
    private boolean isEnable;
    private final String label;
    private final String primaryCachePath;
    private final boolean removeable;
    private final String rootPath;
    private final String secondaryCachePath;

    StorageInformation(String rootPath, boolean removeable, String label) {
        this.isEnable = true;
        this.removeable = removeable;
        this.rootPath = rootPath;
        this.dataPath = this.rootPath + File.separator + "BaiduCarlife";
        this.primaryCachePath = this.dataPath + File.separator + "cache";
        this.secondaryCachePath = C2907c.f().getCacheDir().getAbsolutePath();
        this.label = label;
    }

    StorageInformation() {
        this.isEnable = true;
        this.removeable = false;
        this.rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.dataPath = this.rootPath + File.separator + "BaiduCarlife";
        this.primaryCachePath = C2907c.f().getCacheDir().getAbsolutePath();
        this.secondaryCachePath = "";
        this.label = "";
    }

    public StorageInformation(boolean isEnable, String rootPath) {
        this.isEnable = true;
        this.isEnable = isEnable;
        this.removeable = false;
        this.rootPath = rootPath;
        this.dataPath = this.rootPath + File.separator + "BaiduCarlife";
        this.primaryCachePath = this.dataPath + File.separator + "cache";
        this.secondaryCachePath = C2907c.f().getCacheDir().getAbsolutePath();
        this.label = "";
    }

    public boolean isRemoveable() {
        return this.removeable;
    }

    public String getRootPath() {
        return this.rootPath;
    }

    public String getDataPath() {
        return this.rootPath + File.separator + "BaiduCarlife";
    }

    public String getPrimaryCachePath() {
        return this.primaryCachePath;
    }

    public String getSecondaryCachePath() {
        return this.secondaryCachePath;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    @SuppressLint({"NewApi"})
    public long getAvailableBytes() {
        try {
            StatFs stat = new StatFs(this.rootPath);
            if (VERSION.SDK_INT >= 18) {
                return stat.getAvailableBytes();
            }
            return ((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize());
        } catch (Exception ex) {
            C2911f.a(StorageInformation.class.getSimpleName(), "exception", ex);
            return -1;
        } catch (NoSuchMethodError e) {
            return -1;
        }
    }

    public boolean equals(Object other) {
        if (other == null || !StorageInformation.class.isInstance(other)) {
            return false;
        }
        return this.rootPath.equals(((StorageInformation) other).rootPath);
    }
}
