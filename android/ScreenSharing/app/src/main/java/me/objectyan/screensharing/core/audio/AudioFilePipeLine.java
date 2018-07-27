package me.objectyan.screensharing.core.audio;

import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;


public class AudioFilePipeLine {

    private static final String Tag = "AudioFilePipeLine";

    private static final int f3033c = 10;

    private LinkedBlockingQueue<String> mBlockingQueue;

    private static AudioFilePipeLine sAudioFilePipeLine = null;

    private AudioFilePipeLine() {
        this.mBlockingQueue = new LinkedBlockingQueue(10);
    }


    public static AudioFilePipeLine newInstance() {
        if (sAudioFilePipeLine == null) {
            sAudioFilePipeLine = new AudioFilePipeLine();
        }
        return sAudioFilePipeLine;
    }


    public void clearQueue() {
        deleteQueueFile();
        this.mBlockingQueue.clear();
    }


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


    public void putPath(String path) {
        try {
            this.mBlockingQueue.put(path);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(Tag, "InterruptedException in put, message is " + e.getMessage());
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            Log.e(Tag, "NullPointerException in put, message is " + e2.getMessage());
        }
    }


    public String getFirstQueue() {
        try {
            return (String) this.mBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(Tag, "InterruptedException in take, message is " + e.getMessage());
            return "";
        }
    }


    public void getAllPath(List<String> paths) {
        this.mBlockingQueue.drainTo(paths);
    }


    public int getQueueSize() {
        return this.mBlockingQueue.size();
    }
}
