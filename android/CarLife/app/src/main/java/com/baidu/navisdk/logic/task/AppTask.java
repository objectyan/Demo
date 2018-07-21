package com.baidu.navisdk.logic.task;

import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandCenter.CommandCenterListener;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HookCommandDispatcher;
import com.baidu.navisdk.logic.ReqData;
import java.util.concurrent.Callable;

public class AppTask
{
  public static CommandResult doTask(ReqData paramReqData, String paramString, HookCommandDispatcher paramHookCommandDispatcher)
    throws Exception
  {
    CommandResult localCommandResult = new CommandResult();
    paramString = paramHookCommandDispatcher.getCommandParser(paramString);
    if (paramString != null)
    {
      paramReqData = paramString.execute(paramReqData);
      if (paramReqData.isSuccess()) {
        return paramReqData;
      }
    }
    else
    {
      localCommandResult.set(55537);
      return localCommandResult;
    }
    return paramReqData;
  }
  
  public static Callable<CommandResult> newTask(ReqData paramReqData, final HookCommandDispatcher paramHookCommandDispatcher)
  {
    new Callable()
    {
      public CommandResult call()
        throws Exception
      {
        CommandResult localCommandResult = AppTask.doTask(this.val$reqdata, this.val$reqdata.mCmd, paramHookCommandDispatcher);
        this.val$reqdata.mRequestListener.onRequestFinish(this.val$reqdata, localCommandResult);
        return localCommandResult;
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/task/AppTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */