package com.baidu.che.codriver.protocol.data.nlp;

import android.text.TextUtils;
import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;

public class NLPResponseData
  implements INoProguard
{
  public int errno;
  @SerializedName("list_type")
  public String listType;
  public String logid;
  @SerializedName("raw_text")
  public String rawText;
  @SerializedName("result")
  public ArrayList<Result> resultList;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((!TextUtils.isEmpty(this.rawText)) && (!TextUtils.isEmpty(this.logid))) {
      localStringBuffer.append("BaseResult{errno='" + this.errno + '\'' + ", rawText='" + this.rawText + '\'' + ", logid='" + this.logid + '\'' + ", listType='" + this.listType + '\'' + '}');
    }
    if ((this.resultList != null) && (!this.resultList.isEmpty()))
    {
      localStringBuffer.append('\n');
      localStringBuffer.append("-----NLP播报结果:");
      Iterator localIterator = this.resultList.iterator();
      while (localIterator.hasNext())
      {
        Result localResult = (Result)localIterator.next();
        if (localResult.ttsStatus != null) {
          localStringBuffer.append(localResult.ttsStatus.toString());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static class Directives
    implements INoProguard
  {
    public JsonObject header;
    public NLPResponseData.Payload payload;
  }
  
  public static class Payload
    implements INoProguard
  {
    @SerializedName("ask_type")
    public String askType;
    public int index;
    public String scene;
    public String url;
    public int x;
    public int y;
  }
  
  public static class Result
    implements INoProguard
  {
    @SerializedName("card_type")
    public String cardType;
    public String city;
    @SerializedName("current_temp")
    public String currentTemp;
    public JsonObject data;
    public ArrayList<NLPResponseData.Directives> directives;
    public String intent;
    public String listType;
    public String pm25;
    @SerializedName("pm25_level")
    public String pm25Level;
    @SerializedName("tts_status")
    public TtsData ttsStatus;
    @SerializedName("update_time")
    public String updateTime;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/nlp/NLPResponseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */