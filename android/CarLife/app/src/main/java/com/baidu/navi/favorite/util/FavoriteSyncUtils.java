package com.baidu.navi.favorite.util;

import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.favorite.model.FavoriteSyncRequestModel;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navi.util.NaviAccountUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FavoriteSyncUtils {
    public static final String TAG = FavoriteSyncUtils.class.getSimpleName();

    public static FavoriteSyncRequestModel getSyncDataRequestParams() {
        FavoriteSyncRequestModel model = new FavoriteSyncRequestModel();
        model.bduss = NaviAccountUtils.getInstance().syncGetBduss();
        model.bduid = NaviAccountUtils.getInstance().getUid();
        if (model.bduid == null) {
            model.bduid = "";
        }
        C1260i.b(TAG, "model.bduid:" + model.bduid);
        model.limit = "50";
        model.lastver = FavoritePois.getPoiInstance().getDataVersion();
        model.datas = getDatasStr(model);
        return model;
    }

    public static String getDatasStr(FavoriteSyncRequestModel model) {
        FavoritePois favoritePois = FavoritePois.getPoiInstance();
        JSONArray jsonArray = new JSONArray();
        ArrayList<String> maryKey = favoritePois.getFavPoiGenInfo();
        if (maryKey != null && maryKey.size() > 0) {
            for (int i = 0; i < maryKey.size(); i++) {
                FavSyncPoi syncPoi = favoritePois.getFavPoiInfo((String) maryKey.get(i));
                if (!((!TextUtils.isEmpty(syncPoi.bduid) && !syncPoi.bduid.equals(model.bduid)) || syncPoi == null || syncPoi.getActionType() == 3)) {
                    JSONObject item = favSyncPoiToJsonObject(syncPoi);
                    if (item != null) {
                        jsonArray.put(item);
                        model.addSyncPoi(syncPoi);
                    }
                }
            }
        }
        return jsonArray.toString();
    }

    private static JSONObject favSyncPoiToJsonObject(FavSyncPoi syncPoi) {
        JSONObject jsonObject;
        JSONObject jsonObject2 = null;
        try {
            if (syncPoi.getActionType() == 2) {
                C1260i.b(TAG, "delete");
                if (TextUtils.isEmpty(syncPoi.cId) || TextUtils.isEmpty(syncPoi.sId)) {
                    C1260i.b(TAG, "delete cid || sid is null");
                    return null;
                }
                jsonObject = new JSONObject();
                try {
                    jsonObject.put("cid", syncPoi.cId);
                    jsonObject.put("sid", syncPoi.sId);
                    jsonObject.put(GetPluginInfoDataStruct.KEY_DETAIL, "");
                    jsonObject.put(VoiceKey.ACTION, "del");
                    jsonObject2 = jsonObject;
                } catch (Exception e) {
                    jsonObject2 = jsonObject;
                    return null;
                }
            } else if (syncPoi.getActionType() == 0) {
                C1260i.b(TAG, "add");
                jsonObject = new JSONObject();
                jsonObject.put(VoiceKey.ACTION, "add");
                jsonObject.put("sid", "");
                jsonObject.put("cid", syncPoi.addTimesec);
                JSONObject extdata = new JSONObject();
                extdata.put("name", syncPoi.poiName);
                extdata.put("geoptx", syncPoi.pt.getDoubleX());
                extdata.put("geopty", syncPoi.pt.getDoubleY());
                JSONObject data = new JSONObject();
                data.put("fromapp", "CarLife");
                if (TextUtils.isEmpty(syncPoi.poiId)) {
                    data.put("type", 11);
                    data.put("sourceid", "");
                } else {
                    data.put("type", 10);
                    data.put("sourceid", syncPoi.poiId);
                }
                data.put("plateform", "4");
                data.put("extdata", extdata);
                JSONObject detail = new JSONObject();
                detail.put("data", data.toString());
                jsonObject.put(GetPluginInfoDataStruct.KEY_DETAIL, detail.toString());
                jsonObject2 = jsonObject;
            }
            return jsonObject2;
        } catch (Exception e2) {
            return null;
        }
    }
}
