package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

class IRGInfoAdapter
  implements OnRGInfoListener
{
  private IRGInfoListener mRGInfoListener = null;
  
  public IRGInfoAdapter(IRGInfoListener paramIRGInfoListener)
  {
    this.mRGInfoListener = paramIRGInfoListener;
  }
  
  public void onAssistInfoHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onAssistInfoHide(paramMessage);
    }
  }
  
  public void onAssistInfoShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onAssistInfoShow(paramMessage);
    }
  }
  
  public void onAssistInfoUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onAssistInfoUpdate(paramMessage);
    }
  }
  
  public void onCurRoadNameUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onCurRoadNameUpdate(paramMessage);
    }
  }
  
  public void onDestStreetViewDownloadSuccess(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDestStreetViewDownloadSuccess(paramMessage);
    }
  }
  
  public void onDestStreetViewHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDestStreetViewHide(paramMessage);
    }
  }
  
  public void onDestStreetViewShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDestStreetViewShow(paramMessage);
    }
  }
  
  public void onDestStreetViewStartDownload(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDestStreetViewStartDownload(paramMessage);
    }
  }
  
  public void onDestStreetViewUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDestStreetViewUpdate(paramMessage);
    }
  }
  
  public void onDirectBoardHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDirectBoardHide(paramMessage);
    }
  }
  
  public void onDirectBoardShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDirectBoardShow(paramMessage);
    }
  }
  
  public void onDirectBoardUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onDirectBoardUpdate(paramMessage);
    }
  }
  
  public void onGPSWeak(Message paramMessage) {}
  
  public void onHUDUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onHUDUpdate(paramMessage);
    }
  }
  
  public void onHighwayInfoHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onHighwayInfoHide(paramMessage);
    }
  }
  
  public void onHighwayInfoShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onHighwayInfoShow(paramMessage);
    }
  }
  
  public void onHighwayInfoUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onHighwayInfoUpdate(paramMessage);
    }
  }
  
  public void onOtherRGInfo(Message paramMessage) {}
  
  public void onRGSyncOperation(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onRGSyncOperation(paramMessage);
    }
  }
  
  public void onRasterExpandMapHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onRasterExpandMapHide(paramMessage);
    }
  }
  
  public void onRasterExpandMapShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onRasterExpandMapShow(paramMessage);
    }
  }
  
  public void onRasterExpandMapUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onRasterExpandMapUpdate(paramMessage);
    }
  }
  
  public void onSimpleBoardHide(Message paramMessage) {}
  
  public void onSimpleBoardShow(Message paramMessage) {}
  
  public void onSimpleBoardUpdate(Message paramMessage) {}
  
  public void onSimpleGuideInfoHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onSimpleGuideInfoHide(paramMessage);
    }
  }
  
  public void onSimpleGuideInfoShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onSimpleGuideInfoShow(paramMessage);
    }
  }
  
  public void onSimpleGuideInfoUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onSimpleGuideInfoUpdate(paramMessage);
    }
  }
  
  public void onTotalRemainDistTimeUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onRemainDistTimeUpdate(paramMessage);
    }
  }
  
  public void onUGCEventTipsHide() {}
  
  public void onUGCEventTipsShow() {}
  
  public void onVectorExpandMapHide(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onVectorExpandMapHide(paramMessage);
    }
  }
  
  public void onVectorExpandMapShow(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onVectorExpandMapShow(paramMessage);
    }
  }
  
  public void onVectorExpandMapUpdate(Message paramMessage)
  {
    if (this.mRGInfoListener != null) {
      this.mRGInfoListener.onVectorExpandMapUpdate(paramMessage);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeguide/IRGInfoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */