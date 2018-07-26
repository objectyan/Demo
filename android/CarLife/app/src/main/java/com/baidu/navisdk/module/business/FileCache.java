package com.baidu.navisdk.module.business;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.BitmapLoadUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCache {
    private static final String DATA_CACHE_DIR_NAME = "navi_activity";
    private static final String KEY_LAST_CLEAR_CACHE_TIME = "key_last_clear_cache_time";
    private static final String TAG = FileCache.class.getSimpleName();

    public static boolean checkCacheDir() {
        String cacheDir = SysOSAPI.getInstance().getSecondCachePath();
        if (TextUtils.isEmpty(cacheDir)) {
            return false;
        }
        try {
            File dir = new File(cacheDir + File.separator + DATA_CACHE_DIR_NAME);
            if (dir == null) {
                return false;
            }
            if (dir.exists()) {
                return true;
            }
            return dir.mkdirs();
        } catch (Exception e) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static String getCacheDirPath() {
        String cacheDir = SysOSAPI.getInstance().getSecondCachePath();
        if (TextUtils.isEmpty(cacheDir)) {
            return null;
        }
        return cacheDir + File.separator + DATA_CACHE_DIR_NAME;
    }

    public static void clearCache(Context context, boolean force) {
        PreferenceHelper ph;
        if (!(force || context == null)) {
            ph = PreferenceHelper.getInstance(context.getApplicationContext());
            if (ph != null) {
                long lastTime = ph.getLong(KEY_LAST_CLEAR_CACHE_TIME, -1);
                if (lastTime > 0 && SystemClock.elapsedRealtime() - lastTime < 1296000000) {
                    LogUtil.m15791e(TAG, "clearCache() return for is not time.");
                    return;
                }
            }
        }
        String dirPath = getCacheDirPath();
        if (!TextUtils.isEmpty(dirPath)) {
            try {
                LogUtil.m15791e(TAG, "clearCache()");
                if (context != null) {
                    ph = PreferenceHelper.getInstance(context.getApplicationContext());
                    if (ph != null) {
                        ph.putLong(KEY_LAST_CLEAR_CACHE_TIME, SystemClock.elapsedRealtime());
                    }
                }
                FileUtils.del(dirPath);
            } catch (IOException e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getCacheFilePath(String url, String prefix) {
        LogUtil.m15791e(TAG, "getCacheFilePath() url=" + url);
        if (!checkCacheDir() && TextUtils.isEmpty(url)) {
            return null;
        }
        String dirPath = getCacheDirPath();
        if (TextUtils.isEmpty(dirPath)) {
            return null;
        }
        int index = url.lastIndexOf(46);
        if (index < 0 || index >= url.length() - 1) {
            return null;
        }
        try {
            String suffix = url.substring(index, url.length());
            if (TextUtils.isEmpty(suffix)) {
                return null;
            }
            String md5 = MD5.toMD5(url);
            if (TextUtils.isEmpty(md5)) {
                return null;
            }
            StringBuilder append = new StringBuilder().append(dirPath).append(File.separator);
            if (TextUtils.isEmpty(prefix)) {
                prefix = "";
            }
            String filePath = append.append(prefix).append(md5).append(suffix).toString();
            LogUtil.m15791e(TAG, "getCacheFilePath() fp=" + filePath);
            File file = new File(filePath);
            if (file != null && file.exists()) {
                LogUtil.m15791e(TAG, "getCacheFilePath() got it.");
                return filePath;
            }
            return null;
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap loadBitmapCache(String url, String prefix) {
        Bitmap bitmap = null;
        LogUtil.m15791e(TAG, "loadBitmapCache() url=" + url);
        if (checkCacheDir() || !TextUtils.isEmpty(url)) {
            String dirPath = getCacheDirPath();
            if (!TextUtils.isEmpty(dirPath)) {
                int index = url.lastIndexOf(46);
                if (index >= 0 && index < url.length() - 1) {
                    try {
                        String suffix = url.substring(index, url.length());
                        if (!TextUtils.isEmpty(suffix)) {
                            String md5 = MD5.toMD5(url);
                            if (!TextUtils.isEmpty(md5)) {
                                StringBuilder append = new StringBuilder().append(dirPath).append(File.separator);
                                if (TextUtils.isEmpty(prefix)) {
                                    prefix = "";
                                }
                                String filePath = append.append(prefix).append(md5).append(suffix).toString();
                                LogUtil.m15791e(TAG, "loadBitmapCache() fp=" + filePath);
                                File file = new File(filePath);
                                if (file != null && file.exists()) {
                                    LogUtil.m15791e(TAG, "loadBitmapCache() got it.");
                                    bitmap = BitmapLoadUtils.getBitmapFromPath(filePath);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (LogUtil.LOGGABLE) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return bitmap;
    }

    public static String cacheFile(String url, String prefix, byte[] fileBytes) {
        Exception e;
        Throwable th;
        LogUtil.m15791e(TAG, "cacheFile() url=" + url);
        if (!checkCacheDir() && TextUtils.isEmpty(url)) {
            return null;
        }
        String dirPath = getCacheDirPath();
        if (TextUtils.isEmpty(dirPath)) {
            return null;
        }
        int index = url.lastIndexOf(46);
        if (index < 0 || index >= url.length() - 1) {
            return null;
        }
        FileOutputStream fos = null;
        try {
            String suffix = url.substring(index, url.length());
            if (TextUtils.isEmpty(suffix)) {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (Exception e2) {
                    }
                }
                return null;
            }
            String md5 = MD5.toMD5(url);
            if (TextUtils.isEmpty(md5)) {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (Exception e3) {
                    }
                }
                return null;
            }
            StringBuilder append = new StringBuilder().append(dirPath).append(File.separator);
            if (TextUtils.isEmpty(prefix)) {
                prefix = "";
            }
            String filePath = append.append(prefix).append(md5).append(suffix).toString();
            LogUtil.m15791e(TAG, "cacheFile() fp=" + filePath);
            FileOutputStream fos2 = new FileOutputStream(filePath);
            if (fos2 != null) {
                try {
                    fos2.write(fileBytes);
                    fos2.flush();
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (Exception e4) {
                        }
                    }
                    return filePath;
                } catch (Exception e5) {
                    e = e5;
                    fos = fos2;
                    try {
                        if (LogUtil.LOGGABLE) {
                            e.printStackTrace();
                        }
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (Exception e6) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (Exception e7) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fos = fos2;
                    if (fos != null) {
                        fos.close();
                    }
                    throw th;
                }
            }
            if (fos2 != null) {
                try {
                    fos2.close();
                } catch (Exception e8) {
                }
            }
            return null;
        } catch (Exception e9) {
            e = e9;
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
            if (fos != null) {
                fos.close();
            }
            return null;
        }
    }
}
