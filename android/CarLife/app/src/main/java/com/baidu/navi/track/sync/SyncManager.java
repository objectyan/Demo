package com.baidu.navi.track.sync;

import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.e.a;
import com.baidu.navi.track.http.TrackSyncRequest;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SyncManager
{
  private static final String TAG = "SyncManager";
  private static SyncManager mInstance;
  private Handler handler;
  private boolean hasErrorRecord;
  private TrackSyncRequest mRequest;
  e.a mSyncResponseListener = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      i.b("SyncManager", "onNetWorkResponse responseCode = " + paramAnonymousInt);
      switch (paramAnonymousInt)
      {
      default: 
        SyncManager.access$002(SyncManager.this, true);
        SyncManager.this.syncFinsh();
        return;
      case -1: 
        SyncManager.access$002(SyncManager.this, true);
        SyncManager.this.sendSyncRequest();
        return;
      case -2: 
        SyncManager.access$002(SyncManager.this, true);
        SyncManager.this.stopSync();
        SyncManager.this.syncFinsh();
        return;
      case 0: 
        if (SyncManager.this.mRequest.hasGuid()) {
          SyncManager.this.addUploadSuccessGuid(SyncManager.this.mRequest.getGuid());
        }
        if (SyncManager.this.mRequest.isResponse() == 1)
        {
          SyncManager.this.setSyncResponseModel(SyncManager.this.mRequest.getResponseModel());
          SyncManager.this.syncFinsh();
          return;
        }
        SyncManager.this.sendSyncRequest();
        return;
      case 53: 
        SyncManager.this.syncFinsh();
        return;
      }
      SyncManager.access$002(SyncManager.this, true);
      SyncManager.this.stopSync();
      SyncManager.this.syncFinsh();
    }
  };
  private ArrayList<TrackSyncRequestModel> syncDataList;
  private TrackSyncResponseModel syncResponseModel;
  private ArrayList<String> uploadGuidList;
  
  public static SyncManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null)
      {
        mInstance = new SyncManager();
        mInstance.init();
      }
      return mInstance;
    }
    finally {}
  }
  
  private boolean init()
  {
    this.syncDataList = new ArrayList();
    this.uploadGuidList = new ArrayList();
    this.mRequest = new TrackSyncRequest();
    this.mRequest.registerResponseListener(this.mSyncResponseListener);
    return true;
  }
  
  private boolean isContinueSync()
  {
    return (this.syncDataList != null) && (this.syncDataList.size() > 0);
  }
  
  private void sendSyncRequest()
  {
    if ((this.syncDataList != null) && (this.syncDataList.size() > 0))
    {
      TrackSyncRequestModel localTrackSyncRequestModel = (TrackSyncRequestModel)this.syncDataList.get(0);
      this.syncDataList.remove(0);
      if (localTrackSyncRequestModel == null)
      {
        sendSyncRequest();
        return;
      }
      if (this.mRequest == null)
      {
        this.mRequest = new TrackSyncRequest();
        this.mRequest.registerResponseListener(this.mSyncResponseListener);
      }
      this.mRequest.setParamsModel(localTrackSyncRequestModel);
      this.mRequest.toPostRequest();
      return;
    }
    syncFinsh();
  }
  
  private void syncFinsh()
  {
    int i = 0;
    if (this.syncResponseModel == null)
    {
      this.syncResponseModel = new TrackSyncResponseModel();
      this.syncResponseModel.isResponse = 0;
    }
    if (this.uploadGuidList != null)
    {
      localObject = this.uploadGuidList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.syncResponseModel.guidList.add(str);
      }
      this.uploadGuidList.clear();
    }
    if (this.syncDataList != null) {
      this.syncDataList.clear();
    }
    Object localObject = new Message();
    ((Message)localObject).what = 524;
    if (this.hasErrorRecord) {
      i = 1;
    }
    ((Message)localObject).arg1 = i;
    ((Message)localObject).arg2 = 100;
    if (this.handler != null) {
      this.handler.sendMessage((Message)localObject);
    }
  }
  
  public void addUploadSuccessGuid(String paramString)
  {
    if (this.uploadGuidList != null) {
      this.uploadGuidList.add(paramString);
    }
  }
  
  public TrackSyncResponseModel getSyncData()
  {
    return this.syncResponseModel;
  }
  
  public void registerHandler(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public void releaseSyncData()
  {
    if (this.uploadGuidList != null) {
      this.uploadGuidList.clear();
    }
    this.syncResponseModel = null;
  }
  
  public boolean setSyncData(List<TrackSyncRequestModel> paramList)
  {
    if (this.syncDataList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        this.syncDataList.add(paramList.get(i));
        i += 1;
      }
    }
    return true;
  }
  
  public void setSyncResponseModel(TrackSyncResponseModel paramTrackSyncResponseModel)
  {
    this.syncResponseModel = paramTrackSyncResponseModel;
  }
  
  public void startSync()
  {
    this.hasErrorRecord = false;
    if (isContinueSync()) {
      sendSyncRequest();
    }
  }
  
  public void stopSync()
  {
    if (this.mRequest != null) {
      this.mRequest.cancel();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/sync/SyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */