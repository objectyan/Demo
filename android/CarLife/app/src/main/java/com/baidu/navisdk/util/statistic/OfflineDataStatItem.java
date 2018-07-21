package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class OfflineDataStatItem
{
  private static final int SIZE_M = 1048576;
  private static final String TAG = OfflineDataStatItem.class.getSimpleName();
  private static OfflineDataStatItem instance = null;
  private StringBuilder mDownloadedProvinces;
  private ArrayList<NameValuePair> mStatPairList = new ArrayList();
  private long mTotalDownloadedSize = 0L;
  
  public static OfflineDataStatItem getInstance()
  {
    if (instance == null) {
      instance = new OfflineDataStatItem();
    }
    return instance;
  }
  
  private void init()
  {
    this.mDownloadedProvinces = new StringBuilder();
    Object localObject = BNOfflineDataManager.getInstance().getDownloadedList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        OfflineDataInfo localOfflineDataInfo = (OfflineDataInfo)((Iterator)localObject).next();
        if (localOfflineDataInfo != null)
        {
          this.mTotalDownloadedSize += localOfflineDataInfo.mDownloadSize;
          this.mDownloadedProvinces.append(localOfflineDataInfo.mName).append(",");
        }
      }
    }
    if (this.mDownloadedProvinces.length() > 0) {
      this.mDownloadedProvinces.deleteCharAt(this.mDownloadedProvinces.length() - 1);
    }
  }
  
  public void onEvent()
  {
    init();
    this.mStatPairList.add(new BasicNameValuePair("down_m", Long.toString(this.mTotalDownloadedSize / 1048576L)));
    long l = SDCardUtils.getSdcardSpace() / 1048576L;
    this.mStatPairList.add(new BasicNameValuePair("left_m", Long.toString(l)));
    String str3 = "";
    String str1 = str3;
    if (this.mDownloadedProvinces != null) {}
    try
    {
      str1 = URLEncoder.encode(this.mDownloadedProvinces.toString(), "UTF-8");
      this.mStatPairList.add(new BasicNameValuePair("down_city", str1));
      BNStatisticsManager.getInstance().onEventWithParam(50007, null, this.mStatPairList);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = str3;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/OfflineDataStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */