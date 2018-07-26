package com.baidu.platform.comapi.search.convert;

import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import java.util.ArrayList;
import java.util.List;

public class PBConvertUtil {
    public static boolean stringToBool(String str) {
        return str != null && str.equals("1");
    }

    public static boolean intToBool(int i) {
        return i == 1;
    }

    public static List<Integer> encodePoint(Point point) {
        ArrayList<Integer> array = new ArrayList();
        if (point != null) {
            array.add(Integer.valueOf(point.getIntX()));
            array.add(Integer.valueOf(point.getIntY()));
        } else {
            array.add(Integer.valueOf(0));
            array.add(Integer.valueOf(0));
        }
        return array;
    }

    public static Point decryptPointFromArray(List<? extends Number> list) {
        if (list == null || list.size() < 2) {
            return new Point();
        }
        return new Point(((Number) list.get(0)).doubleValue(), ((Number) list.get(1)).doubleValue());
    }

    public static Point decryptPoint(String geo) {
        return CoordinateUtil.geoStringToPoint(geo);
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            int i2 = i + 1;
            ret[i] = e.intValue();
            i = i2;
        }
        return ret;
    }
}
