package com.baidu.navisdk.logic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CommandCenter
{
  private static final String TAG = "CommandCenter";
  private HookCommandDispatcher mAppDispatcher;
  private CommandCenterListener mListener = new CommandCenterListener()
  {
    public void onRequestFinish(ReqData paramAnonymousReqData, CommandResult paramAnonymousCommandResult)
    {
      if (paramAnonymousCommandResult.isSuccess()) {
        if ((paramAnonymousReqData != null) && (!paramAnonymousReqData.mHasMsgSent) && (paramAnonymousReqData.mHandler != null))
        {
          paramAnonymousCommandResult = paramAnonymousReqData.mHandler.obtainMessage(paramAnonymousReqData.mHandlerMsgWhat);
          paramAnonymousCommandResult.arg1 = 0;
          paramAnonymousCommandResult.obj = new RspData(paramAnonymousReqData, null);
          paramAnonymousCommandResult.sendToTarget();
        }
      }
      for (paramAnonymousReqData.mHasMsgSent = true;; paramAnonymousReqData.mHasMsgSent = true)
      {
        do
        {
          CommandCenter.this.mRequests.removeRequest(paramAnonymousReqData);
          return;
        } while ((paramAnonymousReqData == null) || (paramAnonymousReqData.mHasMsgSent) || (paramAnonymousReqData.mHandler == null));
        Message localMessage = paramAnonymousReqData.mHandler.obtainMessage(paramAnonymousReqData.mHandlerMsgWhat);
        localMessage.arg1 = paramAnonymousCommandResult.mErrCode;
        localMessage.obj = new RspData(paramAnonymousReqData, null);
        localMessage.sendToTarget();
      }
    }
  };
  private RequestQueue mRequests = new RequestQueue("msgqueue");
  
  public static CommandResult doTask(ReqData paramReqData, String paramString)
    throws Exception
  {
    CommandResult localCommandResult = new CommandResult();
    paramString = CommandDispatcher.getCommandParser(paramString);
    if (paramString != null) {
      return paramString.execute(paramReqData);
    }
    localCommandResult.set(55537);
    return localCommandResult;
  }
  
  public static CommandResult doTask(ReqData paramReqData, String paramString, HookCommandDispatcher paramHookCommandDispatcher)
    throws Exception
  {
    CommandResult localCommandResult = new CommandResult();
    paramString = paramHookCommandDispatcher.getCommandParser(paramString);
    if (paramString != null) {
      return paramString.execute(paramReqData);
    }
    localCommandResult.set(55537);
    return localCommandResult;
  }
  
  public static CommandCenter getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public static Callable<CommandResult> newTask(ReqData paramReqData)
  {
    new Callable()
    {
      public CommandResult call()
        throws Exception
      {
        CommandResult localCommandResult = CommandCenter.doTask(this.val$reqdata, this.val$reqdata.mCmd);
        this.val$reqdata.mRequestListener.onRequestFinish(this.val$reqdata, localCommandResult);
        return localCommandResult;
      }
    };
  }
  
  public static Callable<CommandResult> newTask(ReqData paramReqData, final HookCommandDispatcher paramHookCommandDispatcher)
  {
    new Callable()
    {
      public CommandResult call()
        throws Exception
      {
        CommandResult localCommandResult = CommandCenter.doTask(this.val$reqdata, this.val$reqdata.mCmd, paramHookCommandDispatcher);
        this.val$reqdata.mRequestListener.onRequestFinish(this.val$reqdata, localCommandResult);
        return localCommandResult;
      }
    };
  }
  
  public int cancelRequest(String paramString)
  {
    this.mRequests.cancelRequest(paramString);
    return 0;
  }
  
  public int cancelRequestBySubSystem(int paramInt)
  {
    this.mRequests.cancelRequestInSubSystem(paramInt);
    return 0;
  }
  
  public RspData getFromCache(ReqData paramReqData)
  {
    CommandBase localCommandBase = CommandDispatcher.getCommandParser(paramReqData.mCmd);
    if (localCommandBase == null) {
      return null;
    }
    return localCommandBase.getFromCache(paramReqData);
  }
  
  public Looper getLooper()
  {
    return this.mRequests.getLooper();
  }
  
  public int sendRequest(ReqData paramReqData)
  {
    paramReqData.mRequestListener = this.mListener;
    this.mRequests.addRequest(paramReqData);
    return 0;
  }
  
  public void setCommandDispatcher(HookCommandDispatcher paramHookCommandDispatcher)
  {
    this.mAppDispatcher = paramHookCommandDispatcher;
  }
  
  public static abstract interface CommandCenterListener
  {
    public abstract void onRequestFinish(ReqData paramReqData, CommandResult paramCommandResult);
  }
  
  private static class LazyHolder
  {
    private static final CommandCenter sInstance = new CommandCenter();
  }
  
  class RequestQueue
    extends HandlerThread
  {
    private Map<ReqData, Future<CommandResult>> mRequests = Collections.synchronizedMap(new HashMap());
    
    public RequestQueue(String paramString)
    {
      super();
      start();
    }
    
    private void cancelRequestInSubSystem(final int paramInt)
    {
      BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask(CommandCenter.class.getSimpleName() + "2", null)new BNWorkerConfig
      {
        protected String execute()
        {
          Iterator localIterator = CommandCenter.RequestQueue.this.mRequests.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (Map.Entry)localIterator.next();
            Object localObject4 = (Future)((Map.Entry)localObject1).getValue();
            localObject1 = (ReqData)((Map.Entry)localObject1).getKey();
            if (((ReqData)localObject1).mSubSystem == paramInt)
            {
              localIterator.remove();
              ((Future)localObject4).cancel(true);
              Object localObject3 = new CommandResult();
              try
              {
                localObject4 = (CommandResult)((Future)localObject4).get();
                if ((!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null))
                {
                  localObject3 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  ((Message)localObject3).arg1 = ((CommandResult)localObject4).mErrCode;
                  ((Message)localObject3).obj = new RspData((ReqData)localObject1, null);
                  ((Message)localObject3).sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                LogUtil.e(TAG, "task interrupted because cancel, reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(-3);
                if ((!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null))
                {
                  Message localMessage1 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage1.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage1.obj = new RspData((ReqData)localObject1, null);
                  localMessage1.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (ExecutionException localExecutionException)
              {
                LogUtil.e(TAG, "task ExecutionException,reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(55537, "Exception:reqdata=" + ((ReqData)localObject1).toString());
                if ((!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null))
                {
                  Message localMessage2 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage2.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage2.obj = new RspData((ReqData)localObject1, null);
                  localMessage2.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (CancellationException localCancellationException)
              {
                LogUtil.e(TAG, "task cancelled because cancel, reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(-3);
                if ((!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null))
                {
                  Message localMessage3 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage3.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage3.obj = new RspData((ReqData)localObject1, null);
                  localMessage3.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (Exception localException)
              {
                LogUtil.e(TAG, "task Exception,reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(55537, "Exception:" + localException.toString());
                if ((!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null))
                {
                  localMessage4 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage4.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage4.obj = new RspData((ReqData)localObject1, null);
                  localMessage4.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              finally
              {
                Message localMessage4;
                if ((!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null))
                {
                  localMessage4 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage4.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage4.obj = new RspData((ReqData)localObject1, null);
                  localMessage4.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
            }
          }
          return null;
        }
      }, new BNWorkerConfig(100, 0));
    }
    
    public void addRequest(final ReqData paramReqData)
    {
      LogUtil.e("CommandCenter", "task added to request queue,reqdata=" + paramReqData.toString());
      if ((paramReqData.mSubSystem != 5) && (paramReqData.mSubSystem != 4) && (paramReqData.mSubSystem != 7)) {
        cancelRequestInSubSystem(paramReqData.mSubSystem);
      }
      BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask(CommandCenter.class.getSimpleName() + "2", null)new BNWorkerConfig
      {
        protected String execute()
        {
          Object localObject;
          if (CommandCenter.this.mAppDispatcher != null) {
            localObject = CommandCenter.newTask(paramReqData, CommandCenter.this.mAppDispatcher);
          }
          for (;;)
          {
            if (localObject != null) {}
            try
            {
              localObject = BNWorkerCenter.getInstance().submitTask(new BNWorkerNormalTask(CommandCenter.class.getSimpleName(), (Callable)localObject)new BNWorkerConfig
              {
                protected CommandResult execute()
                {
                  try
                  {
                    CommandResult localCommandResult = (CommandResult)((Callable)this.inData).call();
                    return localCommandResult;
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                  }
                  return null;
                }
              }, new BNWorkerConfig(100, 0));
              CommandCenter.RequestQueue.this.mRequests.put(paramReqData, localObject);
              return null;
              localObject = CommandCenter.newTask(paramReqData);
            }
            catch (Throwable localThrowable)
            {
              for (;;) {}
            }
          }
        }
      }, new BNWorkerConfig(100, 0));
      BNWorkerCenter.getInstance().submitQueneTaskDelay(new BNWorkerNormalTask(CommandCenter.class.getSimpleName() + "3", null)new BNWorkerConfig
      {
        protected String execute()
        {
          Object localObject2 = (Future)CommandCenter.RequestQueue.this.mRequests.remove(paramReqData);
          if (localObject2 == null) {}
          for (;;)
          {
            return null;
            ((Future)localObject2).cancel(true);
            Object localObject1 = new CommandResult();
            try
            {
              localObject2 = (CommandResult)((Future)localObject2).get();
              if ((paramReqData == null) || (paramReqData.mHasMsgSent) || (paramReqData.mHandler == null)) {
                continue;
              }
              localObject1 = paramReqData.mHandler.obtainMessage(paramReqData.mHandlerMsgWhat);
              ((Message)localObject1).arg1 = ((CommandResult)localObject2).mErrCode;
              ((Message)localObject1).obj = new RspData(paramReqData, null);
              ((Message)localObject1).sendToTarget();
              paramReqData.mHasMsgSent = true;
              return null;
            }
            catch (InterruptedException localInterruptedException)
            {
              LogUtil.e(TAG, "task interrupted because timeout, reqdata=" + paramReqData.toString());
              ((CommandResult)localObject1).setSDKError(2);
              if (LogUtil.LOGGABLE) {
                localInterruptedException.printStackTrace();
              }
              Message localMessage1;
              return null;
            }
            catch (ExecutionException localExecutionException)
            {
              LogUtil.e(TAG, "task ExecutionException, reqdata=" + paramReqData.toString());
              ((CommandResult)localObject1).set(55537, "Exception:reqdata=" + paramReqData.toString());
              if (LogUtil.LOGGABLE) {
                localExecutionException.printStackTrace();
              }
              Message localMessage2;
              return null;
            }
            catch (CancellationException localCancellationException)
            {
              LogUtil.e(TAG, "task cancelled because timeout,reqdata=" + paramReqData.toString());
              ((CommandResult)localObject1).setSDKError(2);
              if (LogUtil.LOGGABLE) {
                localCancellationException.printStackTrace();
              }
              Message localMessage3;
              return null;
            }
            catch (Exception localException)
            {
              LogUtil.e(TAG, "task Exception, reqdata=" + paramReqData.toString());
              ((CommandResult)localObject1).set(55537, "Exception:reqdata=" + paramReqData.toString());
              if (LogUtil.LOGGABLE) {
                localException.printStackTrace();
              }
              Message localMessage4;
              return null;
            }
            finally
            {
              if ((paramReqData != null) && (!paramReqData.mHasMsgSent) && (paramReqData.mHandler != null))
              {
                Message localMessage5 = paramReqData.mHandler.obtainMessage(paramReqData.mHandlerMsgWhat);
                localMessage5.arg1 = ((CommandResult)localObject1).mErrCode;
                localMessage5.obj = new RspData(paramReqData, null);
                localMessage5.sendToTarget();
                paramReqData.mHasMsgSent = true;
              }
            }
          }
        }
      }, new BNWorkerConfig(100, 0), paramReqData.mTimeout);
    }
    
    public void cancelRequest(final String paramString)
    {
      BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask(CommandCenter.class.getSimpleName() + "2", null)new BNWorkerConfig
      {
        protected String execute()
        {
          Iterator localIterator = CommandCenter.RequestQueue.this.mRequests.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (Map.Entry)localIterator.next();
            Object localObject4 = (Future)((Map.Entry)localObject1).getValue();
            localObject1 = (ReqData)((Map.Entry)localObject1).getKey();
            if ((((ReqData)localObject1).mTag != null) && (paramString != null) && (((ReqData)localObject1).mTag.contains(paramString)))
            {
              localIterator.remove();
              ((Future)localObject4).cancel(true);
              Object localObject3 = new CommandResult();
              try
              {
                localObject4 = (CommandResult)((Future)localObject4).get();
                if ((localObject1 != null) && (!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null) && (localObject1 != null) && (((ReqData)localObject1).mHandler != null))
                {
                  localObject3 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  ((Message)localObject3).arg1 = ((CommandResult)localObject4).mErrCode;
                  ((Message)localObject3).obj = new RspData((ReqData)localObject1, null);
                  ((Message)localObject3).sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                LogUtil.e(TAG, "task interrupted because cancel,reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(-3);
                if ((localObject1 != null) && (!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null) && (localObject1 != null) && (((ReqData)localObject1).mHandler != null))
                {
                  Message localMessage1 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage1.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage1.obj = new RspData((ReqData)localObject1, null);
                  localMessage1.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (ExecutionException localExecutionException)
              {
                LogUtil.e(TAG, "task ExecutionException,reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(55537, "Exception:reqdata=" + ((ReqData)localObject1).toString());
                if ((localObject1 != null) && (!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null) && (localObject1 != null) && (((ReqData)localObject1).mHandler != null))
                {
                  Message localMessage2 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage2.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage2.obj = new RspData((ReqData)localObject1, null);
                  localMessage2.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (CancellationException localCancellationException)
              {
                LogUtil.e(TAG, "task cancelled because cancel,reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(-3);
                if ((localObject1 != null) && (!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null) && (localObject1 != null) && (((ReqData)localObject1).mHandler != null))
                {
                  Message localMessage3 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage3.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage3.obj = new RspData((ReqData)localObject1, null);
                  localMessage3.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              catch (Exception localException)
              {
                LogUtil.e(TAG, "task exception,reqdata=" + ((ReqData)localObject1).toString());
                ((CommandResult)localObject3).set(55537, "Exception:" + localException.toString());
                if ((localObject1 != null) && (!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null) && (localObject1 != null) && (((ReqData)localObject1).mHandler != null))
                {
                  localMessage4 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage4.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage4.obj = new RspData((ReqData)localObject1, null);
                  localMessage4.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
              finally
              {
                Message localMessage4;
                if ((localObject1 != null) && (!((ReqData)localObject1).mHasMsgSent) && (((ReqData)localObject1).mHandler != null) && (localObject1 != null) && (((ReqData)localObject1).mHandler != null))
                {
                  localMessage4 = ((ReqData)localObject1).mHandler.obtainMessage(100000);
                  localMessage4.arg1 = ((CommandResult)localObject3).mErrCode;
                  localMessage4.obj = new RspData((ReqData)localObject1, null);
                  localMessage4.sendToTarget();
                  ((ReqData)localObject1).mHasMsgSent = true;
                }
              }
            }
          }
          return null;
        }
      }, new BNWorkerConfig(100, 0));
    }
    
    public void removeRequest(final ReqData paramReqData)
    {
      BNWorkerCenter.getInstance().submitQueneTask(new BNWorkerNormalTask(CommandCenter.class.getSimpleName() + "2", null)new BNWorkerConfig
      {
        protected String execute()
        {
          CommandCenter.RequestQueue.this.mRequests.remove(paramReqData);
          return null;
        }
      }, new BNWorkerConfig(100, 0));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/CommandCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */