package com.baidu.navi.utils.http;

import com.baidu.navisdk.util.common.LogUtil;
import org.apache.http.HttpResponse;

public class BaseRspHandler
{
  protected static final int FAILURE_MESSAGE = 1;
  protected static final int FINISH_MESSAGE = 3;
  protected static final int PROGRESS_MESSAGE = 0;
  protected static final int START_MESSAGE = 2;
  protected static final int SUCCESS_MESSAGE = 4;
  protected static final String TAG = "plugin";
  private boolean isStop = false;
  
  protected void handleFailureMessage(Throwable paramThrowable)
  {
    if (isStop()) {
      return;
    }
    Throwable localThrowable;
    if (paramThrowable != null)
    {
      localThrowable = paramThrowable;
      if (paramThrowable.getMessage() != null) {}
    }
    else
    {
      localThrowable = new Throwable("unknow error");
    }
    LogUtil.e("plugin", getClass().getName() + ":onFailure");
    onFailure(localThrowable);
  }
  
  protected void handleFinishMessage(Object paramObject)
  {
    LogUtil.e("plugin", getClass().getName() + ":onFinish");
    onFinish();
  }
  
  protected void handleProgressMessage(long paramLong1, long paramLong2, long paramLong3)
  {
    if (isStop()) {
      return;
    }
    LogUtil.e("plugin", getClass().getName() + ":onProgress");
    onProgress(new Long[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  protected void handleResponse(HttpResponse paramHttpResponse) {}
  
  protected void handleStartMessage(Object paramObject)
  {
    if (isStop()) {
      return;
    }
    LogUtil.e("plugin", getClass().getName() + ":onStart");
    onStart();
  }
  
  protected void handleSuccessMessage(Object paramObject)
  {
    if (isStop()) {
      return;
    }
    LogUtil.e("plugin", getClass().getName() + ":onSuccess");
    onSuccess(paramObject);
  }
  
  public boolean isStop()
  {
    return this.isStop;
  }
  
  public void onFailure(Throwable paramThrowable) {}
  
  public void onFinish() {}
  
  public void onProgress(Object paramObject) {}
  
  public void onStart() {}
  
  public void onSuccess(Object paramObject) {}
  
  public void stop()
  {
    LogUtil.e("plugin", getClass().getName() + ":stop");
    this.isStop = true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/BaseRspHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */