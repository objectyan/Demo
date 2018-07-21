package com.baidu.speech.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.speech.EventManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class EventRecognitionService
  extends Service
{
  private static final String TAG = "EventRecognitionService";
  private int RESTART_TIME = 3600000;
  private boolean asrUsing = false;
  private IBinder iBinder = new EventManagerFactory.Stub()
  {
    public EventManager create(final String paramAnonymousString)
      throws RemoteException
    {
      paramAnonymousString = new EventManager.Stub()
      {
        com.baidu.speech.EventManager impl = EventManagerFactory.create(EventRecognitionService.this.getApplicationContext(), paramAnonymousString, false);
        public ArrayList<EventRecognitionService.EventListenerProxy> usingLis = new ArrayList();
        
        public void registerListener(EventListener paramAnonymous2EventListener)
          throws RemoteException
        {
          EventRecognitionService.EventListenerProxy localEventListenerProxy = new EventRecognitionService.EventListenerProxy(EventRecognitionService.this, paramAnonymous2EventListener);
          unregisterListener(paramAnonymous2EventListener);
          this.usingLis.add(localEventListenerProxy);
          this.impl.registerListener(localEventListenerProxy);
        }
        
        public void send(String paramAnonymous2String1, String paramAnonymous2String2, byte[] paramAnonymous2ArrayOfByte, int paramAnonymous2Int1, int paramAnonymous2Int2)
          throws RemoteException
        {
          if (("asr.start".equals(paramAnonymous2String1)) || ("asr.kws.load".equals(paramAnonymous2String1))) {
            EventRecognitionService.access$002(EventRecognitionService.this, true);
          }
          for (;;)
          {
            this.impl.send(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2ArrayOfByte, paramAnonymous2Int1, paramAnonymous2Int2);
            return;
            if ("wp.start".equals(paramAnonymous2String1)) {
              EventRecognitionService.access$102(EventRecognitionService.this, true);
            }
          }
        }
        
        public void unregisterListener(EventListener paramAnonymous2EventListener)
          throws RemoteException
        {
          paramAnonymous2EventListener = this.usingLis.iterator();
          while (paramAnonymous2EventListener.hasNext())
          {
            EventRecognitionService.EventListenerProxy localEventListenerProxy = (EventRecognitionService.EventListenerProxy)paramAnonymous2EventListener.next();
            this.impl.unregisterListener(localEventListenerProxy);
          }
          this.usingLis.clear();
        }
      };
      EventRecognitionService.access$202(EventRecognitionService.this, System.currentTimeMillis());
      return paramAnonymousString;
    }
  };
  private long startTime = 0L;
  private boolean wpUsing = false;
  
  public EventRecognitionService()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run() {}
    }, 5000L);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.iBinder;
  }
  
  class EventListenerProxy
    implements com.baidu.speech.EventListener
  {
    private EventListener listener;
    
    public EventListenerProxy(EventListener paramEventListener)
    {
      this.listener = paramEventListener;
    }
    
    public void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      label184:
      label190:
      label206:
      label223:
      for (;;)
      {
        boolean bool;
        Object localObject;
        try
        {
          long l1 = System.currentTimeMillis();
          long l2 = EventRecognitionService.this.startTime;
          if (paramArrayOfByte != null) {
            break label223;
          }
          paramArrayOfByte = new byte[0];
          if ("asr.exit".equals(paramString1))
          {
            EventRecognitionService.access$002(EventRecognitionService.this, false);
            if ((EventRecognitionService.this.asrUsing) || (EventRecognitionService.this.wpUsing)) {
              break label206;
            }
            int i = EventRecognitionService.this.RESTART_TIME;
            if (l1 - l2 <= i) {
              break label184;
            }
            bool = true;
            if (paramString2 != null) {
              break label190;
            }
            localObject = "{}";
          }
        }
        catch (RemoteException paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          ((JSONObject)localObject).put("_free", bool);
          localObject = ((JSONObject)localObject).toString();
          paramString2 = (String)localObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        this.listener.onEvent(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2);
        if (!bool) {
          break;
        }
        Log.d("EventRecognitionService", "wake up idle, exit!");
        System.exit(0);
        return;
        if ("wp.exit".equals(paramString1))
        {
          EventRecognitionService.access$102(EventRecognitionService.this, false);
          continue;
          bool = false;
          continue;
          localObject = paramString2;
          continue;
          this.listener.onEvent(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/aidl/EventRecognitionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */