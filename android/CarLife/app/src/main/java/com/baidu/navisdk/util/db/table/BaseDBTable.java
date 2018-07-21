package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDBTable<T extends BaseDBObject>
{
  public static final String ORDERBY_DOWN = "DESC";
  public static final String ORDERBY_UP = "ASC";
  private String id = getIdCumName();
  private String idcause = this.id + "=?";
  private Object mMutex = getmMutex();
  private String mTableName = getTableName();
  
  public void beginTransaction()
  {
    DBManager.openDB();
  }
  
  public abstract T build(Cursor paramCursor);
  
  protected ArrayList<T> buildMulti(Cursor paramCursor)
  {
    Object localObject2 = null;
    localObject3 = null;
    localObject1 = localObject2;
    if (paramCursor != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramCursor.moveToFirst())
      {
        localObject1 = new ArrayList(paramCursor.getCount());
        try
        {
          while (!paramCursor.isAfterLast())
          {
            ((ArrayList)localObject1).add(build(paramCursor));
            paramCursor.moveToNext();
          }
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localObject1 = localObject3;
      }
    }
    if (paramCursor != null) {
      paramCursor.close();
    }
    paramCursor = (Cursor)localObject1;
    if (localObject1 == null) {
      paramCursor = new ArrayList(0);
    }
    return paramCursor;
  }
  
  protected T buildOne(Cursor paramCursor)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramCursor != null)
    {
      localObject1 = localObject2;
      if (paramCursor.moveToFirst()) {
        localObject1 = build(paramCursor);
      }
      paramCursor.close();
    }
    return (T)localObject1;
  }
  
  public abstract ContentValues deconstruct(T paramT);
  
  public void delete(int paramInt)
  {
    synchronized (this.mMutex)
    {
      if (DBManager.openDB())
      {
        DBManager.getDB().delete(this.mTableName, this.idcause, new String[] { paramInt + "" });
        DBManager.closeDB();
      }
      return;
    }
  }
  
  public void delete(String paramString, String[] paramArrayOfString)
  {
    try
    {
      synchronized (this.mMutex)
      {
        if (DBManager.openDB())
        {
          DBManager.getDB().delete(this.mTableName, paramString, paramArrayOfString);
          DBManager.closeDB();
        }
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public void deleteAll()
  {
    synchronized (this.mMutex)
    {
      if (DBManager.openDB())
      {
        DBManager.getDB().delete(this.mTableName, null, null);
        DBManager.closeDB();
      }
      return;
    }
  }
  
  public void endTransaction() {}
  
  public int getHighestID(String paramString)
  {
    synchronized (this.mMutex)
    {
      paramString = "SELECT MAX(" + this.id + ") FROM " + paramString;
      SQLiteDatabase localSQLiteDatabase = DBManager.getDB();
      int i = 0;
      if (localSQLiteDatabase != null)
      {
        paramString = localSQLiteDatabase.rawQuery(paramString, null);
        paramString.moveToFirst();
        i = paramString.getInt(0);
        paramString.close();
      }
      return i;
    }
  }
  
  public abstract String getIdCumName();
  
  public abstract String getTableName();
  
  public abstract Object getmMutex();
  
  public int insert(T paramT)
  {
    Object localObject = this.mMutex;
    if (paramT != null) {}
    try
    {
      if (DBManager.openDB())
      {
        paramT.setId((int)DBManager.getDB().insert(this.mTableName, null, deconstruct(paramT)));
        DBManager.closeDB();
      }
      return -1;
    }
    finally {}
  }
  
  public void insert(List<T> paramList)
  {
    Object localObject = this.mMutex;
    if (paramList != null) {}
    try
    {
      if ((paramList.size() > 0) && (DBManager.openDB()))
      {
        DBManager.getDB().beginTransaction();
        int i = 0;
        while (i < paramList.size())
        {
          insert((BaseDBObject)paramList.get(i));
          i += 1;
        }
        DBManager.getDB().endTransaction();
        DBManager.closeDB();
      }
      return;
    }
    finally {}
  }
  
  public T query(int paramInt)
  {
    synchronized (this.mMutex)
    {
      BaseDBObject localBaseDBObject = queryOne(this.idcause, new String[] { paramInt + "" });
      return localBaseDBObject;
    }
  }
  
  public ArrayList<T> queryAll(String paramString1, String paramString2)
  {
    synchronized (this.mMutex)
    {
      paramString1 = queryMulti(null, null, paramString1, paramString2);
      return paramString1;
    }
  }
  
  public ArrayList<T> queryMulti(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    synchronized (this.mMutex)
    {
      if (DBManager.openDB())
      {
        paramString1 = buildMulti(DBManager.getDB().query(this.mTableName, null, paramString1, paramArrayOfString, null, null, paramString2 + " " + paramString3));
        DBManager.closeDB();
        return paramString1;
      }
      return null;
    }
  }
  
  public T queryOne(String paramString, String[] paramArrayOfString)
  {
    synchronized (this.mMutex)
    {
      if (DBManager.openDB())
      {
        paramString = buildOne(DBManager.getDB().query(this.mTableName, null, paramString, paramArrayOfString, null, null, null));
        DBManager.closeDB();
        return paramString;
      }
      return null;
    }
  }
  
  public void update(T paramT)
  {
    Object localObject = this.mMutex;
    if (paramT != null) {}
    try
    {
      if (DBManager.openDB())
      {
        DBManager.getDB().update(this.mTableName, deconstruct(paramT), this.idcause, new String[] { paramT.getId() + "" });
        DBManager.closeDB();
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/table/BaseDBTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */