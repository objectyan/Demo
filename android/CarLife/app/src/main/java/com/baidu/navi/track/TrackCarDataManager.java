package com.baidu.navi.track;

import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.datashop.TrackShopEvent;
import java.util.ArrayList;
import java.util.List;

public class TrackCarDataManager {
    private static final String TAG = TrackCarDataManager.class.getSimpleName();
    private static TrackCarDataManager mInstance;
    private List<OnTrackShopListener> listenerList;
    private MyHandler mHandler;

    private class MyHandler extends Handler {
        private MyHandler() {
        }

        public void handleMessage(Message msg) {
            C1260i.b(TrackCarDataManager.TAG, msg.toString());
        }
    }

    public interface OnTrackShopListener {
        void callBack(TrackShopEvent trackShopEvent);
    }

    private TrackCarDataManager() {
        this.listenerList = new ArrayList();
        this.mHandler = new MyHandler();
        this.listenerList = new ArrayList();
    }

    public static TrackCarDataManager getInstance() {
        if (mInstance == null) {
            mInstance = new TrackCarDataManager();
        }
        return mInstance;
    }

    public void addRecord(Object item, boolean isSync) {
        TrackDataShop.getInstance().addRecord(item, isSync);
    }

    public void fetchTrackList(String bduid, int ctime, TrackQueryType type) {
        TrackDataShop.getInstance().fetchTrackList(this.mHandler, bduid, ctime, type);
    }

    public void fetchStatistics(int monthLimint) {
        TrackDataShop.getInstance().fetchStatistics(this.mHandler, monthLimint);
    }

    public void deleteRecord(Object trackItem) {
        TrackDataShop.getInstance().deleteRecord(this.mHandler, trackItem);
    }

    public void clearTrackReacords(String useId) {
        TrackDataShop.getInstance().clearTrackReacords(useId);
    }

    private void notifyTrackShop(TrackShopEvent event) {
        synchronized (this.listenerList) {
            if (this.listenerList != null) {
                for (OnTrackShopListener listener : this.listenerList) {
                    listener.callBack(event);
                }
            }
        }
    }

    public void registerListener(OnTrackShopListener listener) {
        synchronized (this.listenerList) {
            if (!(this.listenerList == null || listener == null)) {
                this.listenerList.add(listener);
            }
        }
    }

    public void unRegisterListener(OnTrackShopListener listener) {
        synchronized (this.listenerList) {
            if (!(this.listenerList == null || listener == null)) {
                this.listenerList.remove(listener);
            }
        }
    }
}
