package com.baidu.navi.favorite.http;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.navi.favorite.model.FamilyAndCompanyRequestModel;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.C4794a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FamilyAndCompanySyncRequest extends C1626e {
    private FamilyAndCompanyRequestModel requestModel;

    public FamilyAndCompanySyncRequest() {
        this.tag = FamilyAndCompanySyncRequest.class.getSimpleName();
    }

    public void setParamsModel(FamilyAndCompanyRequestModel model) {
        this.requestModel = model;
    }

    protected String getUrl() {
        return "http://automap.baidu.com/naviauto/?__c=tps&rt=usercenter&ctime=" + this.requestModel.getCtime() + "&auth_id=" + this.requestModel.getAuthId() + "&sign=" + this.requestModel.getSign() + "&fromapp=carlife";
    }

    protected C1622d getUrlParams() {
        return null;
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("bduss", this.requestModel.getBduss());
        params.put("ofmt", "json");
        params.put("data", this.requestModel.getData());
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        return -4;
    }

    public void reponseNoJsonCallBack(String response) {
        int code = -4;
        try {
            String str = new String(C4794a.m15888b(AuthTokenSyncRequest.KEY, AuthTokenSyncRequest.hex2byte(response.trim())));
            if (!TextUtils.isEmpty(str)) {
                JSONArray jsonArray = new JSONObject(str).optJSONObject("result").optJSONArray("content");
                LogUtil.m15791e("Family", "result" + jsonArray.toString());
                Bundle homeBundle;
                Bundle comBundle;
                if (jsonArray == null || jsonArray.length() == 0) {
                    AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
                    AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
                    homeBundle = new Bundle();
                    homeBundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
                    UIModel.getInstance();
                    UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), homeBundle);
                    comBundle = new Bundle();
                    comBundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
                    UIModel.getInstance();
                    UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), comBundle);
                    code = 0;
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean(PreferenceHelperConst.FAMILY_HAS_SYNCED, false);
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean(PreferenceHelperConst.COMPANY_HAS_SYNCED, false);
                } else if (jsonArray.length() == 1) {
                    jsonContent = (JSONObject) jsonArray.get(0);
                    key = jsonContent.optString("key");
                    name = jsonContent.optString("name");
                    locX = 0;
                    locY = 0;
                    mBundle = CoordinateTransformUtil.MC2LL(jsonContent.optInt("locx"), jsonContent.optInt("locy"));
                    poiId = jsonContent.optString("poi_id");
                    if (mBundle != null) {
                        locX = (int) (mBundle.getDouble("LLx") * 100000.0d);
                        locY = (int) (mBundle.getDouble("LLy") * 100000.0d);
                    }
                    if ("home".equals(key)) {
                        AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), name, name, locX, locY, poiId);
                        AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
                        homeBundle = new Bundle();
                        homeBundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
                        UIModel.getInstance();
                        UIModel.syncAddressToCoDriver(getSearchPoi(name, name, locX, locY), homeBundle);
                        comBundle = new Bundle();
                        comBundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
                        UIModel.getInstance();
                        UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), comBundle);
                    } else {
                        AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), name, name, locX, locY, poiId);
                        AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), "", "", 0, 0, "");
                        homeBundle = new Bundle();
                        homeBundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
                        UIModel.getInstance();
                        UIModel.syncAddressToCoDriver(getSearchPoi("", "", 0, 0), homeBundle);
                        comBundle = new Bundle();
                        comBundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
                        UIModel.getInstance();
                        UIModel.syncAddressToCoDriver(getSearchPoi(name, name, locX, locY), comBundle);
                    }
                    code = 0;
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean(PreferenceHelperConst.FAMILY_HAS_SYNCED, false);
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean(PreferenceHelperConst.COMPANY_HAS_SYNCED, false);
                } else if (jsonArray.length() == 2) {
                    for (int i = 0; i < 2; i++) {
                        jsonContent = (JSONObject) jsonArray.get(i);
                        key = jsonContent.optString("key");
                        name = jsonContent.optString("name");
                        locX = 0;
                        locY = 0;
                        mBundle = CoordinateTransformUtil.MC2LL(jsonContent.optInt("locx"), jsonContent.optInt("locy"));
                        poiId = jsonContent.optString("poi_id");
                        if (mBundle != null) {
                            locX = (int) (mBundle.getDouble("LLx") * 100000.0d);
                            locY = (int) (mBundle.getDouble("LLy") * 100000.0d);
                        }
                        if ("home".equals(key)) {
                            AddressSettingModel.setHomeAddress(BNaviModuleManager.getContext(), name, name, locX, locY, poiId);
                            homeBundle = new Bundle();
                            homeBundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
                            UIModel.getInstance();
                            UIModel.syncAddressToCoDriver(getSearchPoi(name, name, locX, locY), homeBundle);
                        } else if ("company".equals(key)) {
                            AddressSettingModel.setCompAddress(BNaviModuleManager.getContext(), name, name, locX, locY, poiId);
                            comBundle = new Bundle();
                            comBundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
                            UIModel.getInstance();
                            UIModel.syncAddressToCoDriver(getSearchPoi(name, name, locX, locY), comBundle);
                        }
                    }
                    code = 0;
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean(PreferenceHelperConst.FAMILY_HAS_SYNCED, false);
                    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putBoolean(PreferenceHelperConst.COMPANY_HAS_SYNCED, false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifyResponseListener(code);
    }

    public SearchPoi getSearchPoi(String name, String address, int longitude, int latitude) {
        GeoPoint geoPoint = new GeoPoint(longitude, latitude);
        SearchPoi searchPoi = new SearchPoi();
        searchPoi.mGuidePoint = geoPoint;
        searchPoi.mName = name;
        searchPoi.mAddress = address;
        return searchPoi;
    }
}
