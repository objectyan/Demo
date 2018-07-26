package com.baidu.navi.track.sync;

import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.navi.track.http.TrackSyncRequest;
import com.baidu.navi.track.model.TrackSyncRequestModel;
import com.baidu.navi.track.model.TrackSyncResponseModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SyncManager {
    private static final String TAG = "SyncManager";
    private static SyncManager mInstance;
    private Handler handler;
    private boolean hasErrorRecord;
    private TrackSyncRequest mRequest;
    C0924a mSyncResponseListener = new C39731();
    private ArrayList<TrackSyncRequestModel> syncDataList;
    private TrackSyncResponseModel syncResponseModel;
    private ArrayList<String> uploadGuidList;

    /* renamed from: com.baidu.navi.track.sync.SyncManager$1 */
    class C39731 implements C0924a {
        C39731() {
        }

        public void onNetWorkResponse(int responseCode) {
            C1260i.b(SyncManager.TAG, "onNetWorkResponse responseCode = " + responseCode);
            switch (responseCode) {
                case -2:
                    SyncManager.this.hasErrorRecord = true;
                    SyncManager.this.stopSync();
                    SyncManager.this.syncFinsh();
                    return;
                case -1:
                    SyncManager.this.hasErrorRecord = true;
                    SyncManager.this.sendSyncRequest();
                    return;
                case 0:
                    if (SyncManager.this.mRequest.hasGuid()) {
                        SyncManager.this.addUploadSuccessGuid(SyncManager.this.mRequest.getGuid());
                    }
                    if (SyncManager.this.mRequest.isResponse() == 1) {
                        SyncManager.this.setSyncResponseModel(SyncManager.this.mRequest.getResponseModel());
                        SyncManager.this.syncFinsh();
                        return;
                    }
                    SyncManager.this.sendSyncRequest();
                    return;
                case 51:
                    SyncManager.this.hasErrorRecord = true;
                    SyncManager.this.stopSync();
                    SyncManager.this.syncFinsh();
                    return;
                case 53:
                    SyncManager.this.syncFinsh();
                    return;
                default:
                    SyncManager.this.hasErrorRecord = true;
                    SyncManager.this.syncFinsh();
                    return;
            }
        }
    }

    private SyncManager() {
    }

    private boolean init() {
        this.syncDataList = new ArrayList();
        this.uploadGuidList = new ArrayList();
        this.mRequest = new TrackSyncRequest();
        this.mRequest.registerResponseListener(this.mSyncResponseListener);
        return true;
    }

    public static SyncManager getInstance() {
        if (mInstance == null) {
            synchronized (SyncManager.class) {
                if (mInstance == null) {
                    mInstance = new SyncManager();
                    mInstance.init();
                }
            }
        }
        return mInstance;
    }

    public boolean setSyncData(List<TrackSyncRequestModel> data) {
        if (this.syncDataList != null) {
            for (int i = 0; i < data.size(); i++) {
                this.syncDataList.add(data.get(i));
            }
        }
        return true;
    }

    public void registerHandler(Handler handler) {
        this.handler = handler;
    }

    public void startSync() {
        this.hasErrorRecord = false;
        if (isContinueSync()) {
            sendSyncRequest();
        }
    }

    public void stopSync() {
        if (this.mRequest != null) {
            this.mRequest.cancel();
        }
    }

    private void sendSyncRequest() {
        if (this.syncDataList == null || this.syncDataList.size() <= 0) {
            syncFinsh();
            return;
        }
        TrackSyncRequestModel dataItem = (TrackSyncRequestModel) this.syncDataList.get(0);
        this.syncDataList.remove(0);
        if (dataItem == null) {
            sendSyncRequest();
            return;
        }
        if (this.mRequest == null) {
            this.mRequest = new TrackSyncRequest();
            this.mRequest.registerResponseListener(this.mSyncResponseListener);
        }
        this.mRequest.setParamsModel(dataItem);
        this.mRequest.toPostRequest();
    }

    private void syncFinsh() {
        int i = 0;
        if (this.syncResponseModel == null) {
            this.syncResponseModel = new TrackSyncResponseModel();
            this.syncResponseModel.isResponse = 0;
        }
        if (this.uploadGuidList != null) {
            Iterator it = this.uploadGuidList.iterator();
            while (it.hasNext()) {
                this.syncResponseModel.guidList.add((String) it.next());
            }
            this.uploadGuidList.clear();
        }
        if (this.syncDataList != null) {
            this.syncDataList.clear();
        }
        Message msg = new Message();
        msg.what = SyncChannelConstant.MSG_SYNC_DATA;
        if (this.hasErrorRecord) {
            i = 1;
        }
        msg.arg1 = i;
        msg.arg2 = 100;
        if (this.handler != null) {
            this.handler.sendMessage(msg);
        }
    }

    private boolean isContinueSync() {
        if (this.syncDataList == null || this.syncDataList.size() <= 0) {
            return false;
        }
        return true;
    }

    public void addUploadSuccessGuid(String guid) {
        if (this.uploadGuidList != null) {
            this.uploadGuidList.add(guid);
        }
    }

    public void setSyncResponseModel(TrackSyncResponseModel model) {
        this.syncResponseModel = model;
    }

    public void releaseSyncData() {
        if (this.uploadGuidList != null) {
            this.uploadGuidList.clear();
        }
        this.syncResponseModel = null;
    }

    public TrackSyncResponseModel getSyncData() {
        return this.syncResponseModel;
    }
}
