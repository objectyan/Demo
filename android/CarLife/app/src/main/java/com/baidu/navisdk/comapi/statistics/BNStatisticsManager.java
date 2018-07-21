package com.baidu.navisdk.comapi.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdStatisticsRecord;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.statistic.BNEngineStatistics;
import com.baidu.navisdk.util.statistic.IBNStatisticsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class BNStatisticsManager
  implements CommandConst
{
  private static final String JSONKEY_ACTION = "\"act\":";
  private static final String JSONKEY_ACTPARAM = "\"ActParam\":";
  private static final String JSONKEY_BUPARAM = "\"bu\":";
  private static final String JSONKEY_LT = "\"lt\":";
  private static final String JSONKEY_TM = "\"tm\":";
  private static final int K_TIMEOUT_STATISTICS = 4000;
  private static final String TAG = "~~Statistic";
  private static BNStatisticsManager mInstance;
  private static IBNStatisticsListener mStatisticsListener = null;
  private HashMap<Integer, Long> mEventStartMap = new HashMap();
  private Handler mHandler = new Handler(CommandCenter.getInstance().getLooper());
  private int mLastMapScale;
  @Deprecated
  private Runnable mStatMapScaleTask = new BNStatisticsManager.1(this);
  JNIStatisticsControl mStatisticsControl = JNIStatisticsControl.sInstance;
  
  public static BNStatisticsManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNStatisticsManager();
    }
    return mInstance;
  }
  
  private String getParam(ArrayList<NameValuePair> paramArrayList)
  {
    if (paramArrayList == null) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(new ArrayList(paramArrayList));
      int i = 0;
      while (i < localArrayList.size())
      {
        paramArrayList = "";
        if (((NameValuePair)localArrayList.get(i)).getValue() != null) {
          paramArrayList = ((NameValuePair)localArrayList.get(i)).getValue().trim();
        }
        ((StringBuffer)localObject).append("\"" + ((NameValuePair)localArrayList.get(i)).getName() + "\":\"" + paramArrayList + "\"");
        if (i < localArrayList.size() - 1) {
          ((StringBuffer)localObject).append(",");
        }
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<NameValuePair>)localObject;
    } while (!((String)localObject).endsWith(","));
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  @Deprecated
  private void onGestureEvent(String paramString1, String paramString2) {}
  
  public void exit()
  {
    if (BNaviEngineManager.getInstance().isEngineInitSucc())
    {
      BNEngineStatistics.destory();
      this.mStatisticsControl.exit();
    }
  }
  
  public void init()
  {
    BNEngineStatistics.getInstance().init();
    this.mStatisticsControl.init();
  }
  
  public void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    if ((mStatisticsListener != null) && (paramContext != null)) {
      mStatisticsListener.onEvent(paramContext, paramString1, paramString2);
    }
  }
  
  public void onEvent(String paramString1, String paramString2)
  {
    if (mStatisticsListener != null) {
      mStatisticsListener.onEvent(paramString1, paramString2);
    }
  }
  
  public void onEventDuration(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new ArrayList();
    paramContext.add(new BasicNameValuePair("duration", paramInt2 + ""));
    ReqData localReqData = new ReqData("cmd.statistics.record", 4, this.mHandler, 1101, 4000);
    CmdStatisticsRecord.packetParams(localReqData, paramInt1, null, paramContext, null);
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public void onEventDuration(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((mStatisticsListener != null) && (paramContext != null)) {
      mStatisticsListener.onEventDuration(paramContext, paramString1, paramString2, paramInt);
    }
  }
  
  public void onEventDuration(String paramString1, String paramString2, int paramInt)
  {
    if (mStatisticsListener != null) {
      mStatisticsListener.onEventDuration(paramString1, paramString2, paramInt);
    }
  }
  
  public void onEventEnd(Context paramContext, int paramInt)
  {
    Long localLong = (Long)this.mEventStartMap.remove(Integer.valueOf(paramInt));
    if (localLong == null) {
      return;
    }
    onEventDuration(paramContext, paramInt, (int)(SystemClock.elapsedRealtime() - localLong.longValue()));
  }
  
  public void onEventStart(Context paramContext, int paramInt)
  {
    this.mEventStartMap.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public void onEventWithParam(int paramInt, String paramString1, String paramString2)
  {
    LogUtil.e("~~Statistic", "event " + paramInt + ", param " + paramString1 + " : " + paramString2);
    paramString1 = new BasicNameValuePair(paramString1, paramString2);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString1);
    onEventWithParam(paramInt, paramString2, localArrayList, null);
  }
  
  public void onEventWithParam(int paramInt, String paramString, ArrayList<NameValuePair> paramArrayList)
  {
    onEventWithParam(paramInt, paramString, paramArrayList, null);
  }
  
  public void onEventWithParam(int paramInt, String paramString, ArrayList<NameValuePair> paramArrayList1, ArrayList<NameValuePair> paramArrayList2)
  {
    LogUtil.e("~~Statistic", "event " + paramInt + ", actParams {" + paramsToString(paramArrayList1) + " }, buParams {" + paramsToString(paramArrayList2) + "}");
    String str = paramString;
    if (paramString == null) {
      str = "1";
    }
    paramString = getParam(paramArrayList1);
    paramArrayList2 = getParam(paramArrayList2);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramArrayList1 = new StringBuilder().append("{\"lt\":").append(str).append(",").append("\"tm\":").append(i).append(",").append("\"act\":").append("\"").append(paramInt).append("\",").append("\"ActParam\":").append("{").append(paramString).append("}");
    if (!TextUtils.isEmpty(paramArrayList2)) {}
    for (paramString = ",\"bu\":{" + paramArrayList2 + "}";; paramString = "")
    {
      paramString = paramString + "}";
      CommonHandlerThread.getInstance().sendMessage(12, paramInt, i, paramString, 0L);
      return;
    }
  }
  
  public void onEventWithParam(int paramInt, String paramString, NameValuePair paramNameValuePair)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramNameValuePair);
    onEventWithParam(paramInt, paramString, localArrayList, null);
  }
  
  public void onEventWithValue(int paramInt, String paramString)
  {
    ReqData localReqData = new ReqData("cmd.statistics.record", 4, this.mHandler, 1101, 4000);
    CmdStatisticsRecord.packetParams(localReqData, paramInt, paramString, null, null);
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  @Deprecated
  public void onGestureEvent(String paramString)
  {
    onGestureEvent(paramString, "1");
  }
  
  @Deprecated
  public void onMapScaleSet(int paramInt)
  {
    this.mLastMapScale = paramInt;
  }
  
  public String paramsToString(List<NameValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)paramList.next();
        if (localNameValuePair != null) {
          localStringBuilder.append(localNameValuePair.getName()).append('=').append(localNameValuePair.getValue()).append(',');
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void saveStatistics()
  {
    NaviStatHelper.writeCacheToFile();
    NaviStatSessionHelper.writeCacheToFile();
  }
  
  public void setStatisticsListener(IBNStatisticsListener paramIBNStatisticsListener)
  {
    mStatisticsListener = paramIBNStatisticsListener;
  }
  
  public void upLoadStatistics()
  {
    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
      CommonHandlerThread.getInstance().sendMessage(13, -1, -1, null, 0L);
    }
    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
      CommonHandlerThread.getInstance().sendMessage(14, -1, -1, null, 0L);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/comapi/statistics/BNStatisticsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */