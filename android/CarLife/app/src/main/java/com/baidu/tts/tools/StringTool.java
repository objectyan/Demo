package com.baidu.tts.tools;

import java.util.Iterator;
import java.util.List;

public class StringTool {
    public static String addDivider(List<String> data, String divider) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = data.iterator();
        if (it.hasNext()) {
            stringBuilder.append((String) it.next());
        }
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuilder.append(divider);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String addDivider(int[] data, String divider) {
        if (data == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(data[0]);
        for (int i = 1; i < data.length; i++) {
            stringBuilder.append(divider);
            stringBuilder.append(data[i]);
        }
        return stringBuilder.toString();
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() > 0) {
            return false;
        }
        return true;
    }

    public static boolean isAllNumber(String str) {
        if (str != null) {
            return str.matches("^[0-9]{1,20}$");
        }
        return false;
    }

    public static boolean isEqual(String left, String right) {
        if (left == null) {
            return right == null;
        } else {
            return left.equals(right);
        }
    }
}
