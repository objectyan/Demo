package com.baidu.navisdk.vi;

import android.os.Message;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class VMsg
{
  public static final int VM_USER_ID = 4096;
  private static final List<MsgHandler> outboxHandlers = new ArrayList();
  
  public static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 4096) {}
    for (;;)
    {
      return;
      if ((outboxHandlers != null) && (!outboxHandlers.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(outboxHandlers);
        int i = 0;
        while (i < localArrayList.size())
        {
          MsgHandler localMsgHandler = (MsgHandler)localArrayList.get(i);
          if ((localMsgHandler != null) && (localMsgHandler.isObserved(paramInt1))) {
            Message.obtain(localMsgHandler, paramInt1, paramInt2, paramInt3, null).sendToTarget();
          }
          i += 1;
        }
      }
    }
  }
  
  public static void dumpList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(outboxHandlers);
    LogUtil.e("VMsg", "dumpList()  handlers count=" + localArrayList.size());
    int i = 0;
    while (i < localArrayList.size())
    {
      LogUtil.e("VMsg", i + "handler.class=" + ((MsgHandler)localArrayList.get(i)).getClass() + ", name=" + ((MsgHandler)localArrayList.get(i)).getClass().getSimpleName());
      i += 1;
    }
  }
  
  private static void postMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    VMsgDispatcher.dispatchMessage(paramInt1, paramInt2, paramInt3);
  }
  
  public static void registerMessageHandler(MsgHandler paramMsgHandler)
  {
    if ((paramMsgHandler == null) || (outboxHandlers.contains(paramMsgHandler))) {
      return;
    }
    outboxHandlers.add(paramMsgHandler);
  }
  
  public static void unRegisterMessageHandler(MsgHandler paramMsgHandler)
  {
    if ((paramMsgHandler == null) || (!outboxHandlers.contains(paramMsgHandler))) {
      return;
    }
    outboxHandlers.remove(paramMsgHandler);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/vi/VMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */