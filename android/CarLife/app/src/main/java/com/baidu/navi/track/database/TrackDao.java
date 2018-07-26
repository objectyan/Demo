package com.baidu.navi.track.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataBaseConstants.TRACK_TYPE;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.model.TrackAcmp;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TrackDao {
    private static final String TAG = "TrackDao";
    private SQLiteDatabase mDatabase;

    public TrackDao(SQLiteDatabase database) {
        this.mDatabase = database;
    }

    public int writeTracksToDB(List<Object> list) {
        int ret = 0;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            for (Object item : list) {
                if (item instanceof CarNaviModel) {
                    writeCarTrackToDB((CarNaviModel) item);
                }
            }
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
        } catch (Exception e) {
        } finally {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e2) {
                return 0;
            }
        }
        return ret;
    }

    private void writeCarTrackToDB(CarNaviModel model) {
        if (model != null) {
            try {
                if (model.getPBData().getStartPoint() == null || model.getPBData().getStartPoint() == null) {
                    C1260i.b(TAG, "Start OR End Point is null");
                    return;
                }
                ContentValues values = new ContentValues();
                values.put(DataBaseConstants.CAR_CUID, model.getCarCuid());
                values.put(DataBaseConstants.CAR_CHANNEL, model.getCarChannel());
                values.put(DataBaseConstants.CAR_VERSION, model.getCarVersion());
                values.put("useid", model.getUseId());
                values.put(DataBaseConstants.ISCONNECT, Boolean.valueOf(model.isConnect()));
                values.put(DataBaseConstants.SDCARD_PATH, model.getSDcardPath());
                values.put(DataBaseConstants.ACTION_STATE, Integer.valueOf(model.getSyncState()));
                values.put("guid", model.getPBData().getGuid());
                values.put("type", model.getPBData().getType());
                values.put(DataBaseConstants.CTIME, Integer.valueOf(model.getPBData().getCtime()));
                values.put(DataBaseConstants.MODIFY_TIME, Integer.valueOf(model.getPBData().getModifyTime()));
                values.put("sid", model.getPBData().getSid());
                values.put("distance", Integer.valueOf(model.getPBData().getDistance()));
                values.put("duration", Integer.valueOf(model.getPBData().getDuration()));
                values.put(DataBaseConstants.MAX_SPEED, Double.valueOf(model.getPBData().getMaxSpeed()));
                values.put(DataBaseConstants.AVG_SPEED, Double.valueOf(model.getPBData().getAvgSpeed()));
                values.put("sign", model.getPBData().getSign());
                values.put(DataBaseConstants.START_ADDR, model.getPBData().getStartPoint().getAddr());
                values.put(DataBaseConstants.START_LNG, Double.valueOf(model.getPBData().getStartPoint().getLng()));
                values.put(DataBaseConstants.START_LAT, Double.valueOf(model.getPBData().getStartPoint().getLat()));
                values.put(DataBaseConstants.END_ADDR, model.getPBData().getEndPoint().getAddr());
                values.put(DataBaseConstants.END_LNG, Double.valueOf(model.getPBData().getEndPoint().getLng()));
                values.put(DataBaseConstants.END_LAT, Double.valueOf(model.getPBData().getEndPoint().getLat()));
                C1260i.b(TAG, "rawId : " + this.mDatabase.replace(DataBaseConstants.TRACK_CAR_TABLE, null, values));
            } catch (Exception e) {
                C1260i.b(TAG, "DB Exception");
            }
        }
    }

    public List<Object> getTrackAfterTime(String bduid, int starttime, int limit, String queryType) {
        Exception e;
        List<Object> list = null;
        C1260i.b(TAG, bduid + " " + starttime + " " + limit + " " + queryType);
        if (starttime < 1 || limit < 1) {
            return null;
        }
        if (this.mDatabase == null) {
            return null;
        }
        TRACK_TYPE trackType = TRACK_TYPE.car_navi;
        TrackQueryType trackQueryType = TrackQueryType.CAR;
        try {
            switch (TrackQueryType.valueOf(queryType)) {
                case CAR:
                    String[] projection = new String[]{DataBaseConstants.CAR_CUID, DataBaseConstants.CAR_CHANNEL, DataBaseConstants.CAR_VERSION, "useid", DataBaseConstants.ISCONNECT, DataBaseConstants.SDCARD_PATH, DataBaseConstants.ACTION_STATE, "guid", "type", DataBaseConstants.CTIME, DataBaseConstants.MODIFY_TIME, "sid", "distance", "duration", DataBaseConstants.MAX_SPEED, DataBaseConstants.AVG_SPEED, "sign", DataBaseConstants.START_ADDR, DataBaseConstants.START_LNG, DataBaseConstants.START_LAT, DataBaseConstants.END_ADDR, DataBaseConstants.END_LNG, DataBaseConstants.END_LAT};
                    String sortOrder = "ctime DESC";
                    String strlimit = "" + limit;
                    String selection = "type =? AND ctime <? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?";
                    String[] selectionArgs = new String[]{DataBaseConstants.TYPE_CAR, starttime + "", bduid, "", "2", PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX};
                    trackType = TRACK_TYPE.car_navi;
                    try {
                        Cursor cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, projection, selection, selectionArgs, null, null, sortOrder, strlimit);
                        if (cursor != null && cursor.getColumnCount() > 0) {
                            List<Object> list2 = new ArrayList();
                            while (cursor.moveToNext()) {
                                try {
                                    list2.add(buildModelByType(cursor.getString(cursor.getColumnIndex("type")), cursor));
                                } catch (Exception e2) {
                                    e = e2;
                                    list = list2;
                                }
                            }
                            list = list2;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        C1260i.b(TAG, "DB Exception");
                        return list;
                    }
            }
            return list;
        } catch (Exception e4) {
            return null;
        }
    }

    public List<Object> getAllTrack() {
        ArrayList<Object> arrayList = null;
        if (this.mDatabase == null) {
            return null;
        }
        String[] projection = new String[]{DataBaseConstants.CAR_CUID, DataBaseConstants.CAR_CHANNEL, DataBaseConstants.CAR_VERSION, "useid", DataBaseConstants.ISCONNECT, DataBaseConstants.SDCARD_PATH, DataBaseConstants.ACTION_STATE, "guid", "type", DataBaseConstants.CTIME, DataBaseConstants.MODIFY_TIME, "distance", "duration", DataBaseConstants.MAX_SPEED, DataBaseConstants.AVG_SPEED, "sign", DataBaseConstants.START_ADDR, DataBaseConstants.START_LNG, DataBaseConstants.START_LAT, DataBaseConstants.END_ADDR, DataBaseConstants.END_LNG, DataBaseConstants.END_LAT, "sid"};
        String selection = "action_state !=? AND action_state !=?";
        String[] selectionArgs = new String[]{"2", PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX};
        try {
            Cursor cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, null, null, null, null, null, "ctime DESC");
            if (cursor != null && cursor.getColumnCount() > 0) {
                ArrayList<Object> list = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        list.add(buildModelByType(cursor.getString(cursor.getColumnIndex("type")), cursor));
                    } catch (Exception e) {
                        arrayList = list;
                    }
                }
                arrayList = list;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            C1260i.b(TAG, "DB Exception");
            return arrayList;
        }
        return arrayList;
    }

    public List<Object> getUnsyncTrack(String bduid) {
        ArrayList<Object> arrayList = null;
        if (this.mDatabase == null) {
            return null;
        }
        try {
            Cursor cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, new String[]{DataBaseConstants.CAR_CUID, DataBaseConstants.CAR_CHANNEL, DataBaseConstants.CAR_VERSION, "useid", DataBaseConstants.ISCONNECT, DataBaseConstants.SDCARD_PATH, DataBaseConstants.ACTION_STATE, "guid", "type", DataBaseConstants.CTIME, DataBaseConstants.MODIFY_TIME, "distance", "duration", DataBaseConstants.MAX_SPEED, DataBaseConstants.AVG_SPEED, "sign", DataBaseConstants.START_ADDR, DataBaseConstants.START_LNG, DataBaseConstants.START_LAT, DataBaseConstants.END_ADDR, DataBaseConstants.END_LNG, DataBaseConstants.END_LAT, "sid"}, "action_state !=? AND useid !=? ", new String[]{"1", ""}, null, null, "ctime DESC");
            if (cursor != null && cursor.getColumnCount() > 0) {
                ArrayList<Object> list = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        list.add(buildModelByType(cursor.getString(cursor.getColumnIndex("type")), cursor));
                    } catch (Exception e) {
                        arrayList = list;
                    }
                }
                arrayList = list;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            C1260i.b(TAG, "DB Exception");
            return arrayList;
        }
        return arrayList;
    }

    public Map<String, Integer> getTrackStateByGuidList(List<String> guidList) {
        Map<String, Integer> stateMap = new HashMap();
        if (guidList == null) {
            return null;
        }
        if (this.mDatabase == null) {
            return null;
        }
        try {
            String[] projection = new String[]{DataBaseConstants.ACTION_STATE};
            String sortOrder = "ctime DESC";
            String selection = "guid=?";
            for (String guid : guidList) {
                if (guid != null) {
                    int syncState = -1;
                    Cursor cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, projection, selection, new String[]{guid}, null, null, sortOrder);
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        syncState = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.ACTION_STATE));
                    }
                    stateMap.put(guid, Integer.valueOf(syncState));
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            return stateMap;
        } catch (Exception e) {
            C1260i.b(TAG, "DB Exception");
            return stateMap;
        }
    }

    public int deleteTrackByGUID(String guid) {
        int i = 0;
        if (guid == null) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            String[] whereArgs = new String[]{guid + ""};
            i = this.mDatabase.delete(DataBaseConstants.TRACK_CAR_TABLE, "guid=?", whereArgs);
            this.mDatabase.setTransactionSuccessful();
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                i = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                i = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return i;
    }

    public int deleteTrackByGuidList(List<String> guidList) {
        int ret = 0;
        if (guidList == null || guidList.size() <= 0) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            String whereClause = "guid=?";
            for (String guid : guidList) {
                ret = this.mDatabase.delete(DataBaseConstants.TRACK_CAR_TABLE, whereClause, new String[]{guid + ""});
            }
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public int clearTrackByUseId(String useId) {
        int ret = 0;
        if (TextUtils.isEmpty(useId)) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            String[] whereArgs = new String[]{useId, "0"};
            this.mDatabase.delete(DataBaseConstants.TRACK_CAR_TABLE, "useid=? OR useid=?", whereArgs);
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public int updateTrackSyncStateByID(BaseTrackModel model) {
        int ret = 0;
        if (model == null) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put("guid", model.guid);
            values.put("type", model.type);
            values.put(DataBaseConstants.CTIME, Integer.valueOf(model.modifyTime));
            values.put(DataBaseConstants.ACTION_STATE, Integer.valueOf(model.syncState));
            values.put("useid", model.useId);
            values.put("sid", model.sid);
            String[] selectionArgs = new String[]{model.guid};
            this.mDatabase.update(DataBaseConstants.TRACK_CAR_TABLE, values, "guid=?", selectionArgs);
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public int updateTrackSyncStateAndSidByIDList(List<BaseTrackModel> list) {
        int ret = 0;
        if (list == null) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            for (BaseTrackModel model : list) {
                String guid = model.guid;
                String sid = model.sid;
                int syncState = model.syncState;
                if (!(guid == null || guid.isEmpty())) {
                    String whereClause = "guid=?";
                    String[] whereArgs = new String[]{guid};
                    ContentValues values = new ContentValues();
                    values.put(DataBaseConstants.ACTION_STATE, Integer.valueOf(syncState));
                    if (sid != null) {
                        values.put("sid", sid);
                    }
                    this.mDatabase.update(DataBaseConstants.TRACK_CAR_TABLE, values, whereClause, whereArgs);
                }
            }
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public int updateTrackSyncStateByIDList(Map<String, Integer> guidMap) {
        int ret = 0;
        if (guidMap == null) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            for (Entry<String, Integer> entry : guidMap.entrySet()) {
                String guid = (String) entry.getKey();
                int syncState = ((Integer) entry.getValue()).intValue();
                if (!(guid == null || guid.isEmpty())) {
                    String[] selectionArgs = new String[]{guid};
                    ContentValues values = new ContentValues();
                    values.put(DataBaseConstants.ACTION_STATE, Integer.valueOf(syncState));
                    this.mDatabase.update(DataBaseConstants.TRACK_CAR_TABLE, values, "guid=?", selectionArgs);
                }
            }
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public int updateTrackInfoByGuid(List<Object> list) {
        int ret = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            for (Object item : list) {
                if (item != null && (item instanceof CarNaviModel)) {
                    CarNaviModel model = (CarNaviModel) item;
                    ContentValues values = new ContentValues();
                    values.put(DataBaseConstants.CAR_CUID, model.getCarCuid());
                    values.put(DataBaseConstants.CAR_CHANNEL, model.getCarChannel());
                    values.put(DataBaseConstants.CAR_VERSION, model.getCarVersion());
                    values.put("useid", model.getUseId());
                    values.put(DataBaseConstants.ISCONNECT, Boolean.valueOf(model.isConnect()));
                    values.put(DataBaseConstants.SDCARD_PATH, model.getSDcardPath());
                    values.put("guid", model.getPBData().getGuid());
                    values.put("type", model.getPBData().getType());
                    values.put(DataBaseConstants.CTIME, Integer.valueOf(model.getPBData().getCtime()));
                    values.put(DataBaseConstants.MODIFY_TIME, Integer.valueOf(model.getPBData().getModifyTime()));
                    values.put("distance", Integer.valueOf(model.getPBData().getDistance()));
                    values.put("duration", Integer.valueOf(model.getPBData().getDuration()));
                    values.put(DataBaseConstants.MAX_SPEED, Double.valueOf(model.getPBData().getMaxSpeed()));
                    values.put(DataBaseConstants.AVG_SPEED, Double.valueOf(model.getPBData().getAvgSpeed()));
                    values.put("sign", model.getPBData().getSign());
                    values.put(DataBaseConstants.START_ADDR, model.getPBData().getStartPoint().getAddr());
                    values.put(DataBaseConstants.START_LNG, Double.valueOf(model.getPBData().getStartPoint().getLng()));
                    values.put(DataBaseConstants.START_LAT, Double.valueOf(model.getPBData().getStartPoint().getLat()));
                    values.put(DataBaseConstants.END_ADDR, model.getPBData().getEndPoint().getAddr());
                    values.put(DataBaseConstants.END_LNG, Double.valueOf(model.getPBData().getEndPoint().getLng()));
                    values.put(DataBaseConstants.END_LAT, Double.valueOf(model.getPBData().getEndPoint().getLat()));
                    String[] selectionArgs = new String[]{model.getPBData().getGuid()};
                    this.mDatabase.update(DataBaseConstants.TRACK_CAR_TABLE, values, "guid=?", selectionArgs);
                }
            }
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public int updateNotLoginTracksBduid(String useid) {
        int ret = 0;
        if (TextUtils.isEmpty(useid)) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        this.mDatabase.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put("useid", useid);
            values.put(DataBaseConstants.MODIFY_TIME, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            String[] selectionArgs = new String[]{""};
            this.mDatabase.update(DataBaseConstants.TRACK_CAR_TABLE, values, "useid=?", selectionArgs);
            this.mDatabase.setTransactionSuccessful();
            ret = 1;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = 0;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = 0;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public TrackAcmp getTrackStatistics(String userID, int limit) {
        if (this.mDatabase == null) {
            return null;
        }
        TrackAcmp model = new TrackAcmp();
        try {
            String[] projection = new String[]{"SUM(distance) AS distance"};
            String selection = "type =? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?";
            String[] selectionArgs = new String[]{DataBaseConstants.TYPE_CAR, userID, "", "2", PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX};
            int carTotalDist = 0;
            int carWeekMileage = 0;
            int carMaxDuration = 0;
            Calendar cal = Calendar.getInstance();
            cal.set(7, 2);
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
            long time = cal.getTimeInMillis() / 1000;
            if (cal.getTimeInMillis() > System.currentTimeMillis()) {
                time -= 604800;
            }
            Date date = new Date(1000 * time);
            C1260i.b(TAG, "date :" + new SimpleDateFormat("yy:MM:dd HH:mm:ss").format(date) + "firstDay : " + cal.getFirstDayOfWeek());
            Cursor cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, projection, selection, selectionArgs, null, null, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                carTotalDist = cursor.getInt(cursor.getColumnIndex("distance"));
            }
            String[] selectionArgs2 = new String[]{DataBaseConstants.TYPE_CAR, time + "", (604800 + time) + "", userID, "", "2", PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX};
            cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, projection, "type =? AND ctime >? AND ctime <=? AND (useid =? OR useid =?) AND action_state !=? AND action_state !=?", selectionArgs2, null, null, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                carWeekMileage = cursor.getInt(cursor.getColumnIndex("distance"));
            }
            cursor = this.mDatabase.query(DataBaseConstants.TRACK_CAR_TABLE, new String[]{"MAX(duration) AS duration"}, selection, selectionArgs, null, null, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                carMaxDuration = cursor.getInt(cursor.getColumnIndex("duration"));
            }
            model.setCarNaviDistance(carTotalDist);
            model.setCarWeekMileage(carWeekMileage);
            model.setCarMaxDuration(carMaxDuration);
            TrackConfig.getInstance().setWeekEndTime((int) (604800 + time));
            TrackConfig.getInstance().setTotalDistanse(carTotalDist);
            TrackConfig.getInstance().setWeekDistanse(carWeekMileage);
            TrackConfig.getInstance().setMaxTime(carMaxDuration);
            C1260i.b(TAG, model.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C1260i.b(TAG, "db getTrackStatistics exception");
        }
        return model;
    }

    private Object buildModelByType(String type, Cursor cursor) {
        if (type == null || cursor == null) {
            return null;
        }
        TRACK_TYPE trackType = TRACK_TYPE.car_navi;
        try {
            trackType = TRACK_TYPE.valueOf(type.toLowerCase());
        } catch (Exception e) {
            C1260i.b(TAG, "--- buildModelByType has no type:" + type);
        }
        switch (trackType) {
            case car_navi:
                CarNaviModel model = new CarNaviModel();
                model.setCarCuid(cursor.getString(cursor.getColumnIndex(DataBaseConstants.CAR_CUID)));
                model.setCarChannel(cursor.getString(cursor.getColumnIndex(DataBaseConstants.CAR_CHANNEL)));
                model.setCarVersion(cursor.getString(cursor.getColumnIndex(DataBaseConstants.CAR_VERSION)));
                model.setIsConnect(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.ISCONNECT)) != 0);
                model.setSDcardPath(cursor.getString(cursor.getColumnIndex(DataBaseConstants.SDCARD_PATH)));
                model.setSyncState(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.ACTION_STATE)));
                model.setUseId(cursor.getString(cursor.getColumnIndex("useid")));
                NaviPoint startPoint = new NaviPoint();
                startPoint.setAddr(cursor.getString(cursor.getColumnIndex(DataBaseConstants.START_ADDR)));
                startPoint.setLat(cursor.getDouble(cursor.getColumnIndex(DataBaseConstants.START_LAT)));
                startPoint.setLng(cursor.getDouble(cursor.getColumnIndex(DataBaseConstants.START_LNG)));
                model.getPBData().setStartPoint(startPoint);
                NaviPoint endPoint = new NaviPoint();
                endPoint.setAddr(cursor.getString(cursor.getColumnIndex(DataBaseConstants.END_ADDR)));
                endPoint.setLat(cursor.getDouble(cursor.getColumnIndex(DataBaseConstants.END_LAT)));
                endPoint.setLng(cursor.getDouble(cursor.getColumnIndex(DataBaseConstants.END_LNG)));
                model.getPBData().setEndPoint(endPoint);
                model.getPBData().setSid(cursor.getString(cursor.getColumnIndex("sid")));
                model.getPBData().setGuid(cursor.getString(cursor.getColumnIndex("guid")));
                model.getPBData().setCtime(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.CTIME)));
                model.getPBData().setModifyTime(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MODIFY_TIME)));
                model.getPBData().setAvgSpeed(cursor.getDouble(cursor.getColumnIndex(DataBaseConstants.AVG_SPEED)));
                model.getPBData().setMaxSpeed(cursor.getDouble(cursor.getColumnIndex(DataBaseConstants.MAX_SPEED)));
                model.getPBData().setDistance(cursor.getInt(cursor.getColumnIndex("distance")));
                model.getPBData().setDuration(cursor.getInt(cursor.getColumnIndex("duration")));
                model.getPBData().setSign(cursor.getString(cursor.getColumnIndex("sign")));
                model.getPBData().setType(cursor.getString(cursor.getColumnIndex("type")));
                CarNaviModel result = model;
                C1260i.b(TAG, model.toString());
                return result;
            default:
                return null;
        }
    }
}
