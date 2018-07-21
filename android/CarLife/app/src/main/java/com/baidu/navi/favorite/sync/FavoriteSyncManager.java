package com.baidu.navi.favorite.sync;

import android.os.Handler;
import com.baidu.carlife.k.a.e.a;
import com.baidu.navi.favorite.FavoriteConfig;
import com.baidu.navi.favorite.http.FavoriteSyncRequest;
import com.baidu.navi.favorite.model.FavoriteSyncRequestModel;
import com.baidu.navi.favorite.util.FavoriteSyncUtils;

public class FavoriteSyncManager
{
  public static final String TAG = FavoriteSyncManager.class.getSimpleName();
  private static FavoriteSyncManager mInstance;
  private boolean isSyncing = false;
  private FavoriteSyncRequestModel mSyncData;
  private Handler mSyncHandler;
  private FavoriteSyncRequest mSyncRequest;
  e.a mSyncResponseListener = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      case 1: 
      default: 
        FavoriteSyncManager.access$002(FavoriteSyncManager.this, false);
        if (FavoriteSyncManager.this.mSyncHandler != null) {
          FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(1);
        }
      case 0: 
      case -1: 
      case -2: 
        do
        {
          do
          {
            do
            {
              return;
              FavoriteSyncManager.access$002(FavoriteSyncManager.this, false);
              FavoriteConfig.getInstance().setLastSyncTime(System.currentTimeMillis());
            } while (FavoriteSyncManager.this.mSyncHandler == null);
            FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(0);
            return;
            FavoriteSyncManager.access$002(FavoriteSyncManager.this, false);
          } while (FavoriteSyncManager.this.mSyncHandler == null);
          FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(1);
          return;
          FavoriteSyncManager.access$002(FavoriteSyncManager.this, false);
        } while (FavoriteSyncManager.this.mSyncHandler == null);
        FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(2);
        return;
      }
      FavoriteSyncManager.this.startSync();
    }
  };
  
  public static FavoriteSyncManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null)
      {
        mInstance = new FavoriteSyncManager();
        mInstance.init();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void init()
  {
    this.mSyncRequest = new FavoriteSyncRequest();
    this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
  }
  
  private void sendSyncRequest()
  {
    if (this.mSyncData != null)
    {
      this.isSyncing = true;
      if (this.mSyncRequest == null)
      {
        this.mSyncRequest = new FavoriteSyncRequest();
        this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
      }
      this.mSyncRequest.setParamsModel(this.mSyncData);
      this.mSyncRequest.toPostRequest();
    }
    do
    {
      return;
      this.isSyncing = false;
    } while (this.mSyncHandler == null);
    this.mSyncHandler.sendEmptyMessage(1);
  }
  
  public boolean isSyncing()
  {
    return this.isSyncing;
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.mSyncHandler = paramHandler;
  }
  
  public void startSync()
  {
    try
    {
      this.isSyncing = true;
      this.mSyncData = FavoriteSyncUtils.getSyncDataRequestParams();
      sendSyncRequest();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopSync()
  {
    try
    {
      if (this.mSyncRequest != null)
      {
        this.mSyncRequest.cancel();
        this.isSyncing = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/sync/FavoriteSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */