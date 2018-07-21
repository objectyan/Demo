package com.baidu.tts.d.a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.n;
import com.baidu.tts.loopj.RangeFileAsyncHttpResponseHandler;
import java.io.File;
import org.apache.http.Header;

public class g
  extends RangeFileAsyncHttpResponseHandler
{
  private c a;
  
  public g(File paramFile, c paramc)
  {
    super(paramFile);
    this.a = paramc;
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, File paramFile)
  {
    paramArrayOfHeader = null;
    if (paramThrowable != null)
    {
      paramArrayOfHeader = paramThrowable.getCause();
      if (paramArrayOfHeader != null) {
        break label76;
      }
    }
    label76:
    for (paramArrayOfHeader = paramThrowable.getMessage();; paramArrayOfHeader = paramArrayOfHeader.getMessage())
    {
      LoggerProxy.d("ModelFileResponseHandler", "onFailure statuscode=" + paramInt + "--msg=" + paramArrayOfHeader);
      paramArrayOfHeader = com.baidu.tts.h.a.c.a().a(n.ac, paramInt, "download failure", paramThrowable);
      this.a.a(paramArrayOfHeader);
      return;
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    this.a.a(paramLong1, paramLong2);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, File paramFile)
  {
    LoggerProxy.d("ModelFileResponseHandler", "onSuccess");
    this.a.e();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */