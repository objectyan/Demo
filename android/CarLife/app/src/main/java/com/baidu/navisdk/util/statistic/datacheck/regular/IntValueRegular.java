package com.baidu.navisdk.util.statistic.datacheck.regular;

import android.os.Bundle;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IntValueRegular
  extends Regular
{
  public int a = Integer.MIN_VALUE;
  public List<Integer> arrValues = null;
  public int b = Integer.MAX_VALUE;
  public int fixValue = Integer.MIN_VALUE;
  private Pattern pattern = null;
  public String regex = null;
  
  public IntValueRegular(GeneralRegularData paramGeneralRegularData, String paramString1, String paramString2, String paramString3)
  {
    super(paramGeneralRegularData, paramString1, paramString2, paramString3);
  }
  
  public boolean check()
  {
    if ((this.mGeneralRegularData != null) && (this.mGeneralRegularData.getDataBundle() != null) && (!this.mGeneralRegularData.getDataBundle().containsKey(this.name))) {
      return true;
    }
    int j = Integer.MIN_VALUE;
    boolean bool2 = false;
    int i = j;
    boolean bool1 = bool2;
    if (this.mGeneralRegularData != null)
    {
      i = j;
      bool1 = bool2;
      if (this.mGeneralRegularData.getDataBundle() != null)
      {
        i = j;
        bool1 = bool2;
        if (this.mGeneralRegularData.getDataBundle().containsKey(this.name))
        {
          j = this.mGeneralRegularData.getDataBundle().getInt(this.name);
          if ((!"f".equals(this.category)) || (this.fixValue != j)) {
            break label414;
          }
          bool1 = true;
          i = j;
        }
      }
    }
    for (;;)
    {
      String str2;
      String str3;
      Object localObject;
      String str1;
      if (!bool1)
      {
        str2 = "-";
        str3 = "[error][name:" + this.name + "][category:" + this.category + "][type:" + this.type + "][regularValue:";
        if (!"f".equals(this.category)) {
          break label723;
        }
        localObject = str3 + this.fixValue;
        str1 = "" + this.fixValue;
        label251:
        localObject = (String)localObject + "][actualvalue:" + i + "]";
        this.mGeneralRegularData.addErrorInfo((String)localObject);
        this.mGeneralRegularData.addToastErrorInfo(this.name, "" + i);
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("name", this.name);
        ((JSONObject)localObject).put("category", this.category);
        ((JSONObject)localObject).put("type", this.type);
        ((JSONObject)localObject).put("regularValue", str1);
        ((JSONObject)localObject).put("actualvalue", "" + i);
        DataCheckHelper.sUpJsonArr.put(localObject);
        return bool1;
        label414:
        if ("v".equals(this.category))
        {
          bool1 = true;
          i = j;
          continue;
        }
        if ("arr".equals(this.category))
        {
          if ((this.arrValues != null) && (this.arrValues.contains(Integer.valueOf(j)))) {}
          for (bool1 = true;; bool1 = false)
          {
            i = j;
            break;
          }
        }
        if ("area".equals(this.category))
        {
          if ((this.a != Integer.MIN_VALUE) && (this.b != Integer.MAX_VALUE))
          {
            if ((j > this.a) && (j < this.b)) {}
            for (bool1 = true;; bool1 = false)
            {
              i = j;
              break;
            }
          }
          if ((this.a != Integer.MIN_VALUE) && (this.b == Integer.MAX_VALUE))
          {
            if (j > this.a) {}
            for (bool1 = true;; bool1 = false)
            {
              i = j;
              break;
            }
          }
          i = j;
          bool1 = bool2;
          if (this.a != Integer.MIN_VALUE) {
            continue;
          }
          i = j;
          bool1 = bool2;
          if (this.b == Integer.MAX_VALUE) {
            continue;
          }
          if (j < this.b) {}
          for (bool1 = true;; bool1 = false)
          {
            i = j;
            break;
          }
        }
        i = j;
        bool1 = bool2;
        if (!"regex".equals(this.category)) {
          continue;
        }
        if ((this.pattern == null) && (this.regex != null) && (this.regex.length() > 0)) {
          this.pattern = Pattern.compile(this.regex);
        }
        i = j;
        bool1 = bool2;
        if (this.pattern == null) {
          continue;
        }
        bool1 = this.pattern.matcher("" + j).matches();
        i = j;
        continue;
        label723:
        localObject = str3;
        str1 = str2;
        if ("v".equals(this.category)) {
          break label251;
        }
        if ("arr".equals(this.category))
        {
          localObject = str3 + this.arrValues;
          str1 = this.arrValues.toString();
          break label251;
        }
        if ("area".equals(this.category))
        {
          localObject = str3 + this.a + "," + this.b;
          str1 = this.a + "," + this.b;
          break label251;
        }
        localObject = str3;
        str1 = str2;
        if (!"regex".equals(this.category)) {
          break label251;
        }
        localObject = str3 + this.regex;
        str1 = this.regex;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/regular/IntValueRegular.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */