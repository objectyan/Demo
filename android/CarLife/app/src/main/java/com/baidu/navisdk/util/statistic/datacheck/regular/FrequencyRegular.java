package com.baidu.navisdk.util.statistic.datacheck.regular;

import android.os.SystemClock;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FrequencyRegular
  extends Regular
{
  private long frequency = 0L;
  private long lastCheckTime = -1L;
  
  public FrequencyRegular(GeneralRegularData paramGeneralRegularData, long paramLong)
  {
    super(paramGeneralRegularData, null, null, null);
    this.frequency = paramLong;
  }
  
  public boolean check()
  {
    long l = SystemClock.elapsedRealtime();
    if (l - this.lastCheckTime <= this.frequency)
    {
      this.mGeneralRegularData.addErrorInfo("[error][frequency:" + this.frequency + "][lastchecktime:" + this.lastCheckTime + "ms][curchecktime:" + l + "ms][timediff:" + (l - this.lastCheckTime) + "ms]");
      this.mGeneralRegularData.addToastErrorInfo("frequency", l - this.lastCheckTime + "ms");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", "frequency");
      localJSONObject.put("category", this.category);
      localJSONObject.put("type", this.type);
      localJSONObject.put("regularValue", this.frequency);
      localJSONObject.put("actualvalue", "" + (l - this.lastCheckTime));
      DataCheckHelper.sUpJsonArr.put(localJSONObject);
      this.lastCheckTime = l;
      return false;
      this.lastCheckTime = l;
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/regular/FrequencyRegular.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */