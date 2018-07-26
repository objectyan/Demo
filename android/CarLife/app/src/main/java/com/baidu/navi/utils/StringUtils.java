package com.baidu.navi.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isCarPlate(String input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        return Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z_0-9]{6,7}$").matcher(input).matches();
    }
}
