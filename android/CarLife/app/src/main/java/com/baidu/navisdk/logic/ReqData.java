package com.baidu.navisdk.logic;

import android.os.Handler;
import java.util.HashMap;
import org.apache.http.client.CookieStore;

public class ReqData
{
  public static final int K_DEFAULT_TIMEOUT = 500000;
  public String mCmd;
  public CookieStore mCookieStore = null;
  public Handler mHandler;
  public int mHandlerMsgWhat;
  public boolean mHasMsgSent = false;
  public boolean mNeedCache = false;
  public Object mObj;
  public HashMap<String, Object> mParams = new HashMap();
  public CommandCenter.CommandCenterListener mRequestListener;
  public int mRetryIntervals = 0;
  public int mRetryTimes = 1;
  public int mSubSystem;
  public String mTag;
  public int mTimeout = 500000;
  
  public ReqData() {}
  
  public ReqData(String paramString, int paramInt1, Handler paramHandler, int paramInt2)
  {
    this.mCmd = paramString;
    this.mSubSystem = paramInt1;
    this.mHandler = paramHandler;
    this.mHandlerMsgWhat = paramInt2;
    if (paramHandler != null) {
      this.mTag = paramHandler.getClass().getName();
    }
  }
  
  public ReqData(String paramString, int paramInt1, Handler paramHandler, int paramInt2, int paramInt3)
  {
    this.mCmd = paramString;
    this.mSubSystem = paramInt1;
    this.mHandler = paramHandler;
    this.mHandlerMsgWhat = paramInt2;
    this.mTimeout = paramInt3;
    if (paramHandler != null) {
      this.mTag = paramHandler.getClass().getName();
    }
  }
  
  public Object getObj()
  {
    return this.mObj;
  }
  
  public void setObj(Object paramObject)
  {
    this.mObj = paramObject;
  }
  
  public String toString()
  {
    return "req_" + this.mSubSystem + this.mCmd + "_" + this.mTag;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/ReqData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */