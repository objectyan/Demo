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

public class StringValueRegular
  extends Regular
{
  public String a = null;
  public List<String> arrValues = null;
  public String b = null;
  public String fixValue = null;
  private Pattern pattern = null;
  public String regex = null;
  
  public StringValueRegular(GeneralRegularData paramGeneralRegularData, String paramString1, String paramString2, String paramString3)
  {
    super(paramGeneralRegularData, paramString1, paramString2, paramString3);
  }
  
  public boolean check()
  {
    if ((this.mGeneralRegularData != null) && (this.mGeneralRegularData.getDataBundle() != null) && (!this.mGeneralRegularData.getDataBundle().containsKey(this.name))) {
      return true;
    }
    Object localObject1 = null;
    boolean bool2 = false;
    Object localObject2 = localObject1;
    boolean bool1 = bool2;
    if (this.mGeneralRegularData != null)
    {
      localObject2 = localObject1;
      bool1 = bool2;
      if (this.mGeneralRegularData.getDataBundle() != null)
      {
        localObject2 = localObject1;
        bool1 = bool2;
        if (this.mGeneralRegularData.getDataBundle().containsKey(this.name))
        {
          localObject1 = this.mGeneralRegularData.getDataBundle().getString(this.name);
          if ((!"f".equals(this.category)) || (this.fixValue == null) || (!this.fixValue.equals(localObject1))) {
            break label415;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      String str3;
      String str4;
      String str1;
      if (!bool1)
      {
        str3 = "-";
        str4 = "[error][name:" + this.name + "][category:" + this.category + "][type:" + this.type + "][regularValue:";
        if (!"f".equals(this.category)) {
          break label719;
        }
        localObject1 = str4 + this.fixValue;
        str1 = "" + this.fixValue;
        label259:
        localObject1 = (String)localObject1 + "][actualvalue:" + (String)localObject2 + "]";
        this.mGeneralRegularData.addErrorInfo((String)localObject1);
        this.mGeneralRegularData.addToastErrorInfo(this.name, "" + (String)localObject2);
      }
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("name", this.name);
        ((JSONObject)localObject1).put("category", this.category);
        ((JSONObject)localObject1).put("type", this.type);
        ((JSONObject)localObject1).put("regularValue", str1);
        ((JSONObject)localObject1).put("actualvalue", "" + (String)localObject2);
        DataCheckHelper.sUpJsonArr.put(localObject1);
        return bool1;
        label415:
        if ("v".equals(this.category))
        {
          bool1 = true;
          localObject2 = localObject1;
          continue;
        }
        if ("arr".equals(this.category))
        {
          if ((this.arrValues != null) && (this.arrValues.contains(localObject1))) {}
          for (bool1 = true;; bool1 = false)
          {
            localObject2 = localObject1;
            break;
          }
        }
        if ("area".equals(this.category))
        {
          if ((this.a != null) && (this.b != null))
          {
            if ((((String)localObject1).compareTo(this.a) > 0) && (((String)localObject1).compareTo(this.b) < 0)) {}
            for (bool1 = true;; bool1 = false)
            {
              localObject2 = localObject1;
              break;
            }
          }
          if ((this.a != null) && (this.b == null))
          {
            if (((String)localObject1).compareTo(this.a) > 0) {}
            for (bool1 = true;; bool1 = false)
            {
              localObject2 = localObject1;
              break;
            }
          }
          localObject2 = localObject1;
          bool1 = bool2;
          if (this.a != null) {
            continue;
          }
          localObject2 = localObject1;
          bool1 = bool2;
          if (this.b == null) {
            continue;
          }
          if (((String)localObject1).compareTo(this.b) < 0) {}
          for (bool1 = true;; bool1 = false)
          {
            localObject2 = localObject1;
            break;
          }
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (!"regex".equals(this.category)) {
          continue;
        }
        if ((this.pattern == null) && (this.regex != null) && (this.regex.length() > 0)) {
          this.pattern = Pattern.compile(this.regex);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (this.pattern == null) {
          continue;
        }
        try
        {
          bool1 = this.pattern.matcher((CharSequence)localObject1).matches();
          localObject2 = localObject1;
        }
        catch (Exception localException)
        {
          bool1 = false;
          localObject2 = localObject1;
        }
        continue;
        label719:
        localObject1 = str4;
        String str2 = str3;
        if ("v".equals(this.category)) {
          break label259;
        }
        if ("arr".equals(this.category))
        {
          localObject1 = str4 + this.arrValues;
          str2 = this.arrValues.toString();
          break label259;
        }
        if ("area".equals(this.category))
        {
          localObject1 = str4 + this.a + "," + this.b;
          str2 = this.a + "," + this.b;
          break label259;
        }
        localObject1 = str4;
        str2 = str3;
        if (!"regex".equals(this.category)) {
          break label259;
        }
        localObject1 = str4 + this.regex;
        str2 = this.regex;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/regular/StringValueRegular.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */