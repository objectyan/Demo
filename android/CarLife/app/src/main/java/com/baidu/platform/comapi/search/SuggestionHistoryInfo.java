package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;

public class SuggestionHistoryInfo
{
  private String addword = "";
  private String bid = "";
  private String fbid = "";
  public String l1c1Tag;
  public String l1c2;
  public String l1c3;
  private Point point;
  public String searchQuery;
  private int subNodeType = -1;
  private String subtitle = "";
  private String title = "";
  private int type = Integer.MIN_VALUE;
  private String uid = "";
  
  public void copy(SuggestionHistoryInfo paramSuggestionHistoryInfo)
  {
    this.title = paramSuggestionHistoryInfo.getTitle();
    this.subtitle = paramSuggestionHistoryInfo.getSubtitle();
    this.addword = paramSuggestionHistoryInfo.getAddword();
    this.bid = paramSuggestionHistoryInfo.getBid();
    this.fbid = paramSuggestionHistoryInfo.getFbid();
    this.type = paramSuggestionHistoryInfo.getType();
    this.l1c1Tag = paramSuggestionHistoryInfo.l1c1Tag;
    this.l1c2 = paramSuggestionHistoryInfo.l1c2;
    this.l1c3 = paramSuggestionHistoryInfo.l1c3;
    this.searchQuery = paramSuggestionHistoryInfo.searchQuery;
    this.uid = paramSuggestionHistoryInfo.getUid();
    this.point = paramSuggestionHistoryInfo.point;
    this.subNodeType = paramSuggestionHistoryInfo.subNodeType;
  }
  
  public String getAddword()
  {
    return this.addword;
  }
  
  public String getBid()
  {
    return this.bid;
  }
  
  public String getFbid()
  {
    return this.fbid;
  }
  
  public Point getPoint()
  {
    return this.point;
  }
  
  public int getSubNodeType()
  {
    return this.subNodeType;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAddword(String paramString)
  {
    this.addword = paramString;
  }
  
  public void setBid(String paramString)
  {
    this.bid = paramString;
  }
  
  public void setFbid(String paramString)
  {
    this.fbid = paramString;
  }
  
  public void setPoint(Point paramPoint)
  {
    this.point = paramPoint;
  }
  
  public void setSubNodeType(int paramInt)
  {
    this.subNodeType = paramInt;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/SuggestionHistoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */