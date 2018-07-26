package com.baidu.navi.track.database;

import android.app.IntentService;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataService extends IntentService {
    private static final int DEFAULT_STATISTIC_MONTN_LIMIT = 6;
    private static final int DEFAULT_TRACK_LIMIT = 20;
    public static final String EXTRA_BDUID = "bduid";
    public static final String EXTRA_CACHE_KEY = "cache_key";
    public static final String EXTRA_END_TIME = "end_time";
    public static final String EXTRA_FRAGMENT_KEYS = "keys";
    public static final String EXTRA_FRAGMENT_LEVEL = "level";
    public static final String EXTRA_GUID = "guid";
    public static final String EXTRA_HANDLER = "handler";
    public static final String EXTRA_LAST_TIME = "last_time";
    public static final String EXTRA_LIMIT = "limit";
    public static final String EXTRA_NON_UI_EVENT = "non_ui_evnet";
    public static final String EXTRA_QUERY_TYPE = "query_type";
    public static final String EXTRA_START_TIME = "startTime";
    public static final String EXTRA_TOKEN_INT_KEY = "token_int_key";
    public static final String EXTRA_USEID = "useid";
    public static final int MSG_WHAT_BASE_NUMBER = 0;
    public static final int MSG_WHAT_TRACK_ADD_SHOP = 2;
    public static final int MSG_WHAT_TRACK_BY_STATE_SHOP = 6;
    public static final int MSG_WHAT_TRACK_CLEAR_SHOP = 4;
    public static final int MSG_WHAT_TRACK_DELETE_SHOP = 3;
    public static final int MSG_WHAT_TRACK_GET_SYNC_STATE_BY_GUID_SHOP = 7;
    public static final int MSG_WHAT_TRACK_MAIN_LIST_SHOP = 1;
    public static final int MSG_WHAT_TRACK_STATISTICS_SHOP = 5;
    public static final int MSG_WHAT_TRACK_UPDATE_SYNC_STATE_AND_SID_BY_GUID_SHOP = 9;
    public static final int MSG_WHAT_TRACK_UPDATE_SYNC_STATE_BY_GUID_SHOP = 8;
    private static final String TAG = DataService.class.getSimpleName();
    private TrackDao dao;

    public enum Action {
        ACTION_NONE,
        ACTION_WRITE_TRACK_TO_DB,
        ACTION_READ_TRACK_AFTER_TIME,
        ACTION_DELETE_TRACK_BY_GUID,
        ACTION_DELETE_TRACK_BY_GUID_LIST,
        ACTION_CLEAR_TRACK_BY_BDUID,
        ACTION_UPDATE_TRACK_BY_GUID,
        ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST,
        ACTION_UPDATE_TRACK_SYNC_STATE_AND_SID_BY_GUID_LIST,
        ACTION_UPDATE_TRACK_INFO_BY_LIST,
        ACTION_UPDATE_NOT_LOGIN_TRAKS_BDUID,
        ACTION_READ_TRACK_BY_SYNC_STATE,
        ACTION_GET_UNSYNC_TRACK_NUMBER,
        ACTION_GET_TRACK_STATISTICS,
        ACTION_GET_TRACK_MAP_FRAGMENT,
        ACTION_GET_TRACK_GUID_LIST_BY_BDUID,
        ACTION_UPDATE_LOCATION_TRACK_LAST_TIME,
        ACTION_GET_LAST_TRACK_DATA,
        ACTION_GET_TRACK_DATA_BY_GUID,
        ACTION_GET_TRACK_SYNC_STATE_BY_GUID_LIST,
        ACTION_GET_DAYS_LIST_BETWEEN_TIME,
        ACTION_GET_TRACK_BETWEEN_TIME,
        ACTION_DELETE_TRACK_ON_LOCAL_AND_CLOUD_BY_GUID,
        ACTION_FIND_CITY_BY_CITY_HISTORY,
        ACTION_FIND_BUSINESS_BY_BUSINESS_HISTORY
    }

    public DataService() {
        super(DataService.class.getSimpleName());
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.m15791e(TAG, "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m15791e(TAG, "onDestroy");
    }

    protected void onHandleIntent(Intent intent) {
        LogUtil.m15791e(TAG, "intent = " + intent);
        if (intent == null) {
            LogUtil.m15791e(TAG, "intent is null");
            return;
        }
        final Intent paraIntent = intent;
        DataBaseManager.getInstance().executeQurey(new QueryExecutor() {
            public void run(SQLiteDatabase database) {
                DataService.this.dao = new TrackDao(database);
                DataService.this.executeDBAction(paraIntent);
            }
        });
    }

    private void executeDBAction(Intent intent) {
        if (intent == null) {
            LogUtil.m15791e(TAG, "intent is null");
        }
        String action = intent.getAction();
        Action actionType = Action.ACTION_NONE;
        try {
            actionType = Action.valueOf(action);
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "action type is null");
        }
        switch (actionType) {
            case ACTION_WRITE_TRACK_TO_DB:
                writeTrackToDB(intent);
                return;
            case ACTION_READ_TRACK_AFTER_TIME:
                getTracksAfterTime(intent);
                return;
            case ACTION_GET_TRACK_GUID_LIST_BY_BDUID:
                getAllTracksGuidListByBduid(intent);
                return;
            case ACTION_READ_TRACK_BY_SYNC_STATE:
                getTracksBySyncState(intent);
                return;
            case ACTION_GET_TRACK_SYNC_STATE_BY_GUID_LIST:
                getTrackStateByGuidList(intent);
                return;
            case ACTION_DELETE_TRACK_BY_GUID:
                deleteTrackByGuid(intent);
                return;
            case ACTION_DELETE_TRACK_BY_GUID_LIST:
                deleteTrackByGuidList(intent);
                return;
            case ACTION_CLEAR_TRACK_BY_BDUID:
                clearTrackByUseId(intent);
                return;
            case ACTION_UPDATE_TRACK_BY_GUID:
                updateTrackById(intent);
                return;
            case ACTION_UPDATE_TRACK_SYNC_STATE_BY_GUID_LIST:
                updateTrackSyncStateByIDList(intent);
                return;
            case ACTION_UPDATE_TRACK_SYNC_STATE_AND_SID_BY_GUID_LIST:
                updateTrackSyncStateAndSidByIdList(intent);
                return;
            case ACTION_UPDATE_TRACK_INFO_BY_LIST:
                updateTrackInfoByList(intent);
                return;
            case ACTION_UPDATE_NOT_LOGIN_TRAKS_BDUID:
                updateNotLoginTracksBduid(intent);
                return;
            case ACTION_DELETE_TRACK_ON_LOCAL_AND_CLOUD_BY_GUID:
                deleteTrackOnLocalAndCloudByGuid(intent);
                return;
            case ACTION_GET_TRACK_STATISTICS:
                getTrackStatistic(intent);
                return;
            default:
                return;
        }
    }

    private void writeTrackToDB(Intent intent) {
        int i = 1;
        int ret = 0;
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        Object data = DataCache.getInstance().getCache(key);
        if (!(data == null || this.dao == null)) {
            ret = this.dao.writeTracksToDB((ArrayList) data);
        }
        TrackDBEvent event = new TrackDBEvent();
        event.type = 1;
        if (ret <= 0) {
            i = 0;
        }
        event.status = i;
        if (handler != null) {
            handler.obtainMessage(2, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(key);
        DataCache.getInstance().removeCache(handlerId);
        C1260i.b(TAG, "ret : " + ret);
    }

    private void getTracksAfterTime(Intent intent) {
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        String bduid = intent.getStringExtra(EXTRA_BDUID);
        int startTime = intent.getIntExtra(EXTRA_START_TIME, 0);
        int limit = intent.getIntExtra(EXTRA_LIMIT, 20);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        String queryType = intent.getStringExtra(EXTRA_QUERY_TYPE);
        TrackDBEvent dbEvent = new TrackDBEvent();
        dbEvent.type = 3;
        if (this.dao != null) {
            dbEvent.list = (ArrayList) this.dao.getTrackAfterTime(bduid, startTime, limit, queryType);
            C1260i.b(TAG, "ret list : " + dbEvent.list);
        }
        if (handler != null) {
            DataCache.getInstance().removeCache(handlerId);
            handler.obtainMessage(1, dbEvent).sendToTarget();
        }
    }

    private void getTracksBySyncState(Intent intent) {
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        String bduid = intent.getStringExtra(EXTRA_BDUID);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        TrackDBEvent dbEvent = new TrackDBEvent();
        dbEvent.type = 4;
        if (this.dao != null) {
            dbEvent.list = (ArrayList) this.dao.getUnsyncTrack(bduid);
            C1260i.b(TAG, "ret list : " + dbEvent.list);
        }
        dbEvent.token = token;
        if (handler != null) {
            handler.obtainMessage(6, dbEvent).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerId);
    }

    private void getTrackStateByGuidList(Intent intent) {
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        boolean bNonUI = intent.getBooleanExtra(EXTRA_NON_UI_EVENT, false);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        TrackDBEvent event = new TrackDBEvent();
        event.type = 18;
        Object list = DataCache.getInstance().getCache(key);
        if (list != null) {
            Map<String, Integer> dataMap = null;
            if (this.dao != null) {
                dataMap = this.dao.getTrackStateByGuidList((ArrayList) list);
            }
            event.map = dataMap;
            if (dataMap != null) {
                event.status = 1;
            } else {
                event.status = 0;
            }
        }
        event.token = token;
        DataCache.getInstance().removeCache(key);
        if (handler != null) {
            handler.obtainMessage(7, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerId);
    }

    private void getAllTracksGuidListByBduid(Intent intent) {
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        TrackDBEvent dbEvent = new TrackDBEvent();
        dbEvent.type = 3;
        if (this.dao != null) {
            dbEvent.list = this.dao.getAllTrack();
            C1260i.b(TAG, "ret list : " + dbEvent.list);
        }
        if (handler != null) {
            handler.obtainMessage(1, dbEvent).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerId);
    }

    private void deleteTrackByGuid(Intent intent) {
        int ret = 0;
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        String guid = intent.getStringExtra("guid");
        TrackDBEvent event = new TrackDBEvent();
        event.type = 6;
        if (!TextUtils.isEmpty(guid)) {
            if (this.dao != null) {
                ret = this.dao.deleteTrackByGUID(guid);
            }
            BaseTrackModel model = new BaseTrackModel();
            model.guid = guid;
            event.item = model;
        }
        event.status = ret > 0 ? 1 : 0;
        C1260i.b(TAG, "deleteTrackByGuid : " + (ret == 0 ? "Fail" : "Success"));
        if (handler != null) {
            handler.obtainMessage(3, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerId);
    }

    private void deleteTrackByGuidList(Intent intent) {
        int ret = 0;
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        Object list = DataCache.getInstance().getCache(key);
        if (!(list == null || this.dao == null)) {
            ret = this.dao.deleteTrackByGuidList((ArrayList) list);
        }
        TrackDBEvent event = new TrackDBEvent();
        event.type = 11;
        event.status = ret > 0 ? 1 : 0;
        C1260i.b(TAG, "updateTrackById : " + (ret == 0 ? "Fail" : "Success"));
        if (handler != null) {
            handler.obtainMessage(3, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(key);
        DataCache.getInstance().removeCache(handlerId);
    }

    private void clearTrackByUseId(Intent intent) {
        int ret = 0;
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerId);
        String useid = intent.getStringExtra("useid");
        if (TextUtils.isEmpty(useid) && this.dao != null) {
            ret = this.dao.clearTrackByUseId(useid);
        }
        TrackDBEvent event = new TrackDBEvent();
        event.type = 12;
        event.status = ret > 0 ? 1 : 0;
        if (handler != null) {
            handler.obtainMessage(4, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerId);
        C1260i.b(TAG, "clearTrackByUseId : " + (ret == 0 ? "Fail" : "Success"));
    }

    private void updateTrackById(Intent intent) {
        int ret = 0;
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        Object data = DataCache.getInstance().getCache(key);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        TrackDBEvent event = new TrackDBEvent();
        event.type = 7;
        if (data != null) {
            if (this.dao != null) {
                ret = this.dao.updateTrackSyncStateByID((BaseTrackModel) data);
            }
            if (ret > 0) {
                event.item = (BaseTrackModel) data;
            }
        }
        DataCache.getInstance().removeCache(key);
        event.status = ret > 0 ? 1 : 0;
        event.token = token;
        C1260i.b(TAG, "updateTrackById : " + (ret == 0 ? "Fail" : "Success"));
    }

    private void updateTrackSyncStateAndSidByIdList(Intent intent) {
        int i = 0;
        int ret = 0;
        int handlerid = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerid);
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        Object list = DataCache.getInstance().getCache(key);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        if (!(list == null || this.dao == null)) {
            ret = this.dao.updateTrackSyncStateAndSidByIDList((ArrayList) list);
        }
        DataCache.getInstance().removeCache(key);
        boolean bNonUI = intent.getBooleanExtra(EXTRA_NON_UI_EVENT, false);
        TrackDBEvent event = new TrackDBEvent();
        event.type = 7;
        if (ret > 0) {
            i = 1;
        }
        event.status = i;
        event.token = token;
        if (handler != null) {
            handler.obtainMessage(9, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerid);
    }

    private void updateTrackSyncStateByIDList(Intent intent) {
        int ret = 0;
        int handlerid = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handler = (Handler) DataCache.getInstance().getCache(handlerid);
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        Object data = DataCache.getInstance().getCache(key);
        if (!(data == null || this.dao == null)) {
            ret = this.dao.updateTrackSyncStateByIDList((Map) data);
        }
        DataCache.getInstance().removeCache(key);
        TrackDBEvent event = new TrackDBEvent();
        event.type = 7;
        event.status = ret > 0 ? 1 : 0;
        event.token = token;
        if (handler != null) {
            handler.obtainMessage(8, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerid);
        C1260i.b(TAG, "updateTrackSyncStateByIDList : " + (ret == 0 ? "Fail" : "Success"));
    }

    private void updateTrackInfoByList(Intent intent) {
        int ret = 0;
        int key = intent.getIntExtra(EXTRA_CACHE_KEY, -1);
        Object list = DataCache.getInstance().getCache(key);
        if (!(list == null || this.dao == null)) {
            ret = this.dao.updateTrackInfoByGuid((ArrayList) list);
        }
        DataCache.getInstance().removeCache(key);
        C1260i.b(TAG, "updateTrackInfoByList : " + (ret == 0 ? "Fail" : "Success"));
    }

    private void updateNotLoginTracksBduid(Intent intent) {
        int ret = 0;
        String bduid = intent.getStringExtra(EXTRA_BDUID);
        if (!(TextUtils.isEmpty(bduid) || this.dao == null)) {
            ret = this.dao.updateNotLoginTracksBduid(bduid);
        }
        C1260i.b(TAG, "updateNotLoginTracksBduid : " + (ret == 0 ? "Fail" : "Success"));
    }

    private void getTrackStatistic(Intent intent) {
        int handlerId = intent.getIntExtra(EXTRA_HANDLER, -1);
        Handler handle = (Handler) DataCache.getInstance().getCache(handlerId);
        String bduid = intent.getStringExtra(EXTRA_BDUID);
        int limit = intent.getIntExtra(EXTRA_LIMIT, 6);
        int token = intent.getIntExtra(EXTRA_TOKEN_INT_KEY, -1);
        TrackDBEvent event = new TrackDBEvent();
        event.type = 5;
        if (this.dao != null) {
            event.statistic = this.dao.getTrackStatistics(bduid, limit);
        }
        event.token = token;
        if (handle != null) {
            handle.obtainMessage(5, event).sendToTarget();
        }
        DataCache.getInstance().removeCache(handlerId);
    }

    private void deleteTrackOnLocalAndCloudByGuid(Intent intent) {
        String guid = intent.getStringExtra("guid");
        if (guid != null && this.dao != null) {
            ArrayList<String> list = new ArrayList(1);
            list.add(guid);
            Map<String, Integer> statusMap = this.dao.getTrackStateByGuidList(list);
            if (statusMap != null && statusMap.size() >= 1) {
                int status = ((Integer) statusMap.get(guid)).intValue();
                if (status == 0) {
                    String str;
                    int ret = this.dao.deleteTrackByGUID(guid);
                    String str2 = TAG;
                    StringBuilder append = new StringBuilder().append("deleteTrackOnLocalAndCloudByGuid deleteTrackByGUID : ");
                    if (ret == 0) {
                        str = "Fail";
                    } else {
                        str = "Success";
                    }
                    C1260i.b(str2, append.append(str).toString());
                } else if (status == 1 || status == 11 || status == 12 || status == 10) {
                    Map<String, Integer> guidMap = new HashMap();
                    guidMap.put(guid, Integer.valueOf(12));
                    C1260i.b(TAG, "deleteTrackOnLocalAndCloudByGuid updateTrackSyncStateByIDList : " + (this.dao.updateTrackSyncStateByIDList(guidMap) == 0 ? "Fail" : "Success"));
                }
            }
        }
    }
}
