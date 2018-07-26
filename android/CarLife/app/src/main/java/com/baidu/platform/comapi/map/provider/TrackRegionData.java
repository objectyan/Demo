package com.baidu.platform.comapi.map.provider;

import java.util.ArrayList;

public class TrackRegionData {
    public boolean isNewFlag;
    public String name;
    public ArrayList<Integer> region = new ArrayList();
    public int regionType;
    public int trackNum;
    public String uid;

    public enum Type {
        PROVINCE,
        DISTRIC
    }

    public String toString() {
        return "TrackRegionData{name='" + this.name + '\'' + ", uid='" + this.uid + '\'' + ", region=" + this.region + ", isNewFlag=" + this.isNewFlag + ", trackNum=" + this.trackNum + '}';
    }

    public boolean equals(Object o) {
        if (!(o instanceof TrackRegionData)) {
            return super.equals(o);
        }
        return this.name.equals(((TrackRegionData) o).name);
    }
}
