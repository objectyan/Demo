package com.baidu.navi.track.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.C1260i;
import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseManager {
    private static final String TAG = "DataBaseManager";
    private static Context mContext;
    private static DataBaseManager mInstance;
    private SQLiteDatabase db;
    private DataBaseHelper mHelper;
    private AtomicInteger mUseCounter = new AtomicInteger();

    private DataBaseManager(Context context) {
        this.mHelper = new DataBaseHelper(context);
        try {
            this.db = this.mHelper.getWritableDatabase();
        } catch (Exception e) {
            C1260i.b(TAG, "DataBaseHelper getWritableDatabase exception");
        }
    }

    private static synchronized DataBaseManager newInstance(Context context) {
        DataBaseManager dataBaseManager;
        synchronized (DataBaseManager.class) {
            if (mInstance == null) {
                mContext = context;
                mInstance = new DataBaseManager(context);
            }
            dataBaseManager = mInstance;
        }
        return dataBaseManager;
    }

    public static synchronized DataBaseManager getInstance() {
        DataBaseManager dataBaseManager;
        synchronized (DataBaseManager.class) {
            if (mInstance == null) {
                newInstance(BaiduNaviApplication.getInstance().getApplicationContext());
            }
            C1260i.b(TAG, "DB Version = 1");
            dataBaseManager = mInstance;
        }
        return dataBaseManager;
    }

    private synchronized SQLiteDatabase openDataBase() {
        if (this.mUseCounter.incrementAndGet() == 1) {
            this.db = this.mHelper.getWritableDatabase();
        }
        return this.db;
    }

    private synchronized void closeDataBase() {
        if (this.mUseCounter.decrementAndGet() == 0 && this.db != null && this.db.isOpen()) {
            try {
                this.db.close();
            } catch (Exception e) {
                C1260i.b(TAG, "DataBaseManager db.close exception");
            }
        }
    }

    public void executeQurey(QueryExecutor executor) {
        executor.run(openDataBase());
        closeDataBase();
    }
}
