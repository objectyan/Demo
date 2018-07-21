package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

public abstract interface IGpsStatusListener
{
  public abstract void onGpsServiceProcess(Message paramMessage);
  
  public abstract void onGpsStatusChange(Message paramMessage);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeguide/IGpsStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */