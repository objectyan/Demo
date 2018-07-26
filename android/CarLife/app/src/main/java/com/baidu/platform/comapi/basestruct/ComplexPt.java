package com.baidu.platform.comapi.basestruct;

import com.baidu.platform.comapi.location.LocationMgr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexPt {
    public static final int TEN_THOUSAND = 100000;
    public static final int TYPE_LINE = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_POINT = 1;
    public static final int TYPE_POLYGON = 3;
    public int eType;
    public ArrayList<ArrayList<Point>> mGeoPt;
    public Point mLL;
    public Point mRu;

    public static ComplexPt createComplexPt(List<? extends Number> array) {
        if (array == null || array.size() < 2) {
            return null;
        }
        ComplexPt cp = new ComplexPt();
        int size = array.size();
        ArrayList<Point> part;
        if (size >= 5) {
            cp.mLL = new Point(((Number) array.get(0)).doubleValue(), ((Number) array.get(1)).doubleValue());
            cp.mRu = new Point(((Number) array.get(2)).doubleValue(), ((Number) array.get(3)).doubleValue());
            cp.eType = (int) ((Number) array.get(4)).doubleValue();
            cp.mGeoPt = new ArrayList();
            if (size < 7) {
                return cp;
            }
            part = new ArrayList();
            Point last = new Point(((Number) array.get(5)).doubleValue(), ((Number) array.get(6)).doubleValue());
            part.add(last);
            int i = 7;
            Point last2 = last;
            while (i + 1 < size) {
                last = new Point(last2.getDoubleX() + ((Number) array.get(i)).doubleValue(), last2.getDoubleY() + ((Number) array.get(i + 1)).doubleValue());
                part.add(last);
                i += 2;
                last2 = last;
            }
            cp.mGeoPt.add(part);
            return cp;
        } else if (size < 2) {
            return cp;
        } else {
            Point p = new Point(((Number) array.get(0)).doubleValue(), ((Number) array.get(1)).doubleValue());
            part = new ArrayList();
            part.add(p);
            cp.mLL = new Point(p);
            cp.mRu = new Point(p);
            cp.eType = 1;
            cp.mGeoPt = new ArrayList();
            cp.mGeoPt.add(part);
            return cp;
        }
    }

    public ComplexPt toComplexPtGCJ2MC() {
        Point pt;
        if (this.mLL != null) {
            pt = LocationMgr.getInstance().Coordinate_encryptEx(((float) this.mLL.getIntX()) / 100000.0f, ((float) this.mLL.getIntY()) / 100000.0f, "gcj02");
            if (pt != null) {
                this.mLL.setIntX(pt.getIntX());
                this.mLL.setIntY(pt.getIntY());
            }
        }
        if (this.mRu != null) {
            pt = LocationMgr.getInstance().Coordinate_encryptEx(((float) this.mRu.getIntX()) / 100000.0f, ((float) this.mRu.getIntY()) / 100000.0f, "gcj02");
            if (pt != null) {
                this.mRu.setIntX(pt.getIntX());
                this.mRu.setIntY(pt.getIntY());
            }
        }
        if (this.mGeoPt != null && this.mGeoPt.size() > 0 && ((ArrayList) this.mGeoPt.get(0)).size() > 0) {
            for (int i = 0; i < this.mGeoPt.size(); i++) {
                ArrayList<Point> mcArray = LocationMgr.getInstance().Coordinate_encryptExArray((ArrayList) this.mGeoPt.get(i), "gcj02");
                if (mcArray != null) {
                    for (int j = 0; j < mcArray.size(); j++) {
                        ((Point) ((ArrayList) this.mGeoPt.get(i)).get(j)).setTo((Point) mcArray.get(j));
                    }
                }
            }
        }
        return this;
    }

    public ArrayList<Integer> toIntArray() {
        ArrayList<Integer> array = new ArrayList();
        if (this.mLL != null) {
            addPoint(array, this.mLL.getIntX(), this.mLL.getIntY());
        } else {
            addPoint(array, 0, 0);
        }
        if (this.mRu != null) {
            addPoint(array, this.mRu.getIntX(), this.mRu.getIntY());
        } else {
            addPoint(array, 0, 0);
        }
        array.add(Integer.valueOf(this.eType));
        if (this.mGeoPt != null && this.mGeoPt.size() > 0 && ((ArrayList) this.mGeoPt.get(0)).size() > 0) {
            Point last = new Point(0.0d, 0.0d);
            Iterator it = this.mGeoPt.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) it.next()).iterator();
                while (it2.hasNext()) {
                    Point p = (Point) it2.next();
                    addPoint(array, p.getIntX() - last.getIntX(), p.getIntY() - last.getIntY());
                    last = p;
                }
            }
        }
        return array;
    }

    public boolean isEmpty() {
        return this.mGeoPt == null || this.mGeoPt.size() < 1 || ((ArrayList) this.mGeoPt.get(0)).size() < 1;
    }

    public String toString() {
        return "ComplexPt [eType=" + this.eType + ", mLL=" + this.mLL + ", mRu=" + this.mRu + ", mGeoPt=" + this.mGeoPt + "]";
    }

    private void addPoint(List<Integer> array, int x, int y) {
        array.add(Integer.valueOf(x));
        array.add(Integer.valueOf(y));
    }
}
