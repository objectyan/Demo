package com.baidu.navi.favorite.database;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AppFavorite {
    private FavoriteDao mFavoriteDao = null;
    private AtomicInteger mUseCounter = new AtomicInteger();

    public void create() {
        if (this.mUseCounter.incrementAndGet() == 1) {
            this.mFavoriteDao = new FavoriteDao(FavoriteDataBaseManager.getInstance().openDataBase());
        }
    }

    public void destory() {
        if (this.mUseCounter.decrementAndGet() == 0) {
            FavoriteDataBaseManager.getInstance().closeDataBase();
            this.mFavoriteDao = null;
        }
    }

    public boolean add(String key, String value) {
        return this.mFavoriteDao.add(key, value);
    }

    public boolean addAll(Map<String, String> map) {
        return this.mFavoriteDao.addAll(map);
    }

    public boolean remove(String key) {
        return this.mFavoriteDao.remove(key);
    }

    public boolean removeAll(List<String> keys) {
        return this.mFavoriteDao.removeAll(keys);
    }

    public boolean update(String key, String value) {
        return this.mFavoriteDao.update(key, value);
    }

    public boolean updateAll(Map<String, String> map) {
        return this.mFavoriteDao.updateAll(map);
    }

    public String getValue(String key) {
        return this.mFavoriteDao.getValue(key);
    }

    public List<String> getAllKey() {
        return this.mFavoriteDao.getAllKey();
    }

    public boolean isExist(String key) {
        return this.mFavoriteDao.isExist(key);
    }

    public boolean clear() {
        return this.mFavoriteDao.clear();
    }
}
