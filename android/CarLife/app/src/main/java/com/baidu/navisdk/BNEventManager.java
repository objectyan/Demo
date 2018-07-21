package com.baidu.navisdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class BNEventManager
{
  private static BNEventManager mInstance = null;
  private String TAG = BNEventManager.class.getSimpleName();
  private NaviMsgListener mNaviMsgListener = null;
  private ArrayList<NaviMsgListener> mNaviMsgListeners = null;
  private NaviPhoneStateListener mPhoneStateListener = null;
  
  public static BNEventManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNEventManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public void onIdle()
  {
    if (this.mPhoneStateListener != null)
    {
      this.mPhoneStateListener.onIdle();
      LogUtil.e(this.TAG, "onIdle");
    }
  }
  
  public void onOffHook()
  {
    if (this.mPhoneStateListener != null)
    {
      this.mPhoneStateListener.onOffHook();
      LogUtil.e(this.TAG, "onOffHook");
    }
  }
  
  public void onOtherAction(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onOtherAction(paramInt1, paramInt2, paramInt3, paramObject);
      LogUtil.e(this.TAG, "onOtherAction: type=" + paramInt1);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onOtherAction(paramInt1, paramInt2, paramInt3, paramObject);
        }
      }
    }
  }
  
  public void onRasterMapHide()
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRasterMapHide();
      LogUtil.e(this.TAG, "onRasterMapHide: ");
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRasterMapHide();
        }
      }
    }
  }
  
  public void onRasterMapShow(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    try
    {
      Object localObject2;
      if ((this.mNaviMsgListener != null) && (paramBitmap1 != null) && (!paramBitmap1.isRecycled()) && (paramBitmap2 != null) && (!paramBitmap2.isRecycled()))
      {
        ??? = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
        localObject2 = paramBitmap2.copy(Bitmap.Config.ARGB_8888, true);
        this.mNaviMsgListener.onRasterMapShow(paramInt, (Bitmap)???, (Bitmap)localObject2);
        LogUtil.e(this.TAG, "RasterMapShow,type=" + paramInt);
      }
      synchronized (this.mNaviMsgListeners)
      {
        if ((this.mNaviMsgListeners != null) && (paramBitmap1 != null) && (!paramBitmap1.isRecycled()) && (paramBitmap2 != null) && (!paramBitmap2.isRecycled()))
        {
          paramBitmap1 = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
          paramBitmap2 = paramBitmap2.copy(Bitmap.Config.ARGB_8888, true);
          localObject2 = this.mNaviMsgListeners.iterator();
          if (((Iterator)localObject2).hasNext()) {
            ((NaviMsgListener)((Iterator)localObject2).next()).onRasterMapShow(paramInt, paramBitmap1, paramBitmap2);
          }
        }
      }
    }
    catch (Throwable paramBitmap1) {}
  }
  
  public void onRasterMapUpdate(String paramString1, int paramInt, String paramString2)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRasterMapUpdate(paramString1, paramInt, paramString2);
      LogUtil.e(this.TAG, "RasterMapUpdate: " + paramString1 + "-" + paramInt + "-" + paramString2);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRasterMapUpdate(paramString1, paramInt, paramString2);
        }
      }
    }
  }
  
  public void onRemainDistanceUpdate(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRemainDistanceUpdate(paramCharSequence, paramDrawable);
      LogUtil.e(this.TAG, "RemainDistance: " + paramCharSequence);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRemainDistanceUpdate(paramCharSequence, paramDrawable);
        }
      }
    }
  }
  
  public void onRemainTimeUpdate(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRemainTimeUpdate(paramCharSequence, paramDrawable);
      LogUtil.e(this.TAG, "RemainTime: " + paramCharSequence);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRemainTimeUpdate(paramCharSequence, paramDrawable);
        }
      }
    }
  }
  
  public void onRinging()
  {
    if (this.mPhoneStateListener != null)
    {
      this.mPhoneStateListener.onRinging();
      LogUtil.e(this.TAG, "onRinging");
    }
  }
  
  public void onRoadNameUpdate(String paramString)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRoadNameUpdate(paramString);
      LogUtil.e(this.TAG, "RoadName: " + paramString);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRoadNameUpdate(paramString);
        }
      }
    }
  }
  
  public void onRoadTurnInfoDistanceUpdate(CharSequence paramCharSequence)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRoadTurnInfoDistanceUpdate(paramCharSequence);
      LogUtil.e(this.TAG, "RoadTurnInfoDistance: " + paramCharSequence);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRoadTurnInfoDistanceUpdate(paramCharSequence);
        }
      }
    }
  }
  
  public void onRoadTurnInfoIconUpdate(Drawable paramDrawable)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onRoadTurnInfoIconUpdate(paramDrawable);
      LogUtil.e(this.TAG, "RoadTurnInfoIcon:");
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onRoadTurnInfoIconUpdate(paramDrawable);
        }
      }
    }
  }
  
  public void onSatelliteNumUpdate(int paramInt, Drawable paramDrawable)
  {
    if (this.mNaviMsgListener != null)
    {
      this.mNaviMsgListener.onSatelliteNumUpdate(paramInt, paramDrawable);
      LogUtil.e(this.TAG, "SatelliteNum: " + paramInt);
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners != null)
      {
        Iterator localIterator = this.mNaviMsgListeners.iterator();
        if (localIterator.hasNext()) {
          ((NaviMsgListener)localIterator.next()).onSatelliteNumUpdate(paramInt, paramDrawable);
        }
      }
    }
  }
  
  public void registerNaviMsgListener(NaviMsgListener paramNaviMsgListener)
  {
    if ((this.mNaviMsgListeners == null) || (paramNaviMsgListener == null)) {
      return;
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (!this.mNaviMsgListeners.contains(paramNaviMsgListener)) {
        this.mNaviMsgListeners.add(paramNaviMsgListener);
      }
      return;
    }
  }
  
  public void removeNaviMsgListener()
  {
    this.mNaviMsgListener = null;
  }
  
  public void removeNaviPhoneStateListener()
  {
    this.mPhoneStateListener = null;
  }
  
  public void setNaviMsgListener(NaviMsgListener paramNaviMsgListener)
  {
    this.mNaviMsgListener = paramNaviMsgListener;
  }
  
  public void setNaviPhoneStateListener(NaviPhoneStateListener paramNaviPhoneStateListener)
  {
    this.mPhoneStateListener = paramNaviPhoneStateListener;
  }
  
  public void unregisterNaviMsgListener(NaviMsgListener paramNaviMsgListener)
  {
    if ((this.mNaviMsgListeners == null) || (paramNaviMsgListener == null)) {
      return;
    }
    synchronized (this.mNaviMsgListeners)
    {
      if (this.mNaviMsgListeners.contains(paramNaviMsgListener)) {
        this.mNaviMsgListeners.remove(paramNaviMsgListener);
      }
      return;
    }
  }
  
  public static abstract interface NaviMsgListener
  {
    public static final int EVENT_AVOID_TRAFFIC_EJECT = 13;
    public static final int EVENT_AVOID_TRAFFIC_SWITCH = 12;
    public static final int EVENT_AVOID_TRAFFIC_SWITCH_FAILED = 15;
    public static final int EVENT_AVOID_TRAFFIC_SWITCH_SUCCESS = 14;
    public static final int EVENT_AVOID_TRAFFIC_TIPS = 11;
    public static final int EVENT_GPS_DISMISS = 6;
    public static final int EVENT_GPS_LOCATED = 5;
    public static final int EVENT_NAVIGATING_STATE_BEGIN = 3;
    public static final int EVENT_NAVIGATING_STATE_END = 4;
    public static final int EVENT_ROUTEPLAN_BEGIN = 7;
    public static final int EVENT_ROUTEPLAN_END = 8;
    public static final int EVENT_ROUTEPLAN_FAILED = 10;
    public static final int EVENT_ROUTEPLAN_SUCCESS = 9;
    public static final int RASTERMAPTYPE_DERECTBOARD = 1;
    public static final int RASTERMAPTYPE_GRID = 2;
    
    public abstract void onOtherAction(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void onRasterMapHide();
    
    public abstract void onRasterMapShow(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2);
    
    public abstract void onRasterMapUpdate(String paramString1, int paramInt, String paramString2);
    
    public abstract void onRemainDistanceUpdate(CharSequence paramCharSequence, Drawable paramDrawable);
    
    public abstract void onRemainTimeUpdate(CharSequence paramCharSequence, Drawable paramDrawable);
    
    public abstract void onRoadNameUpdate(String paramString);
    
    public abstract void onRoadTurnInfoDistanceUpdate(CharSequence paramCharSequence);
    
    public abstract void onRoadTurnInfoIconUpdate(Drawable paramDrawable);
    
    public abstract void onSatelliteNumUpdate(int paramInt, Drawable paramDrawable);
  }
  
  public static abstract interface NaviPhoneStateListener
  {
    public abstract void onIdle();
    
    public abstract void onOffHook();
    
    public abstract void onRinging();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/BNEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */