package com.baidu.navi.track.database;

import android.util.SparseArray;

public class DataCache {
    private static DataCache mInstance;
    private int index = 0;
    private SparseArray<Object> mCacheArray = new SparseArray();

    private DataCache() {
    }

    public static DataCache getInstance() {
        if (mInstance == null) {
            mInstance = new DataCache();
        }
        return mInstance;
    }

    public void clearAllCache() {
        if (this.mCacheArray != null) {
            this.mCacheArray.clear();
        }
    }

    public int addCache(Object data) {
        if (this.mCacheArray == null) {
            return -1;
        }
        int key = this.index;
        this.index = key + 1;
        this.mCacheArray.put(key, data);
        return key;
    }

    public void removeCache(int key) {
        if (this.mCacheArray != null) {
            this.mCacheArray.remove(key);
        }
    }

    public Object getCache(int key) {
        if (this.mCacheArray == null) {
            return null;
        }
        return this.mCacheArray.get(key);
    }
}
