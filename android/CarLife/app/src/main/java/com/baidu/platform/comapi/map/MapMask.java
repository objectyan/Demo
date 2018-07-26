package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.List;

public class MapMask extends Polygon {
    private int screenHeight;
    private int screenWidth;

    public MapMask(Style style) {
        super(style);
        this.styleType = 4;
    }

    public void setMaskScreenPoints(List<Point> points, int screenWidth, int screenHeight) {
        if (points == null) {
            throw new IllegalArgumentException("points list can not be null!");
        } else if (points.size() < 3) {
            throw new IllegalArgumentException("points count can not be less than three!");
        } else {
            this.screenHeight = screenHeight;
            this.screenWidth = screenWidth;
            List<GeoPoint> geoPoints = new ArrayList();
            for (Point p : points) {
                geoPoints.add(new GeoPoint(((double) (-p.getIntY())) + (((double) screenHeight) / 2.0d), ((double) p.getIntX()) - (((double) screenWidth) / 2.0d)));
            }
            super.setPoints(geoPoints);
        }
    }

    public void setPoints(List<GeoPoint> points) {
        List<GeoPoint> geoPoints = new ArrayList();
        for (GeoPoint p : points) {
            geoPoints.add(new GeoPoint((-p.getLatitude()) + (((double) this.screenHeight) / 2.0d), p.getLongitude() - (((double) this.screenWidth) / 2.0d)));
        }
        super.setPoints(geoPoints);
    }
}
