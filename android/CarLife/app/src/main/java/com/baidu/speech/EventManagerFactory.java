package com.baidu.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.speech.aidl.EventListener.Stub;
import com.baidu.speech.aidl.EventManagerFactory.Stub;
import com.baidu.speech.aidl.EventRecognitionService;
import com.baidu.speech.asr.EventManagerAsr;
import com.baidu.speech.asr.EventManagerSlot;
import com.baidu.speech.asr.EventManagerWp;
import com.baidu.speech.audio.MicrophoneServer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class EventManagerFactory
{
  private static final String TAG = "EventManagerFactory";
  private static boolean asrUsing = false;
  private static boolean kwsLoaded = false;
  private static boolean wpUsing = false;
  
  public static final EventManager create(Context paramContext, String paramString)
  {
    return create(paramContext, paramString, false);
  }
  
  public static final EventManager create(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.equals(""))) {}
    do
    {
      return null;
      paramContext = paramContext.getApplicationContext();
      if (paramBoolean) {
        return new EventManagerRemote2Local(paramContext, paramString);
      }
      if (paramString.equals("asr")) {
        return new EventManagerAsr(paramContext);
      }
      if (paramString.equals("wp")) {
        return new EventManagerWp(paramContext);
      }
    } while (!paramString.equals("slot"));
    return new EventManagerSlot(paramContext);
  }
  
  static class EventManagerRemote2Local
    implements EventManager
  {
    final ServiceConnection conn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        paramAnonymousComponentName = EventManagerFactory.Stub.asInterface(paramAnonymousIBinder);
        try
        {
          if (EventManagerFactory.EventManagerRemote2Local.this.remoteEM == null)
          {
            paramAnonymousComponentName = paramAnonymousComponentName.create(EventManagerFactory.EventManagerRemote2Local.this.name);
            EventManagerFactory.EventManagerRemote2Local.this.setRemoteEM(paramAnonymousComponentName);
          }
          return;
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          paramAnonymousComponentName.printStackTrace();
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        if ((EventManagerFactory.kwsLoaded) && (EventManagerFactory.EventManagerRemote2Local.this.mLis != null)) {
          EventManagerFactory.EventManagerRemote2Local.this.mLis.onEvent("asr.unloaded", null, null, 0, 0);
        }
        if ((EventManagerFactory.asrUsing) && (EventManagerFactory.EventManagerRemote2Local.this.mLis != null)) {
          EventManagerFactory.EventManagerRemote2Local.this.mLis.onEvent("asr.exit", null, null, 0, 0);
        }
        if ((EventManagerFactory.wpUsing) && (EventManagerFactory.EventManagerRemote2Local.this.mLis != null)) {
          EventManagerFactory.EventManagerRemote2Local.this.mLis.onEvent("wp.exit", null, null, 0, 0);
        }
        EventManagerFactory.EventManagerRemote2Local.access$002(EventManagerFactory.EventManagerRemote2Local.this, null);
      }
    };
    private Context context;
    ExecutorService executor = Executors.newCachedThreadPool();
    private EventListener mLis;
    private String name;
    private com.baidu.speech.aidl.EventManager remoteEM;
    
    EventManagerRemote2Local(Context paramContext, String paramString)
    {
      this.context = paramContext;
      this.name = paramString;
    }
    
    public void registerListener(EventListener paramEventListener)
    {
      this.mLis = paramEventListener;
    }
    
    public void send(final String paramString1, final String paramString2, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
    {
      this.context.bindService(new Intent(this.context, EventRecognitionService.class), this.conn, 1);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new byte[0];
        if ((!"asr.start".equals(paramString1)) && (!"asr.kws.load".equals(paramString1))) {
          break label93;
        }
        EventManagerFactory.access$402(true);
      }
      for (;;)
      {
        paramString1 = new Runnable()
        {
          public void run()
          {
            if (EventManagerFactory.EventManagerRemote2Local.this.remoteEM == null)
            {
              new Handler(Looper.getMainLooper()).postDelayed(this, 10L);
              return;
            }
            String str3 = paramString2;
            if (("asr.start".equals(paramString1)) || ("wp.start".equals(paramString1))) {}
            for (;;)
            {
              try
              {
                localJSONObject = new JSONObject(paramString2);
              }
              catch (Exception localException1)
              {
                try
                {
                  String str4 = localJSONObject.optString("infile");
                  String str1 = str3;
                  if (!localJSONObject.has("audio.socketport"))
                  {
                    str1 = str3;
                    if (!TextUtils.isEmpty(str4))
                    {
                      int i = 1;
                      if (localJSONObject.has("audio.source")) {
                        i = localJSONObject.optInt("audio.source");
                      }
                      localJSONObject.put("audio.socketport", MicrophoneServer.create(str4, i));
                      str1 = localJSONObject.toString();
                    }
                  }
                  try
                  {
                    EventManagerFactory.EventManagerRemote2Local.this.remoteEM.registerListener(new EventListener.Stub()
                    {
                      public void onEvent(final String paramAnonymous2String1, final String paramAnonymous2String2, final byte[] paramAnonymous2ArrayOfByte, final int paramAnonymous2Int1, final int paramAnonymous2Int2)
                        throws RemoteException
                      {
                        String str;
                        if ("asr.exit".equals(paramAnonymous2String1))
                        {
                          EventManagerFactory.access$402(false);
                          if (!"wp.exit".equals(paramAnonymous2String1)) {
                            break label181;
                          }
                          str = paramAnonymous2String2;
                          if (paramAnonymous2String2 == null) {
                            str = "{}";
                          }
                        }
                        for (;;)
                        {
                          try
                          {
                            paramAnonymous2String2 = new JSONObject(str);
                          }
                          catch (JSONException localJSONException1)
                          {
                            paramAnonymous2String2 = null;
                            bool = false;
                          }
                          for (;;)
                          {
                            try
                            {
                              bool = paramAnonymous2String2.optBoolean("_free");
                            }
                            catch (JSONException localJSONException2)
                            {
                              bool = false;
                              continue;
                            }
                            try
                            {
                              paramAnonymous2String2.remove("_free");
                              paramAnonymous2String2 = paramAnonymous2String2.toString();
                              if (!bool) {
                                continue;
                              }
                              new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
                              {
                                public void run()
                                {
                                  EventManagerFactory.EventManagerRemote2Local.this.mLis.onEvent(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2ArrayOfByte, paramAnonymous2Int1, paramAnonymous2Int2);
                                }
                              }, 200L);
                              return;
                            }
                            catch (JSONException localJSONException3) {}
                          }
                          if ("wp.exit".equals(paramAnonymous2String1))
                          {
                            EventManagerFactory.access$502(false);
                            break;
                          }
                          if (!"asr.unloaded".equals(paramAnonymous2String1)) {
                            break;
                          }
                          EventManagerFactory.access$202(false);
                          break;
                          localJSONException1.printStackTrace();
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable()
                        {
                          public void run()
                          {
                            EventManagerFactory.EventManagerRemote2Local.this.mLis.onEvent(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2ArrayOfByte, paramAnonymous2Int1, paramAnonymous2Int2);
                          }
                        });
                        return;
                        label181:
                        new Handler(Looper.getMainLooper()).post(new Runnable()
                        {
                          public void run()
                          {
                            EventManagerFactory.EventManagerRemote2Local.this.mLis.onEvent(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2ArrayOfByte, paramAnonymous2Int1, paramAnonymous2Int2);
                          }
                        });
                      }
                    });
                    EventManagerFactory.EventManagerRemote2Local.this.remoteEM.send(paramString1, str1, paramArrayOfByte, paramInt1, paramInt2);
                    return;
                  }
                  catch (RemoteException localRemoteException)
                  {
                    localRemoteException.printStackTrace();
                    EventManagerFactory.EventManagerRemote2Local.access$002(EventManagerFactory.EventManagerRemote2Local.this, null);
                    return;
                  }
                  localException1 = localException1;
                  JSONObject localJSONObject = new JSONObject();
                  continue;
                  String str2 = str3;
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                }
              }
            }
          }
        };
        new Handler(Looper.getMainLooper()).postDelayed(paramString1, 0L);
        return;
        break;
        label93:
        if ("wp.start".equals(paramString1)) {
          EventManagerFactory.access$502(true);
        } else if ("asr.kws.load".equals(paramString1)) {
          EventManagerFactory.access$202(true);
        }
      }
    }
    
    public void setRemoteEM(com.baidu.speech.aidl.EventManager paramEventManager)
    {
      this.remoteEM = paramEventManager;
    }
    
    public void unregisterListener(EventListener paramEventListener)
    {
      this.mLis = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/EventManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */