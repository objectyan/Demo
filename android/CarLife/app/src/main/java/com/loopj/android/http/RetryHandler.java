package com.loopj.android.http;

import android.os.SystemClock;
import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.k;
import cz.msebera.android.httpclient.n.g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

class RetryHandler
  implements k
{
  private static final HashSet<Class<?>> exceptionBlacklist;
  private static final HashSet<Class<?>> exceptionWhitelist = new HashSet();
  private final int maxRetries;
  private final int retrySleepTimeMS;
  
  static
  {
    exceptionBlacklist = new HashSet();
    exceptionWhitelist.add(ah.class);
    exceptionWhitelist.add(UnknownHostException.class);
    exceptionWhitelist.add(SocketException.class);
    exceptionBlacklist.add(InterruptedIOException.class);
    exceptionBlacklist.add(SSLException.class);
  }
  
  public RetryHandler(int paramInt1, int paramInt2)
  {
    this.maxRetries = paramInt1;
    this.retrySleepTimeMS = paramInt2;
  }
  
  static void addClassToBlacklist(Class<?> paramClass)
  {
    exceptionBlacklist.add(paramClass);
  }
  
  static void addClassToWhitelist(Class<?> paramClass)
  {
    exceptionWhitelist.add(paramClass);
  }
  
  protected boolean isInList(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext()) {
      if (((Class)paramHashSet.next()).isInstance(paramThrowable)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, g paramg)
  {
    boolean bool = true;
    Boolean localBoolean = (Boolean)paramg.a("http.request_sent");
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if (paramInt <= this.maxRetries) {
        break label70;
      }
      bool = false;
    }
    for (;;)
    {
      if ((!bool) || ((q)paramg.a("http.request") != null)) {
        break label115;
      }
      return false;
      i = 0;
      break;
      label70:
      if (isInList(exceptionWhitelist, paramIOException)) {
        bool = true;
      } else if (isInList(exceptionBlacklist, paramIOException)) {
        bool = false;
      } else if (i == 0) {
        bool = true;
      }
    }
    label115:
    if (bool) {
      SystemClock.sleep(this.retrySleepTimeMS);
    }
    for (;;)
    {
      return bool;
      paramIOException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/RetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */