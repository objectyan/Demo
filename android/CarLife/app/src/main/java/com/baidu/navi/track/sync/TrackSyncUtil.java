package com.baidu.navi.track.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.datashop.DeleteFileThread;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TrackSyncUtil {
    private static final String TAG = TrackSyncUtil.class.getSimpleName();

    public static ArrayList<TrackSyncRequestModel> getSyncDataRequestParams(ArrayList<Object> unSyncData, HashMap<String, Integer> updateStatusMap, ArrayList<String> arrayList) {
        if (unSyncData == null || unSyncData.isEmpty()) {
            return null;
        }
        ArrayList<TrackSyncRequestModel> requestModels = new ArrayList();
        for (int i = 0; i < unSyncData.size(); i++) {
            TrackSyncRequestModel requestModel = new TrackSyncRequestModel();
            String cid = "";
            String sid = "";
            String action = "";
            String path = "";
            CarNaviModel obj = unSyncData.get(i);
            if (obj instanceof CarNaviModel) {
                int updateAction;
                CarNaviModel car = obj;
                requestModel.isResponse = "0";
                requestModel.updateTime = String.valueOf(car.getPBData().getModifyTime());
                requestModel.guid = car.getPBData().getGuid();
                requestModel.uploadTime = String.valueOf(System.currentTimeMillis() / 1000);
                requestModel.uid = car.getUseId();
                sid = car.getPBData().getSid();
                path = car.getSDcardPath();
                cid = car.getPBData().getGuid();
                if (car.getSyncState() == 0 || 3 == car.getSyncState() || 10 == car.getSyncState()) {
                    updateAction = 10;
                    if (TextUtils.isEmpty(sid)) {
                        action = "1";
                        requestModel.actionType = "1";
                    } else {
                        action = "2";
                        requestModel.actionType = "2";
                    }
                    requestModel.createTime = String.valueOf(car.getPBData().getCtime());
                    requestModel.name = car.getPBData().getStartPoint().getAddr() + JNISearchConst.LAYER_ID_DIVIDER + car.getPBData().getEndPoint().getAddr();
                    requestModel.distance = String.valueOf(car.getPBData().getDistance());
                    requestModel.duration = String.valueOf(car.getPBData().getDuration());
                    requestModel.speed = String.valueOf(car.getPBData().getAvgSpeed());
                    requestModel.maxSpeed = String.valueOf(car.getPBData().getMaxSpeed());
                    requestModel.dataVersion = "1";
                    requestModel.startPosition = car.getPBData().getStartPoint().getLng() + "," + car.getPBData().getStartPoint().getLat();
                    requestModel.endPosition = car.getPBData().getEndPoint().getLng() + "," + car.getPBData().getEndPoint().getLat();
                    requestModel.fileSign = car.getPBData().getSign();
                    requestModel.trackFilePath = car.getSDcardPath();
                    requestModel.type = "2";
                    requestModel.isConn = car.isConnect() ? "1" : "0";
                    requestModel.cuid = car.getCarCuid();
                    requestModel.channel = car.getCarChannel();
                    requestModel.version = car.getCarVersion();
                } else if (2 == car.getSyncState() || 12 == car.getSyncState()) {
                    updateAction = 2;
                    action = "3";
                    requestModel.actionType = "3";
                }
                requestModel.updatePhoneInfo();
                C1260i.b(TAG, "track actionType = " + action);
                requestModels.add(requestModel);
                updateStatusMap.put(cid, Integer.valueOf(updateAction));
            }
        }
        return requestModels;
    }

    public static void parseSyncDataBundle(Handler handler, TrackSyncResponseModel model, HashMap<String, Integer> map) {
        if (model != null) {
            ArrayList<String> delGuids = new ArrayList();
            ArrayList<Object> modifyObjs = new ArrayList();
            ArrayList<Object> addLocalGuids = new ArrayList();
            ArrayList<Object> addServerObjs = new ArrayList();
            HashMap<String, Integer> updateStatusMap = new HashMap();
            Iterator it = model.guidList.iterator();
            while (it.hasNext()) {
                String guid = (String) it.next();
                if (map != null && map.containsKey(guid)) {
                    if (((Integer) map.get(guid)).intValue() == 2) {
                        updateStatusMap.put(guid, Integer.valueOf(1));
                        delGuids.add(guid);
                    } else if (((Integer) map.get(guid)).intValue() == 10) {
                        updateStatusMap.put(guid, Integer.valueOf(1));
                        BaseTrackModel baseTrackModel = new BaseTrackModel();
                        baseTrackModel.guid = guid;
                        baseTrackModel.sid = "111";
                        baseTrackModel.syncState = 1;
                        addLocalGuids.add(baseTrackModel);
                    }
                }
            }
            if (model.isResponse == 1) {
                Iterator it2 = model.dataList.iterator();
                while (it2.hasNext()) {
                    CarNaviModel carNaviModel = (CarNaviModel) it2.next();
                    if (carNaviModel.getSyncState() == 2) {
                        updateStatusMap.put(carNaviModel.getPBData().getGuid(), Integer.valueOf(1));
                        delGuids.add(carNaviModel.getPBData().getGuid());
                    } else if (carNaviModel.getSyncState() == 3) {
                        updateStatusMap.put(carNaviModel.getPBData().getGuid(), Integer.valueOf(1));
                        addServerObjs.add(carNaviModel);
                    }
                }
            }
            if (delGuids.size() > 0) {
                operateDBTransaction(handler, Action.ACTION_DELETE_TRACK_BY_GUID_LIST.toString(), delGuids, 10001);
                new DeleteFileThread(delGuids).start();
            }
            if (modifyObjs.size() > 0) {
                operateDBTransaction(handler, Action.ACTION_UPDATE_TRACK_INFO_BY_LIST.toString(), modifyObjs, 10001);
            }
            if (addLocalGuids.size() > 0) {
                operateDBTransaction(handler, Action.ACTION_UPDATE_TRACK_SYNC_STATE_AND_SID_BY_GUID_LIST.toString(), addLocalGuids, 10001);
            }
            if (addServerObjs.size() > 0) {
                operateDBTransaction(handler, Action.ACTION_WRITE_TRACK_TO_DB.toString(), addServerObjs, 10001);
            }
            operateDBTransaction(handler, Action.ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), updateStatusMap, 10002);
            C1260i.b(TAG, "delGuids.size=" + delGuids.size());
            C1260i.b(TAG, "addLocalGuids.size=" + addLocalGuids.size());
            C1260i.b(TAG, "modifyObjs.size=" + modifyObjs.size());
            C1260i.b(TAG, "addServerObjs.size=" + addServerObjs.size());
            C1260i.b(TAG, "updateStatusMap=" + updateStatusMap);
        }
    }

    public static void checkTrackStatusInDB(Handler handler, TrackSyncResponseModel model, int token) {
        C1260i.b(TAG, "checkTrackStatusInDB model=" + model);
        if (model == null) {
            return;
        }
        if (!model.guidList.isEmpty() || !model.dataList.isEmpty()) {
            ArrayList<String> guids = new ArrayList();
            Iterator it = model.guidList.iterator();
            while (it.hasNext()) {
                guids.add((String) it.next());
            }
            it = model.dataList.iterator();
            while (it.hasNext()) {
                CarNaviModel item = (CarNaviModel) it.next();
                if (item.getPBData().hasGuid()) {
                    guids.add(item.getPBData().getGuid());
                }
            }
            if (guids.size() > 0) {
                operateDBTransaction(handler, Action.ACTION_GET_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), guids, token);
            }
        }
    }

    public static void operateDBTransaction(Handler handler, String action, Object obj, int token) {
        Context context = C1157a.a();
        Intent intent = new Intent(context, DataService.class);
        if (handler != null) {
            intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(handler));
        }
        intent.putExtra(DataService.EXTRA_CACHE_KEY, DataCache.getInstance().addCache(obj));
        intent.putExtra(DataService.EXTRA_NON_UI_EVENT, true);
        if (token != -1) {
            intent.putExtra(DataService.EXTRA_TOKEN_INT_KEY, token);
        }
        intent.setAction(action);
        try {
            context.startService(intent);
        } catch (Exception e) {
            C1260i.b(TAG, "Unable to find BaiduCarLife app process");
        }
    }
}
