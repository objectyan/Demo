package com.baidu.platform.comjni.tools;

import android.os.Bundle;

public class BundleKeySet {
    public String[] getBundleKeys(Bundle b) {
        String[] strArr = null;
        if (!(b == null || b.isEmpty())) {
            strArr = new String[b.size()];
            int i = 0;
            for (Object jie : b.keySet()) {
                strArr[i] = jie.toString();
                i++;
            }
        }
        return strArr;
    }
}
