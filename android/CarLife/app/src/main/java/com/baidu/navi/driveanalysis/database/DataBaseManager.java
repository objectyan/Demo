package com.baidu.navi.driveanalysis.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.navi.track.database.DataBaseHelper;

public class DataBaseManager
{
  private final String TAG = DataBaseManager.class.getSimpleName();
  private SQLiteDatabase mDB;
  private DataBaseHelper mHelper;
  
  public DataBaseManager(Context paramContext)
  {
    this.mHelper = new DataBaseHelper(paramContext);
  }
  
  public void closeDataBase()
  {
    if ((this.mDB != null) && (this.mDB.isOpen())) {
      this.mDB.close();
    }
  }
  
  public void executeQurey(QueryExecutor paramQueryExecutor)
  {
    paramQueryExecutor.run(this.mDB);
  }
  
  public void openDataBase()
  {
    this.mDB = this.mHelper.getWritableDatabase();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/database/DataBaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */