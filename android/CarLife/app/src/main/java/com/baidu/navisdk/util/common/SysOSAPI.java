package com.baidu.navisdk.util.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class SysOSAPI {
    public static final String CFG_FOLDER = "/nmap";
    private static final int K_MAP_RES_CONFIG_NORMAL = 1;
    private static final int K_MAP_RES_CONFIG_SIMPLE = 2;
    public static String ROOT_FOLDER = "BaiduNavi";
    private static String mAppFolderName = null;
    private boolean inited;
    private String mAppCacheDir;
    private String mAppFilesDir;
    private String mAppResouceDir;
    private String mOfflineDataPath;
    private String mSDCardCachePath;
    private String mSDCardDataPath;
    private String mSDCardRootPath;
    String strGLRenderer;
    String strGLVersion;

    private static class LazyHolder {
        private static SysOSAPI sInstance = new SysOSAPI();

        private LazyHolder() {
        }
    }

    public static SysOSAPI getInstance() {
        return LazyHolder.sInstance;
    }

    private SysOSAPI() {
        this.strGLRenderer = "";
        this.strGLVersion = "";
        this.inited = false;
        init();
    }

    public void init() {
        if (!this.inited && BNaviModuleManager.getContext() != null) {
            this.inited = true;
            this.mAppResouceDir = BNaviModuleManager.getContext().getFilesDir().getAbsolutePath() + CFG_FOLDER;
            this.mAppFilesDir = BNaviModuleManager.getContext().getFilesDir().getAbsolutePath();
            this.mAppCacheDir = BNaviModuleManager.getContext().getCacheDir().getAbsolutePath();
            ensureStorage(this.mAppResouceDir);
            ensureStorage(this.mAppFilesDir);
            ensureStorage(this.mAppCacheDir);
        }
    }

    public void initSDcardPath(String choosePath) {
        this.mSDCardRootPath = choosePath;
        String strPath = this.mSDCardRootPath;
        if (!(mAppFolderName == null || TextUtils.isEmpty(mAppFolderName))) {
            ROOT_FOLDER = mAppFolderName + "/bnav";
        }
        strPath = strPath + "/" + ROOT_FOLDER;
        ensureStorage(strPath);
        ensureNoMediaFile(strPath);
        this.mSDCardDataPath = strPath;
        this.mSDCardCachePath = this.mSDCardDataPath + "/cache";
        ensureStorage(this.mSDCardCachePath);
    }

    public String getSDcardRootPath() {
        return this.mSDCardRootPath;
    }

    public void setOfflineDataPath(String path) {
        this.mOfflineDataPath = path;
    }

    public String getOfflineDataPath() {
        return this.mOfflineDataPath;
    }

    private void ensureStorage(String path) {
        File fout = new File(path);
        if (!fout.exists()) {
            fout.mkdirs();
        }
    }

    private void ensureNoMediaFile(String dirPath) {
        try {
            if (new File(dirPath).exists()) {
                File nmf = new File(dirPath + File.separator + ".nomedia");
                if (!nmf.exists()) {
                    nmf.createNewFile();
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readAndCopyDataCfg(android.content.res.AssetManager r29) throws java.lang.Exception {
        /*
        r28 = this;
        r26 = new java.lang.StringBuilder;
        r26.<init>();
        r0 = r28;
        r0 = r0.mOfflineDataPath;
        r27 = r0;
        r26 = r26.append(r27);
        r27 = "/naviDataCfg.dat";
        r26 = r26.append(r27);
        r17 = r26.toString();
        r12 = new java.io.File;
        r0 = r17;
        r12.<init>(r0);
        r20 = 0;
        r10 = 0;
        r15 = 1;
        r16 = 0;
        r26 = r12.exists();
        if (r26 == 0) goto L_0x00f7;
    L_0x002d:
        r21 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x012b }
        r26 = "r";
        r0 = r21;
        r1 = r17;
        r2 = r26;
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x012b }
        r26 = 24;
        r0 = r26;
        r8 = new byte[r0];	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = 0;
        r27 = 24;
        r0 = r21;
        r1 = r26;
        r2 = r27;
        r7 = r0.read(r8, r1, r2);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r22 = new java.lang.String;	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = "UTF-8";
        r0 = r22;
        r1 = r26;
        r0.<init>(r8, r1);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = ":";
        r0 = r22;
        r1 = r26;
        r19 = r0.indexOf(r1);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = ",";
        r0 = r22;
        r1 = r26;
        r18 = r0.indexOf(r1);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r25 = 0;
        r26 = com.baidu.navisdk.util.common.StringUtils.isEmpty(r22);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        if (r26 != 0) goto L_0x0085;
    L_0x0079:
        r26 = r19 + 1;
        r0 = r22;
        r1 = r26;
        r2 = r18;
        r25 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
    L_0x0085:
        r23 = -1;
        r26 = com.baidu.navisdk.util.common.StringUtils.isEmpty(r25);	 Catch:{ Exception -> 0x0120, all -> 0x015f }
        if (r26 != 0) goto L_0x0091;
    L_0x008d:
        r23 = java.lang.Integer.parseInt(r25);	 Catch:{ Exception -> 0x0120, all -> 0x015f }
    L_0x0091:
        r26 = "naviDataCfg.dat";
        r0 = r29;
        r1 = r26;
        r10 = r0.open(r1);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = 24;
        r0 = r26;
        r3 = new byte[r0];	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = 0;
        r27 = 24;
        r0 = r26;
        r1 = r27;
        r10.read(r3, r0, r1);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = "UTF-8";
        r0 = r26;
        r4.<init>(r3, r0);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = ":";
        r0 = r26;
        r19 = r4.indexOf(r0);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r26 = ",";
        r0 = r26;
        r18 = r4.indexOf(r0);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        r24 = 0;
        if (r4 == 0) goto L_0x00dd;
    L_0x00cd:
        r26 = r4.length();	 Catch:{ Exception -> 0x0163, all -> 0x015f }
        if (r26 <= 0) goto L_0x00dd;
    L_0x00d3:
        r26 = r19 + 1;
        r0 = r26;
        r1 = r18;
        r24 = r4.substring(r0, r1);	 Catch:{ Exception -> 0x0163, all -> 0x015f }
    L_0x00dd:
        r5 = -2;
        r5 = java.lang.Integer.parseInt(r24);	 Catch:{ Exception -> 0x0125, all -> 0x015f }
    L_0x00e2:
        r0 = r23;
        if (r0 != r5) goto L_0x0128;
    L_0x00e6:
        r15 = 0;
    L_0x00e7:
        r21.close();
        if (r10 == 0) goto L_0x00ef;
    L_0x00ec:
        r10.close();
    L_0x00ef:
        r10 = 0;
        r20 = 0;
    L_0x00f2:
        if (r15 == 0) goto L_0x00f7;
    L_0x00f4:
        r12.delete();
    L_0x00f7:
        if (r15 == 0) goto L_0x015e;
    L_0x00f9:
        r12.createNewFile();
        r26 = "naviDataCfg.dat";
        r0 = r29;
        r1 = r26;
        r13 = r0.open(r1);
        r14 = new java.io.FileOutputStream;
        r14.<init>(r12);
        r26 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r0 = r26;
        r6 = new byte[r0];
    L_0x0112:
        r9 = r13.read(r6);
        if (r9 <= 0) goto L_0x014f;
    L_0x0118:
        r26 = 0;
        r0 = r26;
        r14.write(r6, r0, r9);
        goto L_0x0112;
    L_0x0120:
        r11 = move-exception;
        r23 = -1;
        goto L_0x0091;
    L_0x0125:
        r11 = move-exception;
        r5 = -2;
        goto L_0x00e2;
    L_0x0128:
        r16 = 1;
        goto L_0x00e7;
    L_0x012b:
        r11 = move-exception;
    L_0x012c:
        r26 = "";
        r27 = r11.toString();	 Catch:{ all -> 0x0142 }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r26, r27);	 Catch:{ all -> 0x0142 }
        r20.close();
        if (r10 == 0) goto L_0x013e;
    L_0x013b:
        r10.close();
    L_0x013e:
        r10 = 0;
        r20 = 0;
        goto L_0x00f2;
    L_0x0142:
        r26 = move-exception;
    L_0x0143:
        r20.close();
        if (r10 == 0) goto L_0x014b;
    L_0x0148:
        r10.close();
    L_0x014b:
        r10 = 0;
        r20 = 0;
        throw r26;
    L_0x014f:
        r13.close();
        r14.close();
        if (r16 == 0) goto L_0x015e;
    L_0x0157:
        r26 = com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.getInstance();
        r26.checkDataVerNotMatch();
    L_0x015e:
        return;
    L_0x015f:
        r26 = move-exception;
        r20 = r21;
        goto L_0x0143;
    L_0x0163:
        r11 = move-exception;
        r20 = r21;
        goto L_0x012c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.common.SysOSAPI.readAndCopyDataCfg(android.content.res.AssetManager):void");
    }

    private void readAndCopyData(AssetManager am) throws Exception {
        File root = new File(GetSDCardPath());
        if (!root.exists()) {
            root.mkdirs();
            LogUtil.m15791e("SysOSAPI", " init root path");
        }
        try {
            File navi0Res = new File(GetSDCardPath() + "/navi/pub");
            if (!navi0Res.exists()) {
                navi0Res.mkdirs();
            }
            String[] searchArrfilename = new String[]{"catalog.dat", "district.dat", "guidance_polyphone.dat", "rg.tpl"};
            String[] searchDestFile = new String[]{"/navi/pub/catalog.dat", "/navi/pub/district.dat", "/navi/pub/guidance_polyphone.dat", "/navi/pub/rg.tpl"};
            long apkUpdateTime = PackageUtil.getApkUpdateTime();
            for (int i = 0; i < searchArrfilename.length; i++) {
                InputStream input = am.open(searchArrfilename[i]);
                long srcFileLen = (long) input.available();
                File f = new File(GetSDCardPath() + searchDestFile[i]);
                if (f.exists() && f.lastModified() > apkUpdateTime && srcFileLen == f.length()) {
                    input.close();
                } else {
                    byte[] b = new byte[((int) srcFileLen)];
                    input.read(b);
                    input.close();
                    if (f.exists()) {
                        f.delete();
                    }
                    f.createNewFile();
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(b);
                    out.close();
                }
            }
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
        }
    }

    private void readAndCopyLargeData(AssetManager am) {
        File root = new File(this.mOfflineDataPath);
        if (!root.exists()) {
            root.mkdirs();
            LogUtil.m15791e("SysOSAPI", " init root path");
        }
        try {
            File navi0Res = new File(this.mOfflineDataPath + "/navi/pub");
            if (!navi0Res.exists()) {
                navi0Res.mkdirs();
            }
            String[] searchArrfilename = new String[]{"s_3.png"};
            String[] searchDestFile = new String[]{"/navi/pub/s_3"};
            for (int i = 0; i < searchArrfilename.length; i++) {
                File f = new File(this.mOfflineDataPath + searchDestFile[i]);
                if (f.exists()) {
                    f.delete();
                }
                f.createNewFile();
                FileOutputStream out = new FileOutputStream(f);
                InputStream input = am.open(searchArrfilename[i]);
                byte[] b = new byte[1024];
                while (true) {
                    int readLen = input.read(b, 0, 1024);
                    if (readLen == -1) {
                        break;
                    }
                    out.write(b, 0, readLen);
                    out.flush();
                }
                input.close();
                out.close();
            }
        } catch (Throwable e) {
            LogUtil.m15791e("", e.toString());
        }
    }

    private void readAndCopyResource(File fver, byte[] buffer, AssetManager am) throws Exception {
        if (fver.exists()) {
            fver.delete();
        }
        fver.createNewFile();
        FileOutputStream out = new FileOutputStream(fver);
        out.write(buffer);
        out.close();
        File foutA = new File(this.mAppResouceDir + "/cfg/a");
        if (!foutA.exists()) {
            foutA.mkdirs();
        }
        File foutH = new File(this.mAppResouceDir + "/cfg/h");
        if (!foutH.exists()) {
            foutH.mkdirs();
        }
        File foutL = new File(this.mAppResouceDir + "/cfg/l");
        if (!foutL.exists()) {
            foutL.mkdirs();
        }
        File foutHciCloud = new File(this.mAppResouceDir + "/HciCloud");
        if (!foutHciCloud.exists()) {
            foutHciCloud.mkdirs();
        }
        String[] arrfilename = getCopyFilelist();
        for (int i = 0; i < arrfilename.length; i++) {
            InputStream input = am.open(arrfilename[i]);
            long srcFileLen = (long) input.available();
            File f = new File(this.mAppResouceDir + "/" + arrfilename[i]);
            if (f.exists() && f.lastModified() > PackageUtil.getApkUpdateTime() && srcFileLen == f.length()) {
                input.close();
            } else {
                try {
                    byte[] b = new byte[((int) srcFileLen)];
                    input.read(b);
                    input.close();
                    if (f.exists()) {
                        f.delete();
                    }
                    f.createNewFile();
                    FileOutputStream out2 = new FileOutputStream(f);
                    try {
                        out2.write(b);
                        out2.close();
                        out = out2;
                    } catch (OutOfMemoryError e) {
                        out = out2;
                    }
                } catch (OutOfMemoryError e2) {
                }
            }
        }
    }

    public void initEngineRes(Context context) {
        try {
            File fver = new File(this.mAppResouceDir + "/ver.dat");
            boolean firstinit = true;
            byte[] buffer = new byte[]{(byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 9};
            if (fver.exists()) {
                FileInputStream input = new FileInputStream(fver);
                byte[] b = new byte[input.available()];
                input.read(b);
                input.close();
                if (Arrays.equals(b, buffer)) {
                    firstinit = false;
                }
            }
            AssetManager am = JarUtils.getResources().getAssets();
            readAndCopyDataCfg(am);
            readAndCopyData(am);
            if (firstinit) {
                readAndCopyResource(fver, buffer, am);
            }
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
        }
    }

    private static int getMapResConfig() {
        int config = 1;
        try {
            InputStream is = JarUtils.getResources().getAssets().open("cfg/MapRes.cfg");
            byte[] b = new byte[is.available()];
            is.read(b);
            is.close();
            config = new JSONObject(new String(b)).getInt("type");
        } catch (Exception e) {
            LogUtil.m15791e("", e.toString());
        }
        return config;
    }

    private static String[] getCopyFilelist() {
        if (getMapResConfig() == 2) {
            return new String[]{"cfg/MapRes.cfg"};
        }
        return new String[]{"cfg/MapRes.cfg", "cfg/h/DVDirectory.cfg", "cfg/h/DVHotcity.cfg", "cfg/h/DVVersion.cfg", "cfg/l/DVDirectory.cfg", "cfg/l/DVHotcity.cfg", "cfg/l/DVVersion.cfg", "cfg/h/DVStreet.cfg", "cfg/l/DVStreet.cfg", "cfg/a/navicfgversion.cfg"};
    }

    public Bundle initPhoneInfo() {
        Bundle b = new Bundle();
        b.putString("cpu", "");
        b.putString("resid", SysOSAPIv2.RES_ID);
        b.putString("channel", PackageUtil.strChannel);
        b.putString("glr", this.strGLRenderer);
        b.putString("glv", this.strGLVersion);
        b.putString("mb", PackageUtil.strPhoneType);
        b.putString("sv", PackageUtil.strSoftWareVer);
        b.putString("os", PackageUtil.strOSVersion);
        b.putInt("dpi_x", ScreenUtil.getInstance().getDPI());
        b.putInt("dpi_y", ScreenUtil.getInstance().getDPI());
        b.putString("net", NetworkUtils.getCurrentNetMode(BNaviModuleManager.getContext()));
        b.putString("im", PackageUtil.getImeiNum());
        b.putString("imrand", PackageUtil.getImeiRand());
        b.putByteArray("signature", PackageUtil.getPackageSignature());
        b.putString("deviceid", PackageUtil.getImeiNum());
        return b;
    }

    public void updateGLinfo(String glvString, String glrString) {
        setGLVersion(glvString);
        setGLRenderer(glrString);
    }

    public String GetModuleFileName() {
        return this.mAppFilesDir;
    }

    public void setAppFolderName(String appFolderName) {
        mAppFolderName = appFolderName;
    }

    public String GetSDCardPath() {
        return this.mSDCardDataPath;
    }

    public String GetSDCardCachePath() {
        return this.mSDCardCachePath;
    }

    public String getSecondCachePath() {
        return this.mAppCacheDir;
    }

    public String getGLRenderer() {
        return this.strGLRenderer;
    }

    private void setGLRenderer(String strGLRenderer) {
    }

    public String getGLVersion() {
        return this.strGLVersion;
    }

    private void setGLVersion(String strGLVersion) {
    }
}
