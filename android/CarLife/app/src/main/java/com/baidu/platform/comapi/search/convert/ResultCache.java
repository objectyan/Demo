package com.baidu.platform.comapi.search.convert;

import java.util.HashMap;
import java.util.Map;

public class ResultCache {
    private final Map<String, ResultCache$Item> internalCache;

    private static class SingleInstanceHolder {
        private static final ResultCache RESULT_CACHE = new ResultCache();

        private SingleInstanceHolder() {
        }
    }

    public static ResultCache getInstance() {
        return SingleInstanceHolder.RESULT_CACHE;
    }

    public void add(ResultCache$Item item) {
        if (item != null && item.messageLite != null) {
            synchronized (this.internalCache) {
                this.internalCache.put(item.messageLite.getClass().getCanonicalName(), item);
            }
        }
    }

    public ResultCache$Item get(String key) {
        if (key == null) {
            return null;
        }
        ResultCache$Item resultCache$Item;
        synchronized (this.internalCache) {
            resultCache$Item = (ResultCache$Item) this.internalCache.get(key);
        }
        return resultCache$Item;
    }

    public ResultCache$Item get(Class clazz) {
        if (clazz == null) {
            return null;
        }
        ResultCache$Item resultCache$Item;
        synchronized (this.internalCache) {
            resultCache$Item = (ResultCache$Item) this.internalCache.get(clazz.getCanonicalName());
        }
        return resultCache$Item;
    }

    private ResultCache() {
        this.internalCache = new HashMap();
    }
}
