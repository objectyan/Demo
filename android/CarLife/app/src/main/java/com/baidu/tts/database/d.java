package com.baidu.tts.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.l.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private a a;
  private c b;
  private ReadWriteLock c = new ReentrantReadWriteLock();
  private Lock d = this.c.writeLock();
  private Lock e = this.c.readLock();
  
  public d(a parama)
  {
    this.a = parama;
    this.b = new c(this.a.d());
  }
  
  private SQLiteDatabase b()
  {
    return this.b.getWritableDatabase();
  }
  
  private SQLiteDatabase c()
  {
    return this.b.getReadableDatabase();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.d.lock();
    SQLiteDatabase localSQLiteDatabase = c();
    try
    {
      int i = localSQLiteDatabase.delete("StatisticsInfo", "id between ? and ?", new String[] { Integer.toString(paramInt1), Integer.toString(paramInt2) });
      LoggerProxy.d("StatisticsDbManager", "delete database=" + i + "=" + paramInt1 + "=" + paramInt2);
      return i;
    }
    finally
    {
      localSQLiteDatabase.close();
      this.d.unlock();
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3)
  {
    this.d.lock();
    SQLiteDatabase localSQLiteDatabase = b();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(paramString2, paramString3);
      int i = localSQLiteDatabase.update("StatisticsInfo", localContentValues, "uuid=?", new String[] { paramString1 });
      if (i == 0) {
        localSQLiteDatabase.insert("StatisticsInfo", null, localContentValues);
      }
      return i;
    }
    finally
    {
      localSQLiteDatabase.close();
      this.d.unlock();
    }
  }
  
  public long a(String paramString)
  {
    this.d.lock();
    SQLiteDatabase localSQLiteDatabase = b();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uuid", paramString);
      long l = localSQLiteDatabase.insert("StatisticsInfo", null, localContentValues);
      return l;
    }
    finally
    {
      localSQLiteDatabase.close();
      this.d.unlock();
    }
  }
  
  public Map<String, ArrayList> a()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    this.e.lock();
    SQLiteDatabase localSQLiteDatabase = c();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from StatisticsInfo limit 0,100", null);
    try
    {
      while (localCursor.moveToNext())
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          int i = localCursor.getInt(localCursor.getColumnIndex("id"));
          localJSONObject.put("uuid", localCursor.getString(localCursor.getColumnIndex("uuid")));
          localJSONObject.put("startInfo", localCursor.getString(localCursor.getColumnIndex("startInfo")));
          localJSONObject.put("endInfo", localCursor.getString(localCursor.getColumnIndex("endInfo")));
          localArrayList2.add(Integer.valueOf(i));
          localArrayList1.add(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      localMap.put("listId", localArrayList2);
    }
    finally
    {
      localCursor.close();
      localSQLiteDatabase.close();
      this.e.unlock();
    }
    localMap.put("list", localArrayList1);
    localCursor.close();
    localSQLiteDatabase.close();
    this.e.unlock();
    return localMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */