package com.baidu.navisdk.util.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mobstat.Config;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

@TargetApi(9)
public class StorageOptions {
    private static final String DEV_BLOCK_VOLD = "/dev/block/vold/";
    private static final String DEV_MOUNT = "dev_mount";
    public static final String EXTERNAL_SD_CARD = "外置存储卡";
    public static final String INTERNAL_STORAGE = "内置存储卡";
    private static String MNT_SDCARD = "";
    private static final String PROC_MOUNTS = "/proc/mounts";
    private static final String SYSTEM_ETC_VOLD_FSTAB = "/system/etc/vold.fstab";
    public static int count = 0;
    public static String[] labels;
    private static ArrayList<String> mMounts = new ArrayList();
    private static ArrayList<String> mVold = new ArrayList();
    public static String[] paths;
    public static String[] sizes;

    public static void determineStorageOptions(Context context) {
        MNT_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean ret = false;
        if (VERSION.SDK_INT >= 14) {
            ret = getStoragePaths(context);
        }
        if (!ret) {
            readMountsFile();
            readVoldFile();
            compareMountsWithVold();
            testAndCleanMountsList();
            setProperties();
        }
    }

    private static void readMountsFile() {
        mMounts.add(MNT_SDCARD);
        try {
            Scanner scanner = new Scanner(new File(PROC_MOUNTS), "UTF-8");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.startsWith(DEV_BLOCK_VOLD)) {
                    String[] lineElements = line.replace('\t', ' ').split(" ");
                    if (lineElements != null && 1 < lineElements.length) {
                        String element = lineElements[1];
                        if (!element.equals(MNT_SDCARD)) {
                            mMounts.add(element);
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
        }
    }

    private static void readVoldFile() {
        mVold.add(MNT_SDCARD);
        File file = new File(SYSTEM_ETC_VOLD_FSTAB);
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file, "UTF-8");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if (line.startsWith(DEV_MOUNT)) {
                        String[] lineElements = line.replace('\t', ' ').split(" ");
                        if (lineElements != null && 2 < lineElements.length) {
                            String element = lineElements[2];
                            if (element.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
                                element = element.substring(0, element.indexOf(Config.TRACE_TODAY_VISIT_SPLIT));
                            }
                            if (!element.equals(MNT_SDCARD)) {
                                mVold.add(element);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogUtil.m15791e("", e.toString());
            }
        }
    }

    private static void compareMountsWithVold() {
        int i = 0;
        while (i < mMounts.size()) {
            if (!mVold.contains((String) mMounts.get(i))) {
                int i2 = i - 1;
                mMounts.remove(i);
                i = i2;
            }
            i++;
        }
        mVold.clear();
    }

    private static void testAndCleanMountsList() {
        int i = 0;
        while (i < mMounts.size()) {
            File root = new File((String) mMounts.get(i));
            if (!root.exists() || !root.isDirectory() || !root.canWrite()) {
                int i2 = i - 1;
                mMounts.remove(i);
                i = i2;
            }
            i++;
        }
    }

    @TargetApi(9)
    private static void setProperties() {
        ArrayList<String> mLabels = new ArrayList();
        ArrayList<String> mSizes = new ArrayList();
        if (mMounts.size() > 0) {
            if (VERSION.SDK_INT < 9) {
                mLabels.add("Auto");
            }
            mLabels.add(INTERNAL_STORAGE);
            mSizes.add(getAvailaleSize((String) mMounts.get(0)));
            if (mMounts.size() > 1) {
                for (int i = 1; i < mMounts.size(); i++) {
                    mLabels.add(EXTERNAL_SD_CARD);
                    mSizes.add(getAvailaleSize((String) mMounts.get(i)));
                }
            }
        }
        labels = new String[mLabels.size()];
        mLabels.toArray(labels);
        paths = new String[mMounts.size()];
        mMounts.toArray(paths);
        sizes = new String[mMounts.size()];
        mSizes.toArray(sizes);
        count = Math.min(labels.length, paths.length);
        mMounts.clear();
    }

    private static String getAvailaleSize(String path) {
        String strSize = "未知大小";
        try {
            StatFs stat = new StatFs(path);
            long nSize = ((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize());
            DecimalFormat df = new DecimalFormat();
            if (nSize < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                return nSize + "B";
            }
            if (nSize < 1048576) {
                df.applyPattern("0");
                return df.format(((double) nSize) / 1024.0d) + "K";
            } else if (nSize < 1073741824) {
                df.applyPattern("0.0");
                return df.format(((double) nSize) / 1048576.0d) + "M";
            } else {
                df.applyPattern("0.0");
                return df.format(((double) nSize) / 1.073741824E9d) + "G";
            }
        } catch (IllegalArgumentException e) {
            LogUtil.m15791e("", e.toString());
            return strSize;
        }
    }

    private static boolean getStoragePathsV1(Context context) {
        paths = new String[1];
        paths[0] = Environment.getExternalStorageDirectory().getAbsolutePath();
        return true;
    }

    private static boolean getStoragePathsV2(Context context) {
        Object manager = context.getSystemService("storage");
        if (manager == null) {
            return getStoragePathsV1(context);
        }
        ArrayList<String> internalList = new ArrayList();
        ArrayList<String> externalList = new ArrayList();
        ArrayList<String> labelList = new ArrayList();
        ArrayList<String> sizeList = new ArrayList();
        try {
            int i;
            Class<?> clsStorageVolume = Class.forName("android.os.storage.StorageVolume");
            Method mthdGetVolumeList = manager.getClass().getMethod("getVolumeList", new Class[0]);
            Method mthdGetVolumeState = manager.getClass().getMethod("getVolumeState", new Class[]{String.class});
            Method mthdIsRemovable = clsStorageVolume.getMethod("isRemovable", new Class[0]);
            Method mthdGetPath = clsStorageVolume.getMethod("getPath", new Class[0]);
            Object[] volumes = (Object[]) mthdGetVolumeList.invoke(manager, new Object[0]);
            for (i = 0; i < volumes.length; i++) {
                String path = (String) mthdGetPath.invoke(volumes[i], new Object[0]);
                boolean removable = ((Boolean) mthdIsRemovable.invoke(volumes[i], new Object[0])).booleanValue();
                if (!(path == null || StringUtils.isEmpty(path))) {
                    String state = (String) mthdGetVolumeState.invoke(manager, new Object[]{path});
                    if (state != null && state.equals("mounted")) {
                        if (removable) {
                            externalList.add(path);
                        } else {
                            internalList.add(path);
                        }
                    }
                }
            }
            for (i = 0; i < internalList.size(); i++) {
                mMounts.add(internalList.get(i));
                labelList.add(INTERNAL_STORAGE);
                sizeList.add(getAvailaleSize((String) internalList.get(i)));
            }
            for (i = 0; i < externalList.size(); i++) {
                mMounts.add(externalList.get(i));
                labelList.add(EXTERNAL_SD_CARD);
                sizeList.add(getAvailaleSize((String) externalList.get(i)));
            }
            labels = new String[labelList.size()];
            labelList.toArray(labels);
            paths = new String[mMounts.size()];
            mMounts.toArray(paths);
            sizes = new String[mMounts.size()];
            sizeList.toArray(sizes);
            count = Math.min(labels.length, paths.length);
            mMounts.clear();
            return true;
        } catch (ClassNotFoundException ex) {
            LogUtil.m15791e("", ex.toString());
        } catch (NoSuchMethodException ex2) {
            LogUtil.m15791e("", ex2.toString());
        } catch (IllegalArgumentException ex3) {
            LogUtil.m15791e("", ex3.toString());
        } catch (IllegalAccessException ex4) {
            LogUtil.m15791e("", ex4.toString());
        } catch (InvocationTargetException ex5) {
            LogUtil.m15791e("", ex5.toString());
        }
        return false;
    }

    private static boolean getStoragePathsV3(Context context) {
        int i;
        String path;
        ArrayList<String> internalList = new ArrayList();
        ArrayList<String> externalList = new ArrayList();
        ArrayList<String> labelList = new ArrayList();
        ArrayList<String> sizeList = new ArrayList();
        Object manager = context.getSystemService("storage");
        if (manager != null) {
            try {
                Class<?> clsStorageVolume = Class.forName("android.os.storage.StorageVolume");
                Method mthdGetVolumeList = manager.getClass().getMethod("getVolumeList", new Class[0]);
                Method mthdGetVolumeState = manager.getClass().getMethod("getVolumeState", new Class[]{String.class});
                Method mthdIsRemovable = clsStorageVolume.getMethod("isRemovable", new Class[0]);
                Method mthdGetPath = clsStorageVolume.getMethod("getPath", new Class[0]);
                Object[] volumes = (Object[]) mthdGetVolumeList.invoke(manager, new Object[0]);
                for (i = 0; i < volumes.length; i++) {
                    path = (String) mthdGetPath.invoke(volumes[i], new Object[0]);
                    boolean removable = ((Boolean) mthdIsRemovable.invoke(volumes[i], new Object[0])).booleanValue();
                    if (!(path == null || StringUtils.isEmpty(path))) {
                        String state = (String) mthdGetVolumeState.invoke(manager, new Object[]{path});
                        if (!(state == null || !state.equals("mounted") || removable)) {
                            internalList.add(path);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                LogUtil.m15791e("", ex.toString());
            } catch (NoSuchMethodException ex2) {
                LogUtil.m15791e("", ex2.toString());
            } catch (IllegalArgumentException ex3) {
                LogUtil.m15791e("", ex3.toString());
            } catch (IllegalAccessException ex4) {
                LogUtil.m15791e("", ex4.toString());
            } catch (InvocationTargetException ex5) {
                LogUtil.m15791e("", ex5.toString());
            }
        }
        try {
            Method mthdGetExternalFilesDirs = Context.class.getMethod("getExternalFilesDirs", new Class[]{String.class});
            if (mthdGetExternalFilesDirs == null) {
                return false;
            }
            File[] externalStorageFiles = (File[]) mthdGetExternalFilesDirs.invoke(context, new Object[]{""});
            if (externalStorageFiles == null) {
                return false;
            }
            if (externalStorageFiles == null) {
                return true;
            }
            i = 0;
            while (i < externalStorageFiles.length && externalStorageFiles[i] != null) {
                path = externalStorageFiles[i].getAbsolutePath();
                if (path != null) {
                    boolean isPrimary = false;
                    Iterator it = internalList.iterator();
                    while (it.hasNext()) {
                        if (path.startsWith((String) it.next())) {
                            isPrimary = true;
                            break;
                        }
                    }
                    if (!(isPrimary || path.indexOf(context.getPackageName()) == -1)) {
                        externalList.add(path);
                    }
                }
                i++;
            }
            for (i = 0; i < internalList.size(); i++) {
                mMounts.add(internalList.get(i));
                labelList.add(INTERNAL_STORAGE);
                sizeList.add(getAvailaleSize((String) internalList.get(i)));
            }
            for (i = 0; i < externalList.size(); i++) {
                mMounts.add(externalList.get(i));
                labelList.add(EXTERNAL_SD_CARD);
                sizeList.add(getAvailaleSize((String) externalList.get(i)));
            }
            labels = new String[labelList.size()];
            labelList.toArray(labels);
            paths = new String[mMounts.size()];
            mMounts.toArray(paths);
            sizes = new String[mMounts.size()];
            sizeList.toArray(sizes);
            count = Math.min(labels.length, paths.length);
            mMounts.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean getStoragePaths(Context context) {
        if (context == null) {
            return false;
        }
        if (VERSION.SDK_INT < 9) {
            return getStoragePathsV1(context);
        }
        if (VERSION.SDK_INT < 19) {
            return getStoragePathsV2(context);
        }
        return getStoragePathsV3(context);
    }
}
