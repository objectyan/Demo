package com.baidu.che.codriver.protocol.data.nlp;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;

public class RestrictionData
  implements INoProguard
{
  @SerializedName("today_restriction")
  public String todayRestriction;
  
  public String getTodayRestriction()
  {
    return this.todayRestriction;
  }
  
  public void setTodayRestriction(String paramString)
  {
    this.todayRestriction = paramString;
  }
  
  public String toString()
  {
    return this.todayRestriction;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/nlp/RestrictionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */