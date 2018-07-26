package com.baidu.navi.favorite;

import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.favorite.database.AppFavorite;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navi.track.database.DataService;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FavoritePois {
    private static boolean DEBUG = true;
    public static final int MAX_FAV_POI = 1000;
    public static final String TAG = FavoritePois.class.getSimpleName();
    private static FavoritePois mFavoritePoi = null;
    private boolean isBackGetFavInfoTaskIsRun = false;
    private AppFavorite mAppFavoritePoi = null;
    private String mBduid;
    private Vector<String> mFavAllKeys = null;
    private Vector<String> mFavValidAllKeys = null;
    private boolean mIsFavSortCacheValid = false;
    private boolean mIsFavValidSortCacheValid = false;

    public static FavoritePois getPoiInstance() {
        if (mFavoritePoi == null) {
            synchronized (FavoritePois.class) {
                if (mFavoritePoi == null) {
                    mFavoritePoi = new FavoritePois();
                    mFavoritePoi.initPoiFav();
                }
            }
        }
        return mFavoritePoi;
    }

    private FavoritePois() {
    }

    private boolean initPoiFav() {
        if (this.mAppFavoritePoi == null) {
            this.mAppFavoritePoi = new AppFavorite();
            this.mAppFavoritePoi.create();
        }
        return true;
    }

    public static void destroyPoiFav() {
        if (mFavoritePoi != null) {
            if (mFavoritePoi.mAppFavoritePoi != null) {
                mFavoritePoi.mAppFavoritePoi.destory();
                mFavoritePoi.mAppFavoritePoi = null;
            }
            mFavoritePoi = null;
        }
    }

    public void setBduid(String bduid) {
        this.mBduid = bduid;
    }

    public synchronized int addFavPoiInfo(String strName, FavSyncPoi poiInfo) {
        int flag;
        if (strName != null) {
            if (!(strName.equals("") || poiInfo == null)) {
                invalidFavTempKeys();
                ArrayList<String> data = getFavPoiGenInfo();
                int localSize = 0;
                if (data != null) {
                    localSize = data.size();
                }
                if (data != null && data.size() > 0) {
                    Iterator it = data.iterator();
                    while (it.hasNext()) {
                        FavSyncPoi test = getFavPoiInfo((String) it.next());
                        if (test != null) {
                            if (!TextUtils.isEmpty(test.bduid) && (TextUtils.isEmpty(poiInfo.bduid) || !test.bduid.equals(poiInfo.bduid))) {
                                localSize--;
                            } else if (test.actionType == 2) {
                                localSize--;
                            }
                        }
                    }
                }
                try {
                    String strKey = getAllExistKeyByInfo(poiInfo, data);
                    if (strKey == null) {
                        if (DEBUG) {
                            C1260i.m4435b(TAG, "add info " + poiInfo.toString());
                        }
                        String key = "";
                        JSONObject favSync = new JSONObject();
                        if (poiInfo.isSync) {
                            key = poiInfo.addTimesec;
                            favSync.put("nactiontype", poiInfo.actionType);
                        } else {
                            poiInfo.nId = 0;
                            poiInfo.poiName = strName;
                            key = String.valueOf(System.currentTimeMillis());
                            favSync.put("nactiontype", 0);
                        }
                        favSync.put("bdetail", poiInfo.isDetail);
                        favSync.put("nid", poiInfo.nId);
                        favSync.put("uspoiname", poiInfo.poiName);
                        JSONObject pt = new JSONObject();
                        pt.put("x", poiInfo.pt.getIntX());
                        pt.put("y", poiInfo.pt.getIntY());
                        favSync.put("pt", pt);
                        favSync.put("uscontent", poiInfo.content);
                        favSync.put("npoistyle", poiInfo.poiStyle);
                        favSync.put("ncityid", poiInfo.cityid);
                        favSync.put("npoitype", poiInfo.poiType);
                        favSync.put("uspoiuid", poiInfo.poiId);
                        favSync.put("nversion", poiInfo.version);
                        favSync.put("bissync", poiInfo.isSync);
                        favSync.put("floorid", poiInfo.floorId);
                        favSync.put("buildingid", poiInfo.buildingId);
                        poiInfo.addTimesec = key;
                        favSync.put("addtimesec", poiInfo.addTimesec);
                        favSync.put("sid", "");
                        favSync.put("cid", poiInfo.addTimesec);
                        favSync.put(DataService.EXTRA_BDUID, poiInfo.bduid);
                        JSONObject favbundle = new JSONObject();
                        favbundle.put("Fav_Sync", favSync);
                        favbundle.put("Fav_Content", poiInfo.poiJsonData);
                        if (this.mAppFavoritePoi.add(key, favbundle.toString())) {
                            invalidFavTempKeys();
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                    } else {
                        if (DEBUG) {
                            C1260i.m4435b(TAG, "update info " + poiInfo.toString());
                        }
                        JSONObject syncdata = new JSONObject(this.mAppFavoritePoi.getValue(strKey));
                        JSONObject sync = syncdata.optJSONObject("Fav_Sync");
                        sync.remove("uspoiname");
                        sync.put("uspoiname", poiInfo.poiName);
                        sync.remove("nactiontype");
                        FavSyncPoi syncPoi = getFavPoiInfo(strKey);
                        if (syncPoi == null) {
                            sync.put("nactiontype", 0);
                            if (poiInfo != null) {
                                poiInfo.actionType = 0;
                            }
                        } else if (syncPoi.isSync) {
                            sync.put("nactiontype", 1);
                            if (poiInfo != null) {
                                poiInfo.actionType = 1;
                            }
                        } else if (syncPoi.actionType == 2) {
                            sync.put("nactiontype", 3);
                            sync.put("bissync", true);
                            if (poiInfo != null) {
                                poiInfo.actionType = 3;
                                poiInfo.isSync = true;
                            }
                        } else {
                            sync.put("nactiontype", 0);
                            if (poiInfo != null) {
                                poiInfo.actionType = 0;
                            }
                        }
                        syncdata.remove("Fav_Sync");
                        syncdata.put("Fav_Sync", sync);
                        if (DEBUG) {
                            C1260i.m4435b(TAG, "syncJson: " + sync.toString());
                        }
                        if (this.mAppFavoritePoi.update(strKey, syncdata.toString())) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                    }
                    if (localSize + 1 > 1000) {
                        deleteMoreData(poiInfo.bduid);
                    }
                } catch (JSONException e) {
                    flag = 0;
                }
            }
        }
        flag = -1;
        return flag;
    }

    private synchronized int addDownLoadPoiInfo(String strName, FavSyncPoi poiInfo) {
        int i = 0;
        synchronized (this) {
            if (strName != null) {
                if (!(strName.equals("") || poiInfo == null)) {
                    try {
                        JSONObject favSync = new JSONObject();
                        String key = poiInfo.addTimesec;
                        favSync.put("nactiontype", poiInfo.actionType);
                        favSync.put("bdetail", poiInfo.isDetail);
                        favSync.put("nid", poiInfo.nId);
                        favSync.put("cid", poiInfo.cId);
                        favSync.put("sid", poiInfo.sId);
                        favSync.put(DataService.EXTRA_BDUID, poiInfo.bduid);
                        favSync.put("uspoiname", poiInfo.poiName);
                        JSONObject pt = new JSONObject();
                        pt.put("x", poiInfo.pt.getIntX());
                        pt.put("y", poiInfo.pt.getIntY());
                        favSync.put("pt", pt);
                        favSync.put("uscontent", poiInfo.content);
                        favSync.put("npoistyle", poiInfo.poiStyle);
                        favSync.put("ncityid", poiInfo.cityid);
                        favSync.put("npoitype", poiInfo.poiType);
                        favSync.put("uspoiuid", poiInfo.poiId);
                        favSync.put("nversion", poiInfo.version);
                        favSync.put("bissync", poiInfo.isSync);
                        favSync.put("floorid", poiInfo.floorId);
                        favSync.put("buildingid", poiInfo.buildingId);
                        favSync.put("addtimesec", poiInfo.addTimesec);
                        JSONObject favbundle = new JSONObject();
                        favbundle.put("Fav_Sync", favSync);
                        favbundle.put("Fav_Content", poiInfo.poiJsonData);
                        if (this.mAppFavoritePoi != null && this.mAppFavoritePoi.add(key, favbundle.toString())) {
                            i = 1;
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized boolean deleteFavPoi(String strKey) {
        boolean z = false;
        synchronized (this) {
            if (strKey != null) {
                if (!(strKey.equals("") || this.mAppFavoritePoi == null)) {
                    if (isExistPoiKey(strKey)) {
                        invalidFavTempKeys();
                        try {
                            JSONObject jsonRst = new JSONObject(this.mAppFavoritePoi.getValue(strKey));
                            JSONObject syncData = jsonRst.optJSONObject("Fav_Sync");
                            if (syncData.optBoolean("bissync")) {
                                syncData.remove("nactiontype");
                                syncData.put("nactiontype", 2);
                                jsonRst.remove("Fav_Sync");
                                jsonRst.put("Fav_Sync", syncData);
                                z = this.mAppFavoritePoi.update(strKey, jsonRst.toString());
                            } else {
                                z = this.mAppFavoritePoi.remove(strKey);
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        }
        return z;
    }

    private void invalidFavTempKeys() {
        this.mIsFavSortCacheValid = false;
        this.mIsFavValidSortCacheValid = false;
    }

    public ArrayList<String> getFavPoiGenInfo() {
        if (this.mAppFavoritePoi == null) {
            return null;
        }
        if (this.mIsFavSortCacheValid && this.mFavAllKeys != null) {
            return new ArrayList(this.mFavAllKeys);
        }
        try {
            ArrayList<String> arrayList;
            List<String> keys = this.mAppFavoritePoi.getAllKey();
            if (keys != null) {
                if (this.mFavAllKeys == null) {
                    this.mFavAllKeys = new Vector();
                } else {
                    this.mFavAllKeys.clear();
                }
                for (String tmpKey : keys) {
                    if (!"data_version".equals(tmpKey)) {
                        this.mFavAllKeys.add(tmpKey);
                    }
                }
                if (this.mFavAllKeys.size() > 0) {
                    try {
                        Collections.sort(this.mFavAllKeys, new FavoritePois$FavTmtickComparator(this));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    this.mIsFavSortCacheValid = true;
                }
            } else if (this.mFavAllKeys != null) {
                this.mFavAllKeys.clear();
                this.mFavAllKeys = null;
            }
            if (this.mFavAllKeys == null || this.mFavAllKeys.size() == 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(this.mFavAllKeys);
            }
            return arrayList;
        } catch (Exception e) {
            return null;
        }
    }

    public synchronized ArrayList<String> getFavPoiValidGenInfo(String bduid) {
        ArrayList<String> arrayList = null;
        synchronized (this) {
            if (this.mAppFavoritePoi != null) {
                if (!this.mIsFavValidSortCacheValid || this.mFavValidAllKeys == null) {
                    try {
                        List<String> keys = this.mAppFavoritePoi.getAllKey();
                        if (keys != null) {
                            if (this.mFavValidAllKeys == null) {
                                this.mFavValidAllKeys = new Vector();
                            } else {
                                this.mFavValidAllKeys.clear();
                            }
                            for (String tmpKey : keys) {
                                if (!"data_version".equals(tmpKey)) {
                                    String strTmp = this.mAppFavoritePoi.getValue(tmpKey);
                                    if (!(strTmp == null || strTmp.equals(""))) {
                                        try {
                                            JSONObject sync = new JSONObject(strTmp).optJSONObject("Fav_Sync");
                                            if ((TextUtils.isEmpty(sync.optString(DataService.EXTRA_BDUID)) || (!TextUtils.isEmpty(bduid) && sync.optString(DataService.EXTRA_BDUID).equals(bduid))) && sync.optInt("nactiontype") != 2) {
                                                this.mFavValidAllKeys.add(tmpKey);
                                            }
                                        } catch (JSONException e) {
                                        }
                                    }
                                }
                            }
                            if (this.mFavValidAllKeys.size() > 0) {
                                try {
                                    Collections.sort(this.mFavValidAllKeys, new FavoritePois$FavTmtickComparator(this));
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                this.mIsFavValidSortCacheValid = true;
                            }
                        } else if (this.mFavValidAllKeys != null) {
                            this.mFavValidAllKeys.clear();
                            this.mFavValidAllKeys = null;
                        }
                        ArrayList<String> arrayList2 = (this.mFavValidAllKeys == null || this.mFavValidAllKeys.isEmpty()) ? null : new ArrayList(this.mFavValidAllKeys);
                        arrayList = arrayList2;
                    } catch (Exception e2) {
                    }
                } else {
                    arrayList = new ArrayList(this.mFavValidAllKeys);
                }
            }
        }
        return arrayList;
    }

    public FavSyncPoi getFavPoiInfo(String strKey) {
        if (this.mAppFavoritePoi == null || strKey == null || strKey.equals("")) {
            return null;
        }
        if (DEBUG) {
            C1260i.m4435b(TAG, "getFavPoiInfo " + strKey);
        }
        try {
            if (!isExistPoiKey(strKey)) {
                return null;
            }
            FavSyncPoi poiInfo = new FavSyncPoi();
            String jsonData = this.mAppFavoritePoi.getValue(strKey);
            if (jsonData == null || jsonData.equals("")) {
                return null;
            }
            JSONObject favRst = new JSONObject(jsonData);
            JSONObject syncRst = favRst.optJSONObject("Fav_Sync");
            String favPoi = favRst.optString("Fav_Content");
            poiInfo.cId = syncRst.optString("cid");
            poiInfo.sId = syncRst.optString("sid");
            poiInfo.nId = syncRst.optInt("nid");
            poiInfo.bduid = syncRst.optString(DataService.EXTRA_BDUID);
            poiInfo.poiName = syncRst.optString("uspoiname");
            JSONObject ptstring = syncRst.optJSONObject("pt");
            poiInfo.pt = new Point((double) ptstring.optInt("x"), (double) ptstring.optInt("y"));
            poiInfo.content = syncRst.optString("uscontent");
            poiInfo.poiStyle = syncRst.optInt("npoistyle");
            poiInfo.cityid = syncRst.optInt("ncityid");
            poiInfo.poiId = syncRst.optString("uspoiuid");
            poiInfo.poiType = syncRst.optInt("npoitype");
            poiInfo.version = syncRst.optInt("nversion");
            poiInfo.isSync = syncRst.optBoolean("bissync");
            poiInfo.actionType = syncRst.optInt("nactiontype");
            poiInfo.addTimesec = syncRst.optString("addtimesec");
            poiInfo.isDetail = syncRst.optBoolean("bdetail");
            poiInfo.floorId = syncRst.optString("floorid");
            poiInfo.buildingId = syncRst.optString("buildingid");
            poiInfo.poiJsonData = favPoi;
            return poiInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDataVersion() {
        if (this.mAppFavoritePoi == null || !this.mAppFavoritePoi.isExist("data_version")) {
            return "0";
        }
        try {
            return new JSONObject(this.mAppFavoritePoi.getValue("data_version")).optString("data_version");
        } catch (JSONException e) {
            return "0";
        }
    }

    public boolean isExistPoiKey(String strKey) {
        return (this.mAppFavoritePoi == null || TextUtils.isEmpty(strKey) || !this.mAppFavoritePoi.isExist(strKey)) ? false : true;
    }

    public String getExistKeyByInfo(FavSyncPoi newPoi) {
        if (newPoi == null) {
            return null;
        }
        ArrayList<String> poiRst = getFavPoiGenInfo();
        if (poiRst == null || poiRst.size() <= 0) {
            return null;
        }
        if (DEBUG) {
            C1260i.m4435b(TAG, "getExistKeyByInfo poiRst.size: " + poiRst.size());
        }
        Iterator it = poiRst.iterator();
        while (it.hasNext()) {
            String poiKey = (String) it.next();
            if (DEBUG) {
                C1260i.m4435b(TAG, "getExistKeyByInfo poikey: " + poiKey);
            }
            FavSyncPoi poi = getFavPoiInfo(poiKey);
            if (poi != null && (TextUtils.isEmpty(poi.bduid) || (!TextUtils.isEmpty(newPoi.bduid) && poi.bduid.equals(newPoi.bduid)))) {
                if (TextUtils.isEmpty(poi.poiId) || !poi.poiId.equals(newPoi.poiId)) {
                    if (poi.pt != null && newPoi.pt != null && Math.abs(poi.pt.getIntX() - newPoi.pt.getIntX()) <= 5 && Math.abs(poi.pt.getIntY() - newPoi.pt.getIntY()) <= 5) {
                        if (poi.getActionType() == 2) {
                            return null;
                        }
                        return poiKey;
                    }
                } else if (poi.getActionType() == 2) {
                    return null;
                } else {
                    return poiKey;
                }
            }
        }
        return null;
    }

    public String getAllExistKeyByInfo(FavSyncPoi newPoi, ArrayList<String> poiRst) {
        if (newPoi == null) {
            return null;
        }
        if (poiRst == null || poiRst.size() <= 0) {
            return null;
        }
        Iterator it = poiRst.iterator();
        while (it.hasNext()) {
            String poiKey = (String) it.next();
            FavSyncPoi poi = getFavPoiInfo(poiKey);
            if (poi != null && (TextUtils.isEmpty(poi.bduid) || (!TextUtils.isEmpty(newPoi.bduid) && poi.bduid.equals(newPoi.bduid)))) {
                if (TextUtils.isEmpty(poi.poiId) || !poi.poiId.equals(newPoi.poiId)) {
                    if (poi.pt != null && newPoi.pt != null && Math.abs(poi.pt.getIntX() - newPoi.pt.getIntX()) <= 5 && Math.abs(poi.pt.getIntY() - newPoi.pt.getIntY()) <= 5) {
                        if (!DEBUG) {
                            return poiKey;
                        }
                        C1260i.m4435b(TAG, "pt == pt");
                        return poiKey;
                    }
                } else if (!DEBUG) {
                    return poiKey;
                } else {
                    C1260i.m4435b(TAG, "poiId == poiId");
                    return poiKey;
                }
            }
        }
        return null;
    }

    private synchronized boolean updateFavPoiInfo(String strKey, FavSyncPoi poiInfo) {
        boolean z = false;
        synchronized (this) {
            if (!(this.mAppFavoritePoi == null || strKey == null || strKey.equals("") || poiInfo == null)) {
                String oldkey = poiInfo.addTimesec;
                try {
                    JSONObject favSync = new JSONObject();
                    favSync.put("nid", poiInfo.nId);
                    favSync.put("cid", poiInfo.cId);
                    favSync.put("sid", poiInfo.sId);
                    favSync.put(DataService.EXTRA_BDUID, poiInfo.bduid);
                    favSync.put("uspoiname", poiInfo.poiName);
                    JSONObject pt = new JSONObject();
                    pt.put("x", poiInfo.pt.getIntX());
                    pt.put("y", poiInfo.pt.getIntY());
                    favSync.put("pt", pt);
                    favSync.put("uscontent", poiInfo.content);
                    favSync.put("npoistyle", poiInfo.poiStyle);
                    favSync.put("ncityid", poiInfo.cityid);
                    favSync.put("npoitype", poiInfo.poiType);
                    favSync.put("uspoiuid", poiInfo.poiId);
                    favSync.put("nversion", poiInfo.version);
                    favSync.put("bissync", poiInfo.isSync);
                    favSync.put("floorid", poiInfo.floorId);
                    favSync.put("buildingid", poiInfo.buildingId);
                    favSync.put("nactiontype", poiInfo.actionType);
                    favSync.put("addtimesec", strKey);
                    if (poiInfo.poiJsonData.equals("")) {
                        favSync.put("bdetail", false);
                    } else {
                        favSync.put("bdetail", true);
                    }
                    JSONObject favbundle = new JSONObject();
                    favbundle.put("Fav_Sync", favSync);
                    favbundle.put("Fav_Content", poiInfo.poiJsonData);
                    this.mAppFavoritePoi.remove(oldkey);
                    z = this.mAppFavoritePoi.add(favSync.optString("addtimesec"), favbundle.toString());
                } catch (JSONException e) {
                }
            }
        }
        return z;
    }

    public void setIsBackGetFavInfoTaskIsRun(boolean b) {
        this.isBackGetFavInfoTaskIsRun = b;
    }

    public boolean isBackGetFavInfoTaskIsRun() {
        return this.isBackGetFavInfoTaskIsRun;
    }

    public synchronized int handleSyncResult(String resultJson, String bduid) {
        int i;
        if (TextUtils.isEmpty(resultJson)) {
            i = -1;
        } else {
            if (DEBUG) {
                C1260i.m4435b(TAG, resultJson);
            }
            setIsBackGetFavInfoTaskIsRun(true);
            if (this.mAppFavoritePoi == null) {
                setIsBackGetFavInfoTaskIsRun(false);
                if (DEBUG) {
                    C1260i.m4435b(TAG, "mAppFavoritePoi == null");
                }
                i = -1;
            } else {
                i = 0;
                String newnum = "0";
                JSONObject jSONObject = new JSONObject(resultJson);
                JSONArray newdataArr = jSONObject.optJSONArray("newdata");
                String lastver = jSONObject.optString("lastver");
                newnum = jSONObject.optString("newnum");
                if (newdataArr == null || lastver.equals("") || newnum.equals("")) {
                    if (DEBUG) {
                        C1260i.m4435b(TAG, "newdataArr == null");
                    }
                    setIsBackGetFavInfoTaskIsRun(false);
                    i = -1;
                    setIsBackGetFavInfoTaskIsRun(false);
                } else {
                    invalidFavTempKeys();
                    if (DEBUG) {
                        C1260i.m4435b(TAG, "newdataArr length:" + newdataArr.length());
                    }
                    for (int i2 = 0; i2 < newdataArr.length(); i2++) {
                        if (DEBUG) {
                            C1260i.m4435b(TAG, "item " + i2);
                        }
                        JSONObject item = newdataArr.optJSONObject(i2);
                        if (item != null) {
                            String status = item.optString("status");
                            int statusI = item.optInt("status");
                            if (status.equals("100") || statusI == 100) {
                                FavSyncPoi syncPoi = new FavSyncPoi();
                                String action = item.optString(VoiceKey.ACTION);
                                syncPoi.sId = item.optString("sid");
                                syncPoi.cId = item.optString("cid");
                                syncPoi.version = item.optInt("ver");
                                if (!TextUtils.isEmpty(action) && !TextUtils.isEmpty(syncPoi.sId) && !TextUtils.isEmpty(syncPoi.cId)) {
                                    if (DEBUG) {
                                        C1260i.m4435b(TAG, action);
                                    }
                                    Iterator it;
                                    String tmpKey;
                                    String jsonRst;
                                    if (action.equals("del")) {
                                        ArrayList<String> allkeysd = getFavPoiGenInfo();
                                        if (allkeysd != null) {
                                            it = allkeysd.iterator();
                                            while (it.hasNext()) {
                                                tmpKey = (String) it.next();
                                                if (this.mAppFavoritePoi == null) {
                                                    break;
                                                } else if (!TextUtils.isEmpty(tmpKey)) {
                                                    jsonRst = this.mAppFavoritePoi.getValue(tmpKey);
                                                    if (!TextUtils.isEmpty(jsonRst)) {
                                                        jSONObject = new JSONObject(new JSONObject(jsonRst).optString("Fav_Sync"));
                                                        if (jSONObject.optString("sid").equals(syncPoi.sId) && jSONObject.optString(DataService.EXTRA_BDUID).equals(bduid)) {
                                                            this.mAppFavoritePoi.remove(tmpKey);
                                                            break;
                                                        }
                                                    }
                                                    continue;
                                                }
                                            }
                                        }
                                    } else {
                                        try {
                                            if (action.equals("modify") || action.equals("add")) {
                                                String detail = item.optString(GetPluginInfoDataStruct.KEY_DETAIL);
                                                if (DEBUG) {
                                                    C1260i.m4435b(TAG, detail);
                                                }
                                                String dataStr = new JSONObject(detail).optString("data");
                                                if (DEBUG) {
                                                    C1260i.m4435b(TAG, dataStr);
                                                }
                                                JSONObject dataJson = new JSONObject(dataStr);
                                                String type = dataJson.optString("type");
                                                if (type.equals(C2142b.f6818b) || type.equals("11")) {
                                                    JSONObject extdata = dataJson.optJSONObject("extdata");
                                                    if (extdata != null) {
                                                        if (DEBUG) {
                                                            C1260i.m4435b(TAG, extdata.toString());
                                                        }
                                                        JSONObject sourcedata = dataJson.optJSONObject("sourcedata");
                                                        if (sourcedata != null) {
                                                            syncPoi.content = sourcedata.optString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
                                                            if (DEBUG) {
                                                                C1260i.m4435b(TAG, "address = " + syncPoi.content);
                                                            }
                                                            if (syncPoi.content.equals("")) {
                                                                syncPoi.content = sourcedata.optString(GeoPointInfo.KEY_ADDR);
                                                                if (DEBUG) {
                                                                    C1260i.m4435b(TAG, "addr = " + syncPoi.content);
                                                                }
                                                                if (syncPoi.content.equals("")) {
                                                                    syncPoi.content = extdata.optString("content");
                                                                }
                                                            }
                                                        } else {
                                                            syncPoi.content = extdata.optString("content");
                                                        }
                                                        if (DEBUG) {
                                                            C1260i.m4435b(TAG, "syncPoi.content = " + syncPoi.content);
                                                        }
                                                        syncPoi.actionType = 3;
                                                        syncPoi.isSync = true;
                                                        syncPoi.poiName = extdata.optString("name");
                                                        syncPoi.pt = new Point((double) extdata.optInt("geoptx"), (double) extdata.optInt("geopty"));
                                                        syncPoi.poiId = dataJson.optString("sourceid");
                                                        syncPoi.bduid = bduid;
                                                        String time = String.valueOf(System.currentTimeMillis());
                                                        String tmptime = time;
                                                        String mtime = dataJson.optString("mtime");
                                                        String ctime = dataJson.optString(DataBaseConstants.CTIME);
                                                        boolean hastime = false;
                                                        if (!mtime.equals("")) {
                                                            tmptime = mtime;
                                                            hastime = true;
                                                        } else if (!ctime.equals("")) {
                                                            tmptime = ctime;
                                                            hastime = true;
                                                        }
                                                        int index = 100;
                                                        while (hastime && index < 900) {
                                                            time = tmptime + index;
                                                            if (this.mAppFavoritePoi == null) {
                                                                break;
                                                            } else if (!this.mAppFavoritePoi.isExist(time)) {
                                                                syncPoi.addTimesec = time;
                                                                break;
                                                            } else {
                                                                index++;
                                                            }
                                                        }
                                                        syncPoi.addTimesec = time;
                                                        if (DEBUG) {
                                                            C1260i.m4435b(TAG, time);
                                                        }
                                                        if (DEBUG) {
                                                            C1260i.m4435b(TAG, action + " " + syncPoi.toString());
                                                        }
                                                        ArrayList<String> allkeys = getFavPoiGenInfo();
                                                        boolean bFine = false;
                                                        if (allkeys != null) {
                                                            it = allkeys.iterator();
                                                            while (it.hasNext()) {
                                                                tmpKey = (String) it.next();
                                                                if (this.mAppFavoritePoi == null) {
                                                                    break;
                                                                } else if (!TextUtils.isEmpty(tmpKey)) {
                                                                    jsonRst = this.mAppFavoritePoi.getValue(tmpKey);
                                                                    if (!(jsonRst == null || jsonRst.equals(""))) {
                                                                        jSONObject = new JSONObject(new JSONObject(jsonRst).optString("Fav_Sync"));
                                                                        C1260i.m4435b(TAG, "bduid:" + syncPoi.bduid + " jsonSync.bduid:" + jSONObject.optString(DataService.EXTRA_BDUID));
                                                                        if (TextUtils.isEmpty(jSONObject.optString(DataService.EXTRA_BDUID)) || jSONObject.optString(DataService.EXTRA_BDUID).equals(syncPoi.bduid)) {
                                                                            if (jSONObject.optString("uspoiuid").equals(syncPoi.poiId)) {
                                                                                bFine = true;
                                                                            } else if (jSONObject.optString("sid").equals(syncPoi.sId)) {
                                                                                bFine = true;
                                                                            } else if (jSONObject.optString("cid").equals(syncPoi.cId)) {
                                                                                bFine = true;
                                                                            }
                                                                            if (bFine) {
                                                                                this.mAppFavoritePoi.remove(tmpKey);
                                                                                if (addDownLoadPoiInfo(syncPoi.poiName, syncPoi) != 1) {
                                                                                    i = -1;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (!bFine) {
                                                            if (DEBUG) {
                                                                C1260i.m4435b(TAG, "bFine = false");
                                                            }
                                                            if (addDownLoadPoiInfo(syncPoi.poiName, syncPoi) != 1) {
                                                                i = -1;
                                                            }
                                                            if (DEBUG) {
                                                                C1260i.m4435b(TAG, "flag:" + i);
                                                            }
                                                        }
                                                    } else if (DEBUG) {
                                                        C1260i.m4435b(TAG, "extdata is null");
                                                    }
                                                } else if (DEBUG) {
                                                    C1260i.m4435b(TAG, "该记录不是点收藏");
                                                }
                                            }
                                        } catch (Exception e) {
                                            if (DEBUG) {
                                                C1260i.m4435b(TAG, e.toString());
                                            }
                                            setIsBackGetFavInfoTaskIsRun(false);
                                            i = -1;
                                            setIsBackGetFavInfoTaskIsRun(false);
                                        } catch (Throwable th) {
                                            setIsBackGetFavInfoTaskIsRun(false);
                                        }
                                    }
                                }
                            } else if (DEBUG) {
                                C1260i.m4435b(TAG, "status != 100");
                            }
                        } else if (DEBUG) {
                            C1260i.m4435b(TAG, "item " + i2 + " == null");
                        }
                    }
                    if (DEBUG) {
                        C1260i.m4435b(TAG, "lastver:" + lastver);
                    }
                    if (!(i == -1 || this.mAppFavoritePoi == null)) {
                        JSONObject jsonversion;
                        if (this.mAppFavoritePoi.isExist("data_version")) {
                            jsonversion = new JSONObject();
                            jsonversion.put("data_version", lastver);
                            this.mAppFavoritePoi.update("data_version", jsonversion.toString());
                        } else {
                            jsonversion = new JSONObject();
                            jsonversion.put("data_version", lastver);
                            this.mAppFavoritePoi.add("data_version", jsonversion.toString());
                        }
                    }
                    invalidFavTempKeys();
                    setIsBackGetFavInfoTaskIsRun(false);
                    setIsBackGetFavInfoTaskIsRun(false);
                    deleteMoreData(bduid);
                    if (i == 0) {
                        try {
                            if (Integer.valueOf(newnum).intValue() > 0) {
                                i = 2;
                            }
                        } catch (NumberFormatException e2) {
                        }
                    }
                }
            }
        }
        return i;
    }

    public synchronized void deleteMoreData(String bduid) {
        if (this.mAppFavoritePoi != null) {
            ArrayList<String> allKeys = getFavPoiValidGenInfo(bduid);
            if (allKeys != null && allKeys.size() > 1000) {
                int i = allKeys.size() - 1;
                while (i >= 1000 && i < allKeys.size()) {
                    deleteFavPoi((String) allKeys.get(i));
                    i--;
                }
            }
        }
    }

    public synchronized boolean cleanAccountSyncData() {
        boolean z = false;
        synchronized (this) {
            C1260i.m4435b(TAG, "cleanAccountSyncData");
            if (!(this.mAppFavoritePoi == null || TextUtils.isEmpty(this.mBduid))) {
                C1260i.m4435b(TAG, "bduid:" + this.mBduid);
                ArrayList<String> allKeys = getFavPoiGenInfo();
                z = true;
                if (allKeys != null) {
                    Iterator it = allKeys.iterator();
                    while (it.hasNext()) {
                        String subkey = (String) it.next();
                        FavSyncPoi mid = getFavPoiInfo(subkey);
                        if (mid != null && mid.isSync && mid.bduid.equals(this.mBduid) && mid.actionType != 2) {
                            z = this.mAppFavoritePoi.remove(subkey);
                        }
                    }
                }
                invalidFavTempKeys();
                if (isExistPoiKey("data_version")) {
                    try {
                        JSONObject jsonversion = new JSONObject();
                        jsonversion.put("data_version", String.valueOf(0));
                        z = this.mAppFavoritePoi.update("data_version", jsonversion.toString());
                    } catch (JSONException e) {
                    }
                }
                FavoriteConfig.getInstance().setLastSyncTime(0);
                FavoriteConfig.getInstance().setIsSynced(false);
                this.mBduid = "";
            }
        }
        return z;
    }

    private synchronized void associationFavPoiToAccount(String bduid) {
        if (!(this.mAppFavoritePoi == null || TextUtils.isEmpty(bduid))) {
            invalidFavTempKeys();
            ArrayList<String> allKeys = getFavPoiGenInfo();
            if (allKeys != null) {
                Iterator it = allKeys.iterator();
                while (it.hasNext()) {
                    String subkey = (String) it.next();
                    FavSyncPoi mid = getFavPoiInfo(subkey);
                    if (mid != null && TextUtils.isEmpty(mid.bduid)) {
                        JSONObject syncdata;
                        JSONObject sync;
                        boolean flag = false;
                        Iterator it2 = allKeys.iterator();
                        while (it2.hasNext()) {
                            String tmpkey = (String) it2.next();
                            FavSyncPoi tmp = getFavPoiInfo(tmpkey);
                            if (!(tmp == null || TextUtils.isEmpty(tmp.bduid) || !tmp.bduid.equals(bduid))) {
                                if (!TextUtils.isEmpty(tmp.poiId) && tmp.poiId.equals(mid.poiId)) {
                                    flag = true;
                                } else if (mid.pt != null && tmp.pt != null && Math.abs(mid.pt.getIntX() - tmp.pt.getIntX()) <= 5 && Math.abs(mid.pt.getIntY() - tmp.pt.getIntY()) <= 5) {
                                    flag = true;
                                }
                                if (flag && this.mAppFavoritePoi != null) {
                                    this.mAppFavoritePoi.remove(subkey);
                                    if (!tmp.isSync && tmp.actionType == 2) {
                                        tmp.actionType = 3;
                                        tmp.isSync = true;
                                        try {
                                            syncdata = new JSONObject(this.mAppFavoritePoi.getValue(tmpkey));
                                            sync = syncdata.optJSONObject("Fav_Sync");
                                            sync.remove("nactiontype");
                                            sync.put("nactiontype", 3);
                                            sync.remove("bissync");
                                            sync.put("bissync", true);
                                            syncdata.remove("Fav_Sync");
                                            syncdata.put("Fav_Sync", sync);
                                            if (DEBUG) {
                                                C1260i.m4435b(TAG, "syncJson: " + sync.toString());
                                            }
                                            this.mAppFavoritePoi.update(tmpkey, syncdata.toString());
                                        } catch (JSONException e) {
                                            if (DEBUG) {
                                                C1260i.m4435b(TAG, e.toString());
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        continue;
                                    } else if (this.mAppFavoritePoi == null) {
                                        try {
                                            syncdata = new JSONObject(this.mAppFavoritePoi.getValue(subkey));
                                            sync = syncdata.optJSONObject("Fav_Sync");
                                            sync.remove(DataService.EXTRA_BDUID);
                                            sync.put(DataService.EXTRA_BDUID, bduid);
                                            syncdata.remove("Fav_Sync");
                                            syncdata.put("Fav_Sync", sync);
                                            if (DEBUG) {
                                                C1260i.m4435b(TAG, "syncJson: " + sync.toString());
                                            }
                                            this.mAppFavoritePoi.update(subkey, syncdata.toString());
                                        } catch (JSONException e2) {
                                            if (DEBUG) {
                                                C1260i.m4435b(TAG, e2.toString());
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                        if (!flag) {
                            continue;
                        } else if (this.mAppFavoritePoi == null) {
                            continue;
                        } else {
                            syncdata = new JSONObject(this.mAppFavoritePoi.getValue(subkey));
                            sync = syncdata.optJSONObject("Fav_Sync");
                            sync.remove(DataService.EXTRA_BDUID);
                            sync.put(DataService.EXTRA_BDUID, bduid);
                            syncdata.remove("Fav_Sync");
                            syncdata.put("Fav_Sync", sync);
                            if (DEBUG) {
                                C1260i.m4435b(TAG, "syncJson: " + sync.toString());
                            }
                            this.mAppFavoritePoi.update(subkey, syncdata.toString());
                        }
                    }
                }
                invalidFavTempKeys();
            }
        }
    }

    public void login(String bduid) {
        this.mBduid = bduid;
        FavoriteConfig.getInstance().setIsSynced(false);
        new Thread(new FavoritePois$1(this, bduid)).start();
    }

    public void logoutCleanUp() {
        new Thread(new FavoritePois$2(this)).start();
    }
}
