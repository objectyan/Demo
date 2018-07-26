package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.BNaviEngineManager;

public class JNIOfflineDataControl {

    private static class LazyHolder {
        private static JNIOfflineDataControl sInstance = new JNIOfflineDataControl();

        private LazyHolder() {
        }
    }

    public native boolean CopyProvinceMapData(int i);

    public native int DownLoadCityMapData(int i);

    public native boolean GetUpdatedInfo(int i, Bundle bundle);

    public native boolean UpdateCountryInfoFromCfg();

    public native int cancelUpdateData(int i);

    public native boolean checkCitySpeakDataDownload(int i, int i2);

    public native boolean checkNewVer(Bundle bundle, int[] iArr);

    public native int checkVer(int[] iArr, int[] iArr2);

    public native int downLoadAppData();

    public native int downloadData(int i);

    public native int downloadDataRequest(int i);

    public native int getItemTable(int i, Bundle[] bundleArr);

    public native int getProvinceMapFileId(int i, int[] iArr, int[] iArr2);

    public native int pauseAppDataDownLoad();

    public native int removeAppData();

    public native int removeDownloadData(int i);

    public native boolean renameProvinceData(int i);

    public native int suspendDownloadData(int i);

    public native int updateData(int i);

    public static JNIOfflineDataControl getInstance() {
        return LazyHolder.sInstance;
    }

    private JNIOfflineDataControl() {
        BNaviEngineManager.getInstance().initSubSysHandle(3);
    }
}
