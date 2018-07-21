package com.baidu.navisdk.util.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.navisdk.util.db.object.SearchNameDBObject;

public class SearchNameDBTable
  extends BaseDBTable<SearchNameDBObject>
{
  public static final String COUNT = "search_count";
  public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS search_name(search_name_id INTEGER PRIMARY KEY AUTOINCREMENT,search_name_name text,search_count INTEGER);";
  public static final String ID = "search_name_id";
  public static final String NAME = "search_name_name";
  public static final String TABLE_NAME = "search_name";
  public static final Object mMutex = new Object();
  
  public SearchNameDBObject build(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    SearchNameDBObject localSearchNameDBObject = new SearchNameDBObject();
    localSearchNameDBObject.setId(paramCursor.getInt(paramCursor.getColumnIndex("search_name_id")));
    localSearchNameDBObject.setName(paramCursor.getString(paramCursor.getColumnIndex("search_name_name")));
    localSearchNameDBObject.setCount(paramCursor.getInt(paramCursor.getColumnIndex("search_count")));
    return localSearchNameDBObject;
  }
  
  public ContentValues deconstruct(SearchNameDBObject paramSearchNameDBObject)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramSearchNameDBObject == null) {
      return localContentValues;
    }
    localContentValues.put("search_name_name", paramSearchNameDBObject.getName());
    localContentValues.put("search_count", Integer.valueOf(paramSearchNameDBObject.getCount()));
    return localContentValues;
  }
  
  public String getIdCumName()
  {
    return "search_name_id";
  }
  
  public String getTableName()
  {
    return "search_name";
  }
  
  public Object getmMutex()
  {
    return mMutex;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/table/SearchNameDBTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */