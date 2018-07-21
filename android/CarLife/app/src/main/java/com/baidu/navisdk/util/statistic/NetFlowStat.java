package com.baidu.navisdk.util.statistic;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.text.DecimalFormat;

public class NetFlowStat
{
  private static final String KEY_COUNT_SUM = "count.sum";
  private static final String KEY_DATA_SIZE = "data.size";
  private static final String KEY_PSTDOMAIN_NAME = "pstdomain.name";
  private static final String KEY_TICK_COUNT = "tick.count";
  private static final String NAVI_END_FLAG_KEY = "navi.end.flag.key";
  private static final String TAG = NetFlowStat.class.getName();
  private static NetFlowStat instance = null;
  private StringBuffer httpNetFlowBuffer = null;
  
  public static NetFlowStat getInstance()
  {
    if (instance == null) {
      instance = new NetFlowStat();
    }
    return instance;
  }
  
  private static String getUrlForShort(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        if ((paramString.startsWith("http://")) && (paramString.length() > "http://".length())) {
          return paramString.substring("http://".length());
        }
        str = paramString;
      } while (!paramString.startsWith("https://"));
      str = paramString;
    } while (paramString.length() <= "https://".length());
    return paramString.substring("https://".length());
  }
  
  private String parseBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramBundle.getInt("count.sum");
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = paramBundle.getBundle(i + "");
      if (localBundle != null)
      {
        localStringBuffer.append("e;");
        localStringBuffer.append(localBundle.getLong("tick.count"));
        localStringBuffer.append(";");
        localStringBuffer.append(localBundle.getDouble("data.size"));
        localStringBuffer.append(";");
        localStringBuffer.append(getUrlForShort(localBundle.getString("pstdomain.name")));
        if (i + 1 < j) {
          localStringBuffer.append("||");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public String GetAllNetWorkDataSize()
  {
    Bundle localBundle = new Bundle();
    JNIStatisticsControl.sInstance.getAllNetWorkDataSize(localBundle);
    return parseBundle(localBundle);
  }
  
  public void addHttpNetFlow(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (this.httpNetFlowBuffer == null) {
      this.httpNetFlowBuffer = new StringBuffer();
    }
    if (!this.httpNetFlowBuffer.toString().equals("")) {
      this.httpNetFlowBuffer.append("||");
    }
    this.httpNetFlowBuffer.append(paramString);
  }
  
  public void clearOldNetWorkDataRecord()
  {
    JNIStatisticsControl.sInstance.clearOldNetWorkDataRecord();
  }
  
  public void destroy()
  {
    instance = null;
    this.httpNetFlowBuffer = null;
  }
  
  public void endStat(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    PreferenceHelper.getInstance(paramContext).putBoolean("navi.end.flag.key", false);
    String str = GetAllNetWorkDataSize();
    paramContext = "";
    if (this.httpNetFlowBuffer != null) {
      paramContext = this.httpNetFlowBuffer.toString();
    }
    LogUtil.e(TAG + "_endStat engine:", str);
    LogUtil.e(TAG + "_endStat http:", paramContext);
    NaviMergeStatItem.getInstance().setNetFlow(str + "||" + paramContext);
    clearOldNetWorkDataRecord();
    destroy();
  }
  
  public void initStat(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = BNaviModuleManager.getContext();
      localContext = paramContext;
      if (paramContext == null) {
        return;
      }
    }
    if (PreferenceHelper.getInstance(localContext).getBoolean("navi.end.flag.key", false)) {}
    for (NaviMergeStatItem.getInstance().mDft = 1;; NaviMergeStatItem.getInstance().mDft = 0)
    {
      PreferenceHelper.getInstance(localContext).putBoolean("navi.end.flag.key", true);
      return;
    }
  }
  
  public static class HttpNetFlowInfo
  {
    private static DecimalFormat decimalFormat = null;
    private float receiveDataSize = 0.0F;
    private float sendDataSize = 0.0F;
    private long startTime = 0L;
    private String url = null;
    
    public HttpNetFlowInfo()
    {
      if (decimalFormat == null) {
        decimalFormat = new DecimalFormat(".0");
      }
    }
    
    public void setReceiveDataInfo(long paramLong)
    {
      this.receiveDataSize = ((float)(paramLong >> 9) / 2.0F);
    }
    
    public void setSendDataInfo(long paramLong1, long paramLong2, String paramString)
    {
      this.url = NetFlowStat.getUrlForShort(paramString);
      this.startTime = paramLong1;
      this.sendDataSize = ((float)(paramLong2 >> 9) / 2.0F);
    }
    
    public void submit()
    {
      NetFlowStat.getInstance().addHttpNetFlow(toString());
    }
    
    public String toString()
    {
      if (decimalFormat == null) {
        decimalFormat = new DecimalFormat(".0");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("c;");
      localStringBuffer.append(this.startTime + ";");
      localStringBuffer.append(decimalFormat.format(this.sendDataSize + this.receiveDataSize) + ";");
      if (this.url == null) {
        this.url = "";
      }
      localStringBuffer.append(this.url);
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/NetFlowStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */