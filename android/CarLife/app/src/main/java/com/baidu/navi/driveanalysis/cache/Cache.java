package com.baidu.navi.driveanalysis.cache;

import com.baidu.navi.driveanalysis.model.TrackModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cache {
    private final int MAX_QUEUE_SIZE = 200;
    private INotify mNotify;
    private Queue<TrackModel> mQueue = new LinkedBlockingQueue();

    public void initNotify(INotify notify) {
        this.mNotify = notify;
    }

    public synchronized int getSize() {
        return this.mQueue.size();
    }

    public synchronized void insert(TrackModel model) {
        if (this.mQueue.size() == 200) {
            this.mQueue.remove();
        }
        this.mQueue.add(model);
        if (this.mQueue.size() >= 4 && this.mNotify != null) {
            this.mNotify.dataChangeNotify();
        }
    }

    public synchronized List<TrackModel> take(int num) {
        List<TrackModel> list;
        list = new LinkedList();
        for (int i = 0; i < num; i++) {
            list.add(this.mQueue.poll());
        }
        return list;
    }

    public synchronized List<TrackModel> takeAll() {
        List<TrackModel> list;
        list = new LinkedList();
        int queueSize = this.mQueue.size();
        for (int i = 0; i < queueSize; i++) {
            list.add(this.mQueue.poll());
        }
        return list;
    }
}
