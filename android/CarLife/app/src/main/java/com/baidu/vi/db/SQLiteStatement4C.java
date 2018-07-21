package com.baidu.vi.db;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SQLiteStatement4C
{
  private SQLiteDatabase database;
  private HashMap<Integer, Object> parameterMap;
  private String strSQL;
  
  public SQLiteStatement4C(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    this.database = paramSQLiteDatabase;
    this.strSQL = paramString;
    this.parameterMap = new HashMap();
  }
  
  private Object[] extractParameters()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList(this.parameterMap.keySet());
    Collections.sort((List)localObject);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localArrayList.add(this.parameterMap.get(localInteger));
    }
    return localArrayList.toArray();
  }
  
  private String[] extractStringParameters()
  {
    Object[] arrayOfObject = extractParameters();
    String[] arrayOfString = new String[arrayOfObject.length];
    int i = 0;
    for (;;)
    {
      if (i < arrayOfObject.length) {}
      try
      {
        arrayOfString[i] = arrayOfObject[i].toString();
        i += 1;
        continue;
        return arrayOfString;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void Close() {}
  
  public void bind(int paramInt, double paramDouble)
  {
    this.parameterMap.put(Integer.valueOf(paramInt), Double.valueOf(paramDouble));
  }
  
  public void bind(int paramInt1, int paramInt2)
  {
    this.parameterMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void bind(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      bindNull(paramInt);
      return;
    }
    this.parameterMap.put(Integer.valueOf(paramInt), paramString);
  }
  
  public void bind(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0)
    {
      bindNull(paramInt);
      return;
    }
    this.parameterMap.put(Integer.valueOf(paramInt), paramArrayOfByte);
  }
  
  public void bindNull(int paramInt)
  {
    this.parameterMap.put(Integer.valueOf(paramInt), null);
  }
  
  public void clearBinds()
  {
    this.parameterMap.clear();
  }
  
  public boolean execUpdate()
  {
    try
    {
      Object[] arrayOfObject = extractParameters();
      if ((arrayOfObject == null) || (arrayOfObject.length == 0)) {
        this.database.execSQL(this.strSQL);
      } else {
        this.database.execSQL(this.strSQL, arrayOfObject);
      }
    }
    catch (SQLException localSQLException)
    {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/db/SQLiteStatement4C.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */