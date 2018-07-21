package com.baidu.platform.comapi.search;

import com.baidu.entity.pb.TrafficPois.SuggestQuery;
import com.baidu.platform.comapi.basestruct.Point;
import com.google.protobuf.micro.ByteStringMicro;
import java.util.ArrayList;

public class AddrListResult
{
  public boolean hasSuggestQuery;
  public int mEnCityCode;
  public String mEnCityname;
  public int mEnCount;
  public String mEnKeyWord;
  public ArrayList<Citys> mEndCitys;
  public ArrayList<Points> mEndPoints;
  public boolean mHaveEnCityList;
  public boolean mHaveEnPrio;
  public boolean mHaveStCitylist;
  public boolean mHaveStPrio;
  public boolean mHaveThroughCityList;
  public boolean mHaveThroughPrio;
  public boolean mIfNav;
  public ByteStringMicro mImgExt;
  public String mResBound;
  public int mResultType;
  public int mStCityCode;
  public String mStCityname;
  public int mStCount;
  public String mStKeyword;
  public ArrayList<Citys> mStartCitys;
  public ArrayList<Points> mStartPoints;
  public Integer mThroughCityCode;
  public String mThroughCityName;
  public ArrayList<Citys> mThroughCitys;
  public int mThroughCount;
  public String mThroughKeyword;
  public ArrayList<Points> mThroughPoints;
  public ArrayList<TrafficPois.SuggestQuery> suggestQuery;
  public int suggestQueryFlag;
  
  public class Citys
  {
    public int code;
    public String name;
    public int num;
    
    public Citys() {}
  }
  
  public class Points
  {
    public String addr;
    public String buidingId;
    public int cityCode;
    public String cityName;
    public String describe;
    public int direction;
    public int dist;
    public String ext;
    public String floor;
    public boolean hasDirect;
    public boolean hasDist;
    public String name;
    public int poiType;
    public Point pt;
    public String uid;
    
    public Points() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/AddrListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */