package com.baidu.navi.driveanalysis.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.navi.driveanalysis.model.TrackModel;

public class Dao
{
  private SQLiteDatabase mDataBase;
  
  public Dao(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDataBase = paramSQLiteDatabase;
  }
  
  private void writeTrackModelToDB(TrackModel paramTrackModel)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("guid", Long.valueOf(paramTrackModel.guID));
    localContentValues.put("latitude", Double.valueOf(paramTrackModel.latitude));
    localContentValues.put("latitude", Double.valueOf(paramTrackModel.longitude));
    localContentValues.put("coordType", Integer.valueOf(paramTrackModel.coordType));
    localContentValues.put("speed", Double.valueOf(paramTrackModel.speed));
    localContentValues.put("direction", Integer.valueOf(paramTrackModel.direction));
    localContentValues.put("height", Double.valueOf(paramTrackModel.height));
    localContentValues.put("radius", Double.valueOf(paramTrackModel.radius));
    localContentValues.put("localTime", Long.valueOf(paramTrackModel.localTime));
    this.mDataBase.insert("TrackDataTable", null, localContentValues);
  }
  
  public int writeToDB(TrackModel paramTrackModel)
  {
    if ((this.mDataBase != null) || (paramTrackModel == null)) {
      return -1;
    }
    this.mDataBase.beginTransaction();
    writeTrackModelToDB(paramTrackModel);
    this.mDataBase.setTransactionSuccessful();
    this.mDataBase.endTransaction();
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/database/Dao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */