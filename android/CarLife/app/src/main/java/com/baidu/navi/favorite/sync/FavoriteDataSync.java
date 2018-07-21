package com.baidu.navi.favorite.sync;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.util.w;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.NetworkUtils;

public class FavoriteDataSync
{
  public static final int SYNC_FAIL = 1;
  public static final int SYNC_NETWORK_FAIL = 2;
  public static final int SYNC_SUCCESS = 0;
  public static final String TAG = FavoriteDataSync.class.getSimpleName();
  private static FavoriteDataSync mInstance;
  private Handler mSyncHandler = new SyncHandle(Looper.getMainLooper());
  private FavoriteSyncManager mSyncManager = FavoriteSyncManager.getInstance();
  
  public static FavoriteDataSync getInstance()
  {
    if (mInstance == null) {
      mInstance = new FavoriteDataSync();
    }
    return mInstance;
  }
  
  private void startSync()
  {
    this.mSyncManager.startSync();
  }
  
  private void stopSync()
  {
    this.mSyncManager.stopSync();
  }
  
  public boolean isSyncing()
  {
    return this.mSyncManager.isSyncing();
  }
  
  public boolean manualSync()
  {
    if (!NaviAccountUtils.getInstance().isLogin())
    {
      w.a(2131297167);
      return false;
    }
    if (!NetworkUtils.isNetworkAvailable(a.a()))
    {
      w.a(2131296918);
      return false;
    }
    if ((FavoritePois.getPoiInstance().isBackGetFavInfoTaskIsRun()) || (isSyncing()))
    {
      w.a(2131296859);
      return false;
    }
    if (this.mSyncManager == null)
    {
      w.a(2131297162);
      return false;
    }
    this.mSyncManager.setHandler(this.mSyncHandler);
    e.a().a(a.a().getString(2131296859), new b()new d
    {
      public void onClick()
      {
        FavoriteDataSync.this.stopSync();
      }
    }, new d()
    {
      public void onCancel()
      {
        FavoriteDataSync.this.stopSync();
      }
    });
    new Thread(new Runnable()
    {
      public void run()
      {
        if (FavoriteDataSync.this.mSyncManager != null) {
          FavoriteDataSync.this.mSyncManager.startSync();
        }
      }
    }).start();
    return true;
  }
  
  private class SyncHandle
    extends Handler
  {
    public SyncHandle(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      e.a().c();
      k.b(720);
      switch (paramMessage.what)
      {
      default: 
        w.a(2131297162);
        return;
      case 0: 
        w.a(2131297168);
        return;
      case 1: 
        w.a(2131297162);
        return;
      }
      w.a(2131297163);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/sync/FavoriteDataSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */