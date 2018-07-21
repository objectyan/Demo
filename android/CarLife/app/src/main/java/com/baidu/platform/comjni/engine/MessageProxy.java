package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageProxy
{
  private static final SparseArray<List<MainLooperHandler>> a = new SparseArray();
  
  public static void destroy()
  {
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      List localList = (List)a.get(a.keyAt(i));
      if (localList != null) {
        localList.clear();
      }
      i += 1;
    }
    a.clear();
  }
  
  public static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    synchronized (a)
    {
      Object localObject1 = (List)a.get(paramInt1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          Message.obtain((Handler)((Iterator)localObject1).next(), paramInt1, paramInt2, paramInt3, Integer.valueOf(paramInt4)).sendToTarget();
        }
      }
    }
  }
  
  public static void registerMessageHandler(int paramInt, MainLooperHandler paramMainLooperHandler)
  {
    if (paramMainLooperHandler == null) {
      return;
    }
    for (;;)
    {
      synchronized (a)
      {
        localObject = (List)a.get(paramInt);
        if (localObject != null)
        {
          if (!((List)localObject).contains(paramMainLooperHandler)) {
            ((List)localObject).add(paramMainLooperHandler);
          }
          return;
        }
      }
      Object localObject = new ArrayList();
      ((List)localObject).add(paramMainLooperHandler);
      a.put(paramInt, localObject);
    }
  }
  
  public static void unRegisterMessageHandler(int paramInt, MainLooperHandler paramMainLooperHandler)
  {
    if (paramMainLooperHandler != null)
    {
      paramMainLooperHandler.removeCallbacksAndMessages(null);
      synchronized (a)
      {
        List localList = (List)a.get(paramInt);
        if (localList != null) {
          localList.remove(paramMainLooperHandler);
        }
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/engine/MessageProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */