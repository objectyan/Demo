package com.tencent.mm.sdk.b;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;

public final class g
  implements Runnable
{
  private static final String bf;
  private static final String bg;
  final Runnable aQ;
  final String aR;
  final Object aS;
  final Thread aT;
  String aU;
  long aV;
  final a aW;
  long aX;
  long aY;
  long aZ;
  long ba;
  long bb;
  long bc;
  long bd;
  float be = -1.0F;
  final Handler handler;
  int priority;
  boolean started = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append("|token = %s");
    localStringBuilder.append("|handler = %s");
    localStringBuilder.append("|threadName = %s");
    localStringBuilder.append("|threadId = %d");
    localStringBuilder.append("|priority = %d");
    localStringBuilder.append("|addTime = %d");
    localStringBuilder.append("|delayTime = %d");
    localStringBuilder.append("|usedTime = %d");
    localStringBuilder.append("|cpuTime = %d");
    localStringBuilder.append("|started = %b");
    bf = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    bg = localStringBuilder.toString();
  }
  
  g(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, a parama)
  {
    this.aT = paramThread;
    if (paramThread != null)
    {
      this.aU = paramThread.getName();
      this.aV = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.aQ = paramRunnable;
    paramHandler = paramRunnable.getClass().getName();
    paramRunnable = paramRunnable.toString();
    paramThread = paramHandler;
    if (!h.h(paramRunnable))
    {
      int i = paramRunnable.indexOf('|');
      paramThread = paramHandler;
      if (i > 0) {
        paramThread = paramHandler + "_" + paramRunnable.substring(i + 1);
      }
    }
    this.aR = paramThread;
    this.aS = paramObject;
    this.aW = parama;
    this.aX = System.currentTimeMillis();
  }
  
  public final void run()
  {
    int i = Process.myTid();
    new StringBuilder("/proc/self/task/").append(i).append("/stat");
    this.ba = System.currentTimeMillis();
    this.bb = Debug.threadCpuTimeNanos();
    this.bc = -1L;
    this.bd = -1L;
    this.started = true;
    this.aQ.run();
    this.bc = (-1L - this.bc);
    this.bd = (-1L - this.bd);
    this.aZ = System.currentTimeMillis();
    this.ba = (this.aZ - this.ba);
    this.bb = ((Debug.threadCpuTimeNanos() - this.bb) / 1000000L);
    if (this.bd != 0L) {
      this.be = ((float)(100L * this.bc) / (float)this.bd);
    }
    if (this.aW != null) {
      this.aW.c(this.aQ, this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(Runnable paramRunnable, g paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */