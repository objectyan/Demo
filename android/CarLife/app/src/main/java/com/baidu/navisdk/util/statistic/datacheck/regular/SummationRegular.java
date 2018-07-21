package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SummationRegular
  extends Regular
{
  public int curSummation = 0;
  public int summationRegularValue = 0;
  
  public SummationRegular(GeneralRegularData paramGeneralRegularData, int paramInt)
  {
    super(paramGeneralRegularData, null, null, null);
    this.summationRegularValue = paramInt;
  }
  
  public boolean check()
  {
    int i = this.curSummation + 1;
    this.curSummation = i;
    if (i > this.summationRegularValue)
    {
      this.mGeneralRegularData.addErrorInfo("[error][summation:" + this.summationRegularValue + "][curSummation:" + this.curSummation + "]");
      this.mGeneralRegularData.addToastErrorInfo("summation", "" + this.curSummation);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", "summation");
      localJSONObject.put("category", this.category);
      localJSONObject.put("type", this.type);
      localJSONObject.put("regularValue", this.summationRegularValue);
      localJSONObject.put("actualvalue", "" + this.curSummation);
      DataCheckHelper.sUpJsonArr.put(localJSONObject);
      return false;
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/regular/SummationRegular.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */