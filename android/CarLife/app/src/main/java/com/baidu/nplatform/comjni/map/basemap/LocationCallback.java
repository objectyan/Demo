package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.navisdk.util.common.StringUtils;

public class LocationCallback {
    private static String strJsonData = null;

    public static void setData(String str) {
        if (StringUtils.isNotEmpty(str)) {
            strJsonData = str;
        }
    }

    public static boolean GetLocationLayerData(Bundle b) {
        if (StringUtils.isEmpty(strJsonData)) {
            return false;
        }
        if (b != null) {
            b.putString("jsondata", strJsonData);
        }
        return true;
    }
}
