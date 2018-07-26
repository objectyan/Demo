package com.baidu.navi.driveanalysis.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.navi.driveanalysis.model.TrackModel;

public class Dao {
    private SQLiteDatabase mDataBase;

    public Dao(SQLiteDatabase database) {
        this.mDataBase = database;
    }

    public int writeToDB(TrackModel model) {
        if (this.mDataBase != null || model == null) {
            return -1;
        }
        this.mDataBase.beginTransaction();
        writeTrackModelToDB(model);
        this.mDataBase.setTransactionSuccessful();
        this.mDataBase.endTransaction();
        return 0;
    }

    private void writeTrackModelToDB(TrackModel model) {
        ContentValues values = new ContentValues();
        values.put("guid", Long.valueOf(model.guID));
        values.put("latitude", Double.valueOf(model.latitude));
        values.put("latitude", Double.valueOf(model.longitude));
        values.put(CommonConstants.COORD_TYPE, Integer.valueOf(model.coordType));
        values.put("speed", Double.valueOf(model.speed));
        values.put("direction", Integer.valueOf(model.direction));
        values.put("height", Double.valueOf(model.height));
        values.put(CommonConstants.RADIUS, Double.valueOf(model.radius));
        values.put(CommonConstants.LOCAL_TIME, Long.valueOf(model.localTime));
        this.mDataBase.insert(CommonConstants.TRACK_TABLE_NAME, null, values);
    }
}
