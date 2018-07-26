package com.baidu.navi.track.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.datashop.TrackShopEvent;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrackDataSync {
    private static final String TAG = TrackDataSync.class.getSimpleName();
    private static TrackDataSync mInstance;
    private ArrayList<Object> cacheAutoSyncDatas = new ArrayList();
    private ArrayList<String> delDirtyGuids = new ArrayList();
    private HandlerThread handlerThread;
    private boolean isAutoSyncing;
    private boolean isManualSyncing;
    public boolean isMergeDataError = false;
    private boolean isSyncSuccessed;
    private boolean isSyncing;
    private HashMap<Integer, TrackSyncResponseModel> mSyncDataBundleMap = new HashMap();
    private SyncManager mSyncDataMgr = SyncManager.getInstance();
    private List<Object> mainListData;
    private Handler myHandler;
    private long time;

    private class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            C1260i.b(TrackDataSync.TAG, msg.toString());
            TrackDBEvent dbEvent = null;
            TrackShopEvent shopEvent = null;
            if (msg.what == 524) {
                int hasError = msg.arg1;
                switch (msg.arg2) {
                    case 0:
                        if (TrackDataSync.this.time < 1) {
                            TrackDataSync.this.time = System.currentTimeMillis();
                            break;
                        }
                        break;
                    case 15:
                        TrackDataSync.this.isSyncSuccessed = false;
                        TrackDataSync.this.isSyncing = false;
                        TrackShopEvent event = new TrackShopEvent();
                        event.type = 7;
                        event.status = -4;
                        break;
                    case 100:
                        TrackDataSync.this.isSyncSuccessed = hasError == 0;
                        TrackDataSync.this.getSyncDataFromEngine();
                        break;
                    case 2001:
                        C1260i.b("tag", "CLEAN_DATA_OK");
                        break;
                    case 2002:
                        C1260i.b("tag", "CLEAN_DATA_FAIL");
                        break;
                    default:
                        TrackDataSync.this.isSyncSuccessed = false;
                        break;
                }
            }
            if (msg.obj instanceof TrackDBEvent) {
                dbEvent = msg.obj;
            } else if (msg.obj instanceof TrackShopEvent) {
                shopEvent = msg.obj;
            }
            if (dbEvent == null && shopEvent == null) {
                return;
            }
            switch (msg.what) {
                case 1:
                    if (shopEvent.type == 3) {
                        if (shopEvent.status == 0) {
                            TrackDataSync.this.mainListData = shopEvent.list;
                        }
                        Context context = C1157a.a();
                        Intent intent = new Intent(context, DataService.class);
                        intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(TrackDataSync.this.myHandler));
                        intent.putExtra(DataService.EXTRA_NON_UI_EVENT, true);
                        intent.putExtra(DataService.EXTRA_BDUID, NavMapAdapter.getInstance().getUid());
                        intent.setAction(Action.ACTION_READ_TRACK_BY_SYNC_STATE.toString());
                        context.startService(intent);
                        return;
                    }
                    return;
                case 2:
                    if (dbEvent.type == 1 && dbEvent.token == 10001 && dbEvent.status == 0) {
                        TrackDataSync.this.isMergeDataError = true;
                        return;
                    }
                    return;
                case 3:
                    if (dbEvent.type == 11) {
                        int size = TrackDataSync.this.delDirtyGuids.size();
                        TrackDataSync.this.delDirtyGuids.clear();
                        if (dbEvent.token == 10001 && dbEvent.status == 0) {
                            TrackDataSync.this.isMergeDataError = true;
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    if (dbEvent.type == 4) {
                        ArrayList<Object> unSyncData = (ArrayList) dbEvent.list;
                        TrackSyncRequestModel model = new TrackSyncRequestModel();
                        model.updatePhoneInfo();
                        model.uid = NavMapAdapter.getInstance().getUid();
                        model.actionType = "4";
                        model.isResponse = "1";
                        StringBuffer sb = new StringBuffer("");
                        boolean isFirst = true;
                        if (TrackDataSync.this.mainListData != null) {
                            for (Object item : TrackDataSync.this.mainListData) {
                                if (item instanceof CarNaviModel) {
                                    sb.append((isFirst ? "" : ",") + ((CarNaviModel) item).getPBData().getGuid());
                                    isFirst = false;
                                }
                            }
                            TrackDataSync.this.mainListData.clear();
                        }
                        model.guidList = sb.toString();
                        ArrayList<TrackSyncRequestModel> syncData;
                        if (unSyncData == null || unSyncData.size() <= 0) {
                            syncData = new ArrayList();
                            syncData.add(model);
                            boolean syncData2 = SyncManager.getInstance().setSyncData(syncData);
                            C1260i.b(TrackDataSync.TAG, "没有可同步数据");
                        } else {
                            HashMap<String, Integer> updateStateMap = new HashMap();
                            TrackDataSync.this.delDirtyGuids.clear();
                            syncData = TrackSyncUtil.getSyncDataRequestParams(unSyncData, updateStateMap, TrackDataSync.this.delDirtyGuids);
                            if (syncData != null) {
                                syncData.add(model);
                                C1260i.b(TrackDataSync.TAG, "syncData.size = " + syncData.size());
                                if (SyncManager.getInstance().setSyncData(syncData)) {
                                    if (!updateStateMap.isEmpty()) {
                                        TrackSyncUtil.operateDBTransaction(null, Action.ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), updateStateMap, -1);
                                    }
                                    if (TrackDataSync.this.delDirtyGuids.size() > 0) {
                                        TrackSyncUtil.operateDBTransaction(null, Action.ACTION_DELETE_TRACK_BY_GUID_LIST.toString(), TrackDataSync.this.delDirtyGuids, -1);
                                    }
                                } else {
                                    event = new TrackShopEvent();
                                    event.type = 7;
                                    event.status = -1;
                                    TrackDataSync.this.notifySyncRecordsState(event);
                                }
                            } else {
                                syncData = new ArrayList();
                                syncData.add(model);
                                SyncManager.getInstance().setSyncData(syncData);
                            }
                        }
                        TrackDataSync.this.startSync();
                        return;
                    }
                    return;
                case 7:
                    if (dbEvent.type != 18) {
                        return;
                    }
                    if (dbEvent.status == 1) {
                        HashMap<String, Integer> map = dbEvent.map;
                        int token = dbEvent.token;
                        if (!TrackDataSync.this.mSyncDataBundleMap.isEmpty() && token != -1) {
                            TrackSyncUtil.parseSyncDataBundle(TrackDataSync.this.myHandler, (TrackSyncResponseModel) TrackDataSync.this.mSyncDataBundleMap.get(Integer.valueOf(token)), map);
                            TrackDataSync.this.mSyncDataBundleMap.remove(Integer.valueOf(token));
                            return;
                        }
                        return;
                    }
                    C1260i.b(TrackDataSync.TAG, "批量查询指定GUID的List轨迹数据同步状态失败");
                    return;
                case 8:
                    if (dbEvent.type == 7 && dbEvent.token == 10001 && dbEvent.status == 0) {
                        TrackDataSync.this.isMergeDataError = true;
                    }
                    if (dbEvent.token == 10002 && dbEvent.status == 1) {
                        TrackDataSync.this.cleanGetData();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public boolean isSyncing() {
        return this.isManualSyncing;
    }

    private TrackDataSync() {
    }

    public static TrackDataSync getInstance() {
        if (mInstance == null) {
            mInstance = new TrackDataSync();
        }
        return mInstance;
    }

    private void init() {
        if (this.myHandler == null) {
            this.handlerThread = new HandlerThread("TrackDataSyncThread");
            this.handlerThread.start();
            this.myHandler = new MyHandler(this.handlerThread.getLooper());
            this.mSyncDataMgr.registerHandler(this.myHandler);
        }
    }

    private void startSync() {
        if (this.myHandler != null) {
            SyncManager.getInstance().startSync();
        }
    }

    private void stopSync() {
        if (this.myHandler != null) {
            SyncManager.getInstance().stopSync();
        }
    }

    public boolean autoSync(Object object) {
        if (!NaviAccountUtils.getInstance().isLogin() || !NetworkUtils.isNetworkAvailable(C1157a.a())) {
            return false;
        }
        this.cacheAutoSyncDatas.add(object);
        if (this.isSyncing || this.isAutoSyncing) {
            return false;
        }
        init();
        return autoSync(this.cacheAutoSyncDatas);
    }

    public boolean autoSync(ArrayList<Object> unSyncData) {
        if (unSyncData == null || unSyncData.isEmpty()) {
            return false;
        }
        init();
        if (!NaviAccountUtils.getInstance().isLogin() || !NetworkUtils.isNetworkAvailable(C1157a.a())) {
            return false;
        }
        HashMap<String, Integer> updateStateMap = new HashMap();
        this.delDirtyGuids.clear();
        ArrayList<TrackSyncRequestModel> syncData = TrackSyncUtil.getSyncDataRequestParams(unSyncData, updateStateMap, this.delDirtyGuids);
        this.cacheAutoSyncDatas.clear();
        if (syncData != null) {
            C1260i.b(TAG, "syncData.size = " + syncData.size());
            if (SyncManager.getInstance().setSyncData(syncData)) {
                if (!updateStateMap.isEmpty()) {
                    TrackSyncUtil.operateDBTransaction(null, Action.ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST.toString(), updateStateMap, -1);
                }
                if (this.delDirtyGuids.size() > 0) {
                    TrackSyncUtil.operateDBTransaction(null, Action.ACTION_DELETE_TRACK_BY_GUID_LIST.toString(), this.delDirtyGuids, -1);
                }
            }
        }
        this.isAutoSyncing = true;
        startSync();
        return true;
    }

    public boolean manualSync() {
        init();
        if (!NaviAccountUtils.getInstance().isLogin()) {
            return false;
        }
        this.isManualSyncing = true;
        if (this.isAutoSyncing) {
            return true;
        }
        this.isSyncing = true;
        this.isSyncSuccessed = true;
        this.mainListData = null;
        TrackDataShop.getInstance().fetchTrackList(this.myHandler, NavMapAdapter.getInstance().getUid(), 0, 3000, TrackQueryType.CAR);
        return true;
    }

    private void notifySyncRecordsState(TrackShopEvent event) {
        C1261k.a(C1253f.eJ, event);
    }

    private void getSyncDataFromEngine() {
        if (this.mSyncDataMgr != null) {
            TrackSyncResponseModel responseModel = this.mSyncDataMgr.getSyncData();
            if (responseModel != null) {
                int count = responseModel.guidList.size() + responseModel.dataList.size();
                C1260i.b(TAG, "syncData count==" + count);
                if (count > 0) {
                    int token = (int) System.currentTimeMillis();
                    this.mSyncDataBundleMap.put(Integer.valueOf(token), responseModel);
                    TrackSyncUtil.checkTrackStatusInDB(this.myHandler, responseModel, token);
                } else if (count == 0) {
                    solveStateAfterSync();
                }
            }
        }
    }

    private void solveStateAfterSync() {
        if (this.isSyncing) {
            this.isSyncing = false;
            this.isManualSyncing = false;
            TrackShopEvent event = new TrackShopEvent();
            event.type = 7;
            event.status = this.isSyncSuccessed ? 0 : -1;
            TrackConfig.getInstance().setMaxTime(0);
            TrackConfig.getInstance().setTotalDistanse(0);
            TrackConfig.getInstance().setWeekDistanse(0);
            TrackConfig.getInstance().setWeekEndTime(0);
            TrackDataShop.getInstance().fetchStatistics(null, 0);
            TrackConfig.getInstance().setLastSyncTime(System.currentTimeMillis());
            notifySyncRecordsState(event);
        } else if (this.isAutoSyncing) {
            this.isAutoSyncing = false;
            if (this.isManualSyncing) {
                manualSync();
                return;
            }
        }
        autoSync(this.cacheAutoSyncDatas);
    }

    private void cleanGetData() {
        if (this.mSyncDataMgr != null) {
            this.mSyncDataMgr.releaseSyncData();
            solveStateAfterSync();
        }
    }
}
