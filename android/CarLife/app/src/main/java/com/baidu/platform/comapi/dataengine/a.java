package com.baidu.platform.comapi.dataengine;

import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class a
{
  private CopyOnWriteArrayList<MapDataEngineListener> a = new CopyOnWriteArrayList();
  
  public void a(Message paramMessage)
  {
    if (paramMessage.what != 65289) {}
    for (;;)
    {
      return;
      if ((this.a != null) && (this.a.size() != 0))
      {
        switch (paramMessage.arg1)
        {
        default: 
          return;
        }
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          ((MapDataEngineListener)localIterator.next()).onGetDataEngineRst(paramMessage.arg1, paramMessage.arg2);
        }
      }
    }
  }
  
  void a(MapDataEngineListener paramMapDataEngineListener)
  {
    if (paramMapDataEngineListener != null) {
      this.a.add(paramMapDataEngineListener);
    }
  }
  
  void b(MapDataEngineListener paramMapDataEngineListener)
  {
    this.a.remove(paramMapDataEngineListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/dataengine/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */