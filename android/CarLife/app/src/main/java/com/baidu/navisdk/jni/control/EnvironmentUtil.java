package com.baidu.navisdk.jni.control;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.util.List;

public class EnvironmentUtil {
    public static String getImei() {
        return PackageUtil.getImeiNum();
    }

    public static String getCuid() {
        return PackageUtil.getCuid();
    }

    public static String getAppVersion() {
        return PackageUtil.getVersionName();
    }

    public static String getSdcardPath() {
        return SDCardUtils.getExternalStoragePath();
    }

    public static String getCachePath() {
        return BNaviModuleManager.getContext().getFilesDir().getAbsolutePath() + "/";
    }

    public static String getOsVersion() {
        return VERSION.RELEASE;
    }

    public static String phonetype() {
        if (Build.MODEL == null || TextUtils.isEmpty(Build.MODEL)) {
            return "unKnown";
        }
        return Build.MODEL;
    }

    public static int getsensortype() {
        int accsensor = 0;
        int gyrsensor = 0;
        int magsensor = 0;
        int oresensor = 0;
        int grasensor = 0;
        List<Sensor> mSenList = ((SensorManager) BNaviModuleManager.getContext().getSystemService("sensor")).getSensorList(-1);
        int nsen = mSenList.size();
        if (nsen > 0) {
            for (int i = 0; i < nsen; i++) {
                switch (((Sensor) mSenList.get(i)).getType()) {
                    case 1:
                        accsensor = 1;
                        break;
                    case 2:
                        magsensor = 4;
                        break;
                    case 3:
                        oresensor = 8;
                        break;
                    case 4:
                        gyrsensor = 2;
                        break;
                    case 9:
                        grasensor = 16;
                        break;
                    default:
                        break;
                }
            }
        }
        return (((accsensor | gyrsensor) | magsensor) | oresensor) | grasensor;
    }

    public static int getNetStatus() {
        return NetworkUtils.getNetStatus();
    }

    public static void startSensor() {
    }

    public static void stopSensor() {
    }
}
