package com.baidu.navi.favorite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import java.util.concurrent.atomic.AtomicInteger;

public class FavoriteDataBaseManager {
    public static final String TAG = FavoriteDataBaseManager.class.getSimpleName();
    private static FavoriteDataBaseManager mInstance;
    private SQLiteDatabase db;
    private FavoriteDataBaseHelper mHelper;
    private AtomicInteger mUseCounter = new AtomicInteger();

    private FavoriteDataBaseManager(Context context) {
        this.mHelper = new FavoriteDataBaseHelper(context);
        try {
            this.db = this.mHelper.getWritableDatabase();
        } catch (Exception e) {
            C1260i.b(TAG, "FavoriteDataBaseHelper getWritableDatabase exception");
        }
    }

    private static synchronized FavoriteDataBaseManager newInstance(Context context) {
        FavoriteDataBaseManager favoriteDataBaseManager;
        synchronized (FavoriteDataBaseManager.class) {
            if (mInstance == null) {
                mInstance = new FavoriteDataBaseManager(context);
            }
            favoriteDataBaseManager = mInstance;
        }
        return favoriteDataBaseManager;
    }

    public static synchronized FavoriteDataBaseManager getInstance() {
        FavoriteDataBaseManager favoriteDataBaseManager;
        synchronized (FavoriteDataBaseManager.class) {
            if (mInstance == null) {
                newInstance(C1157a.a());
            }
            C1260i.b(TAG, "DB Version = 1");
            favoriteDataBaseManager = mInstance;
        }
        return favoriteDataBaseManager;
    }

    public synchronized SQLiteDatabase openDataBase() {
        if (this.mUseCounter.incrementAndGet() == 1) {
            this.db = this.mHelper.getWritableDatabase();
        }
        return this.db;
    }

    public synchronized void closeDataBase() {
        if (this.mUseCounter.decrementAndGet() == 0 && this.db != null && this.db.isOpen()) {
            try {
                this.db.close();
            } catch (Exception e) {
                C1260i.b(TAG, "FavoriteDataBaseManager db.close exception");
            }
        }
    }

    public void executeQurey(FavoriteQueryExecutor executor) {
        executor.run(openDataBase());
        closeDataBase();
    }
}
