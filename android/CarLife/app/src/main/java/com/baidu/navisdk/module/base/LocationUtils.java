package com.baidu.navisdk.module.base;

import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;

public class LocationUtils {
    public static int getCurrentCityId() {
        DistrictInfo district = GeoLocateModel.getInstance().getCurrentDistrict();
        if (district != null) {
            return district.mId;
        }
        return -1;
    }
}
