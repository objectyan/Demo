package com.baidu.speech.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import java.util.ArrayList;
import java.util.Iterator;

public class EventManagerSlot
  implements EventManager
{
  private ArrayList<EventListener> listeners = new ArrayList();
  private Context mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private SlotControl mSlotControl;
  
  public EventManagerSlot(Context paramContext)
  {
    this.mContext = paramContext;
    try
    {
      this.mSlotControl = new SlotControl(this.mContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void registerListener(EventListener paramEventListener)
  {
    if (paramEventListener != null) {
      this.listeners.add(paramEventListener);
    }
  }
  
  public void send(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (this.mSlotControl == null) {
      return;
    }
    this.mSlotControl.setListener(new EventListener()
    {
      public void onEvent(final String paramAnonymousString1, final String paramAnonymousString2, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        synchronized (EventManagerSlot.this.listeners)
        {
          Iterator localIterator = EventManagerSlot.this.listeners.iterator();
          if (localIterator.hasNext())
          {
            final EventListener localEventListener = (EventListener)localIterator.next();
            EventManagerSlot.this.mHandler.post(new Runnable()
            {
              public void run()
              {
                if (localEventListener != null) {
                  localEventListener.onEvent(paramAnonymousString1, paramAnonymousString2, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
                }
              }
            });
          }
        }
      }
    });
    this.mSlotControl.postEvent(paramString1, paramString2);
  }
  
  public void unregisterListener(EventListener paramEventListener)
  {
    this.listeners.remove(paramEventListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/EventManagerSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */