package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.p225m.C5145h;

public interface TtsListener {
    void onError(C5145h c5145h);

    void onPlayFinished(C5145h c5145h);

    void onPlayProgressUpdate(C5145h c5145h);

    void onPlayStart(C5145h c5145h);

    void onSynthesizeDataArrived(C5145h c5145h);

    void onSynthesizeFinished(C5145h c5145h);

    void onSynthesizeStart(C5145h c5145h);
}
