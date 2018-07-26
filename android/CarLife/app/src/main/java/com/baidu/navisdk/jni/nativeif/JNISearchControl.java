package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class JNISearchControl implements JNISearchConst {
    public static JNISearchControl sInstance = new JNISearchControl();

    public native int GetNetMode();

    public native int GetNetModeOfLastResult();

    public native int RouteSearchForMapPoiResultPB(Bundle bundle, Bundle bundle2);

    public native int SetNetMode(int i);

    public native int UpdateFavPoiCache(ArrayList<Bundle> arrayList, int i);

    public native int cancelQuery();

    public native int clearBkgCache();

    public native int clearFavPoiCache();

    public native int clearPoiCache();

    public native int getChildDistrict(int i, ArrayList<Bundle> arrayList);

    public native int getDistrictInfoById(int i, Bundle bundle);

    public native int getDistrictInfoByPoint(Bundle bundle, Bundle bundle2);

    public native int getInputSug(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int getNearestPoiByPoint(Bundle bundle, Bundle bundle2);

    public native int getParentDistrict(int i, Bundle bundle);

    public native int getTopDistrict(Bundle bundle);

    public native int initSugSubSys(int i);

    public native int inputIndex(Bundle bundle);

    public native int releaseSugSubSys();

    public native int searchAroundParks(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByCircle(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByCircleForMapPoiResultPB(Bundle bundle, Bundle bundle2);

    public native int searchByCircleWithPager(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByFather(Bundle bundle, int[] iArr, ArrayList<Bundle> arrayList);

    public native int searchByKeyInRouteWithPager(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByName(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByNameForMapPoiResultPB(Bundle bundle, Bundle bundle2);

    public native int searchByNameForPBData(Bundle bundle, Bundle bundle2);

    public native int searchByNameWithPager(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int updateBkgCache(ArrayList<Bundle> arrayList, int i);

    public native int updatePoiCache(Bundle bundle);

    public native int updatePoiCacheWithList(ArrayList<Bundle> arrayList);

    private JNISearchControl() {
    }

    private DistrictInfo parseDistrictBundle(Bundle districtBundle) {
        if (districtBundle == null) {
            return null;
        }
        DistrictInfo district = new DistrictInfo();
        district.mType = districtBundle.getInt("Type", -1);
        district.mId = districtBundle.getInt("Id", 0);
        district.mCityId = districtBundle.getInt("CityId", -1);
        district.mProvinceId = districtBundle.getInt("ProvinceId", -1);
        district.mName = districtBundle.getString("Name");
        district.mPoint = new GeoPoint(districtBundle.getInt("CenterX", Integer.MIN_VALUE), districtBundle.getInt("CenterY", Integer.MIN_VALUE));
        district.mChildCount = districtBundle.getInt("ChildCount", 0);
        return district;
    }

    public DistrictInfo getDistrictByPoint(GeoPoint point, int netMode) {
        DistrictInfo districtInfo = null;
        if (point != null) {
            Bundle input = new Bundle();
            input.putInt("CenterX", point.getLongitudeE6());
            input.putInt("CenterY", point.getLatitudeE6());
            Bundle districtBundle = new Bundle();
            try {
                if (sInstance.getDistrictInfoByPoint(input, districtBundle) == 0) {
                    districtInfo = parseDistrictBundle(districtBundle);
                }
            } catch (Throwable th) {
            }
        }
        return districtInfo;
    }

    public DistrictInfo getDistrictById(int districtId) {
        DistrictInfo districtInfo = null;
        Bundle districtBundle = new Bundle();
        try {
            if (sInstance.getDistrictInfoById(districtId, districtBundle) == 0) {
                districtInfo = parseDistrictBundle(districtBundle);
            }
        } catch (Throwable th) {
        }
        return districtInfo;
    }

    public DistrictInfo getParentDistrict(int childDistrictId) {
        DistrictInfo districtInfo = null;
        try {
            Bundle districtBundle = new Bundle();
            if (sInstance.getParentDistrict(childDistrictId, districtBundle) == 0) {
                districtInfo = parseDistrictBundle(districtBundle);
            }
        } catch (Throwable th) {
        }
        return districtInfo;
    }

    public DistrictInfo getTopDistrict() {
        DistrictInfo districtInfo = null;
        try {
            Bundle districtBundle = new Bundle();
            if (sInstance.getTopDistrict(districtBundle) == 0) {
                districtInfo = parseDistrictBundle(districtBundle);
            }
        } catch (Throwable th) {
        }
        return districtInfo;
    }

    public int getChildDistrictAndParse(int parentDistrictId, ArrayList<DistrictInfo> childDistrict) {
        if (childDistrict == null) {
            return -1;
        }
        ArrayList<Bundle> districtBundleList = new ArrayList();
        if (sInstance.getChildDistrict(parentDistrictId, districtBundleList) != 0) {
            return -3;
        }
        int districtCount = districtBundleList.size();
        int outDistrictCount = 0;
        for (int i = 0; i < districtCount; i++) {
            DistrictInfo district = parseDistrictBundle((Bundle) districtBundleList.get(i));
            if (district != null) {
                childDistrict.add(district);
                outDistrictCount++;
            }
        }
        return outDistrictCount;
    }

    public DistrictInfo getParentDistrict(int childDistrictId, int netMode) {
        DistrictInfo districtInfo = null;
        try {
            Bundle districtBundle = new Bundle();
            if (sInstance.getParentDistrict(childDistrictId, districtBundle) == 0) {
                districtInfo = parseDistrictBundle(districtBundle);
            }
        } catch (Throwable th) {
        }
        return districtInfo;
    }

    public int getCompDistrictId(int districtId) {
        if (districtId == -1) {
            return districtId;
        }
        DistrictInfo district = sInstance.getDistrictById(districtId);
        if (district == null) {
            district = new DistrictInfo();
            district.mId = districtId;
        }
        int compDistrictId = district.mId;
        if (district.mType == 3) {
            DistrictInfo provinceDistrict = sInstance.getParentDistrict(district.mId);
            if (provinceDistrict != null && provinceDistrict.mType == 2) {
                compDistrictId = ((provinceDistrict.mId << 16) & -65536) | (district.mId & 65535);
            }
        } else if (district.mType == 2) {
            compDistrictId = (district.mId << 16) & -65536;
        }
        LogUtil.m15791e("", "compDistrictId: " + compDistrictId);
        return compDistrictId;
    }

    public int getCompDistrictId(DistrictInfo district) {
        int compDistrictId = district.mId;
        if (district.mType == 3) {
            if (district.mProvinceId == -1) {
                DistrictInfo provinceDistrict = sInstance.getParentDistrict(district.mId);
                if (provinceDistrict != null && provinceDistrict.mType == 2) {
                    compDistrictId = ((provinceDistrict.mId << 16) & -65536) | (district.mId & 65535);
                }
            } else {
                compDistrictId = ((district.mProvinceId << 16) & -65536) | (district.mId & 65535);
            }
        } else if (district.mType == 2) {
            compDistrictId = (district.mId << 16) & -65536;
        }
        LogUtil.m15791e("", "compDistrictId: " + compDistrictId);
        return compDistrictId;
    }

    public boolean updatePoiCache(GeoPoint point) {
        if (point == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("Id", 0);
            bundle.putString("Name", JNISearchConst.LAYER_POI);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, point.getLongitudeE6());
            bundle.putInt("Latitude", point.getLatitudeE6());
            if (sInstance.updatePoiCache(bundle) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean updateBkgPoiCache(GeoPoint point, boolean isMadian, int poiIndex) {
        if (point == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("Id", 0);
            bundle.putString("Name", JNISearchConst.LAYER_POI);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, point.getLongitudeE6());
            bundle.putInt("Latitude", point.getLatitudeE6());
            bundle.putBoolean(JNISearchConst.JNI_IS_MADIAN, isMadian);
            bundle.putInt(JNISearchConst.JNI_FOCUS_INDEX, poiIndex);
            if (sInstance.updatePoiCache(bundle) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public DistrictInfo[] getDistrictsByPoint(GeoPoint point) {
        DistrictInfo[] districts = new DistrictInfo[2];
        if (point != null) {
            if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                districts[0] = sInstance.getDistrictByPoint(point, 0);
                if (districts[0] != null) {
                    if (districts[0].mType <= 2) {
                        districts[0] = null;
                    } else if (districts[0].mType == 4) {
                        DistrictInfo info = getParentDistrict(districts[0].mId, 0);
                        if (info == null || info.mType != 3) {
                            districts[0] = null;
                        } else {
                            districts[0] = info;
                            districts[1] = getParentDistrict(districts[0].mId, 0);
                        }
                    } else {
                        districts[1] = getParentDistrict(districts[0].mId, 0);
                        if (!(districts[1] == null || districts[1].mType == 2)) {
                            districts[1] = null;
                        }
                    }
                }
            }
            if (NetworkUtils.getConnectStatus()) {
                if (districts[0] == null) {
                    districts[0] = sInstance.getDistrictByPoint(point, 1);
                    LogUtil.m15791e("", "get online, district: " + districts[0]);
                    if (districts[0] != null && districts[0].mType == 3) {
                        districts[1] = getParentDistrict(districts[0].mId, 1);
                        LogUtil.m15791e("", "get online, parent district: " + districts[1]);
                    }
                }
                if (districts[1] == null && districts[0] != null) {
                    districts[1] = getParentDistrict(districts[0].mId, 1);
                }
            }
        }
        return districts;
    }

    public SearchPoi parsePoiBundle(Bundle poiBundle) {
        if (poiBundle == null) {
            return null;
        }
        SearchPoi poi = new SearchPoi();
        poi.mName = StringUtils.trimString(poiBundle.getString("Name"));
        poi.mAddress = StringUtils.trimString(poiBundle.getString(JNISearchConst.JNI_ADDRESS));
        poi.mPhone = poiBundle.getString(JNISearchConst.JNI_PHONE);
        poi.mGuidePoint = new GeoPoint(poiBundle.getInt(JNISearchConst.JNI_GUIDE_LONGITUDE, Integer.MIN_VALUE), poiBundle.getInt(JNISearchConst.JNI_GUIDE_LATITUDE, Integer.MIN_VALUE));
        poi.mViewPoint = new GeoPoint(poiBundle.getInt(JNISearchConst.JNI_VIEW_LONGITUDE, Integer.MIN_VALUE), poiBundle.getInt(JNISearchConst.JNI_VIEW_LATITUDE, Integer.MIN_VALUE));
        poi.mDistrictId = poiBundle.getInt("DistrictId", 0);
        poi.mType = poiBundle.getInt("Type", 0);
        poi.mStreetId = poiBundle.getString(JNISearchConst.JNI_STREET_ID);
        if (poi.mStreetId != null && poi.mStreetId.length() <= 0) {
            poi.mStreetId = null;
        }
        poi.mId = poiBundle.getInt("Id", 0);
        if (poiBundle.containsKey(JNISearchConst.JNI_POI_ORIGIN_UID)) {
            poi.mOriginUID = poiBundle.getString(JNISearchConst.JNI_POI_ORIGIN_UID);
        }
        poi.mWeight = poiBundle.getInt(JNISearchConst.JNI_WEIGHT, 0);
        return poi;
    }

    public SearchPoi parseParChildPoiBundle(Bundle poiBundle) {
        if (poiBundle == null) {
            return null;
        }
        SearchPoi poi = new SearchPoi();
        poi.mName = StringUtils.trimString(poiBundle.getString("Name"));
        poi.mAliasName = StringUtils.trimString(poiBundle.getString(JNISearchConst.JNI_ALIAS_NAME));
        poi.mAddress = StringUtils.trimString(poiBundle.getString(JNISearchConst.JNI_ADDRESS));
        Bundle viewPointBundle = poiBundle.getBundle(JNISearchConst.JNI_VIEW_POINT);
        poi.mViewPoint = new GeoPoint(viewPointBundle.getInt("lon"), viewPointBundle.getInt("lat"));
        Bundle guidPointBundle = poiBundle.getBundle(JNISearchConst.JNI_VIEW_POINT);
        poi.mGuidePoint = new GeoPoint(guidPointBundle.getInt("lon"), guidPointBundle.getInt("lat"));
        poi.mDistrictId = poiBundle.getInt("DistrictId", 0);
        poi.mType = poiBundle.getInt("Type", 0);
        poi.mStreetId = poiBundle.getString(JNISearchConst.JNI_STREET_ID);
        if (poi.mStreetId != null && poi.mStreetId.length() <= 0) {
            poi.mStreetId = null;
        }
        poi.mId = poiBundle.getInt("Id", 0);
        if (poiBundle.containsKey(JNISearchConst.JNI_POI_ORIGIN_UID)) {
            poi.mOriginUID = poiBundle.getString(JNISearchConst.JNI_POI_ORIGIN_UID);
        }
        if (poiBundle.containsKey(JNISearchConst.KEY_UID)) {
            poi.mUid = String.valueOf(poiBundle.getCharArray(JNISearchConst.KEY_UID));
        }
        poi.mWeight = poiBundle.getInt(JNISearchConst.JNI_WEIGHT, 0);
        poi.mChildCnt = poiBundle.getInt(JNISearchConst.JNI_CHILD_CNT, 0);
        poi.mShowCatalog = poiBundle.getInt(JNISearchConst.JNI_SHOW_CATALOG, 0);
        poi.mFCType = poiBundle.getInt(JNISearchConst.JNI_FC_TYPE, 0);
        poi.mPoiCount = poiBundle.getInt("PoiCount", 0);
        poi.mWanda = poiBundle.getInt(JNISearchConst.JNI_WAN_DA, -1);
        return poi;
    }
}
