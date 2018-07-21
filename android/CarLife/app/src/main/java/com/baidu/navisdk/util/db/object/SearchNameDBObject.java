package com.baidu.navisdk.util.db.object;

public class SearchNameDBObject
  implements BaseDBObject
{
  private int mCount = 1;
  private int mId;
  private String mName;
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void setCount(int paramInt)
  {
    this.mCount = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/db/object/SearchNameDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */