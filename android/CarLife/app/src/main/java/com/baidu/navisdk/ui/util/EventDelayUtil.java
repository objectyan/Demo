package com.baidu.navisdk.ui.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.LogUtil;

public class EventDelayUtil
{
  private static final String TAG = "EventDelayUtil";
  private SparseArray<Object[]> mEventMap = new SparseArray();
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      paramAnonymousMessage = (Object[])EventDelayUtil.this.mEventMap.get(i);
      if (EventDelayUtil.this.mListener != null) {
        EventDelayUtil.this.mListener.onStart(i, paramAnonymousMessage);
      }
      EventDelayUtil.this.mEventMap.remove(i);
    }
  };
  private EventDelayListener mListener;
  
  public void cancle(int paramInt)
  {
    this.mEventMap.remove(paramInt);
  }
  
  public void clean()
  {
    this.mHandler.removeCallbacks(null);
    this.mHandler = null;
    this.mEventMap.clear();
  }
  
  public void exec(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (this.mHandler == null) {
      LogUtil.e("EventDelayUtil", "handler is null");
    }
    do
    {
      return;
      this.mEventMap.put(paramInt1, paramVarArgs);
    } while (this.mHandler.hasMessages(paramInt1));
    paramVarArgs = this.mHandler.obtainMessage(paramInt1, paramVarArgs);
    this.mHandler.sendMessageDelayed(paramVarArgs, paramInt2);
  }
  
  public void registListner(EventDelayListener paramEventDelayListener)
  {
    this.mListener = paramEventDelayListener;
  }
  
  public void unRegistListner()
  {
    this.mListener = null;
  }
  
  public static abstract interface EventDelayListener
  {
    public abstract void onStart(int paramInt, Object... paramVarArgs);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/EventDelayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */