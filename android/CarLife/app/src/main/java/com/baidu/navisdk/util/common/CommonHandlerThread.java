package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonHandlerThread
{
  public static final int MAG_NAVI_STAT_INIT = 11;
  public static final int MAG_NAVI_STAT_ONEVEN = 12;
  public static final int MESSAGE_DRAW_ROUTE = 400;
  public static final int MESSAGE_DRAW_TRACK = 401;
  public static final int MESSAGE_DRAW_TRACK_AND_POS = 402;
  public static final int MSG_CLEAN_XIMALAYA_DATA = 20;
  public static final int MSG_DEBUG_FILE_ADD = 300;
  public static final int MSG_LIGHTNAV_STAT_END = 201;
  public static final int MSG_LIGHTNAV_STAT_START = 200;
  public static final int MSG_NAVING_STAT_END = 101;
  public static final int MSG_NAVING_STAT_START = 100;
  public static final int MSG_NAVI_INIT_A = 50;
  public static final int MSG_NAVI_INIT_B = 51;
  public static final int MSG_NAVI_INIT_PRELOAD_VIEW = 56;
  public static final int MSG_NAVI_INIT_UPDATE_USERINFO = 55;
  public static final int MSG_NAVI_INPAGE_INIT_BG = 501;
  public static final int MSG_NAVI_INPAGE_REALLY_START = 502;
  public static final int MSG_NAVI_SESSION_STAT_UPLOAD = 14;
  public static final int MSG_NAVI_STAT_UPLOAD = 13;
  public static final int MSG_NAVMERGE_STAT_END = 250;
  public static final int MSG_ROUTEGUIDE_CPU_END_PROFILE = 31;
  public static final int MSG_ROUTEGUIDE_CPU_START_PROFILE = 30;
  public static final int MSG_SET_KILLED_TIME = 302;
  public static final int MSG_START_RECORD_TRAJECTORY = 150;
  public static final int MSG_SYSTEM_LOG_UPLOAD = 301;
  public static final int MSG_USER_OP_CACHE_OPS = 3;
  public static final int MSG_USER_OP_CLEAR_CACHE = 2;
  public static final int MSG_USER_OP_LOAD_CACHE = 1;
  private static final String TAG = CommonHandlerThread.class.getSimpleName();
  private static CommonHandlerThread sInstance = null;
  private List<Callback> mCallbacks = new ArrayList();
  private Handler mHandler = null;
  private HandlerThread mHandlerThread = null;
  
  protected CommonHandlerThread()
  {
    init();
  }
  
  public static CommonHandlerThread getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new CommonHandlerThread();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void init()
  {
    if (this.mHandlerThread != null) {
      return;
    }
    this.mHandlerThread = new HandlerThread("CommonHandlerThread");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        int i = CommonHandlerThread.this.mCallbacks.size() - 1;
        while ((i >= 0) && (i < CommonHandlerThread.this.mCallbacks.size()) && (CommonHandlerThread.this.mCallbacks.get(i) != null))
        {
          CommonHandlerThread.Callback localCallback = (CommonHandlerThread.Callback)CommonHandlerThread.this.mCallbacks.get(i);
          if (localCallback.isCareAbout(paramAnonymousMessage.what)) {
            localCallback.execute(paramAnonymousMessage);
          }
          i -= 1;
        }
      }
    };
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public Looper getLooper()
  {
    if (this.mHandlerThread == null) {
      return null;
    }
    return this.mHandlerThread.getLooper();
  }
  
  public void registerCallback(Callback paramCallback)
  {
    if ((paramCallback != null) && (!this.mCallbacks.contains(paramCallback)))
    {
      paramCallback.careAbouts();
      this.mCallbacks.add(paramCallback);
    }
  }
  
  public void removeMessage(int paramInt)
  {
    if ((this.mHandler != null) && (this.mHandler.hasMessages(paramInt))) {
      this.mHandler.removeMessages(paramInt);
    }
  }
  
  public boolean sendMessage(int paramInt)
  {
    return sendMessage(paramInt, 0, 0, null, 0L);
  }
  
  public boolean sendMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    if (this.mHandler == null)
    {
      LogUtil.e(TAG, "warning: sendMessage() handler is null.");
      return false;
    }
    Message localMessage = this.mHandler.obtainMessage(paramInt1);
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    if (paramLong <= 0L) {
      this.mHandler.sendMessage(localMessage);
    }
    for (;;)
    {
      return true;
      this.mHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public void unregisterCallback(Callback paramCallback)
  {
    if ((paramCallback != null) && (this.mCallbacks.contains(paramCallback))) {
      this.mCallbacks.remove(paramCallback);
    }
  }
  
  public static abstract class Callback
  {
    private Set<Integer> mCareMsgs = new HashSet();
    
    public final void careAbout(int paramInt)
    {
      this.mCareMsgs.add(Integer.valueOf(paramInt));
    }
    
    public abstract void careAbouts();
    
    public abstract void execute(Message paramMessage);
    
    public String getName()
    {
      return "default";
    }
    
    public final boolean isCareAbout(int paramInt)
    {
      return this.mCareMsgs.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/CommonHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */