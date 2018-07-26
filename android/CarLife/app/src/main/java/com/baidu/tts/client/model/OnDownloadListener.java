package com.baidu.tts.client.model;

public interface OnDownloadListener {
    void onFinish(String str, int i);

    void onProgress(String str, long j, long j2);

    void onStart(String str);
}
