package com.baidu.baidunavis.control;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import java.io.File;

public class NavComponentController {
    private static final String COM_COLLADA_NAME = "map.android.baidu.collada";
    public static final String TAG = NavComponentController.class.getSimpleName();
    private static NavComponentController sInstance = null;
    public boolean isColladaInit = false;

    private NavComponentController() {
    }

    public static NavComponentController getInstance() {
        if (sInstance == null) {
            sInstance = new NavComponentController();
        }
        return sInstance;
    }

    public void loadColladaSo(boolean isDownload) {
        NavLogUtils.m3003e(TAG, " loadColladaSo  isDownload " + isDownload);
        try {
            NavLogUtils.m3003e(TAG, " loadColladaSo  isColladaInit " + this.isColladaInit);
            String path = NavMapAdapter.getInstance().getBaiduMapApplicationInstance().getFilesDir().getParentFile().getAbsolutePath() + File.separator + "lib" + File.separator + "libapp_colladalib.so";
            NavLogUtils.m3003e(TAG, "getFilesDir " + path);
            if (new File(path).exists()) {
                NavLogUtils.m3003e(TAG, "getFilesDir " + path);
                this.isColladaInit = JNIBaseMap.ColladaModuleInit(path);
                JNIBaseMap.ColladaEnable(true);
            } else {
                NavLogUtils.m3003e(TAG, "getFilesDir ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.isColladaInit = false;
        }
        NavLogUtils.m3003e(TAG, " loadColladaSo  isColladaInit " + this.isColladaInit);
    }

    public boolean dispatchCollada(boolean isDownload) {
        NavLogUtils.m3003e(TAG, " dispatchCollada  isColladaInit " + this.isColladaInit + " isDownload " + isDownload);
        return this.isColladaInit ? false : false;
    }

    public void requestCollada() {
        NavLogUtils.m3003e(TAG, " requestCollada  isColladaInit " + this.isColladaInit);
    }

    public boolean invokeCollada() {
        NavLogUtils.m3003e(TAG, " invokeCollada  isColladaInit " + this.isColladaInit);
        return this.isColladaInit;
    }

    public void addColladaUserOP() {
    }
}
