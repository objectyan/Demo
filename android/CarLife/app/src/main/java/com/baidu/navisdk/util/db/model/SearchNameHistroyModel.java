package com.baidu.navisdk.util.db.model;

import android.text.TextUtils;
import com.baidu.navisdk.util.db.object.SearchNameDBObject;
import com.baidu.navisdk.util.db.table.SearchNameDBTable;
import java.util.ArrayList;
import java.util.List;

public class SearchNameHistroyModel
{
  private static final int SIZE_LIMIT = 50;
  public List<SearchNameDBObject> mSearchNameDBObjects;
  private SearchNameDBTable mTable = new SearchNameDBTable();
  
  private SearchNameHistroyModel()
  {
    this.mTable.beginTransaction();
    this.mSearchNameDBObjects = this.mTable.queryAll("search_name_id", "DESC");
    if (this.mSearchNameDBObjects == null) {
      this.mSearchNameDBObjects = new ArrayList(0);
    }
    consumeSize();
    this.mTable.endTransaction();
  }
  
  private void consumeSize()
  {
    if (this.mSearchNameDBObjects.size() > 50)
    {
      SearchNameDBObject localSearchNameDBObject = (SearchNameDBObject)this.mSearchNameDBObjects.get(this.mSearchNameDBObjects.size() - 1);
      if (localSearchNameDBObject != null) {
        this.mTable.delete(localSearchNameDBObject.getId());
      }
      this.mSearchNameDBObjects.remove(this.mSearchNameDBObjects.size() - 1);
    }
  }
  
  public static SearchNameHistroyModel getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  public void addSearchName(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.trim().equals(""))) {
      return;
    }
    SearchNameDBObject localSearchNameDBObject = new SearchNameDBObject();
    localSearchNameDBObject.setName(paramString);
    int i = removeSearchName(paramString);
    if ((i >= 0) && (i < this.mSearchNameDBObjects.size())) {
      localSearchNameDBObject.setCount(localSearchNameDBObject.getCount() + 1);
    }
    this.mTable.insert(localSearchNameDBObject);
    this.mSearchNameDBObjects.add(0, localSearchNameDBObject);
    consumeSize();
  }
  
  public void clear()
  {
    this.mTable.deleteAll();
    this.mSearchNameDBObjects.clear();
  }
  
  public String getName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mSearchNameDBObjects.size()))
    {
      SearchNameDBObject localSearchNameDBObject = (SearchNameDBObject)this.mSearchNameDBObjects.get(paramInt);
      if (localSearchNameDBObject != null) {
        return localSearchNameDBObject.getName();
      }
    }
    return null;
  }
  
  public int getSize()
  {
    return this.mSearchNameDBObjects.size();
  }
  
  public int removeSearchName(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.trim().equals(""))) {}
    for (;;)
    {
      return -1;
      int i = 0;
      while (i < this.mSearchNameDBObjects.size())
      {
        SearchNameDBObject localSearchNameDBObject = (SearchNameDBObject)this.mSearchNameDBObjects.get(i);
        if ((localSearchNameDBObject != null) && (paramString.equalsIgnoreCase(localSearchNameDBObject.getName())))
        {
          this.mSearchNameDBObjects.remove(i);
          this.mTable.delete(localSearchNameDBObject.getId());
          return i;
        }
        i += 1;
      }
    }
  }
  
  static class InnerHolder
  {
    static SearchNameHistroyModel mInstance = new SearchNameHistroyModel(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/model/SearchNameHistroyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */