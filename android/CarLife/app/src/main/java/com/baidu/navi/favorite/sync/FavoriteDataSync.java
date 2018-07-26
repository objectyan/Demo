package com.baidu.navi.favorite.sync;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.NetworkUtils;

public class FavoriteDataSync {
    public static final int SYNC_FAIL = 1;
    public static final int SYNC_NETWORK_FAIL = 2;
    public static final int SYNC_SUCCESS = 0;
    public static final String TAG = FavoriteDataSync.class.getSimpleName();
    private static FavoriteDataSync mInstance;
    private Handler mSyncHandler = new SyncHandle(Looper.getMainLooper());
    private FavoriteSyncManager mSyncManager = FavoriteSyncManager.getInstance();

    /* renamed from: com.baidu.navi.favorite.sync.FavoriteDataSync$1 */
    class C37801 implements C0672b {
        C37801() {
        }

        public void onClick() {
            FavoriteDataSync.this.stopSync();
        }
    }

    /* renamed from: com.baidu.navi.favorite.sync.FavoriteDataSync$2 */
    class C37812 implements C0690d {
        C37812() {
        }

        public void onCancel() {
            FavoriteDataSync.this.stopSync();
        }
    }

    /* renamed from: com.baidu.navi.favorite.sync.FavoriteDataSync$3 */
    class C37823 implements Runnable {
        C37823() {
        }

        public void run() {
            if (FavoriteDataSync.this.mSyncManager != null) {
                FavoriteDataSync.this.mSyncManager.startSync();
            }
        }
    }

    private class SyncHandle extends Handler {
        public SyncHandle(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            C1307e.a().c();
            C1261k.b(C1253f.eK);
            switch (msg.what) {
                case 0:
                    C2201w.a(C0965R.string.sync_succes);
                    return;
                case 1:
                    C2201w.a(C0965R.string.sync_fail);
                    return;
                case 2:
                    C2201w.a(C0965R.string.sync_fail_net);
                    return;
                default:
                    C2201w.a(C0965R.string.sync_fail);
                    return;
            }
        }
    }

    public static FavoriteDataSync getInstance() {
        if (mInstance == null) {
            mInstance = new FavoriteDataSync();
        }
        return mInstance;
    }

    private FavoriteDataSync() {
    }

    public boolean isSyncing() {
        return this.mSyncManager.isSyncing();
    }

    private void startSync() {
        this.mSyncManager.startSync();
    }

    private void stopSync() {
        this.mSyncManager.stopSync();
    }

    public boolean manualSync() {
        if (!NaviAccountUtils.getInstance().isLogin()) {
            C2201w.a(C0965R.string.sync_login);
            return false;
        } else if (!NetworkUtils.isNetworkAvailable(C1157a.a())) {
            C2201w.a(C0965R.string.route_record_sync_failed_prompt);
            return false;
        } else if (FavoritePois.getPoiInstance().isBackGetFavInfoTaskIsRun() || isSyncing()) {
            C2201w.a(C0965R.string.progress_loading);
            return false;
        } else if (this.mSyncManager == null) {
            C2201w.a(C0965R.string.sync_fail);
            return false;
        } else {
            this.mSyncManager.setHandler(this.mSyncHandler);
            C1307e.a().a(C1157a.a().getString(C0965R.string.progress_loading), new C37801(), new C37812());
            new Thread(new C37823()).start();
            return true;
        }
    }
}
