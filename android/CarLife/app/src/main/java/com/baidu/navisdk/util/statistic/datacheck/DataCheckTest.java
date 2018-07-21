package com.baidu.navisdk.util.statistic.datacheck;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

public class DataCheckTest
{
  public static void test()
  {
    if (!LogUtil.LOGGABLE) {
      return;
    }
    test12345();
  }
  
  private static void test12345()
  {
    Test12345 localTest12345 = new Test12345(1, 99, 0, 1000L, 65136, "3/1");
    DataCheckCenter.getInstance().check(localTest12345);
    localTest12345 = new Test12345(9, 100, 4, 70001L, 6, "8");
    DataCheckCenter.getInstance().check(localTest12345);
  }
  
  private static void test50001()
  {
    Data50001 localData50001 = new Data50001(1, 0, 1000L);
    DataCheckCenter.getInstance().check(localData50001);
    localData50001 = new Data50001(5, 1, 8000L);
    DataCheckCenter.getInstance().check(localData50001);
  }
  
  public static class Data50001
    implements StatisitcsDataCheck
  {
    private long rTime = -1L;
    private int seaRet = -1;
    private int seaType = -1;
    
    public Data50001(int paramInt1, int paramInt2, long paramLong)
    {
      this.seaType = paramInt1;
      this.seaRet = paramInt2;
      this.rTime = paramLong;
    }
    
    public Bundle getDataBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("sea_type", this.seaType);
      localBundle.putInt("sea_ret", this.seaRet);
      localBundle.putLong("re_time", this.rTime);
      return localBundle;
    }
    
    public String getID()
    {
      return "50001";
    }
  }
  
  public static class Test12345
    implements StatisitcsDataCheck
  {
    private long mArea = -1L;
    private int mF = -1;
    private int mR1 = -1;
    private String mR2 = null;
    private int mV = -1;
    private int vArr = -1;
    
    public Test12345(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString)
    {
      this.mF = paramInt1;
      this.mV = paramInt2;
      this.vArr = paramInt3;
      this.mArea = paramLong;
      this.mR1 = paramInt4;
      this.mR2 = paramString;
    }
    
    public Bundle getDataBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("testattr_f", this.mF);
      localBundle.putInt("testattr_v", this.mV);
      localBundle.putInt("testattr_arr", this.vArr);
      localBundle.putLong("testattr_area", this.mArea);
      localBundle.putInt("testattr_r1", this.mR1);
      localBundle.putString("testattr_r2", this.mR2);
      return localBundle;
    }
    
    public String getID()
    {
      return "12345";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/DataCheckTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */