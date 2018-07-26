package com.baidu.navisdk.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.db.OperatorDBCallback.CalcRouteHistoryCallback;
import com.baidu.navisdk.db.OperatorDBCallback.CurRoutePoiDBCallback;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

public class DBManager {
    private static final int MSG_ADD_CUSTOM_ROUTE = 50;
    private static final int MSG_ADD_FAVORITE_DEST_POINT = 66;
    private static final int MSG_ADD_HISTORY_DEST_POINT = 2;
    private static final int MSG_ADD_HISTORY_ROUTE = 18;
    private static final int MSG_ADD_LAST_NAVI_ROUTE_POINTS = 34;
    private static final int MSG_CLEAR_CUSTOM_ROUTES = 52;
    private static final int MSG_CLEAR_FAVORITE_DEST_POINTS = 68;
    private static final int MSG_CLEAR_HISTORY_DEST_POINTS = 4;
    private static final int MSG_CLEAR_HISTORY_ROUTES = 20;
    private static final int MSG_CLEAR_LAST_NAVI_ROUTE_POINTS = 36;
    private static final int MSG_DELETE_CUSTOM_ROUTE = 51;
    private static final int MSG_DELETE_FAVORITE_DEST_POINT = 67;
    private static final int MSG_DELETE_HISTORY_DEST_POINT = 3;
    private static final int MSG_DELETE_HISTORY_ROUTE = 19;
    private static final int MSG_DELETE_LAST_NAVI_VIA_POINT = 35;
    private static final int MSG_GET_CUSTOM_ROUTES = 49;
    private static final int MSG_GET_FAVORITE_DEST_POINTS = 65;
    private static final int MSG_GET_HISTORY_DEST_POINTS = 1;
    private static final int MSG_GET_HISTORY_ROUTES = 17;
    private static final int MSG_GET_LAST_NAVI_ROUTE_POINTS = 33;
    private static final Object MUTEX = new Object();
    private static SQLiteDatabase mBb = null;
    private static CalcRouteHistoryCallback mCalcRouteHistoryCallback = new DBManager$2();
    private static CurRoutePoiDBCallback mCurRoutePoiDBcallback = new DBManager$3();
    private static DBHelper mDBHelper = null;
    private static Handler mHandler = null;
    private static HandlerThread mHandlerThread = null;
    private static Looper mLooper = null;
    private static int mOpenCount = 0;

    private DBManager() {
    }

    public static void init(Context context) {
        if (mDBHelper == null) {
            mDBHelper = new DBHelper(context);
            BNRoutePlaner.getInstance().setCalcRouteHistoryCallback(mCalcRouteHistoryCallback);
            BNavigator.getInstance().setCurRoutePoiDBCallback(mCurRoutePoiDBcallback);
            try {
                mHandlerThread = new HandlerThread("DBManager");
                mHandlerThread.start();
                mLooper = mHandlerThread.getLooper();
                mHandler = new DBManager$1(mLooper);
            } catch (Throwable th) {
                LogUtil.e("DBManager", "init: LogUtil -->> Failed to init db!");
            }
        }
    }

    public static void destroy() {
        if (mBb != null) {
            mBb.close();
            mBb = null;
        }
        mDBHelper = null;
        if (mLooper != null) {
            mLooper.quit();
        }
        if (mHandlerThread != null) {
            mHandlerThread.quit();
        }
    }

    public static boolean openDB() {
        try {
            synchronized (MUTEX) {
                if (mBb == null && mDBHelper != null) {
                    mBb = mDBHelper.getWritableDatabase();
                }
                mOpenCount++;
            }
            return true;
        } catch (SQLiteException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static SQLiteDatabase getDB() {
        return mBb;
    }

    public static void closeDB() {
        synchronized (MUTEX) {
            mOpenCount--;
            if (mOpenCount <= 0) {
                mOpenCount = 0;
                if (mBb != null) {
                    mBb.close();
                    mBb = null;
                }
            }
        }
    }

    public static void getLastNaviPointsFromDB(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 33;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }

    public static void addLastNaviPointsToDB(ArrayList<RoutePlanNode> nodes) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 34;
            msg.obj = nodes;
            mHandler.sendMessage(msg);
        }
    }

    public static void clearLastnaviPoints() {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 36;
            mHandler.sendMessage(msg);
        }
    }

    public static void removeLastNaviViaPointFromDB(RoutePlanNode viaNode) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 35;
            msg.obj = viaNode;
            mHandler.sendMessage(msg);
        }
    }

    public static void getAllHistoryDestPoints(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 1;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }

    public static void addHistoryDestPointToDB(RoutePlanNode node) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 2;
            msg.obj = node;
            mHandler.sendMessage(msg);
        }
    }

    public static void deleteHistoryDestFromDB(RoutePlanNode node, DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 3;
            DBManager$DBOperateParams params = new DBManager$DBOperateParams(null);
            params.node = node;
            params.callback = callback;
            msg.obj = params;
            mHandler.sendMessage(msg);
        }
    }

    public static void clearHistoryDestFromDB(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 4;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }

    public static void getAllHistoryRoutes(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 17;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }

    public static void addHistoryRouteToDB(ArrayList<RoutePlanNode> nodesList) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 18;
            msg.obj = nodesList;
            mHandler.sendMessage(msg);
        }
    }

    public static void deleteHistoryRouteFromDB(int position, DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 19;
            DBManager$DBOperateParams params = new DBManager$DBOperateParams(null);
            params.position = position;
            params.callback = callback;
            msg.obj = params;
            mHandler.sendMessage(msg);
        }
    }

    public static void clearAllHistoryRoutesFromDB(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 20;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }

    public static void getAllFavoriteDestPoints(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 65;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }

    public static void addFavoriteDestPointToDB(RoutePlanNode node) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 66;
            msg.obj = node;
            mHandler.sendMessage(msg);
        }
    }

    public static void deleteFavoriteDestFromDB(RoutePlanNode node, DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 67;
            DBManager$DBOperateParams params = new DBManager$DBOperateParams(null);
            params.node = node;
            params.callback = callback;
            msg.obj = params;
            mHandler.sendMessage(msg);
        }
    }

    public static void clearFavoriteDestFromDB(DBManager$DBOperateResultCallback callback) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 68;
            msg.obj = callback;
            mHandler.sendMessage(msg);
        }
    }
}
