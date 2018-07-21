package com.baidu.navisdk.model.modelfactory;

import java.util.ArrayList;

public class OfflineDataMergeMsgModel
{
  private static OfflineDataMergeMsgModel mInstance = null;
  private boolean mIsMergeNeedCache = true;
  public ArrayList<MergeMessage> mMergerMessageCache = new ArrayList();
  private Object mMutex = new Object();
  
  public static OfflineDataMergeMsgModel getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new OfflineDataMergeMsgModel();
      }
      return mInstance;
    }
    finally {}
  }
  
  public boolean getIsMergeNeedCache()
  {
    synchronized (this.mMutex)
    {
      boolean bool = this.mIsMergeNeedCache;
      return bool;
    }
  }
  
  public void setIsMergeNeedCache(boolean paramBoolean)
  {
    synchronized (this.mMutex)
    {
      this.mIsMergeNeedCache = paramBoolean;
      return;
    }
  }
  
  public static class MergeMessage
  {
    public int mMessageType;
    public int mProviceId;
    
    public MergeMessage(int paramInt1, int paramInt2)
    {
      this.mProviceId = paramInt1;
      this.mMessageType = paramInt2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/OfflineDataMergeMsgModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */