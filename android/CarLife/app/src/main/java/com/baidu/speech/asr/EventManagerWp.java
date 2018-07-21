package com.baidu.speech.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class EventManagerWp
  implements EventManager
{
  private static final String TAG = "EventManagerWp";
  private static final String version = "1.1.0.20161226";
  private Exception initException = null;
  private ArrayList<EventListener> listeners = new ArrayList();
  private Context mContext;
  private WakeUpControl mEnginer;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public EventManagerWp(Context paramContext)
  {
    this.mContext = paramContext;
    try
    {
      this.mEnginer = new WakeUpControl(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      this.initException = paramContext;
    }
  }
  
  public static final String getSDKVersion()
  {
    return "1.1.0.20161226";
  }
  
  public void registerListener(EventListener paramEventListener)
  {
    if ((paramEventListener != null) && (!this.listeners.contains(paramEventListener))) {
      this.listeners.add(paramEventListener);
    }
  }
  
  public void send(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    LogUtil.i("EventManagerWp", new String[] { "send cmd : " + paramString1 });
    LogUtil.i("EventManagerWp", new String[] { "send params : " + paramString2 });
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if (("wp.start".equals(paramString1)) && (this.initException != null))
      {
        paramArrayOfByte = this.listeners.iterator();
        while (paramArrayOfByte.hasNext())
        {
          final EventListener localEventListener = (EventListener)paramArrayOfByte.next();
          this.mHandler.post(new Runnable()
          {
            public void run()
            {
              if (localEventListener != null)
              {
                LogUtil.i("EventManagerWp", new String[] { "onEvent mCommand : wp.error and wp.exit  onEvent mParam : " + EventManagerWp.this.initException.getMessage() });
                localEventListener.onEvent("wp.error", EventManagerWp.this.initException.getMessage(), null, 0, 0);
                localEventListener.onEvent("wp.exit", EventManagerWp.this.initException.getMessage(), null, 0, 0);
              }
            }
          });
        }
      }
    } while ((this.mEnginer == null) || (paramString1 == null));
    this.mEnginer.setListener(new EventListener()
    {
      public void onEvent(final String paramAnonymousString1, final String paramAnonymousString2, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        synchronized (EventManagerWp.this.listeners)
        {
          Iterator localIterator = EventManagerWp.this.listeners.iterator();
          if (localIterator.hasNext())
          {
            final EventListener localEventListener = (EventListener)localIterator.next();
            EventManagerWp.this.mHandler.post(new Runnable()
            {
              public void run()
              {
                if (localEventListener != null)
                {
                  LogUtil.i("EventManagerWp", new String[] { "onEvent mCommand : " + paramAnonymousString1 });
                  LogUtil.i("EventManagerWp", new String[] { "onEvent mParam : " + paramAnonymousString2 });
                  localEventListener.onEvent(paramAnonymousString1, paramAnonymousString2, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
                }
              }
            });
          }
        }
      }
    });
    this.mEnginer.postEvent(paramString1, paramString2);
  }
  
  public void unregisterListener(EventListener paramEventListener)
  {
    this.listeners.remove(paramEventListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/EventManagerWp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */