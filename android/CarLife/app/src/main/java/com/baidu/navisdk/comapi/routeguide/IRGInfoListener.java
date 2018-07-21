package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

public abstract interface IRGInfoListener
{
  public abstract void onAssistInfoHide(Message paramMessage);
  
  public abstract void onAssistInfoShow(Message paramMessage);
  
  public abstract void onAssistInfoUpdate(Message paramMessage);
  
  public abstract void onCurRoadNameUpdate(Message paramMessage);
  
  public abstract void onDestStreetViewDownloadSuccess(Message paramMessage);
  
  public abstract void onDestStreetViewHide(Message paramMessage);
  
  public abstract void onDestStreetViewShow(Message paramMessage);
  
  public abstract void onDestStreetViewStartDownload(Message paramMessage);
  
  public abstract void onDestStreetViewUpdate(Message paramMessage);
  
  public abstract void onDirectBoardHide(Message paramMessage);
  
  public abstract void onDirectBoardShow(Message paramMessage);
  
  public abstract void onDirectBoardUpdate(Message paramMessage);
  
  public abstract void onHUDUpdate(Message paramMessage);
  
  public abstract void onHighwayInfoHide(Message paramMessage);
  
  public abstract void onHighwayInfoShow(Message paramMessage);
  
  public abstract void onHighwayInfoUpdate(Message paramMessage);
  
  public abstract void onRGSyncOperation(Message paramMessage);
  
  public abstract void onRasterExpandMapHide(Message paramMessage);
  
  public abstract void onRasterExpandMapShow(Message paramMessage);
  
  public abstract void onRasterExpandMapUpdate(Message paramMessage);
  
  public abstract void onRemainDistTimeUpdate(Message paramMessage);
  
  public abstract void onSimpleGuideInfoHide(Message paramMessage);
  
  public abstract void onSimpleGuideInfoShow(Message paramMessage);
  
  public abstract void onSimpleGuideInfoUpdate(Message paramMessage);
  
  public abstract void onVectorExpandMapHide(Message paramMessage);
  
  public abstract void onVectorExpandMapShow(Message paramMessage);
  
  public abstract void onVectorExpandMapUpdate(Message paramMessage);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeguide/IRGInfoListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */