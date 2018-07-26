package com.baidu.navisdk.model.modelfactory;

import java.util.ArrayList;

public class OfflineDataMergeMsgModel {
    private static OfflineDataMergeMsgModel mInstance = null;
    private boolean mIsMergeNeedCache = true;
    public ArrayList<MergeMessage> mMergerMessageCache = new ArrayList();
    private Object mMutex = new Object();

    public static class MergeMessage {
        public int mMessageType;
        public int mProviceId;

        public MergeMessage(int mProviceId, int mMessageType) {
            this.mProviceId = mProviceId;
            this.mMessageType = mMessageType;
        }
    }

    public static OfflineDataMergeMsgModel getInstance() {
        if (mInstance == null) {
            synchronized (OfflineDataMergeMsgModel.class) {
                if (mInstance == null) {
                    mInstance = new OfflineDataMergeMsgModel();
                }
            }
        }
        return mInstance;
    }

    public boolean getIsMergeNeedCache() {
        boolean z;
        synchronized (this.mMutex) {
            z = this.mIsMergeNeedCache;
        }
        return z;
    }

    public void setIsMergeNeedCache(boolean mIsMergeNeedCache) {
        synchronized (this.mMutex) {
            this.mIsMergeNeedCache = mIsMergeNeedCache;
        }
    }
}
