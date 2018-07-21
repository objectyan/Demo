package com.baidu.vi;

import android.net.NetworkInfo;

public class VNetworkInfo
{
  private static final int STATE_CONNECTED = 2;
  private static final int STATE_CONNECTING = 1;
  private static final int STATE_DISCONNECTED = 0;
  public int state;
  public int type;
  public String typename;
  
  public VNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    this.typename = paramNetworkInfo.getTypeName();
    this.type = paramNetworkInfo.getType();
    switch (1.a[paramNetworkInfo.getState().ordinal()])
    {
    default: 
      this.state = 0;
      return;
    case 1: 
      this.state = 2;
      return;
    }
    this.state = 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/VNetworkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */