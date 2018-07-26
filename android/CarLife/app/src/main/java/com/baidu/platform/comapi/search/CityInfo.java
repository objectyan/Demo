package com.baidu.platform.comapi.search;

import com.baidu.entity.pb.CityResult.Content.Sgeo;
import com.baidu.platform.comapi.basestruct.Point;

public class CityInfo {
    public static final CityInfo DEFAULT_CITYINFO = new CityInfo();
    public int mCityCode;
    public Point mCityGeo;
    public String mCityName;
    public int mCityType;
    public String mCityUid;
    public int mLevel;
    public int mPreCityCode;
    public String mPreCityName;
    public int mResultType;
    public Sgeo mSgeo;
    public boolean mSup_bus;
    public boolean mSup_lukuang;
    public boolean mSup_subway;
    public String mcName;
}
