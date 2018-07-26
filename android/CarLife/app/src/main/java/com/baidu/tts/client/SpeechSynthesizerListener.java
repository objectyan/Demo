package com.baidu.tts.client;

public interface SpeechSynthesizerListener {
    void onError(String str, SpeechError speechError);

    void onSpeechFinish(String str);

    void onSpeechProgressChanged(String str, int i);

    void onSpeechStart(String str);

    void onSynthesizeDataArrived(String str, byte[] bArr, int i);

    void onSynthesizeFinish(String str);

    void onSynthesizeStart(String str);
}
