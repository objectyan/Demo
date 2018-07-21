package com.baidu.sapi2.result;

import java.util.List;

public class GetPopularPortraitsInfoResult
  extends SapiResult
{
  public List<PopularPortraitsInfo> popularPortraitsInfoList;
  
  public static class PopularPortraitsInfo
  {
    public int myItem;
    public int num;
    public String series;
    public String url;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/GetPopularPortraitsInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */