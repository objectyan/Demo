package com.baidu.navi.favorite.sync;

import android.os.Handler;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.navi.favorite.FavoriteConfig;
import com.baidu.navi.favorite.http.FavoriteSyncRequest;
import com.baidu.navi.favorite.model.FavoriteSyncRequestModel;
import com.baidu.navi.favorite.util.FavoriteSyncUtils;

public class FavoriteSyncManager {
    public static final String TAG = FavoriteSyncManager.class.getSimpleName();
    private static FavoriteSyncManager mInstance;
    private boolean isSyncing = false;
    private FavoriteSyncRequestModel mSyncData;
    private Handler mSyncHandler;
    private FavoriteSyncRequest mSyncRequest;
    C0924a mSyncResponseListener = new C37831();

    /* renamed from: com.baidu.navi.favorite.sync.FavoriteSyncManager$1 */
    class C37831 implements C0924a {
        C37831() {
        }

        public void onNetWorkResponse(int responseCode) {
            switch (responseCode) {
                case -2:
                    FavoriteSyncManager.this.isSyncing = false;
                    if (FavoriteSyncManager.this.mSyncHandler != null) {
                        FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                case -1:
                    FavoriteSyncManager.this.isSyncing = false;
                    if (FavoriteSyncManager.this.mSyncHandler != null) {
                        FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(1);
                        return;
                    }
                    return;
                case 0:
                    FavoriteSyncManager.this.isSyncing = false;
                    FavoriteConfig.getInstance().setLastSyncTime(System.currentTimeMillis());
                    if (FavoriteSyncManager.this.mSyncHandler != null) {
                        FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(0);
                        return;
                    }
                    return;
                case 2:
                    FavoriteSyncManager.this.startSync();
                    return;
                default:
                    FavoriteSyncManager.this.isSyncing = false;
                    if (FavoriteSyncManager.this.mSyncHandler != null) {
                        FavoriteSyncManager.this.mSyncHandler.sendEmptyMessage(1);
                        return;
                    }
                    return;
            }
        }
    }

    private FavoriteSyncManager() {
    }

    public static FavoriteSyncManager getInstance() {
        if (mInstance == null) {
            synchronized (FavoriteSyncManager.class) {
                if (mInstance == null) {
                    mInstance = new FavoriteSyncManager();
                    mInstance.init();
                }
            }
        }
        return mInstance;
    }

    private void init() {
        this.mSyncRequest = new FavoriteSyncRequest();
        this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
    }

    public boolean isSyncing() {
        return this.isSyncing;
    }

    public void setHandler(Handler handler) {
        this.mSyncHandler = handler;
    }

    public synchronized void startSync() {
        this.isSyncing = true;
        this.mSyncData = FavoriteSyncUtils.getSyncDataRequestParams();
        sendSyncRequest();
    }

    public synchronized void stopSync() {
        if (this.mSyncRequest != null) {
            this.mSyncRequest.cancel();
            this.isSyncing = false;
        }
    }

    private void sendSyncRequest() {
        if (this.mSyncData != null) {
            this.isSyncing = true;
            if (this.mSyncRequest == null) {
                this.mSyncRequest = new FavoriteSyncRequest();
                this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
            }
            this.mSyncRequest.setParamsModel(this.mSyncData);
            this.mSyncRequest.toPostRequest();
            return;
        }
        this.isSyncing = false;
        if (this.mSyncHandler != null) {
            this.mSyncHandler.sendEmptyMessage(1);
        }
    }
}
