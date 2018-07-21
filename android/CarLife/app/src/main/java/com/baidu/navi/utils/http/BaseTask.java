package com.baidu.navi.utils.http;

import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

public abstract class BaseTask
{
  protected BaseHttpClient mHttpClient = new BaseHttpClient();
  protected ReqParams mReqParams = new ReqParams();
  protected JsonRspHandler mRspHandler;
  private TaskCallback mTaskCallback;
  protected Thread mThread;
  
  public BaseTask()
  {
    this.mReqParams.putSimpleValue(new BaseParamBean().toValuePair());
    this.mHttpClient.addGZIPSupport();
    this.mRspHandler = new JsonRspHandler()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if (BaseTask.this.mTaskCallback != null) {
          BaseTask.this.mTaskCallback.onFailure(paramAnonymousThrowable);
        }
      }
      
      public void onFinish()
      {
        if (BaseTask.this.mTaskCallback != null) {
          BaseTask.this.mTaskCallback.onFinish();
        }
      }
      
      public void onSuccess(Object paramAnonymousObject)
      {
        paramAnonymousObject = BaseTask.this.parseBaseTaskJsonReslut((JSONObject)paramAnonymousObject);
        if (paramAnonymousObject == null) {
          onFailure(new Throwable("get json result fail"));
        }
        do
        {
          return;
          if (((BaseTask.JSONResult)paramAnonymousObject).error != 0)
          {
            onFailure(new Throwable("the query result is error for the value of error is not equal 0"));
            return;
          }
          if (((BaseTask.JSONResult)paramAnonymousObject).data == null)
          {
            onFailure(new Throwable("can not get the data object"));
            return;
          }
          paramAnonymousObject = BaseTask.this.parseData(((BaseTask.JSONResult)paramAnonymousObject).data);
          if (paramAnonymousObject == null)
          {
            onFailure(new Throwable("parse json data fail"));
            return;
          }
        } while (BaseTask.this.mTaskCallback == null);
        BaseTask.this.mTaskCallback.onSuccess(paramAnonymousObject);
      }
    };
  }
  
  protected void addNamePair(String paramString1, String paramString2)
  {
    if (this.mReqParams != null) {
      this.mReqParams.putSimpleValue(paramString1, paramString2);
    }
  }
  
  public void execute()
  {
    this.mThread = new Thread(getClass().getSimpleName())
    {
      public void run()
      {
        if (NaviAccountUtils.getInstance().isLogin())
        {
          String str = NaviAccountUtils.getInstance().syncGetBduss();
          BaseTask.this.mReqParams.putSimpleValue("BDUSS", str);
        }
        for (;;)
        {
          BaseTask.this.mHttpClient.post(BaseTask.this.getServerUrl(), BaseTask.this.mReqParams, BaseTask.this.mRspHandler);
          return;
          LogUtil.e("BDUSS", "has not login");
        }
      }
    };
    this.mThread.start();
  }
  
  public JsonRspHandler getRspHandler()
  {
    return this.mRspHandler;
  }
  
  protected abstract String getServerUrl();
  
  protected abstract JSONResult parseBaseTaskJsonReslut(JSONObject paramJSONObject);
  
  protected abstract Object parseData(Object paramObject);
  
  public void setResponseCharset(String paramString)
  {
    this.mRspHandler.setCharset(paramString);
  }
  
  public void setTaskCallBack(TaskCallback paramTaskCallback)
  {
    this.mTaskCallback = paramTaskCallback;
  }
  
  public void stop()
  {
    if (this.mRspHandler != null) {
      this.mRspHandler.stop();
    }
    if (this.mThread != null) {
      this.mThread.interrupt();
    }
  }
  
  public class JSONResult
  {
    public Object data;
    public int error;
    
    public JSONResult() {}
  }
  
  public static abstract interface TaskCallback<T>
  {
    public abstract void onFailure(Throwable paramThrowable);
    
    public abstract void onFinish();
    
    public abstract void onSuccess(T paramT);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/BaseTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */