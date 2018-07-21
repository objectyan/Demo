package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

public abstract interface IRGSubStatusListener
{
  public abstract void onArriveDest(Message paramMessage);
  
  public abstract void onArriveDestNear(Message paramMessage);
  
  public abstract void onReRouteCarFree(Message paramMessage);
  
  public abstract void onReRouteComplete(Message paramMessage);
  
  public abstract void onRoutePlanYawing(Message paramMessage);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeguide/IRGSubStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */