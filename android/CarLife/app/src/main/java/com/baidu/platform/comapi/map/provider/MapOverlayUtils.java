package com.baidu.platform.comapi.map.provider;

import com.baidu.platform.comapi.basestruct.MapBound;
import java.util.List;

public class MapOverlayUtils {
    public static MapBound getGeoPointFromDiff(List<Integer> ptList) {
        if (ptList.size() == 0) {
            return null;
        }
        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;
        int tmpX = 0;
        int tmpY = 0;
        for (int i = 0; i < ptList.size(); i++) {
            if (i == 0) {
                tmpX = ((Integer) ptList.get(i)).intValue();
                maxX = tmpX;
                minX = tmpX;
            } else if (i == 1) {
                tmpY = ((Integer) ptList.get(i)).intValue();
                maxY = tmpY;
                minY = tmpY;
            } else if (i % 2 == 0) {
                int x = tmpX + ((Integer) ptList.get(i)).intValue();
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                tmpX = x;
            } else {
                int y = tmpY + ((Integer) ptList.get(i)).intValue();
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                tmpY = y;
            }
        }
        return new MapBound(minX, minY, maxX, maxY);
    }
}
