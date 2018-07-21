package com.baidu.speech.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.core.ASREngine;
import com.baidu.speech.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class EventManagerAsr
  implements EventManager, ASRListener
{
  private static final String TAG = "EventManagerAsr";
  private static final String version = "3.4.0.100";
  private Exception initException = null;
  private ArrayList<EventListener> listeners = new ArrayList();
  private ASREngine mEnginer;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private ArrayList<ASRMessage> mMessageQueue = new ArrayList();
  private Context mcontext;
  
  public EventManagerAsr(Context paramContext)
  {
    this.mcontext = paramContext;
    try
    {
      this.mEnginer = new ASREngine(paramContext);
      this.mMessageQueue.clear();
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
    return "3.4.0.100";
  }
  
  private void updateMessageQueue(ASRMessage paramASRMessage)
  {
    synchronized (this.mMessageQueue)
    {
      if (paramASRMessage.mIsVip) {
        this.mMessageQueue.clear();
      }
      this.mMessageQueue.add(paramASRMessage);
      return;
    }
  }
  
  public void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    onEvent(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public void onEvent(String arg1, String arg2, final byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    updateMessageQueue(new ASRMessage(???, ???, paramArrayOfByte, paramInt1, paramInt2, paramBoolean));
    synchronized (this.listeners)
    {
      synchronized (this.mMessageQueue)
      {
        if (this.mMessageQueue.size() <= 0) {
          return;
        }
        paramArrayOfByte = (ASRMessage)this.mMessageQueue.remove(0);
        if (paramArrayOfByte != null)
        {
          Iterator localIterator = this.listeners.iterator();
          if (localIterator.hasNext())
          {
            final EventListener localEventListener = (EventListener)localIterator.next();
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                if (localEventListener != null)
                {
                  LogUtil.i("EventManagerAsr", new String[] { "onEvent mCommand : " + paramArrayOfByte.mCommand });
                  LogUtil.i("EventManagerAsr", new String[] { "onEvent mParam : " + paramArrayOfByte.mParam });
                  localEventListener.onEvent(paramArrayOfByte.mCommand, paramArrayOfByte.mParam, paramArrayOfByte.mData, paramArrayOfByte.mOffset, paramArrayOfByte.mLength);
                }
              }
            });
          }
        }
      }
    }
  }
  
  public void registerListener(EventListener paramEventListener)
  {
    if ((paramEventListener != null) && (!this.listeners.contains(paramEventListener))) {
      this.listeners.add(paramEventListener);
    }
  }
  
  public void send(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    LogUtil.i("EventManagerAsr", new String[] { "send cmd : " + paramString1 });
    LogUtil.i("EventManagerAsr", new String[] { "send params : " + paramString2 });
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if ((paramString1.equals("asr.start")) && (this.initException != null))
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
                LogUtil.i("EventManagerAsr", new String[] { "onEvent mCommand : asr.finish and asr.exit  onEvent mParam : " + EventManagerAsr.this.initException.getMessage() });
                localEventListener.onEvent("asr.finish", EventManagerAsr.this.initException.getMessage(), null, 0, 0);
                localEventListener.onEvent("asr.exit", EventManagerAsr.this.initException.getMessage(), null, 0, 0);
              }
            }
          });
        }
      }
    } while (this.mEnginer == null);
    this.mEnginer.setListener(this);
    this.mEnginer.postEvent(paramString1, paramString2);
  }
  
  public void unregisterListener(EventListener paramEventListener)
  {
    this.listeners.remove(paramEventListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/EventManagerAsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */