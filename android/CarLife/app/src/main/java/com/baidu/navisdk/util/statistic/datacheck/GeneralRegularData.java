package com.baidu.navisdk.util.statistic.datacheck;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.datacheck.regular.DoubleValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.FrequencyRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.IntValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.LongValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.navisdk.util.statistic.datacheck.regular.StringValueRegular;
import com.baidu.navisdk.util.statistic.datacheck.regular.SummationRegular;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralRegularData
{
  public String id = null;
  public long lastestCheckTime = 0L;
  private Bundle mCheckDataBundle = null;
  private StatisitcsDataCheck mCurCheckData = null;
  private StringBuffer mErrorInfo = null;
  private StringBuffer mInfo = null;
  private List<Regular> mRegulars = new ArrayList();
  private StringBuffer mToastErrorInfo = null;
  public int summation = 0;
  
  private void addHeadInfo()
  {
    this.mInfo = new StringBuffer();
    this.mInfo.append("\n-----------------------------------------\n");
    this.mInfo.append(DataCheckLogCenter.getInstance().getCurTimeString() + "\n");
    if (this.mCurCheckData != null) {
      this.mInfo.append("id:" + this.mCurCheckData.getID() + ", data=" + this.mCurCheckData.getDataBundle().toString() + "\n");
    }
    if (this.mCurCheckData != null) {
      DataCheckHelper.reset();
    }
    try
    {
      DataCheckHelper.sUpJson.put("id", this.mCurCheckData.getID());
      DataCheckHelper.sUpJson.put("value", this.mCurCheckData.getDataBundle().toString());
      DataCheckHelper.sUpJson.put("time", SystemClock.elapsedRealtime());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void generateFinalInfo(boolean paramBoolean)
  {
    DataCheckLogCenter.getInstance().appendLog(this.mInfo.toString());
    if ((!paramBoolean) && (this.mErrorInfo != null)) {
      DataCheckLogCenter.getInstance().appendLog(this.mErrorInfo.toString());
    }
    DataCheckLogCenter.getInstance().appendLog("stack:\n" + LogUtil.getCallStack() + "\n");
    if ((!paramBoolean) && (this.mCurCheckData != null)) {}
    try
    {
      DataCheckHelper.sUpJson.put("errors", DataCheckHelper.sUpJsonArr);
      DataCheckHelper.sUpJson.put("stack", LogUtil.getCallStack("com.baidu.navisdk"));
      DataCheckHelper.eventId = Integer.parseInt(this.mCurCheckData.getID());
      DataCheckHelper.uploadDataCheck(DataCheckHelper.sUpJson.toString());
      if ((LogUtil.LOGGABLE) && (this.mToastErrorInfo != null) && (BNaviModuleManager.getActivity() != null)) {
        Toast.makeText(BNaviModuleManager.getActivity(), this.mToastErrorInfo.toString(), 1).show();
      }
      this.mInfo = null;
      this.mErrorInfo = null;
      this.mToastErrorInfo = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public void addErrorInfo(String paramString)
  {
    if (this.mErrorInfo == null)
    {
      this.mErrorInfo = new StringBuffer();
      this.mErrorInfo.append("[error][id:" + this.mCurCheckData.getID() + "]\n");
    }
    if ((this.mErrorInfo != null) && (paramString != null)) {
      this.mErrorInfo.append(paramString + "\n");
    }
  }
  
  public void addToastErrorInfo(String paramString1, String paramString2)
  {
    if (this.mToastErrorInfo == null)
    {
      this.mToastErrorInfo = new StringBuffer();
      this.mToastErrorInfo.append("[err][" + this.mCurCheckData.getID() + "]\n");
    }
    if ((this.mToastErrorInfo != null) && (paramString1 != null) && (paramString2 != null)) {
      this.mToastErrorInfo.append("[" + paramString1 + ":" + paramString2 + "]");
    }
  }
  
  /* Error */
  public boolean check(StatisitcsDataCheck paramStatisitcsDataCheck)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 38	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCurCheckData	Lcom/baidu/navisdk/util/statistic/datacheck/StatisitcsDataCheck;
    //   7: aload_0
    //   8: getfield 38	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCurCheckData	Lcom/baidu/navisdk/util/statistic/datacheck/StatisitcsDataCheck;
    //   11: ifnull +67 -> 78
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 38	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCurCheckData	Lcom/baidu/navisdk/util/statistic/datacheck/StatisitcsDataCheck;
    //   19: invokeinterface 93 1 0
    //   24: putfield 40	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCheckDataBundle	Landroid/os/Bundle;
    //   27: aload_0
    //   28: invokespecial 203	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:addHeadInfo	()V
    //   31: iconst_1
    //   32: istore_3
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: aload_0
    //   37: getfield 36	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mRegulars	Ljava/util/List;
    //   40: invokeinterface 209 1 0
    //   45: if_icmpge +39 -> 84
    //   48: aload_0
    //   49: getfield 36	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mRegulars	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 213 2 0
    //   58: checkcast 215	com/baidu/navisdk/util/statistic/datacheck/regular/Regular
    //   61: invokevirtual 218	com/baidu/navisdk/util/statistic/datacheck/regular/Regular:check	()Z
    //   64: istore 4
    //   66: iload_3
    //   67: iload 4
    //   69: iand
    //   70: istore_3
    //   71: iload_2
    //   72: iconst_1
    //   73: iadd
    //   74: istore_2
    //   75: goto -40 -> 35
    //   78: iconst_0
    //   79: istore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: iload_3
    //   83: ireturn
    //   84: new 61	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   91: ldc -36
    //   93: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 38	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCurCheckData	Lcom/baidu/navisdk/util/statistic/datacheck/StatisitcsDataCheck;
    //   100: invokeinterface 87 1 0
    //   105: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc -34
    //   110: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload_3
    //   114: invokevirtual 225	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 230	com/baidu/navisdk/util/statistic/datacheck/DataCheckCenter:log	(Ljava/lang/String;)V
    //   123: aload_0
    //   124: iload_3
    //   125: invokespecial 232	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:generateFinalInfo	(Z)V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 38	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCurCheckData	Lcom/baidu/navisdk/util/statistic/datacheck/StatisitcsDataCheck;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 40	com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData:mCheckDataBundle	Landroid/os/Bundle;
    //   138: goto -58 -> 80
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	GeneralRegularData
    //   0	146	1	paramStatisitcsDataCheck	StatisitcsDataCheck
    //   34	41	2	i	int
    //   32	93	3	bool1	boolean
    //   64	6	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	31	141	finally
    //   35	66	141	finally
    //   84	138	141	finally
  }
  
  public Bundle getDataBundle()
  {
    return this.mCheckDataBundle;
  }
  
  public boolean loadRegular(String paramString)
  {
    DataCheckCenter.log("start load regulars.");
    Object localObject1;
    int i;
    Object localObject2;
    String str;
    int j;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("id")) {
          break label1346;
        }
        this.id = paramString.getString("id");
        this.mRegulars.clear();
        if (paramString.has("summation"))
        {
          localObject1 = new SummationRegular(this, paramString.getInt("summation"));
          this.mRegulars.add(localObject1);
        }
        if (paramString.has("freq"))
        {
          localObject1 = new FrequencyRegular(this, paramString.getLong("freq"));
          this.mRegulars.add(localObject1);
        }
        JSONArray localJSONArray = paramString.getJSONArray("attr");
        int k = localJSONArray.length();
        i = 0;
        if (i >= k) {
          break label1329;
        }
        localObject2 = localJSONArray.getJSONObject(i);
        paramString = ((JSONObject)localObject2).getString("name");
        localObject1 = ((JSONObject)localObject2).getString("type");
        str = ((JSONObject)localObject2).getString("category");
        if (!"int".equals(localObject1)) {
          break;
        }
        localObject1 = new IntValueRegular(this, paramString, str, (String)localObject1);
        if ("f".equals(str))
        {
          ((IntValueRegular)localObject1).fixValue = ((JSONObject)localObject2).getInt("value");
          paramString = (String)localObject1;
          if (paramString == null) {
            break label1337;
          }
          this.mRegulars.add(paramString);
          break label1337;
        }
        paramString = (String)localObject1;
        if ("v".equals(str)) {
          continue;
        }
        if (!"area".equals(str)) {
          break label364;
        }
        paramString = ((JSONObject)localObject2).getJSONArray("value");
        if ((paramString != null) && (paramString.length() == 2))
        {
          j = paramString.getInt(0);
          if (j != 8888) {
            ((IntValueRegular)localObject1).a = j;
          }
          j = paramString.getInt(1);
          paramString = (String)localObject1;
          if (j == 8888) {
            continue;
          }
          ((IntValueRegular)localObject1).b = j;
          paramString = (String)localObject1;
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        DataCheckCenter.log("end load regulars.err");
        return false;
      }
      continue;
      label364:
      if ("arr".equals(str))
      {
        ((IntValueRegular)localObject1).arrValues = new ArrayList();
        localObject2 = ((JSONObject)localObject2).getJSONArray("value");
        j = 0;
        for (;;)
        {
          paramString = (String)localObject1;
          if (j >= ((JSONArray)localObject2).length()) {
            break;
          }
          ((IntValueRegular)localObject1).arrValues.add(Integer.valueOf(((JSONArray)localObject2).getInt(j)));
          j += 1;
        }
      }
      if ("regex".equals(str))
      {
        ((IntValueRegular)localObject1).regex = ((JSONObject)localObject2).getString("value");
        paramString = (String)localObject1;
      }
      else
      {
        paramString = null;
        DataCheckCenter.log("loadRegular the category is error.");
      }
    }
    if ("long".equals(localObject1))
    {
      localObject1 = new LongValueRegular(this, paramString, str, (String)localObject1);
      if ("f".equals(str))
      {
        ((LongValueRegular)localObject1).fixValue = ((JSONObject)localObject2).getLong("value");
        paramString = (String)localObject1;
      }
      label534:
      while (paramString != null)
      {
        this.mRegulars.add(paramString);
        break;
        paramString = (String)localObject1;
        if (!"v".equals(str)) {
          if ("area".equals(str))
          {
            paramString = ((JSONObject)localObject2).getJSONArray("value");
            if ((paramString == null) || (paramString.length() != 2)) {
              break label1348;
            }
            long l = paramString.getLong(0);
            if (l != 8888L) {
              ((LongValueRegular)localObject1).a = l;
            }
            l = paramString.getLong(1);
            paramString = (String)localObject1;
            if (l != 8888L)
            {
              ((LongValueRegular)localObject1).b = l;
              paramString = (String)localObject1;
            }
          }
          else
          {
            if ("arr".equals(str))
            {
              ((LongValueRegular)localObject1).arrValues = new ArrayList();
              localObject2 = ((JSONObject)localObject2).getJSONArray("value");
              j = 0;
              for (;;)
              {
                paramString = (String)localObject1;
                if (j >= ((JSONArray)localObject2).length()) {
                  break;
                }
                ((LongValueRegular)localObject1).arrValues.add(Long.valueOf(((JSONArray)localObject2).getLong(j)));
                j += 1;
              }
            }
            if ("regex".equals(str))
            {
              ((LongValueRegular)localObject1).regex = ((JSONObject)localObject2).getString("value");
              paramString = (String)localObject1;
            }
            else
            {
              paramString = null;
              DataCheckCenter.log("loadRegular the category is error.");
            }
          }
        }
      }
    }
    if ("double".equals(localObject1))
    {
      localObject1 = new DoubleValueRegular(this, paramString, str, (String)localObject1);
      if ("f".equals(str)) {
        paramString = (String)localObject1;
      }
      label810:
      while (paramString != null)
      {
        this.mRegulars.add(paramString);
        break;
        paramString = (String)localObject1;
        if (!"v".equals(str)) {
          if ("area".equals(str))
          {
            paramString = ((JSONObject)localObject2).getJSONArray("value");
            if ((paramString == null) || (paramString.length() != 2)) {
              break label1353;
            }
            double d = paramString.getDouble(0);
            if (d != 8888.0D) {
              ((DoubleValueRegular)localObject1).a = d;
            }
            d = paramString.getDouble(1);
            paramString = (String)localObject1;
            if (d != 8888.0D)
            {
              ((DoubleValueRegular)localObject1).b = d;
              paramString = (String)localObject1;
            }
          }
          else
          {
            if ("arr".equals(str))
            {
              ((DoubleValueRegular)localObject1).arrValues = new ArrayList();
              localObject2 = ((JSONObject)localObject2).getJSONArray("value");
              j = 0;
              for (;;)
              {
                paramString = (String)localObject1;
                if (j >= ((JSONArray)localObject2).length()) {
                  break;
                }
                ((DoubleValueRegular)localObject1).arrValues.add(Double.valueOf(((JSONArray)localObject2).getDouble(j)));
                j += 1;
              }
            }
            if ("regex".equals(str))
            {
              ((DoubleValueRegular)localObject1).regex = ((JSONObject)localObject2).getString("value");
              paramString = (String)localObject1;
            }
            else
            {
              paramString = null;
              DataCheckCenter.log("loadRegular the category is error.");
            }
          }
        }
      }
    }
    if ("string".equals(localObject1))
    {
      localObject1 = new StringValueRegular(this, paramString, str, (String)localObject1);
      if ("f".equals(str))
      {
        ((StringValueRegular)localObject1).fixValue = ((JSONObject)localObject2).getString("value");
        paramString = (String)localObject1;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.mRegulars.add(paramString);
        break label1337;
        paramString = (String)localObject1;
        if ("v".equals(str)) {
          continue;
        }
        if ("area".equals(str))
        {
          paramString = ((JSONObject)localObject2).getJSONArray("value");
          if ((paramString == null) || (paramString.length() != 2)) {
            break label1358;
          }
          localObject2 = paramString.getString(0);
          if (!"null".equals(localObject2)) {
            ((StringValueRegular)localObject1).a = ((String)localObject2);
          }
          localObject2 = paramString.getString(1);
          paramString = (String)localObject1;
          if ("null".equals(localObject2)) {
            continue;
          }
          ((StringValueRegular)localObject1).b = ((String)localObject2);
          paramString = (String)localObject1;
          continue;
        }
        if ("arr".equals(str))
        {
          ((StringValueRegular)localObject1).arrValues = new ArrayList();
          localObject2 = ((JSONObject)localObject2).getJSONArray("value");
          j = 0;
          for (;;)
          {
            paramString = (String)localObject1;
            if (j >= ((JSONArray)localObject2).length()) {
              break;
            }
            ((StringValueRegular)localObject1).arrValues.add(((JSONArray)localObject2).getString(j));
            j += 1;
          }
        }
        if ("regex".equals(str))
        {
          ((StringValueRegular)localObject1).regex = ((JSONObject)localObject2).getString("value");
          paramString = (String)localObject1;
          continue;
        }
        paramString = null;
        DataCheckCenter.log("loadRegular the category is error.");
        continue;
        label1329:
        DataCheckCenter.log("end load regulars.ok");
        return true;
      }
      label1337:
      i += 1;
      break;
      label1346:
      return false;
      label1348:
      paramString = null;
      break label534;
      label1353:
      paramString = null;
      break label810;
      label1358:
      paramString = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/GeneralRegularData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */