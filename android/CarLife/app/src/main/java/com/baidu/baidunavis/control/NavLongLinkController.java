package com.baidu.baidunavis.control;

import android.os.Bundle;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import java.util.ArrayList;
import java.util.Arrays;

public class NavLongLinkController
{
  public static final int FellowModuleId = 10;
  public static final int FellowModuleId_for_test_cpu = 11;
  public static final String TAG = NavLongLinkController.class.getSimpleName();
  private static NavLongLinkController sInstance = null;
  private LongLinkClient mLongLinkClient;
  private LongLinkDataCallback mLongLinkDataCallback;
  
  public static NavLongLinkController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavLongLinkController();
    }
    return sInstance;
  }
  
  public boolean CloseLCS()
  {
    if (this.mLongLinkClient != null) {
      try
      {
        if (this.mLongLinkClient.release() != -1) {}
        for (boolean bool = true;; bool = false)
        {
          this.mLongLinkClient = null;
          return bool;
        }
        return false;
      }
      catch (Exception localException)
      {
        this.mLongLinkClient = null;
        LogUtil.e("onFellowCloseLCS", "CloseLCS Exception   e====");
        localException.printStackTrace();
      }
    }
  }
  
  public int GetReqId()
  {
    if (this.mLongLinkClient != null) {
      return this.mLongLinkClient.getRequestId();
    }
    return -1;
  }
  
  public boolean IsLCSConnect()
  {
    if (this.mLongLinkClient != null) {
      try
      {
        boolean bool = this.mLongLinkClient.isValid();
        return bool;
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public Bundle SendData(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (this.mLongLinkClient != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        LongLinkFileData localLongLinkFileData = new LongLinkFileData();
        localLongLinkFileData.fileName = paramString2;
        localLongLinkFileData.binData = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
        localArrayList.add(localLongLinkFileData);
        paramArrayOfByte = this.mLongLinkClient.sendFileData(paramString1, localArrayList);
        paramString1 = new Bundle();
        if (paramArrayOfByte != null)
        {
          paramString1.putInt("StatusCode", paramArrayOfByte.getStatusCode());
          paramString1.putInt("RequestId", paramArrayOfByte.getRequestId());
        }
        return paramString1;
      }
      catch (Exception paramArrayOfByte) {}
    }
    return null;
  }
  
  public boolean createLCS()
  {
    try
    {
      if (this.mLongLinkClient == null) {
        this.mLongLinkClient = LongLinkClient.create(10);
      }
      return true;
    }
    catch (Exception localException)
    {
      LogUtil.e("onFellowCloseLCS", "createLCS Exception   e====");
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean registerLCS()
  {
    try
    {
      if (this.mLongLinkClient != null)
      {
        if (this.mLongLinkDataCallback == null) {
          this.mLongLinkDataCallback = new LongLinkDataCallback()
          {
            public boolean onReceiveData(ELongLinkStatus paramAnonymousELongLinkStatus, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
            {
              LogUtil.e("onFellowCreateLCS", "onReceiveData:reqId:" + paramAnonymousInt + " status:" + paramAnonymousELongLinkStatus + " data: " + new String(paramAnonymousArrayOfByte) + "  isPush: " + paramAnonymousBoolean);
              return true;
            }
          };
        }
        boolean bool = this.mLongLinkClient.register(this.mLongLinkDataCallback);
        return bool;
      }
    }
    catch (b localb)
    {
      LogUtil.e("onFellowregisterLCS", "registerLCS Exception   e====");
      localb.printStackTrace();
    }
    return false;
  }
  
  public boolean unRegisterLCS()
  {
    if (this.mLongLinkClient != null) {
      try
      {
        boolean bool = this.mLongLinkClient.unRegister(this.mLongLinkDataCallback);
        this.mLongLinkDataCallback = null;
        return bool;
      }
      catch (b localb)
      {
        this.mLongLinkDataCallback = null;
        LogUtil.e("onFellowUnregisterLCS", "unRegisterLCS Exception   e====");
        localb.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavLongLinkController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */