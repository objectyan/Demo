package com.baidu.vi.db;

import android.database.Cursor;

public class SQLiteResultSet4C
{
  private Cursor cursor;
  
  public SQLiteResultSet4C(Cursor paramCursor)
  {
    this.cursor = paramCursor;
  }
  
  public void close()
  {
    this.cursor.close();
  }
  
  public byte[] getBlobValue(int paramInt)
  {
    return this.cursor.getBlob(paramInt);
  }
  
  public int getColumnCount()
  {
    return this.cursor.getColumnCount();
  }
  
  public int getCount()
  {
    return this.cursor.getCount();
  }
  
  public double getDoubleValue(int paramInt)
  {
    return this.cursor.getDouble(paramInt);
  }
  
  public int getIntValue(int paramInt)
  {
    return this.cursor.getInt(paramInt);
  }
  
  public String getStringValue(int paramInt)
  {
    return this.cursor.getString(paramInt);
  }
  
  public boolean next()
  {
    return this.cursor.moveToNext();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/db/SQLiteResultSet4C.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */