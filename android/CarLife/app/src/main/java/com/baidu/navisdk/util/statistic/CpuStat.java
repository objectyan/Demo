package com.baidu.navisdk.util.statistic;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CpuStat
{
  long mEndTime;
  long mEndValue;
  long mStartTime;
  long mStartValue;
  String mStatPath;
  
  private CpuStat()
  {
    int i = Process.myPid();
    this.mStatPath = ("/proc/" + i + "/stat");
  }
  
  public static CpuStat getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private long getStat(String paramString)
  {
    long l2 = 0L;
    long l3 = l2;
    l4 = l2;
    try
    {
      paramString = new RandomAccessFile(paramString, "r");
      l3 = l2;
      l4 = l2;
      Object localObject = new StringBuffer();
      l3 = l2;
      l4 = l2;
      ((StringBuffer)localObject).setLength(0);
      for (;;)
      {
        l3 = l2;
        l4 = l2;
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        l3 = l2;
        l4 = l2;
        ((StringBuffer)localObject).append(str + "\n");
      }
      long l1;
      return l4;
    }
    catch (FileNotFoundException paramString)
    {
      Log.e("", "FileNotFoundException: " + paramString.getMessage());
      paramString.printStackTrace();
      return l3;
      l3 = l2;
      l4 = l2;
      localObject = ((StringBuffer)localObject).toString().split(" ");
      l3 = l2;
      l1 = l2;
      l4 = l2;
      if (localObject.length > 0)
      {
        l3 = l2;
        l4 = l2;
        l1 = Long.parseLong(localObject[13]) + Long.parseLong(localObject[14]);
      }
      l3 = l1;
      l4 = l1;
      paramString.close();
      return l1;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void endProfile()
  {
    this.mEndTime = SystemClock.elapsedRealtime();
    LogUtil.e("CpuStat", "end jiffies=" + this.mEndValue);
    this.mEndValue = getStat(this.mStatPath);
  }
  
  public long getProfileVal()
  {
    long l = this.mEndTime - this.mStartTime;
    if (l <= 0L) {
      return 0L;
    }
    return (this.mEndValue - this.mStartValue) * 3600L * 1000L / l;
  }
  
  public void startProfile()
  {
    this.mStartTime = SystemClock.elapsedRealtime();
    this.mStartValue = getStat(this.mStatPath);
    LogUtil.e("CpuStat", "start jiffies=" + this.mStartValue);
  }
  
  private static class LazyHolder
  {
    private static CpuStat sInstance = new CpuStat(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/CpuStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */