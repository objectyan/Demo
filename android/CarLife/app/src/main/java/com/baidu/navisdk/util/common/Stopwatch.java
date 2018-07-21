package com.baidu.navisdk.util.common;

import android.os.SystemClock;

public class Stopwatch
{
  private static long end;
  private static long start;
  private long mEnd;
  private long mStart = SystemClock.elapsedRealtime();
  
  public static long getDuration()
  {
    return (end - start) / 1000000L;
  }
  
  public static long getNanoSecDuration()
  {
    return end - start;
  }
  
  public static void reset()
  {
    start = 0L;
    end = 0L;
  }
  
  public static void setEnd()
  {
    end = System.nanoTime();
  }
  
  public static void setStart()
  {
    start = System.nanoTime();
  }
  
  public long ElapsedTicks()
  {
    return this.mEnd - this.mStart;
  }
  
  public void start()
  {
    this.mStart = SystemClock.elapsedRealtime();
    LogUtil.e("Stopwatch", "stat test start time = " + this.mStart);
  }
  
  public void stop()
  {
    this.mEnd = SystemClock.elapsedRealtime();
    LogUtil.e("Stopwatch", "stat test stop time = " + this.mEnd);
  }
  
  public String toString()
  {
    return SystemClock.elapsedRealtime() - this.mStart + " ms";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/Stopwatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */