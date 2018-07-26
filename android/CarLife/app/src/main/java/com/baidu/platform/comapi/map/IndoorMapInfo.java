package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class IndoorMapInfo implements Serializable {
    private static final long serialVersionUID = 3931577061227487973L;
    private String buildingId;
    private int[] floorAttribute;
    private String floorId;
    private String[] floorList;
    private String idrSearch;
    private int idrType;
    private int idrguide;

    public IndoorMapInfo(String buildingId, String floorId) {
        this.buildingId = buildingId;
        this.floorId = floorId;
    }

    public IndoorMapInfo(String buildingId, String floorId, String[] floorList, int[] floorAttribute, int type) {
        this(buildingId, floorId, floorList, floorAttribute, type, 0, "");
    }

    public IndoorMapInfo(String buildingId, String floorId, String[] floorList, int[] floorAttribute, int type, int idrGuide) {
        this(buildingId, floorId, floorList, floorAttribute, type, idrGuide, "");
    }

    public IndoorMapInfo(String buildingId, String floorId, String[] floorList, int[] floorAttribute, int type, int idrguide, String idrSearch) {
        this.buildingId = buildingId;
        this.floorId = floorId;
        this.idrType = type;
        this.idrguide = idrguide;
        if (floorList != null) {
            this.floorList = (String[]) Array.newInstance(String.class, floorList.length);
            System.arraycopy(floorList, 0, this.floorList, 0, floorList.length);
        }
        if (floorAttribute != null) {
            this.floorAttribute = new int[floorAttribute.length];
            System.arraycopy(floorAttribute, 0, this.floorAttribute, 0, floorAttribute.length);
        }
        this.idrSearch = idrSearch;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getFloorId() {
        return this.floorId;
    }

    public final String[] getFloorList() {
        return this.floorList;
    }

    public final int[] getFloorAttribute() {
        return this.floorAttribute;
    }

    public int getIndoorType() {
        return this.idrType;
    }

    public int getIdrguide() {
        return this.idrguide;
    }

    public String getIdrSearch() {
        return this.idrSearch;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof IndoorMapInfo)) {
            return false;
        }
        if (!TextUtils.equals(this.buildingId, ((IndoorMapInfo) o).buildingId)) {
            return false;
        }
        if (!TextUtils.equals(this.floorId, ((IndoorMapInfo) o).floorId)) {
            return false;
        }
        if (Arrays.equals(this.floorList, ((IndoorMapInfo) o).floorList)) {
            return Arrays.equals(this.floorAttribute, ((IndoorMapInfo) o).floorAttribute);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IndoorMapInfo:building_id:").append(this.buildingId);
        stringBuilder.append(";floor_id:").append(this.floorId);
        stringBuilder.append(";indoor_type:").append(this.idrType);
        stringBuilder.append(";floor_list:").append(Arrays.toString(this.floorList));
        stringBuilder.append(";floor_attribute:").append(Arrays.toString(this.floorAttribute));
        return stringBuilder.toString();
    }
}
