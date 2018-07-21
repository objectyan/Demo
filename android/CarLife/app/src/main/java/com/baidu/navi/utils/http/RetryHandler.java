package com.baidu.navi.utils.http;

import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

class RetryHandler
  implements HttpRequestRetryHandler
{
  private static final int RETRY_SLEEP_TIME_MILLIS = 500;
  private int maxRetries;
  
  public RetryHandler(int paramInt)
  {
    this.maxRetries = paramInt;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool1 = true;
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if (paramInt <= this.maxRetries) {
        break label92;
      }
      bool1 = false;
      label43:
      bool2 = bool1;
      if (bool1) {
        if (((HttpRequest)paramHttpContext.getAttribute("http.request") instanceof HttpEntityEnclosingRequest)) {
          break label168;
        }
      }
    }
    label92:
    label168:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (!bool2) {
        break label174;
      }
      SystemClock.sleep(500L);
      return bool2;
      i = 0;
      break;
      if ((paramIOException instanceof InterruptedIOException))
      {
        bool1 = false;
        break label43;
      }
      if ((paramIOException instanceof SSLException))
      {
        bool1 = false;
        break label43;
      }
      if ((paramIOException instanceof NoHttpResponseException))
      {
        bool1 = true;
        break label43;
      }
      if ((paramIOException instanceof SocketException))
      {
        bool1 = true;
        break label43;
      }
      if ((paramIOException instanceof UnknownHostException))
      {
        bool1 = true;
        break label43;
      }
      if (i != 0) {
        break label43;
      }
      bool1 = true;
      break label43;
    }
    label174:
    if (paramIOException == null) {}
    for (paramIOException = "null poit of retry exception";; paramIOException = paramIOException.getMessage())
    {
      LogUtil.e("plugin", paramIOException);
      return bool2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/RetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */