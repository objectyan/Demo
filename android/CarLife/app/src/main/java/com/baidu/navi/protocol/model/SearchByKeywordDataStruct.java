package com.baidu.navi.protocol.model;

public class SearchByKeywordDataStruct
  extends DataStruct
{
  public static final String KEY_DISTRICT_ID = "districtId";
  public static final String KEY_KEYWORD = "keyword";
  public static final String KEY_POI_LIST = "poiList";
  public int districtId;
  public String keyword;
  
  public SearchByKeywordDataStruct()
  {
    this.mCmd = "searchByKeyword";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/SearchByKeywordDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */