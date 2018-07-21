package com.baidu.che.codriver.platform;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.sdk.a.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.e;

public class PlatformManager
{
  private static final String TAG = "PlatformManager";
  private static PlatformManager sIntance = null;
  private static final Object sLock = new Object();
  private Context mContext = null;
  
  public static PlatformManager getInstance()
  {
    if (sIntance == null) {}
    synchronized (sLock)
    {
      if (sIntance == null) {
        sIntance = new PlatformManager();
      }
      return sIntance;
    }
  }
  
  private boolean initNavi()
  {
    NaviParse.getInstance().initCmdHashMap();
    NaviCmdController.getInstance().readAddress();
    return true;
  }
  
  public boolean handleCommand(int paramInt, String paramString, Boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      h.b("PlatformManager", "handleCommand: cmdType = " + paramInt);
      if (paramInt == 8) {
        sendNaviCommand(paramString, paramBoolean);
      }
      return true;
    }
    return false;
  }
  
  public boolean handleCommand(e parame, Boolean paramBoolean)
  {
    if ((parame != null) && (!TextUtils.isEmpty(parame.c())))
    {
      int i = PlatformUtils.getCommandType(parame);
      h.b("PlatformManager", "handleCommand: cmdType = " + i);
      if (i == 8) {
        sendNaviCommand(parame.c(), paramBoolean);
      }
      return true;
    }
    h.b("PlatformManager", "handleCommand: error");
    return false;
  }
  
  public void init(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    initNavi();
  }
  
  public void sendNaviCommand(String paramString, Boolean paramBoolean)
  {
    h.b("PlatformManager", "sendNaviCommand: cmd = " + paramString);
    paramString = NaviParse.getInstance().parse(paramString);
    if (paramString == null)
    {
      h.e("PlatformManager", "cannot parse the navi cmd data");
      return;
    }
    h.b("PlatformManager", "naviCmdData = " + paramString.toString());
    c.a().a(paramString.getFunc(), paramString.getParams());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/PlatformManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */