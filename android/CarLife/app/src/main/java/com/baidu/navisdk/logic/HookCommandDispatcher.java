package com.baidu.navisdk.logic;

import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

public class HookCommandDispatcher
{
  private HashMap<String, Class<? extends CommandBase>> mReqHandlerMap = new HashMap();
  
  public HookCommandDispatcher(Class<?> paramClass)
  {
    init(paramClass);
  }
  
  private CommandBase getHandlerByReqKey(String paramString)
  {
    paramString = (Class)this.mReqHandlerMap.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (CommandBase)paramString.newInstance();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private void init(Class<?> paramClass)
  {
    loadFields(paramClass);
  }
  
  private void loadFields(Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredFields();
    if (paramClass == null) {}
    for (;;)
    {
      return;
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramClass[i];
        try
        {
          Object localObject1 = ((Field)localObject2).get(null);
          if (!(localObject1 instanceof String)) {
            break label173;
          }
          localObject1 = (String)localObject1;
          localObject2 = (CommandDeclare)((Field)localObject2).getAnnotation(CommandDeclare.class);
          LogUtil.e("xxxxxx", localObject2.toString() + ((CommandDeclare)localObject2).annotationType().toString());
          if ((localObject1 == null) || (localObject2 == null)) {
            break label173;
          }
          localObject2 = ((CommandDeclare)localObject2).value();
          if (localObject2 == null) {
            LogUtil.e("", "Command mapping definition in CommandConstant is error:" + (String)localObject1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.mReqHandlerMap.put(localException, localObject2);
        label173:
        i += 1;
      }
    }
  }
  
  public CommandBase getCommandParser(String paramString)
  {
    return getHandlerByReqKey(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/HookCommandDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */