package com.baidu.platform.comapi.map.provider;

import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderUtils {

    public enum RouteState {
        ENTIRE(1),
        SEGMENT(2);
        
        private int nativeValue;

        private RouteState(int aValue) {
            this.nativeValue = aValue;
        }

        public int getNativeValue() {
            return this.nativeValue;
        }
    }

    static String pathToJson(List<? extends Number> list) {
        JsonBuilder builder = new JsonBuilder();
        builder.arrayValue();
        for (Object i : list) {
            builder.value(i);
        }
        builder.endArrayValue();
        return builder.getJson();
    }

    static List<Integer> connectPath(List<Integer> pre, List<Integer> cur) {
        if (pre == null) {
            return cur;
        }
        ComplexPt preComplexPt = ComplexPt.createComplexPt(pre);
        ComplexPt curComplexPt = ComplexPt.createComplexPt(cur);
        if (preComplexPt == null || preComplexPt.isEmpty() || curComplexPt == null || curComplexPt.isEmpty()) {
            return cur;
        }
        ArrayList<Point> lastPart = (ArrayList) preComplexPt.mGeoPt.get(preComplexPt.mGeoPt.size() - 1);
        ((ArrayList) curComplexPt.mGeoPt.get(0)).add(0, (Point) lastPart.get(lastPart.size() - 1));
        return curComplexPt.toIntArray();
    }

    static List<List<Integer>> splitPath(List<Integer> path, List<Integer> parts) {
        ComplexPt cp = ComplexPt.createComplexPt(path);
        if (cp == null || cp.isEmpty()) {
            return new ArrayList();
        }
        ArrayList<Point> points = new ArrayList();
        Iterator it = cp.mGeoPt.iterator();
        while (it.hasNext()) {
            for (Point p : (List) it.next()) {
                points.add(p);
            }
        }
        List<List<Integer>> pathList = new ArrayList();
        Point lastPoint = null;
        int pos = 0;
        for (Integer i : parts) {
            if (points.size() > i.intValue() + pos) {
                cp.mGeoPt = new ArrayList();
                ArrayList<Point> list = subArrayList(points, pos, i.intValue() + pos);
                if (lastPoint != null) {
                    list.add(0, lastPoint);
                }
                lastPoint = (Point) list.get(list.size() - 1);
                cp.mGeoPt.add(list);
                pathList.add(cp.toIntArray());
                pos += i.intValue();
            }
        }
        return pathList;
    }

    private static <T> ArrayList<T> subArrayList(ArrayList<T> list, int start, int end) {
        if (end == 0) {
            return list;
        }
        ArrayList<T> subList = new ArrayList();
        for (int i = start; i <= end; i++) {
            subList.add(list.get(i));
        }
        return subList;
    }

    static String escapeString(String str) {
        return str.replace("\"", "'");
    }

    public static int dip2px(int dip) {
        return (int) (0.5f + (C2907c.f().getResources().getDisplayMetrics().density * ((float) dip)));
    }

    public static int px2dip(int px) {
        return (int) (0.5f + (((float) px) / C2907c.f().getResources().getDisplayMetrics().density));
    }
}
