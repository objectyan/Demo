package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AudioFilePipeLine */
/* renamed from: com.baidu.carlife.core.audio.e */
public class AudioFilePipeLine {
    /* renamed from: a */
    private static final String Tag = "AudioFilePipeLine";
    /* renamed from: c */
    private static final int f3033c = 10;
    /* renamed from: b */
    private LinkedBlockingQueue<String> mBlockingQueue;

    private static AudioFilePipeLine sAudioFilePipeLine = null;

    private AudioFilePipeLine() {
        this.mBlockingQueue = new LinkedBlockingQueue(10);
    }

    /* renamed from: a */
    public static AudioFilePipeLine newInstance() {
        if (sAudioFilePipeLine == null) {
            sAudioFilePipeLine = new AudioFilePipeLine();
        }
        return sAudioFilePipeLine;
    }

    /* renamed from: b */
    public void clearQueue() {
        deleteQueueFile();
        this.mBlockingQueue.clear();
    }

    /* renamed from: e */
    private void deleteQueueFile() {
        List<String> paths = new ArrayList();
        this.mBlockingQueue.drainTo(paths);
        for (String path : paths) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: a */
    public void putPath(String path) {
        try {
            this.mBlockingQueue.put(path);
        } catch (InterruptedException e) {
            e.printStackTrace();
            LogUtil.e(Tag, "InterruptedException in put, message is " + e.getMessage());
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            LogUtil.e(Tag, "NullPointerException in put, message is " + e2.getMessage());
        }
    }

    /* renamed from: c */
    public String getFirstQueue() {
        try {
            return (String) this.mBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            LogUtil.e(Tag, "InterruptedException in take, message is " + e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public void getAllPath(List<String> paths) {
        this.mBlockingQueue.drainTo(paths);
    }

    /* renamed from: d */
    public int getQueueSize() {
        return this.mBlockingQueue.size();
    }
}
